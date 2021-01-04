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

	/** TODO Document me! */
	public static final RexsRelationType assembly = RexsRelationType.create("assembly");

	/** TODO Document me! */
	public static final RexsRelationType ordered_assembly = RexsRelationType.create("ordered_assembly");

	/** TODO Document me! */
	public static final RexsRelationType stage = RexsRelationType.create("stage");

	/** TODO Document me! */
	public static final RexsRelationType stage_gear_data = RexsRelationType.create("stage_gear_data");

	/** TODO Document me! */
	public static final RexsRelationType side = RexsRelationType.create("side");

	/** TODO Document me! */
	public static final RexsRelationType coupling = RexsRelationType.create("coupling");

	/** TODO Document me! */
	public static final RexsRelationType flank = RexsRelationType.create("flank");

	/** TODO Document me! */
	public static final RexsRelationType reference = RexsRelationType.create("reference");

	/** TODO Document me! */
	public static final RexsRelationType ordered_reference = RexsRelationType.create("ordered_reference");

	/** TODO Document me! */
	public static final RexsRelationType planet_shaft = RexsRelationType.create("planet_shaft");

	/** TODO Document me! */
	public static final RexsRelationType central_shaft = RexsRelationType.create("central_shaft");

	/** TODO Document me! */
	public static final RexsRelationType planet_carrier_shaft = RexsRelationType.create("planet_carrier_shaft");

	/** TODO Document me! */
	public static final RexsRelationType planet_pin = RexsRelationType.create("planet_pin");

	/** TODO Document me! */
	public static final RexsRelationType connection = RexsRelationType.create("connection");

	/** TODO Document me! */
	public static final RexsRelationType manufacturing_step = RexsRelationType.create("manufacturing_step");

	public static void init() {}
}
