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

import info.rexs.model.jaxb.Attribute;
import info.rexs.model.jaxb.Component;

/**
 * TODO Document me!
 *
 * @author FVA GmbH
 */
public interface IRexsAttributeValidator {

	/**
	 * TODO Document me!
	 *
	 * @param rexsAttribute
	 * 				TODO Document me!
	 * @param rexsComponent
	 * 				TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public RexsValidationResult validate(Attribute rexsAttribute, Component rexsComponent);
}
