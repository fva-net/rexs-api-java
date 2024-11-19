package info.rexs.cli.common;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

import info.rexs.schema.constants.RexsVersion;

public class RexsVersionParameterValidator implements IParameterValidator {

	@Override
	public void validate(String name, String value) throws ParameterException {
		RexsVersion version = RexsVersion.findByModelVersion(value);

		if (version == null || version.equals(RexsVersion.UNKNOWN))
			throw new ParameterException(String.format("Unknown REXS version '%s'", value));
	}
}
