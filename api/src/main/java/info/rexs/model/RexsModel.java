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
package info.rexs.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.Collectors;

import info.rexs.schema.constants.RexsComponentType;
import info.rexs.schema.constants.RexsRelationRole;
import info.rexs.schema.constants.RexsRelationType;
import info.rexs.schema.constants.RexsVersion;
import info.rexs.schema.constants.standard.RexsStandardAttributeIds;
import info.rexs.schema.constants.standard.RexsStandardComponentTypes;
import info.rexs.schema.constants.standard.RexsStandardRelationRoles;
import info.rexs.schema.constants.standard.RexsStandardRelationTypes;

/**
 * This class represents a REXS model.
 *
 * @author FVA GmbH
 */
public class RexsModel {

	/** The version of the REXS model. */
	private RexsVersion version;

	/** The origin version of the REXS model */
	private String originVersion;

	/** Name of the application that created the REXS model, e.g. "FVA Workbench". */
	private String applicationId;

	/** Version of the application. */
	private String applicationVersion;

	/** All relations of the model as a {@link List} of {@link RexsRelation}. */
	protected List<RexsRelation> relations = new ArrayList<>();

	/** All load spectrums of the model as a {@link List} of {@link RexsLoadSpectrum}. */
	protected List<RexsLoadSpectrum> loadSpectrums = new ArrayList<>();

	/** An internal index with all components of the model for quick access. */
	private Map<Integer, RexsComponent> components = new HashMap<>();

	/** An internal index with all components of the component types in the model for quick access. */
	private Map<RexsComponentType, List<RexsComponent>> mapTypeToComponent = new HashMap<>();

	/** An internal index with all relations of the component in the model for quick access. */
	private Map<Integer, List<RexsRelation>> mapMainCompToRelation = new HashMap<>();

	/** An internal index with all relations of the relation types in the model for quick access. */
	private Map<RexsRelationType, List<RexsRelation>> mapTypeToRelation = new HashMap<>();

	/**
	 * Constructs a new {@link RexsModel} from scratch.
	 *
	 * @param version
	 * 				The version of the REXS model as a{@link String}.
	 * @param applicationId
	 * 				Name of the application that created the REXS model, e.g. "FVA Workbench".
	 * @param applicationVersion
	 * 				Version of the application.
	 */
	public RexsModel(String version, String applicationId, String applicationVersion) {
		this.version = RexsVersion.findByModelVersion(version);
		this.originVersion = version;
		this.applicationId = applicationId;
		this.applicationVersion = applicationVersion;
	}

	/** Copy constructor. Creates a deep copy of the model */
	public RexsModel(RexsModel model) {
		this.version = model.getVersion();
		this.originVersion = model.getOriginVersion();
		this.applicationId = model.applicationId;
		this.applicationVersion = model.applicationVersion;

		for (RexsRelation relation : model.getRelations()) {
			RexsRelation newRelation = new RexsRelation(relation);
			this.addRelation(newRelation);
		}
		for (RexsComponent component: model.getComponents()) {
			RexsComponent newComponent = new RexsComponent(component);
			this.addComponent(newComponent);
		}
	}

	/**
	 * Constructs a new {@link RexsModel} for the given properties.
	 *
	 * @param version
	 * 				The version of the REXS model as a{@link RexsVersion}.
	 * @param applicationId
	 * 				Name of the application that created the REXS model, e.g. "FVA Workbench".
	 * @param applicationVersion
	 * 				Version of the application.
	 */
	protected RexsModel(RexsVersion version, String applicationId, String applicationVersion) {
		this.version = version;
		this.originVersion = version.getModelVersion();
		this.applicationId = applicationId;
		this.applicationVersion = applicationVersion;
	}

	/**
	 * @return
	 * 				The version of the REXS model as a {@link RexsVersion}.
	 */
	public RexsVersion getVersion() {
		return version;
	}

	public void setVersion(RexsVersion version) {
		this.version = version;
	}

	/**
	 * @return
	 * 				The origin version of the REXS model as a {@link String}.
	 */
	public String getOriginVersion() {
		return originVersion;
	}

	/**
	 * @return
	 * 				The name of the application that created the REXS model as a {@link String}.
	 */
	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	/**
	 * @return
	 * 				The version of the application as a {@link String}.
	 */
	public String getApplicationVersion() {
		return applicationVersion;
	}

	/**
	 * @return
	 * 				All components of the model as a {@link List} of {@link RexsComponent}.
	 */
	public List<RexsComponent> getComponents() {
		return components.values().stream().collect(Collectors.toList());
	}

	/**
	 * @return
	 * 				All components of the model as a {@link List} of {@link RexsComponent} sorted by component Id.
	 */
	public List<RexsComponent> getComponentsSorted() {
		return components.keySet().stream().sorted().map(id -> getComponent(id)).collect(Collectors.toList());
	}

	/**
	 * @return
	 * 				All relations of the model as a {@link List} of {@link RexsRelation}.
	 */
	public List<RexsRelation> getRelations() {
		return relations;
	}

	/**
	 * @return
	 * 				All load spectrums of the model as a {@link List} of {@link RexsLoadSpectrum}.
	 */
	public List<RexsLoadSpectrum> getLoadSpectrums() {
		return loadSpectrums;
	}

	/**
	 * Adds a load spectrum to the REXS model.
	 *
	 * @param loadSpectrum
	 * 				The additional load spectrum as a {@link RexsLoadSpectrum}.
	 */
	public void addLoadSpectrum(RexsLoadSpectrum loadSpectrum) {
		this.loadSpectrums.add(loadSpectrum);
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
		return mapMainCompToRelation.getOrDefault(mainCompId, new ArrayList<>());
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
	public List<RexsRelation> getRelationsOfType(RexsRelationType type) {
		return mapTypeToRelation.getOrDefault(type, new ArrayList<>());
	}

	// TODO document
	public List<RexsRelation> getRelations(RexsRelationType type, RexsRelationRole role, int component) {
		return relations.stream()
				.filter(rel -> rel.getType()==type && rel.findComponentIdByRole(role) == component)
				.toList();
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
	public List<RexsComponent> getComponentsOfType(RexsComponentType componentType) {
		return mapTypeToComponent.getOrDefault(componentType, new ArrayList<>());
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
		List<RexsRelation> orderedAssemblyRelations = getRelationsOfType(RexsStandardRelationTypes.ordered_assembly);
		for (RexsRelation relation : orderedAssemblyRelations) {
			if (relation.hasComponent(compId)
					&& relation.findRoleByComponentId(compId).equals(RexsStandardRelationRoles.part))
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
		List<RexsRelation> orderedReferenceRelations = getRelationsOfType(RexsStandardRelationTypes.ordered_reference);
		for (RexsRelation relation : orderedReferenceRelations) {
			if (relation.hasComponent(compId)
					&& relation.findRoleByComponentId(compId).equals(RexsStandardRelationRoles.referenced))
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
	public RexsRelation findFirstRelation(Integer compId, RexsRelationRole role) {
		for (RexsRelation relaltion : relations) {
			if (relaltion.hasComponent(compId)
					&& role.equals(relaltion.findRoleByComponentId(compId)))
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
			if (relation.getType().equals(RexsStandardRelationTypes.stage))
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
		return getComponent(stageRel.findComponentIdByRole(RexsStandardRelationRoles.gear_1));
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
		return getComponent(stageRel.findComponentIdByRole(RexsStandardRelationRoles.gear_2));
	}

	/**
	 * Finds all children of the desired type. If no such children exist, finds
	 * all grand children of the desired type. If those do not exist either returns
	 * an empty List.
	 * Special case: if type==mainCompType returns mainComp
	 * @param mainCompId
	 * @param type
	 * @return
	 */
	public List<RexsComponent> getSubComponentsWithType(Integer mainCompId, RexsComponentType type) {
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
	public List<RexsComponent> getChildrenWithType(Integer mainCompId, RexsComponentType type) {
		Set<RexsComponent> childrenWithType = new HashSet<>();
		for (RexsRelation relation : getRelationsOfMainComp(mainCompId)) {
			for (Integer subCompId : relation.getSubComponentIds()) {
				RexsComponent subComp = getComponent(subCompId);
				if (subComp.getType().equals(type))
					childrenWithType.add(subComp);
			}
		}
		if (type == RexsStandardComponentTypes.stage_gear_data)
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
	private List<RexsComponent> getGrandChildrenWithType(Integer mainCompId, RexsComponentType type) {
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
		for (RexsRelation relation : getRelationsOfType(RexsStandardRelationTypes.stage_gear_data)) {
			if (relation.hasComponent(compId)) {
				Integer stageGearDataId = relation.findComponentIdByRole(RexsStandardRelationRoles.stage_gear_data);
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
		for (RexsRelation relation : getRelationsOfType(RexsStandardRelationTypes.stage_gear_data)) {
			if (relation.hasComponent(stageGearDataId)) {
				Integer stageId = relation.findComponentIdByRole(RexsStandardRelationRoles.stage);
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
		for (RexsRelation relation : getRelationsOfType(RexsStandardRelationTypes.stage_gear_data)) {
			if (relation.hasComponent(stageGearData.getId())) {
				Integer gearId = relation.findComponentIdByRole(RexsStandardRelationRoles.gear);
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
		for (RexsRelation relation : getRelationsOfType(RexsStandardRelationTypes.stage_gear_data)) {
			if (relation.hasComponent(stageId) && relation.hasComponent(gearId)) {
				Integer stageGearDataId = relation.findComponentIdByRole(RexsStandardRelationRoles.stage_gear_data);
				return getComponent(stageGearDataId);
			}
		}
		return null;
	}

	public RexsComponent getBearingRowWithOrder(RexsComponent bearing, int order) {
		List<RexsComponent> subComps = getSubComponentsWithType(bearing.getId(), RexsStandardComponentTypes.rolling_bearing_row);
		for (RexsComponent row : subComps) {
			int orderOfRow = getOrderOfAssemblyRelationOf(row.getId());
			if (order==orderOfRow)
				return row;
		}
		String message = "No bearing row with desired order found for bearing "+bearing.getName()+" with Id "+bearing.getId();
		throw new RexsModelAccessException(message);
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
		Integer gear1Id = stageRel.findComponentIdByRole(RexsStandardRelationRoles.gear_1);
		Integer gear2Id = stageRel.findComponentIdByRole(RexsStandardRelationRoles.gear_2);

		compList.add(getFlankGeometry(gear1Id, RexsStandardRelationRoles.left.getKey()));
		compList.add(getFlankGeometry(gear1Id, RexsStandardRelationRoles.right.getKey()));
		compList.add(getFlankGeometry(gear2Id, RexsStandardRelationRoles.left.getKey()));
		compList.add(getFlankGeometry(gear2Id, RexsStandardRelationRoles.right.getKey()));

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
			if (relation.getType().equals(RexsStandardRelationTypes.flank)) {
				RexsRelationRole role = RexsRelationRole.findByKey(flank);
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
	public RexsComponent getGearUnit() {
		List<RexsComponent> listOfGearUnits = getComponentsOfType(RexsComponentType.gear_unit);
		if (listOfGearUnits.size() != 1)
			throw new RexsModelAccessException("there has to be exactly one gear_unit component in the model!");
		return listOfGearUnits.get(0);
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
		List<RexsComponent> materials = getSubComponentsWithType(componentWithMaterial.getId(), RexsStandardComponentTypes.material);
		if (materials == null || materials.isEmpty())
			return null;
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
		List<RexsComponent> lubricants = getSubComponentsWithType(componentWithLubricant.getId(), RexsStandardComponentTypes.lubricant);
		if (lubricants == null || lubricants.isEmpty())
			return null;
		return lubricants.get(0);
	}

	/**
	 * TODO Document me!
	 *
	 * @param type
	 * 				TODO Document me!
	 * @param id
	 * 				TODO Document me!
	 * @param name
	 * 				TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public RexsComponent createComponent(RexsComponentType type, Integer id, String name) {
		if (components.containsKey(id))
			throw new RexsModelAccessException("component with id " + id + " already exists");

		RexsComponent rexsComponent = RexsModelObjectFactory.getInstance().createRexsComponent(id, type, name);

		addComponent(rexsComponent);

		return rexsComponent;
	}

	/**
	 * Adds a component to the REXS model.
	 *
	 * @param component
	 * 				The additional component as a {@link RexsComponent}.
	 */
	public void addComponent(RexsComponent component) {
		components.put(component.getId(), component);

		List<RexsComponent> componentsForType =
				mapTypeToComponent.containsKey(component.getType()) ?
						mapTypeToComponent.get(component.getType()) : new ArrayList<>();
		componentsForType.add(component);
		mapTypeToComponent.put(component.getType(), componentsForType);
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
	public RexsComponent createComponent(RexsComponentType type, String name) {
		Integer id = getNextFreeComponentId();
		return createComponent(type, id, name);
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

		RexsRelation relation = createRelation(RexsStandardRelationTypes.coupling, null);

		relation.addRef(createRelationRef(relComp, RexsStandardRelationRoles.assembly));
		relation.addRef(createRelationRef(firstPart, RexsStandardRelationRoles.side_1));
		relation.addRef(createRelationRef(secondPart, RexsStandardRelationRoles.side_2));

		addRelation(relation);
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

		RexsRelation relation = createRelation(RexsStandardRelationTypes.side, null);

		relation.addRef(createRelationRef(relComp, RexsStandardRelationRoles.assembly));
		relation.addRef(createRelationRef(innerPart, RexsStandardRelationRoles.inner_part));
		relation.addRef(createRelationRef(outerPart, RexsStandardRelationRoles.outer_part));

		addRelation(relation);
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

		RexsRelation relation = createRelation(RexsStandardRelationTypes.connection, null);

		relation.addRef(createRelationRef(side1, RexsStandardRelationRoles.side_1));
		relation.addRef(createRelationRef(side2, RexsStandardRelationRoles.side_2));

		addRelation(relation);
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

		RexsRelation relation = createRelation(RexsStandardRelationTypes.stage, null);

		relation.addRef(createRelationRef(stage, RexsStandardRelationRoles.stage));
		relation.addRef(createRelationRef(gear1, RexsStandardRelationRoles.gear_1));
		relation.addRef(createRelationRef(gear2, RexsStandardRelationRoles.gear_2));

		addRelation(relation);
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

		RexsRelation relation = createRelation(RexsStandardRelationTypes.stage_gear_data, null);

		relation.addRef(createRelationRef(stage, RexsStandardRelationRoles.stage));
		relation.addRef(createRelationRef(gear, RexsStandardRelationRoles.gear));
		relation.addRef(createRelationRef(stageGearData, RexsStandardRelationRoles.stage_gear_data));

		addRelation(relation);
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

		RexsRelation relation = createRelation(RexsStandardRelationTypes.assembly, null);

		relation.addRef(createRelationRef(mainComp, RexsStandardRelationRoles.assembly));
		relation.addRef(createRelationRef(partComp, RexsStandardRelationRoles.part));

		addRelation(relation);
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

		RexsRelation relation = createRelation(RexsStandardRelationTypes.reference, null);

		relation.addRef(createRelationRef(mainComp, RexsStandardRelationRoles.origin));
		relation.addRef(createRelationRef(referenced, RexsStandardRelationRoles.referenced));

		addRelation(relation);
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

		RexsRelation relation = createRelation(RexsStandardRelationTypes.ordered_reference, order);

		relation.addRef(createRelationRef(mainComp, RexsStandardRelationRoles.origin));
		relation.addRef(createRelationRef(referenced, RexsStandardRelationRoles.referenced));

		addRelation(relation);
		return true;
	}

	/**
	 * TODO Document me!
	 *
	 * @param planetaryStage
	 * 				TODO Document me!
	 * @param planetPinShaft
	 * 				TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public boolean addPlanetPinRelation(RexsComponent planetaryStage, RexsComponent planetPinShaft) {
		if (!componentsExists(planetaryStage, planetPinShaft))
			return false;

		RexsRelation relation = createRelation(RexsStandardRelationTypes.planet_pin, null);

		relation.addRef(createRelationRef(planetaryStage, RexsStandardRelationRoles.planetary_stage));
		relation.addRef(createRelationRef(planetPinShaft, RexsStandardRelationRoles.shaft));

		addRelation(relation);
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

		RexsRelation relation = createRelation(RexsStandardRelationTypes.flank, null);

		relation.addRef(createRelationRef(gear, RexsStandardRelationRoles.gear));
		relation.addRef(createRelationRef(flank1, RexsStandardRelationRoles.left));
		relation.addRef(createRelationRef(flank2, RexsStandardRelationRoles.right));

		addRelation(relation);
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

		RexsRelation relation = createRelation(RexsStandardRelationTypes.ordered_assembly, order);

		relation.addRef(createRelationRef(mainComp, RexsStandardRelationRoles.assembly));
		relation.addRef(createRelationRef(partComp, RexsStandardRelationRoles.part));

		addRelation(relation);
		return true;
	}

	/**
	 * TODO Document me!
	 *
	 * @param flank
	 * 				TODO Document me!
	 * @param tool
	 * 				TODO Document me!
	 * @param manufacturingStep
	 * 				TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public boolean addManufacturingStepRelation(RexsComponent flank, RexsComponent tool, RexsComponent manufacturingStep, int order) {
		if (!componentsExists(flank, tool, manufacturingStep))
			return false;

		RexsRelation relation = createRelation(RexsStandardRelationTypes.manufacturing_step, order);

		relation.addRef(createRelationRef(flank, RexsStandardRelationRoles.workpiece));
		relation.addRef(createRelationRef(tool, RexsStandardRelationRoles.tool));
		relation.addRef(createRelationRef(manufacturingStep, RexsStandardRelationRoles.manufacturing_settings));

		addRelation(relation);
		return true;
	}

	private RexsRelation createRelation(RexsRelationType type, Integer order) {
		Integer id = getNextFreeRelationId();
		return RexsModelObjectFactory.getInstance().createRexsRelation(id, type, order);
	}

	private RexsRelationRef createRelationRef(RexsComponent component, RexsRelationRole role) {
		return RexsModelObjectFactory.getInstance().createRexsRelationRef(component.getId(), role, component.getType().getId());
	}

	public void addRelation(RexsRelation relation) {
		relations.add(relation);

		List<RexsRelation> relationsForType = mapTypeToRelation.getOrDefault(relation.getType(), new ArrayList<>());
		relationsForType.add(relation);
		mapTypeToRelation.put(relation.getType(), relationsForType);

		List<RexsRelation> relationsForMainComp = mapMainCompToRelation.getOrDefault(relation.getMainComponentId(), new ArrayList<>());
		relationsForMainComp.add(relation);
		mapMainCompToRelation.put(relation.getMainComponentId(), relationsForMainComp);
	}

	protected boolean componentsExists(RexsComponent ... rexsComponents) {
		if (rexsComponents == null)
			return false;

		for (RexsComponent rexsComponent : rexsComponents) {
			if (!hasComponent(rexsComponent.getId()))
				return false;
		}
		return true;
	}

	public void createLoadSpectrum() {
		if (loadSpectrums.isEmpty()) {
			loadSpectrums.add(RexsModelObjectFactory.getInstance().createRexsLoadSpectrum(1));
		} else
			throw new RexsModelAccessException("Rexs specification allows only one load spectrum per rexs model!");
	}

	public RexsSubModel createLoadCase(int idOfLoadCase) {
		if (loadSpectrums.isEmpty())
			createLoadSpectrum();
		else if (getLoadCases().stream().anyMatch(lc -> lc.getId()==idOfLoadCase))
			throw new RexsModelAccessException("Load case with this id already exists!");

		RexsLoadSpectrum spectrum = loadSpectrums.get(0);
		RexsSubModel loadCase = RexsModelObjectFactory.getInstance().createRexsSubModel(idOfLoadCase);
		spectrum.addLoadCase(loadCase);

		return loadCase;
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
		for (RexsRelation planetPinRel : getRelationsOfType(RexsStandardRelationTypes.planet_pin)) {
			Integer shaftId = planetPinRel.findComponentIdByRole(RexsStandardRelationRoles.shaft);
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
		for (RexsRelation planetShaftRel : getRelationsOfType(RexsStandardRelationTypes.planet_shaft)) {
			Integer shaftId = planetShaftRel.findComponentIdByRole(RexsStandardRelationRoles.shaft);
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
		RexsComponentType componentType = rexsComponent.getType();

		if (RexsStandardComponentTypes.cylindrical_stage.getId().equals(componentType.getId())
				|| RexsStandardComponentTypes.shaft.getId().equals(componentType.getId())) {
			for (RexsComponent planetaryStage : getComponentsOfType(RexsStandardComponentTypes.planetary_stage)) {
				for (RexsRelation relation : getRelationsOfMainComp(planetaryStage.getId())) {
					if (componentId.equals(relation.findComponentIdByRole(RexsStandardRelationRoles.part)))
						return true;
				}
			}
			return false;

		} else if (RexsStandardComponentTypes.cylindrical_gear.getId().equals(componentType.getId())
				|| RexsStandardComponentTypes.ring_gear.getId().equals(componentType.getId())) {
			for (RexsComponent stage : getStagesOfGear(rexsComponent)) {
				if (isPartOfPlanetaryStage(stage))
					return true;
			}
			return false;

		} else if (RexsStandardComponentTypes.side_plate.getId().equals(componentType.getId())
				|| RexsStandardComponentTypes.planet_carrier.getId().equals(componentType.getId())) {
			return true;

		} else if (RexsStandardComponentTypes.concept_bearing.getId().equals(componentType.getId())
				|| RexsStandardComponentTypes.coupling.getId().equals(componentType.getId())
				|| RexsStandardComponentTypes.rolling_bearing_with_catalog_geometry.getId().equals(componentType.getId())
				|| RexsStandardComponentTypes.rolling_bearing_with_detailed_geometry.getId().equals(componentType.getId())) {
			for (RexsRelation relation : getRelationsOfMainComp(rexsComponent.getId())) {
				if (relation.getType()==RexsStandardRelationTypes.side) {
					RexsComponent sideComp1 = getComponent(relation.findComponentIdByRole(RexsStandardRelationRoles.side_1));
					RexsComponent sideComp2 = getComponent(relation.findComponentIdByRole(RexsStandardRelationRoles.side_2));
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
		RexsComponentType gearType = gear.getType();
		RexsComponentType stageType = null;

		if (RexsStandardComponentTypes.cylindrical_gear.getId().equals(gearType.getId())
				|| RexsStandardComponentTypes.ring_gear.getId().equals(gearType.getId())) {
			stageType = RexsStandardComponentTypes.cylindrical_stage;

		} else if (RexsStandardComponentTypes.bevel_gear.getId().equals(gearType.getId())) {
			stageType = RexsStandardComponentTypes.bevel_stage;

		} else if (RexsStandardComponentTypes.worm_gear.getId().equals(gearType.getId())
				|| RexsStandardComponentTypes.worm_wheel.getId().equals(gearType.getId())) {
			stageType = RexsStandardComponentTypes.worm_stage;

		} else if (RexsStandardComponentTypes.involute_spline_gear_shaft.getId().equals(gearType.getId())
				|| RexsStandardComponentTypes.involute_spline_gear_hub.getId().equals(gearType.getId())) {
			stageType = RexsStandardComponentTypes.involute_spline_connection;
		}

		if (stageType == null)
			return new ArrayList<>();

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
	public RexsComponent getParent(Integer subCompId, RexsComponentType typeOfParent) {
		RexsComponent parent = null;
		for (RexsComponent potentialParent : getComponentsOfType(typeOfParent)) {
			for (RexsRelation relation : getRelationsOfMainComp(potentialParent.getId())) {
				if (relation.getType().equals(RexsStandardRelationTypes.assembly)
						&& subCompId.equals(relation.findComponentIdByRole(RexsStandardRelationRoles.part))) {
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
	public boolean hasParentOfType(Integer subCompId, RexsComponentType typeOfParent) {
		return getParent(subCompId, typeOfParent) != null;
	}

	public Integer getNextFreeComponentId() {
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
			if (relation.getType() == RexsStandardRelationTypes.ordered_reference) {
				int order = relation.getOrder();
				if (order >= highestOrder) {
					highestOrder = order;
					finishingTool = getComponent(relation.findComponentIdByRole(RexsStandardRelationRoles.referenced));
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
		return getParent(gear.getId(), RexsStandardComponentTypes.shaft);
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
		if (loadSpectrums.isEmpty())
			return RexsModelObjectFactory.getInstance().createRexsSubModel();

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

		for (RexsComponent comp : components.values()) {
			if (comp.hasAttribute(RexsStandardAttributeIds.reference_component_for_position)) {
				RexsAttribute refCompAttribute = comp.getAttribute(RexsStandardAttributeIds.reference_component_for_position);
				if (Integer.valueOf(refCompAttribute.getStringValue())==oldId)
					refCompAttribute.setStringValue(String.valueOf(newId));
			}
		}

		for (RexsRelation relation : relations) {
			if (relation.hasComponent(oldId))
				relation.changeComponentId(oldId, newId);
		}

		List<RexsRelation> mainrelations = mapMainCompToRelation.getOrDefault(oldId, new ArrayList<>());
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
	 * @param component
	 * 				TODO Document me!
	 */
	public void changeComponentId(RexsComponent component) {
		changeComponentId(component, getNextFreeComponentId());
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

	public void removeRelation(RexsRelation relation) {
		relations.remove(relation);
		mapMainCompToRelation.get(relation.getMainComponentId()).remove(relation);
		mapTypeToRelation.get(relation.getType()).remove(relation);
	}

	public void removeComponent(RexsComponent component) {
		List<RexsRelation> relationsOfComponent = relations.stream().filter(r -> r.hasComponent(component.getId())).toList();
		for (RexsRelation relation : relationsOfComponent)
			removeRelation(relation);

		components.remove(component.getId());

		List<RexsComponent> compsOfType = mapTypeToComponent.get(component.getType());
		compsOfType.remove(component);
		mapTypeToComponent.put(component.getType(), compsOfType);
	}
}
