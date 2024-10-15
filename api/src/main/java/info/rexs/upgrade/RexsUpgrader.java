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
package info.rexs.upgrade;

import java.util.ArrayList;
import java.util.List;

import info.rexs.schema.constants.RexsVersion;
import info.rexs.schema.constants.standard.RexsStandardVersions;
import info.rexs.model.RexsModel;
import info.rexs.model.jaxb.Model;
import info.rexs.upgrade.upgraders.ModelUpgrader;
import info.rexs.upgrade.upgraders.ModelUpgraderResult;
import info.rexs.upgrade.upgraders.UpgradeNotifications;
import info.rexs.upgrade.upgraders.UpgradeNotifications.Notification;
import info.rexs.upgrade.upgraders.UpgradeResolver;

/**
 * The {@link RexsUpgrader} upgrades a REXS model {@link Model}.
 *
 * @author FVA GmbH
 */
public class RexsUpgrader {

	/** The REXS model {@link Model}. */
	private RexsModel rexsModel;

	/**
	 * Constructs a new {@link RexsUpgrader} for the given {@link Model}.
	 *
	 * @param rexsModel
	 * 				The REXS model {@link Model}.
	 */
	public RexsUpgrader(RexsModel rexsModel) {
		this.rexsModel = rexsModel;
	}

	/**
	 * @return
	 * 				The REXS model {@link Model}.
	 */
	public RexsModel getRexsModel() {
		return rexsModel;
	}

	/**
	 * Upgrades the REXS model to the latest standard REXS version.
	 * @return
	 *
	 * @throws RexsUpgradeException
	 * 				If an unexpected error occurs during the upgrade process.
	 */
	public ModelUpgraderResult upgrade() throws RexsUpgradeException {
		return upgrade(RexsVersion.getLatest(), false);
	}

	/**
	 * Upgrades the REXS model to a specific REXS version.
	 *
	 * @param toVersion
	 * 				The REXS {@link RexsVersion} to upgrade to.
	 * @param strictMode Strict mode applies stricter rule to spec-conformity and may remove invalid attributes and relations and generate additional error messages.
	 * @return
	 *
	 * @throws RexsUpgradeException
	 * 				If an unexpected error occurs during the upgrade process.
	 */
	public ModelUpgraderResult upgrade(RexsVersion toVersion, boolean strictMode) throws RexsUpgradeException {
		RexsVersion fromVersion = rexsModel.getVersion();
		if (fromVersion == null || fromVersion.equals(RexsStandardVersions.UNKNOWN))
			throw new RexsUpgradeException(String.format("unknown version %s", rexsModel.getVersion()));

		List<Notification> notifications = new ArrayList<>();
		RexsModel currentModel = rexsModel;
		List<ModelUpgrader> upgraders = UpgradeResolver.getInstance().resolve(fromVersion, toVersion);
		for (ModelUpgrader upgrader : upgraders) {
			ModelUpgraderResult result = upgrader.upgrade(currentModel, strictMode);
			currentModel = result.getModel();
			notifications.addAll(result.getNotifications().getNotifications());
		}
		UpgradeNotifications notifications2 = new UpgradeNotifications(notifications);
		return new ModelUpgraderResult(currentModel, notifications2);
	}
}
