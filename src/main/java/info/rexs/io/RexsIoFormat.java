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

import java.nio.file.Path;

import info.rexs.io.json.RexsJsonFileReader;
import info.rexs.io.json.RexsJsonFileWriter;
import info.rexs.io.xml.RexsXmlFileReader;
import info.rexs.io.xml.RexsXmlFileWriter;
import info.rexs.io.zip.RexsZipFileReader;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum RexsIoFormat {

	JSON("rexsj") {
		@Override
		public AbstractRexsFileWriter createNewFileWriter(Path pathToRexsOutputFile) {
			return new RexsJsonFileWriter(pathToRexsOutputFile);
		}

		@Override
		public AbstractRexsFileReader createNewFileReader(Path pathToRexsInputFile) {
			return new RexsJsonFileReader(pathToRexsInputFile);
		}
	},

	REXS_JSON("rexs.json") {
		@Override
		public AbstractRexsFileWriter createNewFileWriter(Path pathToRexsOutputFile) {
			return new RexsJsonFileWriter(pathToRexsOutputFile);
		}

		@Override
		public AbstractRexsFileReader createNewFileReader(Path pathToRexsInputFile) {
			return new RexsJsonFileReader(pathToRexsInputFile);
		}
	},

	XML("rexs") {
		@Override
		public AbstractRexsFileWriter createNewFileWriter(Path pathToRexsOutputFile) {
			return new RexsXmlFileWriter(pathToRexsOutputFile);
		}

		@Override
		public AbstractRexsFileReader createNewFileReader(Path pathToRexsInputFile) {
			return new RexsXmlFileReader(pathToRexsInputFile);
		}
	},

	ZIP("rexsz") {
		@Override
		public AbstractRexsFileReader createNewFileReader(Path pathToRexsInputFile) {
			return new RexsZipFileReader(pathToRexsInputFile);
		}
	};

	private final String ending;

	public AbstractRexsFileWriter createNewFileWriter(Path pathToRexsOutputFile) {
		throw new RuntimeException("writer not implemented for format");
	}

	public AbstractRexsFileReader createNewFileReader(Path pathToRexsInputFile) {
		throw new RuntimeException("reader not implemented for format");
	}

	public static RexsIoFormat findFormatByFilename(String filename) {
		if (filename == null)
			return null;

		for (RexsIoFormat format : values()) {
			if (filename.toLowerCase().endsWith(format.getEnding()))
				return format;
		}

		return null;
	}
}
