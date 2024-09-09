/*
 * Copyright (C) 2020 FVA GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.  You may obtain a copy
 * of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package info.rexs.db.constants;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import info.rexs.db.constants.standard.RexsStandardUnitIds;
import org.junit.Test;

public class RexsUnitIdTest {

	@Test
	public void create_givenNullThrowsIllegalArgumentException() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> {
				RexsUnitId.create(null);
			})
			.withMessage("id cannot be empty");
	}

	@Test
	public void create_givenEmptyIdThrowsIllegalArgumentException() {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> {
				RexsUnitId.create("");
			})
			.withMessage("id cannot be empty");

		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> {
					RexsUnitId.create("", 123);
				})
				.withMessage("id cannot be empty");
	}

	@Test
	public void create_givenNegativeNumericIdThrowsIllegalArgumentException() {
		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> {
					RexsUnitId.create("unit", -1);
				})
				.withMessage("numericId cannot be negative");
	}

	@Test
	public void create_givenDuplicateNumericIdThrowsIllegalArgumentException() {
		// Create a unit with numeric ID 123
		RexsUnitId.create("unit1", 123);

		// Attempt to create another unit with the same numeric ID (should throw an exception)
		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> {
					RexsUnitId.create("unit2", 123);
				})
				.withMessage("numericId already exists");
	}

	@Test
	public void create_givenNumericIdCreatesUnitWithNumericId() {
		RexsUnitId newUnitId = RexsUnitId.create("bar", 1234);
		assertThat(newUnitId.getNumericId()).isEqualTo(1234);
	}

	@Test
	public void create_givenZeroNumericIdBehavesSameAsNoNumericId() {
		RexsUnitId unitIdWithoutNumericId = RexsUnitId.create("baz");
		RexsUnitId unitIdWithZeroNumericId = RexsUnitId.create("baz", 0);
		assertThat(unitIdWithZeroNumericId.getId()).isEqualTo(unitIdWithoutNumericId.getId());
	}

	@Test
	public void isOneOf_returnsTrueForMatchingUnit() {
		// Create some sample units
		RexsUnitId unit1 = RexsUnitId.create("unit1");
		RexsUnitId unit2 = RexsUnitId.create("unit2");
		RexsUnitId unit3 = RexsUnitId.create("unit3");

		// Check if unit1 is one of the specified units
		boolean result = unit1.isOneOf(unit1, unit2, unit3);
		assertThat(result).isTrue();
	}

	@Test
	public void isOneOf_returnsFalseForNonMatchingUnit() {
		// Create some sample units
		RexsUnitId unit1 = RexsUnitId.create("unit1");
		RexsUnitId unit2 = RexsUnitId.create("unit2");
		RexsUnitId unit3 = RexsUnitId.create("unit3");

		// Check if unit1 is one of the specified units (should return false)
		boolean result = unit1.isOneOf(unit2, unit3);
		assertThat(result).isFalse();
	}

	@Test
	public void isOneOf_returnsFalseForNullArgument() {
		// Create a sample unit
		RexsUnitId unit = RexsUnitId.create("unit1");

		// Check if unit is one of the specified units (including null)
		boolean result = unit.isOneOf((RexsUnitId) null);
		assertThat(result).isFalse();
	}

	@Test
	public void create_newUnitIdHasId() {
		RexsUnitId newUnitId = RexsUnitId.create("foo");
		assertThat(newUnitId.getId()).isEqualTo("foo");
	}

	@Test
	public void findById_givenEmptyIdReturnsNone() {
		assertThat(RexsUnitId.findById("")).isEqualTo(RexsStandardUnitIds.none);
	}


	@Test
	public void findById_givenNullReturnsNull() {
		assertThat(RexsUnitId.findById(null)).isNull();
	}

	@Test
	public void findById_givenUnknownIdReturnsUnknown() {
		assertThat(RexsUnitId.findById("foo_bar")).isEqualTo(RexsStandardUnitIds.UNKNOWN);
	}

	@Test
	public void findById_returnsRexsStandardUnitId() {
		RexsUnitId unitId = RexsUnitId.findById(RexsStandardUnitIds.hertz.getId());
		assertThat(unitId).isNotNull();
		assertThat(unitId.getId()).isEqualTo(RexsStandardUnitIds.hertz.getId());
	}

	@Test
	public void findById_returnsNewlyCreatedUnitId() {
		RexsUnitId.create("bar");
		RexsUnitId newUnitId = RexsUnitId.findById("bar");
		assertThat(newUnitId).isNotNull();
		assertThat(newUnitId.getId()).isEqualTo("bar");
	}

	@Test
	public void findById_returnsExistingUnitForValidNumericId() {
		// Create some sample units
		RexsUnitId unit1 = RexsUnitId.create("unit1", 12345);
		RexsUnitId unit2 = RexsUnitId.create("unit2", 45678);

		// Test finding units by numeric ID
		RexsUnitId foundUnit1 = RexsUnitId.findById(12345);
		RexsUnitId foundUnit2 = RexsUnitId.findById(45678);

		assertThat(foundUnit1).isEqualTo(unit1);
		assertThat(foundUnit2).isEqualTo(unit2);
	}

	@Test
	public void findById_returnsUnknownForNonExistentNumericId() {
		// Test non-existent numeric ID
		RexsUnitId notFoundUnit = RexsUnitId.findById(999);

		assertThat(notFoundUnit).isEqualTo(RexsStandardUnitIds.UNKNOWN);
	}

	@Test
	public void isEquivalent_nullSafety() {
		assertThat(RexsStandardUnitIds.hour.isEquivalent(null)).isFalse();
	}

	@Test
	public void isEquivalent_equivalentUnitsReturnTrue() {
		assertThat(RexsStandardUnitIds.mega_pascal.isEquivalent(RexsStandardUnitIds.newton_per_mm2)).isTrue();
		assertThat(RexsStandardUnitIds.newton_per_mm2.isEquivalent(RexsStandardUnitIds.mega_pascal)).isTrue();

		assertThat(RexsStandardUnitIds.rotation_per_second.isEquivalent(RexsStandardUnitIds.hertz)).isTrue();
		assertThat(RexsStandardUnitIds.hertz.isEquivalent(RexsStandardUnitIds.rotation_per_second)).isTrue();
	}

	@Test
	public void isEquivalent_nonEquivalentUnitsReturnFalse() {
		assertThat(RexsStandardUnitIds.hour.isEquivalent(RexsStandardUnitIds.degree_celsius)).isFalse();
		assertThat(RexsStandardUnitIds.degree_celsius.isEquivalent(RexsStandardUnitIds.hour)).isFalse();
	}
}
