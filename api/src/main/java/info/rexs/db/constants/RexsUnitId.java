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
import java.util.Set;

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
	private static final Map<String, RexsUnitId> allUnitIds = new HashMap<>();

	/** The actual unit ID as a {@link String}. */
	private final String id;

	/** The units unique numeric ID as a {@link int}. */
	private int numericId = 0;

	private RexsUnitId(String id) {
		if (id == null || id.isEmpty())
			throw new IllegalArgumentException("id cannot be empty");
		this.id = id;
	}

	private RexsUnitId(String id, int numericId) {
		if (id == null || id.isEmpty())
			throw new IllegalArgumentException("id cannot be empty");
		if (numericId < 0)
			throw new IllegalArgumentException("numericId cannot be negative");
		this.id = id;
		this.numericId = numericId;
	}

	/**
	 * @return
	 * 				The actual unit ID as a {@link String}.
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return
	 * 				The units numeric ID as a {@link int}.
	 */
	public int getNumericId() {
		return numericId;
	}

	/**
	 * Checks if the unit is one of the specified units.
	 *
	 * @param checkUnitIds
	 * 				The units to check against.
	 * @return
	 * 				{@code true} if this unit is one of the specified units, otherwise {@code false}.
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
	 * Creates a new unit ID with a numeric ID and adds it to the internal index.
	 *
	 * @param id
	 * 				The actual unit ID as a {@link String}.
	 * @param numericId
	 * 				The numeric ID associated with the unit.
	 * @return
	 * 				The newly created unit ID as {@link RexsUnitId}.
	 * @throws IllegalArgumentException if the numericId already exists.
	 */
	public static RexsUnitId create(String id, int numericId) {
		// check for zero
		if (numericId == 0) {
			return create(id);
		}

		// create unit ID
		RexsUnitId unitId = new RexsUnitId(id, numericId);

		// check for uniqueness of numericId
		for (RexsUnitId unit : allUnitIds.values()) {
			if (unit.numericId == numericId) {
				throw new IllegalArgumentException("numericId already exists");
			}
		}

		// add unit ID to index
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
		if (id.isEmpty())
			return RexsStandardUnitIds.none;
		RexsStandardUnitIds.init();
		return allUnitIds.getOrDefault(id, UNKNOWN);
	}

	public static RexsUnitId findById(int numericId) {
		for (RexsUnitId unit : allUnitIds.values()) {
			if (unit.numericId == numericId) {
				return unit;
			}
		}
		return UNKNOWN;
	}

	/**
	 * Checks if the unit is equivalent to another {@link RexsUnitId}.
	 *
	 * @param unit
	 * 				The {@link RexsUnitId} to check for.
	 *
	 * @return
	 * 				{@code true} if the two {@link RexsUnitId}s are equivalent to each other, otherwise {@code false}.
	 */
	public boolean isEquivalent(RexsUnitId unit) {
		if (unit == null)
			return false;
		for (Set<RexsUnitId> equivalentUnit : EQUIVALENT_UNITS) {
			if (equivalentUnit.contains(this) && equivalentUnit.contains(unit))
				return true;
		}
		return false;
	}
}
