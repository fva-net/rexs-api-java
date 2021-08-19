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
import info.rexs.db.constants.RexsVersion;

/**
 * This implementation of {@link IRexsFileValidator} validates the basic structure of a REXS file
 * and includes the specification of official REXS versions.
 *
 * @author FVA GmbH
 */
public class RexsStandardFileValidator extends DefaultRexsFileValidator {

	private RexsVersion rexsVersion = null;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RexsValidationResult validateVersion(String version) {

		RexsValidationResult validationResult = super.validateVersion(version);

		if (version == null
				|| version.isEmpty())
			return validationResult;

		rexsVersion = DbModelRegistry.getInstance().getVersion(version);

		if (rexsVersion == null)
			validationResult.addError(RexsValidationResultMessageKey.MODEL_VERSION_UNKNOWN);

		return validationResult;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IRexsComponentValidator createComponentValidator() {
		return new RexsStandardComponentValidator(rexsVersion);
	}
}
