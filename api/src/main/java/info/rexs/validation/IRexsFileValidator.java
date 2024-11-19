/*
 * Copyright (C) 2023 FVA GmbH
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

import java.io.File;
import java.nio.file.Path;

import info.rexs.io.Resource;

/**
 * This interface represents the validator of a REXS file.
 *
 * @author FVA GmbH
 */
public interface IRexsFileValidator {

	/**
	 * Validates a REXS file for the given {@link Resource} to the REXS file and returns the validation result.
	 *
	 * @param rexsFileResource
	 * 				The {@link Resource} to the REXS file.
	 *
	 * @return
	 * 				The validation result as {@link RexsValidationResult}.
	 */
	RexsValidationResult validate(Resource rexsFileResource);

	/**
	 * Validates a REXS file for the given {@link Path} to the REXS file and returns the validation result.
	 *
	 * @param pathToRexsFile
	 * 				The {@link Path} to the REXS file.
	 *
	 * @return
	 * 				The validation result as {@link RexsValidationResult}.
	 */
	RexsValidationResult validate(Path pathToRexsFile);

	/**
	 * Validates a REXS file for the given REXS {@link File} and returns the validation result.
	 *
	 * @param rexsFile
	 * 				The REXS {@link File}.
	 *
	 * @return
	 * 				The validation result as {@link RexsValidationResult}.
	 */
	RexsValidationResult validate(File rexsFile);

	/**
	 * Validates a REXS file for the given path to the REXS file as {@link String} and returns the validation result.
	 *
	 * @param pathToRexsFile
	 * 				The path to the REXS file as {@link String}.
	 *
	 * @return
	 * 				The validation result as {@link RexsValidationResult}.
	 */
	RexsValidationResult validate(String pathToRexsFile);

	/**
	 * Creates a new validator for the model of the REXS file.
	 *
	 * @return
	 * 				The model validator as {@link IRexsModelValidator}.
	 */
	IRexsModelValidator createModelValidator();
}
