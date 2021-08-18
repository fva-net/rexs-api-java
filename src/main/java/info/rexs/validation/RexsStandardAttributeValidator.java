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

import info.rexs.db.DbModelRegistry;
import info.rexs.db.constants.RexsComponentType;
import info.rexs.db.constants.RexsVersion;
import info.rexs.model.jaxb.Attribute;
import info.rexs.model.jaxb.Component;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RexsStandardAttributeValidator extends DefaultRexsAttributeValidator {

	private final RexsVersion rexsVersion;

	@Override
	public RexsValidationResult validate(Attribute rexsAttribute, Component rexsComponent) {

		RexsValidationResult validationResult = super.validate(rexsAttribute, rexsComponent);

		if (rexsVersion == null)
			return validationResult;

		String componentType = rexsComponent.getType();
		RexsComponentType rexsComponentType = DbModelRegistry.getInstance().getComponentType(rexsVersion, componentType);
		String attributeId = rexsAttribute.getId();

		if (!DbModelRegistry.getInstance().hasAttributeWithId(rexsVersion, attributeId))
			validationResult.addError(RexsValidationResultMessageKey.ATTRIBUTE_ID_UNKNOWN, componentType, attributeId);

		else if (!DbModelRegistry.getInstance().componentAttributeMappingExists(attributeId, rexsComponentType, rexsVersion))
			validationResult.addError(RexsValidationResultMessageKey.ATTRIBUTE_COMPONENT_MAPPING_UNKNOWN, componentType, attributeId);

		return validationResult;
	}
}
