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
package info.rexs.schema;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.io.InputStream;

import org.junit.Test;

import info.rexs.schema.constants.RexsVersion;
import info.rexs.schema.constants.standard.RexsStandardVersions;

public class RexsSchemaFileTest {

	@Test
	public void create_givenNullVersionThrowsIllegalArgumentException() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> RexsSchemaFile.create(null))
			.withMessage("version cannot be empty");
	}

	@Test
	public void create_givenNullFileResolverConvertsToDefault() throws Exception {
		RexsSchemaFile rexsSchemaFile = RexsSchemaFile.create(RexsStandardVersions.V1_0, null);

		try (InputStream input = rexsSchemaFile.openInputStream()) {
			assertThat(input).isNotNull();
		}
	}

	@Test
	public void create_givenNewFileResolverIsTaken() throws Exception {
		RexsSchemaFileResolver newRexsSchemaFileResolver = new RexsSchemaFileResolver() {
			@Override
			public InputStream openInputStream(RexsSchemaFile rexsSchemaFile) {
				return super.openInputStream(rexsSchemaFile);
			}
		};

		RexsSchemaFile rexsSchemaFile = RexsSchemaFile.create(RexsStandardVersions.V1_0, newRexsSchemaFileResolver);
		try (InputStream input = rexsSchemaFile.openInputStream()) {
			assertThat(input).isNotNull();
		}
	}

	@Test
	public void findByVersion_givenNullVersionReturnsNull() {
		assertThat(RexsSchemaFile.findByVersion(null)).isNull();
	}

	@Test
	public void findByVersion_givenUnknownVersionReturnsNull() {
		RexsVersion versionWithNoSchema = RexsVersion.create("66.6", null, "66.6");
		assertThat(RexsSchemaFile.findByVersion(versionWithNoSchema)).isNull();
	}

	@Test
	public void findByVersion_returnsRequestedRexsSchemaFile() {
		RexsSchemaFile rexsSchemaFile = RexsSchemaFile.findByVersion(RexsStandardVersions.V1_2);
		assertThat(rexsSchemaFile).isNotNull();
		assertThat(rexsSchemaFile.getVersion()).isEqualTo(RexsStandardVersions.V1_2);
	}

	@Test
	public void findByVersion_returnsNewlyCreatedRexsSchemaFile() {
		RexsVersion newVersion = RexsVersion.create("66.7", null, "66.7");
		RexsSchemaFile.create(newVersion);
		RexsSchemaFile newRexsSchemaFile = RexsSchemaFile.findByVersion(newVersion);
		assertThat(newRexsSchemaFile).isNotNull();
		assertThat(newRexsSchemaFile.getVersion().getModelVersion()).isEqualTo("66.7");
	}

	@Test
	public void equals_equalObjects() {
		assertThat(RexsSchemaFile.V1_0.equals(RexsSchemaFile.V1_0)).isTrue();

		RexsVersion newVersion = RexsVersion.create("66.8", null, "66.8");
		assertThat(RexsSchemaFile.create(newVersion)).isEqualTo(RexsSchemaFile.create(newVersion));
	}

	@Test
	public void equals_notEqualObjects() {
		assertThat(RexsSchemaFile.V1_1).isNotEqualTo(RexsSchemaFile.V1_2);
		assertThat(RexsSchemaFile.V1_1).isNotEqualTo("test");

		RexsVersion newVersion1 = RexsVersion.create("6.66", null, "6.66");
		RexsVersion newVersion2 = RexsVersion.create("66.66", null, "66.66");
		assertThat(RexsSchemaFile.create(newVersion1)).isNotEqualTo(RexsSchemaFile.create(newVersion2));
	}
}
