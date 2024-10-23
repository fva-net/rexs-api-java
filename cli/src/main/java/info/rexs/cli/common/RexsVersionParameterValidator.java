package info.rexs.cli.common;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

import info.rexs.schema.constants.RexsVersion;
import info.rexs.schema.constants.standard.RexsStandardVersions;

public class RexsVersionParameterValidator implements IParameterValidator {

	@Override
	public void validate(String name, String value) throws ParameterException {
		RexsVersion version = RexsVersion.findByName(value);

		if (version == null || version.isOneOf(RexsStandardVersions.UNKNOWN))
			throw new ParameterException(String.format("Unknown REXS version '%s'", value));
	}
}
