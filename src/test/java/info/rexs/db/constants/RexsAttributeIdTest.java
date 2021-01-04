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
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.Test;

public class RexsAttributeIdTest {

	@Test
	public void create_givenNullIdThrowsIllegalArgumentException() throws Exception {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> {
				RexsAttributeId.create(null, RexsUnitId.kg);
			})
			.withMessage("id cannot be empty");
	}

	@Test
	public void create_givenNullUnitThrowsIllegalArgumentException() throws Exception {
		assertThatIllegalArgumentException()
		.isThrownBy(() -> {
			RexsAttributeId.create("foo_bar", null);
		})
		.withMessage("unit cannot be empty");
	}

	@Test
	public void create_givenEmptyIdThrowsIllegalArgumentException() throws Exception {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> {
				RexsAttributeId.create("", RexsUnitId.kg);
			})
			.withMessage("id cannot be empty");
	}

	@Test
	public void create_newAttributeIdHasIdAndUnit() throws Exception {
		RexsAttributeId newAttributeId = RexsAttributeId.create("foo", RexsUnitId.kg);
		assertThat(newAttributeId.getId()).isEqualTo("foo");
		assertThat(newAttributeId.getUnit()).isEqualTo(RexsUnitId.kg);
	}

	@Test
	public void findById_givenNullReturnsNull() {
		assertThat(RexsAttributeId.findById(null)).isNull();
	}

	@Test
	public void findById_givenUnknownIdReturnsNull() {
		assertThat(RexsAttributeId.findById("foo_bar")).isNull();
	}

	@Test
	public void findById_returnsRexsStandardAttributeId() throws Exception {
		RexsAttributeId attributeId = RexsAttributeId.findById(RexsAttributeId.width.getId());
		assertThat(attributeId).isNotNull();
		assertThat(attributeId.getId()).isEqualTo(RexsAttributeId.width.getId());
	}

	@Test
	public void findById_returnsNewlyCreatedAttributeId() throws Exception {
		RexsAttributeId.create("bar", RexsUnitId.kg);
		RexsAttributeId newAttributeId = RexsAttributeId.findById("bar");
		assertThat(newAttributeId).isNotNull();
		assertThat(newAttributeId.getId()).isEqualTo("bar");
		assertThat(newAttributeId.getUnit()).isEqualTo(RexsUnitId.kg);
	}

	@Test
	public void equals_equalObjects() {
		assertThat(RexsAttributeId.number_of_teeth.equals(RexsAttributeId.number_of_teeth)).isTrue();
		assertThat(RexsAttributeId.create("test1", RexsUnitId.kg)).isEqualTo(RexsAttributeId.create("test1", RexsUnitId.kg));
	}

	@Test
	public void equals_notEqualObjects() {
		assertThat(RexsAttributeId.length).isNotEqualTo(RexsAttributeId.width);
		assertThat(RexsAttributeId.length).isNotEqualTo("length");
		assertThat(RexsAttributeId.create("test2", RexsUnitId.kg)).isNotEqualTo(RexsAttributeId.create("test3", RexsUnitId.kg));
		assertThat(RexsAttributeId.create("test2", RexsUnitId.kg)).isNotEqualTo(RexsAttributeId.create("test2", RexsUnitId.degree));
	}
}
