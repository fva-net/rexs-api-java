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

/**
 * TODO Document me!
 *
 * @author FVA GmbH
 */
public class RexsRelationData {

	/** TODO Document me! */
	private Integer id;

	/** TODO Document me! */
	private String hint;

	/**
	 * TODO Document me!
	 *
	 * @param id
	 * 				TODO Document me!
	 * @param hint
	 * 				TODO Document me!
	 */
	public RexsRelationData(Integer id, String hint) {
		this.id = id;
		this.hint = hint;
	}

	/**
	 * @return
	 * 				TODO Document me!
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return
	 * 				TODO Document me!
	 */
	public String getHint() {
		return hint;
	}
}
