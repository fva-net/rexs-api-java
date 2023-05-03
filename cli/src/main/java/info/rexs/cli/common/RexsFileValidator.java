package info.rexs.cli.common;

import java.nio.file.Path;

import com.beust.jcommander.IValueValidator;
import com.beust.jcommander.ParameterException;

import info.rexs.io.RexsIoFormat;

public class RexsFileValidator implements IValueValidator<Path>
{
	@Override
	public void validate(String name, Path value) throws ParameterException
	{
		String filename = value.getFileName().toString();
		RexsIoFormat format = RexsIoFormat.findFormatByFilename(filename);

		if (format == null)
			throw new ParameterException(String.format("File '%s' is an unknown REXS file format", value));
	}
}
