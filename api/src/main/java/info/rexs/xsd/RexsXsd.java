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
package info.rexs.xsd;

import java.io.InputStream;

/**
 * This enum represents a REXS XSD schema.
 *
 * @author FVA GmbH
 */
public enum RexsXsd {

	/**
	 * The XSD schema file for the REXS changelog files.
	 */
	CHANGELOG("rexs-changelog.xsd"),

	/**
	 * The XSD schema file for the REXS schema files.
	 */
	SCHEMA("rexs-schema.xsd"),

	/**
	 * The XSD schema file for REXS files.
	 */
	FILE("rexs-file.xsd"),

	/**
	 * The XSD schema file for REXS files.
	 * This schema contains a namespace specification.
	 */
	FILE_WITH_NAMESPACE("rexs-file-ns.xsd");

	private String filename;

	RexsXsd(String filename) {
		this.filename = filename;
	}

	/**
	 * Opens an input stream for the REXS XSD schema file and returns it.
	 *
	 * @return
	 * 				The {@link InputStream} for the REXS XSD schema file.
	 */
	public InputStream openInputStream() {
		return this.getClass().getResourceAsStream(filename);
	}
}
