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

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * This enum represents a REXS value type.
 * <p>
 * It contains values for all value types of the REXS standard.
 *
 * @author FVA GmbH
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum RexsValueType {

    BOOLEAN(2, "boolean"),
    BOOLEAN_ARRAY(7, "boolean_array", BOOLEAN),
    BOOLEAN_MATRIX(16, "boolean_matrix", BOOLEAN),
    STRING(5, "string"),
    STRING_ARRAY(14, "string_array", STRING),
    STRING_MATRIX(17, "string_matrix", STRING),
    INTEGER(3, "integer"),
    INTEGER_ARRAY(11, "integer_array", INTEGER),
    INTEGER_MATRIX(15, "integer_matrix", INTEGER),
    FLOATING_POINT(1, "floating_point"),
    FLOATING_POINT_ARRAY(8, "floating_point_array", FLOATING_POINT),
    FLOATING_POINT_MATRIX(10, "floating_point_matrix", FLOATING_POINT),
    ENUM(4, "enum"),
    ENUM_ARRAY(12, "enum_array", ENUM),
    ARRAY_OF_INTEGER_ARRAYS(13, "array_of_integer_arrays", INTEGER),
    REFERENCE_COMPONENT(9, "reference_component"),
    FILE_REFERENCE(6, "file_reference"),
    DATE_TIME(19, "date_time");

    /**
     * The numeric ID of this value type.
     */
    private final int numericId;
    /**
     * The actual key of the value type.
     */
    private final String key;
    /**
     * The base type associated with the value type.
     */
    private final RexsValueType basicType;


    /**
     * Constructs a new RexsValueType with the specified numeric ID and key.
     *
     * @param id  The numeric ID of the RexsValueType.
     * @param key The actual key of the RexsValueType as a String.
     */
    RexsValueType(int id, String key) {
        this(id, key, null);
    }


    /**
     * Returns the value type for a textual key of all value types.
     *
     * @param key The actual key of the value type to be found as a {@link String}
     * @return The found value type as {@link RexsValueType}, or {@code null} if the key could not be found.
     */
    public static RexsValueType findByKey(String key) {
        if (key == null)
            return null;

        for (RexsValueType valueType : values()) {
            if (key.equals(valueType.getKey()))
                return valueType;
        }

        return null;
    }

    /**
     * Returns the value type for a numeric ID of all value types.
     *
     * @param numericId The numeric ID of the value type to be found.
     * @return The found value type as {@link RexsValueType}, or {@code null} if the ID could not be found.
     */
    public static RexsValueType findByNumericId(int numericId) {
        for (RexsValueType valueType : values()) {
            if (valueType.getNumericId() == numericId)
                return valueType;
        }
        return null;
    }

    /**
     * @return The base type associated with the data type.
     */
    public RexsValueType getBasicType() {
        if (basicType == null)
            return this;
        return basicType;
    }

    /**
     * Determines whether this RexsValueType is one of the specified RexsValueTypes.
     *
     * @param checkValueTypes The RexsValueTypes to check against.
     * @return true if this RexsValueType is one of the specified types, false otherwise.
     */
    public boolean isOneOf(RexsValueType... checkValueTypes) {
        if (checkValueTypes == null)
            return false;

        for (RexsValueType checkValueType : checkValueTypes) {
            if (this == checkValueType)
                return true;
        }
        return false;
    }
}
