package info.rexs.schema.constants.standard;

import info.rexs.schema.constants.RexsVersion2;

/**
 * Interface representing the standard versions of the REXS (Reusable Engineering EXchange Standard) schema.
 */
public interface RexsStandardVersions2 {
	/**
	 * Version 1.0 of the REXS schema.
	 */
	RexsVersion2 V1_0 = RexsVersion2.create("1.0", null, "1.0", "0.90", "0.10", "1.00");

	/**
	 * Version 1.1 of the REXS schema.
	 */
	RexsVersion2 V1_1 = RexsVersion2.create("1.1", null, "1.1", "1.10", "1.1-Beta");

	/**
	 * Version 1.2 of the REXS schema.
	 */
	RexsVersion2 V1_2 = RexsVersion2.create("1.2", null, "1.2");

	/**
	 * Version 1.3 of the REXS schema.
	 */
	RexsVersion2 V1_3 = RexsVersion2.create("1.3", null, "1.3");

	/**
	 * Version 1.4 of the REXS schema.
	 */
	RexsVersion2 V1_4 = RexsVersion2.create("1.4", null, "1.4");

	/**
	 * Version 1.5 of the REXS schema.
	 */
	RexsVersion2 V1_5 = RexsVersion2.create("1.5", null, "1.5");

	/**
	 * Version 1.6 of the REXS schema.
	 */
	RexsVersion2 V1_6 = RexsVersion2.create("1.6", null, "1.6");

	/**
	 * Initializes the standard versions.
	 */
	static void init() {}
}
