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

/**
 * This class represents a REXS unit.
 * <p>
 * It contains constants for all units of official REXS versions (1.0, 1.1, 1.2).
 * <p>
 * Since REXS is freely expandable, you can also add your own units using the {@link #create(String)} method.
 *
 * @author FVA GmbH
 */
public class UnitId {

	/** An internal index with all created units (REXS standard and own) for quick access. */
	private static Map<String, UnitId> allUnitIds = new HashMap<>();

	/** dB */
	public static final UnitId db = create("dB");

	/** ° */
	public static final UnitId degree = create("°");

	/** C */
	public static final UnitId degree_celsius = create("C");

	/** HB */
	public static final UnitId hb = create("HB");

	/** K (m / s)^0.75 mm^1.75 / W */
	public static final UnitId heat_transfer_coefficient_vdi2736 = create("K (m / s)^0.75 mm^1.75 / W");

	/** Hz */
	public static final UnitId hertz = create("Hz");

	/** h */
	public static final UnitId hour = create("h");

	/** HRC */
	public static final UnitId hrc = create("HRC");

	/** HV */
	public static final UnitId hv = create("HV");

	/** J / (kg K) */
	public static final UnitId j_per_kg_k = create("J / (kg K)");

	/** K */
	public static final UnitId kelvin = create("K");

	/** K m^2 / W */
	public static final UnitId kelvin_m2_per_watt = create("K m^2 / W");

	/** K / mus */
	public static final UnitId kelvin_per_mus = create("K / mus");

	/** kg */
	public static final UnitId kg = create("kg");

	/** kg m^2 */
	public static final UnitId kg_m2 = create("kg m^2");

	/** kg / dm^3 */
	public static final UnitId kg_per_dm3 = create("kg / dm^3");

	/** kN */
	public static final UnitId kilo_newton = create("kN");

	/** kW */
	public static final UnitId kilo_watt = create("kW");

	/** l / min */
	public static final UnitId litre_per_minute = create("l / min");

	/** m^2 */
	public static final UnitId m2 = create("m^2");

	/** m^3 / s */
	public static final UnitId m3_per_second = create("m^3 / s");

	/** m / s^2 */
	public static final UnitId m_per_s2 = create("m / s^2");

	/** m / s */
	public static final UnitId m_per_second = create("m / s");

	/** MPa */
	public static final UnitId mega_pascal = create("MPa");

	/** mg */
	public static final UnitId mg = create("mg");

	/** mm */
	public static final UnitId mm = create("mm");

	/** mm^2 */
	public static final UnitId mm2 = create("mm^2");

	/** mm^2 / N */
	public static final UnitId mm2_per_newton = create("mm^2 / N");

	/** mm^2 / s */
	public static final UnitId mm2_per_s = create("mm^2 / s");

	/** mm / h */
	public static final UnitId mm_per_h = create("mm / h");

	/** mPa s */
	public static final UnitId mpa_s = create("mPa s");

	/** mum */
	public static final UnitId mum = create("mum");

	/** mus */
	public static final UnitId mus = create("mus");

	/** N */
	public static final UnitId newton = create("N");

	/** N m */
	public static final UnitId newton_m = create("N m");

	/** N mm / rad */
	public static final UnitId newton_mm_per_rad = create("N mm / rad");

	/** N / m */
	public static final UnitId newton_per_m = create("N / m");

	/** N / mm */
	public static final UnitId newton_per_mm = create("N / mm");

	/** N / mm^2 */
	public static final UnitId newton_per_mm2 = create("N / mm^2");

	/** (N / mm^2)^0.5 */
	public static final UnitId newton_per_mm2_then_squareroot = create("(N / mm^2)^0.5");

	/** N / (mm mum) */
	public static final UnitId newton_per_mm_mum = create("N / (mm mum)");

	/** N / (mm s^0.5 K) */
	public static final UnitId newton_per_mm_s_then_squareroot_k = create("N / (mm s^0.5 K)");

	/** N / rad */
	public static final UnitId newton_per_radian = create("N / rad");

	/** none */
	public static final UnitId none = create("none");

	/** Pa */
	public static final UnitId pascal = create("Pa");

	/** 1 / mm */
	public static final UnitId per_mm = create("1 / mm");

	/** % */
	public static final UnitId percent = create("%");

	/** rad */
	public static final UnitId radian = create("rad");

	/** rad / s */
	public static final UnitId radian_per_s = create("rad / s");

	/** 1 / min */
	public static final UnitId rotation_per_min = create("1 / min");

	/** 1 / s */
	public static final UnitId rotation_per_second = create("1 / s");

	/** s */
	public static final UnitId second = create("s");

	/** 1e-6 / C */
	public static final UnitId thermal_expansion_coefficient = create("1e-6 / C");

	/** W */
	public static final UnitId watt = create("W");

	/** W / (m K) */
	public static final UnitId watt_per_m_k = create("W / (m K)");

	/** W / mm */
	public static final UnitId watt_per_mm = create("W / mm");

	/** 1e-6 mm^3 / (N m) */
	public static final UnitId wear_coefficient_vdi2736 = create("1e-6 mm^3 / (N m)");

	/** The actual unit ID as a {@link String}. */
	private final String id;

	private UnitId(String id) {
		if (id == null || id.isEmpty())
			throw new IllegalArgumentException("id cannot be empty");
		this.id = id;
	}

	/**
	 * @return
	 * 				The actual unit ID as a {@link String}.
	 */
	public String getId() {
		return id;
	}

	/**
	 * Creates a new unit ID and adds it to the internal index.
	 *
	 * @param id
	 * 				The actual unit ID as a {@link String}.
	 *
	 * @return
	 * 				The newly created unit ID as {@link UnitId}.
	 */
	public static UnitId create(String id) {
		UnitId unitId = new UnitId(id);
		allUnitIds.put(id, unitId);
		return unitId;
	}

	/**
	 * Returns the unit ID for a textual ID from the internally stored index of all unit IDs.
	 *
	 * @param id
	 * 				The actual unit ID to be found as a {@link String}
	 *
	 * @return
	 * 				The found unit ID as {@link UnitId}, or {@code null} if the ID could not be found.
	 */
	public static UnitId findById(String id) {
		if (id == null)
			return null;
		return allUnitIds.getOrDefault(id, null);
	}
}
