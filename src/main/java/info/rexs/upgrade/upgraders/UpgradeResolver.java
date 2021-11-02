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

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import info.rexs.db.constants.RexsVersion;
import info.rexs.upgrade.RexsUpgradeException;
import info.rexs.upgrade.upgraders.changelog.ChangelogFile;

/**
 * This class provides the REXS version upgraders of all available REXS versions (REXS standard and own).
 * <p>
 * Since REXS is freely expandable, you can also add your own upgraders using the method {@link #register(RexsVersion, RexsVersion, ModelUpgrader)}.
 *
 * @author FVA GmbH
 */
public class UpgradeResolver {

	/** The singleton instance of this class. */
	private static UpgradeResolver instance = null;

	/** An internal index with all registered upgraders (REXS standard and own) for quick access. [toVersion -> fromVersion -> upgrader] */
	private Map<RexsVersion, Map<RexsVersion, ModelUpgrader>> registeredUpgraders = new HashMap<>();

	private UpgradeResolver() {
		register(RexsVersion.V1_0, RexsVersion.V1_1, new ModelChangelogUpgrader(ChangelogFile.V1_0_TO_V1_1));
		register(RexsVersion.V1_1, RexsVersion.V1_2, new ModelChangelogUpgrader(ChangelogFile.V1_1_TO_V1_2));
		register(RexsVersion.V1_2, RexsVersion.V1_3, new ModelChangelogUpgrader(ChangelogFile.V1_2_TO_V1_3));
		register(RexsVersion.V1_3, RexsVersion.V1_4, new ModelChangelogUpgrader(ChangelogFile.V1_3_TO_V1_4));
	}

	/**
	 * @return
	 * 				The singleton instance of this class.
	 */
	public static synchronized UpgradeResolver getInstance() {
		if (instance == null)
			instance = new UpgradeResolver();
		return instance;
	}

	/**
	 * Registers a new {@link ModelUpgrader}.
	 *
	 * @param fromVersion
	 * 				The from REXS {@link RexsVersion}.
	 * @param toVersion
	 * 				The to REXS {@link RexsVersion}.
	 * @param upgrader
	 * 				Optional {@link ModelUpgrader}.
	 */
	public void register(RexsVersion fromVersion, RexsVersion toVersion, ModelUpgrader upgrader) {
		Map<RexsVersion, ModelUpgrader> toVersionRegisteredUpgraders = registeredUpgraders.computeIfAbsent(toVersion, k -> new HashMap<>());
		toVersionRegisteredUpgraders.put(fromVersion, upgrader);
	}

	/**
	 * Determines the {@link ModelUpgrader}s for a source version up to the target version.
	 * <p>
	 * The {@link ModelUpgrader}s are supplied in a {@link List}. The {@link ModelUpgrader}s must be executed in the order listed.
	 * If no upgraders are found, the list is empty.
	 *
	 * @param fromVersion
	 * 				The from REXS {@link RexsVersion}.
	 * @param toVersion
	 * 				The to REXS {@link RexsVersion}.
	 *
	 * @return
	 * 				A {@link List} of {@link ModelUpgrader}s.
	 *
	 * @throws RexsUpgradeException
	 * 				If an unexpected error occurs while identifying the upgraders.
	 */
	public List<ModelUpgrader> resolve(RexsVersion fromVersion, RexsVersion toVersion) throws RexsUpgradeException {
		if (fromVersion == null || toVersion == null)
			return Collections.emptyList();

		Map<RexsVersion, ModelUpgrader> toVersionRegisteredUpgraders = registeredUpgraders.get(toVersion);
		if (toVersionRegisteredUpgraders == null)
			return Collections.emptyList();

		for (Entry<RexsVersion, ModelUpgrader> toVersionRegisteredUpgradersEntry : toVersionRegisteredUpgraders.entrySet()) {
			RexsVersion possibleFromVersion = toVersionRegisteredUpgradersEntry.getKey();
			if (fromVersion.equals(possibleFromVersion))
				return Stream.of(toVersionRegisteredUpgradersEntry.getValue()).collect(Collectors.toList());

			List<ModelUpgrader> upgraders = resolve(fromVersion, possibleFromVersion);
			if (!upgraders.isEmpty()) {
				upgraders.add(toVersionRegisteredUpgradersEntry.getValue());
				return upgraders;
			}
		}

		return Collections.emptyList();
	}
}
