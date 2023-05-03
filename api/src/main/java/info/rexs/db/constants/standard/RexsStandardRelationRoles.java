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
package info.rexs.db.constants.standard;

import info.rexs.db.constants.RexsRelationRole;

/**
 * This class represents a REXS relation role.
 * <p>
 * It contains constants for all relation roles of official REXS versions (1.0, 1.1, 1.2, 1.3).
 *
 * @author FVA GmbH
 */
public interface RexsStandardRelationRoles {

	/** Relation role "assembly". */
	public static final RexsRelationRole assembly = RexsRelationRole.create("assembly");

	/** Relation role "part". */
	public static final RexsRelationRole part = RexsRelationRole.create("part");

	/** Relation role "stage". */
	public static final RexsRelationRole stage = RexsRelationRole.create("stage");

	/** Relation role "gear". */
	public static final RexsRelationRole gear = RexsRelationRole.create("gear");

	/** Relation role "gear_1". */
	public static final RexsRelationRole gear_1 = RexsRelationRole.create("gear_1");

	/** Relation role "gear_2". */
	public static final RexsRelationRole gear_2 = RexsRelationRole.create("gear_2");

	/** Relation role "stage_gear_data". */
	public static final RexsRelationRole stage_gear_data = RexsRelationRole.create("stage_gear_data");

	/** Relation role "left". */
	public static final RexsRelationRole left = RexsRelationRole.create("left");

	/** Relation role "right". */
	public static final RexsRelationRole right = RexsRelationRole.create("right");

	/** Relation role "inner_part". */
	public static final RexsRelationRole inner_part = RexsRelationRole.create("inner_part");

	/** Relation role "outer_part". */
	public static final RexsRelationRole outer_part = RexsRelationRole.create("outer_part");

	/** Relation role "side_1". */
	public static final RexsRelationRole side_1 = RexsRelationRole.create("side_1");

	/** Relation role "side_2". */
	public static final RexsRelationRole side_2 = RexsRelationRole.create("side_2");

	/** Relation role "origin". */
	public static final RexsRelationRole origin = RexsRelationRole.create("origin");

	/** Relation role "referenced". */
	public static final RexsRelationRole referenced = RexsRelationRole.create("referenced");

	/** Relation role "planetary_stage". */
	public static final RexsRelationRole planetary_stage = RexsRelationRole.create("planetary_stage");

	/** Relation role "shaft". */
	public static final RexsRelationRole shaft = RexsRelationRole.create("shaft");

	/** Relation role "workpiece". */
	public static final RexsRelationRole workpiece = RexsRelationRole.create("workpiece");

	/** Relation role "tool". */
	public static final RexsRelationRole tool = RexsRelationRole.create("tool");

	/** Relation role "manufacturing_settings". */
	public static final RexsRelationRole manufacturing_settings = RexsRelationRole.create("manufacturing_settings");

	/** Constant for an unknown relation role. */
	public static final RexsRelationRole UNKNOWN = RexsRelationRole.create("unknown");

	
	public static void init() {}
}
