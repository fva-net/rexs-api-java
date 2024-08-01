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

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import info.rexs.db.constants.RexsUnitId;

/**
 * This class represents a REXS unit.
 * <p>
 * It contains constants for all units of official REXS versions (1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6).
 *
 * @author FVA GmbH
 */
public interface RexsStandardUnitIds {

	/**
	 * °
	 * @deprecated
	 * This unit was only used in REXS versions 1.0 to 1.3.
	 * <p>From REXS version 1.4 use {@link #deg} instead.
	 */
	@Deprecated
	public static final RexsUnitId degree = RexsUnitId.create("\u00B0", 3);

	/** dB */
	public static final RexsUnitId db = RexsUnitId.create("dB", 51);

	/** deg */
	public static final RexsUnitId deg = RexsUnitId.create("deg", 58);

	/** C */
	public static final RexsUnitId degree_celsius = RexsUnitId.create("C", 1);

	/** HB */
	public static final RexsUnitId hb = RexsUnitId.create("HB", 28);

	/** K (m / s)^0.75 mm^1.75 / W */
	public static final RexsUnitId heat_transfer_coefficient_vdi2736 = RexsUnitId.create("K (m / s)^0.75 mm^1.75 / W", 40);

	/** Hz */
	public static final RexsUnitId hertz = RexsUnitId.create("Hz", 32);

	/** h */
	public static final RexsUnitId hour = RexsUnitId.create("h", 17);

	/** HRC */
	public static final RexsUnitId hrc = RexsUnitId.create("HRC", 27);

	/** HV */
	public static final RexsUnitId hv = RexsUnitId.create("HV", 18);

	/** J / (kg K) */
	public static final RexsUnitId j_per_kg_k = RexsUnitId.create("J / (kg K)", 23);

	/** K */
	public static final RexsUnitId kelvin = RexsUnitId.create("K", 6);

	/** K m^2 / W */
	public static final RexsUnitId kelvin_m2_per_watt = RexsUnitId.create("K m^2 / W", 36);

	/** K / mus */
	public static final RexsUnitId kelvin_per_mus = RexsUnitId.create("K / mus", 50);

	/** kg */
	public static final RexsUnitId kg = RexsUnitId.create("kg", 56);

	/** kg m^2 */
	public static final RexsUnitId kg_m2 = RexsUnitId.create("kg m^2", 57);

	/** kg / dm^3 */
	public static final RexsUnitId kg_per_dm3 = RexsUnitId.create("kg / dm^3", 21);

	/** kN */
	public static final RexsUnitId kilo_newton = RexsUnitId.create("kN", 5);

	/** kW */
	public static final RexsUnitId kilo_watt = RexsUnitId.create("kW", 30);

	/** l / min */
	public static final RexsUnitId litre_per_minute = RexsUnitId.create("l / min", 16);

	/** m^2 */
	public static final RexsUnitId m2 = RexsUnitId.create("m^2", 35);

	/** m^3 / s */
	public static final RexsUnitId m3_per_second = RexsUnitId.create("m^3 / s", 53);

	/** m / s^2 */
	public static final RexsUnitId m_per_s2 = RexsUnitId.create("m / s^2", 33);

	/** m / s */
	public static final RexsUnitId m_per_second = RexsUnitId.create("m / s", 34);

	/** MPa */
	public static final RexsUnitId mega_pascal = RexsUnitId.create("MPa", 14);

	/** mg */
	public static final RexsUnitId mg = RexsUnitId.create("mg", 41);

	/** mm */
	public static final RexsUnitId mm = RexsUnitId.create("mm", 2);

	/** mm^2 */
	public static final RexsUnitId mm2 = RexsUnitId.create("mm^2", 54);

	/** mm^2 / N */
	public static final RexsUnitId mm2_per_newton = RexsUnitId.create("mm^2 / N", 44);

	/** mm^2 / s */
	public static final RexsUnitId mm2_per_s = RexsUnitId.create("mm^2 / s", 24);

	/** mm / h */
	public static final RexsUnitId mm_per_h = RexsUnitId.create("mm / h", 43);

	/** mPa s */
	public static final RexsUnitId mpa_s = RexsUnitId.create("mPa s", 46);

	/** mum */
	public static final RexsUnitId mum = RexsUnitId.create("mum", 11);

	/** mus */
	public static final RexsUnitId mus = RexsUnitId.create("mus", 49);

	/** N */
	public static final RexsUnitId newton = RexsUnitId.create("N", 10);

	/** N m */
	public static final RexsUnitId newton_m = RexsUnitId.create("N m", 12);

	/** N mm / rad */
	public static final RexsUnitId newton_mm_per_rad = RexsUnitId.create("N mm / rad", 8);

	/** N / m */
	public static final RexsUnitId newton_per_m = RexsUnitId.create("N / m", 9);

	/** N / mm */
	public static final RexsUnitId newton_per_mm = RexsUnitId.create("N / mm", 45);

	/** N / mm^2 */
	public static final RexsUnitId newton_per_mm2 = RexsUnitId.create("N / mm^2", 19);

	/** (N / mm^2)^0.5 */
	public static final RexsUnitId newton_per_mm2_then_squareroot = RexsUnitId.create("(N / mm^2)^0.5", 38);

	/** N / (mm mum) */
	public static final RexsUnitId newton_per_mm_mum = RexsUnitId.create("N / (mm mum)", 37);

	/** N / (mm s^0.5 K) */
	public static final RexsUnitId newton_per_mm_s_then_squareroot_k = RexsUnitId.create("N / (mm s^0.5 K)", 47);

	/** N / rad */
	public static final RexsUnitId newton_per_radian = RexsUnitId.create("N / rad", 31);

	/** none */
	public static final RexsUnitId none = RexsUnitId.create("none", 4);

	/** Pa */
	public static final RexsUnitId pascal = RexsUnitId.create("Pa", 52);

	/** 1 / mm */
	public static final RexsUnitId per_mm = RexsUnitId.create("1 / mm", 55);

	/** % */
	public static final RexsUnitId percent = RexsUnitId.create("%", 7);

	/** rad */
	public static final RexsUnitId radian = RexsUnitId.create("rad", 13);

	/** rad / s */
	public static final RexsUnitId radian_per_s = RexsUnitId.create("rad / s", 48);

	/** 1 / min */
	public static final RexsUnitId rotation_per_min = RexsUnitId.create("1 / min", 25);

	/** 1 / s */
	public static final RexsUnitId rotation_per_second = RexsUnitId.create("1 / s", 42);

	/** s */
	public static final RexsUnitId second = RexsUnitId.create("s", 26);

	/** 1e-6 / C */
	public static final RexsUnitId thermal_expansion_coefficient = RexsUnitId.create("1e-6 / C", 20);

	/** MRev */
	public static final RexsUnitId unit_59 = RexsUnitId.create("MRev", 59);

	/** W / (m^2 K) */
	public static final RexsUnitId unit_60 = RexsUnitId.create("W / (m^2 K)", 60);

	/** kg / mm */
	public static final RexsUnitId unit_61 = RexsUnitId.create("kg / mm", 61);

	/** W */
	public static final RexsUnitId watt = RexsUnitId.create("W", 29);

	/** W / (m K) */
	public static final RexsUnitId watt_per_m_k = RexsUnitId.create("W / (m K)", 22);

	/** W / mm */
	public static final RexsUnitId watt_per_mm = RexsUnitId.create("W / mm", 15);

	/** 1e-6 mm^3 / (N m) */
	public static final RexsUnitId wear_coefficient_vdi2736 = RexsUnitId.create("1e-6 mm^3 / (N m)", 39);

	/** Constant for an unknown unit. */
	public static final RexsUnitId UNKNOWN = RexsUnitId.create("unknown");

	/** A set of equivalent units. */
	public static Set<Set<RexsUnitId>> EQUIVALENT_UNITS = new HashSet<>(Arrays.asList(
		new HashSet<>(Arrays.asList(mega_pascal, newton_per_mm2)),
		new HashSet<>(Arrays.asList(rotation_per_second, hertz))
	));

	public static void init() {}
}
