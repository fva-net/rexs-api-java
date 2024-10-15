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

import info.rexs.schema.constants.RexsAttributeId;

/**
 * This class represents the ID of a REXS attribute.
 * <p>
 * It contains constants for all attribute IDs of official REXS versions (1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6).
 *
 * @author FVA GmbH
 */
@Generated("REXS-Database by FVA GmbH (see https://database.rexs.info/)")
public interface RexsStandardAttributeIds {

	/** Acceleration factor according to FVA 341 (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId acceleration_factor_according_fva_341 = RexsAttributeId.create("acceleration_factor_according_fva_341", RexsStandardUnitIds.none);

	/** Account for gravity (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId account_for_gravity = RexsAttributeId.create("account_for_gravity", RexsStandardUnitIds.none);

	/** Account for shear deformation (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId account_for_shear_deformation = RexsAttributeId.create("account_for_shear_deformation", RexsStandardUnitIds.none);

	/** Actual tangential load (AGMA 925 A03) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId actual_tangential_load_agma_925_a03 = RexsAttributeId.create("actual_tangential_load_agma_925_a03", RexsStandardUnitIds.newton);

	/** Tooth tip height (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId addendum_basic_profile = RexsAttributeId.create("addendum_basic_profile", RexsStandardUnitIds.mm);

	/** Addendum coefficient of basic profile (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId addendum_coefficient_basic_profile = RexsAttributeId.create("addendum_coefficient_basic_profile", RexsStandardUnitIds.none);

	/** Addendum coefficient tool reference profile relative to module (Versions: 1.0, 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId addendum_coefficient_reference_profile = RexsAttributeId.create("addendum_coefficient_reference_profile", RexsStandardUnitIds.none);

	/** Addendum modification (profile shift) (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId addendum_modification = RexsAttributeId.create("addendum_modification", RexsStandardUnitIds.mm);

	/** Addendum modification coefficient (profile shift coefficient) (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId addendum_modification_coefficient = RexsAttributeId.create("addendum_modification_coefficient", RexsStandardUnitIds.none);

	/** Addendum modification coefficient (profile shift coefficient) finished gear (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId addendum_modification_coefficient_after_finishing = RexsAttributeId.create("addendum_modification_coefficient_after_finishing", RexsStandardUnitIds.none);

	/** Addendum modification coefficient worm wheel (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId addendum_modification_coefficient_worm_wheel = RexsAttributeId.create("addendum_modification_coefficient_worm_wheel", RexsStandardUnitIds.none);

	/** Addendum reference profile of tool (Versions: 1.0, 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId addendum_reference_profile = RexsAttributeId.create("addendum_reference_profile", RexsStandardUnitIds.mm);

	/** All bearing elements are identical (Versions: 1.0) */
	RexsAttributeId all_rolling_elements_are_identical = RexsAttributeId.create("all_rolling_elements_are_identical", RexsStandardUnitIds.none);

	/** All bearing rows are identical (Versions: 1.0) */
	RexsAttributeId all_rows_are_identical = RexsAttributeId.create("all_rows_are_identical", RexsStandardUnitIds.none);

	/** Allowable stress number bending (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId allowable_stress_number_bending_iso_10300_2014 = RexsAttributeId.create("allowable_stress_number_bending_iso_10300_2014", RexsStandardUnitIds.newton_per_mm2);

	/** Allowable stress number for contact stress (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId allowable_stress_number_for_contact_stress_iso_10300_2014 = RexsAttributeId.create("allowable_stress_number_for_contact_stress_iso_10300_2014", RexsStandardUnitIds.newton_per_mm2);

	/** Alternating bending strength (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId alternating_bending_strength_din_743_2012 = RexsAttributeId.create("alternating_bending_strength_din_743_2012", RexsStandardUnitIds.newton_per_mm2);

	/** Alternating tension/ compression strength (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId alternating_tensile_strength_din_743_2012 = RexsAttributeId.create("alternating_tensile_strength_din_743_2012", RexsStandardUnitIds.newton_per_mm2);

	/** Alternating torsional strength (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId alternating_torsion_strength_din_743_2012 = RexsAttributeId.create("alternating_torsion_strength_din_743_2012", RexsStandardUnitIds.newton_per_mm2);

	/** Ambient pressure (Versions: 1.6) */
	RexsAttributeId ambient_pressure_plain_bearing = RexsAttributeId.create("ambient_pressure_plain_bearing", RexsStandardUnitIds.newton_per_mm2);

	/** Axial journal ambient temperature (front) (Versions: 1.6) */
	RexsAttributeId ambient_temperature_journal_front_plain_bearing = RexsAttributeId.create("ambient_temperature_journal_front_plain_bearing", RexsStandardUnitIds.degree_celsius);

	/** Axial journal ambient temperature (rear) (Versions: 1.6) */
	RexsAttributeId ambient_temperature_journal_rear_plain_bearing = RexsAttributeId.create("ambient_temperature_journal_rear_plain_bearing", RexsStandardUnitIds.degree_celsius);

	/** Axial bearing shell ambient temperature (front) (Versions: 1.6) */
	RexsAttributeId ambient_temperature_shell_front_plain_bearing = RexsAttributeId.create("ambient_temperature_shell_front_plain_bearing", RexsStandardUnitIds.degree_celsius);

	/** Radial bearing shell ambient temperature (Versions: 1.6) */
	RexsAttributeId ambient_temperature_shell_radial_plain_bearing = RexsAttributeId.create("ambient_temperature_shell_radial_plain_bearing", RexsStandardUnitIds.degree_celsius);

	/** Axial bearing shell ambient temperature (rear) (Versions: 1.6) */
	RexsAttributeId ambient_temperature_shell_rear_plain_bearing = RexsAttributeId.create("ambient_temperature_shell_rear_plain_bearing", RexsStandardUnitIds.degree_celsius);

	/** Ambient temperature (VDI 2736 2014) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId ambient_temperature_vdi_2736_2014 = RexsAttributeId.create("ambient_temperature_vdi_2736_2014", RexsStandardUnitIds.degree_celsius);

	/** Angle of blade sequence (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId angle_of_blade_sequence = RexsAttributeId.create("angle_of_blade_sequence", RexsStandardUnitIds.deg);

	/** Relative tilting of the inner ring around the v-axis compared to the outer ring. (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId angular_deflection_in_v = RexsAttributeId.create("angular_deflection_in_v", RexsStandardUnitIds.radian);

	/** Relative tilting of the inner ring around the w-axis compared to the outer ring. (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId angular_deflection_in_w = RexsAttributeId.create("angular_deflection_in_w", RexsStandardUnitIds.radian);

	/** Angular offset of the mounting position of the outer ring around the v-axis (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId angular_misalignment_around_v_axis = RexsAttributeId.create("angular_misalignment_around_v_axis", RexsStandardUnitIds.deg);

	/** Angular offset of the mounting position of the outer ring around the w-axis (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId angular_misalignment_around_w_axis = RexsAttributeId.create("angular_misalignment_around_w_axis", RexsStandardUnitIds.deg);

	/** Angular motion coefficients (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId angular_motion_coefficients = RexsAttributeId.create("angular_motion_coefficients", RexsStandardUnitIds.none);

	/** Angular position around u axis (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId angular_position_around_u = RexsAttributeId.create("angular_position_around_u", RexsStandardUnitIds.deg);

	/** Angular position of the center of curvature of the circular profile (Versions: 1.6) */
	RexsAttributeId angular_position_center_of_curvatue = RexsAttributeId.create("angular_position_center_of_curvatue", RexsStandardUnitIds.deg);

	/** Angular velocity (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId angular_velocity = RexsAttributeId.create("angular_velocity", RexsStandardUnitIds.radian_per_s);

	/** Application factor (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId application_factor_din_3996_2019 = RexsAttributeId.create("application_factor_din_3996_2019", RexsStandardUnitIds.none);

	/** Application factor (DIN 6892 2012) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId application_factor_din_6892_2012 = RexsAttributeId.create("application_factor_din_6892_2012", RexsStandardUnitIds.none);

	/** Application factor for fatigue load (VDI 2736 2014) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId application_factor_for_fatigue_load_vdi_2736_2014 = RexsAttributeId.create("application_factor_for_fatigue_load_vdi_2736_2014", RexsStandardUnitIds.none);

	/** application factor  (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId application_factor_iso_10300_2014 = RexsAttributeId.create("application_factor_iso_10300_2014", RexsStandardUnitIds.none);

	/** Application factor (ISO 6336 2006) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId application_factor_iso_6336_2006 = RexsAttributeId.create("application_factor_iso_6336_2006", RexsStandardUnitIds.none);

	/** Estimated strength value design calculation VDI 2736 2014 (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId approximate_strength_value_vdi_2736_2014 = RexsAttributeId.create("approximate_strength_value_vdi_2736_2014", RexsStandardUnitIds.newton_per_mm2);

	/** Approximated standard deviation of scuffing temperature (AGMA 925 A03) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId approximated_standard_deviation_of_scuffing_temperature_agma_925_a03 = RexsAttributeId.create("approximated_standard_deviation_of_scuffing_temperature_agma_925_a03", RexsStandardUnitIds.degree_celsius);

	/** Average surface roughness for filter cutoff length (AGMA 925 C95) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId arithmentic_mean_roughness_at_filter_cutoff_of_wavelength_agma_925_a03 = RexsAttributeId.create("arithmentic_mean_roughness_at_filter_cutoff_of_wavelength_agma_925_a03", RexsStandardUnitIds.mum);

	/** Arithmetic average of R_q1x (Pinion) and R_q2x (Gear) at filter cutoff of wavelength (AGMA 925 A03) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId arithmetic_average_of_root_mean_square_roughness_of_pinion_and_gear_agma_925_a03 = RexsAttributeId.create("arithmetic_average_of_root_mean_square_roughness_of_pinion_and_gear_agma_925_a03", RexsStandardUnitIds.mum);

	/** Arithmetic average roughness flank (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId arithmetic_average_roughness_flank = RexsAttributeId.create("arithmetic_average_roughness_flank", RexsStandardUnitIds.mum);

	/** Arithmetic average roughness root (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId arithmetic_average_roughness_root = RexsAttributeId.create("arithmetic_average_roughness_root", RexsStandardUnitIds.mum);

	/** Averaged linear wear  (VDI 2736 2014) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId averaged_linear_wear_vdi_2736_2014 = RexsAttributeId.create("averaged_linear_wear_vdi_2736_2014", RexsStandardUnitIds.mm);

	/** Averaged peak-to-valley height flank (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId averaged_peak_to_valley_height_flank = RexsAttributeId.create("averaged_peak_to_valley_height_flank", RexsStandardUnitIds.mum);

	/** Averaged peak-to-valley height root (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId averaged_peak_to_valley_height_root = RexsAttributeId.create("averaged_peak_to_valley_height_root", RexsStandardUnitIds.mum);

	/** Axial backlash (Versions: 1.0) */
	RexsAttributeId axial_backlash = RexsAttributeId.create("axial_backlash", RexsStandardUnitIds.mum);

	/** Axial increase of backlash (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId axial_backlash_increase = RexsAttributeId.create("axial_backlash_increase", RexsStandardUnitIds.mm);

	/** Axial bearing clearance (before mounting) (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId axial_bearing_clearance = RexsAttributeId.create("axial_bearing_clearance", RexsStandardUnitIds.mum);

	/** Axial clearance (Versions: 1.5, 1.6) */
	RexsAttributeId axial_clearance = RexsAttributeId.create("axial_clearance", RexsStandardUnitIds.mum);

	/** Axial bearing clearance class (before mounting) (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId axial_clearance_class = RexsAttributeId.create("axial_clearance_class", RexsStandardUnitIds.none);

	/** Relative displacement of the inner ring in the u-direction compared to the outer ring (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId axial_deflection = RexsAttributeId.create("axial_deflection", RexsStandardUnitIds.mum);

	/** Axial displacement of gear (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId axial_displacement_gear = RexsAttributeId.create("axial_displacement_gear", RexsStandardUnitIds.mm);

	/** Axial displacement of pinion (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId axial_displacement_pinion = RexsAttributeId.create("axial_displacement_pinion", RexsStandardUnitIds.mm);

	/** Axial distance between load input and output point (DIN 6892 2012) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId axial_distance_between_load_input_and_output_din_6892_2012 = RexsAttributeId.create("axial_distance_between_load_input_and_output_din_6892_2012", RexsStandardUnitIds.mm);

	/** Axial dynamic load rating (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId axial_dynamic_load_rating = RexsAttributeId.create("axial_dynamic_load_rating", RexsStandardUnitIds.kilo_newton);

	/** Axial factor (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId axial_factor_y_0 = RexsAttributeId.create("axial_factor_y_0", RexsStandardUnitIds.none);

	/** Axial load factor Y1 for F_a/F_r &lt;= e (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId axial_factor_y_1 = RexsAttributeId.create("axial_factor_y_1", RexsStandardUnitIds.none);

	/** Axial load factor Y2 for F_a/F_r &gt; e (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId axial_factor_y_2 = RexsAttributeId.create("axial_factor_y_2", RexsStandardUnitIds.none);

	/** Axial force in u-direction (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId axial_force = RexsAttributeId.create("axial_force", RexsStandardUnitIds.kilo_newton);

	/** Support of axial loads (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId axial_force_absorption = RexsAttributeId.create("axial_force_absorption", RexsStandardUnitIds.none);

	/** Support of axial loads (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId axial_force_absorption_of_row = RexsAttributeId.create("axial_force_absorption_of_row", RexsStandardUnitIds.none);

	/** Maximum axial force (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId axial_force_maximum_din_743_2012 = RexsAttributeId.create("axial_force_maximum_din_743_2012", RexsStandardUnitIds.newton);

	/** Stress ratio of the axial force (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId axial_force_stress_ratio_din_743_2012 = RexsAttributeId.create("axial_force_stress_ratio_din_743_2012", RexsStandardUnitIds.none);

	/** Upper value of axial force (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId axial_force_upper_value_din_743_2012 = RexsAttributeId.create("axial_force_upper_value_din_743_2012", RexsStandardUnitIds.newton);

	/** Axial machining allowance (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId axial_maching_allowance_din_509_2006 = RexsAttributeId.create("axial_maching_allowance_din_509_2006", RexsStandardUnitIds.mm);

	/** Axial module (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId axial_module = RexsAttributeId.create("axial_module", RexsStandardUnitIds.mm);

	/** Axial module (DIN 3975 2017) (Versions: 1.2) */
	RexsAttributeId axial_module_din_3975_2017 = RexsAttributeId.create("axial_module_din_3975_2017", RexsStandardUnitIds.mm);

	/** Axial pitch (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId axial_pitch = RexsAttributeId.create("axial_pitch", RexsStandardUnitIds.mm);

	/** Axial pitch (DIN 3975 2017) (Versions: 1.2) */
	RexsAttributeId axial_pitch_din_3975_2017 = RexsAttributeId.create("axial_pitch_din_3975_2017", RexsStandardUnitIds.mm);

	/** Axial position of the center of the plain bearing feature (Versions: 1.6) */
	RexsAttributeId axial_position_of_plain_bearing_feature = RexsAttributeId.create("axial_position_of_plain_bearing_feature", RexsStandardUnitIds.mm);

	/** Axial static load rating (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId axial_static_load_rating = RexsAttributeId.create("axial_static_load_rating", RexsStandardUnitIds.kilo_newton);

	/** Axial stiffness (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId axial_stiffness = RexsAttributeId.create("axial_stiffness", RexsStandardUnitIds.newton_per_m);

	/** Base circle diameter (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId base_circle_diameter = RexsAttributeId.create("base_circle_diameter", RexsStandardUnitIds.mm);

	/** Base circle diameter (DIN 3975 2017) (Versions: 1.2) */
	RexsAttributeId base_circle_diameter_din_3975_2017 = RexsAttributeId.create("base_circle_diameter_din_3975_2017", RexsStandardUnitIds.mm);

	/** Base diameter of virtual cylindrical gear in normal section (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId base_diameter_normal_section_virtual_cylindrical_gear_iso_10300_2014 = RexsAttributeId.create("base_diameter_normal_section_virtual_cylindrical_gear_iso_10300_2014", RexsStandardUnitIds.mm);

	/** Base diameter of virtual cylindrical gear (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId base_diameter_virtual_cylindrical_gear_iso_10300_2014 = RexsAttributeId.create("base_diameter_virtual_cylindrical_gear_iso_10300_2014", RexsStandardUnitIds.mm);

	/** Basic factor according to FVA 341 (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId base_factor_according_fva_341 = RexsAttributeId.create("base_factor_according_fva_341", RexsStandardUnitIds.none);

	/** Basic crown gear addendum factor (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId basic_addendum_coefficient = RexsAttributeId.create("basic_addendum_coefficient", RexsStandardUnitIds.none);

	/** Basic crown gear dedendum factor (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId basic_dedendum_coefficient = RexsAttributeId.create("basic_dedendum_coefficient", RexsStandardUnitIds.none);

	/** Basic strength root (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId basic_strength_root = RexsAttributeId.create("basic_strength_root", RexsStandardUnitIds.newton_per_mm2);

	/** Basis of lubricant (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId basis = RexsAttributeId.create("basis", RexsStandardUnitIds.none);

	/** Bearing ring type (Versions: 1.6) */
	RexsAttributeId bearing_ring_type = RexsAttributeId.create("bearing_ring_type", RexsStandardUnitIds.none);

	/** Bearing tolerance class (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId bearing_tolerance_class = RexsAttributeId.create("bearing_tolerance_class", RexsStandardUnitIds.none);

	/** Bearing type (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId bearing_type = RexsAttributeId.create("bearing_type", RexsStandardUnitIds.none);

	/** Beginning of feather key supporting length (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId beginning_of_feather_key_supporting_length = RexsAttributeId.create("beginning_of_feather_key_supporting_length", RexsStandardUnitIds.mm);

	/** Tilting stiffness (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId bending_stiffness = RexsAttributeId.create("bending_stiffness", RexsStandardUnitIds.newton_mm_per_rad);

	/** Bending strength geometry factor (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId bending_strength_geometry_factor_iso_10300_2014 = RexsAttributeId.create("bending_strength_geometry_factor_iso_10300_2014", RexsStandardUnitIds.none);

	/** Maximum bending torque (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId bending_torque_maximum_din_743_2012 = RexsAttributeId.create("bending_torque_maximum_din_743_2012", RexsStandardUnitIds.newton_m);

	/** Stress ratio R of the bending moment (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId bending_torque_stress_ratio_din_743_2012 = RexsAttributeId.create("bending_torque_stress_ratio_din_743_2012", RexsStandardUnitIds.none);

	/** Alternating load bending moment, upper value (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId bending_torque_upper_value_din_743_2012 = RexsAttributeId.create("bending_torque_upper_value_din_743_2012", RexsStandardUnitIds.newton_m);

	/** Bending yield strength (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId bending_yield_stress_din_743_2012 = RexsAttributeId.create("bending_yield_stress_din_743_2012", RexsStandardUnitIds.newton_per_mm2);

	/** Bevel orientation (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId bevel_cone_orientation = RexsAttributeId.create("bevel_cone_orientation", RexsStandardUnitIds.none);

	/** Bevel gear factor (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId bevel_gear_factor_pitting_iso_10300_2014 = RexsAttributeId.create("bevel_gear_factor_pitting_iso_10300_2014", RexsStandardUnitIds.none);

	/** Bevel spiral angle factor (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId bevel_spiral_angle_factor_tooth_root_iso_10300_2014 = RexsAttributeId.create("bevel_spiral_angle_factor_tooth_root_iso_10300_2014", RexsStandardUnitIds.none);

	/** Blade dedenum (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId blade_dedendum = RexsAttributeId.create("blade_dedendum", RexsStandardUnitIds.mm);

	/** Blade point radius (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId blade_point_radius = RexsAttributeId.create("blade_point_radius", RexsStandardUnitIds.mm);

	/** Blade pressure angle (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId blade_pressure_angle = RexsAttributeId.create("blade_pressure_angle", RexsStandardUnitIds.deg);

	/** Blade profile height (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId blade_profile_height = RexsAttributeId.create("blade_profile_height", RexsStandardUnitIds.mm);

	/** Blade spheric radius (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId blade_spheric_radius = RexsAttributeId.create("blade_spheric_radius", RexsStandardUnitIds.mm);

	/** Contour coordinates u (Versions: 1.6) */
	RexsAttributeId body_contour_coordinate_u = RexsAttributeId.create("body_contour_coordinate_u", RexsStandardUnitIds.mm);

	/** Contour coordinates v (Versions: 1.6) */
	RexsAttributeId body_contour_coordinate_v = RexsAttributeId.create("body_contour_coordinate_v", RexsStandardUnitIds.mm);

	/** Contour radius (Versions: 1.6) */
	RexsAttributeId body_contour_element_radius = RexsAttributeId.create("body_contour_element_radius", RexsStandardUnitIds.mm);

	/** Contour element type (Versions: 1.6) */
	RexsAttributeId body_contour_element_type = RexsAttributeId.create("body_contour_element_type", RexsStandardUnitIds.none);

	/** Surface roughness of casing bore (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId bore_surface_roughness = RexsAttributeId.create("bore_surface_roughness", RexsStandardUnitIds.mum);

	/** Tolerance class of bore in bearing seat (Versions: 1.0) */
	RexsAttributeId boring_tolerance_class = RexsAttributeId.create("boring_tolerance_class", RexsStandardUnitIds.none);

	/** Bottom clearance factor (Versions: 1.0, 1.1) */
	RexsAttributeId bottom_clearance_factor = RexsAttributeId.create("bottom_clearance_factor", RexsStandardUnitIds.none);

	/** Bulk temperature (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId bulk_temperature = RexsAttributeId.create("bulk_temperature", RexsStandardUnitIds.degree_celsius);

	/** Bulk temperature (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId bulk_temperature_iso_10300_2021 = RexsAttributeId.create("bulk_temperature_iso_10300_2021", RexsStandardUnitIds.degree_celsius);

	/** Calculation method (DIN 6892 2012) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId calculation_method_din_6892_2012 = RexsAttributeId.create("calculation_method_din_6892_2012", RexsStandardUnitIds.none);

	/** Tolerance class of casing bore (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId casing_bore_tolerance_class = RexsAttributeId.create("casing_bore_tolerance_class", RexsStandardUnitIds.none);

	/** Outer diameter of casing for the operating clearance calculation (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId casing_outer_diameter = RexsAttributeId.create("casing_outer_diameter", RexsStandardUnitIds.mm);

	/** Catalogue designation (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId catalogue_designation = RexsAttributeId.create("catalogue_designation", RexsStandardUnitIds.none);

	/** Catalogue value e (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId catalogue_value_e = RexsAttributeId.create("catalogue_value_e", RexsStandardUnitIds.none);

	/** Center distance (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId center_distance = RexsAttributeId.create("center_distance", RexsStandardUnitIds.mm);

	/** Center distance correction (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId center_distance_correction = RexsAttributeId.create("center_distance_correction", RexsStandardUnitIds.mm);

	/** Offset of center distance (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId center_distance_offset = RexsAttributeId.create("center_distance_offset", RexsStandardUnitIds.mm);

	/** Din 3964 center distance tolerance field (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId center_distance_tolerance_field_din_3964_1980 = RexsAttributeId.create("center_distance_tolerance_field_din_3964_1980", RexsStandardUnitIds.none);

	/** Center roll position (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId center_roll_position = RexsAttributeId.create("center_roll_position", RexsStandardUnitIds.deg);

	/** Central film thickness at the calculation points (AGMA 925 A03) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId central_film_thickness_at_calculation_points_agma_925_a03 = RexsAttributeId.create("central_film_thickness_at_calculation_points_agma_925_a03", RexsStandardUnitIds.mum);

	/** Centre distance of virtual cylindrical gear pair (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId centre_distance_virtual_cylindrical_gear_iso_10300_2014 = RexsAttributeId.create("centre_distance_virtual_cylindrical_gear_iso_10300_2014", RexsStandardUnitIds.mm);

	/** Chamfer angle (Versions: 1.0, 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId chamfer_angle = RexsAttributeId.create("chamfer_angle", RexsStandardUnitIds.deg);

	/** Chamfer ange (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId chamfer_angle_worm_wheel = RexsAttributeId.create("chamfer_angle_worm_wheel", RexsStandardUnitIds.deg);

	/** Chamfer at end of tooth (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId chamfer_at_tooth_end = RexsAttributeId.create("chamfer_at_tooth_end", RexsStandardUnitIds.mm);

	/** Chamfer distance (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId chamfer_distance_worm_wheel = RexsAttributeId.create("chamfer_distance_worm_wheel", RexsStandardUnitIds.mm);

	/** Cordal height (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId chordal_height = RexsAttributeId.create("chordal_height", RexsStandardUnitIds.mm);

	/** Chordal tooth thickness between B and D (ISO 6336 2019) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId chordal_tooth_thickness_between_point_b_and_d_iso_6336_2019 = RexsAttributeId.create("chordal_tooth_thickness_between_point_b_and_d_iso_6336_2019", RexsStandardUnitIds.mm);

	/** Chordal tooth thickness lower deviation (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId chordal_tooth_thickness_lower_deviation = RexsAttributeId.create("chordal_tooth_thickness_lower_deviation", RexsStandardUnitIds.mm);

	/** Chordal tooth thickness upper deviation (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId chordal_tooth_thickness_upper_deviation = RexsAttributeId.create("chordal_tooth_thickness_upper_deviation", RexsStandardUnitIds.mm);

	/** Chordal transverse tooth thickness lower deviation (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId chordal_transverse_tooth_thickness_lower_deviation = RexsAttributeId.create("chordal_transverse_tooth_thickness_lower_deviation", RexsStandardUnitIds.mm);

	/** Chordal transverse tooth thickness upper  deviation (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId chordal_transverse_tooth_thickness_upper_deviation = RexsAttributeId.create("chordal_transverse_tooth_thickness_upper_deviation", RexsStandardUnitIds.mm);

	/** Bearing clearance class (Versions: 1.0) */
	RexsAttributeId clearance_class = RexsAttributeId.create("clearance_class", RexsStandardUnitIds.none);

	/** Longitudinal coefficient of friction during joining (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId coefficient_adhesion_during_joining_longitudinal_direction = RexsAttributeId.create("coefficient_adhesion_during_joining_longitudinal_direction", RexsStandardUnitIds.none);

	/** Coefficient of adhesion with slipping force in circumferential direction (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId coefficient_adhesion_slipping_force_circumferential_direction = RexsAttributeId.create("coefficient_adhesion_slipping_force_circumferential_direction", RexsStandardUnitIds.none);

	/** Coefficient of adhesion for slipping force in longitudinal direction (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId coefficient_adhesion_slipping_force_longitudinal_direction = RexsAttributeId.create("coefficient_adhesion_slipping_force_longitudinal_direction", RexsStandardUnitIds.none);

	/** Coefficient of friction &micro; determined according to VDI 2736 2014 (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId coefficient_of_friction_is_determined_according_to_vdi_2736_2014 = RexsAttributeId.create("coefficient_of_friction_is_determined_according_to_vdi_2736_2014", RexsStandardUnitIds.none);

	/** Coefficient of friction (VDI 2736 2014) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId coefficient_of_friction_vdi_2736_2014 = RexsAttributeId.create("coefficient_of_friction_vdi_2736_2014", RexsStandardUnitIds.none);

	/** Combined derating factor (AGMA 925 A03) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId combined_derating_factor_agma_925_a03 = RexsAttributeId.create("combined_derating_factor_agma_925_a03", RexsStandardUnitIds.none);

	/** Combined influence factor bending (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId combined_influence_factor_bending_din_743_2012 = RexsAttributeId.create("combined_influence_factor_bending_din_743_2012", RexsStandardUnitIds.none);

	/** Combined influence factor tension/ compression (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId combined_influence_factor_tension_compression_din_743_2012 = RexsAttributeId.create("combined_influence_factor_tension_compression_din_743_2012", RexsStandardUnitIds.none);

	/** Combined influence factor torsion (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId combined_influence_factor_torsion_din_743_2012 = RexsAttributeId.create("combined_influence_factor_torsion_din_743_2012", RexsStandardUnitIds.none);

	/** Common face width (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId common_face_width = RexsAttributeId.create("common_face_width", RexsStandardUnitIds.mm);

	/** Composite surface roughness for filter cutoff wavelength L_x (AGMA 925 A03) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId composite_surface_roughess_agma_925_a03 = RexsAttributeId.create("composite_surface_roughess_agma_925_a03", RexsStandardUnitIds.mum);

	/** Cone angle error tapered interference fit (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId cone_angle_error_tapered_interference_fit = RexsAttributeId.create("cone_angle_error_tapered_interference_fit", RexsStandardUnitIds.radian);

	/** Cone ratio tapered interference fit (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId cone_ratio_tapered_interference_fit = RexsAttributeId.create("cone_ratio_tapered_interference_fit", RexsStandardUnitIds.none);

	/** Consequences of damage in case of failure of the component (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId consequence_of_failure_fkm_2012 = RexsAttributeId.create("consequence_of_failure_fkm_2012", RexsStandardUnitIds.none);

	/** Consider centrifugal force (DIN 7190 2017) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId consider_centrifugal_force_din_7190_2017 = RexsAttributeId.create("consider_centrifugal_force_din_7190_2017", RexsStandardUnitIds.none);

	/** Consideration of operating temperature (DIN 7190 2017) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId consider_operating_temperature_din_7190_2017 = RexsAttributeId.create("consider_operating_temperature_din_7190_2017", RexsStandardUnitIds.none);

	/** Consideration of EP additives ISO 281 2007 (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId consideration_of_ep_additives_iso_281_2007 = RexsAttributeId.create("consideration_of_ep_additives_iso_281_2007", RexsStandardUnitIds.none);

	/** Constant a_d of effective norm diameter for tensile strength (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId constant_a_d_of_effective_diameter_norm_tensile_strength_fkm_2012 = RexsAttributeId.create("constant_a_d_of_effective_diameter_norm_tensile_strength_fkm_2012", RexsStandardUnitIds.none);

	/** Constant a_d of effective norm diameter for yield strength (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId constant_a_d_of_effective_diameter_norm_yield_strength_fkm_2012 = RexsAttributeId.create("constant_a_d_of_effective_diameter_norm_yield_strength_fkm_2012", RexsStandardUnitIds.none);

	/** Contact area (Versions: 1.6) */
	RexsAttributeId contact_area = RexsAttributeId.create("contact_area", RexsStandardUnitIds.mm2);

	/** Contact exposure time at contact point Y (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId contact_exposure_time_iso_10300_2021 = RexsAttributeId.create("contact_exposure_time_iso_10300_2021", RexsStandardUnitIds.second);

	/** Contact factor (tooth bending) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId contact_factor_tooth_bending_din_3996_2019 = RexsAttributeId.create("contact_factor_tooth_bending_din_3996_2019", RexsStandardUnitIds.none);

	/** Contact force (Versions: 1.6) */
	RexsAttributeId contact_force = RexsAttributeId.create("contact_force", RexsStandardUnitIds.newton);

	/** Flank contact ratio factor (VDI 2736 2014) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId contact_ratio_factor_flank_vdi_2736_2014 = RexsAttributeId.create("contact_ratio_factor_flank_vdi_2736_2014", RexsStandardUnitIds.none);

	/** Root contact ratio factor (VDI 2736 2014) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId contact_ratio_factor_root_vdi_2736_2014 = RexsAttributeId.create("contact_ratio_factor_root_vdi_2736_2014", RexsStandardUnitIds.none);

	/** Contact ratio factor (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId contact_ratio_factor_tooth_root_iso_10300_2014 = RexsAttributeId.create("contact_ratio_factor_tooth_root_iso_10300_2014", RexsStandardUnitIds.none);

	/** Contact pattern ratio from local loaded tooth contact analysis (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId contact_ratio_ltca_worm_stage = RexsAttributeId.create("contact_ratio_ltca_worm_stage", RexsStandardUnitIds.percent);

	/** Contact ratio (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId contact_ratio_worm_stage = RexsAttributeId.create("contact_ratio_worm_stage", RexsStandardUnitIds.none);

	/** Contact stress adjustment factor (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId contact_stress_adjustment_factor_iso_10300_2014 = RexsAttributeId.create("contact_stress_adjustment_factor_iso_10300_2014", RexsStandardUnitIds.none);

	/** Contact stress (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId contact_stress_iso_10300_2014 = RexsAttributeId.create("contact_stress_iso_10300_2014", RexsStandardUnitIds.newton_per_mm2);

	/** Contact stress at contact point Y (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId contact_stress_iso_10300_2021 = RexsAttributeId.create("contact_stress_iso_10300_2021", RexsStandardUnitIds.newton_per_mm2);

	/** Contamination coefficient (Versions: 1.0) */
	RexsAttributeId contamination_factor_according_to_din_26281 = RexsAttributeId.create("contamination_factor_according_to_din_26281", RexsStandardUnitIds.none);

	/** Contamination coefficient according to ISO 281 2007 (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId contamination_factor_according_to_iso_281_2007 = RexsAttributeId.create("contamination_factor_according_to_iso_281_2007", RexsStandardUnitIds.none);

	/** Deviation factor (measuring piece) (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId conversion_factor = RexsAttributeId.create("conversion_factor", RexsStandardUnitIds.none);

	/** Deviation of base tangent length factor (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId conversion_factor_of_backlash_allowance = RexsAttributeId.create("conversion_factor_of_backlash_allowance", RexsStandardUnitIds.none);

	/** Cooling power (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId cooling_power_din_3996_2019 = RexsAttributeId.create("cooling_power_din_3996_2019", RexsStandardUnitIds.watt);

	/** Coordinate where amount of modification is specified at datum face (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId coordinate_where_helix_crowning_is_specified_datum_face = RexsAttributeId.create("coordinate_where_helix_crowning_is_specified_datum_face", RexsStandardUnitIds.mm);

	/** Coordinate where amount of modification is specified at non-datum face (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId coordinate_where_helix_crowning_is_specified_non_datum_face = RexsAttributeId.create("coordinate_where_helix_crowning_is_specified_non_datum_face", RexsStandardUnitIds.mm);

	/** Face width coordinates of helix deviations (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId coordinates_of_helix_deviation = RexsAttributeId.create("coordinates_of_helix_deviation", RexsStandardUnitIds.mm);

	/** Coordinates  of topographical deviation (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId coordinates_of_topographical_deviation = RexsAttributeId.create("coordinates_of_topographical_deviation", RexsStandardUnitIds.mm);

	/** Coordinates  of topographical modification (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId coordinates_of_topographical_modification = RexsAttributeId.create("coordinates_of_topographical_modification", RexsStandardUnitIds.mm);

	/** Core hardness Brinell (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId core_hardness_brinell = RexsAttributeId.create("core_hardness_brinell", RexsStandardUnitIds.hb);

	/** Core hardness Rockwell (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId core_hardness_rockwell = RexsAttributeId.create("core_hardness_rockwell", RexsStandardUnitIds.hrc);

	/** Core hardness Vickers (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId core_hardness_vickers = RexsAttributeId.create("core_hardness_vickers", RexsStandardUnitIds.hv);

	/** Inner diameter of circular ring cross section (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId cross_sectional_shape_circular_ring_inner_diameter_fkm_2012 = RexsAttributeId.create("cross_sectional_shape_circular_ring_inner_diameter_fkm_2012", RexsStandardUnitIds.mm);

	/** Outer diameter of circular ring cross section (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId cross_sectional_shape_circular_ring_outer_diameter_fkm_2012 = RexsAttributeId.create("cross_sectional_shape_circular_ring_outer_diameter_fkm_2012", RexsStandardUnitIds.mm);

	/** Form of cross section on evaluation point (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId cross_sectional_shape_fkm_2012 = RexsAttributeId.create("cross_sectional_shape_fkm_2012", RexsStandardUnitIds.none);

	/** Crowning of the mating flanks (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId crowning_of_the_mating_flanks = RexsAttributeId.create("crowning_of_the_mating_flanks", RexsStandardUnitIds.none);

	/** Curvature factor at contact point Y (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId curvature_factor_iso_10300_2021 = RexsAttributeId.create("curvature_factor_iso_10300_2021", RexsStandardUnitIds.none);

	/** Endurable tooth root stress limit for the calculation of the load-independent stress influence (Versions: 1.5) */
	RexsAttributeId custom_zf_endurable_tooth_root_stress_limit_for_load_independent_stress_influence_dr14028_2020 = RexsAttributeId.create("custom_zf_endurable_tooth_root_stress_limit_for_load_independent_stress_influence_dr14028_2020", RexsStandardUnitIds.mega_pascal);

	/** Customer (Versions: 1.5, 1.6) */
	RexsAttributeId customer = RexsAttributeId.create("customer", RexsStandardUnitIds.none);

	/** Cutter module (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId cutter_module = RexsAttributeId.create("cutter_module", RexsStandardUnitIds.mm);

	/** Cutter radius (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId cutter_radius = RexsAttributeId.create("cutter_radius", RexsStandardUnitIds.mm);

	/** Cutter swivel (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId cutter_swivel = RexsAttributeId.create("cutter_swivel", RexsStandardUnitIds.deg);

	/** Cutter tilt (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId cutter_tilt = RexsAttributeId.create("cutter_tilt", RexsStandardUnitIds.deg);

	/** Highly loaded surface for the material-mechanical support concept (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId cyclic_highly_loaded_area_fkm_2012 = RexsAttributeId.create("cyclic_highly_loaded_area_fkm_2012", RexsStandardUnitIds.mm2);

	/** Miner variant under cyclic load (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId cyclic_miner_variant_fkm_2012 = RexsAttributeId.create("cyclic_miner_variant_fkm_2012", RexsStandardUnitIds.none);

	/** Number of cycles in each cyclic load spectrum step (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId cyclic_number_of_cycles_in_load_spectrum_steps_fkm_2012 = RexsAttributeId.create("cyclic_number_of_cycles_in_load_spectrum_steps_fkm_2012", RexsStandardUnitIds.none);

	/** Number of steps in cyclic load spectrum (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId cyclic_number_of_steps_in_load_spectrum_fkm_2012 = RexsAttributeId.create("cyclic_number_of_steps_in_load_spectrum_fkm_2012", RexsStandardUnitIds.none);

	/** Overloading type under cyclic load (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId cyclic_overloading_type_fkm_2012 = RexsAttributeId.create("cyclic_overloading_type_fkm_2012", RexsStandardUnitIds.none);

	/** Regular inspections under cyclic load (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId cyclic_regular_inspections_fkm_2012 = RexsAttributeId.create("cyclic_regular_inspections_fkm_2012", RexsStandardUnitIds.none);

	/** Number of required cycles in cyclic load spectrum (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId cyclic_required_number_of_cycles_fkm_2012 = RexsAttributeId.create("cyclic_required_number_of_cycles_fkm_2012", RexsStandardUnitIds.none);

	/** Use equivalent mean stress under cyclic load (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId cyclic_use_equivalent_mean_stress_fkm_2012 = RexsAttributeId.create("cyclic_use_equivalent_mean_stress_fkm_2012", RexsStandardUnitIds.none);

	/** Use Stielers support concept under cyclic load (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId cyclic_use_stielers_support_concept_fkm_2012 = RexsAttributeId.create("cyclic_use_stielers_support_concept_fkm_2012", RexsStandardUnitIds.none);

	/** External data source (Versions: 1.5, 1.6) */
	RexsAttributeId data_source = RexsAttributeId.create("data_source", RexsStandardUnitIds.none);

	/** Orientation datum face (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId datum_face_orientation = RexsAttributeId.create("datum_face_orientation", RexsStandardUnitIds.none);

	/** Nominal outer diameter of casing (Versions: 1.0) */
	RexsAttributeId decisive_housing_outer_diameter = RexsAttributeId.create("decisive_housing_outer_diameter", RexsStandardUnitIds.mm);

	/** Nominal inner diameter of shaft (Versions: 1.0) */
	RexsAttributeId decisive_pin_diameter = RexsAttributeId.create("decisive_pin_diameter", RexsStandardUnitIds.mm);

	/** Dedendum coefficient tool reference profile relative to module (Versions: 1.0, 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId dedendum_coefficient_reference_profile = RexsAttributeId.create("dedendum_coefficient_reference_profile", RexsStandardUnitIds.none);

	/** Dedendum reference profile (Versions: 1.0, 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId dedendum_reference_profile = RexsAttributeId.create("dedendum_reference_profile", RexsStandardUnitIds.mm);

	/** Shaft defines rotational speed (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId defines_speed = RexsAttributeId.create("defines_speed", RexsStandardUnitIds.none);

	/** External load defines torque (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId defines_torque = RexsAttributeId.create("defines_torque", RexsStandardUnitIds.none);

	/** Deflection (DIN 3996 2019) (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId deflection_din_3996_2019 = RexsAttributeId.create("deflection_din_3996_2019", RexsStandardUnitIds.mm);

	/** Deformation behavior (Versions: 1.5, 1.6) */
	RexsAttributeId deformation_behaviour = RexsAttributeId.create("deformation_behaviour", RexsStandardUnitIds.none);

	/** Deformation of the tooth tip in circumferential direction (VDI 2736 2014) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId deformation_of_tooth_tip_vdi_2736_2014 = RexsAttributeId.create("deformation_of_tooth_tip_vdi_2736_2014", RexsStandardUnitIds.mm);

	/** Degree of tooth loss (VDI 2736 2014) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId degree_of_tooth_loss_vdi_2736_2014 = RexsAttributeId.create("degree_of_tooth_loss_vdi_2736_2014", RexsStandardUnitIds.none);

	/** Density (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId density = RexsAttributeId.create("density", RexsStandardUnitIds.kg_per_dm3);

	/** Density at 15&deg;C (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId density_at_15_degree_celsius = RexsAttributeId.create("density_at_15_degree_celsius", RexsStandardUnitIds.kg_per_dm3);

	/** Case hardening depth at 550 HV (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId depth_of_case_hardening_at_550_hv = RexsAttributeId.create("depth_of_case_hardening_at_550_hv", RexsStandardUnitIds.mm);

	/** Depth of hub keyway (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId depth_of_hub_keyway = RexsAttributeId.create("depth_of_hub_keyway", RexsStandardUnitIds.mm);

	/** Depth of immersion of bearing into oil (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId depth_of_immersion_in_oil = RexsAttributeId.create("depth_of_immersion_in_oil", RexsStandardUnitIds.mm);

	/** Axial insertion depth (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId depth_of_insert_axial = RexsAttributeId.create("depth_of_insert_axial", RexsStandardUnitIds.mm);

	/** Radial insertion depth (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId depth_of_insert_radial = RexsAttributeId.create("depth_of_insert_radial", RexsStandardUnitIds.mm);

	/** Depth of shaft keyway (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId depth_of_shaft_keyway = RexsAttributeId.create("depth_of_shaft_keyway", RexsStandardUnitIds.mm);

	/** Description how datum face is defined (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId description_datum_face = RexsAttributeId.create("description_datum_face", RexsStandardUnitIds.none);

	/** Application factor design calculation VDI 2736 2014 (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId design_application_factor_vdi_2736_2014 = RexsAttributeId.create("design_application_factor_vdi_2736_2014", RexsStandardUnitIds.none);

	/** Design tooth flank temperature (VDI 2736 2014) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId design_flank_temperature_vdi_2736_2014 = RexsAttributeId.create("design_flank_temperature_vdi_2736_2014", RexsStandardUnitIds.degree_celsius);

	/** Design tooth root temperature  (VDI 2736 2014) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId design_root_temperature_vdi_2736_2014 = RexsAttributeId.create("design_root_temperature_vdi_2736_2014", RexsStandardUnitIds.degree_celsius);

	/** Design safety of the tooth flank  (VDI 2736 2014) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId design_safety_factor_flank_vdi_2736_2014 = RexsAttributeId.create("design_safety_factor_flank_vdi_2736_2014", RexsStandardUnitIds.none);

	/** Design safety of the tooth root  (VDI 2736 2014) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId design_safety_factor_root_vdi_2736_2014 = RexsAttributeId.create("design_safety_factor_root_vdi_2736_2014", RexsStandardUnitIds.none);

	/** Determination of bulk temperature (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId determination_of_bulk_temperature_din_3996_2019 = RexsAttributeId.create("determination_of_bulk_temperature_din_3996_2019", RexsStandardUnitIds.none);

	/** Determination of cooling power (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId determination_of_cooling_power_din_3996_2019 = RexsAttributeId.create("determination_of_cooling_power_din_3996_2019", RexsStandardUnitIds.none);

	/** Determination of deflection (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId determination_of_deflection_din_3996_2019 = RexsAttributeId.create("determination_of_deflection_din_3996_2019", RexsStandardUnitIds.none);

	/** Determination of degree of tooth loss (VDI 2736 2014) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId determination_of_degree_of_tooth_loss_vdi_2736_2014 = RexsAttributeId.create("determination_of_degree_of_tooth_loss_vdi_2736_2014", RexsStandardUnitIds.none);

	/** Determination of factor K_H for tooth flank loading (VDI 2736 2014) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId determination_of_factor_for_tooth_flank_loading_vdi_2736_2014 = RexsAttributeId.create("determination_of_factor_for_tooth_flank_loading_vdi_2736_2014", RexsStandardUnitIds.none);

	/** Determination of factor K_F for tooth root loading (VDI 2736 2014) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId determination_of_factor_for_tooth_root_loading_vdi_2736_2014 = RexsAttributeId.create("determination_of_factor_for_tooth_root_loading_vdi_2736_2014", RexsStandardUnitIds.none);

	/** Determination of the load cycle-dependent fatigue strength under pulsating stress (VDI 2736 2014) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId determination_of_fatigue_strength_under_pulsating_stress_vdi_2736_2014 = RexsAttributeId.create("determination_of_fatigue_strength_under_pulsating_stress_vdi_2736_2014", RexsStandardUnitIds.none);

	/** Determination of flank loss (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId determination_of_flank_loss_din_3996_2019 = RexsAttributeId.create("determination_of_flank_loss_din_3996_2019", RexsStandardUnitIds.none);

	/** Determination of hardness depth profile (ISO 6336 2019) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId determination_of_hardness_depth_profile_iso_6336_2019 = RexsAttributeId.create("determination_of_hardness_depth_profile_iso_6336_2019", RexsStandardUnitIds.none);

	/** Determination of local Hertzian contact stress (ISO 6336 2019) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId determination_of_local_hertzian_contact_stress_iso_6336_2019 = RexsAttributeId.create("determination_of_local_hertzian_contact_stress_iso_6336_2019", RexsStandardUnitIds.none);

	/** Method for approximating mean coefficient of friction (AGMA 925 C95) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId determination_of_mean_coefficient_of_friction_agma_925_a03 = RexsAttributeId.create("determination_of_mean_coefficient_of_friction_agma_925_a03", RexsStandardUnitIds.none);

	/** Determination of mean hertzian stress (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId determination_of_mean_hertzian_stress_din_3996_2019 = RexsAttributeId.create("determination_of_mean_hertzian_stress_din_3996_2019", RexsStandardUnitIds.none);

	/** Determination of mean minimum lubricant film thickness (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId determination_of_mean_minimum_lubricant_film_thickness_din_3996_2019 = RexsAttributeId.create("determination_of_mean_minimum_lubricant_film_thickness_din_3996_2019", RexsStandardUnitIds.none);

	/** Determination of meshing power loss (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId determination_of_meshing_power_loss_din_3996_2019 = RexsAttributeId.create("determination_of_meshing_power_loss_din_3996_2019", RexsStandardUnitIds.none);

	/** Determination of the temperature-dependant modulus of elasticity (VDI 2736 2014) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId determination_of_modulus_of_elasticity_vdi_2736_2014 = RexsAttributeId.create("determination_of_modulus_of_elasticity_vdi_2736_2014", RexsStandardUnitIds.none);

	/** Determination of oil sump temperature (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId determination_of_oil_sump_temperature_din_3996_2019 = RexsAttributeId.create("determination_of_oil_sump_temperature_din_3996_2019", RexsStandardUnitIds.none);

	/** Determination of permissible wear erosion (Plewe 1980) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId determination_of_permissible_wear_erosion_plewe_1980 = RexsAttributeId.create("determination_of_permissible_wear_erosion_plewe_1980", RexsStandardUnitIds.none);

	/** Determination of the temperature-dependent Poisson's ratio (VDI 2736 2014) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId determination_of_poissons_ratio_vdi_2736_2014 = RexsAttributeId.create("determination_of_poissons_ratio_vdi_2736_2014", RexsStandardUnitIds.none);

	/** Determination of residual stress depth profile (ISO 6336 2019) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId determination_of_residual_stress_depth_profile_iso_6336_2019 = RexsAttributeId.create("determination_of_residual_stress_depth_profile_iso_6336_2019", RexsStandardUnitIds.none);

	/** Determination of the load cycle-dependent rolling contact fatigue strength (VDI 2736 2014) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId determination_of_rolling_contact_fatigue_strength_vdi_2736_2014 = RexsAttributeId.create("determination_of_rolling_contact_fatigue_strength_vdi_2736_2014", RexsStandardUnitIds.none);

	/** Method of calculating scuffing temperature (AGMA 925 A03) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId determination_of_scuffing_temperature_agma_925_a03 = RexsAttributeId.create("determination_of_scuffing_temperature_agma_925_a03", RexsStandardUnitIds.none);

	/** Determination of mean sliding path (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId determination_of_sliding_path_din_3996_2019 = RexsAttributeId.create("determination_of_sliding_path_din_3996_2019", RexsStandardUnitIds.none);

	/** Determination of spiral angle factor Z_&beta; (VDI 2736 2014) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId determination_of_spiral_angle_factor_vdi_2736_2014 = RexsAttributeId.create("determination_of_spiral_angle_factor_vdi_2736_2014", RexsStandardUnitIds.none);

	/** Determination of stress correction factor notch effect (VDI 2736 2014) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId determination_of_stress_correction_factor_notch_effect_vdi_2736_2014 = RexsAttributeId.create("determination_of_stress_correction_factor_notch_effect_vdi_2736_2014", RexsStandardUnitIds.none);

	/** Determination of tooth root safety (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId determination_of_tooth_root_safety_din_3996_2019 = RexsAttributeId.create("determination_of_tooth_root_safety_din_3996_2019", RexsStandardUnitIds.none);

	/** Determination of total efficiency (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId determination_of_total_efficiency_din_3996_2019 = RexsAttributeId.create("determination_of_total_efficiency_din_3996_2019", RexsStandardUnitIds.none);

	/** Determination of wear coefficient (VDI 2736 2014) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId determination_of_wear_coefficient_vdi_2736_2014 = RexsAttributeId.create("determination_of_wear_coefficient_vdi_2736_2014", RexsStandardUnitIds.none);

	/** Determination of the tmperature-dependant yield strength (VDI 2736 2014) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId determination_of_yield_strength_vdi_2736_2014 = RexsAttributeId.create("determination_of_yield_strength_vdi_2736_2014", RexsStandardUnitIds.none);

	/** Deviation of hypoid offset (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId deviation_of_offset = RexsAttributeId.create("deviation_of_offset", RexsStandardUnitIds.mm);

	/** Deviation of shaft angle (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId deviation_of_shaft_angle = RexsAttributeId.create("deviation_of_shaft_angle", RexsStandardUnitIds.deg);

	/** Figure number for contamination coefficient in DIN 26281 (Versions: 1.0) */
	RexsAttributeId diagram_number_in_din_26281 = RexsAttributeId.create("diagram_number_in_din_26281", RexsStandardUnitIds.none);

	/** Figure number for contamination coefficient e_C in ISO 281 2007 (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId diagram_number_in_iso_281_2007 = RexsAttributeId.create("diagram_number_in_iso_281_2007", RexsStandardUnitIds.none);

	/** Diameter clearance in radial plain bearing (Versions: 1.6) */
	RexsAttributeId diameter_clearance_plain_bearing = RexsAttributeId.create("diameter_clearance_plain_bearing", RexsStandardUnitIds.none);

	/** Diameter of the cylindrical surface of the contact (Versions: 1.6) */
	RexsAttributeId diameter_of_cylindrical_surface_contact = RexsAttributeId.create("diameter_of_cylindrical_surface_contact", RexsStandardUnitIds.mm);

	/** Diameters of helix deviations (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId diameter_of_helix_deviation = RexsAttributeId.create("diameter_of_helix_deviation", RexsStandardUnitIds.mm);

	/** Diameter of helix modification (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId diameter_of_helix_modification = RexsAttributeId.create("diameter_of_helix_modification", RexsStandardUnitIds.mm);

	/** Measuring ball or pin diameter (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId diameter_of_measuring_ball_or_pin = RexsAttributeId.create("diameter_of_measuring_ball_or_pin", RexsStandardUnitIds.mm);

	/** Diameter of rolling element (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId diameter_of_rolling_element = RexsAttributeId.create("diameter_of_rolling_element", RexsStandardUnitIds.mm);

	/** Diameter where amount of profile crowning at the root is specified (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId diameter_where_profile_crowning_root_is_specified = RexsAttributeId.create("diameter_where_profile_crowning_root_is_specified", RexsStandardUnitIds.mm);

	/** Diameter where amount of profile crowning at the tip is specified (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId diameter_where_profile_crowning_tip_is_specified = RexsAttributeId.create("diameter_where_profile_crowning_tip_is_specified", RexsStandardUnitIds.mm);

	/** Diameter where amount of modification is specified (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId diameter_where_profile_slope_amount_is_specified = RexsAttributeId.create("diameter_where_profile_slope_amount_is_specified", RexsStandardUnitIds.mm);

	/** Diameter where amount of profile twist is specified (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId diameter_where_profile_twist_amount_is_specified = RexsAttributeId.create("diameter_where_profile_twist_amount_is_specified", RexsStandardUnitIds.mm);

	/** Diameters of profile deviations (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId diameters_of_profile_deviation = RexsAttributeId.create("diameters_of_profile_deviation", RexsStandardUnitIds.mm);

	/** Diameters  of topographical deviation (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId diameters_of_topographical_deviation = RexsAttributeId.create("diameters_of_topographical_deviation", RexsStandardUnitIds.mm);

	/** Diameters  of topographical modification (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId diameters_of_topographical_modification = RexsAttributeId.create("diameters_of_topographical_modification", RexsStandardUnitIds.mm);

	/** Diametral measurement (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId diametral_measurement = RexsAttributeId.create("diametral_measurement", RexsStandardUnitIds.mm);

	/** Dimensionless central film thickness at the calculation points (AGMA 925 A03) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId dimensionless_central_film_thickness_at_calculation_points_agma_925_a03 = RexsAttributeId.create("dimensionless_central_film_thickness_at_calculation_points_agma_925_a03", RexsStandardUnitIds.none);

	/** Din 3964 center distance tolerance field (Versions: 1.0) */
	RexsAttributeId din_3964_center_distance_tolerance_field = RexsAttributeId.create("din_3964_center_distance_tolerance_field", RexsStandardUnitIds.none);

	/** DIN 3967 Deviation-tolerance series (Versions: 1.0) */
	RexsAttributeId din_3967_deviation_tolerance_series = RexsAttributeId.create("din_3967_deviation_tolerance_series", RexsStandardUnitIds.none);

	/** Direction of rotation factor (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId direction_of_rotation_factor_iso_10300_2021 = RexsAttributeId.create("direction_of_rotation_factor_iso_10300_2021", RexsStandardUnitIds.none);

	/** Direction vector of gravity u-coordinate (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId direction_vector_gravity_u = RexsAttributeId.create("direction_vector_gravity_u", RexsStandardUnitIds.none);

	/** Direction vector of gravity v-coordinate (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId direction_vector_gravity_v = RexsAttributeId.create("direction_vector_gravity_v", RexsStandardUnitIds.none);

	/** Direction vector of gravity w-coordinate (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId direction_vector_gravity_w = RexsAttributeId.create("direction_vector_gravity_w", RexsStandardUnitIds.none);

	/** Displacement in u direction at inner side (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId displacement_inner_side_u = RexsAttributeId.create("displacement_inner_side_u", RexsStandardUnitIds.mum);

	/** Displacement in v direction at inner side (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId displacement_inner_side_v = RexsAttributeId.create("displacement_inner_side_v", RexsStandardUnitIds.mum);

	/** Displacement in w direction at inner side (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId displacement_inner_side_w = RexsAttributeId.create("displacement_inner_side_w", RexsStandardUnitIds.mum);

	/** Displacement in u direction at outer side (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId displacement_outer_side_u = RexsAttributeId.create("displacement_outer_side_u", RexsStandardUnitIds.mum);

	/** Displacement in v direction at outer side (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId displacement_outer_side_v = RexsAttributeId.create("displacement_outer_side_v", RexsStandardUnitIds.mum);

	/** Displacement in w direction at outer side (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId displacement_outer_side_w = RexsAttributeId.create("displacement_outer_side_w", RexsStandardUnitIds.mum);

	/** Displacement in u direction (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId displacement_u = RexsAttributeId.create("displacement_u", RexsStandardUnitIds.mum);

	/** Axial displacement in u direction (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId displacement_u_of_nodes = RexsAttributeId.create("displacement_u_of_nodes", RexsStandardUnitIds.mum);

	/** Displacement in v direction (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId displacement_v = RexsAttributeId.create("displacement_v", RexsStandardUnitIds.mum);

	/** Radial displacement in v-direction (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId displacement_v_of_nodes = RexsAttributeId.create("displacement_v_of_nodes", RexsStandardUnitIds.mum);

	/** Displacement in w direction (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId displacement_w = RexsAttributeId.create("displacement_w", RexsStandardUnitIds.mum);

	/** Radial displacement in w-direction (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId displacement_w_of_nodes = RexsAttributeId.create("displacement_w_of_nodes", RexsStandardUnitIds.mum);

	/** Display color (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId display_color = RexsAttributeId.create("display_color", RexsStandardUnitIds.percent);

	/** Distance along the line of action - Point A (AGMA 925 A03) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId distance_along_the_line_of_action_at_point_a_agma_925_a03 = RexsAttributeId.create("distance_along_the_line_of_action_at_point_a_agma_925_a03", RexsStandardUnitIds.mm);

	/** Distance along the line of action - Point B (AGMA 925 A03) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId distance_along_the_line_of_action_at_point_b_agma_925_a03 = RexsAttributeId.create("distance_along_the_line_of_action_at_point_b_agma_925_a03", RexsStandardUnitIds.mm);

	/** Distance along the line of action - Point C (AGMA 925 A03) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId distance_along_the_line_of_action_at_point_c_agma_925_a03 = RexsAttributeId.create("distance_along_the_line_of_action_at_point_c_agma_925_a03", RexsStandardUnitIds.mm);

	/** Distance along the line of action - Point D (AGMA 925 A03) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId distance_along_the_line_of_action_at_point_d_agma_925_a03 = RexsAttributeId.create("distance_along_the_line_of_action_at_point_d_agma_925_a03", RexsStandardUnitIds.mm);

	/** Distance along the line of action - Point E (AGMA 925 A03) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId distance_along_the_line_of_action_at_point_e_agma_925_a03 = RexsAttributeId.create("distance_along_the_line_of_action_at_point_e_agma_925_a03", RexsStandardUnitIds.mm);

	/** Distance along the line of action - Point F (AGMA 925 A03) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId distance_along_the_line_of_action_at_point_f_agma_925_a03 = RexsAttributeId.create("distance_along_the_line_of_action_at_point_f_agma_925_a03", RexsStandardUnitIds.mm);

	/** Distance between bearing rows (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId distance_between_bearing_rows = RexsAttributeId.create("distance_between_bearing_rows", RexsStandardUnitIds.mm);

	/** Distance from the centre of the zone of action to a contact line (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId distance_centre_zone_of_action_to_contact_line_iso_10300_2014 = RexsAttributeId.create("distance_centre_zone_of_action_to_contact_line_iso_10300_2014", RexsStandardUnitIds.mm);

	/** Distance from datum line to measuring line (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId distance_tool_profile_basic_line_to_measuring_line = RexsAttributeId.create("distance_tool_profile_basic_line_to_measuring_line", RexsStandardUnitIds.mm);

	/** Distance of tool tip line to manufacturing pitch circle (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId distance_tool_tip_line_to_manufacturing_pitch_diameter = RexsAttributeId.create("distance_tool_tip_line_to_manufacturing_pitch_diameter", RexsStandardUnitIds.mm);

	/** Driving direction factor (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId driving_direction_factor_iso_10300_2021 = RexsAttributeId.create("driving_direction_factor_iso_10300_2021", RexsStandardUnitIds.none);

	/** Dynamic load rating (Versions: 1.0) */
	RexsAttributeId dynamic_capacity = RexsAttributeId.create("dynamic_capacity", RexsStandardUnitIds.kilo_newton);

	/** Dynamic equivalent reference bearing load (ISO/TS 16281:2008) (Versions: 1.6) */
	RexsAttributeId dynamic_equivalent_reference_bearing_load_iso_16281_2008 = RexsAttributeId.create("dynamic_equivalent_reference_bearing_load_iso_16281_2008", RexsStandardUnitIds.newton);

	/** Dynamic factor (AGMA 2101 C95) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId dynamic_factor_agma_2101_c95 = RexsAttributeId.create("dynamic_factor_agma_2101_c95", RexsStandardUnitIds.none);

	/** Dynamic factor (AGMA 925 C95) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId dynamic_factor_agma_925_a03 = RexsAttributeId.create("dynamic_factor_agma_925_a03", RexsStandardUnitIds.none);

	/** Dynamic factor (DIN 3990 1987) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId dynamic_factor_din_3990_1987 = RexsAttributeId.create("dynamic_factor_din_3990_1987", RexsStandardUnitIds.none);

	/** Dynamic factor (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId dynamic_factor_iso_10300_2014 = RexsAttributeId.create("dynamic_factor_iso_10300_2014", RexsStandardUnitIds.none);

	/** Dynamic factor (ISO 6336 2006) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId dynamic_factor_iso_6336_2006 = RexsAttributeId.create("dynamic_factor_iso_6336_2006", RexsStandardUnitIds.none);

	/** Dynamic viscosity at tooth temperature (AGMA 925 C95) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId dynamic_viscosity_at_gear_tooth_temperature_agma_925_a03 = RexsAttributeId.create("dynamic_viscosity_at_gear_tooth_temperature_agma_925_a03", RexsStandardUnitIds.mpa_s);

	/** Ease-off (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId ease_off = RexsAttributeId.create("ease_off", RexsStandardUnitIds.mm);

	/** Eccentricity (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId eccentricity_vector = RexsAttributeId.create("eccentricity_vector", RexsStandardUnitIds.mm);

	/** 45&deg; chamfer or rounding on the key edge (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId edge_radius_or_chamfer_feather_key = RexsAttributeId.create("edge_radius_or_chamfer_feather_key", RexsStandardUnitIds.mm);

	/** 45&deg; chamfer or rounding on the shaft keyway edge (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId edge_radius_or_chamfer_hub_keyway = RexsAttributeId.create("edge_radius_or_chamfer_hub_keyway", RexsStandardUnitIds.mm);

	/** 45&deg; chamfer or rounding on the shaft keyway edge (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId edge_radius_or_chamfer_shaft_keyway = RexsAttributeId.create("edge_radius_or_chamfer_shaft_keyway", RexsStandardUnitIds.mm);

	/** Effective diameter (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId effective_diameter_fkm_2012 = RexsAttributeId.create("effective_diameter_fkm_2012", RexsStandardUnitIds.mm);

	/** Effective norm diameter for tensile strength (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId effective_diameter_norm_tensile_strength_fkm_2012 = RexsAttributeId.create("effective_diameter_norm_tensile_strength_fkm_2012", RexsStandardUnitIds.mm);

	/** Effective norm diameter for yield strength (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId effective_diameter_norm_yield_strength_fkm_2012 = RexsAttributeId.create("effective_diameter_norm_yield_strength_fkm_2012", RexsStandardUnitIds.mm);

	/** Effective face width (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId effective_face_width_iso_10300_2014 = RexsAttributeId.create("effective_face_width_iso_10300_2014", RexsStandardUnitIds.mm);

	/** Effective face width of virtual cylindrical gear pair (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId effective_face_width_virtual_cylindrical_gear_iso_10300_2014 = RexsAttributeId.create("effective_face_width_virtual_cylindrical_gear_iso_10300_2014", RexsStandardUnitIds.mm);

	/** Effective face width (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId effective_face_width_worm_wheel = RexsAttributeId.create("effective_face_width_worm_wheel", RexsStandardUnitIds.mm);

	/** Effective pressure angle on coast side (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId effective_pressure_angle_coast = RexsAttributeId.create("effective_pressure_angle_coast", RexsStandardUnitIds.deg);

	/** Effective pressure angle on drive side (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId effective_pressure_angle_drive = RexsAttributeId.create("effective_pressure_angle_drive", RexsStandardUnitIds.deg);

	/** Elastic modulus (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId elastic_modulus = RexsAttributeId.create("elastic_modulus", RexsStandardUnitIds.newton_per_mm2);

	/** Elasticity factor (ISO 6336 2019) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId elasticity_factor_iso_6336_2019 = RexsAttributeId.create("elasticity_factor_iso_6336_2019", RexsStandardUnitIds.newton_per_mm2_then_squareroot);

	/** Elasticity factor (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId elasticity_factor_pitting_iso_10300_2014 = RexsAttributeId.create("elasticity_factor_pitting_iso_10300_2014", RexsStandardUnitIds.newton_per_mm2_then_squareroot);

	/** Elasticity factor (VDI 2736 2014) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId elasticity_factor_vdi_2736_2014 = RexsAttributeId.create("elasticity_factor_vdi_2736_2014", RexsStandardUnitIds.newton_per_mm2_then_squareroot);

	/** Element Ids (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId element_ids = RexsAttributeId.create("element_ids", RexsStandardUnitIds.none);

	/** Element structure (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId element_structure = RexsAttributeId.create("element_structure", RexsStandardUnitIds.none);

	/** Element types (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId element_types = RexsAttributeId.create("element_types", RexsStandardUnitIds.none);

	/** Elongation at fracture acc. to FKM 2012 (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId elongation_at_fracture_fkm_2012 = RexsAttributeId.create("elongation_at_fracture_fkm_2012", RexsStandardUnitIds.none);

	/** End angle (Versions: 1.6) */
	RexsAttributeId end_angle_plain_bearing_feature = RexsAttributeId.create("end_angle_plain_bearing_feature", RexsStandardUnitIds.deg);

	/** Length of end of tangential transition area (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId end_relief_datum_face_length_of_tangential_transition_end = RexsAttributeId.create("end_relief_datum_face_length_of_tangential_transition_end", RexsStandardUnitIds.mm);

	/** Length of start of tangential transition area (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId end_relief_datum_face_length_of_tangential_transition_start = RexsAttributeId.create("end_relief_datum_face_length_of_tangential_transition_start", RexsStandardUnitIds.mm);

	/** Depth of end relief (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId end_relief_depth_datum_face = RexsAttributeId.create("end_relief_depth_datum_face", RexsStandardUnitIds.mm);

	/** Depth of end relief (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId end_relief_depth_non_datum_face = RexsAttributeId.create("end_relief_depth_non_datum_face", RexsStandardUnitIds.mm);

	/** Coordinate where amount of modification is specified (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId end_relief_evaluation_reference_datum_face = RexsAttributeId.create("end_relief_evaluation_reference_datum_face", RexsStandardUnitIds.mm);

	/** Coordinate where amount of modification is specified (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId end_relief_evaluation_reference_non_datum_face = RexsAttributeId.create("end_relief_evaluation_reference_non_datum_face", RexsStandardUnitIds.mm);

	/** Length of end relief (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId end_relief_length_datum_face = RexsAttributeId.create("end_relief_length_datum_face", RexsStandardUnitIds.mm);

	/** Length of end relief (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId end_relief_length_non_datum_face = RexsAttributeId.create("end_relief_length_non_datum_face", RexsStandardUnitIds.mm);

	/** Length of end of tangential transition area (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId end_relief_non_datum_face_length_of_tangential_transition_end = RexsAttributeId.create("end_relief_non_datum_face_length_of_tangential_transition_end", RexsStandardUnitIds.mm);

	/** Length of start of tangential transition area (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId end_relief_non_datum_face_length_of_tangential_transition_start = RexsAttributeId.create("end_relief_non_datum_face_length_of_tangential_transition_start", RexsStandardUnitIds.mm);

	/** Endurance limit flank (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId endurance_limit_flank = RexsAttributeId.create("endurance_limit_flank", RexsStandardUnitIds.newton_per_mm2);

	/** Endurance limit root (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId endurance_limit_root = RexsAttributeId.create("endurance_limit_root", RexsStandardUnitIds.newton_per_mm2);

	/** Entraining velocity at the calculation points (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId entraining_velocity_of_calculation_points_agma_925_a03 = RexsAttributeId.create("entraining_velocity_of_calculation_points_agma_925_a03", RexsStandardUnitIds.m_per_second);

	/** Equivalent circumferential force (DIN 6892 2012) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId equivalent_circumferential_force_din_6892_2012 = RexsAttributeId.create("equivalent_circumferential_force_din_6892_2012", RexsStandardUnitIds.newton);

	/** Equivalent dynamic bearing load din iso 281 (Versions: 1.0) */
	RexsAttributeId equivalent_dynamic_bearing_load_din_iso_281 = RexsAttributeId.create("equivalent_dynamic_bearing_load_din_iso_281", RexsStandardUnitIds.kilo_newton);

	/** Equivalent dynamic bearing load iso 281 2007 (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId equivalent_dynamic_bearing_load_iso_281_2007 = RexsAttributeId.create("equivalent_dynamic_bearing_load_iso_281_2007", RexsStandardUnitIds.kilo_newton);

	/** (Equivalent) outer diameter of hub (DIN 6892 2012) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId equivalent_outer_diameter_hub_din_6892_2012 = RexsAttributeId.create("equivalent_outer_diameter_hub_din_6892_2012", RexsStandardUnitIds.mm);

	/** Equivalent radius of curvature at pitch point (Plewe 1980) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId equivalent_radius_of_curvature_at_pitch_point_plewe_1980 = RexsAttributeId.create("equivalent_radius_of_curvature_at_pitch_point_plewe_1980", RexsStandardUnitIds.mm);

	/** Equivalent radius of curvature at pitch point under test conditions (Plewe 1980) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId equivalent_radius_of_curvature_at_pitch_point_under_test_conditions_plewe_1980 = RexsAttributeId.create("equivalent_radius_of_curvature_at_pitch_point_under_test_conditions_plewe_1980", RexsStandardUnitIds.mm);

	/** Equivalent effective surface pressure hub (DIN 6892 2012) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId equivalent_surface_pressure_hub_din_6892_2012 = RexsAttributeId.create("equivalent_surface_pressure_hub_din_6892_2012", RexsStandardUnitIds.mega_pascal);

	/** Equivalent effective surface pressure key (DIN 6892 2012) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId equivalent_surface_pressure_key_din_6892_2012 = RexsAttributeId.create("equivalent_surface_pressure_key_din_6892_2012", RexsStandardUnitIds.mega_pascal);

	/** Equivalent effective surface pressure shaft (DIN 6892 2012) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId equivalent_surface_pressure_shaft_din6892_2012 = RexsAttributeId.create("equivalent_surface_pressure_shaft_din6892_2012", RexsStandardUnitIds.mega_pascal);

	/** Equivalent torsional torque (DIN 6892 2012) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId equivalent_torsional_torque_din_6892_2012 = RexsAttributeId.create("equivalent_torsional_torque_din_6892_2012", RexsStandardUnitIds.newton_m);

	/** Exponent for the distribution of the load peaks along the lines of contact (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId exponent_distribution_load_peaks_along_lines_of_contact_iso_10300_2014 = RexsAttributeId.create("exponent_distribution_load_peaks_along_lines_of_contact_iso_10300_2014", RexsStandardUnitIds.none);

	/** Further extrapolate slope from long life range beyond point L (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId extrapolate_slope_long_life_beyond_long_life = RexsAttributeId.create("extrapolate_slope_long_life_beyond_long_life", RexsStandardUnitIds.none);

	/** Face angle (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId face_angle = RexsAttributeId.create("face_angle", RexsStandardUnitIds.deg);

	/** Face apex beyond crossing point (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId face_apex_beyond_crossing_point = RexsAttributeId.create("face_apex_beyond_crossing_point", RexsStandardUnitIds.mm);

	/** Face load factor flank (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId face_load_factor_flank = RexsAttributeId.create("face_load_factor_flank", RexsStandardUnitIds.none);

	/** Face load factor flank (DIN 3990 1987) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId face_load_factor_flank_din_3990_1987 = RexsAttributeId.create("face_load_factor_flank_din_3990_1987", RexsStandardUnitIds.none);

	/** Face load factor (ISO 6336 2006) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId face_load_factor_flank_iso_6336_2006 = RexsAttributeId.create("face_load_factor_flank_iso_6336_2006", RexsStandardUnitIds.none);

	/** Face load factor root (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId face_load_factor_root = RexsAttributeId.create("face_load_factor_root", RexsStandardUnitIds.none);

	/** Face width (Versions: 1.0, 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId face_width = RexsAttributeId.create("face_width", RexsStandardUnitIds.mm);

	/** Face width (DIN 3975 2017) (Versions: 1.2) */
	RexsAttributeId face_width_din_3975_2017 = RexsAttributeId.create("face_width_din_3975_2017", RexsStandardUnitIds.mm);

	/** Face width factor (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId face_width_factor_iso_10300_2014 = RexsAttributeId.create("face_width_factor_iso_10300_2014", RexsStandardUnitIds.none);

	/** Face width of virtual cylindrical gear pair (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId face_width_virtual_cylindrical_gear_iso_10300_2014 = RexsAttributeId.create("face_width_virtual_cylindrical_gear_iso_10300_2014", RexsStandardUnitIds.mm);

	/** Face width (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId face_width_worm_wheel = RexsAttributeId.create("face_width_worm_wheel", RexsStandardUnitIds.mm);

	/** End of usable face width (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId facewidth_usable_end = RexsAttributeId.create("facewidth_usable_end", RexsStandardUnitIds.mm);

	/** Start of usable face width (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId facewidth_usable_start = RexsAttributeId.create("facewidth_usable_start", RexsStandardUnitIds.mm);

	/** Factor c for calculating dynamic viscosity (AGMA 925 A03) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId factor_c_for_calculating_dynamic_viscosity_at_gear_tooth_temperature_agma_925_a03 = RexsAttributeId.create("factor_c_for_calculating_dynamic_viscosity_at_gear_tooth_temperature_agma_925_a03", RexsStandardUnitIds.none);

	/** Factor d for calculating dynamic viscosity (AGMA 925 A03) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId factor_d_for_calculating_dynamic_viscosity_at_gear_tooth_temperature_agma_925_a03 = RexsAttributeId.create("factor_d_for_calculating_dynamic_viscosity_at_gear_tooth_temperature_agma_925_a03", RexsStandardUnitIds.none);

	/** Factor for tooth flank loading (VDI 2736 2014) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId factor_for_tooth_flank_loading_vdi_2736_2014 = RexsAttributeId.create("factor_for_tooth_flank_loading_vdi_2736_2014", RexsStandardUnitIds.none);

	/** Factor for tooth root loading (VDI 2736 2014) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId factor_for_tooth_root_loading_vdi_2736_2014 = RexsAttributeId.create("factor_for_tooth_root_loading_vdi_2736_2014", RexsStandardUnitIds.none);

	/** Calculation factor k (Plewe 1980) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId factor_k_plewe_1980 = RexsAttributeId.create("factor_k_plewe_1980", RexsStandardUnitIds.none);

	/** Bending stress amplitude of the fatigue strength for a specific mean stress (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId fatigue_bending_strength_din_743_2012 = RexsAttributeId.create("fatigue_bending_strength_din_743_2012", RexsStandardUnitIds.newton_per_mm2);

	/** Fatigue limit under reversed bending stress (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId fatigue_limit_bending = RexsAttributeId.create("fatigue_limit_bending", RexsStandardUnitIds.mega_pascal);

	/** Compression-tension fatigue limit (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId fatigue_limit_compression_tension = RexsAttributeId.create("fatigue_limit_compression_tension", RexsStandardUnitIds.mega_pascal);

	/** Fatigue limit load (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId fatigue_limit_load = RexsAttributeId.create("fatigue_limit_load", RexsStandardUnitIds.kilo_newton);

	/** Fatigue limit under reversed torsional stress (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId fatigue_limit_torsion = RexsAttributeId.create("fatigue_limit_torsion", RexsStandardUnitIds.mega_pascal);

	/** Fatigue strength factor for compression (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId fatigue_strength_factor_compression = RexsAttributeId.create("fatigue_strength_factor_compression", RexsStandardUnitIds.none);

	/** Fatigue strength factor for shear (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId fatigue_strength_factor_shear = RexsAttributeId.create("fatigue_strength_factor_shear", RexsStandardUnitIds.none);

	/** Fatigue strength under pulsating stress (VDI 2736 2014) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId fatigue_strength_under_pulsating_stress_vdi_2736_2014 = RexsAttributeId.create("fatigue_strength_under_pulsating_stress_vdi_2736_2014", RexsStandardUnitIds.newton_per_mm2);

	/** Tension/ compression stress amplitude of the fatigue strength for a specific mean stress (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId fatigue_tensile_strength_din_743_2012 = RexsAttributeId.create("fatigue_tensile_strength_din_743_2012", RexsStandardUnitIds.newton_per_mm2);

	/** Torsional stress amplitude of the component fatigue strength for a specific mean stress (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId fatigue_torsion_strength_din_743_2012 = RexsAttributeId.create("fatigue_torsion_strength_din_743_2012", RexsStandardUnitIds.newton_per_mm2);

	/** Lubricant feed pressure (Versions: 1.6) */
	RexsAttributeId feed_pressure_plain_bearing = RexsAttributeId.create("feed_pressure_plain_bearing", RexsStandardUnitIds.newton_per_mm2);

	/** FEM format used (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId fem_file_format = RexsAttributeId.create("fem_file_format", RexsStandardUnitIds.none);

	/** Fill ratio plain bearing feature (Versions: 1.6) */
	RexsAttributeId fill_ratio_plain_bearing_feature = RexsAttributeId.create("fill_ratio_plain_bearing_feature", RexsStandardUnitIds.none);

	/** Filter cutoff of wavelength (AGMA 925 C95) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId filter_cutoff_of_wavelength_agma_925_a03 = RexsAttributeId.create("filter_cutoff_of_wavelength_agma_925_a03", RexsStandardUnitIds.mm);

	/** Fitting distance (DIN 7190 2017) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId fitting_distance_din_7190_2017 = RexsAttributeId.create("fitting_distance_din_7190_2017", RexsStandardUnitIds.mm);

	/** Flag designation addendum modification (profile shift) (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId flag_designation_addendum_modification = RexsAttributeId.create("flag_designation_addendum_modification", RexsStandardUnitIds.none);

	/** Flank form (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId flank_form = RexsAttributeId.create("flank_form", RexsStandardUnitIds.none);

	/** Flank form (DIN 3975 2017) (Versions: 1.2) */
	RexsAttributeId flank_form_din_3975_2017 = RexsAttributeId.create("flank_form_din_3975_2017", RexsStandardUnitIds.none);

	/** Flank loss from wheel in the normal section (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId flank_loss_from_wheel_in_normal_section_din_3996_2019 = RexsAttributeId.create("flank_loss_from_wheel_in_normal_section_din_3996_2019", RexsStandardUnitIds.mm);

	/** Hertzian flank stress (VDI 2736 2014) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId flank_pressure_vdi_2736_2014 = RexsAttributeId.create("flank_pressure_vdi_2736_2014", RexsStandardUnitIds.newton_per_mm2);

	/** Flank surface (DIN 3996 2019) (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId flank_surface_din_3996_2019 = RexsAttributeId.create("flank_surface_din_3996_2019", RexsStandardUnitIds.mm2);

	/** Flank surface (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId flank_surface_ltca = RexsAttributeId.create("flank_surface_ltca", RexsStandardUnitIds.mm2);

	/** Flank temperature characteristic (VDI 2736 2014) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId flank_temperature_characteristic_vdi_2736_2014 = RexsAttributeId.create("flank_temperature_characteristic_vdi_2736_2014", RexsStandardUnitIds.degree_celsius);

	/** Flash temperature at contact point Y (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId flash_temperature_iso_10300_2021 = RexsAttributeId.create("flash_temperature_iso_10300_2021", RexsStandardUnitIds.degree_celsius);

	/** Flash temperature at the calculation points (AGMA 925 A03) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId flash_temperature_of_calculation_points_agma_925_a03 = RexsAttributeId.create("flash_temperature_of_calculation_points_agma_925_a03", RexsStandardUnitIds.degree_celsius);

	/** Folder name (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId folder = RexsAttributeId.create("folder", RexsStandardUnitIds.none);

	/** Force in u-direction acting on the component on the inner side (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId force_acting_on_inner_component_u = RexsAttributeId.create("force_acting_on_inner_component_u", RexsStandardUnitIds.newton);

	/** Force in v-direction acting on the component on the inner side (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId force_acting_on_inner_component_v = RexsAttributeId.create("force_acting_on_inner_component_v", RexsStandardUnitIds.newton);

	/** Force in w-direction acting on the component on the inner side (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId force_acting_on_inner_component_w = RexsAttributeId.create("force_acting_on_inner_component_w", RexsStandardUnitIds.newton);

	/** Force in u-direction acting on the component on the outer side (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId force_acting_on_outer_component_u = RexsAttributeId.create("force_acting_on_outer_component_u", RexsStandardUnitIds.newton);

	/** Force in v-direction acting on the component on the outer side (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId force_acting_on_outer_component_v = RexsAttributeId.create("force_acting_on_outer_component_v", RexsStandardUnitIds.newton);

	/** Force in w-direction acting on the component on the outer side (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId force_acting_on_outer_component_w = RexsAttributeId.create("force_acting_on_outer_component_w", RexsStandardUnitIds.newton);

	/** Force in u-direction acting on the shaft (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId force_acting_on_shaft_u = RexsAttributeId.create("force_acting_on_shaft_u", RexsStandardUnitIds.newton);

	/** Force in v-direction acting on the shaft (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId force_acting_on_shaft_v = RexsAttributeId.create("force_acting_on_shaft_v", RexsStandardUnitIds.newton);

	/** Force in w-direction acting on the shaft (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId force_acting_on_shaft_w = RexsAttributeId.create("force_acting_on_shaft_w", RexsStandardUnitIds.newton);

	/** Axial force distribution in u-direction (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId force_distribution_u = RexsAttributeId.create("force_distribution_u", RexsStandardUnitIds.newton);

	/** Radial force distribution in v-direction (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId force_distribution_v = RexsAttributeId.create("force_distribution_v", RexsStandardUnitIds.newton);

	/** Radial force distribution in w-direction (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId force_distribution_w = RexsAttributeId.create("force_distribution_w", RexsStandardUnitIds.newton);

	/** Force in u-direction (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId force_u_direction = RexsAttributeId.create("force_u_direction", RexsStandardUnitIds.newton);

	/** Force in v-direction (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId force_v_direction = RexsAttributeId.create("force_v_direction", RexsStandardUnitIds.newton);

	/** Force in w-direction (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId force_w_direction = RexsAttributeId.create("force_w_direction", RexsStandardUnitIds.newton);

	/** Form allowance (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId form_allowance = RexsAttributeId.create("form_allowance", RexsStandardUnitIds.mm);

	/** Form factor bending (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId form_factor_bending_din_743_2012 = RexsAttributeId.create("form_factor_bending_din_743_2012", RexsStandardUnitIds.none);

	/** Form factor (DIN 3975 2017) (Versions: 1.2) */
	RexsAttributeId form_factor_din_3975_2017 = RexsAttributeId.create("form_factor_din_3975_2017", RexsStandardUnitIds.none);

	/** Form factor tension/ compression (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId form_factor_tension_compression_din_743_2012 = RexsAttributeId.create("form_factor_tension_compression_din_743_2012", RexsStandardUnitIds.none);

	/** Form factor (tooth bending) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId form_factor_tooth_bending_din_3996_2019 = RexsAttributeId.create("form_factor_tooth_bending_din_3996_2019", RexsStandardUnitIds.none);

	/** Form factor (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId form_factor_tooth_root_iso_10300_2014 = RexsAttributeId.create("form_factor_tooth_root_iso_10300_2014", RexsStandardUnitIds.none);

	/** Form factor torsion (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId form_factor_torsion_din_743_2012 = RexsAttributeId.create("form_factor_torsion_din_743_2012", RexsStandardUnitIds.none);

	/** Form factor (VDI 2736 2014) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId form_factor_vdi_2736_2014 = RexsAttributeId.create("form_factor_vdi_2736_2014", RexsStandardUnitIds.none);

	/** Form factor (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId form_factor_worm_gear = RexsAttributeId.create("form_factor_worm_gear", RexsStandardUnitIds.none);

	/** Friction connection factor at equivalent load (DIN 6892 2012) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId friction_connection_factor_at_equivalent_load_din_6892_2012 = RexsAttributeId.create("friction_connection_factor_at_equivalent_load_din_6892_2012", RexsStandardUnitIds.none);

	/** Friction connection factor at maximum load (DIN 6892 2012) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId friction_connection_factor_at_maximum_load_din_6892_2012 = RexsAttributeId.create("friction_connection_factor_at_maximum_load_din_6892_2012", RexsStandardUnitIds.none);

	/** GDE file (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId gde_file = RexsAttributeId.create("gde_file", RexsStandardUnitIds.none);

	/** Gear body rim thickness (Versions: 1.6) */
	RexsAttributeId gear_body_rim_thickness = RexsAttributeId.create("gear_body_rim_thickness", RexsStandardUnitIds.mm);

	/** Gear body web thickness (Versions: 1.6) */
	RexsAttributeId gear_body_web_thickness = RexsAttributeId.create("gear_body_web_thickness", RexsStandardUnitIds.mm);

	/** Gear efficiency in increaser (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId gear_efficiency_in_increaser_din_3996_2019 = RexsAttributeId.create("gear_efficiency_in_increaser_din_3996_2019", RexsStandardUnitIds.none);

	/** Gear efficiency in reducer (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId gear_efficiency_in_reducer_din_3996_2019 = RexsAttributeId.create("gear_efficiency_in_reducer_din_3996_2019", RexsStandardUnitIds.none);

	/** Gear ratio (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId gear_ratio = RexsAttributeId.create("gear_ratio", RexsStandardUnitIds.none);

	/** Gear ratio factor (pitting) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId gear_ratio_factor_pitting_din_3996_2019 = RexsAttributeId.create("gear_ratio_factor_pitting_din_3996_2019", RexsStandardUnitIds.none);

	/** Gear shift index (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId gear_shift_index = RexsAttributeId.create("gear_shift_index", RexsStandardUnitIds.none);

	/** Generated addendum modification coefficient (profile shift coefficient) (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId generated_addendum_modification_coefficient = RexsAttributeId.create("generated_addendum_modification_coefficient", RexsStandardUnitIds.none);

	/** Generated addendum modification coefficient (profile shift coefficient) (lower deviation) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId generated_addendum_modification_coefficient_lower_deviation = RexsAttributeId.create("generated_addendum_modification_coefficient_lower_deviation", RexsStandardUnitIds.none);

	/** Generated addendum modification coefficient (profile shift coefficient) (upper deviation) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId generated_addendum_modification_coefficient_upper_deviation = RexsAttributeId.create("generated_addendum_modification_coefficient_upper_deviation", RexsStandardUnitIds.none);

	/** Center distance in generating train (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId generated_center_distance = RexsAttributeId.create("generated_center_distance", RexsStandardUnitIds.mm);

	/** Generated pressure angle on coast side (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId generated_pressure_angle_coast = RexsAttributeId.create("generated_pressure_angle_coast", RexsStandardUnitIds.deg);

	/** Generated pressure angle on drive side (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId generated_pressure_angle_drive = RexsAttributeId.create("generated_pressure_angle_drive", RexsStandardUnitIds.deg);

	/** Geometrical size factor bending (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId geometrical_size_factor_bending_din_743_2012 = RexsAttributeId.create("geometrical_size_factor_bending_din_743_2012", RexsStandardUnitIds.none);

	/** Geometrical size factor tension/ compression (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId geometrical_size_factor_tension_compression_din_743_2012 = RexsAttributeId.create("geometrical_size_factor_tension_compression_din_743_2012", RexsStandardUnitIds.none);

	/** Geometrical size factor torsion (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId geometrical_size_factor_torsion_din_743_2012 = RexsAttributeId.create("geometrical_size_factor_torsion_din_743_2012", RexsStandardUnitIds.none);

	/** Geometry refers to (Versions: 1.0) */
	RexsAttributeId geometry_refers_to = RexsAttributeId.create("geometry_refers_to", RexsStandardUnitIds.none);

	/** Gravitational acceleration (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId gravitational_acceleration = RexsAttributeId.create("gravitational_acceleration", RexsStandardUnitIds.m_per_s2);

	/** Grinding allowance (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId grinding_allowance = RexsAttributeId.create("grinding_allowance", RexsStandardUnitIds.mm);

	/** Grinding disk diameter (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId grinding_disk_diameter = RexsAttributeId.create("grinding_disk_diameter", RexsStandardUnitIds.mm);

	/** Half length of contact area (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId half_length_of_contact_area = RexsAttributeId.create("half_length_of_contact_area", RexsStandardUnitIds.mm);

	/** Half width of contact area (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId half_width_of_contact_area = RexsAttributeId.create("half_width_of_contact_area", RexsStandardUnitIds.mm);

	/** Hardness conversion factor (ISO 6336 2019) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId hardness_conversion_factor_iso_6336_2019 = RexsAttributeId.create("hardness_conversion_factor_iso_6336_2019", RexsStandardUnitIds.none);

	/** Bearing has an inner ring (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId has_inner_ring = RexsAttributeId.create("has_inner_ring", RexsStandardUnitIds.none);

	/** Bearing has an outer ring (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId has_outer_ring = RexsAttributeId.create("has_outer_ring", RexsStandardUnitIds.none);

	/** Heat-dissipating surface (VDI 2736 2014) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId heat_dissipating_surface_vdi_2736_2014 = RexsAttributeId.create("heat_dissipating_surface_vdi_2736_2014", RexsStandardUnitIds.m2);

	/** Heat transfer coefficient at the surface of the bearing seat (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId heat_transfer_coefficient_at_bearing_seat = RexsAttributeId.create("heat_transfer_coefficient_at_bearing_seat", RexsStandardUnitIds.watt_per_mm);

	/** Axial heat transfer coefficient between journal and environment (front) (Versions: 1.6) */
	RexsAttributeId heat_transfer_coefficient_at_journal_front_plain_bearing = RexsAttributeId.create("heat_transfer_coefficient_at_journal_front_plain_bearing", RexsStandardUnitIds.unit_60);

	/** Axial heat transfer coefficient between journal and environment (rear) (Versions: 1.6) */
	RexsAttributeId heat_transfer_coefficient_at_journal_rear_plain_bearing = RexsAttributeId.create("heat_transfer_coefficient_at_journal_rear_plain_bearing", RexsStandardUnitIds.unit_60);

	/** Axial heat transfer coefficient between bearing shell and environment (front) (Versions: 1.6) */
	RexsAttributeId heat_transfer_coefficient_front_plain_bearing = RexsAttributeId.create("heat_transfer_coefficient_front_plain_bearing", RexsStandardUnitIds.unit_60);

	/** Plastic gear flank heat transfer coefficient (VDI 2736 2014) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId heat_transfer_coefficient_plastic_flank_vdi_2736_2014 = RexsAttributeId.create("heat_transfer_coefficient_plastic_flank_vdi_2736_2014", RexsStandardUnitIds.heat_transfer_coefficient_vdi2736);

	/** Plastic gear root heat transfer coefficient  (VDI 2736 2014) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId heat_transfer_coefficient_plastic_root_vdi_2736_2014 = RexsAttributeId.create("heat_transfer_coefficient_plastic_root_vdi_2736_2014", RexsStandardUnitIds.heat_transfer_coefficient_vdi2736);

	/** Radial heat transfer coefficient between bearing shell and environment (Versions: 1.6) */
	RexsAttributeId heat_transfer_coefficient_radial_plain_bearing = RexsAttributeId.create("heat_transfer_coefficient_radial_plain_bearing", RexsStandardUnitIds.unit_60);

	/** Axial heat transfer coefficient between bearing shell and environment (rear) (Versions: 1.6) */
	RexsAttributeId heat_transfer_coefficient_rear_plain_bearing = RexsAttributeId.create("heat_transfer_coefficient_rear_plain_bearing", RexsStandardUnitIds.unit_60);

	/** Heat transfer resistance (VDI 2736 2014) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId heat_transfer_resistance_vdi_2736_2014 = RexsAttributeId.create("heat_transfer_resistance_vdi_2736_2014", RexsStandardUnitIds.kelvin_m2_per_watt);

	/** Heat treated material type (ISO 6336 2006) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId heat_treated_material_type_iso_6336_2006 = RexsAttributeId.create("heat_treated_material_type_iso_6336_2006", RexsStandardUnitIds.none);

	/** Height of feather key (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId height_of_feather_key = RexsAttributeId.create("height_of_feather_key", RexsStandardUnitIds.mm);

	/** Height over chordal tooth thickness (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId height_over_chordal_tooth_thickness = RexsAttributeId.create("height_over_chordal_tooth_thickness", RexsStandardUnitIds.mm);

	/** Helical motion coefficients (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId helical_motion_coefficients = RexsAttributeId.create("helical_motion_coefficients", RexsStandardUnitIds.none);

	/** Helix angle at the base circle (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId helix_angle_base_circle = RexsAttributeId.create("helix_angle_base_circle", RexsStandardUnitIds.deg);

	/** Helix angle factor (VDI 2736 2014) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId helix_angle_factor_vdi_2736_2014 = RexsAttributeId.create("helix_angle_factor_vdi_2736_2014", RexsStandardUnitIds.none);

	/** Helix angle at reference circle (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId helix_angle_reference_diameter = RexsAttributeId.create("helix_angle_reference_diameter", RexsStandardUnitIds.deg);

	/** Amount of helix crowning at datum face (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId helix_crowning_amount_datum_face = RexsAttributeId.create("helix_crowning_amount_datum_face", RexsStandardUnitIds.mm);

	/** Amount of helix crowning at non-datum face (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId helix_crowning_amount_non_datum_face = RexsAttributeId.create("helix_crowning_amount_non_datum_face", RexsStandardUnitIds.mm);

	/** Amount of helix deviations (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId helix_deviation_amounts = RexsAttributeId.create("helix_deviation_amounts", RexsStandardUnitIds.mm);

	/** End of helix evaluation (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId helix_evaluation_end = RexsAttributeId.create("helix_evaluation_end", RexsStandardUnitIds.mm);

	/** Reference length of helix modification (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId helix_evaluation_reference = RexsAttributeId.create("helix_evaluation_reference", RexsStandardUnitIds.none);

	/** Begin of helix evaluation (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId helix_evaluation_start = RexsAttributeId.create("helix_evaluation_start", RexsStandardUnitIds.mm);

	/** Location of the highest point in the helix crowning (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId helix_highest_point = RexsAttributeId.create("helix_highest_point", RexsStandardUnitIds.mm);

	/** Amount of helix slope modification (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId helix_slope = RexsAttributeId.create("helix_slope", RexsStandardUnitIds.mm);

	/** Hertzian flank pressure under test conditions (Plewe 1980) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId hertzian_flank_pressure_under_test_conditions_plewe_1980 = RexsAttributeId.create("hertzian_flank_pressure_under_test_conditions_plewe_1980", RexsStandardUnitIds.newton_per_mm2);

	/** Hobbing procedure (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId hobbing_procedure = RexsAttributeId.create("hobbing_procedure", RexsStandardUnitIds.none);

	/** Horizontal distance (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId horizontal_distance = RexsAttributeId.create("horizontal_distance", RexsStandardUnitIds.mm);

	/** Horizontal motion coefficients (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId horizontal_motion_coefficients = RexsAttributeId.create("horizontal_motion_coefficients", RexsStandardUnitIds.none);

	/** Hub safety against plastic deformation at equivalent torque (DIN 6892 2012) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId hub_safety_plastic_deformation_equivalent_torque_din_6892_2012 = RexsAttributeId.create("hub_safety_plastic_deformation_equivalent_torque_din_6892_2012", RexsStandardUnitIds.none);

	/** Hub safety against plastic deformation at maximum torque (DIN 6892 2012) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId hub_safety_plastic_deformation_maximum_torque_din_6892_2012 = RexsAttributeId.create("hub_safety_plastic_deformation_maximum_torque_din_6892_2012", RexsStandardUnitIds.none);

	/** Hypoid factor pitting (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId hypoid_factor_pitting_iso_10300_2014 = RexsAttributeId.create("hypoid_factor_pitting_iso_10300_2014", RexsStandardUnitIds.none);

	/** Hypoid offset (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId hypoid_offset = RexsAttributeId.create("hypoid_offset", RexsStandardUnitIds.mm);

	/** Offset of inclination angle (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId inclination_angle_offset = RexsAttributeId.create("inclination_angle_offset", RexsStandardUnitIds.deg);

	/** Inclination exponent of the S-N curve in limited life (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId inclination_exponent_in_limited_life = RexsAttributeId.create("inclination_exponent_in_limited_life", RexsStandardUnitIds.none);

	/** Inclination exponent of the S-N curve in long life (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId inclination_exponent_in_long_life = RexsAttributeId.create("inclination_exponent_in_long_life", RexsStandardUnitIds.none);

	/** Increase factor yield strength bending (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId increase_factor_yield_strength_bending_din_743_2012 = RexsAttributeId.create("increase_factor_yield_strength_bending_din_743_2012", RexsStandardUnitIds.none);

	/** Increase factor yield strength tension/ compression (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId increase_factor_yield_strength_tension_compression_din_743_2012 = RexsAttributeId.create("increase_factor_yield_strength_tension_compression_din_743_2012", RexsStandardUnitIds.none);

	/** Increase factor yield strength torsion (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId increase_factor_yield_strength_torsion_din_743_2012 = RexsAttributeId.create("increase_factor_yield_strength_torsion_din_743_2012", RexsStandardUnitIds.none);

	/** Inertia factor for bending stress (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId inertia_factor_bending_iso_10300_2014 = RexsAttributeId.create("inertia_factor_bending_iso_10300_2014", RexsStandardUnitIds.none);

	/** Preload force (Versions: 1.0) */
	RexsAttributeId initial_load = RexsAttributeId.create("initial_load", RexsStandardUnitIds.newton);

	/** Preload distance (Versions: 1.0) */
	RexsAttributeId initial_load_shift = RexsAttributeId.create("initial_load_shift", RexsStandardUnitIds.mum);

	/** Inner cone distance (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId inner_cone_distance = RexsAttributeId.create("inner_cone_distance", RexsStandardUnitIds.mm);

	/** Inner diameter (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId inner_diameter = RexsAttributeId.create("inner_diameter", RexsStandardUnitIds.mm);

	/** Inner diameter begin (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId inner_diameter_begin = RexsAttributeId.create("inner_diameter_begin", RexsStandardUnitIds.mm);

	/** Inner diameter end (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId inner_diameter_end = RexsAttributeId.create("inner_diameter_end", RexsStandardUnitIds.mm);

	/** Inner diameter of shaft (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId inner_diameter_shaft_din_7190_2017 = RexsAttributeId.create("inner_diameter_shaft_din_7190_2017", RexsStandardUnitIds.mm);

	/** Inner pitch diameter (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId inner_pitch_diameter = RexsAttributeId.create("inner_pitch_diameter", RexsStandardUnitIds.mm);

	/** Interference (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId interference = RexsAttributeId.create("interference", RexsStandardUnitIds.mm);

	/** Offset of intersection angle (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId intersection_angle_offset = RexsAttributeId.create("intersection_angle_offset", RexsStandardUnitIds.deg);

	/** Modification is additive (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId is_additive_modification = RexsAttributeId.create("is_additive_modification", RexsStandardUnitIds.none);

	/** Adequate gear tip profile modification (ISO 6336 2019) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId is_adequate_profile_modfication_iso_6336_2019 = RexsAttributeId.create("is_adequate_profile_modfication_iso_6336_2019", RexsStandardUnitIds.none);

	/** Is driving gear (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId is_driving_gear = RexsAttributeId.create("is_driving_gear", RexsStandardUnitIds.none);

	/** Is engaged (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId is_engaged = RexsAttributeId.create("is_engaged", RexsStandardUnitIds.none);

	/** Isothermal calculation (Versions: 1.6) */
	RexsAttributeId is_isothermal_calculation = RexsAttributeId.create("is_isothermal_calculation", RexsStandardUnitIds.none);

	/** Is loading proportional (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId is_loading_proportional_fkm_2012 = RexsAttributeId.create("is_loading_proportional_fkm_2012", RexsStandardUnitIds.none);

	/** Is austenitic and solution-annealed material (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId is_material_austenitic_and_solution_annealed_fkm_2012 = RexsAttributeId.create("is_material_austenitic_and_solution_annealed_fkm_2012", RexsStandardUnitIds.none);

	/** Is austenitic steel (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId is_material_austenitic_steel_fkm_2012 = RexsAttributeId.create("is_material_austenitic_steel_fkm_2012", RexsStandardUnitIds.none);

	/** Is hardable material (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId is_material_hardable_fkm_2012 = RexsAttributeId.create("is_material_hardable_fkm_2012", RexsStandardUnitIds.none);

	/** Is polished (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId is_polished_fkm_2012 = RexsAttributeId.create("is_polished_fkm_2012", RexsStandardUnitIds.none);

	/** Is pressurized (Versions: 1.6) */
	RexsAttributeId is_pressurized = RexsAttributeId.create("is_pressurized", RexsStandardUnitIds.none);

	/** Joining clearance (DIN 7190 2017) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId joining_clearance_din_7190_2017 = RexsAttributeId.create("joining_clearance_din_7190_2017", RexsStandardUnitIds.mum);

	/** Joint diameter of joint section (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId joint_diameter_din_7190_2017 = RexsAttributeId.create("joint_diameter_din_7190_2017", RexsStandardUnitIds.mm);

	/** Joint pressure (DIN 7190 2017) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId joint_section_pressure_din_7190_2017 = RexsAttributeId.create("joint_section_pressure_din_7190_2017", RexsStandardUnitIds.newton_per_mm2);

	/** Feather key safety against plastic deformation at equivalent torque (DIN 6892 2012) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId key_safety_plastic_deformation_equivalent_torque_din_6892_2012 = RexsAttributeId.create("key_safety_plastic_deformation_equivalent_torque_din_6892_2012", RexsStandardUnitIds.none);

	/** Feather key safety against plastic deformation at maximum torque (DIN 6892 2012) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId key_safety_plastic_deformation_maximum_torque_din_6892_2012 = RexsAttributeId.create("key_safety_plastic_deformation_maximum_torque_din_6892_2012", RexsStandardUnitIds.none);

	/** Keyway base radius (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId keyway_base_radius = RexsAttributeId.create("keyway_base_radius", RexsStandardUnitIds.mm);

	/** Kind of lubricant (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId kind = RexsAttributeId.create("kind", RexsStandardUnitIds.none);

	/** Kind of point list (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId kind_of_point_list = RexsAttributeId.create("kind_of_point_list", RexsStandardUnitIds.none);

	/** Kinematic viscosity of the lubricant at ambient pressure and mass temperature (Plewe 1980) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId kinematic_viscosity_of_the_lubricant_at_ambient_pressure_and_mass_temperature_plewe_1980 = RexsAttributeId.create("kinematic_viscosity_of_the_lubricant_at_ambient_pressure_and_mass_temperature_plewe_1980", RexsStandardUnitIds.mm2_per_s);

	/** Klingelnberg 3d neutral data file (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId klingelnberg_3d_neutral_data_file = RexsAttributeId.create("klingelnberg_3d_neutral_data_file", RexsStandardUnitIds.none);

	/** Klingelnberg neutral data file (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId klingelnberg_neutral_data_file = RexsAttributeId.create("klingelnberg_neutral_data_file", RexsStandardUnitIds.none);

	/** Large outer diameter with shouldered hub (DIN 6892 2012) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId large_outer_diameter_shouldered_hub_din_6892_2012 = RexsAttributeId.create("large_outer_diameter_shouldered_hub_din_6892_2012", RexsStandardUnitIds.mm);

	/** Lead (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId lead = RexsAttributeId.create("lead", RexsStandardUnitIds.mm);

	/** Reference lead angle (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId lead_angle_worm_gear = RexsAttributeId.create("lead_angle_worm_gear", RexsStandardUnitIds.deg);

	/** Lead (DIN 3975 2017) (Versions: 1.2) */
	RexsAttributeId lead_din_3975_2017 = RexsAttributeId.create("lead_din_3975_2017", RexsStandardUnitIds.mm);

	/** Lead factor (tooth bending) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId lead_factor_tooth_bending_din_3996_2019 = RexsAttributeId.create("lead_factor_tooth_bending_din_3996_2019", RexsStandardUnitIds.none);

	/** Length (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId length = RexsAttributeId.create("length", RexsStandardUnitIds.mm);

	/** Length of feather key (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId length_of_feather_key = RexsAttributeId.create("length_of_feather_key", RexsStandardUnitIds.mm);

	/** Length of joint section (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId length_of_joint_section_din_7190_2017 = RexsAttributeId.create("length_of_joint_section_din_7190_2017", RexsStandardUnitIds.mm);

	/** Length of the key chamfer (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId length_of_key_chamfer = RexsAttributeId.create("length_of_key_chamfer", RexsStandardUnitIds.mm);

	/** Length of path of contact (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId length_of_path_of_contact = RexsAttributeId.create("length_of_path_of_contact", RexsStandardUnitIds.mm);

	/** Length of profile deviations (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId length_of_profile_deviation = RexsAttributeId.create("length_of_profile_deviation", RexsStandardUnitIds.mm);

	/** Length of rolling element (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId length_of_rolling_element = RexsAttributeId.create("length_of_rolling_element", RexsStandardUnitIds.mm);

	/** Length of tip path of contact (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId length_of_tip_path_of_contact = RexsAttributeId.create("length_of_tip_path_of_contact", RexsStandardUnitIds.mm);

	/** Length  of topographical modification (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId length_of_topographical_modification = RexsAttributeId.create("length_of_topographical_modification", RexsStandardUnitIds.mm);

	/** Length where amount of profile crowning at the rootis specified (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId length_where_profile_crowning_root_is_specified = RexsAttributeId.create("length_where_profile_crowning_root_is_specified", RexsStandardUnitIds.mm);

	/** Length where amount of profile crowning at the tip is specified (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId length_where_profile_crowning_tip_is_specified = RexsAttributeId.create("length_where_profile_crowning_tip_is_specified", RexsStandardUnitIds.mm);

	/** Length of worm gear (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId length_worm_gear = RexsAttributeId.create("length_worm_gear", RexsStandardUnitIds.mm);

	/** Lengthwise curvature factor (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId lengthwise_curvature_factor_tooth_root_iso_10300_2014 = RexsAttributeId.create("lengthwise_curvature_factor_tooth_root_iso_10300_2014", RexsStandardUnitIds.none);

	/** Level of detail (Versions: 1.6) */
	RexsAttributeId level_of_detail = RexsAttributeId.create("level_of_detail", RexsStandardUnitIds.none);

	/** Lever of axial force on cylindrical roller bearings (Versions: 1.0) */
	RexsAttributeId lever_arm_of_axial_force = RexsAttributeId.create("lever_arm_of_axial_force", RexsStandardUnitIds.none);

	/** Life factor (pitting) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId life_factor_pitting_din_3996_2019 = RexsAttributeId.create("life_factor_pitting_din_3996_2019", RexsStandardUnitIds.none);

	/** Life factor pitting (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId life_factor_pitting_iso_10300_2014 = RexsAttributeId.create("life_factor_pitting_iso_10300_2014", RexsStandardUnitIds.none);

	/** Life factor (tooth bending) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId life_factor_tooth_bending_din_3996_2019 = RexsAttributeId.create("life_factor_tooth_bending_din_3996_2019", RexsStandardUnitIds.none);

	/** Life factor tooth root (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId life_factor_tooth_root_iso_10300_2014 = RexsAttributeId.create("life_factor_tooth_root_iso_10300_2014", RexsStandardUnitIds.none);

	/** Life modification factor for reliability ISO 281 2007 (Versions: 1.6) */
	RexsAttributeId life_modification_factor_reliability_iso_281_2007 = RexsAttributeId.create("life_modification_factor_reliability_iso_281_2007", RexsStandardUnitIds.none);

	/** Effective life modification factor system approach ISO/TS 16281 2008 (Versions: 1.6) */
	RexsAttributeId life_modification_factor_system_approach_effective_iso_16281_2008 = RexsAttributeId.create("life_modification_factor_system_approach_effective_iso_16281_2008", RexsStandardUnitIds.none);

	/** Maximum life modification factor system approach ISO/TS 16281 2008 (Versions: 1.6) */
	RexsAttributeId life_modification_factor_system_approach_maximum_iso_16281_2008 = RexsAttributeId.create("life_modification_factor_system_approach_maximum_iso_16281_2008", RexsStandardUnitIds.none);

	/** Minimum life modification factor system approach ISO/TS 16281 2008 (Versions: 1.6) */
	RexsAttributeId life_modification_factor_system_approach_minimum_iso_16281_2008 = RexsAttributeId.create("life_modification_factor_system_approach_minimum_iso_16281_2008", RexsStandardUnitIds.none);

	/** Limit temperature according to standard scuffing tests (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId limit_temperature_standard_scuffing_test_iso_10300_2021 = RexsAttributeId.create("limit_temperature_standard_scuffing_test_iso_10300_2021", RexsStandardUnitIds.degree_celsius);

	/** Limiting speed (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId limiting_speed = RexsAttributeId.create("limiting_speed", RexsStandardUnitIds.rotation_per_min);

	/** Limiting value of flank loss (DIN 3996 2019) (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId limiting_value_flank_loss_din_3996_2019 = RexsAttributeId.create("limiting_value_flank_loss_din_3996_2019", RexsStandardUnitIds.mm);

	/** Linear wear coefficient under test conditions (Plewe 1980) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId linear_wear_coefficient_under_test_conditions_plewe_1980 = RexsAttributeId.create("linear_wear_coefficient_under_test_conditions_plewe_1980", RexsStandardUnitIds.mm);

	/** Load angle at tip (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId load_angle_at_tip = RexsAttributeId.create("load_angle_at_tip", RexsStandardUnitIds.deg);

	/** Load-bearing factor for equivalent load (DIN 6892 2012) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId load_bearing_factor_for_equivalent_load_din_6892_2012 = RexsAttributeId.create("load_bearing_factor_for_equivalent_load_din_6892_2012", RexsStandardUnitIds.none);

	/** Load-bearing factor for maximum load (DIN 6892 2012) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId load_bearing_factor_for_maximum_load_din_6892_2012 = RexsAttributeId.create("load_bearing_factor_for_maximum_load_din_6892_2012", RexsStandardUnitIds.none);

	/** Load carrying face width (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId load_carrying_face_width_vdi_2736_2014 = RexsAttributeId.create("load_carrying_face_width_vdi_2736_2014", RexsStandardUnitIds.mm);

	/** Load cycles dependent fatigue strength under pulsating stress (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId load_cycles_dependent_fatigue_strength_under_pulsating_stress = RexsAttributeId.create("load_cycles_dependent_fatigue_strength_under_pulsating_stress", RexsStandardUnitIds.newton_per_mm2);

	/** Load cycles dependent rolling contact fatigue strength (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId load_cycles_dependent_rolling_contact_fatigue_strength = RexsAttributeId.create("load_cycles_dependent_rolling_contact_fatigue_strength", RexsStandardUnitIds.newton_per_mm2);

	/** Load cycles variation for fatigue strength under pulsating stress (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId load_cycles_variation_for_fatigue_strength_under_pulsating_stress = RexsAttributeId.create("load_cycles_variation_for_fatigue_strength_under_pulsating_stress", RexsStandardUnitIds.none);

	/** Load cycles variation for rolling contact fatigue strength (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId load_cycles_variation_for_rolling_contact_fatigue_strength = RexsAttributeId.create("load_cycles_variation_for_rolling_contact_fatigue_strength", RexsStandardUnitIds.none);

	/** Load dependent power losses (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId load_dependent_power_losses_iso_10300_2021 = RexsAttributeId.create("load_dependent_power_losses_iso_10300_2021", RexsStandardUnitIds.kilo_watt);

	/** Load distribution along common face width (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId load_distribution_along_face_width = RexsAttributeId.create("load_distribution_along_face_width", RexsStandardUnitIds.newton_per_mm);

	/** Load distribution factor (AGMA 2101 C95) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId load_distribution_factor_agma_2101_c95 = RexsAttributeId.create("load_distribution_factor_agma_2101_c95", RexsStandardUnitIds.none);

	/** Load distribution factor (AGMA 925 C95) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId load_distribution_factor_agma_925_a03 = RexsAttributeId.create("load_distribution_factor_agma_925_a03", RexsStandardUnitIds.none);

	/** Load distribution factor (DIN 6892 2012) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId load_distribution_factor_din_6892_2012 = RexsAttributeId.create("load_distribution_factor_din_6892_2012", RexsStandardUnitIds.none);

	/** Node positions of load distribution along common face width (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId load_distribution_node_positions = RexsAttributeId.create("load_distribution_node_positions", RexsStandardUnitIds.mm);

	/** Load duration (Versions: 1.0, 1.1, 1.2) */
	RexsAttributeId load_duration = RexsAttributeId.create("load_duration", RexsStandardUnitIds.hour);

	/** Load duration fraction (Versions: 1.0, 1.1, 1.2) */
	RexsAttributeId load_duration_fraction = RexsAttributeId.create("load_duration_fraction", RexsStandardUnitIds.percent);

	/** Load parameter for central film thickness of calculation points (AGMA 925 A03) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId load_parameter_for_central_film_thickness_of_calculation_points_agma_925_a03 = RexsAttributeId.create("load_parameter_for_central_film_thickness_of_calculation_points_agma_925_a03", RexsStandardUnitIds.none);

	/** Load safety factor (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId load_safety_factor_fkm_2012 = RexsAttributeId.create("load_safety_factor_fkm_2012", RexsStandardUnitIds.none);

	/** Load sharing factor at contact point Y (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId load_sharing_factor_iso_10300_2021 = RexsAttributeId.create("load_sharing_factor_iso_10300_2021", RexsStandardUnitIds.none);

	/** Load sharing factor of calculation points (AGMA 925 A03) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId load_sharing_factor_of_calculation_points_agma_925_a03 = RexsAttributeId.create("load_sharing_factor_of_calculation_points_agma_925_a03", RexsStandardUnitIds.none);

	/** Load sharing factor pitting (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId load_sharing_factor_pitting_iso_10300_2014 = RexsAttributeId.create("load_sharing_factor_pitting_iso_10300_2014", RexsStandardUnitIds.none);

	/** Load sharing factor tooth root (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId load_sharing_factor_tooth_root_iso_10300_2014 = RexsAttributeId.create("load_sharing_factor_tooth_root_iso_10300_2014", RexsStandardUnitIds.none);

	/** Loaded tooth flank (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId loaded_tooth_flank = RexsAttributeId.create("loaded_tooth_flank", RexsStandardUnitIds.none);

	/** Local backlash under load (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId local_backlash_under_load = RexsAttributeId.create("local_backlash_under_load", RexsStandardUnitIds.mum);

	/** Local coefficient of friction (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId local_coefficient_of_friction = RexsAttributeId.create("local_coefficient_of_friction", RexsStandardUnitIds.none);

	/** Local contact distance (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId local_contact_distance = RexsAttributeId.create("local_contact_distance", RexsStandardUnitIds.mum);

	/** Local contact temperature at contact point Y (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId local_contact_temperature_iso_10300_2021 = RexsAttributeId.create("local_contact_temperature_iso_10300_2021", RexsStandardUnitIds.degree_celsius);

	/** Cyclic local degree of utilization in first principal stress direction (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId local_cyclic_degree_of_utilization_in_first_principle_stress_direction_fkm_2012 = RexsAttributeId.create("local_cyclic_degree_of_utilization_in_first_principle_stress_direction_fkm_2012", RexsStandardUnitIds.none);

	/** Cyclic local degree of utilization in second principal stress direction (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId local_cyclic_degree_of_utilization_in_second_principle_stress_direction_fkm_2012 = RexsAttributeId.create("local_cyclic_degree_of_utilization_in_second_principle_stress_direction_fkm_2012", RexsStandardUnitIds.none);

	/** Cyclic local degree of utilization in third principal stress direction (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId local_cyclic_degree_of_utilization_in_third_principle_stress_direction_fkm_2012 = RexsAttributeId.create("local_cyclic_degree_of_utilization_in_third_principle_stress_direction_fkm_2012", RexsStandardUnitIds.none);

	/** Cyclic local degree of utilization (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId local_cyclic_degree_of_utilization_of_all_loads_combined_fkm_2012 = RexsAttributeId.create("local_cyclic_degree_of_utilization_of_all_loads_combined_fkm_2012", RexsStandardUnitIds.none);

	/** Stress tensor of the cyclic load spectrum (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId local_cyclic_load_spectrum_stress_tensor_fkm_2012 = RexsAttributeId.create("local_cyclic_load_spectrum_stress_tensor_fkm_2012", RexsStandardUnitIds.mega_pascal);

	/** Cyclic local safety factor in first principal stress direction (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId local_cyclic_safety_factor_in_first_principle_stress_direction_fkm_2012 = RexsAttributeId.create("local_cyclic_safety_factor_in_first_principle_stress_direction_fkm_2012", RexsStandardUnitIds.none);

	/** Cyclic local safety factor in second principal stress direction (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId local_cyclic_safety_factor_in_second_principle_stress_direction_fkm_2012 = RexsAttributeId.create("local_cyclic_safety_factor_in_second_principle_stress_direction_fkm_2012", RexsStandardUnitIds.none);

	/** Cyclic local safety factor in third principal stress direction (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId local_cyclic_safety_factor_in_third_principle_stress_direction_fkm_2012 = RexsAttributeId.create("local_cyclic_safety_factor_in_third_principle_stress_direction_fkm_2012", RexsStandardUnitIds.none);

	/** Cyclic local safety factor (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId local_cyclic_safety_factor_of_all_loads_combined_fkm_2012 = RexsAttributeId.create("local_cyclic_safety_factor_of_all_loads_combined_fkm_2012", RexsStandardUnitIds.none);

	/** Distance between the two tensors passed to calculate the stress gradient (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId local_cyclic_stress_gradient_evaluation_points_distance_fkm_2012 = RexsAttributeId.create("local_cyclic_stress_gradient_evaluation_points_distance_fkm_2012", RexsStandardUnitIds.mm);

	/** Stress ratio of principle stresses in cyclic load spectrum (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId local_cyclic_stress_ratios_fkm_2012 = RexsAttributeId.create("local_cyclic_stress_ratios_fkm_2012", RexsStandardUnitIds.none);

	/** Stress tensor inside the component for stress gradient calculation (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId local_cyclic_stress_tensor_inside_component_for_stress_gradient_fkm_2012 = RexsAttributeId.create("local_cyclic_stress_tensor_inside_component_for_stress_gradient_fkm_2012", RexsStandardUnitIds.mega_pascal);

	/** Stress tensor at the component surface for stress gradient calculation (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId local_cyclic_stress_tensor_on_component_surface_for_stress_gradient_fkm_2012 = RexsAttributeId.create("local_cyclic_stress_tensor_on_component_surface_for_stress_gradient_fkm_2012", RexsStandardUnitIds.mega_pascal);

	/** Local flash temperature acc. Blok (1937) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId local_flash_temperature_blok_1937 = RexsAttributeId.create("local_flash_temperature_blok_1937", RexsStandardUnitIds.kelvin);

	/** Local Hertzian contact stress (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId local_hertzian_contact_stress = RexsAttributeId.create("local_hertzian_contact_stress", RexsStandardUnitIds.mega_pascal);

	/** Local  load-free backlash (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId local_load_free_backlash = RexsAttributeId.create("local_load_free_backlash", RexsStandardUnitIds.mum);

	/** Local normal line load (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId local_normal_line_load = RexsAttributeId.create("local_normal_line_load", RexsStandardUnitIds.newton_per_mm);

	/** Local relative lubricant film thickness (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId local_relative_lubricant_filmthickness = RexsAttributeId.create("local_relative_lubricant_filmthickness", RexsStandardUnitIds.none);

	/** Local root stress under peak torque (VDI 2736 2014) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId local_root_stress_under_peak_torque_vdi_2736_2014 = RexsAttributeId.create("local_root_stress_under_peak_torque_vdi_2736_2014", RexsStandardUnitIds.newton_per_mm2);

	/** Local safety factor for bending stress against breakage (FVA 411) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId local_safety_factor_bending_stress_fva_411 = RexsAttributeId.create("local_safety_factor_bending_stress_fva_411", RexsStandardUnitIds.none);

	/** Local safety factor for micro pitting  (FVA 516) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId local_safety_factor_micro_pitting_fva_516 = RexsAttributeId.create("local_safety_factor_micro_pitting_fva_516", RexsStandardUnitIds.none);

	/** Local safety factor for contact stress against pitting (FVA 411) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId local_safety_factor_pitting_fva_411 = RexsAttributeId.create("local_safety_factor_pitting_fva_411", RexsStandardUnitIds.none);

	/** Local safety factor for scuffing  (FVA 519) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId local_safety_factor_scuffing_fva_519 = RexsAttributeId.create("local_safety_factor_scuffing_fva_519", RexsStandardUnitIds.none);

	/** Local safety factor scuffing at contact point Y (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId local_safety_factor_scuffing_iso_10300_2021 = RexsAttributeId.create("local_safety_factor_scuffing_iso_10300_2021", RexsStandardUnitIds.none);

	/** Local sliding velocity (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId local_sliding_velocity = RexsAttributeId.create("local_sliding_velocity", RexsStandardUnitIds.m_per_second);

	/** Static local degree of utilization (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId local_static_degree_of_utilization_of_all_loads_combined_fkm_2012 = RexsAttributeId.create("local_static_degree_of_utilization_of_all_loads_combined_fkm_2012", RexsStandardUnitIds.none);

	/** Static local degree of utilization for high stress multiaxiality (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId local_static_degree_of_utilization_of_hydrostatic_stress_fkm_2012 = RexsAttributeId.create("local_static_degree_of_utilization_of_hydrostatic_stress_fkm_2012", RexsStandardUnitIds.none);

	/** Local limit load factor for the static strength calculation (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId local_static_limit_load_factor_fkm_2012 = RexsAttributeId.create("local_static_limit_load_factor_fkm_2012", RexsStandardUnitIds.none);

	/** Method for local limit load factor for the static strength calculation (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId local_static_limit_load_factor_mode_fkm_2012 = RexsAttributeId.create("local_static_limit_load_factor_mode_fkm_2012", RexsStandardUnitIds.none);

	/** Static local safety factor (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId local_static_safety_factor_of_all_loads_combined_fkm_2012 = RexsAttributeId.create("local_static_safety_factor_of_all_loads_combined_fkm_2012", RexsStandardUnitIds.none);

	/** Static local safety factor for high stress multiaxiality (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId local_static_safety_factor_of_hydrostatic_stress_fkm_2012 = RexsAttributeId.create("local_static_safety_factor_of_hydrostatic_stress_fkm_2012", RexsStandardUnitIds.none);

	/** Local stress tensor for the static strength calculation (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId local_static_stress_tensor_fkm_2012 = RexsAttributeId.create("local_static_stress_tensor_fkm_2012", RexsStandardUnitIds.mega_pascal);

	/** Local sum of damage related to pitting  (FVA 411) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId local_sum_of_damage_pitting_fva_411 = RexsAttributeId.create("local_sum_of_damage_pitting_fva_411", RexsStandardUnitIds.none);

	/** Local surface velocity (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId local_surface_velocity_iso_10300_2021 = RexsAttributeId.create("local_surface_velocity_iso_10300_2021", RexsStandardUnitIds.m_per_second);

	/** Local surface velocity in profile direction at contact point Y (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId local_surface_velocity_profile_direction_iso_10300_2021 = RexsAttributeId.create("local_surface_velocity_profile_direction_iso_10300_2021", RexsStandardUnitIds.m_per_second);

	/** Local tooth root stress (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId local_tooth_root_stress = RexsAttributeId.create("local_tooth_root_stress", RexsStandardUnitIds.mega_pascal);

	/** Local tooth root stress (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId local_tooth_root_stress_iso_10300_2014 = RexsAttributeId.create("local_tooth_root_stress_iso_10300_2014", RexsStandardUnitIds.newton_per_mm2);

	/** Longitudinal load factor pitting (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId longitudinal_load_factor_pitting_iso_10300_2014 = RexsAttributeId.create("longitudinal_load_factor_pitting_iso_10300_2014", RexsStandardUnitIds.none);

	/** Longitudinal load factor tooth root (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId longitudinal_load_factor_tooth_root_iso_10300_2014 = RexsAttributeId.create("longitudinal_load_factor_tooth_root_iso_10300_2014", RexsStandardUnitIds.none);

	/** Lower diametric deviation (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId lower_backlash_allowance_balls_or_pins = RexsAttributeId.create("lower_backlash_allowance_balls_or_pins", RexsStandardUnitIds.mm);

	/** Lower base tangent length deviation (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId lower_backlash_allowance_referenced_to_span = RexsAttributeId.create("lower_backlash_allowance_referenced_to_span", RexsStandardUnitIds.mum);

	/** Lower centre distance allowance (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId lower_center_distance_allowance = RexsAttributeId.create("lower_center_distance_allowance", RexsStandardUnitIds.mum);

	/** Lubricant factor (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId lubricant_factor_iso_10300_2021 = RexsAttributeId.create("lubricant_factor_iso_10300_2021", RexsStandardUnitIds.none);

	/** Lubricant factor (pitting) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId lubricant_factor_pitting_din_3996_2019 = RexsAttributeId.create("lubricant_factor_pitting_din_3996_2019", RexsStandardUnitIds.none);

	/** Lubricant factor (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId lubricant_factor_pitting_iso_10300_2014 = RexsAttributeId.create("lubricant_factor_pitting_iso_10300_2014", RexsStandardUnitIds.none);

	/** Lubricant feed temperature (Versions: 1.6) */
	RexsAttributeId lubricant_feed_temperature = RexsAttributeId.create("lubricant_feed_temperature", RexsStandardUnitIds.degree_celsius);

	/** Lubricant film thickness parameter (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId lubricant_film_thickness_parameter_din_3996_2019 = RexsAttributeId.create("lubricant_film_thickness_parameter_din_3996_2019", RexsStandardUnitIds.none);

	/** Oil volume flow rate through bearing (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId lubricant_flow_through_bearing = RexsAttributeId.create("lubricant_flow_through_bearing", RexsStandardUnitIds.litre_per_minute);

	/** Lubricant side of feature (Versions: 1.6) */
	RexsAttributeId lubricant_side = RexsAttributeId.create("lubricant_side", RexsStandardUnitIds.none);

	/** Lubricant structure factor (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId lubricant_structure_factor_din_3996_2019 = RexsAttributeId.create("lubricant_structure_factor_din_3996_2019", RexsStandardUnitIds.none);

	/** Difference of oil temperatures between outflow and feed (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId lubricant_temperature_difference_inlet_output = RexsAttributeId.create("lubricant_temperature_difference_inlet_output", RexsStandardUnitIds.kelvin);

	/** Lubricant type (AGMA 925 C95) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId lubricant_type_agma_925_a03 = RexsAttributeId.create("lubricant_type_agma_925_a03", RexsStandardUnitIds.none);

	/** Lubricant type (ISO 6336 2006) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId lubricant_type_iso_6336_2006 = RexsAttributeId.create("lubricant_type_iso_6336_2006", RexsStandardUnitIds.none);

	/** Coefficient for lubrication method (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId lubrication_factor = RexsAttributeId.create("lubrication_factor", RexsStandardUnitIds.none);

	/** Lubrication factor (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId lubrication_factor_iso_10300_2021 = RexsAttributeId.create("lubrication_factor_iso_10300_2021", RexsStandardUnitIds.none);

	/** Kind of lubrication (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId lubrication_type = RexsAttributeId.create("lubrication_type", RexsStandardUnitIds.none);

	/** Lubrication type (AGMA 925 C95) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId lubrication_type_agma_925_a03 = RexsAttributeId.create("lubrication_type_agma_925_a03", RexsStandardUnitIds.none);

	/** Lubrication type (DIN 3996 2019) (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId lubrication_type_din_3996_2019 = RexsAttributeId.create("lubrication_type_din_3996_2019", RexsStandardUnitIds.none);

	/** Type of lubrication (VDI 2736 2014) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId lubrication_type_vdi_2736_2014 = RexsAttributeId.create("lubrication_type_vdi_2736_2014", RexsStandardUnitIds.none);

	/** Lyra angle (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId lyra_angle = RexsAttributeId.create("lyra_angle", RexsStandardUnitIds.deg);

	/** Machine center to crossing point (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId machine_center_to_crossing_point = RexsAttributeId.create("machine_center_to_crossing_point", RexsStandardUnitIds.mm);

	/** Machine root angle (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId machine_root_angle = RexsAttributeId.create("machine_root_angle", RexsStandardUnitIds.deg);

	/** Machining allowance (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId machining_allowance = RexsAttributeId.create("machining_allowance", RexsStandardUnitIds.mm);

	/** Machining allowance of the tool according to DIN 3972 (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId machining_allowance_din_3972 = RexsAttributeId.create("machining_allowance_din_3972", RexsStandardUnitIds.mm);

	/** Machining allowance tolerance (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId machining_allowance_tolerance = RexsAttributeId.create("machining_allowance_tolerance", RexsStandardUnitIds.mm);

	/** Manufacturer (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId manufacturer = RexsAttributeId.create("manufacturer", RexsStandardUnitIds.none);

	/** Mass of component (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId mass_of_component = RexsAttributeId.create("mass_of_component", RexsStandardUnitIds.kg);

	/** Bending fatigue strength FKM 2012 (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId material_bending_fatigue_strength_fkm_2012 = RexsAttributeId.create("material_bending_fatigue_strength_fkm_2012", RexsStandardUnitIds.mega_pascal);

	/** Material category (VDI 2736 2014) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId material_category_vdi_2736_2014 = RexsAttributeId.create("material_category_vdi_2736_2014", RexsStandardUnitIds.none);

	/** Material constant a_G for Stieler support concept FKM 2012 (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId material_constant_a_g_for_stieler_support_concept_fkm_2012 = RexsAttributeId.create("material_constant_a_g_for_stieler_support_concept_fkm_2012", RexsStandardUnitIds.none);

	/** Material constant b_G for Stieler support concept FKM 2012 (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId material_constant_b_g_for_stieler_support_concept_fkm_2012 = RexsAttributeId.create("material_constant_b_g_for_stieler_support_concept_fkm_2012", RexsStandardUnitIds.none);

	/** Material depth dependent hardness (ISO 6336 2019) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId material_depth_dependent_hardness_iso_6336_2019 = RexsAttributeId.create("material_depth_dependent_hardness_iso_6336_2019", RexsStandardUnitIds.hv);

	/** Material depth dependent residual stress (ISO 6336 2019) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId material_depth_dependent_residual_stress_iso_6336_2019 = RexsAttributeId.create("material_depth_dependent_residual_stress_iso_6336_2019", RexsStandardUnitIds.newton_per_mm2);

	/** Material depth variation for hardness (ISO 6336 2019) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId material_depth_variation_for_hardness_iso_6336_2019 = RexsAttributeId.create("material_depth_variation_for_hardness_iso_6336_2019", RexsStandardUnitIds.mm);

	/** Material depth variation for residual stress (ISO 6336 2019) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId material_depth_variation_for_residual_stress_iso_6336_2019 = RexsAttributeId.create("material_depth_variation_for_residual_stress_iso_6336_2019", RexsStandardUnitIds.mm);

	/** Material designation (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId material_designation = RexsAttributeId.create("material_designation", RexsStandardUnitIds.none);

	/** Material exposure calibration factor (ISO 6336 2019) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId material_exposure_calibration_factor_iso_6336_2019 = RexsAttributeId.create("material_exposure_calibration_factor_iso_6336_2019", RexsStandardUnitIds.none);

	/** Material factor (ISO 6336 2019) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId material_factor_iso_6336_2019 = RexsAttributeId.create("material_factor_iso_6336_2019", RexsStandardUnitIds.none);

	/** Hardening method (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId material_hardening_method_fkm_2012 = RexsAttributeId.create("material_hardening_method_fkm_2012", RexsStandardUnitIds.none);

	/** Material loss (DIN 3996 2019) (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId material_loss_din_3996_2019 = RexsAttributeId.create("material_loss_din_3996_2019", RexsStandardUnitIds.mg);

	/** Material loss limit (DIN 3996 2019) (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId material_loss_limit_din_3996_2019 = RexsAttributeId.create("material_loss_limit_din_3996_2019", RexsStandardUnitIds.mg);

	/** Material - lubricant factor (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId material_lubricant_factor_din_3996_2019 = RexsAttributeId.create("material_lubricant_factor_din_3996_2019", RexsStandardUnitIds.none);

	/** Shear fatigue strength FKM 2012 (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId material_shear_fatigue_strength_fkm_2012 = RexsAttributeId.create("material_shear_fatigue_strength_fkm_2012", RexsStandardUnitIds.mega_pascal);

	/** Tensile fatigue strength FKM 2012 (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId material_tensile_fatigue_strength_fkm_2012 = RexsAttributeId.create("material_tensile_fatigue_strength_fkm_2012", RexsStandardUnitIds.mega_pascal);

	/** Torsion fatigue strength FKM 2012 (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId material_torsion_fatigue_strength_fkm_2012 = RexsAttributeId.create("material_torsion_fatigue_strength_fkm_2012", RexsStandardUnitIds.mega_pascal);

	/** Material type (DIN 6892 2012) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId material_type_din_6892_2012 = RexsAttributeId.create("material_type_din_6892_2012", RexsStandardUnitIds.none);

	/** Material type (DIN 743 2012) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId material_type_din_743_2012 = RexsAttributeId.create("material_type_din_743_2012", RexsStandardUnitIds.none);

	/** Material type (FKM 2012) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId material_type_fkm_2012 = RexsAttributeId.create("material_type_fkm_2012", RexsStandardUnitIds.none);

	/** Materials parameter for central film thickness (AGMA 925 A03) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId materials_paramter_for_central_film_thickness_of_calculation_points_agma_925_a03 = RexsAttributeId.create("materials_paramter_for_central_film_thickness_of_calculation_points_agma_925_a03", RexsStandardUnitIds.none);

	/** Reduced stiffness matrix with boundary condition to inertial environment (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId matrix_with_inertial_environment_boundary = RexsAttributeId.create("matrix_with_inertial_environment_boundary", RexsStandardUnitIds.none);

	/** Maximum actual reference tooth thickness (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId maximum_actual_reference_tooth_thickness_din_5480_2006 = RexsAttributeId.create("maximum_actual_reference_tooth_thickness_din_5480_2006", RexsStandardUnitIds.mm);

	/** Maximum actual space width (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId maximum_actual_space_width_din_5480_2006 = RexsAttributeId.create("maximum_actual_space_width_din_5480_2006", RexsStandardUnitIds.mm);

	/** Permissible pressure in the bearing (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId maximum_allowable_pressure = RexsAttributeId.create("maximum_allowable_pressure", RexsStandardUnitIds.mega_pascal);

	/** Maximum axial bearing clearance (before mounting) (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId maximum_axial_bearing_clearance = RexsAttributeId.create("maximum_axial_bearing_clearance", RexsStandardUnitIds.mum);

	/** Maximum diameter of bearing bore (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId maximum_bearing_bore_diameter = RexsAttributeId.create("maximum_bearing_bore_diameter", RexsStandardUnitIds.mm);

	/** Maximum bearing play (Versions: 1.0) */
	RexsAttributeId maximum_bearing_clearance = RexsAttributeId.create("maximum_bearing_clearance", RexsStandardUnitIds.mum);

	/** Maximum bearing outer diameter (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId maximum_bearing_outer_diameter = RexsAttributeId.create("maximum_bearing_outer_diameter", RexsStandardUnitIds.mm);

	/** Maximum bearing seat diameter (Versions: 1.0) */
	RexsAttributeId maximum_bore_diameter = RexsAttributeId.create("maximum_bore_diameter", RexsStandardUnitIds.mm);

	/** Maximum diameter of casing bore (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId maximum_casing_bore_diameter = RexsAttributeId.create("maximum_casing_bore_diameter", RexsStandardUnitIds.mm);

	/** Maximum circumferential force (DIN 6892 2012) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId maximum_circumferential_force_din_6892_2012 = RexsAttributeId.create("maximum_circumferential_force_din_6892_2012", RexsStandardUnitIds.newton);

	/** Maximum effective cone diameter joint tapered interference fit (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId maximum_cone_diameter_joint_tapered_interference_fit = RexsAttributeId.create("maximum_cone_diameter_joint_tapered_interference_fit", RexsStandardUnitIds.mm);

	/** Maximum contact temperature (AGMA 925 A03) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId maximum_contact_temperature_agma_925_a03 = RexsAttributeId.create("maximum_contact_temperature_agma_925_a03", RexsStandardUnitIds.degree_celsius);

	/** Maximum distance to middle contact line (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId maximum_distance_middle_contact_line_iso_10300_2014 = RexsAttributeId.create("maximum_distance_middle_contact_line_iso_10300_2014", RexsStandardUnitIds.mm);

	/** Maximum distance to middle contact line at left side of contact pattern (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId maximum_distance_middle_contact_line_left_side_iso_10300_2014 = RexsAttributeId.create("maximum_distance_middle_contact_line_left_side_iso_10300_2014", RexsStandardUnitIds.mm);

	/** Maximum distance to middle contact line at right side of contact pattern (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId maximum_distance_middle_contact_line_right_side_iso_10300_2014 = RexsAttributeId.create("maximum_distance_middle_contact_line_right_side_iso_10300_2014", RexsStandardUnitIds.mm);

	/** Maximum effective tooth thickness (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId maximum_effective_tooth_thickness_din_5480_2006 = RexsAttributeId.create("maximum_effective_tooth_thickness_din_5480_2006", RexsStandardUnitIds.mm);

	/** Max flash temperature (AGMA 925 A03) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId maximum_flash_temperature_agma_925_a03 = RexsAttributeId.create("maximum_flash_temperature_agma_925_a03", RexsStandardUnitIds.degree_celsius);

	/** Maximum flash temperature of test gears (AGMA 925 C95) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId maximum_flash_temperature_of_test_gears_agma_925_a03 = RexsAttributeId.create("maximum_flash_temperature_of_test_gears_agma_925_a03", RexsStandardUnitIds.degree_celsius);

	/** Maximum pressure (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId maximum_hertzian_pressure = RexsAttributeId.create("maximum_hertzian_pressure", RexsStandardUnitIds.newton_per_mm2);

	/** Maximum pressure at inner ring (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId maximum_hertzian_pressure_inner_ring = RexsAttributeId.create("maximum_hertzian_pressure_inner_ring", RexsStandardUnitIds.newton_per_mm2);

	/** Maximum pressure at outer ring (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId maximum_hertzian_pressure_outer_ring = RexsAttributeId.create("maximum_hertzian_pressure_outer_ring", RexsStandardUnitIds.newton_per_mm2);

	/** Maximum value of hertzian stress from local loaded tooth contact analysis (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId maximum_hertzian_stress_ltca_worm_stage = RexsAttributeId.create("maximum_hertzian_stress_ltca_worm_stage", RexsStandardUnitIds.newton_per_mm2);

	/** Maximum material exposure (ISO 6336 2019) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId maximum_material_exposure_iso_6336_2019 = RexsAttributeId.create("maximum_material_exposure_iso_6336_2019", RexsStandardUnitIds.none);

	/** Maximum nominal static normal stress due to bending moment around v direction (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId maximum_nominal_static_normal_stress_due_to_bending_torque_around_v_direction_fkm_2012 = RexsAttributeId.create("maximum_nominal_static_normal_stress_due_to_bending_torque_around_v_direction_fkm_2012", RexsStandardUnitIds.mega_pascal);

	/** Maximum nominal static normal stress due to bending moment around w direction (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId maximum_nominal_static_normal_stress_due_to_bending_torque_around_w_direction_fkm_2012 = RexsAttributeId.create("maximum_nominal_static_normal_stress_due_to_bending_torque_around_w_direction_fkm_2012", RexsStandardUnitIds.mega_pascal);

	/** Maximum nominal static normal stress due to tension-compression force in u direction (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId maximum_nominal_static_normal_stress_due_to_tension_compression_force_in_u_direction_fkm_2012 = RexsAttributeId.create("maximum_nominal_static_normal_stress_due_to_tension_compression_force_in_u_direction_fkm_2012", RexsStandardUnitIds.mega_pascal);

	/** Maximum nominal static shear stress due to shear force in v direction (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId maximum_nominal_static_shear_stress_due_to_shear_force_in_v_direction_fkm_2012 = RexsAttributeId.create("maximum_nominal_static_shear_stress_due_to_shear_force_in_v_direction_fkm_2012", RexsStandardUnitIds.mega_pascal);

	/** Maximum nominal static shear stress due to shear forces in w direction (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId maximum_nominal_static_shear_stress_due_to_shear_force_in_w_direction_fkm_2012 = RexsAttributeId.create("maximum_nominal_static_shear_stress_due_to_shear_force_in_w_direction_fkm_2012", RexsStandardUnitIds.mega_pascal);

	/** Maximum nominal static shear stress due to torsion moment in u direction (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId maximum_nominal_static_shear_stress_due_to_torsion_torque_around_u_direction_fkm_2012 = RexsAttributeId.create("maximum_nominal_static_shear_stress_due_to_torsion_torque_around_u_direction_fkm_2012", RexsStandardUnitIds.mega_pascal);

	/** Maximum normal backlash (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId maximum_normal_backlash = RexsAttributeId.create("maximum_normal_backlash", RexsStandardUnitIds.mm);

	/** Upper normal backlash variation (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId maximum_normal_backlash_variation = RexsAttributeId.create("maximum_normal_backlash_variation", RexsStandardUnitIds.mm);

	/** Maximum bearing outer diameter (Versions: 1.0) */
	RexsAttributeId maximum_outer_diameter = RexsAttributeId.create("maximum_outer_diameter", RexsStandardUnitIds.mm);

	/** Maximum permissible material exposure (ISO 6336 2019) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId maximum_permissible_material_exposure_iso_6336_2019 = RexsAttributeId.create("maximum_permissible_material_exposure_iso_6336_2019", RexsStandardUnitIds.none);

	/** Maximum shaft diameter (Versions: 1.0) */
	RexsAttributeId maximum_pin_diameter = RexsAttributeId.create("maximum_pin_diameter", RexsStandardUnitIds.mm);

	/** Maximum radial bearing clearance (before mounting) (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId maximum_radial_bearing_clearance = RexsAttributeId.create("maximum_radial_bearing_clearance", RexsStandardUnitIds.mum);

	/** Maximum root circle diameter (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId maximum_root_circle_diameter_din_5480_2006 = RexsAttributeId.create("maximum_root_circle_diameter_din_5480_2006", RexsStandardUnitIds.mm);

	/** Maximum root strength (VDI 2736 2014) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId maximum_root_stress_vdi_2736_2014 = RexsAttributeId.create("maximum_root_stress_vdi_2736_2014", RexsStandardUnitIds.newton_per_mm2);

	/** Maximum shaft diameter (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId maximum_shaft_diameter = RexsAttributeId.create("maximum_shaft_diameter", RexsStandardUnitIds.mm);

	/** Maximum value of sliding velocity from local loaded tooth contact analysis (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId maximum_sliding_velocity_ltca_worm_stage = RexsAttributeId.create("maximum_sliding_velocity_ltca_worm_stage", RexsStandardUnitIds.m_per_second);

	/** Maximum stress bending (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId maximum_stress_bending_din_743_2012 = RexsAttributeId.create("maximum_stress_bending_din_743_2012", RexsStandardUnitIds.newton_per_mm2);

	/** Maximum stress tension/ compression (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId maximum_stress_tension_compression_din_743_2012 = RexsAttributeId.create("maximum_stress_tension_compression_din_743_2012", RexsStandardUnitIds.newton_per_mm2);

	/** Maximum stress torsion (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId maximum_stress_torsion_din_743_2012 = RexsAttributeId.create("maximum_stress_torsion_din_743_2012", RexsStandardUnitIds.newton_per_mm2);

	/** Maximum effective surface pressure hub (DIN 6892 2012) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId maximum_surface_pressure_hub_din_6892_2012 = RexsAttributeId.create("maximum_surface_pressure_hub_din_6892_2012", RexsStandardUnitIds.mega_pascal);

	/** Maximum effective surface pressure key (DIN 6892 2012) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId maximum_surface_pressure_key_din_6892_2012 = RexsAttributeId.create("maximum_surface_pressure_key_din_6892_2012", RexsStandardUnitIds.mega_pascal);

	/** Maximum effective surface pressure shaft (DIN 6892 2012) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId maximum_surface_pressure_shaft_din_6892_2012 = RexsAttributeId.create("maximum_surface_pressure_shaft_din_6892_2012", RexsStandardUnitIds.mega_pascal);

	/** Maximum tip circle diameter (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId maximum_tip_circle_diameter_din_5480_2006 = RexsAttributeId.create("maximum_tip_circle_diameter_din_5480_2006", RexsStandardUnitIds.mm);

	/** Maximum tip clearance (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId maximum_tip_clearance_din_5480_2006 = RexsAttributeId.create("maximum_tip_clearance_din_5480_2006", RexsStandardUnitIds.mm);

	/** Maximum tip diameter (Versions: 1.5, 1.6) */
	RexsAttributeId maximum_tip_diameter = RexsAttributeId.create("maximum_tip_diameter", RexsStandardUnitIds.mm);

	/** Maximum torsional torque in reverse direction (DIN 6892 2012) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId maximum_torsional_torque_reverse_direction_din_6892_2012 = RexsAttributeId.create("maximum_torsional_torque_reverse_direction_din_6892_2012", RexsStandardUnitIds.newton_m);

	/** Maximum transverse backlash (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId maximum_transverse_backlash = RexsAttributeId.create("maximum_transverse_backlash", RexsStandardUnitIds.mm);

	/** Upper backlash variation in transverse section (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId maximum_transverse_backlash_variation = RexsAttributeId.create("maximum_transverse_backlash_variation", RexsStandardUnitIds.mm);

	/** Maximum value of minimum lubricant film thickness from local loaded tooth contact analysis (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId maximum_value_minimum_lubricant_film_thickness_ltca_worm_stage = RexsAttributeId.create("maximum_value_minimum_lubricant_film_thickness_ltca_worm_stage", RexsStandardUnitIds.mum);

	/** Mean addendum (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId mean_addendum = RexsAttributeId.create("mean_addendum", RexsStandardUnitIds.mm);

	/** Average of pinion and gear average roughness  (AGMA 925 A03) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId mean_average_surface_roughness_agma_925_a03 = RexsAttributeId.create("mean_average_surface_roughness_agma_925_a03", RexsStandardUnitIds.mum);

	/** Mean coefficient of friction at the calculation points (AGMA 925 A03) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId mean_coefficient_of_friction_at_calculation_points_agma_925_a03 = RexsAttributeId.create("mean_coefficient_of_friction_at_calculation_points_agma_925_a03", RexsStandardUnitIds.none);

	/** Mean coefficient of friction (AGMA 925 C95) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId mean_coefficient_of_friction_constant_agma_925_a03 = RexsAttributeId.create("mean_coefficient_of_friction_constant_agma_925_a03", RexsStandardUnitIds.none);

	/** Mean cone distance (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId mean_cone_distance = RexsAttributeId.create("mean_cone_distance", RexsStandardUnitIds.mm);

	/** Mean dedendum (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId mean_dedendum = RexsAttributeId.create("mean_dedendum", RexsStandardUnitIds.mm);

	/** Mean hertzian stress (DIN 3996 2019) (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId mean_hertzian_stress_din_3996_2019 = RexsAttributeId.create("mean_hertzian_stress_din_3996_2019", RexsStandardUnitIds.newton_per_mm2);

	/** Mean value of hertzian stress from local loaded tooth contact analysis (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId mean_hertzian_stress_ltca_worm_stage = RexsAttributeId.create("mean_hertzian_stress_ltca_worm_stage", RexsStandardUnitIds.newton_per_mm2);

	/** Mean minimum lubricant film thickness for wear (DIN 3996 2019) (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId mean_minimum_lubricant_film_thickness_din_3996_2019 = RexsAttributeId.create("mean_minimum_lubricant_film_thickness_din_3996_2019", RexsStandardUnitIds.mum);

	/** Mean value of minimum lubricant film thickness from local loaded tooth contact analysis (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId mean_minimum_lubricant_film_thickness_ltca_worm_stage = RexsAttributeId.create("mean_minimum_lubricant_film_thickness_ltca_worm_stage", RexsStandardUnitIds.mum);

	/** Mean normal chordal tooth thickness (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId mean_normal_chordal_thickness = RexsAttributeId.create("mean_normal_chordal_thickness", RexsStandardUnitIds.mm);

	/** Mean normal circular tooth thickness (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId mean_normal_circular_thickness = RexsAttributeId.create("mean_normal_circular_thickness", RexsStandardUnitIds.mm);

	/** Mean normal module (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId mean_normal_module = RexsAttributeId.create("mean_normal_module", RexsStandardUnitIds.mm);

	/** Mean normal topland (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId mean_normal_topland = RexsAttributeId.create("mean_normal_topland", RexsStandardUnitIds.mm);

	/** Mean minimum specific film thickness (AGMA 925 A03) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId mean_of_minimum_specific_film_thickness_agma_925_a03 = RexsAttributeId.create("mean_of_minimum_specific_film_thickness_agma_925_a03", RexsStandardUnitIds.none);

	/** Mean operating temperature (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId mean_operating_temperature = RexsAttributeId.create("mean_operating_temperature", RexsStandardUnitIds.degree_celsius);

	/** Mean operating temperature of inner ring (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId mean_operating_temperature_inner_ring = RexsAttributeId.create("mean_operating_temperature_inner_ring", RexsStandardUnitIds.degree_celsius);

	/** Mean operating temperature of outer ring (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId mean_operating_temperature_outer_ring = RexsAttributeId.create("mean_operating_temperature_outer_ring", RexsStandardUnitIds.degree_celsius);

	/** Mean pitch cone diameter (Versions: 1.1) */
	RexsAttributeId mean_pitch_cone_diameter = RexsAttributeId.create("mean_pitch_cone_diameter", RexsStandardUnitIds.mm);

	/** Mean pitch diameter (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId mean_pitch_diameter = RexsAttributeId.create("mean_pitch_diameter", RexsStandardUnitIds.mm);

	/** Mean scuffing temperature (AGMA 925 C95) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId mean_scuffing_temperature_agma_925_a03 = RexsAttributeId.create("mean_scuffing_temperature_agma_925_a03", RexsStandardUnitIds.degree_celsius);

	/** Mean sliding path (DIN 3996 2019) (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId mean_sliding_path_din_3996_2019 = RexsAttributeId.create("mean_sliding_path_din_3996_2019", RexsStandardUnitIds.mm);

	/** Mean value of sliding velocity from local loaded tooth contact analysis (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId mean_sliding_velocity_ltca_worm_stage = RexsAttributeId.create("mean_sliding_velocity_ltca_worm_stage", RexsStandardUnitIds.m_per_second);

	/** Mean specific sliding at point A (Plewe 1980) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId mean_specific_sliding_at_point_a_plewe_1980 = RexsAttributeId.create("mean_specific_sliding_at_point_a_plewe_1980", RexsStandardUnitIds.none);

	/** Mean specific sliding at point E (Plewe 1980) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId mean_specific_sliding_at_point_e_plewe_1980 = RexsAttributeId.create("mean_specific_sliding_at_point_e_plewe_1980", RexsStandardUnitIds.none);

	/** Mean specific sliding (Plewe 1980) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId mean_specific_sliding_plewe_1980 = RexsAttributeId.create("mean_specific_sliding_plewe_1980", RexsStandardUnitIds.none);

	/** Mean specific sliding under test conditions (Plewe 1980) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId mean_specific_sliding_under_test_conditions_plewe_1980 = RexsAttributeId.create("mean_specific_sliding_under_test_conditions_plewe_1980", RexsStandardUnitIds.none);

	/** Mean spiral angle (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId mean_spiral_angle = RexsAttributeId.create("mean_spiral_angle", RexsStandardUnitIds.deg);

	/** Mean stress bending (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId mean_stress_bending_din_743_2012 = RexsAttributeId.create("mean_stress_bending_din_743_2012", RexsStandardUnitIds.newton_per_mm2);

	/** Mean stress tension/compression (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId mean_stress_tension_compression_din_743_2012 = RexsAttributeId.create("mean_stress_tension_compression_din_743_2012", RexsStandardUnitIds.newton_per_mm2);

	/** Mean stress torsion (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId mean_stress_torsion_din_743_2012 = RexsAttributeId.create("mean_stress_torsion_din_743_2012", RexsStandardUnitIds.newton_per_mm2);

	/** Mean coefficient of friction (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId mean_tooth_coefficient_of_friction_din_3996_2019 = RexsAttributeId.create("mean_tooth_coefficient_of_friction_din_3996_2019", RexsStandardUnitIds.none);

	/** Mean tooth root thickness (DIN 3996 2019) (Versions: 1.2, 1.3) */
	RexsAttributeId mean_tooth_root_thickness_din_3996_2019 = RexsAttributeId.create("mean_tooth_root_thickness_din_3996_2019", RexsStandardUnitIds.mm);

	/** Mean tooth root thickness (DIN 3996 2019) with wear (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId mean_tooth_root_thickness_with_wear_din_3996_2019 = RexsAttributeId.create("mean_tooth_root_thickness_with_wear_din_3996_2019", RexsStandardUnitIds.mm);

	/** Mean tooth root thickness (DIN 3996 2019) without wear (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId mean_tooth_root_thickness_without_wear_din_3996_2019 = RexsAttributeId.create("mean_tooth_root_thickness_without_wear_din_3996_2019", RexsStandardUnitIds.mm);

	/** Mean transverse circular thickness (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId mean_transverse_circular_thickness = RexsAttributeId.create("mean_transverse_circular_thickness", RexsStandardUnitIds.mm);

	/** Measurement b_z0 of the tool (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId measurement_bz0 = RexsAttributeId.create("measurement_bz0", RexsStandardUnitIds.mm);

	/** Measuring diameter root undercut (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId measuring_diameter_at_undercut = RexsAttributeId.create("measuring_diameter_at_undercut", RexsStandardUnitIds.mm);

	/** Contact circle diameter (upper deviation) (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId measuring_diameter_at_upper_backlash_allowance = RexsAttributeId.create("measuring_diameter_at_upper_backlash_allowance", RexsStandardUnitIds.mm);

	/** Contact circle diameter (ball/flank) (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId measuring_diameter_ball_flank = RexsAttributeId.create("measuring_diameter_ball_flank", RexsStandardUnitIds.mm);

	/** Contact circle diameter for span measurement (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId measuring_diameter_for_span = RexsAttributeId.create("measuring_diameter_for_span", RexsStandardUnitIds.mm);

	/** Mesh load factor (ISO 6336 2019) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId mesh_load_factor_iso_6336_2019 = RexsAttributeId.create("mesh_load_factor_iso_6336_2019", RexsStandardUnitIds.none);

	/** Mesh stiffness for load distribution along face width (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId mesh_stiffness_for_load_distribution_along_face_width = RexsAttributeId.create("mesh_stiffness_for_load_distribution_along_face_width", RexsStandardUnitIds.newton_per_mm_mum);

	/** Meshing power loss (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId meshing_power_loss_din_3996_2019 = RexsAttributeId.create("meshing_power_loss_din_3996_2019", RexsStandardUnitIds.watt);

	/** Mesh stiffness for each mesh position (Versions: 1.5, 1.6) */
	RexsAttributeId meshing_stiffness_characteristic = RexsAttributeId.create("meshing_stiffness_characteristic", RexsStandardUnitIds.newton_per_mm);

	/** Mid zone factor (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId mid_zone_factor_pitting_iso_10300_2014 = RexsAttributeId.create("mid_zone_factor_pitting_iso_10300_2014", RexsStandardUnitIds.none);

	/** Minimum actual reference space width (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId minimum_actual_reference_space_width_din_5480_2006 = RexsAttributeId.create("minimum_actual_reference_space_width_din_5480_2006", RexsStandardUnitIds.mm);

	/** Minimum actual tooth thickness (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId minimum_actual_tooth_thickness_din_5480_2006 = RexsAttributeId.create("minimum_actual_tooth_thickness_din_5480_2006", RexsStandardUnitIds.mm);

	/** Minimum axial bearing clearance (before mounting) (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId minimum_axial_bearing_clearance = RexsAttributeId.create("minimum_axial_bearing_clearance", RexsStandardUnitIds.mum);

	/** Minimum diameter of bearing bore (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId minimum_bearing_bore_diameter = RexsAttributeId.create("minimum_bearing_bore_diameter", RexsStandardUnitIds.mm);

	/** Minimum bearing clearance (Versions: 1.0) */
	RexsAttributeId minimum_bearing_clearance = RexsAttributeId.create("minimum_bearing_clearance", RexsStandardUnitIds.mum);

	/** Minimum outer bearing diameter (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId minimum_bearing_outer_diameter = RexsAttributeId.create("minimum_bearing_outer_diameter", RexsStandardUnitIds.mm);

	/** Minimum bearing seat diameter (Versions: 1.0) */
	RexsAttributeId minimum_bore_diameter = RexsAttributeId.create("minimum_bore_diameter", RexsStandardUnitIds.mm);

	/** Minimum diameter of casing bore (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId minimum_casing_bore_diameter = RexsAttributeId.create("minimum_casing_bore_diameter", RexsStandardUnitIds.mm);

	/** Minimum contact length (AGMA 925 A03) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId minimum_contact_length_agma_925_a03 = RexsAttributeId.create("minimum_contact_length_agma_925_a03", RexsStandardUnitIds.mm);

	/** Minimum grinding diameter at the gear (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId minimum_diameter = RexsAttributeId.create("minimum_diameter", RexsStandardUnitIds.mm);

	/** Minimum effective space width (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId minimum_effective_space_width_din_5480_2006 = RexsAttributeId.create("minimum_effective_space_width_din_5480_2006", RexsStandardUnitIds.mm);

	/** Minimum film thickness (according to Dowson and Toyoda) (AGMA 925 A03) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId minimum_film_thickness_dowson_toyoda_agma_925_a03 = RexsAttributeId.create("minimum_film_thickness_dowson_toyoda_agma_925_a03", RexsStandardUnitIds.mum);

	/** Minimum value of hertzian stress from local loaded tooth contact analysis (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId minimum_hertzian_stress_ltca_worm_stage = RexsAttributeId.create("minimum_hertzian_stress_ltca_worm_stage", RexsStandardUnitIds.newton_per_mm2);

	/** Minimum lubricating film thickness in the pitch point (Plewe 1980) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId minimum_lubricant_film_thickness_in_the_pitch_point_plewe_1980 = RexsAttributeId.create("minimum_lubricant_film_thickness_in_the_pitch_point_plewe_1980", RexsStandardUnitIds.mum);

	/** Minimum normal backlash (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId minimum_normal_backlash = RexsAttributeId.create("minimum_normal_backlash", RexsStandardUnitIds.mm);

	/** Lower normal backlash variation (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId minimum_normal_backlash_variation = RexsAttributeId.create("minimum_normal_backlash_variation", RexsStandardUnitIds.mm);

	/** Normal module design calculation VDI 2738 2014 (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId minimum_normal_module_vdi_2736_2014 = RexsAttributeId.create("minimum_normal_module_vdi_2736_2014", RexsStandardUnitIds.mm);

	/** Minimum outer bearing diameter (Versions: 1.0) */
	RexsAttributeId minimum_outer_diameter = RexsAttributeId.create("minimum_outer_diameter", RexsStandardUnitIds.mm);

	/** Minimum shaft diameter (Versions: 1.0) */
	RexsAttributeId minimum_pin_diameter = RexsAttributeId.create("minimum_pin_diameter", RexsStandardUnitIds.mm);

	/** Minimum radial bearing clearance (before mounting) (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId minimum_radial_bearing_clearance = RexsAttributeId.create("minimum_radial_bearing_clearance", RexsStandardUnitIds.mum);

	/** Minimum root circle diameter (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId minimum_root_circle_diameter_din_5480_2006 = RexsAttributeId.create("minimum_root_circle_diameter_din_5480_2006", RexsStandardUnitIds.mm);

	/** Minimum safety factor for bending stress (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId minimum_safety_factor_bending_stress_iso_10300_2014 = RexsAttributeId.create("minimum_safety_factor_bending_stress_iso_10300_2014", RexsStandardUnitIds.none);

	/** Minimum safety factor for contact stress (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId minimum_safety_factor_contact_stress_iso_10300_2014 = RexsAttributeId.create("minimum_safety_factor_contact_stress_iso_10300_2014", RexsStandardUnitIds.none);

	/** Minimum safety factor scuffing (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId minimum_safety_factor_scuffing_iso_10300_2021 = RexsAttributeId.create("minimum_safety_factor_scuffing_iso_10300_2021", RexsStandardUnitIds.none);

	/** Minimum shaft diameter (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId minimum_shaft_diameter = RexsAttributeId.create("minimum_shaft_diameter", RexsStandardUnitIds.mm);

	/** Minimum value of sliding velocity from local loaded tooth contact analysis (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId minimum_sliding_velocity_ltca_worm_stage = RexsAttributeId.create("minimum_sliding_velocity_ltca_worm_stage", RexsStandardUnitIds.m_per_second);

	/** Minimum specific film thickness (according to Wellauer and Holloway) (AGMA 925 A03) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId minimum_specific_film_thickness_wellauer_holloway_agma_925_a03 = RexsAttributeId.create("minimum_specific_film_thickness_wellauer_holloway_agma_925_a03", RexsStandardUnitIds.none);

	/** Minimum pinion diameter design calculation VDI 2738 2014 (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId minimum_standard_pitch_diameter_vdi_2736_2014 = RexsAttributeId.create("minimum_standard_pitch_diameter_vdi_2736_2014", RexsStandardUnitIds.mm);

	/** Minimum thickness by tip chamfer relief (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId minimum_thickness_by_tip_chamfer_relief = RexsAttributeId.create("minimum_thickness_by_tip_chamfer_relief", RexsStandardUnitIds.mm);

	/** Minimum tip circle diameter (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId minimum_tip_circle_diameter_din_5480_2006 = RexsAttributeId.create("minimum_tip_circle_diameter_din_5480_2006", RexsStandardUnitIds.mm);

	/** Minimum tip clearance (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId minimum_tip_clearance_din_5480_2006 = RexsAttributeId.create("minimum_tip_clearance_din_5480_2006", RexsStandardUnitIds.mm);

	/** Minimum tip diameter (Versions: 1.5, 1.6) */
	RexsAttributeId minimum_tip_diameter = RexsAttributeId.create("minimum_tip_diameter", RexsStandardUnitIds.mm);

	/** Minimum transverse backlash (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId minimum_transverse_backlash = RexsAttributeId.create("minimum_transverse_backlash", RexsStandardUnitIds.mm);

	/** Lower backlash variation in transverse section (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId minimum_transverse_backlash_variation = RexsAttributeId.create("minimum_transverse_backlash_variation", RexsStandardUnitIds.mm);

	/** Minimum value of minimum lubricant film thickness from local loaded tooth contact analysis (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId minimum_value_minimum_lubricant_film_thickness_ltca_worm_stage = RexsAttributeId.create("minimum_value_minimum_lubricant_film_thickness_ltca_worm_stage", RexsStandardUnitIds.mum);

	/** Radial offset of the mounting position of the outer ring in the v-direction (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId misalignment_in_v_direction = RexsAttributeId.create("misalignment_in_v_direction", RexsStandardUnitIds.mum);

	/** Radial offset of the mounting position of the outer ring in the w-direction (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId misalignment_in_w_direction = RexsAttributeId.create("misalignment_in_w_direction", RexsStandardUnitIds.mum);

	/** Model name (Versions: 1.5, 1.6) */
	RexsAttributeId model_name = RexsAttributeId.create("model_name", RexsStandardUnitIds.none);

	/** Modification date (Versions: 1.5, 1.6) */
	RexsAttributeId modification_date = RexsAttributeId.create("modification_date", RexsStandardUnitIds.none);

	/** Modification of diameter clearance at the points (Versions: 1.6) */
	RexsAttributeId modifications_of_diameter_clearance_point_list = RexsAttributeId.create("modifications_of_diameter_clearance_point_list", RexsStandardUnitIds.mum);

	/** Modified contact stress at contact point Y (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId modified_contact_stress_iso_10300_2021 = RexsAttributeId.create("modified_contact_stress_iso_10300_2021", RexsStandardUnitIds.newton_per_mm2);

	/** Modified rating life (ISO 281 2007) (Versions: 1.6) */
	RexsAttributeId modified_rating_life_rotations_iso_281_2007 = RexsAttributeId.create("modified_rating_life_rotations_iso_281_2007", RexsStandardUnitIds.unit_59);

	/** Modified rating life (ISO 281 2007) (Versions: 1.6) */
	RexsAttributeId modified_rating_life_time_iso_281_2007 = RexsAttributeId.create("modified_rating_life_time_iso_281_2007", RexsStandardUnitIds.hour);

	/** Modified reference rating life DIN 26281 2010 (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId modified_reference_rating_life_rotations_din_26281 = RexsAttributeId.create("modified_reference_rating_life_rotations_din_26281", RexsStandardUnitIds.unit_59);

	/** Modified reference rating life DIN 26281 2010 (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId modified_reference_rating_life_time_din_26281 = RexsAttributeId.create("modified_reference_rating_life_time_din_26281", RexsStandardUnitIds.hour);

	/** Modified roll coefficients (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId modified_roll_coefficients = RexsAttributeId.create("modified_roll_coefficients", RexsStandardUnitIds.none);

	/** Modulus of elasticity flank at operating temperature (VDI 2736 2014) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId modulus_of_elasticity_flank_vdi_2736_2014 = RexsAttributeId.create("modulus_of_elasticity_flank_vdi_2736_2014", RexsStandardUnitIds.newton_per_mm2);

	/** Modulus of elasticity root at operating temperature (VDI 2736 2014) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId modulus_of_elasticity_root_vdi_2736_2014 = RexsAttributeId.create("modulus_of_elasticity_root_vdi_2736_2014", RexsStandardUnitIds.newton_per_mm2);

	/** Moment of inertia around u-axis (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId moment_of_inertia_u_axis = RexsAttributeId.create("moment_of_inertia_u_axis", RexsStandardUnitIds.kg_m2);

	/** Moment of inertia around v-axis (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId moment_of_inertia_v_axis = RexsAttributeId.create("moment_of_inertia_v_axis", RexsStandardUnitIds.kg_m2);

	/** Moment of inertia around w-axis (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId moment_of_inertia_w_axis = RexsAttributeId.create("moment_of_inertia_w_axis", RexsStandardUnitIds.kg_m2);

	/** Axial bearing clearance (after mounting) (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId mounted_axial_bearing_clearance = RexsAttributeId.create("mounted_axial_bearing_clearance", RexsStandardUnitIds.mum);

	/** Radial bearing clearance (after mounting) (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId mounted_radial_bearing_clearance = RexsAttributeId.create("mounted_radial_bearing_clearance", RexsStandardUnitIds.mum);

	/** Bearing mounting angle (Versions: 1.6) */
	RexsAttributeId mounting_angle_plain_bearing = RexsAttributeId.create("mounting_angle_plain_bearing", RexsStandardUnitIds.deg);

	/** Mounting factor (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId mounting_factor_iso_10300_2014 = RexsAttributeId.create("mounting_factor_iso_10300_2014", RexsStandardUnitIds.none);

	/** Name of lubricant (Versions: 1.0, 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId name = RexsAttributeId.create("name", RexsStandardUnitIds.none);

	/** Nominal contact stress (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId nominal_contact_stress_iso_10300_2014 = RexsAttributeId.create("nominal_contact_stress_iso_10300_2014", RexsStandardUnitIds.newton_per_mm2);

	/** Nominal cyclic degree of utilization of all loads combined (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId nominal_cyclic_degree_of_utilization_of_all_loads_combined_fkm_2012 = RexsAttributeId.create("nominal_cyclic_degree_of_utilization_of_all_loads_combined_fkm_2012", RexsStandardUnitIds.none);

	/** Nominal cyclic degree of utilization of bending moment around v direction (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId nominal_cyclic_degree_of_utilization_of_bending_torque_around_v_direction_fkm_2012 = RexsAttributeId.create("nominal_cyclic_degree_of_utilization_of_bending_torque_around_v_direction_fkm_2012", RexsStandardUnitIds.none);

	/** Nominal cyclic degree of utilization of bending moment around w direction (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId nominal_cyclic_degree_of_utilization_of_bending_torque_around_w_direction_fkm_2012 = RexsAttributeId.create("nominal_cyclic_degree_of_utilization_of_bending_torque_around_w_direction_fkm_2012", RexsStandardUnitIds.none);

	/** Nominal cyclic degree of utilization of shear force in v direction (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId nominal_cyclic_degree_of_utilization_of_shear_force_in_v_direction_fkm_2012 = RexsAttributeId.create("nominal_cyclic_degree_of_utilization_of_shear_force_in_v_direction_fkm_2012", RexsStandardUnitIds.none);

	/** Nominal cyclic degree of utilization of shear force in w direction (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId nominal_cyclic_degree_of_utilization_of_shear_force_in_w_direction_fkm_2012 = RexsAttributeId.create("nominal_cyclic_degree_of_utilization_of_shear_force_in_w_direction_fkm_2012", RexsStandardUnitIds.none);

	/** Nominal cyclic degree of utilization of tension-compression force in u direction (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId nominal_cyclic_degree_of_utilization_of_tension_compression_force_in_u_direction_fkm_2012 = RexsAttributeId.create("nominal_cyclic_degree_of_utilization_of_tension_compression_force_in_u_direction_fkm_2012", RexsStandardUnitIds.none);

	/** Nominal cyclic degree of utilization of torsion moment in u direction (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId nominal_cyclic_degree_of_utilization_of_torsion_torque_around_u_direction_fkm_2012 = RexsAttributeId.create("nominal_cyclic_degree_of_utilization_of_torsion_torque_around_u_direction_fkm_2012", RexsStandardUnitIds.none);

	/** Nominal cyclic global stress gradient (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId nominal_cyclic_global_normal_stress_gradient_fkm_2012 = RexsAttributeId.create("nominal_cyclic_global_normal_stress_gradient_fkm_2012", RexsStandardUnitIds.per_mm);

	/** Nominal cyclic global shear stress gradient (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId nominal_cyclic_global_shear_stress_gradient_fkm_2012 = RexsAttributeId.create("nominal_cyclic_global_shear_stress_gradient_fkm_2012", RexsStandardUnitIds.per_mm);

	/** Nominal cyclic local normal stress gradient (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId nominal_cyclic_local_normal_stress_gradient_fkm_2012 = RexsAttributeId.create("nominal_cyclic_local_normal_stress_gradient_fkm_2012", RexsStandardUnitIds.per_mm);

	/** Nominal cyclic local shear stress gradient (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId nominal_cyclic_local_shear_stress_gradient_fkm_2012 = RexsAttributeId.create("nominal_cyclic_local_shear_stress_gradient_fkm_2012", RexsStandardUnitIds.per_mm);

	/** Notch factor for nominal cyclic normal stress due to bending moment around v direction (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId nominal_cyclic_normal_notch_factor_due_to_bending_torque_around_v_direction_fkm_2012 = RexsAttributeId.create("nominal_cyclic_normal_notch_factor_due_to_bending_torque_around_v_direction_fkm_2012", RexsStandardUnitIds.none);

	/** Notch factor for nominal cyclic normal stress due to bending moment around w direction (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId nominal_cyclic_normal_notch_factor_due_to_bending_torque_around_w_direction_fkm_2012 = RexsAttributeId.create("nominal_cyclic_normal_notch_factor_due_to_bending_torque_around_w_direction_fkm_2012", RexsStandardUnitIds.none);

	/** Notch factor for nominal cyclic normal stress due to tension-compression force in u direction (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId nominal_cyclic_normal_notch_factor_due_to_tension_compression_force_in_u_direction_fkm_2012 = RexsAttributeId.create("nominal_cyclic_normal_notch_factor_due_to_tension_compression_force_in_u_direction_fkm_2012", RexsStandardUnitIds.none);

	/** Notch factor of probe for nominal cyclic normal stress due to bending moment around v direction (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId nominal_cyclic_normal_notch_factor_of_probe_due_to_bending_torque_around_v_direction_fkm_2012 = RexsAttributeId.create("nominal_cyclic_normal_notch_factor_of_probe_due_to_bending_torque_around_v_direction_fkm_2012", RexsStandardUnitIds.none);

	/** Notch factor of probe for nominal cyclic normal stress due to bending moment around w direction (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId nominal_cyclic_normal_notch_factor_of_probe_due_to_bending_torque_around_w_direction_fkm_2012 = RexsAttributeId.create("nominal_cyclic_normal_notch_factor_of_probe_due_to_bending_torque_around_w_direction_fkm_2012", RexsStandardUnitIds.none);

	/** Notch factor of probe for nominal cyclic normal stress due to tension-compression force in u direction (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId nominal_cyclic_normal_notch_factor_of_probe_due_to_tension_compression_force_in_u_direction_fkm_2012 = RexsAttributeId.create("nominal_cyclic_normal_notch_factor_of_probe_due_to_tension_compression_force_in_u_direction_fkm_2012", RexsStandardUnitIds.none);

	/** Nominal cyclic normal stress maxima due to bending moments around v direction (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId nominal_cyclic_normal_stress_maxima_due_to_bending_torques_around_v_direction_fkm_2012 = RexsAttributeId.create("nominal_cyclic_normal_stress_maxima_due_to_bending_torques_around_v_direction_fkm_2012", RexsStandardUnitIds.mega_pascal);

	/** Nominal cyclic normal stress maxima due to bending moments around w direction (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId nominal_cyclic_normal_stress_maxima_due_to_bending_torques_around_w_direction_fkm_2012 = RexsAttributeId.create("nominal_cyclic_normal_stress_maxima_due_to_bending_torques_around_w_direction_fkm_2012", RexsStandardUnitIds.mega_pascal);

	/** Nominal cyclic normal stress maxima due to tension-compression forces in u direction (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId nominal_cyclic_normal_stress_maxima_due_to_tension_compression_forces_in_u_direction_fkm_2012 = RexsAttributeId.create("nominal_cyclic_normal_stress_maxima_due_to_tension_compression_forces_in_u_direction_fkm_2012", RexsStandardUnitIds.mega_pascal);

	/** Nominal cyclic normal stress ratio due to bending moment around v direction (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId nominal_cyclic_normal_stress_ratio_due_to_bending_torque_around_v_direction_fkm_2012 = RexsAttributeId.create("nominal_cyclic_normal_stress_ratio_due_to_bending_torque_around_v_direction_fkm_2012", RexsStandardUnitIds.none);

	/** Nominal cyclic normal stress ratio due to bending moment around w direction (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId nominal_cyclic_normal_stress_ratio_due_to_bending_torque_around_w_direction_fkm_2012 = RexsAttributeId.create("nominal_cyclic_normal_stress_ratio_due_to_bending_torque_around_w_direction_fkm_2012", RexsStandardUnitIds.none);

	/** Nominal cyclic normal stress ratio due to tension compression forces in u direction (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId nominal_cyclic_normal_stress_ratio_due_to_tension_compression_forces_in_u_direction_fkm_2012 = RexsAttributeId.create("nominal_cyclic_normal_stress_ratio_due_to_tension_compression_forces_in_u_direction_fkm_2012", RexsStandardUnitIds.none);

	/** Notch factor for nominal cyclic shear stress due to shear force in v direction (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId nominal_cyclic_shear_notch_factor_due_to_shear_force_in_v_direction_fkm_2012 = RexsAttributeId.create("nominal_cyclic_shear_notch_factor_due_to_shear_force_in_v_direction_fkm_2012", RexsStandardUnitIds.none);

	/** Notch factor for nominal cyclic shear stress due to shear force in w direction (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId nominal_cyclic_shear_notch_factor_due_to_shear_force_in_w_direction_fkm_2012 = RexsAttributeId.create("nominal_cyclic_shear_notch_factor_due_to_shear_force_in_w_direction_fkm_2012", RexsStandardUnitIds.none);

	/** Notch factor for nominal cyclic shear stress due to torsion moment in u direction (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId nominal_cyclic_shear_notch_factor_due_to_torsion_torque_around_u_direction_fkm_2012 = RexsAttributeId.create("nominal_cyclic_shear_notch_factor_due_to_torsion_torque_around_u_direction_fkm_2012", RexsStandardUnitIds.none);

	/** Notch factor of probe for nominal cyclic shear stress due to shear force in v direction (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId nominal_cyclic_shear_notch_factor_of_probe_due_to_shear_force_in_v_direction_fkm_2012 = RexsAttributeId.create("nominal_cyclic_shear_notch_factor_of_probe_due_to_shear_force_in_v_direction_fkm_2012", RexsStandardUnitIds.none);

	/** Notch factor of probe for nominal cyclic shear stress due to shear force in w direction (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId nominal_cyclic_shear_notch_factor_of_probe_due_to_shear_force_in_w_direction_fkm_2012 = RexsAttributeId.create("nominal_cyclic_shear_notch_factor_of_probe_due_to_shear_force_in_w_direction_fkm_2012", RexsStandardUnitIds.none);

	/** Notch factor of probe for nominal cyclicshear stress due to torsion moment in u direction (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId nominal_cyclic_shear_notch_factor_of_probe_due_to_torsion_torque_around_u_direction_fkm_2012 = RexsAttributeId.create("nominal_cyclic_shear_notch_factor_of_probe_due_to_torsion_torque_around_u_direction_fkm_2012", RexsStandardUnitIds.none);

	/** Nominal cyclic shear stress maxima due to shear forces in v direction (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId nominal_cyclic_shear_stress_maxima_due_to_shear_forces_in_v_direction_fkm_2012 = RexsAttributeId.create("nominal_cyclic_shear_stress_maxima_due_to_shear_forces_in_v_direction_fkm_2012", RexsStandardUnitIds.mega_pascal);

	/** Nominal cyclic shear stress maxima due to shear forces in w direction (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId nominal_cyclic_shear_stress_maxima_due_to_shear_forces_in_w_direction_fkm_2012 = RexsAttributeId.create("nominal_cyclic_shear_stress_maxima_due_to_shear_forces_in_w_direction_fkm_2012", RexsStandardUnitIds.mega_pascal);

	/** Nominal cyclic shear stress maxima due to torsion moments around u direction (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId nominal_cyclic_shear_stress_maxima_due_to_torsion_torques_around_u_direction_fkm_2012 = RexsAttributeId.create("nominal_cyclic_shear_stress_maxima_due_to_torsion_torques_around_u_direction_fkm_2012", RexsStandardUnitIds.mega_pascal);

	/** Nominal cyclic shear stress ratio due to shear force in v direction (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId nominal_cyclic_shear_stress_ratio_due_to_shear_force_in_v_direction_fkm_2012 = RexsAttributeId.create("nominal_cyclic_shear_stress_ratio_due_to_shear_force_in_v_direction_fkm_2012", RexsStandardUnitIds.none);

	/** Nominal cyclic shear stress ratio due to shear force in w direction (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId nominal_cyclic_shear_stress_ratio_due_to_shear_force_in_w_direction_fkm_2012 = RexsAttributeId.create("nominal_cyclic_shear_stress_ratio_due_to_shear_force_in_w_direction_fkm_2012", RexsStandardUnitIds.none);

	/** Nominal cyclic shear stress ratio due to torsion moment around u direction (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId nominal_cyclic_shear_stress_ratio_due_to_torsion_torque_around_u_direction_fkm_2012 = RexsAttributeId.create("nominal_cyclic_shear_stress_ratio_due_to_torsion_torque_around_u_direction_fkm_2012", RexsStandardUnitIds.none);

	/** Nominal design pressure angle on coast side (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId nominal_design_pressure_angle_coast = RexsAttributeId.create("nominal_design_pressure_angle_coast", RexsStandardUnitIds.deg);

	/** Nominal design pressure angle on drive side (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId nominal_design_pressure_angle_drive = RexsAttributeId.create("nominal_design_pressure_angle_drive", RexsStandardUnitIds.deg);

	/** Stress concentration factor for nominal normal stress due to bending moment around v direction (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId nominal_normal_stress_concentration_factor_due_to_bending_torque_around_v_direction_fkm_2012 = RexsAttributeId.create("nominal_normal_stress_concentration_factor_due_to_bending_torque_around_v_direction_fkm_2012", RexsStandardUnitIds.none);

	/** Stress concentration factor for nominal normal stress due to bending moment around w direction (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId nominal_normal_stress_concentration_factor_due_to_bending_torque_around_w_direction_fkm_2012 = RexsAttributeId.create("nominal_normal_stress_concentration_factor_due_to_bending_torque_around_w_direction_fkm_2012", RexsStandardUnitIds.none);

	/** Stress concentration factor for nominal normal stress due to tension-compression force in u direction (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId nominal_normal_stress_concentration_factor_due_to_tension_compression_force_in_u_direction_fkm_2012 = RexsAttributeId.create("nominal_normal_stress_concentration_factor_due_to_tension_compression_force_in_u_direction_fkm_2012", RexsStandardUnitIds.none);

	/** Nominal rating life (L_10) DIN ISO 281 (Versions: 1.0) */
	RexsAttributeId nominal_rating_life_rotations_din_iso_281 = RexsAttributeId.create("nominal_rating_life_rotations_din_iso_281", RexsStandardUnitIds.none);

	/** Nominal rating life ISO 281 2007 (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId nominal_rating_life_rotations_iso_281_2007 = RexsAttributeId.create("nominal_rating_life_rotations_iso_281_2007", RexsStandardUnitIds.unit_59);

	/** Nominal rating life (L_10h) DIN ISO 281 (Versions: 1.0) */
	RexsAttributeId nominal_rating_life_time_din_iso_281 = RexsAttributeId.create("nominal_rating_life_time_din_iso_281", RexsStandardUnitIds.hour);

	/** Nominal rating life ISO 281 2007 (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId nominal_rating_life_time_iso_281_2007 = RexsAttributeId.create("nominal_rating_life_time_iso_281_2007", RexsStandardUnitIds.hour);

	/** Nominal reference rating life DIN 26281 (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId nominal_reference_rating_life_rotations_din_26281 = RexsAttributeId.create("nominal_reference_rating_life_rotations_din_26281", RexsStandardUnitIds.unit_59);

	/** Nominal reference rating life DIN 26281 (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId nominal_reference_rating_life_time_din_26281 = RexsAttributeId.create("nominal_reference_rating_life_time_din_26281", RexsStandardUnitIds.hour);

	/** Stress concentration factor for nominal shear stress due to shear force in v direction (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId nominal_shear_stress_concentration_factor_due_to_shear_force_in_v_direction_fkm_2012 = RexsAttributeId.create("nominal_shear_stress_concentration_factor_due_to_shear_force_in_v_direction_fkm_2012", RexsStandardUnitIds.none);

	/** Stress concentration factor for nominal shear stress due to shear force in w direction (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId nominal_shear_stress_concentration_factor_due_to_shear_force_in_w_direction_fkm_2012 = RexsAttributeId.create("nominal_shear_stress_concentration_factor_due_to_shear_force_in_w_direction_fkm_2012", RexsStandardUnitIds.none);

	/** Stress concentration factor for nominal shear stress due to torsion moment in u direction (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId nominal_shear_stress_concentration_factor_due_to_torsion_torque_around_u_direction_fkm_2012 = RexsAttributeId.create("nominal_shear_stress_concentration_factor_due_to_torsion_torque_around_u_direction_fkm_2012", RexsStandardUnitIds.none);

	/** Nominal static degree of utilization of all loads combined (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId nominal_static_degree_of_utilization_of_all_loads_combined_fkm_2012 = RexsAttributeId.create("nominal_static_degree_of_utilization_of_all_loads_combined_fkm_2012", RexsStandardUnitIds.none);

	/** Nominal static degree of utilization of bending moment around v direction (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId nominal_static_degree_of_utilization_of_bending_torque_around_v_direction_fkm_2012 = RexsAttributeId.create("nominal_static_degree_of_utilization_of_bending_torque_around_v_direction_fkm_2012", RexsStandardUnitIds.none);

	/** Nominal static degree of utilization of bending moment around w direction (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId nominal_static_degree_of_utilization_of_bending_torque_around_w_direction_fkm_2012 = RexsAttributeId.create("nominal_static_degree_of_utilization_of_bending_torque_around_w_direction_fkm_2012", RexsStandardUnitIds.none);

	/** Nominal static degree of utilization of shear force in v direction (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId nominal_static_degree_of_utilization_of_shear_force_in_v_direction_fkm_2012 = RexsAttributeId.create("nominal_static_degree_of_utilization_of_shear_force_in_v_direction_fkm_2012", RexsStandardUnitIds.none);

	/** Nominal static degree of utilization of shear force in w direction (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId nominal_static_degree_of_utilization_of_shear_force_in_w_direction_fkm_2012 = RexsAttributeId.create("nominal_static_degree_of_utilization_of_shear_force_in_w_direction_fkm_2012", RexsStandardUnitIds.none);

	/** Nominal static degree of utilization of tension-compression force in u direction (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId nominal_static_degree_of_utilization_of_tension_compression_force_in_u_direction_fkm_2012 = RexsAttributeId.create("nominal_static_degree_of_utilization_of_tension_compression_force_in_u_direction_fkm_2012", RexsStandardUnitIds.none);

	/** Nominal static degree of utilization of torsion moment in u direction (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId nominal_static_degree_of_utilization_of_torsion_torque_around_u_direction_fkm_2012 = RexsAttributeId.create("nominal_static_degree_of_utilization_of_torsion_torque_around_u_direction_fkm_2012", RexsStandardUnitIds.none);

	/** Is maximum static bending stress on the tension side (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId nominal_static_is_tension_bending_fkm_2012 = RexsAttributeId.create("nominal_static_is_tension_bending_fkm_2012", RexsStandardUnitIds.none);

	/** Nominal static plastic support factor due to bending moment about v-direction (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId nominal_static_plastic_support_factor_due_to_bending_torque_around_v_direction_fkm_2012 = RexsAttributeId.create("nominal_static_plastic_support_factor_due_to_bending_torque_around_v_direction_fkm_2012", RexsStandardUnitIds.none);

	/** Nominal static plastic support factor due to bending moment about w-direction (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId nominal_static_plastic_support_factor_due_to_bending_torque_around_w_direction_fkm_2012 = RexsAttributeId.create("nominal_static_plastic_support_factor_due_to_bending_torque_around_w_direction_fkm_2012", RexsStandardUnitIds.none);

	/** Nominal static plastic support factor due to torsional moment about u-direction (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId nominal_static_plastic_support_factor_due_to_torsion_torque_around_u_direction_fkm_2012 = RexsAttributeId.create("nominal_static_plastic_support_factor_due_to_torsion_torque_around_u_direction_fkm_2012", RexsStandardUnitIds.none);

	/** Nominal tangential force at base circle (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId nominal_tangential_force_at_base_circle = RexsAttributeId.create("nominal_tangential_force_at_base_circle", RexsStandardUnitIds.newton);

	/** Nominal tangential force at reference circle (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId nominal_tangential_force_at_reference_circle = RexsAttributeId.create("nominal_tangential_force_at_reference_circle", RexsStandardUnitIds.newton);

	/** Nominal torsional torque (DIN 6892 2012) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId nominal_torsional_torque_din_6892_2012 = RexsAttributeId.create("nominal_torsional_torque_din_6892_2012", RexsStandardUnitIds.newton_m);

	/** Normal base pitch (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId normal_base_pitch = RexsAttributeId.create("normal_base_pitch", RexsStandardUnitIds.mm);

	/** Normal chordal tooth thickness (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId normal_chordal_tooth_thickness = RexsAttributeId.create("normal_chordal_tooth_thickness", RexsStandardUnitIds.mm);

	/** Normal circular pitch (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId normal_circular_pitch = RexsAttributeId.create("normal_circular_pitch", RexsStandardUnitIds.mm);

	/** Normal line load (Plewe 1980) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId normal_line_load_plewe_1980 = RexsAttributeId.create("normal_line_load_plewe_1980", RexsStandardUnitIds.newton_per_mm);

	/** Normal module (Versions: 1.0, 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId normal_module = RexsAttributeId.create("normal_module", RexsStandardUnitIds.mm);

	/** Normal operating load (AGMA 925 A03) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId normal_operating_load_agma_925_a03 = RexsAttributeId.create("normal_operating_load_agma_925_a03", RexsStandardUnitIds.newton);

	/** Normal pitch (DIN 3975 2017) (Versions: 1.2) */
	RexsAttributeId normal_pitch_din_3975_2017 = RexsAttributeId.create("normal_pitch_din_3975_2017", RexsStandardUnitIds.mm);

	/** Normal pressure angle (Versions: 1.0, 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId normal_pressure_angle = RexsAttributeId.create("normal_pressure_angle", RexsStandardUnitIds.deg);

	/** Normal radius of curvature at point A (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId normal_radius_of_curvature_at_point_a = RexsAttributeId.create("normal_radius_of_curvature_at_point_a", RexsStandardUnitIds.mm);

	/** Normal radius of curvature at point B (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId normal_radius_of_curvature_at_point_b = RexsAttributeId.create("normal_radius_of_curvature_at_point_b", RexsStandardUnitIds.mm);

	/** Normal radius of curvature at point C (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId normal_radius_of_curvature_at_point_c = RexsAttributeId.create("normal_radius_of_curvature_at_point_c", RexsStandardUnitIds.mm);

	/** Normal radius of curvature at point d (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId normal_radius_of_curvature_at_point_d = RexsAttributeId.create("normal_radius_of_curvature_at_point_d", RexsStandardUnitIds.mm);

	/** Normal radius of curvature at point E (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId normal_radius_of_curvature_at_point_e = RexsAttributeId.create("normal_radius_of_curvature_at_point_e", RexsStandardUnitIds.mm);

	/** Normal radius of relative curvature at point A (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId normal_radius_of_relative_curvature_at_point_a = RexsAttributeId.create("normal_radius_of_relative_curvature_at_point_a", RexsStandardUnitIds.mm);

	/** Normal radius of relative curvature at point B (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId normal_radius_of_relative_curvature_at_point_b = RexsAttributeId.create("normal_radius_of_relative_curvature_at_point_b", RexsStandardUnitIds.mm);

	/** Normal radius of relative curvature at point C (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId normal_radius_of_relative_curvature_at_point_c = RexsAttributeId.create("normal_radius_of_relative_curvature_at_point_c", RexsStandardUnitIds.mm);

	/** Normal radius of relative curvature at point D (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId normal_radius_of_relative_curvature_at_point_d = RexsAttributeId.create("normal_radius_of_relative_curvature_at_point_d", RexsStandardUnitIds.mm);

	/** Normal radius of relative curvature at point E (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId normal_radius_of_relative_curvature_at_point_e = RexsAttributeId.create("normal_radius_of_relative_curvature_at_point_e", RexsStandardUnitIds.mm);

	/** Normal relative radius of curvature of calculation points (AGMA 925 A03) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId normal_relative_radius_of_curvature_of_calculation_points_agma_925_a03 = RexsAttributeId.create("normal_relative_radius_of_curvature_of_calculation_points_agma_925_a03", RexsStandardUnitIds.mm);

	/** Normal space width (Versions: 1.2, 1.3, 1.4) */
	RexsAttributeId normal_space_width_at_pitch_diameter = RexsAttributeId.create("normal_space_width_at_pitch_diameter", RexsStandardUnitIds.mm);

	/** Normal space width at reference diameter (Versions: 1.5, 1.6) */
	RexsAttributeId normal_space_width_at_reference_diameter = RexsAttributeId.create("normal_space_width_at_reference_diameter", RexsStandardUnitIds.mm);

	/** Normal space width (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId normal_space_width_din_5480_2006 = RexsAttributeId.create("normal_space_width_din_5480_2006", RexsStandardUnitIds.mm);

	/** Normal tip thickness for A_We (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId normal_tip_thickness = RexsAttributeId.create("normal_tip_thickness", RexsStandardUnitIds.mm);

	/** Normal tooth thickness at active root diameter (Versions: 1.5, 1.6) */
	RexsAttributeId normal_tooth_thickness_at_active_root_diameter = RexsAttributeId.create("normal_tooth_thickness_at_active_root_diameter", RexsStandardUnitIds.mm);

	/** Normal tooth thickness at active tip diameter (Versions: 1.5, 1.6) */
	RexsAttributeId normal_tooth_thickness_at_active_tip_diameter = RexsAttributeId.create("normal_tooth_thickness_at_active_tip_diameter", RexsStandardUnitIds.mm);

	/** Normal tooth thickness at pitch diameter (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId normal_tooth_thickness_at_pitch_diameter = RexsAttributeId.create("normal_tooth_thickness_at_pitch_diameter", RexsStandardUnitIds.mm);

	/** Normal tooth thickness at reference diameter (Versions: 1.5, 1.6) */
	RexsAttributeId normal_tooth_thickness_at_reference_diameter = RexsAttributeId.create("normal_tooth_thickness_at_reference_diameter", RexsStandardUnitIds.mm);

	/** Normal tooth thickness at root diameter (Versions: 1.5, 1.6) */
	RexsAttributeId normal_tooth_thickness_at_root_diameter = RexsAttributeId.create("normal_tooth_thickness_at_root_diameter", RexsStandardUnitIds.mm);

	/** Normal tooth thickness at root form diameter (Versions: 1.5, 1.6) */
	RexsAttributeId normal_tooth_thickness_at_root_form_diameter = RexsAttributeId.create("normal_tooth_thickness_at_root_form_diameter", RexsStandardUnitIds.mm);

	/** Normal tooth thickness at tip diameter (Versions: 1.5, 1.6) */
	RexsAttributeId normal_tooth_thickness_at_tip_diameter = RexsAttributeId.create("normal_tooth_thickness_at_tip_diameter", RexsStandardUnitIds.mm);

	/** Normal tooth thickness at tip form diameter (Versions: 1.5, 1.6) */
	RexsAttributeId normal_tooth_thickness_at_tip_form_diameter = RexsAttributeId.create("normal_tooth_thickness_at_tip_form_diameter", RexsStandardUnitIds.mm);

	/** Normal unit load (AGMA 925 A03) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId normal_unit_load_agma_925_a03 = RexsAttributeId.create("normal_unit_load_agma_925_a03", RexsStandardUnitIds.newton_per_mm);

	/** Notch calculation position (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId notch_calculation_position = RexsAttributeId.create("notch_calculation_position", RexsStandardUnitIds.none);

	/** Notch depth (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId notch_depth = RexsAttributeId.create("notch_depth", RexsStandardUnitIds.mm);

	/** Notch diameter (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId notch_diameter = RexsAttributeId.create("notch_diameter", RexsStandardUnitIds.mm);

	/** Notch diameter of probe (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId notch_diameter_of_probe_fkm_2012 = RexsAttributeId.create("notch_diameter_of_probe_fkm_2012", RexsStandardUnitIds.mm);

	/** Notch factor bending (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId notch_factor_bending_din_743_2012 = RexsAttributeId.create("notch_factor_bending_din_743_2012", RexsStandardUnitIds.none);

	/** Notch factor tension/ compression (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId notch_factor_tension_compression_din_743_2012 = RexsAttributeId.create("notch_factor_tension_compression_din_743_2012", RexsStandardUnitIds.none);

	/** Notch factor torsion (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId notch_factor_torsion_din_743_2012 = RexsAttributeId.create("notch_factor_torsion_din_743_2012", RexsStandardUnitIds.none);

	/** Bore radius (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId notch_hole_radius_din_743_2012 = RexsAttributeId.create("notch_hole_radius_din_743_2012", RexsStandardUnitIds.mm);

	/** Notch radius (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId notch_radius = RexsAttributeId.create("notch_radius", RexsStandardUnitIds.mm);

	/** Notch radius of probe (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId notch_radius_of_probe_fkm_2012 = RexsAttributeId.create("notch_radius_of_probe_fkm_2012", RexsStandardUnitIds.mm);

	/** Notch width (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId notch_width = RexsAttributeId.create("notch_width", RexsStandardUnitIds.mm);

	/** Number of load cycles at the point between limited life and long life (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId number_load_cycles_point_between_limited_life_and_long_life = RexsAttributeId.create("number_load_cycles_point_between_limited_life_and_long_life", RexsStandardUnitIds.none);

	/** Number of load cycles at the point between static and limited life (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId number_load_cycles_point_between_static_and_limited_life = RexsAttributeId.create("number_load_cycles_point_between_static_and_limited_life", RexsStandardUnitIds.none);

	/** Number of load cycles at the point within limited life (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId number_load_cycles_point_within_limited_life = RexsAttributeId.create("number_load_cycles_point_within_limited_life", RexsStandardUnitIds.none);

	/** Number of load cycles at the point within long life (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId number_load_cycles_point_within_long_life = RexsAttributeId.create("number_load_cycles_point_within_long_life", RexsStandardUnitIds.none);

	/** Number of load cycles at the point within static range (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId number_load_cycles_point_within_static_range = RexsAttributeId.create("number_load_cycles_point_within_static_range", RexsStandardUnitIds.none);

	/** Number of bearing rows (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId number_of_bearing_rows = RexsAttributeId.create("number_of_bearing_rows", RexsStandardUnitIds.none);

	/** Number of blade groups (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId number_of_blade_groups = RexsAttributeId.create("number_of_blade_groups", RexsStandardUnitIds.none);

	/** Number of blade groups (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId number_of_blade_groups_bevel_gear_tool = RexsAttributeId.create("number_of_blade_groups_bevel_gear_tool", RexsStandardUnitIds.none);

	/** Number of calculation points along the line of contact (AGMA 925 C95) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId number_of_calculation_points_along_the_line_of_action_agma_925_a03 = RexsAttributeId.create("number_of_calculation_points_along_the_line_of_action_agma_925_a03", RexsStandardUnitIds.none);

	/** Number of gears (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId number_of_gears = RexsAttributeId.create("number_of_gears", RexsStandardUnitIds.none);

	/** Number of keys (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId number_of_keys = RexsAttributeId.create("number_of_keys", RexsStandardUnitIds.none);

	/** Number of load cycles (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId number_of_load_cycles = RexsAttributeId.create("number_of_load_cycles", RexsStandardUnitIds.none);

	/** Number of load direction changes (DIN 6892 2012) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId number_of_load_direction_changes_din_6892_2012 = RexsAttributeId.create("number_of_load_direction_changes_din_6892_2012", RexsStandardUnitIds.none);

	/** Number of load peaks during operation (DIN 6892 2012) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId number_of_load_peaks_din_6892_2012 = RexsAttributeId.create("number_of_load_peaks_din_6892_2012", RexsStandardUnitIds.none);

	/** Number of nodes in mesh width for load distribution (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId number_of_nodes_in_mesh_width_for_loaddistribution = RexsAttributeId.create("number_of_nodes_in_mesh_width_for_loaddistribution", RexsStandardUnitIds.none);

	/** Number of points in y-direction (ISO 6336 2019) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId number_of_points_in_y_direction_iso_6336_2019 = RexsAttributeId.create("number_of_points_in_y_direction_iso_6336_2019", RexsStandardUnitIds.none);

	/** Number of rolling elements (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId number_of_rolling_elements = RexsAttributeId.create("number_of_rolling_elements", RexsStandardUnitIds.none);

	/** Number of teeth (Versions: 1.0, 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId number_of_teeth = RexsAttributeId.create("number_of_teeth", RexsStandardUnitIds.none);

	/** Measured number of teeth for base tangent length W_k (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId number_of_teeth_for_span_measurement = RexsAttributeId.create("number_of_teeth_for_span_measurement", RexsStandardUnitIds.none);

	/** Oil inlet or sump temperature (AGMA 925 C95) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId oil_inlet_or_sump_temperature_agma_925_a03 = RexsAttributeId.create("oil_inlet_or_sump_temperature_agma_925_a03", RexsStandardUnitIds.degree_celsius);

	/** Calculated oil sump temperature (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId oil_sump_temperature_din_3996_2019 = RexsAttributeId.create("oil_sump_temperature_din_3996_2019", RexsStandardUnitIds.degree_celsius);

	/** Operating axial bearing clearance (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId operating_axial_bearing_clearance = RexsAttributeId.create("operating_axial_bearing_clearance", RexsStandardUnitIds.mum);

	/** Operating helix angle (AGMA 925 A03) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId operating_helix_angle_agma_925_a03 = RexsAttributeId.create("operating_helix_angle_agma_925_a03", RexsStandardUnitIds.deg);

	/** Operating point stiffness dF_u / d_u (Versions: 1.0) */
	RexsAttributeId operating_point_stiffness_dF_u_d_u = RexsAttributeId.create("operating_point_stiffness_dF_u_d_u", RexsStandardUnitIds.newton_per_m);

	/** Operating point stiffness dF_u / d_v (Versions: 1.0) */
	RexsAttributeId operating_point_stiffness_dF_u_d_v = RexsAttributeId.create("operating_point_stiffness_dF_u_d_v", RexsStandardUnitIds.newton_per_m);

	/** Operating point stiffness dF_u / d_v_rot (Versions: 1.0) */
	RexsAttributeId operating_point_stiffness_dF_u_d_v_rot = RexsAttributeId.create("operating_point_stiffness_dF_u_d_v_rot", RexsStandardUnitIds.newton_per_radian);

	/** Operating point stiffness dF_u / d_w (Versions: 1.0) */
	RexsAttributeId operating_point_stiffness_dF_u_d_w = RexsAttributeId.create("operating_point_stiffness_dF_u_d_w", RexsStandardUnitIds.newton_per_m);

	/** Operating point stiffness dF_u / d_w_rot (Versions: 1.0) */
	RexsAttributeId operating_point_stiffness_dF_u_d_w_rot = RexsAttributeId.create("operating_point_stiffness_dF_u_d_w_rot", RexsStandardUnitIds.newton_per_radian);

	/** Operating point stiffness dF_v / d_u (Versions: 1.0) */
	RexsAttributeId operating_point_stiffness_dF_v_d_u = RexsAttributeId.create("operating_point_stiffness_dF_v_d_u", RexsStandardUnitIds.newton_per_m);

	/** Operating point stiffness dF_v / d_v (Versions: 1.0) */
	RexsAttributeId operating_point_stiffness_dF_v_d_v = RexsAttributeId.create("operating_point_stiffness_dF_v_d_v", RexsStandardUnitIds.newton_per_m);

	/** Operating point stiffness dF_v / d_v_rot (Versions: 1.0) */
	RexsAttributeId operating_point_stiffness_dF_v_d_v_rot = RexsAttributeId.create("operating_point_stiffness_dF_v_d_v_rot", RexsStandardUnitIds.newton_per_radian);

	/** Operating point stiffness dF_v / d_w (Versions: 1.0) */
	RexsAttributeId operating_point_stiffness_dF_v_d_w = RexsAttributeId.create("operating_point_stiffness_dF_v_d_w", RexsStandardUnitIds.newton_per_m);

	/** Operating point stiffness dF_v / d_w_rot (Versions: 1.0) */
	RexsAttributeId operating_point_stiffness_dF_v_d_w_rot = RexsAttributeId.create("operating_point_stiffness_dF_v_d_w_rot", RexsStandardUnitIds.newton_per_radian);

	/** Operating point stiffness dF_w / d_u (Versions: 1.0) */
	RexsAttributeId operating_point_stiffness_dF_w_d_u = RexsAttributeId.create("operating_point_stiffness_dF_w_d_u", RexsStandardUnitIds.newton_per_m);

	/** Operating point stiffness dF_w / d_v (Versions: 1.0) */
	RexsAttributeId operating_point_stiffness_dF_w_d_v = RexsAttributeId.create("operating_point_stiffness_dF_w_d_v", RexsStandardUnitIds.newton_per_m);

	/** Operating point stiffness dF_w / d_v_rot (Versions: 1.0) */
	RexsAttributeId operating_point_stiffness_dF_w_d_v_rot = RexsAttributeId.create("operating_point_stiffness_dF_w_d_v_rot", RexsStandardUnitIds.newton_per_radian);

	/** Operating point stiffness dF_w / d_w (Versions: 1.0) */
	RexsAttributeId operating_point_stiffness_dF_w_d_w = RexsAttributeId.create("operating_point_stiffness_dF_w_d_w", RexsStandardUnitIds.newton_per_m);

	/** Operating point stiffness dF_w / d_w_rot (Versions: 1.0) */
	RexsAttributeId operating_point_stiffness_dF_w_d_w_rot = RexsAttributeId.create("operating_point_stiffness_dF_w_d_w_rot", RexsStandardUnitIds.newton_per_radian);

	/** Operating point stiffness dM_v / d_u (Versions: 1.0) */
	RexsAttributeId operating_point_stiffness_dM_v_d_u = RexsAttributeId.create("operating_point_stiffness_dM_v_d_u", RexsStandardUnitIds.newton);

	/** Operating point stiffness dM_v / d_v (Versions: 1.0) */
	RexsAttributeId operating_point_stiffness_dM_v_d_v = RexsAttributeId.create("operating_point_stiffness_dM_v_d_v", RexsStandardUnitIds.newton);

	/** Operating point stiffness dM_v / d_v_rot (Versions: 1.0) */
	RexsAttributeId operating_point_stiffness_dM_v_d_v_rot = RexsAttributeId.create("operating_point_stiffness_dM_v_d_v_rot", RexsStandardUnitIds.newton_mm_per_rad);

	/** Operating point stiffness dM_v / d_w (Versions: 1.0) */
	RexsAttributeId operating_point_stiffness_dM_v_d_w = RexsAttributeId.create("operating_point_stiffness_dM_v_d_w", RexsStandardUnitIds.newton);

	/** Operating point stiffness dM_v / d_w_rot (Versions: 1.0) */
	RexsAttributeId operating_point_stiffness_dM_v_d_w_rot = RexsAttributeId.create("operating_point_stiffness_dM_v_d_w_rot", RexsStandardUnitIds.newton_mm_per_rad);

	/** Operating point stiffness dM_w / d_u (Versions: 1.0) */
	RexsAttributeId operating_point_stiffness_dM_w_d_u = RexsAttributeId.create("operating_point_stiffness_dM_w_d_u", RexsStandardUnitIds.newton);

	/** Operating point stiffness dM_w / d_v (Versions: 1.0) */
	RexsAttributeId operating_point_stiffness_dM_w_d_v = RexsAttributeId.create("operating_point_stiffness_dM_w_d_v", RexsStandardUnitIds.newton);

	/** Operating point stiffness dM_w / d_v_rot (Versions: 1.0) */
	RexsAttributeId operating_point_stiffness_dM_w_d_v_rot = RexsAttributeId.create("operating_point_stiffness_dM_w_d_v_rot", RexsStandardUnitIds.newton_mm_per_rad);

	/** Operating point stiffness dM_w / d_w (Versions: 1.0) */
	RexsAttributeId operating_point_stiffness_dM_w_d_w = RexsAttributeId.create("operating_point_stiffness_dM_w_d_w", RexsStandardUnitIds.newton);

	/** Operating point stiffness dM_w / d_w_rot (Versions: 1.0) */
	RexsAttributeId operating_point_stiffness_dM_w_d_w_rot = RexsAttributeId.create("operating_point_stiffness_dM_w_d_w_rot", RexsStandardUnitIds.newton_mm_per_rad);

	/** Operating point stiffness &part;F_u / &part;d_u (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId operating_point_stiffness_f_u_d_u = RexsAttributeId.create("operating_point_stiffness_f_u_d_u", RexsStandardUnitIds.newton_per_m);

	/** Operating point stiffness &part;F_u / &part;d_v (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId operating_point_stiffness_f_u_d_v = RexsAttributeId.create("operating_point_stiffness_f_u_d_v", RexsStandardUnitIds.newton_per_m);

	/** Operating point stiffness &part;F_u / &part;d_w (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId operating_point_stiffness_f_u_d_w = RexsAttributeId.create("operating_point_stiffness_f_u_d_w", RexsStandardUnitIds.newton_per_m);

	/** Operating point stiffness &part;F_u / &part;rot_v (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId operating_point_stiffness_f_u_rot_v = RexsAttributeId.create("operating_point_stiffness_f_u_rot_v", RexsStandardUnitIds.newton_per_radian);

	/** Operating point stiffness &part;F_u / &part;rot_w (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId operating_point_stiffness_f_u_rot_w = RexsAttributeId.create("operating_point_stiffness_f_u_rot_w", RexsStandardUnitIds.newton_per_radian);

	/** Operating point stiffness &part;F_v / &part;d_u (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId operating_point_stiffness_f_v_d_u = RexsAttributeId.create("operating_point_stiffness_f_v_d_u", RexsStandardUnitIds.newton_per_m);

	/** Operating point stiffness &part;F_v / &part;d_v (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId operating_point_stiffness_f_v_d_v = RexsAttributeId.create("operating_point_stiffness_f_v_d_v", RexsStandardUnitIds.newton_per_m);

	/** Operating point stiffness &part;F_v / &part;d_w (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId operating_point_stiffness_f_v_d_w = RexsAttributeId.create("operating_point_stiffness_f_v_d_w", RexsStandardUnitIds.newton_per_m);

	/** Operating point stiffness &part;F_v / &part;rot_v (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId operating_point_stiffness_f_v_rot_v = RexsAttributeId.create("operating_point_stiffness_f_v_rot_v", RexsStandardUnitIds.newton_per_radian);

	/** Operating point stiffness &part;F_v / &part;rot_w (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId operating_point_stiffness_f_v_rot_w = RexsAttributeId.create("operating_point_stiffness_f_v_rot_w", RexsStandardUnitIds.newton_per_radian);

	/** Operating point stiffness  &part;F_w / &part;d_u (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId operating_point_stiffness_f_w_d_u = RexsAttributeId.create("operating_point_stiffness_f_w_d_u", RexsStandardUnitIds.newton_per_m);

	/** Operating point stiffness &part;F_w / &part;d_v (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId operating_point_stiffness_f_w_d_v = RexsAttributeId.create("operating_point_stiffness_f_w_d_v", RexsStandardUnitIds.newton_per_m);

	/** Operating point stiffness &part;F_w / &part;d_w (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId operating_point_stiffness_f_w_d_w = RexsAttributeId.create("operating_point_stiffness_f_w_d_w", RexsStandardUnitIds.newton_per_m);

	/** Operating point stiffness &part;F_w / &part;rot_v (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId operating_point_stiffness_f_w_rot_v = RexsAttributeId.create("operating_point_stiffness_f_w_rot_v", RexsStandardUnitIds.newton_per_radian);

	/** Operating point stiffness &part;F_w / &part;rot_w (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId operating_point_stiffness_f_w_rot_w = RexsAttributeId.create("operating_point_stiffness_f_w_rot_w", RexsStandardUnitIds.newton_per_radian);

	/** Operating point stiffness &part;M_v / &part;d_u (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId operating_point_stiffness_m_v_d_u = RexsAttributeId.create("operating_point_stiffness_m_v_d_u", RexsStandardUnitIds.newton);

	/** Operating point stiffness &part;M_v / &part;d_v (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId operating_point_stiffness_m_v_d_v = RexsAttributeId.create("operating_point_stiffness_m_v_d_v", RexsStandardUnitIds.newton);

	/** Operating point stiffness &part;M_v / &part;d_w (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId operating_point_stiffness_m_v_d_w = RexsAttributeId.create("operating_point_stiffness_m_v_d_w", RexsStandardUnitIds.newton);

	/** Operating point stiffness &part;M_v / &part;rot_v (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId operating_point_stiffness_m_v_rot_v = RexsAttributeId.create("operating_point_stiffness_m_v_rot_v", RexsStandardUnitIds.newton_mm_per_rad);

	/** Operating point stiffness &part;M_v / &part;rot_w (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId operating_point_stiffness_m_v_rot_w = RexsAttributeId.create("operating_point_stiffness_m_v_rot_w", RexsStandardUnitIds.newton_mm_per_rad);

	/** Operating point stiffness &part;M_w / &part;d_u (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId operating_point_stiffness_m_w_d_u = RexsAttributeId.create("operating_point_stiffness_m_w_d_u", RexsStandardUnitIds.newton);

	/** Operating point stiffness &part;M_w / &part;d_v (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId operating_point_stiffness_m_w_d_v = RexsAttributeId.create("operating_point_stiffness_m_w_d_v", RexsStandardUnitIds.newton);

	/** Operating point stiffness &part;M_w / &part;d_w (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId operating_point_stiffness_m_w_d_w = RexsAttributeId.create("operating_point_stiffness_m_w_d_w", RexsStandardUnitIds.newton);

	/** Operating point stiffness &part;M_w / &part;rot_v (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId operating_point_stiffness_m_w_rot_v = RexsAttributeId.create("operating_point_stiffness_m_w_rot_v", RexsStandardUnitIds.newton_mm_per_rad);

	/** Operating point stiffness &part;M_w / &part;rot_w (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId operating_point_stiffness_m_w_rot_w = RexsAttributeId.create("operating_point_stiffness_m_w_rot_w", RexsStandardUnitIds.newton_mm_per_rad);

	/** Operating pressure angle (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId operating_pressure_angle = RexsAttributeId.create("operating_pressure_angle", RexsStandardUnitIds.deg);

	/** Operating pressure angle in the normal section (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId operating_pressure_angle_in_the_normal_section = RexsAttributeId.create("operating_pressure_angle_in_the_normal_section", RexsStandardUnitIds.deg);

	/** Operating pressure angle in the transverse section (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId operating_pressure_angle_in_the_transverse_section = RexsAttributeId.create("operating_pressure_angle_in_the_transverse_section", RexsStandardUnitIds.deg);

	/** Operating radial bearing clearance (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId operating_radial_bearing_clearance = RexsAttributeId.create("operating_radial_bearing_clearance", RexsStandardUnitIds.mum);

	/** Operating time (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId operating_time = RexsAttributeId.create("operating_time", RexsStandardUnitIds.hour);

	/** Time share of the total operating time (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId operating_time_fraction = RexsAttributeId.create("operating_time_fraction", RexsStandardUnitIds.percent);

	/** Desired service life for VDI 2736 2014 design calculation (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId operating_time_vdi_2736_2014 = RexsAttributeId.create("operating_time_vdi_2736_2014", RexsStandardUnitIds.hour);

	/** Kinematic viscosity of the lubricant at operating temperature (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId operating_viscosity = RexsAttributeId.create("operating_viscosity", RexsStandardUnitIds.mm2_per_s);

	/** Outer addendum (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId outer_addendum = RexsAttributeId.create("outer_addendum", RexsStandardUnitIds.mm);

	/** Outer reference cone distance (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId outer_cone_distance = RexsAttributeId.create("outer_cone_distance", RexsStandardUnitIds.mm);

	/** Outer dedendum (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId outer_dedendum = RexsAttributeId.create("outer_dedendum", RexsStandardUnitIds.mm);

	/** Outer diameter (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId outer_diameter = RexsAttributeId.create("outer_diameter", RexsStandardUnitIds.mm);

	/** Outer diameter begin (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId outer_diameter_begin = RexsAttributeId.create("outer_diameter_begin", RexsStandardUnitIds.mm);

	/** Outer diameter (DIN 3975 2017) (Versions: 1.2) */
	RexsAttributeId outer_diameter_din_3975_2017 = RexsAttributeId.create("outer_diameter_din_3975_2017", RexsStandardUnitIds.mm);

	/** Outer diameter end (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId outer_diameter_end = RexsAttributeId.create("outer_diameter_end", RexsStandardUnitIds.mm);

	/** Outer diameter hub (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId outer_diameter_hub_din_7190_2017 = RexsAttributeId.create("outer_diameter_hub_din_7190_2017", RexsStandardUnitIds.mm);

	/** Outer diameter (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId outer_diameter_worm_wheel = RexsAttributeId.create("outer_diameter_worm_wheel", RexsStandardUnitIds.mm);

	/** Outer pitch diameter (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId outer_pitch_diameter = RexsAttributeId.create("outer_pitch_diameter", RexsStandardUnitIds.mm);

	/** Outer transverse module (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId outer_transverse_module = RexsAttributeId.create("outer_transverse_module", RexsStandardUnitIds.mm);

	/** Outer whole depth (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId outer_whole_depth = RexsAttributeId.create("outer_whole_depth", RexsStandardUnitIds.mm);

	/** Overlap contact ratio (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId overlap_contact_ratio = RexsAttributeId.create("overlap_contact_ratio", RexsStandardUnitIds.none);

	/** Overload factor (AGMA 2101 C95) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId overload_factor_agma_2101_c95 = RexsAttributeId.create("overload_factor_agma_2101_c95", RexsStandardUnitIds.none);

	/** Overload factor (AGMA 925 C95) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId overload_factor_agma_925_a03 = RexsAttributeId.create("overload_factor_agma_925_a03", RexsStandardUnitIds.none);

	/** Overrolling frequency inner ring (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId overrolling_frequency_inner_ring = RexsAttributeId.create("overrolling_frequency_inner_ring", RexsStandardUnitIds.hertz);

	/** Overrolling frequency outer ring (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId overrolling_frequency_outer_ring = RexsAttributeId.create("overrolling_frequency_outer_ring", RexsStandardUnitIds.hertz);

	/** Overrolling frequency rolling element (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId overrolling_frequency_rolling_element = RexsAttributeId.create("overrolling_frequency_rolling_element", RexsStandardUnitIds.hertz);

	/** Parameter a_a for hardness according to method C2 (ISO 6336 2019) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId parameter_a_a_for_hardness_method_c2_iso_6336_2019 = RexsAttributeId.create("parameter_a_a_for_hardness_method_c2_iso_6336_2019", RexsStandardUnitIds.none);

	/** Parameter a_b  for hardness according to method C2 (ISO 6336 2019) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId parameter_a_b_for_hardness_method_c2_iso_6336_2019 = RexsAttributeId.create("parameter_a_b_for_hardness_method_c2_iso_6336_2019", RexsStandardUnitIds.none);

	/** Parameter A  for hardness according to method C2 (ISO 6336 2019) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId parameter_a_for_hardness_method_c2_iso_6336_2019 = RexsAttributeId.create("parameter_a_for_hardness_method_c2_iso_6336_2019", RexsStandardUnitIds.none);

	/** Parameter b_a  for hardness according to method C2 (ISO 6336 2019) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId parameter_b_a_for_hardness_method_c2_iso_6336_2019 = RexsAttributeId.create("parameter_b_a_for_hardness_method_c2_iso_6336_2019", RexsStandardUnitIds.none);

	/** Parameter b_b  for hardness according to method C2 (ISO 6336 2019) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId parameter_b_b_for_hardness_method_c2_iso_6336_2019 = RexsAttributeId.create("parameter_b_b_for_hardness_method_c2_iso_6336_2019", RexsStandardUnitIds.none);

	/** Parameter B  for hardness according to method C2 (ISO 6336 2019) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId parameter_b_for_hardness_method_c2_iso_6336_2019 = RexsAttributeId.create("parameter_b_for_hardness_method_c2_iso_6336_2019", RexsStandardUnitIds.none);

	/** Parameter c_a  for hardness according to method C2 (ISO 6336 2019) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId parameter_c_a_for_hardness_method_c2_iso_6336_2019 = RexsAttributeId.create("parameter_c_a_for_hardness_method_c2_iso_6336_2019", RexsStandardUnitIds.none);

	/** Parameter c_b  for hardness according to method C2 (ISO 6336 2019) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId parameter_c_b_for_hardness_method_c2_iso_6336_2019 = RexsAttributeId.create("parameter_c_b_for_hardness_method_c2_iso_6336_2019", RexsStandardUnitIds.none);

	/** Parameter C  for hardness according to method C2 (ISO 6336 2019) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId parameter_c_for_hardness_method_c2_iso_6336_2019 = RexsAttributeId.create("parameter_c_for_hardness_method_c2_iso_6336_2019", RexsStandardUnitIds.none);

	/** Parameter for calculating gear tooth temperature (AGMA 925 A03) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId parameter_for_calculation_of_tooth_temperature_agma_925_a03 = RexsAttributeId.create("parameter_for_calculation_of_tooth_temperature_agma_925_a03", RexsStandardUnitIds.none);

	/** Parameter for mean minimum lubricant film thickness (DIN 3996 2019) (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId parameter_for_mean_minimum_lubricant_film_thickness_din_3996_2019 = RexsAttributeId.create("parameter_for_mean_minimum_lubricant_film_thickness_din_3996_2019", RexsStandardUnitIds.none);

	/** Parameter k for calculating pressure-viscosity coefficient (AGMA 925 C95) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId parameter_k_for_calculation_of_pressure_viscosity_coefficient_agma_925_a03 = RexsAttributeId.create("parameter_k_for_calculation_of_pressure_viscosity_coefficient_agma_925_a03", RexsStandardUnitIds.none);

	/** Parameter for the mean hertzian stress (DIN 3996 2019) (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId parameter_mean_hertzian_stress_din_3996_2019 = RexsAttributeId.create("parameter_mean_hertzian_stress_din_3996_2019", RexsStandardUnitIds.none);

	/** Parameter for the mean sliding path (DIN 3996 2019) (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId parameter_mean_sliding_path_din_3996_2019 = RexsAttributeId.create("parameter_mean_sliding_path_din_3996_2019", RexsStandardUnitIds.none);

	/** Parameter s for calculating pressure-viscosity coefficient (AGMA 925 C95) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId parameter_s_for_calculation_of_pressure_viscosity_coefficient_agma_925_a03 = RexsAttributeId.create("parameter_s_for_calculation_of_pressure_viscosity_coefficient_agma_925_a03", RexsStandardUnitIds.none);

	/** Part number (Versions: 1.5, 1.6) */
	RexsAttributeId part_number = RexsAttributeId.create("part_number", RexsStandardUnitIds.none);

	/** Additional safety factor for castings (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId partial_cast_safety_consideration_fkm_2012 = RexsAttributeId.create("partial_cast_safety_consideration_fkm_2012", RexsStandardUnitIds.none);

	/** Partial contact ratio of tip path of contact (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId partial_contact_ratio = RexsAttributeId.create("partial_contact_ratio", RexsStandardUnitIds.none);

	/** Partial contact ratio (VDI 2736 2014) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId partial_contact_ratio_vdi_2736_2014 = RexsAttributeId.create("partial_contact_ratio_vdi_2736_2014", RexsStandardUnitIds.none);

	/** Peak circumferential force at reference circle (VDI 2736 2014) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId peak_tangential_force_at_reference_circle_vdi_2736_2014 = RexsAttributeId.create("peak_tangential_force_at_reference_circle_vdi_2736_2014", RexsStandardUnitIds.newton);

	/** Peak torque (DIN 6892 2012) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId peak_torque_din_6892_2012 = RexsAttributeId.create("peak_torque_din_6892_2012", RexsStandardUnitIds.newton_m);

	/** Permissible change to the circumferential backlash (Plewe 1980) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId permissible_change_to_the_circumferential_backlash_plewe_1980 = RexsAttributeId.create("permissible_change_to_the_circumferential_backlash_plewe_1980", RexsStandardUnitIds.mm);

	/** Permissible contact stress (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId permissible_contact_stress_iso_10300_2014 = RexsAttributeId.create("permissible_contact_stress_iso_10300_2014", RexsStandardUnitIds.newton_per_mm2);

	/** Permissible equivalent surface pressure hub (DIN 6892 2012) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId permissible_equivalent_surface_pressure_din_6892_2012 = RexsAttributeId.create("permissible_equivalent_surface_pressure_din_6892_2012", RexsStandardUnitIds.mega_pascal);

	/** Permissible equivalent surface pressure key (DIN 6892 2012) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId permissible_equivalent_surface_pressure_key_din_6892_2012 = RexsAttributeId.create("permissible_equivalent_surface_pressure_key_din_6892_2012", RexsStandardUnitIds.mega_pascal);

	/** Permissible equivalent surface pressure shaft (DIN 6892 2012) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId permissible_equivalent_surface_pressure_shaft_din_6892_2012 = RexsAttributeId.create("permissible_equivalent_surface_pressure_shaft_din_6892_2012", RexsStandardUnitIds.mega_pascal);

	/** Permissible flank pressure (VDI 2736 2014) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId permissible_flank_pressure_vdi_2736_2014 = RexsAttributeId.create("permissible_flank_pressure_vdi_2736_2014", RexsStandardUnitIds.newton_per_mm2);

	/** Permissible joining temperature hub (DIN 7190 2017) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId permissible_joining_temperature_hub_din_7190_2017 = RexsAttributeId.create("permissible_joining_temperature_hub_din_7190_2017", RexsStandardUnitIds.degree_celsius);

	/** Permissible linear wear (VDI 2736 2014) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId permissible_linear_wear_vdi_2736_2014 = RexsAttributeId.create("permissible_linear_wear_vdi_2736_2014", RexsStandardUnitIds.mm);

	/** Permissible local root stress under peak torque (VDI 2736 2014) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId permissible_local_root_stress_under_peak_torque_vdi_2736_2014 = RexsAttributeId.create("permissible_local_root_stress_under_peak_torque_vdi_2736_2014", RexsStandardUnitIds.newton_per_mm2);

	/** Permissible maximum surface pressure hub (DIN 6892 2012) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId permissible_maximum_surface_pressure_hub_din_6892_2012 = RexsAttributeId.create("permissible_maximum_surface_pressure_hub_din_6892_2012", RexsStandardUnitIds.mega_pascal);

	/** Permissible maximum surface pressure key (DIN 6892 2012) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId permissible_maximum_surface_pressure_key_din_6892_2012 = RexsAttributeId.create("permissible_maximum_surface_pressure_key_din_6892_2012", RexsStandardUnitIds.mega_pascal);

	/** Permissible maximum surface pressure shaft (DIN 6892 2012) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId permissible_maximum_surface_pressure_shaft_din_6892_2012 = RexsAttributeId.create("permissible_maximum_surface_pressure_shaft_din_6892_2012", RexsStandardUnitIds.mega_pascal);

	/** Permissible root stress (VDI 2736 2014) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId permissible_root_stress_vdi_2736_2014 = RexsAttributeId.create("permissible_root_stress_vdi_2736_2014", RexsStandardUnitIds.newton_per_mm2);

	/** Permissible scuffing temperature (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId permissible_scuffing_temperature_iso_10300_2021 = RexsAttributeId.create("permissible_scuffing_temperature_iso_10300_2021", RexsStandardUnitIds.degree_celsius);

	/** Permissible stress at the point between limited life and long life (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId permissible_stress_point_between_limited_life_and_long_life = RexsAttributeId.create("permissible_stress_point_between_limited_life_and_long_life", RexsStandardUnitIds.mega_pascal);

	/** Permissible stress at the point between static and limited life (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId permissible_stress_point_between_static_and_limited_life = RexsAttributeId.create("permissible_stress_point_between_static_and_limited_life", RexsStandardUnitIds.mega_pascal);

	/** Permissible stress at the point within limited life (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId permissible_stress_point_within_limited_life = RexsAttributeId.create("permissible_stress_point_within_limited_life", RexsStandardUnitIds.mega_pascal);

	/** Permissible stress at the point within long life (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId permissible_stress_point_within_long_life = RexsAttributeId.create("permissible_stress_point_within_long_life", RexsStandardUnitIds.mega_pascal);

	/** Permissible stress at the point within static range (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId permissible_stress_within_static_range = RexsAttributeId.create("permissible_stress_within_static_range", RexsStandardUnitIds.mega_pascal);

	/** Permissible temperature (VDI 2736 2014) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId permissible_temperature_vdi_2736_2014 = RexsAttributeId.create("permissible_temperature_vdi_2736_2014", RexsStandardUnitIds.degree_celsius);

	/** Permissible tooth root stress (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId permissible_tooth_root_stress_iso_10300_2014 = RexsAttributeId.create("permissible_tooth_root_stress_iso_10300_2014", RexsStandardUnitIds.newton_per_mm2);

	/** Permissible wear erosion (Plewe 1980) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId permissible_wear_erosion_plewe_1980 = RexsAttributeId.create("permissible_wear_erosion_plewe_1980", RexsStandardUnitIds.mm);

	/** Permissible wear mass (Plewe 1980) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId permissible_wear_mass_plewe_1980 = RexsAttributeId.create("permissible_wear_mass_plewe_1980", RexsStandardUnitIds.mg);

	/** Tolerance class of shaft (Versions: 1.0) */
	RexsAttributeId pin_tolerance_class = RexsAttributeId.create("pin_tolerance_class", RexsStandardUnitIds.none);

	/** Pitch angle (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId pitch_angle = RexsAttributeId.create("pitch_angle", RexsStandardUnitIds.deg);

	/** Pitch apex beyond crossing point (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId pitch_apex_beyond_crossing_point = RexsAttributeId.create("pitch_apex_beyond_crossing_point", RexsStandardUnitIds.mm);

	/** Pitch circle diameter (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId pitch_diameter = RexsAttributeId.create("pitch_diameter", RexsStandardUnitIds.mm);

	/** Pitting resistance geometry factor (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId pitting_resistance_geometry_factor_iso_10300_2014 = RexsAttributeId.create("pitting_resistance_geometry_factor_iso_10300_2014", RexsStandardUnitIds.none);

	/** Point coordinates - cartesian (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId point_coordinates = RexsAttributeId.create("point_coordinates", RexsStandardUnitIds.mm);

	/** Point coordinates - angle about u-axis (Versions: 1.6) */
	RexsAttributeId point_coordinates_angle_about_u_axis = RexsAttributeId.create("point_coordinates_angle_about_u_axis", RexsStandardUnitIds.deg);

	/** Point coordinates - angle to u axis (Versions: 1.6) */
	RexsAttributeId point_coordinates_angle_to_u_axis = RexsAttributeId.create("point_coordinates_angle_to_u_axis", RexsStandardUnitIds.deg);

	/** Point coordinates - radius (Versions: 1.6) */
	RexsAttributeId point_coordinates_radius = RexsAttributeId.create("point_coordinates_radius", RexsStandardUnitIds.mm);

	/** Point coordinates - u coordinate (Versions: 1.6) */
	RexsAttributeId point_coordinates_u_coord = RexsAttributeId.create("point_coordinates_u_coord", RexsStandardUnitIds.mm);

	/** Point Ids (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId point_ids = RexsAttributeId.create("point_ids", RexsStandardUnitIds.none);

	/** Core hardness depth (ISO 6336 2019) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId point_of_core_hardeness_iso_6336_2019 = RexsAttributeId.create("point_of_core_hardeness_iso_6336_2019", RexsStandardUnitIds.mm);

	/** Point of maximum material exposure (ISO 6336 2019) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId point_of_maximum_material_exposure_iso_6336_2019 = RexsAttributeId.create("point_of_maximum_material_exposure_iso_6336_2019", RexsStandardUnitIds.none);

	/** Poisson's ratio (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId poisson_ratio = RexsAttributeId.create("poisson_ratio", RexsStandardUnitIds.none);

	/** Poisson's ratio at operating temperature (VDI 2736 2014) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId poissons_ratio_vdi_2736_2014 = RexsAttributeId.create("poissons_ratio_vdi_2736_2014", RexsStandardUnitIds.none);

	/** Face width coordinate of profile deviations (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId position_of_profile_deviation = RexsAttributeId.create("position_of_profile_deviation", RexsStandardUnitIds.mm);

	/** Face width coordinate of the profile modification (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId position_of_profile_modification = RexsAttributeId.create("position_of_profile_modification", RexsStandardUnitIds.mm);

	/** Facewidth coordinate of the profile twist modification on datum face (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId position_of_profile_twist_datum_face = RexsAttributeId.create("position_of_profile_twist_datum_face", RexsStandardUnitIds.mm);

	/** Facewidth coordinate of the profile twist modification on non-datum face (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId position_of_profile_twist_non_datum_face = RexsAttributeId.create("position_of_profile_twist_non_datum_face", RexsStandardUnitIds.mm);

	/** Position of rolling elements (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId position_of_rolling_elements = RexsAttributeId.create("position_of_rolling_elements", RexsStandardUnitIds.none);

	/** Power with sign (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId power = RexsAttributeId.create("power", RexsStandardUnitIds.kilo_watt);

	/** Rolling output (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId power_for_rolling_rotational_speed = RexsAttributeId.create("power_for_rolling_rotational_speed", RexsStandardUnitIds.watt);

	/** Power (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId power_for_rotational_speed = RexsAttributeId.create("power_for_rotational_speed", RexsStandardUnitIds.watt);

	/** Preload distance (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId preload_distance = RexsAttributeId.create("preload_distance", RexsStandardUnitIds.mum);

	/** Preload distance (Versions: 1.6) */
	RexsAttributeId preload_distance_surface_contact = RexsAttributeId.create("preload_distance_surface_contact", RexsStandardUnitIds.mum);

	/** Preload force (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId preload_force = RexsAttributeId.create("preload_force", RexsStandardUnitIds.newton);

	/** Preload of the segment running surface (Versions: 1.6) */
	RexsAttributeId preload_running_surface_plain_bearing = RexsAttributeId.create("preload_running_surface_plain_bearing", RexsStandardUnitIds.none);

	/** Pressure angle (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId pressure_angle = RexsAttributeId.create("pressure_angle", RexsStandardUnitIds.deg);

	/** Pressure angle correction (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId pressure_angle_correction = RexsAttributeId.create("pressure_angle_correction", RexsStandardUnitIds.deg);

	/** Pressure angle (DIN 3975 2017) (Versions: 1.2) */
	RexsAttributeId pressure_angle_din_3975_2017 = RexsAttributeId.create("pressure_angle_din_3975_2017", RexsStandardUnitIds.deg);

	/** Pressure angle in the transverse section (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId pressure_angle_in_the_transverse_section = RexsAttributeId.create("pressure_angle_in_the_transverse_section", RexsStandardUnitIds.deg);

	/** Pressure angle (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId pressure_angle_worm_gear = RexsAttributeId.create("pressure_angle_worm_gear", RexsStandardUnitIds.deg);

	/** Pressure factor (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId pressure_factor_din_3996_2019 = RexsAttributeId.create("pressure_factor_din_3996_2019", RexsStandardUnitIds.none);

	/** Pressure viscosity coefficient (AGMA 925 C95) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId pressure_viscosity_coefficient_agma_925_a03 = RexsAttributeId.create("pressure_viscosity_coefficient_agma_925_a03", RexsStandardUnitIds.mm2_per_newton);

	/** Pressure-viscosity coefficient at 38 &deg;C (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId pressure_viscosity_coefficient_at_38_degrees_celsius = RexsAttributeId.create("pressure_viscosity_coefficient_at_38_degrees_celsius", RexsStandardUnitIds.mm2_per_newton);

	/** Probability of scuffing (AGMA 925 A03) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId probability_of_scuffing_agma_925_a03 = RexsAttributeId.create("probability_of_scuffing_agma_925_a03", RexsStandardUnitIds.none);

	/** Probability of survival (Versions: 1.4) */
	RexsAttributeId probability_of_survival = RexsAttributeId.create("probability_of_survival", RexsStandardUnitIds.percent);

	/** Probability of wear (AGMA 925 A03) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId probability_of_wear_agma_925_a03 = RexsAttributeId.create("probability_of_wear_agma_925_a03", RexsStandardUnitIds.none);

	/** Amount of profile crowning at the root (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId profile_crowning_at_root = RexsAttributeId.create("profile_crowning_at_root", RexsStandardUnitIds.mm);

	/** Amount of profile crowning at the tip (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId profile_crowning_at_tip = RexsAttributeId.create("profile_crowning_at_tip", RexsStandardUnitIds.mm);

	/** Curvature diameter of the circular profile (Versions: 1.6) */
	RexsAttributeId profile_curvature_diameter_plain_bearing = RexsAttributeId.create("profile_curvature_diameter_plain_bearing", RexsStandardUnitIds.mm);

	/** Amount of profile deviations (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId profile_deviation_amounts = RexsAttributeId.create("profile_deviation_amounts", RexsStandardUnitIds.mm);

	/** End diameter of profile evaluation (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId profile_evaluation_end = RexsAttributeId.create("profile_evaluation_end", RexsStandardUnitIds.mm);

	/** Profile control diameter (start of evaluation) (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId profile_evaluation_start = RexsAttributeId.create("profile_evaluation_start", RexsStandardUnitIds.mm);

	/** Diameter of highest point in profile (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId profile_highest_point = RexsAttributeId.create("profile_highest_point", RexsStandardUnitIds.mm);

	/** Profile line length of the active tooth flank (VDI 2736 2014) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId profile_line_length_of_the_active_tooth_flank_vdi_2736_2014 = RexsAttributeId.create("profile_line_length_of_the_active_tooth_flank_vdi_2736_2014", RexsStandardUnitIds.mm);

	/** Profile modification (AGMA 925 C95) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId profile_modification_agma_925_a03 = RexsAttributeId.create("profile_modification_agma_925_a03", RexsStandardUnitIds.none);

	/** Profile radius (type ZC) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId profile_radius_zc_disc = RexsAttributeId.create("profile_radius_zc_disc", RexsStandardUnitIds.mm);

	/** Profile shift coefficient (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId profile_shift_coefficient = RexsAttributeId.create("profile_shift_coefficient", RexsStandardUnitIds.none);

	/** Amount of profile slope modification (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId profile_slope = RexsAttributeId.create("profile_slope", RexsStandardUnitIds.mm);

	/** Amount of profile twist modification (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId profile_twist = RexsAttributeId.create("profile_twist", RexsStandardUnitIds.mm);

	/** End diameter of evaluation of the profile twist (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId profile_twist_evaluation_end = RexsAttributeId.create("profile_twist_evaluation_end", RexsStandardUnitIds.mm);

	/** Profile control diameter (start of evaluation) of the profile twist (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId profile_twist_evaluation_start = RexsAttributeId.create("profile_twist_evaluation_start", RexsStandardUnitIds.mm);

	/** Profiling (Versions: 1.6) */
	RexsAttributeId profiling_plain_bearing = RexsAttributeId.create("profiling_plain_bearing", RexsStandardUnitIds.none);

	/** Protuberance amount (Versions: 1.0, 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId protuberance_amount = RexsAttributeId.create("protuberance_amount", RexsStandardUnitIds.mm);

	/** Protuberance amount factor (Versions: 1.0, 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId protuberance_amount_factor = RexsAttributeId.create("protuberance_amount_factor", RexsStandardUnitIds.none);

	/** Protuberance angle (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId protuberance_angle = RexsAttributeId.create("protuberance_angle", RexsStandardUnitIds.deg);

	/** Protuberance angle (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId protuberance_angle_bevel_gear_tool = RexsAttributeId.create("protuberance_angle_bevel_gear_tool", RexsStandardUnitIds.deg);

	/** Protuberance height (Versions: 1.0, 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId protuberance_height = RexsAttributeId.create("protuberance_height", RexsStandardUnitIds.mm);

	/** Protuberance height (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId protuberance_height_bevel_gear_tool = RexsAttributeId.create("protuberance_height_bevel_gear_tool", RexsStandardUnitIds.mm);

	/** Protuberance height factor (Versions: 1.0, 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId protuberance_height_factor = RexsAttributeId.create("protuberance_height_factor", RexsStandardUnitIds.none);

	/** Protuberance radius (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId protuberance_radius_bevel_gear_tool = RexsAttributeId.create("protuberance_radius_bevel_gear_tool", RexsStandardUnitIds.mm);

	/** Radius of raceway at inner ring (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId raceway_radius_of_inner_ring = RexsAttributeId.create("raceway_radius_of_inner_ring", RexsStandardUnitIds.mm);

	/** Radius of raceway at outer ring (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId raceway_radius_of_outer_ring = RexsAttributeId.create("raceway_radius_of_outer_ring", RexsStandardUnitIds.mm);

	/** Radial backlash (Versions: 1.0) */
	RexsAttributeId radial_backlash = RexsAttributeId.create("radial_backlash", RexsStandardUnitIds.mum);

	/** Radial bearing clearance (before mounting) (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId radial_bearing_clearance = RexsAttributeId.create("radial_bearing_clearance", RexsStandardUnitIds.mum);

	/** Radial clearance (Versions: 1.5, 1.6) */
	RexsAttributeId radial_clearance = RexsAttributeId.create("radial_clearance", RexsStandardUnitIds.mum);

	/** Radial bearing clearance class (before mounting) (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId radial_clearance_class = RexsAttributeId.create("radial_clearance_class", RexsStandardUnitIds.none);

	/** Radial contact ratio (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId radial_contact_ratio = RexsAttributeId.create("radial_contact_ratio", RexsStandardUnitIds.none);

	/** Relative displacement of the inner ring in the v-direction compared to the outer ring (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId radial_deflection_in_v = RexsAttributeId.create("radial_deflection_in_v", RexsStandardUnitIds.mum);

	/** Relative displacement of the inner ring in the w-direction compared to the outer ring (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId radial_deflection_in_w = RexsAttributeId.create("radial_deflection_in_w", RexsStandardUnitIds.mum);

	/** Radial distance (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId radial_distance = RexsAttributeId.create("radial_distance", RexsStandardUnitIds.mm);

	/** Radial dynamic load rating (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId radial_dynamic_load_rating = RexsAttributeId.create("radial_dynamic_load_rating", RexsStandardUnitIds.kilo_newton);

	/** Radial load factor X1 for F_a/F_r &lt;=  e (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId radial_factor_x_1 = RexsAttributeId.create("radial_factor_x_1", RexsStandardUnitIds.none);

	/** Radial load factor X2 for F_a/F_r &gt;  e (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId radial_factor_x_2 = RexsAttributeId.create("radial_factor_x_2", RexsStandardUnitIds.none);

	/** Support of radial loads (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId radial_force_absorption = RexsAttributeId.create("radial_force_absorption", RexsStandardUnitIds.none);

	/** Radial force in v-direction (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId radial_force_in_v = RexsAttributeId.create("radial_force_in_v", RexsStandardUnitIds.kilo_newton);

	/** Radial force in w-direction (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId radial_force_in_w = RexsAttributeId.create("radial_force_in_w", RexsStandardUnitIds.kilo_newton);

	/** Radial machining allowance (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId radial_maching_allowance_din_509_2006 = RexsAttributeId.create("radial_maching_allowance_din_509_2006", RexsStandardUnitIds.mm);

	/** Radial motion coefficients (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId radial_motion_coefficients = RexsAttributeId.create("radial_motion_coefficients", RexsStandardUnitIds.none);

	/** Radial static load rating (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId radial_static_load_rating = RexsAttributeId.create("radial_static_load_rating", RexsStandardUnitIds.kilo_newton);

	/** Radial stiffness (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId radial_stiffness = RexsAttributeId.create("radial_stiffness", RexsStandardUnitIds.newton_per_m);

	/** Radius of curvature at Point A (Plewe 1980) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId radius_of_curvature_at_point_a_plewe_1980 = RexsAttributeId.create("radius_of_curvature_at_point_a_plewe_1980", RexsStandardUnitIds.mm);

	/** Radius of curvature at Point E (Plewe 1980) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId radius_of_curvature_at_point_e_plewe_1980 = RexsAttributeId.create("radius_of_curvature_at_point_e_plewe_1980", RexsStandardUnitIds.mm);

	/** Rakeface inclination angle (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId rakeface_inclination_angle = RexsAttributeId.create("rakeface_inclination_angle", RexsStandardUnitIds.deg);

	/** Ratio of roll (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId ratio_of_roll = RexsAttributeId.create("ratio_of_roll", RexsStandardUnitIds.none);

	/** Reduced modulus of elasticity (AGMA 925 A03) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId reduced_modulus_of_elasticity_agma_925_a03 = RexsAttributeId.create("reduced_modulus_of_elasticity_agma_925_a03", RexsStandardUnitIds.newton_per_mm2);

	/** Reduced modulus of elasticity (ISO 6336 2019) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId reduced_modulus_of_elasticity_iso_6336_2019 = RexsAttributeId.create("reduced_modulus_of_elasticity_iso_6336_2019", RexsStandardUnitIds.newton_per_mm2);

	/** Reduced static stiffness matrix (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId reduced_static_stiffness_matrix = RexsAttributeId.create("reduced_static_stiffness_matrix", RexsStandardUnitIds.none);

	/** Reference circle diameter (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId reference_circle_diameter = RexsAttributeId.create("reference_circle_diameter", RexsStandardUnitIds.mm);

	/** Reference component for position (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId reference_component_for_position = RexsAttributeId.create("reference_component_for_position", RexsStandardUnitIds.none);

	/** Reference diameter (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId reference_diameter = RexsAttributeId.create("reference_diameter", RexsStandardUnitIds.mm);

	/** Reference diameter (DIN 3975 2017) (Versions: 1.2) */
	RexsAttributeId reference_diameter_din_3975_2017 = RexsAttributeId.create("reference_diameter_din_3975_2017", RexsStandardUnitIds.mm);

	/** Reference diameter (DIN 5480 2006) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId reference_diameter_din_5480_2006 = RexsAttributeId.create("reference_diameter_din_5480_2006", RexsStandardUnitIds.mm);

	/** Reference diameter of virtual cylindrical gear in normal section (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId reference_diameter_normal_section_virtual_cylindrical_gear_iso_10300_2014 = RexsAttributeId.create("reference_diameter_normal_section_virtual_cylindrical_gear_iso_10300_2014", RexsStandardUnitIds.mm);

	/** Reference diameter of relative plain bearing clearance (Versions: 1.6) */
	RexsAttributeId reference_diameter_relative_clearance_plain_bearing = RexsAttributeId.create("reference_diameter_relative_clearance_plain_bearing", RexsStandardUnitIds.mm);

	/** Reference diameter of virtual cylindrical gear (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId reference_diameter_virtual_cylindrical_gear_iso_10300_2014 = RexsAttributeId.create("reference_diameter_virtual_cylindrical_gear_iso_10300_2014", RexsStandardUnitIds.mm);

	/** Reference diameter (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId reference_diameter_worm_gear = RexsAttributeId.create("reference_diameter_worm_gear", RexsStandardUnitIds.mm);

	/** Reference lead angle (DIN 3975 2017) (Versions: 1.2) */
	RexsAttributeId reference_lead_angle_din_3975_2017 = RexsAttributeId.create("reference_lead_angle_din_3975_2017", RexsStandardUnitIds.deg);

	/** Reference speed according ISO 15312 (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId reference_speed = RexsAttributeId.create("reference_speed", RexsStandardUnitIds.rotation_per_min);

	/** Reference temperature (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId reference_temperature = RexsAttributeId.create("reference_temperature", RexsStandardUnitIds.degree_celsius);

	/** Reference wear intensity (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId reference_wear_intensity_din_3996_2019 = RexsAttributeId.create("reference_wear_intensity_din_3996_2019", RexsStandardUnitIds.none);

	/** Id of referenced component (Versions: 1.5, 1.6) */
	RexsAttributeId referenced_component_id = RexsAttributeId.create("referenced_component_id", RexsStandardUnitIds.none);

	/** Related tip thickness (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId related_tip_thickness = RexsAttributeId.create("related_tip_thickness", RexsStandardUnitIds.none);

	/** Relativ surface factor (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId relativ_surface_factor_tooth_root_iso_10300_2014 = RexsAttributeId.create("relativ_surface_factor_tooth_root_iso_10300_2014", RexsStandardUnitIds.none);

	/** Relative plain bearing clearance (Versions: 1.6) */
	RexsAttributeId relative_clearance_plain_bearing = RexsAttributeId.create("relative_clearance_plain_bearing", RexsStandardUnitIds.percent);

	/** Distance from datum line to measuring line relative to the normal module (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId relative_distance_tool_profile_basic_line_to_measuring_line = RexsAttributeId.create("relative_distance_tool_profile_basic_line_to_measuring_line", RexsStandardUnitIds.none);

	/** Relative duty cycle (VDI 2736 2014) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId relative_duty_cycle_vdi_2736_2014 = RexsAttributeId.create("relative_duty_cycle_vdi_2736_2014", RexsStandardUnitIds.none);

	/** Relative eccentricity (Versions: 1.6) */
	RexsAttributeId relative_eccentricity_plain_bearing = RexsAttributeId.create("relative_eccentricity_plain_bearing", RexsStandardUnitIds.none);

	/** Lever arm for load at tip to 30 degree tangent (relative to module) (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId relative_lever_arm_for_load_at_tip_to_30_degree_tangent = RexsAttributeId.create("relative_lever_arm_for_load_at_tip_to_30_degree_tangent", RexsStandardUnitIds.none);

	/** Machining allowance of the tool (relative to the normal module) (Versions: 1.2) */
	RexsAttributeId relative_machining_allowance = RexsAttributeId.create("relative_machining_allowance", RexsStandardUnitIds.none);

	/** Machining allowance of the tool according to DIN 3972 (relative to the normal module) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId relative_machining_allowance_din_3972 = RexsAttributeId.create("relative_machining_allowance_din_3972", RexsStandardUnitIds.none);

	/** Relative material structure factor (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId relative_material_structure_factor_iso_10300_2021 = RexsAttributeId.create("relative_material_structure_factor_iso_10300_2021", RexsStandardUnitIds.none);

	/** Tool b_z0* measurement (relative to module) (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId relative_measurement_bz0 = RexsAttributeId.create("relative_measurement_bz0", RexsStandardUnitIds.none);

	/** Tooth root chord at the 30&deg; tangent (relative to module) (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId relative_tooth_root_chord_at_30_degree_tangent = RexsAttributeId.create("relative_tooth_root_chord_at_30_degree_tangent", RexsStandardUnitIds.none);

	/** Tooth root radius at the 30&deg; tangent (relative to module) (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId relative_tooth_root_radius_at_30_degree_tangent = RexsAttributeId.create("relative_tooth_root_radius_at_30_degree_tangent", RexsStandardUnitIds.none);

	/** Remaining protuberance (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId remaining_protuberance = RexsAttributeId.create("remaining_protuberance", RexsStandardUnitIds.mm);

	/** Required minimum tooth flank safety factor (VDI 2736 2014) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId required_minimum_safety_factor_flank_vdi_2736_2014 = RexsAttributeId.create("required_minimum_safety_factor_flank_vdi_2736_2014", RexsStandardUnitIds.none);

	/** Required tooth root minimum safety factor (Plewe 1980) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId required_minimum_safety_factor_root_plewe_1980 = RexsAttributeId.create("required_minimum_safety_factor_root_plewe_1980", RexsStandardUnitIds.none);

	/** Required minimum tooth root safety factor (VDI 2736 2014) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId required_minimum_safety_factor_root_vdi_2736_2014 = RexsAttributeId.create("required_minimum_safety_factor_root_vdi_2736_2014", RexsStandardUnitIds.none);

	/** Required minimum safety factor for exceeding the yield strength (VDI 2736 2014) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId required_minimum_safety_factor_yield_strength_vdi_2736_2014 = RexsAttributeId.create("required_minimum_safety_factor_yield_strength_vdi_2736_2014", RexsStandardUnitIds.none);

	/** Revision number (Versions: 1.5, 1.6) */
	RexsAttributeId revision_number = RexsAttributeId.create("revision_number", RexsStandardUnitIds.none);

	/** Rim thickness factor (tooth bending) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId rim_thickness_factor_tooth_bending_din_3996_2019 = RexsAttributeId.create("rim_thickness_factor_tooth_bending_din_3996_2019", RexsStandardUnitIds.none);

	/** Rim width (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId rim_width_worm_wheel = RexsAttributeId.create("rim_width_worm_wheel", RexsStandardUnitIds.mm);

	/** Roll angles of calculation points (AGMA 925 A03) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId roll_angles_of_calculation_points_agma_925_a03 = RexsAttributeId.create("roll_angles_of_calculation_points_agma_925_a03", RexsStandardUnitIds.radian);

	/** Roller angle (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId roller_angle = RexsAttributeId.create("roller_angle", RexsStandardUnitIds.deg);

	/** Roller crowning radius (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId roller_crowning_radius = RexsAttributeId.create("roller_crowning_radius", RexsStandardUnitIds.mm);

	/** Surface radius of roller (Versions: 1.0) */
	RexsAttributeId roller_shell_radius = RexsAttributeId.create("roller_shell_radius", RexsStandardUnitIds.mm);

	/** Path of bearing file (Versions: 1.0) */
	RexsAttributeId rolling_bearing_file = RexsAttributeId.create("rolling_bearing_file", RexsStandardUnitIds.none);

	/** Rolling contact fatigue strength (VDI 2736 2014) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId rolling_contact_fatigue_strength_vdi_2736_2014 = RexsAttributeId.create("rolling_contact_fatigue_strength_vdi_2736_2014", RexsStandardUnitIds.newton_per_mm2);

	/** Contact type (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId rolling_element_contact_type = RexsAttributeId.create("rolling_element_contact_type", RexsStandardUnitIds.none);

	/** Coordinates on rolling element (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId rolling_element_coordinate = RexsAttributeId.create("rolling_element_coordinate", RexsStandardUnitIds.mm);

	/** Rolling element force (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId rolling_element_force = RexsAttributeId.create("rolling_element_force", RexsStandardUnitIds.kilo_newton);

	/** Rolling element lamina load (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId rolling_element_lamina_load = RexsAttributeId.create("rolling_element_lamina_load", RexsStandardUnitIds.newton);

	/** Rolling element pressure (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId rolling_element_pressure = RexsAttributeId.create("rolling_element_pressure", RexsStandardUnitIds.newton_per_mm2);

	/** Rolling element torque (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId rolling_element_torque = RexsAttributeId.create("rolling_element_torque", RexsStandardUnitIds.newton_m);

	/** Rolling length where amount of modification is specified (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId rolling_length_where_profile_slope_amount_is_specified = RexsAttributeId.create("rolling_length_where_profile_slope_amount_is_specified", RexsStandardUnitIds.mm);

	/** Rolling length where amount of profile twist is specified (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId rolling_length_where_profile_twist_amount_is_specified = RexsAttributeId.create("rolling_length_where_profile_twist_amount_is_specified", RexsStandardUnitIds.mm);

	/** Rolling rotational speed (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId rolling_rotational_speed = RexsAttributeId.create("rolling_rotational_speed", RexsStandardUnitIds.rotation_per_min);

	/** Rolling tangential velocity at the calculation points (AGMA 925 A03) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId rolling_tangential_velocity_of_calculation_points_agma_925_a03 = RexsAttributeId.create("rolling_tangential_velocity_of_calculation_points_agma_925_a03", RexsStandardUnitIds.m_per_second);

	/** Root angle (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId root_angle = RexsAttributeId.create("root_angle", RexsStandardUnitIds.deg);

	/** Root apex beyond crossing point (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId root_apex_beyond_crossing_point = RexsAttributeId.create("root_apex_beyond_crossing_point", RexsStandardUnitIds.mm);

	/** Root diameter (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId root_diameter = RexsAttributeId.create("root_diameter", RexsStandardUnitIds.mm);

	/** Root diameter (DIN 3975 2017) (Versions: 1.2) */
	RexsAttributeId root_diameter_din_3975_2017 = RexsAttributeId.create("root_diameter_din_3975_2017", RexsStandardUnitIds.mm);

	/** Root diameter of virtual cylindrical gear (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId root_diameter_virtual_cylindrical_gear_iso_10300_2014 = RexsAttributeId.create("root_diameter_virtual_cylindrical_gear_iso_10300_2014", RexsStandardUnitIds.mm);

	/** Root diameter (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId root_diameter_worm_gear = RexsAttributeId.create("root_diameter_worm_gear", RexsStandardUnitIds.mm);

	/** Root form diameter (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId root_form_diameter = RexsAttributeId.create("root_form_diameter", RexsStandardUnitIds.mm);

	/** Root mean square roughness at filter cutoff of wavelength (AGMA 925 A03) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId root_mean_square_roughness_at_filter_cutoff_of_wavelength_agma_925_a03 = RexsAttributeId.create("root_mean_square_roughness_at_filter_cutoff_of_wavelength_agma_925_a03", RexsStandardUnitIds.mum);

	/** Diameter at start of root relief (reference diameter) (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId root_relief_datum_diameter = RexsAttributeId.create("root_relief_datum_diameter", RexsStandardUnitIds.mm);

	/** Length of root relief (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId root_relief_datum_length = RexsAttributeId.create("root_relief_datum_length", RexsStandardUnitIds.mm);

	/** Depth of root relief (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId root_relief_depth = RexsAttributeId.create("root_relief_depth", RexsStandardUnitIds.mm);

	/** Diameter where tangential transition area ends (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId root_relief_diameter_where_tangential_transition_ends = RexsAttributeId.create("root_relief_diameter_where_tangential_transition_ends", RexsStandardUnitIds.mm);

	/** Diameter where tangential transition area starts (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId root_relief_diameter_where_tangential_transition_starts = RexsAttributeId.create("root_relief_diameter_where_tangential_transition_starts", RexsStandardUnitIds.mm);

	/** Diameter where amount of modification is specified (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId root_relief_evaluation_reference = RexsAttributeId.create("root_relief_evaluation_reference", RexsStandardUnitIds.mm);

	/** Length where amount of modification is specified (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId root_relief_evaluation_reference_length = RexsAttributeId.create("root_relief_evaluation_reference_length", RexsStandardUnitIds.mm);

	/** Length of tangential transition area end (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId root_relief_length_of_tangential_transition_end = RexsAttributeId.create("root_relief_length_of_tangential_transition_end", RexsStandardUnitIds.mm);

	/** Length of tangential transition area start (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId root_relief_length_of_tangential_transition_start = RexsAttributeId.create("root_relief_length_of_tangential_transition_start", RexsStandardUnitIds.mm);

	/** Root stress adjustment factor (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId root_stress_adjustment_factor_iso_10300_2014 = RexsAttributeId.create("root_stress_adjustment_factor_iso_10300_2014", RexsStandardUnitIds.none);

	/** Root stress (VDI 2736 2014) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId root_stress_vdi_2736_2014 = RexsAttributeId.create("root_stress_vdi_2736_2014", RexsStandardUnitIds.newton_per_mm2);

	/** Root temperature (VDI 2736 2014) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId root_temperature_vdi_2736_2014 = RexsAttributeId.create("root_temperature_vdi_2736_2014", RexsStandardUnitIds.degree_celsius);

	/** Root undercut (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId root_undercut = RexsAttributeId.create("root_undercut", RexsStandardUnitIds.mm);

	/** Shaft angle (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId rotating_angle_around_neg_u_axis = RexsAttributeId.create("rotating_angle_around_neg_u_axis", RexsStandardUnitIds.deg);

	/** Rotating angle around u-axis (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId rotating_angle_around_pos_u_axis = RexsAttributeId.create("rotating_angle_around_pos_u_axis", RexsStandardUnitIds.deg);

	/** Rotational meshing positions (Versions: 1.5, 1.6) */
	RexsAttributeId rotational_meshing_position = RexsAttributeId.create("rotational_meshing_position", RexsStandardUnitIds.deg);

	/** Rotational speed with sign (Versions: 1.0, 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId rotational_speed = RexsAttributeId.create("rotational_speed", RexsStandardUnitIds.rotation_per_min);

	/** Torsional stiffness (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId rotational_stiffness = RexsAttributeId.create("rotational_stiffness", RexsStandardUnitIds.newton_mm_per_rad);

	/** Roughness depth of joining surface inner part (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId roughness_depth_joining_surface_inner_part = RexsAttributeId.create("roughness_depth_joining_surface_inner_part", RexsStandardUnitIds.mum);

	/** Roughness depth of joining surface outer part (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId roughness_depth_joining_surface_outer_part = RexsAttributeId.create("roughness_depth_joining_surface_outer_part", RexsStandardUnitIds.mum);

	/** Roughness factor (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId roughness_factor_pitting_iso_10300_2014 = RexsAttributeId.create("roughness_factor_pitting_iso_10300_2014", RexsStandardUnitIds.none);

	/** Running-in factor (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId running_in_factor_iso_10300_2021 = RexsAttributeId.create("running_in_factor_iso_10300_2021", RexsStandardUnitIds.none);

	/** Radius of raceway at inner ring (Versions: 1.0) */
	RexsAttributeId running_path_radius_of_inner_ring = RexsAttributeId.create("running_path_radius_of_inner_ring", RexsStandardUnitIds.mm);

	/** Radius of raceway at outer ring (Versions: 1.0) */
	RexsAttributeId running_path_radius_of_outer_ring = RexsAttributeId.create("running_path_radius_of_outer_ring", RexsStandardUnitIds.mm);

	/** Runout tolerance (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId runout_tolerance = RexsAttributeId.create("runout_tolerance", RexsStandardUnitIds.mm);

	/** Safety against beginning plasticity hub (DIN 7190 2017) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId safety_against_beginning_plasticity_hub_din_7190_2017 = RexsAttributeId.create("safety_against_beginning_plasticity_hub_din_7190_2017", RexsStandardUnitIds.none);

	/** Safety against beginning plasticity hub (maximum distortion criterion) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId safety_against_beginning_plasticity_hub_mises_din_7190_2017 = RexsAttributeId.create("safety_against_beginning_plasticity_hub_mises_din_7190_2017", RexsStandardUnitIds.none);

	/** Safety against beginning plasticity shaft  (DIN 7190 2017) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId safety_against_beginning_plasticity_shaft_din_7190_2017 = RexsAttributeId.create("safety_against_beginning_plasticity_shaft_din_7190_2017", RexsStandardUnitIds.none);

	/** Safety against beginning plasticity shaft (maximum distortion criterion) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId safety_against_beginning_plasticity_shaft_mises_din_7190_2017 = RexsAttributeId.create("safety_against_beginning_plasticity_shaft_mises_din_7190_2017", RexsStandardUnitIds.none);

	/** Safety against full plasticity hub (DIN 7190 2017) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId safety_against_full_plasticity_hub_din_7190_2017 = RexsAttributeId.create("safety_against_full_plasticity_hub_din_7190_2017", RexsStandardUnitIds.none);

	/** Safety against full plasticity shaft (DIN 7190 2017) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId safety_against_full_plasticity_shaft_din_7190_2017 = RexsAttributeId.create("safety_against_full_plasticity_shaft_din_7190_2017", RexsStandardUnitIds.none);

	/** Safety against sliding (DIN 7190 2017) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId safety_against_sliding_din_7190_2017 = RexsAttributeId.create("safety_against_sliding_din_7190_2017", RexsStandardUnitIds.none);

	/** Shaft safety against cracking (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId safety_factor_cracking_din_743_2012 = RexsAttributeId.create("safety_factor_cracking_din_743_2012", RexsStandardUnitIds.none);

	/** Safety factor deflection (DIN 3996 2019) (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId safety_factor_deflection_din_3996_2019 = RexsAttributeId.create("safety_factor_deflection_din_3996_2019", RexsStandardUnitIds.none);

	/** Shaft safety against fatigue fracture (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId safety_factor_fatigue_fracture_din_743_2012 = RexsAttributeId.create("safety_factor_fatigue_fracture_din_743_2012", RexsStandardUnitIds.none);

	/** Tooth flank safety factor (VDI 2736 2014) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId safety_factor_flank_vdi_2736_2014 = RexsAttributeId.create("safety_factor_flank_vdi_2736_2014", RexsStandardUnitIds.none);

	/** Safety factor pitting (DIN 3996 2019) (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId safety_factor_pitting_din_3996_2019 = RexsAttributeId.create("safety_factor_pitting_din_3996_2019", RexsStandardUnitIds.none);

	/** Safety factor pitting (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId safety_factor_pitting_iso_10300_2014 = RexsAttributeId.create("safety_factor_pitting_iso_10300_2014", RexsStandardUnitIds.none);

	/** Shaft safety against plastic deformation (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId safety_factor_plastic_deformation_din_743_2012 = RexsAttributeId.create("safety_factor_plastic_deformation_din_743_2012", RexsStandardUnitIds.none);

	/** Safety factor root (DIN 3990 1987) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId safety_factor_root_din_3990_1987 = RexsAttributeId.create("safety_factor_root_din_3990_1987", RexsStandardUnitIds.none);

	/** Safety factor root (DIN 3996 2019) (Versions: 1.2, 1.3) */
	RexsAttributeId safety_factor_root_din_3996_2019 = RexsAttributeId.create("safety_factor_root_din_3996_2019", RexsStandardUnitIds.none);

	/** Tooth root safety factor for peak loads (VDI 2736 2014) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId safety_factor_root_for_peak_loads_vdi_2736_2014 = RexsAttributeId.create("safety_factor_root_for_peak_loads_vdi_2736_2014", RexsStandardUnitIds.none);

	/** Tooth root safety factor (VDI 2736 2014) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId safety_factor_root_vdi_2736_2014 = RexsAttributeId.create("safety_factor_root_vdi_2736_2014", RexsStandardUnitIds.none);

	/** Safety factor root (DIN 3996 2019) with wear (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId safety_factor_root_with_wear_din_3996_2019 = RexsAttributeId.create("safety_factor_root_with_wear_din_3996_2019", RexsStandardUnitIds.none);

	/** Safety factor root (DIN 3996 2019) without wear (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId safety_factor_root_without_wear_din_3996_2019 = RexsAttributeId.create("safety_factor_root_without_wear_din_3996_2019", RexsStandardUnitIds.none);

	/** Safety factor tooth root (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId safety_factor_tooth_root_iso_10300_2014 = RexsAttributeId.create("safety_factor_tooth_root_iso_10300_2014", RexsStandardUnitIds.none);

	/** Scuffing risk (AGMA 925 A03) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId scuffing_risk_agma_925_a03 = RexsAttributeId.create("scuffing_risk_agma_925_a03", RexsStandardUnitIds.none);

	/** Semi-width of the Hertzian contact band of the calculation points (AGMA 925 A03) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId semi_width_of_the_rectangular_contact_band_of_calculation_points_agma_925_a03 = RexsAttributeId.create("semi_width_of_the_rectangular_contact_band_of_calculation_points_agma_925_a03", RexsStandardUnitIds.mm);

	/** Sequence number (Versions: 1.5, 1.6) */
	RexsAttributeId sequence_number = RexsAttributeId.create("sequence_number", RexsStandardUnitIds.none);

	/** Ids of the associated point/element list (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId set_ids = RexsAttributeId.create("set_ids", RexsStandardUnitIds.none);

	/** Shaft angle (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId shaft_angle = RexsAttributeId.create("shaft_angle", RexsStandardUnitIds.deg);

	/** Inner shaft diameter for the operating clearance calculation (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId shaft_inner_diameter = RexsAttributeId.create("shaft_inner_diameter", RexsStandardUnitIds.mm);

	/** Shaft safety against plastic deformation at equivalent torque (DIN 6892 2012) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId shaft_safety_plastic_deformation_equivalent_torque_din_6892_2012 = RexsAttributeId.create("shaft_safety_plastic_deformation_equivalent_torque_din_6892_2012", RexsStandardUnitIds.none);

	/** Shaft safety against plastic deformation at maximum torque (DIN 6892 2012) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId shaft_safety_plastic_deformation_maximum_torque_din_6892_2012 = RexsAttributeId.create("shaft_safety_plastic_deformation_maximum_torque_din_6892_2012", RexsStandardUnitIds.none);

	/** Surface roughness of shaft (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId shaft_surface_roughness = RexsAttributeId.create("shaft_surface_roughness", RexsStandardUnitIds.mum);

	/** Tolerance class of shaft (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId shaft_tolerance_class = RexsAttributeId.create("shaft_tolerance_class", RexsStandardUnitIds.none);

	/** Shape of feather key according to DIN 6885 (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId shape_of_feather_key_din_6885 = RexsAttributeId.create("shape_of_feather_key_din_6885", RexsStandardUnitIds.none);

	/** Shape of helix crowning (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId shape_of_helix_crowning = RexsAttributeId.create("shape_of_helix_crowning", RexsStandardUnitIds.none);

	/** Shape of profile crowning (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId shape_of_profile_crowning = RexsAttributeId.create("shape_of_profile_crowning", RexsStandardUnitIds.none);

	/** Shape of relief (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId shape_of_relief = RexsAttributeId.create("shape_of_relief", RexsStandardUnitIds.none);

	/** Shape of undercut (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId shape_of_undercut = RexsAttributeId.create("shape_of_undercut", RexsStandardUnitIds.none);

	/** Shear modulus (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId shear_modulus = RexsAttributeId.create("shear_modulus", RexsStandardUnitIds.newton_per_mm2);

	/** Shear stress at tooth root (DIN 3996 2019) (Versions: 1.2, 1.3) */
	RexsAttributeId shear_stress_tooth_root_din_3996_2019 = RexsAttributeId.create("shear_stress_tooth_root_din_3996_2019", RexsStandardUnitIds.newton_per_mm2);

	/** Shear stress at tooth root (DIN 3996 2019) with wear (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId shear_stress_tooth_root_with_wear_din_3996_2019 = RexsAttributeId.create("shear_stress_tooth_root_with_wear_din_3996_2019", RexsStandardUnitIds.newton_per_mm2);

	/** Shear stress at tooth root (DIN 3996 2019) without wear (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId shear_stress_tooth_root_without_wear_din_3996_2019 = RexsAttributeId.create("shear_stress_tooth_root_without_wear_din_3996_2019", RexsStandardUnitIds.newton_per_mm2);

	/** Side rake angle (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId side_rake_angle = RexsAttributeId.create("side_rake_angle", RexsStandardUnitIds.deg);

	/** Maximum length of inner ring contact (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId significant_contact_length_inner_ring = RexsAttributeId.create("significant_contact_length_inner_ring", RexsStandardUnitIds.mm);

	/** Maximum length of outer ring contact (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId significant_contact_length_outer_ring = RexsAttributeId.create("significant_contact_length_outer_ring", RexsStandardUnitIds.mm);

	/** Possible contact length of rolling element inner ring (Versions: 1.0) */
	RexsAttributeId significant_width_inner = RexsAttributeId.create("significant_width_inner", RexsStandardUnitIds.mm);

	/** Possible contact length of rolling element outer ring (Versions: 1.0) */
	RexsAttributeId significant_width_outer = RexsAttributeId.create("significant_width_outer", RexsStandardUnitIds.mm);

	/** Single pitch deviation (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId single_pitch_deviation = RexsAttributeId.create("single_pitch_deviation", RexsStandardUnitIds.mm);

	/** size factor (wheel bulk temperature) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId size_factor_bulk_temperatur_din_3996_2019 = RexsAttributeId.create("size_factor_bulk_temperatur_din_3996_2019", RexsStandardUnitIds.none);

	/** Size factor (pitting) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId size_factor_pitting_din_3996_2019 = RexsAttributeId.create("size_factor_pitting_din_3996_2019", RexsStandardUnitIds.none);

	/** Size factor pitting (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId size_factor_pitting_iso_10300_2014 = RexsAttributeId.create("size_factor_pitting_iso_10300_2014", RexsStandardUnitIds.none);

	/** Size factor tooth root (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId size_factor_tooth_root_iso_10300_2014 = RexsAttributeId.create("size_factor_tooth_root_iso_10300_2014", RexsStandardUnitIds.none);

	/** Size over balls (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId size_over_balls = RexsAttributeId.create("size_over_balls", RexsStandardUnitIds.mm);

	/** Size over pins (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId size_over_pins = RexsAttributeId.create("size_over_pins", RexsStandardUnitIds.mm);

	/** Sliding base (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId sliding_base = RexsAttributeId.create("sliding_base", RexsStandardUnitIds.mm);

	/** Sliding factor at tip diameter (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId sliding_factor_at_tip_diameter = RexsAttributeId.create("sliding_factor_at_tip_diameter", RexsStandardUnitIds.none);

	/** Sliding velocity at reference diameter (DIN 3996 2019) (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId sliding_velocity_at_reference_diameter_din_3996_2019 = RexsAttributeId.create("sliding_velocity_at_reference_diameter_din_3996_2019", RexsStandardUnitIds.m_per_second);

	/** Sliding velocitiy at contact point Y (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId sliding_velocity_iso_10300_2021 = RexsAttributeId.create("sliding_velocity_iso_10300_2021", RexsStandardUnitIds.m_per_second);

	/** Sliding velocity at the calculation points (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId sliding_velocity_of_calculation_points_agma_925_a03 = RexsAttributeId.create("sliding_velocity_of_calculation_points_agma_925_a03", RexsStandardUnitIds.m_per_second);

	/** Sliding velocity in profile direction at contact point Y (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId sliding_velocity_profile_direction_iso_10300_2021 = RexsAttributeId.create("sliding_velocity_profile_direction_iso_10300_2021", RexsStandardUnitIds.m_per_second);

	/** Sliding velocity in tooth lengthwise direction at the mean point (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId sliding_velocity_tooth_lengthwise_direction_iso_10300_2021 = RexsAttributeId.create("sliding_velocity_tooth_lengthwise_direction_iso_10300_2021", RexsStandardUnitIds.m_per_second);

	/** Small outer diameter with shouldered hub (DIN 6892 2012) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId small_outer_diameter_shouldered_hub_din_6892_2012 = RexsAttributeId.create("small_outer_diameter_shouldered_hub_din_6892_2012", RexsStandardUnitIds.mm);

	/** Smoothing factor (DIN 7190 2017) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId smoothing_factor_din_7190_2017 = RexsAttributeId.create("smoothing_factor_din_7190_2017", RexsStandardUnitIds.none);

	/** S/N curve application (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId sn_curve_application = RexsAttributeId.create("sn_curve_application", RexsStandardUnitIds.none);

	/** Span measurement (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId span_measurement = RexsAttributeId.create("span_measurement", RexsStandardUnitIds.mm);

	/** Specific film thickness with a cutoff wavelength equal to the Hertzian contact width at the calculation points (AGMA 925 A03) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId specific_film_thickness_of_calculation_points_agma_925_a03 = RexsAttributeId.create("specific_film_thickness_of_calculation_points_agma_925_a03", RexsStandardUnitIds.none);

	/** Specific sliding (tooth root) (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId specific_sliding_at_root_diameter = RexsAttributeId.create("specific_sliding_at_root_diameter", RexsStandardUnitIds.none);

	/** Specific sliding (tooth tip) (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId specific_sliding_at_tip_diameter = RexsAttributeId.create("specific_sliding_at_tip_diameter", RexsStandardUnitIds.none);

	/** Specify tangential transition area (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId specify_tangential_transition = RexsAttributeId.create("specify_tangential_transition", RexsStandardUnitIds.none);

	/** Speed factor (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId speed_factor_pitting_iso_10300_2014 = RexsAttributeId.create("speed_factor_pitting_iso_10300_2014", RexsStandardUnitIds.none);

	/** Rotational speed inner ring (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId speed_inner_ring = RexsAttributeId.create("speed_inner_ring", RexsStandardUnitIds.rotation_per_min);

	/** Rotational speed outer ring (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId speed_outer_ring = RexsAttributeId.create("speed_outer_ring", RexsStandardUnitIds.rotation_per_min);

	/** Speed parameter for central film thickness at the calculation points (AGMA 925 A03) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId speed_parameter_for_central_film_thickness_of_calculation_points_amga_925_a03 = RexsAttributeId.create("speed_parameter_for_central_film_thickness_of_calculation_points_amga_925_a03", RexsStandardUnitIds.none);

	/** Speed rolling element set / cage (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId speed_rolling_element_set = RexsAttributeId.create("speed_rolling_element_set", RexsStandardUnitIds.rotation_per_min);

	/** Spiral angle factor (VDI 2736 2014) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId spiral_angle_factor_vdi_2736_2014 = RexsAttributeId.create("spiral_angle_factor_vdi_2736_2014", RexsStandardUnitIds.none);

	/** Direction of the spiral angle (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId spiral_angle_pitch_direction = RexsAttributeId.create("spiral_angle_pitch_direction", RexsStandardUnitIds.none);

	/** Standard deviation of the minimum specific film thickness (AGMA 925 A03) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId standard_deviation_of_minimum_specific_film_thickness_agma_925_a03 = RexsAttributeId.create("standard_deviation_of_minimum_specific_film_thickness_agma_925_a03", RexsStandardUnitIds.mum);

	/** Standard deviation for the permissible stress at the point between limited life and long life (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId standard_deviation_permissible_stress_point_between_limited_life_and_long_life = RexsAttributeId.create("standard_deviation_permissible_stress_point_between_limited_life_and_long_life", RexsStandardUnitIds.percent);

	/** Start factor (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId start_factor_din_3996_2019 = RexsAttributeId.create("start_factor_din_3996_2019", RexsStandardUnitIds.none);

	/** Start-up time (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId start_up_time = RexsAttributeId.create("start_up_time", RexsStandardUnitIds.second);

	/** Starting angle (Versions: 1.6) */
	RexsAttributeId starting_angle_plain_bearing_feature = RexsAttributeId.create("starting_angle_plain_bearing_feature", RexsStandardUnitIds.deg);

	/** Static load rating (Versions: 1.0) */
	RexsAttributeId static_capacity = RexsAttributeId.create("static_capacity", RexsStandardUnitIds.kilo_newton);

	/** Is cast material and bending loaded (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId static_is_cast_material_and_bending_loaded_fkm_2012 = RexsAttributeId.create("static_is_cast_material_and_bending_loaded_fkm_2012", RexsStandardUnitIds.none);

	/** Is the component rolled and is the area under consideration stressed mainly transverse to the main machining direction (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId static_is_component_rolled_and_transversal_loaded_fkm_2012 = RexsAttributeId.create("static_is_component_rolled_and_transversal_loaded_fkm_2012", RexsStandardUnitIds.none);

	/** Static load safety (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId static_load_safety = RexsAttributeId.create("static_load_safety", RexsStandardUnitIds.none);

	/** Probability of the occurrence of all maxima at the same time (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId static_occurence_probability_of_stress_combination_fkm_2012 = RexsAttributeId.create("static_occurence_probability_of_stress_combination_fkm_2012", RexsStandardUnitIds.none);

	/** Static overload factor (VDI 2736 2014) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId static_overload_factor_vdi_2736_2014 = RexsAttributeId.create("static_overload_factor_vdi_2736_2014", RexsStandardUnitIds.none);

	/** Static supporting effect bending (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId static_supporting_effect_bending_din_743_2012 = RexsAttributeId.create("static_supporting_effect_bending_din_743_2012", RexsStandardUnitIds.none);

	/** Static supporting effect tension/ compression (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId static_supporting_effect_tension_compression_din_743_2012 = RexsAttributeId.create("static_supporting_effect_tension_compression_din_743_2012", RexsStandardUnitIds.none);

	/** Static supporting effect torsion (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId static_supporting_effect_torsion_din_743_2012 = RexsAttributeId.create("static_supporting_effect_torsion_din_743_2012", RexsStandardUnitIds.none);

	/** Stress amplitude bending (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId stress_amplitude_bending_din_743_2012 = RexsAttributeId.create("stress_amplitude_bending_din_743_2012", RexsStandardUnitIds.newton_per_mm2);

	/** Stress amplitude tosion/ compression (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId stress_amplitude_tension_compression_din_743_2012 = RexsAttributeId.create("stress_amplitude_tension_compression_din_743_2012", RexsStandardUnitIds.newton_per_mm2);

	/** Stress amplitude torsion (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId stress_amplitude_torsion_din_743_2012 = RexsAttributeId.create("stress_amplitude_torsion_din_743_2012", RexsStandardUnitIds.newton_per_mm2);

	/** Stress correction factor (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId stress_concentration_and_correction_factor_iso_10300_2014 = RexsAttributeId.create("stress_concentration_and_correction_factor_iso_10300_2014", RexsStandardUnitIds.none);

	/** Stress correction factor notch effect (VDI 2736 2014) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId stress_correction_factor_notch_effect_vdi_2736_2014 = RexsAttributeId.create("stress_correction_factor_notch_effect_vdi_2736_2014", RexsStandardUnitIds.none);

	/** Stress correction factor for the dimensions of standard test gear (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId stress_correction_factor_of_test_gear_iso_10300_2014 = RexsAttributeId.create("stress_correction_factor_of_test_gear_iso_10300_2014", RexsStandardUnitIds.none);

	/** Strength stress correction factor (VDI 2736 2014) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId stress_correction_factor_strength_vdi_2736_2014 = RexsAttributeId.create("stress_correction_factor_strength_vdi_2736_2014", RexsStandardUnitIds.none);

	/** Stress correction factor for load application at tooth tip (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId stress_correction_factor_tooth_root_iso_10300_2014 = RexsAttributeId.create("stress_correction_factor_tooth_root_iso_10300_2014", RexsStandardUnitIds.none);

	/** Circumferential angle of struts of planet carrier (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId strut_circumferential_angle = RexsAttributeId.create("strut_circumferential_angle", RexsStandardUnitIds.deg);

	/** Inner diameter of struts of planet carrier (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId strut_inner_diameter = RexsAttributeId.create("strut_inner_diameter", RexsStandardUnitIds.mm);

	/** Radius of planet recess in the struts of the planet carrier (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId strut_radius_planet_recess = RexsAttributeId.create("strut_radius_planet_recess", RexsStandardUnitIds.mm);

	/** Sum of addendum modification coefficients (profile shift coefficients) (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId sum_of_addendum_modification_coefficients = RexsAttributeId.create("sum_of_addendum_modification_coefficients", RexsStandardUnitIds.none);

	/** Sum of velocities at contact point Y (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId sum_of_velocities_iso_10300_2021 = RexsAttributeId.create("sum_of_velocities_iso_10300_2021", RexsStandardUnitIds.m_per_second);

	/** Sum of velocities in lengthwise direction (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId sum_of_velocities_lengthwise_direction_iso_10300_2021 = RexsAttributeId.create("sum_of_velocities_lengthwise_direction_iso_10300_2021", RexsStandardUnitIds.m_per_second);

	/** Sum of velocities in profile direction at contact point Y (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId sum_of_velocities_profile_direction_iso_10300_2021 = RexsAttributeId.create("sum_of_velocities_profile_direction_iso_10300_2021", RexsStandardUnitIds.m_per_second);

	/** Sum of velocities vertical to the contact line at contact point Y (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId sum_of_velocities_vertical_to_contact_line_iso_10300_2021 = RexsAttributeId.create("sum_of_velocities_vertical_to_contact_line_iso_10300_2021", RexsStandardUnitIds.m_per_second);

	/** Support vector (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId support_vector = RexsAttributeId.create("support_vector", RexsStandardUnitIds.mm);

	/** Supporting length of the feather key (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId supporting_length_of_feather_key = RexsAttributeId.create("supporting_length_of_feather_key", RexsStandardUnitIds.mm);

	/** Supporting length of the hub keyway (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId supporting_length_of_hub_keyway = RexsAttributeId.create("supporting_length_of_hub_keyway", RexsStandardUnitIds.mm);

	/** Supporting length of the shaft keyway (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId supporting_length_of_shaft_keyway = RexsAttributeId.create("supporting_length_of_shaft_keyway", RexsStandardUnitIds.mm);

	/** Width of the large diameter hub part within the supporting length of the key (DIN 6892 2012) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId supporting_width_large_diameter_hub = RexsAttributeId.create("supporting_width_large_diameter_hub", RexsStandardUnitIds.mm);

	/** Surface hardness - Brinell (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId surface_hardness_brinell = RexsAttributeId.create("surface_hardness_brinell", RexsStandardUnitIds.hb);

	/** Surface hardness - Rockwell (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId surface_hardness_rockwell = RexsAttributeId.create("surface_hardness_rockwell", RexsStandardUnitIds.hrc);

	/** Surface hardness - Vickers (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId surface_hardness_vickers = RexsAttributeId.create("surface_hardness_vickers", RexsStandardUnitIds.hv);

	/** Surface roughness Rz (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId surface_roughness = RexsAttributeId.create("surface_roughness", RexsStandardUnitIds.mum);

	/** Surface roughness constant (AGMA 925 A03) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId surface_roughness_constant_agma_925_a03 = RexsAttributeId.create("surface_roughness_constant_agma_925_a03", RexsStandardUnitIds.none);

	/** Surface roughness factor (VDI 2736 2014) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId surface_roughness_factor_vdi_2736_2014 = RexsAttributeId.create("surface_roughness_factor_vdi_2736_2014", RexsStandardUnitIds.none);

	/** Surface treatment category (DIN 743 2012) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId surface_treatment_category_din_743_2012 = RexsAttributeId.create("surface_treatment_category_din_743_2012", RexsStandardUnitIds.none);

	/** Surface treatment factor (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId surface_treatment_factor_fkm_2012 = RexsAttributeId.create("surface_treatment_factor_fkm_2012", RexsStandardUnitIds.none);

	/** Surface velocity in lengthwise direction (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId surface_velocity_lengthwise_direction_iso_10300_2021 = RexsAttributeId.create("surface_velocity_lengthwise_direction_iso_10300_2021", RexsStandardUnitIds.m_per_second);

	/** Surface velocity vertical to the contact line (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId surface_velocity_vertical_to_contact_line_iso_10300_2021 = RexsAttributeId.create("surface_velocity_vertical_to_contact_line_iso_10300_2021", RexsStandardUnitIds.m_per_second);

	/** Surface zone bending resistance (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId surface_zone_bending_resistance = RexsAttributeId.create("surface_zone_bending_resistance", RexsStandardUnitIds.mega_pascal);

	/** Surface zone tension resistance (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId surface_zone_tension_resistance = RexsAttributeId.create("surface_zone_tension_resistance", RexsStandardUnitIds.mega_pascal);

	/** Surface zone torsion resistance (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId surface_zone_torsion_resistance = RexsAttributeId.create("surface_zone_torsion_resistance", RexsStandardUnitIds.mega_pascal);

	/** Survival probability (Versions: 1.5, 1.6) */
	RexsAttributeId survival_probability = RexsAttributeId.create("survival_probability", RexsStandardUnitIds.percent);

	/** Survival probability (Versions: 1.0, 1.1, 1.2, 1.3, 1.4) */
	RexsAttributeId survival_probablity = RexsAttributeId.create("survival_probablity", RexsStandardUnitIds.percent);

	/** Swivel motion coefficients (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId swivel_motion_coefficients = RexsAttributeId.create("swivel_motion_coefficients", RexsStandardUnitIds.none);

	/** Tangential velocity at pitch circle (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId tangential_velocity_at_pitch_circle = RexsAttributeId.create("tangential_velocity_at_pitch_circle", RexsStandardUnitIds.m_per_second);

	/** Tangential velocity at reference circle (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId tangential_velocity_at_reference_circle = RexsAttributeId.create("tangential_velocity_at_reference_circle", RexsStandardUnitIds.m_per_second);

	/** Technological size factor tensile strength (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId technological_size_factor_tensile_strength_din_743_2012 = RexsAttributeId.create("technological_size_factor_tensile_strength_din_743_2012", RexsStandardUnitIds.none);

	/** Technological size factor yield strength (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId technological_size_factor_yield_strength_din_743_2012 = RexsAttributeId.create("technological_size_factor_yield_strength_din_743_2012", RexsStandardUnitIds.none);

	/** Temperature coefficient a_Tt for tensile strength FKM 2012 (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId temperature_coefficient_a_tt_for_tensile_strength_fkm_2012 = RexsAttributeId.create("temperature_coefficient_a_tt_for_tensile_strength_fkm_2012", RexsStandardUnitIds.none);

	/** Temperature coefficient a_Tt for yield strength FKM 2012 (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId temperature_coefficient_a_tt_for_yield_strength_fkm_2012 = RexsAttributeId.create("temperature_coefficient_a_tt_for_yield_strength_fkm_2012", RexsStandardUnitIds.none);

	/** Temperature coefficient b_Tt for tensile strength FKM 2012 (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId temperature_coefficient_b_tt_for_tensile_strength_fkm_2012 = RexsAttributeId.create("temperature_coefficient_b_tt_for_tensile_strength_fkm_2012", RexsStandardUnitIds.none);

	/** Temperature coefficient b_Tt for yield strength FKM 2012 (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId temperature_coefficient_b_tt_for_yield_strength_fkm_2012 = RexsAttributeId.create("temperature_coefficient_b_tt_for_yield_strength_fkm_2012", RexsStandardUnitIds.none);

	/** Temperature coefficient c_Tt for tensile strength FKM 2012 (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId temperature_coefficient_c_tt_for_tensile_strength_fkm_2012 = RexsAttributeId.create("temperature_coefficient_c_tt_for_tensile_strength_fkm_2012", RexsStandardUnitIds.none);

	/** Temperature coefficient c_Tt for yield strength FKM 2012 (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId temperature_coefficient_c_tt_for_yield_strength_fkm_2012 = RexsAttributeId.create("temperature_coefficient_c_tt_for_yield_strength_fkm_2012", RexsStandardUnitIds.none);

	/** Temperature constant C for tensile strength FKM 2012 (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId temperature_constant_c_for_tensile_strength_fkm_2012 = RexsAttributeId.create("temperature_constant_c_for_tensile_strength_fkm_2012", RexsStandardUnitIds.none);

	/** Temperature constant C for yield strength FKM 2012 (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId temperature_constant_c_for_yield_strength_fkm_2012 = RexsAttributeId.create("temperature_constant_c_for_yield_strength_fkm_2012", RexsStandardUnitIds.none);

	/** Temperature-dependent modulus of elasticity (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId temperature_dependent_modulus_of_elasticity = RexsAttributeId.create("temperature_dependent_modulus_of_elasticity", RexsStandardUnitIds.newton_per_mm2);

	/** Temperature dependent poisson's ratio (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId temperature_dependent_poissons_ratio = RexsAttributeId.create("temperature_dependent_poissons_ratio", RexsStandardUnitIds.none);

	/** Temperature-dependent yield strength (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId temperature_dependent_yield_strength = RexsAttributeId.create("temperature_dependent_yield_strength", RexsStandardUnitIds.newton_per_mm2);

	/** Temperature difference inner / outer ring (Versions: 1.0) */
	RexsAttributeId temperature_difference = RexsAttributeId.create("temperature_difference", RexsStandardUnitIds.kelvin);

	/** Temperature difference between bearing and surroundings (Versions: 1.0) */
	RexsAttributeId temperature_difference_bearing_environment = RexsAttributeId.create("temperature_difference_bearing_environment", RexsStandardUnitIds.kelvin);

	/** Temperature difference between operation and assembly (Versions: 1.0) */
	RexsAttributeId temperature_difference_operation_and_installation = RexsAttributeId.create("temperature_difference_operation_and_installation", RexsStandardUnitIds.kelvin);

	/** Temperature factor (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId temperature_factor_iso_10300_2021 = RexsAttributeId.create("temperature_factor_iso_10300_2021", RexsStandardUnitIds.none);

	/** Operating temperature of lubricant (Versions: 1.0, 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId temperature_lubricant = RexsAttributeId.create("temperature_lubricant", RexsStandardUnitIds.degree_celsius);

	/** Temperature safety factor (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId temperature_safety_factor_din_3996_2019 = RexsAttributeId.create("temperature_safety_factor_din_3996_2019", RexsStandardUnitIds.none);

	/** Temperature under static load (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId temperature_under_static_load_fkm_2012 = RexsAttributeId.create("temperature_under_static_load_fkm_2012", RexsStandardUnitIds.degree_celsius);

	/** Temperature variation for modulus of elasticity (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId temperature_variation_for_modulus_of_elasticity = RexsAttributeId.create("temperature_variation_for_modulus_of_elasticity", RexsStandardUnitIds.degree_celsius);

	/** Temperature variation for poisson's ratio (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId temperature_variation_for_poissons_ratio = RexsAttributeId.create("temperature_variation_for_poissons_ratio", RexsStandardUnitIds.degree_celsius);

	/** Temperature variation for yield strength (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId temperature_variation_for_yield_strength = RexsAttributeId.create("temperature_variation_for_yield_strength", RexsStandardUnitIds.degree_celsius);

	/** Tensile strength (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId tensile_strength = RexsAttributeId.create("tensile_strength", RexsStandardUnitIds.newton_per_mm2);

	/** Tensile strength of component (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId tensile_strength_of_component_fkm_2012 = RexsAttributeId.create("tensile_strength_of_component_fkm_2012", RexsStandardUnitIds.mega_pascal);

	/** Tension/ compression yield strength (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId tensile_yield_stress_din_743_2012 = RexsAttributeId.create("tensile_yield_stress_din_743_2012", RexsStandardUnitIds.newton_per_mm2);

	/** Specific thermal capacity (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId thermal_capacity = RexsAttributeId.create("thermal_capacity", RexsStandardUnitIds.j_per_kg_k);

	/** Thermal conductivity (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId thermal_conductivity = RexsAttributeId.create("thermal_conductivity", RexsStandardUnitIds.watt_per_m_k);

	/** Thermal contact coefficient (AGMA 925 C95) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId thermal_contact_coefficient_agma_925_a03 = RexsAttributeId.create("thermal_contact_coefficient_agma_925_a03", RexsStandardUnitIds.newton_per_mm_s_then_squareroot_k);

	/** Thermal expansion coefficient (-) (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId thermal_expansion_coefficient_minus = RexsAttributeId.create("thermal_expansion_coefficient_minus", RexsStandardUnitIds.thermal_expansion_coefficient);

	/** Thermal expansion coefficient (+) (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId thermal_expansion_coefficient_plus = RexsAttributeId.create("thermal_expansion_coefficient_plus", RexsStandardUnitIds.thermal_expansion_coefficient);

	/** Tooth thickness modification coefficient (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId thickness_modification_coefficient = RexsAttributeId.create("thickness_modification_coefficient", RexsStandardUnitIds.none);

	/** Throat radius (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId throat_radius_worm_wheel = RexsAttributeId.create("throat_radius_worm_wheel", RexsStandardUnitIds.mm);

	/** Tilt motion coefficients (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId tilt_motion_coefficients = RexsAttributeId.create("tilt_motion_coefficients", RexsStandardUnitIds.none);

	/** Tilting of inner side around u axis (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId tilting_inner_side_u = RexsAttributeId.create("tilting_inner_side_u", RexsStandardUnitIds.deg);

	/** Tilting of inner side around v axis (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId tilting_inner_side_v = RexsAttributeId.create("tilting_inner_side_v", RexsStandardUnitIds.deg);

	/** Tilting of inner side around w axis (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId tilting_inner_side_w = RexsAttributeId.create("tilting_inner_side_w", RexsStandardUnitIds.deg);

	/** Tilting of outer side around u axis (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId tilting_outer_side_u = RexsAttributeId.create("tilting_outer_side_u", RexsStandardUnitIds.deg);

	/** Tilting around v axis of outer side (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId tilting_outer_side_v = RexsAttributeId.create("tilting_outer_side_v", RexsStandardUnitIds.deg);

	/** Tilting around w axis of outer side (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId tilting_outer_side_w = RexsAttributeId.create("tilting_outer_side_w", RexsStandardUnitIds.deg);

	/** Tilting around v axis (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId tilting_v = RexsAttributeId.create("tilting_v", RexsStandardUnitIds.deg);

	/** Tilting around w axis (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId tilting_w = RexsAttributeId.create("tilting_w", RexsStandardUnitIds.deg);

	/** Time of operation at temperature under static load (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId time_of_operation_at_temperature_under_static_load_fkm_2012 = RexsAttributeId.create("time_of_operation_at_temperature_under_static_load_fkm_2012", RexsStandardUnitIds.hour);

	/** Tip clearance (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId tip_clearance = RexsAttributeId.create("tip_clearance", RexsStandardUnitIds.mm);

	/** Tip clearance factor (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId tip_clearance_factor = RexsAttributeId.create("tip_clearance_factor", RexsStandardUnitIds.none);

	/** Tip circle diameter (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId tip_diameter = RexsAttributeId.create("tip_diameter", RexsStandardUnitIds.mm);

	/** Tip diameter  (DIN 3975 2017) (Versions: 1.2) */
	RexsAttributeId tip_diameter_din_3975_2017 = RexsAttributeId.create("tip_diameter_din_3975_2017", RexsStandardUnitIds.mm);

	/** Tip diameter of virtual cylindrical gear in normal section (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId tip_diameter_normal_section_virtual_cylindrical_gear_iso_10300_2014 = RexsAttributeId.create("tip_diameter_normal_section_virtual_cylindrical_gear_iso_10300_2014", RexsStandardUnitIds.mm);

	/** Tip diameter of virtual cylindrical gear (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId tip_diameter_virtual_cylindrical_gear_iso_10300_2014 = RexsAttributeId.create("tip_diameter_virtual_cylindrical_gear_iso_10300_2014", RexsStandardUnitIds.mm);

	/** Tip diameter (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId tip_diameter_worm_gear = RexsAttributeId.create("tip_diameter_worm_gear", RexsStandardUnitIds.mm);

	/** Tip form diameter (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId tip_form_diameter = RexsAttributeId.create("tip_form_diameter", RexsStandardUnitIds.mm);

	/** Tip radius (Versions: 1.0, 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId tip_radius = RexsAttributeId.create("tip_radius", RexsStandardUnitIds.mm);

	/** Tip radius factor (Versions: 1.0, 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId tip_radius_factor = RexsAttributeId.create("tip_radius_factor", RexsStandardUnitIds.none);

	/** Tip relief angle (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId tip_relief_angle_bevel_gear_tool = RexsAttributeId.create("tip_relief_angle_bevel_gear_tool", RexsStandardUnitIds.deg);

	/** Diameter at start of tip relief (reference diameter) (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId tip_relief_datum_diameter = RexsAttributeId.create("tip_relief_datum_diameter", RexsStandardUnitIds.mm);

	/** Length of tip relief (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId tip_relief_datum_length = RexsAttributeId.create("tip_relief_datum_length", RexsStandardUnitIds.mm);

	/** Depth of tip relief (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId tip_relief_depth = RexsAttributeId.create("tip_relief_depth", RexsStandardUnitIds.mm);

	/** Diameter where tangential transition area of linear tip relief ends (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId tip_relief_diameter_where_tangential_transition_ends = RexsAttributeId.create("tip_relief_diameter_where_tangential_transition_ends", RexsStandardUnitIds.mm);

	/** Diameter where tangential transition area of linear tip relief starts (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId tip_relief_diameter_where_tangential_transition_starts = RexsAttributeId.create("tip_relief_diameter_where_tangential_transition_starts", RexsStandardUnitIds.mm);

	/** Diameter where amount of modification is specified (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId tip_relief_evaluation_reference = RexsAttributeId.create("tip_relief_evaluation_reference", RexsStandardUnitIds.mm);

	/** Rolling length where amount of modification is specified (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId tip_relief_evaluation_reference_length = RexsAttributeId.create("tip_relief_evaluation_reference_length", RexsStandardUnitIds.mm);

	/** Tip relief factor (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId tip_relief_factor_iso_10300_2021 = RexsAttributeId.create("tip_relief_factor_iso_10300_2021", RexsStandardUnitIds.none);

	/** Tip relief height (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId tip_relief_height_bevel_gear_tool = RexsAttributeId.create("tip_relief_height_bevel_gear_tool", RexsStandardUnitIds.mm);

	/** Length of tangential transition area end of linear tip relief (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId tip_relief_length_of_tangential_transition_end = RexsAttributeId.create("tip_relief_length_of_tangential_transition_end", RexsStandardUnitIds.mm);

	/** Length of tangential transition area start of linear tip relief (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId tip_relief_length_of_tangential_transition_start = RexsAttributeId.create("tip_relief_length_of_tangential_transition_start", RexsStandardUnitIds.mm);

	/** Tip relief radius (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId tip_relief_radius_bevel_gear_tool = RexsAttributeId.create("tip_relief_radius_bevel_gear_tool", RexsStandardUnitIds.mm);

	/** Tolerance zone of base tangent length acc. to DIN 5480 (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId tolerance_and_deviation_series_din_5480_2006 = RexsAttributeId.create("tolerance_and_deviation_series_din_5480_2006", RexsStandardUnitIds.none);

	/** Tolerance class according to ISO 1328 (2013) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId tolerance_class_according_to_iso_1328_2013 = RexsAttributeId.create("tolerance_class_according_to_iso_1328_2013", RexsStandardUnitIds.none);

	/** Tolerance field of root diameter acc .to DIN 5480 (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId tolerance_field_root_diameter_din_5480_2006 = RexsAttributeId.create("tolerance_field_root_diameter_din_5480_2006", RexsStandardUnitIds.none);

	/** Tolerance zone of tip circle diameter acc. to DIN 5480 (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId tolerance_field_tip_diameter_din_5480_2006 = RexsAttributeId.create("tolerance_field_tip_diameter_din_5480_2006", RexsStandardUnitIds.none);

	/** Tool edge radius (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId tool_edge_radius = RexsAttributeId.create("tool_edge_radius", RexsStandardUnitIds.mm);

	/** Tool edge radius (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId tool_edge_radius_bevel_gear_tool = RexsAttributeId.create("tool_edge_radius_bevel_gear_tool", RexsStandardUnitIds.mm);

	/** Tool profile position (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId tool_profile_position_bevel_gear_tool = RexsAttributeId.create("tool_profile_position_bevel_gear_tool", RexsStandardUnitIds.mm);

	/** Tool tip height (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId tool_tip_height_bevel_gear_tool = RexsAttributeId.create("tool_tip_height_bevel_gear_tool", RexsStandardUnitIds.mm);

	/** Tooth addendum (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId tooth_addendum_worm_wheel_hob = RexsAttributeId.create("tooth_addendum_worm_wheel_hob", RexsStandardUnitIds.mm);

	/** Tooth depth (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId tooth_depth = RexsAttributeId.create("tooth_depth", RexsStandardUnitIds.mm);

	/** Tooth depth (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId tooth_depth_worm_wheel_hob = RexsAttributeId.create("tooth_depth_worm_wheel_hob", RexsStandardUnitIds.mm);

	/** Tooth form factor (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId tooth_form_factor_iso_10300_2014 = RexsAttributeId.create("tooth_form_factor_iso_10300_2014", RexsStandardUnitIds.none);

	/** Tooth root stress (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId tooth_root_stress_iso_10300_2014 = RexsAttributeId.create("tooth_root_stress_iso_10300_2014", RexsStandardUnitIds.newton_per_mm2);

	/** Tooth temperature (AGMA 925 C95) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId tooth_temperature_agma_925_a03 = RexsAttributeId.create("tooth_temperature_agma_925_a03", RexsStandardUnitIds.degree_celsius);

	/** Tooth temperature of test gears (AGMA 925 C95) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId tooth_temperature_of_test_gears_agma_925_a03 = RexsAttributeId.create("tooth_temperature_of_test_gears_agma_925_a03", RexsStandardUnitIds.degree_celsius);

	/** Tooth thickness (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId tooth_thickness = RexsAttributeId.create("tooth_thickness", RexsStandardUnitIds.mm);

	/** Transverse tooth thickness (Versions: 1.2, 1.3, 1.4) */
	RexsAttributeId tooth_thickness_at_pitch_diameter = RexsAttributeId.create("tooth_thickness_at_pitch_diameter", RexsStandardUnitIds.mm);

	/** DIN 3967 Deviation-tolerance series (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId tooth_thickness_deviation_tolerance_series_din_3967_1978 = RexsAttributeId.create("tooth_thickness_deviation_tolerance_series_din_3967_1978", RexsStandardUnitIds.none);

	/** Tooth thickness half angle at active root diameter (Versions: 1.5, 1.6) */
	RexsAttributeId tooth_thickness_half_angle_at_active_root_diameter = RexsAttributeId.create("tooth_thickness_half_angle_at_active_root_diameter", RexsStandardUnitIds.deg);

	/** Tooth thickness half angle at active tip diameter (Versions: 1.5, 1.6) */
	RexsAttributeId tooth_thickness_half_angle_at_active_tip_diameter = RexsAttributeId.create("tooth_thickness_half_angle_at_active_tip_diameter", RexsStandardUnitIds.deg);

	/** Tooth thickness half angle at base diameter (Versions: 1.5, 1.6) */
	RexsAttributeId tooth_thickness_half_angle_at_base_diameter = RexsAttributeId.create("tooth_thickness_half_angle_at_base_diameter", RexsStandardUnitIds.deg);

	/** Tooth thickness half angle at pitch diameter (Versions: 1.5, 1.6) */
	RexsAttributeId tooth_thickness_half_angle_at_pitch_diameter = RexsAttributeId.create("tooth_thickness_half_angle_at_pitch_diameter", RexsStandardUnitIds.deg);

	/** Tooth thickness half angle at reference diameter (Versions: 1.5, 1.6) */
	RexsAttributeId tooth_thickness_half_angle_at_reference_diameter = RexsAttributeId.create("tooth_thickness_half_angle_at_reference_diameter", RexsStandardUnitIds.deg);

	/** Tooth thickness half angle at root diameter (Versions: 1.5, 1.6) */
	RexsAttributeId tooth_thickness_half_angle_at_root_diameter = RexsAttributeId.create("tooth_thickness_half_angle_at_root_diameter", RexsStandardUnitIds.deg);

	/** Tooth thickness half angle at root form diameter (Versions: 1.5, 1.6) */
	RexsAttributeId tooth_thickness_half_angle_at_root_form_diameter = RexsAttributeId.create("tooth_thickness_half_angle_at_root_form_diameter", RexsStandardUnitIds.deg);

	/** Tooth thickness half angle at tip diameter (Versions: 1.5, 1.6) */
	RexsAttributeId tooth_thickness_half_angle_at_tip_diameter = RexsAttributeId.create("tooth_thickness_half_angle_at_tip_diameter", RexsStandardUnitIds.deg);

	/** Tooth thickness half angle at tip form diameter (Versions: 1.5, 1.6) */
	RexsAttributeId tooth_thickness_half_angle_at_tip_form_diameter = RexsAttributeId.create("tooth_thickness_half_angle_at_tip_form_diameter", RexsStandardUnitIds.deg);

	/** Tooth thickness loss (DIN 3996 2019) (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId tooth_thickness_loss_din_3996_2019 = RexsAttributeId.create("tooth_thickness_loss_din_3996_2019", RexsStandardUnitIds.mm);

	/** Tooth tip chamfer (radial amount) (Versions: 1.0, 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId tooth_tip_chamfer = RexsAttributeId.create("tooth_tip_chamfer", RexsStandardUnitIds.mm);

	/** Tooth tip thickness (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId tooth_tip_thickness = RexsAttributeId.create("tooth_tip_thickness", RexsStandardUnitIds.mm);

	/** Amount of topographical deviation (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId topographical_deviation_amounts = RexsAttributeId.create("topographical_deviation_amounts", RexsStandardUnitIds.mm);

	/** Topographical deviation amounts (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId topographical_deviation_amounts_point_list = RexsAttributeId.create("topographical_deviation_amounts_point_list", RexsStandardUnitIds.mm);

	/** Normal direction of topographical deviation (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId topographical_deviation_normals = RexsAttributeId.create("topographical_deviation_normals", RexsStandardUnitIds.none);

	/** Amount of topographical modification (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId topographical_modification_amounts = RexsAttributeId.create("topographical_modification_amounts", RexsStandardUnitIds.mm);

	/** Transmitted torque (with sign) (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId torque = RexsAttributeId.create("torque", RexsStandardUnitIds.newton_m);

	/** Torque around u-axis acting on the component on the inner side (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId torque_acting_on_inner_component_u = RexsAttributeId.create("torque_acting_on_inner_component_u", RexsStandardUnitIds.newton_m);

	/** Torque around v-axis acting on the component on the inner side (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId torque_acting_on_inner_component_v = RexsAttributeId.create("torque_acting_on_inner_component_v", RexsStandardUnitIds.newton_m);

	/** Torque around w-axis acting on the component on the inner side (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId torque_acting_on_inner_component_w = RexsAttributeId.create("torque_acting_on_inner_component_w", RexsStandardUnitIds.newton_m);

	/** Torque around u-axis acting on the component on the outer side (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId torque_acting_on_outer_component_u = RexsAttributeId.create("torque_acting_on_outer_component_u", RexsStandardUnitIds.newton_m);

	/** Torque around v-axis acting on the component on the outer side (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId torque_acting_on_outer_component_v = RexsAttributeId.create("torque_acting_on_outer_component_v", RexsStandardUnitIds.newton_m);

	/** Torque around w-axis acting on the component on the outer side (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId torque_acting_on_outer_component_w = RexsAttributeId.create("torque_acting_on_outer_component_w", RexsStandardUnitIds.newton_m);

	/** Torque around u-axis acting on the shaft (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId torque_acting_on_shaft_u = RexsAttributeId.create("torque_acting_on_shaft_u", RexsStandardUnitIds.newton_m);

	/** Torque around v-axis acting on the shaft (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId torque_acting_on_shaft_v = RexsAttributeId.create("torque_acting_on_shaft_v", RexsStandardUnitIds.newton_m);

	/** Torque around w-axis acting on the shaft (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId torque_acting_on_shaft_w = RexsAttributeId.create("torque_acting_on_shaft_w", RexsStandardUnitIds.newton_m);

	/** Torque around the v-axis (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId torque_around_the_v_axis = RexsAttributeId.create("torque_around_the_v_axis", RexsStandardUnitIds.newton_m);

	/** Torque around the w-axis (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId torque_around_the_w_axis = RexsAttributeId.create("torque_around_the_w_axis", RexsStandardUnitIds.newton_m);

	/** Torque with sign (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId torque_around_u_axis = RexsAttributeId.create("torque_around_u_axis", RexsStandardUnitIds.newton_m);

	/** Torque around the v-axis (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId torque_around_v_axis = RexsAttributeId.create("torque_around_v_axis", RexsStandardUnitIds.newton_m);

	/** Torque around the w-axis (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId torque_around_w_axis = RexsAttributeId.create("torque_around_w_axis", RexsStandardUnitIds.newton_m);

	/** Torque distribution around the u-axis (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId torque_distribution_u = RexsAttributeId.create("torque_distribution_u", RexsStandardUnitIds.newton_m);

	/** Torque distribution around the v-axis (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId torque_distribution_v = RexsAttributeId.create("torque_distribution_v", RexsStandardUnitIds.newton_m);

	/** Torque distribution around the w-axis (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId torque_distribution_w = RexsAttributeId.create("torque_distribution_w", RexsStandardUnitIds.newton_m);

	/** Maximum torsional torque (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId torsion_torque_maximum_din_743_2012 = RexsAttributeId.create("torsion_torque_maximum_din_743_2012", RexsStandardUnitIds.newton_m);

	/** Stress ratio of the torsional torque (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId torsion_torque_stress_ratio_din_743_2012 = RexsAttributeId.create("torsion_torque_stress_ratio_din_743_2012", RexsStandardUnitIds.none);

	/** Upper value torsional torque (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId torsion_torque_upper_value_din_743_2012 = RexsAttributeId.create("torsion_torque_upper_value_din_743_2012", RexsStandardUnitIds.newton_m);

	/** Torsion around the u-axis (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId torsion_u = RexsAttributeId.create("torsion_u", RexsStandardUnitIds.deg);

	/** Torsional yield strength (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId torsional_yield_stress_din_743_2012 = RexsAttributeId.create("torsional_yield_stress_din_743_2012", RexsStandardUnitIds.newton_per_mm2);

	/** Total contact ratio (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId total_contact_ratio = RexsAttributeId.create("total_contact_ratio", RexsStandardUnitIds.none);

	/** Total frictional power loss (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId total_frictional_power_loss = RexsAttributeId.create("total_frictional_power_loss", RexsStandardUnitIds.watt);

	/** Total frictional torque (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId total_frictional_torque = RexsAttributeId.create("total_frictional_torque", RexsStandardUnitIds.newton_m);

	/** Total pitch deviation (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId total_pitch_deviation_din_5480_2006 = RexsAttributeId.create("total_pitch_deviation_din_5480_2006", RexsStandardUnitIds.mum);

	/** Tooth force in u-direction (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId total_tooth_force_u_direction = RexsAttributeId.create("total_tooth_force_u_direction", RexsStandardUnitIds.kilo_newton);

	/** Tooth force in v-direction (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId total_tooth_force_v_direction = RexsAttributeId.create("total_tooth_force_v_direction", RexsStandardUnitIds.kilo_newton);

	/** Tooth force in w-direction (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId total_tooth_force_w_direction = RexsAttributeId.create("total_tooth_force_w_direction", RexsStandardUnitIds.kilo_newton);

	/** Load transmits torque (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId transmits_torque = RexsAttributeId.create("transmits_torque", RexsStandardUnitIds.none);

	/** Transmittable axial force (DIN 7190 2017) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId transmittable_axial_force_din_7190_2017 = RexsAttributeId.create("transmittable_axial_force_din_7190_2017", RexsStandardUnitIds.newton);

	/** Transmittable torque (DIN 7190 2017) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId transmittable_torque_din_7190_2017 = RexsAttributeId.create("transmittable_torque_din_7190_2017", RexsStandardUnitIds.newton_m);

	/** Transverse base pitch (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId transverse_base_pitch = RexsAttributeId.create("transverse_base_pitch", RexsStandardUnitIds.mm);

	/** Transverse circular pitch on reference circle (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId transverse_circular_pitch_on_reference_circle = RexsAttributeId.create("transverse_circular_pitch_on_reference_circle", RexsStandardUnitIds.mm);

	/** Transverse load factor flank (DIN 3990 1987) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId transverse_load_factor_flank_din_3990_1987 = RexsAttributeId.create("transverse_load_factor_flank_din_3990_1987", RexsStandardUnitIds.none);

	/** Transverse load factor (ISO 6336 2006) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId transverse_load_factor_iso_6336_2006 = RexsAttributeId.create("transverse_load_factor_iso_6336_2006", RexsStandardUnitIds.none);

	/** Transverse load factor pitting (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId transverse_load_factor_pitting_iso_10300_2014 = RexsAttributeId.create("transverse_load_factor_pitting_iso_10300_2014", RexsStandardUnitIds.none);

	/** Transverse load factor tooth root (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId transverse_load_factor_tooth_root_iso_10300_2014 = RexsAttributeId.create("transverse_load_factor_tooth_root_iso_10300_2014", RexsStandardUnitIds.none);

	/** Transverse module (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId transverse_module = RexsAttributeId.create("transverse_module", RexsStandardUnitIds.mm);

	/** Transverse radius of curvature at point A (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId transverse_radius_of_curvature_at_point_a = RexsAttributeId.create("transverse_radius_of_curvature_at_point_a", RexsStandardUnitIds.mm);

	/** Transverse radius of curvature at point B (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId transverse_radius_of_curvature_at_point_b = RexsAttributeId.create("transverse_radius_of_curvature_at_point_b", RexsStandardUnitIds.mm);

	/** Transverse radius of curvature at point C (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId transverse_radius_of_curvature_at_point_c = RexsAttributeId.create("transverse_radius_of_curvature_at_point_c", RexsStandardUnitIds.mm);

	/** Transverse radius of curvature at point D (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId transverse_radius_of_curvature_at_point_d = RexsAttributeId.create("transverse_radius_of_curvature_at_point_d", RexsStandardUnitIds.mm);

	/** Transverse radius of curvature at point E (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId transverse_radius_of_curvature_at_point_e = RexsAttributeId.create("transverse_radius_of_curvature_at_point_e", RexsStandardUnitIds.mm);

	/** Transverse radius of curvature at the calculation points (AGMA 925 A03) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId transverse_radius_of_curvature_of_calculation_points_agma_925_a03 = RexsAttributeId.create("transverse_radius_of_curvature_of_calculation_points_agma_925_a03", RexsStandardUnitIds.mm);

	/** Transverse radius of relative curvature at point A (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId transverse_radius_of_relative_curvature_at_point_a = RexsAttributeId.create("transverse_radius_of_relative_curvature_at_point_a", RexsStandardUnitIds.mm);

	/** Transverse radius of relative curvature at point B (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId transverse_radius_of_relative_curvature_at_point_b = RexsAttributeId.create("transverse_radius_of_relative_curvature_at_point_b", RexsStandardUnitIds.mm);

	/** Transverse radius of relative curvature at point C (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId transverse_radius_of_relative_curvature_at_point_c = RexsAttributeId.create("transverse_radius_of_relative_curvature_at_point_c", RexsStandardUnitIds.mm);

	/** Transverse radius of relative curvature at point D (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId transverse_radius_of_relative_curvature_at_point_d = RexsAttributeId.create("transverse_radius_of_relative_curvature_at_point_d", RexsStandardUnitIds.mm);

	/** Transverse radius of relative curvature at point E (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId transverse_radius_of_relative_curvature_at_point_e = RexsAttributeId.create("transverse_radius_of_relative_curvature_at_point_e", RexsStandardUnitIds.mm);

	/** Transverse relative radius of curvature of calculation points (AGMA 925 A03) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId transverse_relative_radius_of_curvature_of_calculation_points_agma_925_a03 = RexsAttributeId.create("transverse_relative_radius_of_curvature_of_calculation_points_agma_925_a03", RexsStandardUnitIds.mm);

	/** Transverse tooth thickness at active root diameter (Versions: 1.5, 1.6) */
	RexsAttributeId transverse_tooth_thickness_at_active_root_diameter = RexsAttributeId.create("transverse_tooth_thickness_at_active_root_diameter", RexsStandardUnitIds.mm);

	/** Transverse tooth thickness at active tip diameter (Versions: 1.5, 1.6) */
	RexsAttributeId transverse_tooth_thickness_at_active_tip_diameter = RexsAttributeId.create("transverse_tooth_thickness_at_active_tip_diameter", RexsStandardUnitIds.mm);

	/** Transverse tooth thickness at pitch diameter (Versions: 1.5, 1.6) */
	RexsAttributeId transverse_tooth_thickness_at_pitch_diameter = RexsAttributeId.create("transverse_tooth_thickness_at_pitch_diameter", RexsStandardUnitIds.mm);

	/** Transverse tooth thickness at reference diameter (Versions: 1.5, 1.6) */
	RexsAttributeId transverse_tooth_thickness_at_reference_diameter = RexsAttributeId.create("transverse_tooth_thickness_at_reference_diameter", RexsStandardUnitIds.mm);

	/** Transverse tooth thickness at root diameter (Versions: 1.5, 1.6) */
	RexsAttributeId transverse_tooth_thickness_at_root_diameter = RexsAttributeId.create("transverse_tooth_thickness_at_root_diameter", RexsStandardUnitIds.mm);

	/** Transverse tooth thickness at root form diameter (Versions: 1.5, 1.6) */
	RexsAttributeId transverse_tooth_thickness_at_root_form_diameter = RexsAttributeId.create("transverse_tooth_thickness_at_root_form_diameter", RexsStandardUnitIds.mm);

	/** Transverse tooth thickness at tip diameter (Versions: 1.5, 1.6) */
	RexsAttributeId transverse_tooth_thickness_at_tip_diameter = RexsAttributeId.create("transverse_tooth_thickness_at_tip_diameter", RexsStandardUnitIds.mm);

	/** Transverse tooth thickness at tip form diameter (Versions: 1.5, 1.6) */
	RexsAttributeId transverse_tooth_thickness_at_tip_form_diameter = RexsAttributeId.create("transverse_tooth_thickness_at_tip_form_diameter", RexsStandardUnitIds.mm);

	/** Diameter of begin of triangular root relief (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId triangular_root_relief_datum_diameter = RexsAttributeId.create("triangular_root_relief_datum_diameter", RexsStandardUnitIds.mm);

	/** Length of triangular root relief (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId triangular_root_relief_datum_length = RexsAttributeId.create("triangular_root_relief_datum_length", RexsStandardUnitIds.mm);

	/** Depth of triangular root relief (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId triangular_root_relief_depth = RexsAttributeId.create("triangular_root_relief_depth", RexsStandardUnitIds.mm);

	/** Diameter where tangential transition area of triangular root relief ends (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId triangular_root_relief_diameter_where_tangential_transition_ends = RexsAttributeId.create("triangular_root_relief_diameter_where_tangential_transition_ends", RexsStandardUnitIds.mm);

	/** Diameter where tangential transition area of triangular root relief starts (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId triangular_root_relief_diameter_where_tangential_transition_starts = RexsAttributeId.create("triangular_root_relief_diameter_where_tangential_transition_starts", RexsStandardUnitIds.mm);

	/** Diameter where amount of triangular root relief is specified (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId triangular_root_relief_evaluation_reference = RexsAttributeId.create("triangular_root_relief_evaluation_reference", RexsStandardUnitIds.mm);

	/** Rolling length where amount of triangular root relief is specified (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId triangular_root_relief_evaluation_reference_length = RexsAttributeId.create("triangular_root_relief_evaluation_reference_length", RexsStandardUnitIds.mm);

	/** Length of tangential transition area of triangular root relief end (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId triangular_root_relief_length_of_tangential_transition_end = RexsAttributeId.create("triangular_root_relief_length_of_tangential_transition_end", RexsStandardUnitIds.mm);

	/** Length of tangential transition area of triangular root relief start (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId triangular_root_relief_length_of_tangential_transition_start = RexsAttributeId.create("triangular_root_relief_length_of_tangential_transition_start", RexsStandardUnitIds.mm);

	/** Diameter of begin of triangular tip relief (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId triangular_tip_relief_datum_diameter = RexsAttributeId.create("triangular_tip_relief_datum_diameter", RexsStandardUnitIds.mm);

	/** Length of triangular tip relief (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId triangular_tip_relief_datum_length = RexsAttributeId.create("triangular_tip_relief_datum_length", RexsStandardUnitIds.mm);

	/** Depth of triangular tip relief (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId triangular_tip_relief_depth = RexsAttributeId.create("triangular_tip_relief_depth", RexsStandardUnitIds.mm);

	/** Diameter where tangential transition area of triangular tip relief ends (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId triangular_tip_relief_diameter_where_tangential_transition_ends = RexsAttributeId.create("triangular_tip_relief_diameter_where_tangential_transition_ends", RexsStandardUnitIds.mm);

	/** Diameter where tangential transition area of triangular tip relief starts (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId triangular_tip_relief_diameter_where_tangential_transition_starts = RexsAttributeId.create("triangular_tip_relief_diameter_where_tangential_transition_starts", RexsStandardUnitIds.mm);

	/** Diameter where amount of triangular tip relief is specified (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId triangular_tip_relief_evaluation_reference = RexsAttributeId.create("triangular_tip_relief_evaluation_reference", RexsStandardUnitIds.mm);

	/** Rolling length where amount of triangular tip relief is specified (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId triangular_tip_relief_evaluation_reference_length = RexsAttributeId.create("triangular_tip_relief_evaluation_reference_length", RexsStandardUnitIds.mm);

	/** Length of tangential transition area of triangular tip relief end (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId triangular_tip_relief_length_of_tangential_transition_end = RexsAttributeId.create("triangular_tip_relief_length_of_tangential_transition_end", RexsStandardUnitIds.mm);

	/** Length of tangential transition area of triangular tip relief start (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId triangular_tip_relief_length_of_tangential_transition_start = RexsAttributeId.create("triangular_tip_relief_length_of_tangential_transition_start", RexsStandardUnitIds.mm);

	/** Type of centering (DIN 5480 2006) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId type_of_centering_din_5480_2006 = RexsAttributeId.create("type_of_centering_din_5480_2006", RexsStandardUnitIds.none);

	/** Type of feather key according to DIN 6885 (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId type_of_feather_key_connection_din_6885 = RexsAttributeId.create("type_of_feather_key_connection_din_6885", RexsStandardUnitIds.none);

	/** Type of gear casing construction (VDI 2736 2014) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId type_of_gear_casing_construction_vdi_2736_2014 = RexsAttributeId.create("type_of_gear_casing_construction_vdi_2736_2014", RexsStandardUnitIds.none);

	/** Type of interpolation (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId type_of_interpolation_topographical_modification = RexsAttributeId.create("type_of_interpolation_topographical_modification", RexsStandardUnitIds.none);

	/** Type of surface contact (Versions: 1.6) */
	RexsAttributeId type_of_surface_contact = RexsAttributeId.create("type_of_surface_contact", RexsStandardUnitIds.none);

	/** u-axis vector (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId u_axis_vector = RexsAttributeId.create("u_axis_vector", RexsStandardUnitIds.mm);

	/** u-coordinate on shaft (Versions: 1.0, 1.0, 1.0, 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId u_coordinate_on_shaft = RexsAttributeId.create("u_coordinate_on_shaft", RexsStandardUnitIds.mm);

	/** Inner side: u-coordinate on shaft (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId u_coordinate_on_shaft_inner_side = RexsAttributeId.create("u_coordinate_on_shaft_inner_side", RexsStandardUnitIds.mm);

	/** Outer side: u-coordinate on shaft (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId u_coordinate_on_shaft_outer_side = RexsAttributeId.create("u_coordinate_on_shaft_outer_side", RexsStandardUnitIds.mm);

	/** u-coordinate on shaft on side 1 (Versions: 1.0) */
	RexsAttributeId u_coordinate_on_shaft_side_1 = RexsAttributeId.create("u_coordinate_on_shaft_side_1", RexsStandardUnitIds.mm);

	/** u-coordinate on shaft on side 2 (Versions: 1.0) */
	RexsAttributeId u_coordinate_on_shaft_side_2 = RexsAttributeId.create("u_coordinate_on_shaft_side_2", RexsStandardUnitIds.mm);

	/** U coordinates of beam nodes (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId u_coordinates_of_beam_nodes = RexsAttributeId.create("u_coordinates_of_beam_nodes", RexsStandardUnitIds.mm);

	/** Axial undercut width (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId undercut_width_axial = RexsAttributeId.create("undercut_width_axial", RexsStandardUnitIds.mm);

	/** Radial undercut width (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId undercut_width_radial = RexsAttributeId.create("undercut_width_radial", RexsStandardUnitIds.mm);

	/** Upper diametric deviation (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId upper_backlash_allowance_balls_or_pins = RexsAttributeId.create("upper_backlash_allowance_balls_or_pins", RexsStandardUnitIds.mm);

	/** Upper base tangent length deviation (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId upper_backlash_allowance_referenced_to_span = RexsAttributeId.create("upper_backlash_allowance_referenced_to_span", RexsStandardUnitIds.mum);

	/** Upper centre distance allowance (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId upper_center_distance_allowance = RexsAttributeId.create("upper_center_distance_allowance", RexsStandardUnitIds.mum);

	/** Usable addendum circle diameter (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId usable_addendum_circle_diameter = RexsAttributeId.create("usable_addendum_circle_diameter", RexsStandardUnitIds.mm);

	/** Usable root circle diameter (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId usable_root_circle_diameter = RexsAttributeId.create("usable_root_circle_diameter", RexsStandardUnitIds.mm);

	/** Utilization of yield strength (DIN 7190 2017) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId utilization_of_yield_strength_din_7190_2017 = RexsAttributeId.create("utilization_of_yield_strength_din_7190_2017", RexsStandardUnitIds.none);

	/** Utilized addendum coefficient reference profile (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId utilized_addendum_coefficient_reference_profile = RexsAttributeId.create("utilized_addendum_coefficient_reference_profile", RexsStandardUnitIds.none);

	/** Utilized addendum reference profile (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId utilized_addendum_reference_profile = RexsAttributeId.create("utilized_addendum_reference_profile", RexsStandardUnitIds.mm);

	/** Utilized dedenudum coefficient reference profile (Versions: 1.0, 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId utilized_dedendum_coefficient_reference_profile = RexsAttributeId.create("utilized_dedendum_coefficient_reference_profile", RexsStandardUnitIds.none);

	/** Utilized dedendum reference profile (Versions: 1.0, 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId utilized_dedendum_reference_profile = RexsAttributeId.create("utilized_dedendum_reference_profile", RexsStandardUnitIds.mm);

	/** Velocity factor (pitting) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId velocity_factor_pitting_din_3996_2019 = RexsAttributeId.create("velocity_factor_pitting_din_3996_2019", RexsStandardUnitIds.none);

	/** Version (Versions: 1.5, 1.6) */
	RexsAttributeId version = RexsAttributeId.create("version", RexsStandardUnitIds.none);

	/** Vertical motion coefficients (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId vertical_motion_coefficients = RexsAttributeId.create("vertical_motion_coefficients", RexsStandardUnitIds.none);

	/** Virtual number of teeth (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId virtual_number_of_teeth = RexsAttributeId.create("virtual_number_of_teeth", RexsStandardUnitIds.none);

	/** Viscosity at 100&deg;C (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId viscosity_at_100_degree_celsius = RexsAttributeId.create("viscosity_at_100_degree_celsius", RexsStandardUnitIds.mm2_per_s);

	/** Viscosity at 40&deg;C (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId viscosity_at_40_degree_celsius = RexsAttributeId.create("viscosity_at_40_degree_celsius", RexsStandardUnitIds.mm2_per_s);

	/** Viscosity ratio according to ISO 281 2007 (Versions: 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId viscosity_ratio_according_to_iso_281_2007 = RexsAttributeId.create("viscosity_ratio_according_to_iso_281_2007", RexsStandardUnitIds.none);

	/** Viscosity rating DIN 26281 (Versions: 1.0) */
	RexsAttributeId viscosity_ratio_din_26281 = RexsAttributeId.create("viscosity_ratio_din_26281", RexsStandardUnitIds.none);

	/** w-axis vector (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId w_axis_vector = RexsAttributeId.create("w_axis_vector", RexsStandardUnitIds.mm);

	/** Wear coefficient (VDI 2736 2014) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId wear_coefficient_vdi_2736_2014 = RexsAttributeId.create("wear_coefficient_vdi_2736_2014", RexsStandardUnitIds.wear_coefficient_vdi2736);

	/** Wear erosion (Plewe 1980) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId wear_erosion_plewe_1980 = RexsAttributeId.create("wear_erosion_plewe_1980", RexsStandardUnitIds.mm_per_h);

	/** Wear intensity (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId wear_intensity_din_3996_2019 = RexsAttributeId.create("wear_intensity_din_3996_2019", RexsStandardUnitIds.none);

	/** Wear life (Plewe 1980) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId wear_life_time_plewe_1980 = RexsAttributeId.create("wear_life_time_plewe_1980", RexsStandardUnitIds.hour);

	/** Wear mass (Plewe 1980) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId wear_mass_plewe_1980 = RexsAttributeId.create("wear_mass_plewe_1980", RexsStandardUnitIds.mg);

	/** Wear safety factor (backlash &gt; 0,3 module) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId wear_safety_factor_backlash_din_3996_2019 = RexsAttributeId.create("wear_safety_factor_backlash_din_3996_2019", RexsStandardUnitIds.none);

	/** Wear safety factor (pointed tooth) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId wear_safety_factor_pointed_tooth_din_3996_2019 = RexsAttributeId.create("wear_safety_factor_pointed_tooth_din_3996_2019", RexsStandardUnitIds.none);

	/** Weibull exponent (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId weibull_exponent = RexsAttributeId.create("weibull_exponent", RexsStandardUnitIds.none);

	/** Welding factor (AGMA 925 C95) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId welding_factor_agma_925_a03 = RexsAttributeId.create("welding_factor_agma_925_a03", RexsStandardUnitIds.none);

	/** Wheel bulk temperature (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId wheel_bulk_temperature_din_3996_2019 = RexsAttributeId.create("wheel_bulk_temperature_din_3996_2019", RexsStandardUnitIds.degree_celsius);

	/** Width (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId width = RexsAttributeId.create("width", RexsStandardUnitIds.mm);

	/** Width of large outer diameter with shouldered hub (DIN 6892 2012) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId width_large_outer_diameter_shouldered_hub_din_6892_2012 = RexsAttributeId.create("width_large_outer_diameter_shouldered_hub_din_6892_2012", RexsStandardUnitIds.mm);

	/** Width of line load (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId width_of_external_load = RexsAttributeId.create("width_of_external_load", RexsStandardUnitIds.mm);

	/** Width of feather key (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId width_of_feather_key = RexsAttributeId.create("width_of_feather_key", RexsStandardUnitIds.mm);

	/** Width of hub (DIN 6892 2012) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId width_of_hub_din_6892_2012 = RexsAttributeId.create("width_of_hub_din_6892_2012", RexsStandardUnitIds.mm);

	/** Offset of width (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId width_offset = RexsAttributeId.create("width_offset", RexsStandardUnitIds.mm);

	/** Width of small outer diameter with shouldered hub (DIN 6892 2012) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId width_small_outer_diameter_shouldered_hub_din_6892_2012 = RexsAttributeId.create("width_small_outer_diameter_shouldered_hub_din_6892_2012", RexsStandardUnitIds.mm);

	/** Width to pitch diameter ratio (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId width_to_diameter_ratio = RexsAttributeId.create("width_to_diameter_ratio", RexsStandardUnitIds.none);

	/** Width to normal module ratio (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId width_to_normal_module_ratio = RexsAttributeId.create("width_to_normal_module_ratio", RexsStandardUnitIds.none);

	/** Work hardening factor (ISO 10300 2014) (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId work_hardening_factor_pitting_iso_10300_2014 = RexsAttributeId.create("work_hardening_factor_pitting_iso_10300_2014", RexsStandardUnitIds.none);

	/** Work offset (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId work_offset = RexsAttributeId.create("work_offset", RexsStandardUnitIds.mm);

	/** Working depth (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId working_depth = RexsAttributeId.create("working_depth", RexsStandardUnitIds.mm);

	/** Working depth factor (Versions: 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId working_depth_coefficient = RexsAttributeId.create("working_depth_coefficient", RexsStandardUnitIds.none);

	/** Material depth of maximum hardness (ISO 6336 2019) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId y_coordinate_of_maximum_hardness_iso_6336_2019 = RexsAttributeId.create("y_coordinate_of_maximum_hardness_iso_6336_2019", RexsStandardUnitIds.mm);

	/** Yield strength (Versions: 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId yield_strength = RexsAttributeId.create("yield_strength", RexsStandardUnitIds.newton_per_mm2);

	/** Yield strength at operating temperature (VDI 2736 2014) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId yield_strength_at_operating_temperature_vdi_2736_2014 = RexsAttributeId.create("yield_strength_at_operating_temperature_vdi_2736_2014", RexsStandardUnitIds.newton_per_mm2);

	/** Yield strength of component (Versions: 1.4, 1.5, 1.6) */
	RexsAttributeId yield_strength_of_component_fkm_2012 = RexsAttributeId.create("yield_strength_of_component_fkm_2012", RexsStandardUnitIds.mega_pascal);

	/** Zone factor (VDI 2736 2014) (Versions: 1.3, 1.4, 1.5, 1.6) */
	RexsAttributeId zone_factor_vdi_2736_2014 = RexsAttributeId.create("zone_factor_vdi_2736_2014", RexsStandardUnitIds.none);

	/** unknown attribute */
	RexsAttributeId UNKNOWN = RexsAttributeId.create("unknown", RexsStandardUnitIds.UNKNOWN);

	public static void init() {}
}
