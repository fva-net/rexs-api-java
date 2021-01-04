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
package info.rexs.upgrade.upgraders;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;

import info.rexs.db.constants.RexsVersion;
import info.rexs.model.jaxb.Model;
import info.rexs.upgrade.RexsUpgradeException;

public class UpgradeResolverTest {

	@Test
	public void register_newUpgraderIsRegistered() throws Exception {
		RexsVersion newFromVersion = RexsVersion.create("x.y");
		RexsVersion newToVersion = RexsVersion.create("y.z");
		ModelUpgrader newModelUpgrader = new ModelUpgrader() {
			@Override
			public void upgrade(Model rexsModel) throws RexsUpgradeException {}
		};

		UpgradeResolver.getInstance().register(newFromVersion, newToVersion, newModelUpgrader);

		List<ModelUpgrader> upgraders = UpgradeResolver.getInstance().resolve(newFromVersion, newToVersion);
		assertThat(upgraders).containsExactly(newModelUpgrader);
	}

	@Test
	public void resolve_givenNullReturnsEmptyList() throws Exception {
		assertThat(UpgradeResolver.getInstance().resolve(null, RexsVersion.V1_2)).isEmpty();
		assertThat(UpgradeResolver.getInstance().resolve(RexsVersion.V1_0, null)).isEmpty();
	}

	@Test
	public void resolve_unknownCombinationReturnsEmptyList() throws Exception {
		assertThat(UpgradeResolver.getInstance().resolve(RexsVersion.V1_2, RexsVersion.V1_0)).isEmpty();
		assertThat(UpgradeResolver.getInstance().resolve(RexsVersion.V1_1, RexsVersion.V1_0)).isEmpty();

		RexsVersion newFromVersion = RexsVersion.create("0.0.1");
		assertThat(UpgradeResolver.getInstance().resolve(newFromVersion, RexsVersion.getLatest())).isEmpty();
	}

	@Test
	public void resolve_returnsUpgradersFromFirstVersionToLatestVersion() throws Exception {
		List<ModelUpgrader> upgraders = UpgradeResolver.getInstance().resolve(RexsVersion.V1_0, RexsVersion.getLatest());
		assertThat(upgraders).isNotEmpty();
	}
}
