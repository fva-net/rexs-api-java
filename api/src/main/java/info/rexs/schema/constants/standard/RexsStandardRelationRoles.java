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
package info.rexs.schema.constants.standard;

import javax.annotation.processing.Generated;

import info.rexs.schema.constants.RexsRelationRole;

/**
 * This class represents a REXS relation role.
 * <p>
 * It contains constants for all relation roles of official REXS versions (1.3, 1.4, 1.5, 1.6, 1.7).
 *
 * @author FVA GmbH
 */
@Generated("REXS-Database by FVA GmbH (see https://database.rexs.info/)")
public interface RexsStandardRelationRoles {

	/** Relation role "assembly" (Versions: 1.3, 1.4, 1.5, 1.6, 1.7). */
	RexsRelationRole assembly = RexsRelationRole.create("assembly");

	/** Relation role "gear" (Versions: 1.3, 1.4, 1.5, 1.6, 1.7). */
	RexsRelationRole gear = RexsRelationRole.create("gear");

	/** Relation role "gear_1" (Versions: 1.3, 1.4, 1.5, 1.6, 1.7). */
	RexsRelationRole gear_1 = RexsRelationRole.create("gear_1");

	/** Relation role "gear_2" (Versions: 1.3, 1.4, 1.5, 1.6, 1.7). */
	RexsRelationRole gear_2 = RexsRelationRole.create("gear_2");

	/** Relation role "inner_part" (Versions: 1.3, 1.4, 1.5, 1.6, 1.7). */
	RexsRelationRole inner_part = RexsRelationRole.create("inner_part");

	/** Relation role "left" (Versions: 1.3, 1.4, 1.5, 1.6, 1.7). */
	RexsRelationRole left = RexsRelationRole.create("left");

	/** Relation role "manufacturing_settings" (Versions: 1.3, 1.4, 1.5, 1.6, 1.7). */
	RexsRelationRole manufacturing_settings = RexsRelationRole.create("manufacturing_settings");

	/** Relation role "origin" (Versions: 1.3, 1.4, 1.5, 1.6, 1.7). */
	RexsRelationRole origin = RexsRelationRole.create("origin");

	/** Relation role "outer_part" (Versions: 1.3, 1.4, 1.5, 1.6, 1.7). */
	RexsRelationRole outer_part = RexsRelationRole.create("outer_part");

	/** Relation role "part" (Versions: 1.3, 1.4, 1.5, 1.6, 1.7). */
	RexsRelationRole part = RexsRelationRole.create("part");

	/** Relation role "planetary_stage" (Versions: 1.3, 1.4, 1.5, 1.6, 1.7). */
	RexsRelationRole planetary_stage = RexsRelationRole.create("planetary_stage");

	/** Relation role "referenced" (Versions: 1.3, 1.4, 1.5, 1.6, 1.7). */
	RexsRelationRole referenced = RexsRelationRole.create("referenced");

	/** Relation role "right" (Versions: 1.3, 1.4, 1.5, 1.6, 1.7). */
	RexsRelationRole right = RexsRelationRole.create("right");

	/** Relation role "shaft" (Versions: 1.3, 1.4, 1.5, 1.6, 1.7). */
	RexsRelationRole shaft = RexsRelationRole.create("shaft");

	/** Relation role "side_1" (Versions: 1.6, 1.7). */
	RexsRelationRole side_1 = RexsRelationRole.create("side_1");

	/** Relation role "side_2" (Versions: 1.6, 1.7). */
	RexsRelationRole side_2 = RexsRelationRole.create("side_2");

	/** Relation role "stage" (Versions: 1.3, 1.4, 1.5, 1.6, 1.7). */
	RexsRelationRole stage = RexsRelationRole.create("stage");

	/** Relation role "stage_gear_data" (Versions: 1.3, 1.4, 1.5, 1.6, 1.7). */
	RexsRelationRole stage_gear_data = RexsRelationRole.create("stage_gear_data");

	/** Relation role "tool" (Versions: 1.3, 1.4, 1.5, 1.6, 1.7). */
	RexsRelationRole tool = RexsRelationRole.create("tool");

	/** Relation role "workpiece" (Versions: 1.3, 1.4, 1.5, 1.6, 1.7). */
	RexsRelationRole workpiece = RexsRelationRole.create("workpiece");

	/** Constant for an unknown relation role. */
	RexsRelationRole UNKNOWN = RexsRelationRole.create("unknown");

	public static void init() {}
}
