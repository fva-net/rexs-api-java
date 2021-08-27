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
import info.rexs.model.jaxb.Ref;
import info.rexs.model.jaxb.Relation;

/**
 * This class represents a relation of a REXS model.
 *
 * @author FVA GmbH
 */
public class RexsRelation {

	/** The representation of this relation in the JAXB model. */
	private Relation rawRelation;

	/** A set with all component IDs of this relation. */
	private Set<Integer> componentIds = new HashSet<>();

	/**
	 * Constructs a new {@link RexsRelation} for the given {@link Relation}.
	 *
	 * @param rawRelation
	 * 				The representation of this relation in the JAXB model.
	 */
	protected RexsRelation(Relation rawRelation) {
		this.rawRelation = rawRelation;
		for (Ref ref : rawRelation.getRef()) {
			componentIds.add(ref.getId());
		}
	}

	/**
	 * @return
	 * 				The representation of this relation in the JAXB model.
	 */
	public Relation getRawRelation() {
		return rawRelation;
	}

	/**
	 * @return
	 * 				The type of the relation as {@link RexsRelationType}.
	 */
	public RexsRelationType getType() {
		return RexsRelationType.findByKey(rawRelation.getType());
	}

	/**
	 * @return
	 * 				The ID of the relation as {@link Integer}.
	 */
	public Integer getId() {
		return rawRelation.getId();
	}

	/**
	 * @return
	 * 				The order of the relation as {@link Integer}.
	 */
	public Integer getOrder() {
		Integer order = rawRelation.getOrder();
		if (order == null)
			order = 1;
		return order;
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
		for (Ref ref : rawRelation.getRef()) {
			if (ref.getRole().equals(role.getKey()))
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
			for (Ref ref : rawRelation.getRef()) {
				if (ref.getId().equals(componentId))
					return RexsRelationRole.findByKey(ref.getRole());
			}
		}

		return null;
	}

	/**
	 * @return
	 * 				Returns the ID of the main component of this relation.
	 */
	public Integer getMainComponentId() {
		RexsRelationType type = getType();

		if (RexsRelationType.assembly.equals(type)
				|| RexsRelationType.ordered_assembly.equals(type))
			return findComponentIdByRole(RexsRelationRole.assembly);

		else if (RexsRelationType.stage.equals(type)
				|| RexsRelationType.stage_gear_data.equals(type))
			return findComponentIdByRole(RexsRelationRole.stage);

		else if (RexsRelationType.flank.equals(type))
			return findComponentIdByRole(RexsRelationRole.gear);

		else if (RexsRelationType.side.equals(type)
				|| RexsRelationType.coupling.equals(type))
			return findComponentIdByRole(RexsRelationRole.assembly);

		else if (RexsRelationType.reference.equals(type)
				|| RexsRelationType.ordered_reference.equals(type))
			return findComponentIdByRole(RexsRelationRole.origin);

		else if (RexsRelationType.planet_shaft.equals(type)
				|| RexsRelationType.central_shaft.equals(type)
				|| RexsRelationType.planet_pin.equals(type)
				|| RexsRelationType.planet_carrier_shaft.equals(type))
			return findComponentIdByRole(RexsRelationRole.planetary_stage);

		else if (RexsRelationType.connection.equals(type))
			return findComponentIdByRole(RexsRelationRole.side_1);

		else if (RexsRelationType.manufacturing_step.equals(type))
			return findComponentIdByRole(RexsRelationRole.workpiece);

		return null;
	}

	/**
	 * @return
	 * 				Returns the ID of the sub-component of this relation.
	 */
	public List<Integer> getSubComponentIds() {
		RexsRelationType type = getType();
		List<Integer> subComponentIds = new ArrayList<>();

		if (RexsRelationType.assembly.equals(type)
				|| RexsRelationType.ordered_assembly.equals(type)) {
			subComponentIds.add(findComponentIdByRole(RexsRelationRole.part));

		} else if (RexsRelationType.stage.equals(type)) {
			subComponentIds.add(findComponentIdByRole(RexsRelationRole.gear_1));
			subComponentIds.add(findComponentIdByRole(RexsRelationRole.gear_2));

		} else if (RexsRelationType.stage_gear_data.equals(type)) {
			subComponentIds.add(findComponentIdByRole(RexsRelationRole.gear));
			subComponentIds.add(findComponentIdByRole(RexsRelationRole.stage_gear_data));

		} else if (RexsRelationType.flank.equals(type)) {
			subComponentIds.add(findComponentIdByRole(RexsRelationRole.left));
			subComponentIds.add(findComponentIdByRole(RexsRelationRole.right));

		} else if (RexsRelationType.side.equals(type)) {
			subComponentIds.add(findComponentIdByRole(RexsRelationRole.inner_part));
			subComponentIds.add(findComponentIdByRole(RexsRelationRole.outer_part));

		} else if (RexsRelationType.coupling.equals(type)
				|| RexsRelationType.connection.equals(type)) {
			subComponentIds.add(findComponentIdByRole(RexsRelationRole.side_1));
			subComponentIds.add(findComponentIdByRole(RexsRelationRole.side_2));

		} else if (RexsRelationType.reference.equals(type)
				|| RexsRelationType.ordered_reference.equals(type)) {
			subComponentIds.add(findComponentIdByRole(RexsRelationRole.referenced));

		} else if (RexsRelationType.planet_shaft.equals(type)
				|| RexsRelationType.central_shaft.equals(type)
				|| RexsRelationType.planet_pin.equals(type)
				|| RexsRelationType.planet_carrier_shaft.equals(type)) {
			subComponentIds.add(findComponentIdByRole(RexsRelationRole.shaft));
		} else if (RexsRelationType.manufacturing_step.equals(type)) {
			subComponentIds.add(findComponentIdByRole(RexsRelationRole.tool));
			subComponentIds.add(findComponentIdByRole(RexsRelationRole.manufacturing_settings));
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
		for (Ref ref : rawRelation.getRef()) {
			if (ref.getId().equals(oldId))
				ref.setId(newId);
		}
	}
}
