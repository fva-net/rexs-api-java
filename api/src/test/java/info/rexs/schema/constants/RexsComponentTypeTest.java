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

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.Test;

import info.rexs.schema.constants.standard.RexsStandardComponentTypes;

public class RexsComponentTypeTest {

	@Test
	public void create_givenNullThrowsIllegalArgumentException() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> RexsComponentType.create(null))
			.withMessage("id cannot be empty");
	}

	@Test
	public void create_givenEmptyIdThrowsIllegalArgumentException() {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> RexsComponentType.create(""))
			.withMessage("id cannot be empty");
	}

	@Test
	public void create_newComponentTypeHasId() {
		RexsComponentType newComponentType = RexsComponentType.create("foo");
		assertThat(newComponentType.getId()).isEqualTo("foo");
	}

	@Test
	public void findById_givenNullReturnsNull() {
		assertThat(RexsComponentType.findById(null)).isNull();;
	}

	@Test
	public void findById_givenUnknownIdReturnsUnknown() {
		assertThat(RexsComponentType.findById("foo_bar")).isEqualTo(RexsStandardComponentTypes.UNKNOWN);
	}

	@Test
	public void findById_returnsRexsStandardComponentType() {
		RexsComponentType componentType = RexsComponentType.findById(RexsStandardComponentTypes.coupling.getId());
		assertThat(componentType).isNotNull();
		assertThat(componentType.getId()).isEqualTo(RexsStandardComponentTypes.coupling.getId());
	}

	@Test
	public void findById_returnsNewlyCreatedComponentType() {
		RexsComponentType.create("bar");
		RexsComponentType newComponentType = RexsComponentType.findById("bar");
		assertThat(newComponentType).isNotNull();
		assertThat(newComponentType.getId()).isEqualTo("bar");
	}

	@Test
	public void equals_equalObjects() {
		assertThat(RexsStandardComponentTypes.coupling.equals(RexsStandardComponentTypes.coupling)).isTrue();
		assertThat(RexsComponentType.create("test1")).isEqualTo(RexsComponentType.create("test1"));
	}

	@Test
	public void equals_notEqualObjects() {
		assertThat(RexsStandardComponentTypes.bevel_stage).isNotEqualTo(RexsStandardComponentTypes.bevel_gear);
		assertThat(RexsStandardComponentTypes.bevel_stage).isNotEqualTo("bevel_stage");
		assertThat(RexsComponentType.create("test2")).isNotEqualTo(RexsComponentType.create("test3"));
	}
}
