/*******************************************************************************
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
 ******************************************************************************/
package info.rexs.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.Test;

import info.rexs.db.constants.RexsAttributeId;
import info.rexs.db.constants.RexsComponentType;
import info.rexs.db.constants.RexsUnitId;

public class RexsComponentTest {

	@Test
	public void componentConstructor_getterMatchesValuePassedToConstructor() throws Exception {
		RexsComponent rexsComponent = new RexsComponent(1, RexsComponentType.coupling, "bar");
		rexsComponent.addAttribute(new RexsAttribute(RexsAttributeId.overrolling_frequency_inner_ring));

		assertThat(rexsComponent.getId()).isEqualTo(1);
		assertThat(rexsComponent.getType()).isEqualTo(RexsComponentType.coupling);
		assertThat(rexsComponent.getName()).isEqualTo("bar");
		assertThat(rexsComponent.getAttributes().size()).isEqualTo(1);
		assertThat(rexsComponent.getAttributes().stream().findFirst().get().getAttributeId()).isEqualTo(RexsAttributeId.overrolling_frequency_inner_ring);
	}

	@Test
	public void getName_returnsEmptyStringIfNull() throws Exception {
		RexsComponent rexsComponent = new RexsComponent(1, RexsComponentType.coupling, null);

		assertThat(rexsComponent.getName()).isEqualTo("");
	}

	@Test
	public void hasAttribute_attributeNotInComponentReturnsFalse() throws Exception {
		RexsComponent rexsComponent = new RexsComponent(1, RexsComponentType.coupling, null);

		assertThat(rexsComponent.hasAttribute(RexsAttributeId.account_for_gravity)).isFalse();
	}

	@Test
	public void hasAttribute_attributeInComponentReturnsTrue() throws Exception {
		RexsComponent rexsComponent = new RexsComponent(1, RexsComponentType.coupling, null);
		rexsComponent.addAttribute(new RexsAttribute(RexsAttributeId.overrolling_frequency_inner_ring));

		assertThat(rexsComponent.hasAttribute(RexsAttributeId.overrolling_frequency_inner_ring)).isTrue();
	}

	@Test
	public void getAttribute_attributeNotInComponentReturnsNull() throws Exception {
		RexsComponent rexsComponent = new RexsComponent(1, RexsComponentType.coupling, null);

		assertThatExceptionOfType(RexsModelAccessException.class).isThrownBy(() -> {
			rexsComponent.getAttribute(RexsAttributeId.account_for_gravity);
		}).withMessage("attribute 'account_for_gravity' not found!");
	}

	@Test
	public void getAttribute_attributeInComponentReturnsAttribute() throws Exception {
		RexsComponent rexsComponent = new RexsComponent(1, RexsComponentType.coupling, null);
		rexsComponent.addAttribute(new RexsAttribute(RexsAttributeId.overrolling_frequency_inner_ring));

		RexsAttribute rexsAttribute = rexsComponent.getAttribute(RexsAttributeId.overrolling_frequency_inner_ring);
		assertThat(rexsAttribute).isNotNull();
		assertThat(rexsAttribute.getAttributeId()).isEqualTo(RexsAttributeId.overrolling_frequency_inner_ring);
		assertThat(rexsAttribute.getUnit()).isEqualTo(RexsUnitId.hertz);
	}

	@Test
	public void addAttribute_replacesExistingAttribute() throws Exception {
		RexsComponent rexsComponent = new RexsComponent(1, RexsComponentType.coupling, null);
		rexsComponent.addAttribute(new RexsAttribute(RexsAttributeId.number_of_gears));
		rexsComponent.addAttribute(new RexsAttribute(RexsAttributeId.number_of_gears));

		RexsAttribute rexsAttribute = new RexsAttribute(RexsAttributeId.number_of_teeth);
		rexsAttribute.setIntegerValue(42);
		rexsComponent.addAttribute(rexsAttribute);

		assertThat(rexsComponent.getAttributes().size()).isEqualTo(2);
		assertThat(rexsComponent.getAttribute(RexsAttributeId.number_of_teeth).getIntegerValue()).isEqualTo(42);
	}

	@Test
	public void addAttribute_addsNonExistingAttribute() throws Exception {
		RexsComponent rexsComponent = new RexsComponent(1, RexsComponentType.coupling, null);
		rexsComponent.addAttribute(new RexsAttribute(RexsAttributeId.number_of_teeth));
		rexsComponent.addAttribute(new RexsAttribute(RexsAttributeId.number_of_gears));

		assertThat(rexsComponent.getAttributes().size()).isEqualTo(2);
		assertThat(rexsComponent.getAttribute(RexsAttributeId.number_of_teeth)).isNotNull();
		assertThat(rexsComponent.getAttribute(RexsAttributeId.number_of_gears)).isNotNull();
	}

	@Test
	public void addAttribute_createAndAddsAttributeWithStringValue() throws Exception {
		RexsComponent rexsComponent = new RexsComponent(1, RexsComponentType.coupling, null);
		rexsComponent.addAttribute(RexsAttributeId.account_for_gravity, "foo_bar");

		assertThat(rexsComponent.getAttribute(RexsAttributeId.account_for_gravity).getStringValue()).isEqualTo("foo_bar");
	}

	@Test
	public void addAttribute_createAndAddsAttributeWithBooleanValue() throws Exception {
		RexsComponent rexsComponent = new RexsComponent(1, RexsComponentType.coupling, null);
		rexsComponent.addAttribute(RexsAttributeId.account_for_gravity, Boolean.TRUE);

		assertThat(rexsComponent.getAttribute(RexsAttributeId.account_for_gravity).getBooleanValue()).isTrue();
	}

	@Test
	public void addAttribute_createAndAddsAttributeWithIntegerValue() throws Exception {
		RexsComponent rexsComponent = new RexsComponent(1, RexsComponentType.coupling, null);
		rexsComponent.addAttribute(RexsAttributeId.account_for_gravity, 42);

		assertThat(rexsComponent.getAttribute(RexsAttributeId.account_for_gravity).getIntegerValue()).isEqualTo(42);
	}

	@Test
	public void addAttribute_createAndAddsAttributeWithFloatingPointValue() throws Exception {
		RexsComponent rexsComponent = new RexsComponent(1, RexsComponentType.coupling, null);
		rexsComponent.addAttribute(RexsAttributeId.addendum_basic_profile, 8.15);

		assertThat(rexsComponent.getAttribute(RexsAttributeId.addendum_basic_profile).getDoubleValue(RexsUnitId.mm)).isEqualTo(8.15);
	}

	@Test
	public void addAttribute_createAndAddsAttributeWithStringArrayValue() throws Exception {
		RexsComponent rexsComponent = new RexsComponent(1, RexsComponentType.coupling, null);
		rexsComponent.addAttribute(RexsAttributeId.account_for_gravity, new String[] {"foo", "bar"});

		assertThat(rexsComponent.getAttribute(RexsAttributeId.account_for_gravity).getStringArrayValue()).isEqualTo(new String[] {"foo", "bar"});
	}

	@Test
	public void addAttribute_createAndAddsAttributeWithBooleanArrayValue() throws Exception {
		RexsComponent rexsComponent = new RexsComponent(1, RexsComponentType.coupling, null);
		rexsComponent.addAttribute(RexsAttributeId.account_for_gravity, new Boolean[] {Boolean.TRUE, Boolean.FALSE});

		assertThat(rexsComponent.getAttribute(RexsAttributeId.account_for_gravity).getBooleanArrayValue()).isEqualTo(new Boolean[] {Boolean.TRUE, Boolean.FALSE});
	}

	@Test
	public void addAttribute_createAndAddsAttributeWithIntegerArrayValue() throws Exception {
		RexsComponent rexsComponent = new RexsComponent(1, RexsComponentType.coupling, null);
		rexsComponent.addAttribute(RexsAttributeId.account_for_gravity, new Integer[] {8, 15});

		assertThat(rexsComponent.getAttribute(RexsAttributeId.account_for_gravity).getIntegerArrayValue()).isEqualTo(new Integer[] {8, 15});
	}

	@Test
	public void addAttribute_createAndAddsAttributeWithFloatingPointArrayValue() throws Exception {
		RexsComponent rexsComponent = new RexsComponent(1, RexsComponentType.coupling, null);
		rexsComponent.addAttribute(RexsAttributeId.overrolling_frequency_inner_ring, new Double[] {23.33, 24.8});

		assertThat(rexsComponent.getAttribute(RexsAttributeId.overrolling_frequency_inner_ring).getDoubleArrayValue(RexsUnitId.hertz)).isEqualTo(new Double[] {23.33, 24.8});
	}

	@Test
	public void addAttribute_createAndAddsAttributeWithStringMatrixValue() throws Exception {
		RexsComponent rexsComponent = new RexsComponent(1, RexsComponentType.coupling, null);
		rexsComponent.addAttribute(RexsAttributeId.account_for_gravity, new String[][] {{"foo"}, {"bar"}});

		assertThat(rexsComponent.getAttribute(RexsAttributeId.account_for_gravity).getStringMatrixValue()).isEqualTo(new String[][] {{"foo"}, {"bar"}});
	}

	@Test
	public void addAttribute_createAndAddsAttributeWithBooleanMatrixValue() throws Exception {
		RexsComponent rexsComponent = new RexsComponent(1, RexsComponentType.coupling, null);
		rexsComponent.addAttribute(RexsAttributeId.account_for_gravity, new Boolean[][] {{Boolean.TRUE}, {Boolean.FALSE}});

		assertThat(rexsComponent.getAttribute(RexsAttributeId.account_for_gravity).getBooleanMatrixValue()).isEqualTo(new Boolean[][] {{Boolean.TRUE}, {Boolean.FALSE}});
	}

	@Test
	public void addAttribute_createAndAddsAttributeWithIntegerMatrixValue() throws Exception {
		RexsComponent rexsComponent = new RexsComponent(1, RexsComponentType.coupling, null);
		rexsComponent.addAttribute(RexsAttributeId.account_for_gravity, new Integer[][] {{8}, {15}});

		assertThat(rexsComponent.getAttribute(RexsAttributeId.account_for_gravity).getIntegerMatrixValue()).isEqualTo(new Integer[][] {{8}, {15}});
	}

	@Test
	public void addAttribute_createAndAddsAttributeWithFloatingPointMatrixValue() throws Exception {
		RexsComponent rexsComponent = new RexsComponent(1, RexsComponentType.coupling, null);
		rexsComponent.addAttribute(RexsAttributeId.addendum_modification, new Double[][] {{23.33}, {24.8}});

		assertThat(rexsComponent.getAttribute(RexsAttributeId.addendum_modification).getDoubleMatrixValue(RexsUnitId.mm)).isEqualTo(new Double[][] {{23.33}, {24.8}});
	}

	@Test
	public void changeComponentId_changesIdOfComponent() throws Exception {
		RexsComponent rexsComponent = new RexsComponent(1, RexsComponentType.coupling, null);
		rexsComponent.changeComponentId(2);

		assertThat(rexsComponent.getId()).isEqualTo(2);
	}

	@Test
	public void compareTo_comparesById() throws Exception {
		RexsComponent rexsComponent23 = new RexsComponent(23, RexsComponentType.coupling, null);
		RexsComponent rexsComponent42 = new RexsComponent(42, RexsComponentType.coupling, null);

		assertThat(rexsComponent23.compareTo(rexsComponent42)).isLessThan(0);
		assertThat(rexsComponent42.compareTo(rexsComponent23)).isGreaterThan(0);
		assertThat(rexsComponent23.compareTo(rexsComponent23)).isEqualTo(0);
		assertThat(rexsComponent42.compareTo(rexsComponent42)).isEqualTo(0);
	}

	@Test
	public void deleteAttribute_notIncludedAttributeIsIgnored() throws Exception {
		RexsComponent rexsComponent = new RexsComponent(1, RexsComponentType.coupling, null);
		rexsComponent.addAttribute(new RexsAttribute(RexsAttributeId.overrolling_frequency_inner_ring));
		rexsComponent.deleteAttribute(RexsAttributeId.number_of_gears);

		assertThat(rexsComponent.getAttributes().size()).isEqualTo(1);
		assertThat(rexsComponent.hasAttribute(RexsAttributeId.overrolling_frequency_inner_ring)).isTrue();
	}

	@Test
	public void deleteAttribute_deletesIncludedAttribute() throws Exception {
		RexsComponent rexsComponent = new RexsComponent(1, RexsComponentType.coupling, null);
		rexsComponent.addAttribute(new RexsAttribute(RexsAttributeId.overrolling_frequency_inner_ring));
		rexsComponent.deleteAttribute(RexsAttributeId.overrolling_frequency_inner_ring);

		assertThat(rexsComponent.getAttributes().isEmpty()).isTrue();
		assertThat(rexsComponent.hasAttribute(RexsAttributeId.overrolling_frequency_inner_ring)).isFalse();
	}

	@Test
	public void equals_equalObjects() {
		RexsComponent rexsComponent1 = new RexsComponent(1, RexsComponentType.coupling, null);
		RexsComponent rexsComponent2 = new RexsComponent(1, RexsComponentType.coupling, null);

		assertThat(rexsComponent1.equals(rexsComponent1)).isTrue();
		assertThat(rexsComponent1).isEqualTo(rexsComponent2);
	}

	@Test
	public void equals_notEqualObjects() {
		RexsComponent rexsComponent1 = new RexsComponent(1, RexsComponentType.coupling, null);
		RexsComponent rexsComponent2 = new RexsComponent(2, RexsComponentType.coupling, null);

		assertThat(rexsComponent1).isNotEqualTo(rexsComponent2);
		assertThat(rexsComponent1).isNotEqualTo("1");
	}

	@Test
	public void isOfType_checkAgainstSeveralTypes() {
		RexsComponent rexsComponent1 = new RexsComponent(1, RexsComponentType.cylindrical_gear, null);

		assertThat(rexsComponent1.isOfType(RexsComponentType.cylindrical_gear)).isTrue();
		assertThat(rexsComponent1.isOfType(RexsComponentType.cylindrical_gear, RexsComponentType.ring_gear)).isTrue();
		assertThat(rexsComponent1.isOfType(RexsComponentType.ring_gear)).isFalse();
		assertThat(rexsComponent1.isOfType(RexsComponentType.bevel_gear, RexsComponentType.ring_gear)).isFalse();
	}
}
