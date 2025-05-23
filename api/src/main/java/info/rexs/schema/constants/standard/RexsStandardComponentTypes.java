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

import info.rexs.schema.constants.RexsComponentType;

/**
 * This class represents the type of a REXS component.
 * <p>
 * It contains constants for all component types of official REXS versions (1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7).
 *
 * @author FVA GmbH
 */
@Generated("REXS-Database by FVA GmbH (see https://database.rexs.info/)")
public interface RexsStandardComponentTypes {

	/** Additional mass (Versions: 1.3, 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType additional_mass = RexsComponentType.create("additional_mass");

	/** Assembly group (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType assembly_group = RexsComponentType.create("assembly_group");

	/** Bearing ring (Versions: 1.6, 1.7) */
	RexsComponentType bearing_ring = RexsComponentType.create("bearing_ring");

	/** Bevel gear (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType bevel_gear = RexsComponentType.create("bevel_gear");

	/** Flank of bevel gear (Versions: 1.3, 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType bevel_gear_flank = RexsComponentType.create("bevel_gear_flank");

	/** Bevel gear manufacturing settings (Versions: 1.3, 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType bevel_gear_manufacturing_settings = RexsComponentType.create("bevel_gear_manufacturing_settings");

	/** Bevel gear tool (Versions: 1.3, 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType bevel_gear_tool = RexsComponentType.create("bevel_gear_tool");

	/** Bevel stage (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType bevel_stage = RexsComponentType.create("bevel_stage");

	/** Bevel stage gear data (Versions: 1.3, 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType bevel_stage_gear_data = RexsComponentType.create("bevel_stage_gear_data");

	/** Concept bearing (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType concept_bearing = RexsComponentType.create("concept_bearing");

	/** Coupling (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType coupling = RexsComponentType.create("coupling");

	/** Cutter wheel tool (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType cutter_wheel_tool = RexsComponentType.create("cutter_wheel_tool");

	/** Cylindrical gear (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType cylindrical_gear = RexsComponentType.create("cylindrical_gear");

	/** Flank of cylindrical gear (Versions: 1.3, 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType cylindrical_gear_flank = RexsComponentType.create("cylindrical_gear_flank");

	/** Cylindrical gear manufacturing settings (Versions: 1.3, 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType cylindrical_gear_manufacturing_settings = RexsComponentType.create("cylindrical_gear_manufacturing_settings");

	/** Cylindrical interference fit (Versions: 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType cylindrical_interference_fit = RexsComponentType.create("cylindrical_interference_fit");

	/** Cylindrical stage (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType cylindrical_stage = RexsComponentType.create("cylindrical_stage");

	/** Cylindrical stage gear data (Versions: 1.3, 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType cylindrical_stage_gear_data = RexsComponentType.create("cylindrical_stage_gear_data");

	/** Element list (Versions: 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType element_list = RexsComponentType.create("element_list");

	/** End relief datum face (Versions: 1.2, 1.3, 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType end_relief_datum_face = RexsComponentType.create("end_relief_datum_face");

	/** End relief non-datum face (Versions: 1.2, 1.3, 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType end_relief_non_datum_face = RexsComponentType.create("end_relief_non_datum_face");

	/** External load (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType external_load = RexsComponentType.create("external_load");

	/** Feather key connection (Versions: 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType feather_key_connection = RexsComponentType.create("feather_key_connection");

	/** FEM data set (Versions: 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType fem_data_set = RexsComponentType.create("fem_data_set");

	/** Non-switchable coupling (Versions: 1.0) */
	RexsComponentType fixed_coupling = RexsComponentType.create("fixed_coupling");

	/** FKM evaluation point (Versions: 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType fkm_evaluation_point = RexsComponentType.create("fkm_evaluation_point");

	/** Tooth flank (Versions: 1.0, 1.1, 1.2) */
	RexsComponentType flank_geometry = RexsComponentType.create("flank_geometry");

	/** Gear body (Versions: 1.6, 1.7) */
	RexsComponentType gear_body = RexsComponentType.create("gear_body");

	/** Gear casing (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType gear_casing = RexsComponentType.create("gear_casing");

	/** Gear flank data of a point list (Versions: 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType gear_flank_data_set = RexsComponentType.create("gear_flank_data_set");

	/** Gear root data of a point list (Versions: 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType gear_root_data_set = RexsComponentType.create("gear_root_data_set");

	/** Gear unit (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType gear_unit = RexsComponentType.create("gear_unit");

	/** General gear (Versions: 1.0) */
	RexsComponentType general_gear = RexsComponentType.create("general_gear");

	/** General stage (Versions: 1.0) */
	RexsComponentType general_stage = RexsComponentType.create("general_stage");

	/** Helix crowning (Versions: 1.2, 1.3, 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType helix_crowning = RexsComponentType.create("helix_crowning");

	/** Helix deviation (Versions: 1.2, 1.3, 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType helix_deviation = RexsComponentType.create("helix_deviation");

	/** Helix slope (Versions: 1.2, 1.3, 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType helix_slope = RexsComponentType.create("helix_slope");

	/** Hydrodynamic radial plain bearing (Versions: 1.6, 1.7) */
	RexsComponentType hydrodynamic_radial_plain_bearing = RexsComponentType.create("hydrodynamic_radial_plain_bearing");

	/** Involute spline connection (Versions: 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType involute_spline_connection = RexsComponentType.create("involute_spline_connection");

	/** Involute spline gear flank (Versions: 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType involute_spline_gear_flank = RexsComponentType.create("involute_spline_gear_flank");

	/** Involute spline gear hub (Versions: 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType involute_spline_gear_hub = RexsComponentType.create("involute_spline_gear_hub");

	/** Involute spline gear shaft (Versions: 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType involute_spline_gear_shaft = RexsComponentType.create("involute_spline_gear_shaft");

	/** Involute spline stage gear data (Versions: 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType involute_spline_stage_gear_data = RexsComponentType.create("involute_spline_stage_gear_data");

	/** Joint section (Versions: 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType joint_section = RexsComponentType.create("joint_section");

	/** Lubricant (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType lubricant = RexsComponentType.create("lubricant");

	/** Material (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType material = RexsComponentType.create("material");

	/** Meshing contact gear data of a point list (Versions: 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType meshing_contact_gear_data_set = RexsComponentType.create("meshing_contact_gear_data_set");

	/** Meshing contact stage data of a point list (Versions: 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType meshing_contact_stage_data_set = RexsComponentType.create("meshing_contact_stage_data_set");

	/** Notch effect of shaft-hub-connection (Versions: 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType notch_effect_shaft_hub_connection = RexsComponentType.create("notch_effect_shaft_hub_connection");

	/** Planetary carrier (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType planet_carrier = RexsComponentType.create("planet_carrier");

	/** Planetary stage (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType planetary_stage = RexsComponentType.create("planetary_stage");

	/** Point list (Versions: 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType point_list = RexsComponentType.create("point_list");

	/** Profile crowning (Versions: 1.2, 1.3, 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType profile_crowning = RexsComponentType.create("profile_crowning");

	/** Profile deviation (Versions: 1.2, 1.3, 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType profile_deviation = RexsComponentType.create("profile_deviation");

	/** Profile slope modification (Versions: 1.2, 1.3, 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType profile_slope = RexsComponentType.create("profile_slope");

	/** Profile twist (Versions: 1.2, 1.3, 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType profile_twist = RexsComponentType.create("profile_twist");

	/** Rack-shaped tool (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType rack_shaped_tool = RexsComponentType.create("rack_shaped_tool");

	/** Plain bearing groove (Versions: 1.6, 1.7) */
	RexsComponentType radial_plain_bearing_groove = RexsComponentType.create("radial_plain_bearing_groove");

	/** Plain bearing hole (Versions: 1.6, 1.7) */
	RexsComponentType radial_plain_bearing_hole = RexsComponentType.create("radial_plain_bearing_hole");

	/** Plain bearing profile (Versions: 1.6, 1.7) */
	RexsComponentType radial_plain_bearing_profile = RexsComponentType.create("radial_plain_bearing_profile");

	/** Plain bearing profile data set (Versions: 1.6, 1.7) */
	RexsComponentType radial_plain_bearing_profile_data_set = RexsComponentType.create("radial_plain_bearing_profile_data_set");

	/** Plain bearing shell (Versions: 1.6, 1.7) */
	RexsComponentType radial_plain_bearing_shell = RexsComponentType.create("radial_plain_bearing_shell");

	/** Plain bearing slot (Versions: 1.6, 1.7) */
	RexsComponentType radial_plain_bearing_slot = RexsComponentType.create("radial_plain_bearing_slot");

	/** Rectangular groove (Versions: 1.3, 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType rectangular_groove = RexsComponentType.create("rectangular_groove");

	/** Reduction point (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType reduction_point = RexsComponentType.create("reduction_point");

	/** Ring gear (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType ring_gear = RexsComponentType.create("ring_gear");

	/** Rolling bearing row (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType rolling_bearing_row = RexsComponentType.create("rolling_bearing_row");

	/** Rolling bearing with catalog data (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType rolling_bearing_with_catalog_geometry = RexsComponentType.create("rolling_bearing_with_catalog_geometry");

	/** Rolling bearing with detailed geometry (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType rolling_bearing_with_detailed_geometry = RexsComponentType.create("rolling_bearing_with_detailed_geometry");

	/** Rolling element (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType rolling_element = RexsComponentType.create("rolling_element");

	/** Rolling element contact (Versions: 1.3, 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType rolling_element_contact = RexsComponentType.create("rolling_element_contact");

	/** Model (Versions: 1.0) */
	RexsComponentType root = RexsComponentType.create("root");

	/** Root relief (Versions: 1.2, 1.3, 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType root_relief = RexsComponentType.create("root_relief");

	/** Round groove (Versions: 1.3, 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType round_groove = RexsComponentType.create("round_groove");

	/** Shaft (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType shaft = RexsComponentType.create("shaft");

	/** Shaft section (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType shaft_section = RexsComponentType.create("shaft_section");

	/** Shaft shoulder (Versions: 1.3, 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType shaft_shoulder = RexsComponentType.create("shaft_shoulder");

	/** Shaft shoulder with undercut (Versions: 1.3, 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType shaft_shoulder_with_undercut = RexsComponentType.create("shaft_shoulder_with_undercut");

	/** Side plate (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType side_plate = RexsComponentType.create("side_plate");

	/** Sleeve (Versions: 1.6, 1.7) */
	RexsComponentType sleeve = RexsComponentType.create("sleeve");

	/** Slide bearing (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType slide_bearing = RexsComponentType.create("slide_bearing");

	/** S/N Curve (Versions: 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType sn_curve = RexsComponentType.create("sn_curve");

	/** Stage gear data (Versions: 1.0, 1.1, 1.2) */
	RexsComponentType stage_gear_data = RexsComponentType.create("stage_gear_data");

	/** Surface contact (Versions: 1.6, 1.7) */
	RexsComponentType surface_contact = RexsComponentType.create("surface_contact");

	/** Switchable coupling (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType switchable_coupling = RexsComponentType.create("switchable_coupling");

	/** Tapered interference fit (Versions: 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType tapered_interference_fit = RexsComponentType.create("tapered_interference_fit");

	/** Tip relief (Versions: 1.2, 1.3, 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType tip_relief = RexsComponentType.create("tip_relief");

	/** Topographical flank modification (Versions: 1.2, 1.3, 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType topographical_modification = RexsComponentType.create("topographical_modification");

	/** Transverse bore (Versions: 1.3, 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType transverse_bore = RexsComponentType.create("transverse_bore");

	/** Triangular root relief (Versions: 1.2, 1.3, 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType triangular_root_relief = RexsComponentType.create("triangular_root_relief");

	/** Triangular tip relief (Versions: 1.2, 1.3, 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType triangular_tip_relief = RexsComponentType.create("triangular_tip_relief");

	/** V-notch (Versions: 1.3, 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType v_notch = RexsComponentType.create("v_notch");

	/** Worm gear (Versions: 1.2, 1.3, 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType worm_gear = RexsComponentType.create("worm_gear");

	/** Flank of worm gear or worm wheel (Versions: 1.3, 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType worm_gear_flank = RexsComponentType.create("worm_gear_flank");

	/** Worm gear and worm wheel manufacturing settings (Versions: 1.3, 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType worm_gear_manufacturing_settings = RexsComponentType.create("worm_gear_manufacturing_settings");

	/** Worm grinding disc (Versions: 1.3, 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType worm_grinding_disc_tool = RexsComponentType.create("worm_grinding_disc_tool");

	/** Worm stage (Versions: 1.2, 1.3, 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType worm_stage = RexsComponentType.create("worm_stage");

	/** Worm stage gear data (Versions: 1.3, 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType worm_stage_gear_data = RexsComponentType.create("worm_stage_gear_data");

	/** Worm wheel (Versions: 1.2, 1.3, 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType worm_wheel = RexsComponentType.create("worm_wheel");

	/** Worm wheel hob (Versions: 1.3, 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType worm_wheel_hob_tool = RexsComponentType.create("worm_wheel_hob_tool");

	/** 0° grinding disk tool (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7) */
	RexsComponentType zero_degree_grinding_disk_tool = RexsComponentType.create("zero_degree_grinding_disk_tool");

	RexsComponentType UNKNOWN = RexsComponentType.create("unknown");

	public static void init() {}
}
