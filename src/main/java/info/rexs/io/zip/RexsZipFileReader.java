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
package info.rexs.io.zip;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import info.rexs.io.AbstractRexsFileReader;
import info.rexs.io.RexsFileReader;
import info.rexs.io.RexsIoException;
import info.rexs.model.RexsModel;
import info.rexs.model.jaxb.Model;

/**
 * The {@link RexsZipFileReader} reads a REXS file into the raw model {@link Model} and the base model {@link RexsModel}.
 *
 * @author FVA GmbH
 */
public class RexsZipFileReader extends AbstractRexsFileReader {

	/**
	 * Constructs a new {@link RexsZipFileReader} for the given {@link Path} to the REXS input file.
	 *
	 * @param pathToRexsInputFile
	 * 				The {@link Path} to the REXS input file.
	 */
	public RexsZipFileReader(Path pathToRexsInputFile) {
		super(pathToRexsInputFile);
	}

	/**
	 * Constructs a new {@link RexsZipFileReader} for the given REXS input {@link File}.
	 *
	 * @param rexsInputFile
	 * 				The REXS input {@link File}.
	 */
	public RexsZipFileReader(File rexsInputFile) {
		super(rexsInputFile);
	}

	/**
	 * Constructs a new {@link RexsZipFileReader} for the given path to the REXS input file as {@link String}.
	 *
	 * @param rexsInputFilePath
	 * 				The path to the REXS input file as {@link String}.
	 */
	public RexsZipFileReader(String rexsInputFilePath) {
		super(rexsInputFilePath);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RexsModel read() throws RexsIoException {
		validateInputFile();

		Path pathToRexsFile = null;
		try {
			pathToRexsFile = extractRexsFileFromZip(pathToRexsInputFile);
			if (pathToRexsFile == null) {
				throw new RexsIoException("unable to locate rexs file in rexs zip archive " + pathToRexsInputFile);
			}

			RexsFileReader reader = new RexsFileReader(pathToRexsFile);
			return reader.read();

		} catch (IOException ex) {
			throw new RexsIoException("error on reading rexs model from zip file", ex);

		} finally {
			try {
				Files.deleteIfExists(pathToRexsFile);
			} catch (IOException ex) {
				// Nothing to do
			}
		}
	}

	public Path extractRexsFileFromZip() throws IOException {
		return extractRexsFileFromZip(pathToRexsInputFile);
	}

	private Path extractRexsFileFromZip(Path pathToRexszFile) throws IOException {
		try(FileSystem fs = FileSystems.newFileSystem(pathToRexszFile, (ClassLoader)null)) {
			final Path root = fs.getPath("/");
			RexsZipFileVisitor fileVisitor = new RexsZipFileVisitor(root);
			Files.walkFileTree(root, fileVisitor);
			Path foundRexsFile = fileVisitor.getFoundRexsFile();

			if (foundRexsFile != null) {
				Path pathToRexsFile = Files.createTempFile("rexs-file", foundRexsFile.getFileName().toString());
				Files.copy(foundRexsFile, pathToRexsFile, StandardCopyOption.REPLACE_EXISTING);
				return pathToRexsFile;
			}
		}

		return null;
	}
}
