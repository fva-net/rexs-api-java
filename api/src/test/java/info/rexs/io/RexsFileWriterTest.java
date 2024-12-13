/*
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
 */
package info.rexs.io;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Before;
import org.junit.Test;

import info.rexs.model.IRexsModel;
import info.rexs.model.RexsModel;

public class RexsFileWriterTest {

	private RexsModel aRexsModelToWrite;

	@Before
	public void beforeEach() throws Exception {
		Path rexsFilePath = Paths.get("src/test/resources").resolve("FVA_Planetary_stage_-_Minus_gearing_1.1.rexs");
		RexsFileReader reader = new RexsFileReader(rexsFilePath);
		aRexsModelToWrite = reader.read();
	}

	@Test
	public void write_writesRexsFile() throws Exception {
		Path rexsTargetFilePath = Paths.get("target").resolve("rexs-path-file-" + System.currentTimeMillis() + ".rexs");
		RexsFileWriter writer = new RexsFileWriter(rexsTargetFilePath);
		writer.write(aRexsModelToWrite);

		RexsFileReader reader = new RexsFileReader(rexsTargetFilePath);
		IRexsModel writtenRexsModel = reader.read();

		assertThat(writtenRexsModel.getComponents().size()).isEqualTo(aRexsModelToWrite.getComponents().size());
	}

	@Test
	public void write_writesRexsFileWithFile() throws Exception {
		File rexsTargetFile = new File("target/rexs-file-" + System.currentTimeMillis() + ".rexs");
		RexsFileWriter writer = new RexsFileWriter(rexsTargetFile);
		writer.write(aRexsModelToWrite);

		assertThat(rexsTargetFile).exists();
		assertThat(rexsTargetFile.length()).isGreaterThan(0L);
	}

	@Test
	public void write_writesRexsFileJson() throws Exception {
		Path rexsTargetFilePath = Paths.get("target").resolve("rexs-path-file-" + System.currentTimeMillis() + ".rexsj");
		RexsFileWriter writer = new RexsFileWriter(rexsTargetFilePath);
		writer.write(aRexsModelToWrite);

		RexsFileReader reader = new RexsFileReader(rexsTargetFilePath);
		assertThat(rexsTargetFilePath).exists();
		RexsModel writtenRexsModel = reader.read();

		assertThat(writtenRexsModel.getComponents().size()).isEqualTo(aRexsModelToWrite.getComponents().size());
		assertThat(writtenRexsModel.getRelations().size()).isEqualTo(aRexsModelToWrite.getRelations().size());
		assertThat(writtenRexsModel.getLoadSpectrums().isEmpty()).isEqualTo(aRexsModelToWrite.getLoadSpectrums().isEmpty());
	}

	@Test
	public void write_writesRexsFileJson2() throws Exception {
		Path rexsTargetFilePath = Paths.get("target").resolve("rexs-path-file-" + System.currentTimeMillis() + ".rexs.json");
		RexsFileWriter writer = new RexsFileWriter(rexsTargetFilePath);
		writer.write(aRexsModelToWrite);

		RexsFileReader reader = new RexsFileReader(rexsTargetFilePath);
		assertThat(rexsTargetFilePath).exists();
		RexsModel writtenRexsModel = reader.read();

		assertThat(writtenRexsModel.getComponents().size()).isEqualTo(aRexsModelToWrite.getComponents().size());
		assertThat(writtenRexsModel.getRelations().size()).isEqualTo(aRexsModelToWrite.getRelations().size());
		assertThat(writtenRexsModel.getLoadSpectrums().isEmpty()).isEqualTo(aRexsModelToWrite.getLoadSpectrums().isEmpty());
	}

	@Test
	public void write_writesRexsFileWithFileJson() throws Exception {
		String rexsTargetFileStringPath = "target/rexs-file-string-" + System.currentTimeMillis() + ".rexsj";
		RexsFileWriter writer = new RexsFileWriter(rexsTargetFileStringPath);
		writer.write(aRexsModelToWrite);

		Path rexsTargetFilePath = Paths.get(rexsTargetFileStringPath);
		assertThat(rexsTargetFilePath).exists();
		assertThat(Files.size(rexsTargetFilePath)).isGreaterThan(0L);
	}
}
