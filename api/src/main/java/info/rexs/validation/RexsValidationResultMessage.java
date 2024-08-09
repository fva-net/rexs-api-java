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

/**
 * This class represents the result message of a REXS validation.
 *
 * @author FVA GmbH
 */
public class RexsValidationResultMessage {

	/** The key of the message. */
	private final RexsValidationResultMessageKey key;

	/** A list of additional messages. */
	private final String[] additionalMessages;

	/**
	 * Constructs a new {@link RexsValidationResultMessage} for the given message key,
	 * the related component type, the related attribute id and additional messages.
	 *
	 * @param key
	 * 				The {@link RexsValidationResultMessageKey} describing the message.
	 * @param additionalMessages
	 * 				Additional messages as an array of {@link String}.
	 */
	public RexsValidationResultMessage(RexsValidationResultMessageKey key, String... additionalMessages) {
		this.key = key;
		this.additionalMessages = additionalMessages;
	}

	public RexsValidationResultMessageKey getKey() {
		return key;
	}

	public String[] getAdditionalMessages() {
		return additionalMessages;
	}

	public String getDefaultMessage() {
		if (additionalMessages == null || additionalMessages.length < 1)
			return key.getDefaultMessage();
		return String.format(key.getDefaultMessage(), (Object[])additionalMessages);
	}
}
