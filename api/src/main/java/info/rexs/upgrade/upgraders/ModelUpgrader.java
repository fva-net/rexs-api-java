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

import info.rexs.model.jaxb.Model;
import info.rexs.upgrade.RexsUpgradeException;

/**
 * Defines an interface for all upgraders of REXS models.
 *
 * @author FVA GmbH
 */
public interface ModelUpgrader {

	/**
	 * Upgrades a REXS {@link Model}.
	 *
	 * @param rexsModel
	 * 				The REXS {@link Model} to upgrade.
	 *
	 * @throws RexsUpgradeException
	 * 				If an unexpected error occurs during the upgrade process.
	 */
	public void upgrade(Model rexsModel) throws RexsUpgradeException;
}
