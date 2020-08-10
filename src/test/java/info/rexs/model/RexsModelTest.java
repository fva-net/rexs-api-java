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
package info.rexs.model;

public class RexsModelTest {

	// TODO RexsModel(String applicationId, String applicationVersion)

	// TODO Model getRawModel()

	// TODO Collection<RexsComponent> getComponents()

	// TODO boolean hasComponent(Integer compId)

	// TODO RexsComponent getComponent(Integer compId)

	// TODO List<RexsRelation> getRelationsOfMainComp(Integer mainCompId)

	// TODO List<RexsRelation> getRelationsOfType(RelationType type)

	// TODO List<RexsComponent> getComponentsOfType(ComponentType componentType)

	// TODO int getOrderOfAssemblyRelationOf(Integer compId)

	// TODO int getOrderOfReferenceRelationOf(Integer compId)

	// TODO RexsRelation findFirstRelation(Integer compId, RelationRole role)

	// TODO RexsRelation getStageRelationFromStageId(Integer stageId)

	// TODO RexsComponent getGear1OfStage(Integer stageId)

	// TODO RexsComponent getGear2OfStage(Integer stageId)

	// TODO List<RexsComponent> getSubComponentsWithType(Integer mainCompId, ComponentType type)

	// TODO List<RexsComponent> getChildrenWithType(Integer mainCompId, ComponentType type)

	// TODO Set<RexsComponent> getAssociatedStageGearDataComponents(Integer compId)

	// TODO RexsComponent getStageFromStageGearData(Integer stageGearDataId)

	// TODO RexsComponent getGearFromStageGearData(RexsComponent stageGearData)

	// TODO RexsComponent getStageGearData(Integer stageId, Integer gearId)

	// TODO List<RexsComponent> getFlankGeometriesOfStage(Integer stageId)

	// TODO RexsComponent getFlankGeometry(Integer gearId, String flank)

	// TODO RexsComponent getGearCasing()

	// TODO RexsComponent getGearUnit()

	// TODO RexsComponent getMaterial(RexsComponent componentWithMaterial)

	// TODO RexsComponent getLubricant(RexsComponent componentWithLubricant)

	// TODO RexsComponent createComponent(ComponentType type, String name)

	// TODO boolean addCouplingRelation(RexsComponent relComp, RexsComponent firstPart, RexsComponent secondPart)

	// TODO boolean addSideRelation(RexsComponent relComp, RexsComponent innerPart, RexsComponent outerPart)

	// TODO boolean addConnectionRelation(RexsComponent side1, RexsComponent side2)

	// TODO boolean addStageRelation(RexsComponent stage, RexsComponent gear1, RexsComponent gear2)

	// TODO boolean addStageGearDataRelation(RexsComponent stage, RexsComponent gear, RexsComponent stageGearData)

	// TODO boolean addAssemblyRelation(RexsComponent mainComp, RexsComponent partComp)

	// TODO boolean addReferenceRelation(RexsComponent mainComp, RexsComponent referenced)

	// TODO boolean addOrderedReferenceRelation(RexsComponent mainComp, RexsComponent referenced, int order)

	// TODO boolean addFlankRelation(RexsComponent gear, RexsComponent flank1, RexsComponent flank2)

	// TODO boolean addOrderedAssemblyRelation(RexsComponent mainComp, RexsComponent partComp, int order)

	// TODO boolean isPlanetPin(RexsComponent rexsComponent)

	// TODO boolean isPlanetShaft(RexsComponent rexsComponent)

	// TODO boolean isPartOfPlanetaryStage(RexsComponent rexsComponent)

	// TODO List<RexsComponent> getStagesOfGear(RexsComponent gear)

	// TODO RexsComponent getParent(Integer subCompId, ComponentType typeOfParent)

	// TODO boolean hasParentOfType(Integer subCompId, ComponentType typeOfParent)

	// TODO RexsComponent getFinishingToolOfGear(RexsComponent gear)

	// TODO RexsComponent getShaftOfGear(RexsComponent gear)

	// TODO List<RexsSubModel> getLoadCases()

	// TODO RexsSubModel getAccumulation()

	// TODO void changeComponentId(RexsComponent component, Integer newId)

	// TODO void copyAttributesFromSubModelToMaster(RexsSubModel subModel)
}
