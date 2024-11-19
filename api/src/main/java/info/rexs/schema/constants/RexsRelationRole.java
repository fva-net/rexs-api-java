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

import java.util.HashMap;
import java.util.Map;

import info.rexs.schema.constants.standard.RexsStandardRelationRoles;

/**
 * This class represents a REXS relation role.
 * <p>
 * It contains constants for all relation roles of official REXS versions.
 * <p>
 * Since REXS is freely expandable, you can also add your own relation roles using the {@link #create(String)} method.
 *
 * @author FVA GmbH
 */
public class RexsRelationRole implements RexsStandardRelationRoles {

	/** An internal index with all created relation roles (REXS standard and own) for quick access. */
	private static Map<String, RexsRelationRole> allRelationRoles = new HashMap<>();

	/** The actual key of the relation role as a {@link String}. */
	private final String key;

	private RexsRelationRole(String key) {
		if (key == null || key.isEmpty())
			throw new IllegalArgumentException("key cannot be empty");
		this.key = key;
	}

	/**
	 * @return
	 * 				The actual key of the relation role as a {@link String}.
	 */
	public String getKey() {
		return key;
	}

	/**
	 * TODO Document me!
	 *
	 * @param checkRelationRoles
	 * 				TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public boolean isOneOf(RexsRelationRole ... checkRelationRoles)
	{
		if (checkRelationRoles == null)
			return false;

		for (RexsRelationRole checkRelationRole : checkRelationRoles)
		{
			if (this.equals(checkRelationRole))
				return true;
		}

		return false;
	}

	/**
	 * Creates a new relation role and adds it to the internal index.
	 *
	 * @param key
	 * 				The actual key of the relation role as a {@link String}.
	 *
	 * @return
	 * 				The newly created relation role as {@link RexsRelationRole}.
	 */
	public static RexsRelationRole create(String key) {
		RexsRelationRole relationRole = new RexsRelationRole(key);
		allRelationRoles.put(key, relationRole);
		return relationRole;
	}

	/**
	 * Returns the relation role for a textual key from the internally stored index of all relation roles.
	 *
	 * @param key
	 * 				The actual key of the relation role to be found as a {@link String}
	 *
	 * @return
	 * 				The found relation role as {@link RexsRelationRole}, or {@code null} if the key could not be found.
	 */
	public static RexsRelationRole findByKey(String key) {
		if (key == null)
			return null;
		RexsStandardRelationRoles.init();
		return allRelationRoles.getOrDefault(key, null);
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof RexsRelationRole other)) {
			return false;
		}
		if (!other.canEqual(this)) {
			return false;
		}
		Object this_key = getKey();
		Object other_key = other.getKey();
		return this_key == null ? other_key == null : this_key.equals(other_key);
	}

	protected boolean canEqual(Object other) {
		return other instanceof RexsRelationRole;
	}

	@Override
	public int hashCode() {
		int result = 1;
		Object _key = getKey();
		result = result * 59 + (_key == null ? 43 : _key.hashCode());
		return result;
	}
}
