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
package info.rexs.io.xml;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import info.rexs.db.constants.RexsUnitId;
import info.rexs.db.constants.RexsVersion;
import info.rexs.io.AbstractRexsFileWriter;
import info.rexs.io.RexsIoException;
import info.rexs.model.RexsModel;
import info.rexs.model.jaxb.Attribute;
import info.rexs.model.jaxb.Component;
import info.rexs.model.jaxb.Model;
import info.rexs.model.transformer.RexsModelXmlTransformer;

/**
 * The {@link RexsXmlFileWriter} writes a REXS base model {@link RexsModel} and REXS raw model {@link Model} to a xml file.
 *
 * @author FVA GmbH
 */
public class RexsXmlFileWriter extends AbstractRexsFileWriter {

	/**
	 * Constructs a new {@link RexsXmlFileWriter} for the given {@link Path} to the REXS output file.
	 *
	 * @param pathToRexsOutputFile
	 * 				The {@link Path} to the REXS output file.
	 */
	public RexsXmlFileWriter(Path pathToRexsOutputFile) {
		super(pathToRexsOutputFile);
	}

	/**
	 * Constructs a new {@link RexsXmlFileWriter} for the given REXS output {@link File}.
	 *
	 * @param rexsOutputFile
	 * 				The REXS output {@link File}.
	 */
	public RexsXmlFileWriter(File rexsOutputFile) {
		super(rexsOutputFile);
	}

	/**
	 * Constructs a new {@link RexsXmlFileWriter} for the given path to the REXS output file as {@link String}.
	 *
	 * @param rexsOutputFilePath
	 * 				The path to the REXS output file as {@link String}.
	 */
	public RexsXmlFileWriter(String rexsOutputFilePath) {
		super(rexsOutputFilePath);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void write(RexsModel model) throws RexsIoException {
		validateOutputFile();

		try {
			RexsModelXmlTransformer transformer = new RexsModelXmlTransformer();
			Model rawModel = transformer.transform(model);

			writeRawModel(rawModel, pathToRexsOutputFile);

		} catch (Exception ex) {
			throw new RexsIoException("error on writing rexs model to xml file", ex);
		}
	}

	public void writeRawModel(Model rawModel) throws RexsIoException {
		validateOutputFile();
		try {
			writeRawModel(rawModel, pathToRexsOutputFile);
		} catch (Exception ex) {
			throw new RexsIoException("error writing rexs model to xml file", ex);
		}
	}

	private void writeRawModel(Model rawModel, Path pathToFile) throws IOException, JAXBException {
		try (OutputStream output = Files.newOutputStream(pathToFile, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {
			JAXBContext context = JAXBContext.newInstance(Model.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			marshaller.marshal(convertDegreeUnits(rawModel), output);
		}
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
