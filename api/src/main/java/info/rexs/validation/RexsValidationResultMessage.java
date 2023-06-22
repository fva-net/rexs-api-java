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

import java.util.List;

/**
 * This class represents the result message of a REXS validation.
 *
 * @author FVA GmbH
 */
public class RexsValidationResultMessage {

	/** The key of the message. */
	private final RexsValidationResultMessageKey key;

	/** The related component type. */
	private final String componentType;

	/** The related attribute id. */
	private final String attributeId;

	/** A list of additional messages. */
	private final List<String> additionalMessages;

	/**
	 * Constructs a new {@link RexsValidationResultMessage} for the given message key.
	 *
	 * @param key
	 * 				The {@link RexsValidationResultMessageKey} describing the message.
	 */
	public RexsValidationResultMessage(RexsValidationResultMessageKey key) {
		this(key, null, null, null);
	}

	/**
	 * Constructs a new {@link RexsValidationResultMessage} for the given message key,
	 * the related component type, the related attribute id and additional messages.
	 *
	 * @param key
	 * 				The {@link RexsValidationResultMessageKey} describing the message.
	 * @param componentType
	 * 				The related component type as {@link String}.
	 * @param attributeId
	 * 				The related attribute id as {@link String}.
	 * @param additionalMessages
	 * 				Additional messages as a {@link List} of {@link String}.
	 */
	public RexsValidationResultMessage(RexsValidationResultMessageKey key, String componentType, String attributeId, List<String> additionalMessages) {
		this.key = key;
		this.componentType = componentType;
		this.attributeId = attributeId;
		this.additionalMessages = additionalMessages;
	}
}
