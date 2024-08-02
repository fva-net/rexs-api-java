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
package info.rexs.io.json;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;

import info.rexs.db.constants.standard.RexsStandardUnitIds;
import info.rexs.io.AbstractRexsFileReader;
import info.rexs.io.Resource;
import info.rexs.io.RexsIoException;
import info.rexs.io.json.model.Accumulation;
import info.rexs.io.json.model.Component;
import info.rexs.io.json.model.JSONModel;
import info.rexs.io.json.model.LoadCase;
import info.rexs.io.json.model.LoadSpectrum;
import info.rexs.io.json.model.Model;
import info.rexs.io.json.model.attributes.Attribute;
import info.rexs.model.RexsModel;
import info.rexs.model.transformer.RexsModelJsonTransformer;

public class RexsJsonFileReader extends AbstractRexsFileReader {

	/**
	 * Constructs a new {@link RexsJsonFileReader} for the given {@link Resource} to the REXS input file.
	 *
	 * @param rexsInputFileResource
	 * 				The {@link Resource} to the REXS input file.
	 */
	public RexsJsonFileReader(Resource rexsInputFileResource) {
		super(rexsInputFileResource);
	}

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

	private JSONModel readRawModel() throws RexsIoException {
		validateInputFile();
		try (InputStream input = rexsInputFileResource.openInputStream()) {
			BufferedReader reader = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));
			String text = reader.lines()
					.collect(Collectors.joining(System.lineSeparator()));
			ObjectMapper mapper = new ObjectMapper();
			// remove BOM if provided
			text = text.replace("\uFEFF", "");

			return mapper.readerFor(JSONModel.class).readValue(text);
		} catch (Exception ex) {
			throw new RexsIoException("error reading rexs model from json file", ex);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RexsModel read() throws RexsIoException {
		validateInputFile();
		try {
			JSONModel jsonModel = readRawModel();
			convertDegreeUnits(jsonModel.getModel());
			return new RexsModelJsonTransformer().transform(jsonModel);
		} catch (Exception ex) {
			throw new RexsIoException("error reading rexs model from json file", ex);
		}
	}

	private void convertDegreeUnits(Model model) {
		if (model.getComponents() == null || model.getComponents().isEmpty())
			return;

		List<Component> allComponents = new ArrayList<>();
		allComponents.addAll(model.getComponents());
		LoadSpectrum spectrum = model.getLoadSpectrum();
		if (spectrum!=null) {
			for (LoadCase loadCase : spectrum.getLoadCases())
				allComponents.addAll(loadCase.getComponents());
			Accumulation accumulation = spectrum.getAccumulation();
			if (accumulation!=null)
				allComponents.addAll(accumulation.getComponents());
		}
		for (Component component : allComponents) {
			for (Attribute attribute : component.getAttributes()) {
				if (attribute.getUnit() != null && attribute.getUnit().equals(RexsStandardUnitIds.degree.getId())) {
					attribute.setUnit(RexsStandardUnitIds.deg.getId());
				}
			}
		}
	}
}
