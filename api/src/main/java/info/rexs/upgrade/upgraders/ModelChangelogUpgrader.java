/*******************************************************************************
 * Copyright (C) 2020 FVA GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.  You may obtain a copy
 * of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 ******************************************************************************/
package info.rexs.upgrade.upgraders;

import java.util.ArrayList;
import java.util.List;

import info.rexs.model.jaxb.Attribute;
import info.rexs.model.jaxb.Component;
import info.rexs.model.jaxb.Model;
import info.rexs.upgrade.RexsUpgradeException;
import info.rexs.upgrade.upgraders.changelog.ChangelogFile;
import info.rexs.upgrade.upgraders.changelog.ChangelogResolver;
import info.rexs.upgrade.upgraders.changelog.jaxb.AttributeChange;
import info.rexs.upgrade.upgraders.changelog.jaxb.ChangeType;
import info.rexs.upgrade.upgraders.changelog.jaxb.ChangedValue;
import info.rexs.upgrade.upgraders.changelog.jaxb.ComponentChange;
import info.rexs.upgrade.upgraders.changelog.jaxb.MappingChange;
import info.rexs.upgrade.upgraders.changelog.jaxb.RexsChangelog;

/**
 * A {@link ModelUpgrader} who uses the REXS changelog for the upgrade.
 *
 * @author FVA GmbH
 */
public class ModelChangelogUpgrader implements ModelUpgrader {

	/** The changelog which should be applied. */
	private final ChangelogFile changelogFile;

	/**
	 * Constructs a new {@link ModelChangelogUpgrader} for the given {@link ChangelogFile}.
	 *
	 * @param changelogFile
	 * 				The changelog which should be applied.
	 */
	public ModelChangelogUpgrader(ChangelogFile changelogFile) {
		this.changelogFile = changelogFile;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void upgrade(Model rexsModel) throws RexsUpgradeException {
		beforeApplyChangelog(rexsModel);
		applyChangelog(rexsModel);
		afterApplyChangelog(rexsModel);
	}

	/**
	 * This method is executed before the changelog is applied.
	 * <p>
	 * In its standard implementation, this method does nothing. Override the method to take additional actions.
	 *
	 * @param rexsModel
	 * 				The REXS {@link Model} to upgrade.
	 *
	 * @throws RexsUpgradeException
	 * 				If an unexpected error occurs during the upgrade process.
	 */
	public void beforeApplyChangelog(Model rexsModel) throws RexsUpgradeException {}

	/**
	 * This method is executed after the changelog is applied.
	 * <p>
	 * In its standard implementation, this method does nothing. Override the method to take additional actions.
	 *
	 * @param rexsModel
	 * 				The REXS {@link Model} to upgrade.
	 *
	 * @throws RexsUpgradeException
	 * 				If an unexpected error occurs during the upgrade process.
	 */
	public void afterApplyChangelog(Model rexsModel) throws RexsUpgradeException {}

	private void applyChangelog(Model rexsModel) throws RexsUpgradeException {
		RexsChangelog changelog = ChangelogResolver.getInstance().resolve(changelogFile);
		if (changelog == null)
			throw new RexsUpgradeException(String.format("unable to find rexs changelog for %s", changelogFile));

		applyChangelog(rexsModel, changelog);
	}

	private void applyChangelog(Model rexsModel, RexsChangelog changelog) throws RexsUpgradeException {
		if (changelog.getComponentChanges() != null && changelog.getComponentChanges().getComponentChange() != null) {
			for (ComponentChange change : changelog.getComponentChanges().getComponentChange()) {
				applyComponentChange(rexsModel, change);
			}
		}

		if (changelog.getMappingChanges() != null && changelog.getMappingChanges().getMappingChange() != null) {
			for (MappingChange change : changelog.getMappingChanges().getMappingChange()) {
				applyMappingChange(rexsModel, change);
			}
		}

		if (changelog.getAttributeChanges() != null && changelog.getAttributeChanges().getAttributeChange() != null) {
			for (AttributeChange change : changelog.getAttributeChanges().getAttributeChange()) {
				applyAttributeChange(rexsModel, change);
			}
		}
	}

	private void applyComponentChange(Model rexsModel, ComponentChange change) {
		if (change.getType() == ChangeType.DELETE)
			deleteComponentsByType(rexsModel, change.getId());

		if (change.getType() == ChangeType.EDIT)
			editComponentsByType(rexsModel, change.getId(), change.getChangedValues().getChangedValue());

		// ADD is not supported by the upgrader
	}

	private void applyMappingChange(Model rexsModel, MappingChange change) {
		if (change.getType() == ChangeType.DELETE)
			deleteAttributesByComponentTypeAndAttributeId(rexsModel, change.getComponentId(), change.getAttributeId());

		// ADD is not supported by the upgrader
	}

	private void applyAttributeChange(Model rexsModel, AttributeChange change) throws RexsUpgradeException {
		if (change.getType() == ChangeType.DELETE)
			deleteAttributesByComponentTypeAndAttributeId(rexsModel, null, change.getId());

		if (change.getType() == ChangeType.EDIT)
			editAttributesById(rexsModel, change.getId(), change.getChangedValues().getChangedValue());

		// ADD is not supported by the upgrader
	}

	private void deleteComponentsByType(Model rexsModel, String componentType) {
		if (rexsModel.getComponents() == null || rexsModel.getComponents().getComponent() == null)
			return;

		List<Component> componentsToDelete = new ArrayList<>();
		for (Component component : rexsModel.getComponents().getComponent()) {
			if (component.getType() != null && component.getType().equals(componentType))
				componentsToDelete.add(component);
		}

		for (Component componentToDelete : componentsToDelete) {
			rexsModel.getComponents().getComponent().remove(componentToDelete);
		}
	}

	private void deleteAttributesByComponentTypeAndAttributeId(Model rexsModel, String componentType, String attributeId) {
		if (rexsModel.getComponents() == null || rexsModel.getComponents().getComponent() == null)
			return;

		for (Component component : rexsModel.getComponents().getComponent()) {
			if (componentType == null || (component.getType() != null && component.getType().equals(componentType))) {
				deleteAttributesById(component, attributeId);
			}
		}
	}

	private void deleteAttributesById(Component component, String attributeId) {
		if (component.getAttribute() == null)
			return;

		List<Attribute> attributesToDelete = new ArrayList<>();
		for (Attribute attribute : component.getAttribute()) {
			if (attribute.getId() != null && attribute.getId().equals(attributeId))
				attributesToDelete.add(attribute);
		}

		for (Attribute attributeToDelete : attributesToDelete) {
			component.getAttribute().remove(attributeToDelete);
		}
	}

	private void editComponentsByType(Model rexsModel, String componentType, List<ChangedValue> changedValues) {
		if (rexsModel.getComponents() == null
				|| rexsModel.getComponents().getComponent() == null
				|| !changedValuesContainsAnyKey(changedValues, "componentId"))
			return;

		for (Component component : rexsModel.getComponents().getComponent()) {
			if (component.getType() != null && component.getType().equals(componentType)) {

				for (ChangedValue changedValue : changedValues) {

					if ("componentId".equals(changedValue.getKey())) {
						component.setType(changedValue.getNewValue());
					}
				}
			}
		}
	}

	private void editAttributesById(Model rexsModel, String attributeId, List<ChangedValue> changedValues) throws RexsUpgradeException {
		if (rexsModel.getComponents() == null || rexsModel.getComponents().getComponent() == null)
			return;

		for (Component component : rexsModel.getComponents().getComponent()) {
			editAttributesById(component, attributeId, changedValues);
		}
	}

	private void editAttributesById(Component component, String attributeId, List<ChangedValue> changedValues) throws RexsUpgradeException {
		if (component.getAttribute() == null
				|| !changedValuesContainsAnyKey(changedValues, "attributeId", "unit", "valuetype"))
			return;

		for (Attribute attribute : component.getAttribute()) {
			if (attribute.getId() != null && attribute.getId().equals(attributeId)) {

				for (ChangedValue changedValue : changedValues) {

					if ("attributeId".equals(changedValue.getKey())) {
						attribute.setId(changedValue.getNewValue());

					} else if ("unit".equals(changedValue.getKey())) {
						attribute.setUnit(changedValue.getNewValue());

					} else if ("valuetype".equals(changedValue.getKey())) {
						editAttributeValueType(attribute, changedValue.getOldValue(), changedValue.getNewValue());
					}
				}
			}
		}
	}

	private void editAttributeValueType(Attribute attribute, String oldValueType, String newValueType) throws RexsUpgradeException {
		if ("integer".equals(oldValueType) && "enum".equals(newValueType)) {
			// Nothing to do
		} else {
			throw new RexsUpgradeException("upgrade from value type '" + oldValueType + "' to '" + newValueType + "' is not implemented yet");
		}
	}

	private boolean changedValuesContainsAnyKey(List<ChangedValue> changedValues, String ... keys) {
		for (ChangedValue changedValue : changedValues) {
			if (changedValue.getKey() == null)
				continue;

			for (String key : keys) {
				if (changedValue.getKey().equals(key))
					return true;
			}
		}

		return false;
	}
}
