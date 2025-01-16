package info.rexs.model.jaxb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import info.rexs.schema.constants.standard.RexsStandardVersions;

public class RexsVersionAdapterTest {

	public static final RexsVersionAdapter REXS_VERSION_ADAPTER = new RexsVersionAdapter();

	@Test
	public void marshal() {
		// valid RexsStandardVersions
		assertEquals("1.6", REXS_VERSION_ADAPTER.marshal(RexsStandardVersions.V1_6));

		// invalid RexsStandardVersions
		assertNull(REXS_VERSION_ADAPTER.marshal(null));
	}

	@Test
	public void unmarshal() {
		// valid version strings
		assertEquals(RexsStandardVersions.V1_6, REXS_VERSION_ADAPTER.unmarshal("1.6"));
	}
}
