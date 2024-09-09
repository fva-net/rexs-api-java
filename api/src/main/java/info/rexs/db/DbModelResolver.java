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
package info.rexs.db;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;

import info.rexs.db.constants.RexsVersion;
import info.rexs.db.jaxb.RexsDatabaseModelFile;

/**
 * This class provides the REXS database models of all available REXS versions (REXS standard and own).
 *
 * @author FVA GmbH
 */
public class DbModelResolver {

	/** The singleton instance of this class. */
	private static DbModelResolver instance = null;

	/** An internal index with all created REXS database models (REXS standard and own) for quick access. */
	private Map<DbModelFile, RexsDatabaseModelFile> dbModelFileCache = new HashMap<>();

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
	 * 				The found {@link RexsDatabaseModelFile}, or {@code null} if the REXS database model could not be found.
	 */
	public RexsDatabaseModelFile resolve(RexsVersion version) {
		DbModelFile dbModelFile = DbModelFile.findByVersion(version);
		if (dbModelFile == null)
			return null;

		if (dbModelFileCache.containsKey(dbModelFile))
			return dbModelFileCache.get(dbModelFile);

		RexsDatabaseModelFile dbModel = null;

		try (InputStream input = dbModelFile.openInputStream()) {
			JAXBContext context = JAXBContext.newInstance(RexsDatabaseModelFile.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			dbModel = (RexsDatabaseModelFile)unmarshaller.unmarshal(input);
		} catch (Exception ex) {
			throw new IllegalStateException(String.format("could not load rexs db model for version %s", dbModelFile.getVersion()), ex);
		}

		dbModelFileCache.put(dbModelFile, dbModel);
		return dbModel;
	}
}
