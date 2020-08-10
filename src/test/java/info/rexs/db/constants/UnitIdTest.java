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

public class UnitIdTest {

	@Test
	public void create_givenNullThrowsIllegalArgumentException() throws Exception {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> {
				UnitId.create(null);
			})
			.withMessage("id cannot be empty");
	}

	@Test
	public void create_givenEmptyIdThrowsIllegalArgumentException() throws Exception {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> {
				UnitId.create("");
			})
			.withMessage("id cannot be empty");
	}

	@Test
	public void create_newUnitIdHasId() throws Exception {
		UnitId newUnitId = UnitId.create("foo");
		assertThat(newUnitId.getId()).isEqualTo("foo");
	}

	@Test
	public void findById_givenNullReturnsNull() {
		assertThat(UnitId.findById(null)).isNull();
	}

	@Test
	public void findById_givenUnknownIdReturnsNull() {
		assertThat(UnitId.findById("foo_bar")).isNull();
	}

	@Test
	public void findById_returnsRexsStandardUnitId() throws Exception {
		UnitId unitId = UnitId.findById(UnitId.hertz.getId());
		assertThat(unitId).isNotNull();
		assertThat(unitId.getId()).isEqualTo(UnitId.hertz.getId());
	}

	@Test
	public void findById_returnsNewlyCreatedUnitId() throws Exception {
		UnitId.create("bar");
		UnitId newUnitId = UnitId.findById("bar");
		assertThat(newUnitId).isNotNull();
		assertThat(newUnitId.getId()).isEqualTo("bar");
	}
}
