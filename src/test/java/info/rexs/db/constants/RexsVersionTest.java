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

public class RexsVersionTest {

	@Test
	public void getLatest_returnsNotNull() throws Exception {
		assertThat(RexsVersion.getLatest()).isNotNull();
	}

	@Test
	public void create_givenNullThrowsIllegalArgumentException() throws Exception {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> {
				RexsVersion.create(null);
			})
			.withMessage("name cannot be empty");
	}

	@Test
	public void create_givenEmptyIdThrowsIllegalArgumentException() throws Exception {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> {
				RexsVersion.create("");
			})
			.withMessage("name cannot be empty");
	}

	@Test
	public void create_givenNullAlternativeNamesDoesNotCrash() throws Exception {
		RexsVersion newVersion = RexsVersion.create("a.b", (String[])null);
		assertThat(newVersion.getName()).isEqualTo("a.b");
	}

	@Test
	public void create_newVersionHasName() throws Exception {
		RexsVersion newVersion = RexsVersion.create("a.b");
		assertThat(newVersion.getName()).isEqualTo("a.b");
	}

	@Test
	public void findByName_givenNullReturnsNull() {
		assertThat(RexsVersion.findByName(null)).isNull();
	}

	@Test
	public void findByName_givenUnknownNameReturnsNull() {
		assertThat(RexsVersion.findByName("foo.bar")).isNull();
	}

	@Test
	public void findByName_returnsRexsStandardVersion() throws Exception {
		RexsVersion version = RexsVersion.findByName(RexsVersion.V1_0.getName());
		assertThat(version).isNotNull();
		assertThat(version.getName()).isEqualTo(RexsVersion.V1_0.getName());
	}

	@Test
	public void findByName_returnsNewlyCreatedVersion() throws Exception {
		RexsVersion.create("b.c");
		RexsVersion newVersion = RexsVersion.findByName("b.c");
		assertThat(newVersion).isNotNull();
		assertThat(newVersion.getName()).isEqualTo("b.c");
	}

	@Test
	public void findByName_returnsNewlyCreatedVersionByAlternativeVersionName() throws Exception {
		RexsVersion.create("c.d", "d.e", "e.f");

		RexsVersion newVersionByName = RexsVersion.findByName("c.d");
		assertThat(newVersionByName).isNotNull();
		assertThat(newVersionByName.getName()).isEqualTo("c.d");

		RexsVersion newVersionByAlternativeName = RexsVersion.findByName("d.e");
		assertThat(newVersionByAlternativeName).isNotNull();
		assertThat(newVersionByAlternativeName.getName()).isEqualTo("c.d");

		newVersionByAlternativeName = RexsVersion.findByName("e.f");
		assertThat(newVersionByAlternativeName).isNotNull();
		assertThat(newVersionByAlternativeName.getName()).isEqualTo("c.d");
	}
}
