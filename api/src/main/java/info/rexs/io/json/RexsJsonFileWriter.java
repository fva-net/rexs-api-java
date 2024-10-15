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
package info.rexs.io.json;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import info.rexs.schema.constants.RexsUnitId;
import info.rexs.schema.constants.RexsVersion;
import info.rexs.schema.constants.standard.RexsStandardUnitIds;
import info.rexs.schema.constants.standard.RexsStandardVersions;
import info.rexs.io.AbstractRexsFileWriter;
import info.rexs.io.RexsIoException;
import info.rexs.io.json.model.Accumulation;
import info.rexs.io.json.model.Component;
import info.rexs.io.json.model.JSONModel;
import info.rexs.io.json.model.LoadCase;
import info.rexs.io.json.model.LoadSpectrum;
import info.rexs.io.json.model.Model;
import info.rexs.io.json.model.attributes.ArrayOfIntegerArraysAttribute;
import info.rexs.io.json.model.attributes.Attribute;
import info.rexs.io.json.model.attributes.BooleanArrayAttribute;
import info.rexs.io.json.model.attributes.BooleanAttribute;
import info.rexs.io.json.model.attributes.BooleanMatrixAttribute;
import info.rexs.io.json.model.attributes.EnumArrayAttribute;
import info.rexs.io.json.model.attributes.EnumAttribute;
import info.rexs.io.json.model.attributes.FileReferenceAttribute;
import info.rexs.io.json.model.attributes.FloatingPointArrayAttribute;
import info.rexs.io.json.model.attributes.FloatingPointAttribute;
import info.rexs.io.json.model.attributes.FloatingPointMatrixAttribute;
import info.rexs.io.json.model.attributes.DateTimeAttribute;
import info.rexs.io.json.model.attributes.IntegerArrayAttribute;
import info.rexs.io.json.model.attributes.IntegerAttribute;
import info.rexs.io.json.model.attributes.IntegerMatrixAttribute;
import info.rexs.io.json.model.attributes.ReferenceComponentAttribute;
import info.rexs.io.json.model.attributes.StringArrayAttribute;
import info.rexs.io.json.model.attributes.StringAttribute;
import info.rexs.io.json.model.attributes.StringMatrixAttribute;
import info.rexs.model.RexsModel;
import info.rexs.model.transformer.RexsModelJsonTransformer;

/**
 * The {@link RexsJsonFileWriter} writes a REXS base model {@link RexsModel} and REXS raw model {@link Model} to a xml file.
 *
 * @author FVA GmbH
 */
public class RexsJsonFileWriter extends AbstractRexsFileWriter {

	/**
	 * Constructs a new {@link RexsJsonFileWriter} for the given {@link Path} to the REXS output file.
	 *
	 * @param pathToRexsOutputFile
	 * 				The {@link Path} to the REXS output file.
	 */
	public RexsJsonFileWriter(Path pathToRexsOutputFile) {
		super(pathToRexsOutputFile);
	}

	/**
	 * Constructs a new {@link RexsJsonFileWriter} for the given REXS output {@link File}.
	 *
	 * @param rexsOutputFile
	 * 				The REXS output {@link File}.
	 */
	public RexsJsonFileWriter(File rexsOutputFile) {
		super(rexsOutputFile);
	}

	/**
	 * Constructs a new {@link RexsJsonFileWriter} for the given path to the REXS output file as {@link String}.
	 *
	 * @param rexsOutputFilePath
	 * 				The path to the REXS output file as {@link String}.
	 */
	public RexsJsonFileWriter(String rexsOutputFilePath) {
		super(rexsOutputFilePath);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void write(RexsModel model) throws RexsIoException {
		validateOutputFile();
		String jsonString = "";
		try {
			RexsModelJsonTransformer transformer = new RexsModelJsonTransformer();
			JSONModel rawModel = transformer.transform(model);
			convertDegreeUnits(rawModel.getModel());

			ObjectMapper mapper = new ObjectMapper();
			//mapper.disable(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES);
			mapper.registerSubtypes(
					DateTimeAttribute.class,
					BooleanAttribute.class,
					EnumAttribute.class,
					FloatingPointAttribute.class,
					IntegerAttribute.class, StringAttribute.class,
					BooleanArrayAttribute.class,
					EnumArrayAttribute.class,
					FloatingPointArrayAttribute.class,
					IntegerArrayAttribute.class,
					StringArrayAttribute.class,
					BooleanMatrixAttribute.class,
					FloatingPointMatrixAttribute.class,
					IntegerMatrixAttribute.class,
					StringMatrixAttribute.class,
					ArrayOfIntegerArraysAttribute.class,
					FileReferenceAttribute.class,
					ReferenceComponentAttribute.class
			);



			jsonString = mapper
				.writerWithDefaultPrettyPrinter()
				.writeValueAsString(rawModel);
		} catch (Exception ex) {
			throw new RexsIoException("error on writing rexs model to json file", ex);
		}
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(this.pathToRexsOutputFile.toString(), StandardCharsets.UTF_8))){
			writer.write("\ufeff"); // add UTF8 BOM (otherwise encoding is only UTF8)
			writer.write(jsonString);
			writer.flush();
		}catch(IOException ex) {
			throw new RexsIoException("error on writing rexs model to json file", ex);
		}
	}

	private void convertDegreeUnits(Model model) {
		if (model.getComponents() == null || model.getComponents().isEmpty())
			return;

		String versionName = model.getVersion();
		RexsVersion version = RexsVersion.findByName(versionName);
		if (version == null)
			return;

		RexsUnitId searchUnit = version.isLess(RexsStandardVersions.V1_4) ? RexsStandardUnitIds.deg : RexsStandardUnitIds.degree;
		RexsUnitId replaceUnit = version.isLess(RexsStandardVersions.V1_4) ? RexsStandardUnitIds.degree : RexsStandardUnitIds.deg;

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
				if (attribute!=null && attribute.getUnit() != null && attribute.getUnit().equals(searchUnit.getId()))
					attribute.setUnit(replaceUnit.getId());
			}
		}
	}
}
