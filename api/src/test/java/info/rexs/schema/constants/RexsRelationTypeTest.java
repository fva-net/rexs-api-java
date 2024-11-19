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

import info.rexs.schema.constants.standard.RexsStandardRelationTypes;

public class RexsRelationTypeTest {

	@Test
	public void create_givenNullThrowsIllegalArgumentException() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> {
				RexsRelationType.create(null);
			})
			.withMessage("key cannot be empty");
	}

	@Test
	public void create_givenEmptyIdThrowsIllegalArgumentException() {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> {
				RexsRelationType.create("");
			})
			.withMessage("key cannot be empty");
	}

	@Test
	public void create_newRelationTypeHasKey() {
		RexsRelationType newRelationType = RexsRelationType.create("foo");
		assertThat(newRelationType.getKey()).isEqualTo("foo");
	}

	@Test
	public void findByKey_givenNullReturnsNull() {
		assertThat(RexsRelationType.findByKey(null)).isNull();
	}

	@Test
	public void findByKey_givenUnknownKeyReturnsNull() {
		assertThat(RexsRelationType.findByKey("foo_bar")).isNull();
	}

	@Test
	public void findByKey_returnsRexsStandardRelationType() {
		RexsRelationType relationType = RexsRelationType.findByKey(RexsStandardRelationTypes.central_shaft.getKey());
		assertThat(relationType).isNotNull();
		assertThat(relationType.getKey()).isEqualTo(RexsStandardRelationTypes.central_shaft.getKey());
	}

	@Test
	public void findByKey_returnsNewlyCreatedRelationType() {
		RexsRelationType.create("bar");
		RexsRelationType newRelationType = RexsRelationType.findByKey("bar");
		assertThat(newRelationType).isNotNull();
		assertThat(newRelationType.getKey()).isEqualTo("bar");
	}

	@Test
	public void equals_equalObjects() {
		assertThat(RexsStandardRelationTypes.coupling.equals(RexsStandardRelationTypes.coupling)).isTrue();
		assertThat(RexsRelationType.create("test1")).isEqualTo(RexsRelationType.create("test1"));
	}

	@Test
	public void equals_notEqualObjects() {
		assertThat(RexsStandardRelationTypes.planet_carrier_shaft).isNotEqualTo(RexsStandardRelationTypes.planet_shaft);
		assertThat(RexsStandardRelationTypes.planet_carrier_shaft).isNotEqualTo("planet_carrier_shaft");
		assertThat(RexsRelationType.create("test2")).isNotEqualTo(RexsRelationType.create("test3"));
	}
}
