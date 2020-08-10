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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.Set;
import java.util.TimeZone;
import java.util.stream.Collectors;

import info.rexs.db.constants.ComponentType;
import info.rexs.db.constants.RelationRole;
import info.rexs.db.constants.RelationType;
import info.rexs.db.constants.Version;
import info.rexs.model.jaxb.Accumulation;
import info.rexs.model.jaxb.Component;
import info.rexs.model.jaxb.LoadSpectrum;
import info.rexs.model.jaxb.Model;
import info.rexs.model.jaxb.ObjectFactory;
import info.rexs.model.jaxb.Ref;
import info.rexs.model.jaxb.Relation;

/**
 * This class represents a REXS model.
 *
 * @author FVA GmbH
 */
public class RexsModel {

	/** Factory class to create new instances for the JAXB model. */
	private ObjectFactory objectFactory = new ObjectFactory();

	/** The representation of this model in the JAXB model. */
	private Model rawModel;

	/** All relations of the model as a {@link List} of {@link RexsRelation}. */
	private List<RexsRelation> relations;

	/** All load spectrums of the model as a {@link List} of {@link RexsLoadSpectrum}. */
	private List<RexsLoadSpectrum> loadSpectrums;

	/** An internal index with all components of the model for quick access. */
	private Map<Integer, RexsComponent> components;

	/** An internal index with all components of the component types in the model for quick access. */
	private Map<ComponentType, List<RexsComponent>> mapTypeToComponentId;

	/** An internal index with all relations of the component in the model for quick access. */
	private Map<Integer, List<RexsRelation>> mapMainCompToRelation;

	/** An internal index with all relations of the relation types in the model for quick access. */
	private Map<RelationType, List<RexsRelation>> mapTypeToRelation;

	/**
	 * Constructs a new {@link RexsModel} from scratch.
	 *
	 * @param applicationId
	 * 				Name of the application that created the REXS model, e.g. "FVA Workbench".
	 * @param applicationVersion
	 * 				Version of the application.
	 */
	public RexsModel(String applicationId, String applicationVersion) {
		this.rawModel = createEmptyRexsModel(applicationId, applicationVersion);
		initialize();
	}

	/**
	 * Constructs a new {@link RexsModel} for the given {@link Model}.
	 *
	 * @param model
	 * 				The representation of this model in the JAXB model.
	 */
	public RexsModel(Model model) {
		this.rawModel = model;
		initialize();
	}

	private void initialize() {
		List<Component> rawComponents = rawModel.getComponents().getComponent();
		List<Relation> rawRelations = rawModel.getRelations().getRelation();

		this.relations = new ArrayList<>();
		this.mapMainCompToRelation = new HashMap<>(rawRelations.size());
		this.mapTypeToRelation = new EnumMap<>(RelationType.class);

		for (Relation rawRelation : rawRelations) {
			RexsRelation relation = new RexsRelation(rawRelation);
			this.relations.add(relation);

			List<RexsRelation> relationsOfComp = this.mapMainCompToRelation.get(relation.getMainComponentId());
			if (relationsOfComp == null)
				relationsOfComp = new ArrayList<>();
			relationsOfComp.add(relation);
			this.mapMainCompToRelation.put(relation.getMainComponentId(), relationsOfComp);

			List<RexsRelation> relationsOfType = mapTypeToRelation.get(relation.getType());
			if (relationsOfType==null)
				relationsOfType = new ArrayList<>();
			relationsOfType.add(relation);
			this.mapTypeToRelation.put(relation.getType(), relationsOfType);
		}

		this.components = new HashMap<>(rawComponents.size());
		this.mapTypeToComponentId = new HashMap<>();

		for (Component rawComponent : rawComponents) {
			RexsComponent component = new RexsComponent(rawComponent);
			this.components.put(rawComponent.getId(), component);

			ComponentType componentType = ComponentType.findById(rawComponent.getType());
			List<RexsComponent> componentsOfType = this.mapTypeToComponentId.get(componentType);
			if (componentsOfType==null)
				componentsOfType = new ArrayList<>();
			componentsOfType.add(component);
			this.mapTypeToComponentId.put(componentType, componentsOfType);
		}

		this.loadSpectrums = new ArrayList<>();
		for (LoadSpectrum rawSpectrum : rawModel.getLoadSpectrum())
			this.loadSpectrums.add(new RexsLoadSpectrum(rawSpectrum));
	}

	private Model createEmptyRexsModel(String applicationId, String applicationVersion) {
		Model newRawModel = objectFactory.createModel();

		// set xml headers
		newRawModel.setVersion(Version.getLatest().getName());
		newRawModel.setDate(getISO8601Date());
		newRawModel.setApplicationId(applicationId);
		newRawModel.setApplicationVersion(applicationVersion);

		// leere Listen für Komponenten und Relationen anlegen
		newRawModel.setComponents(objectFactory.createComponents());
		newRawModel.setRelations(objectFactory.createRelations());

		return newRawModel;
	}

	private String getISO8601Date() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
		TimeZone tz = TimeZone.getDefault();
		df.setTimeZone(tz);
		return df.format(new Date());
	}

	/**
	 * @return
	 * 				The representation of this model in the JAXB model.
	 */
	public Model getRawModel() {
		return rawModel;
	}

	/**
	 * @return
	 * 				All components of the model as a {@link List} of {@link RexsComponent}.
	 */
	public Collection<RexsComponent> getComponents() {
		return components.values().stream().collect(Collectors.toList());
	}

	/**
	 * Checks on the ID of a component whether the model contains a corresponding component.
	 *
	 * @param compId
	 * 				The ID of the component as {@link Integer}.
	 *
	 * @return
	 * 				{@code true} if the model contains the component, otherwise {@code false}.
	 */
	public boolean hasComponent(Integer compId) {
		return components.containsKey(compId);
	}

	/**
	 * Returns the component of the sub-model for a numeric ID.
	 *
	 * @param compId
	 * 				The ID of the component as {@link Integer}.
	 *
	 * @return
	 * 				The component as {@link RexsComponent} or {@code null} if the sub-model does not contain a corresponding component.
	 */
	public RexsComponent getComponent(Integer compId) {
		return components.get(compId);
	}

	/**
	 * TODO Document me!
	 *
	 * @param mainCompId
	 * 				TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public List<RexsRelation> getRelationsOfMainComp(Integer mainCompId) {
		return mapMainCompToRelation.getOrDefault(mainCompId, Collections.emptyList());
	}

	/**
	 * TODO Document me!
	 *
	 * @param type
	 * 				TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public List<RexsRelation> getRelationsOfType(RelationType type) {
		return mapTypeToRelation.getOrDefault(type, Collections.emptyList());
	}

	/**
	 * TODO Document me!
	 *
	 * @param componentType
	 * 				TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public List<RexsComponent> getComponentsOfType(ComponentType componentType) {
		return mapTypeToComponentId.getOrDefault(componentType, Collections.emptyList());
	}

	/**
	 * TODO Document me!
	 *
	 * @param compId
	 * 				TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public int getOrderOfAssemblyRelationOf(Integer compId) {
		List<RexsRelation> orderedAssemblyRelations = getRelationsOfType(RelationType.ORDERED_ASSEMBLY);
		for (RexsRelation relation : orderedAssemblyRelations) {
			if (relation.hasComponent(compId)
					&& relation.findRoleByComponentId(compId) == RelationRole.PART)
				return relation.getOrder();
		}

		return -1;
	}

	/**
	 * TODO Document me!
	 *
	 * @param compId
	 * 				TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public int getOrderOfReferenceRelationOf(Integer compId) {
		List<RexsRelation> orderedReferenceRelations = getRelationsOfType(RelationType.ORDERED_REFERENCE);
		for (RexsRelation relation : orderedReferenceRelations) {
			if (relation.hasComponent(compId)
					&& relation.findRoleByComponentId(compId) == RelationRole.REFERENCED)
				return relation.getOrder();
		}

		return -1;
	}

	/**
	 * TODO Document me!
	 *
	 * @param compId
	 * 				TODO Document me!
	 * @param role
	 * 				TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public RexsRelation findFirstRelation(Integer compId, RelationRole role) {
		for (RexsRelation relaltion : relations) {
			if (relaltion.hasComponent(compId)
					&& role == relaltion.findRoleByComponentId(compId))
				return relaltion;
		}
		return null;
	}

	/**
	 * TODO Document me!
	 *
	 * @param stageId
	 * 				TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public RexsRelation getStageRelationFromStageId(Integer stageId) {
		for (RexsRelation relation : getRelationsOfMainComp(stageId)) {
			if (relation.getType() == RelationType.STAGE)
				return relation;
		}
		return null;
	}

	/**
	 * TODO Document me!
	 *
	 * @param stageId
	 * 				TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public RexsComponent getGear1OfStage(Integer stageId) {
		RexsRelation stageRel = getStageRelationFromStageId(stageId);
		return getComponent(stageRel.findComponentIdByRole(RelationRole.GEAR_1));
	}

	/**
	 * TODO Document me!
	 *
	 * @param stageId
	 * 				TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public RexsComponent getGear2OfStage(Integer stageId) {
		RexsRelation stageRel = getStageRelationFromStageId(stageId);
		return getComponent(stageRel.findComponentIdByRole(RelationRole.GEAR_2));
	}

//	/**
//	 * Finds all children of the desired type. If no such children exist, finds
//	 * all grand children of the desired type. If those do not exist either returns
//	 * an empty List.
//	 * Special case: if type==mainCompType returns mainComp
//	 * @param mainCompId
//	 * @param type
//	 * @return
//	 */
	/**
	 * TODO Document me!
	 *
	 * @param mainCompId
	 * 				TODO Document me!
	 * @param type
	 * 				TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public List<RexsComponent> getSubComponentsWithType(Integer mainCompId, ComponentType type) {
		RexsComponent mainComp = getComponent(mainCompId);
		if (mainComp.getType().equals(type))
			return Arrays.asList(mainComp);
		List<RexsComponent> subCompList = getChildrenWithType(mainCompId, type);
		if (subCompList.isEmpty())
			subCompList = getGrandChildrenWithType(mainCompId, type);
		return subCompList;
	}

	/**
	 * TODO Document me!
	 *
	 * @param mainCompId
	 * 				TODO Document me!
	 * @param type
	 * 				TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public List<RexsComponent> getChildrenWithType(Integer mainCompId, ComponentType type) {
		Set<RexsComponent> childrenWithType = new HashSet<>();
		for (RexsRelation relation : getRelationsOfMainComp(mainCompId)) {
			for (Integer subCompId : relation.getSubComponentIds()) {
				RexsComponent subComp = getComponent(subCompId);
				if (subComp.getType().equals(type))
					childrenWithType.add(subComp);
			}
		}
		if (type == ComponentType.stage_gear_data)
			childrenWithType.addAll(getAssociatedStageGearDataComponents(mainCompId));
		return childrenWithType.stream().sorted().collect(Collectors.toList());
	}

	/**
	 * TODO Document me!
	 *
	 * @param mainCompId
	 * 				TODO Document me!
	 * @param type
	 * 				TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	private List<RexsComponent> getGrandChildrenWithType(Integer mainCompId, ComponentType type) {
		Set<RexsComponent> grandChildrenWithType = new HashSet<>();
		for (RexsRelation relation : getRelationsOfMainComp(mainCompId)) {
			for (Integer subCompId : relation.getSubComponentIds()) {
				grandChildrenWithType.addAll(getChildrenWithType(subCompId, type));
			}
		}
		return new ArrayList<>(grandChildrenWithType);
	}

	/**
	 * TODO Document me!
	 *
	 * @param compId
	 * 				TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public Set<RexsComponent> getAssociatedStageGearDataComponents(Integer compId) {
		Set<RexsComponent> stageGearDataComps = new HashSet<>();
		for (RexsRelation relation : getRelationsOfType(RelationType.STAGE_GEAR_DATA)) {
			if (relation.hasComponent(compId)) {
				Integer stageGearDataId = relation.findComponentIdByRole(RelationRole.STAGE_GEAR_DATA);
				RexsComponent stageGearData = getComponent(stageGearDataId);
				stageGearDataComps.add(stageGearData);
			}
		}
		return stageGearDataComps;
	}

	/**
	 * TODO Document me!
	 *
	 * @param stageGearDataId
	 * 				TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public RexsComponent getStageFromStageGearData(Integer stageGearDataId) {
		for (RexsRelation relation : getRelationsOfType(RelationType.STAGE_GEAR_DATA)) {
			if (relation.hasComponent(stageGearDataId)) {
				Integer stageId = relation.findComponentIdByRole(RelationRole.STAGE);
				return getComponent(stageId);
			}
		}
		return null;
	}

	/**
	 * TODO Document me!
	 *
	 * @param stageGearData
	 * 				TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public RexsComponent getGearFromStageGearData(RexsComponent stageGearData) {
		for (RexsRelation relation : getRelationsOfType(RelationType.STAGE_GEAR_DATA)) {
			if (relation.hasComponent(stageGearData.getId())) {
				Integer gearId = relation.findComponentIdByRole(RelationRole.GEAR);
				return getComponent(gearId);
			}
		}
		return null;
	}

	/**
	 * TODO Document me!
	 *
	 * @param stageId
	 * 				TODO Document me!
	 * @param gearId
	 * 				TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public RexsComponent getStageGearData(Integer stageId, Integer gearId) {
		for (RexsRelation relation : getRelationsOfType(RelationType.STAGE_GEAR_DATA)) {
			if (relation.hasComponent(stageId) && relation.hasComponent(gearId)) {
				Integer stageGearDataId = relation.findComponentIdByRole(RelationRole.STAGE_GEAR_DATA);
				return getComponent(stageGearDataId);
			}
		}
		return null;
	}

	/**
	 * TODO Document me!
	 *
	 * @param stageId
	 * 				TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public List<RexsComponent> getFlankGeometriesOfStage(Integer stageId) {
		List<RexsComponent> compList = new ArrayList<>();
		RexsRelation stageRel = getStageRelationFromStageId(stageId);
		Integer gear1Id = stageRel.findComponentIdByRole(RelationRole.GEAR_1);
		Integer gear2Id = stageRel.findComponentIdByRole(RelationRole.GEAR_2);

		compList.addAll(getChildrenWithType(gear1Id, ComponentType.flank_geometry));
		compList.addAll(getChildrenWithType(gear2Id, ComponentType.flank_geometry));
		return compList;
	}

//	/**
//	 * Liefert zu einem Rad die linek oder rechte Flanke
//	 */
	/**
	 * TODO Document me!
	 *
	 * @param gearId
	 * 				TODO Document me!
	 * @param flank
	 * 				TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public RexsComponent getFlankGeometry(Integer gearId, String flank) {
		RexsComponent flankGeometry = null;
		for (RexsRelation relation : getRelationsOfMainComp(gearId)) {
			if (relation.getType() == RelationType.FLANK) {
				RelationRole role = RelationRole.valueOf(flank);
				Integer flankId = relation.findComponentIdByRole(role);
				flankGeometry = getComponent(flankId);
				break;
			}
		}
		return flankGeometry;
	}

	/**
	 * TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public RexsComponent getGearCasing() {
		List<RexsComponent> listOfCasings = getComponentsOfType(ComponentType.gear_casing);
		return listOfCasings.get(0); // TODO es darf genau ein Gehäuse geben
	}

	/**
	 * TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public RexsComponent getGearUnit() {
		List<RexsComponent> listOfGearUnits = getComponentsOfType(ComponentType.gear_unit);
		return listOfGearUnits.get(0); // TODO es darf genau eine Getriebeinheit geben
	}

	/**
	 * TODO Document me!
	 *
	 * @param componentWithMaterial
	 * 				TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public RexsComponent getMaterial(RexsComponent componentWithMaterial) {
		List<RexsComponent> materials = getSubComponentsWithType(componentWithMaterial.getId(), ComponentType.material);
		return materials.get(0);
	}

	/**
	 * TODO Document me!
	 *
	 * @param componentWithLubricant
	 * 				TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public RexsComponent getLubricant(RexsComponent componentWithLubricant) {
		List<RexsComponent> lubricants = getSubComponentsWithType(componentWithLubricant.getId(), ComponentType.lubricant);
		return lubricants.get(0);
	}

	/**
	 * TODO Document me!
	 *
	 * @param type
	 * 				TODO Document me!
	 * @param name
	 * 				TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public RexsComponent createComponent(ComponentType type, String name) {
		Integer id = getNextFreeComponentId();

		Component component = objectFactory.createComponent();
		component.setId(id);
		component.setType(type.getId());
		component.setName(name);

		RexsComponent rexsComponent = new RexsComponent(component);

		components.put(id, rexsComponent);
		rawModel.getComponents().getComponent().add(component);

		List<RexsComponent> componentsForType =
				mapTypeToComponentId.containsKey(type) ?
						mapTypeToComponentId.get(type) : new ArrayList<>();
		componentsForType.add(rexsComponent);
		mapTypeToComponentId.put(type, componentsForType);

		return rexsComponent;
	}

	/**
	 * TODO Document me!
	 *
	 * @param relComp
	 * 				TODO Document me!
	 * @param firstPart
	 * 				TODO Document me!
	 * @param secondPart
	 * 				TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public boolean addCouplingRelation(RexsComponent relComp, RexsComponent firstPart, RexsComponent secondPart) {
		if (!componentsExists(relComp, firstPart, secondPart))
			return false;

		Relation rexsRelation = createRexsRelationWithType(RelationType.COUPLING);

		rexsRelation.getRef().add(createRexsRefWithType(toRelationData(relComp), RelationRole.ASSEMBLY));
		rexsRelation.getRef().add(createRexsRefWithType(toRelationData(firstPart), RelationRole.SIDE_1));
		rexsRelation.getRef().add(createRexsRefWithType(toRelationData(secondPart), RelationRole.SIDE_2));

		addRelation(rexsRelation);
		return true;
	}

	/**
	 * TODO Document me!
	 *
	 * @param relComp
	 * 				TODO Document me!
	 * @param innerPart
	 * 				TODO Document me!
	 * @param outerPart
	 * 				TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public boolean addSideRelation(RexsComponent relComp, RexsComponent innerPart, RexsComponent outerPart) {
		if (!componentsExists(relComp, innerPart, outerPart))
			return false;

		Relation rexsRelation = createRexsRelationWithType(RelationType.SIDE);

		rexsRelation.getRef().add(createRexsRefWithType(toRelationData(relComp), RelationRole.ASSEMBLY));
		rexsRelation.getRef().add(createRexsRefWithType(toRelationData(innerPart), RelationRole.INNER_PART));
		rexsRelation.getRef().add(createRexsRefWithType(toRelationData(outerPart), RelationRole.OUTER_PART));

		addRelation(rexsRelation);
		return true;
	}

	/**
	 * TODO Document me!
	 *
	 * @param side1
	 * 				TODO Document me!
	 * @param side2
	 * 				TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public boolean addConnectionRelation(RexsComponent side1, RexsComponent side2) {
		if (!componentsExists(side1, side2))
			return false;

		Relation rexsRelation = createRexsRelationWithType(RelationType.CONNECTION);

		rexsRelation.getRef().add(createRexsRefWithType(toRelationData(side1), RelationRole.SIDE_1));
		rexsRelation.getRef().add(createRexsRefWithType(toRelationData(side2), RelationRole.SIDE_2));

		addRelation(rexsRelation);
		return true;
	}

	/**
	 * TODO Document me!
	 *
	 * @param stage
	 * 				TODO Document me!
	 * @param gear1
	 * 				TODO Document me!
	 * @param gear2
	 * 				TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public boolean addStageRelation(RexsComponent stage, RexsComponent gear1, RexsComponent gear2) {
		if (!componentsExists(stage, gear1, gear2))
			return false;

		Relation rexsRelation = createRexsRelationWithType(RelationType.STAGE);

		rexsRelation.getRef().add(createRexsRefWithType(toRelationData(stage), RelationRole.STAGE));
		rexsRelation.getRef().add(createRexsRefWithType(toRelationData(gear1), RelationRole.GEAR_1));
		rexsRelation.getRef().add(createRexsRefWithType(toRelationData(gear2), RelationRole.GEAR_2));

		addRelation(rexsRelation);
		return true;
	}

	/**
	 * TODO Document me!
	 *
	 * @param stage
	 * 				TODO Document me!
	 * @param gear
	 * 				TODO Document me!
	 * @param stageGearData
	 * 				TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public boolean addStageGearDataRelation(RexsComponent stage, RexsComponent gear, RexsComponent stageGearData) {
		if (!componentsExists(stage, gear, stageGearData))
			return false;

		Relation rexsRelation = createRexsRelationWithType(RelationType.STAGE_GEAR_DATA);

		rexsRelation.getRef().add(createRexsRefWithType(toRelationData(stage), RelationRole.STAGE));
		rexsRelation.getRef().add(createRexsRefWithType(toRelationData(gear), RelationRole.GEAR));
		rexsRelation.getRef().add(createRexsRefWithType(toRelationData(stageGearData), RelationRole.STAGE_GEAR_DATA));

		addRelation(rexsRelation);
		return true;
	}

	/**
	 * TODO Document me!
	 *
	 * @param mainComp
	 * 				TODO Document me!
	 * @param partComp
	 * 				TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public boolean addAssemblyRelation(RexsComponent mainComp, RexsComponent partComp) {
		if (!componentsExists(mainComp, partComp))
			return false;

		Relation rexsRelation = createRexsRelationWithType(RelationType.ASSEMBLY);

		rexsRelation.getRef().add(createRexsRefWithType(toRelationData(mainComp), RelationRole.ASSEMBLY));
		rexsRelation.getRef().add(createRexsRefWithType(toRelationData(partComp), RelationRole.PART));

		addRelation(rexsRelation);
		return true;
	}

	/**
	 * TODO Document me!
	 *
	 * @param mainComp
	 * 				TODO Document me!
	 * @param referenced
	 * 				TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public boolean addReferenceRelation(RexsComponent mainComp, RexsComponent referenced) {
		if (!componentsExists(mainComp, referenced))
			return false;

		Relation rexsRelation = createRexsRelationWithType(RelationType.REFERENCE);

		rexsRelation.getRef().add(createRexsRefWithType(toRelationData(mainComp), RelationRole.ORIGIN));
		rexsRelation.getRef().add(createRexsRefWithType(toRelationData(referenced), RelationRole.REFERENCED));

		addRelation(rexsRelation);
		return true;
	}

	/**
	 * TODO Document me!
	 *
	 * @param mainComp
	 * 				TODO Document me!
	 * @param referenced
	 * 				TODO Document me!
	 * @param order
	 * 				TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public boolean addOrderedReferenceRelation(RexsComponent mainComp, RexsComponent referenced, int order) {
		if (!componentsExists(mainComp, referenced))
			return false;

		Relation rexsRelation = createRexsRelationWithType(RelationType.ORDERED_REFERENCE);
		rexsRelation.setOrder(order);

		rexsRelation.getRef().add(createRexsRefWithType(toRelationData(mainComp), RelationRole.ORIGIN));
		rexsRelation.getRef().add(createRexsRefWithType(toRelationData(referenced), RelationRole.REFERENCED));

		addRelation(rexsRelation);
		return true;
	}

	/**
	 * TODO Document me!
	 *
	 * @param gear
	 * 				TODO Document me!
	 * @param flank1
	 * 				TODO Document me!
	 * @param flank2
	 * 				TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public boolean addFlankRelation(RexsComponent gear, RexsComponent flank1, RexsComponent flank2) {
		if (!componentsExists(gear, flank1, flank2))
			return false;

		Relation rexsRelation = createRexsRelationWithType(RelationType.FLANK);

		rexsRelation.getRef().add(createRexsRefWithType(toRelationData(gear), RelationRole.GEAR));
		rexsRelation.getRef().add(createRexsRefWithType(toRelationData(flank1), RelationRole.LEFT));
		rexsRelation.getRef().add(createRexsRefWithType(toRelationData(flank2), RelationRole.RIGHT));

		addRelation(rexsRelation);
		return true;
	}

	/**
	 * TODO Document me!
	 *
	 * @param mainComp
	 * 				TODO Document me!
	 * @param partComp
	 * 				TODO Document me!
	 * @param order
	 * 				TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public boolean addOrderedAssemblyRelation(RexsComponent mainComp, RexsComponent partComp, int order) {
		if (!componentsExists(mainComp, partComp))
			return false;

		Relation rexsRelation = createRexsRelationWithType(RelationType.ORDERED_ASSEMBLY);
		rexsRelation.setOrder(order);

		rexsRelation.getRef().add(createRexsRefWithType(toRelationData(mainComp), RelationRole.ASSEMBLY));
		rexsRelation.getRef().add(createRexsRefWithType(toRelationData(partComp), RelationRole.PART));

		addRelation(rexsRelation);
		return true;
	}

	private Relation createRexsRelationWithType(RelationType type) {
		Relation rexsRelation = objectFactory.createRelation();
		rexsRelation.setId(getNextFreeRelationId());
		rexsRelation.setType(type.getKey());
		return rexsRelation;
	}

	private Ref createRexsRefWithType(RexsRelationData data, RelationRole role) {
		Ref ref = objectFactory.createRef();
		ref.setId(data.getId());
		ref.setRole(role.getKey());
		ref.setHint(data.getHint());
		return ref;
	}

	private RexsRelationData toRelationData(RexsComponent rexsComponent) {
		return new RexsRelationData(rexsComponent.getId(), rexsComponent.getType().getId());
	}

	private void addRelation(Relation relation) {
		RexsRelation rexsRelation =  new RexsRelation(relation);

		relations.add(rexsRelation);
		rawModel.getRelations().getRelation().add(relation);

		List<RexsRelation> relationsForType =
				mapTypeToRelation.containsKey(rexsRelation.getType()) ?
						mapTypeToRelation.get(rexsRelation.getType()) : new ArrayList<>();
		relationsForType.add(rexsRelation);
		mapTypeToRelation.put(rexsRelation.getType(), relationsForType);

		List<RexsRelation> relationsForMainComp =
				mapMainCompToRelation.containsKey(rexsRelation.getMainComponentId()) ?
						mapMainCompToRelation.get(rexsRelation.getMainComponentId()) : new ArrayList<>();
		relationsForMainComp.add(rexsRelation);
		mapMainCompToRelation.put(rexsRelation.getMainComponentId(), relationsForMainComp);
	}

	private boolean componentsExists(RexsComponent ... rexsComponents) {
		if (rexsComponents == null)
			return false;

		for (RexsComponent rexsComponent : rexsComponents) {
			if (!hasComponent(rexsComponent.getId()))
				return false;
		}
		return true;
	}

	/**
	 * TODO Document me!
	 *
	 * @param rexsComponent
	 * 				TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public boolean isPlanetPin(RexsComponent rexsComponent) {
		for (RexsRelation planetPinRel : getRelationsOfType(RelationType.PLANET_PIN)) {
			Integer shaftId = planetPinRel.findComponentIdByRole(RelationRole.SHAFT);
			if (rexsComponent.getId().equals(shaftId))
				return true;
		}
		return false;
	}

	/**
	 * TODO Document me!
	 *
	 * @param rexsComponent
	 * 				TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public boolean isPlanetShaft(RexsComponent rexsComponent) {
		for (RexsRelation planetShaftRel : getRelationsOfType(RelationType.PLANET_SHAFT)) {
			Integer shaftId = planetShaftRel.findComponentIdByRole(RelationRole.SHAFT);
			if (rexsComponent.getId().equals(shaftId))
				return true;
		}
		return false;
	}

	/**
	 * TODO Document me!
	 *
	 * @param rexsComponent
	 * 				TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public boolean isPartOfPlanetaryStage(RexsComponent rexsComponent) {
		Integer componentId = rexsComponent.getId();
		ComponentType componentType = rexsComponent.getType();

		if (ComponentType.cylindrical_stage.getId().equals(componentType.getId())
				|| ComponentType.shaft.getId().equals(componentType.getId())) {
			for (RexsComponent planetaryStage : getComponentsOfType(ComponentType.planetary_stage)) {
				for (RexsRelation relation : getRelationsOfMainComp(planetaryStage.getId())) {
					if (componentId.equals(relation.findComponentIdByRole(RelationRole.PART)))
						return true;
				}
			}
			return false;

		} else if (ComponentType.cylindrical_gear.getId().equals(componentType.getId())
				|| ComponentType.ring_gear.getId().equals(componentType.getId())) {
			for (RexsComponent stage : getStagesOfGear(rexsComponent)) {
				if (isPartOfPlanetaryStage(stage))
					return true;
			}
			return false;

		} else if (ComponentType.side_plate.getId().equals(componentType.getId())
				|| ComponentType.planet_carrier.getId().equals(componentType.getId())) {
			return true;

		} else if (ComponentType.concept_bearing.getId().equals(componentType.getId())
				|| ComponentType.coupling.getId().equals(componentType.getId())) {
			for (RexsRelation relation : getRelationsOfMainComp(rexsComponent.getId())) {
				if (relation.getType()==RelationType.SIDE) {
					RexsComponent sideComp1 = getComponent(relation.findComponentIdByRole(RelationRole.SIDE_1));
					RexsComponent sideComp2 = getComponent(relation.findComponentIdByRole(RelationRole.SIDE_2));
					if (isPartOfPlanetaryStage(sideComp1) && isPartOfPlanetaryStage(sideComp2))
						return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}

	/**
	 * TODO Document me!
	 *
	 * @param gear
	 * 				TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public List<RexsComponent> getStagesOfGear(RexsComponent gear) {
		ComponentType gearType = gear.getType();
		ComponentType stageType = null;

		if (ComponentType.cylindrical_gear.getId().equals(gearType.getId())
				|| ComponentType.ring_gear.getId().equals(gearType.getId())) {
			stageType = ComponentType.cylindrical_stage;
		} else if (ComponentType.bevel_gear.getId().equals(gearType.getId())) {
			stageType = ComponentType.bevel_stage;
		}

		if (stageType == null)
			return Collections.emptyList();

		List<RexsComponent> stages = new ArrayList<>();
		for (RexsComponent stage : getComponentsOfType(stageType)) {
			if (getSubComponentsWithType(stage.getId(), gear.getType()).contains(gear))
				stages.add(stage);
		}
		return stages;
	}

	/**
	 * TODO Document me!
	 *
	 * @param subCompId
	 * 				TODO Document me!
	 * @param typeOfParent
	 * 				TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public RexsComponent getParent(Integer subCompId, ComponentType typeOfParent) {
		RexsComponent parent = null;
		for (RexsComponent potentialParent : getComponentsOfType(typeOfParent)) {
			for (RexsRelation relation : getRelationsOfMainComp(potentialParent.getId())) {
				if (relation.getType() == RelationType.ASSEMBLY
						&& subCompId.equals(relation.findComponentIdByRole(RelationRole.PART))) {
					if (parent == null)
						parent = potentialParent;
					else
						return null; // non-unique parent!
				}
			}
		}
		return parent;
	}

	/**
	 * TODO Document me!
	 *
	 * @param subCompId
	 * 				TODO Document me!
	 * @param typeOfParent
	 * 				TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public boolean hasParentOfType(Integer subCompId, ComponentType typeOfParent) {
		return getParent(subCompId, typeOfParent) != null;
	}

	private Integer getNextFreeComponentId() {
		OptionalInt max = components.keySet().stream().mapToInt(Integer::intValue).max();
		if (max.isPresent())
			return max.getAsInt() + 1;
		return 1;
	}

	private Integer getNextFreeRelationId() {
		OptionalInt max = relations.stream().mapToInt(relation -> relation.getId().intValue()).max();
		if (max.isPresent())
			return max.getAsInt() + 1;
		return 1;
	}

	/**
	 * TODO Document me!
	 *
	 * @param gear
	 * 				TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public RexsComponent getFinishingToolOfGear(RexsComponent gear) {
		List<RexsRelation> relationsOfGear = getRelationsOfMainComp(gear.getId());
		int highestOrder = 0;
		RexsComponent finishingTool = null;
		for (RexsRelation relation : relationsOfGear) {
			if (relation.getType() == RelationType.ORDERED_REFERENCE) {
				int order = relation.getOrder();
				if (order >= highestOrder) {
					highestOrder = order;
					finishingTool = getComponent(relation.findComponentIdByRole(RelationRole.REFERENCED));
				}
			}
		}
		return finishingTool;
	}

	/**
	 * TODO Document me!
	 *
	 * @param gear
	 * 				TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public RexsComponent getShaftOfGear(RexsComponent gear) {
		return getParent(gear.getId(), ComponentType.shaft);
	}

	/**
	 * TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public List<RexsSubModel> getLoadCases() {
		if (loadSpectrums.isEmpty())
			return new ArrayList<>();

		List<RexsSubModel> loadCases = loadSpectrums.get(0).getLoadCases();
		Collections.sort(loadCases);
		return loadCases;
	}

	/**
	 * TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public RexsSubModel getAccumulation() {
		if (loadSpectrums.isEmpty()) {
			Accumulation empty = null;
			return new RexsSubModel(empty);
		}
		return loadSpectrums.get(0).getAccumulation();
	}

	/**
	 * Changes the numerical ID of a component.
	 * <p>
	 * ATTENTION: Make sure that the new ID has not already been assigned to another component.
	 *
	 * @param component
	 * 				The component of the REXS model whose ID is to be changed.
	 * @param newId
	 * 				The new numeric ID of the component within the REXS model.
	 */
	public void changeComponentId(RexsComponent component, Integer newId) {
		Integer oldId = component.getId();
		component.changeComponentId(newId);

		components.remove(oldId);
		components.put(newId, component);

		for (RexsRelation relation : relations) {
			if (relation.hasComponent(oldId))
				relation.changeComponentId(oldId, newId);
		}

		List<RexsRelation> mainrelations = mapMainCompToRelation.get(oldId);
		mapMainCompToRelation.put(newId, mainrelations);
		mapMainCompToRelation.remove(oldId);

		for (RexsLoadSpectrum loadSpectrum : loadSpectrums) {
			for (RexsSubModel subModel : loadSpectrum.getLoadCases()) {
				subModel.changeComponentId(oldId, newId);
			}
			loadSpectrum.getAccumulation().changeComponentId(oldId, newId);
		}
	}

	/**
	 * TODO Document me!
	 *
	 * @param subModel
	 * 				TODO Document me!
	 */
	public void copyAttributesFromSubModelToMaster(RexsSubModel subModel) {
		for (RexsComponent masterComp : this.getComponents()) {
			if (!subModel.hasComponent(masterComp.getId()))
				continue;
			RexsComponent subModelComp = subModel.getComponent(masterComp.getId());
			for (RexsAttribute attribute : subModelComp.getAttributes()) {
				masterComp.addAttribute(attribute);
			}
		}
	}
}
