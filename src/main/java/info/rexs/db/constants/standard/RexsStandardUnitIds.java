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

import info.rexs.db.constants.RexsUnitId;

/**
 * This class represents a REXS unit.
 * <p>
 * It contains constants for all units of official REXS versions (1.0, 1.1, 1.2, 1.3, 1.4, 1.5).
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
	public static final RexsUnitId degree = RexsUnitId.create("\u00B0");

	/** dB */
	public static final RexsUnitId db = RexsUnitId.create("dB");

	/** deg */
	public static final RexsUnitId deg = RexsUnitId.create("deg");

	/** C */
	public static final RexsUnitId degree_celsius = RexsUnitId.create("C");

	/** HB */
	public static final RexsUnitId hb = RexsUnitId.create("HB");

	/** K (m / s)^0.75 mm^1.75 / W */
	public static final RexsUnitId heat_transfer_coefficient_vdi2736 = RexsUnitId.create("K (m / s)^0.75 mm^1.75 / W");

	/** Hz */
	public static final RexsUnitId hertz = RexsUnitId.create("Hz");

	/** h */
	public static final RexsUnitId hour = RexsUnitId.create("h");

	/** HRC */
	public static final RexsUnitId hrc = RexsUnitId.create("HRC");

	/** HV */
	public static final RexsUnitId hv = RexsUnitId.create("HV");

	/** J / (kg K) */
	public static final RexsUnitId j_per_kg_k = RexsUnitId.create("J / (kg K)");

	/** K */
	public static final RexsUnitId kelvin = RexsUnitId.create("K");

	/** K m^2 / W */
	public static final RexsUnitId kelvin_m2_per_watt = RexsUnitId.create("K m^2 / W");

	/** K / mus */
	public static final RexsUnitId kelvin_per_mus = RexsUnitId.create("K / mus");

	/** kg */
	public static final RexsUnitId kg = RexsUnitId.create("kg");

	/** kg m^2 */
	public static final RexsUnitId kg_m2 = RexsUnitId.create("kg m^2");

	/** kg / dm^3 */
	public static final RexsUnitId kg_per_dm3 = RexsUnitId.create("kg / dm^3");

	/** kN */
	public static final RexsUnitId kilo_newton = RexsUnitId.create("kN");

	/** kW */
	public static final RexsUnitId kilo_watt = RexsUnitId.create("kW");

	/** l / min */
	public static final RexsUnitId litre_per_minute = RexsUnitId.create("l / min");

	/** m^2 */
	public static final RexsUnitId m2 = RexsUnitId.create("m^2");

	/** m^3 / s */
	public static final RexsUnitId m3_per_second = RexsUnitId.create("m^3 / s");

	/** m / s^2 */
	public static final RexsUnitId m_per_s2 = RexsUnitId.create("m / s^2");

	/** m / s */
	public static final RexsUnitId m_per_second = RexsUnitId.create("m / s");

	/** MPa */
	public static final RexsUnitId mega_pascal = RexsUnitId.create("MPa");

	/** mg */
	public static final RexsUnitId mg = RexsUnitId.create("mg");

	/** mm */
	public static final RexsUnitId mm = RexsUnitId.create("mm");

	/** mm^2 */
	public static final RexsUnitId mm2 = RexsUnitId.create("mm^2");

	/** mm^2 / N */
	public static final RexsUnitId mm2_per_newton = RexsUnitId.create("mm^2 / N");

	/** mm^2 / s */
	public static final RexsUnitId mm2_per_s = RexsUnitId.create("mm^2 / s");

	/** mm / h */
	public static final RexsUnitId mm_per_h = RexsUnitId.create("mm / h");

	/** mPa s */
	public static final RexsUnitId mpa_s = RexsUnitId.create("mPa s");

	/** mum */
	public static final RexsUnitId mum = RexsUnitId.create("mum");

	/** mus */
	public static final RexsUnitId mus = RexsUnitId.create("mus");

	/** N */
	public static final RexsUnitId newton = RexsUnitId.create("N");

	/** N m */
	public static final RexsUnitId newton_m = RexsUnitId.create("N m");

	/** N mm / rad */
	public static final RexsUnitId newton_mm_per_rad = RexsUnitId.create("N mm / rad");

	/** N / m */
	public static final RexsUnitId newton_per_m = RexsUnitId.create("N / m");

	/** N / mm */
	public static final RexsUnitId newton_per_mm = RexsUnitId.create("N / mm");

	/** N / mm^2 */
	public static final RexsUnitId newton_per_mm2 = RexsUnitId.create("N / mm^2");

	/** (N / mm^2)^0.5 */
	public static final RexsUnitId newton_per_mm2_then_squareroot = RexsUnitId.create("(N / mm^2)^0.5");

	/** N / (mm mum) */
	public static final RexsUnitId newton_per_mm_mum = RexsUnitId.create("N / (mm mum)");

	/** N / (mm s^0.5 K) */
	public static final RexsUnitId newton_per_mm_s_then_squareroot_k = RexsUnitId.create("N / (mm s^0.5 K)");

	/** N / rad */
	public static final RexsUnitId newton_per_radian = RexsUnitId.create("N / rad");

	/** none */
	public static final RexsUnitId none = RexsUnitId.create("none");

	/** Pa */
	public static final RexsUnitId pascal = RexsUnitId.create("Pa");

	/** 1 / mm */
	public static final RexsUnitId per_mm = RexsUnitId.create("1 / mm");

	/** % */
	public static final RexsUnitId percent = RexsUnitId.create("%");

	/** rad */
	public static final RexsUnitId radian = RexsUnitId.create("rad");

	/** rad / s */
	public static final RexsUnitId radian_per_s = RexsUnitId.create("rad / s");

	/** 1 / min */
	public static final RexsUnitId rotation_per_min = RexsUnitId.create("1 / min");

	/** 1 / s */
	public static final RexsUnitId rotation_per_second = RexsUnitId.create("1 / s");

	/** s */
	public static final RexsUnitId second = RexsUnitId.create("s");

	/** 1e-6 / C */
	public static final RexsUnitId thermal_expansion_coefficient = RexsUnitId.create("1e-6 / C");

	/** W */
	public static final RexsUnitId watt = RexsUnitId.create("W");

	/** W / (m K) */
	public static final RexsUnitId watt_per_m_k = RexsUnitId.create("W / (m K)");

	/** W / mm */
	public static final RexsUnitId watt_per_mm = RexsUnitId.create("W / mm");

	/** 1e-6 mm^3 / (N m) */
	public static final RexsUnitId wear_coefficient_vdi2736 = RexsUnitId.create("1e-6 mm^3 / (N m)");

	/** Constant for an unknown unit. */
	public static final RexsUnitId UNKNOWN = RexsUnitId.create("unknown");

	public static void init() {}
}
