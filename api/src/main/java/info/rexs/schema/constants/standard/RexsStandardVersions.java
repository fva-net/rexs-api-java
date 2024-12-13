package info.rexs.schema.constants.standard;

import info.rexs.schema.constants.RexsVersion;

/**
 * The standard versions of the REXS (Reusable Engineering EXchange Standard) schema.
 */
public final class RexsStandardVersions {

	/**
	 * Version 1.0 of the REXS schema.
	 */
	public static final RexsVersion V1_0 = RexsVersion.create("1.0", null, "1.0", "0.90", "0.10", "1.00");

	/**
	 * Version 1.1 of the REXS schema.
	 */
	public static final RexsVersion V1_1 = RexsVersion.create("1.1", null, "1.1", "1.10", "1.1-Beta");

	/**
	 * Version 1.2 of the REXS schema.
	 */
	public static final RexsVersion V1_2 = RexsVersion.create("1.2", null, "1.2");

	/**
	 * Version 1.3 of the REXS schema.
	 */
	public static final RexsVersion V1_3 = RexsVersion.create("1.3", null, "1.3");

	/**
	 * Version 1.4 of the REXS schema.
	 */
	public static final RexsVersion V1_4 = RexsVersion.create("1.4", null, "1.4");

	/**
	 * Version 1.5 of the REXS schema.
	 */
	public static final RexsVersion V1_5 = RexsVersion.create("1.5", null, "1.5");

	/**
	 * Version 1.6 of the REXS schema.
	 */
	public static final RexsVersion V1_6 = RexsVersion.create("1.6", null, "1.6");

	/**
	 * Version 1.7 of the REXS schema.
	 */
	public static final RexsVersion V1_7 = RexsVersion.create("1.7", null, "1.7");

	/**
	 * @return
	 * 				The latest official REXS {@link RexsVersion}.
	 */
	public static RexsVersion getLatest() {
		return V1_7;
	}

	/**
	 * Initializes the standard versions.
	 */
	public static void init() {
		// necessary to initialize the standard versions
	}

	/** private constructor to prevent instantiation */
	private RexsStandardVersions() {}
}
