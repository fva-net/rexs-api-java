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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import info.rexs.schema.constants.RexsComponentType;
import info.rexs.schema.constants.RexsRelationType;
import info.rexs.schema.constants.RexsUnitId;
import info.rexs.schema.constants.RexsValueType;
import info.rexs.schema.constants.RexsVersion;
import info.rexs.schema.constants.standard.RexsStandardComponentTypes;
import info.rexs.schema.constants.standard.RexsStandardUnitIds;
import info.rexs.schema.constants.standard.RexsStandardVersions;
import info.rexs.schema.jaxb.AllowedCombination;
import info.rexs.schema.jaxb.AllowedCombinationRole;
import info.rexs.schema.jaxb.AllowedCombinations;
import info.rexs.schema.jaxb.Attribute;
import info.rexs.schema.jaxb.Component;
import info.rexs.schema.jaxb.ComponentAttributeMapping;
import info.rexs.schema.jaxb.EnumValue;
import info.rexs.schema.jaxb.Relation;
import info.rexs.schema.jaxb.RexsSchema;
import info.rexs.schema.jaxb.Unit;
import info.rexs.schema.jaxb.ValueType;

/**
 * This class offers methods to check meta information of a REXS version,
 * e.g. getAttributeType(...), componentAttributeMappingExists(...),...
 *
 * @author FVA GmbH
 */
public class RexsSchemaRegistry implements IRexsSchemaRegistry {

	private static RexsSchemaRegistry instance = null;

	private Map<String, RexsVersion> versions = new HashMap<>();
	private Map<RexsVersion, Map<String, RexsComponentType>> componentMap = new HashMap<>();
	private Map<RexsVersion, Map<String, RexsUnitId>> attributeUnits = new HashMap<>();
	private Map<RexsVersion, Map<String, RexsValueType>> attributeTypes = new HashMap<>();
	private Map<RexsVersion, Map<String, Attribute>> attributeMap = new HashMap<>();
	private Map<RexsVersion, Map<String, List<RexsComponentType>>> attributeToComponentMap = new HashMap<>();
	private Map<RexsVersion, Map<RexsComponentType, List<String>>> componentToAttributesMap = new HashMap<>();
	private Map<RexsVersion, Map<RexsRelationType, List<List<AllowedCombinationRole>>>> relationsToAllowedCombinationsMap = new HashMap<>();

	private RexsSchemaRegistry() {
		try {
			registerRexsVersion(RexsStandardVersions.V1_0);
			registerRexsVersion(RexsStandardVersions.V1_1);
			registerRexsVersion(RexsStandardVersions.V1_2);
			registerRexsVersion(RexsStandardVersions.V1_3);
			registerRexsVersion(RexsStandardVersions.V1_4);
			registerRexsVersion(RexsStandardVersions.V1_5);
			registerRexsVersion(RexsStandardVersions.V1_6);
		} catch (Exception ex) {
			throw new RuntimeException("error while registering rexs model:", ex);
		}
	}

	public static RexsSchemaRegistry getInstance() {
		if (instance != null) {
			return instance;
		}

		synchronized(RexsSchemaRegistry.class) {
			if (instance == null) {
				instance = new RexsSchemaRegistry();
			}
			return instance;
		}
	}

	public void registerRexsVersion(RexsVersion version) {
		RexsSchema rexsModel = RexsSchemaResolver.getInstance().resolve(version);
		if (rexsModel == null)
			throw new IllegalStateException(String.format("rexs db model for version %s not found", version.getName()));
		registerRexsModel(version, rexsModel);
		versions.put(version.getName(), version);
	}

	private void registerRexsModel(RexsVersion version, RexsSchema rexsModel) {
		generateComponentMap(version, rexsModel);
		generateAttributeMap(version, rexsModel);
		generateAttributeTypeMap(version, rexsModel);
		generateAttributeUnitMap(version, rexsModel);
		generateAttributeComponentMappings(version, rexsModel);
		if (version.isGreater(RexsStandardVersions.V1_6))
			generateRelationsWithAllowedCombinations(version, rexsModel);
	}

	private void generateRelationsWithAllowedCombinations(RexsVersion version, RexsSchema rexsModel) {
		Map<RexsRelationType, List<List<AllowedCombinationRole>>> relationsToAllowedCombinationsMapofVersion = relationsToAllowedCombinationsMap.computeIfAbsent(version, k -> new HashMap<>());
		if (rexsModel.getRelations() != null) {
			for (Relation relation : rexsModel.getRelations().getRelation()) {
				RexsRelationType relationType = RexsRelationType.findByKey(relation.getRelationId());
				List<List<AllowedCombinationRole>> listOfCombinations = relationsToAllowedCombinationsMapofVersion.computeIfAbsent(relationType, k -> new ArrayList<>());
				AllowedCombinations combinations = relation.getAllowedCombinations();
				for (AllowedCombination combination : combinations.getAllowedCombination())
					listOfCombinations.add(combination.getAllowedCombinationRole());
			}
		}
	}

	private void generateComponentMap(RexsVersion version, RexsSchema rexsModel) {
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
	private void generateAttributeMap(RexsVersion version, RexsSchema rexsModel) {
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
	 */
	private void generateAttributeTypeMap(RexsVersion version, RexsSchema rexsModel) {
		Map<String, RexsValueType> mapofVersion = attributeTypes.computeIfAbsent(version, k -> new HashMap<>());
		Map<Integer, String> valueTypeMap = new HashMap<>();
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

	private void generateAttributeUnitMap(RexsVersion version, RexsSchema rexsModel) {
		Map<String, RexsUnitId> mapofVersion = attributeUnits.computeIfAbsent(version, k -> new HashMap<>());
		Map<Integer, String> unitMap = new HashMap<>();
		if (rexsModel.getUnits() != null) {
			for (Unit unit : rexsModel.getUnits().getUnit()) {
				if (RexsStandardUnitIds.degree.getId().equals(unit.getName()))
					unitMap.put(unit.getId(), RexsStandardUnitIds.deg.getId());
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
	@Override
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
	@Override
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
	@Override
	public String getAttributeName(String attributeId, RexsVersion version) {
		if (!attributeMap.get(version).containsKey(attributeId))
			return attributeId;
		Attribute attribute = attributeMap.get(version).get(attributeId);
		if (getLanguageDefaultLocale().equals("de"))
			return attribute.getNameDe();
		return attribute.getNameEn();
	}

	/**
	 * returns the symbol of the attribute in the specified REXS version
	 * @param attributeId
	 * @param version
	 * @return
	 */
	@Override
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
	@Override
	public String getNameForEnumValue(String attributeId, RexsVersion version, String value) {
		Attribute attribute = attributeMap.get(version).get(attributeId);
		for (EnumValue enumValue : attribute.getEnumValues().getEnumValue()) {
			if (enumValue.getValue().equals(value)) {
				if (getLanguageDefaultLocale().equals("de"))
					return enumValue.getNameDe();
				return enumValue.getNameEn();
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
	private void generateAttributeComponentMappings(RexsVersion version, RexsSchema rexsModel) {
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
	@Override
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
	@Override
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
	@Override
	public List<String> getAttributeIdsOfComponentType(RexsComponentType rexsComponentType, RexsVersion version) {
		Map<RexsComponentType, List<String>> map = componentToAttributesMap.get(version);
		if (map != null && (map.containsKey(rexsComponentType)) )
			return map.get(rexsComponentType);
		throw new IllegalArgumentException(String.format("Rexs component type %s is not registered in RexsVersion %s", rexsComponentType, version.getName()));
	}

	@Override
	public RexsVersion getVersion(String version) {
		return versions.get(version);
	}

	@Override
	public RexsComponentType getComponentType(RexsVersion version, String componentType) {
		Map<String, RexsComponentType> map = componentMap.get(version);
		if (map != null && map.containsKey(componentType))
			return map.get(componentType);
		return RexsStandardComponentTypes.UNKNOWN;
	}

	@Override
	public boolean hasAttributeWithId(RexsVersion version, String attributeId) {
		Map<String, Attribute> map = attributeMap.get(version);
		return map != null && map.containsKey(attributeId);
	}

	private static String getLanguageDefaultLocale() {
		Locale locale = Locale.getDefault();
		if (!locale.getLanguage().equalsIgnoreCase("en") && !locale.getLanguage().equalsIgnoreCase("de"))
			return Locale.ENGLISH.getLanguage();
		return locale.getLanguage();
	}

	@Override
	public boolean hasRelationTypes(RexsVersion version) {
		Map<RexsRelationType, List<List<AllowedCombinationRole>>> relationsToAllowedCombinationsMapOfVersion = relationsToAllowedCombinationsMap.get(version);
		return relationsToAllowedCombinationsMapOfVersion != null
				&& !relationsToAllowedCombinationsMapOfVersion.isEmpty();
	}

	@Override
	public List<List<AllowedCombinationRole>> getAllowedCombinationsForRelation(RexsVersion version, RexsRelationType relationType) {
		Map<RexsRelationType, List<List<AllowedCombinationRole>>> relationsToAllowedCombinationsMapOfVersion = relationsToAllowedCombinationsMap.get(version);
		if (relationsToAllowedCombinationsMapOfVersion==null)
			throw new IllegalArgumentException(String.format("No relation types for REXS version %s specified", version.getName()));
		List<List<AllowedCombinationRole>> listOfAllowedCombinations = relationsToAllowedCombinationsMapOfVersion.get(relationType);
		if (listOfAllowedCombinations==null || listOfAllowedCombinations.isEmpty())
			throw new IllegalArgumentException(String.format("Rexs Relation type %s is not defined in version %s", relationType, version.getName()));
		return listOfAllowedCombinations;
	}
}
