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

import info.rexs.model.RexsModel;

/**
 * This interface represents the validator of a REXS model.
 *
 * @author FVA GmbH
 */
public interface IRexsModelValidator {

	/**
	 * Validates a REXS model and returns the validation result.
	 *
	 * @param rexsModel
	 * 				The REXS model to validate.
	 *
	 * @return
	 * 				The validation result as {@link RexsValidationResult}.
	 */
	public RexsValidationResult validate(RexsModel rexsModel);

	/**
	 * Creates a new validator for the components of the REXS file.
	 *
	 * @return
	 * 				The component validator as {@link IRexsComponentValidator}.
	 */
	public IRexsComponentValidator createComponentValidator();

	/**
	 * Creates a new validator for the relations of the REXS file.
	 * 
	 * @return
	 * 				The relation validator as {@link IRexsRelationValidator}.
	 */
	IRexsRelationValidator createRelationValidator();
}
