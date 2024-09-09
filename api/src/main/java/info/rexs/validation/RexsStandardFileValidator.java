/*
 * Copyright (C) 2020 FVA GmbH
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
 */
package info.rexs.validation;

import java.util.Objects;

import info.rexs.db.DbModelRegistry;
import info.rexs.db.IDbModelRegistry;

/**
 * This implementation of {@link IRexsFileValidator} validates the basic structure of a REXS file
 * and includes the specification of official REXS versions.
 *
 * @author FVA GmbH
 */
public class RexsStandardFileValidator extends DefaultRexsFileValidator {

	protected final IDbModelRegistry dbModelRegistry;

	public RexsStandardFileValidator() {
		this(DbModelRegistry.getInstance());
	}

	public RexsStandardFileValidator(IDbModelRegistry dbModelRegistry) {
		Objects.nonNull(dbModelRegistry);
		this.dbModelRegistry = dbModelRegistry;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IRexsModelValidator createModelValidator() {
		return new RexsStandardModelValidator(dbModelRegistry);
	}
}
