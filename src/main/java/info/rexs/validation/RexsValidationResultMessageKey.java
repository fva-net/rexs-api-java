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

import lombok.Getter;

@Getter
public enum RexsValidationResultMessageKey {

	EMPTY_FILE("TODO"),
	XML_SCHEMA("TODO"),

	MODEL_VERSION_EMPTY("TODO"),
	MODEL_VERSION_UNKNOWN("TODO"),
	MODEL_COMPONENTS_EMPTY("TODO"),

	COMPONENT_TYPE_UNKNOWN("TODO"),
	COMPONENT_ATTRIBUTES_EMPTY("TODO"),
	COMPONENT_ATTRIBUTE_MULTIPLE("TODO"),

	ATTRIBUTE_ID_UNKNOWN("TODO"),
	ATTRIBUTE_COMPONENT_MAPPING_UNKNOWN("TODO"),

	INTERNAL_ERROR("An unexpected error occurred. Contact support if necessary.");

	private String defaultMessage;

	private RexsValidationResultMessageKey(String defaultMessage) {
		this.defaultMessage = defaultMessage;
	}
}
