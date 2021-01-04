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
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import info.rexs.db.constants.RexsVersion;
import info.rexs.db.jaxb.RexsModel;

/**
 * This class provides the REXS database models of all available REXS versions (REXS standard and own).
 *
 * @author FVA GmbH
 */
public class DbModelResolver {

	/** The singleton instance of this class. */
	private static DbModelResolver instance = null;

	/** An internal index with all created REXS database models (REXS standard and own) for quick access. */
	private Map<DbModelFile, RexsModel> dbModelFileCache = new HashMap<>();

	private DbModelResolver() {}

	/**
	 * @return
	 * 				The singleton instance of this class.
	 */
	public static synchronized DbModelResolver getInstance() {
		if (instance == null)
			instance = new DbModelResolver();
		return instance;
	}

	/**
	 * Determines the REXS database model for a version.
	 *
	 * @param version
	 * 				The {@link RexsVersion} of the REXS database model.
	 *
	 * @return
	 * 				The found {@link RexsModel}, or {@code null} if the REXS database model could not be found.
	 */
	public RexsModel resolve(RexsVersion version) {
		return resolve(version, null);
	}

	/**
	 * Determines the REXS database model for a version and locale.
	 *
	 * @param version
	 * 				The {@link RexsVersion} of the REXS database model.
	 * @param locale
	 * 				The {@link Locale} of the REXS database model.
	 *
	 * @return
	 * 				The found {@link RexsModel}, or {@code null} if the REXS database model could not be found.
	 */
	public RexsModel resolve(RexsVersion version, Locale locale) {
		DbModelFile dbModelFile = DbModelFile.findByVersionAndLocale(version, locale);
		if (dbModelFile == null)
			return null;

		if (dbModelFileCache.containsKey(dbModelFile))
			return dbModelFileCache.get(dbModelFile);

		RexsModel dbModel = null;

		try (InputStream input = dbModelFile.openInputStream()) {
			JAXBContext context = JAXBContext.newInstance(RexsModel.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			dbModel = (RexsModel)unmarshaller.unmarshal(input);
		} catch (Exception ex) {
			throw new IllegalStateException(String.format("could not load rexs db model for version %s and language %s", dbModelFile.getVersion(), dbModelFile.getLanguage()), ex);
		}

		dbModelFileCache.put(dbModelFile, dbModel);
		return dbModel;
	}
}
