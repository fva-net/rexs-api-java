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
import info.rexs.db.constants.standard.RexsStandardComponentTypes;
import info.rexs.model.RexsComponent;

/**
 * This implementation of {@link IRexsComponentValidator} validates the basic structure of a REXS component
 * and includes the specification of official REXS versions.
 *
 * @author FVA GmbH
 */
public class RexsStandardComponentValidator extends DefaultRexsComponentValidator {

	private final RexsVersion rexsVersion;

	public RexsStandardComponentValidator(RexsVersion rexsVersion) {
		this.rexsVersion = rexsVersion;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RexsValidationResult validate(RexsComponent rexsComponent) {

		RexsValidationResult validationResult = super.validate(rexsComponent);

		if (rexsVersion == null)
			return validationResult;

		String componentType = rexsComponent.getOriginType();
		RexsComponentType rexsComponentType = DbModelRegistry.getInstance().getComponentType(rexsVersion, componentType);

		if (rexsComponentType.isOneOf(RexsStandardComponentTypes.UNKNOWN))
			validationResult.addError(RexsValidationResultMessageKey.COMPONENT_TYPE_UNKNOWN, componentType);

		return validationResult;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IRexsAttributeValidator createAttributeValidator() {
		return new RexsStandardAttributeValidator(rexsVersion);
	}
}
