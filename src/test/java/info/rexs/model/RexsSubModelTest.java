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

import org.junit.Test;

import info.rexs.db.constants.RexsComponentType;
import info.rexs.model.jaxb.Accumulation;
import info.rexs.model.jaxb.Component;
import info.rexs.model.jaxb.LoadCase;

public class RexsSubModelTest {

	@Test
	public void integerConstructor_getterMatchesValuePassedToConstructor() throws Exception {
		RexsSubModel rexsSubModel = new RexsSubModel(41);

		assertThat(rexsSubModel.getId()).isEqualTo(41);
		assertThat(rexsSubModel.isAccumulation()).isFalse();
	}

	@Test
	public void loadCaseConstructor_getterMatchesValuePassedToConstructor() throws Exception {
		Component rawComponent = new Component();
		rawComponent.setId(1);

		LoadCase loadCase = new LoadCase();
		loadCase.setId(41);
		loadCase.getComponent().add(rawComponent);

		RexsSubModel rexsSubModel = new RexsSubModel(loadCase);

		assertThat(rexsSubModel.getId()).isEqualTo(41);
		assertThat(rexsSubModel.hasComponent(1)).isTrue();
		assertThat(rexsSubModel.isAccumulation()).isFalse();
	}

	@Test
	public void accumulationConstructor_getterMatchesValuePassedToConstructor() throws Exception {
		Component rawComponent = new Component();
		rawComponent.setId(1);

		Accumulation rawAccumulation = new Accumulation();
		rawAccumulation.getComponent().add(rawComponent);

		RexsSubModel rexsSubModel = new RexsSubModel(rawAccumulation);

		assertThat(rexsSubModel.getId()).isNull();
		assertThat(rexsSubModel.hasComponent(1)).isTrue();
		assertThat(rexsSubModel.isAccumulation()).isTrue();
	}

	@Test
	public void accumulationConstructor_nullParameterDoesNotCrash() throws Exception {
		RexsSubModel rexsSubModel = new RexsSubModel((Accumulation)null);

		assertThat(rexsSubModel.getId()).isNull();
		assertThat(rexsSubModel.hasComponent(1)).isFalse();
		assertThat(rexsSubModel.isAccumulation()).isTrue();
	}

	@Test
	public void hasComponent_componentNotInSubModelReturnsFalse() throws Exception {
		Component rawComponent = new Component();
		rawComponent.setId(1);

		LoadCase loadCase = new LoadCase();
		loadCase.setId(41);
		loadCase.getComponent().add(rawComponent);

		RexsSubModel rexsSubModel = new RexsSubModel(loadCase);

		assertThat(rexsSubModel.hasComponent(2)).isFalse();
	}

	@Test
	public void hasComponent_componentInSubModelReturnsTrue() throws Exception {
		Component rawComponent = new Component();
		rawComponent.setId(1);

		LoadCase loadCase = new LoadCase();
		loadCase.setId(41);
		loadCase.getComponent().add(rawComponent);

		RexsSubModel rexsSubModel = new RexsSubModel(loadCase);

		assertThat(rexsSubModel.hasComponent(1)).isTrue();
	}

	@Test
	public void getComponent_componentNotInSubModelReturnsNull() throws Exception {
		Component rawComponent = new Component();
		rawComponent.setId(1);

		LoadCase loadCase = new LoadCase();
		loadCase.setId(41);
		loadCase.getComponent().add(rawComponent);

		RexsSubModel rexsSubModel = new RexsSubModel(loadCase);

		assertThat(rexsSubModel.getComponent(2)).isNull();
	}

	@Test
	public void getComponent_componentInSubModelReturnsComponent() throws Exception {
		Component rawComponent = new Component();
		rawComponent.setId(1);
		rawComponent.setType(RexsComponentType.cylindrical_gear.getId());

		LoadCase loadCase = new LoadCase();
		loadCase.setId(41);
		loadCase.getComponent().add(rawComponent);

		RexsSubModel rexsSubModel = new RexsSubModel(loadCase);

		RexsComponent rexsComponent = rexsSubModel.getComponent(1);
		assertThat(rexsComponent).isNotNull();
		assertThat(rexsComponent.getId()).isEqualTo(1);
		assertThat(rexsComponent.getType()).isEqualTo(RexsComponentType.cylindrical_gear);
		assertThat(rexsComponent.getRawComponent()).isEqualTo(rawComponent);
	}

	@Test
	public void changeComponentId_nonExistingComponentIdIgnoresMethodCall() throws Exception {
		Component rawComponent1 = new Component();
		rawComponent1.setId(1);
		rawComponent1.setType(RexsComponentType.cylindrical_gear.getId());

		Component rawComponent2 = new Component();
		rawComponent2.setId(2);
		rawComponent2.setType(RexsComponentType.bevel_gear.getId());

		LoadCase loadCase = new LoadCase();
		loadCase.setId(41);
		loadCase.getComponent().add(rawComponent1);
		loadCase.getComponent().add(rawComponent2);

		RexsSubModel rexsSubModel = new RexsSubModel(loadCase);
		rexsSubModel.changeComponentId(3, 4);

		assertThat(rexsSubModel.hasComponent(1)).isTrue();
		assertThat(rexsSubModel.hasComponent(2)).isTrue();
		assertThat(rexsSubModel.hasComponent(3)).isFalse();
		assertThat(rexsSubModel.hasComponent(4)).isFalse();
	}

	@Test
	public void changeComponentId_changesIdOfComponent() throws Exception {
		Component rawComponent1 = new Component();
		rawComponent1.setId(1);
		rawComponent1.setType(RexsComponentType.cylindrical_gear.getId());

		Component rawComponent2 = new Component();
		rawComponent2.setId(2);
		rawComponent2.setType(RexsComponentType.bevel_gear.getId());

		LoadCase loadCase = new LoadCase();
		loadCase.setId(41);
		loadCase.getComponent().add(rawComponent1);
		loadCase.getComponent().add(rawComponent2);

		RexsSubModel rexsSubModel = new RexsSubModel(loadCase);
		rexsSubModel.changeComponentId(2, 3);

		assertThat(rexsSubModel.hasComponent(1)).isTrue();
		assertThat(rexsSubModel.hasComponent(2)).isFalse();
		assertThat(rexsSubModel.hasComponent(3)).isTrue();
	}

	@Test
	public void compareTo_accumulationIsAlwaysGreaterThanAnyOtherLoadCase() throws Exception {
		RexsSubModel rexsSubModelAccumulation = new RexsSubModel((Accumulation)null);
		RexsSubModel rexsSubModelLoadCase1 = new RexsSubModel(1);
		RexsSubModel rexsSubModelLoadCase24 = new RexsSubModel(24);

		assertThat(rexsSubModelAccumulation.compareTo(rexsSubModelAccumulation)).isEqualTo(0);
		assertThat(rexsSubModelAccumulation.compareTo(rexsSubModelLoadCase1)).isEqualTo(1);
		assertThat(rexsSubModelAccumulation.compareTo(rexsSubModelLoadCase24)).isEqualTo(1);
		assertThat(rexsSubModelLoadCase1.compareTo(rexsSubModelAccumulation)).isEqualTo(-1);
		assertThat(rexsSubModelLoadCase24.compareTo(rexsSubModelAccumulation)).isEqualTo(-1);
	}

	@Test
	public void compareTo_comparesById() throws Exception {
		RexsSubModel rexsSubModel23 = new RexsSubModel(23);
		RexsSubModel rexsSubModel24 = new RexsSubModel(24);

		assertThat(rexsSubModel23.compareTo(rexsSubModel24)).isLessThan(0);
		assertThat(rexsSubModel24.compareTo(rexsSubModel23)).isGreaterThan(0);
		assertThat(rexsSubModel23.compareTo(rexsSubModel23)).isEqualTo(0);
		assertThat(rexsSubModel24.compareTo(rexsSubModel24)).isEqualTo(0);
	}

	@Test
	public void equals_equalObjects() {
		RexsSubModel rexsSubModelAccumulation1 = new RexsSubModel((Accumulation)null);
		RexsSubModel rexsSubModelAccumulation2 = new RexsSubModel((Accumulation)null);
		RexsSubModel rexsSubModelLoadCase1 = new RexsSubModel(1);
		RexsSubModel rexsSubModelLoadCase2 = new RexsSubModel(1);

		assertThat(rexsSubModelAccumulation1.equals(rexsSubModelAccumulation1)).isTrue();
		assertThat(rexsSubModelAccumulation1).isEqualTo(rexsSubModelAccumulation2);

		assertThat(rexsSubModelLoadCase1.equals(rexsSubModelLoadCase1)).isTrue();
		assertThat(rexsSubModelLoadCase1).isEqualTo(rexsSubModelLoadCase2);
	}

	@Test
	public void equals_notEqualObjects() {
		RexsSubModel rexsSubModelAccumulation = new RexsSubModel((Accumulation)null);
		RexsSubModel rexsSubModelLoadCase1 = new RexsSubModel(1);
		RexsSubModel rexsSubModelLoadCase24 = new RexsSubModel(24);

		assertThat(rexsSubModelAccumulation).isNotEqualTo(rexsSubModelLoadCase1);
		assertThat(rexsSubModelAccumulation).isNotEqualTo("1");
		assertThat(rexsSubModelLoadCase1).isNotEqualTo(rexsSubModelLoadCase24);
		assertThat(rexsSubModelLoadCase1).isNotEqualTo("1");
	}
}
