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

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.EqualsAndHashCode;

/**
 * This class represents a REXS version.
 * <p>
 * It contains constants for all official REXS versions.
 * <p>
 * Since REXS is freely expandable, you can also add your own versions using the {@link #create(String, String...)} method.
 *
 * @author FVA GmbH
 */
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Version {

	/** An internal index with all created versions (REXS standard and own) for quick access. */
	private static Set<Version> allVerions = new HashSet<>();

	/** 1.0 */
	public static final Version V1_0 = create("1.0", "0.90", "0.10", "1.00");

	/** 1.1 */
	public static final Version V1_1 = create("1.1", "1.10", "1.1-Beta");

	/** 1.2 */
	public static final Version V1_2 = create("1.2");

	/** The version name. */
	@EqualsAndHashCode.Include
	private final String name;

	/** Alternative version names that can also be assigned to an official version (e.g. a beta version name). */
	private final Set<String> alternativeNames;

	private Version(String name, Set<String> alternativeNames) {
		if (name == null || name.isEmpty())
			throw new IllegalArgumentException("name cannot be empty");
		this.name = name;
		this.alternativeNames = alternativeNames;
	}

	/**
	 * @return
	 * 				The latest official REXS {@link Version}.
	 */
	public static Version getLatest() {
		return V1_2;
	}

	/**
	 * @return
	 * 				The version name as a {@link String}.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Creates a new version and adds it to the internal index.
	 *
	 * @param name
	 * 				The version name as a {@link String}.
	 * @param alternativeNames
	 * 				Optional alternative version names that can also be assigned to the version (e.g. a beta version name).
	 *
	 * @return
	 * 				The newly created version as {@link Version}.
	 */
	public static Version create(String name, String... alternativeNames) {
		Set<String> alternativeNamesSet = null;
		if (alternativeNames != null && alternativeNames.length > 0)
			alternativeNamesSet = Arrays.stream(alternativeNames).collect(Collectors.toSet());

		Version version = new Version(name, alternativeNamesSet);
		allVerions.add(version);
		return version;
	}

	/**
	 * Returns the version for a version name from the internally stored index of all versions.
	 * <p>
	 * Alternate version names are taken into account in the search.
	 *
	 * @param name
	 * 				The name of the version to be found as a {@link String}.
	 *
	 * @return
	 * 				The found {@link Version}, or {@code null} if the version could not be found.
	 */
	public static Version findByName(String name) {
		if (name == null)
			return null;

		for (Version version : allVerions) {
			if (name.equals(version.getName())
					|| (version.alternativeNames != null && version.alternativeNames.contains(name)))
				return version;
		}

		return null;
	}
}
