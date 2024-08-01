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

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import org.junit.Test;

public class RexsValueTypeTest {

	@Test
	public void getKey_notNullAndNotEmpty() {
		Stream.of(RexsValueType.values()).forEach(valueType -> {
			assertThat(valueType.getKey()).isNotNull();
			assertThat(valueType.getKey()).isNotEmpty();
		});
	}

	@Test
	public void getKey_returnsUniqueKey() {
		Set<String> usedKeys = new HashSet<>();
		Stream.of(RexsValueType.values()).forEach(valueType -> {
			assertThat(usedKeys).doesNotContain(valueType.getKey());
			usedKeys.add(valueType.getKey());
		});
	}

	@Test
	public void getNumericId_notZero() {
		Stream.of(RexsValueType.values()).forEach(valueType -> assertThat(valueType.getNumericId()).isNotZero());
	}

	@Test
	public void getNumericId_returnsUniqueValues() {
		Set<Integer> usedIds = new HashSet<>();
		Stream.of(RexsValueType.values()).forEach(valueType -> {
			assertThat(usedIds).doesNotContain(valueType.getNumericId());
			usedIds.add(valueType.getNumericId());
		});
	}

	@Test
	public void getBasicType_assignmentsCorrect() {
		assertThat(RexsValueType.BOOLEAN.getBasicType()).isEqualTo(RexsValueType.BOOLEAN);
		assertThat(RexsValueType.BOOLEAN_ARRAY.getBasicType()).isEqualTo(RexsValueType.BOOLEAN);
		assertThat(RexsValueType.BOOLEAN_MATRIX.getBasicType()).isEqualTo(RexsValueType.BOOLEAN);

		assertThat(RexsValueType.STRING.getBasicType()).isEqualTo(RexsValueType.STRING);
		assertThat(RexsValueType.STRING_ARRAY.getBasicType()).isEqualTo(RexsValueType.STRING);
		assertThat(RexsValueType.STRING_MATRIX.getBasicType()).isEqualTo(RexsValueType.STRING);

		assertThat(RexsValueType.INTEGER.getBasicType()).isEqualTo(RexsValueType.INTEGER);
		assertThat(RexsValueType.INTEGER_ARRAY.getBasicType()).isEqualTo(RexsValueType.INTEGER);
		assertThat(RexsValueType.INTEGER_MATRIX.getBasicType()).isEqualTo(RexsValueType.INTEGER);

		assertThat(RexsValueType.FLOATING_POINT.getBasicType()).isEqualTo(RexsValueType.FLOATING_POINT);
		assertThat(RexsValueType.FLOATING_POINT_ARRAY.getBasicType()).isEqualTo(RexsValueType.FLOATING_POINT);
		assertThat(RexsValueType.FLOATING_POINT_MATRIX.getBasicType()).isEqualTo(RexsValueType.FLOATING_POINT);

		assertThat(RexsValueType.ENUM.getBasicType()).isEqualTo(RexsValueType.ENUM);
		assertThat(RexsValueType.ENUM_ARRAY.getBasicType()).isEqualTo(RexsValueType.ENUM);

		assertThat(RexsValueType.REFERENCE_COMPONENT.getBasicType()).isEqualTo(RexsValueType.REFERENCE_COMPONENT);

		assertThat(RexsValueType.FILE_REFERENCE.getBasicType()).isEqualTo(RexsValueType.FILE_REFERENCE);
	}

	@Test
	public void findByKey_givenNullReturnsNull() {
		assertThat(RexsValueType.findByKey(null)).isNull();
	}

	@Test
	public void findByKey_givenUnknownIdReturnsNull() {
		assertThat(RexsValueType.findByKey("foo_bar")).isNull();
	}

	@Test
	public void findByKey_returnsCorrectValueType() {
		RexsValueType valueType = RexsValueType.findByKey(RexsValueType.FLOATING_POINT_ARRAY.getKey());
		assertThat(valueType).isNotNull();
		assertThat(valueType).isEqualTo(RexsValueType.FLOATING_POINT_ARRAY);
	}

	@Test
	public void findByNumericId_givenNullReturnsNull() {
		assertThat(RexsValueType.findByNumericId(0)).isNull();
	}

	@Test
	public void findByNumericId_givenUnknownIdReturnsNull() {
		assertThat(RexsValueType.findByNumericId(-1)).isNull();
	}

	@Test
	public void findByNumericId_returnsCorrectValueType() {
		RexsValueType valueType = RexsValueType.findByNumericId(RexsValueType.FLOATING_POINT_ARRAY.getNumericId());
		assertThat(valueType).isNotNull();
		assertThat(valueType).isEqualTo(RexsValueType.FLOATING_POINT_ARRAY);
	}

	@Test
	public void isOneOf_returnsTrueForMatchingTypes() {
		assertThat(RexsValueType.INTEGER.isOneOf(RexsValueType.INTEGER, RexsValueType.INTEGER_ARRAY)).isTrue();
		assertThat(RexsValueType.INTEGER_ARRAY.isOneOf(RexsValueType.INTEGER, RexsValueType.INTEGER_ARRAY)).isTrue();
	}

	@Test
	public void isOneOf_returnsFalseForNonMatchingTypes() {
		assertThat(RexsValueType.INTEGER.isOneOf(RexsValueType.FLOATING_POINT, RexsValueType.BOOLEAN)).isFalse();
		assertThat(RexsValueType.FLOATING_POINT.isOneOf(RexsValueType.BOOLEAN_ARRAY, RexsValueType.DATE_TIME)).isFalse();
	}

	@Test
	public void isOneOf_returnsFalseForNullArgument() {
		assertThat(RexsValueType.STRING.isOneOf((RexsValueType[]) null)).isFalse();
	}

	@Test
	public void isOneOf_returnsFalseForEmptyArgument() {
		assertThat(RexsValueType.STRING.isOneOf()).isFalse();
	}
}
