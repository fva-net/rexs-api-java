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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import info.rexs.db.constants.RexsRelationRole;
import info.rexs.db.constants.RexsRelationType;
import info.rexs.db.constants.standard.RexsStandardRelationRoles;
import info.rexs.db.constants.standard.RexsStandardRelationTypes;

/**
 * This class represents a relation of a REXS model.
 *
 * @author FVA GmbH
 */
public class RexsRelation {

	/** The numeric ID of the relation. */
	private final Integer id;

	/** The type of the relation. */
	private RexsRelationType type;

	/** Optional order for sorting in the case of several relations. */
	private Integer order;

	/** All relation references of the relation. */
	private List<RexsRelationRef> refs = new ArrayList<>();

	/** A set with all component IDs of this relation. */
	private Set<Integer> componentIds = new HashSet<>();

	/**
	 * Constructs a new {@link RexsRelation} for the given properties.
	 *
	 * @param id
	 * 				The ID of the relation as a {@link Integer}.
	 * @param type
	 * 				The type of the relation as a {@link String}.
	 * @param order
	 * 				The order of the relation as a {@link Integer}.
	 */
	protected RexsRelation(Integer id, String type, Integer order) {
		this.id = id;
		this.type = RexsRelationType.findByKey(type);
		if (this.type==null)
			throw new RexsModelAccessException("Invalid RexsRelationType "+type);
		this.order = order;
	}

	/**
	 * Constructs a new {@link RexsRelation} for the given properties.
	 *
	 * @param id
	 * 				The ID of the relation as a {@link Integer}.
	 * @param type
	 * 				The type of the relation as a {@link RexsRelationType}.
	 * @param order
	 * 				The order of the relation as a {@link Integer}.
	 */
	public RexsRelation(Integer id, RexsRelationType type, Integer order) {
		this.id = id;
		this.type = type;
		this.order = order;
	}

	/** copy constructor */
	public RexsRelation(RexsRelation relation) {
		this.id = relation.id;
		this.type = relation.type;
		this.order = relation.order;
		for (RexsRelationRef reference: relation.getRefs()) {
			RexsRelationRef newReference = new RexsRelationRef(reference);
			this.addRef(newReference);
		}
	}

	/**
	 * @return
	 * 				The ID of the relation as {@link Integer}.
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return
	 * 				The type of the relation as {@link RexsRelationType}.
	 */
	public RexsRelationType getType() {
		return type;
	}


	/**
	 * @return
	 * 				The order of the relation as {@link Integer}.
	 */
	public Integer getOrder() {
		return order;
	}

	/**
	 * Sets the order of the relation.
	 *
	 * @param order
	 * 				The order of the relation as a {@link Integer}.
	 */
	public void setOrder(Integer order) {
		this.order = order;
	}

	/**
	 * @return
	 * 				All relation references of the relation as a {@link List} of {@link RexsRelationRef}.
	 */
	public List<RexsRelationRef> getRefs() {
		return refs;
	}

	/**
	 * Adds a relation reference to the relation.
	 *
	 * @param ref
	 * 				The additional relation reference as a {@link RexsRelationRef}.
	 */
	public void addRef(RexsRelationRef ref) {
		this.refs.add(ref);
		this.componentIds.add(ref.getId());
	}

	/**
	 * Checks on the ID of a component whether the relation contains a corresponding component.
	 *
	 * @param componentId
	 * 				The ID of the component as {@link Integer}.
	 *
	 * @return
	 * 				{@code true} if the relation contains the component, otherwise {@code false}.
	 */
	public boolean hasComponent(Integer componentId) {
		return componentIds.contains(componentId);
	}

	/**
	 * Returns the ID of the component for a relation role from the relation.
	 *
	 * @param role
	 * 				The relation role of the component to be found as {@link RexsRelationRole}.
	 *
	 * @return
	 * 				The found component ID as {@link Integer}, or {@code null} if the component could not be found.
	 */
	public Integer findComponentIdByRole(RexsRelationRole role) {
		for (RexsRelationRef ref : refs) {
			if (ref.getRole().equals(role))
				return ref.getId();
		}

		return null;
	}

	/**
	 * Returns the relation role for a component ID from the relation.
	 *
	 * @param componentId
	 * 				The component ID of the relation role to be found as {@link Integer}.
	 *
	 * @return
	 * 				The found relation role as {@link RexsRelationRole}, or {@code null} if the relation role could not be found.
	 */
	public RexsRelationRole findRoleByComponentId(Integer componentId) {
		if (hasComponent(componentId)) {
			for (RexsRelationRef ref : refs) {
				if (ref.getId().equals(componentId))
					return ref.getRole();
			}
		}

		return null;
	}

	public RexsRelationRef findRefByRole(RexsRelationRole role) {
		for (RexsRelationRef ref : refs) {
			if (ref.getRole().equals(role))
				return ref;
		}

		return null;
	}

	/**
	 * @return
	 * 				Returns the ID of the main component of this relation.
	 */
	public Integer getMainComponentId() {
		RexsRelationType type = getType();

		if (RexsStandardRelationTypes.assembly.equals(type)
				|| RexsStandardRelationTypes.ordered_assembly.equals(type))
			return findComponentIdByRole(RexsStandardRelationRoles.assembly);

		else if (RexsStandardRelationTypes.stage.equals(type)
				|| RexsStandardRelationTypes.stage_gear_data.equals(type))
			return findComponentIdByRole(RexsStandardRelationRoles.stage);

		else if (RexsStandardRelationTypes.flank.equals(type))
			return findComponentIdByRole(RexsStandardRelationRoles.gear);

		else if (RexsStandardRelationTypes.side.equals(type)
				|| RexsStandardRelationTypes.coupling.equals(type))
			return findComponentIdByRole(RexsStandardRelationRoles.assembly);

		else if (RexsStandardRelationTypes.reference.equals(type)
				|| RexsStandardRelationTypes.ordered_reference.equals(type))
			return findComponentIdByRole(RexsStandardRelationRoles.origin);

		else if (RexsStandardRelationTypes.planet_shaft.equals(type)
				|| RexsStandardRelationTypes.central_shaft.equals(type)
				|| RexsStandardRelationTypes.planet_pin.equals(type)
				|| RexsStandardRelationTypes.planet_carrier_shaft.equals(type))
			return findComponentIdByRole(RexsStandardRelationRoles.planetary_stage);

		else if (RexsStandardRelationTypes.connection.equals(type))
			return findComponentIdByRole(RexsStandardRelationRoles.side_1);

		else if (RexsStandardRelationTypes.manufacturing_step.equals(type))
			return findComponentIdByRole(RexsStandardRelationRoles.workpiece);

		return null;
	}

	/**
	 * @return
	 * 				Returns the ID of the sub-component of this relation.
	 */
	public List<Integer> getSubComponentIds() {
		RexsRelationType type = getType();
		List<Integer> subComponentIds = new ArrayList<>();

		if (RexsStandardRelationTypes.assembly.equals(type)
				|| RexsStandardRelationTypes.ordered_assembly.equals(type)) {
			subComponentIds.add(findComponentIdByRole(RexsStandardRelationRoles.part));

		} else if (RexsStandardRelationTypes.stage.equals(type)) {
			subComponentIds.add(findComponentIdByRole(RexsStandardRelationRoles.gear_1));
			subComponentIds.add(findComponentIdByRole(RexsStandardRelationRoles.gear_2));

		} else if (RexsStandardRelationTypes.stage_gear_data.equals(type)) {
			subComponentIds.add(findComponentIdByRole(RexsStandardRelationRoles.gear));
			subComponentIds.add(findComponentIdByRole(RexsStandardRelationRoles.stage_gear_data));

		} else if (RexsStandardRelationTypes.flank.equals(type)) {
			subComponentIds.add(findComponentIdByRole(RexsStandardRelationRoles.left));
			subComponentIds.add(findComponentIdByRole(RexsStandardRelationRoles.right));

		} else if (RexsStandardRelationTypes.side.equals(type)) {
			subComponentIds.add(findComponentIdByRole(RexsStandardRelationRoles.inner_part));
			subComponentIds.add(findComponentIdByRole(RexsStandardRelationRoles.outer_part));

		} else if (RexsStandardRelationTypes.coupling.equals(type)
				|| RexsStandardRelationTypes.connection.equals(type)) {
			subComponentIds.add(findComponentIdByRole(RexsStandardRelationRoles.side_1));
			subComponentIds.add(findComponentIdByRole(RexsStandardRelationRoles.side_2));

		} else if (RexsStandardRelationTypes.reference.equals(type)
				|| RexsStandardRelationTypes.ordered_reference.equals(type)) {
			subComponentIds.add(findComponentIdByRole(RexsStandardRelationRoles.referenced));

		} else if (RexsStandardRelationTypes.planet_shaft.equals(type)
				|| RexsStandardRelationTypes.central_shaft.equals(type)
				|| RexsStandardRelationTypes.planet_pin.equals(type)
				|| RexsStandardRelationTypes.planet_carrier_shaft.equals(type)) {
			subComponentIds.add(findComponentIdByRole(RexsStandardRelationRoles.shaft));
		} else if (RexsStandardRelationTypes.manufacturing_step.equals(type)) {
			subComponentIds.add(findComponentIdByRole(RexsStandardRelationRoles.tool));
			subComponentIds.add(findComponentIdByRole(RexsStandardRelationRoles.manufacturing_settings));
		}

		return subComponentIds;
	}

	/**
	 * Changes the numerical ID of the associated components.
	 * <p>
	 * ATTENTION: Make sure that the new ID has not already been assigned to another component.
	 *
	 * @param oldId
	 * 				The old numeric ID of the component within the REXS model.
	 * @param newId
	 * 				The new numeric ID of the component within the REXS model.
	 */
	public void changeComponentId(Integer oldId, Integer newId) {
		componentIds.remove(oldId);
		componentIds.add(newId);
		for (RexsRelationRef ref : refs) {
			if (ref.getId().equals(oldId))
				ref.setId(newId);
		}
	}

	@Override
	public String toString() {
		String refString = refs.stream()
				.map(ref -> ref.getRole().getKey()+": "+ref.getId())
				.reduce((a,b) -> a+", "+b)
				.orElse("");
		return type.getKey()+"("+refString+")";
	}
}