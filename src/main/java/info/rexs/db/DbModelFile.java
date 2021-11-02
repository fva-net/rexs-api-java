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
import java.util.Locale;
import java.util.Set;

import info.rexs.db.constants.RexsVersion;
import lombok.EqualsAndHashCode;

/**
 * This class represents a REXS database model file.
 * <p>
 * It contains constants for all official REXS versions.
 * <p>
 * Since REXS is freely expandable, you can also add your own models using the methods {@link #create(RexsVersion, Locale)} and {@link #create(RexsVersion, Locale, DbModelFileResolver)}.
 *
 * @author FVA GmbH
 */
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class DbModelFile {

	/** The default {@link DbModelFileResolver} in case none is specified. */
	private static final DbModelFileResolver DEFAULT_FILE_RESOLVER = new DbModelFileResolver();

	/** An internal index with all created REXS database model files (REXS standard and own) for quick access. */
	private static Set<DbModelFile> allDbModelFiles = new HashSet<>();

	/** REXS 1.0 (english) */
	public static final DbModelFile V1_0_ENGLISH = create(RexsVersion.V1_0, Locale.ENGLISH);

	/** REXS 1.0 (german) */
	public static final DbModelFile V1_0_GERMAN = create(RexsVersion.V1_0, Locale.GERMAN);

	/** REXS 1.1 (english) */
	public static final DbModelFile V1_1_ENGLISH = create(RexsVersion.V1_1, Locale.ENGLISH);

	/** REXS 1.1 (german) */
	public static final DbModelFile V1_1_GERMAN = create(RexsVersion.V1_1, Locale.GERMAN);

	/** REXS 1.2 (english) */
	public static final DbModelFile V1_2_ENGLISH = create(RexsVersion.V1_2, Locale.ENGLISH);

	/** REXS 1.2 (german) */
	public static final DbModelFile V1_2_GERMAN = create(RexsVersion.V1_2, Locale.GERMAN);

	/** REXS 1.3 (english) */
	public static final DbModelFile V1_3_ENGLISH = create(RexsVersion.V1_3, Locale.ENGLISH);

	/** REXS 1.3 (german) */
	public static final DbModelFile V1_3_GERMAN = create(RexsVersion.V1_3, Locale.GERMAN);

	/** REXS DEV (english) */
	public static final DbModelFile V_DEV_ENGLISH = create(RexsVersion.V_DEV, Locale.ENGLISH);

	/** REXS DEV (german) */
	public static final DbModelFile V_DEV_GERMAN = create(RexsVersion.V_DEV, Locale.GERMAN);

	/** The {@link RexsVersion} of the REXS database model file. */
	@EqualsAndHashCode.Include
	private final RexsVersion version;

	/** The language key for terms from the REXS database. */
	@EqualsAndHashCode.Include
	private final String language;

	/** The {@link DbModelFileResolver} for the REXS database model file. */
	private final DbModelFileResolver fileResolver;

	private DbModelFile(RexsVersion version, String language, DbModelFileResolver fileResolver) {
		if (version == null)
			throw new IllegalArgumentException("version cannot be empty");
		this.version = version;
		this.language = language;
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
	 * @return
	 * 				The language key for terms from the REXS database.
	 */
	public String getLanguage() {
		return language;
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
	 * @param locale
	 * 				The {@link Locale} for terms from the REXS database.
	 * @param fileResolver
	 * 				Optional {@link DbModelFileResolver}.
	 *
	 * @return
	 * 				The newly created REXS database model file as {@link DbModelFile}.
	 */
	public static DbModelFile create(RexsVersion version, Locale locale, DbModelFileResolver fileResolver) {
		if (fileResolver == null)
			fileResolver = DEFAULT_FILE_RESOLVER;
		DbModelFile dbModelFile = new DbModelFile(version, getLanguageFromLocale(locale), fileResolver);
		allDbModelFiles.add(dbModelFile);
		return dbModelFile;
	}

	/**
	 * Creates a new REXS database model file and adds it to the internal index.
	 *
	 * @param version
	 * 				The {@link RexsVersion} of the REXS database model file.
	 * @param locale
	 * 				The {@link Locale} for terms from the REXS database.
	 *
	 * @return
	 * 				The newly created REXS database model file as {@link DbModelFile}.
	 */
	public static DbModelFile create(RexsVersion version, Locale locale) {
		return create(version, locale, null);
	}

	/**
	 * Returns the REXS database model file for a version and locale from the internally stored index of all REXS database model files.
	 *
	 * @param version
	 * 				The {@link RexsVersion} of the REXS database model file.
	 * @param locale
	 * 				The {@link Locale} of the REXS database model file.
	 *
	 * @return
	 * 				The found {@link DbModelFile}, or {@code null} if the REXS database model file could not be found.
	 */
	public static DbModelFile findByVersionAndLocale(RexsVersion version, Locale locale) {
		if (version == null)
			return null;

		String language = getLanguageFromLocale(locale);

		for (DbModelFile dbModelFile : allDbModelFiles) {
			if (version.equals(dbModelFile.version)
					&& language.equals(dbModelFile.language))
				return dbModelFile;
		}

		return null;
	}

	private static String getLanguageFromLocale(Locale locale) {
		if (locale == null
				|| (!locale.getLanguage().equalsIgnoreCase("en") && !locale.getLanguage().equalsIgnoreCase("de")))
			return Locale.ENGLISH.getLanguage();
		return locale.getLanguage();
	}
}
