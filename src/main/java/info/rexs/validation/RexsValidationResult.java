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

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

/**
 * TODO Document me!
 *
 * @author FVA GmbH
 */
@Getter
public class RexsValidationResult {

	/** TODO Document me! */
	private List<RexsValidationResultMessage> warnings = new ArrayList<>();

	/** TODO Document me! */
	private List<RexsValidationResultMessage> errors = new ArrayList<>();

	/**
	 * TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public boolean isValid()
	{
		return errors == null || errors.isEmpty();
	}

	/**
	 * TODO Document me!
	 *
	 * @param key
	 * 				TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public void addError(RexsValidationResultMessageKey key)
	{
		errors.add(new RexsValidationResultMessage(key));
	}

	/**
	 * TODO Document me!
	 *
	 * @param key
	 * 				TODO Document me!
	 * @param additionalMessages
	 * 				TODO Document me!
	 */
	public void addError(RexsValidationResultMessageKey key, List<String> additionalMessages)
	{
		errors.add(new RexsValidationResultMessage(key, null, null, additionalMessages));
	}

	/**
	 * TODO Document me!
	 *
	 * @param key
	 * 				TODO Document me!
	 * @param componentType
	 * 				TODO Document me!
	 */
	public void addError(RexsValidationResultMessageKey key, String componentType)
	{
		errors.add(new RexsValidationResultMessage(key, componentType, null, null));
	}

	/**
	 * TODO Document me!
	 *
	 * @param key
	 * 				TODO Document me!
	 * @param componentType
	 * 				TODO Document me!
	 * @param additionalMessages
	 * 				TODO Document me!
	 */
	public void addError(RexsValidationResultMessageKey key, String componentType, List<String> additionalMessages)
	{
		errors.add(new RexsValidationResultMessage(key, componentType, null, additionalMessages));
	}

	/**
	 * TODO Document me!
	 *
	 * @param key
	 * 				TODO Document me!
	 * @param componentType
	 * 				TODO Document me!
	 * @param attributeId
	 * 				TODO Document me!
	 */
	public void addError(RexsValidationResultMessageKey key, String componentType, String attributeId)
	{
		errors.add(new RexsValidationResultMessage(key, componentType, attributeId, null));
	}

	/**
	 * TODO Document me!
	 *
	 * @param key
	 * 				TODO Document me!
	 * @param componentType
	 * 				TODO Document me!
	 * @param attributeId
	 * 				TODO Document me!
	 * @param additionalMessages
	 * 				TODO Document me!
	 */
	public void addError(RexsValidationResultMessageKey key, String componentType, String attributeId, List<String> additionalMessages)
	{
		errors.add(new RexsValidationResultMessage(key, componentType, attributeId, additionalMessages));
	}

	/**
	 * TODO Document me!
	 *
	 * @param key
	 * 				TODO Document me!
	 */
	public void addWarning(RexsValidationResultMessageKey key)
	{
		warnings.add(new RexsValidationResultMessage(key));
	}

	/**
	 * TODO Document me!
	 *
	 * @param key
	 * 				TODO Document me!
	 * @param additionalMessages
	 * 				TODO Document me!
	 */
	public void addWarning(RexsValidationResultMessageKey key, List<String> additionalMessages)
	{
		warnings.add(new RexsValidationResultMessage(key, null, null, additionalMessages));
	}

	/**
	 * TODO Document me!
	 *
	 * @param key
	 * 				TODO Document me!
	 * @param componentType
	 * 				TODO Document me!
	 */
	public void addWarning(RexsValidationResultMessageKey key, String componentType)
	{
		warnings.add(new RexsValidationResultMessage(key, componentType, null, null));
	}

	/**
	 * TODO Document me!
	 *
	 * @param key
	 * 				TODO Document me!
	 * @param componentType
	 * 				TODO Document me!
	 * @param additionalMessages
	 * 				TODO Document me!
	 */
	public void addWarning(RexsValidationResultMessageKey key, String componentType, List<String> additionalMessages)
	{
		warnings.add(new RexsValidationResultMessage(key, componentType, null, additionalMessages));
	}

	/**
	 * TODO Document me!
	 *
	 * @param key
	 * 				TODO Document me!
	 * @param componentType
	 * 				TODO Document me!
	 * @param attributeId
	 * 				TODO Document me!
	 */
	public void addWarning(RexsValidationResultMessageKey key, String componentType, String attributeId)
	{
		warnings.add(new RexsValidationResultMessage(key, componentType, attributeId, null));
	}

	/**
	 * TODO Document me!
	 *
	 * @param key
	 * 				TODO Document me!
	 * @param componentType
	 * 				TODO Document me!
	 * @param attributeId
	 * 				TODO Document me!
	 * @param additionalMessages
	 * 				TODO Document me!
	 */
	public void addWarning(RexsValidationResultMessageKey key, String componentType, String attributeId, List<String> additionalMessages)
	{
		warnings.add(new RexsValidationResultMessage(key, componentType, attributeId, additionalMessages));
	}

	/**
	 * TODO Document me!
	 *
	 * @param validationResult
	 * 				TODO Document me!
	 */
	public void add(RexsValidationResult validationResult) {
		errors.addAll(validationResult.getErrors());
		warnings.addAll(validationResult.getWarnings());
	}
}
