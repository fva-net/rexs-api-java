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

import java.util.HashSet;
import java.util.Set;

import info.rexs.model.RexsAttribute;
import info.rexs.model.RexsComponent;

/**
 * This implementation of {@link IRexsComponentValidator} validates the basic structure of a REXS component.
 * <p>
 * Official REXS versions are not taken into account.
 *
 * @author FVA GmbH
 */
public class DefaultRexsComponentValidator implements IRexsComponentValidator {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RexsValidationResult validate(RexsComponent rexsComponent) {

		RexsValidationResult validationResult = new RexsValidationResult();

		if (rexsComponent.getAttributes() == null
				|| rexsComponent.getAttributes().isEmpty()) {
			validationResult.addWarning(RexsValidationResultMessageKey.COMPONENT_ATTRIBUTES_EMPTY, rexsComponent.toString());
			return validationResult;

		} else {
			IRexsAttributeValidator attributeValidator = createAttributeValidator();

			Set<String> existingAttributeIds = new HashSet<>();
			Set<String> existingAttributeIdsReported = new HashSet<>();

			for (RexsAttribute rexsAttribute : rexsComponent.getAttributes()) {
				validationResult.add(attributeValidator.validate(rexsAttribute, rexsComponent));

				String attributeId = rexsAttribute.getOriginAttributeId();
				if (existingAttributeIds.contains(attributeId)
						&& !existingAttributeIdsReported.contains(attributeId)) {
					validationResult.addWarning(RexsValidationResultMessageKey.COMPONENT_ATTRIBUTE_MULTIPLE, attributeId, rexsComponent.toString());
					existingAttributeIdsReported.add(attributeId);
				}
				existingAttributeIds.add(attributeId);
			}
		}

		return validationResult;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IRexsAttributeValidator createAttributeValidator() {
		return new DefaultRexsAttributeValidator();
	}
}
