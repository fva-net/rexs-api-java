package info.rexs.schema.constants;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import info.rexs.schema.constants.standard.RexsStandardVersions;

public class RexsVersionTest {

	@Test
	public void create_whenValidInput_thenCreatesVersion() {
		// provider-specific version
		RexsVersion version = RexsVersion.create("1.0", "provider", "1.0");
		assertNotNull(version);
		assertEquals("1.0", version.getSchemaVersion());
		assertEquals("provider", version.getSchemaProvider());
		assertEquals("1.0", version.getModelVersion());
		assertEquals(10000, version.getNumericVersion());

		// provider-specific DEV version
		version = RexsVersion.create("DEV", "ACME", "DEVACME");
		assertNotNull(version);
		assertEquals("DEV", version.getSchemaVersion());
		assertEquals("ACME", version.getSchemaProvider());
		assertEquals("DEVACME", version.getModelVersion());
		assertEquals(Integer.MAX_VALUE, version.getNumericVersion());
	}

	@Test
	public void create_whenEmptyProvider_thenProviderIsNull() {
		RexsVersion version = RexsVersion.create("1.0", "", "1.0");
		assertNotNull(version);
		assertNull(version.getSchemaProvider());
	}

	@Test(expected = IllegalArgumentException.class)
	public void create_whenSchemaVersionIsEmpty_thenThrowsException() {
		RexsVersion.create("", "provider", "1.0");
	}


	@Test(expected = IllegalArgumentException.class)
	public void create_whenSchemaVersionIsNull_thenThrowsException() {
		RexsVersion.create(null, "provider", "1.0");
	}

	@Test(expected = IllegalArgumentException.class)
	public void create_whenPrimaryModelVersionIsEmpty_thenThrowsException() {
		RexsVersion.create("1.0", "provider", "");
	}

	@Test(expected = IllegalArgumentException.class)
	public void create_whenPrimaryModelVersionIsNull_thenThrowsException() {
		RexsVersion.create("1.0", "provider", null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void create_whenAdditionalModelVersionIsEmpty_thenThrowsException() {
		RexsVersion.create("1.0", "provider", "1.0", "1.0.0", "");
	}

	@Test(expected = IllegalArgumentException.class)
	public void create_whenAdditionalModelVersionIsNull_thenThrowsException() {
		RexsVersion.create("1.0", "provider", "1.0", "1.0.0", null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void create_whenSchemaVersionPatternIsInvalid_thenThrowsException() {
		RexsVersion.create("1", "provider", "1.0");
	}

	@Test
	public void findByModelVersion_whenModelVersionExists_thenReturnsVersion() {
		// provider-specific version
		RexsVersion v10pro = RexsVersion.create("1.0", "provider", "1.0 PROVIDER");
		RexsVersion version = RexsVersion.findByModelVersion("1.0 PROVIDER");
		assertNotNull(version);
		assertEquals(v10pro, version);

		// DEV
		RexsVersion dev1 = RexsVersion.findByModelVersion("dev");
		RexsVersion dev2 = RexsVersion.findByModelVersion("DEV");
		assertEquals(RexsVersion.DEV, dev1);
		assertEquals(RexsVersion.DEV, dev2);
	}

	@Test
	public void findByModelVersion_whenModelVersionWasGivenAsAdditional_thenReturnsVersion() {
		RexsVersion v10pro = RexsVersion.create("1.0", "provider", "1.0 PROVIDER", "additionalWhatever");
		RexsVersion version = RexsVersion.findByModelVersion("additionalWhatever");
		assertNotNull(version);
		assertEquals(v10pro, version);
	}

	@Test
	public void findByModelVersion_whenModelVersionDoesNotExist_thenReturnsUnknown() {
		RexsVersion version = RexsVersion.findByModelVersion("nonexistent");
		assertNotNull(version);
		assertEquals(RexsVersion.UNKNOWN, version);
	}

	@Test
	public void findByModelVersion_whenModelVersionIsNull_thenReturnsUnknown() {
		RexsVersion version = RexsVersion.findByModelVersion(null);
		assertEquals(RexsVersion.UNKNOWN, version);
	}

	@Test
	public void findBySchema_whenSchemaVersionIsDev_thenReturnDev() {
		assertEquals(RexsVersion.DEV, RexsVersion.findBySchema("DEV", null));
	}

	@Test
	public void findBySchema_whenSchemaVersionIsDevAndProviderIsNotExisting_thenReturnUnknown() {
		assertEquals(RexsVersion.UNKNOWN, RexsVersion.findBySchema("DEV", "non_existing_provider"));
	}

	@Test
	public void findBySchema_whenSchemaVersionIsNull_thenReturnsUnknown() {
		assertEquals(RexsVersion.UNKNOWN, RexsVersion.findBySchema(null, "provider"));
	}

	@Test
	public void findBySchema_whenSchemaProviderIsEmpty_thenTreatAsNull() {
		RexsVersion version = RexsVersion.create("1.0", null, "1.0");
		assertEquals(version, RexsVersion.findBySchema("1.0", ""));
	}

	@Test
	public void findBySchema_whenSchemaVersionAndProviderMatch_thenReturnsVersion() {
		RexsVersion version = RexsVersion.create("1.0", "provider", "1.0");
		assertEquals(version, RexsVersion.findBySchema("1.0", "provider"));
	}

	@Test
	public void findBySchema_whenSchemaVersionMatchesWithoutProvider_thenReturnsVersion() {
		RexsVersion version = RexsVersion.create("1.0", null, "1.0");
		assertEquals(version, RexsVersion.findBySchema("1.0", null));
	}

	@Test
	public void findBySchema_whenSchemaVersionMatchesButProviderDoesNot_thenReturnsUnknown() {
		RexsVersion.create("1.0", "provider1", "1.0");
		RexsVersion.create("200.0", "provider200", "200.0 provider200");
		assertEquals(RexsVersion.UNKNOWN, RexsVersion.findBySchema("1.0", "provider2"));
		assertEquals(RexsVersion.UNKNOWN, RexsVersion.findBySchema("99.99", ""));
		assertEquals(RexsVersion.UNKNOWN, RexsVersion.findBySchema("200.0", ""));
	}

	@Test
	public void findBySchema_whenSchemaVersionDoesNotMatch_thenReturnsUnknown() {
		RexsVersion.create("1.0", "provider", "1.0");
		assertEquals(RexsVersion.UNKNOWN, RexsVersion.findBySchema("7.0", "provider"));
	}

	@Test
	public void equals_whenSameSchemaAndProvider_thenReturnsTrue() {
		// without provider
		RexsVersion version1 = RexsVersion.create("1.0", null, "1.0");
		RexsVersion version2 = RexsVersion.create("1.0", null, "1.0 whatever");
		assertEquals(version1, version2);

		// with provider
		RexsVersion version1pro = RexsVersion.create("1.0", "provider", "1.0 PROVIDER");
		RexsVersion version2pro = RexsVersion.create("1.0", "provider", "1.0 PROVIDER whatever");
		assertEquals(version1pro, version2pro);
	}

	@Test
	public void equals_whenDifferentSchemaOrProvider_thenReturnsFalse() {
		RexsVersion version1 = RexsVersion.create("1.0", null, "1.0");
		RexsVersion version2 = RexsVersion.create("1.1", null, "1.1");
		RexsVersion version1pro = RexsVersion.create("1.0", "provider", "1.0");
		RexsVersion version2pro = RexsVersion.create("1.1", "provider", "1.1");
		assertNotEquals(version1, version2);
		assertNotEquals(version1pro, version2pro);
		assertNotEquals(version1, version1pro);
		assertNotEquals(version2, version2pro);
	}

	@Test
	public void equals_whenDifferentObject_thenNotEqual() {
		RexsVersion version = RexsVersion.create("1.0", null, "1.0");
		assertNotEquals(new Object(), version);
	}

	@Test
	public void hashCode_whenSameSchemaAndProvider_thenReturnsSameHashCode() {
		// without provider
		RexsVersion version1 = RexsVersion.create("1.0", null, "1.0");
		RexsVersion version2 = RexsVersion.create("1.0", null, "1.1");
		assertEquals(version1.hashCode(), version2.hashCode());

		// with provider
		RexsVersion version1pro = RexsVersion.create("1.0", "provider", "1.0");
		RexsVersion version2pro = RexsVersion.create("1.0", "provider", "1.1");
		assertEquals(version1pro.hashCode(), version2pro.hashCode());
	}

	@Test
	public void hashCode_whenDifferentSchemaOrProvider_thenReturnsDifferentHashCode() {
		RexsVersion version1 = RexsVersion.create("1.0", "provider1", "1.0");
		RexsVersion version2 = RexsVersion.create("1.0", "provider2", "1.0");
		assertNotEquals(version1.hashCode(), version2.hashCode());
	}

	@Test
	public void getNumericVersion_whenUnknownVersion_thenReturnsMinusOne() {
		assertEquals(-1, RexsVersion.UNKNOWN.getNumericVersion());
	}

	@Test
	public void getNumericVersion_whenDevVersion_thenReturnsMaxValue() {
		assertEquals(Integer.MAX_VALUE, RexsVersion.DEV.getNumericVersion());
	}

	@Test
	public void getNumericVersion_whenValidVersion_thenReturnsNumericValue() {
		RexsVersion version = RexsVersion.create("1.0", "provider", "1.0");
		assertEquals(10000, version.getNumericVersion());

		version = RexsVersion.create("2.5", "provider", "2.5");
		assertEquals(20500, version.getNumericVersion());
	}

	@Test
	public void compareTo_whenVersionsAreEqual_thenReturnsZero() {
		RexsVersion version1 = RexsVersion.create("1.0", "provider", "1.0");
		RexsVersion version2 = RexsVersion.create("1.0", "provider", "1.1");
		assertEquals(0, version1.compareTo(version2));
	}

	@Test
	public void compareTo_whenThisVersionIsLessThanOther_thenReturnsNegative() {
		RexsVersion version1 = RexsVersion.create("1.0", "provider", "1.0");
		RexsVersion version2 = RexsVersion.create("2.0", "provider", "2.0");
		assertTrue(version1.compareTo(version2) < 0);
	}

	@Test
	public void compareTo_whenThisVersionIsGreaterThanOther_thenReturnsPositive() {
		RexsVersion version1 = RexsVersion.create("2.0", "provider", "2.0");
		RexsVersion version2 = RexsVersion.create("1.0", "provider", "1.0");
		assertTrue(version1.compareTo(version2) > 0);
	}

	@Test
	public void isLessThan_whenThisVersionIsLessThanOther_thenReturnsTrue() {
		RexsVersion version1 = RexsVersion.create("1.0", "provider", "1.0");
		RexsVersion version2 = RexsVersion.create("2.0", "provider", "2.0");
		assertTrue(version1.isLessThan(version2));
	}

	@Test
	public void isLessThan_whenThisVersionIsNotLessThanOther_thenReturnsFalse() {
		RexsVersion version1 = RexsVersion.create("2.0", "provider", "2.0");
		RexsVersion version2 = RexsVersion.create("1.0", "provider", "1.0");
		assertFalse(version1.isLessThan(version2));
	}

	@Test
	public void isLessThanOrEquivalentTo_whenThisVersionIsLessThanOrEqualToOther_thenReturnsTrue() {
		RexsVersion version1 = RexsVersion.create("1.0", "provider", "1.0");
		RexsVersion version2 = RexsVersion.create("2.0", "provider", "2.0");
		RexsVersion version3 = RexsVersion.create("1.0", "provider", "1.1");
		assertTrue(version1.isLessThanOrEquivalentTo(version2));
		assertTrue(version1.isLessThanOrEquivalentTo(version3));
	}

	@Test
	public void isLessThanOrEquivalentTo_whenThisVersionIsNotLessThanOrEqualToOther_thenReturnsFalse() {
		RexsVersion version1 = RexsVersion.create("2.0", "provider", "2.0");
		RexsVersion version2 = RexsVersion.create("1.0", "provider", "1.0");
		assertFalse(version1.isLessThanOrEquivalentTo(version2));
	}

	@Test
	public void isGreaterThan_whenThisVersionIsGreaterThanOther_thenReturnsTrue() {
		RexsVersion version1 = RexsVersion.create("2.0", "provider", "2.0");
		RexsVersion version2 = RexsVersion.create("1.0", "provider", "1.0");
		assertTrue(version1.isGreaterThan(version2));
	}

	@Test
	public void isGreaterThan_whenThisVersionIsNotGreaterThanOther_thenReturnsFalse() {
		RexsVersion version1 = RexsVersion.create("1.0", "provider", "1.0");
		RexsVersion version2 = RexsVersion.create("2.0", "provider", "2.0");
		assertFalse(version1.isGreaterThan(version2));
	}

	@Test
	public void isGreaterThanOrEquivalentTo_whenThisVersionIsGreaterThanOrEqualToOther_thenReturnsTrue() {
		RexsVersion version1 = RexsVersion.create("2.0", "provider", "2.0");
		RexsVersion version2 = RexsVersion.create("1.0", "provider", "1.0");
		RexsVersion version3 = RexsVersion.create("2.0", "provider", "2.1");
		assertTrue(version1.isGreaterThanOrEquivalentTo(version2));
		assertTrue(version1.isGreaterThanOrEquivalentTo(version3));
	}

	@Test
	public void isGreaterThanOrEquivalentTo_whenThisVersionIsNotGreaterThanOrEqualToOther_thenReturnsFalse() {
		RexsVersion version1 = RexsVersion.create("1.0", "provider", "1.0");
		RexsVersion version2 = RexsVersion.create("2.0", "provider", "2.0");
		assertFalse(version1.isGreaterThanOrEquivalentTo(version2));
	}

	@Test
	public void isEquivalentTo_whenVersionsAreEqual_thenReturnsTrue() {
		RexsVersion version1 = RexsVersion.create("1.0", "provider", "1.0");
		RexsVersion version2 = RexsVersion.create("1.0", "provider", "1.1");
		assertTrue(version1.isEquivalentTo(version2));
	}

	@Test
	public void isEquivalentTo_whenVersionsAreNotEqual_thenReturnsFalse() {
		RexsVersion version1 = RexsVersion.create("1.0", "provider", "1.0");
		RexsVersion version2 = RexsVersion.create("2.0", "provider", "2.0");
		assertFalse(version1.isEquivalentTo(version2));
	}

	@Test
	public void toString_whenCalled_thenReturnsStringRepresentation() {
		// without provider
		assertEquals("1.0", RexsStandardVersions.V1_0.toString());

		// with provider
		RexsVersion version = RexsVersion.create("1.0", "provider", "1.0");
		assertEquals("1.0 (provider)", version.toString());
	}

	@Test
	public void getAll_whenCalled_returnsAllRegisteredVersionsWithoutDuplicates() {
		// Get all registered versions
		List<RexsVersion> allVersions = RexsVersion.getAll();

		// Verify that the list is not null
		assertNotNull(allVersions);

		// Verify that all entries to the list are unique
		assertEquals(allVersions.size(), allVersions.stream().distinct().count());

		// Verify that the registered versions are in the list
		assertTrue(allVersions.stream().anyMatch(v -> v.equals(RexsStandardVersions.V1_0)));
		assertTrue(allVersions.stream().anyMatch(v -> v.equals(RexsStandardVersions.V1_1)));
		assertTrue(allVersions.stream().anyMatch(v -> v.equals(RexsStandardVersions.V1_7)));

		// Verify that DEV is in that list but UNKNOWN isn't
		assertTrue(allVersions.stream().anyMatch(v -> v.equals(RexsVersion.DEV)));
		assertFalse(allVersions.stream().anyMatch(v -> v.equals(RexsVersion.UNKNOWN)));
	}

}
