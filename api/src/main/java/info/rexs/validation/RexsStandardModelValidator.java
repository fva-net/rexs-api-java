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

import java.util.List;
import java.util.Objects;

import info.rexs.db.DbModelRegistry;
import info.rexs.db.IDbModelRegistry;
import info.rexs.db.constants.RexsVersion;
import info.rexs.db.constants.standard.RexsStandardComponentTypes;
import info.rexs.db.constants.standard.RexsStandardRelationTypes;
import info.rexs.model.RexsComponent;
import info.rexs.model.RexsModel;
import info.rexs.model.RexsRelation;

/**
 * This implementation of {@link IRexsModelValidator} validates the basic structure of a REXS file
 * and includes the specification of official REXS versions.
 *
 * @author FVA GmbH
 */
public class RexsStandardModelValidator extends DefaultRexsModelValidator {

	protected final IDbModelRegistry dbModelRegistry;

	protected RexsVersion rexsVersion = null;

	public RexsStandardModelValidator() {
		this(DbModelRegistry.getInstance());
	}

	public RexsStandardModelValidator(IDbModelRegistry dbModelRegistry) {
		Objects.nonNull(dbModelRegistry);
		this.dbModelRegistry = dbModelRegistry;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected RexsValidationResult validateVersion(String version) {
		RexsValidationResult validationResult = super.validateVersion(version);

		if (version == null
				|| version.isEmpty())
			return validationResult;

		rexsVersion = dbModelRegistry.getVersion(version);

		if (rexsVersion == null)
			validationResult.addError(RexsValidationResultMessageKey.MODEL_VERSION_UNKNOWN);

		return validationResult;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RexsValidationResult validate(RexsModel rexsModel) {
		RexsValidationResult validationResult = super.validate(rexsModel);

		validationResult.add(checkPlanetaryStage(rexsModel));

		return validationResult;
	}

	private RexsValidationResult checkPlanetaryStage(RexsModel rexsModel) {
		RexsValidationResult validationResult = new RexsValidationResult();

		for (RexsComponent planetaryStage : rexsModel.getComponentsOfType(RexsStandardComponentTypes.planetary_stage)) {

			if (rexsModel.getSubComponentsWithType(planetaryStage.getId(), RexsStandardComponentTypes.planet_carrier).size()!=1)
				validationResult.addError(RexsValidationResultMessageKey.PLANETARY_STAGE_INCONSISTENT_CARRIER, String.valueOf(planetaryStage.getId()));
			if (rexsModel.getSubComponentsWithType(planetaryStage.getId(), RexsStandardComponentTypes.cylindrical_stage).isEmpty())
				validationResult.addError(RexsValidationResultMessageKey.PLANETARY_STAGE_MISSING_STAGE, String.valueOf(planetaryStage.getId()));

			List<RexsRelation> relationsOfPlanetaryStage = rexsModel.getRelationsOfMainComp(planetaryStage.getId());
			if (relationsOfPlanetaryStage.stream().noneMatch(r -> r.getType()==RexsStandardRelationTypes.planet_shaft))
				validationResult.addError(RexsValidationResultMessageKey.PLANETARY_STAGE_MISSING_PLANET_SHAFT, String.valueOf(planetaryStage.getId()));
			if (relationsOfPlanetaryStage.stream().noneMatch(r -> r.getType()==RexsStandardRelationTypes.central_shaft))
				validationResult.addError(RexsValidationResultMessageKey.PLANETARY_STAGE_MISSING_CENTRAL_SHAFT, String.valueOf(planetaryStage.getId()));
		}

		return validationResult;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IRexsComponentValidator createComponentValidator() {
		if (rexsVersion == null)
			return super.createComponentValidator();
		return new RexsStandardComponentValidator(rexsVersion, dbModelRegistry);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IRexsRelationValidator createRelationValidator() {
		if (rexsVersion == null)
			return super.createRelationValidator();
		return new RexsStandardRelationValidator(rexsVersion, dbModelRegistry);
	}
}
