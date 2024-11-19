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
package info.rexs.validation;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import info.rexs.io.FileResource;
import info.rexs.io.Resource;
import info.rexs.io.RexsFileReader;
import info.rexs.io.RexsIoFormat;
import info.rexs.io.zip.RexsZipFileReader;
import info.rexs.model.RexsModel;
import info.rexs.xsd.RexsXsd;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

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
	public RexsValidationResult validate(Resource rexsFileResource) {

		RexsValidationResult validationResult = validateFilesize(rexsFileResource);
		if (!validationResult.isValid())
			return validationResult;

		if (RexsIoFormat.ZIP.hasEnding(rexsFileResource.getFilename())) {
			return validateRexszFile(rexsFileResource);
		}

		if (RexsIoFormat.XML.hasEnding(rexsFileResource.getFilename())) {
			validationResult = validateSchema(rexsFileResource);
			if (!validationResult.isValid())
				return validationResult;
		}

		return validateContent(rexsFileResource);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RexsValidationResult validate(Path pathToRexsFile) {
		return validate(new FileResource(pathToRexsFile));
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

	private RexsValidationResult validateFilesize(Resource rexsFileResource) {

		RexsValidationResult validationResult = new RexsValidationResult();

		try {
			if (rexsFileResource.getContentLength() < 1)
				validationResult.addError(RexsValidationResultMessageKey.EMPTY_FILE);

		} catch (IOException ex) {
			validationResult.addError(RexsValidationResultMessageKey.INTERNAL_ERROR);
		}

		return validationResult;
	}

	private RexsValidationResult validateRexszFile(Resource rexszFileResource) {

		Resource rexsFileInZipResource = null;
		try {
			RexsZipFileReader reader = new RexsZipFileReader(rexszFileResource);
			rexsFileInZipResource = reader.extractRexsFileFromZip();
			return validate(rexsFileInZipResource);

		} catch (IOException ex) {
			RexsValidationResult validationResult = new RexsValidationResult();
			validationResult.addError(RexsValidationResultMessageKey.INTERNAL_ERROR);
			return validationResult;
		}
	}

	private RexsValidationResult validateSchema(Resource rexsFileResource) {

		RexsValidationResult validationResult = new RexsValidationResult();
		SchemaValidationErrorHandler errorHandler = new SchemaValidationErrorHandler();

		try (
			InputStream schemaInput = RexsXsd.FILE.openInputStream();
			InputStream rexsFileInput = rexsFileResource.openInputStream();) {

			SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = schemaFactory.newSchema(new StreamSource(schemaInput));
			Validator validator = schema.newValidator();
			validator.setErrorHandler(errorHandler);
			validator.validate(new StreamSource(rexsFileInput));

		} catch (IOException | SAXException ex) {
			validationResult.addError(RexsValidationResultMessageKey.INTERNAL_ERROR);
			return validationResult;
		}

		List<String> errorMessages = errorHandler.getErrorMessages();
		for (String error : errorMessages)
			validationResult.addError(RexsValidationResultMessageKey.XML_SCHEMA, error);

		List<String> warningMessages = errorHandler.getWarningMessages();
		for (String warning : warningMessages)
			validationResult.addWarning(RexsValidationResultMessageKey.XML_SCHEMA, warning);

		return validationResult;
	}

	private class SchemaValidationErrorHandler implements ErrorHandler {

		private List<String> errorMessages = new ArrayList<>();
		private List<String> warningMessages = new ArrayList<>();

		@Override
		public void error(SAXParseException ex) {
			errorMessages.add(createExceptionMessage(ex));
		}

		public List<String> getWarningMessages() {
			return this.warningMessages;
		}

		public List<String> getErrorMessages() {
			return this.errorMessages;
		}

		@Override
		public void fatalError(SAXParseException ex) {
			errorMessages.add(createExceptionMessage(ex));
		}

		@Override
		public void warning(SAXParseException ex) {
			warningMessages.add(createExceptionMessage(ex));
		}

		private String createExceptionMessage(SAXParseException ex)
		{
			return String.format("%s (line number: %s, column number: %s)", ex.getMessage(), ex.getLineNumber(), ex.getColumnNumber());
		}
	}

	private RexsValidationResult validateContent(Resource rexsFileResource) {

		RexsValidationResult validationResult = new RexsValidationResult();

		RexsFileReader reader = new RexsFileReader(rexsFileResource);
		RexsModel rexsModel = null;

		try {
			rexsModel = reader.read();

		} catch (Exception ex) {
			validationResult.addError(RexsValidationResultMessageKey.INTERNAL_ERROR);
			return validationResult;
		}

		IRexsModelValidator modelValidator = createModelValidator();
		validationResult.add(modelValidator.validate(rexsModel));

		return validationResult;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IRexsModelValidator createModelValidator() {
		return new DefaultRexsModelValidator();
	}
}
