package info.rexs.cli.common;

import java.nio.file.Files;
import java.nio.file.Path;

import com.beust.jcommander.ParameterException;

public class RexsFileExistingValidator extends RexsFileValidator
{
	@Override
	public void validate(String name, Path value) throws ParameterException
	{
		super.validate(name, value);

		if (Files.notExists(value))
			throw new ParameterException(String.format("File '%s' does not exist", value));
	}
}
