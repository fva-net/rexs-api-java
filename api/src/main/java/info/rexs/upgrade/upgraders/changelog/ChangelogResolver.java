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

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;

import info.rexs.upgrade.RexsUpgradeException;
import info.rexs.upgrade.upgraders.changelog.jaxb.RexsChangelog;

/**
 * This class provides the REXS database changelogs of all available REXS versions (REXS standard and own).
 *
 * @author FVA GmbH
 */
public class ChangelogResolver {

	/** The singleton instance of this class. */
	private static ChangelogResolver instance = null;

	/** An internal index with all created REXS database changelogs (REXS standard and own) for quick access. */
	private Map<ChangelogFile, RexsChangelog> changelogFileCache = new HashMap<>();

	private ChangelogResolver() {}

	/**
	 * @return
	 * 				The singleton instance of this class.
	 */
	public static synchronized ChangelogResolver getInstance() {
		if (instance == null)
			instance = new ChangelogResolver();
		return instance;
	}

	/**
	 * Determines the REXS database changelog for a changelog file.
	 *
	 * @param changelogFile
	 * 				The {@link ChangelogFile} of the REXS database changelog.
	 *
	 * @return
	 * 				The found {@link RexsChangelog}, or {@code null} if the REXS database changelog could not be found.
	 *
	 * @throws RexsUpgradeException
	 * 				If an unexpected error occurs while identifying the changelog.
	 */
	public RexsChangelog resolve(ChangelogFile changelogFile) throws RexsUpgradeException {
		if (changelogFile == null)
			return null;

		if (changelogFileCache.containsKey(changelogFile))
			return changelogFileCache.get(changelogFile);

		RexsChangelog changelog = null;

		try (InputStream input = changelogFile.openInputStream()) {
			JAXBContext context = JAXBContext.newInstance(RexsChangelog.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			changelog = (RexsChangelog)unmarshaller.unmarshal(input);
		} catch (Exception ex) {
			throw new RexsUpgradeException(String.format("could not load rexs changelog for version %s to version %s", changelogFile.getFromVersion().getModelVersion(), changelogFile.getToVersion().getModelVersion()), ex);
		}

		changelogFileCache.put(changelogFile, changelog);
		return changelog;
	}
}
