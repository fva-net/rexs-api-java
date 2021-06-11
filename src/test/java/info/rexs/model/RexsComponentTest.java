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
import info.rexs.model.jaxb.Attribute;
import info.rexs.model.jaxb.Component;

public class RexsComponentTest {

	@Test
	public void componentConstructor_getterMatchesValuePassedToConstructor() throws Exception {
		Attribute rawAttribute = new Attribute();
		rawAttribute.setId(RexsAttributeId.overrolling_frequency_inner_ring.getId());
		rawAttribute.setUnit(RexsUnitId.hertz.getId());

		Component rawComponent = new Component();
		rawComponent.setId(1);
		rawComponent.setType(RexsComponentType.coupling.getId());
		rawComponent.setName("bar");
		rawComponent.getAttribute().add(rawAttribute);

		RexsComponent rexsComponent = new RexsComponent(rawComponent);

		assertThat(rexsComponent.getId()).isEqualTo(1);
		assertThat(rexsComponent.getType()).isEqualTo(RexsComponentType.coupling);
		assertThat(rexsComponent.getName()).isEqualTo("bar");
		assertThat(rexsComponent.getRawComponent()).isEqualTo(rawComponent);
		assertThat(rexsComponent.getAttributes().size()).isEqualTo(1);
		assertThat(rexsComponent.getAttributes().stream().findFirst().get().getRawAttribute()).isEqualTo(rawAttribute);
	}

	@Test
	public void getName_returnsEmptyStringIfNull() throws Exception {
		Component rawComponent = new Component();
		rawComponent.setId(1);
		rawComponent.setType(RexsComponentType.coupling.getId());
		rawComponent.setName(null);

		RexsComponent rexsComponent = new RexsComponent(rawComponent);

		assertThat(rexsComponent.getName()).isEqualTo("");
	}

	@Test
	public void hasAttribute_attributeNotInComponentReturnsFalse() throws Exception {
		Component rawComponent = new Component();
		rawComponent.setId(1);
		rawComponent.setType(RexsComponentType.coupling.getId());

		RexsComponent rexsComponent = new RexsComponent(rawComponent);

		assertThat(rexsComponent.hasAttribute(RexsAttributeId.account_for_gravity)).isFalse();
	}

	@Test
	public void hasAttribute_attributeInComponentReturnsTrue() throws Exception {
		Attribute rawAttribute = new Attribute();
		rawAttribute.setId(RexsAttributeId.overrolling_frequency_inner_ring.getId());
		rawAttribute.setUnit(RexsUnitId.hertz.getId());

		Component rawComponent = new Component();
		rawComponent.setId(1);
		rawComponent.setType(RexsComponentType.coupling.getId());
		rawComponent.getAttribute().add(rawAttribute);

		RexsComponent rexsComponent = new RexsComponent(rawComponent);

		assertThat(rexsComponent.hasAttribute(RexsAttributeId.overrolling_frequency_inner_ring)).isTrue();
	}

	@Test
	public void getAttribute_attributeNotInComponentReturnsNull() throws Exception {
		Component rawComponent = new Component();
		rawComponent.setId(1);
		rawComponent.setType(RexsComponentType.coupling.getId());

		RexsComponent rexsComponent = new RexsComponent(rawComponent);
		assertThatExceptionOfType(RexsModelAccessException.class).isThrownBy(() -> {
			rexsComponent.getAttribute(RexsAttributeId.account_for_gravity);
		}).withMessage("attribute 'account_for_gravity' not found!");
	}

	@Test
	public void getAttribute_attributeInComponentReturnsAttribute() throws Exception {
		Attribute rawAttribute = new Attribute();
		rawAttribute.setId(RexsAttributeId.overrolling_frequency_inner_ring.getId());
		rawAttribute.setUnit(RexsUnitId.hertz.getId());

		Component rawComponent = new Component();
		rawComponent.setId(1);
		rawComponent.setType(RexsComponentType.coupling.getId());
		rawComponent.getAttribute().add(rawAttribute);

		RexsComponent rexsComponent = new RexsComponent(rawComponent);

		RexsAttribute rexsAttribute = rexsComponent.getAttribute(RexsAttributeId.overrolling_frequency_inner_ring);
		assertThat(rexsAttribute).isNotNull();
		assertThat(rexsAttribute.getRawAttribute()).isEqualTo(rawAttribute);
		assertThat(rexsAttribute.getAttributeId()).isEqualTo(RexsAttributeId.overrolling_frequency_inner_ring);
		assertThat(rexsAttribute.getUnit()).isEqualTo(RexsUnitId.hertz);
	}

	@Test
	public void addAttribute_replacesExistingAttribute() throws Exception {
		Attribute rawAttribute1 = new Attribute();
		rawAttribute1.setId(RexsAttributeId.number_of_gears.getId());
		rawAttribute1.setUnit(RexsUnitId.none.getId());

		Attribute rawAttribute2 = new Attribute();
		rawAttribute2.setId(RexsAttributeId.number_of_teeth.getId());
		rawAttribute2.setUnit(RexsUnitId.none.getId());

		Component rawComponent = new Component();
		rawComponent.setId(1);
		rawComponent.setType(RexsComponentType.coupling.getId());
		rawComponent.getAttribute().add(rawAttribute1);
		rawComponent.getAttribute().add(rawAttribute2);

		RexsComponent rexsComponent = new RexsComponent(rawComponent);
		RexsAttribute rexsAttribute = new RexsAttribute(RexsAttributeId.number_of_teeth);
		rexsAttribute.setIntegerValue(42);
		rexsComponent.addAttribute(rexsAttribute);

		assertThat(rexsComponent.getAttributes().size()).isEqualTo(2);
		assertThat(rexsComponent.getAttribute(RexsAttributeId.number_of_teeth).getIntegerValue()).isEqualTo(42);
	}

	@Test
	public void addAttribute_addsNonExistingAttribute() throws Exception {
		Attribute rawAttribute = new Attribute();
		rawAttribute.setId(RexsAttributeId.number_of_teeth.getId());
		rawAttribute.setUnit(RexsUnitId.none.getId());

		Component rawComponent = new Component();
		rawComponent.setId(1);
		rawComponent.setType(RexsComponentType.coupling.getId());
		rawComponent.getAttribute().add(rawAttribute);

		RexsComponent rexsComponent = new RexsComponent(rawComponent);
		RexsAttribute rexsAttribute = new RexsAttribute(RexsAttributeId.number_of_gears);
		rexsComponent.addAttribute(rexsAttribute);

		assertThat(rexsComponent.getAttributes().size()).isEqualTo(2);
		assertThat(rexsComponent.getAttribute(RexsAttributeId.number_of_teeth)).isNotNull();
		assertThat(rexsComponent.getAttribute(RexsAttributeId.number_of_gears)).isNotNull();
	}

	@Test
	public void addAttribute_createAndAddsAttributeWithStringValue() throws Exception {
		Component rawComponent = new Component();
		rawComponent.setId(1);
		rawComponent.setType(RexsComponentType.coupling.getId());
		RexsComponent rexsComponent = new RexsComponent(rawComponent);

		rexsComponent.addAttribute(RexsAttributeId.account_for_gravity, "foo_bar");

		assertThat(rexsComponent.getAttribute(RexsAttributeId.account_for_gravity).getStringValue()).isEqualTo("foo_bar");
	}

	@Test
	public void addAttribute_createAndAddsAttributeWithBooleanValue() throws Exception {
		Component rawComponent = new Component();
		rawComponent.setId(1);
		rawComponent.setType(RexsComponentType.coupling.getId());
		RexsComponent rexsComponent = new RexsComponent(rawComponent);

		rexsComponent.addAttribute(RexsAttributeId.account_for_gravity, Boolean.TRUE);

		assertThat(rexsComponent.getAttribute(RexsAttributeId.account_for_gravity).getBooleanValue()).isTrue();
	}

	@Test
	public void addAttribute_createAndAddsAttributeWithIntegerValue() throws Exception {
		Component rawComponent = new Component();
		rawComponent.setId(1);
		rawComponent.setType(RexsComponentType.coupling.getId());
		RexsComponent rexsComponent = new RexsComponent(rawComponent);

		rexsComponent.addAttribute(RexsAttributeId.account_for_gravity, 42);

		assertThat(rexsComponent.getAttribute(RexsAttributeId.account_for_gravity).getIntegerValue()).isEqualTo(42);
	}

	@Test
	public void addAttribute_createAndAddsAttributeWithFloatingPointValue() throws Exception {
		Component rawComponent = new Component();
		rawComponent.setId(1);
		rawComponent.setType(RexsComponentType.coupling.getId());
		RexsComponent rexsComponent = new RexsComponent(rawComponent);

		rexsComponent.addAttribute(RexsAttributeId.addendum_basic_profile, 8.15);

		assertThat(rexsComponent.getAttribute(RexsAttributeId.addendum_basic_profile).getDoubleValue(RexsUnitId.mm)).isEqualTo(8.15);
	}

	@Test
	public void addAttribute_createAndAddsAttributeWithStringArrayValue() throws Exception {
		Component rawComponent = new Component();
		rawComponent.setId(1);
		rawComponent.setType(RexsComponentType.coupling.getId());
		RexsComponent rexsComponent = new RexsComponent(rawComponent);

		rexsComponent.addAttribute(RexsAttributeId.account_for_gravity, new String[] {"foo", "bar"});

		assertThat(rexsComponent.getAttribute(RexsAttributeId.account_for_gravity).getStringArrayValue()).isEqualTo(new String[] {"foo", "bar"});
	}

	@Test
	public void addAttribute_createAndAddsAttributeWithBooleanArrayValue() throws Exception {
		Component rawComponent = new Component();
		rawComponent.setId(1);
		rawComponent.setType(RexsComponentType.coupling.getId());
		RexsComponent rexsComponent = new RexsComponent(rawComponent);

		rexsComponent.addAttribute(RexsAttributeId.account_for_gravity, new Boolean[] {Boolean.TRUE, Boolean.FALSE});

		assertThat(rexsComponent.getAttribute(RexsAttributeId.account_for_gravity).getBooleanArrayValue()).isEqualTo(new Boolean[] {Boolean.TRUE, Boolean.FALSE});
	}

	@Test
	public void addAttribute_createAndAddsAttributeWithIntegerArrayValue() throws Exception {
		Component rawComponent = new Component();
		rawComponent.setId(1);
		rawComponent.setType(RexsComponentType.coupling.getId());
		RexsComponent rexsComponent = new RexsComponent(rawComponent);

		rexsComponent.addAttribute(RexsAttributeId.account_for_gravity, new Integer[] {8, 15});

		assertThat(rexsComponent.getAttribute(RexsAttributeId.account_for_gravity).getIntegerArrayValue()).isEqualTo(new Integer[] {8, 15});
	}

	@Test
	public void addAttribute_createAndAddsAttributeWithFloatingPointArrayValue() throws Exception {
		Component rawComponent = new Component();
		rawComponent.setId(1);
		rawComponent.setType(RexsComponentType.coupling.getId());
		RexsComponent rexsComponent = new RexsComponent(rawComponent);

		rexsComponent.addAttribute(RexsAttributeId.overrolling_frequency_inner_ring, new Double[] {23.33, 24.8});

		assertThat(rexsComponent.getAttribute(RexsAttributeId.overrolling_frequency_inner_ring).getDoubleArrayValue(RexsUnitId.hertz)).isEqualTo(new Double[] {23.33, 24.8});
	}

	@Test
	public void addAttribute_createAndAddsAttributeWithStringMatrixValue() throws Exception {
		Component rawComponent = new Component();
		rawComponent.setId(1);
		rawComponent.setType(RexsComponentType.coupling.getId());
		RexsComponent rexsComponent = new RexsComponent(rawComponent);

		rexsComponent.addAttribute(RexsAttributeId.account_for_gravity, new String[][] {{"foo"}, {"bar"}});

		assertThat(rexsComponent.getAttribute(RexsAttributeId.account_for_gravity).getStringMatrixValue()).isEqualTo(new String[][] {{"foo"}, {"bar"}});
	}

	@Test
	public void addAttribute_createAndAddsAttributeWithBooleanMatrixValue() throws Exception {
		Component rawComponent = new Component();
		rawComponent.setId(1);
		rawComponent.setType(RexsComponentType.coupling.getId());
		RexsComponent rexsComponent = new RexsComponent(rawComponent);

		rexsComponent.addAttribute(RexsAttributeId.account_for_gravity, new Boolean[][] {{Boolean.TRUE}, {Boolean.FALSE}});

		assertThat(rexsComponent.getAttribute(RexsAttributeId.account_for_gravity).getBooleanMatrixValue()).isEqualTo(new Boolean[][] {{Boolean.TRUE}, {Boolean.FALSE}});
	}

	@Test
	public void addAttribute_createAndAddsAttributeWithIntegerMatrixValue() throws Exception {
		Component rawComponent = new Component();
		rawComponent.setId(1);
		rawComponent.setType(RexsComponentType.coupling.getId());
		RexsComponent rexsComponent = new RexsComponent(rawComponent);

		rexsComponent.addAttribute(RexsAttributeId.account_for_gravity, new Integer[][] {{8}, {15}});

		assertThat(rexsComponent.getAttribute(RexsAttributeId.account_for_gravity).getIntegerMatrixValue()).isEqualTo(new Integer[][] {{8}, {15}});
	}

	@Test
	public void addAttribute_createAndAddsAttributeWithFloatingPointMatrixValue() throws Exception {
		Component rawComponent = new Component();
		rawComponent.setId(1);
		rawComponent.setType(RexsComponentType.coupling.getId());
		RexsComponent rexsComponent = new RexsComponent(rawComponent);

		rexsComponent.addAttribute(RexsAttributeId.addendum_modification, new Double[][] {{23.33}, {24.8}});

		assertThat(rexsComponent.getAttribute(RexsAttributeId.addendum_modification).getDoubleMatrixValue(RexsUnitId.mm)).isEqualTo(new Double[][] {{23.33}, {24.8}});
	}

	@Test
	public void changeComponentId_changesIdOfComponent() throws Exception {
		Component rawComponent = new Component();
		rawComponent.setId(1);
		RexsComponent rexsComponent = new RexsComponent(rawComponent);

		rexsComponent.changeComponentId(2);

		assertThat(rexsComponent.getId()).isEqualTo(2);
		assertThat(rexsComponent.getRawComponent().getId()).isEqualTo(2);
	}

	@Test
	public void compareTo_comparesById() throws Exception {
		Component rawComponent23 = new Component();
		rawComponent23.setId(23);
		RexsComponent rexsComponent23 = new RexsComponent(rawComponent23);

		Component rawComponent42 = new Component();
		rawComponent42.setId(42);
		RexsComponent rexsComponent42 = new RexsComponent(rawComponent42);

		assertThat(rexsComponent23.compareTo(rexsComponent42)).isLessThan(0);
		assertThat(rexsComponent42.compareTo(rexsComponent23)).isGreaterThan(0);
		assertThat(rexsComponent23.compareTo(rexsComponent23)).isEqualTo(0);
		assertThat(rexsComponent42.compareTo(rexsComponent42)).isEqualTo(0);
	}

	@Test
	public void deleteAttribute_notIncludedAttributeIsIgnored() throws Exception {
		Attribute rawAttribute = new Attribute();
		rawAttribute.setId(RexsAttributeId.overrolling_frequency_inner_ring.getId());
		rawAttribute.setUnit(RexsUnitId.hertz.getId());

		Component rawComponent = new Component();
		rawComponent.setId(1);
		rawComponent.setType(RexsComponentType.coupling.getId());
		rawComponent.getAttribute().add(rawAttribute);

		RexsComponent rexsComponent = new RexsComponent(rawComponent);
		rexsComponent.deleteAttribute(RexsAttributeId.number_of_gears);

		assertThat(rexsComponent.getAttributes().size()).isEqualTo(1);
		assertThat(rexsComponent.hasAttribute(RexsAttributeId.overrolling_frequency_inner_ring)).isTrue();
	}

	@Test
	public void deleteAttribute_deletesIncludedAttribute() throws Exception {
		Attribute rawAttribute = new Attribute();
		rawAttribute.setId(RexsAttributeId.overrolling_frequency_inner_ring.getId());
		rawAttribute.setUnit(RexsUnitId.hertz.getId());

		Component rawComponent = new Component();
		rawComponent.setId(1);
		rawComponent.setType(RexsComponentType.coupling.getId());
		rawComponent.getAttribute().add(rawAttribute);

		RexsComponent rexsComponent = new RexsComponent(rawComponent);
		rexsComponent.deleteAttribute(RexsAttributeId.overrolling_frequency_inner_ring);

		assertThat(rexsComponent.getAttributes().isEmpty()).isTrue();
		assertThat(rexsComponent.hasAttribute(RexsAttributeId.overrolling_frequency_inner_ring)).isFalse();
	}

	@Test
	public void equals_equalObjects() {
		Component rawComponent1 = new Component();
		rawComponent1.setId(1);
		RexsComponent rexsComponent1 = new RexsComponent(rawComponent1);

		Component rawComponent2 = new Component();
		rawComponent2.setId(1);
		RexsComponent rexsComponent2 = new RexsComponent(rawComponent2);

		assertThat(rexsComponent1.equals(rexsComponent1)).isTrue();
		assertThat(rexsComponent1).isEqualTo(rexsComponent2);
	}

	@Test
	public void equals_notEqualObjects() {
		Component rawComponent1 = new Component();
		rawComponent1.setId(1);
		RexsComponent rexsComponent1 = new RexsComponent(rawComponent1);

		Component rawComponent2 = new Component();
		rawComponent1.setId(2);
		RexsComponent rexsComponent2 = new RexsComponent(rawComponent2);

		assertThat(rexsComponent1).isNotEqualTo(rexsComponent2);
		assertThat(rexsComponent1).isNotEqualTo("1");
	}

	@Test
	public void isOfType_checkAgainstSeveralTypes() {
		Component rawComponent1 = new Component();
		rawComponent1.setId(1);
		rawComponent1.setType(RexsComponentType.cylindrical_gear.getId());
		RexsComponent rexsComponent1 = new RexsComponent(rawComponent1);

		assertThat(rexsComponent1.isOfType(RexsComponentType.cylindrical_gear)).isTrue();
		assertThat(rexsComponent1.isOfType(RexsComponentType.cylindrical_gear, RexsComponentType.ring_gear)).isTrue();
		assertThat(rexsComponent1.isOfType(RexsComponentType.ring_gear)).isFalse();
		assertThat(rexsComponent1.isOfType(RexsComponentType.bevel_gear, RexsComponentType.ring_gear)).isFalse();
	}
}
