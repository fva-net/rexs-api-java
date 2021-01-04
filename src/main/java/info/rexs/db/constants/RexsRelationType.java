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

import info.rexs.db.constants.standard.RexsStandardRelationTypes;
import lombok.EqualsAndHashCode;

/**
 * This class represents a REXS relation type.
 * <p>
 * It contains constants for all relation types of official REXS versions (1.0, 1.1, 1.2, 1.3).
 * <p>
 * Since REXS is freely expandable, you can also add your own relation types using the {@link #create(String)} method.
 *
 * @author FVA GmbH
 */
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class RexsRelationType implements RexsStandardRelationTypes {

	/** An internal index with all created relation types (REXS standard and own) for quick access. */
	private static Map<String, RexsRelationType> allRelationTypes = new HashMap<>();

	/** The actual key of the relation type as a {@link String}. */
	@EqualsAndHashCode.Include
	private final String key;

	private RexsRelationType(String key) {
		if (key == null || key.isEmpty())
			throw new IllegalArgumentException("key cannot be empty");
		this.key = key;
	}

	/**
	 * @return
	 * 				The actual key of the relation type as a {@link String}.
	 */
	public String getKey() {
		return key;
	}

	/**
	 * TODO Document me!
	 *
	 * @param checkRelationTypes
	 * 				TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public boolean isOneOf(RexsRelationType ... checkRelationTypes)
	{
		if (checkRelationTypes == null)
			return false;

		for (RexsRelationType checkRelationType : checkRelationTypes)
		{
			if (this.equals(checkRelationType))
				return true;
		}

		return false;
	}

	/**
	 * Creates a new relation type and adds it to the internal index.
	 *
	 * @param key
	 * 				The actual key of the relation type as a {@link String}.
	 *
	 * @return
	 * 				The newly created relation type as {@link RexsRelationType}.
	 */
	public static RexsRelationType create(String key) {
		RexsRelationType relationType = new RexsRelationType(key);
		allRelationTypes.put(key, relationType);
		return relationType;
	}

	/**
	 * Returns the relation type for a textual key from the internally stored index of all relation types.
	 *
	 * @param key
	 * 				The actual key of the relation type to be found as a {@link String}
	 *
	 * @return
	 * 				The found relation type as {@link RexsRelationType}, or {@code null} if the key could not be found.
	 */
	public static RexsRelationType findByKey(String key) {
		if (key == null)
			return null;
		RexsStandardRelationTypes.init();
		return allRelationTypes.getOrDefault(key, null);
	}
}
