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

import info.rexs.schema.constants.standard.RexsStandardRelationRoles;

public class RexsRelationRoleTest {

	@Test
	public void create_givenNullThrowsIllegalArgumentException() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> RexsRelationRole.create(null))
			.withMessage("key cannot be empty");
	}

	@Test
	public void create_givenEmptyIdThrowsIllegalArgumentException() {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> RexsRelationRole.create(""))
			.withMessage("key cannot be empty");
	}

	@Test
	public void create_newRelationRoleHasKey() {
		RexsRelationRole newRelationRole = RexsRelationRole.create("foo");
		assertThat(newRelationRole.getKey()).isEqualTo("foo");
	}

	@Test
	public void findByKey_givenNullReturnsNull() {
		assertThat(RexsRelationRole.findByKey(null)).isNull();
	}

	@Test
	public void findByKey_givenUnknownKeyReturnsNull() {
		assertThat(RexsRelationRole.findByKey("foo_bar")).isNull();
	}

	@Test
	public void findByKey_returnsRexsStandardRelationRole() {
		RexsRelationRole relationRole = RexsRelationRole.findByKey(RexsStandardRelationRoles.inner_part.getKey());
		assertThat(relationRole).isNotNull();
		assertThat(relationRole.getKey()).isEqualTo(RexsStandardRelationRoles.inner_part.getKey());
	}

	@Test
	public void findByKey_returnsNewlyCreatedRelationRole() {
		RexsRelationRole.create("bar");
		RexsRelationRole newRelationRole = RexsRelationRole.findByKey("bar");
		assertThat(newRelationRole).isNotNull();
		assertThat(newRelationRole.getKey()).isEqualTo("bar");
	}

	@Test
	public void equals_equalObjects() {
		assertThat(RexsStandardRelationRoles.manufacturing_settings.equals(RexsStandardRelationRoles.manufacturing_settings)).isTrue();
		assertThat(RexsRelationRole.create("test1")).isEqualTo(RexsRelationRole.create("test1"));
	}

	@Test
	public void equals_notEqualObjects() {
		assertThat(RexsStandardRelationRoles.outer_part).isNotEqualTo(RexsStandardRelationRoles.inner_part);
		assertThat(RexsStandardRelationRoles.outer_part).isNotEqualTo("outer_part");
		assertThat(RexsRelationRole.create("test2")).isNotEqualTo(RexsRelationRole.create("test3"));
	}
}
