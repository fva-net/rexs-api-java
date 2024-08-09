/*******************************************************************************
 * Copyright (C) 2024 FVA GmbH
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
import info.rexs.model.RexsRelation;

/**
 * This interface represents the validator of a REXS relation.
 *
 * @author FVA GmbH
 */
public interface IRexsRelationValidator {

	/**
	 * Validates a REXS relation and returns the validation result.
	 *
	 * @param rexsRelation
	 * 				The REXS relation to validate.
	 * @param rexsModel 
	 *
	 * @return
	 * 				The validation result as {@link RexsValidationResult}.
	 */
	public RexsValidationResult validate(RexsRelation rexsRelation, RexsModel rexsModel);
}
