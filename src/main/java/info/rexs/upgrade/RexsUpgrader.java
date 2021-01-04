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

import java.util.List;

import info.rexs.db.constants.RexsVersion;
import info.rexs.model.jaxb.Model;
import info.rexs.upgrade.upgraders.ModelUpgrader;
import info.rexs.upgrade.upgraders.UpgradeResolver;

/**
 * The {@link RexsUpgrader} upgrades a REXS model {@link Model}.
 *
 * @author FVA GmbH
 */
public class RexsUpgrader {

	/** The REXS model {@link Model}. */
	private Model rexsModel;

	/**
	 * Constructs a new {@link RexsUpgrader} for the given {@link Model}.
	 *
	 * @param rexsModel
	 * 				The REXS model {@link Model}.
	 */
	public RexsUpgrader(Model rexsModel) {
		this.rexsModel = rexsModel;
	}

	/**
	 * @return
	 * 				The REXS model {@link Model}.
	 */
	public Model getRexsModel() {
		return rexsModel;
	}

	/**
	 * Upgrades the REXS model to the latest standard REXS version.
	 *
	 * @throws RexsUpgradeException
	 * 				If an unexpected error occurs during the upgrade process.
	 */
	public void upgrade() throws RexsUpgradeException {
		upgrade(RexsVersion.getLatest());
	}

	/**
	 * Upgrades the REXS model to a specific REXS version.
	 *
	 * @param toVersion
	 * 				The REXS {@link RexsVersion} to upgrade to.
	 *
	 * @throws RexsUpgradeException
	 * 				If an unexpected error occurs during the upgrade process.
	 */
	public void upgrade(RexsVersion toVersion) throws RexsUpgradeException {
		RexsVersion fromVersion = RexsVersion.findByName(rexsModel.getVersion());
		if (fromVersion == null)
			throw new RexsUpgradeException(String.format("unknown version %s", rexsModel.getVersion()));

		List<ModelUpgrader> upgraders = UpgradeResolver.getInstance().resolve(fromVersion, toVersion);
		for (ModelUpgrader upgrader : upgraders) {
			upgrader.upgrade(rexsModel);
		}

		rexsModel.setVersion(toVersion.getName());
	}
}
