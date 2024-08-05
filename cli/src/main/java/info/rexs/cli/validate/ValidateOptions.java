package info.rexs.cli.validate;

import java.nio.file.Path;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

import info.rexs.cli.common.RexsFileExistingValidator;
import info.rexs.validation.RexsValidatorMode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Parameters(commandDescription = "Validates a REXS file")
public class ValidateOptions {

	@Parameter(
		names = {"--file", "-f"},
		description = "The REXS file to validate (use slashes instead of backslashes)",
		validateValueWith = RexsFileExistingValidator.class,
		required = true)
	private Path file;

	@Parameter(
		names = {"--mode", "-m"},
		description = "The validation mode",
		converter = RexsValidatorModeConverter.class)
	private RexsValidatorMode mode = RexsValidatorMode.STANDARD;
}
