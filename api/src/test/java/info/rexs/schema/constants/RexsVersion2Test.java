package info.rexs.schema.constants;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class RexsVersion2Test {

	@Test
	public void create_whenValidInput_thenCreatesVersion() {
		RexsVersion2 version = RexsVersion2.create("1.0", "provider", "1.0");
		assertNotNull(version);
		assertEquals("1.0", version.getSchemaVersion());
		assertEquals("provider", version.getSchemaProvider());
		assertEquals("1.0", version.getModelVersion());
	}

	@Test
	public void create_whenEmptyProvider_thenProviderIsNull() {
		RexsVersion2 version = RexsVersion2.create("1.0", "", "1.0");
		assertNotNull(version);
		assertNull(version.getSchemaProvider());
	}

	@Test(expected = IllegalArgumentException.class)
	public void create_whenSchemaVersionIsEmpty_thenThrowsException() {
		RexsVersion2.create("", "provider", "1.0");
	}


	@Test(expected = IllegalArgumentException.class)
	public void create_whenSchemaVersionIsNull_thenThrowsException() {
		RexsVersion2.create(null, "provider", "1.0");
	}

	@Test(expected = IllegalArgumentException.class)
	public void create_whenPrimaryModelVersionIsEmpty_thenThrowsException() {
		RexsVersion2.create("1.0", "provider", "");
	}

	@Test(expected = IllegalArgumentException.class)
	public void create_whenPrimaryModelVersionIsNull_thenThrowsException() {
		RexsVersion2.create("1.0", "provider", null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void create_whenAdditionalModelVersionIsEmpty_thenThrowsException() {
		RexsVersion2.create("1.0", "provider", "1.0", "1.0.0", "");
	}

	@Test(expected = IllegalArgumentException.class)
	public void create_whenAdditionalModelVersionIsNull_thenThrowsException() {
		RexsVersion2.create("1.0", "provider", "1.0", "1.0.0", null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void create_whenSchemaVersionPatternIsInvalid_thenThrowsException() {
		RexsVersion2.create("1", "provider", "1.0");
	}

	@Test
	public void findByModelVersion_whenModelVersionExists_thenReturnsVersion() {
		// provider-specific version
		RexsVersion2 v10pro = RexsVersion2.create("1.0", "provider", "1.0 PROVIDER");
		RexsVersion2 version = RexsVersion2.findByModelVersion("1.0 PROVIDER");
		assertNotNull(version);
		assertEquals(v10pro, version);

		// DEV
		RexsVersion2 dev1 = RexsVersion2.findByModelVersion("dev");
		RexsVersion2 dev2 = RexsVersion2.findByModelVersion("DEV");
		assertEquals(RexsVersion2.DEV, dev1);
		assertEquals(RexsVersion2.DEV, dev2);
	}

	@Test
	public void findByModelVersion_whenModelVersionDoesNotExist_thenReturnsUnknown() {
		RexsVersion2 version = RexsVersion2.findByModelVersion("nonexistent");
		assertNotNull(version);
		assertEquals(RexsVersion2.UNKNOWN, version);
	}

	@Test
	public void findByModelVersion_whenModelVersionIsNull_thenReturnsUnknown() {
		RexsVersion2 version = RexsVersion2.findByModelVersion(null);
		assertEquals(RexsVersion2.UNKNOWN, version);
	}

	@Test
	public void equals_whenSameSchemaAndProvider_thenReturnsTrue() {
		// without provider
		RexsVersion2 version1 = RexsVersion2.create("1.0", null, "1.0");
		RexsVersion2 version2 = RexsVersion2.create("1.0", null, "1.0 whatever");
		assertEquals(version1, version2);

		// with provider
		RexsVersion2 version1pro = RexsVersion2.create("1.0", "provider", "1.0 PROVIDER");
		RexsVersion2 version2pro = RexsVersion2.create("1.0", "provider", "1.0 PROVIDER whatever");
		assertEquals(version1pro, version2pro);
	}

	@Test
	public void equals_whenDifferentSchemaOrProvider_thenReturnsFalse() {
		RexsVersion2 version1 = RexsVersion2.create("1.0", null, "1.0");
		RexsVersion2 version2 = RexsVersion2.create("1.1", null, "1.1");
		RexsVersion2 version1pro = RexsVersion2.create("1.0", "provider", "1.0");
		RexsVersion2 version2pro = RexsVersion2.create("1.1", "provider", "1.1");
		assertNotEquals(version1, version2);
		assertNotEquals(version1pro, version2pro);
		assertNotEquals(version1, version1pro);
		assertNotEquals(version2, version2pro);
	}

	@Test
	public void equals_whenDifferentObject_thenNotEqual() {
		RexsVersion2 version = RexsVersion2.create("1.0", null, "1.0");
		assertNotEquals(version, new Object());
	}

	@Test
	public void hashCode_whenSameSchemaAndProvider_thenReturnsSameHashCode() {
		// without provider
		RexsVersion2 version1 = RexsVersion2.create("1.0", null, "1.0");
		RexsVersion2 version2 = RexsVersion2.create("1.0", null, "1.1");
		assertEquals(version1.hashCode(), version2.hashCode());

		// with provider
		RexsVersion2 version1pro = RexsVersion2.create("1.0", "provider", "1.0");
		RexsVersion2 version2pro = RexsVersion2.create("1.0", "provider", "1.1");
		assertEquals(version1pro.hashCode(), version2pro.hashCode());
	}

	@Test
	public void hashCode_whenDifferentSchemaOrProvider_thenReturnsDifferentHashCode() {
		RexsVersion2 version1 = RexsVersion2.create("1.0", "provider1", "1.0");
		RexsVersion2 version2 = RexsVersion2.create("1.0", "provider2", "1.0");
		assertNotEquals(version1.hashCode(), version2.hashCode());
	}
}
