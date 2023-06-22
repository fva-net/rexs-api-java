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

import info.rexs.db.constants.standard.RexsStandardAttributeIds;

/**
 * This class represents the ID of a REXS attribute.
 * <p>
 * It contains constants for all attribute IDs of official REXS versions.
 * <p>
 * Since REXS is freely expandable, you can also add your own attribute IDs using the {@link #create(String, RexsUnitId)} method.
 *
 * @author FVA GmbH
 */
public class RexsAttributeId implements RexsStandardAttributeIds {

	/** An internal index with all created attribute IDs (REXS standard and own) for quick access. */
	private static Map<String, RexsAttributeId> allAttributeIds = new HashMap<>();

	/** The actual attribute ID as a {@link String}. */
	private final String id;

	/** The unit of the attribute as {@link RexsUnitId}. */
	private final RexsUnitId unit;

	private RexsAttributeId(String id, RexsUnitId unit) {
		if (id == null || id.isEmpty())
			throw new IllegalArgumentException("id cannot be empty");
		if (unit == null)
			throw new IllegalArgumentException("unit cannot be empty");
		this.id = id;
		this.unit = unit;
	}

	/**
	 * @return
	 * 				The actual attribute ID as a {@link String}.
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return
	 * 				The unit of the attribute as {@link RexsUnitId}.
	 */
	public RexsUnitId getUnit() {
		return unit;
	}

	/**
	 * TODO Document me!
	 *
	 * @param checkAttributeIds
	 * 				TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public boolean isOneOf(RexsAttributeId ... checkAttributeIds)
	{
		if (checkAttributeIds == null)
			return false;

		for (RexsAttributeId checkAttributeId : checkAttributeIds)
		{
			if (this.equals(checkAttributeId))
				return true;
		}

		return false;
	}

	/**
	 * Creates a new attribute ID and adds it to the internal index.
	 *
	 * @param id
	 * 				The actual attribute ID as {@link String}.
	 * @param unit
	 * 				The unit of the attribute as {@link RexsUnitId}.
	 *
	 * @return
	 * 				The newly created attribute ID as {@link RexsAttributeId}.
	 */
	public static RexsAttributeId create(String id, RexsUnitId unit) {
		RexsAttributeId attributeId = new RexsAttributeId(id, unit);
		allAttributeIds.put(id, attributeId);
		return attributeId;
	}

	/**
	 * Returns the attribute ID for a textual ID from the internally stored index of all attribute IDs.
	 *
	 * @param id
	 * 				The actual attribute ID to be found as a {@link String}
	 *
	 * @return
	 * 				The found attribute ID as {@link RexsAttributeId}, or {@code RexsStandardAttributeIds.UNKNOWN} if the ID could not be found.
	 */
	public static RexsAttributeId findById(String id) {
		if (id == null)
			return null;
		RexsStandardAttributeIds.init();
		return allAttributeIds.getOrDefault(id, RexsStandardAttributeIds.UNKNOWN);
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof RexsAttributeId)) {
			return false;
		}
		RexsAttributeId other = (RexsAttributeId)o;
		if (!other.canEqual(this)) {
			return false;
		}
		Object this_id = getId();
		Object other_id = other.getId();
		if (this_id == null ? other_id != null : !this_id.equals(other_id)) {
			return false;
		}
		Object this_unit = getUnit();
		Object other_unit = other.getUnit();
		return this_unit == null ? other_unit == null : this_unit.equals(other_unit);
	}

	protected boolean canEqual(Object other) {
		return other instanceof RexsAttributeId;
	}

	@Override
	public int hashCode() {
		int result = 1;
		Object _id = getId();
		result = result * 59 + (_id == null ? 43 : _id.hashCode());
		Object _unit = getUnit();
		result = result * 59 + (_unit == null ? 43 : _unit.hashCode());
		return result;
	}
}
