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
package info.rexs.validation;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;

import info.rexs.schema.RexsSchemaRegistry;
import info.rexs.schema.IRexsSchemaRegistry;
import info.rexs.schema.constants.RexsComponentType;
import info.rexs.schema.constants.RexsUnitId;
import info.rexs.schema.constants.RexsVersion;
import info.rexs.schema.constants.standard.RexsStandardUnitIds;
import info.rexs.model.RexsAttribute;
import info.rexs.model.RexsComponent;

/**
 * This implementation of {@link IRexsAttributeValidator} validates the basic structure of a REXS attribute
 * and includes the specification of official REXS versions.
 *
 * @author FVA GmbH
 */
public class RexsStandardAttributeValidator extends DefaultRexsAttributeValidator {

	protected final IRexsSchemaRegistry rexsSchemaRegistry;

	protected final RexsVersion rexsVersion;

	public RexsStandardAttributeValidator(RexsVersion rexsVersion) {
		this(rexsVersion, RexsSchemaRegistry.getInstance());
	}

	public RexsStandardAttributeValidator(RexsVersion rexsVersion, IRexsSchemaRegistry rexsSchemaRegistry) {
		Objects.nonNull(rexsSchemaRegistry);
		this.rexsVersion = rexsVersion;
		this.rexsSchemaRegistry = rexsSchemaRegistry;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RexsValidationResult validate(RexsAttribute rexsAttribute, RexsComponent rexsComponent) {
		RexsValidationResult validationResult = super.validate(rexsAttribute, rexsComponent);

		if (rexsVersion == null)
			return validationResult;

		String componentType = rexsComponent.getOriginType();
		RexsComponentType rexsComponentType = rexsSchemaRegistry.getComponentType(rexsVersion, componentType);
		String attributeId = rexsAttribute.getOriginAttributeId();
		boolean attributeKnown = true;

		if (!rexsSchemaRegistry.hasAttributeWithId(rexsVersion, attributeId)) {
			if (StringUtils.startsWith(attributeId, "custom_"))
				validationResult.addWarning(RexsValidationResultMessageKey.ATTRIBUTE_ID_CUSTOM, attributeId);
			else
				validationResult.addError(RexsValidationResultMessageKey.ATTRIBUTE_ID_UNKNOWN, attributeId);
			attributeKnown = false;
		}
		else if (!rexsSchemaRegistry.componentAttributeMappingExists(attributeId, rexsComponentType, rexsVersion))
			validationResult.addError(RexsValidationResultMessageKey.ATTRIBUTE_COMPONENT_MAPPING_UNKNOWN, rexsComponent.toString(), attributeId);

		validationResult.add(validateUnit(rexsAttribute.getOriginUnit(), rexsComponent.toString(), attributeId, attributeKnown));

		return validationResult;
	}

	private RexsValidationResult validateUnit(String unit, String componentName, String attributeId, boolean attributeKnown) {
		RexsValidationResult validationResult = new RexsValidationResult();

		if (unit == null
				|| unit.isEmpty())
			return validationResult;

		RexsUnitId unitId = RexsUnitId.findById(unit);
		if (unitId == null
				|| unitId.isOneOf(RexsStandardUnitIds.UNKNOWN))
			validationResult.addError(RexsValidationResultMessageKey.UNIT_UNKNOWN, unit);

		if (unitId != null && attributeKnown) {
			RexsUnitId dbUnitId = rexsSchemaRegistry.getAttributeUnit(attributeId, rexsVersion);
			if (!unitId.equals(dbUnitId)) {
				String additionalMessage = String.format("expected: \"%s\" but was: \"%s\"", dbUnitId.getId(), unit);
				validationResult.addError(RexsValidationResultMessageKey.ATTRIBUTE_UNIT_MAPPING_UNKNOWN, attributeId, componentName , additionalMessage);
			}
		}

		return validationResult;
	}
}
