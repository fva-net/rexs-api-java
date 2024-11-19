package info.rexs.cli.common;

import com.beust.jcommander.IStringConverter;

import info.rexs.schema.constants.RexsVersion;

public class RexsVersionConverter implements IStringConverter<RexsVersion> {

	@Override
	public RexsVersion convert(String value) {
		return RexsVersion.findByModelVersion(value);
	}
}
