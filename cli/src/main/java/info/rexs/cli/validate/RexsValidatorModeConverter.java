package info.rexs.cli.validate;

import com.beust.jcommander.converters.EnumConverter;

import info.rexs.validation.RexsValidatorMode;

public class RexsValidatorModeConverter extends EnumConverter<RexsValidatorMode> {

	public RexsValidatorModeConverter(String optionName, Class<RexsValidatorMode> clazz) {
		super(optionName, clazz);
	}
}