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
package info.rexs.io;

import java.io.File;
import java.nio.file.Path;

import info.rexs.model.RexsModel;
import info.rexs.model.jaxb.Model;

/**
 * The {@link RexsFileReader} reads a REXS file into the raw model {@link Model} and the base model {@link RexsModel}.
 *
 * @author FVA GmbH
 */
public class RexsFileReader extends AbstractRexsFileReader {

	/**
	 * Constructs a new {@link RexsFileReader} for the given {@link Path} to the REXS input file.
	 *
	 * @param pathToRexsInputFile
	 * 				The {@link Path} to the REXS input file.
	 */
	public RexsFileReader(Path pathToRexsInputFile) {
		super(pathToRexsInputFile);
	}

	/**
	 * Constructs a new {@link RexsFileReader} for the given REXS input {@link File}.
	 *
	 * @param rexsInputFile
	 * 				The REXS input {@link File}.
	 */
	public RexsFileReader(File rexsInputFile) {
		super(rexsInputFile);
	}

	/**
	 * Constructs a new {@link RexsFileReader} for the given path to the REXS input file as {@link String}.
	 *
	 * @param rexsInputFilePath
	 * 				The path to the REXS input file as {@link String}.
	 */
	public RexsFileReader(String rexsInputFilePath) {
		super(rexsInputFilePath);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RexsModel read() throws RexsIoException {
		validateInputFile();

		RexsIoFormat format = RexsIoFormat.findFormatByFilename(pathToRexsInputFile.getFileName().toString());
		if (format == null)
			throw new RexsIoException("rexs file " + pathToRexsInputFile + " has unknown filename ending");

		AbstractRexsFileReader reader = format.createNewFileReader(pathToRexsInputFile);
		return reader.read();
	}
}
