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
package info.rexs.schema;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import info.rexs.schema.constants.RexsAttributeId;
import info.rexs.schema.constants.RexsComponentType;
import info.rexs.schema.constants.RexsUnitId;
import info.rexs.schema.constants.RexsVersion;
import info.rexs.schema.constants.standard.RexsStandardVersions;
import info.rexs.schema.jaxb.Attribute;
import info.rexs.schema.jaxb.Component;
import info.rexs.schema.jaxb.RexsSchema;
import info.rexs.schema.jaxb.Unit;
import info.rexs.schema.jaxb.ValueType;

public class RexsSchemaResolverTest {

	@Test
	public void resolve_unknownRexsSchemaFileReturnsNull() throws Exception {
		RexsVersion newVersion = RexsVersion.create("r.s", 10000);
		assertThat(RexsSchemaResolver.getInstance().resolve(newVersion)).isNull();

		assertThat(RexsSchemaResolver.getInstance().resolve(null)).isNull();
	}

	@Test
	public void resolve_invalidRexsSchemaFileResolverThrowsIllegalStateException() throws Exception {
		RexsVersion newVersion = RexsVersion.create("s.t", 11000);
		RexsSchemaFile.create(newVersion, new RexsSchemaFileResolver() {
			@Override
			public InputStream openInputStream(RexsSchemaFile rexsSchemaFile) {
				return null;
			}
		});

		assertThatIllegalStateException()
			.isThrownBy(() -> {
				RexsSchemaResolver.getInstance().resolve(newVersion);
			})
			.withMessageStartingWith("could not load rexs schema for version");
	}

	@Test
	public void resolve_cachingReturnsSameObjectForMultipleCalls() throws Exception {
		RexsSchema rexsModel1 = RexsSchemaResolver.getInstance().resolve(RexsVersion.getLatest());
		RexsSchema rexsModel2 = RexsSchemaResolver.getInstance().resolve(RexsVersion.getLatest());

		assertThat(rexsModel1).isSameAs(rexsModel2);
	}

	@Test
	public void resolve_everyRexsStandardVersionHasRexsSchema() throws Exception {
		List<RexsVersion> rexsStandardVersions = Stream.of(RexsStandardVersions.V1_0, RexsStandardVersions.V1_1, RexsStandardVersions.V1_2).collect(Collectors.toList());
		for (RexsVersion version : rexsStandardVersions) {
			RexsSchema rexsModel = RexsSchemaResolver.getInstance().resolve(version);
			assertThat(rexsModel.getVersion()).isEqualTo(version.getName());

			for (Unit unit : rexsModel.getUnits().getUnit()) {
				assertThat(RexsUnitId.findById(unit.getName())).isNotNull();
			}

			for (ValueType valueType : rexsModel.getValueTypes().getValueType()) {
				assertThat(info.rexs.schema.constants.RexsValueType.findByKey(valueType.getName())).isNotNull();
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
