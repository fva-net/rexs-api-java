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
package info.rexs.upgrade;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.Test;

import info.rexs.db.constants.RexsVersion;
import info.rexs.model.jaxb.Model;

public class RexsUpgraderTest {

	@Test
	public void constructor_getterMatchesValuePassedToConstructor() throws Exception {
		Model rexsModel = new Model();
		rexsModel.setVersion(RexsVersion.V1_0.getName());
		RexsUpgrader rexsUpgrader = new RexsUpgrader(rexsModel);

		assertThat(rexsUpgrader.getRexsModel()).isEqualTo(rexsModel);
	}

	@Test
	public void upgrade_unknownVersionThrowsRexsUpgradeException() throws Exception {
		Model rexsModel = new Model();
		rexsModel.setVersion("unknown");
		RexsUpgrader rexsUpgrader = new RexsUpgrader(rexsModel);

		assertThatExceptionOfType(RexsUpgradeException.class)
		.isThrownBy(() -> {
			rexsUpgrader.upgrade(RexsVersion.getLatest());
		})
		.withMessageStartingWith("unknown version");
	}

	@Test
	public void upgrade_upgradesToLatestVersion() throws Exception {
		Model rexsModel = new Model();
		rexsModel.setVersion(RexsVersion.V1_0.getName());

		RexsUpgrader rexsUpgrader = new RexsUpgrader(rexsModel);
		rexsUpgrader.upgrade();

		assertThat(rexsUpgrader.getRexsModel().getVersion()).isEqualTo(RexsVersion.getLatest().getName());
	}

	@Test
	public void upgrade_upgradesToSpecifiedVersion() throws Exception {
		Model rexsModel = new Model();
		rexsModel.setVersion(RexsVersion.V1_0.getName());

		RexsUpgrader rexsUpgrader = new RexsUpgrader(rexsModel);
		rexsUpgrader.upgrade(RexsVersion.V1_1);

		assertThat(rexsUpgrader.getRexsModel().getVersion()).isEqualTo(RexsVersion.V1_1.getName());
	}
}
