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

/**
 * This class represents the result of a REXS validation.
 *
 * @author FVA GmbH
 */
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
	public boolean isValid() {
		return errors == null || errors.isEmpty();
	}

	/**
	 * Add an error to the validation result containing additional messages.
	 *
	 * @param key
	 * 				The {@link RexsValidationResultMessageKey} describing the error.
	 * @param additionalMessages
	 * 				Additional messages as a {@link Array} of {@link String}.
	 */
	public void addError(RexsValidationResultMessageKey key, String... additionalMessages) {
		errors.add(new RexsValidationResultMessage(key, additionalMessages));
	}

	/**
	 * Add an warning to the validation result containing additional messages.
	 *
	 * @param key
	 * 				The {@link RexsValidationResultMessageKey} describing the warning.
	 * @param additionalMessages
	 * 				Additional messages as a {@link Array} of {@link String}.
	 */
	public void addWarning(RexsValidationResultMessageKey key, String... additionalMessages) {
		warnings.add(new RexsValidationResultMessage(key, additionalMessages));
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

	public List<RexsValidationResultMessage> getWarnings() {
		return this.warnings;
	}

	public List<RexsValidationResultMessage> getErrors() {
		return this.errors;
	}
}
