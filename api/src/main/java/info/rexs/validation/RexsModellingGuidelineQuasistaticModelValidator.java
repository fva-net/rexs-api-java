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

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import info.rexs.db.IDbModelRegistry;
import info.rexs.db.constants.RexsComponentType;
import info.rexs.db.constants.standard.RexsStandardComponentTypes;
import info.rexs.db.constants.standard.RexsStandardRelationRoles;
import info.rexs.db.constants.standard.RexsStandardRelationTypes;
import info.rexs.db.jaxb.AllowedCombinationRole;
import info.rexs.model.RexsComponent;
import info.rexs.model.RexsModel;
import info.rexs.model.RexsRelation;

public class RexsModellingGuidelineQuasistaticModelValidator extends RexsStandardModelValidator {

	public RexsModellingGuidelineQuasistaticModelValidator() {
		super();
	}

	public RexsModellingGuidelineQuasistaticModelValidator(IDbModelRegistry dbModelRegistry) {
		super(dbModelRegistry);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RexsValidationResult validate(RexsModel rexsModel) {
		RexsValidationResult validationResult = super.validate(rexsModel);

		validationResult.add(checkIfUniqueGearUnitIsPresent(rexsModel));
		validationResult.add(checkIfComponentWithoutRelationIsPresent(rexsModel));
		validationResult.add(checkShaftSections(rexsModel));
		validationResult.add(checkGears(rexsModel));
		validationResult.add(checkStages(rexsModel));
		validationResult.add(checkSideReleations(rexsModel));
		validationResult.add(checkPlanetCarrier(rexsModel));

		return validationResult;
	}

	private RexsValidationResult checkSideReleations(RexsModel rexsModel) {
		RexsValidationResult validationResult = new RexsValidationResult();

		List<RexsRelation> sideRelations = rexsModel.getRelationsOfType(RexsStandardRelationTypes.side);

		if (dbModelRegistry.hasRelationTypes(rexsVersion)) {
			List<List<AllowedCombinationRole>> listOfAllowedCombinationsSideRelation = dbModelRegistry.getAllowedCombinationsForRelation(rexsVersion, RexsStandardRelationTypes.side);
			Set<RexsComponentType> mainComponentTypesForSideRelation = new HashSet<>();
			for (List<AllowedCombinationRole> allowedCombination : listOfAllowedCombinationsSideRelation) {
				for (AllowedCombinationRole combination : allowedCombination) {
					if (combination.getRoleId().equals(RexsStandardRelationRoles.assembly.getKey())) {
						mainComponentTypesForSideRelation.add(RexsComponentType.findById(combination.getComponentId()));
						break;
					}
				}
			}

			for (RexsComponentType mainType : mainComponentTypesForSideRelation) {
				for (RexsComponent mainComponent : rexsModel.getComponentsOfType(mainType)) {
					if (sideRelations.stream().noneMatch(r -> r.hasComponent(mainComponent.getId())))
						validationResult.addError(RexsValidationResultMessageKey.GUIDELINE_QUASISTATIC_COMPONENT_REQUIRES_SIDE_RELATION, mainComponent.toString(), mainComponent.getType().getId());
				}
			}
		}

		for (RexsComponent shaft : rexsModel.getComponentsOfType(RexsStandardComponentTypes.shaft)) {
			if (sideRelations.stream().noneMatch(r -> r.hasComponent(shaft.getId())))
				validationResult.addWarning(RexsValidationResultMessageKey.GUIDELINE_QUASISTATIC_SHAFT_WITHOUT_SIDE_RELATION, shaft.toString());
		}

		return validationResult;
	}

	private RexsValidationResult checkPlanetCarrier(RexsModel rexsModel) {
		RexsValidationResult validationResult = new RexsValidationResult();

		for (RexsComponent planetaryStage : rexsModel.getComponentsOfType(RexsStandardComponentTypes.planetary_stage)) {
			try {
				RexsComponent carrier = rexsModel.getSubComponentsWithType(planetaryStage.getId(), RexsStandardComponentTypes.planet_carrier).get(0);

				List<RexsComponent> shaftsInCarrier = rexsModel.getSubComponentsWithType(carrier.getId(), RexsStandardComponentTypes.shaft);

				List<RexsRelation> relationsOfPlanetaryStage = rexsModel.getRelationsOfMainComp(planetaryStage.getId());
				List<Integer> carrierShaftIds = relationsOfPlanetaryStage.stream().filter(r -> r.getType()==RexsStandardRelationTypes.planet_carrier_shaft).map(r -> r.findComponentIdByRole(RexsStandardRelationRoles.shaft)).toList();
				List<Integer> pinShaftIds = relationsOfPlanetaryStage.stream().filter(r -> r.getType()==RexsStandardRelationTypes.planet_pin).map(r -> r.findComponentIdByRole(RexsStandardRelationRoles.shaft)).toList();

				if (carrierShaftIds.isEmpty())
					validationResult.addError(RexsValidationResultMessageKey.GUIDELINE_QUASISTATIC_PLANETARY_STAGE_MISSING_PLANET_CARRIER_SHAFT, planetaryStage.toString());

				if (shaftsInCarrier.stream().noneMatch(s -> carrierShaftIds.contains(s.getId())))
					validationResult.addError(RexsValidationResultMessageKey.GUIDELINE_QUASISTATIC_PLANETARY_CARRIER_MISSING_PLANET_CARRIER_SHAFT, planetaryStage.toString());

				List<RexsComponent> sidePlates = rexsModel.getSubComponentsWithType(carrier.getId(), RexsStandardComponentTypes.side_plate);
				if (sidePlates.isEmpty())
					validationResult.addError(RexsValidationResultMessageKey.GUIDELINE_QUASISTATIC_PLANETARY_CARRIER_MISSING_SIDE_PLATE, planetaryStage.toString());
				else {
					for (RexsComponent sidePlate : sidePlates) {
						List<RexsRelation> sideRelations = rexsModel.getRelations(RexsStandardRelationTypes.side, RexsStandardRelationRoles.outer_part, sidePlate.getId());
						if (!atLeastOneIdIsContainedInRelations(carrierShaftIds, sideRelations))
							validationResult.addError(RexsValidationResultMessageKey.GUIDELINE_QUASISTATIC_SIDE_PLATE_MISSING_CARRIER_SHAFT_COUPLING, sidePlate.toString());
					}
				}

				for (Integer pinId : pinShaftIds) {
					List<RexsRelation> sideRelations = rexsModel.getRelations(RexsStandardRelationTypes.side, RexsStandardRelationRoles.inner_part, pinId);
					if (!atLeastOneIdIsContainedInRelations(sidePlates.stream().map(c -> c.getId()).toList(), sideRelations))
						validationResult.addError(RexsValidationResultMessageKey.GUIDELINE_QUASISTATIC_SIDE_PLATE_MISSING_PIN_COUPLING, rexsModel.getComponent(pinId).toString());
				}

			}
			catch (IndexOutOfBoundsException e) {
				// invalid planetray stage -> errors were already generated in standard validator
			}
		}

		return validationResult;
	}

	private boolean atLeastOneIdIsContainedInRelations(List<Integer> componentIds, List<RexsRelation> relations) {
		for (Integer componentId : componentIds) {
			if (relations.stream().anyMatch(r -> r.hasComponent(componentId)))
				return true;
		}
		return false;
	}

	private RexsValidationResult checkGears(RexsModel rexsModel) {
		RexsValidationResult validationResult = new RexsValidationResult();

		List<RexsComponent> gears = rexsModel.getComponentsOfType(RexsStandardComponentTypes.cylindrical_gear);
		gears.addAll(rexsModel.getComponentsOfType(RexsStandardComponentTypes.ring_gear));
		gears.addAll(rexsModel.getComponentsOfType(RexsStandardComponentTypes.bevel_gear));
		gears.addAll(rexsModel.getComponentsOfType(RexsStandardComponentTypes.worm_gear));
		gears.addAll(rexsModel.getComponentsOfType(RexsStandardComponentTypes.worm_wheel));
		gears.addAll(rexsModel.getComponentsOfType(RexsStandardComponentTypes.involute_spline_gear_shaft));
		gears.addAll(rexsModel.getComponentsOfType(RexsStandardComponentTypes.involute_spline_gear_hub));
		for (RexsComponent gear : gears) {
			if (rexsModel.getStagesOfGear(gear).isEmpty())
				validationResult.addError(RexsValidationResultMessageKey.GUIDELINE_QUASISTATIC_INCONSISTENT_GEAR, gear.toString());
		}

		return validationResult;
	}

	private RexsValidationResult checkStages(RexsModel rexsModel) {
		RexsValidationResult validationResult = new RexsValidationResult();

		List<RexsComponent> stages = rexsModel.getComponentsOfType(RexsStandardComponentTypes.cylindrical_stage);
		stages.addAll(rexsModel.getComponentsOfType(RexsStandardComponentTypes.bevel_stage));
		stages.addAll(rexsModel.getComponentsOfType(RexsStandardComponentTypes.worm_stage));
		stages.addAll(rexsModel.getComponentsOfType(RexsStandardComponentTypes.involute_spline_connection));
		for (RexsComponent stage : stages) {
			RexsComponent gear1 = rexsModel.getGear1OfStage(stage.getId());
			RexsComponent gear2 = rexsModel.getGear2OfStage(stage.getId());
			if (gear1==null || gear2==null || gear1.getId()==gear2.getId())
				validationResult.addError(RexsValidationResultMessageKey.GUIDELINE_QUASISTATIC_INCONSISTENT_STAGE, stage.toString());
		}

		return validationResult;
	}

	private RexsValidationResult checkShaftSections(RexsModel rexsModel) {
		RexsValidationResult validationResult = new RexsValidationResult();

		for (RexsComponent shaft : rexsModel.getComponentsOfType(RexsStandardComponentTypes.shaft)) {
			if(rexsModel.getSubComponentsWithType(shaft.getId(), RexsStandardComponentTypes.shaft_section).isEmpty())
				validationResult.addError(RexsValidationResultMessageKey.GUIDELINE_QUASISTATIC_SHAFT_WITHOUT_SHAFT_SECTION, shaft.toString());
		}

		return validationResult;
	}

	private RexsValidationResult checkIfComponentWithoutRelationIsPresent(RexsModel rexsModel) {
		RexsValidationResult validationResult = new RexsValidationResult();

		List<RexsRelation> relations = rexsModel.getRelations();
		for (RexsComponent component : rexsModel.getComponents()) {
			if (relations.stream().noneMatch(r -> r.hasComponent(component.getId()))) {
				validationResult.addError(RexsValidationResultMessageKey.GUIDELINE_QUASISTATIC_COMPONENT_WITHOUT_RELATION, component.toString());
			}
		}

		return validationResult;
	}

	private RexsValidationResult checkIfUniqueGearUnitIsPresent(RexsModel rexsModel) {
		RexsValidationResult validationResult = new RexsValidationResult();

		if (rexsModel.getComponentsOfType(RexsStandardComponentTypes.gear_unit).size()!=1)
			validationResult.addError(RexsValidationResultMessageKey.GUIDELINE_QUASISTATIC_INCONSISTENT_GEAR_UNIT);

		return validationResult;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IRexsRelationValidator createRelationValidator() {
		if (rexsVersion == null)
			return super.createRelationValidator();
		return new RexsModellingGuidelineQuasistaticRelationValidator(rexsVersion, dbModelRegistry);
	}
}
