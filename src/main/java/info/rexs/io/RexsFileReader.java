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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import info.rexs.model.RexsModel;
import info.rexs.model.jaxb.Model;

/**
 * The {@link RexsFileReader} reads a REXS file into the raw model {@link Model} and the base model {@link RexsModel}.
 *
 * @author FVA GmbH
 */
public class RexsFileReader {

	/** The {@link Path} to the REXS input file. */
	private final Path pathToRexsInputFile;

	/**
	 * Constructs a new {@link RexsFileReader} for the given {@link Path} to the REXS input file.
	 *
	 * @param pathToRexsInputFile
	 * 				The {@link Path} to the REXS input file.
	 */
	public RexsFileReader(Path pathToRexsInputFile) {
		this.pathToRexsInputFile = pathToRexsInputFile;
	}

	/**
	 * Constructs a new {@link RexsFileReader} for the given REXS input {@link File}.
	 *
	 * @param rexsInputFile
	 * 				The REXS input {@link File}.
	 */
	public RexsFileReader(File rexsInputFile) {
		this(rexsInputFile.toPath());
	}

	/**
	 * Constructs a new {@link RexsFileReader} for the given path to the REXS input file as {@link String}.
	 *
	 * @param rexsInputFilePath
	 * 				The path to the REXS input file as {@link String}.
	 */
	public RexsFileReader(String rexsInputFilePath) {
		this(Paths.get(rexsInputFilePath));
	}

	/**
	 * Reads the REXS input file into the raw model {@link Model}.
	 *
	 * @return The newly created {@link Model}.
	 *
	 * @throws FileNotFoundException
	 * 				If the REXS input file does not exist.
	 * @throws IOException
	 * 				In case of an IO error while reading the REXS input file.
	 * @throws JAXBException
	 * 				If any unexpected errors occur while unmarshalling the REXS input file.
	 */
	public Model readRawModel() throws FileNotFoundException, IOException, JAXBException {
		if (!Files.exists(pathToRexsInputFile))
			throw new FileNotFoundException("rexs file " + pathToRexsInputFile + " does not exist");

		JAXBContext context = JAXBContext.newInstance(Model.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();

		if (isRexsZipFile(pathToRexsInputFile)) {
			Path pathToRexsFile = null;
			try {
				pathToRexsFile = extractRexsFileFromZip(pathToRexsInputFile);
				return (Model)unmarshaller.unmarshal(pathToRexsFile.toFile());
			} finally {
				Files.deleteIfExists(pathToRexsFile);
			}
		}

		return (Model)unmarshaller.unmarshal(pathToRexsInputFile.toFile());
	}

	/**
	 * Reads the REXS input file into the base model {@link RexsModel}.
	 *
	 * @return The newly created {@link RexsModel}.
	 *
	 * @throws FileNotFoundException
	 * 				If the REXS input file does not exist.
	 * @throws IOException
	 * 				In case of an IO error while reading the REXS input file.
	 * @throws JAXBException
	 * 				If any unexpected errors occur while unmarshalling the REXS input file.
	 */
	public RexsModel read() throws FileNotFoundException, IOException, JAXBException {
		Model rawModel = readRawModel();
		return new RexsModel(rawModel);
	}

	public static boolean isRexsZipFile(Path pathToRexsFile) {
		return Files.exists(pathToRexsFile)
				&& (pathToRexsFile.endsWith(".zip") || pathToRexsFile.endsWith(".rexsz"));
	}

	public static Path extractRexsFileFromZip(Path pathToRexszFile) throws IOException
	{
		Path pathToRexsFile = Files.createTempFile("rexs-file", ".rexs");

		try(FileSystem fs = FileSystems.newFileSystem(pathToRexszFile, null)) {
			final Path root = fs.getPath("/");
			Files.walkFileTree(root, new SimpleFileVisitor<Path>() {
				@Override
				public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
					if (dir.toString().equals(root.toString()))
						return FileVisitResult.CONTINUE;
					// ignore directory - rexs file has to be located in the root directory of the zip archive
					return FileVisitResult.SKIP_SUBTREE;
				}

				@Override
				public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
					if (file.toString().endsWith(".rexs")) {
						Files.copy(file, pathToRexsFile, StandardCopyOption.REPLACE_EXISTING);
						return FileVisitResult.TERMINATE;
					}
					return FileVisitResult.CONTINUE;
				}
			});
		}

		return pathToRexsFile;
	}
}
