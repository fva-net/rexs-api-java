package info.rexs.model.transformer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import info.rexs.db.constants.RexsAttributeId;
import info.rexs.db.constants.RexsComponentType;
import info.rexs.db.constants.RexsRelationRole;
import info.rexs.db.constants.RexsRelationType;
import info.rexs.db.constants.RexsUnitId;
import info.rexs.db.constants.RexsVersion;
import info.rexs.io.json.jsonmodel.Accumulation;
import info.rexs.io.json.jsonmodel.Component;
import info.rexs.io.json.jsonmodel.FloatingPointArrayCoded;
import info.rexs.io.json.jsonmodel.FloatingPointMatrixCoded;
import info.rexs.io.json.jsonmodel.JSONModel;
import info.rexs.io.json.jsonmodel.LoadCase;
import info.rexs.io.json.jsonmodel.LoadSpectrum;
import info.rexs.io.json.jsonmodel.Model;
import info.rexs.io.json.jsonmodel.Ref;
import info.rexs.io.json.jsonmodel.Relation;
import info.rexs.io.json.jsonmodel.attributes.ArrayOfIntegerArraysAttribute;
import info.rexs.io.json.jsonmodel.attributes.Attribute;
import info.rexs.io.json.jsonmodel.attributes.BooleanArrayAttribute;
import info.rexs.io.json.jsonmodel.attributes.BooleanAttribute;
import info.rexs.io.json.jsonmodel.attributes.BooleanMatrixAttribute;
import info.rexs.io.json.jsonmodel.attributes.EnumAttribute;
import info.rexs.io.json.jsonmodel.attributes.FloatingPointArrayAttribute;
import info.rexs.io.json.jsonmodel.attributes.FloatingPointArrayCodedAttribute;
import info.rexs.io.json.jsonmodel.attributes.FloatingPointAttribute;
import info.rexs.io.json.jsonmodel.attributes.FloatingPointMatrixAttribute;
import info.rexs.io.json.jsonmodel.attributes.FloatingPointMatrixCodedAttribute;
import info.rexs.io.json.jsonmodel.attributes.IntegerArrayAttribute;
import info.rexs.io.json.jsonmodel.attributes.IntegerAttribute;
import info.rexs.io.json.jsonmodel.attributes.IntegerMatrixAttribute;
import info.rexs.io.json.jsonmodel.attributes.StringArrayAttribute;
import info.rexs.io.json.jsonmodel.attributes.StringAttribute;
import info.rexs.io.json.jsonmodel.attributes.StringMatrixAttribute;
import info.rexs.model.RexsAttribute;
import info.rexs.model.RexsComponent;
import info.rexs.model.RexsLoadSpectrum;
import info.rexs.model.RexsModel;
import info.rexs.model.RexsModelAccessException;
import info.rexs.model.RexsModelObjectFactory;
import info.rexs.model.RexsRelation;
import info.rexs.model.RexsRelationRef;
import info.rexs.model.RexsSubModel;
import info.rexs.model.jaxb.CodeType;
import info.rexs.model.util.DateUtils;
import info.rexs.model.value.AbstractRexsAttributeValue;
import info.rexs.model.value.AbstractRexsAttributeValueArray;
import info.rexs.model.value.AbstractRexsAttributeValueMatrix;
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
public class RexsModelJsonTransformer implements IRexsModelTransformer<JSONModel> {

	@Override
	public JSONModel transform(RexsModel model) {
		return createModelJson(model);
	}

	@Override
	public RexsModel transform(JSONModel model) {
		return createModel(model);
	}

	private JSONModel createModelJson(RexsModel model) {
		return new JSONModel().withModel(new Model()
			.withDate(DateUtils.getISO8601Date())
			.withApplicationId(model.getApplicationId())
			.withApplicationVersion(model.getApplicationVersion())
			.withVersion(model.getVersion().equals(RexsVersion.UNKNOWN)?model.getOriginVersion():model.getVersion().getName())
			.withComponents(createComponentsJson(model.getComponents()))
			.withRelations(createRelationsJson(model.getRelations()))
			.withLoadSpectrum(createLoadSpectrumsJson(model.getLoadSpectrums())));
	}

	private List<Relation> createRelationsJson(List<RexsRelation> relations) {
		if (relations == null || relations.isEmpty())
			return new ArrayList<>();

		List<Relation> relationsJson = new ArrayList<>();

		for (RexsRelation relation : relations) {
			relationsJson.add(createRelationJson(relation));
		}

		return relationsJson;
	}

	private Relation createRelationJson(RexsRelation relation) {
		Relation relationJson = new Relation();
		relationJson.setId(relation.getId());

		if (relation.getType().equals(RexsRelationType.UNKNOWN)) {
			relationJson.setType(relation.getOriginType());
		} else {
			relationJson.setType(relation.getType().getKey());
		}

		if (relation.getOrder() != null && relation.getOrder() > -1)
			relationJson.setOrder(relation.getOrder());

		relationJson.getRefs().addAll(createRefsJson(relation.getRefs()));

		return relationJson;
	}

	private List<Ref> createRefsJson(Collection<RexsRelationRef> refs) {
		if (refs == null || refs.isEmpty())
			return new ArrayList<>();

		List<Ref> refsJson = new ArrayList<>();

		for (RexsRelationRef ref : refs) {
			refsJson.add(createRefJson(ref));
		}

		return refsJson;
	}

	private Ref createRefJson(RexsRelationRef ref) {
		Ref refJson = new Ref();
		refJson.setId(ref.getId());
		refJson.setHint(ref.getHint());

		if (ref.getRole().equals(RexsRelationRole.UNKNOWN)) {
			refJson.setRole(ref.getOriginRole());
		} else {
			refJson.setRole(ref.getRole().getKey());
		}

		return refJson;
	}

	private List<Component> createComponentsJson(List<RexsComponent> components) {
		if (components == null || components.isEmpty())
			return new ArrayList<>();

		List<Component> componentsJson = new ArrayList<>();

		for (RexsComponent component : components) {
			componentsJson.add(createComponentJson(component));
		}

		return componentsJson;
	}

	private Component createComponentJson(RexsComponent component) {
		Component componentJson = new Component();
		componentJson.setId(component.getId());

		if (component.getType().equals(RexsComponentType.UNKNOWN)) {
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
		if (attributes == null || attributes.isEmpty())
			return new ArrayList<>();

		List<Attribute> attributesJson = new ArrayList<>();

		for (RexsAttribute attribute : attributes) {
			attributesJson.add(createAttributeJson(attribute));
		}

		return attributesJson;
	}

	private Attribute createAttributeJson(RexsAttribute attribute) {
		AbstractRexsAttributeValue value = attribute.getRawValue();
		if (value != null) {
			return createAttributeContentJson(attribute,value);
		}
		return null;
	}

	private Attribute createAttributeContentJson(RexsAttribute attr, AbstractRexsAttributeValue value) {
		if (value instanceof RexsAttributeValueScalar) {
			RexsAttributeValueScalar valueScalar = (RexsAttributeValueScalar)value;
			try{
				int d = valueScalar.getValueInteger();
				return new IntegerAttribute()
					.withInteger(d)
					.withId(getRightRexsAttrIdId(attr))
					.withUnit(getRightRexsAttrUnit(attr));
			}catch(RexsModelAccessException e){

			}
			try{
				double d = valueScalar.getValueDouble();
				return new FloatingPointAttribute()
					.withFloatingPoint(d)
					.withId(getRightRexsAttrIdId(attr))
					.withUnit(getRightRexsAttrUnit(attr));
			}catch(RexsModelAccessException e){

			}

			try{
				boolean d = valueScalar.getValueBoolean();
				return new BooleanAttribute()
					.withBoolean(d)
					.withId(getRightRexsAttrIdId(attr))
					.withUnit(getRightRexsAttrUnit(attr));
			}catch(RexsModelAccessException e){

			}
			return new StringAttribute()
				.withString(valueScalar.getValueString())
				.withId(getRightRexsAttrIdId(attr))
				.withUnit(getRightRexsAttrUnit(attr));

			//TODO implement enum according to context

		}
		 if (value instanceof AbstractRexsAttributeValueArray) {
			return createArrayFromJson(attr, (AbstractRexsAttributeValueArray)value);
		}
		 if (value instanceof AbstractRexsAttributeValueMatrix) {
		return createMatrixJson(attr,(AbstractRexsAttributeValueMatrix)value);
		}
		else if (value instanceof RexsAttributeValueArrayOfArrays) {
			return createArrayOfArraysJson(attr,(RexsAttributeValueArrayOfArrays)value);
		}

		return null;
	}

	private String getRightRexsAttrIdId(RexsAttribute attribute){
		if (attribute.getAttributeId().equals(RexsAttributeId.UNKNOWN))
			return attribute.getOriginAttributeId();
		return attribute.getAttributeId().getId();
	}

	private String getRightRexsAttrUnit(RexsAttribute attribute){
		if (attribute.getUnit().equals(RexsUnitId.UNKNOWN))
			return attribute.getOriginUnit();
		return attribute.getUnit().getId();
	}

	private List<Integer> createListFromRexs(RexsAttribute attr, AbstractRexsAttributeValueArray value) {
		try{
			Integer[] d = value.getValueIntegerArray();
			return Arrays.asList(d);
		}catch(RexsModelAccessException e){

		}
		return new ArrayList<>();
	}
	private Attribute createArrayFromJson(RexsAttribute attr, AbstractRexsAttributeValueArray value) {
		if (value instanceof RexsAttributeValueArray) {
			RexsAttributeValueArray arr = (RexsAttributeValueArray)value;
			List<String> rawValue = arr.getRawValue();
			if (rawValue == null)
				return null;

			try{
				Integer[] d = value.getValueIntegerArray();
				return new IntegerArrayAttribute()
					.withIntegerArray(Arrays.asList(d))
					.withId(getRightRexsAttrIdId(attr))
					.withUnit(getRightRexsAttrUnit(attr));
			}catch(RexsModelAccessException e){
				//TODO
			}
			try{
				Double[] d = value.getValueDoubleArray();
				return new FloatingPointArrayAttribute()
					.withFloatingPointArray(Arrays.asList(d))
					.withId(getRightRexsAttrIdId(attr))
					.withUnit(getRightRexsAttrUnit(attr));
			}catch(RexsModelAccessException e){
				//TODO
			}

			try{
				Boolean[] d = value.getValueBooleanArray();
				return new BooleanArrayAttribute()
					.withBooleanArray(Arrays.asList(d))
					.withId(getRightRexsAttrIdId(attr))
					.withUnit(getRightRexsAttrUnit(attr));
			}catch(RexsModelAccessException e){
				//TODO
			}
			String[] d = value.getValueStringArray();
			return new StringArrayAttribute()
				.withStringArray(Arrays.asList(d))
				.withId(getRightRexsAttrIdId(attr))
				.withUnit(getRightRexsAttrUnit(attr));

		}
		if (value instanceof RexsAttributeValueArrayBase64) {
			RexsAttributeValueArrayBase64 valueBase64 = (RexsAttributeValueArrayBase64)value;
			if (valueBase64.getRawValue() == null)
				return null;
			CodeType code = convertBase64Type(valueBase64.getRawType());
			FloatingPointArrayCoded fpac = new FloatingPointArrayCoded()
				.withCode(code == null? null: code.toString())
				.withValue(valueBase64.getRawValue());
			return new FloatingPointArrayCodedAttribute()
				.withFloatingPointArrayCoded(fpac)
				.withId(getRightRexsAttrIdId(attr))
				.withUnit(getRightRexsAttrUnit(attr));
		}

		return null;
	}

	private Attribute createMatrixJson(RexsAttribute attr, AbstractRexsAttributeValueMatrix value) {
		RexsAttributeValueMatrix matrixValue = (RexsAttributeValueMatrix)value;

		try{
			List<List<Boolean>> boolListList = get2DArrayAsList(matrixValue.getValueBooleanMatrix());
			return new BooleanMatrixAttribute()
				.withBooleanMatrix(boolListList)
				.withId(getRightRexsAttrIdId(attr))
				.withUnit(getRightRexsAttrUnit(attr));
		}catch(RexsModelAccessException e){
			//TODO
		}
		try{
			List<List<Integer>> intListList = get2DArrayAsList(matrixValue.getValueIntegerMatrix());
			return new IntegerMatrixAttribute()
				.withIntegerMatrix(intListList)
				.withId(getRightRexsAttrIdId(attr))
				.withUnit(getRightRexsAttrUnit(attr));
		}catch(RexsModelAccessException e){
			//TODO
		}
		try{
			List<List<Double>> intListList = get2DArrayAsList(matrixValue.getValueDoubleMatrix());
			return new FloatingPointMatrixAttribute()
				.withFloatingPointMatrix(intListList)
				.withId(getRightRexsAttrIdId(attr))
				.withUnit(getRightRexsAttrUnit(attr));
		}catch(RexsModelAccessException e){
			//TODO
		}
		List<List<String>> sListList = get2DArrayAsList(matrixValue.getValueStringMatrix());
			return new StringMatrixAttribute()
				.withStringMatrix(sListList)
				.withId(getRightRexsAttrIdId(attr))
				.withUnit(getRightRexsAttrUnit(attr));
	}

	private <T> List<List<T>> get2DArrayAsList(T[][] arr){
		List<List<T>> twoDList = new ArrayList<>();
		for (T[] list : arr) {
			twoDList.add(Arrays.asList(list));
		}
		return twoDList;
	}



	private CodeType convertBase64Type(Base64Type type) {
		if (type == Base64Type.INT_32)
			return CodeType.INT_32;
		else if (type == Base64Type.FLOAT_32)
			return CodeType.FLOAT_32;
		else if (type == Base64Type.FLOAT_64)
			return CodeType.FLOAT_64;
		return null;
	}

	private Attribute createArrayOfArraysJson(RexsAttribute attr, RexsAttributeValueArrayOfArrays value) {
		ArrayOfIntegerArraysAttribute arrayOfArrays = new ArrayOfIntegerArraysAttribute().withArrayOfIntegerArrays(new ArrayList<>());

		List<AbstractRexsAttributeValueArray> rawValue = value.getRawValue();
		for (AbstractRexsAttributeValueArray arrayValue : rawValue) {
			arrayOfArrays.getArrayOfIntegerArrays().add(createListFromRexs(attr, arrayValue));
		}

		return arrayOfArrays;
	}

	private LoadSpectrum createLoadSpectrumsJson(List<RexsLoadSpectrum> loadSpectrums) {
		if (loadSpectrums == null || loadSpectrums.isEmpty())
			return null;

		List<LoadSpectrum> loadSpectrumsJson = new ArrayList<>();

		for (RexsLoadSpectrum loadSpectrum : loadSpectrums) {
			loadSpectrumsJson.add(createLoadSpectrumJson(loadSpectrum));
		}

		return loadSpectrumsJson.isEmpty() ? null: loadSpectrumsJson.get(0);
	}

	private LoadSpectrum createLoadSpectrumJson(RexsLoadSpectrum loadSpectrum) {
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
			loadCasesJson.add(createLoadCaseJson(loadCase));
		}

		return loadCasesJson;
	}

	private LoadCase createLoadCaseJson(RexsSubModel loadCase) {
		LoadCase loadCaseJson = new LoadCase();
		loadCaseJson.setId(loadCase.getId());
		loadCaseJson.setComponents(createComponentsJson(loadCase.getComponents()));
		return loadCaseJson;
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

	private RexsModel createModel(JSONModel jmodel) {
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
			//TODO to implement in appropriate context
		}
		//arrays
		if(attributeJson instanceof StringArrayAttribute){
			return new RexsAttributeValueArray(((StringArrayAttribute)attributeJson).getStringArray());
		}
		if(attributeJson instanceof IntegerArrayAttribute){
			RexsAttributeValueArray rava = new RexsAttributeValueArray();
			List<Integer> intList = ((IntegerArrayAttribute)attributeJson).getIntegerArray();
			rava.setValueIntegerArray(intList.toArray(new Integer[intList.size()]));
			return rava;
		}
		if(attributeJson instanceof FloatingPointArrayAttribute){
			RexsAttributeValueArray rava = new RexsAttributeValueArray();
			List<Double> intList = ((FloatingPointArrayAttribute)attributeJson).getFloatingPointArray();
			rava.setValueDoubleArray(intList.toArray(new Double[intList.size()]));
			return rava;
		}
		if(attributeJson instanceof BooleanArrayAttribute){
			RexsAttributeValueArray rava = new RexsAttributeValueArray();
			List<Boolean> intList = ((BooleanArrayAttribute)attributeJson).getBooleanArray();
			rava.setValueBooleanArray(intList.toArray(new Boolean[intList.size()]));
			return rava;
		}
		//matrix
		if(attributeJson instanceof StringMatrixAttribute){
			RexsAttributeValueMatrix rava = new RexsAttributeValueMatrix();
			List<List<String>> intList = ((StringMatrixAttribute)attributeJson).getStringMatrix();
			String[][] stringArrArr = new String[intList.size()][intList.isEmpty()?0:intList.get(0).size()];
			rava.setValueStringMatrix(stringArrArr);
			return rava;
		}
		if(attributeJson instanceof IntegerMatrixAttribute){
			RexsAttributeValueMatrix rava = new RexsAttributeValueMatrix();
			List<List<Integer>> intList = ((IntegerMatrixAttribute)attributeJson).getIntegerMatrix();
			Integer[][] integerArrArr = new Integer[intList.size()][intList.isEmpty()?0:intList.get(0).size()];
			rava.setValueIntegerMatrix(integerArrArr);
			return rava;
		}
		if(attributeJson instanceof FloatingPointMatrixAttribute){
			RexsAttributeValueMatrix rava = new RexsAttributeValueMatrix();
			List<List<Double>> floatList = ((FloatingPointMatrixAttribute)attributeJson).getFloatingPointMatrix();
			Double[][] floatArrArr = new Double[floatList.size()][floatList.isEmpty()?0:floatList.get(0).size()];
			rava.setValueDoubleMatrix(floatArrArr);
			return rava;
		}
		if(attributeJson instanceof BooleanMatrixAttribute){
			RexsAttributeValueMatrix rava = new RexsAttributeValueMatrix();
			List<List<Boolean>> boolList = ((BooleanMatrixAttribute)attributeJson).getBooleanMatrix();
			Boolean[][] boolArrArr = new Boolean[boolList.size()][boolList.isEmpty()?0:boolList.get(0).size()];
			rava.setValueBooleanMatrix(boolArrArr);
			return rava;
		}
		if(attributeJson instanceof FloatingPointArrayCodedAttribute){
			FloatingPointArrayCodedAttribute floatingPointArrayAttr = (FloatingPointArrayCodedAttribute)attributeJson;
			String floatList = floatingPointArrayAttr.getFloatingPointArrayCoded().getValue();
			Base64Type type = getBase64Type(floatingPointArrayAttr.getFloatingPointArrayCoded().getCode());

			return new RexsAttributeValueArrayBase64(floatList, type);
		}
		if(attributeJson instanceof FloatingPointMatrixAttribute){
			FloatingPointMatrixCoded matrix = ((FloatingPointMatrixCodedAttribute)attributeJson).getFloatingPointMatrixCoded();
			String floatList = matrix.getValue();
			Base64Type type = getBase64Type(matrix.getCode());
			return new RexsAttributeValueMatrixBase64(floatList, type, matrix.getRows(), matrix.getColumns());
		}
		return null;
	}

	private Base64Type getBase64Type(String baseType){
		switch(baseType){
			case "int32": return Base64Type.INT_32;
			case "float32": return Base64Type.FLOAT_32;
			case "float64": return Base64Type.FLOAT_64;
			default: return null;
		}
	}

	private String readArrayBase64Value(FloatingPointArrayAttribute attribute) {
		if (attribute != null) {
			return attribute.getFloatingPointArray()
					.stream()
					.filter(String.class::isInstance)
					.map(String.class::cast)
					.filter(Objects::nonNull)
					.map(String::trim)
					.filter(val -> !val.isEmpty())
					.findFirst()
					.orElse(null);
		}
		return null;
	}

	private RexsLoadSpectrum createLoadSpectrum(LoadSpectrum loadSpectrumJson) {
		RexsLoadSpectrum loadSpectrum = RexsModelObjectFactory.getInstance().createRexsLoadSpectrum(loadSpectrumJson.getId());

		if (loadSpectrumJson.getLoadCases() != null)
			for (LoadCase loadCaseJson : loadSpectrumJson.getLoadCases()) {
				loadSpectrum.addLoadCase(createLoadCase(loadCaseJson));
			}

		if (loadSpectrumJson.getAccumulation() != null)
			loadSpectrum.setAccumulation(createAccumulation(loadSpectrumJson.getAccumulation()));

		return loadSpectrum;
	}

	private RexsSubModel createLoadCase(LoadCase loadCaseJson) {
		RexsSubModel loadCase = RexsModelObjectFactory.getInstance().createRexsSubModel(loadCaseJson.getId());

		if (loadCaseJson.getComponents() != null)
			for (Component componentJson : loadCaseJson.getComponents()) {
				loadCase.addComponent(createComponent(componentJson));
			}

		return loadCase;
	}

	private RexsSubModel createAccumulation(Accumulation accumulationJson) {
		RexsSubModel accumulation = RexsModelObjectFactory.getInstance().createRexsSubModel();

		if (accumulationJson.getComponents() != null)
			for (Component componentJson : accumulationJson.getComponents()) {
				accumulation.addComponent(createComponent(componentJson));
			}

		return accumulation;
	}
}
