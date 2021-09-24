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

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import info.rexs.db.constants.RexsUnitId;
import info.rexs.db.constants.RexsVersion;
import info.rexs.model.RexsModel;
import info.rexs.model.jaxb.Attribute;
import info.rexs.model.jaxb.Component;
import info.rexs.model.jaxb.Model;

/**
 * The {@link RexsFileWriter} writes a REXS base model {@link RexsModel} and REXS raw model {@link Model} to a file.
 *
 * @author FVA GmbH
 */
public class RexsFileWriter {

	/** The {@link Path} to the REXS output file. */
	private final Path pathToRexsOutputFile;

	/**
	 * Constructs a new {@link RexsFileWriter} for the given {@link Path} to the REXS output file.
	 *
	 * @param pathToRexsOutputFile
	 * 				The {@link Path} to the REXS output file.
	 */
	public RexsFileWriter(Path pathToRexsOutputFile) {
		this.pathToRexsOutputFile = pathToRexsOutputFile;
	}

	/**
	 * Constructs a new {@link RexsFileWriter} for the given REXS output {@link File}.
	 *
	 * @param rexsOutputFile
	 * 				The REXS output {@link File}.
	 */
	public RexsFileWriter(File rexsOutputFile) {
		this(rexsOutputFile.toPath());
	}

	/**
	 * Constructs a new {@link RexsFileWriter} for the given path to the REXS output file as {@link String}.
	 *
	 * @param rexsOutputFilePath
	 * 				The path to the REXS output file as {@link String}.
	 */
	public RexsFileWriter(String rexsOutputFilePath) {
		this(Paths.get(rexsOutputFilePath));
	}

	/**
	 * Writes the REXS raw model {@link Model} to the output file.
	 *
	 * @param rawModel
	 * 				The REXS base model {@link Model}.
	 *
	 * @throws IOException
	 * 				If the REXS output file is not writable.
	 * @throws JAXBException
	 * 				If any unexpected problem occurs during the marshalling of the REXS output file.
	 */
	public void writeRawModel(Model rawModel) throws IOException, JAXBException {
		if(!Files.exists(pathToRexsOutputFile))
			Files.createFile(pathToRexsOutputFile);

		if(!Files.isWritable(pathToRexsOutputFile))
			throw new IOException("file " + pathToRexsOutputFile + " is not writable");

		JAXBContext context = JAXBContext.newInstance(Model.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.marshal(convertDegreeUnits(rawModel), pathToRexsOutputFile.toFile());
	}

	/**
	 * Writes the REXS base model {@link RexsModel} to the output file.
	 *
	 * @param model
	 * 				The REXS base model {@link RexsModel}.
	 *
	 * @throws IOException
	 * 				If the REXS output file is not writable.
	 * @throws JAXBException
	 * 				If any unexpected problem occurs during the marshalling of the REXS output file.
	 */
	public void write(RexsModel model) throws IOException, JAXBException {
		writeRawModel(model.getRawModel());
	}

	private Model convertDegreeUnits(Model model) {
		if (model.getComponents() == null || model.getComponents().getComponent().isEmpty())
			return model;

		String versionName = model.getVersion();
		RexsVersion version = RexsVersion.findByName(versionName);
		if (version == null)
			return model;

		RexsUnitId searchUnit = version.isLess(RexsVersion.V1_4) ? RexsUnitId.deg : RexsUnitId.degree;
		RexsUnitId replaceUnit = version.isLess(RexsVersion.V1_4) ? RexsUnitId.degree : RexsUnitId.deg;

		for (Component component : model.getComponents().getComponent()) {
			for (Attribute attribute : component.getAttribute()) {
				if (attribute.getUnit() != null && attribute.getUnit().equals(searchUnit.getId()))
					attribute.setUnit(replaceUnit.getId());
			}
		}

		return model;
	}
}
