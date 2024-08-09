package info.rexs.validation;

public enum RexsValidatorMode {

	DEFAULT,

	STANDARD {
		@Override
		public IRexsFileValidator createFileValidator() {
			return new RexsStandardFileValidator();
		}

		@Override
		public IRexsModelValidator createModelValidator() {
			return new RexsStandardModelValidator();
		}
	},

	GUIDELINE_QUASI_STATIC {
		@Override
		public IRexsFileValidator createFileValidator() {
			return new RexsModellingGuidelineQuasistaticFileValidator();
		}

		@Override
		public IRexsModelValidator createModelValidator() {
			return new RexsModellingGuidelineQuasistaticModelValidator();
		}
	};

	public IRexsFileValidator createFileValidator() {
		return new DefaultRexsFileValidator();
	}

	public IRexsModelValidator createModelValidator() {
		return new DefaultRexsModelValidator();
	}
}
