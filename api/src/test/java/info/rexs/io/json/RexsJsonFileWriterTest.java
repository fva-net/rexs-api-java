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
package info.rexs.io.json;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Before;
import org.junit.Test;

import info.rexs.io.RexsFileReader;
import info.rexs.model.RexsModel;

public class RexsJsonFileWriterTest {

	private RexsModel aRexsModelToWrite;

	@Before
	public void beforeEach() throws Exception {
		Path rexsFilePath = Paths.get("src/test/resources").resolve("FVA_Planetary_stage_-_Minus_gearing_1.1.rexsj");
		RexsJsonFileReader reader = new RexsJsonFileReader(rexsFilePath);
		aRexsModelToWrite = reader.read();
	}

	@Test
	public void write_writesRexsFile() throws Exception {
		Path rexsTargetFilePath = Paths.get("target").resolve("rexs-path-file-" + System.currentTimeMillis() + ".rexsj");
		RexsJsonFileWriter writer = new RexsJsonFileWriter(rexsTargetFilePath);
		writer.write(aRexsModelToWrite);

		RexsJsonFileReader reader = new RexsJsonFileReader(rexsTargetFilePath);
		RexsModel writtenRexsModel = reader.read();

		assertThat(writtenRexsModel.getComponents()).hasSameSizeAs(aRexsModelToWrite.getComponents());
	}

	@Test
	public void write_writesRexsFileWithFile() throws Exception {
		File rexsTargetFile = new File("target/rexs-file-" + System.currentTimeMillis() + ".rexsj");
		RexsJsonFileWriter writer = new RexsJsonFileWriter(rexsTargetFile);
		writer.write(aRexsModelToWrite);

		assertThat(rexsTargetFile).exists().isNotEmpty();
	}

	@Test
	public void write_writesRexsFileWithString() throws Exception {
		String rexsTargetFileStringPath = "target/rexs-file-string-" + System.currentTimeMillis() + ".rexsj";
		RexsJsonFileWriter writer = new RexsJsonFileWriter(rexsTargetFileStringPath);
		writer.write(aRexsModelToWrite);

		Path rexsTargetFilePath = Paths.get(rexsTargetFileStringPath);
		assertThat(rexsTargetFilePath).exists();
		assertThat(Files.size(rexsTargetFilePath)).isPositive();
	}

	@Test
	public void write_writeRexsjFileFromRexsModel() throws Exception {
		String rexsInputFileStringPath = "src/test/resources/SEW_3-stage_cylindrical_gearbox_1.0.rexs";
		String rexsOutputFileStringPath = "target/rexs-switch-file-" + System.currentTimeMillis() + ".rexsj";

		RexsFileReader reader = new RexsFileReader(rexsInputFileStringPath);
		RexsModel model = aRexsModelToWrite = reader.read();
	
		RexsJsonFileWriter writer = new RexsJsonFileWriter(rexsOutputFileStringPath);
		writer.write(model);

		Path rexsOutputFilePath = Paths.get(rexsOutputFileStringPath);
		assertThat(rexsOutputFilePath).exists();
		assertThat(Files.size(rexsOutputFilePath)).isGreaterThan(0l);
	}
}
