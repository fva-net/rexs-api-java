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

import java.util.HashSet;
import java.util.Set;

import info.rexs.model.jaxb.Attribute;
import info.rexs.model.jaxb.Component;

/**
 * TODO Document me!
 *
 * @author FVA GmbH
 */
public class DefaultRexsComponentValidator implements IRexsComponentValidator {

	/**
	 * TODO Document me!
	 *
	 * @param rexsComponent
	 * 				TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	@Override
	public RexsValidationResult validate(Component rexsComponent) {

		RexsValidationResult validationResult = new RexsValidationResult();

		String componentType = rexsComponent.getType();

		if (rexsComponent.getAttribute() == null
				|| rexsComponent.getAttribute().isEmpty()) {
			validationResult.addWarning(RexsValidationResultMessageKey.COMPONENT_ATTRIBUTES_EMPTY, componentType);
			return validationResult;

		} else {
			IRexsAttributeValidator attributeValidator = createAttributeValidator();

			Set<String> existingAttributeIds = new HashSet<>();
			Set<String> existingAttributeIdsReported = new HashSet<>();

			for (Attribute rexsAttribute : rexsComponent.getAttribute()) {
				validationResult.add(attributeValidator.validate(rexsAttribute, rexsComponent));

				String attributeId = rexsAttribute.getId();
				if (existingAttributeIds.contains(attributeId)
						&& !existingAttributeIdsReported.contains(attributeId)) {
					validationResult.addWarning(RexsValidationResultMessageKey.COMPONENT_ATTRIBUTE_MULTIPLE, componentType, attributeId);
					existingAttributeIdsReported.add(attributeId);
				}
				existingAttributeIds.add(attributeId);
			}
		}

		return validationResult;
	}

	/**
	 * TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	@Override
	public IRexsAttributeValidator createAttributeValidator() {
		return new DefaultRexsAttributeValidator();
	}
}
