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
import java.util.HashMap;
import java.util.Map;

import info.rexs.schema.constants.RexsVersion;
import info.rexs.schema.jaxb.RexsSchema;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;

/**
 * This class provides the REXS schemas of all available REXS versions (REXS standard and own).
 *
 * @author FVA GmbH
 */
public class RexsSchemaResolver {

	/** The singleton instance of this class. */
	private static RexsSchemaResolver instance = null;

	/** An internal index with all created REXS schemas (REXS standard and own) for quick access. */
	private final Map<RexsSchemaFile, RexsSchema> rexsSchemaFileCache = new HashMap<>();

	private RexsSchemaResolver() {}

	/**
	 * @return
	 * 				The singleton instance of this class.
	 */
	public static synchronized RexsSchemaResolver getInstance() {
		if (instance == null)
			instance = new RexsSchemaResolver();
		return instance;
	}

	/**
	 * Determines the REXS schema for a version.
	 *
	 * @param version
	 * 				The {@link RexsVersion} of the REXS schema.
	 *
	 * @return
	 * 				The found {@link RexsSchema}, or {@code null} if the REXS schema could not be found.
	 */
	public RexsSchema resolve(RexsVersion version) {
		RexsSchemaFile rexsSchemaFile = RexsSchemaFile.findByVersion(version);
		if (rexsSchemaFile == null)
			return null;

		if (rexsSchemaFileCache.containsKey(rexsSchemaFile))
			return rexsSchemaFileCache.get(rexsSchemaFile);

		RexsSchema rexsSchema = null;

		try (InputStream input = rexsSchemaFile.openInputStream()) {
			JAXBContext context = JAXBContext.newInstance(RexsSchema.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			rexsSchema = (RexsSchema)unmarshaller.unmarshal(input);
		} catch (Exception ex) {
			throw new IllegalStateException(String.format("could not load rexs schema for version %s", rexsSchemaFile.getVersion()), ex);
		}

		rexsSchemaFileCache.put(rexsSchemaFile, rexsSchema);
		return rexsSchema;
	}
}
