/*
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
 */
package info.rexs.upgrade.upgraders;

import java.util.ArrayList;
import java.util.List;

import info.rexs.model.RexsAttribute;
import info.rexs.model.RexsComponent;
import info.rexs.model.RexsModel;
import info.rexs.model.value.RexsAttributeValueScalar;
import info.rexs.schema.constants.RexsAttributeId;
import info.rexs.schema.constants.RexsComponentType;
import info.rexs.schema.constants.RexsUnitId;
import info.rexs.schema.constants.RexsValueType;
import info.rexs.schema.constants.standard.RexsStandardUnitIds;
import info.rexs.upgrade.RexsUpgradeException;
import info.rexs.upgrade.upgraders.UpgradeNotifications.AttributeSource;
import info.rexs.upgrade.upgraders.UpgradeNotifications.ComponentSource;
import info.rexs.upgrade.upgraders.UpgradeNotifications.Notification;
import info.rexs.upgrade.upgraders.UpgradeNotifications.NotificationType;
import info.rexs.upgrade.upgraders.changelog.jaxb.AttributeChange;
import info.rexs.upgrade.upgraders.changelog.jaxb.ChangeType;
import info.rexs.upgrade.upgraders.changelog.jaxb.ChangedValue;
import info.rexs.upgrade.upgraders.changelog.jaxb.ComponentChange;
import info.rexs.upgrade.upgraders.changelog.jaxb.EnumValueChange;
import info.rexs.upgrade.upgraders.changelog.jaxb.MappingChange;
import info.rexs.upgrade.upgraders.changelog.jaxb.RexsChangelog;

/** generic upgrade for changes defined in the changelog file */
public class ModelChangelogUpgrader {

	private final RexsModel newModel;
	private final RexsModel oldModel;

	private final RexsChangelog changelog;
	private UpgradeNotifications notifications = new UpgradeNotifications();
	/** remove invalid attributes in strict mode */
	private boolean strictMode;

	public ModelChangelogUpgrader(RexsModel model, RexsChangelog changelog, boolean strictMode) {
		this.oldModel = model;
		this.newModel = new RexsModel(model);
		this.changelog = changelog;
		this.strictMode = strictMode;
	}


	public RexsModel applyChangelog() throws RexsUpgradeException {
		if (changelog.getComponentChanges() != null)
			for (ComponentChange change : changelog.getComponentChanges()) {
				if (change.getType() == ChangeType.DELETE)
					deleteComponentsByType(newModel, change.getId());

				if (change.getType() == ChangeType.EDIT)
					editComponentsByType(change.getId(), change.getChangedValues());
			}

		if (changelog.getMappingChanges() != null)
			for (MappingChange change : changelog.getMappingChanges()) {
				if (change.getType() == ChangeType.DELETE) {
					if (strictMode) {
						deleteAttributesByComponentTypeAndAttributeId(newModel, change.getComponentId(), change.getAttributeId());
					}
					else
						notifyAboutOutdatedAttributeMapping(change.getComponentId(), change.getAttributeId());
				}
			}

		if (changelog.getAttributeChanges() != null)
			for (AttributeChange change : changelog.getAttributeChanges()) {
				if (change.getType() == ChangeType.EDIT)
					editAttributesById(change.getId(), change.getChangedValues());
			}

		return newModel;
	}



	private void notifyAboutOutdatedAttributeMapping(String componentType, String attributeId) {
		List<RexsComponent> affectedComponents = newModel.getComponentsOfType(RexsComponentType.findById(componentType)).stream().
				filter( c -> c.getAttributes().stream().anyMatch(a -> a.getAttributeId().getId().equals(attributeId))).toList();
		for (RexsComponent component : affectedComponents) {
			notifications.add(new Notification(NotificationType.WARNING, "Attribute is no longer available for this component type: ",
					new ComponentSource(component.getId()), new AttributeSource(attributeId)));
		}
	}


	private void editComponentsByType(String componentType, List<ChangedValue> changedValues) {
		for (RexsComponent component : oldModel.getComponents()) {
			if (component.getType().getId().equals(componentType)) {

				for (ChangedValue changedValue : changedValues) {
					if ("componentId".equals(changedValue.getKey())) {
						RexsComponentType compType = RexsComponentType.findById(changedValue.getNewValue());
						component.setType(compType);
					}
				}
			}
		}
	}

	private void deleteComponentsByType(RexsModel rexsModel, String componentType) {
		List<RexsComponent> componentsToDelete = new ArrayList<>();
		for (RexsComponent component : rexsModel.getComponents()) {
			if (component.getType().getId().equals(componentType))
				componentsToDelete.add(component);
		}

		for (RexsComponent componentToDelete : componentsToDelete) {
			rexsModel.removeComponent(componentToDelete);
			notifications.add(new Notification("removed component", new ComponentSource(componentToDelete.getId())));
		}
	}

	private void deleteAttributesByComponentTypeAndAttributeId(RexsModel rexsModel, String componentType, String attributeId) {
		for (RexsComponent component : rexsModel.getComponents()) {
			if (component.getType().getId().equals(componentType)) {
				deleteAttributesById(component, attributeId);
			}
		}
	}

	private void deleteAttributesById(RexsComponent component, String attributeId) {
		List<RexsAttribute> attributesToDelete = new ArrayList<>();
		for (RexsAttribute attribute : component.getAttributes()) {
			if (attribute.getAttributeId().getId().equals(attributeId))
				attributesToDelete.add(attribute);
		}

		for (RexsAttribute attributeToDelete : attributesToDelete) {
			component.removeAttribute(attributeToDelete.getAttributeId());
			notifications.add(new Notification("removed attribute",
					new ComponentSource(component.getId()), new AttributeSource(attributeId)));
		}
	}

	private void editAttributesById(String attributeId, List<ChangedValue> changedValues) throws RexsUpgradeException {
		for (RexsComponent component : newModel.getComponents()) {
			for (RexsAttribute attribute : component.getAttributes()) {
				if (attribute.getAttributeId().getId().equals(attributeId)) {

					for (ChangedValue changedValue : changedValues) {
						switch(changedValue.getKey()) {
						case "attributeId": {
							RexsAttributeId id = RexsAttributeId.findById(changedValue.getNewValue());
							attribute.setId(id);
							break;
						}
						case "numericId": {
							// numeric id exists only in the database
							// do nothing
							break;
						}
						case "unit": {
							if (changedValue.getOldValue().equals("\u00B0") && changedValue.getNewValue().equals("deg")) {
								attribute.setUnit(RexsStandardUnitIds.deg);
							} else
							if (changedValue.getOldValue().equals("N") && changedValue.getNewValue().equals("N / mm")) {
								attribute.setUnit(RexsStandardUnitIds.newton_per_mm);
								notifications.add(new Notification(NotificationType.WARNING, "unit conversion from N to N/mm",
										new AttributeSource(attribute.getAttributeId().getId())));
							} else {
								throw new RuntimeException("unsupported unit conversion");
							}
							RexsUnitId unit = RexsUnitId.findById(changedValue.getNewValue());
							attribute.setUnit(unit);
							break;
						}
						case "symbol": {
							// do nothing
							break;
						}
						case "name": {
							// change translation
							// do nothing
							break;
						}
						case "valuetype": {
							RexsValueType oldType = RexsValueType.findByKey(changedValue.getOldValue());
							RexsValueType newType = RexsValueType.findByKey(changedValue.getNewValue());

							editAttributeValueType(component, attribute, oldType, newType);
							break;
						}
						case "range": {
							// TODO
							break;
						}
						case "rangeMin": {
							// TODO
							break;
						}
						case "rangeMax": {
							// TODO
							break;
						}
						case "rangeMinIntervalOpen": {
							// TODO
							break;
						}
						case "rangeMaxIntervalOpen": {
							// TODO
							break;
						}

						case "enumvalues": {
							changeEnumValue(attribute, changedValue);
							break;
						}
						default: throw new RuntimeException("unknown key "+changedValue.getKey());
						}
					}
				}
			}
		}
	}


	private void changeEnumValue(RexsAttribute attribute, ChangedValue changedValue) {
		for (EnumValueChange enumChange: changedValue.getEnumValueChanges()) {
			switch (enumChange.getType()) {
			case ADD: {
				// Do nothing. Change must be handled by custom upgrade.
				break;
			}
			case DELETE: {
				// Do nothing. Change must be handled by custom upgrade.
				break;
			}
			case EDIT: {
				String attrValue = attribute.getStringValue();
				if (attrValue.equals(enumChange.getValue())) {
					ChangedValue changedEnumValue = enumChange.getChangedValues().get(0);
					String newName = changedEnumValue.getNewValue();
					attribute.setStringValue(newName);
				}
				break;
			}
			default:
				throw new RuntimeException("unknown enum change type");
			}
		}
	}

	private void editAttributeValueType(
			RexsComponent component,
			RexsAttribute attribute,
			RexsValueType oldType,
			RexsValueType newType) {

		String rawValue = attribute.getRawValue().getValueString();
		switch(newType) {
		case BOOLEAN: {
			switch(rawValue) {
			case "true":
				attribute.setRawValue(new RexsAttributeValueScalar("true"));
				break;
			case "false":
				attribute.setRawValue(new RexsAttributeValueScalar("false"));
				break;
			default:
				if (strictMode) {
					component.removeAttribute(attribute.getAttributeId());
				}
				notifications.add(new Notification(NotificationType.WARNING, "value could not be converted to boolean",
						new AttributeSource(attribute.getAttributeId().getId())));
			break;
			}
		}
		case INTEGER: {
			try {
				attribute.setRawValue(new RexsAttributeValueScalar(rawValue));
			} catch (NumberFormatException e) {
				if (strictMode) {
					component.removeAttribute(attribute.getAttributeId());
				}
				notifications.add(new Notification(NotificationType.WARNING, "value could not be converted to integer",
						new AttributeSource(attribute.getAttributeId().getId())));
			}
			break;
		}
		case FLOATING_POINT: {
			try {
				attribute.setRawValue(new RexsAttributeValueScalar(rawValue));
			} catch (NumberFormatException e) {
				if (strictMode) {
					component.removeAttribute(attribute.getAttributeId());
				}
				notifications.add(new Notification(NotificationType.WARNING, "value could not be converted to float",
						new AttributeSource(attribute.getAttributeId().getId())));
			}
			break;
		}
		case ENUM: {
			// Do nothing. Change must be handled by custom upgrade.
			break;
		}
		default:
			throw new RuntimeException("unsupported type conversion to "+newType);
		}
	}

	public UpgradeNotifications getNotifications() {
		return notifications;
	}

}
