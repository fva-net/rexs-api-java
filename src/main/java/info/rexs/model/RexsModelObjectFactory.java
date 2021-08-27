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

import info.rexs.db.constants.RexsAttributeId;
import info.rexs.model.jaxb.Accumulation;
import info.rexs.model.jaxb.Attribute;
import info.rexs.model.jaxb.Component;
import info.rexs.model.jaxb.LoadCase;
import info.rexs.model.jaxb.LoadSpectrum;
import info.rexs.model.jaxb.Model;
import info.rexs.model.jaxb.Relation;

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
	 * TODO Document me!
	 *
	 * @param applicationId
	 * 				TODO Document me!
	 * @param applicationVersion
	 * 				TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public RexsModel createRexsModel(String applicationId, String applicationVersion) {
		return new RexsModel(applicationId, applicationVersion);
	}

	/**
	 * TODO Document me!
	 *
	 * @param rawModel
	 * 				TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public RexsModel createRexsModel(Model rawModel) {
		return new RexsModel(rawModel);
	}

	/**
	 * TODO Document me!
	 *
	 * @param rawComponent
	 * 				TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public RexsComponent createRexsComponent(Component rawComponent) {
		return new RexsComponent(rawComponent);
	}

	/**
	 * TODO Document me!
	 *
	 * @param rawAttribute
	 * 				TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public RexsAttribute createRexsAttribute(Attribute rawAttribute) {
		return new RexsAttribute(rawAttribute);
	}

	/**
	 * TODO Document me!
	 *
	 * @param attributeId
	 * 				TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public RexsAttribute createRexsAttribute(RexsAttributeId attributeId) {
		return new RexsAttribute(attributeId);
	}

	/**
	 * TODO Document me!
	 *
	 * @param rawRelation
	 * 				TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public RexsRelation createRexsRelation(Relation rawRelation) {
		return new RexsRelation(rawRelation);
	}

	/**
	 * TODO Document me!
	 *
	 * @param id
	 * 				TODO Document me!
	 * @param hint
	 * 				TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public RexsRelationData createRexsRelationData(Integer id, String hint) {
		return new RexsRelationData(id, hint);
	}

	/**
	 * TODO Document me!
	 *
	 * @param rawLoadSpectrum
	 * 				TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public RexsLoadSpectrum createRexsLoadSpectrum(LoadSpectrum rawLoadSpectrum) {
		return new RexsLoadSpectrum(rawLoadSpectrum);
	}

	/**
	 * TODO Document me!
	 *
	 * @param rawLoadCase
	 * 				TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public RexsSubModel createRexsSubModel(LoadCase rawLoadCase) {
		return new RexsSubModel(rawLoadCase);
	}

	/**
	 * TODO Document me!
	 *
	 * @param rawAccumulation
	 * 				TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public RexsSubModel createRexsSubModel(Accumulation rawAccumulation) {
		return new RexsSubModel(rawAccumulation);
	}
}
