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
 * This class represents the type of a REXS component.
 * <p>
 * It contains constants for all component types of official REXS versions (1.0, 1.1, 1.2).
 * <p>
 * Since REXS is freely expandable, you can also add your own component types using the {@link #create(String)} method.
 *
 * @author FVA GmbH
 */
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ComponentType {

	/** An internal index with all created component types (REXS standard and own) for quick access. */
	private static Map<String, ComponentType> allComponentTypes = new HashMap<>();

	/** Assembly group (Versions: 1.1, 1.2) */
	public static final ComponentType assembly_group = create("assembly_group");

	/** Bevel gear (Versions: 1.0, 1.1, 1.2) */
	public static final ComponentType bevel_gear = create("bevel_gear");

	/** Bevel stage (Versions: 1.0, 1.1, 1.2) */
	public static final ComponentType bevel_stage = create("bevel_stage");

	/** Concept bearing (Versions: 1.0, 1.1, 1.2) */
	public static final ComponentType concept_bearing = create("concept_bearing");

	/** Coupling (Versions: 1.1, 1.2) */
	public static final ComponentType coupling = create("coupling");

	/** Cutter wheel tool (Versions: 1.0, 1.1, 1.2) */
	public static final ComponentType cutter_wheel_tool = create("cutter_wheel_tool");

	/** Cylindrical gear (Versions: 1.0, 1.1, 1.2) */
	public static final ComponentType cylindrical_gear = create("cylindrical_gear");

	/** Cylindrical stage (Versions: 1.0, 1.1, 1.2) */
	public static final ComponentType cylindrical_stage = create("cylindrical_stage");

	/** End relief datum face (Versions: 1.2) */
	public static final ComponentType end_relief_datum_face = create("end_relief_datum_face");

	/** End relief non-datum face (Versions: 1.2) */
	public static final ComponentType end_relief_non_datum_face = create("end_relief_non_datum_face");

	/** External load (Versions: 1.0, 1.1, 1.2) */
	public static final ComponentType external_load = create("external_load");

	/** Non-switchable coupling (Versions: 1.0) */
	public static final ComponentType fixed_coupling = create("fixed_coupling");

	/** Tooth flank (Versions: 1.0, 1.1, 1.2) */
	public static final ComponentType flank_geometry = create("flank_geometry");

	/** Gear casing (Versions: 1.0, 1.1, 1.2) */
	public static final ComponentType gear_casing = create("gear_casing");

	/** Gear unit (Versions: 1.0, 1.1, 1.2) */
	public static final ComponentType gear_unit = create("gear_unit");

	/** General gear (Versions: 1.0) */
	public static final ComponentType general_gear = create("general_gear");

	/** General stage (Versions: 1.0) */
	public static final ComponentType general_stage = create("general_stage");

	/** Helix crowning (Versions: 1.2) */
	public static final ComponentType helix_crowning = create("helix_crowning");

	/** Helix deviation (Versions: 1.2) */
	public static final ComponentType helix_deviation = create("helix_deviation");

	/** Helix slope (Versions: 1.2) */
	public static final ComponentType helix_slope = create("helix_slope");

	/** Lubricant (Versions: 1.0, 1.1, 1.2) */
	public static final ComponentType lubricant = create("lubricant");

	/** Material (Versions: 1.0, 1.1, 1.2) */
	public static final ComponentType material = create("material");

	/** Planetary carrier (Versions: 1.1, 1.2) */
	public static final ComponentType planet_carrier = create("planet_carrier");

	/** Planetary stage (Versions: 1.1, 1.2) */
	public static final ComponentType planetary_stage = create("planetary_stage");

	/** Profile crowning (Versions: 1.2) */
	public static final ComponentType profile_crowning = create("profile_crowning");

	/** Profile deviation (Versions: 1.2) */
	public static final ComponentType profile_deviation = create("profile_deviation");

	/** Profile slope modification (Versions: 1.2) */
	public static final ComponentType profile_slope = create("profile_slope");

	/** Profile twist (Versions: 1.2) */
	public static final ComponentType profile_twist = create("profile_twist");

	/** Rack-shaped tool (Versions: 1.0, 1.1, 1.2) */
	public static final ComponentType rack_shaped_tool = create("rack_shaped_tool");

	/** Reduction point (Versions: 1.1, 1.2) */
	public static final ComponentType reduction_point = create("reduction_point");

	/** Ring gear (Versions: 1.1, 1.2) */
	public static final ComponentType ring_gear = create("ring_gear");

	/** Rolling bearing row (Versions: 1.0, 1.1, 1.2) */
	public static final ComponentType rolling_bearing_row = create("rolling_bearing_row");

	/** Rolling bearing with catalog data (Versions: 1.0, 1.1, 1.2) */
	public static final ComponentType rolling_bearing_with_catalog_geometry = create("rolling_bearing_with_catalog_geometry");

	/** Rolling bearing with detailed geometry (Versions: 1.0, 1.1, 1.2) */
	public static final ComponentType rolling_bearing_with_detailed_geometry = create("rolling_bearing_with_detailed_geometry");

	/** Rolling element (Versions: 1.0, 1.1, 1.2) */
	public static final ComponentType rolling_element = create("rolling_element");

	/** Model (Versions: 1.0) */
	public static final ComponentType root = create("root");

	/** Root relief (Versions: 1.2) */
	public static final ComponentType root_relief = create("root_relief");

	/** Shaft (Versions: 1.0, 1.1, 1.2) */
	public static final ComponentType shaft = create("shaft");

	/** Shaft section (Versions: 1.0, 1.1, 1.2) */
	public static final ComponentType shaft_section = create("shaft_section");

	/** Side plate (Versions: 1.1, 1.2) */
	public static final ComponentType side_plate = create("side_plate");

	/** Slide bearing (Versions: 1.0, 1.1, 1.2) */
	public static final ComponentType slide_bearing = create("slide_bearing");

	/** Stage gear data (Versions: 1.0, 1.1, 1.2) */
	public static final ComponentType stage_gear_data = create("stage_gear_data");

	/** Switchable coupling (Versions: 1.0, 1.1, 1.2) */
	public static final ComponentType switchable_coupling = create("switchable_coupling");

	/** Tip relief (Versions: 1.2) */
	public static final ComponentType tip_relief = create("tip_relief");

	/** Topographical flank modification (Versions: 1.2) */
	public static final ComponentType topographical_modification = create("topographical_modification");

	/** Triangular root relief (Versions: 1.2) */
	public static final ComponentType triangular_root_relief = create("triangular_root_relief");

	/** Triangular tip relief (Versions: 1.2) */
	public static final ComponentType triangular_tip_relief = create("triangular_tip_relief");

	/** Worm gear (Versions: 1.2) */
	public static final ComponentType worm_gear = create("worm_gear");

	/** Worm stage (Versions: 1.2) */
	public static final ComponentType worm_stage = create("worm_stage");

	/** Worm wheel (Versions: 1.2) */
	public static final ComponentType worm_wheel = create("worm_wheel");

	/** 0° grinding disk tool (Versions: 1.0, 1.1, 1.2) */
	public static final ComponentType zero_degree_grinding_disk_tool = create("zero_degree_grinding_disk_tool");

	/** The actual ID of the component type as a {@link String}. */
	@EqualsAndHashCode.Include
	private final String id;

	private ComponentType(String id) {
		if (id == null || id.isEmpty())
			throw new IllegalArgumentException("id cannot be empty");
		this.id = id;
	}

	/**
	 * @return
	 * 				The actual ID of the component type as a {@link String}.
	 */
	public String getId() {
		return id;
	}

	/**
	 * Creates a new component type and adds it to the internal index.
	 *
	 * @param id
	 * 				The actual ID of the component type as a {@link String}.
	 *
	 * @return
	 * 				The newly created component type as {@link ComponentType}.
	 */
	public static ComponentType create(String id) {
		ComponentType componentType = new ComponentType(id);
		allComponentTypes.put(id, componentType);
		return componentType;
	}

	/**
	 * Returns the component type for a textual ID from the internally stored index of all component types.
	 *
	 * @param id
	 * 				The actual ID of the component type to be found as a {@link String}
	 *
	 * @return
	 * 				The found component type as {@link ComponentType}, or {@code null} if the ID could not be found.
	 */
	public static ComponentType findById(String id) {
		if (id == null)
			return null;
		return allComponentTypes.getOrDefault(id, null);
	}
}
