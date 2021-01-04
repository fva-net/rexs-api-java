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

public class RexsRelationTypeTest {

	@Test
	public void create_givenNullThrowsIllegalArgumentException() throws Exception {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> {
				RexsRelationType.create(null);
			})
			.withMessage("key cannot be empty");
	}

	@Test
	public void create_givenEmptyIdThrowsIllegalArgumentException() throws Exception {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> {
				RexsRelationType.create("");
			})
			.withMessage("key cannot be empty");
	}

	@Test
	public void create_newRelationTypeHasKey() throws Exception {
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
	public void findByKey_returnsRexsStandardRelationType() throws Exception {
		RexsRelationType relationType = RexsRelationType.findByKey(RexsRelationType.central_shaft.getKey());
		assertThat(relationType).isNotNull();
		assertThat(relationType.getKey()).isEqualTo(RexsRelationType.central_shaft.getKey());
	}

	@Test
	public void findByKey_returnsNewlyCreatedRelationType() throws Exception {
		RexsRelationType.create("bar");
		RexsRelationType newRelationType = RexsRelationType.findByKey("bar");
		assertThat(newRelationType).isNotNull();
		assertThat(newRelationType.getKey()).isEqualTo("bar");
	}

	@Test
	public void equals_equalObjects() {
		assertThat(RexsRelationType.coupling.equals(RexsRelationType.coupling)).isTrue();
		assertThat(RexsRelationType.create("test1")).isEqualTo(RexsRelationType.create("test1"));
	}

	@Test
	public void equals_notEqualObjects() {
		assertThat(RexsRelationType.planet_carrier_shaft).isNotEqualTo(RexsRelationType.planet_shaft);
		assertThat(RexsRelationType.planet_carrier_shaft).isNotEqualTo("planet_carrier_shaft");
		assertThat(RexsRelationType.create("test2")).isNotEqualTo(RexsRelationType.create("test3"));
	}
}
