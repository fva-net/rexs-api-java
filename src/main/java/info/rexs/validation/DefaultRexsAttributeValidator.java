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

import info.rexs.model.RexsAttribute;
import info.rexs.model.RexsComponent;

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
	public RexsValidationResult validate(RexsAttribute rexsAttribute, RexsComponent rexsComponent) {

		RexsValidationResult validationResult = new RexsValidationResult();

		return validationResult;
	}
}
