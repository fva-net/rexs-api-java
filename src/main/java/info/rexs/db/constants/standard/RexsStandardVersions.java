package info.rexs.db.constants.standard;

import info.rexs.db.constants.RexsVersion;

/**
 * TODO Document me!
 *
 * @author FVA GmbH
 */
public interface RexsStandardVersions {

	/** 1.0 */
	public static final RexsVersion V1_0 = RexsVersion.create("1.0", 1000, "0.90", "0.10", "1.00");

	/** 1.1 */
	public static final RexsVersion V1_1 = RexsVersion.create("1.1", 1100, "1.10", "1.1-Beta");

	/** 1.2 */
	public static final RexsVersion V1_2 = RexsVersion.create("1.2", 1200);

	/** 1.3 */
	public static final RexsVersion V1_3 = RexsVersion.create("1.3", 1300);

	public static void init() {}
}
