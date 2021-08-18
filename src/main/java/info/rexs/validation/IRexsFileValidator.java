/*******************************************************************************
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
 ******************************************************************************/
package info.rexs.validation;

import java.io.File;
import java.nio.file.Path;

/**
 * TODO Document me!
 *
 * @author FVA GmbH
 */
public interface IRexsFileValidator {

	/**
	 * TODO Document me!
	 *
	 * @param pathToRexsFile
	 * 				TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public RexsValidationResult validate(Path pathToRexsFile);

	/**
	 * TODO Document me!
	 *
	 * @param rexsFile
	 * 				TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public RexsValidationResult validate(File rexsFile);

	/**
	 * TODO Document me!
	 *
	 * @param pathToRexsFile
	 * 				TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public RexsValidationResult validate(String pathToRexsFile);

	/**
	 * TODO Document me!
	 *
	 * @param version
	 * 				TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public RexsValidationResult validateVersion(String version);

	/**
	 * TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public IRexsComponentValidator createComponentValidator();
}
