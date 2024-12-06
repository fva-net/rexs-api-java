package info.rexs.schema.constants;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import info.rexs.schema.constants.standard.RexsStandardVersions;

/**
 * Class representing a version in the REXS (Reusable Engineering EXchange Standard) schema.
 *
 * @apiNote {@link #equals} and {@link #hashCode} are implemented based on the schema version and schema provider only. Two versions are considered equal if their schema version and schema provider are equal, even if their model version is different.
 */
public class RexsVersion {

	private static final String DEV_VERSION_NAME = "DEV";

	/**
	 * A constant representing the development version.
	 */
	public static final RexsVersion DEV = new RexsVersion(DEV_VERSION_NAME, null, DEV_VERSION_NAME);

	/**
	 * A constant representing an unknown version.
	 */
	public static final RexsVersion UNKNOWN = new RexsVersion("UNKNOWN", null, "UNKNOWN");

	/**
	 * A map to store all versions by their model identifier.
	 */
	private static final Map<String, RexsVersion> allModelVersions = new HashMap<>();

	static {
		// initialize the standard versions
		RexsStandardVersions.init();
	}

	/**
	 * The (case-insensitive) identifier of the version in the REXS schema.
	 */
	private final String schemaVersion;

	/**
	 * The (case-insensitive) identifier of the provider in the REXS schema.
	 */
	private final String schemaProvider;

	/**
	 * The (case-insensitive) identifier of the version in the REXS model.
	 */
	private final String modelVersion;

	/**
	 * Creates a new REXS version.
	 *
	 * @param schemaVersion  The (case-insensitive) identifier of the version in the REXS schema.
	 * @param schemaProvider The (case-insensitive) identifier of the provider in the REXS schema.
	 * @param modelVersion   The (case-insensitive) identifier of the version in the REXS model.
	 */
	private RexsVersion(String schemaVersion, String schemaProvider, String modelVersion) {
		this.schemaVersion = schemaVersion;
		this.schemaProvider = schemaProvider;
		this.modelVersion = modelVersion;
	}

	/**
	 * Creates a new REXS version and registers it along with any additional model versions.
	 *
	 * @param schemaVersion           The (case-insensitive) identifier of the version in the REXS schema.
	 * @param schemaProvider          The (case-insensitive) identifier of the provider in the REXS schema.
	 * @param primaryModelVersion     The (case-insensitive) identifier of the primary version in the REXS model.
	 * @param additionalModelVersions Additional (case-insensitive) identifiers of the versions in the REXS model.
	 * @return The primary REXS version created.
	 * @throws IllegalArgumentException if any of the input parameters are invalid.
	 */
	public static RexsVersion create(String schemaVersion, String schemaProvider, String primaryModelVersion, String... additionalModelVersions) {
		// input data validation
		if (schemaVersion == null || schemaVersion.isEmpty()) throw new IllegalArgumentException("The schema version cannot be empty");
		if (schemaProvider != null && schemaProvider.isEmpty()) schemaProvider = null;
		if (primaryModelVersion == null || primaryModelVersion.isEmpty()) throw new IllegalArgumentException("The primary model version cannot be empty");

		// check that no entry of additionalModelVersions is empty
		for (String additionalModelVersion : additionalModelVersions) {
			if (additionalModelVersion == null || additionalModelVersion.isEmpty())
				throw new IllegalArgumentException("Additional model versions cannot contain empty entries");
		}

		// assure that the schema version follows X.X pattern
		if (!schemaVersion.matches("\\d+\\.\\d+") && !schemaVersion.equalsIgnoreCase(DEV_VERSION_NAME))
			throw new IllegalArgumentException("schemaVersion must follow the pattern X.X");

		// create the primary version
		RexsVersion primaryVersion = new RexsVersion(schemaVersion, schemaProvider, primaryModelVersion);
		allModelVersions.put(primaryVersion.getModelVersion(), primaryVersion);

		// register additional versions
		for (String additionalModelVersion : additionalModelVersions) {
			allModelVersions.put(additionalModelVersion, primaryVersion);
		}

		// return the primary version
		return primaryVersion;
	}

	/**
	 * Finds a version by its model version.
	 *
	 * @param modelVersion The model version.
	 * @return The corresponding RexsVersion2 object, or null if not found.
	 */
	public static RexsVersion findByModelVersion(String modelVersion) {
		// null-check
		if (modelVersion == null) {
			return UNKNOWN;
		}

		// check for DEV
		if (modelVersion.equalsIgnoreCase(DEV.getModelVersion())) {
			return DEV;
		}

		// Check for registered versions and return the corresponding version or UNKNOWN if not found
		return allModelVersions.entrySet().stream()
			.filter(entry -> modelVersion.equalsIgnoreCase(entry.getKey()))
			.map(Map.Entry::getValue)
			.findFirst()
			.orElse(UNKNOWN);
	}

	/**
	 * Finds a version by its schema version and schema provider.
	 *
	 * @param schemaVersion  The schema version.
	 * @param schemaProvider The schema provider.
	 * @return The corresponding RexsVersion2 object, or null if not found.
	 */
	public static RexsVersion findBySchema(String schemaVersion, String schemaProvider) {
		// null-check
		if (schemaVersion == null) {
			return UNKNOWN;
		}

		// replace empty schema provider with null
		if (schemaProvider != null && schemaProvider.isEmpty()) {
			schemaProvider = null;
		}

		// check for registered versions (both with and without schema provider)
		for (RexsVersion version : allModelVersions.values()) {
			if (schemaProvider == null) {
				if (schemaVersion.equalsIgnoreCase(version.getSchemaVersion()) && version.schemaProvider == null) {
					return version;
				}
			} else {
				if (schemaVersion.equalsIgnoreCase(version.getSchemaVersion()) && schemaProvider.equalsIgnoreCase(version.getSchemaProvider())) {
					return version;
				}
			}
		}

		// return unknown if nothing matches
		return UNKNOWN;
	}

	/**
	 * Gets the schema version.
	 *
	 * @return The schema version.
	 */
	public String getSchemaVersion() {
		return schemaVersion;
	}

	/**
	 * Gets the schema provider.
	 *
	 * @return The schema provider.
	 */
	public String getSchemaProvider() {
		return schemaProvider;
	}

	/**
	 * Gets the model version.
	 *
	 * @return The model version.
	 */
	public String getModelVersion() {
		return modelVersion;
	}

	/**
	 * Gets the numeric representation of the REXS version.
	 * <p>
	 * The numeric version is derived from the {@link #getSchemaVersion() schemaVersion} as follows:
	 * <ul>
	 *   <li>Major version is multiplied by {@code 10000}</li>
	 *   <li>Minor version is multiplied by {@code 100}</li>
	 *   <li>Patch version (optional) is multiplied by {@code 1}</li>
	 * </ul>
	 * <p>
	 * Example: {@code "1.6"} results in {@code 10600}.
	 * </p>
	 * {@link #DEV} and {@link #UNKNOWN} are handled as special cases. The latest development version is always {@link java.lang.Integer#MAX_VALUE Integer.MAX_VALUE}, the unknown version is returning as {@code -1}.
	 *
	 * @return the numeric representation of the REXS version
	 * @apiNote The {@link #getSchemaProvider() schemaProvider} and {@link #getModelVersion() modelVersion} are not considered in the numeric version.
	 */
	public int getNumericVersion() {
		// return -1 for UNKNOWN
		if (this == UNKNOWN) {
			return -1;
		}

		// return max value for DEV
		if (this.getSchemaVersion().equalsIgnoreCase(DEV_VERSION_NAME)) {
			return Integer.MAX_VALUE;
		}

		// extract major and minor from the schema version
		String[] parts = schemaVersion.split("\\.");
		int major = Integer.parseInt(parts[0]);
		int minor = Integer.parseInt(parts[1]);

		// return the numeric version
		return 10000 * major + 100 * minor;
	}

	/**
	 * Compares this version with another version.
	 *
	 * @param other The other version to compare with.
	 * @return A negative integer, zero, or a positive integer as this version is less than, equal to, or greater than the specified version.
	 */
	public int compareTo(RexsVersion other) {
		return Integer.compare(this.getNumericVersion(), other.getNumericVersion());
	}

	/**
	 * Checks if this version is less than the specified version.
	 *
	 * @param other The other version to compare with.
	 * @return true if this version is less than the specified version, false otherwise.
	 */
	public boolean isLessThan(RexsVersion other) {
		return this.compareTo(other) < 0;
	}

	/**
	 * Checks if this version is less than or equivalent to the specified version.
	 *
	 * @param other The other version to compare with.
	 * @return true if this version is less than or equivalent to the specified version, false otherwise.
	 */
	public boolean isLessThanOrEquivalentTo(RexsVersion other) {
		return this.compareTo(other) <= 0;
	}

	/**
	 * Checks if this version is greater than the specified version.
	 *
	 * @param other The other version to compare with.
	 * @return true if this version is greater than the specified version, false otherwise.
	 */
	public boolean isGreaterThan(RexsVersion other) {
		return this.compareTo(other) > 0;
	}

	/**
	 * Checks if this version is greater than or equivalent to the specified version.
	 *
	 * @param other The other version to compare with.
	 * @return true if this version is greater than or equivalent to the specified version, false otherwise.
	 */
	public boolean isGreaterThanOrEquivalentTo(RexsVersion other) {
		return this.compareTo(other) >= 0;
	}

	/**
	 * Checks if this version is equivalent to the specified version.
	 *
	 * @param other The other version to compare with.
	 * @return true if this version is equivalent to the specified version, false otherwise.
	 */
	public boolean isEquivalentTo(RexsVersion other) {
		return this.compareTo(other) == 0;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (o instanceof RexsVersion other) {
			if (this.schemaProvider != null) {
				return this.schemaVersion.equals(other.schemaVersion) && this.schemaProvider.equals(other.schemaProvider);
			} else {
				return this.schemaVersion.equals(other.schemaVersion) && other.schemaProvider == null;
			}

		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(schemaVersion, schemaProvider);
	}
}
