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

import info.rexs.schema.constants.standard.RexsStandardAttributeIds;
import info.rexs.schema.constants.standard.RexsStandardUnitIds;

public class RexsAttributeIdTest {

	@Test
	public void create_givenNullIdThrowsIllegalArgumentException() throws Exception {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> {
				RexsAttributeId.create(null, RexsStandardUnitIds.kg);
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
				RexsAttributeId.create("", RexsStandardUnitIds.kg);
			})
			.withMessage("id cannot be empty");
	}

	@Test
	public void create_newAttributeIdHasIdAndUnit() throws Exception {
		RexsAttributeId newAttributeId = RexsAttributeId.create("foo", RexsStandardUnitIds.kg);
		assertThat(newAttributeId.getId()).isEqualTo("foo");
		assertThat(newAttributeId.getUnit()).isEqualTo(RexsStandardUnitIds.kg);
	}

	@Test
	public void findById_givenNullReturnsNull() {
		assertThat(RexsAttributeId.findById(null)).isNull();
	}

	@Test
	public void findById_givenUnknownIdReturnsUnknown() {
		assertThat(RexsAttributeId.findById("foo_bar")).isEqualTo(RexsStandardAttributeIds.UNKNOWN);
	}

	@Test
	public void findById_returnsRexsStandardAttributeId() throws Exception {
		RexsAttributeId attributeId = RexsAttributeId.findById(RexsStandardAttributeIds.width.getId());
		assertThat(attributeId).isNotNull();
		assertThat(attributeId.getId()).isEqualTo(RexsStandardAttributeIds.width.getId());
	}

	@Test
	public void findById_returnsNewlyCreatedAttributeId() throws Exception {
		RexsAttributeId.create("bar", RexsStandardUnitIds.kg);
		RexsAttributeId newAttributeId = RexsAttributeId.findById("bar");
		assertThat(newAttributeId).isNotNull();
		assertThat(newAttributeId.getId()).isEqualTo("bar");
		assertThat(newAttributeId.getUnit()).isEqualTo(RexsStandardUnitIds.kg);
	}

	@Test
	public void equals_equalObjects() {
		assertThat(RexsStandardAttributeIds.number_of_teeth.equals(RexsStandardAttributeIds.number_of_teeth)).isTrue();
		assertThat(RexsAttributeId.create("test1", RexsStandardUnitIds.kg)).isEqualTo(RexsAttributeId.create("test1", RexsStandardUnitIds.kg));
	}

	@Test
	public void equals_notEqualObjects() {
		assertThat(RexsStandardAttributeIds.length).isNotEqualTo(RexsStandardAttributeIds.width);
		assertThat(RexsStandardAttributeIds.length).isNotEqualTo("length");
		assertThat(RexsAttributeId.create("test2", RexsStandardUnitIds.kg)).isNotEqualTo(RexsAttributeId.create("test3", RexsStandardUnitIds.kg));
		assertThat(RexsAttributeId.create("test2", RexsStandardUnitIds.kg)).isNotEqualTo(RexsAttributeId.create("test2", RexsStandardUnitIds.deg));
	}
}
