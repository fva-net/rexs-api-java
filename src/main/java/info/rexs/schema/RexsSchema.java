package info.rexs.schema;

import java.io.InputStream;

/**
 * This enum represents a REXS XSD schema.
 *
 * @author FVA GmbH
 */
public enum RexsSchema {

	/**
	 * The XSD schema file for the REXS changelog files.
	 */
	CHANGELOG("rexs-changelog.xsd"),

	/**
	 * The XSD schema file for the REXS database model files.
	 */
	DB_MODEL("rexs-dbmodel.xsd"),

	/**
	 * The XSD schema file for REXS files.
	 */
	FILE("rexs-file.xsd"),

	/**
	 * The XSD schema file for REXS files.
	 * This schema contains a namespace specification.
	 */
	FILE_WITH_NAMESPACE("rexs-file-ns.xsd");

	private String filename;

	private RexsSchema(String filename) {
		this.filename = filename;
	}

	/**
	 * Opens an input stream for the REXS XSD schema file and returns it.
	 *
	 * @return
	 * 				The {@link InputStream} for the REXS XSD schema file.
	 */
	public InputStream openInputStream() {
		return this.getClass().getResourceAsStream(filename);
	}
}
