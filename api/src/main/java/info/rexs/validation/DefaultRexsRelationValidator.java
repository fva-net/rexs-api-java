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
import info.rexs.model.RexsRelationRef;

/**
 * This implementation of {@link IRexsRelationValidator} validates the basic structure of a REXS relation.
 * <p>
 * Official REXS versions are not taken into account.
 *
 * @author FVA GmbH
 */
public class DefaultRexsRelationValidator implements IRexsRelationValidator {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RexsValidationResult validate(RexsRelation rexsRelation, RexsModel rexsModel) {

		RexsValidationResult validationResult = new RexsValidationResult();

		for (RexsRelationRef ref : rexsRelation.getRefs()) {
			if (!rexsModel.hasComponent(ref.getId()))
				validationResult.addError(RexsValidationResultMessageKey.RELATION_COMPONENT_MISSING, String.valueOf(rexsRelation.getId()), String.valueOf(ref.getId()));
		}

		return validationResult;
	}
}
