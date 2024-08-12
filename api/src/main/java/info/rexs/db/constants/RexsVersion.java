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
import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import info.rexs.db.constants.standard.RexsStandardVersions;

/**
 * This class represents a REXS version.
 * <p>
 * It contains constants for all official REXS versions.
 * <p>
 * Since REXS is freely expandable, you can also add your own versions using the {@link #create(String, int, String...)} method.
 *
 * @author FVA GmbH
 */
public class RexsVersion implements RexsStandardVersions, Comparable<RexsVersion> {


	/** An internal index with all created versions (REXS standard and own) for quick access. */
	private static final Set<RexsVersion> allVerions = new HashSet<>();

	/** The version name. */
	private final String name;

	/** The version order. */
	private final int order;

	/** Alternative version names that can also be assigned to an official version (e.g. a beta version name). */
	private final Set<String> alternativeNames;

	private RexsVersion(String name, int order, Set<String> alternativeNames) {
		if (name == null || name.isEmpty())
			throw new IllegalArgumentException("name cannot be empty");
		this.name = name;
		this.order = order;
		this.alternativeNames = alternativeNames;
	}

	/**
	 * @return
	 * 				The latest official REXS {@link RexsVersion}.
	 */
	public static RexsVersion getLatest() {
		return V1_6;
	}

	/**
	 * @return
	 * 				The version name as a {@link String}.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return
	 * 				The version order as a {@code int}.
	 */
	public int getOrder() {
		return order;
	}

	/**
	 * Checks if this version is one of the specified versions.
	 *
	 * @param checkVersions An array of {@link RexsVersion} to check against.
	 * @return {@code true} if this version is one of the specified versions; {@code false} otherwise.
	 */
	public boolean isOneOf(RexsVersion ... checkVersions) {
		if (checkVersions == null)
			return false;

		for (RexsVersion checkVersion : checkVersions) {
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
	 * @param order
	 * 				The version order as a {@code int}.
	 * @param alternativeNames
	 * 				Optional alternative version names that can also be assigned to the version (e.g. a beta version name).
	 *
	 * @return
	 * 				The newly created version as {@link RexsVersion}.
	 */
	public static RexsVersion create(String name, int order, String... alternativeNames) {
		Set<String> alternativeNamesSet = null;
		if (alternativeNames != null && alternativeNames.length > 0)
			alternativeNamesSet = Arrays.stream(alternativeNames).collect(Collectors.toSet());

		RexsVersion version = new RexsVersion(name, order, alternativeNamesSet);
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
			return UNKNOWN;
		RexsStandardVersions.init();

		for (RexsVersion version : allVerions) {
			if (name.equals(version.getName())
					|| (version.alternativeNames != null && version.alternativeNames.contains(name)))
				return version;
		}

		return UNKNOWN;
	}

	public boolean isLess(RexsVersion version) {
		return this.compareTo(version) < 0;
	}

	public boolean isLessOrEqual(RexsVersion version) {
		return this.compareTo(version) <= 0;
	}

	public boolean isEqual(RexsVersion version) {
		return this.compareTo(version) == 0;
	}

	public boolean isGreater(RexsVersion version) {
		return this.compareTo(version) > 0;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof RexsVersion other)) {
			return false;
		}
		if (!other.canEqual(this)) {
			return false;
		}
		return Objects.equals(getName(), other.getName());
	}

	protected boolean canEqual(Object other) {
		return other instanceof RexsVersion;
	}

	@Override
	public int hashCode() {
		int result = 1;
		result = result * 59 + (name == null ? 43 : name.hashCode());
		return result;
	}

	@Override
	public int compareTo(RexsVersion other) {
		return Comparator.comparing(RexsVersion::getOrder).compare(this, other);
	}
}
