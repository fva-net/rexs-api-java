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
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.xml.bind.JAXBException;

import info.rexs.model.jaxb.Model;
import info.rexs.upgrade.RexsUpgradeException;
import info.rexs.upgrade.RexsUpgrader;

/**
 * The {@link RexsFileUpgrader} reads a REXS file, upgrades it to the latest REXS version and writes it to a file.
 *
 * @author FVA GmbH
 */
public class RexsFileUpgrader {

	/** The {@link Path} to the REXS input file. */
	private final Path pathToRexsInputFile;

	/** The {@link Path} to the REXS output file. */
	private final Path pathToRexsOutputFile;

	/**
	 * Constructs a new {@link RexsFileUpgrader} for the given {@link Path}s to the REXS input file and the REXS output file.
	 *
	 * @param pathToRexsInputFile
	 * 				The {@link Path} to the REXS input file.
	 * @param pathToRexsOutputFile
	 * 				The {@link Path} to the REXS output file.
	 */
	public RexsFileUpgrader(Path pathToRexsInputFile, Path pathToRexsOutputFile) {
		this.pathToRexsInputFile = pathToRexsInputFile;
		this.pathToRexsOutputFile = pathToRexsOutputFile;
	}

	/**
	 * Constructs a new {@link RexsFileUpgrader} for the given REXS input {@link File} and REXS output {@link File}.
	 *
	 * @param rexsInputFile
	 * 				The REXS input {@link File}.
	 * @param rexsOutputFile
	 * 				The REXS output {@link File}.
	 */
	public RexsFileUpgrader(File rexsInputFile, File rexsOutputFile) {
		this(rexsInputFile.toPath(), rexsOutputFile.toPath());
	}

	/**
	 * Constructs a new {@link RexsFileUpgrader} for the given paths to the REXS input and the REXS output file as {@link String}.
	 *
	 * @param rexsInputFilePath
	 * 				The path to the REXS input file as {@link String}.
	 * @param rexsOutputFilePath
	 * 				The path to the REXS output file as {@link String}.
	 */
	public RexsFileUpgrader(String rexsInputFilePath, String rexsOutputFilePath) {
		this(Paths.get(rexsInputFilePath), Paths.get(rexsOutputFilePath));
	}

	/**
	 * Reads the REXS input file, upgrades it to the latest REXS version and writes it to the REXS output file.
	 *
	 * @throws RexsUpgradeException
	 * 				If an unexpected error occurs during the upgrade process.
	 * @throws JAXBException
	 * 				If any unexpected errors occur while unmarshalling the REXS input file or marshalling of the REXS output file.
	 * @throws IOException
	 * 				If the REXS input file does not exist or if the REXS output file is not writable.
	 */
	public void upgrade() throws RexsUpgradeException, JAXBException, IOException {
		RexsFileReader rexsFileReader = new RexsFileReader(pathToRexsInputFile);
		Model rexsModel = rexsFileReader.readRawModel();

		RexsUpgrader rexsUpgrader = new RexsUpgrader(rexsModel);
		rexsUpgrader.upgrade();

		RexsFileWriter rexsFileWriter = new RexsFileWriter(pathToRexsOutputFile);
		rexsFileWriter.writeRawModel(rexsModel);
	}
}
