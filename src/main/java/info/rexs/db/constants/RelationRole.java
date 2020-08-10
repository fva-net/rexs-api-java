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

/**
 * This enum represents a REXS relation role.
 * <p>
 * It contains values for all relation roles of the REXS standard.
 *
 * @author FVA GmbH
 */
public enum RelationRole {

	ASSEMBLY("assembly"),
	PART("part"),
	STAGE("stage"),
	GEAR("gear"),
	GEAR_1("gear_1"),
	GEAR_2("gear_2"),
	STAGE_GEAR_DATA("stage_gear_data"),
	LEFT("left"),
	RIGHT("right"),
	INNER_PART("inner_part"),
	OUTER_PART("outer_part"),
	SIDE_1("side_1"),
	SIDE_2("side_2"),
	ORIGIN("origin"),
	REFERENCED("referenced"),
	PLANETARY_STAGE("planetary_stage"),
	SHAFT("shaft");

	/** The actual key of the relation role as a {@link String}. */
	private final String key;

	private RelationRole(String key) {
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
	 * Returns the relation role for a textual key of all relation roles.
	 *
	 * @param key
	 * 				The actual key of the relation role to be found as a {@link String}
	 *
	 * @return
	 * 				The found relation role as {@link RelationRole}, or {@code null} if the key could not be found.
	 */
	public static RelationRole findByKey(String key) {
		if (key == null)
			return null;

		for (RelationRole relationRole : values()) {
			if (key.equals(relationRole.getKey()))
				return relationRole;
		}

		return null;
	}
}
