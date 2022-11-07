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
package info.rexs.model.transformer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import info.rexs.db.constants.RexsAttributeId;
import info.rexs.db.constants.RexsComponentType;
import info.rexs.db.constants.RexsRelationRole;
import info.rexs.db.constants.RexsRelationType;
import info.rexs.db.constants.RexsUnitId;
import info.rexs.db.constants.RexsVersion;
import info.rexs.model.RexsAttribute;
import info.rexs.model.RexsComponent;
import info.rexs.model.RexsLoadSpectrum;
import info.rexs.model.RexsModel;
import info.rexs.model.RexsModelObjectFactory;
import info.rexs.model.RexsRelation;
import info.rexs.model.RexsRelationRef;
import info.rexs.model.RexsSubModel;
import info.rexs.model.jaxb.Accumulation;
import info.rexs.model.jaxb.Array;
import info.rexs.model.jaxb.ArrayOfArrays;
import info.rexs.model.jaxb.Attribute;
import info.rexs.model.jaxb.C;
import info.rexs.model.jaxb.CodeType;
import info.rexs.model.jaxb.Component;
import info.rexs.model.jaxb.Components;
import info.rexs.model.jaxb.LoadCase;
import info.rexs.model.jaxb.LoadSpectrum;
import info.rexs.model.jaxb.Matrix;
import info.rexs.model.jaxb.Model;
import info.rexs.model.jaxb.ObjectFactory;
import info.rexs.model.jaxb.R;
import info.rexs.model.jaxb.Ref;
import info.rexs.model.jaxb.Relation;
import info.rexs.model.jaxb.Relations;
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
public class RexsModelXmlTransformer implements IRexsModelTransformer<Model> {

	/** Factory class to create new instances for the JAXB model. */
	protected ObjectFactory objectFactory = new ObjectFactory();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Model transform(RexsModel model) {
		return createModelXml(model);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RexsModel transform(Model modelXml) {
		return createModel(modelXml);
	}

	private Model createModelXml(RexsModel model) {
		Model modelXml = objectFactory.createModel();
		modelXml.setApplicationId(model.getApplicationId());
		modelXml.setApplicationVersion(model.getApplicationVersion());
		modelXml.setDate(DateUtils.getISO8601Date());

		if (model.getVersion().equals(RexsVersion.UNKNOWN)) {
			modelXml.setVersion(model.getOriginVersion());
		} else {
			modelXml.setVersion(model.getVersion().getName());
		}

		modelXml.setRelations(createRelationsXml(model.getRelations()));
		modelXml.setComponents(createComponentsXml(model.getComponents()));
		modelXml.getLoadSpectrum().addAll(createLoadSpectrumsXml(model.getLoadSpectrums()));

		return modelXml;
	}

	private Relations createRelationsXml(List<RexsRelation> relations) {
		if (relations == null || relations.isEmpty())
			return null;

		Relations relationsXml = objectFactory.createRelations();

		for (RexsRelation relation : relations) {
			relationsXml.getRelation().add(createRelationXml(relation));
		}

		return relationsXml;
	}

	private Relation createRelationXml(RexsRelation relation) {
		Relation relationXml = objectFactory.createRelation();
		relationXml.setId(relation.getId());

		if (relation.getType().equals(RexsRelationType.UNKNOWN)) {
			relationXml.setType(relation.getOriginType());
		} else {
			relationXml.setType(relation.getType().getKey());
		}

		if (relation.getOrder() != null && relation.getOrder() > -1)
			relationXml.setOrder(relation.getOrder());

		relationXml.getRef().addAll(createRefsXml(relation.getRefs()));

		return relationXml;
	}

	private List<Ref> createRefsXml(Collection<RexsRelationRef> refs) {
		if (refs == null || refs.isEmpty())
			return new ArrayList<>();

		List<Ref> refsXml = new ArrayList<>();

		for (RexsRelationRef ref : refs) {
			refsXml.add(createRefXml(ref));
		}

		return refsXml;
	}

	private Ref createRefXml(RexsRelationRef ref) {
		Ref refXml = objectFactory.createRef();
		refXml.setId(ref.getId());
		refXml.setHint(ref.getHint());

		if (ref.getRole().equals(RexsRelationRole.UNKNOWN)) {
			refXml.setRole(ref.getOriginRole());
		} else {
			refXml.setRole(ref.getRole().getKey());
		}

		return refXml;
	}

	private Components createComponentsXml(List<RexsComponent> components) {
		if (components == null || components.isEmpty())
			return null;

		Components componentsXml = objectFactory.createComponents();

		for (RexsComponent component : components) {
			componentsXml.getComponent().add(createComponentXml(component));
		}

		return componentsXml;
	}

	private Component createComponentXml(RexsComponent component) {
		Component componentXml = objectFactory.createComponent();
		componentXml.setId(component.getId());

		if (component.getType().equals(RexsComponentType.UNKNOWN)) {
			componentXml.setType(component.getOriginType());
		} else {
			componentXml.setType(component.getType().getId());
		}
		componentXml.setName(component.getName());

		componentXml.getAttribute().addAll(createAttributesXml(component.getAttributes()));

		return componentXml;
	}

	private List<Attribute> createAttributesXml(Collection<RexsAttribute> attributes) {
		if (attributes == null || attributes.isEmpty())
			return new ArrayList<>();

		List<Attribute> attributesXml = new ArrayList<>();

		for (RexsAttribute attribute : attributes) {
			attributesXml.add(createAttributeXml(attribute));
		}

		return attributesXml;
	}

	private Attribute createAttributeXml(RexsAttribute attribute) {
		Attribute attributeXml = objectFactory.createAttribute();

		if (attribute.getAttributeId().equals(RexsAttributeId.UNKNOWN)) {
			attributeXml.setId(attribute.getOriginAttributeId());
		} else {
			attributeXml.setId(attribute.getAttributeId().getId());
		}

		if (attribute.getUnit().equals(RexsUnitId.UNKNOWN)) {
			attributeXml.setUnit(attribute.getOriginUnit());
		} else {
			attributeXml.setUnit(attribute.getUnit().getId());
		}

		AbstractRexsAttributeValue value = attribute.getRawValue();
		if (value != null) {
			Object valueXml = createAttributeContentXml(value);
			if (valueXml != null)
				attributeXml.getContent().add(valueXml);
		}

		return attributeXml;
	}

	private Object createAttributeContentXml(AbstractRexsAttributeValue value) {
		if (value instanceof RexsAttributeValueScalar) {
			RexsAttributeValueScalar valueScalar = (RexsAttributeValueScalar)value;
			return valueScalar.getRawValue() != null ? valueScalar.getRawValue() : "";

		} else if (value instanceof AbstractRexsAttributeValueArray) {
			return createArrayXml((AbstractRexsAttributeValueArray)value);

		} else if (value instanceof AbstractRexsAttributeValueMatrix) {
			return createMatrixXml((AbstractRexsAttributeValueMatrix)value);

		} else if (value instanceof RexsAttributeValueArrayOfArrays) {
			return createArrayOfArraysXml((RexsAttributeValueArrayOfArrays)value);
		}

		return null;
	}

	private Array createArrayXml(AbstractRexsAttributeValueArray value) {
		Array array = null;

		if (value instanceof RexsAttributeValueArray) {
			List<String> rawValue = ((RexsAttributeValueArray)value).getRawValue();
			if (rawValue == null)
				return null;

			array = objectFactory.createArray();
			for (String valueXml : rawValue) {
				C c = objectFactory.createC();
				if (valueXml == null)
					c.setValue("");
				else
					c.setValue(valueXml);
				array.getContent().add(c);
			}

		} else if (value instanceof RexsAttributeValueArrayBase64) {
			RexsAttributeValueArrayBase64 valueBase64 = (RexsAttributeValueArrayBase64)value;
			if (valueBase64.getRawValue() == null)
				return null;

			array = objectFactory.createArray();
			array.setCode(convertBase64Type(valueBase64.getRawType()));
			array.getContent().add(valueBase64.getRawValue());
		}

		return array;
	}

	private Matrix createMatrixXml(AbstractRexsAttributeValueMatrix value) {
		Matrix matrix = null;

		if (value instanceof RexsAttributeValueMatrix) {
			List<List<String>> rawValue = ((RexsAttributeValueMatrix)value).getRawValue();
			if (rawValue == null)
				return null;

			matrix = objectFactory.createMatrix();
			for (List<String> rawValueRow : rawValue) {
				R row = objectFactory.createR();
				if (rawValueRow != null) {
					for (String rawValueCol : rawValueRow) {
						if (rawValueCol == null)
							row.getC().add("");
						else
							row.getC().add(rawValueCol);
					}
				}
				matrix.getContent().add(row);
			}

		} else if (value instanceof RexsAttributeValueMatrixBase64) {
			RexsAttributeValueMatrixBase64 valueBase64 = (RexsAttributeValueMatrixBase64)value;
			if (valueBase64.getRawValue() == null)
				return null;

			matrix = objectFactory.createMatrix();
			matrix.setCode(convertBase64Type(valueBase64.getRawType()));

			if (valueBase64.getRawRows() >= 0)
				matrix.setRows(valueBase64.getRawRows());

			if (valueBase64.getRawCols() >= 0)
				matrix.setColumns(valueBase64.getRawCols());

			matrix.getContent().add(valueBase64.getRawValue());
		}

		return matrix;
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

	private ArrayOfArrays createArrayOfArraysXml(RexsAttributeValueArrayOfArrays value) {
		ArrayOfArrays arrayOfArrays = objectFactory.createArrayOfArrays();

		List<AbstractRexsAttributeValueArray> rawValue = value.getRawValue();
		for (AbstractRexsAttributeValueArray arrayValue : rawValue) {
			arrayOfArrays.getArray().add(createArrayXml(arrayValue));
		}

		return arrayOfArrays;
	}

	private List<LoadSpectrum> createLoadSpectrumsXml(List<RexsLoadSpectrum> loadSpectrums) {
		if (loadSpectrums == null || loadSpectrums.isEmpty())
			return new ArrayList<>();

		List<LoadSpectrum> loadSpectrumsXml = new ArrayList<>();

		for (RexsLoadSpectrum loadSpectrum : loadSpectrums) {
			loadSpectrumsXml.add(createLoadSpectrumXml(loadSpectrum));
		}

		return loadSpectrumsXml;
	}

	private LoadSpectrum createLoadSpectrumXml(RexsLoadSpectrum loadSpectrum) {
		LoadSpectrum loadSpectrumXml = objectFactory.createLoadSpectrum();
		loadSpectrumXml.setId(loadSpectrum.getId());

		loadSpectrumXml.getLoadCase().addAll(createLoadCasesXml(loadSpectrum.getLoadCases()));
		loadSpectrumXml.setAccumulation(createAccumulationXml(loadSpectrum.getAccumulation()));

		return loadSpectrumXml;
	}

	private List<LoadCase> createLoadCasesXml(Collection<RexsSubModel> loadCases) {
		if (loadCases == null || loadCases.isEmpty())
			return new ArrayList<>();

		List<LoadCase> loadCasesXml = new ArrayList<>();

		for (RexsSubModel loadCase : loadCases) {
			loadCasesXml.add(createLoadCaseXml(loadCase));
		}

		return loadCasesXml;
	}

	private LoadCase createLoadCaseXml(RexsSubModel loadCase) {
		LoadCase loadCaseXml = objectFactory.createLoadCase();
		loadCaseXml.setId(loadCase.getId());

		for (RexsComponent component : loadCase.getComponents()) {
			loadCaseXml.getComponent().add(createComponentXml(component));
		}

		return loadCaseXml;
	}

	private Accumulation createAccumulationXml(RexsSubModel accumulation) {
		if (accumulation == null)
			return null;

		List<RexsComponent> components = accumulation.getComponents();
		if (components == null || components.isEmpty())
			return null;

		Accumulation accumulationXml = objectFactory.createAccumulation();

		for (RexsComponent component : components) {
			accumulationXml.getComponent().add(createComponentXml(component));
		}

		return accumulationXml;
	}

	private RexsModel createModel(Model modelXml) {
		RexsModel model = RexsModelObjectFactory.getInstance().createRexsModel(modelXml.getVersion(), modelXml.getApplicationId(), modelXml.getApplicationVersion());

		if (modelXml.getRelations() != null && modelXml.getRelations().getRelation() != null)
			for (Relation relationXml : modelXml.getRelations().getRelation()) {
				model.addRelation(createRelation(relationXml));
			}

		if (modelXml.getComponents() != null && modelXml.getComponents().getComponent() != null)
			for (Component componentXml : modelXml.getComponents().getComponent()) {
				model.addComponent(createComponent(componentXml));
			}

		if (modelXml.getLoadSpectrum() != null)
			for (LoadSpectrum loadSpectrumXml : modelXml.getLoadSpectrum()) {
				model.addLoadSpectrum(createLoadSpectrum(loadSpectrumXml));
			}

		return model;
	}

	private RexsRelation createRelation(Relation relationXml) {
		RexsRelation relation = RexsModelObjectFactory.getInstance().createRexsRelation(relationXml.getId(), relationXml.getType(), relationXml.getOrder());

		if (relationXml.getRef() != null)
			for (Ref refXml : relationXml.getRef()) {
				RexsRelationRef ref = RexsModelObjectFactory.getInstance().createRexsRelationRef(refXml.getId(), refXml.getRole(), refXml.getHint());
				relation.addRef(ref);
			}

		return relation;
	}

	private RexsComponent createComponent(Component componentXml) {
		RexsComponent component = RexsModelObjectFactory.getInstance().createRexsComponent(componentXml.getId(), componentXml.getType(), componentXml.getName());

		if (componentXml.getAttribute() != null)
			for (Attribute attributeXml : componentXml.getAttribute()) {
				component.addAttribute(createAttribute(attributeXml));
			}

		return component;
	}

	private RexsAttribute createAttribute(Attribute attributeXml) {
		RexsAttribute attribute;

		String unit = attributeXml.getUnit();
		if (unit != null)
			attribute = RexsModelObjectFactory.getInstance().createRexsAttribute(attributeXml.getId(), unit);
		else
			attribute = RexsModelObjectFactory.getInstance().createRexsAttribute(attributeXml.getId());

		attribute.setRawValue(createAttributeValue(attributeXml));

		return attribute;
	}

	private AbstractRexsAttributeValue createAttributeValue(Attribute attributeXml) {
		List<Object> valueContent = attributeXml.getContent();
		if (valueContent == null || valueContent.isEmpty())
			return null;

		Object value = valueContent.get(0);
		if (value instanceof String)
			return new RexsAttributeValueScalar(((String)value).trim());

		Array arrayXml = readArrayElement(attributeXml);
		if (arrayXml != null)
			return createAttributeValue(arrayXml);

		Matrix matrixXml = readMatrixElement(attributeXml);
		if (matrixXml != null)
			return createAttributeValue(matrixXml);

		ArrayOfArrays arrayOfArraysXml = readArrayOfArraysElement(attributeXml);
		if (arrayOfArraysXml != null)
			return createAttributeValue(arrayOfArraysXml);

		return null;
	}

	private AbstractRexsAttributeValueArray createAttributeValue(Array arrayXml) {
		CodeType arrayCode = readArrayCodeType(arrayXml);

		if (arrayCode == null) {
			List<String> value = readStringArrayValue(arrayXml);
			return new RexsAttributeValueArray(value);

		} else {
			String base64 = readArrayBase64Value(arrayXml);

			if (arrayCode == CodeType.INT_32) {
				return new RexsAttributeValueArrayBase64(base64, Base64Type.INT_32);

			} else if (arrayCode == CodeType.FLOAT_32) {
				return new RexsAttributeValueArrayBase64(base64, Base64Type.FLOAT_32);

			} else if (arrayCode == CodeType.FLOAT_64) {
				return new RexsAttributeValueArrayBase64(base64, Base64Type.FLOAT_64);
			}
		}

		return null;
	}

	private AbstractRexsAttributeValueMatrix createAttributeValue(Matrix matrixXml) {
		CodeType matrixCode = readMatrixCodeType(matrixXml);

		if (matrixCode == null) {
			List<List<String>> value = readStringMatrixValue(matrixXml);
			return new RexsAttributeValueMatrix(value);

		} else {
			int rows = readMatrixRows(matrixXml);
			int cols = readMatrixCols(matrixXml);
			String base64 = readMatrixBase64Value(matrixXml);

			if (matrixCode == CodeType.INT_32) {
				return new RexsAttributeValueMatrixBase64(base64, Base64Type.INT_32, rows, cols);

			} else if (matrixCode == CodeType.FLOAT_32) {
				return new RexsAttributeValueMatrixBase64(base64, Base64Type.FLOAT_32, rows, cols);

			} else if (matrixCode == CodeType.FLOAT_64) {
				return new RexsAttributeValueMatrixBase64(base64, Base64Type.FLOAT_64, rows, cols);
			}
		}

		return null;
	}

	private RexsAttributeValueArrayOfArrays createAttributeValue(ArrayOfArrays arrayOfArraysXml) {
		List<AbstractRexsAttributeValueArray> value = new ArrayList<>();

		for (Array arrayXml : arrayOfArraysXml.getArray()) {
			value.add(createAttributeValue(arrayXml));
		}

		return new RexsAttributeValueArrayOfArrays(value);
	}

	private RexsLoadSpectrum createLoadSpectrum(LoadSpectrum loadSpectrumXml) {
		RexsLoadSpectrum loadSpectrum = RexsModelObjectFactory.getInstance().createRexsLoadSpectrum(loadSpectrumXml.getId());

		if (loadSpectrumXml.getLoadCase() != null)
			for (LoadCase loadCaseXml : loadSpectrumXml.getLoadCase()) {
				loadSpectrum.addLoadCase(createLoadCase(loadCaseXml));
			}

		if (loadSpectrumXml.getAccumulation() != null)
			loadSpectrum.setAccumulation(createAccumulation(loadSpectrumXml.getAccumulation()));

		return loadSpectrum;
	}

	private RexsSubModel createLoadCase(LoadCase loadCaseXml) {
		RexsSubModel loadCase = RexsModelObjectFactory.getInstance().createRexsSubModel(loadCaseXml.getId());

		if (loadCaseXml.getComponent() != null)
			for (Component componentXml : loadCaseXml.getComponent()) {
				loadCase.addComponent(createComponent(componentXml));
			}

		return loadCase;
	}

	private RexsSubModel createAccumulation(Accumulation accumulationXml) {
		RexsSubModel accumulation = RexsModelObjectFactory.getInstance().createRexsSubModel();

		if (accumulationXml.getComponent() != null)
			for (Component componentXml : accumulationXml.getComponent()) {
				accumulation.addComponent(createComponent(componentXml));
			}

		return accumulation;
	}

	private Array readArrayElement(Attribute attributeXml) {
		List<Object> valueContent = attributeXml.getContent();
		if (valueContent == null || valueContent.isEmpty())
			return null;

		return valueContent
				.stream()
				.filter(Array.class::isInstance)
				.map(Array.class::cast)
				.findFirst()
				.orElse(null);
	}

	private CodeType readArrayCodeType(Array array) {
		if (array != null)
			return array.getCode();
		return null;
	}

	private List<String> readStringArrayValue(Array array) {
		if (array != null)
			return array.getContent()
					.stream()
					.filter(C.class::isInstance)
					.map(C.class::cast)
					.map(C::getValue)
					.collect(Collectors.toList());

		return Collections.emptyList();
	}

	private String readArrayBase64Value(Array array) {
		if (array != null) {
			return array.getContent()
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

	private Matrix readMatrixElement(Attribute attributeXml) {
		List<Object> valueContent = attributeXml.getContent();
		if (valueContent == null || valueContent.isEmpty())
			return null;

		return valueContent
				.stream()
				.filter(Matrix.class::isInstance)
				.map(Matrix.class::cast)
				.findFirst()
				.orElse(null);
	}

	private CodeType readMatrixCodeType(Matrix matrix) {
		if (matrix != null)
			return matrix.getCode();
		return null;
	}

	private List<List<String>> readStringMatrixValue(Matrix matrix) {
		if (matrix != null)
			return matrix.getContent()
					.stream()
					.filter(R.class::isInstance)
					.map(R.class::cast)
					.map(R::getC)
					.collect(Collectors.toList());

		return Collections.emptyList();
	}

	private int readMatrixRows(Matrix matrix) {
		if (matrix != null && matrix.getRows() != null)
			return matrix.getRows();
		return -1;
	}

	private int readMatrixCols(Matrix matrix) {
		if (matrix != null && matrix.getColumns() != null)
			return matrix.getColumns();
		return -1;
	}

	private String readMatrixBase64Value(Matrix matrix) {
		if (matrix != null) {
			return matrix.getContent()
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

	private ArrayOfArrays readArrayOfArraysElement(Attribute attributeXml) {
		List<Object> valueContent = attributeXml.getContent();
		if (valueContent == null || valueContent.isEmpty())
			return null;

		return valueContent
				.stream()
				.filter(ArrayOfArrays.class::isInstance)
				.map(ArrayOfArrays.class::cast)
				.findFirst()
				.orElse(null);
	}
}
