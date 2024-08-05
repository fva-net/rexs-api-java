/*******************************************************************************
 * Copyright (C) 2024 FVA GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.  You may obtain a copy
 * of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 ******************************************************************************/
package info.rexs.validation;

import info.rexs.db.IDbModelRegistry;

/**
 * This implementation of {@link IRexsFileValidator} validates if a REXS file conforms to the 
 * modelling guideline quasistatic and includes the specification of official REXS versions.
 *
 * @author FVA GmbH
 */
public class RexsModellingGuidelineQuasistaticFileValidator extends RexsStandardFileValidator {

	public RexsModellingGuidelineQuasistaticFileValidator() {
		super();
	}

	public RexsModellingGuidelineQuasistaticFileValidator(IDbModelRegistry dbModelRegistry) {
		super(dbModelRegistry);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IRexsModelValidator createModelValidator() {
		return new RexsModellingGuidelineQuasistaticModelValidator(dbModelRegistry);
	}
}
