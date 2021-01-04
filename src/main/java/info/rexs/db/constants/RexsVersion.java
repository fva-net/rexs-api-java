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

import info.rexs.db.constants.standard.RexsStandardVersions;
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
public class RexsVersion implements RexsStandardVersions {

	/** An internal index with all created versions (REXS standard and own) for quick access. */
	private static Set<RexsVersion> allVerions = new HashSet<>();

	/** The version name. */
	@EqualsAndHashCode.Include
	private final String name;

	/** Alternative version names that can also be assigned to an official version (e.g. a beta version name). */
	private final Set<String> alternativeNames;

	private RexsVersion(String name, Set<String> alternativeNames) {
		if (name == null || name.isEmpty())
			throw new IllegalArgumentException("name cannot be empty");
		this.name = name;
		this.alternativeNames = alternativeNames;
	}

	/**
	 * @return
	 * 				The latest official REXS {@link RexsVersion}.
	 */
	public static RexsVersion getLatest() {
		return V1_3;
	}

	/**
	 * @return
	 * 				The version name as a {@link String}.
	 */
	public String getName() {
		return name;
	}

	/**
	 * TODO Document me!
	 *
	 * @param checkVersions
	 * 				TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public boolean isOneOf(RexsVersion ... checkVersions)
	{
		if (checkVersions == null)
			return false;

		for (RexsVersion checkVersion : checkVersions)
		{
			if (this.equals(checkVersion))
				return true;
		}

		return false;
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
	 * 				The newly created version as {@link RexsVersion}.
	 */
	public static RexsVersion create(String name, String... alternativeNames) {
		Set<String> alternativeNamesSet = null;
		if (alternativeNames != null && alternativeNames.length > 0)
			alternativeNamesSet = Arrays.stream(alternativeNames).collect(Collectors.toSet());

		RexsVersion version = new RexsVersion(name, alternativeNamesSet);
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
	 * 				The found {@link RexsVersion}, or {@code null} if the version could not be found.
	 */
	public static RexsVersion findByName(String name) {
		if (name == null)
			return null;
		RexsStandardVersions.init();

		for (RexsVersion version : allVerions) {
			if (name.equals(version.getName())
					|| (version.alternativeNames != null && version.alternativeNames.contains(name)))
				return version;
		}

		return null;
	}
}
