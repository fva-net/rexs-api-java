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
import java.util.List;
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
		RexsVersion newVersion = RexsVersion.create("r.s", 10000);
		assertThat(DbModelResolver.getInstance().resolve(newVersion)).isNull();

		assertThat(DbModelResolver.getInstance().resolve(null)).isNull();
	}

	@Test
	public void resolve_invalidDbModelFileResolverThrowsIllegalStateException() throws Exception {
		RexsVersion newVersion = RexsVersion.create("s.t", 11000);
		DbModelFile.create(newVersion, new DbModelFileResolver() {
			@Override
			public InputStream openInputStream(DbModelFile dbModelFile) {
				return null;
			}
		});

		assertThatIllegalStateException()
			.isThrownBy(() -> {
				DbModelResolver.getInstance().resolve(newVersion);
			})
			.withMessageStartingWith("could not load rexs db model for version");
	}

	@Test
	public void resolve_cachingReturnsSameObjectForMultipleCalls() throws Exception {
		RexsModel rexsModel1 = DbModelResolver.getInstance().resolve(RexsVersion.getLatest());
		RexsModel rexsModel2 = DbModelResolver.getInstance().resolve(RexsVersion.getLatest());

		assertThat(rexsModel1).isSameAs(rexsModel2);
	}

	@Test
	public void resolve_everyRexsStandardVersionHasDbModel() throws Exception {
		List<RexsVersion> rexsStandardVersions = Stream.of(RexsVersion.V1_0, RexsVersion.V1_1, RexsVersion.V1_2).collect(Collectors.toList());
		for (RexsVersion version : rexsStandardVersions) {
			RexsModel rexsModel = DbModelResolver.getInstance().resolve(version);
			assertThat(rexsModel.getVersion()).isEqualTo(version.getName());

			for (Unit unit : rexsModel.getUnits().getUnit()) {
				assertThat(RexsUnitId.findById(unit.getName())).isNotNull();
			}

			for (ValueType valueType : rexsModel.getValueTypes().getValueType()) {
				assertThat(info.rexs.db.constants.RexsValueType.findByKey(valueType.getName())).isNotNull();
			}

			for (Component component : rexsModel.getComponents().getComponent()) {
				assertThat(RexsComponentType.findById(component.getComponentId())).isNotNull();
			}

			for (Attribute attribute : rexsModel.getAttributes().getAttribute()) {
				assertThat(RexsAttributeId.findById(attribute.getAttributeId())).isNotNull();
			}
		}
	}
}
