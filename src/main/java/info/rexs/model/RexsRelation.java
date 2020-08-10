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

import info.rexs.db.constants.RelationRole;
import info.rexs.db.constants.RelationType;
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
	public RexsRelation(Relation rawRelation) {
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
	 * 				The type of the relation as {@link RelationType}.
	 */
	public RelationType getType() {
		return RelationType.findByKey(rawRelation.getType());
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
	 * 				The relation role of the component to be found as {@link RelationRole}.
	 *
	 * @return
	 * 				The found component ID as {@link Integer}, or {@code null} if the component could not be found.
	 */
	public Integer findComponentIdByRole(RelationRole role) {
		for (Ref ref : rawRelation.getRef()) {
			if (ref.getRole().equals(role.name()))
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
	 * 				The found relation role as {@link RelationRole}, or {@code null} if the relation role could not be found.
	 */
	public RelationRole findRoleByComponentId(Integer componentId) {
		if (hasComponent(componentId)) {
			for (Ref ref : rawRelation.getRef()) {
				if (ref.getId().equals(componentId))
					return RelationRole.findByKey(ref.getRole());
			}
		}

		return null;
	}

	/**
	 * @return
	 * 				Returns the ID of the main component of this relation.
	 */
	public Integer getMainComponentId() {
		switch (getType()) {
			case ASSEMBLY:
			case ORDERED_ASSEMBLY:
				return findComponentIdByRole(RelationRole.ASSEMBLY);
			case STAGE:
			case STAGE_GEAR_DATA:
				return findComponentIdByRole(RelationRole.STAGE);
			case FLANK:
				return findComponentIdByRole(RelationRole.GEAR);
			case SIDE:
			case COUPLING:
				return findComponentIdByRole(RelationRole.ASSEMBLY);
			case REFERENCE:
			case ORDERED_REFERENCE:
				return findComponentIdByRole(RelationRole.ORIGIN);
			case PLANET_SHAFT:
			case CENTRAL_SHAFT:
			case PLANET_PIN:
			case PLANET_CARRIER_SHAFT:
				return findComponentIdByRole(RelationRole.PLANETARY_STAGE);
			case CONNECTION:
				return findComponentIdByRole(RelationRole.SIDE_1);
			default:
				return null;
		}
	}

	/**
	 * @return
	 * 				Returns the ID of the sub-component of this relation.
	 */
	public List<Integer> getSubComponentIds() {
		List<Integer> subComponentIds = new ArrayList<>();
		switch (getType()) {
			case ASSEMBLY:
			case ORDERED_ASSEMBLY:
				subComponentIds.add(findComponentIdByRole(RelationRole.PART));
				break;
			case STAGE:
				subComponentIds.add(findComponentIdByRole(RelationRole.GEAR_1));
				subComponentIds.add(findComponentIdByRole(RelationRole.GEAR_2));
				break;
			case STAGE_GEAR_DATA:
				subComponentIds.add(findComponentIdByRole(RelationRole.GEAR));
				subComponentIds.add(findComponentIdByRole(RelationRole.STAGE_GEAR_DATA));
				break;
			case FLANK:
				subComponentIds.add(findComponentIdByRole(RelationRole.LEFT));
				subComponentIds.add(findComponentIdByRole(RelationRole.RIGHT));
				break;
			case SIDE:
				subComponentIds.add(findComponentIdByRole(RelationRole.INNER_PART));
				subComponentIds.add(findComponentIdByRole(RelationRole.OUTER_PART));
				break;
			case COUPLING:
			case CONNECTION:
				subComponentIds.add(findComponentIdByRole(RelationRole.SIDE_1));
				subComponentIds.add(findComponentIdByRole(RelationRole.SIDE_2));
				break;
			case REFERENCE:
			case ORDERED_REFERENCE:
				subComponentIds.add(findComponentIdByRole(RelationRole.REFERENCED));
				break;
			case PLANET_SHAFT:
			case CENTRAL_SHAFT:
			case PLANET_PIN:
			case PLANET_CARRIER_SHAFT:
				subComponentIds.add(findComponentIdByRole(RelationRole.SHAFT));
				break;
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
	protected void changeComponentId(Integer oldId, Integer newId) {
		componentIds.remove(oldId);
		componentIds.add(newId);
		for (Ref ref : rawRelation.getRef()) {
			if (ref.getId().equals(oldId))
				ref.setId(newId);
		}
	}
}
