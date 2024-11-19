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
package info.rexs.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.Test;

import info.rexs.schema.constants.standard.RexsStandardAttributeIds;
import info.rexs.schema.constants.standard.RexsStandardComponentTypes;
import info.rexs.schema.constants.standard.RexsStandardUnitIds;

public class RexsComponentTest {

	@Test
	public void componentConstructor_getterMatchesValuePassedToConstructor() {
		RexsComponent rexsComponent = new RexsComponent(1, RexsStandardComponentTypes.coupling, "bar");
		rexsComponent.addAttribute(new RexsAttribute(RexsStandardAttributeIds.overrolling_frequency_inner_ring));

		assertThat(rexsComponent.getId()).isEqualTo(1);
		assertThat(rexsComponent.getType()).isEqualTo(RexsStandardComponentTypes.coupling);
		assertThat(rexsComponent.getName()).isEqualTo("bar");
		assertThat(rexsComponent.getAttributes().size()).isEqualTo(1);
		assertThat(rexsComponent.getAttributes().stream().findFirst().get().getAttributeId()).isEqualTo(RexsStandardAttributeIds.overrolling_frequency_inner_ring);
	}

	@Test
	public void getName_returnsEmptyStringIfNull() {
		RexsComponent rexsComponent = new RexsComponent(1, RexsStandardComponentTypes.coupling, null);

		assertThat(rexsComponent.getName()).isEqualTo("");
	}

	@Test
	public void hasAttribute_attributeNotInComponentReturnsFalse() {
		RexsComponent rexsComponent = new RexsComponent(1, RexsStandardComponentTypes.coupling, null);

		assertThat(rexsComponent.hasAttribute(RexsStandardAttributeIds.account_for_gravity)).isFalse();
	}

	@Test
	public void hasAttribute_attributeInComponentReturnsTrue() {
		RexsComponent rexsComponent = new RexsComponent(1, RexsStandardComponentTypes.coupling, null);
		rexsComponent.addAttribute(new RexsAttribute(RexsStandardAttributeIds.overrolling_frequency_inner_ring));

		assertThat(rexsComponent.hasAttribute(RexsStandardAttributeIds.overrolling_frequency_inner_ring)).isTrue();
	}

	@Test
	public void getAttribute_attributeNotInComponentReturnsNull() {
		RexsComponent rexsComponent = new RexsComponent(1, RexsStandardComponentTypes.coupling, null);

		assertThatExceptionOfType(RexsModelAccessException.class).isThrownBy(() -> rexsComponent.getAttribute(RexsStandardAttributeIds.account_for_gravity)).withMessage("attribute 'account_for_gravity' not found!");
	}

	@Test
	public void getAttribute_attributeInComponentReturnsAttribute() {
		RexsComponent rexsComponent = new RexsComponent(1, RexsStandardComponentTypes.coupling, null);
		rexsComponent.addAttribute(new RexsAttribute(RexsStandardAttributeIds.overrolling_frequency_inner_ring));

		RexsAttribute rexsAttribute = rexsComponent.getAttribute(RexsStandardAttributeIds.overrolling_frequency_inner_ring);
		assertThat(rexsAttribute).isNotNull();
		assertThat(rexsAttribute.getAttributeId()).isEqualTo(RexsStandardAttributeIds.overrolling_frequency_inner_ring);
		assertThat(rexsAttribute.getUnit()).isEqualTo(RexsStandardUnitIds.hertz);
	}

	@Test
	public void addAttribute_replacesExistingAttribute() {
		RexsComponent rexsComponent = new RexsComponent(1, RexsStandardComponentTypes.coupling, null);
		rexsComponent.addAttribute(new RexsAttribute(RexsStandardAttributeIds.number_of_gears));
		rexsComponent.addAttribute(new RexsAttribute(RexsStandardAttributeIds.number_of_gears));

		RexsAttribute rexsAttribute = new RexsAttribute(RexsStandardAttributeIds.number_of_teeth);
		rexsAttribute.setIntegerValue(42);
		rexsComponent.addAttribute(rexsAttribute);

		assertThat(rexsComponent.getAttributes().size()).isEqualTo(2);
		assertThat(rexsComponent.getAttribute(RexsStandardAttributeIds.number_of_teeth).getIntegerValue()).isEqualTo(42);
	}

	@Test
	public void addAttribute_addsNonExistingAttribute() {
		RexsComponent rexsComponent = new RexsComponent(1, RexsStandardComponentTypes.coupling, null);
		rexsComponent.addAttribute(new RexsAttribute(RexsStandardAttributeIds.number_of_teeth));
		rexsComponent.addAttribute(new RexsAttribute(RexsStandardAttributeIds.number_of_gears));

		assertThat(rexsComponent.getAttributes().size()).isEqualTo(2);
		assertThat(rexsComponent.getAttribute(RexsStandardAttributeIds.number_of_teeth)).isNotNull();
		assertThat(rexsComponent.getAttribute(RexsStandardAttributeIds.number_of_gears)).isNotNull();
	}

	@Test
	public void addAttribute_createAndAddsAttributeWithStringValue() {
		RexsComponent rexsComponent = new RexsComponent(1, RexsStandardComponentTypes.coupling, null);
		rexsComponent.addAttribute(RexsStandardAttributeIds.account_for_gravity, "foo_bar");

		assertThat(rexsComponent.getAttribute(RexsStandardAttributeIds.account_for_gravity).getStringValue()).isEqualTo("foo_bar");
	}

	@Test
	public void addAttribute_createAndAddsAttributeWithBooleanValue() {
		RexsComponent rexsComponent = new RexsComponent(1, RexsStandardComponentTypes.coupling, null);
		rexsComponent.addAttribute(RexsStandardAttributeIds.account_for_gravity, Boolean.TRUE);

		assertThat(rexsComponent.getAttribute(RexsStandardAttributeIds.account_for_gravity).getBooleanValue()).isTrue();
	}

	@Test
	public void addAttribute_createAndAddsAttributeWithIntegerValue() {
		RexsComponent rexsComponent = new RexsComponent(1, RexsStandardComponentTypes.coupling, null);
		rexsComponent.addAttribute(RexsStandardAttributeIds.account_for_gravity, 42);

		assertThat(rexsComponent.getAttribute(RexsStandardAttributeIds.account_for_gravity).getIntegerValue()).isEqualTo(42);
	}

	@Test
	public void addAttribute_createAndAddsAttributeWithFloatingPointValue() {
		RexsComponent rexsComponent = new RexsComponent(1, RexsStandardComponentTypes.coupling, null);
		rexsComponent.addAttribute(RexsStandardAttributeIds.addendum_basic_profile, 8.15);

		assertThat(rexsComponent.getAttribute(RexsStandardAttributeIds.addendum_basic_profile).getDoubleValue(RexsStandardUnitIds.mm)).isEqualTo(8.15);
	}

	@Test
	public void addAttribute_createAndAddsAttributeWithStringArrayValue() {
		RexsComponent rexsComponent = new RexsComponent(1, RexsStandardComponentTypes.coupling, null);
		rexsComponent.addAttribute(RexsStandardAttributeIds.account_for_gravity, new String[] {"foo", "bar"});

		assertThat(rexsComponent.getAttribute(RexsStandardAttributeIds.account_for_gravity).getStringArrayValue()).isEqualTo(new String[] {"foo", "bar"});
	}

	@Test
	public void addAttribute_createAndAddsAttributeWithBooleanArrayValue() {
		RexsComponent rexsComponent = new RexsComponent(1, RexsStandardComponentTypes.coupling, null);
		rexsComponent.addAttribute(RexsStandardAttributeIds.account_for_gravity, new Boolean[] {Boolean.TRUE, Boolean.FALSE});

		assertThat(rexsComponent.getAttribute(RexsStandardAttributeIds.account_for_gravity).getBooleanArrayValue()).isEqualTo(new Boolean[] {Boolean.TRUE, Boolean.FALSE});
	}

	@Test
	public void addAttribute_createAndAddsAttributeWithIntegerArrayValue() {
		RexsComponent rexsComponent = new RexsComponent(1, RexsStandardComponentTypes.coupling, null);
		rexsComponent.addAttribute(RexsStandardAttributeIds.account_for_gravity, new Integer[] {8, 15});

		assertThat(rexsComponent.getAttribute(RexsStandardAttributeIds.account_for_gravity).getIntegerArrayValue()).isEqualTo(new Integer[] {8, 15});
	}

	@Test
	public void addAttribute_createAndAddsAttributeWithFloatingPointArrayValue() {
		RexsComponent rexsComponent = new RexsComponent(1, RexsStandardComponentTypes.coupling, null);
		rexsComponent.addAttribute(RexsStandardAttributeIds.overrolling_frequency_inner_ring, new Double[] {23.33, 24.8});

		assertThat(rexsComponent.getAttribute(RexsStandardAttributeIds.overrolling_frequency_inner_ring).getDoubleArrayValue(RexsStandardUnitIds.hertz)).isEqualTo(new Double[] {23.33, 24.8});
	}

	@Test
	public void addAttribute_createAndAddsAttributeWithStringMatrixValue() {
		RexsComponent rexsComponent = new RexsComponent(1, RexsStandardComponentTypes.coupling, null);
		rexsComponent.addAttribute(RexsStandardAttributeIds.account_for_gravity, new String[][] {{"foo"}, {"bar"}});

		assertThat(rexsComponent.getAttribute(RexsStandardAttributeIds.account_for_gravity).getStringMatrixValue()).isEqualTo(new String[][] {{"foo"}, {"bar"}});
	}

	@Test
	public void addAttribute_createAndAddsAttributeWithBooleanMatrixValue() {
		RexsComponent rexsComponent = new RexsComponent(1, RexsStandardComponentTypes.coupling, null);
		rexsComponent.addAttribute(RexsStandardAttributeIds.account_for_gravity, new Boolean[][] {{Boolean.TRUE}, {Boolean.FALSE}});

		assertThat(rexsComponent.getAttribute(RexsStandardAttributeIds.account_for_gravity).getBooleanMatrixValue()).isEqualTo(new Boolean[][] {{Boolean.TRUE}, {Boolean.FALSE}});
	}

	@Test
	public void addAttribute_createAndAddsAttributeWithIntegerMatrixValue() {
		RexsComponent rexsComponent = new RexsComponent(1, RexsStandardComponentTypes.coupling, null);
		rexsComponent.addAttribute(RexsStandardAttributeIds.account_for_gravity, new Integer[][] {{8}, {15}});

		assertThat(rexsComponent.getAttribute(RexsStandardAttributeIds.account_for_gravity).getIntegerMatrixValue()).isEqualTo(new Integer[][] {{8}, {15}});
	}

	@Test
	public void addAttribute_createAndAddsAttributeWithFloatingPointMatrixValue() {
		RexsComponent rexsComponent = new RexsComponent(1, RexsStandardComponentTypes.coupling, null);
		rexsComponent.addAttribute(RexsStandardAttributeIds.addendum_modification, new Double[][] {{23.33}, {24.8}});

		assertThat(rexsComponent.getAttribute(RexsStandardAttributeIds.addendum_modification).getDoubleMatrixValue(RexsStandardUnitIds.mm)).isEqualTo(new Double[][] {{23.33}, {24.8}});
	}

	@Test
	public void changeComponentId_changesIdOfComponent() {
		RexsComponent rexsComponent = new RexsComponent(1, RexsStandardComponentTypes.coupling, null);
		rexsComponent.changeComponentId(2);

		assertThat(rexsComponent.getId()).isEqualTo(2);
	}

	@Test
	public void compareTo_comparesById() {
		RexsComponent rexsComponent23 = new RexsComponent(23, RexsStandardComponentTypes.coupling, null);
		RexsComponent rexsComponent42 = new RexsComponent(42, RexsStandardComponentTypes.coupling, null);

		assertThat(rexsComponent23.compareTo(rexsComponent42)).isLessThan(0);
		assertThat(rexsComponent42.compareTo(rexsComponent23)).isGreaterThan(0);
		assertThat(rexsComponent23.compareTo(rexsComponent23)).isEqualTo(0);
		assertThat(rexsComponent42.compareTo(rexsComponent42)).isEqualTo(0);
	}

	@Test
	public void deleteAttribute_notIncludedAttributeIsIgnored() {
		RexsComponent rexsComponent = new RexsComponent(1, RexsStandardComponentTypes.coupling, null);
		rexsComponent.addAttribute(new RexsAttribute(RexsStandardAttributeIds.overrolling_frequency_inner_ring));
		rexsComponent.deleteAttribute(RexsStandardAttributeIds.number_of_gears);

		assertThat(rexsComponent.getAttributes().size()).isEqualTo(1);
		assertThat(rexsComponent.hasAttribute(RexsStandardAttributeIds.overrolling_frequency_inner_ring)).isTrue();
	}

	@Test
	public void deleteAttribute_deletesIncludedAttribute() {
		RexsComponent rexsComponent = new RexsComponent(1, RexsStandardComponentTypes.coupling, null);
		rexsComponent.addAttribute(new RexsAttribute(RexsStandardAttributeIds.overrolling_frequency_inner_ring));
		rexsComponent.deleteAttribute(RexsStandardAttributeIds.overrolling_frequency_inner_ring);

		assertThat(rexsComponent.getAttributes().isEmpty()).isTrue();
		assertThat(rexsComponent.hasAttribute(RexsStandardAttributeIds.overrolling_frequency_inner_ring)).isFalse();
	}

	@Test
	public void equals_equalObjects() {
		RexsComponent rexsComponent1 = new RexsComponent(1, RexsStandardComponentTypes.coupling, null);
		RexsComponent rexsComponent2 = new RexsComponent(1, RexsStandardComponentTypes.coupling, null);

		assertThat(rexsComponent1.equals(rexsComponent1)).isTrue();
		assertThat(rexsComponent1).isEqualTo(rexsComponent2);
	}

	@Test
	public void equals_notEqualObjects() {
		RexsComponent rexsComponent1 = new RexsComponent(1, RexsStandardComponentTypes.coupling, null);
		RexsComponent rexsComponent2 = new RexsComponent(2, RexsStandardComponentTypes.coupling, null);

		assertThat(rexsComponent1).isNotEqualTo(rexsComponent2);
		assertThat(rexsComponent1).isNotEqualTo("1");
	}

	@Test
	public void isOfType_checkAgainstSeveralTypes() {
		RexsComponent rexsComponent1 = new RexsComponent(1, RexsStandardComponentTypes.cylindrical_gear, null);

		assertThat(rexsComponent1.isOfType(RexsStandardComponentTypes.cylindrical_gear)).isTrue();
		assertThat(rexsComponent1.isOfType(RexsStandardComponentTypes.cylindrical_gear, RexsStandardComponentTypes.ring_gear)).isTrue();
		assertThat(rexsComponent1.isOfType(RexsStandardComponentTypes.ring_gear)).isFalse();
		assertThat(rexsComponent1.isOfType(RexsStandardComponentTypes.bevel_gear, RexsStandardComponentTypes.ring_gear)).isFalse();
	}
}
