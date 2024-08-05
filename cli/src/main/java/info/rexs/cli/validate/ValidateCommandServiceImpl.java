package info.rexs.cli.validate;

import java.nio.file.Files;
import java.util.List;

import org.springframework.stereotype.Service;

import com.beust.jcommander.internal.Console;

import info.rexs.io.RexsFileReader;
import info.rexs.model.RexsModel;
import info.rexs.validation.IRexsModelValidator;
import info.rexs.validation.RexsValidationResult;
import info.rexs.validation.RexsValidationResultMessage;

@Service
public class ValidateCommandServiceImpl {

	public void validate(Console console, ValidateOptions options) {

		/*
		 * Read rexs model from file
		 */
		RexsModel rexsModel = null;

		try {
			if (Files.size(options.getFile()) < 1) {
				console.println(String.format("The REXS file '%s' is empty.", options.getFile()));
				return;
			}

			RexsFileReader rexsFileReader = new RexsFileReader(options.getFile());
			rexsModel = rexsFileReader.read();

		} catch (Exception ex) {
			console.println(String.format("The REXS file '%s' could not be read (%s).", options.getFile(), ex.getMessage()));
			return;
		}

		/*
		 * Validate the rexs model
		 */
		IRexsModelValidator validator = options.getMode().createModelValidator();
		RexsValidationResult result = validator.validate(rexsModel);

		if (result.isValid())
			console.println("The REXS file is VALID.");
		else
			console.println("The REXS file is NOT VALID.");

		List<RexsValidationResultMessage> errorMessages = result.getErrors();
		if (errorMessages != null && !errorMessages.isEmpty()) {
			for (RexsValidationResultMessage errorMessage : errorMessages) {
				console.println("[ERROR] " + errorMessage.getDefaultMessage());
			}
		}

		List<RexsValidationResultMessage> warnMessages = result.getWarnings();
		if (warnMessages != null && !warnMessages.isEmpty()) {
			for (RexsValidationResultMessage warnMessage : warnMessages) {
				console.println("[WARNING] " + warnMessage.getDefaultMessage());
			}
		}
	}
}
