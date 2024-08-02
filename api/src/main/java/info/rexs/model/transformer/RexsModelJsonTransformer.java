package info.rexs.model.transformer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import info.rexs.db.DbModelRegistry;
import info.rexs.db.constants.RexsValueType;
import info.rexs.db.constants.RexsVersion;
import info.rexs.db.constants.standard.RexsStandardAttributeIds;
import info.rexs.db.constants.standard.RexsStandardComponentTypes;
import info.rexs.db.constants.standard.RexsStandardUnitIds;
import info.rexs.db.constants.standard.RexsStandardVersions;
import info.rexs.io.json.model.Accumulation;
import info.rexs.io.json.model.Component;
import info.rexs.io.json.model.FloatingPointArrayCoded;
import info.rexs.io.json.model.FloatingPointMatrixCoded;
import info.rexs.io.json.model.JSONModel;
import info.rexs.io.json.model.LoadCase;
import info.rexs.io.json.model.LoadSpectrum;
import info.rexs.io.json.model.Model;
import info.rexs.io.json.model.Ref;
import info.rexs.io.json.model.Relation;
import info.rexs.io.json.model.attributes.ArrayOfIntegerArraysAttribute;
import info.rexs.io.json.model.attributes.Attribute;
import info.rexs.io.json.model.attributes.BooleanArrayAttribute;
import info.rexs.io.json.model.attributes.BooleanAttribute;
import info.rexs.io.json.model.attributes.BooleanMatrixAttribute;
import info.rexs.io.json.model.attributes.EnumArrayAttribute;
import info.rexs.io.json.model.attributes.EnumAttribute;
import info.rexs.io.json.model.attributes.FileReferenceAttribute;
import info.rexs.io.json.model.attributes.FloatingPointArrayAttribute;
import info.rexs.io.json.model.attributes.FloatingPointArrayCodedAttribute;
import info.rexs.io.json.model.attributes.FloatingPointAttribute;
import info.rexs.io.json.model.attributes.FloatingPointMatrixAttribute;
import info.rexs.io.json.model.attributes.FloatingPointMatrixCodedAttribute;
import info.rexs.io.json.model.attributes.DateTimeAttribute;
import info.rexs.io.json.model.attributes.IntegerArrayAttribute;
import info.rexs.io.json.model.attributes.IntegerAttribute;
import info.rexs.io.json.model.attributes.IntegerMatrixAttribute;
import info.rexs.io.json.model.attributes.ReferenceComponentAttribute;
import info.rexs.io.json.model.attributes.StringArrayAttribute;
import info.rexs.io.json.model.attributes.StringAttribute;
import info.rexs.io.json.model.attributes.StringMatrixAttribute;
import info.rexs.model.RexsAttribute;
import info.rexs.model.RexsComponent;
import info.rexs.model.RexsLoadSpectrum;
import info.rexs.model.RexsModel;
import info.rexs.model.RexsModelAccessException;
import info.rexs.model.RexsModelObjectFactory;
import info.rexs.model.RexsRelation;
import info.rexs.model.RexsRelationRef;
import info.rexs.model.RexsSubModel;
import info.rexs.model.util.DateUtils;
import info.rexs.model.value.AbstractRexsAttributeValue;
import info.rexs.model.value.Base64Type;
import info.rexs.model.value.RexsAttributeValueArray;
import info.rexs.model.value.RexsAttributeValueArrayBase64;
import info.rexs.model.value.RexsAttributeValueArrayOfArrays;
import info.rexs.model.value.RexsAttributeValueMatrix;
import info.rexs.model.value.RexsAttributeValueMatrixBase64;
import info.rexs.model.value.RexsAttributeValueScalar;


/**
 * This class is a {@link IRexsModelTransformer} to transform REXS models of the types {@link RexsModel} and {@link Model}.
 *
 * @author FVA GmbH
 */
public class RexsModelJsonTransformer implements IRexsModelTransformer<JSONModel>{



	private RexsVersion version;

	@Override
	public JSONModel transform(RexsModel model) {
		version = model.getVersion().equals(RexsStandardVersions.UNKNOWN) ? RexsVersion.create(model.getOriginVersion(), 0) : model.getVersion();
		return new JSONModel().withModel(new Model()
				.withDate(DateUtils.getISO8601Date())
				.withApplicationId(model.getApplicationId())
				.withApplicationVersion(model.getApplicationVersion())
				.withVersion(version.getName())
				.withComponents(createComponentsJson(model.getComponents()))
				.withRelations(createRelationsJson(model.getRelations()))
				.withLoadSpectrum(createLoadSpectrumsJson(model.getLoadSpectrums())));
	}

	@Override
	public RexsModel transform(JSONModel jmodel) {
		Model modelJson = jmodel.getModel();
		RexsModel model = RexsModelObjectFactory.getInstance().createRexsModel(modelJson.getVersion(), modelJson.getApplicationId(), modelJson.getApplicationVersion());

		if (modelJson.getRelations() != null && !modelJson.getRelations().isEmpty())
			for (Relation relationJson : modelJson.getRelations()) {
				model.addRelation(createRelation(relationJson));
			}

		if (modelJson.getComponents() != null && !modelJson.getComponents().isEmpty())
			for (Component componentJson : modelJson.getComponents()) {
				model.addComponent(createComponent(componentJson));
			}

		if (modelJson.getLoadSpectrum() != null)
			model.addLoadSpectrum(createLoadSpectrum(modelJson.getLoadSpectrum()));

		return model;
	}


	private List<Relation> createRelationsJson(List<RexsRelation> relations) {
		List<Relation> relationsJson = new ArrayList<>();
		for (RexsRelation relation : relations)
			relationsJson.add(createRelationJson(relation));
		return relationsJson;
	}

	private Relation createRelationJson(RexsRelation relation) {
		Relation relationJson = new Relation();
		relationJson.setId(relation.getId());
		relationJson.setType(relation.getType().getKey());
		if (relation.getOrder() != null)
			relationJson.setOrder(relation.getOrder());
		relationJson.getRefs().addAll(createRefsJson(relation.getRefs()));
		return relationJson;
	}

	private List<Ref> createRefsJson(Collection<RexsRelationRef> refs) {
		List<Ref> refsJson = new ArrayList<>();
		for (RexsRelationRef ref : refs)
			refsJson.add(createRefJson(ref));
		return refsJson;
	}

	private Ref createRefJson(RexsRelationRef ref) {
		Ref refJson = new Ref();
		refJson.setId(ref.getId());
		refJson.setHint(ref.getHint());
		refJson.setRole(ref.getRole().getKey());
		return refJson;
	}

	private List<Component> createComponentsJson(List<RexsComponent> components) {
		List<Component> componentsJson = new ArrayList<>();
		List<RexsComponent> sortedComponents = components.stream().sorted(Comparator.comparingInt(component -> component.getId())).toList();
		for (RexsComponent component : sortedComponents)
			componentsJson.add(createComponentJson(component));
		return componentsJson;
	}

	private Component createComponentJson(RexsComponent component) {
		Component componentJson = new Component();
		componentJson.setId(component.getId());

		if (component.getType().equals(RexsStandardComponentTypes.UNKNOWN)) {
			componentJson.setType(component.getOriginType());
		} else {
			componentJson.setType(component.getType().getId());
		}

		if (component.getName() != null && !component.getName().isEmpty())
			componentJson.setName(component.getName());

		componentJson.getAttributes().addAll(createAttributesJson(component.getAttributes()));

		return componentJson;
	}

	private List<Attribute> createAttributesJson(Collection<RexsAttribute> attributes) {
		List<Attribute> attributesJson = new ArrayList<>();
		for (RexsAttribute attribute : attributes)
			attributesJson.addAll(createAttributeJson(attribute));
		return attributesJson;
	}

	/**
	 * return List to allow for empty return
	 */
	private List<Attribute> createAttributeJson(RexsAttribute attribute) {
		try {
		DbModelRegistry registry = DbModelRegistry.getInstance();
		String attributeId = getRexsAttrId(attribute);
		String unit = getRexsAttrUnit(attribute);
		AbstractRexsAttributeValue value = attribute.getRawValue();
		Attribute jsonAttribute;
		if (registry.hasAttributeWithId(version, attributeId)) {
			RexsValueType type = registry.getAttributeType(attributeId, version);
			switch (type) {
			case DATE_TIME: {
				DateTimeAttribute timeAttr = new DateTimeAttribute();
				timeAttr.setTime(attribute.hasValue() ? attribute.getDateTimeValue().toString() : null );
				jsonAttribute = timeAttr;
				break;
			}
			case BOOLEAN:
				jsonAttribute = new BooleanAttribute().withBoolean(attribute.hasValue() ? attribute.getBooleanValue() : null ); break;
			case ENUM:
				jsonAttribute = new EnumAttribute().withEnum(attribute.hasValue() ? attribute.getStringValue() : null ); break;
			case FILE_REFERENCE:
				jsonAttribute = new FileReferenceAttribute().withFileReference(attribute.hasValue() ? attribute.getStringValue() : null ); break;
			case FLOATING_POINT:
				jsonAttribute = new FloatingPointAttribute().withFloatingPoint(attribute.hasValue() ? attribute.getDoubleValue(attribute.getUnit()) : null ); break;
			case INTEGER:
				jsonAttribute = new IntegerAttribute().withInteger(attribute.hasValue() ? attribute.getIntegerValue() : null ); break;
			case REFERENCE_COMPONENT:
				jsonAttribute = new ReferenceComponentAttribute().withReferenceComponent(attribute.hasValue() ? attribute.getIntegerValue() : null ); break;
			case STRING:
				jsonAttribute = new StringAttribute().withString(attribute.hasValue() ? attribute.getStringValue() : null ); break;
			case BOOLEAN_ARRAY:
				jsonAttribute = new BooleanArrayAttribute().withBooleanArray(attribute.hasValue() ? Arrays.asList(attribute.getBooleanArrayValue()) : null ); break;
			case ENUM_ARRAY:
				jsonAttribute = new EnumArrayAttribute().withEnumArray(attribute.hasValue() ? Arrays.asList(attribute.getStringArrayValue()) : null ); break;
			case FLOATING_POINT_ARRAY:
				if (value instanceof RexsAttributeValueArrayBase64) {
					RexsAttributeValueArrayBase64 valueBase64 = (RexsAttributeValueArrayBase64) value;
					Base64Type code = valueBase64.getRawType();
					FloatingPointArrayCoded fpac = new FloatingPointArrayCoded()
							.withCode(code == null? null: code.toString())
							.withValue(valueBase64.getRawValue());
					jsonAttribute = new FloatingPointArrayCodedAttribute().withFloatingPointArrayCoded(fpac); break;
				}
				else
					jsonAttribute = new FloatingPointArrayAttribute().withFloatingPointArray(attribute.hasValue() ? Arrays.asList(attribute.getDoubleArrayValue(attribute.getUnit())) : null ); break;
			case INTEGER_ARRAY:
				jsonAttribute = new IntegerArrayAttribute().withIntegerArray(attribute.hasValue() ? Arrays.asList(attribute.getIntegerArrayValue()) : null ); break;
			case STRING_ARRAY:
				jsonAttribute = new StringArrayAttribute().withStringArray(attribute.hasValue() ? Arrays.asList(attribute.getStringArrayValue()) : null ); break;
			case BOOLEAN_MATRIX:
				jsonAttribute = new BooleanMatrixAttribute().withBooleanMatrix(attribute.hasValue() ? (get2DArrayAsList(attribute.getBooleanMatrixValue())) : null ); break;
			case FLOATING_POINT_MATRIX:
				if (value instanceof RexsAttributeValueMatrixBase64) {
					RexsAttributeValueMatrixBase64 valueBase64 = (RexsAttributeValueMatrixBase64) value;
					Base64Type code = valueBase64.getRawType();
					FloatingPointMatrixCoded fpac = new FloatingPointMatrixCoded()
							.withCode(code == null? null: code.toString())
							.withColumns(valueBase64.getRawCols())
							.withRows(valueBase64.getRawRows())
							.withValue(valueBase64.getRawValue());
					jsonAttribute = new FloatingPointMatrixCodedAttribute().withFloatingPointMatrixCoded(fpac); break;
				}
				else
					jsonAttribute = new FloatingPointMatrixAttribute().withFloatingPointMatrix(attribute.hasValue() ? (get2DArrayAsList(attribute.getDoubleMatrixValue(attribute.getUnit()))) : null ); break;
			case INTEGER_MATRIX:
				jsonAttribute = new IntegerMatrixAttribute().withIntegerMatrix(attribute.hasValue() ? (get2DArrayAsList(attribute.getIntegerMatrixValue())) : null ); break;
			case STRING_MATRIX:
				jsonAttribute = new StringMatrixAttribute().withStringMatrix(attribute.hasValue() ? (get2DArrayAsList(attribute.getStringMatrixValue())) : null ); break;
			case ARRAY_OF_INTEGER_ARRAYS:
				jsonAttribute = new ArrayOfIntegerArraysAttribute().withArrayOfIntegerArrays(attribute.hasValue() ? createListOfIntegerLists(attribute.getArrayOfIntegerArraysValue()) : null ); break;
			default: return new ArrayList<>();
			}
		}
		else { // unknown/ custom attribute
			if (value==null)
				return new ArrayList<>();
			jsonAttribute = createAttributeJsonCustom(value, unit);
		}
		return Collections.singletonList(jsonAttribute.withId(attributeId).withUnit(unit));
		}
		catch (Exception e) {
			return new ArrayList<>();
		}
	}

	private Attribute createAttributeJsonCustom(AbstractRexsAttributeValue value, String unit) {
		if (value instanceof RexsAttributeValueScalar) {
			String valueString = ((RexsAttributeValueScalar) value).getRawValue();
			if (valueString==null || valueString.isEmpty())
				return new StringAttribute().withString(valueString);
			else if (valueString.equals("true") || valueString.equals("false"))
				return new BooleanAttribute().withBoolean(Boolean.valueOf(valueString));
			else if (!unit.equals(RexsStandardUnitIds.none.getId()))
				return new FloatingPointAttribute().withFloatingPoint(Double.valueOf(valueString));
			// if nothing better is known try valueOf...
			try {
				return new IntegerAttribute().withInteger(Integer.valueOf(valueString));
			}
			catch (NumberFormatException e) {}
			try {
				return new FloatingPointAttribute().withFloatingPoint(Double.valueOf(valueString));
			}
			catch (NumberFormatException e) {}
			// if nothing else fits use string
			return new StringAttribute().withString(valueString);
		}
		else if (value instanceof RexsAttributeValueArray) {
			RexsAttributeValueArray arrayValue = (RexsAttributeValueArray) value;
			List<String> valueString = arrayValue.getRawValue();
			if (valueString==null || valueString.isEmpty() || valueString.get(0)==null || valueString.get(0).isEmpty())
				return new StringArrayAttribute().withStringArray(valueString);
			else if (valueString.get(0).equals("true") || valueString.get(0).equals("false"))
				return new BooleanArrayAttribute().withBooleanArray(valueString.stream().map(s -> Boolean.valueOf(s)).toList());
			else if (!unit.equals(RexsStandardUnitIds.none.getId()))
				return new FloatingPointArrayAttribute().withFloatingPointArray(valueString.stream().map(s -> Double.valueOf(s)).toList());
			// if nothing better is known try valueOf...
			try {
				return new IntegerArrayAttribute().withIntegerArray(valueString.stream().map(s -> Integer.valueOf(s)).toList());
			}
			catch (NumberFormatException e) {}
			try {
				return new FloatingPointArrayAttribute().withFloatingPointArray(valueString.stream().map(s -> Double.valueOf(s)).toList());
			}
			catch (NumberFormatException e) {}
			// if nothing else fits use string
			return new StringArrayAttribute().withStringArray(valueString);
		}
		else if (value instanceof RexsAttributeValueArrayBase64) {
			RexsAttributeValueArrayBase64 valueBase64 = (RexsAttributeValueArrayBase64) value;
			Base64Type code = valueBase64.getRawType();
			FloatingPointArrayCoded fpac = new FloatingPointArrayCoded()
					.withCode(code == null? null: code.toString())
					.withValue(valueBase64.getRawValue());
			return new FloatingPointArrayCodedAttribute().withFloatingPointArrayCoded(fpac);
		}
		else if (value instanceof RexsAttributeValueMatrix) {
			RexsAttributeValueMatrix matrixValue = (RexsAttributeValueMatrix) value;
			List<List<String>> valueString = matrixValue.getRawValue();
			if (valueString==null || valueString.isEmpty() || valueString.get(0)==null || valueString.get(0).isEmpty() || valueString.get(0).get(0)==null || valueString.get(0).get(0).isEmpty())
				return new StringMatrixAttribute().withStringMatrix(valueString);
			else if (valueString.get(0).get(0).equals("true") || valueString.get(0).get(0).equals("false"))
				return new BooleanMatrixAttribute().withBooleanMatrix(valueString.stream().map(list -> list.stream().map(s -> Boolean.valueOf(s)).toList()).toList());
			else if (!unit.equals(RexsStandardUnitIds.none.getId()))
				return new FloatingPointMatrixAttribute().withFloatingPointMatrix(valueString.stream().map(list -> list.stream().map(s -> Double.valueOf(s)).toList()).toList());
			// if nothing better is known try valueOf...
			try {
				return new IntegerMatrixAttribute().withIntegerMatrix(valueString.stream().map(list -> list.stream().map(s -> Integer.valueOf(s)).toList()).toList());
			}
			catch (NumberFormatException e) {}
			try {
				return new BooleanMatrixAttribute().withBooleanMatrix(valueString.stream().map(list -> list.stream().map(s -> Boolean.valueOf(s)).toList()).toList());
			}
			catch (NumberFormatException e) {}
			// if nothing else fits use string
			return new StringMatrixAttribute().withStringMatrix(valueString);
		}
		else if (value instanceof RexsAttributeValueMatrixBase64) {
			RexsAttributeValueMatrixBase64 valueBase64 = (RexsAttributeValueMatrixBase64) value;
			Base64Type code = valueBase64.getRawType();
			FloatingPointMatrixCoded fpac = new FloatingPointMatrixCoded()
					.withCode(code == null? null: code.toString())
					.withColumns(valueBase64.getRawCols())
					.withRows(valueBase64.getRawRows())
					.withValue(valueBase64.getRawValue());
			return new FloatingPointMatrixCodedAttribute().withFloatingPointMatrixCoded(fpac);
		}
		else if (value instanceof RexsAttributeValueArrayOfArrays) {
			List<Integer[]> valueString = ((RexsAttributeValueArrayOfArrays) value).getValueArrayOfIntegerArrays();
			return new ArrayOfIntegerArraysAttribute().withArrayOfIntegerArrays(valueString.stream().map(array -> Arrays.asList(array)).toList());
		}
		else
			throw new RexsModelAccessException("unkown value type: "+value);
	}

	private List<List<Integer>> createListOfIntegerLists(List<Integer[]> listOfIntegerArraysValue) {
		List<List<Integer>> listOfLists = new ArrayList<>();
		for (Integer[] array : listOfIntegerArraysValue) {
			listOfLists.add(Arrays.asList(array));
		}
		return listOfLists;
	}

	private String getRexsAttrId(RexsAttribute attribute){
		if (attribute.getAttributeId().equals(RexsStandardAttributeIds.UNKNOWN))
			return attribute.getOriginAttributeId();
		return attribute.getAttributeId().getId();
	}

	private String getRexsAttrUnit(RexsAttribute attribute){
		if (attribute.getUnit().equals(RexsStandardUnitIds.UNKNOWN))
			return attribute.getOriginUnit();
		return attribute.getUnit().getId();
	}

	private <T> List<List<T>> get2DArrayAsList(T[][] arr){
		List<List<T>> twoDList = new ArrayList<>();
		for (T[] list : arr) {
			twoDList.add(Arrays.asList(list));
		}
		return twoDList;
	}



	private LoadSpectrum createLoadSpectrumsJson(List<RexsLoadSpectrum> loadSpectrums) {
		if (loadSpectrums == null || loadSpectrums.isEmpty())
			return null;
		RexsLoadSpectrum loadSpectrum = loadSpectrums.get(0);
		LoadSpectrum loadSpectrumJson = new LoadSpectrum();
		loadSpectrumJson.setId(loadSpectrum.getId());
		loadSpectrumJson.setLoadCases(createLoadCasesJson(loadSpectrum.getLoadCases()));
		loadSpectrumJson.setAccumulation(createAccumulationJson(loadSpectrum.getAccumulation()));
		return loadSpectrumJson;
	}

	private List<LoadCase> createLoadCasesJson(Collection<RexsSubModel> loadCases) {
		if (loadCases == null || loadCases.isEmpty())
			return new ArrayList<>();
		List<LoadCase> loadCasesJson = new ArrayList<>();
		for (RexsSubModel loadCase : loadCases) {
			LoadCase loadCaseJson = new LoadCase();
			loadCaseJson.setId(loadCase.getId());
			loadCaseJson.setComponents(createComponentsJson(loadCase.getComponents()));
			loadCasesJson.add(loadCaseJson);
		}
		return loadCasesJson;
	}

	private Accumulation createAccumulationJson(RexsSubModel accumulation) {
		if (accumulation == null)
			return null;
		List<RexsComponent> components = accumulation.getComponents();
		if (components == null || components.isEmpty())
			return null;
		Accumulation accumulationJson = new Accumulation();
		accumulationJson.setComponents(createComponentsJson(accumulation.getComponents()));
		return accumulationJson;
	}

	private RexsRelation createRelation(Relation relationJson) {
		RexsRelation relation = RexsModelObjectFactory.getInstance().createRexsRelation(relationJson.getId(), relationJson.getType(), relationJson.getOrder());

		if (relationJson.getRefs() != null)
			for (Ref refJson : relationJson.getRefs()) {
				RexsRelationRef ref = RexsModelObjectFactory.getInstance().createRexsRelationRef(refJson.getId(), refJson.getRole(), refJson.getHint());
				relation.addRef(ref);
			}
		return relation;
	}

	private RexsComponent createComponent(Component componentJson) {
		RexsComponent component = RexsModelObjectFactory.getInstance().createRexsComponent(componentJson.getId(), componentJson.getType(), componentJson.getName());

		if (componentJson.getAttributes() != null)
			for (Attribute attributeJson : componentJson.getAttributes()) {
				component.addAttribute(createAttribute(attributeJson));
			}
		return component;
	}

	private RexsAttribute createAttribute(Attribute attributeJson) {
		RexsAttribute attribute;

		String unit = attributeJson.getUnit();
		if (unit != null)
			attribute = RexsModelObjectFactory.getInstance().createRexsAttribute(attributeJson.getId(), unit);
		else
			attribute = RexsModelObjectFactory.getInstance().createRexsAttribute(attributeJson.getId());

		attribute.setRawValue(createAttributeValue(attributeJson));
		return attribute;
	}

	private AbstractRexsAttributeValue createAttributeValue(Attribute attributeJson) {
		if(attributeJson instanceof DateTimeAttribute){
			return new RexsAttributeValueScalar(((DateTimeAttribute)attributeJson).getTime());
		}
		if(attributeJson instanceof StringAttribute){
			return new RexsAttributeValueScalar(((StringAttribute)attributeJson).getString());
		}
		if(attributeJson instanceof FloatingPointAttribute){
			return new RexsAttributeValueScalar(((FloatingPointAttribute)attributeJson).getFloatingPoint().toString());
		}
		if(attributeJson instanceof IntegerAttribute){
			return new RexsAttributeValueScalar(((IntegerAttribute)attributeJson).getInteger().toString());
		}
		if(attributeJson instanceof BooleanAttribute){
			return new RexsAttributeValueScalar(((BooleanAttribute)attributeJson).getBoolean().toString());
		}
		if(attributeJson instanceof EnumAttribute){
			return new RexsAttributeValueScalar(((EnumAttribute)attributeJson).getEnum());
		}
		if(attributeJson instanceof FileReferenceAttribute){
			return new RexsAttributeValueScalar(((FileReferenceAttribute)attributeJson).getFileReference());
		}
		if(attributeJson instanceof ReferenceComponentAttribute){
			return new RexsAttributeValueScalar(((ReferenceComponentAttribute)attributeJson).getReferenceComponent().toString());
		}
		if(attributeJson instanceof StringArrayAttribute){
			return new RexsAttributeValueArray(((StringArrayAttribute)attributeJson).getStringArray());
		}
		if(attributeJson instanceof IntegerArrayAttribute){
			RexsAttributeValueArray array = new RexsAttributeValueArray();
			List<Integer> intList = ((IntegerArrayAttribute)attributeJson).getIntegerArray();
			array.setValueIntegerArray(intList.toArray(new Integer[intList.size()]));
			return array;
		}
		if(attributeJson instanceof FloatingPointArrayAttribute){
			RexsAttributeValueArray array = new RexsAttributeValueArray();
			List<Double> intList = ((FloatingPointArrayAttribute)attributeJson).getFloatingPointArray();
			array.setValueDoubleArray(intList.toArray(new Double[intList.size()]));
			return array;
		}
		if(attributeJson instanceof FloatingPointArrayCodedAttribute){
			FloatingPointArrayCoded arrayCoded = ((FloatingPointArrayCodedAttribute)attributeJson).getFloatingPointArrayCoded();
			return new RexsAttributeValueArrayBase64(arrayCoded.getValue(), Base64Type.valueOf(arrayCoded.getCode()));
		}
		if(attributeJson instanceof BooleanArrayAttribute){
			RexsAttributeValueArray array = new RexsAttributeValueArray();
			List<Boolean> intList = ((BooleanArrayAttribute)attributeJson).getBooleanArray();
			array.setValueBooleanArray(intList.toArray(new Boolean[intList.size()]));
			return array;
		}
		if(attributeJson instanceof StringMatrixAttribute){
			List<List<String>> jsonValue = ((StringMatrixAttribute) attributeJson).getStringMatrix();
			return new RexsAttributeValueMatrix(jsonValue);
		}
		if(attributeJson instanceof IntegerMatrixAttribute){
			List<List<Integer>> jsonValue = ((IntegerMatrixAttribute) attributeJson).getIntegerMatrix();
			List<List<String>> stringValue = new ArrayList<>();
			for (List<Integer> list : jsonValue)
				stringValue.add(list.stream().map(entry -> entry.toString()).toList());
			return new RexsAttributeValueMatrix(stringValue);
		}
		if(attributeJson instanceof FloatingPointMatrixAttribute){
			List<List<Double>> jsonValue = ((FloatingPointMatrixAttribute) attributeJson).getFloatingPointMatrix();
			List<List<String>> stringValue = new ArrayList<>();
			for (List<Double> list : jsonValue)
				stringValue.add(list.stream().map(entry -> entry.toString()).toList());
			return new RexsAttributeValueMatrix(stringValue);
		}
		if(attributeJson instanceof FloatingPointMatrixCodedAttribute){
			FloatingPointMatrixCoded matrixCoded = ((FloatingPointMatrixCodedAttribute)attributeJson).getFloatingPointMatrixCoded();
			return new RexsAttributeValueMatrixBase64(matrixCoded.getValue(), Base64Type.valueOf(matrixCoded.getCode()), matrixCoded.getRows(), matrixCoded.getColumns());
		}
		if(attributeJson instanceof BooleanMatrixAttribute){
			List<List<Boolean>> jsonValue = ((BooleanMatrixAttribute) attributeJson).getBooleanMatrix();
			List<List<String>> stringValue = new ArrayList<>();
			for (List<Boolean> list : jsonValue)
				stringValue.add(list.stream().map(entry -> entry.toString()).toList());
			return new RexsAttributeValueMatrix(stringValue);
		}
		if(attributeJson instanceof ArrayOfIntegerArraysAttribute){
			List<List<Integer>> jsonValue = ((ArrayOfIntegerArraysAttribute) attributeJson).getArrayOfIntegerArrays();
			List<List<String>> stringValue = new ArrayList<>();
			for (List<Integer> list : jsonValue)
				stringValue.add(list.stream().map(entry -> entry.toString()).toList());
			return new RexsAttributeValueMatrix(stringValue);
		}
		return null;
	}



	private RexsLoadSpectrum createLoadSpectrum(LoadSpectrum loadSpectrumJson) {
		RexsLoadSpectrum loadSpectrum = RexsModelObjectFactory.getInstance().createRexsLoadSpectrum(loadSpectrumJson.getId());
		if (loadSpectrumJson.getLoadCases() != null)
			for (LoadCase loadCaseJson : loadSpectrumJson.getLoadCases())
				loadSpectrum.addLoadCase(createLoadCase(loadCaseJson));
		if (loadSpectrumJson.getAccumulation() != null)
			loadSpectrum.setAccumulation(createAccumulation(loadSpectrumJson.getAccumulation()));

		return loadSpectrum;
	}

	private RexsSubModel createLoadCase(LoadCase loadCaseJson) {
		RexsSubModel loadCase = RexsModelObjectFactory.getInstance().createRexsSubModel(loadCaseJson.getId());
		if (loadCaseJson.getComponents() != null)
			for (Component componentJson : loadCaseJson.getComponents())
				loadCase.addComponent(createComponent(componentJson));
		return loadCase;
	}

	private RexsSubModel createAccumulation(Accumulation accumulationJson) {
		RexsSubModel accumulation = RexsModelObjectFactory.getInstance().createRexsSubModel();
		if (accumulationJson.getComponents() != null)
			for (Component componentJson : accumulationJson.getComponents())
				accumulation.addComponent(createComponent(componentJson));
		return accumulation;
	}

}
