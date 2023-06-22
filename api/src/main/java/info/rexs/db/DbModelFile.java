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
package info.rexs.db;

import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

import info.rexs.db.constants.RexsVersion;

/**
 * This class represents a REXS database model file.
 * <p>
 * It contains constants for all official REXS versions.
 * <p>
 * Since REXS is freely expandable, you can also add your own models using the methods {@link #create(RexsVersion)} and {@link #create(RexsVersion, DbModelFileResolver)}.
 *
 * @author FVA GmbH
 */
public class DbModelFile {

	/** The default {@link DbModelFileResolver} in case none is specified. */
	private static final DbModelFileResolver DEFAULT_FILE_RESOLVER = new DbModelFileResolver();

	/** An internal index with all created REXS database model files (REXS standard and own) for quick access. */
	private static Set<DbModelFile> allDbModelFiles = new HashSet<>();

	/** REXS 1.0 */
	public static final DbModelFile V1_0 = create(RexsVersion.V1_0);

	/** REXS 1.1 */
	public static final DbModelFile V1_1 = create(RexsVersion.V1_1);

	/** REXS 1.2 */
	public static final DbModelFile V1_2 = create(RexsVersion.V1_2);

	/** REXS 1.3 */
	public static final DbModelFile V1_3 = create(RexsVersion.V1_3);

	/** REXS 1.4 */
	public static final DbModelFile V1_4 = create(RexsVersion.V1_4);

	/** REXS 1.5 */
	public static final DbModelFile V1_5 = create(RexsVersion.V1_5);

	/** The {@link RexsVersion} of the REXS database model file. */
	private final RexsVersion version;

	/** The {@link DbModelFileResolver} for the REXS database model file. */
	private final DbModelFileResolver fileResolver;

	private DbModelFile(RexsVersion version, DbModelFileResolver fileResolver) {
		if (version == null)
			throw new IllegalArgumentException("version cannot be empty");
		this.version = version;
		this.fileResolver = fileResolver;
	}

	/**
	 * @return
	 * 				The {@link RexsVersion} of the REXS database model file.
	 */
	public RexsVersion getVersion() {
		return version;
	}

	/**
	 * Opens an input stream for the REXS database model file and returns it.
	 *
	 * @return
	 * 				The {@link InputStream} for the REXS database model file.
	 */
	public InputStream openInputStream() {
		return fileResolver.openInputStream(this);
	}

	/**
	 * Creates a new REXS database model file and adds it to the internal index.
	 *
	 * @param version
	 * 				The {@link RexsVersion} of the REXS database model file.
	 * @param fileResolver
	 * 				Optional {@link DbModelFileResolver}.
	 *
	 * @return
	 * 				The newly created REXS database model file as {@link DbModelFile}.
	 */
	public static DbModelFile create(RexsVersion version, DbModelFileResolver fileResolver) {
		if (fileResolver == null)
			fileResolver = DEFAULT_FILE_RESOLVER;
		DbModelFile dbModelFile = new DbModelFile(version, fileResolver);
		allDbModelFiles.add(dbModelFile);
		return dbModelFile;
	}

	/**
	 * Creates a new REXS database model file and adds it to the internal index.
	 *
	 * @param version
	 * 				The {@link RexsVersion} of the REXS database model file.
	 *
	 * @return
	 * 				The newly created REXS database model file as {@link DbModelFile}.
	 */
	public static DbModelFile create(RexsVersion version) {
		return create(version, null);
	}

	/**
	 * Returns the REXS database model file for a version and locale from the internally stored index of all REXS database model files.
	 *
	 * @param version
	 * 				The {@link RexsVersion} of the REXS database model file.
	 *
	 * @return
	 * 				The found {@link DbModelFile}, or {@code null} if the REXS database model file could not be found.
	 */
	public static DbModelFile findByVersion(RexsVersion version) {
		if (version == null)
			return null;

		for (DbModelFile dbModelFile : allDbModelFiles) {
			if (version.equals(dbModelFile.version))
				return dbModelFile;
		}

		return null;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof DbModelFile)) {
			return false;
		}
		DbModelFile other = (DbModelFile)o;
		if (!other.canEqual(this)) {
			return false;
		}
		Object this_version = getVersion();
		Object other_version = other.getVersion();
		return this_version == null ? other_version == null : this_version.equals(other_version);
	}

	protected boolean canEqual(Object other) {
		return other instanceof DbModelFile;
	}

	@Override
	public int hashCode() {
		int result = 1;
		Object _version = getVersion();
		result = result * 59 + (_version == null ? 43 : _version.hashCode());
		return result;
	}
}
