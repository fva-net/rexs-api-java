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

import info.rexs.model.RexsComponent;
import info.rexs.model.RexsModel;
import info.rexs.model.RexsRelation;

/**
 * This implementation of {@link IRexsModelValidator} validates the basic structure of a REXS model
 * and includes the specification of official REXS versions.
 *
 * @author FVA GmbH
 */
public class DefaultRexsModelValidator implements IRexsModelValidator {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RexsValidationResult validate(RexsModel rexsModel) {

		RexsValidationResult validationResult = new RexsValidationResult();

		validationResult.add(validateVersion(rexsModel.getOriginVersion()));

		if (rexsModel.getComponents() == null
				|| rexsModel.getComponents().isEmpty()) {
			validationResult.addError(RexsValidationResultMessageKey.MODEL_COMPONENTS_EMPTY);
			return validationResult;
		}

		IRexsComponentValidator componentValidator = createComponentValidator();
		for (RexsComponent rexsComponent : rexsModel.getComponents()) {
			validationResult.add(componentValidator.validate(rexsComponent));
		}

		IRexsRelationValidator relationValidator = createRelationValidator();
		for (RexsRelation rexsRelation : rexsModel.getRelations())
			validationResult.add(relationValidator.validate(rexsRelation, rexsModel));

		return validationResult;
	}

	protected RexsValidationResult validateVersion(String version) {
		RexsValidationResult validationResult = new RexsValidationResult();

		if (version == null
				|| version.isEmpty())
			validationResult.addError(RexsValidationResultMessageKey.MODEL_VERSION_EMPTY);

		return validationResult;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IRexsComponentValidator createComponentValidator() {
		return new DefaultRexsComponentValidator();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IRexsRelationValidator createRelationValidator() {
		return new DefaultRexsRelationValidator();
	}
}
