/*******************************************************************************
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
 ******************************************************************************/
package info.rexs.io.zip;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.zip.Deflater;
import java.util.zip.ZipOutputStream;

import info.rexs.io.AbstractRexsFileWriter;
import info.rexs.io.RexsIoException;
import info.rexs.io.xml.RexsXmlFileWriter;
import info.rexs.model.RexsModel;
import info.rexs.model.jaxb.Model;

/**
 * The {@link RexsZipFileWriter} writes a REXS base model {@link RexsModel} and REXS raw model {@link Model} to a zip file.
 *
 * @author FVA GmbH
 */
public class RexsZipFileWriter extends AbstractRexsFileWriter {

	/**
	 * Constructs a new {@link RexsZipFileWriter} for the given {@link Path} to the REXS output file.
	 *
	 * @param pathToRexsOutputFile
	 * 				The {@link Path} to the REXS output file.
	 */
	public RexsZipFileWriter(Path pathToRexsOutputFile) {
		super(pathToRexsOutputFile);
	}

	/**
	 * Constructs a new {@link RexsZipFileWriter} for the given REXS output {@link File}.
	 *
	 * @param rexsOutputFile
	 * 				The REXS output {@link File}.
	 */
	public RexsZipFileWriter(File rexsOutputFile) {
		super(rexsOutputFile);
	}

	/**
	 * Constructs a new {@link RexsZipFileWriter} for the given path to the REXS output file as {@link String}.
	 *
	 * @param rexsOutputFilePath
	 * 				The path to the REXS output file as {@link String}.
	 */
	public RexsZipFileWriter(String rexsOutputFilePath) {
		super(rexsOutputFilePath);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void write(RexsModel model) throws RexsIoException {
		createNewArchive();

		try (FileSystem fileStorageFileSystem = FileSystems.newFileSystem(pathToRexsOutputFile))
		{
			Path pathToFileInArchive = fileStorageFileSystem.getPath("/rexs-model.rexs");
			RexsXmlFileWriter rexsXmlFileWriter = new RexsXmlFileWriter(pathToFileInArchive);
			rexsXmlFileWriter.write(model);

		} catch (Exception ex) {
			throw new RexsIoException("error on writing rexs model to zip file", ex);
		}
	}

	private void createNewArchive() throws RexsIoException {

		if (Files.exists(pathToRexsOutputFile)) {
			try {
				Files.delete(pathToRexsOutputFile);
			} catch (IOException ex) {
				throw new RexsIoException("rexs archive already exists and cannot be deleted", ex);
			}

		} else {
			Path pathToRexsOutputFileDirectory = pathToRexsOutputFile.getParent();
			if (pathToRexsOutputFileDirectory != null && !Files.exists(pathToRexsOutputFileDirectory))
				throw new RexsIoException("directory " + pathToRexsOutputFileDirectory + " does not exist");
		}

		try (ZipOutputStream out = new ZipOutputStream(
				Files.newOutputStream(
						pathToRexsOutputFile,
						StandardOpenOption.CREATE,
						StandardOpenOption.TRUNCATE_EXISTING))) {
			out.setLevel(Deflater.NO_COMPRESSION);
			out.closeEntry();

		} catch (IOException ex) {
			throw new RexsIoException("error on createing new rexs zip archive");
		}
	}
}