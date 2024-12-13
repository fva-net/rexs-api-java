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
package info.rexs.io.zip;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Before;
import org.junit.Test;

import info.rexs.io.xml.RexsXmlFileReader;
import info.rexs.model.IRexsModel;
import info.rexs.model.RexsModel;

public class RexsZipFileWriterTest {

	private RexsModel aRexsModelToWrite;

	@Before
	public void beforeEach() throws Exception {
		Path rexsFilePath = Paths.get("src/test/resources").resolve("FVA_Planetary_stage_-_Minus_gearing_1.1.rexs");
		RexsXmlFileReader reader = new RexsXmlFileReader(rexsFilePath);
		aRexsModelToWrite = reader.read();
	}

	@Test
	public void write_nonExistingFileIsCreated() throws Exception {
		Path nonExistingFilePath = Paths.get("target").resolve("non-existing-file-" + System.currentTimeMillis() + ".rexsz");
		RexsZipFileWriter writer = new RexsZipFileWriter(nonExistingFilePath);
		writer.write(aRexsModelToWrite);

		assertThat(nonExistingFilePath).exists();
		assertThat(Files.size(nonExistingFilePath)).isGreaterThan(0L);
	}

	@Test
	public void write_writesExistingRexsFile() throws Exception {
		Path existingFilePath = Paths.get("target").resolve("existing-file-" + System.currentTimeMillis() + ".rexsz");
		Files.createFile(existingFilePath);
		RexsZipFileWriter writer = new RexsZipFileWriter(existingFilePath);
		writer.write(aRexsModelToWrite);

		assertThat(existingFilePath).exists();
		assertThat(Files.size(existingFilePath)).isGreaterThan(0L);
	}

	@Test
	public void write_writesRexsFile() throws Exception {
		Path rexsTargetFilePath = Paths.get("target").resolve("rexs-path-file-" + System.currentTimeMillis() + ".rexsz");
		RexsZipFileWriter writer = new RexsZipFileWriter(rexsTargetFilePath);
		writer.write(aRexsModelToWrite);

		RexsZipFileReader reader = new RexsZipFileReader(rexsTargetFilePath);
		IRexsModel writtenRexsModel = reader.read();

		assertThat(writtenRexsModel.getComponents().size()).isEqualTo(aRexsModelToWrite.getComponents().size());
	}

	@Test
	public void write_writesRexsFileWithFile() throws Exception {
		File rexsTargetFile = new File("target/rexs-file-" + System.currentTimeMillis() + ".rexsz");
		RexsZipFileWriter writer = new RexsZipFileWriter(rexsTargetFile);
		writer.write(aRexsModelToWrite);

		assertThat(rexsTargetFile).exists();
		assertThat(rexsTargetFile.length()).isGreaterThan(0L);
	}

	@Test
	public void write_writesRexsFileWithString() throws Exception {
		String rexsTargetFileStringPath = "target/rexs-file-string-" + System.currentTimeMillis() + ".rexsz";
		RexsZipFileWriter writer = new RexsZipFileWriter(rexsTargetFileStringPath);
		writer.write(aRexsModelToWrite);

		Path rexsTargetFilePath = Paths.get(rexsTargetFileStringPath);
		assertThat(rexsTargetFilePath).exists();
		assertThat(Files.size(rexsTargetFilePath)).isGreaterThan(0L);
	}
}
