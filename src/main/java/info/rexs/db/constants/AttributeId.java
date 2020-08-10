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
package info.rexs.db.constants;

import java.util.HashMap;
import java.util.Map;

import lombok.EqualsAndHashCode;

/**
 * This class represents the ID of a REXS attribute.
 * <p>
 * It contains constants for all attribute IDs of official REXS versions (1.0, 1.1, 1.2).
 * <p>
 * Since REXS is freely expandable, you can also add your own attribute IDs using the {@link #create(String, UnitId)} method.
 *
 * @author FVA GmbH
 */
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AttributeId {

	/** An internal index with all created attribute IDs (REXS standard and own) for quick access. */
	private static Map<String, AttributeId> allAttributeIds = new HashMap<>();

	/** Acceleration factor according to FVA 341 (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId acceleration_factor_according_fva_341 = create("acceleration_factor_according_fva_341", UnitId.none);

	/** Account for gravity (Versions: 1.1, 1.2) */
	public static final AttributeId account_for_gravity = create("account_for_gravity", UnitId.none);

	/** Account for shear deformation (Versions: 1.1, 1.2) */
	public static final AttributeId account_for_shear_deformation = create("account_for_shear_deformation", UnitId.none);

	/** Tooth tip height (Versions: 1.2) */
	public static final AttributeId addendum_basic_profile = create("addendum_basic_profile", UnitId.mm);

	/** Addendum coefficient of basic profile (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId addendum_coefficient_basic_profile = create("addendum_coefficient_basic_profile", UnitId.none);

	/** Addendum coefficient tool reference profile relative to module (Versions: 1.0, 1.0, 1.1, 1.2) */
	public static final AttributeId addendum_coefficient_reference_profile = create("addendum_coefficient_reference_profile", UnitId.none);

	/** Addendum modification (profile shift) (Versions: 1.2) */
	public static final AttributeId addendum_modification = create("addendum_modification", UnitId.mm);

	/** Addendum modification coefficient (profile shift coefficient) (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId addendum_modification_coefficient = create("addendum_modification_coefficient", UnitId.none);

	/** Addendum modification coefficient (profile shift coefficient) finished gear (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId addendum_modification_coefficient_after_finishing = create("addendum_modification_coefficient_after_finishing", UnitId.none);

	/** Addendum reference profile of tool (Versions: 1.0, 1.0, 1.1, 1.2) */
	public static final AttributeId addendum_reference_profile = create("addendum_reference_profile", UnitId.mm);

	/** All bearing elements are identical (Versions: 1.0) */
	public static final AttributeId all_rolling_elements_are_identical = create("all_rolling_elements_are_identical", UnitId.none);

	/** All bearing rows are identical (Versions: 1.0) */
	public static final AttributeId all_rows_are_identical = create("all_rows_are_identical", UnitId.none);

	/** Relative tilting of the inner ring around the v-axis compared to the outer ring. (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId angular_deflection_in_v = create("angular_deflection_in_v", UnitId.radian);

	/** Relative tilting of the inner ring around the w-axis compared to the outer ring. (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId angular_deflection_in_w = create("angular_deflection_in_w", UnitId.radian);

	/** Angular offset of the mounting position of the outer ring around the v-axis (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId angular_misalignment_around_v_axis = create("angular_misalignment_around_v_axis", UnitId.degree);

	/** Angular offset of the mounting position of the outer ring around the w-axis (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId angular_misalignment_around_w_axis = create("angular_misalignment_around_w_axis", UnitId.degree);

	/** Angular position around u axis (Versions: 1.1, 1.2) */
	public static final AttributeId angular_position_around_u = create("angular_position_around_u", UnitId.degree);

	/** Arithmetic average roughness flank (Versions: 1.2) */
	public static final AttributeId arithmetic_average_roughness_flank = create("arithmetic_average_roughness_flank", UnitId.mum);

	/** Arithmetic average roughness root (Versions: 1.2) */
	public static final AttributeId arithmetic_average_roughness_root = create("arithmetic_average_roughness_root", UnitId.mum);

	/** Averaged peak-to-valley height root (Versions: 1.2) */
	public static final AttributeId averaged_peak_to_valley_height_root = create("averaged_peak_to_valley_height_root", UnitId.mum);

	/** Axial backlash (Versions: 1.0) */
	public static final AttributeId axial_backlash = create("axial_backlash", UnitId.mum);

	/** Axial bearing clearance (before mounting) (Versions: 1.1, 1.2) */
	public static final AttributeId axial_bearing_clearance = create("axial_bearing_clearance", UnitId.mum);

	/** Axial bearing clearance class (before mounting) (Versions: 1.1, 1.2) */
	public static final AttributeId axial_clearance_class = create("axial_clearance_class", UnitId.none);

	/** Relative displacement of the inner ring in the u-direction compared to the outer ring (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId axial_deflection = create("axial_deflection", UnitId.mum);

	/** Axial displacement of gear (Versions: 1.1, 1.2) */
	public static final AttributeId axial_displacement_gear = create("axial_displacement_gear", UnitId.mm);

	/** Axial displacement of pinion (Versions: 1.1, 1.2) */
	public static final AttributeId axial_displacement_pinion = create("axial_displacement_pinion", UnitId.mm);

	/** Axial dynamic load rating (Versions: 1.1, 1.2) */
	public static final AttributeId axial_dynamic_load_rating = create("axial_dynamic_load_rating", UnitId.kilo_newton);

	/** Axial factor (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId axial_factor_y_0 = create("axial_factor_y_0", UnitId.none);

	/** Axial load factor Y1 for F_a/F_r &lt;= e (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId axial_factor_y_1 = create("axial_factor_y_1", UnitId.none);

	/** Axial load factor Y2 for F_a/F_r &gt; e (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId axial_factor_y_2 = create("axial_factor_y_2", UnitId.none);

	/** Axial force in u-direction (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId axial_force = create("axial_force", UnitId.kilo_newton);

	/** Support of axial loads (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId axial_force_absorption = create("axial_force_absorption", UnitId.none);

	/** Support of axial loads (Versions: 1.1, 1.2) */
	public static final AttributeId axial_force_absorption_of_row = create("axial_force_absorption_of_row", UnitId.none);

	/** Axial module (DIN 3975 2017) (Versions: 1.2) */
	public static final AttributeId axial_module_din_3975_2017 = create("axial_module_din_3975_2017", UnitId.mm);

	/** Axial pitch (Versions: 1.1, 1.2) */
	public static final AttributeId axial_pitch = create("axial_pitch", UnitId.mm);

	/** Axial pitch (DIN 3975 2017) (Versions: 1.2) */
	public static final AttributeId axial_pitch_din_3975_2017 = create("axial_pitch_din_3975_2017", UnitId.mm);

	/** Axial static load rating (Versions: 1.1, 1.2) */
	public static final AttributeId axial_static_load_rating = create("axial_static_load_rating", UnitId.kilo_newton);

	/** Axial stiffness (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId axial_stiffness = create("axial_stiffness", UnitId.newton_per_m);

	/** Base circle diameter (Versions: 1.1, 1.2) */
	public static final AttributeId base_circle_diameter = create("base_circle_diameter", UnitId.mm);

	/** Base circle diameter (DIN 3975 2017) (Versions: 1.2) */
	public static final AttributeId base_circle_diameter_din_3975_2017 = create("base_circle_diameter_din_3975_2017", UnitId.mm);

	/** Basic factor according to FVA 341 (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId base_factor_according_fva_341 = create("base_factor_according_fva_341", UnitId.none);

	/** Basic crown gear addendum factor (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId basic_addendum_coefficient = create("basic_addendum_coefficient", UnitId.none);

	/** Basic crown gear dedendum factor (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId basic_dedendum_coefficient = create("basic_dedendum_coefficient", UnitId.none);

	/** Basic strength root (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId basic_strength_root = create("basic_strength_root", UnitId.newton_per_mm2);

	/** Basis of lubricant (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId basis = create("basis", UnitId.none);

	/** Bearing tolerance class (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId bearing_tolerance_class = create("bearing_tolerance_class", UnitId.none);

	/** Bearing type (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId bearing_type = create("bearing_type", UnitId.none);

	/** Tilting stiffness (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId bending_stiffness = create("bending_stiffness", UnitId.newton_mm_per_rad);

	/** Bevel orientation (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId bevel_cone_orientation = create("bevel_cone_orientation", UnitId.none);

	/** Surface roughness of casing bore (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId bore_surface_roughness = create("bore_surface_roughness", UnitId.mum);

	/** Tolerance class of bore in bearing seat (Versions: 1.0) */
	public static final AttributeId boring_tolerance_class = create("boring_tolerance_class", UnitId.none);

	/** Bottom clearance factor (Versions: 1.0, 1.1) */
	public static final AttributeId bottom_clearance_factor = create("bottom_clearance_factor", UnitId.none);

	/** Tolerance class of casing bore (Versions: 1.1, 1.2) */
	public static final AttributeId casing_bore_tolerance_class = create("casing_bore_tolerance_class", UnitId.none);

	/** Outer diameter of casing for the operating clearance calculation (Versions: 1.1, 1.2) */
	public static final AttributeId casing_outer_diameter = create("casing_outer_diameter", UnitId.mm);

	/** Catalogue designation (Versions: 1.1, 1.2) */
	public static final AttributeId catalogue_designation = create("catalogue_designation", UnitId.none);

	/** Catalogue value e (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId catalogue_value_e = create("catalogue_value_e", UnitId.none);

	/** Center distance (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId center_distance = create("center_distance", UnitId.mm);

	/** Din 3964 center distance tolerance field (Versions: 1.1, 1.2) */
	public static final AttributeId center_distance_tolerance_field_din_3964_1980 = create("center_distance_tolerance_field_din_3964_1980", UnitId.none);

	/** Chamfer angle (Versions: 1.0, 1.0, 1.1, 1.2) */
	public static final AttributeId chamfer_angle = create("chamfer_angle", UnitId.degree);

	/** Chamfer at end of tooth (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId chamfer_at_tooth_end = create("chamfer_at_tooth_end", UnitId.mm);

	/** Cordal height (Versions: 1.2) */
	public static final AttributeId chordal_height = create("chordal_height", UnitId.mm);

	/** Chordal tooth thickness lower deviation (Versions: 1.2) */
	public static final AttributeId chordal_tooth_thickness_lower_deviation = create("chordal_tooth_thickness_lower_deviation", UnitId.mm);

	/** Chordal tooth thickness upper deviation (Versions: 1.2) */
	public static final AttributeId chordal_tooth_thickness_upper_deviation = create("chordal_tooth_thickness_upper_deviation", UnitId.mm);

	/** Chordal transverse tooth thickness lower deviation (Versions: 1.2) */
	public static final AttributeId chordal_transverse_tooth_thickness_lower_deviation = create("chordal_transverse_tooth_thickness_lower_deviation", UnitId.mm);

	/** Chordal transverse tooth thickness upper  deviation (Versions: 1.2) */
	public static final AttributeId chordal_transverse_tooth_thickness_upper_deviation = create("chordal_transverse_tooth_thickness_upper_deviation", UnitId.mm);

	/** Bearing clearance class (Versions: 1.0) */
	public static final AttributeId clearance_class = create("clearance_class", UnitId.none);

	/** Common face width (Versions: 1.1, 1.2) */
	public static final AttributeId common_face_width = create("common_face_width", UnitId.mm);

	/** Contamination coefficient (Versions: 1.0) */
	public static final AttributeId contamination_factor_according_to_din_26281 = create("contamination_factor_according_to_din_26281", UnitId.none);

	/** Contamination coefficient according to ISO 281 2007 (Versions: 1.1, 1.2) */
	public static final AttributeId contamination_factor_according_to_iso_281_2007 = create("contamination_factor_according_to_iso_281_2007", UnitId.none);

	/** Deviation factor (measuring piece) (Versions: 1.2) */
	public static final AttributeId conversion_factor = create("conversion_factor", UnitId.none);

	/** Deviation of base tangent length factor (Versions: 1.2) */
	public static final AttributeId conversion_factor_of_backlash_allowance = create("conversion_factor_of_backlash_allowance", UnitId.none);

	/** Coordinate where amount of modification is specified at datum face (Versions: 1.2) */
	public static final AttributeId coordinate_where_helix_crowning_is_specified_datum_face = create("coordinate_where_helix_crowning_is_specified_datum_face", UnitId.mm);

	/** Coordinate where amount of modification is specified at non-datum face (Versions: 1.2) */
	public static final AttributeId coordinate_where_helix_crowning_is_specified_non_datum_face = create("coordinate_where_helix_crowning_is_specified_non_datum_face", UnitId.mm);

	/** Face width coordinates of helix deviations (Versions: 1.2) */
	public static final AttributeId coordinates_of_helix_deviation = create("coordinates_of_helix_deviation", UnitId.mm);

	/** Coordinates  of topographical deviation (Versions: 1.2) */
	public static final AttributeId coordinates_of_topographical_deviation = create("coordinates_of_topographical_deviation", UnitId.mm);

	/** Coordinates  of topographical modification (Versions: 1.2) */
	public static final AttributeId coordinates_of_topographical_modification = create("coordinates_of_topographical_modification", UnitId.mm);

	/** Core hardness Brinell (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId core_hardness_brinell = create("core_hardness_brinell", UnitId.hb);

	/** Core hardness Rockwell (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId core_hardness_rockwell = create("core_hardness_rockwell", UnitId.hrc);

	/** Core hardness Vickers (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId core_hardness_vickers = create("core_hardness_vickers", UnitId.hv);

	/** Crowning of the mating flanks (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId crowning_of_the_mating_flanks = create("crowning_of_the_mating_flanks", UnitId.none);

	/** Cutter module (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId cutter_module = create("cutter_module", UnitId.mm);

	/** Cutter radius (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId cutter_radius = create("cutter_radius", UnitId.mm);

	/** Orientation datum face (Versions: 1.2) */
	public static final AttributeId datum_face_orientation = create("datum_face_orientation", UnitId.none);

	/** Nominal outer diameter of casing (Versions: 1.0) */
	public static final AttributeId decisive_housing_outer_diameter = create("decisive_housing_outer_diameter", UnitId.mm);

	/** Nominal inner diameter of shaft (Versions: 1.0) */
	public static final AttributeId decisive_pin_diameter = create("decisive_pin_diameter", UnitId.mm);

	/** Dedendum coefficient tool reference profile relative to module (Versions: 1.0, 1.0, 1.1, 1.2) */
	public static final AttributeId dedendum_coefficient_reference_profile = create("dedendum_coefficient_reference_profile", UnitId.none);

	/** Dedendum reference profile (Versions: 1.0, 1.0, 1.1, 1.2) */
	public static final AttributeId dedendum_reference_profile = create("dedendum_reference_profile", UnitId.mm);

	/** Shaft defines rotational speed (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId defines_speed = create("defines_speed", UnitId.none);

	/** External load defines torque (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId defines_torque = create("defines_torque", UnitId.none);

	/** Deflection (DIN 3996 2019) (Versions: 1.2) */
	public static final AttributeId deflection_din_3996_2019 = create("deflection_din_3996_2019", UnitId.mm);

	/** Density (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId density = create("density", UnitId.kg_per_dm3);

	/** Density at 15&deg;C (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId density_at_15_degree_celsius = create("density_at_15_degree_celsius", UnitId.kg_per_dm3);

	/** Depth of immersion of bearing into oil (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId depth_of_immersion_in_oil = create("depth_of_immersion_in_oil", UnitId.mm);

	/** Description how datum face is defined (Versions: 1.2) */
	public static final AttributeId description_datum_face = create("description_datum_face", UnitId.none);

	/** Deviation of hypoid offset (Versions: 1.1, 1.2) */
	public static final AttributeId deviation_of_offset = create("deviation_of_offset", UnitId.mm);

	/** Deviation of shaft angle (Versions: 1.1, 1.2) */
	public static final AttributeId deviation_of_shaft_angle = create("deviation_of_shaft_angle", UnitId.degree);

	/** Figure number for contamination coefficient in DIN 26281 (Versions: 1.0) */
	public static final AttributeId diagram_number_in_din_26281 = create("diagram_number_in_din_26281", UnitId.none);

	/** Figure number for contamination coefficient e_C in ISO 281 2007 (Versions: 1.1, 1.2) */
	public static final AttributeId diagram_number_in_iso_281_2007 = create("diagram_number_in_iso_281_2007", UnitId.none);

	/** Diameters of helix deviations (Versions: 1.2) */
	public static final AttributeId diameter_of_helix_deviation = create("diameter_of_helix_deviation", UnitId.mm);

	/** Diameter of helix modification (Versions: 1.2) */
	public static final AttributeId diameter_of_helix_modification = create("diameter_of_helix_modification", UnitId.mm);

	/** Measuring ball or pin diameter (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId diameter_of_measuring_ball_or_pin = create("diameter_of_measuring_ball_or_pin", UnitId.mm);

	/** Diameter of rolling element (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId diameter_of_rolling_element = create("diameter_of_rolling_element", UnitId.mm);

	/** Diameter where amount of profile crowning at the root is specified (Versions: 1.2) */
	public static final AttributeId diameter_where_profile_crowning_root_is_specified = create("diameter_where_profile_crowning_root_is_specified", UnitId.mm);

	/** Diameter where amount of profile crowning at the tip is specified (Versions: 1.2) */
	public static final AttributeId diameter_where_profile_crowning_tip_is_specified = create("diameter_where_profile_crowning_tip_is_specified", UnitId.mm);

	/** Diameter where amount of modification is specified (Versions: 1.2) */
	public static final AttributeId diameter_where_profile_slope_amount_is_specified = create("diameter_where_profile_slope_amount_is_specified", UnitId.mm);

	/** Diameter where amount of profile twist is specified (Versions: 1.2) */
	public static final AttributeId diameter_where_profile_twist_amount_is_specified = create("diameter_where_profile_twist_amount_is_specified", UnitId.mm);

	/** Diameters of profile deviations (Versions: 1.2) */
	public static final AttributeId diameters_of_profile_deviation = create("diameters_of_profile_deviation", UnitId.mm);

	/** Diameters  of topographical deviation (Versions: 1.2) */
	public static final AttributeId diameters_of_topographical_deviation = create("diameters_of_topographical_deviation", UnitId.mm);

	/** Diameters  of topographical modification (Versions: 1.2) */
	public static final AttributeId diameters_of_topographical_modification = create("diameters_of_topographical_modification", UnitId.mm);

	/** Diametral measurement (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId diametral_measurement = create("diametral_measurement", UnitId.mm);

	/** Din 3964 center distance tolerance field (Versions: 1.0) */
	public static final AttributeId din_3964_center_distance_tolerance_field = create("din_3964_center_distance_tolerance_field", UnitId.none);

	/** DIN 3967 Deviation-tolerance series (Versions: 1.0) */
	public static final AttributeId din_3967_deviation_tolerance_series = create("din_3967_deviation_tolerance_series", UnitId.none);

	/** Direction vector of gravity u-coordinate (Versions: 1.1, 1.2) */
	public static final AttributeId direction_vector_gravity_u = create("direction_vector_gravity_u", UnitId.none);

	/** Direction vector of gravity v-coordinate (Versions: 1.1, 1.2) */
	public static final AttributeId direction_vector_gravity_v = create("direction_vector_gravity_v", UnitId.none);

	/** Direction vector of gravity w-coordinate (Versions: 1.1, 1.2) */
	public static final AttributeId direction_vector_gravity_w = create("direction_vector_gravity_w", UnitId.none);

	/** Displacement in u direction at inner side (Versions: 1.1, 1.2) */
	public static final AttributeId displacement_inner_side_u = create("displacement_inner_side_u", UnitId.mum);

	/** Displacement in v direction at inner side (Versions: 1.1, 1.2) */
	public static final AttributeId displacement_inner_side_v = create("displacement_inner_side_v", UnitId.mum);

	/** Displacement in w direction at inner side (Versions: 1.1, 1.2) */
	public static final AttributeId displacement_inner_side_w = create("displacement_inner_side_w", UnitId.mum);

	/** Displacement in u direction at outer side (Versions: 1.1, 1.2) */
	public static final AttributeId displacement_outer_side_u = create("displacement_outer_side_u", UnitId.mum);

	/** Displacement in v direction at outer side (Versions: 1.1, 1.2) */
	public static final AttributeId displacement_outer_side_v = create("displacement_outer_side_v", UnitId.mum);

	/** Displacement in w direction at outer side (Versions: 1.1, 1.2) */
	public static final AttributeId displacement_outer_side_w = create("displacement_outer_side_w", UnitId.mum);

	/** Displacement in u direction (Versions: 1.1, 1.2) */
	public static final AttributeId displacement_u = create("displacement_u", UnitId.mum);

	/** Axial displacement in u direction (Versions: 1.1, 1.2) */
	public static final AttributeId displacement_u_of_nodes = create("displacement_u_of_nodes", UnitId.mum);

	/** Displacement in v direction (Versions: 1.1, 1.2) */
	public static final AttributeId displacement_v = create("displacement_v", UnitId.mum);

	/** Radial displacement in v-direction (Versions: 1.1, 1.2) */
	public static final AttributeId displacement_v_of_nodes = create("displacement_v_of_nodes", UnitId.mum);

	/** Displacement in w direction (Versions: 1.1, 1.2) */
	public static final AttributeId displacement_w = create("displacement_w", UnitId.mum);

	/** Radial displacement in w-direction (Versions: 1.1, 1.2) */
	public static final AttributeId displacement_w_of_nodes = create("displacement_w_of_nodes", UnitId.mum);

	/** Distance between bearing rows (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId distance_between_bearing_rows = create("distance_between_bearing_rows", UnitId.mm);

	/** Distance from datum line to measuring line (Versions: 1.2) */
	public static final AttributeId distance_tool_profile_basic_line_to_measuring_line = create("distance_tool_profile_basic_line_to_measuring_line", UnitId.mm);

	/** Distance of tool tip line to manufacturing pitch circle (Versions: 1.2) */
	public static final AttributeId distance_tool_tip_line_to_manufacturing_pitch_diameter = create("distance_tool_tip_line_to_manufacturing_pitch_diameter", UnitId.mm);

	/** Dynamic load rating (Versions: 1.0) */
	public static final AttributeId dynamic_capacity = create("dynamic_capacity", UnitId.kilo_newton);

	/** Effective pressure angle on coast side (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId effective_pressure_angle_coast = create("effective_pressure_angle_coast", UnitId.degree);

	/** Effective pressure angle on drive side (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId effective_pressure_angle_drive = create("effective_pressure_angle_drive", UnitId.degree);

	/** Elastic modulus (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId elastic_modulus = create("elastic_modulus", UnitId.newton_per_mm2);

	/** Length of end of tangential transition (Versions: 1.2) */
	public static final AttributeId end_relief_datum_face_length_of_tangential_transition_end = create("end_relief_datum_face_length_of_tangential_transition_end", UnitId.mm);

	/** Length of start of tangential transition (Versions: 1.2) */
	public static final AttributeId end_relief_datum_face_length_of_tangential_transition_start = create("end_relief_datum_face_length_of_tangential_transition_start", UnitId.mm);

	/** Depth of end relief (Versions: 1.2) */
	public static final AttributeId end_relief_depth_datum_face = create("end_relief_depth_datum_face", UnitId.mm);

	/** Depth of end relief (Versions: 1.2) */
	public static final AttributeId end_relief_depth_non_datum_face = create("end_relief_depth_non_datum_face", UnitId.mm);

	/** Coordinate where amount of modification is specified (Versions: 1.2) */
	public static final AttributeId end_relief_evaluation_reference_datum_face = create("end_relief_evaluation_reference_datum_face", UnitId.mm);

	/** Coordinate where amount of modification is specified (Versions: 1.2) */
	public static final AttributeId end_relief_evaluation_reference_non_datum_face = create("end_relief_evaluation_reference_non_datum_face", UnitId.mm);

	/** Length of end relief (Versions: 1.2) */
	public static final AttributeId end_relief_length_datum_face = create("end_relief_length_datum_face", UnitId.mm);

	/** Length of end relief (Versions: 1.2) */
	public static final AttributeId end_relief_length_non_datum_face = create("end_relief_length_non_datum_face", UnitId.mm);

	/** Length of end of tangential transition (Versions: 1.2) */
	public static final AttributeId end_relief_non_datum_face_length_of_tangential_transition_end = create("end_relief_non_datum_face_length_of_tangential_transition_end", UnitId.mm);

	/** Length of start of tangential transition (Versions: 1.2) */
	public static final AttributeId end_relief_non_datum_face_length_of_tangential_transition_start = create("end_relief_non_datum_face_length_of_tangential_transition_start", UnitId.mm);

	/** Endurance limit flank (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId endurance_limit_flank = create("endurance_limit_flank", UnitId.newton_per_mm2);

	/** Endurance limit root (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId endurance_limit_root = create("endurance_limit_root", UnitId.newton_per_mm2);

	/** Equivalent dynamic bearing load din iso 281 (Versions: 1.0) */
	public static final AttributeId equivalent_dynamic_bearing_load_din_iso_281 = create("equivalent_dynamic_bearing_load_din_iso_281", UnitId.kilo_newton);

	/** Equivalent dynamic bearing load iso 281 2007 (Versions: 1.1, 1.2) */
	public static final AttributeId equivalent_dynamic_bearing_load_iso_281_2007 = create("equivalent_dynamic_bearing_load_iso_281_2007", UnitId.kilo_newton);

	/** Face angle (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId face_angle = create("face_angle", UnitId.degree);

	/** Face apex beyond crossing point (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId face_apex_beyond_crossing_point = create("face_apex_beyond_crossing_point", UnitId.mm);

	/** Face load factor flank (Versions: 1.1, 1.2) */
	public static final AttributeId face_load_factor_flank = create("face_load_factor_flank", UnitId.none);

	/** Face load factor root (Versions: 1.1, 1.2) */
	public static final AttributeId face_load_factor_root = create("face_load_factor_root", UnitId.none);

	/** Face width (Versions: 1.0, 1.0, 1.1, 1.2) */
	public static final AttributeId face_width = create("face_width", UnitId.mm);

	/** Face width (DIN 3975 2017) (Versions: 1.2) */
	public static final AttributeId face_width_din_3975_2017 = create("face_width_din_3975_2017", UnitId.mm);

	/** End of usable face width (Versions: 1.2) */
	public static final AttributeId facewidth_usable_end = create("facewidth_usable_end", UnitId.mm);

	/** Start of usable face width (Versions: 1.2) */
	public static final AttributeId facewidth_usable_start = create("facewidth_usable_start", UnitId.mm);

	/** Fatigue limit under reversed bending stress (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId fatigue_limit_bending = create("fatigue_limit_bending", UnitId.mega_pascal);

	/** Compression-tension fatigue limit (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId fatigue_limit_compression_tension = create("fatigue_limit_compression_tension", UnitId.mega_pascal);

	/** Fatigue limit load (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId fatigue_limit_load = create("fatigue_limit_load", UnitId.kilo_newton);

	/** Fatigue limit under reversed torsional stress (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId fatigue_limit_torsion = create("fatigue_limit_torsion", UnitId.mega_pascal);

	/** FEM format used (Versions: 1.1, 1.2) */
	public static final AttributeId fem_file_format = create("fem_file_format", UnitId.none);

	/** Flag designation addendum modification (profile shift) (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId flag_designation_addendum_modification = create("flag_designation_addendum_modification", UnitId.none);

	/** Flank form (DIN 3975 2017) (Versions: 1.2) */
	public static final AttributeId flank_form_din_3975_2017 = create("flank_form_din_3975_2017", UnitId.none);

	/** Flank surface (DIN 3996 2019) (Versions: 1.2) */
	public static final AttributeId flank_surface_din_3996_2019 = create("flank_surface_din_3996_2019", UnitId.mm2);

	/** Folder name (Versions: 1.1, 1.2) */
	public static final AttributeId folder = create("folder", UnitId.none);

	/** Force in u-direction acting on the component on the inner side (Versions: 1.1, 1.2) */
	public static final AttributeId force_acting_on_inner_component_u = create("force_acting_on_inner_component_u", UnitId.newton);

	/** Force in v-direction acting on the component on the inner side (Versions: 1.1, 1.2) */
	public static final AttributeId force_acting_on_inner_component_v = create("force_acting_on_inner_component_v", UnitId.newton);

	/** Force in w-direction acting on the component on the inner side (Versions: 1.1, 1.2) */
	public static final AttributeId force_acting_on_inner_component_w = create("force_acting_on_inner_component_w", UnitId.newton);

	/** Force in u-direction acting on the component on the outer side (Versions: 1.1, 1.2) */
	public static final AttributeId force_acting_on_outer_component_u = create("force_acting_on_outer_component_u", UnitId.newton);

	/** Force in v-direction acting on the component on the outer side (Versions: 1.1, 1.2) */
	public static final AttributeId force_acting_on_outer_component_v = create("force_acting_on_outer_component_v", UnitId.newton);

	/** Force in w-direction acting on the component on the outer side (Versions: 1.1, 1.2) */
	public static final AttributeId force_acting_on_outer_component_w = create("force_acting_on_outer_component_w", UnitId.newton);

	/** Force in u-direction acting on the shaft (Versions: 1.1, 1.2) */
	public static final AttributeId force_acting_on_shaft_u = create("force_acting_on_shaft_u", UnitId.newton);

	/** Force in v-direction acting on the shaft (Versions: 1.1, 1.2) */
	public static final AttributeId force_acting_on_shaft_v = create("force_acting_on_shaft_v", UnitId.newton);

	/** Force in w-direction acting on the shaft (Versions: 1.1, 1.2) */
	public static final AttributeId force_acting_on_shaft_w = create("force_acting_on_shaft_w", UnitId.newton);

	/** Axial force distribution in u-direction (Versions: 1.1, 1.2) */
	public static final AttributeId force_distribution_u = create("force_distribution_u", UnitId.newton);

	/** Radial force distribution in v-direction (Versions: 1.1, 1.2) */
	public static final AttributeId force_distribution_v = create("force_distribution_v", UnitId.newton);

	/** Radial force distribution in w-direction (Versions: 1.1, 1.2) */
	public static final AttributeId force_distribution_w = create("force_distribution_w", UnitId.newton);

	/** Force in u-direction (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId force_u_direction = create("force_u_direction", UnitId.newton);

	/** Force in v-direction (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId force_v_direction = create("force_v_direction", UnitId.newton);

	/** Force in w-direction (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId force_w_direction = create("force_w_direction", UnitId.newton);

	/** Form allowance (Versions: 1.2) */
	public static final AttributeId form_allowance = create("form_allowance", UnitId.mm);

	/** Form factor (DIN 3975 2017) (Versions: 1.2) */
	public static final AttributeId form_factor_din_3975_2017 = create("form_factor_din_3975_2017", UnitId.none);

	/** Gear ratio (Versions: 1.1, 1.2) */
	public static final AttributeId gear_ratio = create("gear_ratio", UnitId.none);

	/** Gear shift index (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId gear_shift_index = create("gear_shift_index", UnitId.none);

	/** Generated addendum modification coefficient (profile shift coefficient) (Versions: 1.1, 1.2) */
	public static final AttributeId generated_addendum_modification_coefficient = create("generated_addendum_modification_coefficient", UnitId.none);

	/** Generated pressure angle on coast side (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId generated_pressure_angle_coast = create("generated_pressure_angle_coast", UnitId.degree);

	/** Generated pressure angle on drive side (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId generated_pressure_angle_drive = create("generated_pressure_angle_drive", UnitId.degree);

	/** Geometry refers to (Versions: 1.0) */
	public static final AttributeId geometry_refers_to = create("geometry_refers_to", UnitId.none);

	/** Gravitational acceleration (Versions: 1.1, 1.2) */
	public static final AttributeId gravitational_acceleration = create("gravitational_acceleration", UnitId.m_per_s2);

	/** Grinding allowance (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId grinding_allowance = create("grinding_allowance", UnitId.mm);

	/** Bearing has an inner ring (Versions: 1.1, 1.2) */
	public static final AttributeId has_inner_ring = create("has_inner_ring", UnitId.none);

	/** Bearing has an outer ring (Versions: 1.1, 1.2) */
	public static final AttributeId has_outer_ring = create("has_outer_ring", UnitId.none);

	/** Heat transfer coefficient at the surface of the bearing seat (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId heat_transfer_coefficient_at_bearing_seat = create("heat_transfer_coefficient_at_bearing_seat", UnitId.watt_per_mm);

	/** Height over chordal tooth thickness (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId height_over_chordal_tooth_thickness = create("height_over_chordal_tooth_thickness", UnitId.mm);

	/** Helix angle at the base circle (Versions: 1.1, 1.2) */
	public static final AttributeId helix_angle_base_circle = create("helix_angle_base_circle", UnitId.degree);

	/** Helix angle at reference circle (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId helix_angle_reference_diameter = create("helix_angle_reference_diameter", UnitId.degree);

	/** Amount of helix crowning at datum face (Versions: 1.2) */
	public static final AttributeId helix_crowning_amount_datum_face = create("helix_crowning_amount_datum_face", UnitId.mm);

	/** Amount of helix crowning at non-datum face (Versions: 1.2) */
	public static final AttributeId helix_crowning_amount_non_datum_face = create("helix_crowning_amount_non_datum_face", UnitId.mm);

	/** Amount of helix deviations (Versions: 1.2) */
	public static final AttributeId helix_deviation_amounts = create("helix_deviation_amounts", UnitId.mm);

	/** End of helix evaluation (Versions: 1.2) */
	public static final AttributeId helix_evaluation_end = create("helix_evaluation_end", UnitId.mm);

	/** Reference length of helix modification (Versions: 1.2) */
	public static final AttributeId helix_evaluation_reference = create("helix_evaluation_reference", UnitId.none);

	/** Begin of helix evaluation (Versions: 1.2) */
	public static final AttributeId helix_evaluation_start = create("helix_evaluation_start", UnitId.mm);

	/** Location of the highest point in the helix crowning (Versions: 1.2) */
	public static final AttributeId helix_highest_point = create("helix_highest_point", UnitId.mm);

	/** Amount of helix slope modification (Versions: 1.2) */
	public static final AttributeId helix_slope = create("helix_slope", UnitId.mm);

	/** Hypoid offset (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId hypoid_offset = create("hypoid_offset", UnitId.mm);

	/** Preload force (Versions: 1.0) */
	public static final AttributeId initial_load = create("initial_load", UnitId.newton);

	/** Preload distance (Versions: 1.0) */
	public static final AttributeId initial_load_shift = create("initial_load_shift", UnitId.mum);

	/** Inner cone distance (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId inner_cone_distance = create("inner_cone_distance", UnitId.mm);

	/** Inner diameter (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId inner_diameter = create("inner_diameter", UnitId.mm);

	/** Inner diameter begin (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId inner_diameter_begin = create("inner_diameter_begin", UnitId.mm);

	/** Inner diameter end (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId inner_diameter_end = create("inner_diameter_end", UnitId.mm);

	/** Inner pitch diameter (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId inner_pitch_diameter = create("inner_pitch_diameter", UnitId.mm);

	/** Modification is additive (Versions: 1.2) */
	public static final AttributeId is_additive_modification = create("is_additive_modification", UnitId.none);

	/** Is driving gear (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId is_driving_gear = create("is_driving_gear", UnitId.none);

	/** Is engaged (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId is_engaged = create("is_engaged", UnitId.none);

	/** Kind of lubricant (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId kind = create("kind", UnitId.none);

	/** Lead (DIN 3975 2017) (Versions: 1.2) */
	public static final AttributeId lead_din_3975_2017 = create("lead_din_3975_2017", UnitId.mm);

	/** Length (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId length = create("length", UnitId.mm);

	/** Length of profile deviations (Versions: 1.2) */
	public static final AttributeId length_of_profile_deviation = create("length_of_profile_deviation", UnitId.mm);

	/** Length of rolling element (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId length_of_rolling_element = create("length_of_rolling_element", UnitId.mm);

	/** Length  of topographical modification (Versions: 1.2) */
	public static final AttributeId length_of_topographical_modification = create("length_of_topographical_modification", UnitId.mm);

	/** Length where amount of profile crowning at the rootis specified (Versions: 1.2) */
	public static final AttributeId length_where_profile_crowning_root_is_specified = create("length_where_profile_crowning_root_is_specified", UnitId.mm);

	/** Length where amount of profile crowning at the tip is specified (Versions: 1.2) */
	public static final AttributeId length_where_profile_crowning_tip_is_specified = create("length_where_profile_crowning_tip_is_specified", UnitId.mm);

	/** Lever of axial force on cylindrical roller bearings (Versions: 1.0) */
	public static final AttributeId lever_arm_of_axial_force = create("lever_arm_of_axial_force", UnitId.none);

	/** Limiting speed (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId limiting_speed = create("limiting_speed", UnitId.rotation_per_min);

	/** Limiting value of flank loss (DIN 3996 2019) (Versions: 1.2) */
	public static final AttributeId limiting_value_flank_loss_din_3996_2019 = create("limiting_value_flank_loss_din_3996_2019", UnitId.mm);

	/** Load angle at tip (Versions: 1.1, 1.2) */
	public static final AttributeId load_angle_at_tip = create("load_angle_at_tip", UnitId.degree);

	/** Load distribution along common face width (Versions: 1.1, 1.2) */
	public static final AttributeId load_distribution_along_face_width = create("load_distribution_along_face_width", UnitId.newton);

	/** Node positions of load distribution along common face width (Versions: 1.1, 1.2) */
	public static final AttributeId load_distribution_node_positions = create("load_distribution_node_positions", UnitId.mm);

	/** Load duration (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId load_duration = create("load_duration", UnitId.hour);

	/** Load duration fraction (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId load_duration_fraction = create("load_duration_fraction", UnitId.percent);

	/** Loaded tooth flank (Versions: 1.1, 1.2) */
	public static final AttributeId loaded_tooth_flank = create("loaded_tooth_flank", UnitId.none);

	/** Lower diametric deviation (Versions: 1.2) */
	public static final AttributeId lower_backlash_allowance_balls_or_pins = create("lower_backlash_allowance_balls_or_pins", UnitId.mm);

	/** Lower base tangent length deviation (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId lower_backlash_allowance_referenced_to_span = create("lower_backlash_allowance_referenced_to_span", UnitId.mum);

	/** Lower centre distance allowance (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId lower_center_distance_allowance = create("lower_center_distance_allowance", UnitId.mum);

	/** Oil volume flow rate through bearing (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId lubricant_flow_through_bearing = create("lubricant_flow_through_bearing", UnitId.litre_per_minute);

	/** Difference of oil temperatures between outflow and feed (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId lubricant_temperature_difference_inlet_output = create("lubricant_temperature_difference_inlet_output", UnitId.kelvin);

	/** Coefficient for lubrication method (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId lubrication_factor = create("lubrication_factor", UnitId.none);

	/** Kind of lubrication (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId lubrication_type = create("lubrication_type", UnitId.none);

	/** Lubrication type (DIN 3996 2019) (Versions: 1.2) */
	public static final AttributeId lubrication_type_din_3996_2019 = create("lubrication_type_din_3996_2019", UnitId.none);

	/** Machining allowance (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId machining_allowance = create("machining_allowance", UnitId.mm);

	/** Machining allowance tolerance (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId machining_allowance_tolerance = create("machining_allowance_tolerance", UnitId.mm);

	/** Manufacturer (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId manufacturer = create("manufacturer", UnitId.none);

	/** Material designation (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId material_designation = create("material_designation", UnitId.none);

	/** Material loss (DIN 3996 2019) (Versions: 1.2) */
	public static final AttributeId material_loss_din_3996_2019 = create("material_loss_din_3996_2019", UnitId.mg);

	/** Material loss limit (DIN 3996 2019) (Versions: 1.2) */
	public static final AttributeId material_loss_limit_din_3996_2019 = create("material_loss_limit_din_3996_2019", UnitId.mg);

	/** Permissible pressure in the bearing (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId maximum_allowable_pressure = create("maximum_allowable_pressure", UnitId.mega_pascal);

	/** Maximum axial bearing clearance (before mounting) (Versions: 1.1, 1.2) */
	public static final AttributeId maximum_axial_bearing_clearance = create("maximum_axial_bearing_clearance", UnitId.mum);

	/** Maximum diameter of bearing bore (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId maximum_bearing_bore_diameter = create("maximum_bearing_bore_diameter", UnitId.mm);

	/** Maximum bearing play (Versions: 1.0) */
	public static final AttributeId maximum_bearing_clearance = create("maximum_bearing_clearance", UnitId.mum);

	/** Maximum bearing outer diameter (Versions: 1.1, 1.2) */
	public static final AttributeId maximum_bearing_outer_diameter = create("maximum_bearing_outer_diameter", UnitId.mm);

	/** Maximum bearing seat diameter (Versions: 1.0) */
	public static final AttributeId maximum_bore_diameter = create("maximum_bore_diameter", UnitId.mm);

	/** Maximum diameter of casing bore (Versions: 1.1, 1.2) */
	public static final AttributeId maximum_casing_bore_diameter = create("maximum_casing_bore_diameter", UnitId.mm);

	/** Maximum normal backlash (Versions: 1.2) */
	public static final AttributeId maximum_normal_backlash = create("maximum_normal_backlash", UnitId.mm);

	/** Upper normal backlash variation (Versions: 1.2) */
	public static final AttributeId maximum_normal_backlash_variation = create("maximum_normal_backlash_variation", UnitId.mm);

	/** Maximum bearing outer diameter (Versions: 1.0) */
	public static final AttributeId maximum_outer_diameter = create("maximum_outer_diameter", UnitId.mm);

	/** Maximum shaft diameter (Versions: 1.0) */
	public static final AttributeId maximum_pin_diameter = create("maximum_pin_diameter", UnitId.mm);

	/** Maximum radial bearing clearance (before mounting) (Versions: 1.1, 1.2) */
	public static final AttributeId maximum_radial_bearing_clearance = create("maximum_radial_bearing_clearance", UnitId.mum);

	/** Maximum shaft diameter (Versions: 1.1, 1.2) */
	public static final AttributeId maximum_shaft_diameter = create("maximum_shaft_diameter", UnitId.mm);

	/** Maximum transverse backlash (Versions: 1.2) */
	public static final AttributeId maximum_transverse_backlash = create("maximum_transverse_backlash", UnitId.mm);

	/** Upper backlash variation in transverse section (Versions: 1.2) */
	public static final AttributeId maximum_transverse_backlash_variation = create("maximum_transverse_backlash_variation", UnitId.mm);

	/** Mean addendum (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId mean_addendum = create("mean_addendum", UnitId.mm);

	/** Mean cone distance (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId mean_cone_distance = create("mean_cone_distance", UnitId.mm);

	/** Mean dedendum (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId mean_dedendum = create("mean_dedendum", UnitId.mm);

	/** Mean hertzian stress (DIN 3996 2019) (Versions: 1.2) */
	public static final AttributeId mean_hertzian_stress_din_3996_2019 = create("mean_hertzian_stress_din_3996_2019", UnitId.newton_per_mm2);

	/** Mean minimum lubricant film thickness for wear (DIN 3996 2019) (Versions: 1.2) */
	public static final AttributeId mean_minimum_lubricant_film_thickness_din_3996_2019 = create("mean_minimum_lubricant_film_thickness_din_3996_2019", UnitId.mum);

	/** Mean normal chordal tooth thickness (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId mean_normal_chordal_thickness = create("mean_normal_chordal_thickness", UnitId.mm);

	/** Mean normal circular tooth thickness (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId mean_normal_circular_thickness = create("mean_normal_circular_thickness", UnitId.mm);

	/** Mean normal module (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId mean_normal_module = create("mean_normal_module", UnitId.mm);

	/** Mean normal topland (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId mean_normal_topland = create("mean_normal_topland", UnitId.mm);

	/** Mean operating temperature (Versions: 1.1, 1.2) */
	public static final AttributeId mean_operating_temperature = create("mean_operating_temperature", UnitId.degree_celsius);

	/** Mean operating temperature of inner ring (Versions: 1.1, 1.2) */
	public static final AttributeId mean_operating_temperature_inner_ring = create("mean_operating_temperature_inner_ring", UnitId.degree_celsius);

	/** Mean operating temperature of outer ring (Versions: 1.1, 1.2) */
	public static final AttributeId mean_operating_temperature_outer_ring = create("mean_operating_temperature_outer_ring", UnitId.degree_celsius);

	/** Mean pitch cone diameter (Versions: 1.1) */
	public static final AttributeId mean_pitch_cone_diameter = create("mean_pitch_cone_diameter", UnitId.mm);

	/** Mean pitch diameter (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId mean_pitch_diameter = create("mean_pitch_diameter", UnitId.mm);

	/** Mean sliding path (DIN 3996 2019) (Versions: 1.2) */
	public static final AttributeId mean_sliding_path_din_3996_2019 = create("mean_sliding_path_din_3996_2019", UnitId.mm);

	/** Mean spiral angle (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId mean_spiral_angle = create("mean_spiral_angle", UnitId.degree);

	/** Mean tooth root thickness (DIN 3996 2019) (Versions: 1.2) */
	public static final AttributeId mean_tooth_root_thickness_din_3996_2019 = create("mean_tooth_root_thickness_din_3996_2019", UnitId.mm);

	/** Mean transverse circular thickness (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId mean_transverse_circular_thickness = create("mean_transverse_circular_thickness", UnitId.mm);

	/** Measurement b_z0 of the tool (Versions: 1.2) */
	public static final AttributeId measurement_bz0 = create("measurement_bz0", UnitId.mm);

	/** Measuring diameter root undercut (Versions: 1.2) */
	public static final AttributeId measuring_diameter_at_undercut = create("measuring_diameter_at_undercut", UnitId.mm);

	/** Contact circle diameter (upper deviation) (Versions: 1.2) */
	public static final AttributeId measuring_diameter_at_upper_backlash_allowance = create("measuring_diameter_at_upper_backlash_allowance", UnitId.mm);

	/** Contact circle diameter (ball/flank) (Versions: 1.2) */
	public static final AttributeId measuring_diameter_ball_flank = create("measuring_diameter_ball_flank", UnitId.mm);

	/** Contact circle diameter for span measurement (Versions: 1.2) */
	public static final AttributeId measuring_diameter_for_span = create("measuring_diameter_for_span", UnitId.mm);

	/** Mesh stiffness for load distribution along face width (Versions: 1.1, 1.2) */
	public static final AttributeId mesh_stiffness_for_load_distribution_along_face_width = create("mesh_stiffness_for_load_distribution_along_face_width", UnitId.newton_per_mm_mum);

	/** Minimum axial bearing clearance (before mounting) (Versions: 1.1, 1.2) */
	public static final AttributeId minimum_axial_bearing_clearance = create("minimum_axial_bearing_clearance", UnitId.mum);

	/** Minimum diameter of bearing bore (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId minimum_bearing_bore_diameter = create("minimum_bearing_bore_diameter", UnitId.mm);

	/** Minimum bearing clearance (Versions: 1.0) */
	public static final AttributeId minimum_bearing_clearance = create("minimum_bearing_clearance", UnitId.mum);

	/** Minimum outer bearing diameter (Versions: 1.1, 1.2) */
	public static final AttributeId minimum_bearing_outer_diameter = create("minimum_bearing_outer_diameter", UnitId.mm);

	/** Minimum bearing seat diameter (Versions: 1.0) */
	public static final AttributeId minimum_bore_diameter = create("minimum_bore_diameter", UnitId.mm);

	/** Minimum diameter of casing bore (Versions: 1.1, 1.2) */
	public static final AttributeId minimum_casing_bore_diameter = create("minimum_casing_bore_diameter", UnitId.mm);

	/** Minimum grinding diameter at the gear (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId minimum_diameter = create("minimum_diameter", UnitId.mm);

	/** Minimum normal backlash (Versions: 1.2) */
	public static final AttributeId minimum_normal_backlash = create("minimum_normal_backlash", UnitId.mm);

	/** Lower normal backlash variation (Versions: 1.2) */
	public static final AttributeId minimum_normal_backlash_variation = create("minimum_normal_backlash_variation", UnitId.mm);

	/** Minimum outer bearing diameter (Versions: 1.0) */
	public static final AttributeId minimum_outer_diameter = create("minimum_outer_diameter", UnitId.mm);

	/** Minimum shaft diameter (Versions: 1.0) */
	public static final AttributeId minimum_pin_diameter = create("minimum_pin_diameter", UnitId.mm);

	/** Minimum radial bearing clearance (before mounting) (Versions: 1.1, 1.2) */
	public static final AttributeId minimum_radial_bearing_clearance = create("minimum_radial_bearing_clearance", UnitId.mum);

	/** Minimum shaft diameter (Versions: 1.1, 1.2) */
	public static final AttributeId minimum_shaft_diameter = create("minimum_shaft_diameter", UnitId.mm);

	/** Minimum thickness by tip chamfer relief (Versions: 1.2) */
	public static final AttributeId minimum_thickness_by_tip_chamfer_relief = create("minimum_thickness_by_tip_chamfer_relief", UnitId.mm);

	/** Minimum transverse backlash (Versions: 1.2) */
	public static final AttributeId minimum_transverse_backlash = create("minimum_transverse_backlash", UnitId.mm);

	/** Lower backlash variation in transverse section (Versions: 1.2) */
	public static final AttributeId minimum_transverse_backlash_variation = create("minimum_transverse_backlash_variation", UnitId.mm);

	/** Radial offset of the mounting position of the outer ring in the v-direction (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId misalignment_in_v_direction = create("misalignment_in_v_direction", UnitId.mum);

	/** Radial offset of the mounting position of the outer ring in the w-direction (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId misalignment_in_w_direction = create("misalignment_in_w_direction", UnitId.mum);

	/** Modified reference rating life DIN 26281 2010 (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId modified_reference_rating_life_rotations_din_26281 = create("modified_reference_rating_life_rotations_din_26281", UnitId.none);

	/** Modified reference rating life DIN 26281 2010 (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId modified_reference_rating_life_time_din_26281 = create("modified_reference_rating_life_time_din_26281", UnitId.hour);

	/** Axial bearing clearance (after mounting) (Versions: 1.1, 1.2) */
	public static final AttributeId mounted_axial_bearing_clearance = create("mounted_axial_bearing_clearance", UnitId.mum);

	/** Radial bearing clearance (after mounting) (Versions: 1.1, 1.2) */
	public static final AttributeId mounted_radial_bearing_clearance = create("mounted_radial_bearing_clearance", UnitId.mum);

	/** Name of lubricant (Versions: 1.0, 1.0, 1.1, 1.2) */
	public static final AttributeId name = create("name", UnitId.none);

	/** Nominal design pressure angle on coast side (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId nominal_design_pressure_angle_coast = create("nominal_design_pressure_angle_coast", UnitId.degree);

	/** Nominal design pressure angle on drive side (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId nominal_design_pressure_angle_drive = create("nominal_design_pressure_angle_drive", UnitId.degree);

	/** Nominal rating life (L_10) DIN ISO 281 (Versions: 1.0) */
	public static final AttributeId nominal_rating_life_rotations_din_iso_281 = create("nominal_rating_life_rotations_din_iso_281", UnitId.none);

	/** Nominal rating life ISO 281 2007 (Versions: 1.1, 1.2) */
	public static final AttributeId nominal_rating_life_rotations_iso_281_2007 = create("nominal_rating_life_rotations_iso_281_2007", UnitId.none);

	/** Nominal rating life (L_10h) DIN ISO 281 (Versions: 1.0) */
	public static final AttributeId nominal_rating_life_time_din_iso_281 = create("nominal_rating_life_time_din_iso_281", UnitId.hour);

	/** Nominal rating life ISO 281 2007 (Versions: 1.1, 1.2) */
	public static final AttributeId nominal_rating_life_time_iso_281_2007 = create("nominal_rating_life_time_iso_281_2007", UnitId.hour);

	/** Nominal reference rating life DIN 26281 (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId nominal_reference_rating_life_rotations_din_26281 = create("nominal_reference_rating_life_rotations_din_26281", UnitId.none);

	/** Nominal reference rating life DIN 26281 (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId nominal_reference_rating_life_time_din_26281 = create("nominal_reference_rating_life_time_din_26281", UnitId.hour);

	/** Nominal tangential force at reference circle (Versions: 1.1, 1.2) */
	public static final AttributeId nominal_tangential_force_at_reference_circle = create("nominal_tangential_force_at_reference_circle", UnitId.newton);

	/** Normal chordal tooth thickness (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId normal_chordal_tooth_thickness = create("normal_chordal_tooth_thickness", UnitId.mm);

	/** Normal circular pitch (Versions: 1.2) */
	public static final AttributeId normal_circular_pitch = create("normal_circular_pitch", UnitId.mm);

	/** Normal module (Versions: 1.0, 1.0, 1.1, 1.2) */
	public static final AttributeId normal_module = create("normal_module", UnitId.mm);

	/** Normal pitch (DIN 3975 2017) (Versions: 1.2) */
	public static final AttributeId normal_pitch_din_3975_2017 = create("normal_pitch_din_3975_2017", UnitId.mm);

	/** Normal pressure angle (Versions: 1.0, 1.0, 1.1, 1.2) */
	public static final AttributeId normal_pressure_angle = create("normal_pressure_angle", UnitId.degree);

	/** Normal space width (Versions: 1.2) */
	public static final AttributeId normal_space_width_at_pitch_diameter = create("normal_space_width_at_pitch_diameter", UnitId.mm);

	/** Normal tip thickness for A_We (Versions: 1.2) */
	public static final AttributeId normal_tip_thickness = create("normal_tip_thickness", UnitId.mm);

	/** Normal tooth thickness (Versions: 1.2) */
	public static final AttributeId normal_tooth_thickness_at_pitch_diameter = create("normal_tooth_thickness_at_pitch_diameter", UnitId.mm);

	/** Number of bearing rows (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId number_of_bearing_rows = create("number_of_bearing_rows", UnitId.none);

	/** Number of blade groups (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId number_of_blade_groups = create("number_of_blade_groups", UnitId.none);

	/** Number of gears (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId number_of_gears = create("number_of_gears", UnitId.none);

	/** Number of load cycles (Versions: 1.1, 1.2) */
	public static final AttributeId number_of_load_cycles = create("number_of_load_cycles", UnitId.none);

	/** Number of nodes in mesh width for load distribution (Versions: 1.1, 1.2) */
	public static final AttributeId number_of_nodes_in_mesh_width_for_loaddistribution = create("number_of_nodes_in_mesh_width_for_loaddistribution", UnitId.none);

	/** Number of rolling elements (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId number_of_rolling_elements = create("number_of_rolling_elements", UnitId.none);

	/** Number of teeth (Versions: 1.0, 1.0, 1.1, 1.2) */
	public static final AttributeId number_of_teeth = create("number_of_teeth", UnitId.none);

	/** Measured number of teeth for base tangent length W_k (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId number_of_teeth_for_span_measurement = create("number_of_teeth_for_span_measurement", UnitId.none);

	/** Operating axial bearing clearance (Versions: 1.1, 1.2) */
	public static final AttributeId operating_axial_bearing_clearance = create("operating_axial_bearing_clearance", UnitId.mum);

	/** Operating point stiffness dF_u / d_u (Versions: 1.0) */
	public static final AttributeId operating_point_stiffness_dF_u_d_u = create("operating_point_stiffness_dF_u_d_u", UnitId.newton_per_m);

	/** Operating point stiffness dF_u / d_v (Versions: 1.0) */
	public static final AttributeId operating_point_stiffness_dF_u_d_v = create("operating_point_stiffness_dF_u_d_v", UnitId.newton_per_m);

	/** Operating point stiffness dF_u / d_v_rot (Versions: 1.0) */
	public static final AttributeId operating_point_stiffness_dF_u_d_v_rot = create("operating_point_stiffness_dF_u_d_v_rot", UnitId.newton_per_radian);

	/** Operating point stiffness dF_u / d_w (Versions: 1.0) */
	public static final AttributeId operating_point_stiffness_dF_u_d_w = create("operating_point_stiffness_dF_u_d_w", UnitId.newton_per_m);

	/** Operating point stiffness dF_u / d_w_rot (Versions: 1.0) */
	public static final AttributeId operating_point_stiffness_dF_u_d_w_rot = create("operating_point_stiffness_dF_u_d_w_rot", UnitId.newton_per_radian);

	/** Operating point stiffness dF_v / d_u (Versions: 1.0) */
	public static final AttributeId operating_point_stiffness_dF_v_d_u = create("operating_point_stiffness_dF_v_d_u", UnitId.newton_per_m);

	/** Operating point stiffness dF_v / d_v (Versions: 1.0) */
	public static final AttributeId operating_point_stiffness_dF_v_d_v = create("operating_point_stiffness_dF_v_d_v", UnitId.newton_per_m);

	/** Operating point stiffness dF_v / d_v_rot (Versions: 1.0) */
	public static final AttributeId operating_point_stiffness_dF_v_d_v_rot = create("operating_point_stiffness_dF_v_d_v_rot", UnitId.newton_per_radian);

	/** Operating point stiffness dF_v / d_w (Versions: 1.0) */
	public static final AttributeId operating_point_stiffness_dF_v_d_w = create("operating_point_stiffness_dF_v_d_w", UnitId.newton_per_m);

	/** Operating point stiffness dF_v / d_w_rot (Versions: 1.0) */
	public static final AttributeId operating_point_stiffness_dF_v_d_w_rot = create("operating_point_stiffness_dF_v_d_w_rot", UnitId.newton_per_radian);

	/** Operating point stiffness dF_w / d_u (Versions: 1.0) */
	public static final AttributeId operating_point_stiffness_dF_w_d_u = create("operating_point_stiffness_dF_w_d_u", UnitId.newton_per_m);

	/** Operating point stiffness dF_w / d_v (Versions: 1.0) */
	public static final AttributeId operating_point_stiffness_dF_w_d_v = create("operating_point_stiffness_dF_w_d_v", UnitId.newton_per_m);

	/** Operating point stiffness dF_w / d_v_rot (Versions: 1.0) */
	public static final AttributeId operating_point_stiffness_dF_w_d_v_rot = create("operating_point_stiffness_dF_w_d_v_rot", UnitId.newton_per_radian);

	/** Operating point stiffness dF_w / d_w (Versions: 1.0) */
	public static final AttributeId operating_point_stiffness_dF_w_d_w = create("operating_point_stiffness_dF_w_d_w", UnitId.newton_per_m);

	/** Operating point stiffness dF_w / d_w_rot (Versions: 1.0) */
	public static final AttributeId operating_point_stiffness_dF_w_d_w_rot = create("operating_point_stiffness_dF_w_d_w_rot", UnitId.newton_per_radian);

	/** Operating point stiffness dM_v / d_u (Versions: 1.0) */
	public static final AttributeId operating_point_stiffness_dM_v_d_u = create("operating_point_stiffness_dM_v_d_u", UnitId.newton);

	/** Operating point stiffness dM_v / d_v (Versions: 1.0) */
	public static final AttributeId operating_point_stiffness_dM_v_d_v = create("operating_point_stiffness_dM_v_d_v", UnitId.newton);

	/** Operating point stiffness dM_v / d_v_rot (Versions: 1.0) */
	public static final AttributeId operating_point_stiffness_dM_v_d_v_rot = create("operating_point_stiffness_dM_v_d_v_rot", UnitId.newton_mm_per_rad);

	/** Operating point stiffness dM_v / d_w (Versions: 1.0) */
	public static final AttributeId operating_point_stiffness_dM_v_d_w = create("operating_point_stiffness_dM_v_d_w", UnitId.newton);

	/** Operating point stiffness dM_v / d_w_rot (Versions: 1.0) */
	public static final AttributeId operating_point_stiffness_dM_v_d_w_rot = create("operating_point_stiffness_dM_v_d_w_rot", UnitId.newton_mm_per_rad);

	/** Operating point stiffness dM_w / d_u (Versions: 1.0) */
	public static final AttributeId operating_point_stiffness_dM_w_d_u = create("operating_point_stiffness_dM_w_d_u", UnitId.newton);

	/** Operating point stiffness dM_w / d_v (Versions: 1.0) */
	public static final AttributeId operating_point_stiffness_dM_w_d_v = create("operating_point_stiffness_dM_w_d_v", UnitId.newton);

	/** Operating point stiffness dM_w / d_v_rot (Versions: 1.0) */
	public static final AttributeId operating_point_stiffness_dM_w_d_v_rot = create("operating_point_stiffness_dM_w_d_v_rot", UnitId.newton_mm_per_rad);

	/** Operating point stiffness dM_w / d_w (Versions: 1.0) */
	public static final AttributeId operating_point_stiffness_dM_w_d_w = create("operating_point_stiffness_dM_w_d_w", UnitId.newton);

	/** Operating point stiffness dM_w / d_w_rot (Versions: 1.0) */
	public static final AttributeId operating_point_stiffness_dM_w_d_w_rot = create("operating_point_stiffness_dM_w_d_w_rot", UnitId.newton_mm_per_rad);

	/** Operating point stiffness &part;F_u / &part;d_u (Versions: 1.1, 1.2) */
	public static final AttributeId operating_point_stiffness_f_u_d_u = create("operating_point_stiffness_f_u_d_u", UnitId.newton_per_m);

	/** Operating point stiffness &part;F_u / &part;d_v (Versions: 1.1, 1.2) */
	public static final AttributeId operating_point_stiffness_f_u_d_v = create("operating_point_stiffness_f_u_d_v", UnitId.newton_per_m);

	/** Operating point stiffness &part;F_u / &part;d_w (Versions: 1.1, 1.2) */
	public static final AttributeId operating_point_stiffness_f_u_d_w = create("operating_point_stiffness_f_u_d_w", UnitId.newton_per_m);

	/** Operating point stiffness &part;F_u / &part;rot_v (Versions: 1.1, 1.2) */
	public static final AttributeId operating_point_stiffness_f_u_rot_v = create("operating_point_stiffness_f_u_rot_v", UnitId.newton_per_radian);

	/** Operating point stiffness &part;F_u / &part;rot_w (Versions: 1.1, 1.2) */
	public static final AttributeId operating_point_stiffness_f_u_rot_w = create("operating_point_stiffness_f_u_rot_w", UnitId.newton_per_radian);

	/** Operating point stiffness &part;F_v / &part;d_u (Versions: 1.1, 1.2) */
	public static final AttributeId operating_point_stiffness_f_v_d_u = create("operating_point_stiffness_f_v_d_u", UnitId.newton_per_m);

	/** Operating point stiffness &part;F_v / &part;d_v (Versions: 1.1, 1.2) */
	public static final AttributeId operating_point_stiffness_f_v_d_v = create("operating_point_stiffness_f_v_d_v", UnitId.newton_per_m);

	/** Operating point stiffness &part;F_v / &part;d_w (Versions: 1.1, 1.2) */
	public static final AttributeId operating_point_stiffness_f_v_d_w = create("operating_point_stiffness_f_v_d_w", UnitId.newton_per_m);

	/** Operating point stiffness &part;F_v / &part;rot_v (Versions: 1.1, 1.2) */
	public static final AttributeId operating_point_stiffness_f_v_rot_v = create("operating_point_stiffness_f_v_rot_v", UnitId.newton_per_radian);

	/** Operating point stiffness &part;F_v / &part;rot_w (Versions: 1.1, 1.2) */
	public static final AttributeId operating_point_stiffness_f_v_rot_w = create("operating_point_stiffness_f_v_rot_w", UnitId.newton_per_radian);

	/** Operating point stiffness  &part;F_w / &part;d_u (Versions: 1.1, 1.2) */
	public static final AttributeId operating_point_stiffness_f_w_d_u = create("operating_point_stiffness_f_w_d_u", UnitId.newton_per_m);

	/** Operating point stiffness &part;F_w / &part;d_v (Versions: 1.1, 1.2) */
	public static final AttributeId operating_point_stiffness_f_w_d_v = create("operating_point_stiffness_f_w_d_v", UnitId.newton_per_m);

	/** Operating point stiffness &part;F_w / &part;d_w (Versions: 1.1, 1.2) */
	public static final AttributeId operating_point_stiffness_f_w_d_w = create("operating_point_stiffness_f_w_d_w", UnitId.newton_per_m);

	/** Operating point stiffness &part;F_w / &part;rot_v (Versions: 1.1, 1.2) */
	public static final AttributeId operating_point_stiffness_f_w_rot_v = create("operating_point_stiffness_f_w_rot_v", UnitId.newton_per_radian);

	/** Operating point stiffness &part;F_w / &part;rot_w (Versions: 1.1, 1.2) */
	public static final AttributeId operating_point_stiffness_f_w_rot_w = create("operating_point_stiffness_f_w_rot_w", UnitId.newton_per_radian);

	/** Operating point stiffness &part;M_v / &part;d_u (Versions: 1.1, 1.2) */
	public static final AttributeId operating_point_stiffness_m_v_d_u = create("operating_point_stiffness_m_v_d_u", UnitId.newton);

	/** Operating point stiffness &part;M_v / &part;d_v (Versions: 1.1, 1.2) */
	public static final AttributeId operating_point_stiffness_m_v_d_v = create("operating_point_stiffness_m_v_d_v", UnitId.newton);

	/** Operating point stiffness &part;M_v / &part;d_w (Versions: 1.1, 1.2) */
	public static final AttributeId operating_point_stiffness_m_v_d_w = create("operating_point_stiffness_m_v_d_w", UnitId.newton);

	/** Operating point stiffness &part;M_v / &part;rot_v (Versions: 1.1, 1.2) */
	public static final AttributeId operating_point_stiffness_m_v_rot_v = create("operating_point_stiffness_m_v_rot_v", UnitId.newton_mm_per_rad);

	/** Operating point stiffness &part;M_v / &part;rot_w (Versions: 1.1, 1.2) */
	public static final AttributeId operating_point_stiffness_m_v_rot_w = create("operating_point_stiffness_m_v_rot_w", UnitId.newton_mm_per_rad);

	/** Operating point stiffness &part;M_w / &part;d_u (Versions: 1.1, 1.2) */
	public static final AttributeId operating_point_stiffness_m_w_d_u = create("operating_point_stiffness_m_w_d_u", UnitId.newton);

	/** Operating point stiffness &part;M_w / &part;d_v (Versions: 1.1, 1.2) */
	public static final AttributeId operating_point_stiffness_m_w_d_v = create("operating_point_stiffness_m_w_d_v", UnitId.newton);

	/** Operating point stiffness &part;M_w / &part;d_w (Versions: 1.1, 1.2) */
	public static final AttributeId operating_point_stiffness_m_w_d_w = create("operating_point_stiffness_m_w_d_w", UnitId.newton);

	/** Operating point stiffness &part;M_w / &part;rot_v (Versions: 1.1, 1.2) */
	public static final AttributeId operating_point_stiffness_m_w_rot_v = create("operating_point_stiffness_m_w_rot_v", UnitId.newton_mm_per_rad);

	/** Operating point stiffness &part;M_w / &part;rot_w (Versions: 1.1, 1.2) */
	public static final AttributeId operating_point_stiffness_m_w_rot_w = create("operating_point_stiffness_m_w_rot_w", UnitId.newton_mm_per_rad);

	/** Operating pressure angle in the normal section (Versions: 1.1, 1.2) */
	public static final AttributeId operating_pressure_angle_in_the_normal_section = create("operating_pressure_angle_in_the_normal_section", UnitId.degree);

	/** Operating pressure angle in the transverse section (Versions: 1.1, 1.2) */
	public static final AttributeId operating_pressure_angle_in_the_transverse_section = create("operating_pressure_angle_in_the_transverse_section", UnitId.degree);

	/** Operating radial bearing clearance (Versions: 1.1, 1.2) */
	public static final AttributeId operating_radial_bearing_clearance = create("operating_radial_bearing_clearance", UnitId.mum);

	/** Operating viscosity (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId operating_viscosity = create("operating_viscosity", UnitId.mm2_per_s);

	/** Outer addendum (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId outer_addendum = create("outer_addendum", UnitId.mm);

	/** Outer reference cone distance (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId outer_cone_distance = create("outer_cone_distance", UnitId.mm);

	/** Outer dedendum (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId outer_dedendum = create("outer_dedendum", UnitId.mm);

	/** Outer diameter (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId outer_diameter = create("outer_diameter", UnitId.mm);

	/** Outer diameter begin (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId outer_diameter_begin = create("outer_diameter_begin", UnitId.mm);

	/** Outer diameter (DIN 3975 2017) (Versions: 1.2) */
	public static final AttributeId outer_diameter_din_3975_2017 = create("outer_diameter_din_3975_2017", UnitId.mm);

	/** Outer diameter end (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId outer_diameter_end = create("outer_diameter_end", UnitId.mm);

	/** Outer pitch diameter (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId outer_pitch_diameter = create("outer_pitch_diameter", UnitId.mm);

	/** Outer transverse module (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId outer_transverse_module = create("outer_transverse_module", UnitId.mm);

	/** Outer whole depth (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId outer_whole_depth = create("outer_whole_depth", UnitId.mm);

	/** Overlap contact ratio (Versions: 1.1, 1.2) */
	public static final AttributeId overlap_contact_ratio = create("overlap_contact_ratio", UnitId.none);

	/** Overrolling frequency inner ring (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId overrolling_frequency_inner_ring = create("overrolling_frequency_inner_ring", UnitId.hertz);

	/** Overrolling frequency outer ring (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId overrolling_frequency_outer_ring = create("overrolling_frequency_outer_ring", UnitId.hertz);

	/** Overrolling frequency rolling element (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId overrolling_frequency_rolling_element = create("overrolling_frequency_rolling_element", UnitId.hertz);

	/** Parameter for mean minimum lubricant film thickness (DIN 3996 2019) (Versions: 1.2) */
	public static final AttributeId parameter_for_mean_minimum_lubricant_film_thickness_din_3996_2019 = create("parameter_for_mean_minimum_lubricant_film_thickness_din_3996_2019", UnitId.none);

	/** Parameter for the mean hertzian stress (DIN 3996 2019) (Versions: 1.2) */
	public static final AttributeId parameter_mean_hertzian_stress_din_3996_2019 = create("parameter_mean_hertzian_stress_din_3996_2019", UnitId.none);

	/** Parameter for the mean sliding path (DIN 3996 2019) (Versions: 1.2) */
	public static final AttributeId parameter_mean_sliding_path_din_3996_2019 = create("parameter_mean_sliding_path_din_3996_2019", UnitId.none);

	/** Tolerance class of shaft (Versions: 1.0) */
	public static final AttributeId pin_tolerance_class = create("pin_tolerance_class", UnitId.none);

	/** Pitch angle (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId pitch_angle = create("pitch_angle", UnitId.degree);

	/** Pitch apex beyond crossing point (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId pitch_apex_beyond_crossing_point = create("pitch_apex_beyond_crossing_point", UnitId.mm);

	/** Pitch circle diameter (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId pitch_diameter = create("pitch_diameter", UnitId.mm);

	/** Poisson's ratio (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId poisson_ratio = create("poisson_ratio", UnitId.none);

	/** Face width coordinate of profile deviations (Versions: 1.2) */
	public static final AttributeId position_of_profile_deviation = create("position_of_profile_deviation", UnitId.mm);

	/** Face width coordinate of the profile modification (Versions: 1.2) */
	public static final AttributeId position_of_profile_modification = create("position_of_profile_modification", UnitId.mm);

	/** Facewidth coordinate of the profile twist modification on datum face (Versions: 1.2) */
	public static final AttributeId position_of_profile_twist_datum_face = create("position_of_profile_twist_datum_face", UnitId.mm);

	/** Facewidth coordinate of the profile twist modification on non-datum face (Versions: 1.2) */
	public static final AttributeId position_of_profile_twist_non_datum_face = create("position_of_profile_twist_non_datum_face", UnitId.mm);

	/** Position of rolling elements (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId position_of_rolling_elements = create("position_of_rolling_elements", UnitId.none);

	/** Power with sign (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId power = create("power", UnitId.kilo_watt);

	/** Rolling output (Versions: 1.1, 1.2) */
	public static final AttributeId power_for_rolling_rotational_speed = create("power_for_rolling_rotational_speed", UnitId.watt);

	/** Power (Versions: 1.1, 1.2) */
	public static final AttributeId power_for_rotational_speed = create("power_for_rotational_speed", UnitId.watt);

	/** Preload distance (Versions: 1.1, 1.2) */
	public static final AttributeId preload_distance = create("preload_distance", UnitId.mum);

	/** Preload force (Versions: 1.1, 1.2) */
	public static final AttributeId preload_force = create("preload_force", UnitId.newton);

	/** Contact angle (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId pressure_angle = create("pressure_angle", UnitId.degree);

	/** Pressure angle (DIN 3975 2017) (Versions: 1.2) */
	public static final AttributeId pressure_angle_din_3975_2017 = create("pressure_angle_din_3975_2017", UnitId.degree);

	/** Pressure angle in the transverse section (Versions: 1.1, 1.2) */
	public static final AttributeId pressure_angle_in_the_transverse_section = create("pressure_angle_in_the_transverse_section", UnitId.degree);

	/** Amount of profile crowning at the root (Versions: 1.2) */
	public static final AttributeId profile_crowning_at_root = create("profile_crowning_at_root", UnitId.mm);

	/** Amount of profile crowning at the tip (Versions: 1.2) */
	public static final AttributeId profile_crowning_at_tip = create("profile_crowning_at_tip", UnitId.mm);

	/** Amount of profile deviations (Versions: 1.2) */
	public static final AttributeId profile_deviation_amounts = create("profile_deviation_amounts", UnitId.mm);

	/** End diameter of profile evaluation (Versions: 1.2) */
	public static final AttributeId profile_evaluation_end = create("profile_evaluation_end", UnitId.mm);

	/** Profile control diameter (start of evaluation) (Versions: 1.2) */
	public static final AttributeId profile_evaluation_start = create("profile_evaluation_start", UnitId.mm);

	/** Diameter of highest point in profile (Versions: 1.2) */
	public static final AttributeId profile_highest_point = create("profile_highest_point", UnitId.mm);

	/** Profile shift coefficient (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId profile_shift_coefficient = create("profile_shift_coefficient", UnitId.none);

	/** Amount of profile slope modification (Versions: 1.2) */
	public static final AttributeId profile_slope = create("profile_slope", UnitId.mm);

	/** Amount of profile twist modification (Versions: 1.2) */
	public static final AttributeId profile_twist = create("profile_twist", UnitId.mm);

	/** End diameter of evaluation of the profile twist (Versions: 1.2) */
	public static final AttributeId profile_twist_evaluation_end = create("profile_twist_evaluation_end", UnitId.mm);

	/** Profile control diameter (start of evaluation) of the profile twist (Versions: 1.2) */
	public static final AttributeId profile_twist_evaluation_start = create("profile_twist_evaluation_start", UnitId.mm);

	/** Protuberance amount (Versions: 1.0, 1.0, 1.1, 1.2) */
	public static final AttributeId protuberance_amount = create("protuberance_amount", UnitId.mm);

	/** Protuberance amount factor (Versions: 1.0, 1.0, 1.1, 1.2) */
	public static final AttributeId protuberance_amount_factor = create("protuberance_amount_factor", UnitId.none);

	/** Protuberance angle (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId protuberance_angle = create("protuberance_angle", UnitId.degree);

	/** Protuberance height (Versions: 1.0, 1.0, 1.1, 1.2) */
	public static final AttributeId protuberance_height = create("protuberance_height", UnitId.mm);

	/** Protuberance height factor (Versions: 1.0, 1.0, 1.1, 1.2) */
	public static final AttributeId protuberance_height_factor = create("protuberance_height_factor", UnitId.none);

	/** Radius of raceway at inner ring (Versions: 1.1, 1.2) */
	public static final AttributeId raceway_radius_of_inner_ring = create("raceway_radius_of_inner_ring", UnitId.mm);

	/** Radius of raceway at outer ring (Versions: 1.1, 1.2) */
	public static final AttributeId raceway_radius_of_outer_ring = create("raceway_radius_of_outer_ring", UnitId.mm);

	/** Radial backlash (Versions: 1.0) */
	public static final AttributeId radial_backlash = create("radial_backlash", UnitId.mum);

	/** Radial bearing clearance (before mounting) (Versions: 1.1, 1.2) */
	public static final AttributeId radial_bearing_clearance = create("radial_bearing_clearance", UnitId.mum);

	/** Radial bearing clearance class (before mounting) (Versions: 1.1, 1.2) */
	public static final AttributeId radial_clearance_class = create("radial_clearance_class", UnitId.none);

	/** Radial contact ratio (Versions: 1.1, 1.2) */
	public static final AttributeId radial_contact_ratio = create("radial_contact_ratio", UnitId.none);

	/** Relative displacement of the inner ring in the v-direction compared to the outer ring (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId radial_deflection_in_v = create("radial_deflection_in_v", UnitId.mum);

	/** Relative displacement of the inner ring in the w-direction compared to the outer ring (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId radial_deflection_in_w = create("radial_deflection_in_w", UnitId.mum);

	/** Radial dynamic load rating (Versions: 1.1, 1.2) */
	public static final AttributeId radial_dynamic_load_rating = create("radial_dynamic_load_rating", UnitId.kilo_newton);

	/** Radial load factor X1 for F_a/F_r &lt;=  e (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId radial_factor_x_1 = create("radial_factor_x_1", UnitId.none);

	/** Radial load factor X2 for F_a/F_r &gt;  e (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId radial_factor_x_2 = create("radial_factor_x_2", UnitId.none);

	/** Support of radial loads (Versions: 1.1, 1.2) */
	public static final AttributeId radial_force_absorption = create("radial_force_absorption", UnitId.none);

	/** Radial force in v-direction (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId radial_force_in_v = create("radial_force_in_v", UnitId.kilo_newton);

	/** Radial force in w-direction (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId radial_force_in_w = create("radial_force_in_w", UnitId.kilo_newton);

	/** Radial static load rating (Versions: 1.1, 1.2) */
	public static final AttributeId radial_static_load_rating = create("radial_static_load_rating", UnitId.kilo_newton);

	/** Radial stiffness (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId radial_stiffness = create("radial_stiffness", UnitId.newton_per_m);

	/** Reduced static stiffness matrix (Versions: 1.1, 1.2) */
	public static final AttributeId reduced_static_stiffness_matrix = create("reduced_static_stiffness_matrix", UnitId.none);

	/** Reference circle diameter (Versions: 1.1, 1.2) */
	public static final AttributeId reference_circle_diameter = create("reference_circle_diameter", UnitId.mm);

	/** Reference component for position (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId reference_component_for_position = create("reference_component_for_position", UnitId.none);

	/** Reference diameter (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId reference_diameter = create("reference_diameter", UnitId.mm);

	/** Reference diameter (DIN 3975 2017) (Versions: 1.2) */
	public static final AttributeId reference_diameter_din_3975_2017 = create("reference_diameter_din_3975_2017", UnitId.mm);

	/** Reference lead angle (DIN 3975 2017) (Versions: 1.2) */
	public static final AttributeId reference_lead_angle_din_3975_2017 = create("reference_lead_angle_din_3975_2017", UnitId.degree);

	/** Thermal reference speed (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId reference_speed = create("reference_speed", UnitId.none);

	/** Reference temperature (Versions: 1.1, 1.2) */
	public static final AttributeId reference_temperature = create("reference_temperature", UnitId.degree_celsius);

	/** Related tip thickness (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId related_tip_thickness = create("related_tip_thickness", UnitId.none);

	/** Distance from datum line to measuring line relative to the normal module (Versions: 1.2) */
	public static final AttributeId relative_distance_tool_profile_basic_line_to_measuring_line = create("relative_distance_tool_profile_basic_line_to_measuring_line", UnitId.none);

	/** Lever arm for load at tip to 30 degree tangent (relative to module) (Versions: 1.1, 1.2) */
	public static final AttributeId relative_lever_arm_for_load_at_tip_to_30_degree_tangent = create("relative_lever_arm_for_load_at_tip_to_30_degree_tangent", UnitId.none);

	/** Machining allowance of the tool (relative to the normal module) (Versions: 1.2) */
	public static final AttributeId relative_machining_allowance = create("relative_machining_allowance", UnitId.none);

	/** Tool b_z0* measurement (relative to module) (Versions: 1.2) */
	public static final AttributeId relative_measurement_bz0 = create("relative_measurement_bz0", UnitId.none);

	/** Tooth root chord at the 30&deg; tangent (relative to module) (Versions: 1.1, 1.2) */
	public static final AttributeId relative_tooth_root_chord_at_30_degree_tangent = create("relative_tooth_root_chord_at_30_degree_tangent", UnitId.none);

	/** Tooth root radius at the 30&deg; tangent (relative to module) (Versions: 1.1, 1.2) */
	public static final AttributeId relative_tooth_root_radius_at_30_degree_tangent = create("relative_tooth_root_radius_at_30_degree_tangent", UnitId.none);

	/** Remaining protuberance (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId remaining_protuberance = create("remaining_protuberance", UnitId.mm);

	/** Roller angle (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId roller_angle = create("roller_angle", UnitId.degree);

	/** Roller crowning radius (Versions: 1.1, 1.2) */
	public static final AttributeId roller_crowning_radius = create("roller_crowning_radius", UnitId.mm);

	/** Surface radius of roller (Versions: 1.0) */
	public static final AttributeId roller_shell_radius = create("roller_shell_radius", UnitId.mm);

	/** Path of bearing file (Versions: 1.0) */
	public static final AttributeId rolling_bearing_file = create("rolling_bearing_file", UnitId.none);

	/** Rolling length where amount of modification is specified (Versions: 1.2) */
	public static final AttributeId rolling_length_where_profile_slope_amount_is_specified = create("rolling_length_where_profile_slope_amount_is_specified", UnitId.mm);

	/** Rolling length where amount of profile twist is specified (Versions: 1.2) */
	public static final AttributeId rolling_length_where_profile_twist_amount_is_specified = create("rolling_length_where_profile_twist_amount_is_specified", UnitId.mm);

	/** Rolling rotational speed (Versions: 1.1, 1.2) */
	public static final AttributeId rolling_rotational_speed = create("rolling_rotational_speed", UnitId.rotation_per_min);

	/** Root angle (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId root_angle = create("root_angle", UnitId.degree);

	/** Root apex beyond crossing point (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId root_apex_beyond_crossing_point = create("root_apex_beyond_crossing_point", UnitId.mm);

	/** Root diameter (Versions: 1.2) */
	public static final AttributeId root_diameter = create("root_diameter", UnitId.mm);

	/** Root diameter (DIN 3975 2017) (Versions: 1.2) */
	public static final AttributeId root_diameter_din_3975_2017 = create("root_diameter_din_3975_2017", UnitId.mm);

	/** Root form diameter (Versions: 1.2) */
	public static final AttributeId root_form_diameter = create("root_form_diameter", UnitId.mm);

	/** Diameter at start of root relief (reference diameter) (Versions: 1.2) */
	public static final AttributeId root_relief_datum_diameter = create("root_relief_datum_diameter", UnitId.mm);

	/** Length of root relief (Versions: 1.2) */
	public static final AttributeId root_relief_datum_length = create("root_relief_datum_length", UnitId.mm);

	/** Depth of root relief (Versions: 1.2) */
	public static final AttributeId root_relief_depth = create("root_relief_depth", UnitId.mm);

	/** Diameter where tangential transition ends (Versions: 1.2) */
	public static final AttributeId root_relief_diameter_where_tangential_transition_ends = create("root_relief_diameter_where_tangential_transition_ends", UnitId.mm);

	/** Diameter where tangential transition starts (Versions: 1.2) */
	public static final AttributeId root_relief_diameter_where_tangential_transition_starts = create("root_relief_diameter_where_tangential_transition_starts", UnitId.mm);

	/** Diameter where amount of modification is specified (Versions: 1.2) */
	public static final AttributeId root_relief_evaluation_reference = create("root_relief_evaluation_reference", UnitId.mm);

	/** Length where amount of modification is specified (Versions: 1.2) */
	public static final AttributeId root_relief_evaluation_reference_length = create("root_relief_evaluation_reference_length", UnitId.mm);

	/** Length of tangential transition end (Versions: 1.2) */
	public static final AttributeId root_relief_length_of_tangential_transition_end = create("root_relief_length_of_tangential_transition_end", UnitId.mm);

	/** Length of tangential transition start (Versions: 1.2) */
	public static final AttributeId root_relief_length_of_tangential_transition_start = create("root_relief_length_of_tangential_transition_start", UnitId.mm);

	/** Root undercut (Versions: 1.2) */
	public static final AttributeId root_undercut = create("root_undercut", UnitId.mm);

	/** Shaft angle (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId rotating_angle_around_neg_u_axis = create("rotating_angle_around_neg_u_axis", UnitId.degree);

	/** Rotating angle around u-axis (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId rotating_angle_around_pos_u_axis = create("rotating_angle_around_pos_u_axis", UnitId.degree);

	/** Rotational speed with sign (Versions: 1.0, 1.0, 1.1, 1.2) */
	public static final AttributeId rotational_speed = create("rotational_speed", UnitId.rotation_per_min);

	/** Torsional stiffness (Versions: 1.1, 1.2) */
	public static final AttributeId rotational_stiffness = create("rotational_stiffness", UnitId.newton_mm_per_rad);

	/** Radius of raceway at inner ring (Versions: 1.0) */
	public static final AttributeId running_path_radius_of_inner_ring = create("running_path_radius_of_inner_ring", UnitId.mm);

	/** Radius of raceway at outer ring (Versions: 1.0) */
	public static final AttributeId running_path_radius_of_outer_ring = create("running_path_radius_of_outer_ring", UnitId.mm);

	/** Safety factor deflection (DIN 3996 2019) (Versions: 1.2) */
	public static final AttributeId safety_factor_deflection_din_3996_2019 = create("safety_factor_deflection_din_3996_2019", UnitId.none);

	/** Safety factor pitting (DIN 3996 2019) (Versions: 1.2) */
	public static final AttributeId safety_factor_pitting_din_3996_2019 = create("safety_factor_pitting_din_3996_2019", UnitId.none);

	/** Safety factor root (DIN 3996 2019) (Versions: 1.2) */
	public static final AttributeId safety_factor_root_din_3996_2019 = create("safety_factor_root_din_3996_2019", UnitId.none);

	/** Shaft angle (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId shaft_angle = create("shaft_angle", UnitId.degree);

	/** Inner shaft diameter for the operating clearance calculation (Versions: 1.1, 1.2) */
	public static final AttributeId shaft_inner_diameter = create("shaft_inner_diameter", UnitId.mm);

	/** Surface roughness of shaft (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId shaft_surface_roughness = create("shaft_surface_roughness", UnitId.mum);

	/** Tolerance class of shaft (Versions: 1.1, 1.2) */
	public static final AttributeId shaft_tolerance_class = create("shaft_tolerance_class", UnitId.none);

	/** Shape of helix crowning (Versions: 1.2) */
	public static final AttributeId shape_of_helix_crowning = create("shape_of_helix_crowning", UnitId.none);

	/** Shape of profile crowning (Versions: 1.2) */
	public static final AttributeId shape_of_profile_crowning = create("shape_of_profile_crowning", UnitId.none);

	/** Shape of relief (Versions: 1.2) */
	public static final AttributeId shape_of_relief = create("shape_of_relief", UnitId.none);

	/** Shear modulus (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId shear_modulus = create("shear_modulus", UnitId.newton_per_mm2);

	/** Shear stress at tooth root (DIN 3996 2019) (Versions: 1.2) */
	public static final AttributeId shear_stress_tooth_root_din_3996_2019 = create("shear_stress_tooth_root_din_3996_2019", UnitId.newton_per_mm2);

	/** Maximum length of inner ring contact (Versions: 1.1, 1.2) */
	public static final AttributeId significant_contact_length_inner_ring = create("significant_contact_length_inner_ring", UnitId.mm);

	/** Maximum length of outer ring contact (Versions: 1.1, 1.2) */
	public static final AttributeId significant_contact_length_outer_ring = create("significant_contact_length_outer_ring", UnitId.mm);

	/** Possible contact length of rolling element inner ring (Versions: 1.0) */
	public static final AttributeId significant_width_inner = create("significant_width_inner", UnitId.mm);

	/** Possible contact length of rolling element outer ring (Versions: 1.0) */
	public static final AttributeId significant_width_outer = create("significant_width_outer", UnitId.mm);

	/** Size over balls (Versions: 1.2) */
	public static final AttributeId size_over_balls = create("size_over_balls", UnitId.mm);

	/** Size over pins (Versions: 1.2) */
	public static final AttributeId size_over_pins = create("size_over_pins", UnitId.mm);

	/** Sliding factor at tip diameter (Versions: 1.2) */
	public static final AttributeId sliding_factor_at_tip_diameter = create("sliding_factor_at_tip_diameter", UnitId.none);

	/** Sliding velocity at reference diameter (DIN 3996 2019) (Versions: 1.2) */
	public static final AttributeId sliding_velocity_at_reference_diameter_din_3996_2019 = create("sliding_velocity_at_reference_diameter_din_3996_2019", UnitId.m_per_second);

	/** Span measurement (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId span_measurement = create("span_measurement", UnitId.mm);

	/** Specific sliding (tooth root) (Versions: 1.2) */
	public static final AttributeId specific_sliding_at_root_diameter = create("specific_sliding_at_root_diameter", UnitId.none);

	/** Specific sliding (tooth tip) (Versions: 1.2) */
	public static final AttributeId specific_sliding_at_tip_diameter = create("specific_sliding_at_tip_diameter", UnitId.none);

	/** Specify tangential transition (Versions: 1.2) */
	public static final AttributeId specify_tangential_transition = create("specify_tangential_transition", UnitId.none);

	/** Rotational speed inner ring (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId speed_inner_ring = create("speed_inner_ring", UnitId.rotation_per_min);

	/** Rotational speed outer ring (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId speed_outer_ring = create("speed_outer_ring", UnitId.rotation_per_min);

	/** Speed rolling element set / cage (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId speed_rolling_element_set = create("speed_rolling_element_set", UnitId.rotation_per_min);

	/** Direction of the spiral angle (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId spiral_angle_pitch_direction = create("spiral_angle_pitch_direction", UnitId.none);

	/** Start-up time (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId start_up_time = create("start_up_time", UnitId.second);

	/** Static load rating (Versions: 1.0) */
	public static final AttributeId static_capacity = create("static_capacity", UnitId.kilo_newton);

	/** Static load safety (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId static_load_safety = create("static_load_safety", UnitId.none);

	/** Circumferential angle of struts of planet carrier (Versions: 1.2) */
	public static final AttributeId strut_circumferential_angle = create("strut_circumferential_angle", UnitId.degree);

	/** Inner diameter of struts of planet carrier (Versions: 1.2) */
	public static final AttributeId strut_inner_diameter = create("strut_inner_diameter", UnitId.mm);

	/** Radius of planet recess in the struts of the planet carrier (Versions: 1.2) */
	public static final AttributeId strut_radius_planet_recess = create("strut_radius_planet_recess", UnitId.mm);

	/** Sum of addendum modification coefficients (profile shift coefficients) (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId sum_of_addendum_modification_coefficients = create("sum_of_addendum_modification_coefficients", UnitId.none);

	/** Support vector (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId support_vector = create("support_vector", UnitId.mm);

	/** Surface hardness - Brinell (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId surface_hardness_brinell = create("surface_hardness_brinell", UnitId.hb);

	/** Surface hardness - Rockwell (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId surface_hardness_rockwell = create("surface_hardness_rockwell", UnitId.hrc);

	/** Surface hardness - Vickers (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId surface_hardness_vickers = create("surface_hardness_vickers", UnitId.hv);

	/** Surface zone bending resistance (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId surface_zone_bending_resistance = create("surface_zone_bending_resistance", UnitId.mega_pascal);

	/** Surface zone tension resistance (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId surface_zone_tension_resistance = create("surface_zone_tension_resistance", UnitId.mega_pascal);

	/** Surface zone torsion resistance (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId surface_zone_torsion_resistance = create("surface_zone_torsion_resistance", UnitId.mega_pascal);

	/** Survival probability (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId survival_probablity = create("survival_probablity", UnitId.percent);

	/** Tangential velocity at reference circle (Versions: 1.1, 1.2) */
	public static final AttributeId tangential_velocity_at_reference_circle = create("tangential_velocity_at_reference_circle", UnitId.m_per_second);

	/** Temperature difference inner / outer ring (Versions: 1.0) */
	public static final AttributeId temperature_difference = create("temperature_difference", UnitId.kelvin);

	/** Temperature difference between bearing and surroundings (Versions: 1.0) */
	public static final AttributeId temperature_difference_bearing_environment = create("temperature_difference_bearing_environment", UnitId.kelvin);

	/** Temperature difference between operation and assembly (Versions: 1.0) */
	public static final AttributeId temperature_difference_operation_and_installation = create("temperature_difference_operation_and_installation", UnitId.kelvin);

	/** Operating temperature of lubricant (Versions: 1.0, 1.0, 1.1, 1.2) */
	public static final AttributeId temperature_lubricant = create("temperature_lubricant", UnitId.degree_celsius);

	/** Tensile strength (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId tensile_strength = create("tensile_strength", UnitId.newton_per_mm2);

	/** Specific thermal capacity (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId thermal_capacity = create("thermal_capacity", UnitId.j_per_kg_k);

	/** Thermal conductivity (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId thermal_conductivity = create("thermal_conductivity", UnitId.watt_per_m_k);

	/** Thermal expansion coefficient (-) (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId thermal_expansion_coefficient_minus = create("thermal_expansion_coefficient_minus", UnitId.thermal_expansion_coefficient);

	/** Thermal expansion coefficient (+) (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId thermal_expansion_coefficient_plus = create("thermal_expansion_coefficient_plus", UnitId.thermal_expansion_coefficient);

	/** Tooth thickness modification coefficient (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId thickness_modification_coefficient = create("thickness_modification_coefficient", UnitId.none);

	/** Tilting of inner side around u axis (Versions: 1.1, 1.2) */
	public static final AttributeId tilting_inner_side_u = create("tilting_inner_side_u", UnitId.degree);

	/** Tilting of inner side around v axis (Versions: 1.1, 1.2) */
	public static final AttributeId tilting_inner_side_v = create("tilting_inner_side_v", UnitId.degree);

	/** Tilting of inner side around w axis (Versions: 1.1, 1.2) */
	public static final AttributeId tilting_inner_side_w = create("tilting_inner_side_w", UnitId.degree);

	/** Tilting of outer side around u axis (Versions: 1.1, 1.2) */
	public static final AttributeId tilting_outer_side_u = create("tilting_outer_side_u", UnitId.degree);

	/** Tilting around v axis of outer side (Versions: 1.1, 1.2) */
	public static final AttributeId tilting_outer_side_v = create("tilting_outer_side_v", UnitId.degree);

	/** Tilting around w axis of outer side (Versions: 1.1, 1.2) */
	public static final AttributeId tilting_outer_side_w = create("tilting_outer_side_w", UnitId.degree);

	/** Tilting around v axis (Versions: 1.1, 1.2) */
	public static final AttributeId tilting_v = create("tilting_v", UnitId.degree);

	/** Tilting around w axis (Versions: 1.1, 1.2) */
	public static final AttributeId tilting_w = create("tilting_w", UnitId.degree);

	/** Tip clearance (Versions: 1.2) */
	public static final AttributeId tip_clearance = create("tip_clearance", UnitId.mm);

	/** Tip clearance factor (Versions: 1.2) */
	public static final AttributeId tip_clearance_factor = create("tip_clearance_factor", UnitId.none);

	/** Tip circle diameter (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId tip_diameter = create("tip_diameter", UnitId.mm);

	/** Tip diameter  (DIN 3975 2017) (Versions: 1.2) */
	public static final AttributeId tip_diameter_din_3975_2017 = create("tip_diameter_din_3975_2017", UnitId.mm);

	/** Tip form diameter (Versions: 1.2) */
	public static final AttributeId tip_form_diameter = create("tip_form_diameter", UnitId.mm);

	/** Tip radius (Versions: 1.0, 1.0, 1.1, 1.2) */
	public static final AttributeId tip_radius = create("tip_radius", UnitId.mm);

	/** Tip radius factor (Versions: 1.0, 1.0, 1.1, 1.2) */
	public static final AttributeId tip_radius_factor = create("tip_radius_factor", UnitId.none);

	/** Diameter at start of tip relief (reference diameter) (Versions: 1.2) */
	public static final AttributeId tip_relief_datum_diameter = create("tip_relief_datum_diameter", UnitId.mm);

	/** Length of tip relief (Versions: 1.2) */
	public static final AttributeId tip_relief_datum_length = create("tip_relief_datum_length", UnitId.mm);

	/** Depth of tip relief (Versions: 1.2) */
	public static final AttributeId tip_relief_depth = create("tip_relief_depth", UnitId.mm);

	/** Diameter where tangential transition ends (Versions: 1.2) */
	public static final AttributeId tip_relief_diameter_where_tangential_transition_ends = create("tip_relief_diameter_where_tangential_transition_ends", UnitId.mm);

	/** Diameter where tangential transition starts (Versions: 1.2) */
	public static final AttributeId tip_relief_diameter_where_tangential_transition_starts = create("tip_relief_diameter_where_tangential_transition_starts", UnitId.mm);

	/** Diameter where amount of modification is specified (Versions: 1.2) */
	public static final AttributeId tip_relief_evaluation_reference = create("tip_relief_evaluation_reference", UnitId.mm);

	/** Rolling length where amount of modification is specified (Versions: 1.2) */
	public static final AttributeId tip_relief_evaluation_reference_length = create("tip_relief_evaluation_reference_length", UnitId.mm);

	/** Length of tangential transition end (Versions: 1.2) */
	public static final AttributeId tip_relief_length_of_tangential_transition_end = create("tip_relief_length_of_tangential_transition_end", UnitId.mm);

	/** Length of tangential transition start (Versions: 1.2) */
	public static final AttributeId tip_relief_length_of_tangential_transition_start = create("tip_relief_length_of_tangential_transition_start", UnitId.mm);

	/** Tool edge radius (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId tool_edge_radius = create("tool_edge_radius", UnitId.mm);

	/** Tooth depth (Versions: 1.2) */
	public static final AttributeId tooth_depth = create("tooth_depth", UnitId.mm);

	/** Tooth thickness (Versions: 1.2) */
	public static final AttributeId tooth_thickness = create("tooth_thickness", UnitId.mm);

	/** Transverse tooth thickness (Versions: 1.2) */
	public static final AttributeId tooth_thickness_at_pitch_diameter = create("tooth_thickness_at_pitch_diameter", UnitId.mm);

	/** DIN 3967 Deviation-tolerance series (Versions: 1.1, 1.2) */
	public static final AttributeId tooth_thickness_deviation_tolerance_series_din_3967_1978 = create("tooth_thickness_deviation_tolerance_series_din_3967_1978", UnitId.none);

	/** Tooth thickness loss (DIN 3996 2019) (Versions: 1.2) */
	public static final AttributeId tooth_thickness_loss_din_3996_2019 = create("tooth_thickness_loss_din_3996_2019", UnitId.mm);

	/** Tooth tip chamfer (radial amount) (Versions: 1.0, 1.0, 1.1, 1.2) */
	public static final AttributeId tooth_tip_chamfer = create("tooth_tip_chamfer", UnitId.mm);

	/** Amount of topographical deviation (Versions: 1.2) */
	public static final AttributeId topographical_deviation_amounts = create("topographical_deviation_amounts", UnitId.mm);

	/** Amount of topographical modification (Versions: 1.2) */
	public static final AttributeId topographical_modification_amounts = create("topographical_modification_amounts", UnitId.mm);

	/** Transmitted torque (with sign) (Versions: 1.1, 1.2) */
	public static final AttributeId torque = create("torque", UnitId.newton_m);

	/** Torque around u-axis acting on the component on the inner side (Versions: 1.1, 1.2) */
	public static final AttributeId torque_acting_on_inner_component_u = create("torque_acting_on_inner_component_u", UnitId.newton_m);

	/** Torque around v-axis acting on the component on the inner side (Versions: 1.1, 1.2) */
	public static final AttributeId torque_acting_on_inner_component_v = create("torque_acting_on_inner_component_v", UnitId.newton_m);

	/** Torque around w-axis acting on the component on the inner side (Versions: 1.1, 1.2) */
	public static final AttributeId torque_acting_on_inner_component_w = create("torque_acting_on_inner_component_w", UnitId.newton_m);

	/** Torque around u-axis acting on the component on the outer side (Versions: 1.1, 1.2) */
	public static final AttributeId torque_acting_on_outer_component_u = create("torque_acting_on_outer_component_u", UnitId.newton_m);

	/** Torque around v-axis acting on the component on the outer side (Versions: 1.1, 1.2) */
	public static final AttributeId torque_acting_on_outer_component_v = create("torque_acting_on_outer_component_v", UnitId.newton_m);

	/** Torque around w-axis acting on the component on the outer side (Versions: 1.1, 1.2) */
	public static final AttributeId torque_acting_on_outer_component_w = create("torque_acting_on_outer_component_w", UnitId.newton_m);

	/** Torque around v-axis acting on the shaft (Versions: 1.1, 1.2) */
	public static final AttributeId torque_acting_on_shaft_v = create("torque_acting_on_shaft_v", UnitId.newton_m);

	/** Torque around w-axis acting on the shaft (Versions: 1.1, 1.2) */
	public static final AttributeId torque_acting_on_shaft_w = create("torque_acting_on_shaft_w", UnitId.newton_m);

	/** Torque around the v-axis (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId torque_around_the_v_axis = create("torque_around_the_v_axis", UnitId.newton_m);

	/** Torque around the w-axis (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId torque_around_the_w_axis = create("torque_around_the_w_axis", UnitId.newton_m);

	/** Torque with sign (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId torque_around_u_axis = create("torque_around_u_axis", UnitId.newton_m);

	/** Torque around the v-axis (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId torque_around_v_axis = create("torque_around_v_axis", UnitId.newton_m);

	/** Torque around the w-axis (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId torque_around_w_axis = create("torque_around_w_axis", UnitId.newton_m);

	/** Torque distribution around the u-axis (Versions: 1.1, 1.2) */
	public static final AttributeId torque_distribution_u = create("torque_distribution_u", UnitId.newton_m);

	/** Torque distribution around the v-axis (Versions: 1.1, 1.2) */
	public static final AttributeId torque_distribution_v = create("torque_distribution_v", UnitId.newton_m);

	/** Torque distribution around the w-axis (Versions: 1.1, 1.2) */
	public static final AttributeId torque_distribution_w = create("torque_distribution_w", UnitId.newton_m);

	/** Torsion around the u-axis (Versions: 1.1, 1.2) */
	public static final AttributeId torsion_u = create("torsion_u", UnitId.degree);

	/** Total frictional power loss (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId total_frictional_power_loss = create("total_frictional_power_loss", UnitId.watt);

	/** Total frictional torque (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId total_frictional_torque = create("total_frictional_torque", UnitId.newton_m);

	/** Tooth force in u-direction (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId total_tooth_force_u_direction = create("total_tooth_force_u_direction", UnitId.kilo_newton);

	/** Tooth force in v-direction (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId total_tooth_force_v_direction = create("total_tooth_force_v_direction", UnitId.kilo_newton);

	/** Tooth force in w-direction (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId total_tooth_force_w_direction = create("total_tooth_force_w_direction", UnitId.kilo_newton);

	/** Load transmits torque (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId transmits_torque = create("transmits_torque", UnitId.none);

	/** Transverse base pitch (Versions: 1.1, 1.2) */
	public static final AttributeId transverse_base_pitch = create("transverse_base_pitch", UnitId.mm);

	/** Transverse circular pitch on reference circle (Versions: 1.1, 1.2) */
	public static final AttributeId transverse_circular_pitch_on_reference_circle = create("transverse_circular_pitch_on_reference_circle", UnitId.mm);

	/** Transverse module (Versions: 1.2) */
	public static final AttributeId transverse_module = create("transverse_module", UnitId.mm);

	/** Diameter of begin of triangular root relief (Versions: 1.2) */
	public static final AttributeId triangular_root_relief_datum_diameter = create("triangular_root_relief_datum_diameter", UnitId.mm);

	/** Length of triangular root relief (Versions: 1.2) */
	public static final AttributeId triangular_root_relief_datum_length = create("triangular_root_relief_datum_length", UnitId.mm);

	/** Depth of triangular root relief (Versions: 1.2) */
	public static final AttributeId triangular_root_relief_depth = create("triangular_root_relief_depth", UnitId.mm);

	/** Diameter where tangential transition of triangular root relief ends (Versions: 1.2) */
	public static final AttributeId triangular_root_relief_diameter_where_tangential_transition_ends = create("triangular_root_relief_diameter_where_tangential_transition_ends", UnitId.mm);

	/** Diameter where tangential transition of triangular root relief starts (Versions: 1.2) */
	public static final AttributeId triangular_root_relief_diameter_where_tangential_transition_starts = create("triangular_root_relief_diameter_where_tangential_transition_starts", UnitId.mm);

	/** Diameter where amount of triangular root relief is specified (Versions: 1.2) */
	public static final AttributeId triangular_root_relief_evaluation_reference = create("triangular_root_relief_evaluation_reference", UnitId.mm);

	/** Rolling length where amount of triangular root relief is specified (Versions: 1.2) */
	public static final AttributeId triangular_root_relief_evaluation_reference_length = create("triangular_root_relief_evaluation_reference_length", UnitId.mm);

	/** Length of tangential transition of triangular  root relief end (Versions: 1.2) */
	public static final AttributeId triangular_root_relief_length_of_tangential_transition_end = create("triangular_root_relief_length_of_tangential_transition_end", UnitId.mm);

	/** Length of tangential transition of triangular root relief start (Versions: 1.2) */
	public static final AttributeId triangular_root_relief_length_of_tangential_transition_start = create("triangular_root_relief_length_of_tangential_transition_start", UnitId.mm);

	/** Diameter of begin of triangular tip relief (Versions: 1.2) */
	public static final AttributeId triangular_tip_relief_datum_diameter = create("triangular_tip_relief_datum_diameter", UnitId.mm);

	/** Length of triangular tip relief (Versions: 1.2) */
	public static final AttributeId triangular_tip_relief_datum_length = create("triangular_tip_relief_datum_length", UnitId.mm);

	/** Depth of triangular tip relief (Versions: 1.2) */
	public static final AttributeId triangular_tip_relief_depth = create("triangular_tip_relief_depth", UnitId.mm);

	/** Diameter where tangential transition of triangular tip relief ends (Versions: 1.2) */
	public static final AttributeId triangular_tip_relief_diameter_where_tangential_transition_ends = create("triangular_tip_relief_diameter_where_tangential_transition_ends", UnitId.mm);

	/** Diameter where tangential transition of triangular tip relief starts (Versions: 1.2) */
	public static final AttributeId triangular_tip_relief_diameter_where_tangential_transition_starts = create("triangular_tip_relief_diameter_where_tangential_transition_starts", UnitId.mm);

	/** Diameter where amount of triangular tip relief is specified (Versions: 1.2) */
	public static final AttributeId triangular_tip_relief_evaluation_reference = create("triangular_tip_relief_evaluation_reference", UnitId.mm);

	/** Rolling length where amount of triangular tip relief is specified (Versions: 1.2) */
	public static final AttributeId triangular_tip_relief_evaluation_reference_length = create("triangular_tip_relief_evaluation_reference_length", UnitId.mm);

	/** Length of tangential transition of triangular tip relief end (Versions: 1.2) */
	public static final AttributeId triangular_tip_relief_length_of_tangential_transition_end = create("triangular_tip_relief_length_of_tangential_transition_end", UnitId.mm);

	/** Length of tangential transition of triangular tip relief start (Versions: 1.2) */
	public static final AttributeId triangular_tip_relief_length_of_tangential_transition_start = create("triangular_tip_relief_length_of_tangential_transition_start", UnitId.mm);

	/** Type of interpolation (Versions: 1.2) */
	public static final AttributeId type_of_interpolation_topographical_modification = create("type_of_interpolation_topographical_modification", UnitId.none);

	/** u-axis vector (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId u_axis_vector = create("u_axis_vector", UnitId.mm);

	/** u-coordinate on shaft (Versions: 1.0, 1.0, 1.0, 1.0, 1.1, 1.2) */
	public static final AttributeId u_coordinate_on_shaft = create("u_coordinate_on_shaft", UnitId.mm);

	/** Inner side: u-coordinate on shaft (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId u_coordinate_on_shaft_inner_side = create("u_coordinate_on_shaft_inner_side", UnitId.mm);

	/** Outer side: u-coordinate on shaft (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId u_coordinate_on_shaft_outer_side = create("u_coordinate_on_shaft_outer_side", UnitId.mm);

	/** u-coordinate on shaft on side 1 (Versions: 1.0) */
	public static final AttributeId u_coordinate_on_shaft_side_1 = create("u_coordinate_on_shaft_side_1", UnitId.mm);

	/** u-coordinate on shaft on side 2 (Versions: 1.0) */
	public static final AttributeId u_coordinate_on_shaft_side_2 = create("u_coordinate_on_shaft_side_2", UnitId.mm);

	/** U coordinates of beam nodes (Versions: 1.1, 1.2) */
	public static final AttributeId u_coordinates_of_beam_nodes = create("u_coordinates_of_beam_nodes", UnitId.mm);

	/** Upper diametric deviation (Versions: 1.2) */
	public static final AttributeId upper_backlash_allowance_balls_or_pins = create("upper_backlash_allowance_balls_or_pins", UnitId.mm);

	/** Upper base tangent length deviation (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId upper_backlash_allowance_referenced_to_span = create("upper_backlash_allowance_referenced_to_span", UnitId.mum);

	/** Upper centre distance allowance (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId upper_center_distance_allowance = create("upper_center_distance_allowance", UnitId.mum);

	/** Usable addendum circle diameter (Versions: 1.1, 1.2) */
	public static final AttributeId usable_addendum_circle_diameter = create("usable_addendum_circle_diameter", UnitId.mm);

	/** Usable root circle diameter (Versions: 1.1, 1.2) */
	public static final AttributeId usable_root_circle_diameter = create("usable_root_circle_diameter", UnitId.mm);

	/** Utilized dedenudum coefficient reference profile (Versions: 1.0, 1.0, 1.1, 1.2) */
	public static final AttributeId utilized_dedendum_coefficient_reference_profile = create("utilized_dedendum_coefficient_reference_profile", UnitId.none);

	/** Utilized dedendum reference profile (Versions: 1.0, 1.0, 1.1, 1.2) */
	public static final AttributeId utilized_dedendum_reference_profile = create("utilized_dedendum_reference_profile", UnitId.mm);

	/** Virtual number of teeth (Versions: 1.2) */
	public static final AttributeId virtual_number_of_teeth = create("virtual_number_of_teeth", UnitId.none);

	/** Viscosity at 100&deg;C (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId viscosity_at_100_degree_celsius = create("viscosity_at_100_degree_celsius", UnitId.mm2_per_s);

	/** Viscosity at 40&deg;C (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId viscosity_at_40_degree_celsius = create("viscosity_at_40_degree_celsius", UnitId.mm2_per_s);

	/** Viscosity ratio according to ISO 281 2007 (Versions: 1.1, 1.2) */
	public static final AttributeId viscosity_ratio_according_to_iso_281_2007 = create("viscosity_ratio_according_to_iso_281_2007", UnitId.none);

	/** Viscosity rating DIN 26281 (Versions: 1.0) */
	public static final AttributeId viscosity_ratio_din_26281 = create("viscosity_ratio_din_26281", UnitId.none);

	/** w-axis vector (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId w_axis_vector = create("w_axis_vector", UnitId.mm);

	/** Weibull exponent (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId weibull_exponent = create("weibull_exponent", UnitId.none);

	/** Bearing width (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId width = create("width", UnitId.mm);

	/** Working depth (Versions: 1.2) */
	public static final AttributeId working_depth = create("working_depth", UnitId.mm);

	/** Working depth factor (Versions: 1.2) */
	public static final AttributeId working_depth_coefficient = create("working_depth_coefficient", UnitId.none);

	/** Yield strength (Versions: 1.0, 1.1, 1.2) */
	public static final AttributeId yield_strength = create("yield_strength", UnitId.newton_per_mm2);

	/** The actual attribute ID as a {@link String}. */
	@EqualsAndHashCode.Include
	private final String id;

	/** The unit of the attribute as {@link UnitId}. */
	@EqualsAndHashCode.Include
	private final UnitId unit;

	private AttributeId(String id, UnitId unit) {
		if (id == null || id.isEmpty())
			throw new IllegalArgumentException("id cannot be empty");
		if (unit == null)
			throw new IllegalArgumentException("unit cannot be empty");
		this.id = id;
		this.unit = unit;
	}

	/**
	 * @return
	 * 				The actual attribute ID as a {@link String}.
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return
	 * 				The unit of the attribute as {@link UnitId}.
	 */
	public UnitId getUnit() {
		return unit;
	}

	/**
	 * Creates a new attribute ID and adds it to the internal index.
	 *
	 * @param id
	 * 				The actual attribute ID as {@link String}.
	 * @param unit
	 * 				The unit of the attribute as {@link UnitId}.
	 *
	 * @return
	 * 				The newly created attribute ID as {@link AttributeId}.
	 */
	public static AttributeId create(String id, UnitId unit) {
		AttributeId attributeId = new AttributeId(id, unit);
		allAttributeIds.put(id, attributeId);
		return attributeId;
	}

	/**
	 * Returns the attribute ID for a textual ID from the internally stored index of all attribute IDs.
	 *
	 * @param id
	 * 				The actual attribute ID to be found as a {@link String}
	 *
	 * @return
	 * 				The found attribute ID as {@link AttributeId}, or {@code null} if the ID could not be found.
	 */
	public static AttributeId findById(String id) {
		if (id == null)
			return null;
		return allAttributeIds.getOrDefault(id, null);
	}
}
