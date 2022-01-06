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
 * The {@link RexsFileWriter} writes a REXS base model {@link RexsModel} and REXS raw model {@link Model} to a file.
 *
 * @author FVA GmbH
 */
public class RexsFileWriter extends AbstractRexsFileWriter {

	/**
	 * Constructs a new {@link RexsFileWriter} for the given {@link Path} to the REXS output file.
	 *
	 * @param pathToRexsOutputFile
	 * 				The {@link Path} to the REXS output file.
	 */
	public RexsFileWriter(Path pathToRexsOutputFile) {
		super(pathToRexsOutputFile);
	}

	/**
	 * Constructs a new {@link RexsFileWriter} for the given REXS output {@link File}.
	 *
	 * @param rexsOutputFile
	 * 				The REXS output {@link File}.
	 */
	public RexsFileWriter(File rexsOutputFile) {
		super(rexsOutputFile);
	}

	/**
	 * Constructs a new {@link RexsFileWriter} for the given path to the REXS output file as {@link String}.
	 *
	 * @param rexsOutputFilePath
	 * 				The path to the REXS output file as {@link String}.
	 */
	public RexsFileWriter(String rexsOutputFilePath) {
		super(rexsOutputFilePath);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void write(RexsModel model) throws RexsIoException {
		validateOutputFile();

		RexsIoFormat format = RexsIoFormat.findFormatByFilename(pathToRexsOutputFile.getFileName().toString());
		if (format == null)
			throw new RexsIoException("rexs file " + pathToRexsOutputFile + " has unknown filename ending");

		AbstractRexsFileWriter writer = format.createNewFileWriter(pathToRexsOutputFile);
		writer.write(model);
	}
}
