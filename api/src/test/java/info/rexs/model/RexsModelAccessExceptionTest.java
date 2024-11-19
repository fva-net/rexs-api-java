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

import java.util.UUID;

import org.junit.Test;

import info.rexs.schema.constants.RexsComponentType;
import info.rexs.schema.constants.standard.RexsStandardComponentTypes;

public class RexsModelAccessExceptionTest {

	@Test
	public void messageConstructor_getterMatchesValuePassedToConstructor() {
		String message = UUID.randomUUID().toString();
		RexsModelAccessException ex = new RexsModelAccessException(message);

		assertThat(ex.getMessage()).isEqualTo(message);
		assertThat(ex.getComponentId()).isEqualTo(RexsModelAccessException.DEFAULT_COMPONENT_ID_EMPTY);
		assertThat(ex.getComponentName()).isEqualTo(RexsModelAccessException.DEFAULT_COMPONENT_NAME_EMPTY);
	}

	@Test
	public void messageAndCauseConstructor_getterMatchesValuePassedToConstructor() {
		Exception cause = new Exception("foo");
		RexsModelAccessException ex = new RexsModelAccessException("bar", cause);

		assertThat(ex.getMessage()).isEqualTo("bar");
		assertThat(ex.getCause()).isEqualTo(cause);
		assertThat(ex.getComponentId()).isEqualTo(RexsModelAccessException.DEFAULT_COMPONENT_ID_EMPTY);
		assertThat(ex.getComponentName()).isEqualTo(RexsModelAccessException.DEFAULT_COMPONENT_NAME_EMPTY);
	}

	@Test
	public void componentAndmessageConstructor_getterMatchesValuePassedToConstructor() {
		Integer id = 15;
		RexsComponentType type = RexsStandardComponentTypes.UNKNOWN;
		String name = "SampleComponent";
		RexsComponent component = new RexsComponent(id, type, name);
		String message = UUID.randomUUID().toString();
		RexsModelAccessException ex = new RexsModelAccessException(component, message);

		assertThat(ex.getMessage()).isEqualTo(message);
		assertThat(ex.getComponentId()).isEqualTo(15);
		assertThat(ex.getComponentName()).isEqualTo("SampleComponent");
	}

	@Test
	public void componentAndmessageAndCauseConstructor_getterMatchesValuePassedToConstructor() {
		Integer id = 15;
		RexsComponentType type = RexsStandardComponentTypes.UNKNOWN;
		String name = "SampleComponent";
		RexsComponent component = new RexsComponent(id, type, name);
		Exception cause = new Exception("foo");
		RexsModelAccessException ex = new RexsModelAccessException(component, "bar", cause);

		assertThat(ex.getMessage()).isEqualTo("bar");
		assertThat(ex.getCause()).isEqualTo(cause);
		assertThat(ex.getComponentId()).isEqualTo(15);
		assertThat(ex.getComponentName()).isEqualTo("SampleComponent");
	}
}
