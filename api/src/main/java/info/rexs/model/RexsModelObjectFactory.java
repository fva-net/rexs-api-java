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

import info.rexs.db.constants.RexsAttributeId;
import info.rexs.db.constants.RexsComponentType;
import info.rexs.db.constants.RexsRelationRole;
import info.rexs.db.constants.RexsRelationType;
import info.rexs.db.constants.RexsVersion;

/**
 * TODO Document me!
 *
 * @author FVA GmbH
 */
public class RexsModelObjectFactory {

	private static RexsModelObjectFactory instance = new RexsModelObjectFactory();

	/**
	 * TODO Document me!
	 *
	 * @param newInstance
	 * 				TODO Document me!
	 */
	public static void setInstance(RexsModelObjectFactory newInstance) {
		instance = newInstance;
	}

	/**
	 * TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public static RexsModelObjectFactory getInstance() {
		return instance;
	}

	/**
	 * Creates a new {@link RexsModel} for the given properties.
	 *
	 * @param version
	 * 				The version of the REXS model as a{@link String}.
	 * @param applicationId
	 * 				Name of the application that created the REXS model, e.g. "FVA Workbench".
	 * @param applicationVersion
	 * 				Version of the application.
	 *
	 * @return
	 * 				The created model.
	 */
	public RexsModel createRexsModel(String version, String applicationId, String applicationVersion) {
		return new RexsModel(version, applicationId, applicationVersion);
	}

	/**
	 * Creates a new {@link RexsModel} for the given properties.
	 *
	 * @param version
	 * 				The version of the REXS model as a{@link RexsVersion}.
	 * @param applicationId
	 * 				Name of the application that created the REXS model, e.g. "FVA Workbench".
	 * @param applicationVersion
	 * 				Version of the application.
	 *
	 * @return
	 * 				The created model.
	 */
	public RexsModel createRexsModel(RexsVersion version, String applicationId, String applicationVersion) {
		return new RexsModel(version, applicationId, applicationVersion);
	}

	/**
	 * Creates a new {@link RexsComponent} for the given properties.
	 *
	 * @param id
	 * 				The numeric ID of the component as an {@link Integer}.
	 * @param type
	 * 				The type of the component as a {@link String}.
	 * @param name
	 * 				The name of the component as a {@link String}.
	 *
	 * @return
	 * 				The created component.
	 */
	public RexsComponent createRexsComponent(Integer id, String type, String name) {
		return new RexsComponent(id, type, name);
	}

	/**
	 * Creates a new {@link RexsComponent} for the given properties.
	 *
	 * @param id
	 * 				The numeric ID of the component as an {@link Integer}.
	 * @param type
	 * 				The type of the component as a {@link RexsComponentType}.
	 * @param name
	 * 				The name of the component as a {@link String}.
	 *
	 * @return
	 * 				The created component.
	 */
	public RexsComponent createRexsComponent(Integer id, RexsComponentType type, String name) {
		return new RexsComponent(id, type, name);
	}

	/**
	 * Creates a new {@link RexsAttribute} for the given properties.
	 *
	 * @param id
	 * 				The ID of the attribute as a {@link String}.
	 * @param unit
	 * 				The unit of the attribute as a {@link String}.
	 *
	 * @return
	 * 				The created attribute.
	 */
	public RexsAttribute createRexsAttribute(String id, String unit) {
		return new RexsAttribute(id, unit);
	}

	/**
	 * Creates a new {@link RexsAttribute} for the given properties.
	 *
	 * @param id
	 * 				The ID of the attribute as a {@link String}.
	 *
	 * @return
	 * 				The created attribute.
	 */
	public RexsAttribute createRexsAttribute(String id) {
		return new RexsAttribute(id);
	}

	/**
	 * Creates a new {@link RexsAttribute} from scratch.
	 *
	 * @param id
	 * 				The ID of the attribute.
	 *
	 * @return
	 * 				The created attribute.
	 */
	public RexsAttribute createRexsAttribute(RexsAttributeId id) {
		return new RexsAttribute(id);
	}

	/**
	 * Creates a new {@link RexsRelation} for the given properties.
	 *
	 * @param id
	 * 				The ID of the relation as a {@link Integer}.
	 * @param type
	 * 				The type of the relation as a {@link String}.
	 * @param order
	 * 				The order of the relation as a {@link Integer}.
	 *
	 * @return
	 * 				The created relation.
	 */
	public RexsRelation createRexsRelation(Integer id, String type, Integer order) {
		return new RexsRelation(id, type, order);
	}

	/**
	 * Creates a new {@link RexsRelation} for the given properties.
	 *
	 * @param id
	 * 				The ID of the relation as a {@link Integer}.
	 * @param type
	 * 				The type of the relation as a {@link RexsRelationType}.
	 * @param order
	 * 				The order of the relation as a {@link Integer}.
	 *
	 * @return
	 * 				The created relation.
	 */
	public RexsRelation createRexsRelation(Integer id, RexsRelationType type, Integer order) {
		return new RexsRelation(id, type, order);
	}

	/**
	 * Creates a new {@link RexsRelationRef} for the given properties.
	 *
	 * @param id
	 * 				The ID of the relation reference as a {@link Integer}.
	 * @param role
	 * 				The role of the relation reference as a {@link String}.
	 * @param hint
	 * 				The hint of the relation reference as a {@link String}.
	 *
	 * @return
	 * 				The created relation reference.
	 */
	public RexsRelationRef createRexsRelationRef(Integer id, String role, String hint) {
		return new RexsRelationRef(id, role, hint);
	}

	/**
	 * Creates a new {@link RexsRelationRef} for the given properties.
	 *
	 * @param id
	 * 				The ID of the relation reference as a {@link Integer}.
	 * @param role
	 * 				The role of the relation reference as a {@link RexsRelationRole}.
	 * @param hint
	 * 				The hint of the relation reference as a {@link String}.
	 *
	 * @return
	 * 				The created relation reference.
	 */
	public RexsRelationRef createRexsRelationRef(Integer id, RexsRelationRole role, String hint) {
		return new RexsRelationRef(id, role, hint);
	}

	/**
	 * Creates a new {@link RexsLoadSpectrum} for the given properties.
	 *
	 * @param id
	 * 				The ID of the load spectrum as an {@link Integer}.
	 *
	 * @return
	 * 				The created load spectrum.
	 */
	public RexsLoadSpectrum createRexsLoadSpectrum(Integer id) {
		return new RexsLoadSpectrum(id);
	}

	/**
	 * Creates a new {@link RexsSubModel} for the given properties.
	 *
	 * @param id
	 * 				The numeric ID of the sub-model within the REXS model.
	 * @param isAccumulation
	 * 				Flag whether it is an accumulation.
	 *
	 * @return
	 * 				The created sub-model.
	 */
	public RexsSubModel createRexsSubModel(Integer id, boolean isAccumulation) {
		return new RexsSubModel(id, isAccumulation);
	}

	/**
	 * Creates a new {@link RexsSubModel} for a load case.
	 *
	 * @param id
	 * 				The numeric ID of the sub-model within the REXS model.
	 *
	 * @return
	 * 				The created sub-model.
	 */
	public RexsSubModel createRexsSubModel(Integer id) {
		return new RexsSubModel(id);
	}

	/**
	 * Creates a new {@link RexsSubModel} for an accumilation.
	 *
	 * @return
	 * 				The created sub-model.
	 */
	public RexsSubModel createRexsSubModel() {
		return new RexsSubModel();
	}

	public RexsAttribute copyAttribute(RexsAttribute attribute) {
		RexsAttribute copy = attribute.getOriginUnit() != null ?
			createRexsAttribute(attribute.getOriginAttributeId(), attribute.getOriginUnit())
			: createRexsAttribute(attribute.getOriginAttributeId());

		if (attribute.hasValue())
			copy.setRawValue(attribute.getRawValue().copy());

		return copy;
	}
}
