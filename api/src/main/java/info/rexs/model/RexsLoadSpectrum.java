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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class represents a load spectrum of a REXS model.
 *
 * @author FVA GmbH
 */
public class RexsLoadSpectrum {

	/** The numeric ID of the load spectrum within the REXS model. */
	private Integer id;

	/** An internal index with all load cases of the load spectrum for quick access. */
	protected Map<Integer, RexsSubModel> loadCases = new HashMap<>();

	/** The sub-model for accumulated values of this load spectrum. */
	private RexsSubModel accumulation = new RexsSubModel();

	/**
	 * Constructs a new {@link RexsLoadSpectrum} for the given properties.
	 *
	 * @param id
	 * 				The ID of the load spectrum as an {@link Integer}.
	 */
	protected RexsLoadSpectrum(Integer id) {
		this.id = id;
	}

	/**
	 * @return
	 * 				The numeric ID of the load spectrum within the REXS model.
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return
	 * 				All load cases of the load spectrum as a {@link List} of {@link RexsSubModel}.
	 */
	public List<RexsSubModel> getLoadCases() {
		return new ArrayList<>(loadCases.values());
	}

	/**
	 * Returns the load case of the load spectrum for a numeric ID.
	 *
	 * @param loadCaseId
	 * 				The ID of the load case as {@link Integer}.
	 *
	 * @return
	 * 				The load case as {@link RexsSubModel} or {@code null} if the load spectrum does not contain a corresponding load case.
	 */
	public RexsSubModel getLoadCase(Integer loadCaseId) {
		return loadCases.get(loadCaseId);
	}

	/**
	 * Adds a load case to the load spectrum.
	 *
	 * @param loadCase
	 * 				The additional load case as a {@link RexsSubModel}.
	 */
	public void addLoadCase(RexsSubModel loadCase) {
		this.loadCases.put(loadCase.getId(), loadCase);
	}

	/**
	 * @return
	 * 				The sub-model for accumulated values of this load spectrum.
	 */
	public RexsSubModel getAccumulation() {
		return accumulation;
	}

	/**
	 * Sets the accumulation of the load spectrum.
	 *
	 * @param accumulation
	 * 				The new accumulation as a {@link RexsSubModel}.
	 */
	public void setAccumulation(RexsSubModel accumulation) {
		this.accumulation = accumulation;
	}
}
