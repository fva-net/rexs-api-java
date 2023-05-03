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
import java.io.InputStream;
import java.nio.file.Path;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import javax.xml.stream.StreamFilter;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;

import info.rexs.db.constants.RexsUnitId;
import info.rexs.io.AbstractRexsFileReader;
import info.rexs.io.Resource;
import info.rexs.io.RexsIoException;
import info.rexs.model.RexsModel;
import info.rexs.model.jaxb.Attribute;
import info.rexs.model.jaxb.Component;
import info.rexs.model.jaxb.Model;
import info.rexs.model.transformer.RexsModelXmlTransformer;

/**
 * The {@link RexsXmlFileReader} reads a REXS file into the raw model {@link Model} and the base model {@link RexsModel}.
 *
 * @author FVA GmbH
 */
public class RexsXmlFileReader extends AbstractRexsFileReader {

	/**
	 * Constructs a new {@link RexsXmlFileReader} for the given {@link Resource} to the REXS input file.
	 *
	 * @param rexsInputFileResource
	 * 				The {@link Resource} to the REXS input file.
	 */
	public RexsXmlFileReader(Resource rexsInputFileResource) {
		super(rexsInputFileResource);
	}

	/**
	 * Constructs a new {@link RexsXmlFileReader} for the given {@link Path} to the REXS input file.
	 *
	 * @param pathToRexsInputFile
	 * 				The {@link Path} to the REXS input file.
	 */
	public RexsXmlFileReader(Path pathToRexsInputFile) {
		super(pathToRexsInputFile);
	}

	/**
	 * Constructs a new {@link RexsXmlFileReader} for the given REXS input {@link File}.
	 *
	 * @param rexsInputFile
	 * 				The REXS input {@link File}.
	 */
	public RexsXmlFileReader(File rexsInputFile) {
		super(rexsInputFile);
	}

	/**
	 * Constructs a new {@link RexsXmlFileReader} for the given path to the REXS input file as {@link String}.
	 *
	 * @param rexsInputFilePath
	 * 				The path to the REXS input file as {@link String}.
	 */
	public RexsXmlFileReader(String rexsInputFilePath) {
		super(rexsInputFilePath);
	}

	public Model readRawModel() throws RexsIoException {
		validateInputFile();

		try (InputStream input = rexsInputFileResource.openInputStream()) {
			JAXBContext context = JAXBContext.newInstance(Model.class);

			XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();
			XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(new StreamSource(input));
			xmlStreamReader = xmlInputFactory.createFilteredReader(xmlStreamReader, new StreamFilter() {

				@Override
				public boolean accept(XMLStreamReader reader) {
					if(reader.getEventType() == XMLStreamReader.CHARACTERS) {
						return reader.getText().trim().length() > 0;
					}
					return true;
				}
			});

			Unmarshaller unmarshaller = context.createUnmarshaller();
			Model rawModel = (Model)unmarshaller.unmarshal(xmlStreamReader);
			return convertDegreeUnits(rawModel);

		} catch (Exception ex) {
			throw new RexsIoException("error reading rexs model from xml file", ex);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RexsModel read() throws RexsIoException {
		try {
			Model rawModel = readRawModel();
			RexsModelXmlTransformer transformer = new RexsModelXmlTransformer();
			return transformer.transform(rawModel);

		} catch (Exception ex) {
			throw new RexsIoException("error on reading rexs model from xml file", ex);
		}
	}

	private Model convertDegreeUnits(Model model) {
		if (model.getComponents() == null || model.getComponents().getComponent().isEmpty())
			return model;

		for (Component component : model.getComponents().getComponent()) {
			for (Attribute attribute : component.getAttribute()) {
				if (attribute.getUnit() != null && attribute.getUnit().equals(RexsUnitId.degree.getId()))
					attribute.setUnit(RexsUnitId.deg.getId());
			}
		}

		return model;
	}
}
