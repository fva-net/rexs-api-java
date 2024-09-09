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
package info.rexs.upgrade.upgraders.changelog;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import info.rexs.db.constants.standard.RexsStandardVersions;
import info.rexs.upgrade.RexsUpgradeException;
import info.rexs.upgrade.upgraders.changelog.jaxb.RexsChangelog;

public class ChangelogResolverTest {

	@Test
	public void resolve_nullChangelogFileReturnsNull() throws Exception {
		assertThat(ChangelogResolver.getInstance().resolve(null)).isNull();
	}

	@Test
	public void resolve_invalidChangelogFileResolverThrowsIllegalStateException() throws Exception {
		ChangelogFile newChangelogFile = ChangelogFile.create(RexsStandardVersions.V1_0, RexsStandardVersions.V1_2, new ChangelogFileResolver() {
			@Override
			public InputStream openInputStream(ChangelogFile changelogFile) {
				return null;
			}
		});

		assertThatExceptionOfType(RexsUpgradeException.class)
			.isThrownBy(() -> {
				ChangelogResolver.getInstance().resolve(newChangelogFile);
			})
			.withMessageStartingWith("could not load rexs changelog for version");
	}

	@Test
	public void resolve_cachingReturnsSameObjectForMultipleCalls() throws Exception {
		RexsChangelog rexsChangelog1 = ChangelogResolver.getInstance().resolve(ChangelogFile.V1_0_TO_V1_1);
		RexsChangelog rexsChangelog2 = ChangelogResolver.getInstance().resolve(ChangelogFile.V1_0_TO_V1_1);

		assertThat(rexsChangelog1).isSameAs(rexsChangelog2);
	}

	@Test
	public void resolve_everyRexsStandardChangelogIsAvailable() throws Exception {
		List<ChangelogFile> rexsStandardChangelogFiles = Stream.of(ChangelogFile.V1_0_TO_V1_1, ChangelogFile.V1_1_TO_V1_2).collect(Collectors.toList());
		for (ChangelogFile changelogFile : rexsStandardChangelogFiles) {
			RexsChangelog rexsChangelog = ChangelogResolver.getInstance().resolve(changelogFile);
			assertThat(rexsChangelog.getFromVersion()).isEqualTo(changelogFile.getFromVersion().getName());
			assertThat(rexsChangelog.getToVersion()).isEqualTo(changelogFile.getToVersion().getName());

			int countChangelogChanges = 0;
			countChangelogChanges += rexsChangelog.getComponentChanges().getComponentChange().size();
			countChangelogChanges += rexsChangelog.getAttributeChanges().getAttributeChange().size();
			countChangelogChanges += rexsChangelog.getMappingChanges().getMappingChange().size();
			assertThat(countChangelogChanges).isGreaterThan(0);
		}
	}
}
