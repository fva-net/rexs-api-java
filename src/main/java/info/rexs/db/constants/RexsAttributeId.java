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
import lombok.EqualsAndHashCode;

/**
 * This class represents the ID of a REXS attribute.
 * <p>
 * It contains constants for all attribute IDs of official REXS versions (1.0, 1.1, 1.2, 1.3).
 * <p>
 * Since REXS is freely expandable, you can also add your own attribute IDs using the {@link #create(String, RexsUnitId)} method.
 *
 * @author FVA GmbH
 */
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class RexsAttributeId implements RexsStandardAttributeIds {

	/** An internal index with all created attribute IDs (REXS standard and own) for quick access. */
	private static Map<String, RexsAttributeId> allAttributeIds = new HashMap<>();

	/** The actual attribute ID as a {@link String}. */
	@EqualsAndHashCode.Include
	private final String id;

	/** The unit of the attribute as {@link RexsUnitId}. */
	@EqualsAndHashCode.Include
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
	 * 				The found attribute ID as {@link RexsAttributeId}, or {@code null} if the ID could not be found.
	 */
	public static RexsAttributeId findById(String id) {
		if (id == null)
			return null;
		RexsStandardAttributeIds.init();
		return allAttributeIds.getOrDefault(id, null);
	}
}
