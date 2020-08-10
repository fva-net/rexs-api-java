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
package info.rexs.db.constants;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import org.junit.Test;

public class RelationTypeTest {

	@Test
	public void getKey_notNullAndNotEmpty() throws Exception {
		Stream.of(RelationType.values()).forEach(relationType -> {
			assertThat(relationType.getKey()).isNotNull();
			assertThat(relationType.getKey()).isNotEmpty();
		});
	}

	@Test
	public void getKey_returnsUniqueKey() throws Exception {
		Set<String> usedKeys = new HashSet<>();
		Stream.of(RelationType.values()).forEach(relationType -> {
			assertThat(usedKeys).doesNotContain(relationType.getKey());
			usedKeys.add(relationType.getKey());
		});
	}

	@Test
	public void findByKey_givenNullReturnsNull() {
		assertThat(RelationType.findByKey(null)).isNull();
	}

	@Test
	public void findByKey_givenUnknownIdReturnsNull() {
		assertThat(RelationType.findByKey("foo_bar")).isNull();
	}

	@Test
	public void findByKey_returnsCorrectRelationType() throws Exception {
		RelationType relationType = RelationType.findByKey(RelationType.PLANET_CARRIER_SHAFT.getKey());
		assertThat(relationType).isNotNull();
		assertThat(relationType).isEqualTo(RelationType.PLANET_CARRIER_SHAFT);
	}
}
