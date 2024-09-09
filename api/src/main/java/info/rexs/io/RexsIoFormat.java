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
package info.rexs.io;

import java.nio.file.Path;

import info.rexs.io.json.RexsJsonFileReader;
import info.rexs.io.json.RexsJsonFileWriter;
import info.rexs.io.xml.RexsXmlFileReader;
import info.rexs.io.xml.RexsXmlFileWriter;
import info.rexs.io.zip.RexsZipFileReader;
import info.rexs.io.zip.RexsZipFileWriter;

public enum RexsIoFormat {

	JSON("rexsj", "rexs.json", "json") {
		@Override
		public AbstractRexsFileWriter createNewFileWriter(Path pathToRexsOutputFile) {
			return new RexsJsonFileWriter(pathToRexsOutputFile);
		}

		@Override
		public AbstractRexsFileReader createNewFileReader(Resource rexsInputFileResource) {
			return new RexsJsonFileReader(rexsInputFileResource);
		}
	},

	XML("rexs", "xml") {
		@Override
		public AbstractRexsFileWriter createNewFileWriter(Path pathToRexsOutputFile) {
			return new RexsXmlFileWriter(pathToRexsOutputFile);
		}

		@Override
		public AbstractRexsFileReader createNewFileReader(Resource rexsInputFileResource) {
			return new RexsXmlFileReader(rexsInputFileResource);
		}
	},

	ZIP("rexsz", "zip") {
		@Override
		public AbstractRexsFileWriter createNewFileWriter(Path pathToRexsOutputFile) {
			return new RexsZipFileWriter(pathToRexsOutputFile);
		}

		@Override
		public AbstractRexsFileReader createNewFileReader(Resource rexsInputFileResource) {
			return new RexsZipFileReader(rexsInputFileResource);
		}
	};

	private RexsIoFormat(String... endings) {
		this.endings = endings;
	}

	private final String[] endings;

	public String[] getEndings() {
		return endings;
	}

	public boolean hasEnding(String filename) {
		if (filename == null)
			return false;

		for (String ending : endings) {
			if (filename.toLowerCase().endsWith(ending))
				return true;
		}

		return false;
	}

	public AbstractRexsFileWriter createNewFileWriter(Path pathToRexsOutputFile) {
		throw new RuntimeException("writer not implemented for format");
	}

	public AbstractRexsFileReader createNewFileReader(Resource rexsInputFileResource) {
		throw new RuntimeException("reader not implemented for format");
	}

	public static RexsIoFormat findFormatByFilename(String filename) {
		if (filename == null)
			return null;

		for (RexsIoFormat format : values()) {
			if (format.hasEnding(filename))
				return format;
		}

		return null;
	}
}
