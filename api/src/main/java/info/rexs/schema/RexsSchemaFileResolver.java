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

/**
 * This class is used to determine the content of REXS schema files.
 * <p>
 * If you extend the REXS model, create your own implementation of this class.
 *
 * @author FVA GmbH
 */
public class RexsSchemaFileResolver {

	/**
	 * Returns an input stream with the content of the REXS schema file.
	 *
	 * @param rexsSchemaFile
	 * 				The {@link RexsSchemaFile} whose input stream is to be opened.
	 *
	 * @return
	 * 				The {@link InputStream} of the file.
	 */
	public InputStream openInputStream(RexsSchemaFile rexsSchemaFile) {
		String rexsSchemaFilename = String.format("rexs_schema_%s.xml", rexsSchemaFile.getVersion().getName());
		return rexsSchemaFile.getClass().getResourceAsStream(rexsSchemaFilename);
	}
}
