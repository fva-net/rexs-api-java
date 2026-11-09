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

import info.rexs.schema.constants.RexsRelationRole;
import lombok.Getter;
import lombok.Setter;

/**
 * This class represents a relation reference of a REXS model.
 *
 * @author FVA GmbH
 */
@Getter
public class RexsRelationRef {

	/**
	 * The numeric ID of the relation reference as an {@link Integer}.
	 */
	@Setter
	private Integer id;

	/**
	 * The role of the relation reference as a {@link RexsRelationRole}.
	 */
	@Setter
	private RexsRelationRole role;

	/**
	 * Optional note for better readability of the relation reference.
	 */
	private final String hint;

	/**
	 * Constructs a new {@link RexsRelationRef} for the given properties.
	 *
	 * @param id
	 * 				The ID of the relation reference as a {@link Integer}.
	 * @param role
	 * 				The role of the relation reference as a {@link String}.
	 * @param hint
	 * 				The hint of the relation reference as a {@link String}.
	 */
	public RexsRelationRef(Integer id, String role, String hint) {
		this.id = id;
		this.role = RexsRelationRole.findByKey(role);
		if (this.role==null)
			throw new RexsModelAccessException("Invalid RexsRelationRole: "+role);
		this.hint = hint;
	}

	/**
	 * Constructs a new {@link RexsRelationRef} for the given properties.
	 *
	 * @param id
	 * 				The ID of the relation reference as a {@link Integer}.
	 * @param role
	 * 				The role of the relation reference as a {@link RexsRelationRole}.
	 * @param hint
	 * 				The hint of the relation reference as a {@link String}.
	 */
	public RexsRelationRef(Integer id, RexsRelationRole role, String hint) {
		this.id = id;
		this.role = role;
		this.hint = hint;
	}

	/** copy constructor */
	public RexsRelationRef(RexsRelationRef reference) {
		this.id = reference.id;
		this.role = reference.role;
		this.hint = reference.hint;
	}


}
