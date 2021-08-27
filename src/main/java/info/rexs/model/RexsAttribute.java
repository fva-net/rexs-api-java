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
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import info.rexs.db.constants.RexsAttributeId;
import info.rexs.db.constants.RexsUnitId;
import info.rexs.model.jaxb.Array;
import info.rexs.model.jaxb.ArrayOfArrays;
import info.rexs.model.jaxb.Attribute;
import info.rexs.model.jaxb.C;
import info.rexs.model.jaxb.CodeType;
import info.rexs.model.jaxb.Matrix;
import info.rexs.model.jaxb.ObjectFactory;
import info.rexs.model.jaxb.R;
import info.rexs.model.util.Base64Utils;
import info.rexs.model.util.JavaDatatypeUtils;

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
	protected RexsAttribute(Attribute rawAttribute) {
		this.rawAttribute = rawAttribute;
		this.attributeId = RexsAttributeId.findById(rawAttribute.getId());
		Objects.requireNonNull(attributeId, "attribute id cannot be empty");
		RexsUnitId unitId = RexsUnitId.findById(rawAttribute.getUnit());
		Objects.requireNonNull(unitId, "unit cannot be empty");
		checkUnit(unitId);
	}

	/**
	 * Constructs a new {@link RexsAttribute} from scratch.
	 *
	 * @param attributeId
	 * 				The ID of the attribute.
	 */
	protected RexsAttribute(RexsAttributeId attributeId) {
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

		Array array = readArrayElement();
		if (array != null)
			return hasValue(array);

		Matrix matrix = readMatrixElement();
		if (matrix != null)
			return hasValue(matrix);

		ArrayOfArrays arrayOfArrays = readArrayOfArraysElement();
		if (arrayOfArrays != null)
			return hasValue(arrayOfArrays);

		return false;
	}

	private boolean hasValue(Array array) {
		if (array.getContent().isEmpty())
			return false;

		boolean hasCValue = array.getContent()
			.stream()
			.filter(C.class::isInstance)
			.map(C.class::cast)
			.map(C::getValue)
			.filter(Objects::nonNull)
			.anyMatch(value -> !value.isEmpty());

		if (hasCValue)
			return true;

		return array.getContent()
			.stream()
			.filter(String.class::isInstance)
			.map(String.class::cast)
			.filter(Objects::nonNull)
			.map(String::trim)
			.anyMatch(value -> !value.isEmpty());
	}

	private boolean hasValue(Matrix matrix) {
		if (matrix.getContent().isEmpty())
			return false;

		boolean hasCValue = matrix.getContent()
			.stream()
			.filter(R.class::isInstance)
			.map(R.class::cast)
			.flatMap(row -> row.getC().stream())
			.filter(Objects::nonNull)
			.anyMatch(value -> !value.isEmpty());

		if (hasCValue)
			return true;

		return matrix.getContent()
			.stream()
			.filter(String.class::isInstance)
			.map(String.class::cast)
			.filter(Objects::nonNull)
			.map(String::trim)
			.anyMatch(value -> !value.isEmpty());
	}

	private boolean hasValue(ArrayOfArrays arrayOfArrays) {
		if (arrayOfArrays.getArray().isEmpty())
			return false;

		return arrayOfArrays.getArray()
			.stream()
			.anyMatch(this::hasValue);
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
	public String getStringValue() {
		String value = readStringValue();

		if (value == null)
			throw new RexsModelAccessException(
					"string value cannot be null for attribute " + this.getAttributeId().getId());

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
	public boolean getBooleanValue() {
		String valueString = readStringValue();
		Boolean value = null;
		if (valueString != null && !valueString.isEmpty())
			value = Boolean.valueOf(valueString);

		if (value == null)
			throw new RexsModelAccessException(
					"boolean value cannot be null for attribute " + this.getAttributeId().getId());

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
	public int getIntegerValue() {
		String valueString = readStringValue();
		Integer value = null;
		if (valueString != null && !valueString.isEmpty()) {
			try {
				value = Integer.parseInt(valueString);
			} catch (NumberFormatException ex) {
				throw new RexsModelAccessException(
						"cannot read integer value " + valueString + " from attribute " + this.getAttributeId().getId(),
						ex);
			}
		}

		if (value == null)
			throw new RexsModelAccessException(
					"integer value cannot be null for attribute " + this.getAttributeId().getId());

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
	public double getDoubleValue(RexsUnitId unit) {
		String valueString = readStringValue();
		Double value = null;
		if (valueString != null && !valueString.isEmpty()) {
			try {
				value = Double.parseDouble(valueString);
				if (Double.isNaN(value))
					value = null;
			} catch (NumberFormatException ex) {
				throw new RexsModelAccessException(
						"cannot read double value " + valueString + " from attribute " + this.getAttributeId().getId(),
						ex);
			}
		}

		if (value == null)
			throw new RexsModelAccessException(
					"double value cannot be null for attribute " + this.getAttributeId().getId());

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
	public String[] getStringArrayValue() {
		List<String> valueString = readStringArrayValue();
		String [] value = null;
		if (valueString != null && !valueString.isEmpty())
			value = convertStringListToStringArray(valueString);

		if (value == null)
			throw new RexsModelAccessException(
					"string array value cannot be null for attribute " + this.getAttributeId().getId());

		return value;
	}

	/**
	 * Returns the enum array value of the attribute.
	 *
	 * @return
	 * 				The value of the attribute as {@link String[]}.
	 *
	 * @throws RexsModelAccessException
	 * 				If the attribute has no enum array value.
	 */
	public String[] getEnumArrayValue() {
		List<String> valueString = readStringArrayValue();
		String [] value = null;
		if (valueString != null && !valueString.isEmpty())
			value = convertStringListToStringArray(valueString);

		if (value == null)
			throw new RexsModelAccessException(
					"enum array value cannot be null for attribute " + this.getAttributeId().getId());

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
	public Boolean[] getBooleanArrayValue() {
		List<String> valueString = readStringArrayValue();
		Boolean[] value = null;
		if (valueString != null && !valueString.isEmpty())
			value = convertStringListToBooleanArray(valueString);

		if (value == null)
			throw new RexsModelAccessException(
					"boolean array value cannot be null for attribute " + this.getAttributeId().getId());

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
	public Integer[] getIntegerArrayValue() {
		Integer[] value = null;

		CodeType arrayCode = readArrayCodeType();
		if (arrayCode == null) {
			List<String> valueString = readStringArrayValue();
			if (valueString != null && !valueString.isEmpty())
				value = convertStringListToIntegerArrayBoxed(valueString);

		} else if (arrayCode == CodeType.INT_32) {
			String base64 = readArrayBase64Value();
			value = Base64Utils.decodeInt32ArrayBoxed(base64);
		}

		if (value == null)
			throw new RexsModelAccessException(
					"integer array value cannot be null for attribute " + this.getAttributeId().getId());

		return value;
	}

	/**
	 * Returns the integer array value of the attribute.
	 *
	 * @return
	 * 				The value of the attribute as {@link int[]}.
	 *
	 * @throws RexsModelAccessException
	 * 				If the attribute has no integer array value.
	 */
	public int[] getIntegerArrayValueUnboxed() {
		int[] value = null;

		CodeType arrayCode = readArrayCodeType();
		if (arrayCode == null) {
			List<String> valueString = readStringArrayValue();
			if (valueString != null && !valueString.isEmpty())
				value = convertStringListToIntegerArrayUnboxed(valueString);

		} else if (arrayCode == CodeType.INT_32) {
			String base64 = readArrayBase64Value();
			value = Base64Utils.decodeInt32Array(base64);
		}

		if (value == null)
			throw new RexsModelAccessException(
					"integer array value cannot be null for attribute " + this.getAttributeId().getId());

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
	public Double[] getDoubleArrayValue(RexsUnitId unit) {
		Double[] value = null;

		CodeType arrayCode = readArrayCodeType();
		if (arrayCode == null) {
			List<String> valueString = readStringArrayValue();
			if (valueString != null && !valueString.isEmpty())
				value = convertStringListToDoubleArrayBoxed(valueString);

		} else if (arrayCode == CodeType.FLOAT_32) {
			String base64 = readArrayBase64Value();
			value = Base64Utils.decodeFloat32ArrayBoxed(base64);

		} else if (arrayCode == CodeType.FLOAT_64) {
			String base64 = readArrayBase64Value();
			value = Base64Utils.decodeFloat64ArrayBoxed(base64);
		}

		if (value == null)
			throw new RexsModelAccessException(
					"double array value cannot be null for attribute " + this.getAttributeId().getId());

		checkUnit(unit);

		return value;
	}

	/**
	 * Returns the floating point array value of the attribute.
	 *
	 * @param unit
	 * 				The unit of the attribute as {@link RexsUnitId}.
	 *
	 * @return
	 * 				The value of the attribute as {@link double[]}.
	 *
	 * @throws RexsModelAccessException
	 * 				If the attribute has no double array value or the unit does not match the unit of the attribute.
	 */
	public double[] getDoubleArrayValueUnboxed(RexsUnitId unit) {
		double[] value = null;

		CodeType arrayCode = readArrayCodeType();
		if (arrayCode == null) {
			List<String> valueString = readStringArrayValue();
			if (valueString != null && !valueString.isEmpty())
				value = convertStringListToDoubleArrayUnboxed(valueString);

		} else if (arrayCode == CodeType.FLOAT_32) {
			String base64 = readArrayBase64Value();
			float[] floatArray = Base64Utils.decodeFloat32Array(base64);
			value = convertFloatArrayToDoubleArray(floatArray);

		} else if (arrayCode == CodeType.FLOAT_64) {
			String base64 = readArrayBase64Value();
			value = Base64Utils.decodeFloat64Array(base64);
		}

		if (value == null)
			throw new RexsModelAccessException(
					"double array value cannot be null for attribute " + this.getAttributeId().getId());

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
	public String[][] getStringMatrixValue() {
		List<List<String>> valueString = readStringMatrixValue();
		String[][] value = null;
		if (valueString != null && !valueString.isEmpty())
			value = convertStringMatrixToStringMatrix(valueString);

		if (value == null)
			throw new RexsModelAccessException(
					"string matrix value cannot be null for attribute " + this.getAttributeId().getId());

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
	public Boolean[][] getBooleanMatrixValue() {
		List<List<String>> valueString = readStringMatrixValue();
		Boolean[][] value = null;
		if (valueString != null && !valueString.isEmpty())
			value = convertStringMatrixToBooleanMatrix(valueString);

		if (value == null)
			throw new RexsModelAccessException(
					"boolean matrix value cannot be null for attribute " + this.getAttributeId().getId());

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
	public Integer[][] getIntegerMatrixValue() {
		Integer[][] value = null;

		CodeType matrixCode = readMatrixCodeType();
		if (matrixCode == null) {
			List<List<String>> valueString = readStringMatrixValue();
			if (valueString != null && !valueString.isEmpty())
				value = convertStringMatrixToIntegerMatrixBoxed(valueString);

		} else if (matrixCode == CodeType.INT_32) {
			int rows = readMatrixRows();
			if (rows < 0)
				throw new RexsModelAccessException(
						"integer matrix with base64 value requires number of rows for attribute " + this.getAttributeId().getId());

			int cols = readMatrixCols();
			if (cols < 0)
				throw new RexsModelAccessException(
						"integer matrix with base64 value requires number of columns for attribute " + this.getAttributeId().getId());

			String base64 = readMatrixBase64Value();
			value = Base64Utils.decodeInt32MatrixBoxed(base64, rows, cols);
		}

		if (value == null)
			throw new RexsModelAccessException(
					"integer matrix value cannot be null for attribute " + this.getAttributeId().getId());

		return value;
	}

	/**
	 * Returns the integer matrix value of the attribute.
	 *
	 * @return
	 * 				The value of the attribute as {@link int[][]}.
	 *
	 * @throws RexsModelAccessException
	 * 				If the attribute has no integer matrix value.
	 */
	public int[][] getIntegerMatrixValueUnboxed() {
		int[][] value = null;

		CodeType matrixCode = readMatrixCodeType();
		if (matrixCode == null) {
			List<List<String>> valueString = readStringMatrixValue();
			if (valueString != null && !valueString.isEmpty())
				value = convertStringMatrixToIntegerMatrixUnboxed(valueString);

		} else if (matrixCode == CodeType.INT_32) {
			int rows = readMatrixRows();
			if (rows < 0)
				throw new RexsModelAccessException(
						"integer matrix with base64 value requires number of rows for attribute " + this.getAttributeId().getId());

			int cols = readMatrixCols();
			if (cols < 0)
				throw new RexsModelAccessException(
						"integer matrix with base64 value requires number of columns for attribute " + this.getAttributeId().getId());

			String base64 = readMatrixBase64Value();
			value = Base64Utils.decodeInt32Matrix(base64, rows, cols);
		}

		if (value == null)
			throw new RexsModelAccessException(
					"integer matrix value cannot be null for attribute " + this.getAttributeId().getId());

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
	public Double[][] getDoubleMatrixValue(RexsUnitId unit) {
		Double[][] value = null;

		CodeType matrixCode = readMatrixCodeType();
		if (matrixCode == null) {
			List<List<String>> valueString = readStringMatrixValue();
			if (valueString != null && !valueString.isEmpty())
				value = convertStringMatrixToDoubleMatrixBoxed(valueString);

		} else {
			int rows = readMatrixRows();
			if (rows < 0)
				throw new RexsModelAccessException(
						"double matrix with base64 value requires number of rows for attribute " + this.getAttributeId().getId());

			int cols = readMatrixCols();
			if (cols < 0)
				throw new RexsModelAccessException(
						"double matrix with base64 value requires number of columns for attribute " + this.getAttributeId().getId());

			if (matrixCode == CodeType.FLOAT_32) {
				String base64 = readMatrixBase64Value();
				value = Base64Utils.decodeFloat32MatrixBoxed(base64, rows, cols);

			} else if (matrixCode == CodeType.FLOAT_64) {
				String base64 = readMatrixBase64Value();
				value = Base64Utils.decodeFloat64MatrixBoxed(base64, rows, cols);
			}
		}

		if (value == null)
			throw new RexsModelAccessException(
					"double matrix value cannot be null for attribute " + this.getAttributeId().getId());

		checkUnit(unit);

		return value;
	}

	/**
	 * Returns the floating point matrix value of the attribute.
	 *
	 * @param unit
	 * 				The unit of the attribute as {@link RexsUnitId}.
	 *
	 * @return
	 * 				The value of the attribute as {@link double[][]}.
	 *
	 * @throws RexsModelAccessException
	 * 				If the attribute has no double matrix value or the unit does not match the unit of the attribute.
	 */
	public double[][] getDoubleMatrixValueUnboxed(RexsUnitId unit) {
		double[][] value = null;

		CodeType matrixCode = readMatrixCodeType();
		if (matrixCode == null) {
			List<List<String>> valueString = readStringMatrixValue();
			if (valueString != null && !valueString.isEmpty())
				value = convertStringMatrixToDoubleMatrixUnboxed(valueString);

		} else {
			int rows = readMatrixRows();
			if (rows < 0)
				throw new RexsModelAccessException(
						"double matrix with base64 value requires number of rows for attribute " + this.getAttributeId().getId());

			int cols = readMatrixCols();
			if (cols < 0)
				throw new RexsModelAccessException(
						"double matrix with base64 value requires number of columns for attribute " + this.getAttributeId().getId());

			if (matrixCode == CodeType.FLOAT_32) {
				String base64 = readMatrixBase64Value();
				float[][] floatMatrix = Base64Utils.decodeFloat32Matrix(base64, rows, cols);
				value = convertFloatMatrixToDoubleMatrix(floatMatrix);

			} else if (matrixCode == CodeType.FLOAT_64) {
				String base64 = readMatrixBase64Value();
				value = Base64Utils.decodeFloat64Matrix(base64, rows, cols);
			}
		}

		if (value == null)
			throw new RexsModelAccessException(
					"double matrix value cannot be null for attribute " + this.getAttributeId().getId());

		checkUnit(unit);

		return value;
	}

	/**
	 * Returns the array of integer arrays value of the attribute.
	 *
	 * @return
	 * 				The value of the attribute as {@link List}.
	 *
	 * @throws RexsModelAccessException
	 * 				If the attribute has no array of integer array value.
	 */
	public List<Integer[]> getArrayOfIntegerArraysValue() {
		List<Integer[]> value = new ArrayList<>();

		ArrayOfArrays arrayOfArrays = readArrayOfArraysElement();
		if (arrayOfArrays != null) {

			for (Array array : arrayOfArrays.getArray()) {
				Integer[] arrayValue = null;

				CodeType arrayCode = readArrayCodeType(array);
				if (arrayCode == null) {
					List<String> valueString = readStringArrayValue(array);
					if (valueString != null && !valueString.isEmpty())
						arrayValue = convertStringListToIntegerArrayBoxed(valueString);

				} else if (arrayCode == CodeType.INT_32) {
					String base64 = readArrayBase64Value(array);
					arrayValue = Base64Utils.decodeInt32ArrayBoxed(base64);
				}

				if (arrayValue == null)
					throw new RexsModelAccessException(
							"integer array value in array of integer arrays cannot be null for attribute " + this.getAttributeId().getId());

				value.add(arrayValue);
			}
		}

		if (value.isEmpty())
			throw new RexsModelAccessException(
					"array of integer arrays value cannot be null for attribute " + this.getAttributeId().getId());

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
		Array array = readArrayElement();
		return readStringArrayValue(array);
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

	private Array readArrayElement() {
		List<Object> valueContent = rawAttribute.getContent();
		if (valueContent == null || valueContent.isEmpty())
			return null;

		return valueContent
				.stream()
				.filter(Array.class::isInstance)
				.map(Array.class::cast)
				.findFirst()
				.orElse(null);
	}

	private CodeType readArrayCodeType() {
		Array array = readArrayElement();
		return readArrayCodeType(array);
	}

	private CodeType readArrayCodeType(Array array) {
		if (array != null)
			return array.getCode();

		return null;
	}

	private String readArrayBase64Value() {
		Array array = readArrayElement();
		return readArrayBase64Value(array);
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

	private List<List<String>> readStringMatrixValue() {
		Matrix matrix = readMatrixElement();
		if (matrix != null)
			return matrix.getContent()
					.stream()
					.filter(R.class::isInstance)
					.map(R.class::cast)
					.map(R::getC)
					.collect(Collectors.toList());

		return Collections.emptyList();
	}

	private Matrix readMatrixElement() {
		List<Object> valueContent = rawAttribute.getContent();
		if (valueContent == null || valueContent.isEmpty())
			return null;

		return valueContent
				.stream()
				.filter(Matrix.class::isInstance)
				.map(Matrix.class::cast)
				.findFirst()
				.orElse(null);
	}

	private CodeType readMatrixCodeType() {
		Matrix matrix = readMatrixElement();
		if (matrix != null)
			return matrix.getCode();

		return null;
	}

	private int readMatrixRows() {
		Matrix matrix = readMatrixElement();
		if (matrix != null && matrix.getRows() != null)
			return matrix.getRows();

		return -1;
	}

	private int readMatrixCols() {
		Matrix matrix = readMatrixElement();
		if (matrix != null && matrix.getColumns() != null)
			return matrix.getColumns();

		return -1;
	}

	private String readMatrixBase64Value() {
		Matrix matrix = readMatrixElement();
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

	private ArrayOfArrays readArrayOfArraysElement() {
		List<Object> valueContent = rawAttribute.getContent();
		if (valueContent == null || valueContent.isEmpty())
			return null;

		return valueContent
				.stream()
				.filter(ArrayOfArrays.class::isInstance)
				.map(ArrayOfArrays.class::cast)
				.findFirst()
				.orElse(null);
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

	private Integer[] convertStringListToIntegerArrayBoxed(List<String> stringList) {
		Integer[] integerArray = new Integer[stringList.size()];

		for (int i = 0; i < stringList.size(); i++) {
			String stringValue = stringList.get(i);
			if (!stringValue.isEmpty()) {
				try {
					integerArray[i] = Integer.parseInt(stringValue);
				} catch (NumberFormatException ex) {
					throw new RexsModelAccessException("cannot read integer value " + stringValue + " from attribute "
							+ this.getAttributeId().getId(), ex);
				}
			}
		}
		return integerArray;
	}

	private int[] convertStringListToIntegerArrayUnboxed(List<String> stringList) {
		int[] integerArray = new int[stringList.size()];

		for (int i = 0; i < stringList.size(); i++) {
			String stringValue = stringList.get(i);
			if (!stringValue.isEmpty()) {
				try {
					integerArray[i] = Integer.parseInt(stringValue);
				} catch (NumberFormatException ex) {
					throw new RexsModelAccessException("cannot read integer value " + stringValue + " from attribute "
							+ this.getAttributeId().getId(), ex);
				}
			}
		}
		return integerArray;
	}

	private Double[] convertStringListToDoubleArrayBoxed(List<String> stringList) {
		Double[] doubleArray = new Double[stringList.size()];

		for (int i = 0; i < stringList.size(); i++) {
			String stringValue = stringList.get(i);
			if (!stringValue.isEmpty()) {
				try {
					doubleArray[i] = Double.parseDouble(stringValue);
					if (Double.isNaN(doubleArray[i]))
						doubleArray[i] = null;
				} catch (NumberFormatException ex) {
					throw new RexsModelAccessException("cannot read double value " + stringValue + " from attribute "
							+ this.getAttributeId().getId(), ex);
				}
			}
		}
		return doubleArray;
	}

	private double[] convertStringListToDoubleArrayUnboxed(List<String> stringList) {
		double[] doubleArray = new double[stringList.size()];

		for (int i = 0; i < stringList.size(); i++) {
			String stringValue = stringList.get(i);
			if (!stringValue.isEmpty()) {
				try {
					double parsedDouble = Double.parseDouble(stringValue);
					if (!Double.isNaN(parsedDouble))
						doubleArray[i] = parsedDouble;
				} catch (NumberFormatException ex) {
					throw new RexsModelAccessException("cannot read double value " + stringValue + " from attribute "
							+ this.getAttributeId().getId(), ex);
				}
			}
		}
		return doubleArray;
	}

	private double[] convertFloatArrayToDoubleArray(float[] input) {
		if (input == null)
			return null;

		double[] output = new double[input.length];
		for (int i = 0; i < input.length; i++) {
			output[i] = input[i];
		}
		return output;
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

	private Integer[][] convertStringMatrixToIntegerMatrixBoxed(List<List<String>> stringMatrix) {
		Integer[][] integerMatrix = new Integer[stringMatrix.size()][stringMatrix.get(0).size()];

		for (int i = 0; i < stringMatrix.size(); i++) {
			List<String> stringArray = stringMatrix.get(i);
			for (int j = 0; j < stringArray.size(); j++) {
				String stringValue = stringArray.get(j);
				if (!stringValue.isEmpty()) {
					try {
						integerMatrix[i][j] = Integer.parseInt(stringValue);
					} catch (NumberFormatException ex) {
						throw new RexsModelAccessException("cannot read integer value " + stringValue
								+ " from attribute " + this.getAttributeId().getId(), ex);
					}
				}
			}
		}
		return integerMatrix;
	}

	private int[][] convertStringMatrixToIntegerMatrixUnboxed(List<List<String>> stringMatrix) {
		int[][] integerMatrix = new int[stringMatrix.size()][stringMatrix.get(0).size()];

		for (int i = 0; i < stringMatrix.size(); i++) {
			List<String> stringArray = stringMatrix.get(i);
			for (int j = 0; j < stringArray.size(); j++) {
				String stringValue = stringArray.get(j);
				if (!stringValue.isEmpty()) {
					try {
						integerMatrix[i][j] = Integer.parseInt(stringValue);
					} catch (NumberFormatException ex) {
						throw new RexsModelAccessException("cannot read integer value " + stringValue
								+ " from attribute " + this.getAttributeId().getId(), ex);
					}
				}
			}
		}
		return integerMatrix;
	}

	private Double[][] convertStringMatrixToDoubleMatrixBoxed(List<List<String>> stringMatrix) {
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
						throw new RexsModelAccessException("cannot read double value " + stringValue
								+ " from attribute " + this.getAttributeId().getId(), ex);
					}
				}
			}
		}
		return doubleMatrix;
	}

	private double[][] convertStringMatrixToDoubleMatrixUnboxed(List<List<String>> stringMatrix) {
		double[][] doubleMatrix = new double[stringMatrix.size()][stringMatrix.get(0).size()];

		for (int i = 0; i < stringMatrix.size(); i++) {
			List<String> stringArray = stringMatrix.get(i);
			for (int j = 0; j < stringArray.size(); j++) {
				String stringValue = stringArray.get(j);
				if (!stringValue.isEmpty()) {
					try {
						double parsedDouble = Double.parseDouble(stringValue);
						if (!Double.isNaN(parsedDouble))
							doubleMatrix[i][j] = parsedDouble;
					} catch (NumberFormatException ex) {
						throw new RexsModelAccessException("cannot read double value " + stringValue
								+ " from attribute " + this.getAttributeId().getId(), ex);
					}
				}
			}
		}
		return doubleMatrix;
	}

	private double[][] convertFloatMatrixToDoubleMatrix(float[][] input) {
		if (input == null)
			return null;

		int colLength = Arrays.stream(input)
				.mapToInt(col -> col.length)
				.max()
				.orElse(0);

		double[][] output = new double[input.length][colLength];
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[i].length; j++) {
				output[i][j] = input[i][j];
			}
		}
		return output;
	}

	private void checkUnit(RexsUnitId unitToCheck) {
		if (attributeId.getUnit() != unitToCheck && attributeId.getUnit() != RexsUnitId.UNKNOWN)
			throw new RexsModelAccessException(String.format("incompatible units (%s <-> %s) on %s attribute",
					attributeId.getUnit().getId(), unitToCheck.getId(), attributeId.getId()));
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
			C c = objectFactory.createC();
			if (value[i] == null)
				c.setValue("");
			else
				c.setValue(String.valueOf(value[i]));
			array.getContent().add(c);
		}

		rawAttribute.getContent().clear();
		rawAttribute.getContent().add(array);
	}

	private void setArrayValueBase64(String base64Value, CodeType codeType) {
		if (base64Value == null)
			return;

		ObjectFactory objectFactory = new ObjectFactory();
		Array array = objectFactory.createArray();
		array.setCode(codeType);
		array.getContent().add(base64Value);

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
	 * Sets the enum array value of the attribute.
	 *
	 * @param value
	 * 				The value of the attribute as {@link String[]}.
	 */
	public void setEnumArrayValue(String[] value) {
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
	 * Sets the integer array value of the attribute.
	 *
	 * @param value
	 * 				The value of the attribute as {@link int[]}.
	 */
	public void setIntegerArrayValue(int[] value) {
		setArrayValue(JavaDatatypeUtils.boxIntArray(value));
	}

	/**
	 * Sets the integer array value of the attribute with Base64 encoding.
	 *
	 * @param value
	 * 				The value of the attribute as {@link int[]}.
	 */
	public void setIntegerArrayValueBase64(int[] value) {
		String base64Value = Base64Utils.encodeInt32Array(value);
		setArrayValueBase64(base64Value, CodeType.INT_32);
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

	/**
	 * Sets the floating point array value of the attribute.
	 *
	 * @param value
	 * 				The value of the attribute as {@link double[]}.
	 */
	public void setDoubleArrayValue(double[] value) {
		setArrayValue(JavaDatatypeUtils.boxDoubleArray(value));
	}

	/**
	 * Sets the floating point array value of the attribute.
	 *
	 * @param value
	 * 				The value of the attribute as {@link float[]}.
	 */
	public void setDoubleArrayValue(float[] value) {
		setArrayValue(JavaDatatypeUtils.boxFloatArray(value));
	}

	/**
	 * Sets the floating point array value of the attribute with Base64 encoding.
	 *
	 * @param value
	 * 				The value of the attribute as {@link float[]}.
	 */
	public void setDoubleArrayValueBase64(float[] value) {
		String base64Value = Base64Utils.encodeFloat32Array(value);
		setArrayValueBase64(base64Value, CodeType.FLOAT_32);
	}

	/**
	 * Sets the floating point array value of the attribute with Base64 encoding.
	 *
	 * @param value
	 * 				The value of the attribute as {@link double[]}.
	 */
	public void setDoubleArrayValueBase64(double[] value) {
		String base64Value = Base64Utils.encodeFloat64Array(value);
		setArrayValueBase64(base64Value, CodeType.FLOAT_64);
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
			matrix.getContent().add(row);
		}

		rawAttribute.getContent().clear();
		rawAttribute.getContent().add(matrix);
	}

	private void setMatrixValueBase64(String base64Value, CodeType codeType, int rows, int cols) {
		if (base64Value == null)
			return;

		ObjectFactory objectFactory = new ObjectFactory();
		Matrix matrix = objectFactory.createMatrix();
		matrix.setCode(codeType);
		matrix.setRows(rows);
		matrix.setColumns(cols);
		matrix.getContent().add(base64Value);

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
	 * Sets the integer matrix value of the attribute.
	 *
	 * @param value
	 * 				The value of the attribute as {@link int[][]}.
	 */
	public void setIntegerMatrixValue(int[][] value) {
		setMatrixValue(JavaDatatypeUtils.boxIntMatrix(value));
	}

	/**
	 * Sets the integer matrix value of the attribute with Base64 encoding.
	 *
	 * @param value
	 * 				The value of the attribute as {@link int[][]}.
	 */
	public void setIntegerMatrixValueBase64(int[][] value) {
		int rows = value.length;
		int cols = Arrays.stream(value).mapToInt(col -> col.length).max().orElse(0);
		String base64Value = Base64Utils.encodeInt32Matrix(value);
		setMatrixValueBase64(base64Value, CodeType.INT_32, rows, cols);
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

	/**
	 * Sets the floating point matrix value of the attribute.
	 *
	 * @param value
	 * 				The value of the attribute as {@link double[][]}.
	 */
	public void setDoubleMatrixValue(double[][] value) {
		setMatrixValue(JavaDatatypeUtils.boxDoubleMatrix(value));
	}

	/**
	 * Sets the floating point matrix value of the attribute.
	 *
	 * @param value
	 * 				The value of the attribute as {@link float[][]}.
	 */
	public void setDoubleMatrixValue(float[][] value) {
		setMatrixValue(JavaDatatypeUtils.boxFloatMatrix(value));
	}

	/**
	 * Sets the floating point matrix value of the attribute with Base64 encoding.
	 *
	 * @param value
	 * 				The value of the attribute as {@link float[][]}.
	 */
	public void setDoubleMatrixValueBase64(float[][] value) {
		int rows = value.length;
		int cols = Arrays.stream(value).mapToInt(col -> col.length).max().orElse(0);
		String base64Value = Base64Utils.encodeFloat32Matrix(value);
		setMatrixValueBase64(base64Value, CodeType.FLOAT_32, rows, cols);
	}

	/**
	 * Sets the floating point matrix value of the attribute with Base64 encoding.
	 *
	 * @param value
	 * 				The value of the attribute as {@link double[][]}.
	 */
	public void setDoubleMatrixValueBase64(double[][] value) {
		int rows = value.length;
		int cols = Arrays.stream(value).mapToInt(col -> col.length).max().orElse(0);
		String base64Value = Base64Utils.encodeFloat64Matrix(value);
		setMatrixValueBase64(base64Value, CodeType.FLOAT_64, rows, cols);
	}

	/**
	 * Sets the array of integer arrays value of the attribute.
	 *
	 * @param value
	 * 				The value of the attribute as {@link List}.
	 */
	public void setArrayOfIntegerArraysValue(List<Integer[]> value) {
		if (value == null || value.isEmpty())
			return;

		ObjectFactory objectFactory = new ObjectFactory();
		ArrayOfArrays arrayOfArrays = objectFactory.createArrayOfArrays();
		for (Integer[] arrayValue : value) {
			Array array = objectFactory.createArray();
			for (int i = 0; i < arrayValue.length; i++) {
				C c = objectFactory.createC();
				if (arrayValue[i] == null)
					c.setValue("");
				else
					c.setValue(String.valueOf(arrayValue[i]));
				array.getContent().add(c);
			}
			arrayOfArrays.getArray().add(array);
		}

		rawAttribute.getContent().clear();
		rawAttribute.getContent().add(arrayOfArrays);
	}
}
