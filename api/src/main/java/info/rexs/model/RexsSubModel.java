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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.EqualsAndHashCode;

/**
 * This class represents a sub-model (containing only the varied data) of a REXS model.
 *
 * @author FVA GmbH
 */
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class RexsSubModel implements Comparable<RexsSubModel> {

	/** An internal index with all components of the sub-model for quick access. */
	protected Map<Integer, RexsComponent> components = new HashMap<>();

	/** The numeric ID of the sub-model within the REXS model. */
	@EqualsAndHashCode.Include
	private Integer id;

	/** Indicates whether it is a separate sub-model for accumulated values. */
	@EqualsAndHashCode.Include
	private boolean isAccumulation = false;

	/**
	 * Constructs a new {@link RexsSubModel} for the given properties.
	 *
	 * @param id
	 * 				The numeric ID of the sub-model within the REXS model.
	 * @param isAccumulation
	 * 				Flag whether it is an accumulation.
	 */
	protected RexsSubModel(Integer id, boolean isAccumulation) {
		this.id = id;
		this.isAccumulation = isAccumulation;
	}

	/**
	 * Constructs a new {@link RexsSubModel} for a load case.
	 *
	 * @param id
	 * 				The numeric ID of the sub-model within the REXS model.
	 */
	protected RexsSubModel(Integer id) {
		this(id, false);
	}

	/**
	 * Constructs a new {@link RexsSubModel} for an accumilation.
	 */
	protected RexsSubModel() {
		this((Integer)null, true);
	}

	/**
	 * @return
	 * 				The numeric ID of the sub-model within the REXS model.
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return
	 * 				{@code true} if it is a separate sub-model for accumulated values, otherwise {@code false}.
	 */
	public boolean isAccumulation() {
		return isAccumulation;
	}

	/**
	 * @return
	 * 				All components of the sub-model as a {@link List} of {@link RexsComponent}.
	 */
	public List<RexsComponent> getComponents() {
		return components.values().stream().collect(Collectors.toList());
	}

	/**
	 * Adds a component to the sub-model.
	 *
	 * @param component
	 * 				The additional component as a {@link RexsComponent}.
	 */
	public void addComponent(RexsComponent component) {
		this.components.put(component.getId(), component);
	}

	/**
	 * Checks on the ID of a component whether the sub-model contains a corresponding component.
	 *
	 * @param compId
	 * 				The ID of the component as {@link Integer}.
	 *
	 * @return
	 * 				{@code true} if the sub-model contains the component, otherwise {@code false}.
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
		if (hasComponent(oldId)) {
			RexsComponent component = getComponent(oldId);
			component.changeComponentId(newId);
			components.remove(oldId);
			components.put(newId, component);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int compareTo(RexsSubModel other) {
		// accumulation is greater than any other load case
		if (isAccumulation && other.isAccumulation())
			return 0;
		if (isAccumulation)
			return 1;
		if (other.isAccumulation())
			return -1;

		// sort by id
		return getId().compareTo(other.getId());
	}
}
