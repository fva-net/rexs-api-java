package info.rexs.db.constants.standard;

import info.rexs.db.constants.RexsVersion2;

/**
 * Enum representing the standard versions of REXS (Reusable Engineering EXchange Standard).
 * Each version has a schema version identifier and a numeric representation.
 */
public enum RexsStandardVersions2 implements RexsVersion2 {

	/** REXS Version 1.0 */
	V1_0("1.0", 10000),

	/** REXS Version 1.1 */
	V1_1("1.1", 10100),

	/** REXS Version 1.2 */
	V1_2("1.2", 10200),

	/** REXS Version 1.3 */
	V1_3("1.3", 10300),

	/** REXS Version 1.4 */
	V1_4("1.4", 10400),

	/** REXS Version 1.5 */
	V1_5("1.5", 10500),

	/** REXS Version 1.6 */
	V1_6("1.6", 10600);

	private final String schemaVersion;
	private final int numericVersion;

	/**
	 * Constructor for REXS standard versions.
	 *
	 * @param schemaVersion  the schema version identifier
	 * @param numericVersion the numeric representation of the version
	 */
	RexsStandardVersions2(String schemaVersion, int numericVersion) {
		this.schemaVersion = schemaVersion;
		this.numericVersion = numericVersion;
	}


	@Override
	public String getSchemaVersion() {
		return schemaVersion;
	}

	@Override
	public String getSchemaProvider() {
		return "";
	}

	@Override
	public String getModelVersion() {
		return schemaVersion;
	}

	@Override
	public int getNumericVersion() {
		return numericVersion;
	}
}