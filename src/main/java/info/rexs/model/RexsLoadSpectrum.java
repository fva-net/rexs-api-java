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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import info.rexs.model.jaxb.LoadCase;
import info.rexs.model.jaxb.LoadSpectrum;

/**
 * This class represents a load spectrum of a REXS model.
 *
 * @author FVA GmbH
 */
public class RexsLoadSpectrum {

	/** The representation of this load spectrum in the JAXB model. */
	private LoadSpectrum rawLoadSpectrum;

	/** The numeric ID of the load spectrum within the REXS model. */
	private Integer id;

	/** An internal index with all load cases of the load spectrum for quick access. */
	protected Map<Integer, RexsSubModel> loadCases = new HashMap<>();

	/** The sub-model for accumulated values of this load spectrum. */
	private RexsSubModel accumulation;

	/**
	 * Constructs a new {@link RexsLoadSpectrum} for the given {@link LoadSpectrum}.
	 *
	 * @param rawLoadSpectrum
	 * 				The representation of a load spectrum in the JAXB model.
	 */
	protected RexsLoadSpectrum(LoadSpectrum rawLoadSpectrum) {
		this.rawLoadSpectrum = rawLoadSpectrum;
		this.id = rawLoadSpectrum.getId();
		for (LoadCase rawLoadCase : rawLoadSpectrum.getLoadCase()) {
			loadCases.put(rawLoadCase.getId(), RexsModelObjectFactory.getInstance().createRexsSubModel(rawLoadCase));
		}
		this.accumulation = RexsModelObjectFactory.getInstance().createRexsSubModel(rawLoadSpectrum.getAccumulation());
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
	 * 				The representation of this load spectrum in the JAXB model.
	 */
	public LoadSpectrum getRawLoadSpectrum() {
		return rawLoadSpectrum;
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
	 * @return
	 * 				The sub-model for accumulated values of this load spectrum.
	 */
	public RexsSubModel getAccumulation() {
		return accumulation;
	}
}
