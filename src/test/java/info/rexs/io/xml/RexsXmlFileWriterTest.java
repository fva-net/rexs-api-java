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
package info.rexs.io.xml;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Before;
import org.junit.Test;

import info.rexs.io.RexsIoException;
import info.rexs.model.RexsModel;
import info.rexs.model.jaxb.Model;

public class RexsXmlFileWriterTest {

	private RexsModel aRexsModelToWrite;

	private Model aRexsModelToWriteXml;

	@Before
	public void beforeEach() throws Exception {
		Path rexsFilePath = Paths.get("src/test/resources").resolve("FVA_Planetary_stage_-_Minus_gearing_1.1.rexs");
		RexsXmlFileReader reader = new RexsXmlFileReader(rexsFilePath);
		aRexsModelToWrite = reader.read();
		aRexsModelToWriteXml = reader.readRawModel();
	}

	@Test
	public void writeRawModel_nonExistingFileIsCreated() throws Exception {
		Path nonExistingFilePath = Paths.get("target").resolve("non-existing-file-" + System.currentTimeMillis() + ".rexs");
		RexsXmlFileWriter writer = new RexsXmlFileWriter(nonExistingFilePath);
		writer.writeRawModel(aRexsModelToWriteXml);

		assertThat(nonExistingFilePath).exists();
		assertThat(Files.size(nonExistingFilePath)).isGreaterThan(0l);
	}

	@Test
	public void writeRawModel_nonWritableFileThrowsIOException() throws Exception {
		Path nonWritableFilePath = Paths.get("target").resolve("non-writable-file-" + System.currentTimeMillis() + ".rexs");
		Files.createFile(nonWritableFilePath);
		nonWritableFilePath.toFile().setWritable(false);

		assertThatExceptionOfType(RexsIoException.class).isThrownBy(() -> {
			RexsXmlFileWriter writer = new RexsXmlFileWriter(nonWritableFilePath);
			writer.writeRawModel(aRexsModelToWriteXml);
		})
		.withMessageEndingWith("is not writable");
	}

	@Test
	public void writeRawModel_writesExistingRexsFile() throws Exception {
		Path existingFilePath = Paths.get("target").resolve("existing-file-" + System.currentTimeMillis() + ".rexs");
		Files.createFile(existingFilePath);
		RexsXmlFileWriter writer = new RexsXmlFileWriter(existingFilePath);
		writer.writeRawModel(aRexsModelToWriteXml);

		assertThat(existingFilePath).exists();
		assertThat(Files.size(existingFilePath)).isGreaterThan(0l);
	}

	@Test
	public void write_writesRexsFile() throws Exception {
		Path rexsTargetFilePath = Paths.get("target").resolve("rexs-path-file-" + System.currentTimeMillis() + ".rexs");
		RexsXmlFileWriter writer = new RexsXmlFileWriter(rexsTargetFilePath);
		writer.write(aRexsModelToWrite);

		RexsXmlFileReader reader = new RexsXmlFileReader(rexsTargetFilePath);
		RexsModel writtenRexsModel = reader.read();

		assertThat(writtenRexsModel.getComponents().size()).isEqualTo(aRexsModelToWrite.getComponents().size());
	}

	@Test
	public void write_writesRexsFileWithFile() throws Exception {
		File rexsTargetFile = new File("target/rexs-file-" + System.currentTimeMillis() + ".rexs");
		RexsXmlFileWriter writer = new RexsXmlFileWriter(rexsTargetFile);
		writer.write(aRexsModelToWrite);

		assertThat(rexsTargetFile).exists();
		assertThat(rexsTargetFile.length()).isGreaterThan(0l);
	}

	@Test
	public void write_writesRexsFileWithString() throws Exception {
		String rexsTargetFileStringPath = "target/rexs-file-string-" + System.currentTimeMillis() + ".rexs";
		RexsXmlFileWriter writer = new RexsXmlFileWriter(rexsTargetFileStringPath);
		writer.write(aRexsModelToWrite);

		Path rexsTargetFilePath = Paths.get(rexsTargetFileStringPath);
		assertThat(rexsTargetFilePath).exists();
		assertThat(Files.size(rexsTargetFilePath)).isGreaterThan(0l);
	}
}
