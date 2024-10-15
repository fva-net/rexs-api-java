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

import info.rexs.schema.RexsSchemaRegistry;
import info.rexs.schema.IRexsSchemaRegistry;

/**
 * This implementation of {@link IRexsFileValidator} validates the basic structure of a REXS file
 * and includes the specification of official REXS versions.
 *
 * @author FVA GmbH
 */
public class RexsStandardFileValidator extends DefaultRexsFileValidator {

	protected final IRexsSchemaRegistry rexsSchemaRegistry;

	public RexsStandardFileValidator() {
		this(RexsSchemaRegistry.getInstance());
	}

	public RexsStandardFileValidator(IRexsSchemaRegistry rexsSchemaRegistry) {
		Objects.nonNull(rexsSchemaRegistry);
		this.rexsSchemaRegistry = rexsSchemaRegistry;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IRexsModelValidator createModelValidator() {
		return new RexsStandardModelValidator(rexsSchemaRegistry);
	}
}
