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
package info.rexs.schema;

import java.io.InputStream;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import info.rexs.schema.constants.RexsVersion;
import info.rexs.schema.constants.standard.RexsStandardVersions;

/**
 * This class represents a REXS schema file.
 * <p>
 * It contains constants for all official REXS versions.
 * <p>
 * Since REXS is freely expandable, you can also add your own models using the methods {@link #create(RexsVersion)} and {@link #create(RexsVersion, RexsSchemaFileResolver)}.
 *
 * @author FVA GmbH
 */
public class RexsSchemaFile {

	/** The default {@link RexsSchemaFileResolver} in case none is specified. */
	private static final RexsSchemaFileResolver DEFAULT_FILE_RESOLVER = new RexsSchemaFileResolver();

	/** An internal index with all created REXS schema files (REXS standard and own) for quick access. */
	private static Set<RexsSchemaFile> allRexsSchemaFiles = new HashSet<>();

	/** REXS 1.0 */
	public static final RexsSchemaFile V1_0 = create(RexsStandardVersions.V1_0);

	/** REXS 1.1 */
	public static final RexsSchemaFile V1_1 = create(RexsStandardVersions.V1_1);

	/** REXS 1.2 */
	public static final RexsSchemaFile V1_2 = create(RexsStandardVersions.V1_2);

	/** REXS 1.3 */
	public static final RexsSchemaFile V1_3 = create(RexsStandardVersions.V1_3);

	/** REXS 1.4 */
	public static final RexsSchemaFile V1_4 = create(RexsStandardVersions.V1_4);

	/** REXS 1.5 */
	public static final RexsSchemaFile V1_5 = create(RexsStandardVersions.V1_5);

	/** REXS 1.6 */
	public static final RexsSchemaFile V1_6 = create(RexsStandardVersions.V1_6);

	/** REXS 1.7 */
	public static final RexsSchemaFile V1_7 = create(RexsStandardVersions.V1_7);

	/** The {@link RexsVersion} of the REXS schema file. */
	private final RexsVersion version;

	/** The {@link RexsSchemaFileResolver} for the REXS schema file. */
	private final RexsSchemaFileResolver fileResolver;

	private RexsSchemaFile(RexsVersion version, RexsSchemaFileResolver fileResolver) {
		if (version == null)
			throw new IllegalArgumentException("version cannot be empty");
		this.version = version;
		this.fileResolver = fileResolver;
	}

	/**
	 * @return
	 * 				The {@link RexsVersion} of the REXS schema file.
	 */
	public RexsVersion getVersion() {
		return version;
	}

	/**
	 * Opens an input stream for the REXS schema file and returns it.
	 *
	 * @return
	 * 				The {@link InputStream} for the REXS schema file.
	 */
	public InputStream openInputStream() {
		return fileResolver.openInputStream(this);
	}

	/**
	 * Creates a new REXS schema file and adds it to the internal index.
	 *
	 * @param version
	 * 				The {@link RexsVersion} of the REXS schema file.
	 * @param fileResolver
	 * 				Optional {@link RexsSchemaFileResolver}.
	 *
	 * @return
	 * 				The newly created REXS schema file as {@link RexsSchemaFile}.
	 */
	public static RexsSchemaFile create(RexsVersion version, RexsSchemaFileResolver fileResolver) {
		if (fileResolver == null)
			fileResolver = DEFAULT_FILE_RESOLVER;
		RexsSchemaFile rexsSchemaFile = new RexsSchemaFile(version, fileResolver);
		allRexsSchemaFiles.add(rexsSchemaFile);
		return rexsSchemaFile;
	}

	/**
	 * Creates a new REXS schema file and adds it to the internal index.
	 *
	 * @param version
	 * 				The {@link RexsVersion} of the REXS schema file.
	 *
	 * @return
	 * 				The newly created REXS schema file as {@link RexsSchemaFile}.
	 */
	public static RexsSchemaFile create(RexsVersion version) {
		return create(version, null);
	}

	/**
	 * Returns the REXS schema file for a version and locale from the internally stored index of all REXS schema files.
	 *
	 * @param version
	 * 				The {@link RexsVersion} of the REXS schema file.
	 *
	 * @return
	 * 				The found {@link RexsSchemaFile}, or {@code null} if the REXS schema file could not be found.
	 */
	public static RexsSchemaFile findByVersion(RexsVersion version) {
		if (version == null)
			return null;

		for (RexsSchemaFile rexsSchemaFile : allRexsSchemaFiles) {
			if (version.equals(rexsSchemaFile.version))
				return rexsSchemaFile;
		}

		return null;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof RexsSchemaFile other)) {
			return false;
		}
		if (!other.canEqual(this)) {
			return false;
		}
		Object this_version = getVersion();
		Object other_version = other.getVersion();
		return Objects.equals(this_version, other_version);
	}

	protected boolean canEqual(Object other) {
		return other instanceof RexsSchemaFile;
	}

	@Override
	public int hashCode() {
		int result = 1;
		Object _version = getVersion();
		result = result * 59 + (_version == null ? 43 : _version.hashCode());
		return result;
	}
}
