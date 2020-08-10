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

public class ComponentTypeTest {

	@Test
	public void create_givenNullThrowsIllegalArgumentException() throws Exception {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> {
				ComponentType.create(null);
			})
			.withMessage("id cannot be empty");
	}

	@Test
	public void create_givenEmptyIdThrowsIllegalArgumentException() throws Exception {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> {
				ComponentType.create("");
			})
			.withMessage("id cannot be empty");
	}

	@Test
	public void create_newComponentTypeHasId() throws Exception {
		ComponentType newComponentType = ComponentType.create("foo");
		assertThat(newComponentType.getId()).isEqualTo("foo");
	}

	@Test
	public void findById_givenNullReturnsNull() {
		assertThat(ComponentType.findById(null)).isNull();
	}

	@Test
	public void findById_givenUnknownIdReturnsNull() {
		assertThat(ComponentType.findById("foo_bar")).isNull();
	}

	@Test
	public void findById_returnsRexsStandardComponentType() throws Exception {
		ComponentType componentType = ComponentType.findById(ComponentType.coupling.getId());
		assertThat(componentType).isNotNull();
		assertThat(componentType.getId()).isEqualTo(ComponentType.coupling.getId());
	}

	@Test
	public void findById_returnsNewlyCreatedComponentType() throws Exception {
		ComponentType.create("bar");
		ComponentType newComponentType = ComponentType.findById("bar");
		assertThat(newComponentType).isNotNull();
		assertThat(newComponentType.getId()).isEqualTo("bar");
	}

	@Test
	public void equals_equalObjects() {
		assertThat(ComponentType.coupling.equals(ComponentType.coupling)).isTrue();
		assertThat(ComponentType.create("test1")).isEqualTo(ComponentType.create("test1"));
	}

	@Test
	public void equals_notEqualObjects() {
		assertThat(ComponentType.bevel_stage).isNotEqualTo(ComponentType.bevel_gear);
		assertThat(ComponentType.bevel_stage).isNotEqualTo("bevel_stage");
		assertThat(ComponentType.create("test2")).isNotEqualTo(ComponentType.create("test3"));
	}
}
