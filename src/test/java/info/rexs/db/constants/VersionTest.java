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

public class VersionTest {

	@Test
	public void getLatest_returnsNotNull() throws Exception {
		assertThat(Version.getLatest()).isNotNull();
	}

	@Test
	public void create_givenNullThrowsIllegalArgumentException() throws Exception {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> {
				Version.create(null);
			})
			.withMessage("name cannot be empty");
	}

	@Test
	public void create_givenEmptyIdThrowsIllegalArgumentException() throws Exception {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> {
				Version.create("");
			})
			.withMessage("name cannot be empty");
	}

	@Test
	public void create_givenNullAlternativeNamesDoesNotCrash() throws Exception {
		Version newVersion = Version.create("a.b", (String[])null);
		assertThat(newVersion.getName()).isEqualTo("a.b");
	}

	@Test
	public void create_newVersionHasName() throws Exception {
		Version newVersion = Version.create("a.b");
		assertThat(newVersion.getName()).isEqualTo("a.b");
	}

	@Test
	public void findByName_givenNullReturnsNull() {
		assertThat(Version.findByName(null)).isNull();
	}

	@Test
	public void findByName_givenUnknownNameReturnsNull() {
		assertThat(Version.findByName("foo.bar")).isNull();
	}

	@Test
	public void findByName_returnsRexsStandardVersion() throws Exception {
		Version version = Version.findByName(Version.V1_0.getName());
		assertThat(version).isNotNull();
		assertThat(version.getName()).isEqualTo(Version.V1_0.getName());
	}

	@Test
	public void findByName_returnsNewlyCreatedVersion() throws Exception {
		Version.create("b.c");
		Version newVersion = Version.findByName("b.c");
		assertThat(newVersion).isNotNull();
		assertThat(newVersion.getName()).isEqualTo("b.c");
	}

	@Test
	public void findByName_returnsNewlyCreatedVersionByAlternativeVersionName() throws Exception {
		Version.create("c.d", "d.e", "e.f");

		Version newVersionByName = Version.findByName("c.d");
		assertThat(newVersionByName).isNotNull();
		assertThat(newVersionByName.getName()).isEqualTo("c.d");

		Version newVersionByAlternativeName = Version.findByName("d.e");
		assertThat(newVersionByAlternativeName).isNotNull();
		assertThat(newVersionByAlternativeName.getName()).isEqualTo("c.d");

		newVersionByAlternativeName = Version.findByName("e.f");
		assertThat(newVersionByAlternativeName).isNotNull();
		assertThat(newVersionByAlternativeName.getName()).isEqualTo("c.d");
	}
}
