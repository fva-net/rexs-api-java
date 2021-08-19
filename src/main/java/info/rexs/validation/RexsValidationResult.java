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
 * This class represents the result of a REXS validation.
 *
 * @author FVA GmbH
 */
@Getter
public class RexsValidationResult {

	/** A list containing all warning messages. */
	private List<RexsValidationResultMessage> warnings = new ArrayList<>();

	/** A list containing all error messages. */
	private List<RexsValidationResultMessage> errors = new ArrayList<>();

	/**
	 * Returns the status of the validation.
	 *
	 * @return
	 * 				{@code true} if the validation is valid, otherwise {@code false}.
	 */
	public boolean isValid()
	{
		return errors == null || errors.isEmpty();
	}

	/**
	 * Add an error to the validation result.
	 *
	 * @param key
	 * 				The {@link RexsValidationResultMessageKey} describing the error.
	 */
	public void addError(RexsValidationResultMessageKey key)
	{
		errors.add(new RexsValidationResultMessage(key));
	}

	/**
	 * Add an error to the validation result containing additional messages.
	 *
	 * @param key
	 * 				The {@link RexsValidationResultMessageKey} describing the error.
	 * @param additionalMessages
	 * 				Additional messages as a {@link List} of {@link String}.
	 */
	public void addError(RexsValidationResultMessageKey key, List<String> additionalMessages)
	{
		errors.add(new RexsValidationResultMessage(key, null, null, additionalMessages));
	}

	/**
	 * Add an error to the validation result containing the related component type.
	 *
	 * @param key
	 * 				The {@link RexsValidationResultMessageKey} describing the error.
	 * @param componentType
	 * 				The related component type as {@link String}.
	 */
	public void addError(RexsValidationResultMessageKey key, String componentType)
	{
		errors.add(new RexsValidationResultMessage(key, componentType, null, null));
	}

	/**
	 * Add an error to the validation result containing the related component type and additional messages.
	 *
	 * @param key
	 * 				The {@link RexsValidationResultMessageKey} describing the error.
	 * @param componentType
	 * 				The related component type as {@link String}.
	 * @param additionalMessages
	 * 				Additional messages as a {@link List} of {@link String}.
	 */
	public void addError(RexsValidationResultMessageKey key, String componentType, List<String> additionalMessages)
	{
		errors.add(new RexsValidationResultMessage(key, componentType, null, additionalMessages));
	}

	/**
	 * Add an error to the validation result containing the related component type and the related attribute id.
	 *
	 * @param key
	 * 				The {@link RexsValidationResultMessageKey} describing the error.
	 * @param componentType
	 * 				The related component type as {@link String}.
	 * @param attributeId
	 * 				The related attribute id as {@link String}.
	 */
	public void addError(RexsValidationResultMessageKey key, String componentType, String attributeId)
	{
		errors.add(new RexsValidationResultMessage(key, componentType, attributeId, null));
	}

	/**
	 * Add an error to the validation result containing the related component type, the related attribute id and additional messages.
	 *
	 * @param key
	 * 				The {@link RexsValidationResultMessageKey} describing the error.
	 * @param componentType
	 * 				The related component type as {@link String}.
	 * @param attributeId
	 * 				The related attribute id as {@link String}.
	 * @param additionalMessages
	 * 				Additional messages as a {@link List} of {@link String}.
	 */
	public void addError(RexsValidationResultMessageKey key, String componentType, String attributeId, List<String> additionalMessages)
	{
		errors.add(new RexsValidationResultMessage(key, componentType, attributeId, additionalMessages));
	}

	/**
	 * Add an warning to the validation result.
	 *
	 * @param key
	 * 				The {@link RexsValidationResultMessageKey} describing the warning.
	 */
	public void addWarning(RexsValidationResultMessageKey key)
	{
		warnings.add(new RexsValidationResultMessage(key));
	}

	/**
	 * Add an warning to the validation result containing additional messages.
	 *
	 * @param key
	 * 				The {@link RexsValidationResultMessageKey} describing the warning.
	 * @param additionalMessages
	 * 				Additional messages as a {@link List} of {@link String}.
	 */
	public void addWarning(RexsValidationResultMessageKey key, List<String> additionalMessages)
	{
		warnings.add(new RexsValidationResultMessage(key, null, null, additionalMessages));
	}

	/**
	 * Add an warning to the validation result containing the related component type.
	 *
	 * @param key
	 * 				The {@link RexsValidationResultMessageKey} describing the warning.
	 * @param componentType
	 * 				The related component type as {@link String}.
	 */
	public void addWarning(RexsValidationResultMessageKey key, String componentType)
	{
		warnings.add(new RexsValidationResultMessage(key, componentType, null, null));
	}

	/**
	 * Add an warning to the validation result containing the related component type and additional messages.
	 *
	 * @param key
	 * 				The {@link RexsValidationResultMessageKey} describing the warning.
	 * @param componentType
	 * 				The related component type as {@link String}.
	 * @param additionalMessages
	 * 				Additional messages as a {@link List} of {@link String}.
	 */
	public void addWarning(RexsValidationResultMessageKey key, String componentType, List<String> additionalMessages)
	{
		warnings.add(new RexsValidationResultMessage(key, componentType, null, additionalMessages));
	}

	/**
	 * Add an warning to the validation result containing the related component type and the related attribute id.
	 *
	 * @param key
	 * 				The {@link RexsValidationResultMessageKey} describing the warning.
	 * @param componentType
	 * 				The related component type as {@link String}.
	 * @param attributeId
	 * 				The related attribute id as {@link String}.
	 */
	public void addWarning(RexsValidationResultMessageKey key, String componentType, String attributeId)
	{
		warnings.add(new RexsValidationResultMessage(key, componentType, attributeId, null));
	}

	/**
	 * Add an warning to the validation result containing the related component type, the related attribute id and additional messages.
	 *
	 * @param key
	 * 				The {@link RexsValidationResultMessageKey} describing the warning.
	 * @param componentType
	 * 				The related component type as {@link String}.
	 * @param attributeId
	 * 				The related attribute id as {@link String}.
	 * @param additionalMessages
	 * 				Additional messages as a {@link List} of {@link String}.
	 */
	public void addWarning(RexsValidationResultMessageKey key, String componentType, String attributeId, List<String> additionalMessages)
	{
		warnings.add(new RexsValidationResultMessage(key, componentType, attributeId, additionalMessages));
	}

	/**
	 * Adds all the errors and warning of another validation result.
	 *
	 * @param validationResult
	 * 				The {@link RexsValidationResult} from which the messages are taken.
	 */
	public void add(RexsValidationResult validationResult) {
		errors.addAll(validationResult.getErrors());
		warnings.addAll(validationResult.getWarnings());
	}
}
