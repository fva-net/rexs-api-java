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

public class AttributeIdTest {

	@Test
	public void create_givenNullIdThrowsIllegalArgumentException() throws Exception {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> {
				AttributeId.create(null, UnitId.kg);
			})
			.withMessage("id cannot be empty");
	}

	@Test
	public void create_givenNullUnitThrowsIllegalArgumentException() throws Exception {
		assertThatIllegalArgumentException()
		.isThrownBy(() -> {
			AttributeId.create("foo_bar", null);
		})
		.withMessage("unit cannot be empty");
	}

	@Test
	public void create_givenEmptyIdThrowsIllegalArgumentException() throws Exception {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> {
				AttributeId.create("", UnitId.kg);
			})
			.withMessage("id cannot be empty");
	}

	@Test
	public void create_newAttributeIdHasIdAndUnit() throws Exception {
		AttributeId newAttributeId = AttributeId.create("foo", UnitId.kg);
		assertThat(newAttributeId.getId()).isEqualTo("foo");
		assertThat(newAttributeId.getUnit()).isEqualTo(UnitId.kg);
	}

	@Test
	public void findById_givenNullReturnsNull() {
		assertThat(AttributeId.findById(null)).isNull();
	}

	@Test
	public void findById_givenUnknownIdReturnsNull() {
		assertThat(AttributeId.findById("foo_bar")).isNull();
	}

	@Test
	public void findById_returnsRexsStandardAttributeId() throws Exception {
		AttributeId attributeId = AttributeId.findById(AttributeId.width.getId());
		assertThat(attributeId).isNotNull();
		assertThat(attributeId.getId()).isEqualTo(AttributeId.width.getId());
	}

	@Test
	public void findById_returnsNewlyCreatedAttributeId() throws Exception {
		AttributeId.create("bar", UnitId.kg);
		AttributeId newAttributeId = AttributeId.findById("bar");
		assertThat(newAttributeId).isNotNull();
		assertThat(newAttributeId.getId()).isEqualTo("bar");
		assertThat(newAttributeId.getUnit()).isEqualTo(UnitId.kg);
	}

	@Test
	public void equals_equalObjects() {
		assertThat(AttributeId.number_of_teeth.equals(AttributeId.number_of_teeth)).isTrue();
		assertThat(AttributeId.create("test1", UnitId.kg)).isEqualTo(AttributeId.create("test1", UnitId.kg));
	}

	@Test
	public void equals_notEqualObjects() {
		assertThat(AttributeId.length).isNotEqualTo(AttributeId.width);
		assertThat(AttributeId.length).isNotEqualTo("length");
		assertThat(AttributeId.create("test2", UnitId.kg)).isNotEqualTo(AttributeId.create("test3", UnitId.kg));
		assertThat(AttributeId.create("test2", UnitId.kg)).isNotEqualTo(AttributeId.create("test2", UnitId.degree));
	}
}
