package info.rexs.schema.constants;

import info.rexs.schema.constants.standard.RexsStandardVersions2;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Class representing a version in the REXS (Reusable Engineering EXchange Standard) schema.
 *
 * @apiNote {@link #equals} and {@link #hashCode} are implemented based on the schema version and schema provider only. Two versions are considered equal if their schema version and schema provider are equal, even if their model version is different.
 */
public class RexsVersion2 {

	/**
	 * A constant representing the development version.
	 */
	public static final RexsVersion2 DEV = new RexsVersion2("DEV", null, "DEV");
	/**
	 * A constant representing an unknown version.
	 */
	public static final RexsVersion2 UNKNOWN = new RexsVersion2("UNKNOWN", null, "UNKNOWN");
	/**
	 * A map to store all versions by their model identifier.
	 */
	private static final Map<String, RexsVersion2> allModelVersions = new HashMap<>();

	static {
		// initialize the standard versions
		RexsStandardVersions2.init();
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
	private RexsVersion2(String schemaVersion, String schemaProvider, String modelVersion) {
		this.schemaVersion = schemaVersion;
		this.schemaProvider = schemaProvider;
		this.modelVersion = modelVersion;
	}

	public static RexsVersion2 create(String schemaVersion, String schemaProvider, String primaryModelVersion, String... additionalModelVersions) {

		// input data validation
		if (schemaVersion == null || schemaVersion.isEmpty())
			throw new IllegalArgumentException("The schema version cannot be empty");
		if (schemaProvider != null && schemaProvider.isEmpty())
			schemaProvider = null;
		if (primaryModelVersion == null || primaryModelVersion.isEmpty())
			throw new IllegalArgumentException("The primary model version cannot be empty");
		// check that no entry of additionalModelVersions is empty
		for (String additionalModelVersion : additionalModelVersions) {
			if (additionalModelVersion == null || additionalModelVersion.isEmpty())
				throw new IllegalArgumentException("Additional model versions cannot contain empty entries");
		}

		// assure that the schema version follows X.X pattern
		if (!schemaVersion.matches("\\d+\\.\\d+"))
			throw new IllegalArgumentException("schemaVersion must follow the pattern X.X");

		// create the primary version
		RexsVersion2 primaryVersion = new RexsVersion2(schemaVersion, schemaProvider, primaryModelVersion);
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
	public static RexsVersion2 findByModelVersion(String modelVersion) {
		// null-check
		if (modelVersion == null) {
			return UNKNOWN;
		}

		// check for DEV
		if (modelVersion.equalsIgnoreCase(DEV.getModelVersion())) {
			return DEV;
		}

		// check for registered versions
		for (RexsVersion2 version : allModelVersions.values()) {
			if (modelVersion.equalsIgnoreCase(version.getModelVersion())) {
				return version;
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

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (o instanceof RexsVersion2 other) {
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
