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
package info.rexs.validation;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import info.rexs.io.RexsFileReader;
import info.rexs.io.RexsIoFormat;
import info.rexs.io.zip.RexsZipFileReader;
import info.rexs.model.RexsComponent;
import info.rexs.model.RexsModel;
import info.rexs.schema.RexsSchema;
import lombok.Getter;

/**
 * This implementation of {@link IRexsFileValidator} validates the basic structure of a REXS file.
 * <p>
 * Official REXS versions are not taken into account.
 *
 * @author FVA GmbH
 */
public class DefaultRexsFileValidator implements IRexsFileValidator {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RexsValidationResult validate(Path pathToRexsFile) {

		RexsValidationResult validationResult = validateFilesize(pathToRexsFile);
		if (!validationResult.isValid())
			return validationResult;

		if (pathToRexsFile.getFileName().toString().toLowerCase().endsWith("." + RexsIoFormat.ZIP.getEnding())) {
			return validateRexszFile(pathToRexsFile);
		}

		validationResult = validateSchema(pathToRexsFile);
		if (!validationResult.isValid())
			return validationResult;

		return validateContent(pathToRexsFile);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RexsValidationResult validate(File rexsFile) {
		return validate(rexsFile.toPath());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RexsValidationResult validate(String pathToRexsFile) {
		return validate(Paths.get(pathToRexsFile));
	}

	private RexsValidationResult validateFilesize(Path pathToRexsFile) {

		RexsValidationResult validationResult = new RexsValidationResult();

		try {
			if (Files.size(pathToRexsFile) < 1)
				validationResult.addError(RexsValidationResultMessageKey.EMPTY_FILE);

		} catch (IOException ex) {
			validationResult.addError(RexsValidationResultMessageKey.INTERNAL_ERROR);
		}

		return validationResult;
	}

	private RexsValidationResult validateRexszFile(Path pathToRexszFile) {

		Path pathToRexsFile = null;
		try {
			RexsZipFileReader reader = new RexsZipFileReader(pathToRexszFile);
			pathToRexsFile = reader.extractRexsFileFromZip();
			return validate(pathToRexsFile);

		} catch (IOException ex) {
			RexsValidationResult validationResult = new RexsValidationResult();
			validationResult.addError(RexsValidationResultMessageKey.INTERNAL_ERROR);
			return validationResult;

		} finally {
			try {
				Files.deleteIfExists(pathToRexsFile);
			} catch (IOException ex) {
				// Nothing to do
			}
		}
	}

	private RexsValidationResult validateSchema(Path pathToRexsFile) {

		RexsValidationResult validationResult = new RexsValidationResult();
		SchemaValidationErrorHandler errorHandler = new SchemaValidationErrorHandler();

		try (InputStream schemaInput = RexsSchema.FILE.openInputStream()) {
			SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = schemaFactory.newSchema(new StreamSource(schemaInput));
			Validator validator = schema.newValidator();
			validator.setErrorHandler(errorHandler);
			validator.validate(new StreamSource(pathToRexsFile.toFile()));

		} catch (IOException | SAXException ex) {
			validationResult.addError(RexsValidationResultMessageKey.INTERNAL_ERROR);
			return validationResult;
		}

		List<String> errorMessages = errorHandler.getErrorMessages();
		if (!errorMessages.isEmpty())
			validationResult.addError(RexsValidationResultMessageKey.XML_SCHEMA, errorMessages);

		List<String> warningMessages = errorHandler.getWarningMessages();
		if (!warningMessages.isEmpty())
			validationResult.addWarning(RexsValidationResultMessageKey.XML_SCHEMA, warningMessages);

		return validationResult;
	}

	@Getter
	private class SchemaValidationErrorHandler implements ErrorHandler {

		private List<String> errorMessages = new ArrayList<>();
		private List<String> warningMessages = new ArrayList<>();

		@Override
		public void error(SAXParseException ex) throws SAXException
		{
			errorMessages.add(createExceptionMessage(ex));
		}

		@Override
		public void fatalError(SAXParseException ex) throws SAXException
		{
			errorMessages.add(createExceptionMessage(ex));
		}

		@Override
		public void warning(SAXParseException ex) throws SAXException
		{
			warningMessages.add(createExceptionMessage(ex));
		}

		private String createExceptionMessage(SAXParseException ex)
		{
			return String.format("%s (line number: %s, column number: %s)", ex.getMessage(), ex.getLineNumber(), ex.getColumnNumber());
		}
	}

	private RexsValidationResult validateContent(Path pathToRexsFile) {

		RexsValidationResult validationResult = new RexsValidationResult();

		RexsFileReader reader = new RexsFileReader(pathToRexsFile);
		RexsModel rexsModel = null;

		try {
			rexsModel = reader.read();

		} catch (Exception ex) {
			validationResult.addError(RexsValidationResultMessageKey.INTERNAL_ERROR);
			return validationResult;
		}

		validationResult.add(validateVersion(rexsModel.getOriginVersion()));

		if (rexsModel.getComponents() == null
				|| rexsModel.getComponents().isEmpty()) {
			validationResult.addError(RexsValidationResultMessageKey.MODEL_COMPONENTS_EMPTY);
			return validationResult;
		}

		IRexsComponentValidator componentValidator = createComponentValidator();
		for (RexsComponent rexsComponent : rexsModel.getComponents()) {
			validationResult.add(componentValidator.validate(rexsComponent));
		}

		return validationResult;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RexsValidationResult validateVersion(String version) {

		RexsValidationResult validationResult = new RexsValidationResult();

		if (version == null
				|| version.isEmpty())
			validationResult.addError(RexsValidationResultMessageKey.MODEL_VERSION_EMPTY);

		return validationResult;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IRexsComponentValidator createComponentValidator() {
		return new DefaultRexsComponentValidator();
	}
}
