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
 * This enum represents a REXS value type.
 * <p>
 * It contains values for all value types of the REXS standard.
 *
 * @author FVA GmbH
 */
public enum ValueType {

	BOOLEAN("boolean"),
	BOOLEAN_ARRAY("boolean_array", BOOLEAN),
	BOOLEAN_MATRIX("boolean_matrix", BOOLEAN),
	STRING("string"),
	STRING_ARRAY("string_array", STRING),
	STRING_MATRIX("string_matrix", STRING),
	INTEGER("integer"),
	INTEGER_ARRAY("integer_array", INTEGER),
	INTEGER_MATRIX("integer_matrix", INTEGER),
	FLOATING_POINT("floating_point"),
	FLOATING_POINT_ARRAY("floating_point_array", FLOATING_POINT),
	FLOATING_POINT_MATRIX("floating_point_matrix", FLOATING_POINT),
	ENUM("enum"),
	REFERENCE_COMPONENT("reference_component"),
	FILE_REFERENCE("file_reference");

	/** The actual key of the value type as a {@link String}. */
	private final String key;

	/** The base type associated with the data type. */
	private final ValueType basicType;

	private ValueType(String key, ValueType basicType) {
		this.key = key;
		this.basicType = basicType;
	}

	private ValueType(String key) {
		this(key, null);
	}

	/**
	 * @return
	 * 				The actual key of the value type as a {@link String}.
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @return
	 * 				The base type associated with the data type.
	 */
	public ValueType getBasicType() {
		if (basicType == null)
			return this;
		return basicType;
	}

	/**
	 * Returns the value type for a textual key of all value types.
	 *
	 * @param key
	 * 				The actual key of the value type to be found as a {@link String}
	 *
	 * @return
	 * 				The found value type as {@link ValueType}, or {@code null} if the key could not be found.
	 */
	public static ValueType findByKey(String key) {
		if (key == null)
			return null;

		for (ValueType valueType : values()) {
			if (key.equals(valueType.getKey()))
				return valueType;
		}

		return null;
	}
}
