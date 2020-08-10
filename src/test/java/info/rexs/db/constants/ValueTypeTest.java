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

public class ValueTypeTest {

	@Test
	public void getKey_notNullAndNotEmpty() throws Exception {
		Stream.of(ValueType.values()).forEach(valueType -> {
			assertThat(valueType.getKey()).isNotNull();
			assertThat(valueType.getKey()).isNotEmpty();
		});
	}

	@Test
	public void getKey_returnsUniqueKey() throws Exception {
		Set<String> usedKeys = new HashSet<>();
		Stream.of(ValueType.values()).forEach(valueType -> {
			assertThat(usedKeys).doesNotContain(valueType.getKey());
			usedKeys.add(valueType.getKey());
		});
	}

	@Test
	public void getBasicType_assignmentsCorrect() throws Exception {
		assertThat(ValueType.BOOLEAN.getBasicType()).isEqualTo(ValueType.BOOLEAN);
		assertThat(ValueType.BOOLEAN_ARRAY.getBasicType()).isEqualTo(ValueType.BOOLEAN);
		assertThat(ValueType.BOOLEAN_MATRIX.getBasicType()).isEqualTo(ValueType.BOOLEAN);

		assertThat(ValueType.STRING.getBasicType()).isEqualTo(ValueType.STRING);
		assertThat(ValueType.STRING_ARRAY.getBasicType()).isEqualTo(ValueType.STRING);
		assertThat(ValueType.STRING_MATRIX.getBasicType()).isEqualTo(ValueType.STRING);

		assertThat(ValueType.INTEGER.getBasicType()).isEqualTo(ValueType.INTEGER);
		assertThat(ValueType.INTEGER_ARRAY.getBasicType()).isEqualTo(ValueType.INTEGER);
		assertThat(ValueType.INTEGER_MATRIX.getBasicType()).isEqualTo(ValueType.INTEGER);

		assertThat(ValueType.FLOATING_POINT.getBasicType()).isEqualTo(ValueType.FLOATING_POINT);
		assertThat(ValueType.FLOATING_POINT_ARRAY.getBasicType()).isEqualTo(ValueType.FLOATING_POINT);
		assertThat(ValueType.FLOATING_POINT_MATRIX.getBasicType()).isEqualTo(ValueType.FLOATING_POINT);

		assertThat(ValueType.ENUM.getBasicType()).isEqualTo(ValueType.ENUM);

		assertThat(ValueType.REFERENCE_COMPONENT.getBasicType()).isEqualTo(ValueType.REFERENCE_COMPONENT);

		assertThat(ValueType.FILE_REFERENCE.getBasicType()).isEqualTo(ValueType.FILE_REFERENCE);
	}

	@Test
	public void findByKey_givenNullReturnsNull() {
		assertThat(ValueType.findByKey(null)).isNull();
	}

	@Test
	public void findByKey_givenUnknownIdReturnsNull() {
		assertThat(ValueType.findByKey("foo_bar")).isNull();
	}

	@Test
	public void findByKey_returnsCorrectValueType() throws Exception {
		ValueType valueType = ValueType.findByKey(ValueType.FLOATING_POINT_ARRAY.getKey());
		assertThat(valueType).isNotNull();
		assertThat(valueType).isEqualTo(ValueType.FLOATING_POINT_ARRAY);
	}
}
