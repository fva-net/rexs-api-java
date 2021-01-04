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
package info.rexs.db;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.io.InputStream;
import java.util.Locale;

import org.junit.Test;

import info.rexs.db.constants.RexsVersion;

public class DbModelFileTest {

	@Test
	public void create_givenNullVersionThrowsIllegalArgumentException() throws Exception {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> {
				DbModelFile.create(null, Locale.getDefault());
			})
			.withMessage("version cannot be empty");
	}

	@Test
	public void create_givenNullLocaleConvertsToEnglish() throws Exception {
		DbModelFile dbModelFile = DbModelFile.create(RexsVersion.V1_0, null);

		assertThat(dbModelFile.getLanguage()).isEqualTo(Locale.ENGLISH.getLanguage());
	}

	@Test
	public void create_givenUnknownLocaleConvertsToDefault() throws Exception {
		DbModelFile dbModelFile = DbModelFile.create(RexsVersion.V1_0, Locale.CHINESE);

		assertThat(dbModelFile.getLanguage()).isEqualTo(Locale.ENGLISH.getLanguage());
	}

	@Test
	public void create_givenKnownLocaleIsTaken() throws Exception {
		DbModelFile dbModelFile = DbModelFile.create(RexsVersion.V1_0, Locale.GERMAN);

		assertThat(dbModelFile.getLanguage()).isEqualTo(Locale.GERMAN.getLanguage());
	}

	@Test
	public void create_givenNullFileResolverConvertsToDefault() throws Exception {
		DbModelFile dbModelFile = DbModelFile.create(RexsVersion.V1_0, Locale.GERMAN, null);

		try (InputStream input = dbModelFile.openInputStream()) {
			assertThat(input).isNotNull();
		}
	}

	@Test
	public void create_givenNewFileResolverIsTaken() throws Exception {
		DbModelFileResolver newDbModelFileResolver = new DbModelFileResolver() {
			@Override
			public InputStream openInputStream(DbModelFile dbModelFile) {
				return super.openInputStream(dbModelFile);
			}
		};

		DbModelFile dbModelFile = DbModelFile.create(RexsVersion.V1_0, Locale.GERMAN, newDbModelFileResolver);
		try (InputStream input = dbModelFile.openInputStream()) {
			assertThat(input).isNotNull();
		}
	}

	@Test
	public void findByVersionAndLocale_givenNullVersionReturnsNull() {
		assertThat(DbModelFile.findByVersionAndLocale(null, Locale.getDefault())).isNull();
	}

	@Test
	public void findByVersionAndLocale_givenNullLocaleConvertsToDefault() {
		assertThat(DbModelFile.findByVersionAndLocale(RexsVersion.V1_1, null).getLanguage()).isEqualTo(Locale.ENGLISH.getLanguage());
	}

	@Test
	public void findByVersionAndLocale_givenUnknownVersionReturnsNull() {
		assertThat(DbModelFile.findByVersionAndLocale(RexsVersion.create("m.n"), Locale.GERMAN)).isNull();
	}

	@Test
	public void findByVersionAndLocale_returnsRequestedDbModelFile() throws Exception {
		DbModelFile dbModelFile = DbModelFile.findByVersionAndLocale(RexsVersion.V1_2, Locale.GERMAN);
		assertThat(dbModelFile).isNotNull();
		assertThat(dbModelFile.getVersion()).isEqualTo(RexsVersion.V1_2);
		assertThat(dbModelFile.getLanguage()).isEqualTo(Locale.GERMAN.getLanguage());
	}

	@Test
	public void findByVersionAndLocale_returnsNewlyCreatedDbModelFile() throws Exception {
		RexsVersion newVersion = RexsVersion.create("n.o");
		DbModelFile.create(newVersion, Locale.GERMAN);
		DbModelFile newDbModelFile = DbModelFile.findByVersionAndLocale(newVersion, Locale.GERMAN);
		assertThat(newDbModelFile).isNotNull();
		assertThat(newDbModelFile.getVersion().getName()).isEqualTo("n.o");
		assertThat(newDbModelFile.getLanguage()).isEqualTo(Locale.GERMAN.getLanguage());
	}

	@Test
	public void equals_equalObjects() {
		assertThat(DbModelFile.V1_0_GERMAN.equals(DbModelFile.V1_0_GERMAN)).isTrue();

		RexsVersion newVersion = RexsVersion.create("o.p");
		assertThat(DbModelFile.create(newVersion, Locale.ENGLISH)).isEqualTo(DbModelFile.create(newVersion, Locale.ENGLISH));
	}

	@Test
	public void equals_notEqualObjects() {
		assertThat(DbModelFile.V1_1_ENGLISH).isNotEqualTo(DbModelFile.V1_1_GERMAN);
		assertThat(DbModelFile.V1_1_ENGLISH).isNotEqualTo("test");

		RexsVersion newVersion1 = RexsVersion.create("p.q");
		RexsVersion newVersion2 = RexsVersion.create("q.r");
		assertThat(DbModelFile.create(newVersion1, Locale.ENGLISH)).isNotEqualTo(DbModelFile.create(newVersion1, Locale.GERMAN));
		assertThat(DbModelFile.create(newVersion1, Locale.ENGLISH)).isNotEqualTo(DbModelFile.create(newVersion2, Locale.ENGLISH));
	}
}
