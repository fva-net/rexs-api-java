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

import java.util.List;

import info.rexs.schema.constants.RexsComponentType;
import info.rexs.schema.constants.RexsRelationType;
import info.rexs.schema.constants.RexsUnitId;
import info.rexs.schema.constants.RexsValueType;
import info.rexs.schema.constants.RexsVersion;
import info.rexs.schema.jaxb.AllowedCombinationRole;

/**
 * This interface offers methods to check meta information of a REXS version,
 * e.g. getAttributeType(...), componentAttributeMappingExists(...),...
 *
 * @author FVA GmbH
 */
public interface IRexsSchemaRegistry {

	/**
	 * returns the RexsUnitId of the attribute in the specified REXS version
	 * @param rexsAttributeId
	 * @param version
	 * @return
	 */
	public RexsUnitId getAttributeUnit(String rexsAttributeId, RexsVersion version);

	/**
	 * returns the RexsValueType of the attribute in the specified REXS version
	 * @param rexsAttributeId
	 * @param version
	 * @return
	 */
	public RexsValueType getAttributeType(String rexsAttributeId, RexsVersion version);

	/**
	 * returns the (translated) name of the attribute in the specified REXS version
	 * @param attributeId
	 * @param version
	 * @return
	 */
	public String getAttributeName(String attributeId, RexsVersion version);

	/**
	 * returns the symbol of the attribute in the specified REXS version
	 * @param attributeId
	 * @param version
	 * @return
	 */
	public String getAttributeSymbol(String attributeId, RexsVersion version);

	/**
	 * returns the (translated) name of an enum value of an enum attribute
	 * @param attributeId
	 * @param version
	 * @param value
	 * @return
	 */
	public String getNameForEnumValue(String attributeId, RexsVersion version, String value);

	/**
	 * returns true if this attribute is mapped to this component type in the specified REXS version
	 * @param rexsAttributeId
	 * @param rexsCompType
	 * @param version
	 * @return
	 */
	public boolean componentAttributeMappingExists(String rexsAttributeId, RexsComponentType rexsCompType, RexsVersion version);

	/**
	 * returns the list of component types which are mapped to this attribute in the specified REXS version
	 * @param rexsAttributeId
	 * @param version
	 * @return
	 */
	public List<RexsComponentType> getAvailableComponentTypesForAttributeId(String rexsAttributeId, RexsVersion version);

	/**
	 * returns the list of attributes which are mapped to this component type in the specified REXS version
	 * @param rexsComponentType
	 * @param version
	 * @return
	 */
	public List<String> getAttributeIdsOfComponentType(RexsComponentType rexsComponentType, RexsVersion version);

	public RexsVersion getVersion(String version);

	public RexsComponentType getComponentType(RexsVersion version, String componentType);

	public boolean hasAttributeWithId(RexsVersion version, String attributeId);

	public boolean hasRelationTypes(RexsVersion version);

	public List<List<AllowedCombinationRole>> getAllowedCombinationsForRelation(RexsVersion version, RexsRelationType relationType);
}
