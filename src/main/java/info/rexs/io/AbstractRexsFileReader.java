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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import info.rexs.model.RexsModel;

public abstract class AbstractRexsFileReader {

	/** The {@link Path} to the REXS input file. */
	protected final Path pathToRexsInputFile;

	/**
	 * Constructs a new {@link AbstractRexsFileReader} for the given {@link Path} to the REXS input file.
	 *
	 * @param pathToRexsInputFile
	 * 				The {@link Path} to the REXS input file.
	 */
	public AbstractRexsFileReader(Path pathToRexsInputFile) {
		this.pathToRexsInputFile = pathToRexsInputFile;
	}

	/**
	 * Constructs a new {@link AbstractRexsFileReader} for the given REXS input {@link File}.
	 *
	 * @param rexsInputFile
	 * 				The REXS input {@link File}.
	 */
	public AbstractRexsFileReader(File rexsInputFile) {
		this(rexsInputFile.toPath());
	}

	/**
	 * Constructs a new {@link AbstractRexsFileReader} for the given path to the REXS input file as {@link String}.
	 *
	 * @param rexsInputFilePath
	 * 				The path to the REXS input file as {@link String}.
	 */
	public AbstractRexsFileReader(String rexsInputFilePath) {
		this(Paths.get(rexsInputFilePath));
	}

	protected void validateInputFile() throws RexsIoException {
		if (!Files.exists(pathToRexsInputFile))
			throw new RexsIoException("rexs file " + pathToRexsInputFile + " does not exist");
	}

	public abstract RexsModel read() throws RexsIoException;
}
