/*
 * Copyright (C) 2023 FVA GmbH
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
package info.rexs.io;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import info.rexs.model.RexsModel;

public abstract class AbstractRexsFileReader {

	/** The {@link Resource} to the REXS input file. */
	protected final Resource rexsInputFileResource;

	/**
	 * Constructs a new {@link AbstractRexsFileReader} for the given {@link Resource} to the REXS input file.
	 *
	 * @param rexsInputFileResource
	 * 				The {@link Resource} to the REXS input file.
	 */
	protected AbstractRexsFileReader(Resource rexsInputFileResource) {
		this.rexsInputFileResource = rexsInputFileResource;
	}

	/**
	 * Constructs a new {@link AbstractRexsFileReader} for the given {@link Path} to the REXS input file.
	 *
	 * @param pathToRexsInputFile
	 * 				The {@link Path} to the REXS input file.
	 */
	protected AbstractRexsFileReader(Path pathToRexsInputFile) {
		this(new FileResource(pathToRexsInputFile));
	}

	/**
	 * Constructs a new {@link AbstractRexsFileReader} for the given REXS input {@link File}.
	 *
	 * @param rexsInputFile
	 * 				The REXS input {@link File}.
	 */
	protected AbstractRexsFileReader(File rexsInputFile) {
		this(rexsInputFile.toPath());
	}

	/**
	 * Constructs a new {@link AbstractRexsFileReader} for the given path to the REXS input file as {@link String}.
	 *
	 * @param rexsInputFilePath
	 * 				The path to the REXS input file as {@link String}.
	 */
	protected AbstractRexsFileReader(String rexsInputFilePath) {
		this(Paths.get(rexsInputFilePath));
	}

	protected void validateInputFile() throws RexsIoException {
		if (!rexsInputFileResource.exists())
			throw new RexsIoException("rexs file " + rexsInputFileResource.getFilename() + " does not exist");
	}

	public abstract RexsModel read() throws RexsIoException;
}
