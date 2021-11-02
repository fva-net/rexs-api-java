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
package info.rexs.db;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import info.rexs.db.constants.RexsComponentType;
import info.rexs.db.constants.RexsUnitId;
import info.rexs.db.constants.RexsValueType;
import info.rexs.db.constants.RexsVersion;
import info.rexs.db.jaxb.Attribute;
import info.rexs.db.jaxb.Component;
import info.rexs.db.jaxb.ComponentAttributeMapping;
import info.rexs.db.jaxb.EnumValue;
import info.rexs.db.jaxb.RexsModel;
import info.rexs.db.jaxb.Unit;
import info.rexs.db.jaxb.ValueType;

/**
 * This class offers methods to check meta information of a REXS version,
 * e.g. getAttributeType(...), componentAttributeMappingExists(...),...
 *
 * @author FVA GmbH
 */
public class DbModelRegistry {

	private static DbModelRegistry instance = null;

	private Map<String, RexsVersion> versions = new HashMap<>();
	private Map<RexsVersion, Map<String, RexsComponentType>> componentMap = new HashMap<>();
	private Map<RexsVersion, Map<String, RexsUnitId>> attributeUnits = new HashMap<>();
	private Map<RexsVersion, Map<String, RexsValueType>> attributeTypes = new HashMap<>();
	private Map<RexsVersion, Map<String, Attribute>> attributeMap = new HashMap<>();
	private Map<RexsVersion, Map<String, List<RexsComponentType>>> attributeToComponentMap = new HashMap<>();
	private Map<RexsVersion, Map<RexsComponentType, List<String>>> componentToAttributesMap = new HashMap<>();

	private DbModelRegistry() {
		try {
			registerRexsVersion(RexsVersion.V1_0);
			registerRexsVersion(RexsVersion.V1_1);
			registerRexsVersion(RexsVersion.V1_2);
			registerRexsVersion(RexsVersion.V1_3);
			registerRexsVersion(RexsVersion.V_DEV);
		} catch (Exception ex) {
			throw new RuntimeException("error while registering rexs model:", ex);
		}
	}

	public static DbModelRegistry getInstance() {
		if (instance != null) {
			return instance;
		}

		synchronized(DbModelRegistry.class) {
			if (instance == null) {
				instance = new DbModelRegistry();
			}
			return instance;
		}
	}

	public void registerRexsVersion(RexsVersion version) {
		registerRexsVersion(version, Locale.getDefault());
	}

	public void registerRexsVersion(RexsVersion version, Locale locale) {
		RexsModel rexsModel = DbModelResolver.getInstance().resolve(version, locale);
		if (rexsModel == null)
			throw new IllegalStateException(String.format("rexs db model for version %s and language %s not found", version.getName(), locale));
		registerRexsModel(version, rexsModel);
		versions.put(version.getName(), version);
	}

	private void registerRexsModel(RexsVersion version, RexsModel rexsModel) {
		generateComponentMap(version, rexsModel);
		generateAttributeMap(version, rexsModel);
		generateAttributeTypeMap(version, rexsModel);
		generateAttributeUnitMap(version, rexsModel);
		generateAttributeComponentMappings(version, rexsModel);
	}

	private void generateComponentMap(RexsVersion version, RexsModel rexsModel) {
		Map<String, RexsComponentType> mapOfVersion = componentMap.computeIfAbsent(version, k -> new HashMap<>());
		for (Component component : rexsModel.getComponents().getComponent()) {
			RexsComponentType componentType = RexsComponentType.findById(component.getComponentId());
			mapOfVersion.put(component.getComponentId(), componentType);
		}
	}

	/**
	 * Generates the Map<RexsVersion, Map<String, Attribute>> attributeMap
	 * such that given a version and an attribute id the corresponding instance of the Attribute.java class is returned
	 * @param version
	 * @param rexsModel
	 */
	private void generateAttributeMap(RexsVersion version, RexsModel rexsModel) {
		Map<String, Attribute> mapofVersion = attributeMap.computeIfAbsent(version, k -> new HashMap<>());
		for (Attribute attribute : rexsModel.getAttributes().getAttribute()) {
			mapofVersion.put(attribute.getAttributeId(), attribute);
		}
	}

	/**
	 * generates the Map<RexsVersion, Map<String, RexsValueType>> attributeTypes map
	 * such that given a version and an attribute id the corresponding RexsValueType is returned
	 * @param version
	 * @param rexsModel
	 * @param valueTypeMap
	 */
	private void generateAttributeTypeMap(RexsVersion version, RexsModel rexsModel) {
		Map<String, RexsValueType> mapofVersion = attributeTypes.computeIfAbsent(version, k -> new HashMap<>());
		Map<BigInteger, String> valueTypeMap = new HashMap<>();
		if (rexsModel.getValueTypes() != null) {
			for (ValueType valueType : rexsModel.getValueTypes().getValueType()) {
				valueTypeMap.put(valueType.getId(), valueType.getName());
			}
		}
		if (rexsModel.getAttributes() != null) {
			for (Attribute attribute : rexsModel.getAttributes().getAttribute()) {
				mapofVersion.put(attribute.getAttributeId(), RexsValueType.findByKey(valueTypeMap.get(attribute.getValueType())));
			}
		}
	}

	private void generateAttributeUnitMap(RexsVersion version, RexsModel rexsModel) {
		Map<String, RexsUnitId> mapofVersion = attributeUnits.computeIfAbsent(version, k -> new HashMap<>());
		Map<BigInteger, String> unitMap = new HashMap<>();
		if (rexsModel.getUnits() != null) {
			for (Unit unit : rexsModel.getUnits().getUnit()) {
				if (RexsUnitId.degree.getId().equals(unit.getName()))
					unitMap.put(unit.getId(), RexsUnitId.deg.getId());
				else
					unitMap.put(unit.getId(), unit.getName());
			}
		}
		if (rexsModel.getAttributes() != null) {
			for (Attribute attribute : rexsModel.getAttributes().getAttribute()) {
				String unit = unitMap.get(attribute.getUnit());
				mapofVersion.put(attribute.getAttributeId(), RexsUnitId.findById(unit));
			}
		}
	}

	/**
	 * returns the RexsUnitId of the attribute in the specified REXS version
	 * @param rexsAttributeId
	 * @param version
	 * @return
	 */
	public RexsUnitId getAttributeUnit(String rexsAttributeId, RexsVersion version) {
		Map<String, RexsUnitId> unitsMap = attributeUnits.get(version);
		if (unitsMap != null && (unitsMap.containsKey(rexsAttributeId)) )
			return unitsMap.get(rexsAttributeId);
		throw new IllegalArgumentException(String.format("Rexs Attribute with id %s is not registered in RexsVersion %s", rexsAttributeId, version.getName()));
	}

	/**
	 * returns the RexsValueType of the attribute in the specified REXS version
	 * @param rexsAttributeId
	 * @param version
	 * @return
	 */
	public RexsValueType getAttributeType(String rexsAttributeId, RexsVersion version) {
		Map<String, RexsValueType> map = attributeTypes.get(version);
		if (map != null && (map.containsKey(rexsAttributeId)) )
			return map.get(rexsAttributeId);
		throw new IllegalArgumentException(String.format("Rexs Attribute with id %s is not registered in RexsVersion %s", rexsAttributeId, version.getName()));
	}

	/**
	 * returns the (translated) name of the attribute in the specified REXS version
	 * @param attributeId
	 * @param version
	 * @return
	 */
	public String getAttributeName(String attributeId, RexsVersion version) {
		if (!attributeMap.get(version).containsKey(attributeId))
			return attributeId;
		return attributeMap.get(version).get(attributeId).getName();
	}

	/**
	 * returns the symbol of the attribute in the specified REXS version
	 * @param attributeId
	 * @param version
	 * @return
	 */
	public String getAttributeSymbol(String attributeId, RexsVersion version) {
		if (!attributeMap.get(version).containsKey(attributeId))
			return "";
		return attributeMap.get(version).get(attributeId).getSymbol();
	}

	/**
	 * returns the (translated) name of an enum value of an enum attribute
	 * @param attributeId
	 * @param version
	 * @param value
	 * @return
	 */
	public String getNameForEnumValue(String attributeId, RexsVersion version, String value) {
		Attribute attribute = attributeMap.get(version).get(attributeId);
		for (EnumValue enumValue : attribute.getEnumValues().getEnumValue()) {
			if (enumValue.getValue().equals(value)) {
				return enumValue.getName();
			}
		}
		return value;
	}

	/**
	 * generates the Map<RexsVersion, Map<String, List<RexsComponentType>>> attributeToComponentMap
	 * and the Map<RexsVersion, Map<RexsComponentType, List<String>>> componentToAttributesMap
	 * such that given a version and a component type the  list of available attributes for this component type can be returned
	 * as well as given a version and an attribute id the  list of component type which contain this attribute can be returned
	 * @param version
	 * @param rexsModel
	 */
	private void generateAttributeComponentMappings(RexsVersion version, RexsModel rexsModel) {
		Map<String, List<RexsComponentType>> attributeToComponentMapofVersion = attributeToComponentMap.computeIfAbsent(version, k -> new HashMap<>());
		Map<RexsComponentType, List<String>> componentToAttributeMapofVersion = componentToAttributesMap.computeIfAbsent(version, k -> new HashMap<>());
		if (rexsModel.getComponentAttributeMappings() != null) {
			for (ComponentAttributeMapping mapping : rexsModel.getComponentAttributeMappings().getComponentAttributeMapping()) {
				RexsComponentType componentType = RexsComponentType.findById(mapping.getComponentId());
				String attributeId = mapping.getAttributeId();

				List<RexsComponentType> componentsOfAttributeList = attributeToComponentMapofVersion.computeIfAbsent(attributeId, k -> new ArrayList<>());
				List<String> attributesOfComponentList = componentToAttributeMapofVersion.computeIfAbsent(componentType, k -> new ArrayList<>());
				componentsOfAttributeList.add(componentType);
				attributesOfComponentList.add(attributeId);
			}
		}
	}

	/**
	 * returns true if this attribute is mapped to this component type in the specified REXS version
	 * @param rexsAttributeId
	 * @param rexsCompType
	 * @param version
	 * @return
	 */
	public boolean componentAttributeMappingExists(String rexsAttributeId, RexsComponentType rexsCompType, RexsVersion version) {
		Map<String, List<RexsComponentType>> map = attributeToComponentMap.get(version);
		if (map != null && (map.containsKey(rexsAttributeId)) )
			return map.get(rexsAttributeId).contains(rexsCompType);
		return false;
	}

	/**
	 * returns the list of component types which are mapped to this attribute in the specified REXS version
	 * @param rexsAttributeId
	 * @param version
	 * @return
	 */
	public List<RexsComponentType> getAvailableComponentTypesForAttributeId(String rexsAttributeId, RexsVersion version) {
		Map<String, List<RexsComponentType>> map = attributeToComponentMap.get(version);
		if (map != null && (map.containsKey(rexsAttributeId)) )
			return map.get(rexsAttributeId);
		throw new IllegalArgumentException(String.format("Rexs Attribute with id %s is not registered in RexsVersion %s", rexsAttributeId, version.getName()));
	}

	/**
	 * returns the list of attributes which are mapped to this component type in the specified REXS version
	 * @param rexsComponentType
	 * @param version
	 * @return
	 */
	public List<String> getAttributeIdsOfComponentType(RexsComponentType rexsComponentType, RexsVersion version) {
		Map<RexsComponentType, List<String>> map = componentToAttributesMap.get(version);
		if (map != null && (map.containsKey(rexsComponentType)) )
			return map.get(rexsComponentType);
		throw new IllegalArgumentException(String.format("Rexs component type %s is not registered in RexsVersion %s", rexsComponentType, version.getName()));
	}

	public RexsVersion getVersion(String version) {
		return versions.get(version);
	}

	public RexsComponentType getComponentType(RexsVersion version, String componentType) {
		Map<String, RexsComponentType> map = componentMap.get(version);
		if (map != null && map.containsKey(componentType))
			return map.get(componentType);
		return RexsComponentType.UNKNOWN;
	}

	public boolean hasAttributeWithId(RexsVersion version, String attributeId) {
		Map<String, Attribute> map = attributeMap.get(version);
		return map != null && map.containsKey(attributeId);
	}
}
