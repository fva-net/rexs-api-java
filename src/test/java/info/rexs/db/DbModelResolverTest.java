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
package info.rexs.db;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import info.rexs.db.constants.RexsAttributeId;
import info.rexs.db.constants.RexsComponentType;
import info.rexs.db.constants.RexsUnitId;
import info.rexs.db.constants.RexsVersion;
import info.rexs.db.jaxb.Attribute;
import info.rexs.db.jaxb.Component;
import info.rexs.db.jaxb.RexsModel;
import info.rexs.db.jaxb.Unit;
import info.rexs.db.jaxb.ValueType;

public class DbModelResolverTest {

	@Test
	public void resolve_unknownDbModelFileReturnsNull() throws Exception {
		RexsVersion newVersion = RexsVersion.create("r.s");
		assertThat(DbModelResolver.getInstance().resolve(newVersion, Locale.getDefault())).isNull();

		assertThat(DbModelResolver.getInstance().resolve(null)).isNull();
	}

	@Test
	public void resolve_invalidDbModelFileResolverThrowsIllegalStateException() throws Exception {
		RexsVersion newVersion = RexsVersion.create("s.t");
		DbModelFile.create(newVersion, Locale.GERMAN, new DbModelFileResolver() {
			@Override
			public InputStream openInputStream(DbModelFile dbModelFile) {
				return null;
			}
		});

		assertThatIllegalStateException()
			.isThrownBy(() -> {
				DbModelResolver.getInstance().resolve(newVersion, Locale.GERMAN);
			})
			.withMessageStartingWith("could not load rexs db model for version");
	}

	@Test
	public void resolve_cachingReturnsSameObjectForMultipleCalls() throws Exception {
		RexsModel rexsModel1 = DbModelResolver.getInstance().resolve(RexsVersion.getLatest(), Locale.ENGLISH);
		RexsModel rexsModel2 = DbModelResolver.getInstance().resolve(RexsVersion.getLatest(), Locale.ENGLISH);

		assertThat(rexsModel1).isSameAs(rexsModel2);
	}

	@Test
	public void resolve_everyRexsStandardVersionHasDbModel() throws Exception {
		List<RexsVersion> rexsStandardVersions = Stream.of(RexsVersion.V1_0, RexsVersion.V1_1, RexsVersion.V1_2).collect(Collectors.toList());
		for (RexsVersion version : rexsStandardVersions) {
			RexsModel rexsModelEn = DbModelResolver.getInstance().resolve(version, Locale.ENGLISH);
			assertThat(rexsModelEn.getVersion()).isEqualTo(version.getName());

			RexsModel rexsModelDe = DbModelResolver.getInstance().resolve(version, Locale.GERMAN);
			assertThat(rexsModelDe.getVersion()).isEqualTo(version.getName());

			assertThat(rexsModelEn.getUnits().getUnit().size()).isEqualTo(rexsModelDe.getUnits().getUnit().size());
			List<String> ids = new ArrayList<>();
			for (Unit unit : rexsModelEn.getUnits().getUnit()) {
				assertThat(RexsUnitId.findById(unit.getName())).isNotNull();
				ids.add(unit.getName());
			}
			for (Unit unit : rexsModelDe.getUnits().getUnit()) {
				assertThat(ids).contains(unit.getName());
			}

			assertThat(rexsModelEn.getValueTypes().getValueType().size()).isEqualTo(rexsModelEn.getValueTypes().getValueType().size());
			ids.clear();
			for (ValueType valueType : rexsModelEn.getValueTypes().getValueType()) {
				assertThat(info.rexs.db.constants.RexsValueType.findByKey(valueType.getName())).isNotNull();
				ids.add(valueType.getName());
			}
			for (ValueType valueType : rexsModelDe.getValueTypes().getValueType()) {
				assertThat(ids).contains(valueType.getName());
			}

			assertThat(rexsModelEn.getComponents().getComponent().size()).isEqualTo(rexsModelDe.getComponents().getComponent().size());
			ids.clear();
			for (Component component : rexsModelEn.getComponents().getComponent()) {
				assertThat(RexsComponentType.findById(component.getComponentId())).isNotNull();
				ids.add(component.getComponentId());
			}
			for (Component component : rexsModelDe.getComponents().getComponent()) {
				assertThat(ids).contains(component.getComponentId());
			}

			assertThat(rexsModelEn.getAttributes().getAttribute().size()).isEqualTo(rexsModelDe.getAttributes().getAttribute().size());
			ids.clear();
			for (Attribute attribute : rexsModelEn.getAttributes().getAttribute()) {
				assertThat(RexsAttributeId.findById(attribute.getAttributeId())).isNotNull();
				ids.add(attribute.getAttributeId());
			}
			for (Attribute attrbute : rexsModelDe.getAttributes().getAttribute()) {
				assertThat(ids).contains(attrbute.getAttributeId());
			}
		}
	}
}
