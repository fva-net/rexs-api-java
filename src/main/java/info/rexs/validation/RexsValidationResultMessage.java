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

import lombok.Getter;

@Getter
public class RexsValidationResultMessage {

	private final RexsValidationResultMessageKey key;

	private final String componentType;

	private final String attributeId;

	private final List<String> additionalMessages;

	public RexsValidationResultMessage(RexsValidationResultMessageKey key) {
		this(key, null, null, null);
	}

	public RexsValidationResultMessage(RexsValidationResultMessageKey key, String componentType, String attributeId, List<String> additionalMessages) {
		this.key = key;
		this.componentType = componentType;
		this.attributeId = attributeId;
		this.additionalMessages = additionalMessages;
	}
}
