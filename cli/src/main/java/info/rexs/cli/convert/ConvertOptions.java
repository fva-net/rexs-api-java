package info.rexs.cli.convert;

import java.nio.file.Path;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

import info.rexs.cli.common.RexsFileExistingValidator;
import info.rexs.cli.common.RexsFileValidator;
import info.rexs.cli.common.RexsVersionConverter;
import info.rexs.cli.common.RexsVersionParameterValidator;
import info.rexs.db.constants.RexsVersion;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Parameters(commandDescription = "Converts a REXS file")
public class ConvertOptions {

	@Parameter(
		names = {"--file", "-f"},
		description = "The REXS file to convert",
		validateValueWith = RexsFileExistingValidator.class,
		required = true)
	private Path file;

	@Parameter(
		names = {"--targetVersion"},
		description = "The target REXS version",
		validateWith = RexsVersionParameterValidator.class,
		converter = RexsVersionConverter.class)
	private RexsVersion targetVersion;

	@Parameter(
		names = {"--strict"},
		description = "Use strict mode") // TODO: Add description
	private boolean strictMode = false;

	@Parameter(
		names = {"--targetFile"},
		description = "Location of the converted REXS file",
		validateValueWith = RexsFileValidator.class,
		required = true)
	private String targetFile;

	@Parameter(
		names = {"--override", "-o"},
		description = "Overwrite if the target file already exists")
	private boolean overrideExistingFile = false;
	}