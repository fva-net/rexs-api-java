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

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

import info.rexs.io.RexsIoException;
import info.rexs.model.RexsModel;

public class RexsZipFileReaderTest {

	@Test
	public void read_nonExistingFileThrowsFileNotFoundException() throws Exception {
		Path nonExistingFilePath = Paths.get("path/to/non/existing/file");

		assertThatExceptionOfType(RexsIoException.class).isThrownBy(() -> {
			RexsZipFileReader reader = new RexsZipFileReader(nonExistingFilePath);
			reader.read();
		})
		.withMessageEndingWith("does not exist");
	}

	@Test
	public void read_readsExsistingRexsFile() throws Exception {
		Path rexsFilePath = Paths.get("src/test/resources").resolve("FVA_Planetary_stage_-_Minus_gearing_1.1.rexsz");
		RexsZipFileReader reader = new RexsZipFileReader(rexsFilePath);
		RexsModel rexsModel = reader.read();

		assertThat(rexsModel).isNotNull();
		assertThat(rexsModel.getComponents().size()).isEqualTo(97);
	}

	@Test
	public void read_readsExsistingRexsFileWithFile() throws Exception {
		File rexsFile = new File("src/test/resources/FVA_Planetary_stage_-_Minus_gearing_1.1.rexsz");
		RexsZipFileReader reader = new RexsZipFileReader(rexsFile);
		RexsModel rexsModel = reader.read();

		assertThat(rexsModel).isNotNull();
		assertThat(rexsModel.getComponents().size()).isEqualTo(97);
	}

	@Test
	public void read_readsExsistingRexsFileWithString() throws Exception {
		String rexsFileStringPath = "src/test/resources/FVA_Planetary_stage_-_Minus_gearing_1.1.rexsz";
		RexsZipFileReader reader = new RexsZipFileReader(rexsFileStringPath);
		RexsModel rexsModel = reader.read();

		assertThat(rexsModel).isNotNull();
		assertThat(rexsModel.getComponents().size()).isEqualTo(97);
	}
}
