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
package info.rexs.schema.constants;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import info.rexs.schema.constants.standard.RexsStandardRelationTypes;

/**
 * This class represents a REXS relation type.
 * <p>
 * It contains constants for all relation types of official REXS versions.
 * <p>
 * Since REXS is freely expandable, you can also add your own relation types using the {@link #create(String)} method.
 *
 * @author FVA GmbH
 */
public class RexsRelationType implements RexsStandardRelationTypes {

	/** An internal index with all created relation types (REXS standard and own) for quick access. */
	private static Map<String, RexsRelationType> allRelationTypes = new HashMap<>();

	/** The actual key of the relation type as a {@link String}. */
	private final String key;

	private final List<RexsRelationRole> roles;

	private RexsRelationType(String key) {
		if (key == null || key.isEmpty())
			throw new IllegalArgumentException("key cannot be empty");
		this.key = key;
		this.roles = Arrays.asList();
	}

	private RexsRelationType(String key, List<RexsRelationRole> roles) {
		if (key == null || key.isEmpty())
			throw new IllegalArgumentException("key cannot be empty");
		this.key = key;
		this.roles = roles;
	}

	public List<RexsRelationRole> getRoles() {
		return roles;
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

	public boolean isOrdered() {
		return key.contains("ordered");
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

	public static RexsRelationType create(String key, RexsRelationRole ... roles) {
		RexsRelationType relationType = new RexsRelationType(key, Arrays.asList(roles));
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

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof RexsRelationType other)) {
			return false;
		}
		if (!other.canEqual(this)) {
			return false;
		}
		Object this_key = getKey();
		Object other_key = other.getKey();
		return Objects.equals(this_key, other_key);
	}

	protected boolean canEqual(Object other) {
		return other instanceof RexsRelationType;
	}

	@Override
	public int hashCode() {
		int result = 1;
		Object _key = getKey();
		result = result * 59 + (_key == null ? 43 : _key.hashCode());
		return result;
	}
}
