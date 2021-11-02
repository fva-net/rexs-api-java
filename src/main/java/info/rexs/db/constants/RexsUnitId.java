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
package info.rexs.db.constants;

import java.util.HashMap;
import java.util.Map;

import info.rexs.db.constants.standard.RexsStandardUnitIds;

/**
 * This class represents a REXS unit.
 * <p>
 * It contains constants for all units of official REXS versions.
 * <p>
 * Since REXS is freely expandable, you can also add your own units using the {@link #create(String)} method.
 *
 * @author FVA GmbH
 */
public class RexsUnitId implements RexsStandardUnitIds {

	/** An internal index with all created units (REXS standard and own) for quick access. */
	private static Map<String, RexsUnitId> allUnitIds = new HashMap<>();

	/** The actual unit ID as a {@link String}. */
	private final String id;

	protected RexsUnitId(String id) {
		if (id == null || id.isEmpty())
			throw new IllegalArgumentException("id cannot be empty");
		this.id = id;
	}

	/**
	 * @return
	 * 				The actual unit ID as a {@link String}.
	 */
	public String getId() {
		return id;
	}

	/**
	 * TODO Document me!
	 *
	 * @param checkUnitIds
	 * 				TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public boolean isOneOf(RexsUnitId ... checkUnitIds)
	{
		if (checkUnitIds == null)
			return false;

		for (RexsUnitId checkUnitId : checkUnitIds)
		{
			if (this.equals(checkUnitId))
				return true;
		}

		return false;
	}

	/**
	 * Creates a new unit ID and adds it to the internal index.
	 *
	 * @param id
	 * 				The actual unit ID as a {@link String}.
	 *
	 * @return
	 * 				The newly created unit ID as {@link RexsUnitId}.
	 */
	public static RexsUnitId create(String id) {
		RexsUnitId unitId = new RexsUnitId(id);
		allUnitIds.put(id, unitId);
		return unitId;
	}

	/**
	 * Returns the unit ID for a textual ID from the internally stored index of all unit IDs.
	 *
	 * @param id
	 * 				The actual unit ID to be found as a {@link String}
	 *
	 * @return
	 * 				The found unit ID as {@link RexsUnitId}, or {@code null} if the ID could not be found.
	 */
	public static RexsUnitId findById(String id) {
		if (id == null)
			return null;
		RexsStandardUnitIds.init();
		return allUnitIds.getOrDefault(id, RexsStandardUnitIds.UNKNOWN);
	}
}
