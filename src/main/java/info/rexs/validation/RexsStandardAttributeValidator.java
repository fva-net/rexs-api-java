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
package info.rexs.validation;

import java.util.ArrayList;
import java.util.List;

import info.rexs.db.DbModelRegistry;
import info.rexs.db.constants.RexsComponentType;
import info.rexs.db.constants.RexsUnitId;
import info.rexs.db.constants.RexsVersion;
import info.rexs.db.constants.standard.RexsStandardUnitIds;
import info.rexs.model.jaxb.Attribute;
import info.rexs.model.jaxb.Component;
import lombok.RequiredArgsConstructor;

/**
 * TODO Document me!
 *
 * @author FVA GmbH
 */
@RequiredArgsConstructor
public class RexsStandardAttributeValidator extends DefaultRexsAttributeValidator {

	private final RexsVersion rexsVersion;

	/**
	 * TODO Document me!
	 *
	 * @param rexsAttribute
	 * 				TODO Document me!
	 * @param rexsComponent
	 * 				TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	@Override
	public RexsValidationResult validate(Attribute rexsAttribute, Component rexsComponent) {

		RexsValidationResult validationResult = super.validate(rexsAttribute, rexsComponent);

		if (rexsVersion == null)
			return validationResult;

		String componentType = rexsComponent.getType();
		RexsComponentType rexsComponentType = DbModelRegistry.getInstance().getComponentType(rexsVersion, componentType);
		String attributeId = rexsAttribute.getId();
		boolean attributeKnown = true;

		if (!DbModelRegistry.getInstance().hasAttributeWithId(rexsVersion, attributeId)) {
			validationResult.addError(RexsValidationResultMessageKey.ATTRIBUTE_ID_UNKNOWN, componentType, attributeId);
			attributeKnown = false;
		}

		else if (!DbModelRegistry.getInstance().componentAttributeMappingExists(attributeId, rexsComponentType, rexsVersion))
			validationResult.addError(RexsValidationResultMessageKey.ATTRIBUTE_COMPONENT_MAPPING_UNKNOWN, componentType, attributeId);

		validationResult.add(validateUnit(rexsAttribute.getUnit(), componentType, attributeId, attributeKnown));

		return validationResult;
	}

	private RexsValidationResult validateUnit(String unit, String componentType, String attributeId, boolean attributeKnown) {

		RexsValidationResult validationResult = new RexsValidationResult();

		if (unit == null
				|| unit.isEmpty())
			return validationResult;

		RexsUnitId unitId = RexsUnitId.findById(unit);
		if (unitId == null
				|| unitId.isOneOf(RexsStandardUnitIds.UNKNOWN))
			validationResult.addError(RexsValidationResultMessageKey.UNIT_UNKNOWN, componentType, attributeId);

		if (unitId != null && attributeKnown) {
			RexsUnitId dbUnitId = DbModelRegistry.getInstance().getAttributeUnit(attributeId, rexsVersion);
			if (!unitId.equals(dbUnitId)) {
				List<String> additionalMessages = new ArrayList<>();
				additionalMessages.add(String.format("expected: \"%s\" but was: \"%s\"", dbUnitId.getId(), unit));
				validationResult.addError(RexsValidationResultMessageKey.ATTRIBUTE_UNIT_MAPPING_UNKNOWN, componentType, attributeId, additionalMessages);
			}
		}

		return validationResult;
	}
}
