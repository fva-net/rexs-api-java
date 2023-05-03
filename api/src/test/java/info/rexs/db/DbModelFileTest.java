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

import org.junit.Test;

import info.rexs.db.constants.RexsVersion;

public class DbModelFileTest {

	@Test
	public void create_givenNullVersionThrowsIllegalArgumentException() throws Exception {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> {
				DbModelFile.create(null);
			})
			.withMessage("version cannot be empty");
	}

	@Test
	public void create_givenNullFileResolverConvertsToDefault() throws Exception {
		DbModelFile dbModelFile = DbModelFile.create(RexsVersion.V1_0, null);

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

		DbModelFile dbModelFile = DbModelFile.create(RexsVersion.V1_0, newDbModelFileResolver);
		try (InputStream input = dbModelFile.openInputStream()) {
			assertThat(input).isNotNull();
		}
	}

	@Test
	public void findByVersion_givenNullVersionReturnsNull() {
		assertThat(DbModelFile.findByVersion(null)).isNull();
	}

	@Test
	public void findByVersion_givenUnknownVersionReturnsNull() {
		assertThat(DbModelFile.findByVersion(RexsVersion.create("m.n", 10000))).isNull();
	}

	@Test
	public void findByVersion_returnsRequestedDbModelFile() throws Exception {
		DbModelFile dbModelFile = DbModelFile.findByVersion(RexsVersion.V1_2);
		assertThat(dbModelFile).isNotNull();
		assertThat(dbModelFile.getVersion()).isEqualTo(RexsVersion.V1_2);
	}

	@Test
	public void findByVersion_returnsNewlyCreatedDbModelFile() throws Exception {
		RexsVersion newVersion = RexsVersion.create("n.o", 11000);
		DbModelFile.create(newVersion);
		DbModelFile newDbModelFile = DbModelFile.findByVersion(newVersion);
		assertThat(newDbModelFile).isNotNull();
		assertThat(newDbModelFile.getVersion().getName()).isEqualTo("n.o");
	}

	@Test
	public void equals_equalObjects() {
		assertThat(DbModelFile.V1_0.equals(DbModelFile.V1_0)).isTrue();

		RexsVersion newVersion = RexsVersion.create("o.p", 12000);
		assertThat(DbModelFile.create(newVersion)).isEqualTo(DbModelFile.create(newVersion));
	}

	@Test
	public void equals_notEqualObjects() {
		assertThat(DbModelFile.V1_1).isNotEqualTo(DbModelFile.V1_2);
		assertThat(DbModelFile.V1_1).isNotEqualTo("test");

		RexsVersion newVersion1 = RexsVersion.create("p.q", 13000);
		RexsVersion newVersion2 = RexsVersion.create("q.r", 14000);
		assertThat(DbModelFile.create(newVersion1)).isNotEqualTo(DbModelFile.create(newVersion2));
	}
}
