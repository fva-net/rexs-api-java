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

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

import com.fasterxml.jackson.databind.ObjectMapper;

import info.rexs.io.AbstractRexsFileWriter;
import info.rexs.io.RexsIoException;
import info.rexs.io.json.jsonmodel.JSONModel;
import info.rexs.io.json.jsonmodel.Model;
import info.rexs.io.json.jsonmodel.attributes.ArrayOfIntegerArraysAttribute;
import info.rexs.io.json.jsonmodel.attributes.BooleanArrayAttribute;
import info.rexs.io.json.jsonmodel.attributes.BooleanAttribute;
import info.rexs.io.json.jsonmodel.attributes.BooleanMatrixAttribute;
import info.rexs.io.json.jsonmodel.attributes.EnumArrayAttribute;
import info.rexs.io.json.jsonmodel.attributes.EnumAttribute;
import info.rexs.io.json.jsonmodel.attributes.FileReferenceAttribute;
import info.rexs.io.json.jsonmodel.attributes.FloatingPointArrayAttribute;
import info.rexs.io.json.jsonmodel.attributes.FloatingPointArrayCodedAttribute;
import info.rexs.io.json.jsonmodel.attributes.FloatingPointAttribute;
import info.rexs.io.json.jsonmodel.attributes.FloatingPointMatrixAttribute;
import info.rexs.io.json.jsonmodel.attributes.FloatingPointMatrixCodedAttribute;
import info.rexs.io.json.jsonmodel.attributes.IntegerArrayAttribute;
import info.rexs.io.json.jsonmodel.attributes.IntegerAttribute;
import info.rexs.io.json.jsonmodel.attributes.IntegerMatrixAttribute;
import info.rexs.io.json.jsonmodel.attributes.ReferenceComponentAttribute;
import info.rexs.io.json.jsonmodel.attributes.StringArrayAttribute;
import info.rexs.io.json.jsonmodel.attributes.StringAttribute;
import info.rexs.io.json.jsonmodel.attributes.StringMatrixAttribute;
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
		RexsModelJsonTransformer transformer = new RexsModelJsonTransformer();
		JSONModel rawModel = transformer.transform(model);
		writeRawModel(rawModel);
	}

	public void writeRawModel(JSONModel model) throws RexsIoException {
		validateOutputFile();
		String jsonString = "";
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.registerSubtypes(
			BooleanAttribute.class,
			EnumAttribute.class,
			FloatingPointAttribute.class,
			IntegerAttribute.class,
			StringAttribute.class,

			BooleanArrayAttribute.class,
			EnumArrayAttribute.class,
			FloatingPointArrayAttribute.class,
			IntegerArrayAttribute.class,
			StringArrayAttribute.class,
			FloatingPointArrayCodedAttribute.class,

			BooleanMatrixAttribute.class,
			FloatingPointMatrixAttribute.class,
			IntegerMatrixAttribute.class,
			StringMatrixAttribute.class,
			FloatingPointMatrixCodedAttribute.class,

			ArrayOfIntegerArraysAttribute.class,
			FileReferenceAttribute.class,
			ReferenceComponentAttribute.class);

			jsonString = mapper
				.writerWithDefaultPrettyPrinter()
				.writeValueAsString(model);
		} catch (Exception ex) {
			throw new RexsIoException("error on writing rexs model to json file", ex);
		}
		try(BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.pathToRexsOutputFile.toString(),false), StandardCharsets.UTF_8))){
			writer.write(jsonString);
			writer.flush();
		}catch(IOException e){
			e.printStackTrace();
			throw new RexsIoException("error on writing rexs model to json file", e);
		}
	}
}
