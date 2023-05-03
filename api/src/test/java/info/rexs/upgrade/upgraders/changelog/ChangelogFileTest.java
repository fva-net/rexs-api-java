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
package info.rexs.upgrade.upgraders.changelog;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.io.InputStream;

import org.junit.Test;

import info.rexs.db.constants.RexsVersion;

public class ChangelogFileTest {

	@Test
	public void create_givenNullVersionThrowsIllegalArgumentException() throws Exception {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> {
				ChangelogFile.create(null, RexsVersion.V1_1);
			})
			.withMessage("from version cannot be empty");

		assertThatIllegalArgumentException()
			.isThrownBy(() -> {
				ChangelogFile.create(RexsVersion.V1_0, null);
			})
			.withMessage("to version cannot be empty");
	}

	@Test
	public void create_givenNullFileResolverConvertsToDefault() throws Exception {
		ChangelogFile changelogFile = ChangelogFile.create(RexsVersion.V1_0, RexsVersion.V1_1, null);

		try (InputStream input = changelogFile.openInputStream()) {
			assertThat(input).isNotNull();
		}
	}

	@Test
	public void create_givenNewFileResolverIsTaken() throws Exception {
		ChangelogFileResolver newChangelogFileResolver = new ChangelogFileResolver() {
			@Override
			public InputStream openInputStream(ChangelogFile changelogFile) {
				return super.openInputStream(changelogFile);
			}
		};

		ChangelogFile changelogFile = ChangelogFile.create(RexsVersion.V1_0, RexsVersion.V1_1, newChangelogFileResolver);
		try (InputStream input = changelogFile.openInputStream()) {
			assertThat(input).isNotNull();
		}
	}

	@Test
	public void equals_equalObjects() {
		assertThat(ChangelogFile.V1_0_TO_V1_1.equals(ChangelogFile.V1_0_TO_V1_1)).isTrue();

		RexsVersion newFromVersion = RexsVersion.create("o.p", 1);
		RexsVersion newToVersion = RexsVersion.create("p.q", 1);
		assertThat(ChangelogFile.create(newFromVersion, newToVersion)).isEqualTo(ChangelogFile.create(newFromVersion, newToVersion));
	}

	@Test
	public void equals_notEqualObjects() {
		assertThat(ChangelogFile.V1_0_TO_V1_1).isNotEqualTo(ChangelogFile.V1_1_TO_V1_2);
		assertThat(ChangelogFile.V1_1_TO_V1_2).isNotEqualTo("test");

		RexsVersion newVersion1 = RexsVersion.create("p.q", 1);
		RexsVersion newVersion2 = RexsVersion.create("q.r", 1);
		assertThat(ChangelogFile.create(newVersion1, newVersion2)).isNotEqualTo(ChangelogFile.create(newVersion2, newVersion1));
		assertThat(ChangelogFile.create(newVersion2, newVersion1)).isNotEqualTo(ChangelogFile.create(newVersion1, newVersion2));
	}
}
