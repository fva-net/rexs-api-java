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

import info.rexs.db.constants.RexsComponentType;

/**
 * This class represents the type of a REXS component.
 * <p>
 * It contains constants for all component types of official REXS versions (1.0, 1.1, 1.2, 1.3).
 *
 * @author FVA GmbH
 */
public interface RexsStandardComponentTypes {

	/** Additional mass (Versions: 1.3) */
	public static final RexsComponentType additional_mass = RexsComponentType.create("additional_mass");

	/** Assembly group (Versions: 1.1, 1.2, 1.3) */
	public static final RexsComponentType assembly_group = RexsComponentType.create("assembly_group");

	/** Bevel gear (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsComponentType bevel_gear = RexsComponentType.create("bevel_gear");

	/** Flank of bevel gear (Versions: 1.3) */
	public static final RexsComponentType bevel_gear_flank = RexsComponentType.create("bevel_gear_flank");

	/** Bevel gear manufacturing settings (Versions: 1.3) */
	public static final RexsComponentType bevel_gear_manufacturing_settings = RexsComponentType.create("bevel_gear_manufacturing_settings");

	/** Bevel gear tool (Versions: 1.3) */
	public static final RexsComponentType bevel_gear_tool = RexsComponentType.create("bevel_gear_tool");

	/** Bevel stage (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsComponentType bevel_stage = RexsComponentType.create("bevel_stage");

	/** Bevel stage gear data (Versions: 1.3) */
	public static final RexsComponentType bevel_stage_gear_data = RexsComponentType.create("bevel_stage_gear_data");

	/** Concept bearing (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsComponentType concept_bearing = RexsComponentType.create("concept_bearing");

	/** Coupling (Versions: 1.1, 1.2, 1.3) */
	public static final RexsComponentType coupling = RexsComponentType.create("coupling");

	/** Cutter wheel tool (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsComponentType cutter_wheel_tool = RexsComponentType.create("cutter_wheel_tool");

	/** Cylindrical gear (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsComponentType cylindrical_gear = RexsComponentType.create("cylindrical_gear");

	/** Flank of cylindrical gear (Versions: 1.3) */
	public static final RexsComponentType cylindrical_gear_flank = RexsComponentType.create("cylindrical_gear_flank");

	/** Cylindrical gear manufacturing settings (Versions: 1.3) */
	public static final RexsComponentType cylindrical_gear_manufacturing_settings = RexsComponentType.create("cylindrical_gear_manufacturing_settings");

	/** Cylindrical stage (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsComponentType cylindrical_stage = RexsComponentType.create("cylindrical_stage");

	/** Cylindrical stage gear data (Versions: 1.3) */
	public static final RexsComponentType cylindrical_stage_gear_data = RexsComponentType.create("cylindrical_stage_gear_data");

	/** End relief datum face (Versions: 1.2, 1.3) */
	public static final RexsComponentType end_relief_datum_face = RexsComponentType.create("end_relief_datum_face");

	/** End relief non-datum face (Versions: 1.2, 1.3) */
	public static final RexsComponentType end_relief_non_datum_face = RexsComponentType.create("end_relief_non_datum_face");

	/** External load (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsComponentType external_load = RexsComponentType.create("external_load");

	/** Non-switchable coupling (Versions: 1.0) */
	public static final RexsComponentType fixed_coupling = RexsComponentType.create("fixed_coupling");

	/** Tooth flank (Versions: 1.0, 1.1, 1.2) */
	public static final RexsComponentType flank_geometry = RexsComponentType.create("flank_geometry");

	/** Gear casing (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsComponentType gear_casing = RexsComponentType.create("gear_casing");

	/** Gear unit (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsComponentType gear_unit = RexsComponentType.create("gear_unit");

	/** General gear (Versions: 1.0) */
	public static final RexsComponentType general_gear = RexsComponentType.create("general_gear");

	/** General stage (Versions: 1.0) */
	public static final RexsComponentType general_stage = RexsComponentType.create("general_stage");

	/** Helix crowning (Versions: 1.2, 1.3) */
	public static final RexsComponentType helix_crowning = RexsComponentType.create("helix_crowning");

	/** Helix deviation (Versions: 1.2, 1.3) */
	public static final RexsComponentType helix_deviation = RexsComponentType.create("helix_deviation");

	/** Helix slope (Versions: 1.2, 1.3) */
	public static final RexsComponentType helix_slope = RexsComponentType.create("helix_slope");

	/** Lubricant (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsComponentType lubricant = RexsComponentType.create("lubricant");

	/** Material (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsComponentType material = RexsComponentType.create("material");

	/** Planetary carrier (Versions: 1.1, 1.2, 1.3) */
	public static final RexsComponentType planet_carrier = RexsComponentType.create("planet_carrier");

	/** Planetary stage (Versions: 1.1, 1.2, 1.3) */
	public static final RexsComponentType planetary_stage = RexsComponentType.create("planetary_stage");

	/** Profile crowning (Versions: 1.2, 1.3) */
	public static final RexsComponentType profile_crowning = RexsComponentType.create("profile_crowning");

	/** Profile deviation (Versions: 1.2, 1.3) */
	public static final RexsComponentType profile_deviation = RexsComponentType.create("profile_deviation");

	/** Profile slope modification (Versions: 1.2, 1.3) */
	public static final RexsComponentType profile_slope = RexsComponentType.create("profile_slope");

	/** Profile twist (Versions: 1.2, 1.3) */
	public static final RexsComponentType profile_twist = RexsComponentType.create("profile_twist");

	/** Rack-shaped tool (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsComponentType rack_shaped_tool = RexsComponentType.create("rack_shaped_tool");

	/** Rectangular groove (Versions: 1.3) */
	public static final RexsComponentType rectangular_groove = RexsComponentType.create("rectangular_groove");

	/** Reduction point (Versions: 1.1, 1.2, 1.3) */
	public static final RexsComponentType reduction_point = RexsComponentType.create("reduction_point");

	/** Ring gear (Versions: 1.1, 1.2, 1.3) */
	public static final RexsComponentType ring_gear = RexsComponentType.create("ring_gear");

	/** Rolling bearing row (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsComponentType rolling_bearing_row = RexsComponentType.create("rolling_bearing_row");

	/** Rolling bearing with catalog data (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsComponentType rolling_bearing_with_catalog_geometry = RexsComponentType.create("rolling_bearing_with_catalog_geometry");

	/** Rolling bearing with detailed geometry (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsComponentType rolling_bearing_with_detailed_geometry = RexsComponentType.create("rolling_bearing_with_detailed_geometry");

	/** Rolling element (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsComponentType rolling_element = RexsComponentType.create("rolling_element");

	/** Rolling element contact (Versions: 1.3) */
	public static final RexsComponentType rolling_element_contact = RexsComponentType.create("rolling_element_contact");

	/** Model (Versions: 1.0) */
	public static final RexsComponentType root = RexsComponentType.create("root");

	/** Root relief (Versions: 1.2, 1.3) */
	public static final RexsComponentType root_relief = RexsComponentType.create("root_relief");

	/** Round groove (Versions: 1.3) */
	public static final RexsComponentType round_groove = RexsComponentType.create("round_groove");

	/** Shaft (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsComponentType shaft = RexsComponentType.create("shaft");

	/** Shaft section (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsComponentType shaft_section = RexsComponentType.create("shaft_section");

	/** Shaft shoulder (Versions: 1.3) */
	public static final RexsComponentType shaft_shoulder = RexsComponentType.create("shaft_shoulder");

	/** Shaft shoulder with undercut (Versions: 1.3) */
	public static final RexsComponentType shaft_shoulder_with_undercut = RexsComponentType.create("shaft_shoulder_with_undercut");

	/** Side plate (Versions: 1.1, 1.2, 1.3) */
	public static final RexsComponentType side_plate = RexsComponentType.create("side_plate");

	/** Slide bearing (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsComponentType slide_bearing = RexsComponentType.create("slide_bearing");

	/** Stage gear data (Versions: 1.0, 1.1, 1.2) */
	public static final RexsComponentType stage_gear_data = RexsComponentType.create("stage_gear_data");

	/** Switchable coupling (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsComponentType switchable_coupling = RexsComponentType.create("switchable_coupling");

	/** Tip relief (Versions: 1.2, 1.3) */
	public static final RexsComponentType tip_relief = RexsComponentType.create("tip_relief");

	/** Topographical flank modification (Versions: 1.2, 1.3) */
	public static final RexsComponentType topographical_modification = RexsComponentType.create("topographical_modification");

	/** Transverse bore (Versions: 1.3) */
	public static final RexsComponentType transverse_bore = RexsComponentType.create("transverse_bore");

	/** Triangular root relief (Versions: 1.2, 1.3) */
	public static final RexsComponentType triangular_root_relief = RexsComponentType.create("triangular_root_relief");

	/** Triangular tip relief (Versions: 1.2, 1.3) */
	public static final RexsComponentType triangular_tip_relief = RexsComponentType.create("triangular_tip_relief");

	/** V-notch (Versions: 1.3) */
	public static final RexsComponentType v_notch = RexsComponentType.create("v_notch");

	/** Worm gear (Versions: 1.2, 1.3) */
	public static final RexsComponentType worm_gear = RexsComponentType.create("worm_gear");

	/** Flank of worm gear or worm wheel (Versions: 1.3) */
	public static final RexsComponentType worm_gear_flank = RexsComponentType.create("worm_gear_flank");

	/** Worm gear and worm wheel manufacturing settings (Versions: 1.3) */
	public static final RexsComponentType worm_gear_manufacturing_settings = RexsComponentType.create("worm_gear_manufacturing_settings");

	/** Worm grinding disc (Versions: 1.3) */
	public static final RexsComponentType worm_grinding_disc_tool = RexsComponentType.create("worm_grinding_disc_tool");

	/** Worm stage (Versions: 1.2, 1.3) */
	public static final RexsComponentType worm_stage = RexsComponentType.create("worm_stage");

	/** Worm stage gear data (Versions: 1.3) */
	public static final RexsComponentType worm_stage_gear_data = RexsComponentType.create("worm_stage_gear_data");

	/** Worm wheel (Versions: 1.2, 1.3) */
	public static final RexsComponentType worm_wheel = RexsComponentType.create("worm_wheel");

	/** Worm wheel hob (Versions: 1.3) */
	public static final RexsComponentType worm_wheel_hob_tool = RexsComponentType.create("worm_wheel_hob_tool");

	/** 0° grinding disk tool (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsComponentType zero_degree_grinding_disk_tool = RexsComponentType.create("zero_degree_grinding_disk_tool");

	public static final RexsComponentType UNKNOWN = RexsComponentType.create("unknown");

	public static void init() {}
}
