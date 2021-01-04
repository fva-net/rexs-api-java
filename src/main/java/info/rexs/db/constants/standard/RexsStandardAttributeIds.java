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

import info.rexs.db.constants.RexsAttributeId;
import info.rexs.db.constants.RexsUnitId;

/**
 * This class represents the ID of a REXS attribute.
 * <p>
 * It contains constants for all attribute IDs of official REXS versions (1.0, 1.1, 1.2, 1.3).
 *
 * @author FVA GmbH
 */
public interface RexsStandardAttributeIds {

	/** Acceleration factor according to FVA 341 (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId acceleration_factor_according_fva_341 = RexsAttributeId.create("acceleration_factor_according_fva_341", RexsUnitId.none);

	/** Account for gravity (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId account_for_gravity = RexsAttributeId.create("account_for_gravity", RexsUnitId.none);

	/** Account for shear deformation (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId account_for_shear_deformation = RexsAttributeId.create("account_for_shear_deformation", RexsUnitId.none);

	/** Actual tangential load (AGMA 925 A03) (Versions: 1.3) */
	public static final RexsAttributeId actual_tangential_load_agma_925_a03 = RexsAttributeId.create("actual_tangential_load_agma_925_a03", RexsUnitId.newton);

	/** Tooth tip height (Versions: 1.2, 1.3) */
	public static final RexsAttributeId addendum_basic_profile = RexsAttributeId.create("addendum_basic_profile", RexsUnitId.mm);

	/** Addendum coefficient of basic profile (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId addendum_coefficient_basic_profile = RexsAttributeId.create("addendum_coefficient_basic_profile", RexsUnitId.none);

	/** Addendum coefficient tool reference profile relative to module (Versions: 1.0, 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId addendum_coefficient_reference_profile = RexsAttributeId.create("addendum_coefficient_reference_profile", RexsUnitId.none);

	/** Addendum modification (profile shift) (Versions: 1.2, 1.3) */
	public static final RexsAttributeId addendum_modification = RexsAttributeId.create("addendum_modification", RexsUnitId.mm);

	/** Addendum modification coefficient (profile shift coefficient) (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId addendum_modification_coefficient = RexsAttributeId.create("addendum_modification_coefficient", RexsUnitId.none);

	/** Addendum modification coefficient (profile shift coefficient) finished gear (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId addendum_modification_coefficient_after_finishing = RexsAttributeId.create("addendum_modification_coefficient_after_finishing", RexsUnitId.none);

	/** Addendum modification coefficient worm wheel (Versions: 1.3) */
	public static final RexsAttributeId addendum_modification_coefficient_worm_wheel = RexsAttributeId.create("addendum_modification_coefficient_worm_wheel", RexsUnitId.none);

	/** Addendum reference profile of tool (Versions: 1.0, 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId addendum_reference_profile = RexsAttributeId.create("addendum_reference_profile", RexsUnitId.mm);

	/** All bearing elements are identical (Versions: 1.0) */
	public static final RexsAttributeId all_rolling_elements_are_identical = RexsAttributeId.create("all_rolling_elements_are_identical", RexsUnitId.none);

	/** All bearing rows are identical (Versions: 1.0) */
	public static final RexsAttributeId all_rows_are_identical = RexsAttributeId.create("all_rows_are_identical", RexsUnitId.none);

	/** Alternating bending strength (Versions: 1.3) */
	public static final RexsAttributeId alternating_bending_strength_din_743_2012 = RexsAttributeId.create("alternating_bending_strength_din_743_2012", RexsUnitId.newton_per_mm2);

	/** Alternating tension/ compression strength (Versions: 1.3) */
	public static final RexsAttributeId alternating_tensile_strength_din_743_2012 = RexsAttributeId.create("alternating_tensile_strength_din_743_2012", RexsUnitId.newton_per_mm2);

	/** Alternating torsional strength (Versions: 1.3) */
	public static final RexsAttributeId alternating_torsion_strength_din_743_2012 = RexsAttributeId.create("alternating_torsion_strength_din_743_2012", RexsUnitId.newton_per_mm2);

	/** Ambient temperature (VDI 2736 2014) (Versions: 1.3) */
	public static final RexsAttributeId ambient_temperature_vdi_2736_2014 = RexsAttributeId.create("ambient_temperature_vdi_2736_2014", RexsUnitId.degree_celsius);

	/** Angle of blade sequence (Versions: 1.3) */
	public static final RexsAttributeId angle_of_blade_sequence = RexsAttributeId.create("angle_of_blade_sequence", RexsUnitId.degree);

	/** Relative tilting of the inner ring around the v-axis compared to the outer ring. (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId angular_deflection_in_v = RexsAttributeId.create("angular_deflection_in_v", RexsUnitId.radian);

	/** Relative tilting of the inner ring around the w-axis compared to the outer ring. (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId angular_deflection_in_w = RexsAttributeId.create("angular_deflection_in_w", RexsUnitId.radian);

	/** Angular offset of the mounting position of the outer ring around the v-axis (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId angular_misalignment_around_v_axis = RexsAttributeId.create("angular_misalignment_around_v_axis", RexsUnitId.degree);

	/** Angular offset of the mounting position of the outer ring around the w-axis (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId angular_misalignment_around_w_axis = RexsAttributeId.create("angular_misalignment_around_w_axis", RexsUnitId.degree);

	/** Angular motion coefficients (Versions: 1.3) */
	public static final RexsAttributeId angular_motion_coefficients = RexsAttributeId.create("angular_motion_coefficients", RexsUnitId.none);

	/** Angular position around u axis (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId angular_position_around_u = RexsAttributeId.create("angular_position_around_u", RexsUnitId.degree);

	/** Angular velocity (Versions: 1.3) */
	public static final RexsAttributeId angular_velocity = RexsAttributeId.create("angular_velocity", RexsUnitId.radian_per_s);

	/** Application factor (Versions: 1.3) */
	public static final RexsAttributeId application_factor_din_3996_2019 = RexsAttributeId.create("application_factor_din_3996_2019", RexsUnitId.none);

	/** Application factor for fatigue load (VDI 2736 2014) (Versions: 1.3) */
	public static final RexsAttributeId application_factor_for_fatigue_load_vdi_2736_2014 = RexsAttributeId.create("application_factor_for_fatigue_load_vdi_2736_2014", RexsUnitId.none);

	/** Application factor (ISO 6336 2006) (Versions: 1.3) */
	public static final RexsAttributeId application_factor_iso_6336_2006 = RexsAttributeId.create("application_factor_iso_6336_2006", RexsUnitId.none);

	/** Estimated strength value design calculation VDI 2736 2014 (Versions: 1.3) */
	public static final RexsAttributeId approximate_strength_value_vdi_2736_2014 = RexsAttributeId.create("approximate_strength_value_vdi_2736_2014", RexsUnitId.newton_per_mm2);

	/** Approximated standard deviation of scuffing temperature (AGMA 925 A03) (Versions: 1.3) */
	public static final RexsAttributeId approximated_standard_deviation_of_scuffing_temperature_agma_925_a03 = RexsAttributeId.create("approximated_standard_deviation_of_scuffing_temperature_agma_925_a03", RexsUnitId.degree_celsius);

	/** Average surface roughness for filter cutoff length (AGMA 925 C95) (Versions: 1.3) */
	public static final RexsAttributeId arithmentic_mean_roughness_at_filter_cutoff_of_wavelength_agma_925_a03 = RexsAttributeId.create("arithmentic_mean_roughness_at_filter_cutoff_of_wavelength_agma_925_a03", RexsUnitId.mum);

	/** Arithmetic average of R_q1x (Pinion) and R_q2x (Gear) at filter cutoff of wavelength (AGMA 925 A03) (Versions: 1.3) */
	public static final RexsAttributeId arithmetic_average_of_root_mean_square_roughness_of_pinion_and_gear_agma_925_a03 = RexsAttributeId.create("arithmetic_average_of_root_mean_square_roughness_of_pinion_and_gear_agma_925_a03", RexsUnitId.mum);

	/** Arithmetic average roughness flank (Versions: 1.2, 1.3) */
	public static final RexsAttributeId arithmetic_average_roughness_flank = RexsAttributeId.create("arithmetic_average_roughness_flank", RexsUnitId.mum);

	/** Arithmetic average roughness root (Versions: 1.2, 1.3) */
	public static final RexsAttributeId arithmetic_average_roughness_root = RexsAttributeId.create("arithmetic_average_roughness_root", RexsUnitId.mum);

	/** Averaged linear wear  (VDI 2736 2014) (Versions: 1.3) */
	public static final RexsAttributeId averaged_linear_wear_vdi_2736_2014 = RexsAttributeId.create("averaged_linear_wear_vdi_2736_2014", RexsUnitId.mm);

	/** Averaged peak-to-valley height flank (Versions: 1.3) */
	public static final RexsAttributeId averaged_peak_to_valley_height_flank = RexsAttributeId.create("averaged_peak_to_valley_height_flank", RexsUnitId.mum);

	/** Averaged peak-to-valley height root (Versions: 1.2, 1.3) */
	public static final RexsAttributeId averaged_peak_to_valley_height_root = RexsAttributeId.create("averaged_peak_to_valley_height_root", RexsUnitId.mum);

	/** Axial backlash (Versions: 1.0) */
	public static final RexsAttributeId axial_backlash = RexsAttributeId.create("axial_backlash", RexsUnitId.mum);

	/** Axial increase of backlash (Versions: 1.3) */
	public static final RexsAttributeId axial_backlash_increase = RexsAttributeId.create("axial_backlash_increase", RexsUnitId.mm);

	/** Axial bearing clearance (before mounting) (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId axial_bearing_clearance = RexsAttributeId.create("axial_bearing_clearance", RexsUnitId.mum);

	/** Axial bearing clearance class (before mounting) (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId axial_clearance_class = RexsAttributeId.create("axial_clearance_class", RexsUnitId.none);

	/** Relative displacement of the inner ring in the u-direction compared to the outer ring (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId axial_deflection = RexsAttributeId.create("axial_deflection", RexsUnitId.mum);

	/** Axial displacement of gear (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId axial_displacement_gear = RexsAttributeId.create("axial_displacement_gear", RexsUnitId.mm);

	/** Axial displacement of pinion (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId axial_displacement_pinion = RexsAttributeId.create("axial_displacement_pinion", RexsUnitId.mm);

	/** Axial dynamic load rating (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId axial_dynamic_load_rating = RexsAttributeId.create("axial_dynamic_load_rating", RexsUnitId.kilo_newton);

	/** Axial factor (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId axial_factor_y_0 = RexsAttributeId.create("axial_factor_y_0", RexsUnitId.none);

	/** Axial load factor Y1 for F_a/F_r &lt;= e (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId axial_factor_y_1 = RexsAttributeId.create("axial_factor_y_1", RexsUnitId.none);

	/** Axial load factor Y2 for F_a/F_r &gt; e (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId axial_factor_y_2 = RexsAttributeId.create("axial_factor_y_2", RexsUnitId.none);

	/** Axial force in u-direction (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId axial_force = RexsAttributeId.create("axial_force", RexsUnitId.kilo_newton);

	/** Support of axial loads (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId axial_force_absorption = RexsAttributeId.create("axial_force_absorption", RexsUnitId.none);

	/** Support of axial loads (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId axial_force_absorption_of_row = RexsAttributeId.create("axial_force_absorption_of_row", RexsUnitId.none);

	/** Maximum axial force (Versions: 1.3) */
	public static final RexsAttributeId axial_force_maximum_din_743_2012 = RexsAttributeId.create("axial_force_maximum_din_743_2012", RexsUnitId.newton);

	/** Stress ratio of the axial force (Versions: 1.3) */
	public static final RexsAttributeId axial_force_stress_ratio_din_743_2012 = RexsAttributeId.create("axial_force_stress_ratio_din_743_2012", RexsUnitId.none);

	/** Upper value of axial force (Versions: 1.3) */
	public static final RexsAttributeId axial_force_upper_value_din_743_2012 = RexsAttributeId.create("axial_force_upper_value_din_743_2012", RexsUnitId.newton);

	/** Axial machining allowance (Versions: 1.3) */
	public static final RexsAttributeId axial_maching_allowance_din_509_2006 = RexsAttributeId.create("axial_maching_allowance_din_509_2006", RexsUnitId.mm);

	/** Axial module (Versions: 1.3) */
	public static final RexsAttributeId axial_module = RexsAttributeId.create("axial_module", RexsUnitId.mm);

	/** Axial module (DIN 3975 2017) (Versions: 1.2) */
	public static final RexsAttributeId axial_module_din_3975_2017 = RexsAttributeId.create("axial_module_din_3975_2017", RexsUnitId.mm);

	/** Axial pitch (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId axial_pitch = RexsAttributeId.create("axial_pitch", RexsUnitId.mm);

	/** Axial pitch (DIN 3975 2017) (Versions: 1.2) */
	public static final RexsAttributeId axial_pitch_din_3975_2017 = RexsAttributeId.create("axial_pitch_din_3975_2017", RexsUnitId.mm);

	/** Axial static load rating (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId axial_static_load_rating = RexsAttributeId.create("axial_static_load_rating", RexsUnitId.kilo_newton);

	/** Axial stiffness (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId axial_stiffness = RexsAttributeId.create("axial_stiffness", RexsUnitId.newton_per_m);

	/** Base circle diameter (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId base_circle_diameter = RexsAttributeId.create("base_circle_diameter", RexsUnitId.mm);

	/** Base circle diameter (DIN 3975 2017) (Versions: 1.2) */
	public static final RexsAttributeId base_circle_diameter_din_3975_2017 = RexsAttributeId.create("base_circle_diameter_din_3975_2017", RexsUnitId.mm);

	/** Basic factor according to FVA 341 (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId base_factor_according_fva_341 = RexsAttributeId.create("base_factor_according_fva_341", RexsUnitId.none);

	/** Basic crown gear addendum factor (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId basic_addendum_coefficient = RexsAttributeId.create("basic_addendum_coefficient", RexsUnitId.none);

	/** Basic crown gear dedendum factor (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId basic_dedendum_coefficient = RexsAttributeId.create("basic_dedendum_coefficient", RexsUnitId.none);

	/** Basic strength root (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId basic_strength_root = RexsAttributeId.create("basic_strength_root", RexsUnitId.newton_per_mm2);

	/** Basis of lubricant (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId basis = RexsAttributeId.create("basis", RexsUnitId.none);

	/** Bearing tolerance class (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId bearing_tolerance_class = RexsAttributeId.create("bearing_tolerance_class", RexsUnitId.none);

	/** Bearing type (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId bearing_type = RexsAttributeId.create("bearing_type", RexsUnitId.none);

	/** Tilting stiffness (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId bending_stiffness = RexsAttributeId.create("bending_stiffness", RexsUnitId.newton_mm_per_rad);

	/** Maximum bending torque (Versions: 1.3) */
	public static final RexsAttributeId bending_torque_maximum_din_743_2012 = RexsAttributeId.create("bending_torque_maximum_din_743_2012", RexsUnitId.newton_m);

	/** Stress ratio R of the bending moment (Versions: 1.3) */
	public static final RexsAttributeId bending_torque_stress_ratio_din_743_2012 = RexsAttributeId.create("bending_torque_stress_ratio_din_743_2012", RexsUnitId.none);

	/** Alternating load bending moment, upper value (Versions: 1.3) */
	public static final RexsAttributeId bending_torque_upper_value_din_743_2012 = RexsAttributeId.create("bending_torque_upper_value_din_743_2012", RexsUnitId.newton_m);

	/** Bending yield strength (Versions: 1.3) */
	public static final RexsAttributeId bending_yield_stress_din_743_2012 = RexsAttributeId.create("bending_yield_stress_din_743_2012", RexsUnitId.newton_per_mm2);

	/** Bevel orientation (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId bevel_cone_orientation = RexsAttributeId.create("bevel_cone_orientation", RexsUnitId.none);

	/** Blade dedenum (Versions: 1.3) */
	public static final RexsAttributeId blade_dedendum = RexsAttributeId.create("blade_dedendum", RexsUnitId.mm);

	/** Blade point radius (Versions: 1.3) */
	public static final RexsAttributeId blade_point_radius = RexsAttributeId.create("blade_point_radius", RexsUnitId.mm);

	/** Blade pressure angle (Versions: 1.3) */
	public static final RexsAttributeId blade_pressure_angle = RexsAttributeId.create("blade_pressure_angle", RexsUnitId.degree);

	/** Blade profile height (Versions: 1.3) */
	public static final RexsAttributeId blade_profile_height = RexsAttributeId.create("blade_profile_height", RexsUnitId.mm);

	/** Blade spheric radius (Versions: 1.3) */
	public static final RexsAttributeId blade_spheric_radius = RexsAttributeId.create("blade_spheric_radius", RexsUnitId.mm);

	/** Surface roughness of casing bore (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId bore_surface_roughness = RexsAttributeId.create("bore_surface_roughness", RexsUnitId.mum);

	/** Tolerance class of bore in bearing seat (Versions: 1.0) */
	public static final RexsAttributeId boring_tolerance_class = RexsAttributeId.create("boring_tolerance_class", RexsUnitId.none);

	/** Bottom clearance factor (Versions: 1.0, 1.1) */
	public static final RexsAttributeId bottom_clearance_factor = RexsAttributeId.create("bottom_clearance_factor", RexsUnitId.none);

	/** Bulk temperature (Versions: 1.3) */
	public static final RexsAttributeId bulk_temperature = RexsAttributeId.create("bulk_temperature", RexsUnitId.degree_celsius);

	/** Tolerance class of casing bore (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId casing_bore_tolerance_class = RexsAttributeId.create("casing_bore_tolerance_class", RexsUnitId.none);

	/** Outer diameter of casing for the operating clearance calculation (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId casing_outer_diameter = RexsAttributeId.create("casing_outer_diameter", RexsUnitId.mm);

	/** Catalogue designation (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId catalogue_designation = RexsAttributeId.create("catalogue_designation", RexsUnitId.none);

	/** Catalogue value e (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId catalogue_value_e = RexsAttributeId.create("catalogue_value_e", RexsUnitId.none);

	/** Center distance (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId center_distance = RexsAttributeId.create("center_distance", RexsUnitId.mm);

	/** Center distance correction (Versions: 1.3) */
	public static final RexsAttributeId center_distance_correction = RexsAttributeId.create("center_distance_correction", RexsUnitId.mm);

	/** Offset of center distance (Versions: 1.3) */
	public static final RexsAttributeId center_distance_offset = RexsAttributeId.create("center_distance_offset", RexsUnitId.mm);

	/** Din 3964 center distance tolerance field (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId center_distance_tolerance_field_din_3964_1980 = RexsAttributeId.create("center_distance_tolerance_field_din_3964_1980", RexsUnitId.none);

	/** Center roll position (Versions: 1.3) */
	public static final RexsAttributeId center_roll_position = RexsAttributeId.create("center_roll_position", RexsUnitId.degree);

	/** Central film thickness at the calculation points (AGMA 925 A03) (Versions: 1.3) */
	public static final RexsAttributeId central_film_thickness_at_calculation_points_agma_925_a03 = RexsAttributeId.create("central_film_thickness_at_calculation_points_agma_925_a03", RexsUnitId.mum);

	/** Chamfer angle (Versions: 1.0, 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId chamfer_angle = RexsAttributeId.create("chamfer_angle", RexsUnitId.degree);

	/** Chamfer ange (Versions: 1.3) */
	public static final RexsAttributeId chamfer_angle_worm_wheel = RexsAttributeId.create("chamfer_angle_worm_wheel", RexsUnitId.degree);

	/** Chamfer at end of tooth (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId chamfer_at_tooth_end = RexsAttributeId.create("chamfer_at_tooth_end", RexsUnitId.mm);

	/** Chamfer distance (Versions: 1.3) */
	public static final RexsAttributeId chamfer_distance_worm_wheel = RexsAttributeId.create("chamfer_distance_worm_wheel", RexsUnitId.mm);

	/** Cordal height (Versions: 1.2, 1.3) */
	public static final RexsAttributeId chordal_height = RexsAttributeId.create("chordal_height", RexsUnitId.mm);

	/** Chordal tooth thickness between B and D (ISO 6336 2019) (Versions: 1.3) */
	public static final RexsAttributeId chordal_tooth_thickness_between_point_b_and_d_iso_6336_2019 = RexsAttributeId.create("chordal_tooth_thickness_between_point_b_and_d_iso_6336_2019", RexsUnitId.mm);

	/** Chordal tooth thickness lower deviation (Versions: 1.2, 1.3) */
	public static final RexsAttributeId chordal_tooth_thickness_lower_deviation = RexsAttributeId.create("chordal_tooth_thickness_lower_deviation", RexsUnitId.mm);

	/** Chordal tooth thickness upper deviation (Versions: 1.2, 1.3) */
	public static final RexsAttributeId chordal_tooth_thickness_upper_deviation = RexsAttributeId.create("chordal_tooth_thickness_upper_deviation", RexsUnitId.mm);

	/** Chordal transverse tooth thickness lower deviation (Versions: 1.2, 1.3) */
	public static final RexsAttributeId chordal_transverse_tooth_thickness_lower_deviation = RexsAttributeId.create("chordal_transverse_tooth_thickness_lower_deviation", RexsUnitId.mm);

	/** Chordal transverse tooth thickness upper  deviation (Versions: 1.2, 1.3) */
	public static final RexsAttributeId chordal_transverse_tooth_thickness_upper_deviation = RexsAttributeId.create("chordal_transverse_tooth_thickness_upper_deviation", RexsUnitId.mm);

	/** Bearing clearance class (Versions: 1.0) */
	public static final RexsAttributeId clearance_class = RexsAttributeId.create("clearance_class", RexsUnitId.none);

	/** Coefficient of friction &micro; determined according to VDI 2736 2014 (Versions: 1.3) */
	public static final RexsAttributeId coefficient_of_friction_is_determined_according_to_vdi_2736_2014 = RexsAttributeId.create("coefficient_of_friction_is_determined_according_to_vdi_2736_2014", RexsUnitId.none);

	/** Coefficient of friction (VDI 2736 2014) (Versions: 1.3) */
	public static final RexsAttributeId coefficient_of_friction_vdi_2736_2014 = RexsAttributeId.create("coefficient_of_friction_vdi_2736_2014", RexsUnitId.none);

	/** Combined derating factor (AGMA 925 A03) (Versions: 1.3) */
	public static final RexsAttributeId combined_derating_factor_agma_925_a03 = RexsAttributeId.create("combined_derating_factor_agma_925_a03", RexsUnitId.none);

	/** Combined influence factor bending (Versions: 1.3) */
	public static final RexsAttributeId combined_influence_factor_bending_din_743_2012 = RexsAttributeId.create("combined_influence_factor_bending_din_743_2012", RexsUnitId.none);

	/** Combined influence factor tension/ compression (Versions: 1.3) */
	public static final RexsAttributeId combined_influence_factor_tension_compression_din_743_2012 = RexsAttributeId.create("combined_influence_factor_tension_compression_din_743_2012", RexsUnitId.none);

	/** Combined influence factor torsion (Versions: 1.3) */
	public static final RexsAttributeId combined_influence_factor_torsion_din_743_2012 = RexsAttributeId.create("combined_influence_factor_torsion_din_743_2012", RexsUnitId.none);

	/** Common face width (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId common_face_width = RexsAttributeId.create("common_face_width", RexsUnitId.mm);

	/** Composite surface roughness for filter cutoff wavelength L_x (AGMA 925 A03) (Versions: 1.3) */
	public static final RexsAttributeId composite_surface_roughess_agma_925_a03 = RexsAttributeId.create("composite_surface_roughess_agma_925_a03", RexsUnitId.mum);

	/** Contact factor (tooth bending) (Versions: 1.3) */
	public static final RexsAttributeId contact_factor_tooth_bending_din_3996_2019 = RexsAttributeId.create("contact_factor_tooth_bending_din_3996_2019", RexsUnitId.none);

	/** Flank contact ratio factor (VDI 2736 2014) (Versions: 1.3) */
	public static final RexsAttributeId contact_ratio_factor_flank_vdi_2736_2014 = RexsAttributeId.create("contact_ratio_factor_flank_vdi_2736_2014", RexsUnitId.none);

	/** Root contact ratio factor (VDI 2736 2014) (Versions: 1.3) */
	public static final RexsAttributeId contact_ratio_factor_root_vdi_2736_2014 = RexsAttributeId.create("contact_ratio_factor_root_vdi_2736_2014", RexsUnitId.none);

	/** Contact pattern ratio from local loaded tooth contact analysis (Versions: 1.3) */
	public static final RexsAttributeId contact_ratio_ltca_worm_stage = RexsAttributeId.create("contact_ratio_ltca_worm_stage", RexsUnitId.percent);

	/** Contact ratio (Versions: 1.3) */
	public static final RexsAttributeId contact_ratio_worm_stage = RexsAttributeId.create("contact_ratio_worm_stage", RexsUnitId.none);

	/** Contamination coefficient (Versions: 1.0) */
	public static final RexsAttributeId contamination_factor_according_to_din_26281 = RexsAttributeId.create("contamination_factor_according_to_din_26281", RexsUnitId.none);

	/** Contamination coefficient according to ISO 281 2007 (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId contamination_factor_according_to_iso_281_2007 = RexsAttributeId.create("contamination_factor_according_to_iso_281_2007", RexsUnitId.none);

	/** Deviation factor (measuring piece) (Versions: 1.2, 1.3) */
	public static final RexsAttributeId conversion_factor = RexsAttributeId.create("conversion_factor", RexsUnitId.none);

	/** Deviation of base tangent length factor (Versions: 1.2, 1.3) */
	public static final RexsAttributeId conversion_factor_of_backlash_allowance = RexsAttributeId.create("conversion_factor_of_backlash_allowance", RexsUnitId.none);

	/** Cooling power (Versions: 1.3) */
	public static final RexsAttributeId cooling_power_din_3996_2019 = RexsAttributeId.create("cooling_power_din_3996_2019", RexsUnitId.watt);

	/** Coordinate where amount of modification is specified at datum face (Versions: 1.2, 1.3) */
	public static final RexsAttributeId coordinate_where_helix_crowning_is_specified_datum_face = RexsAttributeId.create("coordinate_where_helix_crowning_is_specified_datum_face", RexsUnitId.mm);

	/** Coordinate where amount of modification is specified at non-datum face (Versions: 1.2, 1.3) */
	public static final RexsAttributeId coordinate_where_helix_crowning_is_specified_non_datum_face = RexsAttributeId.create("coordinate_where_helix_crowning_is_specified_non_datum_face", RexsUnitId.mm);

	/** Face width coordinates of helix deviations (Versions: 1.2, 1.3) */
	public static final RexsAttributeId coordinates_of_helix_deviation = RexsAttributeId.create("coordinates_of_helix_deviation", RexsUnitId.mm);

	/** Coordinates  of topographical deviation (Versions: 1.2, 1.3) */
	public static final RexsAttributeId coordinates_of_topographical_deviation = RexsAttributeId.create("coordinates_of_topographical_deviation", RexsUnitId.mm);

	/** Coordinates  of topographical modification (Versions: 1.2, 1.3) */
	public static final RexsAttributeId coordinates_of_topographical_modification = RexsAttributeId.create("coordinates_of_topographical_modification", RexsUnitId.mm);

	/** Core hardness Brinell (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId core_hardness_brinell = RexsAttributeId.create("core_hardness_brinell", RexsUnitId.hb);

	/** Core hardness Rockwell (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId core_hardness_rockwell = RexsAttributeId.create("core_hardness_rockwell", RexsUnitId.hrc);

	/** Core hardness Vickers (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId core_hardness_vickers = RexsAttributeId.create("core_hardness_vickers", RexsUnitId.hv);

	/** Crowning of the mating flanks (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId crowning_of_the_mating_flanks = RexsAttributeId.create("crowning_of_the_mating_flanks", RexsUnitId.none);

	/** Cutter module (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId cutter_module = RexsAttributeId.create("cutter_module", RexsUnitId.mm);

	/** Cutter radius (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId cutter_radius = RexsAttributeId.create("cutter_radius", RexsUnitId.mm);

	/** Cutter swivel (Versions: 1.3) */
	public static final RexsAttributeId cutter_swivel = RexsAttributeId.create("cutter_swivel", RexsUnitId.degree);

	/** Cutter tilt (Versions: 1.3) */
	public static final RexsAttributeId cutter_tilt = RexsAttributeId.create("cutter_tilt", RexsUnitId.degree);

	/** Orientation datum face (Versions: 1.2, 1.3) */
	public static final RexsAttributeId datum_face_orientation = RexsAttributeId.create("datum_face_orientation", RexsUnitId.none);

	/** Nominal outer diameter of casing (Versions: 1.0) */
	public static final RexsAttributeId decisive_housing_outer_diameter = RexsAttributeId.create("decisive_housing_outer_diameter", RexsUnitId.mm);

	/** Nominal inner diameter of shaft (Versions: 1.0) */
	public static final RexsAttributeId decisive_pin_diameter = RexsAttributeId.create("decisive_pin_diameter", RexsUnitId.mm);

	/** Dedendum coefficient tool reference profile relative to module (Versions: 1.0, 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId dedendum_coefficient_reference_profile = RexsAttributeId.create("dedendum_coefficient_reference_profile", RexsUnitId.none);

	/** Dedendum reference profile (Versions: 1.0, 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId dedendum_reference_profile = RexsAttributeId.create("dedendum_reference_profile", RexsUnitId.mm);

	/** Shaft defines rotational speed (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId defines_speed = RexsAttributeId.create("defines_speed", RexsUnitId.none);

	/** External load defines torque (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId defines_torque = RexsAttributeId.create("defines_torque", RexsUnitId.none);

	/** Deflection (DIN 3996 2019) (Versions: 1.2, 1.3) */
	public static final RexsAttributeId deflection_din_3996_2019 = RexsAttributeId.create("deflection_din_3996_2019", RexsUnitId.mm);

	/** Deformation of the tooth tip in circumferential direction (VDI 2736 2014) (Versions: 1.3) */
	public static final RexsAttributeId deformation_of_tooth_tip_vdi_2736_2014 = RexsAttributeId.create("deformation_of_tooth_tip_vdi_2736_2014", RexsUnitId.mm);

	/** Degree of tooth loss (VDI 2736 2014) (Versions: 1.3) */
	public static final RexsAttributeId degree_of_tooth_loss_vdi_2736_2014 = RexsAttributeId.create("degree_of_tooth_loss_vdi_2736_2014", RexsUnitId.none);

	/** Density (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId density = RexsAttributeId.create("density", RexsUnitId.kg_per_dm3);

	/** Density at 15&deg;C (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId density_at_15_degree_celsius = RexsAttributeId.create("density_at_15_degree_celsius", RexsUnitId.kg_per_dm3);

	/** Case hardening depth at 550 HV (Versions: 1.3) */
	public static final RexsAttributeId depth_of_case_hardening_at_550_hv = RexsAttributeId.create("depth_of_case_hardening_at_550_hv", RexsUnitId.mm);

	/** Depth of immersion of bearing into oil (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId depth_of_immersion_in_oil = RexsAttributeId.create("depth_of_immersion_in_oil", RexsUnitId.mm);

	/** Axial insertion depth (Versions: 1.3) */
	public static final RexsAttributeId depth_of_insert_axial = RexsAttributeId.create("depth_of_insert_axial", RexsUnitId.mm);

	/** Radial insertion depth (Versions: 1.3) */
	public static final RexsAttributeId depth_of_insert_radial = RexsAttributeId.create("depth_of_insert_radial", RexsUnitId.mm);

	/** Description how datum face is defined (Versions: 1.2, 1.3) */
	public static final RexsAttributeId description_datum_face = RexsAttributeId.create("description_datum_face", RexsUnitId.none);

	/** Application factor design calculation VDI 2736 2014 (Versions: 1.3) */
	public static final RexsAttributeId design_application_factor_vdi_2736_2014 = RexsAttributeId.create("design_application_factor_vdi_2736_2014", RexsUnitId.none);

	/** Design tooth flank temperature (VDI 2736 2014) (Versions: 1.3) */
	public static final RexsAttributeId design_flank_temperature_vdi_2736_2014 = RexsAttributeId.create("design_flank_temperature_vdi_2736_2014", RexsUnitId.degree_celsius);

	/** Design tooth root temperature  (VDI 2736 2014) (Versions: 1.3) */
	public static final RexsAttributeId design_root_temperature_vdi_2736_2014 = RexsAttributeId.create("design_root_temperature_vdi_2736_2014", RexsUnitId.degree_celsius);

	/** Design safety of the tooth flank  (VDI 2736 2014) (Versions: 1.3) */
	public static final RexsAttributeId design_safety_factor_flank_vdi_2736_2014 = RexsAttributeId.create("design_safety_factor_flank_vdi_2736_2014", RexsUnitId.none);

	/** Design safety of the tooth root  (VDI 2736 2014) (Versions: 1.3) */
	public static final RexsAttributeId design_safety_factor_root_vdi_2736_2014 = RexsAttributeId.create("design_safety_factor_root_vdi_2736_2014", RexsUnitId.none);

	/** Determination of bulk temperature (Versions: 1.3) */
	public static final RexsAttributeId determination_of_bulk_temperature_din_3996_2019 = RexsAttributeId.create("determination_of_bulk_temperature_din_3996_2019", RexsUnitId.none);

	/** Determination of cooling power (Versions: 1.3) */
	public static final RexsAttributeId determination_of_cooling_power_din_3996_2019 = RexsAttributeId.create("determination_of_cooling_power_din_3996_2019", RexsUnitId.none);

	/** Determination of deflection (Versions: 1.3) */
	public static final RexsAttributeId determination_of_deflection_din_3996_2019 = RexsAttributeId.create("determination_of_deflection_din_3996_2019", RexsUnitId.none);

	/** Determination of degree of tooth loss (VDI 2736 2014) (Versions: 1.3) */
	public static final RexsAttributeId determination_of_degree_of_tooth_loss_vdi_2736_2014 = RexsAttributeId.create("determination_of_degree_of_tooth_loss_vdi_2736_2014", RexsUnitId.none);

	/** Determination of factor K_H for tooth flank loading (VDI 2736 2014) (Versions: 1.3) */
	public static final RexsAttributeId determination_of_factor_for_tooth_flank_loading_vdi_2736_2014 = RexsAttributeId.create("determination_of_factor_for_tooth_flank_loading_vdi_2736_2014", RexsUnitId.none);

	/** Determination of factor K_F for tooth root loading (VDI 2736 2014) (Versions: 1.3) */
	public static final RexsAttributeId determination_of_factor_for_tooth_root_loading_vdi_2736_2014 = RexsAttributeId.create("determination_of_factor_for_tooth_root_loading_vdi_2736_2014", RexsUnitId.none);

	/** Determination of the load cycle-dependent fatigue strength under pulsating stress (VDI 2736 2014) (Versions: 1.3) */
	public static final RexsAttributeId determination_of_fatigue_strength_under_pulsating_stress_vdi_2736_2014 = RexsAttributeId.create("determination_of_fatigue_strength_under_pulsating_stress_vdi_2736_2014", RexsUnitId.none);

	/** Determination of flank loss (Versions: 1.3) */
	public static final RexsAttributeId determination_of_flank_loss_din_3996_2019 = RexsAttributeId.create("determination_of_flank_loss_din_3996_2019", RexsUnitId.none);

	/** Determination of hardness depth profile (ISO 6336 2019) (Versions: 1.3) */
	public static final RexsAttributeId determination_of_hardness_depth_profile_iso_6336_2019 = RexsAttributeId.create("determination_of_hardness_depth_profile_iso_6336_2019", RexsUnitId.none);

	/** Determination of local Hertzian contact stress (ISO 6336 2019) (Versions: 1.3) */
	public static final RexsAttributeId determination_of_local_hertzian_contact_stress_iso_6336_2019 = RexsAttributeId.create("determination_of_local_hertzian_contact_stress_iso_6336_2019", RexsUnitId.none);

	/** Method for approximating mean coefficient of friction (AGMA 925 C95) (Versions: 1.3) */
	public static final RexsAttributeId determination_of_mean_coefficient_of_friction_agma_925_a03 = RexsAttributeId.create("determination_of_mean_coefficient_of_friction_agma_925_a03", RexsUnitId.none);

	/** Determination of mean hertzian stress (Versions: 1.3) */
	public static final RexsAttributeId determination_of_mean_hertzian_stress_din_3996_2019 = RexsAttributeId.create("determination_of_mean_hertzian_stress_din_3996_2019", RexsUnitId.none);

	/** Determination of mean minimum lubricant film thickness (Versions: 1.3) */
	public static final RexsAttributeId determination_of_mean_minimum_lubricant_film_thickness_din_3996_2019 = RexsAttributeId.create("determination_of_mean_minimum_lubricant_film_thickness_din_3996_2019", RexsUnitId.none);

	/** Determination of meshing power loss (Versions: 1.3) */
	public static final RexsAttributeId determination_of_meshing_power_loss_din_3996_2019 = RexsAttributeId.create("determination_of_meshing_power_loss_din_3996_2019", RexsUnitId.none);

	/** Determination of the temperature-dependant modulus of elasticity (VDI 2736 2014) (Versions: 1.3) */
	public static final RexsAttributeId determination_of_modulus_of_elasticity_vdi_2736_2014 = RexsAttributeId.create("determination_of_modulus_of_elasticity_vdi_2736_2014", RexsUnitId.none);

	/** Determination of oil sump temperature (Versions: 1.3) */
	public static final RexsAttributeId determination_of_oil_sump_temperature_din_3996_2019 = RexsAttributeId.create("determination_of_oil_sump_temperature_din_3996_2019", RexsUnitId.none);

	/** Determination of permissible wear erosion (Plewe 1980) (Versions: 1.3) */
	public static final RexsAttributeId determination_of_permissible_wear_erosion_plewe_1980 = RexsAttributeId.create("determination_of_permissible_wear_erosion_plewe_1980", RexsUnitId.none);

	/** Determination of the temperature-dependent Poisson's ratio (VDI 2736 2014) (Versions: 1.3) */
	public static final RexsAttributeId determination_of_poissons_ratio_vdi_2736_2014 = RexsAttributeId.create("determination_of_poissons_ratio_vdi_2736_2014", RexsUnitId.none);

	/** Determination of residual stress depth profile (ISO 6336 2019) (Versions: 1.3) */
	public static final RexsAttributeId determination_of_residual_stress_depth_profile_iso_6336_2019 = RexsAttributeId.create("determination_of_residual_stress_depth_profile_iso_6336_2019", RexsUnitId.none);

	/** Determination of the load cycle-dependent rolling contact fatigue strength (VDI 2736 2014) (Versions: 1.3) */
	public static final RexsAttributeId determination_of_rolling_contact_fatigue_strength_vdi_2736_2014 = RexsAttributeId.create("determination_of_rolling_contact_fatigue_strength_vdi_2736_2014", RexsUnitId.none);

	/** Method of calculating scuffing temperature (AGMA 925 A03) (Versions: 1.3) */
	public static final RexsAttributeId determination_of_scuffing_temperature_agma_925_a03 = RexsAttributeId.create("determination_of_scuffing_temperature_agma_925_a03", RexsUnitId.none);

	/** Determination of mean sliding path (Versions: 1.3) */
	public static final RexsAttributeId determination_of_sliding_path_din_3996_2019 = RexsAttributeId.create("determination_of_sliding_path_din_3996_2019", RexsUnitId.none);

	/** Determination of spiral angle factor Z_&beta; (VDI 2736 2014) (Versions: 1.3) */
	public static final RexsAttributeId determination_of_spiral_angle_factor_vdi_2736_2014 = RexsAttributeId.create("determination_of_spiral_angle_factor_vdi_2736_2014", RexsUnitId.none);

	/** Determination of stress correction factor notch effect (VDI 2736 2014) (Versions: 1.3) */
	public static final RexsAttributeId determination_of_stress_correction_factor_notch_effect_vdi_2736_2014 = RexsAttributeId.create("determination_of_stress_correction_factor_notch_effect_vdi_2736_2014", RexsUnitId.none);

	/** Determination of tooth root safety (Versions: 1.3) */
	public static final RexsAttributeId determination_of_tooth_root_safety_din_3996_2019 = RexsAttributeId.create("determination_of_tooth_root_safety_din_3996_2019", RexsUnitId.none);

	/** Determination of total efficiency (Versions: 1.3) */
	public static final RexsAttributeId determination_of_total_efficiency_din_3996_2019 = RexsAttributeId.create("determination_of_total_efficiency_din_3996_2019", RexsUnitId.none);

	/** Determination of wear coefficient (VDI 2736 2014) (Versions: 1.3) */
	public static final RexsAttributeId determination_of_wear_coefficient_vdi_2736_2014 = RexsAttributeId.create("determination_of_wear_coefficient_vdi_2736_2014", RexsUnitId.none);

	/** Determination of the tmperature-dependant yield strength (VDI 2736 2014) (Versions: 1.3) */
	public static final RexsAttributeId determination_of_yield_strength_vdi_2736_2014 = RexsAttributeId.create("determination_of_yield_strength_vdi_2736_2014", RexsUnitId.none);

	/** Deviation of hypoid offset (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId deviation_of_offset = RexsAttributeId.create("deviation_of_offset", RexsUnitId.mm);

	/** Deviation of shaft angle (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId deviation_of_shaft_angle = RexsAttributeId.create("deviation_of_shaft_angle", RexsUnitId.degree);

	/** Figure number for contamination coefficient in DIN 26281 (Versions: 1.0) */
	public static final RexsAttributeId diagram_number_in_din_26281 = RexsAttributeId.create("diagram_number_in_din_26281", RexsUnitId.none);

	/** Figure number for contamination coefficient e_C in ISO 281 2007 (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId diagram_number_in_iso_281_2007 = RexsAttributeId.create("diagram_number_in_iso_281_2007", RexsUnitId.none);

	/** Diameters of helix deviations (Versions: 1.2, 1.3) */
	public static final RexsAttributeId diameter_of_helix_deviation = RexsAttributeId.create("diameter_of_helix_deviation", RexsUnitId.mm);

	/** Diameter of helix modification (Versions: 1.2, 1.3) */
	public static final RexsAttributeId diameter_of_helix_modification = RexsAttributeId.create("diameter_of_helix_modification", RexsUnitId.mm);

	/** Measuring ball or pin diameter (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId diameter_of_measuring_ball_or_pin = RexsAttributeId.create("diameter_of_measuring_ball_or_pin", RexsUnitId.mm);

	/** Diameter of rolling element (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId diameter_of_rolling_element = RexsAttributeId.create("diameter_of_rolling_element", RexsUnitId.mm);

	/** Diameter where amount of profile crowning at the root is specified (Versions: 1.2, 1.3) */
	public static final RexsAttributeId diameter_where_profile_crowning_root_is_specified = RexsAttributeId.create("diameter_where_profile_crowning_root_is_specified", RexsUnitId.mm);

	/** Diameter where amount of profile crowning at the tip is specified (Versions: 1.2, 1.3) */
	public static final RexsAttributeId diameter_where_profile_crowning_tip_is_specified = RexsAttributeId.create("diameter_where_profile_crowning_tip_is_specified", RexsUnitId.mm);

	/** Diameter where amount of modification is specified (Versions: 1.2, 1.3) */
	public static final RexsAttributeId diameter_where_profile_slope_amount_is_specified = RexsAttributeId.create("diameter_where_profile_slope_amount_is_specified", RexsUnitId.mm);

	/** Diameter where amount of profile twist is specified (Versions: 1.2, 1.3) */
	public static final RexsAttributeId diameter_where_profile_twist_amount_is_specified = RexsAttributeId.create("diameter_where_profile_twist_amount_is_specified", RexsUnitId.mm);

	/** Diameters of profile deviations (Versions: 1.2, 1.3) */
	public static final RexsAttributeId diameters_of_profile_deviation = RexsAttributeId.create("diameters_of_profile_deviation", RexsUnitId.mm);

	/** Diameters  of topographical deviation (Versions: 1.2, 1.3) */
	public static final RexsAttributeId diameters_of_topographical_deviation = RexsAttributeId.create("diameters_of_topographical_deviation", RexsUnitId.mm);

	/** Diameters  of topographical modification (Versions: 1.2, 1.3) */
	public static final RexsAttributeId diameters_of_topographical_modification = RexsAttributeId.create("diameters_of_topographical_modification", RexsUnitId.mm);

	/** Diametral measurement (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId diametral_measurement = RexsAttributeId.create("diametral_measurement", RexsUnitId.mm);

	/** Dimensionless central film thickness at the calculation points (AGMA 925 A03) (Versions: 1.3) */
	public static final RexsAttributeId dimensionless_central_film_thickness_at_calculation_points_agma_925_a03 = RexsAttributeId.create("dimensionless_central_film_thickness_at_calculation_points_agma_925_a03", RexsUnitId.none);

	/** Din 3964 center distance tolerance field (Versions: 1.0) */
	public static final RexsAttributeId din_3964_center_distance_tolerance_field = RexsAttributeId.create("din_3964_center_distance_tolerance_field", RexsUnitId.none);

	/** DIN 3967 Deviation-tolerance series (Versions: 1.0) */
	public static final RexsAttributeId din_3967_deviation_tolerance_series = RexsAttributeId.create("din_3967_deviation_tolerance_series", RexsUnitId.none);

	/** Direction vector of gravity u-coordinate (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId direction_vector_gravity_u = RexsAttributeId.create("direction_vector_gravity_u", RexsUnitId.none);

	/** Direction vector of gravity v-coordinate (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId direction_vector_gravity_v = RexsAttributeId.create("direction_vector_gravity_v", RexsUnitId.none);

	/** Direction vector of gravity w-coordinate (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId direction_vector_gravity_w = RexsAttributeId.create("direction_vector_gravity_w", RexsUnitId.none);

	/** Displacement in u direction at inner side (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId displacement_inner_side_u = RexsAttributeId.create("displacement_inner_side_u", RexsUnitId.mum);

	/** Displacement in v direction at inner side (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId displacement_inner_side_v = RexsAttributeId.create("displacement_inner_side_v", RexsUnitId.mum);

	/** Displacement in w direction at inner side (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId displacement_inner_side_w = RexsAttributeId.create("displacement_inner_side_w", RexsUnitId.mum);

	/** Displacement in u direction at outer side (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId displacement_outer_side_u = RexsAttributeId.create("displacement_outer_side_u", RexsUnitId.mum);

	/** Displacement in v direction at outer side (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId displacement_outer_side_v = RexsAttributeId.create("displacement_outer_side_v", RexsUnitId.mum);

	/** Displacement in w direction at outer side (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId displacement_outer_side_w = RexsAttributeId.create("displacement_outer_side_w", RexsUnitId.mum);

	/** Displacement in u direction (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId displacement_u = RexsAttributeId.create("displacement_u", RexsUnitId.mum);

	/** Axial displacement in u direction (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId displacement_u_of_nodes = RexsAttributeId.create("displacement_u_of_nodes", RexsUnitId.mum);

	/** Displacement in v direction (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId displacement_v = RexsAttributeId.create("displacement_v", RexsUnitId.mum);

	/** Radial displacement in v-direction (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId displacement_v_of_nodes = RexsAttributeId.create("displacement_v_of_nodes", RexsUnitId.mum);

	/** Displacement in w direction (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId displacement_w = RexsAttributeId.create("displacement_w", RexsUnitId.mum);

	/** Radial displacement in w-direction (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId displacement_w_of_nodes = RexsAttributeId.create("displacement_w_of_nodes", RexsUnitId.mum);

	/** Display color (Versions: 1.3) */
	public static final RexsAttributeId display_color = RexsAttributeId.create("display_color", RexsUnitId.percent);

	/** Distance along the line of action - Point A (AGMA 925 A03) (Versions: 1.3) */
	public static final RexsAttributeId distance_along_the_line_of_action_at_point_a_agma_925_a03 = RexsAttributeId.create("distance_along_the_line_of_action_at_point_a_agma_925_a03", RexsUnitId.mm);

	/** Distance along the line of action - Point B (AGMA 925 A03) (Versions: 1.3) */
	public static final RexsAttributeId distance_along_the_line_of_action_at_point_b_agma_925_a03 = RexsAttributeId.create("distance_along_the_line_of_action_at_point_b_agma_925_a03", RexsUnitId.mm);

	/** Distance along the line of action - Point C (AGMA 925 A03) (Versions: 1.3) */
	public static final RexsAttributeId distance_along_the_line_of_action_at_point_c_agma_925_a03 = RexsAttributeId.create("distance_along_the_line_of_action_at_point_c_agma_925_a03", RexsUnitId.mm);

	/** Distance along the line of action - Point D (AGMA 925 A03) (Versions: 1.3) */
	public static final RexsAttributeId distance_along_the_line_of_action_at_point_d_agma_925_a03 = RexsAttributeId.create("distance_along_the_line_of_action_at_point_d_agma_925_a03", RexsUnitId.mm);

	/** Distance along the line of action - Point E (AGMA 925 A03) (Versions: 1.3) */
	public static final RexsAttributeId distance_along_the_line_of_action_at_point_e_agma_925_a03 = RexsAttributeId.create("distance_along_the_line_of_action_at_point_e_agma_925_a03", RexsUnitId.mm);

	/** Distance along the line of action - Point F (AGMA 925 A03) (Versions: 1.3) */
	public static final RexsAttributeId distance_along_the_line_of_action_at_point_f_agma_925_a03 = RexsAttributeId.create("distance_along_the_line_of_action_at_point_f_agma_925_a03", RexsUnitId.mm);

	/** Distance between bearing rows (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId distance_between_bearing_rows = RexsAttributeId.create("distance_between_bearing_rows", RexsUnitId.mm);

	/** Distance from datum line to measuring line (Versions: 1.2, 1.3) */
	public static final RexsAttributeId distance_tool_profile_basic_line_to_measuring_line = RexsAttributeId.create("distance_tool_profile_basic_line_to_measuring_line", RexsUnitId.mm);

	/** Distance of tool tip line to manufacturing pitch circle (Versions: 1.2, 1.3) */
	public static final RexsAttributeId distance_tool_tip_line_to_manufacturing_pitch_diameter = RexsAttributeId.create("distance_tool_tip_line_to_manufacturing_pitch_diameter", RexsUnitId.mm);

	/** Dynamic load rating (Versions: 1.0) */
	public static final RexsAttributeId dynamic_capacity = RexsAttributeId.create("dynamic_capacity", RexsUnitId.kilo_newton);

	/** Dynamic factor (AGMA 2101 C95) (Versions: 1.3) */
	public static final RexsAttributeId dynamic_factor_agma_2101_c95 = RexsAttributeId.create("dynamic_factor_agma_2101_c95", RexsUnitId.none);

	/** Dynamic factor (AGMA 925 C95) (Versions: 1.3) */
	public static final RexsAttributeId dynamic_factor_agma_925_a03 = RexsAttributeId.create("dynamic_factor_agma_925_a03", RexsUnitId.none);

	/** Dynamic factor (DIN 3990 1987) (Versions: 1.3) */
	public static final RexsAttributeId dynamic_factor_din_3990_1987 = RexsAttributeId.create("dynamic_factor_din_3990_1987", RexsUnitId.none);

	/** Dynamic factor (ISO 6336 2006) (Versions: 1.3) */
	public static final RexsAttributeId dynamic_factor_iso_6336_2006 = RexsAttributeId.create("dynamic_factor_iso_6336_2006", RexsUnitId.none);

	/** Dynamic viscosity at tooth temperature (AGMA 925 C95) (Versions: 1.3) */
	public static final RexsAttributeId dynamic_viscosity_at_gear_tooth_temperature_agma_925_a03 = RexsAttributeId.create("dynamic_viscosity_at_gear_tooth_temperature_agma_925_a03", RexsUnitId.mpa_s);

	/** Eccentricity (Versions: 1.3) */
	public static final RexsAttributeId eccentricity_vector = RexsAttributeId.create("eccentricity_vector", RexsUnitId.mm);

	/** Effective face width (Versions: 1.3) */
	public static final RexsAttributeId effective_face_width_worm_wheel = RexsAttributeId.create("effective_face_width_worm_wheel", RexsUnitId.mm);

	/** Effective pressure angle on coast side (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId effective_pressure_angle_coast = RexsAttributeId.create("effective_pressure_angle_coast", RexsUnitId.degree);

	/** Effective pressure angle on drive side (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId effective_pressure_angle_drive = RexsAttributeId.create("effective_pressure_angle_drive", RexsUnitId.degree);

	/** Elastic modulus (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId elastic_modulus = RexsAttributeId.create("elastic_modulus", RexsUnitId.newton_per_mm2);

	/** Elasticity factor (ISO 6336 2019) (Versions: 1.3) */
	public static final RexsAttributeId elasticity_factor_iso_6336_2019 = RexsAttributeId.create("elasticity_factor_iso_6336_2019", RexsUnitId.newton_per_mm2_then_squareroot);

	/** Elasticity factor (VDI 2736 2014) (Versions: 1.3) */
	public static final RexsAttributeId elasticity_factor_vdi_2736_2014 = RexsAttributeId.create("elasticity_factor_vdi_2736_2014", RexsUnitId.newton_per_mm2_then_squareroot);

	/** Length of end of tangential transition (Versions: 1.2, 1.3) */
	public static final RexsAttributeId end_relief_datum_face_length_of_tangential_transition_end = RexsAttributeId.create("end_relief_datum_face_length_of_tangential_transition_end", RexsUnitId.mm);

	/** Length of start of tangential transition (Versions: 1.2, 1.3) */
	public static final RexsAttributeId end_relief_datum_face_length_of_tangential_transition_start = RexsAttributeId.create("end_relief_datum_face_length_of_tangential_transition_start", RexsUnitId.mm);

	/** Depth of end relief (Versions: 1.2, 1.3) */
	public static final RexsAttributeId end_relief_depth_datum_face = RexsAttributeId.create("end_relief_depth_datum_face", RexsUnitId.mm);

	/** Depth of end relief (Versions: 1.2, 1.3) */
	public static final RexsAttributeId end_relief_depth_non_datum_face = RexsAttributeId.create("end_relief_depth_non_datum_face", RexsUnitId.mm);

	/** Coordinate where amount of modification is specified (Versions: 1.2, 1.3) */
	public static final RexsAttributeId end_relief_evaluation_reference_datum_face = RexsAttributeId.create("end_relief_evaluation_reference_datum_face", RexsUnitId.mm);

	/** Coordinate where amount of modification is specified (Versions: 1.2, 1.3) */
	public static final RexsAttributeId end_relief_evaluation_reference_non_datum_face = RexsAttributeId.create("end_relief_evaluation_reference_non_datum_face", RexsUnitId.mm);

	/** Length of end relief (Versions: 1.2, 1.3) */
	public static final RexsAttributeId end_relief_length_datum_face = RexsAttributeId.create("end_relief_length_datum_face", RexsUnitId.mm);

	/** Length of end relief (Versions: 1.2, 1.3) */
	public static final RexsAttributeId end_relief_length_non_datum_face = RexsAttributeId.create("end_relief_length_non_datum_face", RexsUnitId.mm);

	/** Length of end of tangential transition (Versions: 1.2, 1.3) */
	public static final RexsAttributeId end_relief_non_datum_face_length_of_tangential_transition_end = RexsAttributeId.create("end_relief_non_datum_face_length_of_tangential_transition_end", RexsUnitId.mm);

	/** Length of start of tangential transition (Versions: 1.2, 1.3) */
	public static final RexsAttributeId end_relief_non_datum_face_length_of_tangential_transition_start = RexsAttributeId.create("end_relief_non_datum_face_length_of_tangential_transition_start", RexsUnitId.mm);

	/** Endurance limit flank (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId endurance_limit_flank = RexsAttributeId.create("endurance_limit_flank", RexsUnitId.newton_per_mm2);

	/** Endurance limit root (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId endurance_limit_root = RexsAttributeId.create("endurance_limit_root", RexsUnitId.newton_per_mm2);

	/** Entraining velocity at the calculation points (Versions: 1.3) */
	public static final RexsAttributeId entraining_velocity_of_calculation_points_agma_925_a03 = RexsAttributeId.create("entraining_velocity_of_calculation_points_agma_925_a03", RexsUnitId.m_per_second);

	/** Equivalent dynamic bearing load din iso 281 (Versions: 1.0) */
	public static final RexsAttributeId equivalent_dynamic_bearing_load_din_iso_281 = RexsAttributeId.create("equivalent_dynamic_bearing_load_din_iso_281", RexsUnitId.kilo_newton);

	/** Equivalent dynamic bearing load iso 281 2007 (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId equivalent_dynamic_bearing_load_iso_281_2007 = RexsAttributeId.create("equivalent_dynamic_bearing_load_iso_281_2007", RexsUnitId.kilo_newton);

	/** Equivalent radius of curvature at pitch point (Plewe 1980) (Versions: 1.3) */
	public static final RexsAttributeId equivalent_radius_of_curvature_at_pitch_point_plewe_1980 = RexsAttributeId.create("equivalent_radius_of_curvature_at_pitch_point_plewe_1980", RexsUnitId.mm);

	/** Equivalent radius of curvature at pitch point under test conditions (Plewe 1980) (Versions: 1.3) */
	public static final RexsAttributeId equivalent_radius_of_curvature_at_pitch_point_under_test_conditions_plewe_1980 = RexsAttributeId.create("equivalent_radius_of_curvature_at_pitch_point_under_test_conditions_plewe_1980", RexsUnitId.mm);

	/** Face angle (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId face_angle = RexsAttributeId.create("face_angle", RexsUnitId.degree);

	/** Face apex beyond crossing point (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId face_apex_beyond_crossing_point = RexsAttributeId.create("face_apex_beyond_crossing_point", RexsUnitId.mm);

	/** Face load factor flank (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId face_load_factor_flank = RexsAttributeId.create("face_load_factor_flank", RexsUnitId.none);

	/** Face load factor flank (DIN 3990 1987) (Versions: 1.3) */
	public static final RexsAttributeId face_load_factor_flank_din_3990_1987 = RexsAttributeId.create("face_load_factor_flank_din_3990_1987", RexsUnitId.none);

	/** Face load factor (ISO 6336 2006) (Versions: 1.3) */
	public static final RexsAttributeId face_load_factor_flank_iso_6336_2006 = RexsAttributeId.create("face_load_factor_flank_iso_6336_2006", RexsUnitId.none);

	/** Face load factor root (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId face_load_factor_root = RexsAttributeId.create("face_load_factor_root", RexsUnitId.none);

	/** Face width (Versions: 1.0, 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId face_width = RexsAttributeId.create("face_width", RexsUnitId.mm);

	/** Face width (DIN 3975 2017) (Versions: 1.2) */
	public static final RexsAttributeId face_width_din_3975_2017 = RexsAttributeId.create("face_width_din_3975_2017", RexsUnitId.mm);

	/** Face width (Versions: 1.3) */
	public static final RexsAttributeId face_width_worm_wheel = RexsAttributeId.create("face_width_worm_wheel", RexsUnitId.mm);

	/** End of usable face width (Versions: 1.2, 1.3) */
	public static final RexsAttributeId facewidth_usable_end = RexsAttributeId.create("facewidth_usable_end", RexsUnitId.mm);

	/** Start of usable face width (Versions: 1.2, 1.3) */
	public static final RexsAttributeId facewidth_usable_start = RexsAttributeId.create("facewidth_usable_start", RexsUnitId.mm);

	/** Factor c for calculating dynamic viscosity (AGMA 925 A03) (Versions: 1.3) */
	public static final RexsAttributeId factor_c_for_calculating_dynamic_viscosity_at_gear_tooth_temperature_agma_925_a03 = RexsAttributeId.create("factor_c_for_calculating_dynamic_viscosity_at_gear_tooth_temperature_agma_925_a03", RexsUnitId.none);

	/** Factor d for calculating dynamic viscosity (AGMA 925 A03) (Versions: 1.3) */
	public static final RexsAttributeId factor_d_for_calculating_dynamic_viscosity_at_gear_tooth_temperature_agma_925_a03 = RexsAttributeId.create("factor_d_for_calculating_dynamic_viscosity_at_gear_tooth_temperature_agma_925_a03", RexsUnitId.none);

	/** Factor for tooth flank loading (VDI 2736 2014) (Versions: 1.3) */
	public static final RexsAttributeId factor_for_tooth_flank_loading_vdi_2736_2014 = RexsAttributeId.create("factor_for_tooth_flank_loading_vdi_2736_2014", RexsUnitId.none);

	/** Factor for tooth root loading (VDI 2736 2014) (Versions: 1.3) */
	public static final RexsAttributeId factor_for_tooth_root_loading_vdi_2736_2014 = RexsAttributeId.create("factor_for_tooth_root_loading_vdi_2736_2014", RexsUnitId.none);

	/** Calculation factor k (Plewe 1980) (Versions: 1.3) */
	public static final RexsAttributeId factor_k_plewe_1980 = RexsAttributeId.create("factor_k_plewe_1980", RexsUnitId.none);

	/** Bending stress amplitude of the fatigue strength for a specific mean stress (Versions: 1.3) */
	public static final RexsAttributeId fatigue_bending_strength_din_743_2012 = RexsAttributeId.create("fatigue_bending_strength_din_743_2012", RexsUnitId.newton_per_mm2);

	/** Fatigue limit under reversed bending stress (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId fatigue_limit_bending = RexsAttributeId.create("fatigue_limit_bending", RexsUnitId.mega_pascal);

	/** Compression-tension fatigue limit (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId fatigue_limit_compression_tension = RexsAttributeId.create("fatigue_limit_compression_tension", RexsUnitId.mega_pascal);

	/** Fatigue limit load (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId fatigue_limit_load = RexsAttributeId.create("fatigue_limit_load", RexsUnitId.kilo_newton);

	/** Fatigue limit under reversed torsional stress (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId fatigue_limit_torsion = RexsAttributeId.create("fatigue_limit_torsion", RexsUnitId.mega_pascal);

	/** Fatigue strength under pulsating stress (VDI 2736 2014) (Versions: 1.3) */
	public static final RexsAttributeId fatigue_strength_under_pulsating_stress_vdi_2736_2014 = RexsAttributeId.create("fatigue_strength_under_pulsating_stress_vdi_2736_2014", RexsUnitId.newton_per_mm2);

	/** Tension/ compression stress amplitude of the fatigue strength for a specific mean stress (Versions: 1.3) */
	public static final RexsAttributeId fatigue_tensile_strength_din_743_2012 = RexsAttributeId.create("fatigue_tensile_strength_din_743_2012", RexsUnitId.newton_per_mm2);

	/** Torsional stress amplitude of the component fatigue strength for a specific mean stress (Versions: 1.3) */
	public static final RexsAttributeId fatigue_torsion_strength_din_743_2012 = RexsAttributeId.create("fatigue_torsion_strength_din_743_2012", RexsUnitId.newton_per_mm2);

	/** FEM format used (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId fem_file_format = RexsAttributeId.create("fem_file_format", RexsUnitId.none);

	/** Filter cutoff of wavelength (AGMA 925 C95) (Versions: 1.3) */
	public static final RexsAttributeId filter_cutoff_of_wavelength_agma_925_a03 = RexsAttributeId.create("filter_cutoff_of_wavelength_agma_925_a03", RexsUnitId.mm);

	/** Flag designation addendum modification (profile shift) (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId flag_designation_addendum_modification = RexsAttributeId.create("flag_designation_addendum_modification", RexsUnitId.none);

	/** Flank form (Versions: 1.3) */
	public static final RexsAttributeId flank_form = RexsAttributeId.create("flank_form", RexsUnitId.none);

	/** Flank form (DIN 3975 2017) (Versions: 1.2) */
	public static final RexsAttributeId flank_form_din_3975_2017 = RexsAttributeId.create("flank_form_din_3975_2017", RexsUnitId.none);

	/** Flank loss from wheel in the normal section (Versions: 1.3) */
	public static final RexsAttributeId flank_loss_from_wheel_in_normal_section_din_3996_2019 = RexsAttributeId.create("flank_loss_from_wheel_in_normal_section_din_3996_2019", RexsUnitId.mm);

	/** Hertzian flank stress (VDI 2736 2014) (Versions: 1.3) */
	public static final RexsAttributeId flank_pressure_vdi_2736_2014 = RexsAttributeId.create("flank_pressure_vdi_2736_2014", RexsUnitId.newton_per_mm2);

	/** Flank surface (DIN 3996 2019) (Versions: 1.2, 1.3) */
	public static final RexsAttributeId flank_surface_din_3996_2019 = RexsAttributeId.create("flank_surface_din_3996_2019", RexsUnitId.mm2);

	/** Flank temperature characteristic (VDI 2736 2014) (Versions: 1.3) */
	public static final RexsAttributeId flank_temperature_characteristic_vdi_2736_2014 = RexsAttributeId.create("flank_temperature_characteristic_vdi_2736_2014", RexsUnitId.degree_celsius);

	/** Flash temperature at the calculation points (AGMA 925 A03) (Versions: 1.3) */
	public static final RexsAttributeId flash_temperature_of_calculation_points_agma_925_a03 = RexsAttributeId.create("flash_temperature_of_calculation_points_agma_925_a03", RexsUnitId.degree_celsius);

	/** Folder name (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId folder = RexsAttributeId.create("folder", RexsUnitId.none);

	/** Force in u-direction acting on the component on the inner side (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId force_acting_on_inner_component_u = RexsAttributeId.create("force_acting_on_inner_component_u", RexsUnitId.newton);

	/** Force in v-direction acting on the component on the inner side (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId force_acting_on_inner_component_v = RexsAttributeId.create("force_acting_on_inner_component_v", RexsUnitId.newton);

	/** Force in w-direction acting on the component on the inner side (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId force_acting_on_inner_component_w = RexsAttributeId.create("force_acting_on_inner_component_w", RexsUnitId.newton);

	/** Force in u-direction acting on the component on the outer side (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId force_acting_on_outer_component_u = RexsAttributeId.create("force_acting_on_outer_component_u", RexsUnitId.newton);

	/** Force in v-direction acting on the component on the outer side (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId force_acting_on_outer_component_v = RexsAttributeId.create("force_acting_on_outer_component_v", RexsUnitId.newton);

	/** Force in w-direction acting on the component on the outer side (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId force_acting_on_outer_component_w = RexsAttributeId.create("force_acting_on_outer_component_w", RexsUnitId.newton);

	/** Force in u-direction acting on the shaft (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId force_acting_on_shaft_u = RexsAttributeId.create("force_acting_on_shaft_u", RexsUnitId.newton);

	/** Force in v-direction acting on the shaft (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId force_acting_on_shaft_v = RexsAttributeId.create("force_acting_on_shaft_v", RexsUnitId.newton);

	/** Force in w-direction acting on the shaft (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId force_acting_on_shaft_w = RexsAttributeId.create("force_acting_on_shaft_w", RexsUnitId.newton);

	/** Axial force distribution in u-direction (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId force_distribution_u = RexsAttributeId.create("force_distribution_u", RexsUnitId.newton);

	/** Radial force distribution in v-direction (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId force_distribution_v = RexsAttributeId.create("force_distribution_v", RexsUnitId.newton);

	/** Radial force distribution in w-direction (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId force_distribution_w = RexsAttributeId.create("force_distribution_w", RexsUnitId.newton);

	/** Force in u-direction (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId force_u_direction = RexsAttributeId.create("force_u_direction", RexsUnitId.newton);

	/** Force in v-direction (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId force_v_direction = RexsAttributeId.create("force_v_direction", RexsUnitId.newton);

	/** Force in w-direction (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId force_w_direction = RexsAttributeId.create("force_w_direction", RexsUnitId.newton);

	/** Form allowance (Versions: 1.2, 1.3) */
	public static final RexsAttributeId form_allowance = RexsAttributeId.create("form_allowance", RexsUnitId.mm);

	/** Form factor bending (Versions: 1.3) */
	public static final RexsAttributeId form_factor_bending_din_743_2012 = RexsAttributeId.create("form_factor_bending_din_743_2012", RexsUnitId.none);

	/** Form factor (DIN 3975 2017) (Versions: 1.2) */
	public static final RexsAttributeId form_factor_din_3975_2017 = RexsAttributeId.create("form_factor_din_3975_2017", RexsUnitId.none);

	/** Form factor tension/ compression (Versions: 1.3) */
	public static final RexsAttributeId form_factor_tension_compression_din_743_2012 = RexsAttributeId.create("form_factor_tension_compression_din_743_2012", RexsUnitId.none);

	/** Form factor (tooth bending) (Versions: 1.3) */
	public static final RexsAttributeId form_factor_tooth_bending_din_3996_2019 = RexsAttributeId.create("form_factor_tooth_bending_din_3996_2019", RexsUnitId.none);

	/** Form factor torsion (Versions: 1.3) */
	public static final RexsAttributeId form_factor_torsion_din_743_2012 = RexsAttributeId.create("form_factor_torsion_din_743_2012", RexsUnitId.none);

	/** Form factor (VDI 2736 2014) (Versions: 1.3) */
	public static final RexsAttributeId form_factor_vdi_2736_2014 = RexsAttributeId.create("form_factor_vdi_2736_2014", RexsUnitId.none);

	/** Form factor (Versions: 1.3) */
	public static final RexsAttributeId form_factor_worm_gear = RexsAttributeId.create("form_factor_worm_gear", RexsUnitId.none);

	/** GDE file (Versions: 1.3) */
	public static final RexsAttributeId gde_file = RexsAttributeId.create("gde_file", RexsUnitId.none);

	/** Gear efficiency in increaser (Versions: 1.3) */
	public static final RexsAttributeId gear_efficiency_in_increaser_din_3996_2019 = RexsAttributeId.create("gear_efficiency_in_increaser_din_3996_2019", RexsUnitId.none);

	/** Gear efficiency in reducer (Versions: 1.3) */
	public static final RexsAttributeId gear_efficiency_in_reducer_din_3996_2019 = RexsAttributeId.create("gear_efficiency_in_reducer_din_3996_2019", RexsUnitId.none);

	/** Gear ratio (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId gear_ratio = RexsAttributeId.create("gear_ratio", RexsUnitId.none);

	/** Gear ratio factor (pitting) (Versions: 1.3) */
	public static final RexsAttributeId gear_ratio_factor_pitting_din_3996_2019 = RexsAttributeId.create("gear_ratio_factor_pitting_din_3996_2019", RexsUnitId.none);

	/** Gear shift index (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId gear_shift_index = RexsAttributeId.create("gear_shift_index", RexsUnitId.none);

	/** Generated addendum modification coefficient (profile shift coefficient) (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId generated_addendum_modification_coefficient = RexsAttributeId.create("generated_addendum_modification_coefficient", RexsUnitId.none);

	/** Generated addendum modification coefficient (profile shift coefficient) (lower deviation) (Versions: 1.3) */
	public static final RexsAttributeId generated_addendum_modification_coefficient_lower_deviation = RexsAttributeId.create("generated_addendum_modification_coefficient_lower_deviation", RexsUnitId.none);

	/** Generated addendum modification coefficient (profile shift coefficient) (upper deviation) (Versions: 1.3) */
	public static final RexsAttributeId generated_addendum_modification_coefficient_upper_deviation = RexsAttributeId.create("generated_addendum_modification_coefficient_upper_deviation", RexsUnitId.none);

	/** Center distance in generating train (Versions: 1.3) */
	public static final RexsAttributeId generated_center_distance = RexsAttributeId.create("generated_center_distance", RexsUnitId.mm);

	/** Generated pressure angle on coast side (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId generated_pressure_angle_coast = RexsAttributeId.create("generated_pressure_angle_coast", RexsUnitId.degree);

	/** Generated pressure angle on drive side (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId generated_pressure_angle_drive = RexsAttributeId.create("generated_pressure_angle_drive", RexsUnitId.degree);

	/** Geometrical size factor bending (Versions: 1.3) */
	public static final RexsAttributeId geometrical_size_factor_bending_din_743_2012 = RexsAttributeId.create("geometrical_size_factor_bending_din_743_2012", RexsUnitId.none);

	/** Geometrical size factor tension/ compression (Versions: 1.3) */
	public static final RexsAttributeId geometrical_size_factor_tension_compression_din_743_2012 = RexsAttributeId.create("geometrical_size_factor_tension_compression_din_743_2012", RexsUnitId.none);

	/** Geometrical size factor torsion (Versions: 1.3) */
	public static final RexsAttributeId geometrical_size_factor_torsion_din_743_2012 = RexsAttributeId.create("geometrical_size_factor_torsion_din_743_2012", RexsUnitId.none);

	/** Geometry refers to (Versions: 1.0) */
	public static final RexsAttributeId geometry_refers_to = RexsAttributeId.create("geometry_refers_to", RexsUnitId.none);

	/** Gravitational acceleration (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId gravitational_acceleration = RexsAttributeId.create("gravitational_acceleration", RexsUnitId.m_per_s2);

	/** Grinding allowance (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId grinding_allowance = RexsAttributeId.create("grinding_allowance", RexsUnitId.mm);

	/** Grinding disk diameter (Versions: 1.3) */
	public static final RexsAttributeId grinding_disk_diameter = RexsAttributeId.create("grinding_disk_diameter", RexsUnitId.mm);

	/** Half length of contact area (Versions: 1.3) */
	public static final RexsAttributeId half_length_of_contact_area = RexsAttributeId.create("half_length_of_contact_area", RexsUnitId.mm);

	/** Half width of contact area (Versions: 1.3) */
	public static final RexsAttributeId half_width_of_contact_area = RexsAttributeId.create("half_width_of_contact_area", RexsUnitId.mm);

	/** Hardness conversion factor (ISO 6336 2019) (Versions: 1.3) */
	public static final RexsAttributeId hardness_conversion_factor_iso_6336_2019 = RexsAttributeId.create("hardness_conversion_factor_iso_6336_2019", RexsUnitId.none);

	/** Bearing has an inner ring (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId has_inner_ring = RexsAttributeId.create("has_inner_ring", RexsUnitId.none);

	/** Bearing has an outer ring (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId has_outer_ring = RexsAttributeId.create("has_outer_ring", RexsUnitId.none);

	/** Heat-dissipating surface (VDI 2736 2014) (Versions: 1.3) */
	public static final RexsAttributeId heat_dissipating_surface_vdi_2736_2014 = RexsAttributeId.create("heat_dissipating_surface_vdi_2736_2014", RexsUnitId.m2);

	/** Heat transfer coefficient at the surface of the bearing seat (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId heat_transfer_coefficient_at_bearing_seat = RexsAttributeId.create("heat_transfer_coefficient_at_bearing_seat", RexsUnitId.watt_per_mm);

	/** Plastic gear flank heat transfer coefficient (VDI 2736 2014) (Versions: 1.3) */
	public static final RexsAttributeId heat_transfer_coefficient_plastic_flank_vdi_2736_2014 = RexsAttributeId.create("heat_transfer_coefficient_plastic_flank_vdi_2736_2014", RexsUnitId.heat_transfer_coefficient_vdi2736);

	/** Plastic gear root heat transfer coefficient  (VDI 2736 2014) (Versions: 1.3) */
	public static final RexsAttributeId heat_transfer_coefficient_plastic_root_vdi_2736_2014 = RexsAttributeId.create("heat_transfer_coefficient_plastic_root_vdi_2736_2014", RexsUnitId.heat_transfer_coefficient_vdi2736);

	/** Heat transfer resistance (VDI 2736 2014) (Versions: 1.3) */
	public static final RexsAttributeId heat_transfer_resistance_vdi_2736_2014 = RexsAttributeId.create("heat_transfer_resistance_vdi_2736_2014", RexsUnitId.kelvin_m2_per_watt);

	/** Heat treated material type (ISO 6336 2006) (Versions: 1.3) */
	public static final RexsAttributeId heat_treated_material_type_iso_6336_2006 = RexsAttributeId.create("heat_treated_material_type_iso_6336_2006", RexsUnitId.none);

	/** Height over chordal tooth thickness (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId height_over_chordal_tooth_thickness = RexsAttributeId.create("height_over_chordal_tooth_thickness", RexsUnitId.mm);

	/** Helical motion coefficients (Versions: 1.3) */
	public static final RexsAttributeId helical_motion_coefficients = RexsAttributeId.create("helical_motion_coefficients", RexsUnitId.none);

	/** Helix angle at the base circle (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId helix_angle_base_circle = RexsAttributeId.create("helix_angle_base_circle", RexsUnitId.degree);

	/** Helix angle factor (VDI 2736 2014) (Versions: 1.3) */
	public static final RexsAttributeId helix_angle_factor_vdi_2736_2014 = RexsAttributeId.create("helix_angle_factor_vdi_2736_2014", RexsUnitId.none);

	/** Helix angle at reference circle (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId helix_angle_reference_diameter = RexsAttributeId.create("helix_angle_reference_diameter", RexsUnitId.degree);

	/** Amount of helix crowning at datum face (Versions: 1.2, 1.3) */
	public static final RexsAttributeId helix_crowning_amount_datum_face = RexsAttributeId.create("helix_crowning_amount_datum_face", RexsUnitId.mm);

	/** Amount of helix crowning at non-datum face (Versions: 1.2, 1.3) */
	public static final RexsAttributeId helix_crowning_amount_non_datum_face = RexsAttributeId.create("helix_crowning_amount_non_datum_face", RexsUnitId.mm);

	/** Amount of helix deviations (Versions: 1.2, 1.3) */
	public static final RexsAttributeId helix_deviation_amounts = RexsAttributeId.create("helix_deviation_amounts", RexsUnitId.mm);

	/** End of helix evaluation (Versions: 1.2, 1.3) */
	public static final RexsAttributeId helix_evaluation_end = RexsAttributeId.create("helix_evaluation_end", RexsUnitId.mm);

	/** Reference length of helix modification (Versions: 1.2, 1.3) */
	public static final RexsAttributeId helix_evaluation_reference = RexsAttributeId.create("helix_evaluation_reference", RexsUnitId.none);

	/** Begin of helix evaluation (Versions: 1.2, 1.3) */
	public static final RexsAttributeId helix_evaluation_start = RexsAttributeId.create("helix_evaluation_start", RexsUnitId.mm);

	/** Location of the highest point in the helix crowning (Versions: 1.2, 1.3) */
	public static final RexsAttributeId helix_highest_point = RexsAttributeId.create("helix_highest_point", RexsUnitId.mm);

	/** Amount of helix slope modification (Versions: 1.2, 1.3) */
	public static final RexsAttributeId helix_slope = RexsAttributeId.create("helix_slope", RexsUnitId.mm);

	/** Hertzian flank pressure under test conditions (Plewe 1980) (Versions: 1.3) */
	public static final RexsAttributeId hertzian_flank_pressure_under_test_conditions_plewe_1980 = RexsAttributeId.create("hertzian_flank_pressure_under_test_conditions_plewe_1980", RexsUnitId.newton_per_mm2);

	/** Hobbing procedure (Versions: 1.3) */
	public static final RexsAttributeId hobbing_procedure = RexsAttributeId.create("hobbing_procedure", RexsUnitId.none);

	/** Horizontal distance (Versions: 1.3) */
	public static final RexsAttributeId horizontal_distance = RexsAttributeId.create("horizontal_distance", RexsUnitId.mm);

	/** Horizontal motion coefficients (Versions: 1.3) */
	public static final RexsAttributeId horizontal_motion_coefficients = RexsAttributeId.create("horizontal_motion_coefficients", RexsUnitId.none);

	/** Hypoid offset (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId hypoid_offset = RexsAttributeId.create("hypoid_offset", RexsUnitId.mm);

	/** Offset of inclination angle (Versions: 1.3) */
	public static final RexsAttributeId inclination_angle_offset = RexsAttributeId.create("inclination_angle_offset", RexsUnitId.degree);

	/** Increase factor yield strength bending (Versions: 1.3) */
	public static final RexsAttributeId increase_factor_yield_strength_bending_din_743_2012 = RexsAttributeId.create("increase_factor_yield_strength_bending_din_743_2012", RexsUnitId.none);

	/** Increase factor yield strength tension/ compression (Versions: 1.3) */
	public static final RexsAttributeId increase_factor_yield_strength_tension_compression_din_743_2012 = RexsAttributeId.create("increase_factor_yield_strength_tension_compression_din_743_2012", RexsUnitId.none);

	/** Increase factor yield strength torsion (Versions: 1.3) */
	public static final RexsAttributeId increase_factor_yield_strength_torsion_din_743_2012 = RexsAttributeId.create("increase_factor_yield_strength_torsion_din_743_2012", RexsUnitId.none);

	/** Preload force (Versions: 1.0) */
	public static final RexsAttributeId initial_load = RexsAttributeId.create("initial_load", RexsUnitId.newton);

	/** Preload distance (Versions: 1.0) */
	public static final RexsAttributeId initial_load_shift = RexsAttributeId.create("initial_load_shift", RexsUnitId.mum);

	/** Inner cone distance (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId inner_cone_distance = RexsAttributeId.create("inner_cone_distance", RexsUnitId.mm);

	/** Inner diameter (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId inner_diameter = RexsAttributeId.create("inner_diameter", RexsUnitId.mm);

	/** Inner diameter begin (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId inner_diameter_begin = RexsAttributeId.create("inner_diameter_begin", RexsUnitId.mm);

	/** Inner diameter end (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId inner_diameter_end = RexsAttributeId.create("inner_diameter_end", RexsUnitId.mm);

	/** Inner pitch diameter (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId inner_pitch_diameter = RexsAttributeId.create("inner_pitch_diameter", RexsUnitId.mm);

	/** Offset of intersection angle (Versions: 1.3) */
	public static final RexsAttributeId intersection_angle_offset = RexsAttributeId.create("intersection_angle_offset", RexsUnitId.degree);

	/** Modification is additive (Versions: 1.2, 1.3) */
	public static final RexsAttributeId is_additive_modification = RexsAttributeId.create("is_additive_modification", RexsUnitId.none);

	/** Adequate gear tip profile modification (ISO 6336 2019) (Versions: 1.3) */
	public static final RexsAttributeId is_adequate_profile_modfication_iso_6336_2019 = RexsAttributeId.create("is_adequate_profile_modfication_iso_6336_2019", RexsUnitId.none);

	/** Is driving gear (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId is_driving_gear = RexsAttributeId.create("is_driving_gear", RexsUnitId.none);

	/** Is engaged (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId is_engaged = RexsAttributeId.create("is_engaged", RexsUnitId.none);

	/** Kind of lubricant (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId kind = RexsAttributeId.create("kind", RexsUnitId.none);

	/** Kinematic viscosity of the lubricant at ambient pressure and mass temperature (Plewe 1980) (Versions: 1.3) */
	public static final RexsAttributeId kinematic_viscosity_of_the_lubricant_at_ambient_pressure_and_mass_temperature_plewe_1980 = RexsAttributeId.create("kinematic_viscosity_of_the_lubricant_at_ambient_pressure_and_mass_temperature_plewe_1980", RexsUnitId.mm2_per_s);

	/** Klingelnberg 3d neutral data file (Versions: 1.3) */
	public static final RexsAttributeId klingelnberg_3d_neutral_data_file = RexsAttributeId.create("klingelnberg_3d_neutral_data_file", RexsUnitId.none);

	/** Klingelnberg neutral data file (Versions: 1.3) */
	public static final RexsAttributeId klingelnberg_neutral_data_file = RexsAttributeId.create("klingelnberg_neutral_data_file", RexsUnitId.none);

	/** Lead (Versions: 1.3) */
	public static final RexsAttributeId lead = RexsAttributeId.create("lead", RexsUnitId.mm);

	/** Reference lead angle (Versions: 1.3) */
	public static final RexsAttributeId lead_angle_worm_gear = RexsAttributeId.create("lead_angle_worm_gear", RexsUnitId.degree);

	/** Lead (DIN 3975 2017) (Versions: 1.2) */
	public static final RexsAttributeId lead_din_3975_2017 = RexsAttributeId.create("lead_din_3975_2017", RexsUnitId.mm);

	/** Lead factor (tooth bending) (Versions: 1.3) */
	public static final RexsAttributeId lead_factor_tooth_bending_din_3996_2019 = RexsAttributeId.create("lead_factor_tooth_bending_din_3996_2019", RexsUnitId.none);

	/** Length (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId length = RexsAttributeId.create("length", RexsUnitId.mm);

	/** Length of path of contact (Versions: 1.3) */
	public static final RexsAttributeId length_of_path_of_contact = RexsAttributeId.create("length_of_path_of_contact", RexsUnitId.mm);

	/** Length of profile deviations (Versions: 1.2, 1.3) */
	public static final RexsAttributeId length_of_profile_deviation = RexsAttributeId.create("length_of_profile_deviation", RexsUnitId.mm);

	/** Length of rolling element (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId length_of_rolling_element = RexsAttributeId.create("length_of_rolling_element", RexsUnitId.mm);

	/** Length of tip path of contact (Versions: 1.3) */
	public static final RexsAttributeId length_of_tip_path_of_contact = RexsAttributeId.create("length_of_tip_path_of_contact", RexsUnitId.mm);

	/** Length  of topographical modification (Versions: 1.2, 1.3) */
	public static final RexsAttributeId length_of_topographical_modification = RexsAttributeId.create("length_of_topographical_modification", RexsUnitId.mm);

	/** Length where amount of profile crowning at the rootis specified (Versions: 1.2, 1.3) */
	public static final RexsAttributeId length_where_profile_crowning_root_is_specified = RexsAttributeId.create("length_where_profile_crowning_root_is_specified", RexsUnitId.mm);

	/** Length where amount of profile crowning at the tip is specified (Versions: 1.2, 1.3) */
	public static final RexsAttributeId length_where_profile_crowning_tip_is_specified = RexsAttributeId.create("length_where_profile_crowning_tip_is_specified", RexsUnitId.mm);

	/** Length of worm gear (Versions: 1.3) */
	public static final RexsAttributeId length_worm_gear = RexsAttributeId.create("length_worm_gear", RexsUnitId.mm);

	/** Lever of axial force on cylindrical roller bearings (Versions: 1.0) */
	public static final RexsAttributeId lever_arm_of_axial_force = RexsAttributeId.create("lever_arm_of_axial_force", RexsUnitId.none);

	/** Life factor (pitting) (Versions: 1.3) */
	public static final RexsAttributeId life_factor_pitting_din_3996_2019 = RexsAttributeId.create("life_factor_pitting_din_3996_2019", RexsUnitId.none);

	/** Life factor (tooth bending) (Versions: 1.3) */
	public static final RexsAttributeId life_factor_tooth_bending_din_3996_2019 = RexsAttributeId.create("life_factor_tooth_bending_din_3996_2019", RexsUnitId.none);

	/** Limiting speed (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId limiting_speed = RexsAttributeId.create("limiting_speed", RexsUnitId.rotation_per_min);

	/** Limiting value of flank loss (DIN 3996 2019) (Versions: 1.2, 1.3) */
	public static final RexsAttributeId limiting_value_flank_loss_din_3996_2019 = RexsAttributeId.create("limiting_value_flank_loss_din_3996_2019", RexsUnitId.mm);

	/** Linear wear coefficient under test conditions (Plewe 1980) (Versions: 1.3) */
	public static final RexsAttributeId linear_wear_coefficient_under_test_conditions_plewe_1980 = RexsAttributeId.create("linear_wear_coefficient_under_test_conditions_plewe_1980", RexsUnitId.mm);

	/** Load angle at tip (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId load_angle_at_tip = RexsAttributeId.create("load_angle_at_tip", RexsUnitId.degree);

	/** Load carrying face width (Versions: 1.3) */
	public static final RexsAttributeId load_carrying_face_width_vdi_2736_2014 = RexsAttributeId.create("load_carrying_face_width_vdi_2736_2014", RexsUnitId.mm);

	/** Load cycles dependent fatigue strength under pulsating stress (Versions: 1.3) */
	public static final RexsAttributeId load_cycles_dependent_fatigue_strength_under_pulsating_stress = RexsAttributeId.create("load_cycles_dependent_fatigue_strength_under_pulsating_stress", RexsUnitId.newton_per_mm2);

	/** Load cycles dependent rolling contact fatigue strength (Versions: 1.3) */
	public static final RexsAttributeId load_cycles_dependent_rolling_contact_fatigue_strength = RexsAttributeId.create("load_cycles_dependent_rolling_contact_fatigue_strength", RexsUnitId.newton_per_mm2);

	/** Load cycles variation for fatigue strength under pulsating stress (Versions: 1.3) */
	public static final RexsAttributeId load_cycles_variation_for_fatigue_strength_under_pulsating_stress = RexsAttributeId.create("load_cycles_variation_for_fatigue_strength_under_pulsating_stress", RexsUnitId.none);

	/** Load cycles variation for rolling contact fatigue strength (Versions: 1.3) */
	public static final RexsAttributeId load_cycles_variation_for_rolling_contact_fatigue_strength = RexsAttributeId.create("load_cycles_variation_for_rolling_contact_fatigue_strength", RexsUnitId.none);

	/** Load distribution along common face width (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId load_distribution_along_face_width = RexsAttributeId.create("load_distribution_along_face_width", RexsUnitId.newton);

	/** Load distribution factor (AGMA 2101 C95) (Versions: 1.3) */
	public static final RexsAttributeId load_distribution_factor_agma_2101_c95 = RexsAttributeId.create("load_distribution_factor_agma_2101_c95", RexsUnitId.none);

	/** Load distribution factor (AGMA 925 C95) (Versions: 1.3) */
	public static final RexsAttributeId load_distribution_factor_agma_925_a03 = RexsAttributeId.create("load_distribution_factor_agma_925_a03", RexsUnitId.none);

	/** Node positions of load distribution along common face width (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId load_distribution_node_positions = RexsAttributeId.create("load_distribution_node_positions", RexsUnitId.mm);

	/** Load duration (Versions: 1.0, 1.1, 1.2) */
	public static final RexsAttributeId load_duration = RexsAttributeId.create("load_duration", RexsUnitId.hour);

	/** Load duration fraction (Versions: 1.0, 1.1, 1.2) */
	public static final RexsAttributeId load_duration_fraction = RexsAttributeId.create("load_duration_fraction", RexsUnitId.percent);

	/** Load parameter for central film thickness of calculation points (AGMA 925 A03) (Versions: 1.3) */
	public static final RexsAttributeId load_parameter_for_central_film_thickness_of_calculation_points_agma_925_a03 = RexsAttributeId.create("load_parameter_for_central_film_thickness_of_calculation_points_agma_925_a03", RexsUnitId.none);

	/** Load sharing factor of calculation points (AGMA 925 A03) (Versions: 1.3) */
	public static final RexsAttributeId load_sharing_factor_of_calculation_points_agma_925_a03 = RexsAttributeId.create("load_sharing_factor_of_calculation_points_agma_925_a03", RexsUnitId.none);

	/** Loaded tooth flank (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId loaded_tooth_flank = RexsAttributeId.create("loaded_tooth_flank", RexsUnitId.none);

	/** Local root stress under peak torque (VDI 2736 2014) (Versions: 1.3) */
	public static final RexsAttributeId local_root_stress_under_peak_torque_vdi_2736_2014 = RexsAttributeId.create("local_root_stress_under_peak_torque_vdi_2736_2014", RexsUnitId.newton_per_mm2);

	/** Lower diametric deviation (Versions: 1.2, 1.3) */
	public static final RexsAttributeId lower_backlash_allowance_balls_or_pins = RexsAttributeId.create("lower_backlash_allowance_balls_or_pins", RexsUnitId.mm);

	/** Lower base tangent length deviation (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId lower_backlash_allowance_referenced_to_span = RexsAttributeId.create("lower_backlash_allowance_referenced_to_span", RexsUnitId.mum);

	/** Lower centre distance allowance (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId lower_center_distance_allowance = RexsAttributeId.create("lower_center_distance_allowance", RexsUnitId.mum);

	/** Lubricant factor (pitting) (Versions: 1.3) */
	public static final RexsAttributeId lubricant_factor_pitting_din_3996_2019 = RexsAttributeId.create("lubricant_factor_pitting_din_3996_2019", RexsUnitId.none);

	/** Lubricant film thickness parameter (Versions: 1.3) */
	public static final RexsAttributeId lubricant_film_thickness_parameter_din_3996_2019 = RexsAttributeId.create("lubricant_film_thickness_parameter_din_3996_2019", RexsUnitId.none);

	/** Oil volume flow rate through bearing (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId lubricant_flow_through_bearing = RexsAttributeId.create("lubricant_flow_through_bearing", RexsUnitId.litre_per_minute);

	/** Lubricant structure factor (Versions: 1.3) */
	public static final RexsAttributeId lubricant_structure_factor_din_3996_2019 = RexsAttributeId.create("lubricant_structure_factor_din_3996_2019", RexsUnitId.none);

	/** Difference of oil temperatures between outflow and feed (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId lubricant_temperature_difference_inlet_output = RexsAttributeId.create("lubricant_temperature_difference_inlet_output", RexsUnitId.kelvin);

	/** Lubricant type (AGMA 925 C95) (Versions: 1.3) */
	public static final RexsAttributeId lubricant_type_agma_925_a03 = RexsAttributeId.create("lubricant_type_agma_925_a03", RexsUnitId.none);

	/** Lubricant type (ISO 6336 2006) (Versions: 1.3) */
	public static final RexsAttributeId lubricant_type_iso_6336_2006 = RexsAttributeId.create("lubricant_type_iso_6336_2006", RexsUnitId.none);

	/** Coefficient for lubrication method (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId lubrication_factor = RexsAttributeId.create("lubrication_factor", RexsUnitId.none);

	/** Kind of lubrication (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId lubrication_type = RexsAttributeId.create("lubrication_type", RexsUnitId.none);

	/** Lubrication type (AGMA 925 C95) (Versions: 1.3) */
	public static final RexsAttributeId lubrication_type_agma_925_a03 = RexsAttributeId.create("lubrication_type_agma_925_a03", RexsUnitId.none);

	/** Lubrication type (DIN 3996 2019) (Versions: 1.2, 1.3) */
	public static final RexsAttributeId lubrication_type_din_3996_2019 = RexsAttributeId.create("lubrication_type_din_3996_2019", RexsUnitId.none);

	/** Type of lubrication (VDI 2736 2014) (Versions: 1.3) */
	public static final RexsAttributeId lubrication_type_vdi_2736_2014 = RexsAttributeId.create("lubrication_type_vdi_2736_2014", RexsUnitId.none);

	/** Lyra angle (Versions: 1.3) */
	public static final RexsAttributeId lyra_angle = RexsAttributeId.create("lyra_angle", RexsUnitId.degree);

	/** Machine center to crossing point (Versions: 1.3) */
	public static final RexsAttributeId machine_center_to_crossing_point = RexsAttributeId.create("machine_center_to_crossing_point", RexsUnitId.mm);

	/** Machine root angle (Versions: 1.3) */
	public static final RexsAttributeId machine_root_angle = RexsAttributeId.create("machine_root_angle", RexsUnitId.degree);

	/** Machining allowance (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId machining_allowance = RexsAttributeId.create("machining_allowance", RexsUnitId.mm);

	/** Machining allowance of the tool according to DIN 3972 (Versions: 1.3) */
	public static final RexsAttributeId machining_allowance_din_3972 = RexsAttributeId.create("machining_allowance_din_3972", RexsUnitId.mm);

	/** Machining allowance tolerance (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId machining_allowance_tolerance = RexsAttributeId.create("machining_allowance_tolerance", RexsUnitId.mm);

	/** Manufacturer (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId manufacturer = RexsAttributeId.create("manufacturer", RexsUnitId.none);

	/** Mass of component (Versions: 1.3) */
	public static final RexsAttributeId mass_of_component = RexsAttributeId.create("mass_of_component", RexsUnitId.kg);

	/** Material category (VDI 2736 2014) (Versions: 1.3) */
	public static final RexsAttributeId material_category_vdi_2736_2014 = RexsAttributeId.create("material_category_vdi_2736_2014", RexsUnitId.none);

	/** Material depth dependent hardness (ISO 6336 2019) (Versions: 1.3) */
	public static final RexsAttributeId material_depth_dependent_hardness_iso_6336_2019 = RexsAttributeId.create("material_depth_dependent_hardness_iso_6336_2019", RexsUnitId.hv);

	/** Material depth dependent residual stress (ISO 6336 2019) (Versions: 1.3) */
	public static final RexsAttributeId material_depth_dependent_residual_stress_iso_6336_2019 = RexsAttributeId.create("material_depth_dependent_residual_stress_iso_6336_2019", RexsUnitId.newton_per_mm2);

	/** Material depth variation for hardness (ISO 6336 2019) (Versions: 1.3) */
	public static final RexsAttributeId material_depth_variation_for_hardness_iso_6336_2019 = RexsAttributeId.create("material_depth_variation_for_hardness_iso_6336_2019", RexsUnitId.mm);

	/** Material depth variation for residual stress (ISO 6336 2019) (Versions: 1.3) */
	public static final RexsAttributeId material_depth_variation_for_residual_stress_iso_6336_2019 = RexsAttributeId.create("material_depth_variation_for_residual_stress_iso_6336_2019", RexsUnitId.mm);

	/** Material designation (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId material_designation = RexsAttributeId.create("material_designation", RexsUnitId.none);

	/** Material exposure calibration factor (ISO 6336 2019) (Versions: 1.3) */
	public static final RexsAttributeId material_exposure_calibration_factor_iso_6336_2019 = RexsAttributeId.create("material_exposure_calibration_factor_iso_6336_2019", RexsUnitId.none);

	/** Material factor (ISO 6336 2019) (Versions: 1.3) */
	public static final RexsAttributeId material_factor_iso_6336_2019 = RexsAttributeId.create("material_factor_iso_6336_2019", RexsUnitId.none);

	/** Material loss (DIN 3996 2019) (Versions: 1.2, 1.3) */
	public static final RexsAttributeId material_loss_din_3996_2019 = RexsAttributeId.create("material_loss_din_3996_2019", RexsUnitId.mg);

	/** Material loss limit (DIN 3996 2019) (Versions: 1.2, 1.3) */
	public static final RexsAttributeId material_loss_limit_din_3996_2019 = RexsAttributeId.create("material_loss_limit_din_3996_2019", RexsUnitId.mg);

	/** Material - lubricant factor (Versions: 1.3) */
	public static final RexsAttributeId material_lubricant_factor_din_3996_2019 = RexsAttributeId.create("material_lubricant_factor_din_3996_2019", RexsUnitId.none);

	/** Materials parameter for central film thickness (AGMA 925 A03) (Versions: 1.3) */
	public static final RexsAttributeId materials_paramter_for_central_film_thickness_of_calculation_points_agma_925_a03 = RexsAttributeId.create("materials_paramter_for_central_film_thickness_of_calculation_points_agma_925_a03", RexsUnitId.none);

	/** Reduced stiffness matrix with boundary condition to inertial environment (Versions: 1.3) */
	public static final RexsAttributeId matrix_with_inertial_environment_boundary = RexsAttributeId.create("matrix_with_inertial_environment_boundary", RexsUnitId.none);

	/** Permissible pressure in the bearing (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId maximum_allowable_pressure = RexsAttributeId.create("maximum_allowable_pressure", RexsUnitId.mega_pascal);

	/** Maximum axial bearing clearance (before mounting) (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId maximum_axial_bearing_clearance = RexsAttributeId.create("maximum_axial_bearing_clearance", RexsUnitId.mum);

	/** Maximum diameter of bearing bore (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId maximum_bearing_bore_diameter = RexsAttributeId.create("maximum_bearing_bore_diameter", RexsUnitId.mm);

	/** Maximum bearing play (Versions: 1.0) */
	public static final RexsAttributeId maximum_bearing_clearance = RexsAttributeId.create("maximum_bearing_clearance", RexsUnitId.mum);

	/** Maximum bearing outer diameter (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId maximum_bearing_outer_diameter = RexsAttributeId.create("maximum_bearing_outer_diameter", RexsUnitId.mm);

	/** Maximum bearing seat diameter (Versions: 1.0) */
	public static final RexsAttributeId maximum_bore_diameter = RexsAttributeId.create("maximum_bore_diameter", RexsUnitId.mm);

	/** Maximum diameter of casing bore (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId maximum_casing_bore_diameter = RexsAttributeId.create("maximum_casing_bore_diameter", RexsUnitId.mm);

	/** Maximum contact temperature (AGMA 925 A03) (Versions: 1.3) */
	public static final RexsAttributeId maximum_contact_temperature_agma_925_a03 = RexsAttributeId.create("maximum_contact_temperature_agma_925_a03", RexsUnitId.degree_celsius);

	/** Max flash temperature (AGMA 925 A03) (Versions: 1.3) */
	public static final RexsAttributeId maximum_flash_temperature_agma_925_a03 = RexsAttributeId.create("maximum_flash_temperature_agma_925_a03", RexsUnitId.degree_celsius);

	/** Maximum flash temperature of test gears (AGMA 925 C95) (Versions: 1.3) */
	public static final RexsAttributeId maximum_flash_temperature_of_test_gears_agma_925_a03 = RexsAttributeId.create("maximum_flash_temperature_of_test_gears_agma_925_a03", RexsUnitId.degree_celsius);

	/** Maximum pressure (Versions: 1.3) */
	public static final RexsAttributeId maximum_hertzian_pressure = RexsAttributeId.create("maximum_hertzian_pressure", RexsUnitId.newton_per_mm2);

	/** Maximum pressure at inner ring (Versions: 1.3) */
	public static final RexsAttributeId maximum_hertzian_pressure_inner_ring = RexsAttributeId.create("maximum_hertzian_pressure_inner_ring", RexsUnitId.newton_per_mm2);

	/** Maximum pressure at outer ring (Versions: 1.3) */
	public static final RexsAttributeId maximum_hertzian_pressure_outer_ring = RexsAttributeId.create("maximum_hertzian_pressure_outer_ring", RexsUnitId.newton_per_mm2);

	/** Maximum value of hertzian stress from local loaded tooth contact analysis (Versions: 1.3) */
	public static final RexsAttributeId maximum_hertzian_stress_ltca_worm_stage = RexsAttributeId.create("maximum_hertzian_stress_ltca_worm_stage", RexsUnitId.newton_per_mm2);

	/** Maximum material exposure (ISO 6336 2019) (Versions: 1.3) */
	public static final RexsAttributeId maximum_material_exposure_iso_6336_2019 = RexsAttributeId.create("maximum_material_exposure_iso_6336_2019", RexsUnitId.none);

	/** Maximum normal backlash (Versions: 1.2, 1.3) */
	public static final RexsAttributeId maximum_normal_backlash = RexsAttributeId.create("maximum_normal_backlash", RexsUnitId.mm);

	/** Upper normal backlash variation (Versions: 1.2, 1.3) */
	public static final RexsAttributeId maximum_normal_backlash_variation = RexsAttributeId.create("maximum_normal_backlash_variation", RexsUnitId.mm);

	/** Maximum bearing outer diameter (Versions: 1.0) */
	public static final RexsAttributeId maximum_outer_diameter = RexsAttributeId.create("maximum_outer_diameter", RexsUnitId.mm);

	/** Maximum permissible material exposure (ISO 6336 2019) (Versions: 1.3) */
	public static final RexsAttributeId maximum_permissible_material_exposure_iso_6336_2019 = RexsAttributeId.create("maximum_permissible_material_exposure_iso_6336_2019", RexsUnitId.none);

	/** Maximum shaft diameter (Versions: 1.0) */
	public static final RexsAttributeId maximum_pin_diameter = RexsAttributeId.create("maximum_pin_diameter", RexsUnitId.mm);

	/** Maximum radial bearing clearance (before mounting) (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId maximum_radial_bearing_clearance = RexsAttributeId.create("maximum_radial_bearing_clearance", RexsUnitId.mum);

	/** Maximum root strength (VDI 2736 2014) (Versions: 1.3) */
	public static final RexsAttributeId maximum_root_stress_vdi_2736_2014 = RexsAttributeId.create("maximum_root_stress_vdi_2736_2014", RexsUnitId.newton_per_mm2);

	/** Maximum shaft diameter (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId maximum_shaft_diameter = RexsAttributeId.create("maximum_shaft_diameter", RexsUnitId.mm);

	/** Maximum value of sliding velocity from local loaded tooth contact analysis (Versions: 1.3) */
	public static final RexsAttributeId maximum_sliding_velocity_ltca_worm_stage = RexsAttributeId.create("maximum_sliding_velocity_ltca_worm_stage", RexsUnitId.m_per_second);

	/** Maximum stress bending (Versions: 1.3) */
	public static final RexsAttributeId maximum_stress_bending_din_743_2012 = RexsAttributeId.create("maximum_stress_bending_din_743_2012", RexsUnitId.newton_per_mm2);

	/** Maximum stress tension/ compression (Versions: 1.3) */
	public static final RexsAttributeId maximum_stress_tension_compression_din_743_2012 = RexsAttributeId.create("maximum_stress_tension_compression_din_743_2012", RexsUnitId.newton_per_mm2);

	/** Maximum stress torsion (Versions: 1.3) */
	public static final RexsAttributeId maximum_stress_torsion_din_743_2012 = RexsAttributeId.create("maximum_stress_torsion_din_743_2012", RexsUnitId.newton_per_mm2);

	/** Maximum transverse backlash (Versions: 1.2, 1.3) */
	public static final RexsAttributeId maximum_transverse_backlash = RexsAttributeId.create("maximum_transverse_backlash", RexsUnitId.mm);

	/** Upper backlash variation in transverse section (Versions: 1.2, 1.3) */
	public static final RexsAttributeId maximum_transverse_backlash_variation = RexsAttributeId.create("maximum_transverse_backlash_variation", RexsUnitId.mm);

	/** Maximum value of minimum lubricant film thickness from local loaded tooth contact analysis (Versions: 1.3) */
	public static final RexsAttributeId maximum_value_minimum_lubricant_film_thickness_ltca_worm_stage = RexsAttributeId.create("maximum_value_minimum_lubricant_film_thickness_ltca_worm_stage", RexsUnitId.mum);

	/** Mean addendum (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId mean_addendum = RexsAttributeId.create("mean_addendum", RexsUnitId.mm);

	/** Average of pinion and gear average roughness  (AGMA 925 A03) (Versions: 1.3) */
	public static final RexsAttributeId mean_average_surface_roughness_agma_925_a03 = RexsAttributeId.create("mean_average_surface_roughness_agma_925_a03", RexsUnitId.mum);

	/** Mean coefficient of friction at the calculation points (AGMA 925 A03) (Versions: 1.3) */
	public static final RexsAttributeId mean_coefficient_of_friction_at_calculation_points_agma_925_a03 = RexsAttributeId.create("mean_coefficient_of_friction_at_calculation_points_agma_925_a03", RexsUnitId.none);

	/** Mean coefficient of friction (AGMA 925 C95) (Versions: 1.3) */
	public static final RexsAttributeId mean_coefficient_of_friction_constant_agma_925_a03 = RexsAttributeId.create("mean_coefficient_of_friction_constant_agma_925_a03", RexsUnitId.none);

	/** Mean cone distance (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId mean_cone_distance = RexsAttributeId.create("mean_cone_distance", RexsUnitId.mm);

	/** Mean dedendum (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId mean_dedendum = RexsAttributeId.create("mean_dedendum", RexsUnitId.mm);

	/** Mean hertzian stress (DIN 3996 2019) (Versions: 1.2, 1.3) */
	public static final RexsAttributeId mean_hertzian_stress_din_3996_2019 = RexsAttributeId.create("mean_hertzian_stress_din_3996_2019", RexsUnitId.newton_per_mm2);

	/** Mean value of hertzian stress from local loaded tooth contact analysis (Versions: 1.3) */
	public static final RexsAttributeId mean_hertzian_stress_ltca_worm_stage = RexsAttributeId.create("mean_hertzian_stress_ltca_worm_stage", RexsUnitId.newton_per_mm2);

	/** Mean minimum lubricant film thickness for wear (DIN 3996 2019) (Versions: 1.2, 1.3) */
	public static final RexsAttributeId mean_minimum_lubricant_film_thickness_din_3996_2019 = RexsAttributeId.create("mean_minimum_lubricant_film_thickness_din_3996_2019", RexsUnitId.mum);

	/** Mean value of minimum lubricant film thickness from local loaded tooth contact analysis (Versions: 1.3) */
	public static final RexsAttributeId mean_minimum_lubricant_film_thickness_ltca_worm_stage = RexsAttributeId.create("mean_minimum_lubricant_film_thickness_ltca_worm_stage", RexsUnitId.mum);

	/** Mean normal chordal tooth thickness (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId mean_normal_chordal_thickness = RexsAttributeId.create("mean_normal_chordal_thickness", RexsUnitId.mm);

	/** Mean normal circular tooth thickness (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId mean_normal_circular_thickness = RexsAttributeId.create("mean_normal_circular_thickness", RexsUnitId.mm);

	/** Mean normal module (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId mean_normal_module = RexsAttributeId.create("mean_normal_module", RexsUnitId.mm);

	/** Mean normal topland (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId mean_normal_topland = RexsAttributeId.create("mean_normal_topland", RexsUnitId.mm);

	/** Mean minimum specific film thickness (AGMA 925 A03) (Versions: 1.3) */
	public static final RexsAttributeId mean_of_minimum_specific_film_thickness_agma_925_a03 = RexsAttributeId.create("mean_of_minimum_specific_film_thickness_agma_925_a03", RexsUnitId.none);

	/** Mean operating temperature (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId mean_operating_temperature = RexsAttributeId.create("mean_operating_temperature", RexsUnitId.degree_celsius);

	/** Mean operating temperature of inner ring (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId mean_operating_temperature_inner_ring = RexsAttributeId.create("mean_operating_temperature_inner_ring", RexsUnitId.degree_celsius);

	/** Mean operating temperature of outer ring (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId mean_operating_temperature_outer_ring = RexsAttributeId.create("mean_operating_temperature_outer_ring", RexsUnitId.degree_celsius);

	/** Mean pitch cone diameter (Versions: 1.1) */
	public static final RexsAttributeId mean_pitch_cone_diameter = RexsAttributeId.create("mean_pitch_cone_diameter", RexsUnitId.mm);

	/** Mean pitch diameter (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId mean_pitch_diameter = RexsAttributeId.create("mean_pitch_diameter", RexsUnitId.mm);

	/** Mean scuffing temperature (AGMA 925 C95) (Versions: 1.3) */
	public static final RexsAttributeId mean_scuffing_temperature_agma_925_a03 = RexsAttributeId.create("mean_scuffing_temperature_agma_925_a03", RexsUnitId.degree_celsius);

	/** Mean sliding path (DIN 3996 2019) (Versions: 1.2, 1.3) */
	public static final RexsAttributeId mean_sliding_path_din_3996_2019 = RexsAttributeId.create("mean_sliding_path_din_3996_2019", RexsUnitId.mm);

	/** Mean value of sliding velocity from local loaded tooth contact analysis (Versions: 1.3) */
	public static final RexsAttributeId mean_sliding_velocity_ltca_worm_stage = RexsAttributeId.create("mean_sliding_velocity_ltca_worm_stage", RexsUnitId.m_per_second);

	/** Mean specific sliding at point A (Plewe 1980) (Versions: 1.3) */
	public static final RexsAttributeId mean_specific_sliding_at_point_a_plewe_1980 = RexsAttributeId.create("mean_specific_sliding_at_point_a_plewe_1980", RexsUnitId.none);

	/** Mean specific sliding at point E (Plewe 1980) (Versions: 1.3) */
	public static final RexsAttributeId mean_specific_sliding_at_point_e_plewe_1980 = RexsAttributeId.create("mean_specific_sliding_at_point_e_plewe_1980", RexsUnitId.none);

	/** Mean specific sliding (Plewe 1980) (Versions: 1.3) */
	public static final RexsAttributeId mean_specific_sliding_plewe_1980 = RexsAttributeId.create("mean_specific_sliding_plewe_1980", RexsUnitId.none);

	/** Mean specific sliding under test conditions (Plewe 1980) (Versions: 1.3) */
	public static final RexsAttributeId mean_specific_sliding_under_test_conditions_plewe_1980 = RexsAttributeId.create("mean_specific_sliding_under_test_conditions_plewe_1980", RexsUnitId.none);

	/** Mean spiral angle (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId mean_spiral_angle = RexsAttributeId.create("mean_spiral_angle", RexsUnitId.degree);

	/** Mean stress bending (Versions: 1.3) */
	public static final RexsAttributeId mean_stress_bending_din_743_2012 = RexsAttributeId.create("mean_stress_bending_din_743_2012", RexsUnitId.newton_per_mm2);

	/** Mean stress tension/compression (Versions: 1.3) */
	public static final RexsAttributeId mean_stress_tension_compression_din_743_2012 = RexsAttributeId.create("mean_stress_tension_compression_din_743_2012", RexsUnitId.newton_per_mm2);

	/** Mean stress torsion (Versions: 1.3) */
	public static final RexsAttributeId mean_stress_torsion_din_743_2012 = RexsAttributeId.create("mean_stress_torsion_din_743_2012", RexsUnitId.newton_per_mm2);

	/** Mean coefficient of friction (Versions: 1.3) */
	public static final RexsAttributeId mean_tooth_coefficient_of_friction_din_3996_2019 = RexsAttributeId.create("mean_tooth_coefficient_of_friction_din_3996_2019", RexsUnitId.none);

	/** Mean tooth root thickness (DIN 3996 2019) (Versions: 1.2, 1.3) */
	public static final RexsAttributeId mean_tooth_root_thickness_din_3996_2019 = RexsAttributeId.create("mean_tooth_root_thickness_din_3996_2019", RexsUnitId.mm);

	/** Mean transverse circular thickness (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId mean_transverse_circular_thickness = RexsAttributeId.create("mean_transverse_circular_thickness", RexsUnitId.mm);

	/** Measurement b_z0 of the tool (Versions: 1.2, 1.3) */
	public static final RexsAttributeId measurement_bz0 = RexsAttributeId.create("measurement_bz0", RexsUnitId.mm);

	/** Measuring diameter root undercut (Versions: 1.2, 1.3) */
	public static final RexsAttributeId measuring_diameter_at_undercut = RexsAttributeId.create("measuring_diameter_at_undercut", RexsUnitId.mm);

	/** Contact circle diameter (upper deviation) (Versions: 1.2, 1.3) */
	public static final RexsAttributeId measuring_diameter_at_upper_backlash_allowance = RexsAttributeId.create("measuring_diameter_at_upper_backlash_allowance", RexsUnitId.mm);

	/** Contact circle diameter (ball/flank) (Versions: 1.2, 1.3) */
	public static final RexsAttributeId measuring_diameter_ball_flank = RexsAttributeId.create("measuring_diameter_ball_flank", RexsUnitId.mm);

	/** Contact circle diameter for span measurement (Versions: 1.2, 1.3) */
	public static final RexsAttributeId measuring_diameter_for_span = RexsAttributeId.create("measuring_diameter_for_span", RexsUnitId.mm);

	/** Mesh load factor (ISO 6336 2019) (Versions: 1.3) */
	public static final RexsAttributeId mesh_load_factor_iso_6336_2019 = RexsAttributeId.create("mesh_load_factor_iso_6336_2019", RexsUnitId.none);

	/** Mesh stiffness for load distribution along face width (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId mesh_stiffness_for_load_distribution_along_face_width = RexsAttributeId.create("mesh_stiffness_for_load_distribution_along_face_width", RexsUnitId.newton_per_mm_mum);

	/** Meshing power loss (Versions: 1.3) */
	public static final RexsAttributeId meshing_power_loss_din_3996_2019 = RexsAttributeId.create("meshing_power_loss_din_3996_2019", RexsUnitId.watt);

	/** Minimum axial bearing clearance (before mounting) (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId minimum_axial_bearing_clearance = RexsAttributeId.create("minimum_axial_bearing_clearance", RexsUnitId.mum);

	/** Minimum diameter of bearing bore (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId minimum_bearing_bore_diameter = RexsAttributeId.create("minimum_bearing_bore_diameter", RexsUnitId.mm);

	/** Minimum bearing clearance (Versions: 1.0) */
	public static final RexsAttributeId minimum_bearing_clearance = RexsAttributeId.create("minimum_bearing_clearance", RexsUnitId.mum);

	/** Minimum outer bearing diameter (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId minimum_bearing_outer_diameter = RexsAttributeId.create("minimum_bearing_outer_diameter", RexsUnitId.mm);

	/** Minimum bearing seat diameter (Versions: 1.0) */
	public static final RexsAttributeId minimum_bore_diameter = RexsAttributeId.create("minimum_bore_diameter", RexsUnitId.mm);

	/** Minimum diameter of casing bore (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId minimum_casing_bore_diameter = RexsAttributeId.create("minimum_casing_bore_diameter", RexsUnitId.mm);

	/** Minimum contact length (AGMA 925 A03) (Versions: 1.3) */
	public static final RexsAttributeId minimum_contact_length_agma_925_a03 = RexsAttributeId.create("minimum_contact_length_agma_925_a03", RexsUnitId.mm);

	/** Minimum grinding diameter at the gear (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId minimum_diameter = RexsAttributeId.create("minimum_diameter", RexsUnitId.mm);

	/** Minimum film thickness (according to Dowson and Toyoda) (AGMA 925 A03) (Versions: 1.3) */
	public static final RexsAttributeId minimum_film_thickness_dowson_toyoda_agma_925_a03 = RexsAttributeId.create("minimum_film_thickness_dowson_toyoda_agma_925_a03", RexsUnitId.mum);

	/** Minimum value of hertzian stress from local loaded tooth contact analysis (Versions: 1.3) */
	public static final RexsAttributeId minimum_hertzian_stress_ltca_worm_stage = RexsAttributeId.create("minimum_hertzian_stress_ltca_worm_stage", RexsUnitId.newton_per_mm2);

	/** Minimum lubricating film thickness in the pitch point (Plewe 1980) (Versions: 1.3) */
	public static final RexsAttributeId minimum_lubricant_film_thickness_in_the_pitch_point_plewe_1980 = RexsAttributeId.create("minimum_lubricant_film_thickness_in_the_pitch_point_plewe_1980", RexsUnitId.mum);

	/** Minimum normal backlash (Versions: 1.2, 1.3) */
	public static final RexsAttributeId minimum_normal_backlash = RexsAttributeId.create("minimum_normal_backlash", RexsUnitId.mm);

	/** Lower normal backlash variation (Versions: 1.2, 1.3) */
	public static final RexsAttributeId minimum_normal_backlash_variation = RexsAttributeId.create("minimum_normal_backlash_variation", RexsUnitId.mm);

	/** Normal module design calculation VDI 2738 2014 (Versions: 1.3) */
	public static final RexsAttributeId minimum_normal_module_vdi_2736_2014 = RexsAttributeId.create("minimum_normal_module_vdi_2736_2014", RexsUnitId.mm);

	/** Minimum outer bearing diameter (Versions: 1.0) */
	public static final RexsAttributeId minimum_outer_diameter = RexsAttributeId.create("minimum_outer_diameter", RexsUnitId.mm);

	/** Minimum shaft diameter (Versions: 1.0) */
	public static final RexsAttributeId minimum_pin_diameter = RexsAttributeId.create("minimum_pin_diameter", RexsUnitId.mm);

	/** Minimum radial bearing clearance (before mounting) (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId minimum_radial_bearing_clearance = RexsAttributeId.create("minimum_radial_bearing_clearance", RexsUnitId.mum);

	/** Minimum shaft diameter (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId minimum_shaft_diameter = RexsAttributeId.create("minimum_shaft_diameter", RexsUnitId.mm);

	/** Minimum value of sliding velocity from local loaded tooth contact analysis (Versions: 1.3) */
	public static final RexsAttributeId minimum_sliding_velocity_ltca_worm_stage = RexsAttributeId.create("minimum_sliding_velocity_ltca_worm_stage", RexsUnitId.m_per_second);

	/** Minimum specific film thickness (according to Wellauer and Holloway) (AGMA 925 A03) (Versions: 1.3) */
	public static final RexsAttributeId minimum_specific_film_thickness_wellauer_holloway_agma_925_a03 = RexsAttributeId.create("minimum_specific_film_thickness_wellauer_holloway_agma_925_a03", RexsUnitId.none);

	/** Minimum pinion diameter design calculation VDI 2738 2014 (Versions: 1.3) */
	public static final RexsAttributeId minimum_standard_pitch_diameter_vdi_2736_2014 = RexsAttributeId.create("minimum_standard_pitch_diameter_vdi_2736_2014", RexsUnitId.mm);

	/** Minimum thickness by tip chamfer relief (Versions: 1.2, 1.3) */
	public static final RexsAttributeId minimum_thickness_by_tip_chamfer_relief = RexsAttributeId.create("minimum_thickness_by_tip_chamfer_relief", RexsUnitId.mm);

	/** Minimum transverse backlash (Versions: 1.2, 1.3) */
	public static final RexsAttributeId minimum_transverse_backlash = RexsAttributeId.create("minimum_transverse_backlash", RexsUnitId.mm);

	/** Lower backlash variation in transverse section (Versions: 1.2, 1.3) */
	public static final RexsAttributeId minimum_transverse_backlash_variation = RexsAttributeId.create("minimum_transverse_backlash_variation", RexsUnitId.mm);

	/** Minimum value of minimum lubricant film thickness from local loaded tooth contact analysis (Versions: 1.3) */
	public static final RexsAttributeId minimum_value_minimum_lubricant_film_thickness_ltca_worm_stage = RexsAttributeId.create("minimum_value_minimum_lubricant_film_thickness_ltca_worm_stage", RexsUnitId.mum);

	/** Radial offset of the mounting position of the outer ring in the v-direction (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId misalignment_in_v_direction = RexsAttributeId.create("misalignment_in_v_direction", RexsUnitId.mum);

	/** Radial offset of the mounting position of the outer ring in the w-direction (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId misalignment_in_w_direction = RexsAttributeId.create("misalignment_in_w_direction", RexsUnitId.mum);

	/** Modified reference rating life DIN 26281 2010 (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId modified_reference_rating_life_rotations_din_26281 = RexsAttributeId.create("modified_reference_rating_life_rotations_din_26281", RexsUnitId.none);

	/** Modified reference rating life DIN 26281 2010 (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId modified_reference_rating_life_time_din_26281 = RexsAttributeId.create("modified_reference_rating_life_time_din_26281", RexsUnitId.hour);

	/** Modified roll coefficients (Versions: 1.3) */
	public static final RexsAttributeId modified_roll_coefficients = RexsAttributeId.create("modified_roll_coefficients", RexsUnitId.none);

	/** Modulus of elasticity flank at operating temperature (VDI 2736 2014) (Versions: 1.3) */
	public static final RexsAttributeId modulus_of_elasticity_flank_vdi_2736_2014 = RexsAttributeId.create("modulus_of_elasticity_flank_vdi_2736_2014", RexsUnitId.newton_per_mm2);

	/** Modulus of elasticity root at operating temperature (VDI 2736 2014) (Versions: 1.3) */
	public static final RexsAttributeId modulus_of_elasticity_root_vdi_2736_2014 = RexsAttributeId.create("modulus_of_elasticity_root_vdi_2736_2014", RexsUnitId.newton_per_mm2);

	/** Moment of inertia around u-axis (Versions: 1.3) */
	public static final RexsAttributeId moment_of_inertia_u_axis = RexsAttributeId.create("moment_of_inertia_u_axis", RexsUnitId.kg_m2);

	/** Moment of inertia around v-axis (Versions: 1.3) */
	public static final RexsAttributeId moment_of_inertia_v_axis = RexsAttributeId.create("moment_of_inertia_v_axis", RexsUnitId.kg_m2);

	/** Moment of inertia around w-axis (Versions: 1.3) */
	public static final RexsAttributeId moment_of_inertia_w_axis = RexsAttributeId.create("moment_of_inertia_w_axis", RexsUnitId.kg_m2);

	/** Axial bearing clearance (after mounting) (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId mounted_axial_bearing_clearance = RexsAttributeId.create("mounted_axial_bearing_clearance", RexsUnitId.mum);

	/** Radial bearing clearance (after mounting) (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId mounted_radial_bearing_clearance = RexsAttributeId.create("mounted_radial_bearing_clearance", RexsUnitId.mum);

	/** Name of lubricant (Versions: 1.0, 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId name = RexsAttributeId.create("name", RexsUnitId.none);

	/** Nominal design pressure angle on coast side (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId nominal_design_pressure_angle_coast = RexsAttributeId.create("nominal_design_pressure_angle_coast", RexsUnitId.degree);

	/** Nominal design pressure angle on drive side (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId nominal_design_pressure_angle_drive = RexsAttributeId.create("nominal_design_pressure_angle_drive", RexsUnitId.degree);

	/** Nominal rating life (L_10) DIN ISO 281 (Versions: 1.0) */
	public static final RexsAttributeId nominal_rating_life_rotations_din_iso_281 = RexsAttributeId.create("nominal_rating_life_rotations_din_iso_281", RexsUnitId.none);

	/** Nominal rating life ISO 281 2007 (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId nominal_rating_life_rotations_iso_281_2007 = RexsAttributeId.create("nominal_rating_life_rotations_iso_281_2007", RexsUnitId.none);

	/** Nominal rating life (L_10h) DIN ISO 281 (Versions: 1.0) */
	public static final RexsAttributeId nominal_rating_life_time_din_iso_281 = RexsAttributeId.create("nominal_rating_life_time_din_iso_281", RexsUnitId.hour);

	/** Nominal rating life ISO 281 2007 (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId nominal_rating_life_time_iso_281_2007 = RexsAttributeId.create("nominal_rating_life_time_iso_281_2007", RexsUnitId.hour);

	/** Nominal reference rating life DIN 26281 (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId nominal_reference_rating_life_rotations_din_26281 = RexsAttributeId.create("nominal_reference_rating_life_rotations_din_26281", RexsUnitId.none);

	/** Nominal reference rating life DIN 26281 (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId nominal_reference_rating_life_time_din_26281 = RexsAttributeId.create("nominal_reference_rating_life_time_din_26281", RexsUnitId.hour);

	/** Nominal tangential force at base circle (Versions: 1.3) */
	public static final RexsAttributeId nominal_tangential_force_at_base_circle = RexsAttributeId.create("nominal_tangential_force_at_base_circle", RexsUnitId.newton);

	/** Nominal tangential force at reference circle (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId nominal_tangential_force_at_reference_circle = RexsAttributeId.create("nominal_tangential_force_at_reference_circle", RexsUnitId.newton);

	/** Normal base pitch (Versions: 1.3) */
	public static final RexsAttributeId normal_base_pitch = RexsAttributeId.create("normal_base_pitch", RexsUnitId.mm);

	/** Normal chordal tooth thickness (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId normal_chordal_tooth_thickness = RexsAttributeId.create("normal_chordal_tooth_thickness", RexsUnitId.mm);

	/** Normal circular pitch (Versions: 1.2, 1.3) */
	public static final RexsAttributeId normal_circular_pitch = RexsAttributeId.create("normal_circular_pitch", RexsUnitId.mm);

	/** Normal line load (Plewe 1980) (Versions: 1.3) */
	public static final RexsAttributeId normal_line_load_plewe_1980 = RexsAttributeId.create("normal_line_load_plewe_1980", RexsUnitId.newton_per_mm);

	/** Normal module (Versions: 1.0, 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId normal_module = RexsAttributeId.create("normal_module", RexsUnitId.mm);

	/** Normal operating load (AGMA 925 A03) (Versions: 1.3) */
	public static final RexsAttributeId normal_operating_load_agma_925_a03 = RexsAttributeId.create("normal_operating_load_agma_925_a03", RexsUnitId.newton);

	/** Normal pitch (DIN 3975 2017) (Versions: 1.2) */
	public static final RexsAttributeId normal_pitch_din_3975_2017 = RexsAttributeId.create("normal_pitch_din_3975_2017", RexsUnitId.mm);

	/** Normal pressure angle (Versions: 1.0, 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId normal_pressure_angle = RexsAttributeId.create("normal_pressure_angle", RexsUnitId.degree);

	/** Normal relative radius of curvature of calculation points (AGMA 925 A03) (Versions: 1.3) */
	public static final RexsAttributeId normal_relative_radius_of_curvature_of_calculation_points_agma_925_a03 = RexsAttributeId.create("normal_relative_radius_of_curvature_of_calculation_points_agma_925_a03", RexsUnitId.mm);

	/** Normal space width (Versions: 1.2, 1.3) */
	public static final RexsAttributeId normal_space_width_at_pitch_diameter = RexsAttributeId.create("normal_space_width_at_pitch_diameter", RexsUnitId.mm);

	/** Normal tip thickness for A_We (Versions: 1.2, 1.3) */
	public static final RexsAttributeId normal_tip_thickness = RexsAttributeId.create("normal_tip_thickness", RexsUnitId.mm);

	/** Normal tooth thickness (Versions: 1.2, 1.3) */
	public static final RexsAttributeId normal_tooth_thickness_at_pitch_diameter = RexsAttributeId.create("normal_tooth_thickness_at_pitch_diameter", RexsUnitId.mm);

	/** Normal unit load (AGMA 925 A03) (Versions: 1.3) */
	public static final RexsAttributeId normal_unit_load_agma_925_a03 = RexsAttributeId.create("normal_unit_load_agma_925_a03", RexsUnitId.newton_per_mm);

	/** Notch depth (Versions: 1.3) */
	public static final RexsAttributeId notch_depth = RexsAttributeId.create("notch_depth", RexsUnitId.mm);

	/** Notch diameter (Versions: 1.3) */
	public static final RexsAttributeId notch_diameter = RexsAttributeId.create("notch_diameter", RexsUnitId.mm);

	/** Notch factor bending (Versions: 1.3) */
	public static final RexsAttributeId notch_factor_bending_din_743_2012 = RexsAttributeId.create("notch_factor_bending_din_743_2012", RexsUnitId.none);

	/** Notch factor tension/ compression (Versions: 1.3) */
	public static final RexsAttributeId notch_factor_tension_compression_din_743_2012 = RexsAttributeId.create("notch_factor_tension_compression_din_743_2012", RexsUnitId.none);

	/** Notch factor torsion (Versions: 1.3) */
	public static final RexsAttributeId notch_factor_torsion_din_743_2012 = RexsAttributeId.create("notch_factor_torsion_din_743_2012", RexsUnitId.none);

	/** Bore radius (Versions: 1.3) */
	public static final RexsAttributeId notch_hole_radius_din_743_2012 = RexsAttributeId.create("notch_hole_radius_din_743_2012", RexsUnitId.mm);

	/** Notch radius (Versions: 1.3) */
	public static final RexsAttributeId notch_radius = RexsAttributeId.create("notch_radius", RexsUnitId.mm);

	/** Notch width (Versions: 1.3) */
	public static final RexsAttributeId notch_width = RexsAttributeId.create("notch_width", RexsUnitId.mm);

	/** Number of bearing rows (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId number_of_bearing_rows = RexsAttributeId.create("number_of_bearing_rows", RexsUnitId.none);

	/** Number of blade groups (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId number_of_blade_groups = RexsAttributeId.create("number_of_blade_groups", RexsUnitId.none);

	/** Number of blade groups (Versions: 1.3) */
	public static final RexsAttributeId number_of_blade_groups_bevel_gear_tool = RexsAttributeId.create("number_of_blade_groups_bevel_gear_tool", RexsUnitId.none);

	/** Number of calculation points along the line of contact (AGMA 925 C95) (Versions: 1.3) */
	public static final RexsAttributeId number_of_calculation_points_along_the_line_of_action_agma_925_a03 = RexsAttributeId.create("number_of_calculation_points_along_the_line_of_action_agma_925_a03", RexsUnitId.none);

	/** Number of gears (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId number_of_gears = RexsAttributeId.create("number_of_gears", RexsUnitId.none);

	/** Number of load cycles (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId number_of_load_cycles = RexsAttributeId.create("number_of_load_cycles", RexsUnitId.none);

	/** Number of nodes in mesh width for load distribution (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId number_of_nodes_in_mesh_width_for_loaddistribution = RexsAttributeId.create("number_of_nodes_in_mesh_width_for_loaddistribution", RexsUnitId.none);

	/** Number of points in y-direction (ISO 6336 2019) (Versions: 1.3) */
	public static final RexsAttributeId number_of_points_in_y_direction_iso_6336_2019 = RexsAttributeId.create("number_of_points_in_y_direction_iso_6336_2019", RexsUnitId.none);

	/** Number of rolling elements (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId number_of_rolling_elements = RexsAttributeId.create("number_of_rolling_elements", RexsUnitId.none);

	/** Number of teeth (Versions: 1.0, 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId number_of_teeth = RexsAttributeId.create("number_of_teeth", RexsUnitId.none);

	/** Measured number of teeth for base tangent length W_k (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId number_of_teeth_for_span_measurement = RexsAttributeId.create("number_of_teeth_for_span_measurement", RexsUnitId.none);

	/** Oil inlet or sump temperature (AGMA 925 C95) (Versions: 1.3) */
	public static final RexsAttributeId oil_inlet_or_sump_temperature_agma_925_a03 = RexsAttributeId.create("oil_inlet_or_sump_temperature_agma_925_a03", RexsUnitId.degree_celsius);

	/** Calculated oil sump temperature (Versions: 1.3) */
	public static final RexsAttributeId oil_sump_temperature_din_3996_2019 = RexsAttributeId.create("oil_sump_temperature_din_3996_2019", RexsUnitId.degree_celsius);

	/** Operating axial bearing clearance (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId operating_axial_bearing_clearance = RexsAttributeId.create("operating_axial_bearing_clearance", RexsUnitId.mum);

	/** Operating helix angle (AGMA 925 A03) (Versions: 1.3) */
	public static final RexsAttributeId operating_helix_angle_agma_925_a03 = RexsAttributeId.create("operating_helix_angle_agma_925_a03", RexsUnitId.degree);

	/** Operating point stiffness dF_u / d_u (Versions: 1.0) */
	public static final RexsAttributeId operating_point_stiffness_dF_u_d_u = RexsAttributeId.create("operating_point_stiffness_dF_u_d_u", RexsUnitId.newton_per_m);

	/** Operating point stiffness dF_u / d_v (Versions: 1.0) */
	public static final RexsAttributeId operating_point_stiffness_dF_u_d_v = RexsAttributeId.create("operating_point_stiffness_dF_u_d_v", RexsUnitId.newton_per_m);

	/** Operating point stiffness dF_u / d_v_rot (Versions: 1.0) */
	public static final RexsAttributeId operating_point_stiffness_dF_u_d_v_rot = RexsAttributeId.create("operating_point_stiffness_dF_u_d_v_rot", RexsUnitId.newton_per_radian);

	/** Operating point stiffness dF_u / d_w (Versions: 1.0) */
	public static final RexsAttributeId operating_point_stiffness_dF_u_d_w = RexsAttributeId.create("operating_point_stiffness_dF_u_d_w", RexsUnitId.newton_per_m);

	/** Operating point stiffness dF_u / d_w_rot (Versions: 1.0) */
	public static final RexsAttributeId operating_point_stiffness_dF_u_d_w_rot = RexsAttributeId.create("operating_point_stiffness_dF_u_d_w_rot", RexsUnitId.newton_per_radian);

	/** Operating point stiffness dF_v / d_u (Versions: 1.0) */
	public static final RexsAttributeId operating_point_stiffness_dF_v_d_u = RexsAttributeId.create("operating_point_stiffness_dF_v_d_u", RexsUnitId.newton_per_m);

	/** Operating point stiffness dF_v / d_v (Versions: 1.0) */
	public static final RexsAttributeId operating_point_stiffness_dF_v_d_v = RexsAttributeId.create("operating_point_stiffness_dF_v_d_v", RexsUnitId.newton_per_m);

	/** Operating point stiffness dF_v / d_v_rot (Versions: 1.0) */
	public static final RexsAttributeId operating_point_stiffness_dF_v_d_v_rot = RexsAttributeId.create("operating_point_stiffness_dF_v_d_v_rot", RexsUnitId.newton_per_radian);

	/** Operating point stiffness dF_v / d_w (Versions: 1.0) */
	public static final RexsAttributeId operating_point_stiffness_dF_v_d_w = RexsAttributeId.create("operating_point_stiffness_dF_v_d_w", RexsUnitId.newton_per_m);

	/** Operating point stiffness dF_v / d_w_rot (Versions: 1.0) */
	public static final RexsAttributeId operating_point_stiffness_dF_v_d_w_rot = RexsAttributeId.create("operating_point_stiffness_dF_v_d_w_rot", RexsUnitId.newton_per_radian);

	/** Operating point stiffness dF_w / d_u (Versions: 1.0) */
	public static final RexsAttributeId operating_point_stiffness_dF_w_d_u = RexsAttributeId.create("operating_point_stiffness_dF_w_d_u", RexsUnitId.newton_per_m);

	/** Operating point stiffness dF_w / d_v (Versions: 1.0) */
	public static final RexsAttributeId operating_point_stiffness_dF_w_d_v = RexsAttributeId.create("operating_point_stiffness_dF_w_d_v", RexsUnitId.newton_per_m);

	/** Operating point stiffness dF_w / d_v_rot (Versions: 1.0) */
	public static final RexsAttributeId operating_point_stiffness_dF_w_d_v_rot = RexsAttributeId.create("operating_point_stiffness_dF_w_d_v_rot", RexsUnitId.newton_per_radian);

	/** Operating point stiffness dF_w / d_w (Versions: 1.0) */
	public static final RexsAttributeId operating_point_stiffness_dF_w_d_w = RexsAttributeId.create("operating_point_stiffness_dF_w_d_w", RexsUnitId.newton_per_m);

	/** Operating point stiffness dF_w / d_w_rot (Versions: 1.0) */
	public static final RexsAttributeId operating_point_stiffness_dF_w_d_w_rot = RexsAttributeId.create("operating_point_stiffness_dF_w_d_w_rot", RexsUnitId.newton_per_radian);

	/** Operating point stiffness dM_v / d_u (Versions: 1.0) */
	public static final RexsAttributeId operating_point_stiffness_dM_v_d_u = RexsAttributeId.create("operating_point_stiffness_dM_v_d_u", RexsUnitId.newton);

	/** Operating point stiffness dM_v / d_v (Versions: 1.0) */
	public static final RexsAttributeId operating_point_stiffness_dM_v_d_v = RexsAttributeId.create("operating_point_stiffness_dM_v_d_v", RexsUnitId.newton);

	/** Operating point stiffness dM_v / d_v_rot (Versions: 1.0) */
	public static final RexsAttributeId operating_point_stiffness_dM_v_d_v_rot = RexsAttributeId.create("operating_point_stiffness_dM_v_d_v_rot", RexsUnitId.newton_mm_per_rad);

	/** Operating point stiffness dM_v / d_w (Versions: 1.0) */
	public static final RexsAttributeId operating_point_stiffness_dM_v_d_w = RexsAttributeId.create("operating_point_stiffness_dM_v_d_w", RexsUnitId.newton);

	/** Operating point stiffness dM_v / d_w_rot (Versions: 1.0) */
	public static final RexsAttributeId operating_point_stiffness_dM_v_d_w_rot = RexsAttributeId.create("operating_point_stiffness_dM_v_d_w_rot", RexsUnitId.newton_mm_per_rad);

	/** Operating point stiffness dM_w / d_u (Versions: 1.0) */
	public static final RexsAttributeId operating_point_stiffness_dM_w_d_u = RexsAttributeId.create("operating_point_stiffness_dM_w_d_u", RexsUnitId.newton);

	/** Operating point stiffness dM_w / d_v (Versions: 1.0) */
	public static final RexsAttributeId operating_point_stiffness_dM_w_d_v = RexsAttributeId.create("operating_point_stiffness_dM_w_d_v", RexsUnitId.newton);

	/** Operating point stiffness dM_w / d_v_rot (Versions: 1.0) */
	public static final RexsAttributeId operating_point_stiffness_dM_w_d_v_rot = RexsAttributeId.create("operating_point_stiffness_dM_w_d_v_rot", RexsUnitId.newton_mm_per_rad);

	/** Operating point stiffness dM_w / d_w (Versions: 1.0) */
	public static final RexsAttributeId operating_point_stiffness_dM_w_d_w = RexsAttributeId.create("operating_point_stiffness_dM_w_d_w", RexsUnitId.newton);

	/** Operating point stiffness dM_w / d_w_rot (Versions: 1.0) */
	public static final RexsAttributeId operating_point_stiffness_dM_w_d_w_rot = RexsAttributeId.create("operating_point_stiffness_dM_w_d_w_rot", RexsUnitId.newton_mm_per_rad);

	/** Operating point stiffness &part;F_u / &part;d_u (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId operating_point_stiffness_f_u_d_u = RexsAttributeId.create("operating_point_stiffness_f_u_d_u", RexsUnitId.newton_per_m);

	/** Operating point stiffness &part;F_u / &part;d_v (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId operating_point_stiffness_f_u_d_v = RexsAttributeId.create("operating_point_stiffness_f_u_d_v", RexsUnitId.newton_per_m);

	/** Operating point stiffness &part;F_u / &part;d_w (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId operating_point_stiffness_f_u_d_w = RexsAttributeId.create("operating_point_stiffness_f_u_d_w", RexsUnitId.newton_per_m);

	/** Operating point stiffness &part;F_u / &part;rot_v (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId operating_point_stiffness_f_u_rot_v = RexsAttributeId.create("operating_point_stiffness_f_u_rot_v", RexsUnitId.newton_per_radian);

	/** Operating point stiffness &part;F_u / &part;rot_w (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId operating_point_stiffness_f_u_rot_w = RexsAttributeId.create("operating_point_stiffness_f_u_rot_w", RexsUnitId.newton_per_radian);

	/** Operating point stiffness &part;F_v / &part;d_u (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId operating_point_stiffness_f_v_d_u = RexsAttributeId.create("operating_point_stiffness_f_v_d_u", RexsUnitId.newton_per_m);

	/** Operating point stiffness &part;F_v / &part;d_v (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId operating_point_stiffness_f_v_d_v = RexsAttributeId.create("operating_point_stiffness_f_v_d_v", RexsUnitId.newton_per_m);

	/** Operating point stiffness &part;F_v / &part;d_w (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId operating_point_stiffness_f_v_d_w = RexsAttributeId.create("operating_point_stiffness_f_v_d_w", RexsUnitId.newton_per_m);

	/** Operating point stiffness &part;F_v / &part;rot_v (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId operating_point_stiffness_f_v_rot_v = RexsAttributeId.create("operating_point_stiffness_f_v_rot_v", RexsUnitId.newton_per_radian);

	/** Operating point stiffness &part;F_v / &part;rot_w (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId operating_point_stiffness_f_v_rot_w = RexsAttributeId.create("operating_point_stiffness_f_v_rot_w", RexsUnitId.newton_per_radian);

	/** Operating point stiffness  &part;F_w / &part;d_u (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId operating_point_stiffness_f_w_d_u = RexsAttributeId.create("operating_point_stiffness_f_w_d_u", RexsUnitId.newton_per_m);

	/** Operating point stiffness &part;F_w / &part;d_v (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId operating_point_stiffness_f_w_d_v = RexsAttributeId.create("operating_point_stiffness_f_w_d_v", RexsUnitId.newton_per_m);

	/** Operating point stiffness &part;F_w / &part;d_w (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId operating_point_stiffness_f_w_d_w = RexsAttributeId.create("operating_point_stiffness_f_w_d_w", RexsUnitId.newton_per_m);

	/** Operating point stiffness &part;F_w / &part;rot_v (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId operating_point_stiffness_f_w_rot_v = RexsAttributeId.create("operating_point_stiffness_f_w_rot_v", RexsUnitId.newton_per_radian);

	/** Operating point stiffness &part;F_w / &part;rot_w (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId operating_point_stiffness_f_w_rot_w = RexsAttributeId.create("operating_point_stiffness_f_w_rot_w", RexsUnitId.newton_per_radian);

	/** Operating point stiffness &part;M_v / &part;d_u (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId operating_point_stiffness_m_v_d_u = RexsAttributeId.create("operating_point_stiffness_m_v_d_u", RexsUnitId.newton);

	/** Operating point stiffness &part;M_v / &part;d_v (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId operating_point_stiffness_m_v_d_v = RexsAttributeId.create("operating_point_stiffness_m_v_d_v", RexsUnitId.newton);

	/** Operating point stiffness &part;M_v / &part;d_w (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId operating_point_stiffness_m_v_d_w = RexsAttributeId.create("operating_point_stiffness_m_v_d_w", RexsUnitId.newton);

	/** Operating point stiffness &part;M_v / &part;rot_v (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId operating_point_stiffness_m_v_rot_v = RexsAttributeId.create("operating_point_stiffness_m_v_rot_v", RexsUnitId.newton_mm_per_rad);

	/** Operating point stiffness &part;M_v / &part;rot_w (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId operating_point_stiffness_m_v_rot_w = RexsAttributeId.create("operating_point_stiffness_m_v_rot_w", RexsUnitId.newton_mm_per_rad);

	/** Operating point stiffness &part;M_w / &part;d_u (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId operating_point_stiffness_m_w_d_u = RexsAttributeId.create("operating_point_stiffness_m_w_d_u", RexsUnitId.newton);

	/** Operating point stiffness &part;M_w / &part;d_v (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId operating_point_stiffness_m_w_d_v = RexsAttributeId.create("operating_point_stiffness_m_w_d_v", RexsUnitId.newton);

	/** Operating point stiffness &part;M_w / &part;d_w (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId operating_point_stiffness_m_w_d_w = RexsAttributeId.create("operating_point_stiffness_m_w_d_w", RexsUnitId.newton);

	/** Operating point stiffness &part;M_w / &part;rot_v (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId operating_point_stiffness_m_w_rot_v = RexsAttributeId.create("operating_point_stiffness_m_w_rot_v", RexsUnitId.newton_mm_per_rad);

	/** Operating point stiffness &part;M_w / &part;rot_w (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId operating_point_stiffness_m_w_rot_w = RexsAttributeId.create("operating_point_stiffness_m_w_rot_w", RexsUnitId.newton_mm_per_rad);

	/** Operating pressure angle (Versions: 1.3) */
	public static final RexsAttributeId operating_pressure_angle = RexsAttributeId.create("operating_pressure_angle", RexsUnitId.degree);

	/** Operating pressure angle in the normal section (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId operating_pressure_angle_in_the_normal_section = RexsAttributeId.create("operating_pressure_angle_in_the_normal_section", RexsUnitId.degree);

	/** Operating pressure angle in the transverse section (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId operating_pressure_angle_in_the_transverse_section = RexsAttributeId.create("operating_pressure_angle_in_the_transverse_section", RexsUnitId.degree);

	/** Operating radial bearing clearance (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId operating_radial_bearing_clearance = RexsAttributeId.create("operating_radial_bearing_clearance", RexsUnitId.mum);

	/** Operating time (Versions: 1.3) */
	public static final RexsAttributeId operating_time = RexsAttributeId.create("operating_time", RexsUnitId.hour);

	/** Time share of the total operating time (Versions: 1.3) */
	public static final RexsAttributeId operating_time_fraction = RexsAttributeId.create("operating_time_fraction", RexsUnitId.percent);

	/** Desired service life for VDI 2736 2014 design calculation (Versions: 1.3) */
	public static final RexsAttributeId operating_time_vdi_2736_2014 = RexsAttributeId.create("operating_time_vdi_2736_2014", RexsUnitId.hour);

	/** Operating viscosity (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId operating_viscosity = RexsAttributeId.create("operating_viscosity", RexsUnitId.mm2_per_s);

	/** Outer addendum (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId outer_addendum = RexsAttributeId.create("outer_addendum", RexsUnitId.mm);

	/** Outer reference cone distance (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId outer_cone_distance = RexsAttributeId.create("outer_cone_distance", RexsUnitId.mm);

	/** Outer dedendum (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId outer_dedendum = RexsAttributeId.create("outer_dedendum", RexsUnitId.mm);

	/** Outer diameter (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId outer_diameter = RexsAttributeId.create("outer_diameter", RexsUnitId.mm);

	/** Outer diameter begin (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId outer_diameter_begin = RexsAttributeId.create("outer_diameter_begin", RexsUnitId.mm);

	/** Outer diameter (DIN 3975 2017) (Versions: 1.2) */
	public static final RexsAttributeId outer_diameter_din_3975_2017 = RexsAttributeId.create("outer_diameter_din_3975_2017", RexsUnitId.mm);

	/** Outer diameter end (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId outer_diameter_end = RexsAttributeId.create("outer_diameter_end", RexsUnitId.mm);

	/** Outer diameter (Versions: 1.3) */
	public static final RexsAttributeId outer_diameter_worm_wheel = RexsAttributeId.create("outer_diameter_worm_wheel", RexsUnitId.mm);

	/** Outer pitch diameter (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId outer_pitch_diameter = RexsAttributeId.create("outer_pitch_diameter", RexsUnitId.mm);

	/** Outer transverse module (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId outer_transverse_module = RexsAttributeId.create("outer_transverse_module", RexsUnitId.mm);

	/** Outer whole depth (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId outer_whole_depth = RexsAttributeId.create("outer_whole_depth", RexsUnitId.mm);

	/** Overlap contact ratio (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId overlap_contact_ratio = RexsAttributeId.create("overlap_contact_ratio", RexsUnitId.none);

	/** Overload factor (AGMA 2101 C95) (Versions: 1.3) */
	public static final RexsAttributeId overload_factor_agma_2101_c95 = RexsAttributeId.create("overload_factor_agma_2101_c95", RexsUnitId.none);

	/** Overload factor (AGMA 925 C95) (Versions: 1.3) */
	public static final RexsAttributeId overload_factor_agma_925_a03 = RexsAttributeId.create("overload_factor_agma_925_a03", RexsUnitId.none);

	/** Overrolling frequency inner ring (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId overrolling_frequency_inner_ring = RexsAttributeId.create("overrolling_frequency_inner_ring", RexsUnitId.hertz);

	/** Overrolling frequency outer ring (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId overrolling_frequency_outer_ring = RexsAttributeId.create("overrolling_frequency_outer_ring", RexsUnitId.hertz);

	/** Overrolling frequency rolling element (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId overrolling_frequency_rolling_element = RexsAttributeId.create("overrolling_frequency_rolling_element", RexsUnitId.hertz);

	/** Parameter a_a for hardness according to method C2 (ISO 6336 2019) (Versions: 1.3) */
	public static final RexsAttributeId parameter_a_a_for_hardness_method_c2_iso_6336_2019 = RexsAttributeId.create("parameter_a_a_for_hardness_method_c2_iso_6336_2019", RexsUnitId.none);

	/** Parameter a_b  for hardness according to method C2 (ISO 6336 2019) (Versions: 1.3) */
	public static final RexsAttributeId parameter_a_b_for_hardness_method_c2_iso_6336_2019 = RexsAttributeId.create("parameter_a_b_for_hardness_method_c2_iso_6336_2019", RexsUnitId.none);

	/** Parameter A  for hardness according to method C2 (ISO 6336 2019) (Versions: 1.3) */
	public static final RexsAttributeId parameter_a_for_hardness_method_c2_iso_6336_2019 = RexsAttributeId.create("parameter_a_for_hardness_method_c2_iso_6336_2019", RexsUnitId.none);

	/** Parameter b_a  for hardness according to method C2 (ISO 6336 2019) (Versions: 1.3) */
	public static final RexsAttributeId parameter_b_a_for_hardness_method_c2_iso_6336_2019 = RexsAttributeId.create("parameter_b_a_for_hardness_method_c2_iso_6336_2019", RexsUnitId.none);

	/** Parameter b_b  for hardness according to method C2 (ISO 6336 2019) (Versions: 1.3) */
	public static final RexsAttributeId parameter_b_b_for_hardness_method_c2_iso_6336_2019 = RexsAttributeId.create("parameter_b_b_for_hardness_method_c2_iso_6336_2019", RexsUnitId.none);

	/** Parameter B  for hardness according to method C2 (ISO 6336 2019) (Versions: 1.3) */
	public static final RexsAttributeId parameter_b_for_hardness_method_c2_iso_6336_2019 = RexsAttributeId.create("parameter_b_for_hardness_method_c2_iso_6336_2019", RexsUnitId.none);

	/** Parameter c_a  for hardness according to method C2 (ISO 6336 2019) (Versions: 1.3) */
	public static final RexsAttributeId parameter_c_a_for_hardness_method_c2_iso_6336_2019 = RexsAttributeId.create("parameter_c_a_for_hardness_method_c2_iso_6336_2019", RexsUnitId.none);

	/** Parameter c_b  for hardness according to method C2 (ISO 6336 2019) (Versions: 1.3) */
	public static final RexsAttributeId parameter_c_b_for_hardness_method_c2_iso_6336_2019 = RexsAttributeId.create("parameter_c_b_for_hardness_method_c2_iso_6336_2019", RexsUnitId.none);

	/** Parameter C  for hardness according to method C2 (ISO 6336 2019) (Versions: 1.3) */
	public static final RexsAttributeId parameter_c_for_hardness_method_c2_iso_6336_2019 = RexsAttributeId.create("parameter_c_for_hardness_method_c2_iso_6336_2019", RexsUnitId.none);

	/** Parameter for calculating gear tooth temperature (AGMA 925 A03) (Versions: 1.3) */
	public static final RexsAttributeId parameter_for_calculation_of_tooth_temperature_agma_925_a03 = RexsAttributeId.create("parameter_for_calculation_of_tooth_temperature_agma_925_a03", RexsUnitId.none);

	/** Parameter for mean minimum lubricant film thickness (DIN 3996 2019) (Versions: 1.2, 1.3) */
	public static final RexsAttributeId parameter_for_mean_minimum_lubricant_film_thickness_din_3996_2019 = RexsAttributeId.create("parameter_for_mean_minimum_lubricant_film_thickness_din_3996_2019", RexsUnitId.none);

	/** Parameter k for calculating pressure-viscosity coefficient (AGMA 925 C95) (Versions: 1.3) */
	public static final RexsAttributeId parameter_k_for_calculation_of_pressure_viscosity_coefficient_agma_925_a03 = RexsAttributeId.create("parameter_k_for_calculation_of_pressure_viscosity_coefficient_agma_925_a03", RexsUnitId.none);

	/** Parameter for the mean hertzian stress (DIN 3996 2019) (Versions: 1.2, 1.3) */
	public static final RexsAttributeId parameter_mean_hertzian_stress_din_3996_2019 = RexsAttributeId.create("parameter_mean_hertzian_stress_din_3996_2019", RexsUnitId.none);

	/** Parameter for the mean sliding path (DIN 3996 2019) (Versions: 1.2, 1.3) */
	public static final RexsAttributeId parameter_mean_sliding_path_din_3996_2019 = RexsAttributeId.create("parameter_mean_sliding_path_din_3996_2019", RexsUnitId.none);

	/** Parameter s for calculating pressure-viscosity coefficient (AGMA 925 C95) (Versions: 1.3) */
	public static final RexsAttributeId parameter_s_for_calculation_of_pressure_viscosity_coefficient_agma_925_a03 = RexsAttributeId.create("parameter_s_for_calculation_of_pressure_viscosity_coefficient_agma_925_a03", RexsUnitId.none);

	/** Partial contact ratio of tip path of contact (Versions: 1.3) */
	public static final RexsAttributeId partial_contact_ratio = RexsAttributeId.create("partial_contact_ratio", RexsUnitId.none);

	/** Partial contact ratio (VDI 2736 2014) (Versions: 1.3) */
	public static final RexsAttributeId partial_contact_ratio_vdi_2736_2014 = RexsAttributeId.create("partial_contact_ratio_vdi_2736_2014", RexsUnitId.none);

	/** Peak circumferential force at reference circle (VDI 2736 2014) (Versions: 1.3) */
	public static final RexsAttributeId peak_tangential_force_at_reference_circle_vdi_2736_2014 = RexsAttributeId.create("peak_tangential_force_at_reference_circle_vdi_2736_2014", RexsUnitId.newton);

	/** Permissible change to the circumferential backlash (Plewe 1980) (Versions: 1.3) */
	public static final RexsAttributeId permissible_change_to_the_circumferential_backlash_plewe_1980 = RexsAttributeId.create("permissible_change_to_the_circumferential_backlash_plewe_1980", RexsUnitId.mm);

	/** Permissible flank pressure (VDI 2736 2014) (Versions: 1.3) */
	public static final RexsAttributeId permissible_flank_pressure_vdi_2736_2014 = RexsAttributeId.create("permissible_flank_pressure_vdi_2736_2014", RexsUnitId.newton_per_mm2);

	/** Permissible linear wear (VDI 2736 2014) (Versions: 1.3) */
	public static final RexsAttributeId permissible_linear_wear_vdi_2736_2014 = RexsAttributeId.create("permissible_linear_wear_vdi_2736_2014", RexsUnitId.mm);

	/** Permissible local root stress under peak torque (VDI 2736 2014) (Versions: 1.3) */
	public static final RexsAttributeId permissible_local_root_stress_under_peak_torque_vdi_2736_2014 = RexsAttributeId.create("permissible_local_root_stress_under_peak_torque_vdi_2736_2014", RexsUnitId.newton_per_mm2);

	/** Permissible root stress (VDI 2736 2014) (Versions: 1.3) */
	public static final RexsAttributeId permissible_root_stress_vdi_2736_2014 = RexsAttributeId.create("permissible_root_stress_vdi_2736_2014", RexsUnitId.newton_per_mm2);

	/** Permissible temperature (VDI 2736 2014) (Versions: 1.3) */
	public static final RexsAttributeId permissible_temperature_vdi_2736_2014 = RexsAttributeId.create("permissible_temperature_vdi_2736_2014", RexsUnitId.degree_celsius);

	/** Permissible wear erosion (Plewe 1980) (Versions: 1.3) */
	public static final RexsAttributeId permissible_wear_erosion_plewe_1980 = RexsAttributeId.create("permissible_wear_erosion_plewe_1980", RexsUnitId.mm);

	/** Permissible wear mass (Plewe 1980) (Versions: 1.3) */
	public static final RexsAttributeId permissible_wear_mass_plewe_1980 = RexsAttributeId.create("permissible_wear_mass_plewe_1980", RexsUnitId.mg);

	/** Tolerance class of shaft (Versions: 1.0) */
	public static final RexsAttributeId pin_tolerance_class = RexsAttributeId.create("pin_tolerance_class", RexsUnitId.none);

	/** Pitch angle (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId pitch_angle = RexsAttributeId.create("pitch_angle", RexsUnitId.degree);

	/** Pitch apex beyond crossing point (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId pitch_apex_beyond_crossing_point = RexsAttributeId.create("pitch_apex_beyond_crossing_point", RexsUnitId.mm);

	/** Pitch circle diameter (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId pitch_diameter = RexsAttributeId.create("pitch_diameter", RexsUnitId.mm);

	/** Core hardness depth (ISO 6336 2019) (Versions: 1.3) */
	public static final RexsAttributeId point_of_core_hardeness_iso_6336_2019 = RexsAttributeId.create("point_of_core_hardeness_iso_6336_2019", RexsUnitId.mm);

	/** Point of maximum material exposure (ISO 6336 2019) (Versions: 1.3) */
	public static final RexsAttributeId point_of_maximum_material_exposure_iso_6336_2019 = RexsAttributeId.create("point_of_maximum_material_exposure_iso_6336_2019", RexsUnitId.none);

	/** Poisson's ratio (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId poisson_ratio = RexsAttributeId.create("poisson_ratio", RexsUnitId.none);

	/** Poisson's ratio at operating temperature (VDI 2736 2014) (Versions: 1.3) */
	public static final RexsAttributeId poissons_ratio_vdi_2736_2014 = RexsAttributeId.create("poissons_ratio_vdi_2736_2014", RexsUnitId.none);

	/** Face width coordinate of profile deviations (Versions: 1.2, 1.3) */
	public static final RexsAttributeId position_of_profile_deviation = RexsAttributeId.create("position_of_profile_deviation", RexsUnitId.mm);

	/** Face width coordinate of the profile modification (Versions: 1.2, 1.3) */
	public static final RexsAttributeId position_of_profile_modification = RexsAttributeId.create("position_of_profile_modification", RexsUnitId.mm);

	/** Facewidth coordinate of the profile twist modification on datum face (Versions: 1.2, 1.3) */
	public static final RexsAttributeId position_of_profile_twist_datum_face = RexsAttributeId.create("position_of_profile_twist_datum_face", RexsUnitId.mm);

	/** Facewidth coordinate of the profile twist modification on non-datum face (Versions: 1.2, 1.3) */
	public static final RexsAttributeId position_of_profile_twist_non_datum_face = RexsAttributeId.create("position_of_profile_twist_non_datum_face", RexsUnitId.mm);

	/** Position of rolling elements (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId position_of_rolling_elements = RexsAttributeId.create("position_of_rolling_elements", RexsUnitId.none);

	/** Power with sign (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId power = RexsAttributeId.create("power", RexsUnitId.kilo_watt);

	/** Rolling output (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId power_for_rolling_rotational_speed = RexsAttributeId.create("power_for_rolling_rotational_speed", RexsUnitId.watt);

	/** Power (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId power_for_rotational_speed = RexsAttributeId.create("power_for_rotational_speed", RexsUnitId.watt);

	/** Preload distance (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId preload_distance = RexsAttributeId.create("preload_distance", RexsUnitId.mum);

	/** Preload force (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId preload_force = RexsAttributeId.create("preload_force", RexsUnitId.newton);

	/** Contact angle (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId pressure_angle = RexsAttributeId.create("pressure_angle", RexsUnitId.degree);

	/** Pressure angle correction (Versions: 1.3) */
	public static final RexsAttributeId pressure_angle_correction = RexsAttributeId.create("pressure_angle_correction", RexsUnitId.degree);

	/** Pressure angle (DIN 3975 2017) (Versions: 1.2) */
	public static final RexsAttributeId pressure_angle_din_3975_2017 = RexsAttributeId.create("pressure_angle_din_3975_2017", RexsUnitId.degree);

	/** Pressure angle in the transverse section (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId pressure_angle_in_the_transverse_section = RexsAttributeId.create("pressure_angle_in_the_transverse_section", RexsUnitId.degree);

	/** Pressure angle (Versions: 1.3) */
	public static final RexsAttributeId pressure_angle_worm_gear = RexsAttributeId.create("pressure_angle_worm_gear", RexsUnitId.degree);

	/** Pressure factor (Versions: 1.3) */
	public static final RexsAttributeId pressure_factor_din_3996_2019 = RexsAttributeId.create("pressure_factor_din_3996_2019", RexsUnitId.none);

	/** Pressure viscosity coefficient (AGMA 925 C95) (Versions: 1.3) */
	public static final RexsAttributeId pressure_viscosity_coefficient_agma_925_a03 = RexsAttributeId.create("pressure_viscosity_coefficient_agma_925_a03", RexsUnitId.mm2_per_newton);

	/** Pressure-viscosity coefficient at 38 &deg;C (Versions: 1.3) */
	public static final RexsAttributeId pressure_viscosity_coefficient_at_38_degrees_celsius = RexsAttributeId.create("pressure_viscosity_coefficient_at_38_degrees_celsius", RexsUnitId.mm2_per_newton);

	/** Probability of scuffing (AGMA 925 A03) (Versions: 1.3) */
	public static final RexsAttributeId probability_of_scuffing_agma_925_a03 = RexsAttributeId.create("probability_of_scuffing_agma_925_a03", RexsUnitId.none);

	/** Probability of wear (AGMA 925 A03) (Versions: 1.3) */
	public static final RexsAttributeId probability_of_wear_agma_925_a03 = RexsAttributeId.create("probability_of_wear_agma_925_a03", RexsUnitId.none);

	/** Amount of profile crowning at the root (Versions: 1.2, 1.3) */
	public static final RexsAttributeId profile_crowning_at_root = RexsAttributeId.create("profile_crowning_at_root", RexsUnitId.mm);

	/** Amount of profile crowning at the tip (Versions: 1.2, 1.3) */
	public static final RexsAttributeId profile_crowning_at_tip = RexsAttributeId.create("profile_crowning_at_tip", RexsUnitId.mm);

	/** Amount of profile deviations (Versions: 1.2, 1.3) */
	public static final RexsAttributeId profile_deviation_amounts = RexsAttributeId.create("profile_deviation_amounts", RexsUnitId.mm);

	/** End diameter of profile evaluation (Versions: 1.2, 1.3) */
	public static final RexsAttributeId profile_evaluation_end = RexsAttributeId.create("profile_evaluation_end", RexsUnitId.mm);

	/** Profile control diameter (start of evaluation) (Versions: 1.2, 1.3) */
	public static final RexsAttributeId profile_evaluation_start = RexsAttributeId.create("profile_evaluation_start", RexsUnitId.mm);

	/** Diameter of highest point in profile (Versions: 1.2, 1.3) */
	public static final RexsAttributeId profile_highest_point = RexsAttributeId.create("profile_highest_point", RexsUnitId.mm);

	/** Profile line length of the active tooth flank (VDI 2736 2014) (Versions: 1.3) */
	public static final RexsAttributeId profile_line_length_of_the_active_tooth_flank_vdi_2736_2014 = RexsAttributeId.create("profile_line_length_of_the_active_tooth_flank_vdi_2736_2014", RexsUnitId.mm);

	/** Profile modification (AGMA 925 C95) (Versions: 1.3) */
	public static final RexsAttributeId profile_modification_agma_925_a03 = RexsAttributeId.create("profile_modification_agma_925_a03", RexsUnitId.none);

	/** Profile radius (type ZC) (Versions: 1.3) */
	public static final RexsAttributeId profile_radius_zc_disc = RexsAttributeId.create("profile_radius_zc_disc", RexsUnitId.mm);

	/** Profile shift coefficient (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId profile_shift_coefficient = RexsAttributeId.create("profile_shift_coefficient", RexsUnitId.none);

	/** Amount of profile slope modification (Versions: 1.2, 1.3) */
	public static final RexsAttributeId profile_slope = RexsAttributeId.create("profile_slope", RexsUnitId.mm);

	/** Amount of profile twist modification (Versions: 1.2, 1.3) */
	public static final RexsAttributeId profile_twist = RexsAttributeId.create("profile_twist", RexsUnitId.mm);

	/** End diameter of evaluation of the profile twist (Versions: 1.2, 1.3) */
	public static final RexsAttributeId profile_twist_evaluation_end = RexsAttributeId.create("profile_twist_evaluation_end", RexsUnitId.mm);

	/** Profile control diameter (start of evaluation) of the profile twist (Versions: 1.2, 1.3) */
	public static final RexsAttributeId profile_twist_evaluation_start = RexsAttributeId.create("profile_twist_evaluation_start", RexsUnitId.mm);

	/** Protuberance amount (Versions: 1.0, 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId protuberance_amount = RexsAttributeId.create("protuberance_amount", RexsUnitId.mm);

	/** Protuberance amount factor (Versions: 1.0, 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId protuberance_amount_factor = RexsAttributeId.create("protuberance_amount_factor", RexsUnitId.none);

	/** Protuberance angle (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId protuberance_angle = RexsAttributeId.create("protuberance_angle", RexsUnitId.degree);

	/** Protuberance angle (Versions: 1.3) */
	public static final RexsAttributeId protuberance_angle_bevel_gear_tool = RexsAttributeId.create("protuberance_angle_bevel_gear_tool", RexsUnitId.degree);

	/** Protuberance height (Versions: 1.0, 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId protuberance_height = RexsAttributeId.create("protuberance_height", RexsUnitId.mm);

	/** Protuberance height (Versions: 1.3) */
	public static final RexsAttributeId protuberance_height_bevel_gear_tool = RexsAttributeId.create("protuberance_height_bevel_gear_tool", RexsUnitId.mm);

	/** Protuberance height factor (Versions: 1.0, 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId protuberance_height_factor = RexsAttributeId.create("protuberance_height_factor", RexsUnitId.none);

	/** Protuberance radius (Versions: 1.3) */
	public static final RexsAttributeId protuberance_radius_bevel_gear_tool = RexsAttributeId.create("protuberance_radius_bevel_gear_tool", RexsUnitId.mm);

	/** Radius of raceway at inner ring (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId raceway_radius_of_inner_ring = RexsAttributeId.create("raceway_radius_of_inner_ring", RexsUnitId.mm);

	/** Radius of raceway at outer ring (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId raceway_radius_of_outer_ring = RexsAttributeId.create("raceway_radius_of_outer_ring", RexsUnitId.mm);

	/** Radial backlash (Versions: 1.0) */
	public static final RexsAttributeId radial_backlash = RexsAttributeId.create("radial_backlash", RexsUnitId.mum);

	/** Radial bearing clearance (before mounting) (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId radial_bearing_clearance = RexsAttributeId.create("radial_bearing_clearance", RexsUnitId.mum);

	/** Radial bearing clearance class (before mounting) (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId radial_clearance_class = RexsAttributeId.create("radial_clearance_class", RexsUnitId.none);

	/** Radial contact ratio (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId radial_contact_ratio = RexsAttributeId.create("radial_contact_ratio", RexsUnitId.none);

	/** Relative displacement of the inner ring in the v-direction compared to the outer ring (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId radial_deflection_in_v = RexsAttributeId.create("radial_deflection_in_v", RexsUnitId.mum);

	/** Relative displacement of the inner ring in the w-direction compared to the outer ring (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId radial_deflection_in_w = RexsAttributeId.create("radial_deflection_in_w", RexsUnitId.mum);

	/** Radial distance (Versions: 1.3) */
	public static final RexsAttributeId radial_distance = RexsAttributeId.create("radial_distance", RexsUnitId.mm);

	/** Radial dynamic load rating (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId radial_dynamic_load_rating = RexsAttributeId.create("radial_dynamic_load_rating", RexsUnitId.kilo_newton);

	/** Radial load factor X1 for F_a/F_r &lt;=  e (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId radial_factor_x_1 = RexsAttributeId.create("radial_factor_x_1", RexsUnitId.none);

	/** Radial load factor X2 for F_a/F_r &gt;  e (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId radial_factor_x_2 = RexsAttributeId.create("radial_factor_x_2", RexsUnitId.none);

	/** Support of radial loads (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId radial_force_absorption = RexsAttributeId.create("radial_force_absorption", RexsUnitId.none);

	/** Radial force in v-direction (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId radial_force_in_v = RexsAttributeId.create("radial_force_in_v", RexsUnitId.kilo_newton);

	/** Radial force in w-direction (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId radial_force_in_w = RexsAttributeId.create("radial_force_in_w", RexsUnitId.kilo_newton);

	/** Radial machining allowance (Versions: 1.3) */
	public static final RexsAttributeId radial_maching_allowance_din_509_2006 = RexsAttributeId.create("radial_maching_allowance_din_509_2006", RexsUnitId.mm);

	/** Radial motion coefficients (Versions: 1.3) */
	public static final RexsAttributeId radial_motion_coefficients = RexsAttributeId.create("radial_motion_coefficients", RexsUnitId.none);

	/** Radial static load rating (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId radial_static_load_rating = RexsAttributeId.create("radial_static_load_rating", RexsUnitId.kilo_newton);

	/** Radial stiffness (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId radial_stiffness = RexsAttributeId.create("radial_stiffness", RexsUnitId.newton_per_m);

	/** Radius of curvature at Point A (Plewe 1980) (Versions: 1.3) */
	public static final RexsAttributeId radius_of_curvature_at_point_a_plewe_1980 = RexsAttributeId.create("radius_of_curvature_at_point_a_plewe_1980", RexsUnitId.mm);

	/** Radius of curvature at Point E (Plewe 1980) (Versions: 1.3) */
	public static final RexsAttributeId radius_of_curvature_at_point_e_plewe_1980 = RexsAttributeId.create("radius_of_curvature_at_point_e_plewe_1980", RexsUnitId.mm);

	/** Rakeface inclination angle (Versions: 1.3) */
	public static final RexsAttributeId rakeface_inclination_angle = RexsAttributeId.create("rakeface_inclination_angle", RexsUnitId.degree);

	/** Ratio of roll (Versions: 1.3) */
	public static final RexsAttributeId ratio_of_roll = RexsAttributeId.create("ratio_of_roll", RexsUnitId.none);

	/** Reduced modulus of elasticity (AGMA 925 A03) (Versions: 1.3) */
	public static final RexsAttributeId reduced_modulus_of_elasticity_agma_925_a03 = RexsAttributeId.create("reduced_modulus_of_elasticity_agma_925_a03", RexsUnitId.newton_per_mm2);

	/** Reduced modulus of elasticity (ISO 6336 2019) (Versions: 1.3) */
	public static final RexsAttributeId reduced_modulus_of_elasticity_iso_6336_2019 = RexsAttributeId.create("reduced_modulus_of_elasticity_iso_6336_2019", RexsUnitId.newton_per_mm2);

	/** Reduced static stiffness matrix (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId reduced_static_stiffness_matrix = RexsAttributeId.create("reduced_static_stiffness_matrix", RexsUnitId.none);

	/** Reference circle diameter (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId reference_circle_diameter = RexsAttributeId.create("reference_circle_diameter", RexsUnitId.mm);

	/** Reference component for position (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId reference_component_for_position = RexsAttributeId.create("reference_component_for_position", RexsUnitId.none);

	/** Reference diameter (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId reference_diameter = RexsAttributeId.create("reference_diameter", RexsUnitId.mm);

	/** Reference diameter (DIN 3975 2017) (Versions: 1.2) */
	public static final RexsAttributeId reference_diameter_din_3975_2017 = RexsAttributeId.create("reference_diameter_din_3975_2017", RexsUnitId.mm);

	/** Reference diameter (Versions: 1.3) */
	public static final RexsAttributeId reference_diameter_worm_gear = RexsAttributeId.create("reference_diameter_worm_gear", RexsUnitId.mm);

	/** Reference lead angle (DIN 3975 2017) (Versions: 1.2) */
	public static final RexsAttributeId reference_lead_angle_din_3975_2017 = RexsAttributeId.create("reference_lead_angle_din_3975_2017", RexsUnitId.degree);

	/** Thermal reference speed (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId reference_speed = RexsAttributeId.create("reference_speed", RexsUnitId.none);

	/** Reference temperature (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId reference_temperature = RexsAttributeId.create("reference_temperature", RexsUnitId.degree_celsius);

	/** Reference wear intensity (Versions: 1.3) */
	public static final RexsAttributeId reference_wear_intensity_din_3996_2019 = RexsAttributeId.create("reference_wear_intensity_din_3996_2019", RexsUnitId.none);

	/** Related tip thickness (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId related_tip_thickness = RexsAttributeId.create("related_tip_thickness", RexsUnitId.none);

	/** Distance from datum line to measuring line relative to the normal module (Versions: 1.2, 1.3) */
	public static final RexsAttributeId relative_distance_tool_profile_basic_line_to_measuring_line = RexsAttributeId.create("relative_distance_tool_profile_basic_line_to_measuring_line", RexsUnitId.none);

	/** Relative duty cycle (VDI 2736 2014) (Versions: 1.3) */
	public static final RexsAttributeId relative_duty_cycle_vdi_2736_2014 = RexsAttributeId.create("relative_duty_cycle_vdi_2736_2014", RexsUnitId.none);

	/** Lever arm for load at tip to 30 degree tangent (relative to module) (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId relative_lever_arm_for_load_at_tip_to_30_degree_tangent = RexsAttributeId.create("relative_lever_arm_for_load_at_tip_to_30_degree_tangent", RexsUnitId.none);

	/** Machining allowance of the tool (relative to the normal module) (Versions: 1.2) */
	public static final RexsAttributeId relative_machining_allowance = RexsAttributeId.create("relative_machining_allowance", RexsUnitId.none);

	/** Machining allowance of the tool according to DIN 3972 (relative to the normal module) (Versions: 1.3) */
	public static final RexsAttributeId relative_machining_allowance_din_3972 = RexsAttributeId.create("relative_machining_allowance_din_3972", RexsUnitId.none);

	/** Tool b_z0* measurement (relative to module) (Versions: 1.2, 1.3) */
	public static final RexsAttributeId relative_measurement_bz0 = RexsAttributeId.create("relative_measurement_bz0", RexsUnitId.none);

	/** Tooth root chord at the 30&deg; tangent (relative to module) (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId relative_tooth_root_chord_at_30_degree_tangent = RexsAttributeId.create("relative_tooth_root_chord_at_30_degree_tangent", RexsUnitId.none);

	/** Tooth root radius at the 30&deg; tangent (relative to module) (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId relative_tooth_root_radius_at_30_degree_tangent = RexsAttributeId.create("relative_tooth_root_radius_at_30_degree_tangent", RexsUnitId.none);

	/** Remaining protuberance (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId remaining_protuberance = RexsAttributeId.create("remaining_protuberance", RexsUnitId.mm);

	/** Required minimum tooth flank safety factor (VDI 2736 2014) (Versions: 1.3) */
	public static final RexsAttributeId required_minimum_safety_factor_flank_vdi_2736_2014 = RexsAttributeId.create("required_minimum_safety_factor_flank_vdi_2736_2014", RexsUnitId.none);

	/** Required tooth root minimum safety factor (Plewe 1980) (Versions: 1.3) */
	public static final RexsAttributeId required_minimum_safety_factor_root_plewe_1980 = RexsAttributeId.create("required_minimum_safety_factor_root_plewe_1980", RexsUnitId.none);

	/** Required minimum tooth root safety factor (VDI 2736 2014) (Versions: 1.3) */
	public static final RexsAttributeId required_minimum_safety_factor_root_vdi_2736_2014 = RexsAttributeId.create("required_minimum_safety_factor_root_vdi_2736_2014", RexsUnitId.none);

	/** Required minimum safety factor for exceeding the yield strength (VDI 2736 2014) (Versions: 1.3) */
	public static final RexsAttributeId required_minimum_safety_factor_yield_strength_vdi_2736_2014 = RexsAttributeId.create("required_minimum_safety_factor_yield_strength_vdi_2736_2014", RexsUnitId.none);

	/** Rim thickness factor (tooth bending) (Versions: 1.3) */
	public static final RexsAttributeId rim_thickness_factor_tooth_bending_din_3996_2019 = RexsAttributeId.create("rim_thickness_factor_tooth_bending_din_3996_2019", RexsUnitId.none);

	/** Rim width (Versions: 1.3) */
	public static final RexsAttributeId rim_width_worm_wheel = RexsAttributeId.create("rim_width_worm_wheel", RexsUnitId.mm);

	/** Roll angles of calculation points (AGMA 925 A03) (Versions: 1.3) */
	public static final RexsAttributeId roll_angles_of_calculation_points_agma_925_a03 = RexsAttributeId.create("roll_angles_of_calculation_points_agma_925_a03", RexsUnitId.radian);

	/** Roller angle (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId roller_angle = RexsAttributeId.create("roller_angle", RexsUnitId.degree);

	/** Roller crowning radius (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId roller_crowning_radius = RexsAttributeId.create("roller_crowning_radius", RexsUnitId.mm);

	/** Surface radius of roller (Versions: 1.0) */
	public static final RexsAttributeId roller_shell_radius = RexsAttributeId.create("roller_shell_radius", RexsUnitId.mm);

	/** Path of bearing file (Versions: 1.0) */
	public static final RexsAttributeId rolling_bearing_file = RexsAttributeId.create("rolling_bearing_file", RexsUnitId.none);

	/** Rolling contact fatigue strength (VDI 2736 2014) (Versions: 1.3) */
	public static final RexsAttributeId rolling_contact_fatigue_strength_vdi_2736_2014 = RexsAttributeId.create("rolling_contact_fatigue_strength_vdi_2736_2014", RexsUnitId.newton_per_mm2);

	/** Contact type (Versions: 1.3) */
	public static final RexsAttributeId rolling_element_contact_type = RexsAttributeId.create("rolling_element_contact_type", RexsUnitId.none);

	/** Coordinates on rolling element (Versions: 1.3) */
	public static final RexsAttributeId rolling_element_coordinate = RexsAttributeId.create("rolling_element_coordinate", RexsUnitId.mm);

	/** Rolling element force (Versions: 1.3) */
	public static final RexsAttributeId rolling_element_force = RexsAttributeId.create("rolling_element_force", RexsUnitId.kilo_newton);

	/** Rolling element lamina load (Versions: 1.3) */
	public static final RexsAttributeId rolling_element_lamina_load = RexsAttributeId.create("rolling_element_lamina_load", RexsUnitId.newton);

	/** Rolling element pressure (Versions: 1.3) */
	public static final RexsAttributeId rolling_element_pressure = RexsAttributeId.create("rolling_element_pressure", RexsUnitId.newton_per_mm2);

	/** Rolling element torque (Versions: 1.3) */
	public static final RexsAttributeId rolling_element_torque = RexsAttributeId.create("rolling_element_torque", RexsUnitId.newton_m);

	/** Rolling length where amount of modification is specified (Versions: 1.2, 1.3) */
	public static final RexsAttributeId rolling_length_where_profile_slope_amount_is_specified = RexsAttributeId.create("rolling_length_where_profile_slope_amount_is_specified", RexsUnitId.mm);

	/** Rolling length where amount of profile twist is specified (Versions: 1.2, 1.3) */
	public static final RexsAttributeId rolling_length_where_profile_twist_amount_is_specified = RexsAttributeId.create("rolling_length_where_profile_twist_amount_is_specified", RexsUnitId.mm);

	/** Rolling rotational speed (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId rolling_rotational_speed = RexsAttributeId.create("rolling_rotational_speed", RexsUnitId.rotation_per_min);

	/** Rolling tangential velocity at the calculation points (AGMA 925 A03) (Versions: 1.3) */
	public static final RexsAttributeId rolling_tangential_velocity_of_calculation_points_agma_925_a03 = RexsAttributeId.create("rolling_tangential_velocity_of_calculation_points_agma_925_a03", RexsUnitId.m_per_second);

	/** Root angle (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId root_angle = RexsAttributeId.create("root_angle", RexsUnitId.degree);

	/** Root apex beyond crossing point (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId root_apex_beyond_crossing_point = RexsAttributeId.create("root_apex_beyond_crossing_point", RexsUnitId.mm);

	/** Root diameter (Versions: 1.2, 1.3) */
	public static final RexsAttributeId root_diameter = RexsAttributeId.create("root_diameter", RexsUnitId.mm);

	/** Root diameter (DIN 3975 2017) (Versions: 1.2) */
	public static final RexsAttributeId root_diameter_din_3975_2017 = RexsAttributeId.create("root_diameter_din_3975_2017", RexsUnitId.mm);

	/** Root diameter (Versions: 1.3) */
	public static final RexsAttributeId root_diameter_worm_gear = RexsAttributeId.create("root_diameter_worm_gear", RexsUnitId.mm);

	/** Root form diameter (Versions: 1.2, 1.3) */
	public static final RexsAttributeId root_form_diameter = RexsAttributeId.create("root_form_diameter", RexsUnitId.mm);

	/** Root mean square roughness at filter cutoff of wavelength (AGMA 925 A03) (Versions: 1.3) */
	public static final RexsAttributeId root_mean_square_roughness_at_filter_cutoff_of_wavelength_agma_925_a03 = RexsAttributeId.create("root_mean_square_roughness_at_filter_cutoff_of_wavelength_agma_925_a03", RexsUnitId.mum);

	/** Diameter at start of root relief (reference diameter) (Versions: 1.2, 1.3) */
	public static final RexsAttributeId root_relief_datum_diameter = RexsAttributeId.create("root_relief_datum_diameter", RexsUnitId.mm);

	/** Length of root relief (Versions: 1.2, 1.3) */
	public static final RexsAttributeId root_relief_datum_length = RexsAttributeId.create("root_relief_datum_length", RexsUnitId.mm);

	/** Depth of root relief (Versions: 1.2, 1.3) */
	public static final RexsAttributeId root_relief_depth = RexsAttributeId.create("root_relief_depth", RexsUnitId.mm);

	/** Diameter where tangential transition ends (Versions: 1.2, 1.3) */
	public static final RexsAttributeId root_relief_diameter_where_tangential_transition_ends = RexsAttributeId.create("root_relief_diameter_where_tangential_transition_ends", RexsUnitId.mm);

	/** Diameter where tangential transition starts (Versions: 1.2, 1.3) */
	public static final RexsAttributeId root_relief_diameter_where_tangential_transition_starts = RexsAttributeId.create("root_relief_diameter_where_tangential_transition_starts", RexsUnitId.mm);

	/** Diameter where amount of modification is specified (Versions: 1.2, 1.3) */
	public static final RexsAttributeId root_relief_evaluation_reference = RexsAttributeId.create("root_relief_evaluation_reference", RexsUnitId.mm);

	/** Length where amount of modification is specified (Versions: 1.2, 1.3) */
	public static final RexsAttributeId root_relief_evaluation_reference_length = RexsAttributeId.create("root_relief_evaluation_reference_length", RexsUnitId.mm);

	/** Length of tangential transition end (Versions: 1.2, 1.3) */
	public static final RexsAttributeId root_relief_length_of_tangential_transition_end = RexsAttributeId.create("root_relief_length_of_tangential_transition_end", RexsUnitId.mm);

	/** Length of tangential transition start (Versions: 1.2, 1.3) */
	public static final RexsAttributeId root_relief_length_of_tangential_transition_start = RexsAttributeId.create("root_relief_length_of_tangential_transition_start", RexsUnitId.mm);

	/** Root stress (VDI 2736 2014) (Versions: 1.3) */
	public static final RexsAttributeId root_stress_vdi_2736_2014 = RexsAttributeId.create("root_stress_vdi_2736_2014", RexsUnitId.newton_per_mm2);

	/** Root temperature (VDI 2736 2014) (Versions: 1.3) */
	public static final RexsAttributeId root_temperature_vdi_2736_2014 = RexsAttributeId.create("root_temperature_vdi_2736_2014", RexsUnitId.degree_celsius);

	/** Root undercut (Versions: 1.2, 1.3) */
	public static final RexsAttributeId root_undercut = RexsAttributeId.create("root_undercut", RexsUnitId.mm);

	/** Shaft angle (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId rotating_angle_around_neg_u_axis = RexsAttributeId.create("rotating_angle_around_neg_u_axis", RexsUnitId.degree);

	/** Rotating angle around u-axis (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId rotating_angle_around_pos_u_axis = RexsAttributeId.create("rotating_angle_around_pos_u_axis", RexsUnitId.degree);

	/** Rotational speed with sign (Versions: 1.0, 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId rotational_speed = RexsAttributeId.create("rotational_speed", RexsUnitId.rotation_per_min);

	/** Torsional stiffness (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId rotational_stiffness = RexsAttributeId.create("rotational_stiffness", RexsUnitId.newton_mm_per_rad);

	/** Radius of raceway at inner ring (Versions: 1.0) */
	public static final RexsAttributeId running_path_radius_of_inner_ring = RexsAttributeId.create("running_path_radius_of_inner_ring", RexsUnitId.mm);

	/** Radius of raceway at outer ring (Versions: 1.0) */
	public static final RexsAttributeId running_path_radius_of_outer_ring = RexsAttributeId.create("running_path_radius_of_outer_ring", RexsUnitId.mm);

	/** Shaft safety against cracking (Versions: 1.3) */
	public static final RexsAttributeId safety_factor_cracking_din_743_2012 = RexsAttributeId.create("safety_factor_cracking_din_743_2012", RexsUnitId.none);

	/** Safety factor deflection (DIN 3996 2019) (Versions: 1.2, 1.3) */
	public static final RexsAttributeId safety_factor_deflection_din_3996_2019 = RexsAttributeId.create("safety_factor_deflection_din_3996_2019", RexsUnitId.none);

	/** Shaft safety against fatigue fracture (Versions: 1.3) */
	public static final RexsAttributeId safety_factor_fatigue_fracture_din_743_2012 = RexsAttributeId.create("safety_factor_fatigue_fracture_din_743_2012", RexsUnitId.none);

	/** Tooth flank safety factor (VDI 2736 2014) (Versions: 1.3) */
	public static final RexsAttributeId safety_factor_flank_vdi_2736_2014 = RexsAttributeId.create("safety_factor_flank_vdi_2736_2014", RexsUnitId.none);

	/** Safety factor pitting (DIN 3996 2019) (Versions: 1.2, 1.3) */
	public static final RexsAttributeId safety_factor_pitting_din_3996_2019 = RexsAttributeId.create("safety_factor_pitting_din_3996_2019", RexsUnitId.none);

	/** Shaft safety against plastic deformation (Versions: 1.3) */
	public static final RexsAttributeId safety_factor_plastic_deformation_din_743_2012 = RexsAttributeId.create("safety_factor_plastic_deformation_din_743_2012", RexsUnitId.none);

	/** Safety factor root (DIN 3990 1987) (Versions: 1.3) */
	public static final RexsAttributeId safety_factor_root_din_3990_1987 = RexsAttributeId.create("safety_factor_root_din_3990_1987", RexsUnitId.none);

	/** Safety factor root (DIN 3996 2019) (Versions: 1.2, 1.3) */
	public static final RexsAttributeId safety_factor_root_din_3996_2019 = RexsAttributeId.create("safety_factor_root_din_3996_2019", RexsUnitId.none);

	/** Tooth root safety factor for peak loads (VDI 2736 2014) (Versions: 1.3) */
	public static final RexsAttributeId safety_factor_root_for_peak_loads_vdi_2736_2014 = RexsAttributeId.create("safety_factor_root_for_peak_loads_vdi_2736_2014", RexsUnitId.none);

	/** Tooth root safety factor (VDI 2736 2014) (Versions: 1.3) */
	public static final RexsAttributeId safety_factor_root_vdi_2736_2014 = RexsAttributeId.create("safety_factor_root_vdi_2736_2014", RexsUnitId.none);

	/** Scuffing risk (AGMA 925 A03) (Versions: 1.3) */
	public static final RexsAttributeId scuffing_risk_agma_925_a03 = RexsAttributeId.create("scuffing_risk_agma_925_a03", RexsUnitId.none);

	/** Semi-width of the Hertzian contact band of the calculation points (AGMA 925 A03) (Versions: 1.3) */
	public static final RexsAttributeId semi_width_of_the_rectangular_contact_band_of_calculation_points_agma_925_a03 = RexsAttributeId.create("semi_width_of_the_rectangular_contact_band_of_calculation_points_agma_925_a03", RexsUnitId.mm);

	/** Shaft angle (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId shaft_angle = RexsAttributeId.create("shaft_angle", RexsUnitId.degree);

	/** Inner shaft diameter for the operating clearance calculation (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId shaft_inner_diameter = RexsAttributeId.create("shaft_inner_diameter", RexsUnitId.mm);

	/** Surface roughness of shaft (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId shaft_surface_roughness = RexsAttributeId.create("shaft_surface_roughness", RexsUnitId.mum);

	/** Tolerance class of shaft (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId shaft_tolerance_class = RexsAttributeId.create("shaft_tolerance_class", RexsUnitId.none);

	/** Shape of helix crowning (Versions: 1.2, 1.3) */
	public static final RexsAttributeId shape_of_helix_crowning = RexsAttributeId.create("shape_of_helix_crowning", RexsUnitId.none);

	/** Shape of profile crowning (Versions: 1.2, 1.3) */
	public static final RexsAttributeId shape_of_profile_crowning = RexsAttributeId.create("shape_of_profile_crowning", RexsUnitId.none);

	/** Shape of relief (Versions: 1.2, 1.3) */
	public static final RexsAttributeId shape_of_relief = RexsAttributeId.create("shape_of_relief", RexsUnitId.none);

	/** Shape of undercut (Versions: 1.3) */
	public static final RexsAttributeId shape_of_undercut = RexsAttributeId.create("shape_of_undercut", RexsUnitId.none);

	/** Shear modulus (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId shear_modulus = RexsAttributeId.create("shear_modulus", RexsUnitId.newton_per_mm2);

	/** Shear stress at tooth root (DIN 3996 2019) (Versions: 1.2, 1.3) */
	public static final RexsAttributeId shear_stress_tooth_root_din_3996_2019 = RexsAttributeId.create("shear_stress_tooth_root_din_3996_2019", RexsUnitId.newton_per_mm2);

	/** Side rake angle (Versions: 1.3) */
	public static final RexsAttributeId side_rake_angle = RexsAttributeId.create("side_rake_angle", RexsUnitId.degree);

	/** Maximum length of inner ring contact (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId significant_contact_length_inner_ring = RexsAttributeId.create("significant_contact_length_inner_ring", RexsUnitId.mm);

	/** Maximum length of outer ring contact (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId significant_contact_length_outer_ring = RexsAttributeId.create("significant_contact_length_outer_ring", RexsUnitId.mm);

	/** Possible contact length of rolling element inner ring (Versions: 1.0) */
	public static final RexsAttributeId significant_width_inner = RexsAttributeId.create("significant_width_inner", RexsUnitId.mm);

	/** Possible contact length of rolling element outer ring (Versions: 1.0) */
	public static final RexsAttributeId significant_width_outer = RexsAttributeId.create("significant_width_outer", RexsUnitId.mm);

	/** Single pitch deviation (Versions: 1.3) */
	public static final RexsAttributeId single_pitch_deviation = RexsAttributeId.create("single_pitch_deviation", RexsUnitId.mm);

	/** size factor (wheel bulk temperature) (Versions: 1.3) */
	public static final RexsAttributeId size_factor_bulk_temperatur_din_3996_2019 = RexsAttributeId.create("size_factor_bulk_temperatur_din_3996_2019", RexsUnitId.none);

	/** Size factor (pitting) (Versions: 1.3) */
	public static final RexsAttributeId size_factor_pitting_din_3996_2019 = RexsAttributeId.create("size_factor_pitting_din_3996_2019", RexsUnitId.none);

	/** Size over balls (Versions: 1.2, 1.3) */
	public static final RexsAttributeId size_over_balls = RexsAttributeId.create("size_over_balls", RexsUnitId.mm);

	/** Size over pins (Versions: 1.2, 1.3) */
	public static final RexsAttributeId size_over_pins = RexsAttributeId.create("size_over_pins", RexsUnitId.mm);

	/** Sliding base (Versions: 1.3) */
	public static final RexsAttributeId sliding_base = RexsAttributeId.create("sliding_base", RexsUnitId.mm);

	/** Sliding factor at tip diameter (Versions: 1.2, 1.3) */
	public static final RexsAttributeId sliding_factor_at_tip_diameter = RexsAttributeId.create("sliding_factor_at_tip_diameter", RexsUnitId.none);

	/** Sliding velocity at reference diameter (DIN 3996 2019) (Versions: 1.2, 1.3) */
	public static final RexsAttributeId sliding_velocity_at_reference_diameter_din_3996_2019 = RexsAttributeId.create("sliding_velocity_at_reference_diameter_din_3996_2019", RexsUnitId.m_per_second);

	/** Sliding velocity at the calculation points (Versions: 1.3) */
	public static final RexsAttributeId sliding_velocity_of_calculation_points_agma_925_a03 = RexsAttributeId.create("sliding_velocity_of_calculation_points_agma_925_a03", RexsUnitId.m_per_second);

	/** Span measurement (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId span_measurement = RexsAttributeId.create("span_measurement", RexsUnitId.mm);

	/** Specific film thickness with a cutoff wavelength equal to the Hertzian contact width at the calculation points (AGMA 925 A03) (Versions: 1.3) */
	public static final RexsAttributeId specific_film_thickness_of_calculation_points_agma_925_a03 = RexsAttributeId.create("specific_film_thickness_of_calculation_points_agma_925_a03", RexsUnitId.none);

	/** Specific sliding (tooth root) (Versions: 1.2, 1.3) */
	public static final RexsAttributeId specific_sliding_at_root_diameter = RexsAttributeId.create("specific_sliding_at_root_diameter", RexsUnitId.none);

	/** Specific sliding (tooth tip) (Versions: 1.2, 1.3) */
	public static final RexsAttributeId specific_sliding_at_tip_diameter = RexsAttributeId.create("specific_sliding_at_tip_diameter", RexsUnitId.none);

	/** Specify tangential transition (Versions: 1.2, 1.3) */
	public static final RexsAttributeId specify_tangential_transition = RexsAttributeId.create("specify_tangential_transition", RexsUnitId.none);

	/** Rotational speed inner ring (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId speed_inner_ring = RexsAttributeId.create("speed_inner_ring", RexsUnitId.rotation_per_min);

	/** Rotational speed outer ring (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId speed_outer_ring = RexsAttributeId.create("speed_outer_ring", RexsUnitId.rotation_per_min);

	/** Speed parameter for central film thickness at the calculation points (AGMA 925 A03) (Versions: 1.3) */
	public static final RexsAttributeId speed_parameter_for_central_film_thickness_of_calculation_points_amga_925_a03 = RexsAttributeId.create("speed_parameter_for_central_film_thickness_of_calculation_points_amga_925_a03", RexsUnitId.none);

	/** Speed rolling element set / cage (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId speed_rolling_element_set = RexsAttributeId.create("speed_rolling_element_set", RexsUnitId.rotation_per_min);

	/** Spiral angle factor (VDI 2736 2014) (Versions: 1.3) */
	public static final RexsAttributeId spiral_angle_factor_vdi_2736_2014 = RexsAttributeId.create("spiral_angle_factor_vdi_2736_2014", RexsUnitId.none);

	/** Direction of the spiral angle (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId spiral_angle_pitch_direction = RexsAttributeId.create("spiral_angle_pitch_direction", RexsUnitId.none);

	/** Standard deviation of the minimum specific film thickness (AGMA 925 A03) (Versions: 1.3) */
	public static final RexsAttributeId standard_deviation_of_minimum_specific_film_thickness_agma_925_a03 = RexsAttributeId.create("standard_deviation_of_minimum_specific_film_thickness_agma_925_a03", RexsUnitId.mum);

	/** Start factor (Versions: 1.3) */
	public static final RexsAttributeId start_factor_din_3996_2019 = RexsAttributeId.create("start_factor_din_3996_2019", RexsUnitId.none);

	/** Start-up time (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId start_up_time = RexsAttributeId.create("start_up_time", RexsUnitId.second);

	/** Static load rating (Versions: 1.0) */
	public static final RexsAttributeId static_capacity = RexsAttributeId.create("static_capacity", RexsUnitId.kilo_newton);

	/** Static load safety (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId static_load_safety = RexsAttributeId.create("static_load_safety", RexsUnitId.none);

	/** Static overload factor (VDI 2736 2014) (Versions: 1.3) */
	public static final RexsAttributeId static_overload_factor_vdi_2736_2014 = RexsAttributeId.create("static_overload_factor_vdi_2736_2014", RexsUnitId.none);

	/** Static supporting effect bending (Versions: 1.3) */
	public static final RexsAttributeId static_supporting_effect_bending_din_743_2012 = RexsAttributeId.create("static_supporting_effect_bending_din_743_2012", RexsUnitId.none);

	/** Static supporting effect tension/ compression (Versions: 1.3) */
	public static final RexsAttributeId static_supporting_effect_tension_compression_din_743_2012 = RexsAttributeId.create("static_supporting_effect_tension_compression_din_743_2012", RexsUnitId.none);

	/** Static supporting effect torsion (Versions: 1.3) */
	public static final RexsAttributeId static_supporting_effect_torsion_din_743_2012 = RexsAttributeId.create("static_supporting_effect_torsion_din_743_2012", RexsUnitId.none);

	/** Stress amplitude bending (Versions: 1.3) */
	public static final RexsAttributeId stress_amplitude_bending_din_743_2012 = RexsAttributeId.create("stress_amplitude_bending_din_743_2012", RexsUnitId.newton_per_mm2);

	/** Stress amplitude tosion/ compression (Versions: 1.3) */
	public static final RexsAttributeId stress_amplitude_tension_compression_din_743_2012 = RexsAttributeId.create("stress_amplitude_tension_compression_din_743_2012", RexsUnitId.newton_per_mm2);

	/** Stress amplitude torsion (Versions: 1.3) */
	public static final RexsAttributeId stress_amplitude_torsion_din_743_2012 = RexsAttributeId.create("stress_amplitude_torsion_din_743_2012", RexsUnitId.newton_per_mm2);

	/** Stress correction factor notch effect (VDI 2736 2014) (Versions: 1.3) */
	public static final RexsAttributeId stress_correction_factor_notch_effect_vdi_2736_2014 = RexsAttributeId.create("stress_correction_factor_notch_effect_vdi_2736_2014", RexsUnitId.none);

	/** Strength stress correction factor (VDI 2736 2014) (Versions: 1.3) */
	public static final RexsAttributeId stress_correction_factor_strength_vdi_2736_2014 = RexsAttributeId.create("stress_correction_factor_strength_vdi_2736_2014", RexsUnitId.none);

	/** Circumferential angle of struts of planet carrier (Versions: 1.2, 1.3) */
	public static final RexsAttributeId strut_circumferential_angle = RexsAttributeId.create("strut_circumferential_angle", RexsUnitId.degree);

	/** Inner diameter of struts of planet carrier (Versions: 1.2, 1.3) */
	public static final RexsAttributeId strut_inner_diameter = RexsAttributeId.create("strut_inner_diameter", RexsUnitId.mm);

	/** Radius of planet recess in the struts of the planet carrier (Versions: 1.2, 1.3) */
	public static final RexsAttributeId strut_radius_planet_recess = RexsAttributeId.create("strut_radius_planet_recess", RexsUnitId.mm);

	/** Sum of addendum modification coefficients (profile shift coefficients) (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId sum_of_addendum_modification_coefficients = RexsAttributeId.create("sum_of_addendum_modification_coefficients", RexsUnitId.none);

	/** Support vector (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId support_vector = RexsAttributeId.create("support_vector", RexsUnitId.mm);

	/** Surface hardness - Brinell (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId surface_hardness_brinell = RexsAttributeId.create("surface_hardness_brinell", RexsUnitId.hb);

	/** Surface hardness - Rockwell (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId surface_hardness_rockwell = RexsAttributeId.create("surface_hardness_rockwell", RexsUnitId.hrc);

	/** Surface hardness - Vickers (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId surface_hardness_vickers = RexsAttributeId.create("surface_hardness_vickers", RexsUnitId.hv);

	/** Surface roughness constant (AGMA 925 A03) (Versions: 1.3) */
	public static final RexsAttributeId surface_roughness_constant_agma_925_a03 = RexsAttributeId.create("surface_roughness_constant_agma_925_a03", RexsUnitId.none);

	/** Surface roughness factor (VDI 2736 2014) (Versions: 1.3) */
	public static final RexsAttributeId surface_roughness_factor_vdi_2736_2014 = RexsAttributeId.create("surface_roughness_factor_vdi_2736_2014", RexsUnitId.none);

	/** Surface zone bending resistance (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId surface_zone_bending_resistance = RexsAttributeId.create("surface_zone_bending_resistance", RexsUnitId.mega_pascal);

	/** Surface zone tension resistance (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId surface_zone_tension_resistance = RexsAttributeId.create("surface_zone_tension_resistance", RexsUnitId.mega_pascal);

	/** Surface zone torsion resistance (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId surface_zone_torsion_resistance = RexsAttributeId.create("surface_zone_torsion_resistance", RexsUnitId.mega_pascal);

	/** Survival probability (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId survival_probablity = RexsAttributeId.create("survival_probablity", RexsUnitId.percent);

	/** Swivel motion coefficients (Versions: 1.3) */
	public static final RexsAttributeId swivel_motion_coefficients = RexsAttributeId.create("swivel_motion_coefficients", RexsUnitId.none);

	/** Tangential velocity at pitch circle (Versions: 1.3) */
	public static final RexsAttributeId tangential_velocity_at_pitch_circle = RexsAttributeId.create("tangential_velocity_at_pitch_circle", RexsUnitId.m_per_second);

	/** Tangential velocity at reference circle (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId tangential_velocity_at_reference_circle = RexsAttributeId.create("tangential_velocity_at_reference_circle", RexsUnitId.m_per_second);

	/** Technological size factor tensile strength (Versions: 1.3) */
	public static final RexsAttributeId technological_size_factor_tensile_strength_din_743_2012 = RexsAttributeId.create("technological_size_factor_tensile_strength_din_743_2012", RexsUnitId.none);

	/** Technological size factor yield strength (Versions: 1.3) */
	public static final RexsAttributeId technological_size_factor_yield_strength_din_743_2012 = RexsAttributeId.create("technological_size_factor_yield_strength_din_743_2012", RexsUnitId.none);

	/** Temperature-dependent modulus of elasticity (Versions: 1.3) */
	public static final RexsAttributeId temperature_dependent_modulus_of_elasticity = RexsAttributeId.create("temperature_dependent_modulus_of_elasticity", RexsUnitId.newton_per_mm2);

	/** Temperature dependent poisson's ratio (Versions: 1.3) */
	public static final RexsAttributeId temperature_dependent_poissons_ratio = RexsAttributeId.create("temperature_dependent_poissons_ratio", RexsUnitId.none);

	/** Temperature-dependent yield strength (Versions: 1.3) */
	public static final RexsAttributeId temperature_dependent_yield_strength = RexsAttributeId.create("temperature_dependent_yield_strength", RexsUnitId.newton_per_mm2);

	/** Temperature difference inner / outer ring (Versions: 1.0) */
	public static final RexsAttributeId temperature_difference = RexsAttributeId.create("temperature_difference", RexsUnitId.kelvin);

	/** Temperature difference between bearing and surroundings (Versions: 1.0) */
	public static final RexsAttributeId temperature_difference_bearing_environment = RexsAttributeId.create("temperature_difference_bearing_environment", RexsUnitId.kelvin);

	/** Temperature difference between operation and assembly (Versions: 1.0) */
	public static final RexsAttributeId temperature_difference_operation_and_installation = RexsAttributeId.create("temperature_difference_operation_and_installation", RexsUnitId.kelvin);

	/** Operating temperature of lubricant (Versions: 1.0, 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId temperature_lubricant = RexsAttributeId.create("temperature_lubricant", RexsUnitId.degree_celsius);

	/** Temperature safety factor (Versions: 1.3) */
	public static final RexsAttributeId temperature_safety_factor_din_3996_2019 = RexsAttributeId.create("temperature_safety_factor_din_3996_2019", RexsUnitId.none);

	/** Temperature variation for modulus of elasticity (Versions: 1.3) */
	public static final RexsAttributeId temperature_variation_for_modulus_of_elasticity = RexsAttributeId.create("temperature_variation_for_modulus_of_elasticity", RexsUnitId.degree_celsius);

	/** Temperature variation for poisson's ratio (Versions: 1.3) */
	public static final RexsAttributeId temperature_variation_for_poissons_ratio = RexsAttributeId.create("temperature_variation_for_poissons_ratio", RexsUnitId.degree_celsius);

	/** Temperature variation for yield strength (Versions: 1.3) */
	public static final RexsAttributeId temperature_variation_for_yield_strength = RexsAttributeId.create("temperature_variation_for_yield_strength", RexsUnitId.degree_celsius);

	/** Tensile strength (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId tensile_strength = RexsAttributeId.create("tensile_strength", RexsUnitId.newton_per_mm2);

	/** Tension/ compression yield strength (Versions: 1.3) */
	public static final RexsAttributeId tensile_yield_stress_din_743_2012 = RexsAttributeId.create("tensile_yield_stress_din_743_2012", RexsUnitId.newton_per_mm2);

	/** Specific thermal capacity (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId thermal_capacity = RexsAttributeId.create("thermal_capacity", RexsUnitId.j_per_kg_k);

	/** Thermal conductivity (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId thermal_conductivity = RexsAttributeId.create("thermal_conductivity", RexsUnitId.watt_per_m_k);

	/** Thermal contact coefficient (AGMA 925 C95) (Versions: 1.3) */
	public static final RexsAttributeId thermal_contact_coefficient_agma_925_a03 = RexsAttributeId.create("thermal_contact_coefficient_agma_925_a03", RexsUnitId.newton_per_mm_s_then_squareroot_k);

	/** Thermal expansion coefficient (-) (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId thermal_expansion_coefficient_minus = RexsAttributeId.create("thermal_expansion_coefficient_minus", RexsUnitId.thermal_expansion_coefficient);

	/** Thermal expansion coefficient (+) (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId thermal_expansion_coefficient_plus = RexsAttributeId.create("thermal_expansion_coefficient_plus", RexsUnitId.thermal_expansion_coefficient);

	/** Tooth thickness modification coefficient (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId thickness_modification_coefficient = RexsAttributeId.create("thickness_modification_coefficient", RexsUnitId.none);

	/** Throat radius (Versions: 1.3) */
	public static final RexsAttributeId throat_radius_worm_wheel = RexsAttributeId.create("throat_radius_worm_wheel", RexsUnitId.mm);

	/** Tilt motion coefficients (Versions: 1.3) */
	public static final RexsAttributeId tilt_motion_coefficients = RexsAttributeId.create("tilt_motion_coefficients", RexsUnitId.none);

	/** Tilting of inner side around u axis (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId tilting_inner_side_u = RexsAttributeId.create("tilting_inner_side_u", RexsUnitId.degree);

	/** Tilting of inner side around v axis (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId tilting_inner_side_v = RexsAttributeId.create("tilting_inner_side_v", RexsUnitId.degree);

	/** Tilting of inner side around w axis (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId tilting_inner_side_w = RexsAttributeId.create("tilting_inner_side_w", RexsUnitId.degree);

	/** Tilting of outer side around u axis (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId tilting_outer_side_u = RexsAttributeId.create("tilting_outer_side_u", RexsUnitId.degree);

	/** Tilting around v axis of outer side (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId tilting_outer_side_v = RexsAttributeId.create("tilting_outer_side_v", RexsUnitId.degree);

	/** Tilting around w axis of outer side (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId tilting_outer_side_w = RexsAttributeId.create("tilting_outer_side_w", RexsUnitId.degree);

	/** Tilting around v axis (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId tilting_v = RexsAttributeId.create("tilting_v", RexsUnitId.degree);

	/** Tilting around w axis (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId tilting_w = RexsAttributeId.create("tilting_w", RexsUnitId.degree);

	/** Tip clearance (Versions: 1.2, 1.3) */
	public static final RexsAttributeId tip_clearance = RexsAttributeId.create("tip_clearance", RexsUnitId.mm);

	/** Tip clearance factor (Versions: 1.2, 1.3) */
	public static final RexsAttributeId tip_clearance_factor = RexsAttributeId.create("tip_clearance_factor", RexsUnitId.none);

	/** Tip circle diameter (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId tip_diameter = RexsAttributeId.create("tip_diameter", RexsUnitId.mm);

	/** Tip diameter  (DIN 3975 2017) (Versions: 1.2) */
	public static final RexsAttributeId tip_diameter_din_3975_2017 = RexsAttributeId.create("tip_diameter_din_3975_2017", RexsUnitId.mm);

	/** Tip diameter (Versions: 1.3) */
	public static final RexsAttributeId tip_diameter_worm_gear = RexsAttributeId.create("tip_diameter_worm_gear", RexsUnitId.mm);

	/** Tip form diameter (Versions: 1.2, 1.3) */
	public static final RexsAttributeId tip_form_diameter = RexsAttributeId.create("tip_form_diameter", RexsUnitId.mm);

	/** Tip radius (Versions: 1.0, 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId tip_radius = RexsAttributeId.create("tip_radius", RexsUnitId.mm);

	/** Tip radius factor (Versions: 1.0, 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId tip_radius_factor = RexsAttributeId.create("tip_radius_factor", RexsUnitId.none);

	/** Tip relief angle (Versions: 1.3) */
	public static final RexsAttributeId tip_relief_angle_bevel_gear_tool = RexsAttributeId.create("tip_relief_angle_bevel_gear_tool", RexsUnitId.degree);

	/** Diameter at start of tip relief (reference diameter) (Versions: 1.2, 1.3) */
	public static final RexsAttributeId tip_relief_datum_diameter = RexsAttributeId.create("tip_relief_datum_diameter", RexsUnitId.mm);

	/** Length of tip relief (Versions: 1.2, 1.3) */
	public static final RexsAttributeId tip_relief_datum_length = RexsAttributeId.create("tip_relief_datum_length", RexsUnitId.mm);

	/** Depth of tip relief (Versions: 1.2, 1.3) */
	public static final RexsAttributeId tip_relief_depth = RexsAttributeId.create("tip_relief_depth", RexsUnitId.mm);

	/** Diameter where tangential transition ends (Versions: 1.2, 1.3) */
	public static final RexsAttributeId tip_relief_diameter_where_tangential_transition_ends = RexsAttributeId.create("tip_relief_diameter_where_tangential_transition_ends", RexsUnitId.mm);

	/** Diameter where tangential transition starts (Versions: 1.2, 1.3) */
	public static final RexsAttributeId tip_relief_diameter_where_tangential_transition_starts = RexsAttributeId.create("tip_relief_diameter_where_tangential_transition_starts", RexsUnitId.mm);

	/** Diameter where amount of modification is specified (Versions: 1.2, 1.3) */
	public static final RexsAttributeId tip_relief_evaluation_reference = RexsAttributeId.create("tip_relief_evaluation_reference", RexsUnitId.mm);

	/** Rolling length where amount of modification is specified (Versions: 1.2, 1.3) */
	public static final RexsAttributeId tip_relief_evaluation_reference_length = RexsAttributeId.create("tip_relief_evaluation_reference_length", RexsUnitId.mm);

	/** Tip relief height (Versions: 1.3) */
	public static final RexsAttributeId tip_relief_height_bevel_gear_tool = RexsAttributeId.create("tip_relief_height_bevel_gear_tool", RexsUnitId.mm);

	/** Length of tangential transition end (Versions: 1.2, 1.3) */
	public static final RexsAttributeId tip_relief_length_of_tangential_transition_end = RexsAttributeId.create("tip_relief_length_of_tangential_transition_end", RexsUnitId.mm);

	/** Length of tangential transition start (Versions: 1.2, 1.3) */
	public static final RexsAttributeId tip_relief_length_of_tangential_transition_start = RexsAttributeId.create("tip_relief_length_of_tangential_transition_start", RexsUnitId.mm);

	/** Tip relief radius (Versions: 1.3) */
	public static final RexsAttributeId tip_relief_radius_bevel_gear_tool = RexsAttributeId.create("tip_relief_radius_bevel_gear_tool", RexsUnitId.mm);

	/** Tolerance class according to ISO 1328 (2013) (Versions: 1.3) */
	public static final RexsAttributeId tolerance_class_according_to_iso_1328_2013 = RexsAttributeId.create("tolerance_class_according_to_iso_1328_2013", RexsUnitId.none);

	/** Tool edge radius (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId tool_edge_radius = RexsAttributeId.create("tool_edge_radius", RexsUnitId.mm);

	/** Tool edge radius (Versions: 1.3) */
	public static final RexsAttributeId tool_edge_radius_bevel_gear_tool = RexsAttributeId.create("tool_edge_radius_bevel_gear_tool", RexsUnitId.mm);

	/** Tool profile position (Versions: 1.3) */
	public static final RexsAttributeId tool_profile_position_bevel_gear_tool = RexsAttributeId.create("tool_profile_position_bevel_gear_tool", RexsUnitId.mm);

	/** Tool tip height (Versions: 1.3) */
	public static final RexsAttributeId tool_tip_height_bevel_gear_tool = RexsAttributeId.create("tool_tip_height_bevel_gear_tool", RexsUnitId.mm);

	/** Tooth addendum (Versions: 1.3) */
	public static final RexsAttributeId tooth_addendum_worm_wheel_hob = RexsAttributeId.create("tooth_addendum_worm_wheel_hob", RexsUnitId.mm);

	/** Tooth depth (Versions: 1.2, 1.3) */
	public static final RexsAttributeId tooth_depth = RexsAttributeId.create("tooth_depth", RexsUnitId.mm);

	/** Tooth depth (Versions: 1.3) */
	public static final RexsAttributeId tooth_depth_worm_wheel_hob = RexsAttributeId.create("tooth_depth_worm_wheel_hob", RexsUnitId.mm);

	/** Tooth temperature (AGMA 925 C95) (Versions: 1.3) */
	public static final RexsAttributeId tooth_temperature_agma_925_a03 = RexsAttributeId.create("tooth_temperature_agma_925_a03", RexsUnitId.degree_celsius);

	/** Tooth temperature of test gears (AGMA 925 C95) (Versions: 1.3) */
	public static final RexsAttributeId tooth_temperature_of_test_gears_agma_925_a03 = RexsAttributeId.create("tooth_temperature_of_test_gears_agma_925_a03", RexsUnitId.degree_celsius);

	/** Tooth thickness (Versions: 1.2, 1.3) */
	public static final RexsAttributeId tooth_thickness = RexsAttributeId.create("tooth_thickness", RexsUnitId.mm);

	/** Transverse tooth thickness (Versions: 1.2, 1.3) */
	public static final RexsAttributeId tooth_thickness_at_pitch_diameter = RexsAttributeId.create("tooth_thickness_at_pitch_diameter", RexsUnitId.mm);

	/** DIN 3967 Deviation-tolerance series (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId tooth_thickness_deviation_tolerance_series_din_3967_1978 = RexsAttributeId.create("tooth_thickness_deviation_tolerance_series_din_3967_1978", RexsUnitId.none);

	/** Tooth thickness loss (DIN 3996 2019) (Versions: 1.2, 1.3) */
	public static final RexsAttributeId tooth_thickness_loss_din_3996_2019 = RexsAttributeId.create("tooth_thickness_loss_din_3996_2019", RexsUnitId.mm);

	/** Tooth tip chamfer (radial amount) (Versions: 1.0, 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId tooth_tip_chamfer = RexsAttributeId.create("tooth_tip_chamfer", RexsUnitId.mm);

	/** Tooth tip thickness (Versions: 1.3) */
	public static final RexsAttributeId tooth_tip_thickness = RexsAttributeId.create("tooth_tip_thickness", RexsUnitId.mm);

	/** Amount of topographical deviation (Versions: 1.2, 1.3) */
	public static final RexsAttributeId topographical_deviation_amounts = RexsAttributeId.create("topographical_deviation_amounts", RexsUnitId.mm);

	/** Amount of topographical modification (Versions: 1.2, 1.3) */
	public static final RexsAttributeId topographical_modification_amounts = RexsAttributeId.create("topographical_modification_amounts", RexsUnitId.mm);

	/** Transmitted torque (with sign) (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId torque = RexsAttributeId.create("torque", RexsUnitId.newton_m);

	/** Torque around u-axis acting on the component on the inner side (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId torque_acting_on_inner_component_u = RexsAttributeId.create("torque_acting_on_inner_component_u", RexsUnitId.newton_m);

	/** Torque around v-axis acting on the component on the inner side (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId torque_acting_on_inner_component_v = RexsAttributeId.create("torque_acting_on_inner_component_v", RexsUnitId.newton_m);

	/** Torque around w-axis acting on the component on the inner side (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId torque_acting_on_inner_component_w = RexsAttributeId.create("torque_acting_on_inner_component_w", RexsUnitId.newton_m);

	/** Torque around u-axis acting on the component on the outer side (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId torque_acting_on_outer_component_u = RexsAttributeId.create("torque_acting_on_outer_component_u", RexsUnitId.newton_m);

	/** Torque around v-axis acting on the component on the outer side (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId torque_acting_on_outer_component_v = RexsAttributeId.create("torque_acting_on_outer_component_v", RexsUnitId.newton_m);

	/** Torque around w-axis acting on the component on the outer side (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId torque_acting_on_outer_component_w = RexsAttributeId.create("torque_acting_on_outer_component_w", RexsUnitId.newton_m);

	/** Torque around v-axis acting on the shaft (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId torque_acting_on_shaft_v = RexsAttributeId.create("torque_acting_on_shaft_v", RexsUnitId.newton_m);

	/** Torque around w-axis acting on the shaft (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId torque_acting_on_shaft_w = RexsAttributeId.create("torque_acting_on_shaft_w", RexsUnitId.newton_m);

	/** Torque around the v-axis (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId torque_around_the_v_axis = RexsAttributeId.create("torque_around_the_v_axis", RexsUnitId.newton_m);

	/** Torque around the w-axis (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId torque_around_the_w_axis = RexsAttributeId.create("torque_around_the_w_axis", RexsUnitId.newton_m);

	/** Torque with sign (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId torque_around_u_axis = RexsAttributeId.create("torque_around_u_axis", RexsUnitId.newton_m);

	/** Torque around the v-axis (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId torque_around_v_axis = RexsAttributeId.create("torque_around_v_axis", RexsUnitId.newton_m);

	/** Torque around the w-axis (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId torque_around_w_axis = RexsAttributeId.create("torque_around_w_axis", RexsUnitId.newton_m);

	/** Torque distribution around the u-axis (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId torque_distribution_u = RexsAttributeId.create("torque_distribution_u", RexsUnitId.newton_m);

	/** Torque distribution around the v-axis (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId torque_distribution_v = RexsAttributeId.create("torque_distribution_v", RexsUnitId.newton_m);

	/** Torque distribution around the w-axis (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId torque_distribution_w = RexsAttributeId.create("torque_distribution_w", RexsUnitId.newton_m);

	/** Maximum torsional torque (Versions: 1.3) */
	public static final RexsAttributeId torsion_torque_maximum_din_743_2012 = RexsAttributeId.create("torsion_torque_maximum_din_743_2012", RexsUnitId.newton_m);

	/** Stress ratio of the torsional torque (Versions: 1.3) */
	public static final RexsAttributeId torsion_torque_stress_ratio_din_743_2012 = RexsAttributeId.create("torsion_torque_stress_ratio_din_743_2012", RexsUnitId.none);

	/** Upper value torsional torque (Versions: 1.3) */
	public static final RexsAttributeId torsion_torque_upper_value_din_743_2012 = RexsAttributeId.create("torsion_torque_upper_value_din_743_2012", RexsUnitId.newton_m);

	/** Torsion around the u-axis (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId torsion_u = RexsAttributeId.create("torsion_u", RexsUnitId.degree);

	/** Torsional yield strength (Versions: 1.3) */
	public static final RexsAttributeId torsional_yield_stress_din_743_2012 = RexsAttributeId.create("torsional_yield_stress_din_743_2012", RexsUnitId.newton_per_mm2);

	/** Total contact ratio (Versions: 1.3) */
	public static final RexsAttributeId total_contact_ratio = RexsAttributeId.create("total_contact_ratio", RexsUnitId.none);

	/** Total frictional power loss (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId total_frictional_power_loss = RexsAttributeId.create("total_frictional_power_loss", RexsUnitId.watt);

	/** Total frictional torque (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId total_frictional_torque = RexsAttributeId.create("total_frictional_torque", RexsUnitId.newton_m);

	/** Tooth force in u-direction (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId total_tooth_force_u_direction = RexsAttributeId.create("total_tooth_force_u_direction", RexsUnitId.kilo_newton);

	/** Tooth force in v-direction (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId total_tooth_force_v_direction = RexsAttributeId.create("total_tooth_force_v_direction", RexsUnitId.kilo_newton);

	/** Tooth force in w-direction (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId total_tooth_force_w_direction = RexsAttributeId.create("total_tooth_force_w_direction", RexsUnitId.kilo_newton);

	/** Load transmits torque (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId transmits_torque = RexsAttributeId.create("transmits_torque", RexsUnitId.none);

	/** Transverse base pitch (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId transverse_base_pitch = RexsAttributeId.create("transverse_base_pitch", RexsUnitId.mm);

	/** Transverse circular pitch on reference circle (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId transverse_circular_pitch_on_reference_circle = RexsAttributeId.create("transverse_circular_pitch_on_reference_circle", RexsUnitId.mm);

	/** Transverse load factor flank (DIN 3990 1987) (Versions: 1.3) */
	public static final RexsAttributeId transverse_load_factor_flank_din_3990_1987 = RexsAttributeId.create("transverse_load_factor_flank_din_3990_1987", RexsUnitId.none);

	/** Transverse load factor (ISO 6336 2006) (Versions: 1.3) */
	public static final RexsAttributeId transverse_load_factor_iso_6336_2006 = RexsAttributeId.create("transverse_load_factor_iso_6336_2006", RexsUnitId.none);

	/** Transverse module (Versions: 1.2, 1.3) */
	public static final RexsAttributeId transverse_module = RexsAttributeId.create("transverse_module", RexsUnitId.mm);

	/** Transverse radius of curvature at the calculation points (AGMA 925 A03) (Versions: 1.3) */
	public static final RexsAttributeId transverse_radius_of_curvature_of_calculation_points_agma_925_a03 = RexsAttributeId.create("transverse_radius_of_curvature_of_calculation_points_agma_925_a03", RexsUnitId.mm);

	/** Transverse relative radius of curvature of calculation points (AGMA 925 A03) (Versions: 1.3) */
	public static final RexsAttributeId transverse_relative_radius_of_curvature_of_calculation_points_agma_925_a03 = RexsAttributeId.create("transverse_relative_radius_of_curvature_of_calculation_points_agma_925_a03", RexsUnitId.mm);

	/** Diameter of begin of triangular root relief (Versions: 1.2, 1.3) */
	public static final RexsAttributeId triangular_root_relief_datum_diameter = RexsAttributeId.create("triangular_root_relief_datum_diameter", RexsUnitId.mm);

	/** Length of triangular root relief (Versions: 1.2, 1.3) */
	public static final RexsAttributeId triangular_root_relief_datum_length = RexsAttributeId.create("triangular_root_relief_datum_length", RexsUnitId.mm);

	/** Depth of triangular root relief (Versions: 1.2, 1.3) */
	public static final RexsAttributeId triangular_root_relief_depth = RexsAttributeId.create("triangular_root_relief_depth", RexsUnitId.mm);

	/** Diameter where tangential transition of triangular root relief ends (Versions: 1.2, 1.3) */
	public static final RexsAttributeId triangular_root_relief_diameter_where_tangential_transition_ends = RexsAttributeId.create("triangular_root_relief_diameter_where_tangential_transition_ends", RexsUnitId.mm);

	/** Diameter where tangential transition of triangular root relief starts (Versions: 1.2, 1.3) */
	public static final RexsAttributeId triangular_root_relief_diameter_where_tangential_transition_starts = RexsAttributeId.create("triangular_root_relief_diameter_where_tangential_transition_starts", RexsUnitId.mm);

	/** Diameter where amount of triangular root relief is specified (Versions: 1.2, 1.3) */
	public static final RexsAttributeId triangular_root_relief_evaluation_reference = RexsAttributeId.create("triangular_root_relief_evaluation_reference", RexsUnitId.mm);

	/** Rolling length where amount of triangular root relief is specified (Versions: 1.2, 1.3) */
	public static final RexsAttributeId triangular_root_relief_evaluation_reference_length = RexsAttributeId.create("triangular_root_relief_evaluation_reference_length", RexsUnitId.mm);

	/** Length of tangential transition of triangular  root relief end (Versions: 1.2, 1.3) */
	public static final RexsAttributeId triangular_root_relief_length_of_tangential_transition_end = RexsAttributeId.create("triangular_root_relief_length_of_tangential_transition_end", RexsUnitId.mm);

	/** Length of tangential transition of triangular root relief start (Versions: 1.2, 1.3) */
	public static final RexsAttributeId triangular_root_relief_length_of_tangential_transition_start = RexsAttributeId.create("triangular_root_relief_length_of_tangential_transition_start", RexsUnitId.mm);

	/** Diameter of begin of triangular tip relief (Versions: 1.2, 1.3) */
	public static final RexsAttributeId triangular_tip_relief_datum_diameter = RexsAttributeId.create("triangular_tip_relief_datum_diameter", RexsUnitId.mm);

	/** Length of triangular tip relief (Versions: 1.2, 1.3) */
	public static final RexsAttributeId triangular_tip_relief_datum_length = RexsAttributeId.create("triangular_tip_relief_datum_length", RexsUnitId.mm);

	/** Depth of triangular tip relief (Versions: 1.2, 1.3) */
	public static final RexsAttributeId triangular_tip_relief_depth = RexsAttributeId.create("triangular_tip_relief_depth", RexsUnitId.mm);

	/** Diameter where tangential transition of triangular tip relief ends (Versions: 1.2, 1.3) */
	public static final RexsAttributeId triangular_tip_relief_diameter_where_tangential_transition_ends = RexsAttributeId.create("triangular_tip_relief_diameter_where_tangential_transition_ends", RexsUnitId.mm);

	/** Diameter where tangential transition of triangular tip relief starts (Versions: 1.2, 1.3) */
	public static final RexsAttributeId triangular_tip_relief_diameter_where_tangential_transition_starts = RexsAttributeId.create("triangular_tip_relief_diameter_where_tangential_transition_starts", RexsUnitId.mm);

	/** Diameter where amount of triangular tip relief is specified (Versions: 1.2, 1.3) */
	public static final RexsAttributeId triangular_tip_relief_evaluation_reference = RexsAttributeId.create("triangular_tip_relief_evaluation_reference", RexsUnitId.mm);

	/** Rolling length where amount of triangular tip relief is specified (Versions: 1.2, 1.3) */
	public static final RexsAttributeId triangular_tip_relief_evaluation_reference_length = RexsAttributeId.create("triangular_tip_relief_evaluation_reference_length", RexsUnitId.mm);

	/** Length of tangential transition of triangular tip relief end (Versions: 1.2, 1.3) */
	public static final RexsAttributeId triangular_tip_relief_length_of_tangential_transition_end = RexsAttributeId.create("triangular_tip_relief_length_of_tangential_transition_end", RexsUnitId.mm);

	/** Length of tangential transition of triangular tip relief start (Versions: 1.2, 1.3) */
	public static final RexsAttributeId triangular_tip_relief_length_of_tangential_transition_start = RexsAttributeId.create("triangular_tip_relief_length_of_tangential_transition_start", RexsUnitId.mm);

	/** Type of gear casing construction (VDI 2736 2014) (Versions: 1.3) */
	public static final RexsAttributeId type_of_gear_casing_construction_vdi_2736_2014 = RexsAttributeId.create("type_of_gear_casing_construction_vdi_2736_2014", RexsUnitId.none);

	/** Type of interpolation (Versions: 1.2, 1.3) */
	public static final RexsAttributeId type_of_interpolation_topographical_modification = RexsAttributeId.create("type_of_interpolation_topographical_modification", RexsUnitId.none);

	/** u-axis vector (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId u_axis_vector = RexsAttributeId.create("u_axis_vector", RexsUnitId.mm);

	/** u-coordinate on shaft (Versions: 1.0, 1.0, 1.0, 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId u_coordinate_on_shaft = RexsAttributeId.create("u_coordinate_on_shaft", RexsUnitId.mm);

	/** Inner side: u-coordinate on shaft (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId u_coordinate_on_shaft_inner_side = RexsAttributeId.create("u_coordinate_on_shaft_inner_side", RexsUnitId.mm);

	/** Outer side: u-coordinate on shaft (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId u_coordinate_on_shaft_outer_side = RexsAttributeId.create("u_coordinate_on_shaft_outer_side", RexsUnitId.mm);

	/** u-coordinate on shaft on side 1 (Versions: 1.0) */
	public static final RexsAttributeId u_coordinate_on_shaft_side_1 = RexsAttributeId.create("u_coordinate_on_shaft_side_1", RexsUnitId.mm);

	/** u-coordinate on shaft on side 2 (Versions: 1.0) */
	public static final RexsAttributeId u_coordinate_on_shaft_side_2 = RexsAttributeId.create("u_coordinate_on_shaft_side_2", RexsUnitId.mm);

	/** U coordinates of beam nodes (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId u_coordinates_of_beam_nodes = RexsAttributeId.create("u_coordinates_of_beam_nodes", RexsUnitId.mm);

	/** Axial undercut width (Versions: 1.3) */
	public static final RexsAttributeId undercut_width_axial = RexsAttributeId.create("undercut_width_axial", RexsUnitId.mm);

	/** Radial undercut width (Versions: 1.3) */
	public static final RexsAttributeId undercut_width_radial = RexsAttributeId.create("undercut_width_radial", RexsUnitId.mm);

	/** Upper diametric deviation (Versions: 1.2, 1.3) */
	public static final RexsAttributeId upper_backlash_allowance_balls_or_pins = RexsAttributeId.create("upper_backlash_allowance_balls_or_pins", RexsUnitId.mm);

	/** Upper base tangent length deviation (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId upper_backlash_allowance_referenced_to_span = RexsAttributeId.create("upper_backlash_allowance_referenced_to_span", RexsUnitId.mum);

	/** Upper centre distance allowance (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId upper_center_distance_allowance = RexsAttributeId.create("upper_center_distance_allowance", RexsUnitId.mum);

	/** Usable addendum circle diameter (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId usable_addendum_circle_diameter = RexsAttributeId.create("usable_addendum_circle_diameter", RexsUnitId.mm);

	/** Usable root circle diameter (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId usable_root_circle_diameter = RexsAttributeId.create("usable_root_circle_diameter", RexsUnitId.mm);

	/** Utilized dedenudum coefficient reference profile (Versions: 1.0, 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId utilized_dedendum_coefficient_reference_profile = RexsAttributeId.create("utilized_dedendum_coefficient_reference_profile", RexsUnitId.none);

	/** Utilized dedendum reference profile (Versions: 1.0, 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId utilized_dedendum_reference_profile = RexsAttributeId.create("utilized_dedendum_reference_profile", RexsUnitId.mm);

	/** Velocity factor (pitting) (Versions: 1.3) */
	public static final RexsAttributeId velocity_factor_pitting_din_3996_2019 = RexsAttributeId.create("velocity_factor_pitting_din_3996_2019", RexsUnitId.none);

	/** Vertical motion coefficients (Versions: 1.3) */
	public static final RexsAttributeId vertical_motion_coefficients = RexsAttributeId.create("vertical_motion_coefficients", RexsUnitId.none);

	/** Virtual number of teeth (Versions: 1.2, 1.3) */
	public static final RexsAttributeId virtual_number_of_teeth = RexsAttributeId.create("virtual_number_of_teeth", RexsUnitId.none);

	/** Viscosity at 100&deg;C (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId viscosity_at_100_degree_celsius = RexsAttributeId.create("viscosity_at_100_degree_celsius", RexsUnitId.mm2_per_s);

	/** Viscosity at 40&deg;C (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId viscosity_at_40_degree_celsius = RexsAttributeId.create("viscosity_at_40_degree_celsius", RexsUnitId.mm2_per_s);

	/** Viscosity ratio according to ISO 281 2007 (Versions: 1.1, 1.2, 1.3) */
	public static final RexsAttributeId viscosity_ratio_according_to_iso_281_2007 = RexsAttributeId.create("viscosity_ratio_according_to_iso_281_2007", RexsUnitId.none);

	/** Viscosity rating DIN 26281 (Versions: 1.0) */
	public static final RexsAttributeId viscosity_ratio_din_26281 = RexsAttributeId.create("viscosity_ratio_din_26281", RexsUnitId.none);

	/** w-axis vector (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId w_axis_vector = RexsAttributeId.create("w_axis_vector", RexsUnitId.mm);

	/** Wear coefficient (VDI 2736 2014) (Versions: 1.3) */
	public static final RexsAttributeId wear_coefficient_vdi_2736_2014 = RexsAttributeId.create("wear_coefficient_vdi_2736_2014", RexsUnitId.wear_coefficient_vdi2736);

	/** Wear erosion (Plewe 1980) (Versions: 1.3) */
	public static final RexsAttributeId wear_erosion_plewe_1980 = RexsAttributeId.create("wear_erosion_plewe_1980", RexsUnitId.mm_per_h);

	/** Wear intensity (Versions: 1.3) */
	public static final RexsAttributeId wear_intensity_din_3996_2019 = RexsAttributeId.create("wear_intensity_din_3996_2019", RexsUnitId.none);

	/** Wear life (Plewe 1980) (Versions: 1.3) */
	public static final RexsAttributeId wear_life_time_plewe_1980 = RexsAttributeId.create("wear_life_time_plewe_1980", RexsUnitId.hour);

	/** Wear mass (Plewe 1980) (Versions: 1.3) */
	public static final RexsAttributeId wear_mass_plewe_1980 = RexsAttributeId.create("wear_mass_plewe_1980", RexsUnitId.mg);

	/** Wear safety factor (backlash &gt; 0,3 module) (Versions: 1.3) */
	public static final RexsAttributeId wear_safety_factor_backlash_din_3996_2019 = RexsAttributeId.create("wear_safety_factor_backlash_din_3996_2019", RexsUnitId.none);

	/** Wear safety factor (pointed tooth) (Versions: 1.3) */
	public static final RexsAttributeId wear_safety_factor_pointed_tooth_din_3996_2019 = RexsAttributeId.create("wear_safety_factor_pointed_tooth_din_3996_2019", RexsUnitId.none);

	/** Weibull exponent (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId weibull_exponent = RexsAttributeId.create("weibull_exponent", RexsUnitId.none);

	/** Welding factor (AGMA 925 C95) (Versions: 1.3) */
	public static final RexsAttributeId welding_factor_agma_925_a03 = RexsAttributeId.create("welding_factor_agma_925_a03", RexsUnitId.none);

	/** Wheel bulk temperature (Versions: 1.3) */
	public static final RexsAttributeId wheel_bulk_temperature_din_3996_2019 = RexsAttributeId.create("wheel_bulk_temperature_din_3996_2019", RexsUnitId.degree_celsius);

	/** Bearing width (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId width = RexsAttributeId.create("width", RexsUnitId.mm);

	/** Width of line load (Versions: 1.3) */
	public static final RexsAttributeId width_of_external_load = RexsAttributeId.create("width_of_external_load", RexsUnitId.mm);

	/** Offset of width (Versions: 1.3) */
	public static final RexsAttributeId width_offset = RexsAttributeId.create("width_offset", RexsUnitId.mm);

	/** Width to pitch diameter ratio (Versions: 1.3) */
	public static final RexsAttributeId width_to_diameter_ratio = RexsAttributeId.create("width_to_diameter_ratio", RexsUnitId.none);

	/** Width to normal module ratio (Versions: 1.3) */
	public static final RexsAttributeId width_to_normal_module_ratio = RexsAttributeId.create("width_to_normal_module_ratio", RexsUnitId.none);

	/** Work offset (Versions: 1.3) */
	public static final RexsAttributeId work_offset = RexsAttributeId.create("work_offset", RexsUnitId.mm);

	/** Working depth (Versions: 1.2, 1.3) */
	public static final RexsAttributeId working_depth = RexsAttributeId.create("working_depth", RexsUnitId.mm);

	/** Working depth factor (Versions: 1.2, 1.3) */
	public static final RexsAttributeId working_depth_coefficient = RexsAttributeId.create("working_depth_coefficient", RexsUnitId.none);

	/** Material depth of maximum hardness (ISO 6336 2019) (Versions: 1.3) */
	public static final RexsAttributeId y_coordinate_of_maximum_hardness_iso_6336_2019 = RexsAttributeId.create("y_coordinate_of_maximum_hardness_iso_6336_2019", RexsUnitId.mm);

	/** Yield strength (Versions: 1.0, 1.1, 1.2, 1.3) */
	public static final RexsAttributeId yield_strength = RexsAttributeId.create("yield_strength", RexsUnitId.newton_per_mm2);

	/** Yield strength at operating temperature (VDI 2736 2014) (Versions: 1.3) */
	public static final RexsAttributeId yield_strength_at_operating_temperature_vdi_2736_2014 = RexsAttributeId.create("yield_strength_at_operating_temperature_vdi_2736_2014", RexsUnitId.newton_per_mm2);

	/** Zone factor (VDI 2736 2014) (Versions: 1.3) */
	public static final RexsAttributeId zone_factor_vdi_2736_2014 = RexsAttributeId.create("zone_factor_vdi_2736_2014", RexsUnitId.none);

	public static void init() {}
}
