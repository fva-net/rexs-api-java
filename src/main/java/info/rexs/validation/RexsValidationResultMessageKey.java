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

/**
 * This class represents the key of a result message for a REXS validation.
 *
 * @author FVA GmbH
 */
@Getter
public enum RexsValidationResultMessageKey {

	EMPTY_FILE("The file is empty."),
	XML_SCHEMA("The XML schema for REXS files is violated."),

	MODEL_VERSION_EMPTY("The version is empty."),
	MODEL_VERSION_UNKNOWN("The version is unknown."),
	MODEL_COMPONENTS_EMPTY("The model has no components."),

	COMPONENT_TYPE_UNKNOWN("The component type is unknown."),
	COMPONENT_ATTRIBUTES_EMPTY("The component has no attributes."),
	COMPONENT_ATTRIBUTE_MULTIPLE("The attribute was specified multiple times within the component."),

	ATTRIBUTE_ID_UNKNOWN("The attribute id is unknown."),
	ATTRIBUTE_COMPONENT_MAPPING_UNKNOWN("The assignment between component and attribute is incorrect."),
	ATTRIBUTE_UNIT_MAPPING_UNKNOWN("The assignment between attribute and unit is incorrect."),

	UNIT_UNKNOWN("The unit is unknown."),

	INTERNAL_ERROR("An unexpected error occurred. Contact support if necessary.");

	/** The default message of the message key. */
	private String defaultMessage;

	private RexsValidationResultMessageKey(String defaultMessage) {
		this.defaultMessage = defaultMessage;
	}
}
