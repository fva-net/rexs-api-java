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
 * This enum represents a REXS relation type.
 * <p>
 * It contains values for all relation types of the REXS standard.
 *
 * @author FVA GmbH
 */
public enum RelationType {

	ASSEMBLY("assembly"),
	ORDERED_ASSEMBLY("ordered_assembly"),
	STAGE("stage"),
	STAGE_GEAR_DATA("stage_gear_data"),
	SIDE("side"),
	COUPLING("coupling"),
	FLANK("flank"),
	REFERENCE("reference"),
	ORDERED_REFERENCE("ordered_reference"),
	PLANET_SHAFT("planet_shaft"),
	CENTRAL_SHAFT("central_shaft"),
	PLANET_CARRIER_SHAFT("planet_carrier_shaft"),
	PLANET_PIN("planet_pin"),
	CONNECTION("connection");

	/** The actual key of the relation type as a {@link String}. */
	private final String key;

	private RelationType(String key) {
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
	 * Returns the relation type for a textual key of all relation types.
	 *
	 * @param key
	 * 				The actual key of the relation type to be found as a {@link String}
	 *
	 * @return
	 * 				The found relation type as {@link RelationType}, or {@code null} if the key could not be found.
	 */
	public static RelationType findByKey(String key) {
		if (key == null)
			return null;

		for (RelationType relationType : values()) {
			if (key.equals(relationType.getKey()))
				return relationType;
		}

		return null;
	}
}
