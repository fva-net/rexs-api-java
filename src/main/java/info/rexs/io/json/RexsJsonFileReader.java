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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;

import info.rexs.io.AbstractRexsFileReader;
import info.rexs.io.RexsIoException;
import info.rexs.io.json.jsonmodel.JSONModel;
import info.rexs.model.RexsModel;
import info.rexs.model.transformer.RexsModelJsonTransformer;

public class RexsJsonFileReader extends AbstractRexsFileReader {

	/**
	 * Constructs a new {@link RexsJsonFileReader} for the given {@link Path} to the REXS input file.
	 *
	 * @param pathToRexsInputFile
	 * 				The {@link Path} to the REXS input file.
	 */
	public RexsJsonFileReader(Path pathToRexsInputFile) {
		super(pathToRexsInputFile);
	}

	/**
	 * Constructs a new {@link RexsJsonFileReader} for the given REXS input {@link File}.
	 *
	 * @param rexsInputFile
	 * 				The REXS input {@link File}.
	 */
	public RexsJsonFileReader(File rexsInputFile) {
		super(rexsInputFile);
	}

	/**
	 * Constructs a new {@link RexsJsonFileReader} for the given path to the REXS input file as {@link String}.
	 *
	 * @param rexsInputFilePath
	 * 				The path to the REXS input file as {@link String}.
	 */
	public RexsJsonFileReader(String rexsInputFilePath) {
		super(rexsInputFilePath);
	}

	public JSONModel readRawModel() throws RexsIoException {
		validateInputFile();
		try (FileReader input = new FileReader(pathToRexsInputFile.toFile())) {
			BufferedReader reader = new BufferedReader(input);
			String text = reader.lines()
								.collect(Collectors.joining(System.lineSeparator()));
			ObjectMapper mapper = new ObjectMapper();

			return mapper.readerFor(JSONModel.class).readValue(text);
		} catch (Exception ex) {
			throw new RexsIoException("error reading rexs model from xml file", ex);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RexsModel read() throws RexsIoException {
		validateInputFile();
		try  {
			JSONModel jsonModel = readRawModel();
			return new RexsModelJsonTransformer().transform(jsonModel);
		} catch (Exception ex) {
			throw new RexsIoException("error reading rexs model from json file", ex);
		}
	}
}