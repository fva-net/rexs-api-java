package info.rexs.schema;

import info.rexs.schema.constants.RexsVersion;
import info.rexs.schema.constants.standard.RexsStandardVersions;
import junit.framework.TestCase;

public class RexsSchemaRegistryTest extends TestCase {

	public void testGetVersion() {
		// find version by primary model version
		assertEquals(RexsStandardVersions.V1_0, RexsSchemaRegistry.getInstance().getVersion("1.0"));

		// find version by additional model version
		assertEquals(RexsStandardVersions.V1_0, RexsSchemaRegistry.getInstance().getVersion("0.90"));
		
		// invalid version returns UNKNOWN
		assertEquals(RexsVersion.UNKNOWN, RexsSchemaRegistry.getInstance().getVersion("9.9"));
	}
}
