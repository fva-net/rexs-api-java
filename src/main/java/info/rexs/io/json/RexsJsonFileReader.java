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
package info.rexs.io.json;

import java.io.File;
import java.nio.file.Path;

import info.rexs.io.AbstractRexsFileReader;
import info.rexs.io.RexsIoException;
import info.rexs.model.RexsModel;

public class RexsJsonFileReader extends AbstractRexsFileReader {

	/**
	 * Constructs a new {@link RexsJsonFileReader} for the given {@link Path} to the REXS input file.
	 *
	 * @param pathToRexsInputFile
	 * 				The {@link Path} to the REXS input file.
	 */
	public RexsJsonFileReader(Path pathToRexsInputFile) {
		super(pathToRexsInputFile);
	}

	/**
	 * Constructs a new {@link RexsJsonFileReader} for the given REXS input {@link File}.
	 *
	 * @param rexsInputFile
	 * 				The REXS input {@link File}.
	 */
	public RexsJsonFileReader(File rexsInputFile) {
		super(rexsInputFile);
	}

	/**
	 * Constructs a new {@link RexsJsonFileReader} for the given path to the REXS input file as {@link String}.
	 *
	 * @param rexsInputFilePath
	 * 				The path to the REXS input file as {@link String}.
	 */
	public RexsJsonFileReader(String rexsInputFilePath) {
		super(rexsInputFilePath);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RexsModel read() throws RexsIoException {
		validateInputFile();

		try {
			// TODO: Implementieren!
			return null;

		} catch (Exception ex) {
			throw new RexsIoException("error on reading rexs model from json file", ex);
		}
	}
}
