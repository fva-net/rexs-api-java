package info.rexs.db.constants;

import info.rexs.db.constants.standard.RexsStandardVersions2;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RexsVersion2Test {

	@Test
	public void getSchemaVersion_whenCalled_thenReturnsCorrectVersion() {
		RexsVersion2 version = RexsStandardVersions2.V1_0;
		assertThat(version.getSchemaVersion()).isEqualTo("1.0");
	}

	@Test
	public void getSchemaProvider_whenCalled_thenReturnsCorrectProvider() {
		RexsVersion2 version = RexsStandardVersions2.V1_0;
		assertThat(version.getSchemaProvider()).isEmpty();
	}

	@Test
	public void getModelVersion_whenCalled_thenReturnsCorrectModelVersion() {
		RexsVersion2 version = RexsStandardVersions2.V1_0;
		assertThat(version.getModelVersion()).isEqualTo("1.0");
	}

	@Test
	public void getNumericVersion_whenCalled_thenReturnsCorrectNumericVersion() {
		RexsVersion2 version = RexsStandardVersions2.V1_0;
		assertThat(version.getNumericVersion()).isEqualTo(10000);
	}

	@Test
	public void isEquivalentTo_whenVersionsAreEqual_thenReturnsTrue() {
		RexsVersion2 version1 = RexsStandardVersions2.V1_0;
		RexsVersion2 version2 = RexsStandardVersions2.V1_0;
		assertThat(version1.isEquivalentTo(version2)).isTrue();
	}

	@Test
	public void isLessThan_whenVersionIsLess_thenReturnsTrue() {
		RexsVersion2 version1 = RexsStandardVersions2.V1_0;
		RexsVersion2 version2 = RexsStandardVersions2.V1_1;
		assertThat(version1.isLessThan(version2)).isTrue();
	}

	@Test
	public void isGreaterThan_whenVersionIsGreater_thenReturnsTrue() {
		RexsVersion2 version1 = RexsStandardVersions2.V1_1;
		RexsVersion2 version2 = RexsStandardVersions2.V1_0;
		assertThat(version1.isGreaterThan(version2)).isTrue();
	}
}