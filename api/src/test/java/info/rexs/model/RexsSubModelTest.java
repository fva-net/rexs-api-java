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

import org.junit.Test;

import info.rexs.schema.constants.standard.RexsStandardComponentTypes;

public class RexsSubModelTest {

	@Test
	public void integerConstructor_getterMatchesValuePassedToConstructor() {
		RexsSubModel rexsSubModel = new RexsSubModel(41);

		assertThat(rexsSubModel.getId()).isEqualTo(41);
		assertThat(rexsSubModel.isAccumulation()).isFalse();
	}

	@Test
	public void loadCaseConstructor_getterMatchesValuePassedToConstructor() {
		RexsComponent rexsComponent = new RexsComponent(1, RexsStandardComponentTypes.UNKNOWN, "Foo");

		RexsSubModel rexsSubModel = new RexsSubModel(41);
		rexsSubModel.addComponent(rexsComponent);

		assertThat(rexsSubModel.getId()).isEqualTo(41);
		assertThat(rexsSubModel.hasComponent(1)).isTrue();
		assertThat(rexsSubModel.isAccumulation()).isFalse();
	}

	@Test
	public void accumulationConstructor_getterMatchesValuePassedToConstructor() {
		RexsComponent rexsComponent = new RexsComponent(1, RexsStandardComponentTypes.UNKNOWN, "Foo");

		RexsSubModel rexsSubModel = new RexsSubModel();
		rexsSubModel.addComponent(rexsComponent);

		assertThat(rexsSubModel.getId()).isNull();
		assertThat(rexsSubModel.hasComponent(1)).isTrue();
		assertThat(rexsSubModel.isAccumulation()).isTrue();
	}

	@Test
	public void accumulationConstructor_nullParameterDoesNotCrash() {
		RexsSubModel rexsSubModel = new RexsSubModel();

		assertThat(rexsSubModel.getId()).isNull();
		assertThat(rexsSubModel.hasComponent(1)).isFalse();
		assertThat(rexsSubModel.isAccumulation()).isTrue();
	}

	@Test
	public void hasComponent_componentNotInSubModelReturnsFalse() {
		RexsComponent rexsComponent = new RexsComponent(1, RexsStandardComponentTypes.UNKNOWN, "Foo");

		RexsSubModel rexsSubModel = new RexsSubModel(41);
		rexsSubModel.addComponent(rexsComponent);

		assertThat(rexsSubModel.hasComponent(2)).isFalse();
	}

	@Test
	public void hasComponent_componentInSubModelReturnsTrue() {
		RexsComponent rexsComponent = new RexsComponent(1, RexsStandardComponentTypes.UNKNOWN, "Foo");

		RexsSubModel rexsSubModel = new RexsSubModel(41);
		rexsSubModel.addComponent(rexsComponent);

		assertThat(rexsSubModel.hasComponent(1)).isTrue();
	}

	@Test
	public void getComponent_componentNotInSubModelReturnsNull() {
		RexsComponent rexsComponent = new RexsComponent(1, RexsStandardComponentTypes.UNKNOWN, "Foo");

		RexsSubModel rexsSubModel = new RexsSubModel(41);
		rexsSubModel.addComponent(rexsComponent);

		assertThat(rexsSubModel.getComponent(2)).isNull();
	}

	@Test
	public void getComponent_componentInSubModelReturnsComponent() {
		RexsComponent rexsComponent1 = new RexsComponent(1, RexsStandardComponentTypes.cylindrical_gear, "Foo");

		RexsSubModel rexsSubModel = new RexsSubModel(41);
		rexsSubModel.addComponent(rexsComponent1);

		RexsComponent rexsComponent2 = rexsSubModel.getComponent(1);
		assertThat(rexsComponent2).isNotNull();
		assertThat(rexsComponent2.getId()).isEqualTo(1);
		assertThat(rexsComponent2.getType()).isEqualTo(RexsStandardComponentTypes.cylindrical_gear);
	}

	@Test
	public void changeComponentId_nonExistingComponentIdIgnoresMethodCall() {
		RexsComponent rexsComponent1 = new RexsComponent(1, RexsStandardComponentTypes.cylindrical_gear, "Foo");
		RexsComponent rexsComponent2 = new RexsComponent(2, RexsStandardComponentTypes.bevel_gear, "Bar");

		RexsSubModel rexsSubModel = new RexsSubModel(41);
		rexsSubModel.addComponent(rexsComponent1);
		rexsSubModel.addComponent(rexsComponent2);
		rexsSubModel.changeComponentId(3, 4);

		assertThat(rexsSubModel.hasComponent(1)).isTrue();
		assertThat(rexsSubModel.hasComponent(2)).isTrue();
		assertThat(rexsSubModel.hasComponent(3)).isFalse();
		assertThat(rexsSubModel.hasComponent(4)).isFalse();
	}

	@Test
	public void changeComponentId_changesIdOfComponent() {
		RexsComponent rexsComponent1 = new RexsComponent(1, RexsStandardComponentTypes.cylindrical_gear, "Foo");
		RexsComponent rexsComponent2 = new RexsComponent(2, RexsStandardComponentTypes.bevel_gear, "Bar");

		RexsSubModel rexsSubModel = new RexsSubModel(41);
		rexsSubModel.addComponent(rexsComponent1);
		rexsSubModel.addComponent(rexsComponent2);
		rexsSubModel.changeComponentId(2, 3);

		assertThat(rexsSubModel.hasComponent(1)).isTrue();
		assertThat(rexsSubModel.hasComponent(2)).isFalse();
		assertThat(rexsSubModel.hasComponent(3)).isTrue();
	}

	@Test
	public void compareTo_accumulationIsAlwaysGreaterThanAnyOtherLoadCase() {
		RexsSubModel rexsSubModelAccumulation = new RexsSubModel();
		RexsSubModel rexsSubModelLoadCase1 = new RexsSubModel(1);
		RexsSubModel rexsSubModelLoadCase24 = new RexsSubModel(24);

		assertThat(rexsSubModelAccumulation.compareTo(rexsSubModelAccumulation)).isEqualTo(0);
		assertThat(rexsSubModelAccumulation.compareTo(rexsSubModelLoadCase1)).isEqualTo(1);
		assertThat(rexsSubModelAccumulation.compareTo(rexsSubModelLoadCase24)).isEqualTo(1);
		assertThat(rexsSubModelLoadCase1.compareTo(rexsSubModelAccumulation)).isEqualTo(-1);
		assertThat(rexsSubModelLoadCase24.compareTo(rexsSubModelAccumulation)).isEqualTo(-1);
	}

	@Test
	public void compareTo_comparesById() {
		RexsSubModel rexsSubModel23 = new RexsSubModel(23);
		RexsSubModel rexsSubModel24 = new RexsSubModel(24);

		assertThat(rexsSubModel23.compareTo(rexsSubModel24)).isLessThan(0);
		assertThat(rexsSubModel24.compareTo(rexsSubModel23)).isGreaterThan(0);
		assertThat(rexsSubModel23.compareTo(rexsSubModel23)).isEqualTo(0);
		assertThat(rexsSubModel24.compareTo(rexsSubModel24)).isEqualTo(0);
	}

	@Test
	public void equals_equalObjects() {
		RexsSubModel rexsSubModelAccumulation1 = new RexsSubModel();
		RexsSubModel rexsSubModelAccumulation2 = new RexsSubModel();
		RexsSubModel rexsSubModelLoadCase1 = new RexsSubModel(1);
		RexsSubModel rexsSubModelLoadCase2 = new RexsSubModel(1);

		assertThat(rexsSubModelAccumulation1.equals(rexsSubModelAccumulation1)).isTrue();
		assertThat(rexsSubModelAccumulation1).isEqualTo(rexsSubModelAccumulation2);

		assertThat(rexsSubModelLoadCase1.equals(rexsSubModelLoadCase1)).isTrue();
		assertThat(rexsSubModelLoadCase1).isEqualTo(rexsSubModelLoadCase2);
	}

	@Test
	public void equals_notEqualObjects() {
		RexsSubModel rexsSubModelAccumulation = new RexsSubModel();
		RexsSubModel rexsSubModelLoadCase1 = new RexsSubModel(1);
		RexsSubModel rexsSubModelLoadCase24 = new RexsSubModel(24);

		assertThat(rexsSubModelAccumulation).isNotEqualTo(rexsSubModelLoadCase1);
		assertThat(rexsSubModelAccumulation).isNotEqualTo("1");
		assertThat(rexsSubModelLoadCase1).isNotEqualTo(rexsSubModelLoadCase24);
		assertThat(rexsSubModelLoadCase1).isNotEqualTo("1");
	}

	@Test
	public void copyConstructor_copiesIdAndAccumulationFlag() {
		RexsSubModel original = new RexsSubModel(41);
		RexsSubModel copy = new RexsSubModel(original);

		assertThat(copy.getId()).isEqualTo(original.getId());
		assertThat(copy.isAccumulation()).isEqualTo(original.isAccumulation());
	}

	@Test
	public void copyConstructor_copiesComponents() {
		RexsComponent rexsComponent = new RexsComponent(1, RexsStandardComponentTypes.UNKNOWN, "Foo");
		RexsSubModel original = new RexsSubModel(41);
		original.addComponent(rexsComponent);

		RexsSubModel copy = new RexsSubModel(original);

		assertThat(copy.hasComponent(1)).isTrue();
		assertThat(copy.getComponent(1)).isNotSameAs(rexsComponent);
		assertThat(copy.getComponent(1).getId()).isEqualTo(rexsComponent.getId());
		assertThat(copy.getComponent(1).getType()).isEqualTo(rexsComponent.getType());
	}

	@Test
	public void copyConstructor_handlesEmptyComponents() {
		RexsSubModel original = new RexsSubModel(41);
		RexsSubModel copy = new RexsSubModel(original);

		assertThat(copy.getComponents()).isEmpty();
	}

	@Test
	public void copyConstructor_handlesAccumulationSubModel() {
		RexsSubModel original = new RexsSubModel();
		RexsSubModel copy = new RexsSubModel(original);

		assertThat(copy.getId()).isNull();
		assertThat(copy.isAccumulation()).isTrue();
	}
}
