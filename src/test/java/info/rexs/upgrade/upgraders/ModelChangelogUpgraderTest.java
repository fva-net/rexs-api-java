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
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.Test;

import info.rexs.db.constants.RexsVersion;
import info.rexs.model.jaxb.Model;
import info.rexs.upgrade.RexsUpgradeException;
import info.rexs.upgrade.upgraders.changelog.ChangelogFile;

public class ModelChangelogUpgraderTest {

	@Test
	public void beforeApplyChangelog_methodIsCalledInUpgradeProcess() throws Exception {
		Model newRexsModel = new Model();
		newRexsModel.setVersion(RexsVersion.V1_0.getName());

		ModelChangelogUpgrader newModelChangelogUpgrader = new ModelChangelogUpgrader(ChangelogFile.V1_0_TO_V1_1) {
			@Override
			public void beforeApplyChangelog(Model rexsModel) throws RexsUpgradeException {
				rexsModel.setApplicationId("foo_bar");
			}
		};
		newModelChangelogUpgrader.upgrade(newRexsModel);

		assertThat(newRexsModel.getApplicationId()).isEqualTo("foo_bar");
	}

	@Test
	public void afterApplyChangelog_methodIsCalledInUpgradeProcess() throws Exception {
		Model newRexsModel = new Model();
		newRexsModel.setVersion(RexsVersion.V1_0.getName());

		ModelChangelogUpgrader newModelChangelogUpgrader = new ModelChangelogUpgrader(ChangelogFile.V1_0_TO_V1_1) {
			@Override
			public void afterApplyChangelog(Model rexsModel) throws RexsUpgradeException {
				rexsModel.setApplicationId("foo_bar");
			}
		};
		newModelChangelogUpgrader.upgrade(newRexsModel);

		assertThat(newRexsModel.getApplicationId()).isEqualTo("foo_bar");
	}

	@Test
	public void upgrade_nullChangelogFileThrowsRexsUpgradeException() throws Exception {
		Model newRexsModel = new Model();
		newRexsModel.setVersion(RexsVersion.V1_0.getName());
		ModelChangelogUpgrader newModelChangelogUpgrader = new ModelChangelogUpgrader(null);

		assertThatExceptionOfType(RexsUpgradeException.class)
			.isThrownBy(() -> {
				newModelChangelogUpgrader.upgrade(newRexsModel);
			})
			.withMessageStartingWith("unable to find rexs changelog for");
	}
}
