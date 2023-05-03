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

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import info.rexs.io.AbstractRexsFileReader;
import info.rexs.io.ByteArrayResource;
import info.rexs.io.Resource;
import info.rexs.io.RexsFileReader;
import info.rexs.io.RexsIoException;
import info.rexs.io.RexsIoFormat;
import info.rexs.model.RexsModel;
import info.rexs.model.jaxb.Model;

/**
 * The {@link RexsZipFileReader} reads a REXS file into the raw model {@link Model} and the base model {@link RexsModel}.
 *
 * @author FVA GmbH
 */
public class RexsZipFileReader extends AbstractRexsFileReader {

	/**
	 * Constructs a new {@link RexsZipFileReader} for the given {@link Resource} to the REXS input file.
	 *
	 * @param rexsInputFileResource
	 * 				The {@link Resource} to the REXS input file.
	 */
	public RexsZipFileReader(Resource rexsInputFileResource) {
		super(rexsInputFileResource);
	}

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

		Resource rexsFileInZipResource = null;
		try {
			rexsFileInZipResource = extractRexsFileFromZip();
			if (rexsFileInZipResource == null) {
				throw new RexsIoException("unable to locate rexs file in rexs zip archive " + rexsInputFileResource.getFilename());
			}

			RexsFileReader reader = new RexsFileReader(rexsFileInZipResource);
			return reader.read();

		} catch (IOException ex) {
			throw new RexsIoException("error on reading rexs model from zip file", ex);
		}
	}

	public Resource extractRexsFileFromZip() throws IOException {
		try (ZipInputStream input = new ZipInputStream(rexsInputFileResource.openInputStream())) {
			ZipEntry entry;
			while((entry = input.getNextEntry()) != null) {
				RexsIoFormat format = RexsIoFormat.findFormatByFilename(entry.getName());
				if (format == null)
					continue;

				byte[] buffer = new byte[2048];
				try (ByteArrayOutputStream output = new ByteArrayOutputStream()) {
					int len;
					while ((len = input.read(buffer)) > 0) {
						output.write(buffer, 0, len);
					}

					return new ByteArrayResource(output.toByteArray(), entry.getName());
				}
			}
		}

		return null;
	}
}
