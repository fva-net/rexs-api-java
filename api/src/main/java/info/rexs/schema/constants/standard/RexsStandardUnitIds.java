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

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.processing.Generated;

import info.rexs.schema.constants.RexsUnitId;

/**
 * This class represents a REXS unit.
 * <p>
 * It contains constants for all units of official REXS versions (1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7).
 *
 * @author FVA GmbH
 */
@Generated("REXS-Database by FVA GmbH (see https://database.rexs.info/)")
public interface RexsStandardUnitIds {

	/**
	 * °
	 * @deprecated
	 * This unit was only used in REXS versions 1.0 to 1.3.
	 * <p>From REXS version 1.4 use {@link #deg} instead.
	 */
	@Deprecated
	RexsUnitId degree = RexsUnitId.create("\u00B0", 3);

	/** dB */
	RexsUnitId db = RexsUnitId.create("dB", 51);

	/** deg */
	RexsUnitId deg = RexsUnitId.create("deg", 58);

	/** C */
	RexsUnitId degree_celsius = RexsUnitId.create("C", 1);

	/** HB */
	RexsUnitId hb = RexsUnitId.create("HB", 28);

	/** K (m / s)^0.75 mm^1.75 / W */
	RexsUnitId heat_transfer_coefficient_vdi2736 = RexsUnitId.create("K (m / s)^0.75 mm^1.75 / W", 40);

	/** Hz */
	RexsUnitId hertz = RexsUnitId.create("Hz", 32);

	/** h */
	RexsUnitId hour = RexsUnitId.create("h", 17);

	/** HRC */
	RexsUnitId hrc = RexsUnitId.create("HRC", 27);

	/** HV */
	RexsUnitId hv = RexsUnitId.create("HV", 18);

	/** J / (kg K) */
	RexsUnitId j_per_kg_k = RexsUnitId.create("J / (kg K)", 23);

	/** K */
	RexsUnitId kelvin = RexsUnitId.create("K", 6);

	/** K m^2 / W */
	RexsUnitId kelvin_m2_per_watt = RexsUnitId.create("K m^2 / W", 36);

	/** K / mus */
	RexsUnitId kelvin_per_mus = RexsUnitId.create("K / mus", 50);

	/** kg */
	RexsUnitId kg = RexsUnitId.create("kg", 56);

	/** kg m^2 */
	RexsUnitId kg_m2 = RexsUnitId.create("kg m^2", 57);

	/** kg / dm^3 */
	RexsUnitId kg_per_dm3 = RexsUnitId.create("kg / dm^3", 21);

	/** kN */
	RexsUnitId kilo_newton = RexsUnitId.create("kN", 5);

	/** kW */
	RexsUnitId kilo_watt = RexsUnitId.create("kW", 30);

	/** l / min */
	RexsUnitId litre_per_minute = RexsUnitId.create("l / min", 16);

	/** m^2 */
	RexsUnitId m2 = RexsUnitId.create("m^2", 35);

	/** m^3 / s */
	RexsUnitId m3_per_second = RexsUnitId.create("m^3 / s", 53);

	/** m / s^2 */
	RexsUnitId m_per_s2 = RexsUnitId.create("m / s^2", 33);

	/** m / s */
	RexsUnitId m_per_second = RexsUnitId.create("m / s", 34);

	/** MPa */
	RexsUnitId mega_pascal = RexsUnitId.create("MPa", 14);

	/** mg */
	RexsUnitId mg = RexsUnitId.create("mg", 41);

	/** mm */
	RexsUnitId mm = RexsUnitId.create("mm", 2);

	/** mm^2 */
	RexsUnitId mm2 = RexsUnitId.create("mm^2", 54);

	/** mm^2 / N */
	RexsUnitId mm2_per_newton = RexsUnitId.create("mm^2 / N", 44);

	/** mm^2 / s */
	RexsUnitId mm2_per_s = RexsUnitId.create("mm^2 / s", 24);

	/** mm / h */
	RexsUnitId mm_per_h = RexsUnitId.create("mm / h", 43);

	/** mPa s */
	RexsUnitId mpa_s = RexsUnitId.create("mPa s", 46);

	/** mum */
	RexsUnitId mum = RexsUnitId.create("mum", 11);

	/** mus */
	RexsUnitId mus = RexsUnitId.create("mus", 49);

	/** N */
	RexsUnitId newton = RexsUnitId.create("N", 10);

	/** N m */
	RexsUnitId newton_m = RexsUnitId.create("N m", 12);

	/** N mm / rad */
	RexsUnitId newton_mm_per_rad = RexsUnitId.create("N mm / rad", 8);

	/** N / m */
	RexsUnitId newton_per_m = RexsUnitId.create("N / m", 9);

	/** N / mm */
	RexsUnitId newton_per_mm = RexsUnitId.create("N / mm", 45);

	/** N / mm^2 */
	RexsUnitId newton_per_mm2 = RexsUnitId.create("N / mm^2", 19);

	/** (N / mm^2)^0.5 */
	RexsUnitId newton_per_mm2_then_squareroot = RexsUnitId.create("(N / mm^2)^0.5", 38);

	/** N / (mm mum) */
	RexsUnitId newton_per_mm_mum = RexsUnitId.create("N / (mm mum)", 37);

	/** N / (mm s^0.5 K) */
	RexsUnitId newton_per_mm_s_then_squareroot_k = RexsUnitId.create("N / (mm s^0.5 K)", 47);

	/** N / rad */
	RexsUnitId newton_per_radian = RexsUnitId.create("N / rad", 31);

	/** none */
	RexsUnitId none = RexsUnitId.create("none", 4);

	/** Pa */
	RexsUnitId pascal = RexsUnitId.create("Pa", 52);

	/** 1 / mm */
	RexsUnitId per_mm = RexsUnitId.create("1 / mm", 55);

	/** % */
	RexsUnitId percent = RexsUnitId.create("%", 7);

	/** rad */
	RexsUnitId radian = RexsUnitId.create("rad", 13);

	/** rad / s */
	RexsUnitId radian_per_s = RexsUnitId.create("rad / s", 48);

	/** 1 / min */
	RexsUnitId rotation_per_min = RexsUnitId.create("1 / min", 25);

	/** 1 / s */
	RexsUnitId rotation_per_second = RexsUnitId.create("1 / s", 42);

	/** s */
	RexsUnitId second = RexsUnitId.create("s", 26);

	/** 1e-6 / C */
	RexsUnitId thermal_expansion_coefficient = RexsUnitId.create("1e-6 / C", 20);

	/** MRev */
	RexsUnitId unit_59 = RexsUnitId.create("MRev", 59);

	/** W / (m^2 K) */
	RexsUnitId unit_60 = RexsUnitId.create("W / (m^2 K)", 60);

	/** kg / mm */
	RexsUnitId unit_61 = RexsUnitId.create("kg / mm", 61);

	/** W */
	RexsUnitId watt = RexsUnitId.create("W", 29);

	/** W / (m K) */
	RexsUnitId watt_per_m_k = RexsUnitId.create("W / (m K)", 22);

	/** W / mm */
	RexsUnitId watt_per_mm = RexsUnitId.create("W / mm", 15);

	/** 1e-6 mm^3 / (N m) */
	RexsUnitId wear_coefficient_vdi2736 = RexsUnitId.create("1e-6 mm^3 / (N m)", 39);

	/** Constant for an unknown unit. */
	RexsUnitId UNKNOWN = RexsUnitId.create("unknown");

	/** A set of equivalent units. */
	Set<Set<RexsUnitId>> EQUIVALENT_UNITS = new HashSet<>(Arrays.asList(
		new HashSet<>(Arrays.asList(mega_pascal, newton_per_mm2)),
		new HashSet<>(Arrays.asList(rotation_per_second, hertz)),
		new HashSet<>(Arrays.asList(deg, degree))
	));

	public static void init() {}
}
