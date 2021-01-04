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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import info.rexs.db.constants.RexsAttributeId;
import info.rexs.db.constants.RexsUnitId;
import info.rexs.model.jaxb.Array;
import info.rexs.model.jaxb.Attribute;
import info.rexs.model.jaxb.Matrix;
import info.rexs.model.jaxb.ObjectFactory;
import info.rexs.model.jaxb.R;

/**
 * This class represents an attribute of a REXS model.
 *
 * @author FVA GmbH
 */
public class RexsAttribute {

	/** The representation of this attribute in the JAXB model. */
	private Attribute rawAttribute;

	/** The ID of the attribute. */
	private RexsAttributeId attributeId;

	/**
	 * Constructs a new {@link RexsAttribute} for the given {@link Attribute}.
	 *
	 * @param rawAttribute
	 * 				The representation of this attribute in the JAXB model.
	 */
	public RexsAttribute(Attribute rawAttribute) {
		this.rawAttribute = rawAttribute;
		this.attributeId = RexsAttributeId.findById(rawAttribute.getId());
		Objects.requireNonNull(attributeId, "attribute id cannot be empty");
		RexsUnitId unitId = RexsUnitId.findById(rawAttribute.getUnit());
		Objects.requireNonNull(unitId, "unit cannot be empty");
		if (unitId != attributeId.getUnit())
			throw new IllegalArgumentException(String.format("incompatible units (%s <-> %s)", attributeId.getUnit().getId(), unitId.getId()));
	}

	/**
	 * Constructs a new {@link RexsAttribute} from scratch.
	 *
	 * @param attributeId
	 * 				The ID of the attribute.
	 */
	public RexsAttribute(RexsAttributeId attributeId) {
		this.attributeId = attributeId;
		this.rawAttribute = new Attribute();
		this.rawAttribute.setId(attributeId.getId());
		this.rawAttribute.setUnit(attributeId.getUnit().getId());
	}

	/**
	 * @return
	 * 				The ID of the attribute as a {@link RexsAttributeId}.
	 */
	public RexsAttributeId getAttributeId() {
		return attributeId;
	}

	/**
	 * @return
	 * 				The unit of the attribute as {@link RexsUnitId}.
	 */
	public RexsUnitId getUnit() {
		return attributeId.getUnit();
	}

	/**
	 * @return
	 * 				The representation of this attribute in the JAXB model.
	 */
	public Attribute getRawAttribute() {
		return rawAttribute;
	}

	/**
	 * Checks whether the attribute has a value.
	 *
	 * @return
	 * 				{@code true} if the attribute has a value, otherwise {@code false}.
	 */
	public boolean hasValue() {
		List<Object> valueContent = rawAttribute.getContent();
		if (valueContent == null || valueContent.isEmpty())
			return false;

		Object value = valueContent.get(0);
		if (value instanceof String)
			return !((String)value).isEmpty();

		if (value instanceof Array) {
			Array arrayValue = (Array)value;
			List<String> arrayValueColumns = arrayValue.getC();
			return !arrayValueColumns.isEmpty() && arrayValueColumns.get(0) != null;
		}

		if (value instanceof Matrix) {
			Matrix matrixValue = (Matrix)value;
			if (matrixValue.getR() == null || matrixValue.getR().isEmpty())
				return false;
			List<String> matrixValueColumns = matrixValue.getR().get(0).getC();
			return !matrixValueColumns.isEmpty() && matrixValueColumns.get(0) != null;
		}

		return false;
	}

	/**
	 * Returns the string value of the attribute.
	 *
	 * @return
	 * 				The value of the attribute as {@link String}.
	 *
	 * @throws RexsModelAccessException
	 * 				If the attribute has no string value.
	 */
	public String getStringValue() throws RexsModelAccessException {
		String value = readStringValue();

		if (value == null)
			throw new RexsModelAccessException("string value cannot be null");

		return value;
	}

	/**
	 * Returns the boolean value of the attribute.
	 *
	 * @return
	 * 				The value of the attribute as {@link boolean}.
	 *
	 * @throws RexsModelAccessException
	 * 				If the attribute has no boolean value.
	 */
	public boolean getBooleanValue() throws RexsModelAccessException {
		String valueString = readStringValue();
		Boolean value = null;
		if (valueString != null && !valueString.isEmpty())
			value = Boolean.valueOf(valueString);

		if (value == null)
			throw new RexsModelAccessException("boolean value cannot be null");

		return value;
	}

	/**
	 * Returns the integer value of the attribute.
	 *
	 * @return
	 * 				The value of the attribute as {@link Integer}.
	 *
	 * @throws RexsModelAccessException
	 * 				If the attribute has no integer value.
	 */
	public int getIntegerValue() throws RexsModelAccessException {
		String valueString = readStringValue();
		Integer value = null;
		if (valueString != null && !valueString.isEmpty()) {
			try {
				value = Integer.parseInt(valueString);
			} catch (NumberFormatException ex) {
				throw new RexsModelAccessException("cannot read integer value " + valueString, ex);
			}
		}

		if (value == null)
			throw new RexsModelAccessException("integer value cannot be null");

		return value;
	}

	/**
	 * Returns the floating point value of the attribute.
	 *
	 * @param unit
	 * 				The unit of the attribute as {@link RexsUnitId}.
	 *
	 * @return
	 * 				The value of the attribute as {@link Double}.
	 *
	 * @throws RexsModelAccessException
	 * 				If the attribute has no double value or the unit does not match the unit of the attribute.
	 */
	public double getDoubleValue(RexsUnitId unit) throws RexsModelAccessException {
		String valueString = readStringValue();
		Double value = null;
		if (valueString != null && !valueString.isEmpty()) {
			try {
				value = Double.parseDouble(valueString);
				if (Double.isNaN(value))
					value = null;
			} catch (NumberFormatException ex) {
				throw new RexsModelAccessException("cannot read double value " + valueString, ex);
			}
		}

		if (value == null)
			throw new RexsModelAccessException("double value cannot be null");

		checkUnit(unit);

		return value;
	}

	/**
	 * Returns the string array value of the attribute.
	 *
	 * @return
	 * 				The value of the attribute as {@link String[]}.
	 *
	 * @throws RexsModelAccessException
	 * 				If the attribute has no string array value.
	 */
	public String[] getStringArrayValue() throws RexsModelAccessException {
		List<String> valueString = readStringArrayValue();
		String [] value = null;
		if (valueString != null && !valueString.isEmpty())
			value = convertStringListToStringArray(valueString);

		if (value == null)
			throw new RexsModelAccessException("string array value cannot be null");

		return value;
	}

	/**
	 * Returns the boolean array value of the attribute.
	 *
	 * @return
	 * 				The value of the attribute as {@link Boolean[]}.
	 *
	 * @throws RexsModelAccessException
	 * 				If the attribute has no boolean array value.
	 */
	public Boolean[] getBooleanArrayValue() throws RexsModelAccessException {
		List<String> valueString = readStringArrayValue();
		Boolean[] value = null;
		if (valueString != null && !valueString.isEmpty())
			value = convertStringListToBooleanArray(valueString);

		if (value == null)
			throw new RexsModelAccessException("boolean array value cannot be null");

		return value;
	}

	/**
	 * Returns the integer array value of the attribute.
	 *
	 * @return
	 * 				The value of the attribute as {@link Integer[]}.
	 *
	 * @throws RexsModelAccessException
	 * 				If the attribute has no integer array value.
	 */
	public Integer[] getIntegerArrayValue() throws RexsModelAccessException {
		List<String> valueString = readStringArrayValue();
		Integer[] value = null;
		if (valueString != null && !valueString.isEmpty())
			value = convertStringListToIntegerArray(valueString);

		if (value == null)
			throw new RexsModelAccessException("integer array value cannot be null");

		return value;
	}

	/**
	 * Returns the floating point array value of the attribute.
	 *
	 * @param unit
	 * 				The unit of the attribute as {@link RexsUnitId}.
	 *
	 * @return
	 * 				The value of the attribute as {@link Double[]}.
	 *
	 * @throws RexsModelAccessException
	 * 				If the attribute has no double array value or the unit does not match the unit of the attribute.
	 */
	public Double[] getDoubleArrayValue(RexsUnitId unit) throws RexsModelAccessException {
		List<String> valueString = readStringArrayValue();
		Double[] value = null;
		if (valueString != null && !valueString.isEmpty())
			value = convertStringListToDoubleArray(valueString);

		if (value == null)
			throw new RexsModelAccessException("double array value cannot be null");

		checkUnit(unit);

		return value;
	}

	/**
	 * Returns the string matrix value of the attribute.
	 *
	 * @return
	 * 				The value of the attribute as {@link String[][]}.
	 *
	 * @throws RexsModelAccessException
	 * 				If the attribute has no string matrix value.
	 */
	public String[][] getStringMatrixValue() throws RexsModelAccessException {
		List<List<String>> valueString = readStringMatrixValue();
		String[][] value = null;
		if (valueString != null && !valueString.isEmpty())
			value = convertStringMatrixToStringMatrix(valueString);

		if (value == null)
			throw new RexsModelAccessException("string matrix value cannot be null");

		return value;
	}

	/**
	 * Returns the boolean matrix value of the attribute.
	 *
	 * @return
	 * 				The value of the attribute as {@link Boolean[][]}.
	 *
	 * @throws RexsModelAccessException
	 * 				If the attribute has no boolean matrix value.
	 */
	public Boolean[][] getBooleanMatrixValue() throws RexsModelAccessException {
		List<List<String>> valueString = readStringMatrixValue();
		Boolean[][] value = null;
		if (valueString != null && !valueString.isEmpty())
			value = convertStringMatrixToBooleanMatrix(valueString);

		if (value == null)
			throw new RexsModelAccessException("boolean matrix value cannot be null");

		return value;
	}

	/**
	 * Returns the integer matrix value of the attribute.
	 *
	 * @return
	 * 				The value of the attribute as {@link Integer[][]}.
	 *
	 * @throws RexsModelAccessException
	 * 				If the attribute has no integer matrix value.
	 */
	public Integer[][] getIntegerMatrixValue() throws RexsModelAccessException {
		List<List<String>> valueString = readStringMatrixValue();
		Integer[][] value = null;
		if (valueString != null && !valueString.isEmpty())
			value = convertStringMatrixToIntegerMatrix(valueString);

		if (value == null)
			throw new RexsModelAccessException("integer matrix value cannot be null");

		return value;
	}

	/**
	 * Returns the floating point matrix value of the attribute.
	 *
	 * @param unit
	 * 				The unit of the attribute as {@link RexsUnitId}.
	 *
	 * @return
	 * 				The value of the attribute as {@link Double[][]}.
	 *
	 * @throws RexsModelAccessException
	 * 				If the attribute has no double matrix value or the unit does not match the unit of the attribute.
	 */
	public Double[][] getDoubleMatrixValue(RexsUnitId unit) throws RexsModelAccessException {
		List<List<String>> valueString = readStringMatrixValue();
		Double[][] value = null;
		if (valueString != null && !valueString.isEmpty())
			value = convertStringMatrixToDoubleMatrix(valueString);

		if (value == null)
			throw new RexsModelAccessException("double matrix value cannot be null");

		checkUnit(unit);

		return value;
	}

	private String readStringValue() {
		List<Object> valueContent = rawAttribute.getContent();
		if (valueContent == null || valueContent.isEmpty())
			return null;

		Object value = valueContent.get(0);
		if (value instanceof String)
			return (String)value;
		return null;
	}

	private List<String> readStringArrayValue() {
		List<Object> valueContent = rawAttribute.getContent();
		if (valueContent == null || valueContent.isEmpty())
			return Collections.emptyList();

		Object value = valueContent.get(0);
		if (value instanceof Array) {
			Array array = (Array)value;
			return array.getC();
		}
		return Collections.emptyList();
	}

	private List<List<String>> readStringMatrixValue() {
		List<Object> valueContent = rawAttribute.getContent();
		if (valueContent == null || valueContent.isEmpty())
			return Collections.emptyList();

		List<List<String>> matrixValue = new ArrayList<>();
		Object value = valueContent.get(0);
		if (value instanceof Matrix) {
			Matrix matrix = (Matrix)value;
			for (R row : matrix.getR()) {
				matrixValue.add(row.getC());
			}
		}
		return matrixValue;
	}

	private String[] convertStringListToStringArray(List<String> stringList) {
		String[] stringArray = new String[stringList.size()];

		for (int i = 0; i < stringList.size(); i++) {
			stringArray[i] = stringList.get(i);
		}
		return stringArray;
	}

	private Boolean[] convertStringListToBooleanArray(List<String> stringList) {
		Boolean[] booleanArray = new Boolean[stringList.size()];

		for (int i = 0; i < stringList.size(); i++) {
			String stringValue = stringList.get(i);
			if (!stringValue.isEmpty())
				booleanArray[i] = Boolean.valueOf(stringValue);
		}
		return booleanArray;
	}

	private Integer[] convertStringListToIntegerArray(List<String> stringList) throws RexsModelAccessException {
		Integer[] integerArray = new Integer[stringList.size()];

		for (int i = 0; i < stringList.size(); i++) {
			String stringValue = stringList.get(i);
			if (!stringValue.isEmpty()) {
				try {
					integerArray[i] = Integer.parseInt(stringValue);
				} catch (NumberFormatException ex) {
					throw new RexsModelAccessException("cannot read integer value " + stringValue, ex);
				}
			}
		}
		return integerArray;
	}

	private Double[] convertStringListToDoubleArray(List<String> stringList) throws RexsModelAccessException {
		Double[] doubleArray = new Double[stringList.size()];

		for (int i = 0; i < stringList.size(); i++) {
			String stringValue = stringList.get(i);
			if (!stringValue.isEmpty()) {
				try {
					doubleArray[i] = Double.parseDouble(stringValue);
					if (Double.isNaN(doubleArray[i]))
						doubleArray[i] = null;
				} catch (NumberFormatException ex) {
					throw new RexsModelAccessException("cannot read double value " + stringValue, ex);
				}
			}
		}
		return doubleArray;
	}

	private String[][] convertStringMatrixToStringMatrix(List<List<String>> stringMatrix) {
		String[][] newStringMatrix = new String[stringMatrix.size()][stringMatrix.get(0).size()];

		for (int i = 0; i < stringMatrix.size(); i++) {
			List<String> stringArray = stringMatrix.get(i);
			for (int j = 0; j < stringArray.size(); j++) {
				newStringMatrix[i][j] = stringArray.get(j);
			}
		}
		return newStringMatrix;
	}

	private Boolean[][] convertStringMatrixToBooleanMatrix(List<List<String>> stringMatrix) {
		Boolean[][] booleanMatrix = new Boolean[stringMatrix.size()][stringMatrix.get(0).size()];

		for (int i = 0; i < stringMatrix.size(); i++) {
			List<String> stringArray = stringMatrix.get(i);
			for (int j = 0; j < stringArray.size(); j++) {
				String stringValue = stringArray.get(j);
				if (!stringValue.isEmpty()) {
					booleanMatrix[i][j] = Boolean.valueOf(stringValue);
				}
			}
		}
		return booleanMatrix;
	}

	private Integer[][] convertStringMatrixToIntegerMatrix(List<List<String>> stringMatrix) throws RexsModelAccessException {
		Integer[][] doubleMatrix = new Integer[stringMatrix.size()][stringMatrix.get(0).size()];

		for (int i = 0; i < stringMatrix.size(); i++) {
			List<String> stringArray = stringMatrix.get(i);
			for (int j = 0; j < stringArray.size(); j++) {
				String stringValue = stringArray.get(j);
				if (!stringValue.isEmpty()) {
					try {
						doubleMatrix[i][j] = Integer.parseInt(stringValue);
					} catch (NumberFormatException ex) {
						throw new RexsModelAccessException("cannot read integer value " + stringValue, ex);
					}
				}
			}
		}
		return doubleMatrix;
	}

	private Double[][] convertStringMatrixToDoubleMatrix(List<List<String>> stringMatrix) throws RexsModelAccessException {
		Double[][] doubleMatrix = new Double[stringMatrix.size()][stringMatrix.get(0).size()];

		for (int i = 0; i < stringMatrix.size(); i++) {
			List<String> stringArray = stringMatrix.get(i);
			for (int j = 0; j < stringArray.size(); j++) {
				String stringValue = stringArray.get(j);
				if (!stringValue.isEmpty()) {
					try {
						doubleMatrix[i][j] = Double.parseDouble(stringValue);
						if (Double.isNaN(doubleMatrix[i][j]))
							doubleMatrix[i][j] = null;
					} catch (NumberFormatException ex) {
						throw new RexsModelAccessException("cannot read double value " + stringValue, ex);
					}
				}
			}
		}
		return doubleMatrix;
	}

	private void checkUnit(RexsUnitId unitToCheck) throws RexsModelAccessException {
		if (attributeId.getUnit() != unitToCheck)
			throw new RexsModelAccessException(String.format("incompatible units (%s <-> %s)", attributeId.getUnit().getId(), unitToCheck.getId()));
	}

	/**
	 * Sets the string value of the attribute.
	 *
	 * @param value
	 * 				The value of the attribute as {@link String}.
	 */
	public void setStringValue(String value) {
		rawAttribute.getContent().clear();
		rawAttribute.getContent().add(value);
	}

	/**
	 * Sets the boolean value of the attribute.
	 *
	 * @param value
	 * 				The value of the attribute as {@link Boolean}.
	 */
	public void setBooleanValue(boolean value) {
		setStringValue(Boolean.toString(value));
	}

	/**
	 * Sets the integer value of the attribute.
	 *
	 * @param value
	 * 				The value of the attribute as {@link Integer}.
	 */
	public void setIntegerValue(int value) {
		setStringValue(Integer.toString(value));
	}

	/**
	 * Sets the floating point value of the attribute.
	 *
	 * @param value
	 * 				The value of the attribute as {@link Double}.
	 */
	public void setDoubleValue(double value) {
		setStringValue(Double.toString(value));
	}

	private void setArrayValue(Object[] value) {
		if (value == null)
			return;

		ObjectFactory objectFactory = new ObjectFactory();
		Array array = objectFactory.createArray();
		for (int i = 0; i < value.length; i++) {
			if (value[i] == null)
				array.getC().add("");
			else
				array.getC().add(String.valueOf(value[i]));
		}

		rawAttribute.getContent().clear();
		rawAttribute.getContent().add(array);
	}

	/**
	 * Sets the string array value of the attribute.
	 *
	 * @param value
	 * 				The value of the attribute as {@link String[]}.
	 */
	public void setStringArrayValue(String[] value) {
		setArrayValue(value);
	}

	/**
	 * Sets the bolean array value of the attribute.
	 *
	 * @param value
	 * 				The value of the attribute as {@link Boolean[]}.
	 */
	public void setBooleanArrayValue(Boolean[] value) {
		setArrayValue(value);
	}

	/**
	 * Sets the integer array value of the attribute.
	 *
	 * @param value
	 * 				The value of the attribute as {@link Integer[]}.
	 */
	public void setIntegerArrayValue(Integer[] value) {
		setArrayValue(value);
	}

	/**
	 * Sets the floating point array value of the attribute.
	 *
	 * @param value
	 * 				The value of the attribute as {@link Double[]}.
	 */
	public void setDoubleArrayValue(Double[] value) {
		setArrayValue(value);
	}

	private void setMatrixValue(Object[][] value) {
		if (value == null)
			return;

		ObjectFactory objectFactory = new ObjectFactory();
		Matrix matrix = objectFactory.createMatrix();
		for (int i = 0; i < value.length; i++) {
			R row = objectFactory.createR();

			if (value[i] != null) {
				for (int j = 0; j < value[i].length; j++) {
					if (value[i][j] == null)
						row.getC().add("");
					else
						row.getC().add(String.valueOf(value[i][j]));
				}
			}
			matrix.getR().add(row);
		}

		rawAttribute.getContent().clear();
		rawAttribute.getContent().add(matrix);
	}

	/**
	 * Sets the string matrix value of the attribute.
	 *
	 * @param value
	 * 				The value of the attribute as {@link String[][]}.
	 */
	public void setStringMatrixValue(String[][] value) {
		setMatrixValue(value);
	}

	/**
	 * Sets the boolean matrix value of the attribute.
	 *
	 * @param value
	 * 				The value of the attribute as {@link Boolean[][]}.
	 */
	public void setBooleanMatrixValue(Boolean[][] value) {
		setMatrixValue(value);
	}

	/**
	 * Sets the integer matrix value of the attribute.
	 *
	 * @param value
	 * 				The value of the attribute as {@link Integer[][]}.
	 */
	public void setIntegerMatrixValue(Integer[][] value) {
		setMatrixValue(value);
	}

	/**
	 * Sets the floating point matrix value of the attribute.
	 *
	 * @param value
	 * 				The value of the attribute as {@link Double[][]}.
	 */
	public void setDoubleMatrixValue(Double[][] value) {
		setMatrixValue(value);
	}
}
