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
package info.rexs.upgrade;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.UUID;

import org.junit.Test;

public class RexsUpgradeExceptionTest {

	@Test
	public void messageConstructor_getterMatchesValuePassedToConstructor() throws Exception {
		String message = UUID.randomUUID().toString();
		RexsUpgradeException ex = new RexsUpgradeException(message);

		assertThat(ex.getMessage()).isEqualTo(message);
	}

	@Test
	public void messageAndCauseConstructor_getterMatchesValuePassedToConstructor() throws Exception {
		Exception cause = new Exception("foo");
		RexsUpgradeException ex = new RexsUpgradeException("bar", cause);

		assertThat(ex.getMessage()).isEqualTo("bar");
		assertThat(ex.getCause()).isEqualTo(cause);
	}
}
