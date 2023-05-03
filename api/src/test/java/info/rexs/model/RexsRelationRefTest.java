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

import info.rexs.db.constants.RexsRelationRole;

public class RexsRelationRefTest {

	@Test
	public void integerStringConstructor_getterMatchesValuePassedToConstructor() throws Exception {
		RexsRelationRef rexsRelationData = new RexsRelationRef(42, RexsRelationRole.UNKNOWN, "foo bar");

		assertThat(rexsRelationData.getId()).isEqualTo(42);
		assertThat(rexsRelationData.getHint()).isEqualTo("foo bar");
	}
}
