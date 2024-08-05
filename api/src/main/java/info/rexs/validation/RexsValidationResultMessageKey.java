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

/**
 * This class represents the key of a result message for a REXS validation.
 *
 * @author FVA GmbH
 */
public enum RexsValidationResultMessageKey {

	EMPTY_FILE("The file is empty."),
	XML_SCHEMA("The XML schema for REXS files is violated: %s"),

	MODEL_VERSION_EMPTY("The version is empty."),
	MODEL_VERSION_UNKNOWN("The version is unknown."),
	MODEL_COMPONENTS_EMPTY("The model has no components."),

	COMPONENT_TYPE_UNKNOWN("The component type %s is unknown."),
	COMPONENT_ATTRIBUTES_EMPTY("The component %s has no attributes."),
	COMPONENT_ATTRIBUTE_MULTIPLE("The attribute %s was specified multiple times within the component %s."),

	ATTRIBUTE_ID_UNKNOWN("The attribute id %s is unknown."),
	ATTRIBUTE_COMPONENT_MAPPING_UNKNOWN("The assignment between component %s and attribute %s is incorrect."),
	ATTRIBUTE_UNIT_MAPPING_UNKNOWN("The assigned unit for attribute %s in component %s is incorrect: %s"),

	UNIT_UNKNOWN("The unit %s is unknown."),

	RELATION_ROLE_INVALID_FOR_RELATION_TYPE("The role %s is not valid for the relation type %s"),
	RELATION_NOT_ALLOWED_COMBINATION("The relation %s contains an invalid combination of component types in the respective roles for relation type %s: %s"),
	RELATION_COMPONENT_MISSING("The relation %s references the component id %s which is not present in the REXS model"),

	PLANETARY_STAGE_INCONSISTENT_CARRIER("A planetary stage has to be assigned exactly one planet carrier: %s"),
	PLANETARY_STAGE_MISSING_CENTRAL_SHAFT("A planetary stage has to be assigned at least one central shaft: %s"),
	PLANETARY_STAGE_MISSING_PLANET_SHAFT("A planetary stage has to be assigned at least one planet shaft: %s"),
	PLANETARY_STAGE_MISSING_STAGE("A planetary stage has to be assigned at least one stage: %s"),

	GUIDELINE_QUASISTATIC_RELATION_MISSING_ROLES("Modelling guideline quasi-static analysis: Incomplete relations are not permitted. The following roles are missing for relation %s: %s"),
	GUIDELINE_QUASISTATIC_INCONSISTENT_GEAR_UNIT("Modelling guideline quasi-static analysis: Exactly one geat_unit component is required per model."),
	GUIDELINE_QUASISTATIC_COMPONENT_WITHOUT_RELATION("Modelling guideline quasi-static analysis: Components that do not appear in any relation are not permitted: %s"),
	GUIDELINE_QUASISTATIC_SHAFT_WITHOUT_SHAFT_SECTION("Modelling guideline quasi-static analysis: Each shaft must have at least one shaft section: %s"),
	GUIDELINE_QUASISTATIC_INCONSISTENT_GEAR("Modelling guideline quasi-static analysis: Each gear must be part of at least one stage: %s"),
	GUIDELINE_QUASISTATIC_INCONSISTENT_STAGE("Modelling guideline quasi-static analysis: Two different gears must be assigned to each gear stage: %s"),
	GUIDELINE_QUASISTATIC_INCOMPLETE_PLANET_CARRIER("Modelling guideline quasi-static analysis: A planet carrier must have at least a carrier shaft and a side plate: %s"),
	GUIDELINE_QUASISTATIC_MISSING_SIDE_RELATION("Modelling guideline quasi-static analysis: Missing side relation for component: %s"),
	GUIDELINE_QUASISTATIC_PLANETARY_STAGE_MISSING_PLANET_CARRIER_SHAFT("Modelling guideline quasi-static analysis: A planetary stage has to be assigned at least one planet carrier shaft: %s"),
	GUIDELINE_QUASISTATIC_PLANETARY_CARRIER_MISSING_PLANET_CARRIER_SHAFT("Modelling guideline quasi-static analysis: A planet carrier has to be assigned at least one planet carrier shaft: %s"),
	GUIDELINE_QUASISTATIC_PLANETARY_CARRIER_MISSING_SIDE_PLATE("Modelling guideline quasi-static analysis: A planet carrier has to be assigned at least one side plate: %s"),
	GUIDELINE_QUASISTATIC_SIDE_PLATE_MISSING_CARRIER_SHAFT_COUPLING("Modelling guideline quasi-static analysis: A side plate has to be coupled to a planet carrier shaft via a coupling: %s"),
	GUIDELINE_QUASISTATIC_SIDE_PLATE_MISSING_PIN_COUPLING("Modelling guideline quasi-static analysis: A pin has to be coupled to a side plate via a coupling: %s"),
	GUIDELINE_QUASISTATIC_COMPONENT_REQUIRES_SIDE_RELATION("Modelling guideline quasi-static analysis: The component %s of type %s requires a side relation"),
	GUIDELINE_QUASISTATIC_SHAFT_WITHOUT_SIDE_RELATION("Modelling guideline quasi-static analysis: Each shaft must be connected via at least one side relation: %s"),

	INTERNAL_ERROR("An unexpected error occurred. Contact support if necessary."),
	CAUGHT_EXCEPTION("%s");

	/** The default message of the message key. */
	private String defaultMessage;

	private RexsValidationResultMessageKey(String defaultMessage) {
		this.defaultMessage = defaultMessage;
	}

	@Override
	public String toString() {
		return defaultMessage;
	}
}
