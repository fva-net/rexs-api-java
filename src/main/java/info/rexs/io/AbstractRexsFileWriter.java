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
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import info.rexs.model.RexsModel;

public abstract class AbstractRexsFileWriter {

	/** The {@link Path} to the REXS output file. */
	protected final Path pathToRexsOutputFile;

	/**
	 * Constructs a new {@link AbstractRexsFileWriter} for the given {@link Path} to the REXS output file.
	 *
	 * @param pathToRexsOutputFile
	 * 				The {@link Path} to the REXS output file.
	 */
	public AbstractRexsFileWriter(Path pathToRexsOutputFile) {
		this.pathToRexsOutputFile = pathToRexsOutputFile;
	}

	/**
	 * Constructs a new {@link AbstractRexsFileWriter} for the given REXS output {@link File}.
	 *
	 * @param rexsOutputFile
	 * 				The REXS output {@link File}.
	 */
	public AbstractRexsFileWriter(File rexsOutputFile) {
		this(rexsOutputFile.toPath());
	}

	/**
	 * Constructs a new {@link AbstractRexsFileWriter} for the given path to the REXS output file as {@link String}.
	 *
	 * @param rexsOutputFilePath
	 * 				The path to the REXS output file as {@link String}.
	 */
	public AbstractRexsFileWriter(String rexsOutputFilePath) {
		this(Paths.get(rexsOutputFilePath));
	}

	protected void validateOutputFile() throws RexsIoException {
		if (!Files.exists(pathToRexsOutputFile)) {
			Path pathToRexsOutputFileDirectory = pathToRexsOutputFile.getParent();
			if (pathToRexsOutputFileDirectory != null && !Files.exists(pathToRexsOutputFileDirectory))
				throw new RexsIoException("directory " + pathToRexsOutputFileDirectory + " does not exist");

			try {
				Files.createFile(pathToRexsOutputFile);

			} catch (IOException ex) {
				throw new RexsIoException("error creating new rexs file", ex);
			}
		}

		if (!Files.isWritable(pathToRexsOutputFile))
			throw new RexsIoException("file " + pathToRexsOutputFile + " is not writable");
	}

	public abstract void write(RexsModel model) throws RexsIoException;
}
