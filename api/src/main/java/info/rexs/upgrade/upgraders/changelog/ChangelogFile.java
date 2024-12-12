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
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import info.rexs.schema.constants.RexsVersion;
import info.rexs.schema.constants.standard.RexsStandardVersions;

/**
 * This class represents a REXS database changelog file.
 * <p>
 * It contains constants for all official REXS versions.
 * <p>
 * Since REXS is freely expandable, you can also add your own changelogs using the methods {@link #create(RexsVersion, RexsVersion)} and {@link #create(RexsVersion, RexsVersion, ChangelogFileResolver)}.
 *
 * @author FVA GmbH
 */
public class ChangelogFile {

	/** The default {@link ChangelogFileResolver} in case none is specified. */
	private static final ChangelogFileResolver DEFAULT_FILE_RESOLVER = new ChangelogFileResolver();

	/** An internal index with all created REXS database changelog files (REXS standard and own) for quick access. */
	private static Set<ChangelogFile> allChangelogFiles = new HashSet<>();

	/** REXS Changelog 1.0 to 1.1 */
	public static final ChangelogFile V1_0_TO_V1_1 = create(RexsStandardVersions.V1_0, RexsStandardVersions.V1_1);

	/** REXS Changelog 1.1 to 1.2 */
	public static final ChangelogFile V1_1_TO_V1_2 = create(RexsStandardVersions.V1_1, RexsStandardVersions.V1_2);

	/** REXS Changelog 1.2 to 1.3 */
	public static final ChangelogFile V1_2_TO_V1_3 = create(RexsStandardVersions.V1_2, RexsStandardVersions.V1_3);

	/** REXS Changelog 1.3 to 1.4 */
	public static final ChangelogFile V1_3_TO_V1_4 = create(RexsStandardVersions.V1_3, RexsStandardVersions.V1_4);

	/** REXS Changelog 1.4 to 1.5 */
	public static final ChangelogFile V1_4_TO_V1_5 = create(RexsStandardVersions.V1_4, RexsStandardVersions.V1_5);

	/** REXS Changelog 1.5 to 1.6 */
	public static final ChangelogFile V1_5_TO_V1_6 = create(RexsStandardVersions.V1_5, RexsStandardVersions.V1_6);

	/** REXS Changelog 1.6 to 1.7 */
	public static final ChangelogFile V1_6_TO_V1_7 = create(RexsStandardVersions.V1_6, RexsStandardVersions.V1_7);

	/** The from {@link RexsVersion} of the REXS database changelog file. */
	private final RexsVersion fromVersion;

	/** The to {@link RexsVersion} of the REXS database changelog file. */
	private final RexsVersion toVersion;

	/** The {@link ChangelogFileResolver} for the REXS database changelog file. */
	private final ChangelogFileResolver fileResolver;

	private ChangelogFile(RexsVersion fromVersion, RexsVersion toVersion, ChangelogFileResolver fileResolver) {
		if (fromVersion == null)
			throw new IllegalArgumentException("from version cannot be empty");
		if (toVersion == null)
			throw new IllegalArgumentException("to version cannot be empty");
		this.fromVersion = fromVersion;
		this.toVersion = toVersion;
		this.fileResolver = fileResolver;
	}

	/**
	 * @return
	 * 				The from {@link RexsVersion} of the REXS database changelog file.
	 */
	public RexsVersion getFromVersion() {
		return fromVersion;
	}

	/**
	 * @return
	 * 				The to {@link RexsVersion} of the REXS database changelog file.
	 */
	public RexsVersion getToVersion() {
		return toVersion;
	}

	/**
	 * Opens an input stream for the REXS database changelog file and returns it.
	 *
	 * @return
	 * 				The {@link InputStream} for the REXS database changelog file.
	 */
	public InputStream openInputStream() {
		return fileResolver.openInputStream(this);
	}

	/**
	 * Creates a new REXS database changelog file and adds it to the internal index.
	 *
	 * @param fromVersion
	 * 				The from {@link RexsVersion} of the REXS database changelog file.
	 * @param toVersion
	 * 				The to {@link RexsVersion} of the REXS database changelog file.
	 * @param fileResolver
	 * 				Optional {@link ChangelogFileResolver}.
	 *
	 * @return
	 * 				The newly created REXS database changelog file as {@link ChangelogFile}.
	 */
	public static ChangelogFile create(RexsVersion fromVersion, RexsVersion toVersion, ChangelogFileResolver fileResolver) {
		if (fileResolver == null)
			fileResolver = DEFAULT_FILE_RESOLVER;
		ChangelogFile changelogFile = new ChangelogFile(fromVersion, toVersion, fileResolver);
		allChangelogFiles.add(changelogFile);
		return changelogFile;
	}

	/**
	 * Creates a new REXS database changelog file and adds it to the internal index.
	 *
	 * @param fromVersion
	 * 				The from {@link RexsVersion} of the REXS database changelog file.
	 * @param toVersion
	 * 				The to {@link RexsVersion} of the REXS database changelog file.
	 *
	 * @return
	 * 				The newly created REXS database changelog file as {@link ChangelogFile}.
	 */
	public static ChangelogFile create(RexsVersion fromVersion, RexsVersion toVersion) {
		return create(fromVersion, toVersion, null);
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof ChangelogFile other)) {
			return false;
		}
		if (!other.canEqual(this)) {
			return false;
		}
		Object this_fromVersion = getFromVersion();
		Object other_fromVersion = other.getFromVersion();
		if (!Objects.equals(this_fromVersion, other_fromVersion)) {
			return false;
		}
		Object this_toVersion = getToVersion();
		Object other_toVersion = other.getToVersion();
		return Objects.equals(this_toVersion, other_toVersion);
	}

	protected boolean canEqual(Object other) {
		return other instanceof ChangelogFile;
	}

	@Override
	public int hashCode() {
		int result = 1;
		Object _fromVersion = getFromVersion();
		result = result * 59 + (_fromVersion == null ? 43 : _fromVersion.hashCode());
		Object _toVersion = getToVersion();
		result = result * 59 + (_toVersion == null ? 43 : _toVersion.hashCode());
		return result;
	}
}
