package info.rexs.db.constants;

/**
 * Interface representing a REXS (Reusable Engineering EXchange Standard) version.
 */
public interface RexsVersion2 {

	/**
	 * The latest development version.
	 */
	RexsVersion2 DEV = new RexsVersion2() {
		@Override
		public String getSchemaVersion() {
			return "DEV";
		}

		@Override
		public String getSchemaProvider() {
			return "";
		}

		@Override
		public String getModelVersion() {
			return getSchemaVersion();
		}

		@Override
		public int getNumericVersion() {
			return Integer.MAX_VALUE;
		}
	};

	/**
	 * Returns the version given in the REXS schema.
	 *
	 * @return the version given in the REXS schema
	 */
	String getSchemaVersion();

	/**
	 * Returns the provider given in the REXS schema.
	 *
	 * @return the provider given in the REXS schema
	 */
	String getSchemaProvider();

	/**
	 * Gets the model version of the REXS version.
	 *
	 * @return the model version of the REXS version
	 */
	String getModelVersion();

	/**
	 * Gets the numeric representation of the REXS version.
	 * <p>
	 * The numeric version is derived from the {@link #getSchemaVersion() schemaVersion} as follows:
	 * <ul>
	 *   <li>Major version is multiplied by 10000</li>
	 *   <li>Minor version is multiplied by 100</li>
	 *   <li>Patch version (optional) is multiplied by 1</li>
	 * </ul>
	 * The latest development version is always {#link Integer.MAX_VALUE}.
	 * <p>
	 * Example: "1.6" results in 10600.
	 * </p>
	 *
	 * @return the numeric representation of the REXS version
	 * @apiNote The {@link #getSchemaProvider() schemaProvider} is not considered in the numeric version.
	 */
	int getNumericVersion();

	/**
	 * Checks if this version is equivalent to the specified version.
	 *
	 * @param version the version to compare with
	 * @return true if the versions are equivalent, false otherwise
	 */
	default boolean isEquivalentTo(RexsVersion2 version) {
		return getNumericVersion() == version.getNumericVersion();
	}

	/**
	 * Checks if this version is less than the specified version.
	 *
	 * @param version the version to compare with
	 * @return true if this version is less than the specified version, false otherwise
	 */
	default boolean isLessThan(RexsVersion2 version) {
		return getNumericVersion() < version.getNumericVersion();
	}

	/**
	 * Checks if this version is greater than the specified version.
	 *
	 * @param version the version to compare with
	 * @return true if this version is greater than the specified version, false otherwise
	 */
	default boolean isGreaterThan(RexsVersion2 version) {
		return getNumericVersion() > version.getNumericVersion();
	}

	/**
	 * Checks if this version is less than or equivalent to the specified version.
	 *
	 * @param version the version to compare with
	 * @return true if this version is less than or equivalent to the specified version, false otherwise
	 */
	default boolean isLessThanOrEquivalentTo(RexsVersion2 version) {
		return getNumericVersion() <= version.getNumericVersion();
	}

	/**
	 * Checks if this version is greater than or equivalent to the specified version.
	 *
	 * @param version the version to compare with
	 * @return true if this version is greater than or equivalent to the specified version, false otherwise
	 */
	default boolean isGreaterThanOrEquivalentTo(RexsVersion2 version) {
		return getNumericVersion() >= version.getNumericVersion();
	}
}