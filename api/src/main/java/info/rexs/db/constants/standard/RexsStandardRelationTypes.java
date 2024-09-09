/*
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
 */
package info.rexs.db.constants.standard;

import java.util.Arrays;
import java.util.List;

import javax.annotation.processing.Generated;

import info.rexs.db.constants.RexsRelationType;

/**
 * This enum represents a REXS relation type.
 * <p>
 * It contains values for all relation types of the REXS standard.
 *
 * @author FVA GmbH
 */
@Generated("REXS-Database by FVA GmbH (see https://database.rexs.info/)")
public interface RexsStandardRelationTypes {

	/** Relation type "assembly" (Versions: 1.3, 1.4, 1.5, 1.6). */
	RexsRelationType assembly = RexsRelationType.create("assembly", RexsStandardRelationRoles.assembly, RexsStandardRelationRoles.part);

	/** Relation type "central_shaft" (Versions: 1.3, 1.4, 1.5, 1.6). */
	RexsRelationType central_shaft = RexsRelationType.create("central_shaft", RexsStandardRelationRoles.planetary_stage, RexsStandardRelationRoles.shaft);

	/** Relation type "contact" (Versions: 1.6). */
	RexsRelationType contact = RexsRelationType.create("contact", RexsStandardRelationRoles.assembly, RexsStandardRelationRoles.side_1, RexsStandardRelationRoles.side_2);

	/** Relation type "flank" (Versions: 1.3, 1.4, 1.5, 1.6). */
	RexsRelationType flank = RexsRelationType.create("flank", RexsStandardRelationRoles.gear, RexsStandardRelationRoles.left, RexsStandardRelationRoles.right);

	/** Relation type "manufacturing_step" (Versions: 1.3, 1.4, 1.5, 1.6). */
	RexsRelationType manufacturing_step = RexsRelationType.create("manufacturing_step", RexsStandardRelationRoles.manufacturing_settings, RexsStandardRelationRoles.tool, RexsStandardRelationRoles.workpiece);

	/** Relation type "ordered_assembly" (Versions: 1.3, 1.4, 1.5, 1.6). */
	RexsRelationType ordered_assembly = RexsRelationType.create("ordered_assembly", RexsStandardRelationRoles.assembly, RexsStandardRelationRoles.part);

	/** Relation type "planet_carrier_shaft" (Versions: 1.3, 1.4, 1.5, 1.6). */
	RexsRelationType planet_carrier_shaft = RexsRelationType.create("planet_carrier_shaft", RexsStandardRelationRoles.planetary_stage, RexsStandardRelationRoles.shaft);

	/** Relation type "planet_pin" (Versions: 1.3, 1.4, 1.5, 1.6). */
	RexsRelationType planet_pin = RexsRelationType.create("planet_pin", RexsStandardRelationRoles.planetary_stage, RexsStandardRelationRoles.shaft);

	/** Relation type "planet_shaft" (Versions: 1.3, 1.4, 1.5, 1.6). */
	RexsRelationType planet_shaft = RexsRelationType.create("planet_shaft", RexsStandardRelationRoles.planetary_stage, RexsStandardRelationRoles.shaft);

	/** Relation type "reference" (Versions: 1.3, 1.4, 1.5, 1.6). */
	RexsRelationType reference = RexsRelationType.create("reference", RexsStandardRelationRoles.origin, RexsStandardRelationRoles.referenced);

	/** Relation type "side" (Versions: 1.3, 1.4, 1.5, 1.6). */
	RexsRelationType side = RexsRelationType.create("side", RexsStandardRelationRoles.assembly, RexsStandardRelationRoles.inner_part, RexsStandardRelationRoles.outer_part);

	/** Relation type "stage" (Versions: 1.3, 1.4, 1.5, 1.6). */
	RexsRelationType stage = RexsRelationType.create("stage", RexsStandardRelationRoles.gear_1, RexsStandardRelationRoles.gear_2, RexsStandardRelationRoles.stage);

	/** Relation type "stage_gear_data" (Versions: 1.3, 1.4, 1.5, 1.6). */
	RexsRelationType stage_gear_data = RexsRelationType.create("stage_gear_data", RexsStandardRelationRoles.gear, RexsStandardRelationRoles.stage, RexsStandardRelationRoles.stage_gear_data);

	/** Constant for an unknown relation type. */
	RexsRelationType UNKNOWN = RexsRelationType.create("unknown");

	/** Relation type "connection". */
	RexsRelationType connection = RexsRelationType.create("connection", RexsStandardRelationRoles.side_1, RexsStandardRelationRoles.side_2);

	/** Relation type "coupling". */
	RexsRelationType coupling = RexsRelationType.create("coupling", RexsStandardRelationRoles.side_1, RexsStandardRelationRoles.side_2);

	/** Relation type "ordered_reference". */
	RexsRelationType ordered_reference = RexsRelationType.create("ordered_reference", RexsStandardRelationRoles.origin, RexsStandardRelationRoles.referenced);

	List<RexsRelationType> REXS_RELATIONS_1_0 = Arrays.asList(
			assembly, ordered_assembly, stage, stage_gear_data, side, flank, reference, ordered_reference,
			planet_shaft, central_shaft, planet_carrier_shaft, planet_pin);

	public static void init() {}
}
