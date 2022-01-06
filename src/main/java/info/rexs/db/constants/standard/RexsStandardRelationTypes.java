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

import info.rexs.db.constants.RexsRelationType;

/**
 * This enum represents a REXS relation type.
 * <p>
 * It contains values for all relation types of the REXS standard.
 *
 * @author FVA GmbH
 */
public interface RexsStandardRelationTypes {

	/** Relation type "assembly". */
	public static final RexsRelationType assembly = RexsRelationType.create("assembly");

	/** Relation type "ordered_assembly". */
	public static final RexsRelationType ordered_assembly = RexsRelationType.create("ordered_assembly");

	/** Relation type "stage". */
	public static final RexsRelationType stage = RexsRelationType.create("stage");

	/** Relation type "stage_gear_data". */
	public static final RexsRelationType stage_gear_data = RexsRelationType.create("stage_gear_data");

	/** Relation type "side". */
	public static final RexsRelationType side = RexsRelationType.create("side");

	/** Relation type "coupling". */
	public static final RexsRelationType coupling = RexsRelationType.create("coupling");

	/** Relation type "flank". */
	public static final RexsRelationType flank = RexsRelationType.create("flank");

	/** Relation type "reference". */
	public static final RexsRelationType reference = RexsRelationType.create("reference");

	/** Relation type "ordered_reference". */
	public static final RexsRelationType ordered_reference = RexsRelationType.create("ordered_reference");

	/** Relation type "planet_shaft". */
	public static final RexsRelationType planet_shaft = RexsRelationType.create("planet_shaft");

	/** Relation type "central_shaft". */
	public static final RexsRelationType central_shaft = RexsRelationType.create("central_shaft");

	/** Relation type "planet_carrier_shaft". */
	public static final RexsRelationType planet_carrier_shaft = RexsRelationType.create("planet_carrier_shaft");

	/** Relation type "planet_pin". */
	public static final RexsRelationType planet_pin = RexsRelationType.create("planet_pin");

	/** Relation type "connection". */
	public static final RexsRelationType connection = RexsRelationType.create("connection");

	/** Relation type "manufacturing_step". */
	public static final RexsRelationType manufacturing_step = RexsRelationType.create("manufacturing_step");

	/** Constant for an unknown relation type. */
	public static final RexsRelationType UNKNOWN = RexsRelationType.create("unknown");

	public static void init() {}
}
