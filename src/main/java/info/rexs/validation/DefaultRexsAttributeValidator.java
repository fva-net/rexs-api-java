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

import info.rexs.model.jaxb.Attribute;
import info.rexs.model.jaxb.Component;

/**
 * This implementation of {@link IRexsAttributeValidator} validates the basic structure of a REXS attribute.
 * <p>
 * Official REXS versions are not taken into account.
 *
 * @author FVA GmbH
 */
public class DefaultRexsAttributeValidator implements IRexsAttributeValidator {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RexsValidationResult validate(Attribute rexsAttribute, Component rexsComponent) {

		RexsValidationResult validationResult = new RexsValidationResult();

		String componentType = rexsComponent.getType();
		String attributeId = rexsAttribute.getId();

		List<Object> attributeValues = detectAttributeValues(rexsAttribute);
		if (attributeValues.size() > 1)
			validationResult.addError(RexsValidationResultMessageKey.ATTRIBUTE_MULTIPLE_VALUES, componentType, attributeId);

		return validationResult;
	}

	private List<Object> detectAttributeValues(Attribute rexsAttribute) {

		List<Object> values = new ArrayList<>();

		for (Object value : rexsAttribute.getContent()) {

			if (value instanceof String) {
				String strValue = ((String)value).trim();
				if (strValue.isEmpty())
					continue;

				values.add(strValue);

			} else {
				values.add(value);
			}
		}

		return values;
	}
}
