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

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

public class RexsFileUpgraderTest {

	@Test
	public void upgrade_upgradesRexsFile() throws Exception {
		Path rexsInputFilePath = Paths.get("src/test/resources").resolve("FVA_Planetary_stage_-_Minus_gearing_1.1.rexs");
		Path rexsOutputFilePath = Paths.get("target").resolve("rexs-upgrade-path-file-" + System.currentTimeMillis() + ".rexs");

		RexsFileUpgrader rexsFileUpgrader = new RexsFileUpgrader(rexsInputFilePath, rexsOutputFilePath);
		rexsFileUpgrader.upgrade();

		assertThat(rexsOutputFilePath).exists();
		assertThat(Files.size(rexsOutputFilePath)).isGreaterThan(0l);
	}

	@Test
	public void upgrade_upgradesRexsFileWithFile() throws Exception {
		File rexsInputFile = new File("src/test/resources/FVA_Planetary_stage_-_Minus_gearing_1.1.rexs");
		File rexsOutputFile = new File("target/rexs-upgrade-file-" + System.currentTimeMillis() + ".rexs");

		RexsFileUpgrader rexsFileUpgrader = new RexsFileUpgrader(rexsInputFile, rexsOutputFile);
		rexsFileUpgrader.upgrade();

		assertThat(rexsOutputFile).exists();
		assertThat(rexsOutputFile.length()).isGreaterThan(0l);
	}

	@Test
	public void upgrade_upgradesRexsFileWithString() throws Exception {
		String rexsInputFileStringPath = "src/test/resources/SEW_3-stage_cylindrical_gearbox_1.0.rexs";
		String rexsOutputFileStringPath = "target/rexs-upgrade-file-" + System.currentTimeMillis() + ".rexs";

		RexsFileUpgrader rexsFileUpgrader = new RexsFileUpgrader(rexsInputFileStringPath, rexsOutputFileStringPath);
		rexsFileUpgrader.upgrade();

		Path rexsOutputFilePath = Paths.get(rexsOutputFileStringPath);
		assertThat(rexsOutputFilePath).exists();
		assertThat(Files.size(rexsOutputFilePath)).isGreaterThan(0l);
	}
}
