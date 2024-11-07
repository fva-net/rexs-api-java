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

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;

import info.rexs.schema.constants.RexsAttributeId;
import info.rexs.schema.constants.RexsUnitId;
import info.rexs.schema.constants.RexsValueType;
import info.rexs.schema.constants.standard.RexsStandardAttributeIds;
import info.rexs.schema.constants.standard.RexsStandardUnitIds;
import info.rexs.model.value.AbstractRexsAttributeValue;
import info.rexs.model.value.RexsAttributeValueArray;
import info.rexs.model.value.RexsAttributeValueArrayBase64;
import info.rexs.model.value.RexsAttributeValueArrayOfArrays;
import info.rexs.model.value.RexsAttributeValueMatrix;
import info.rexs.model.value.RexsAttributeValueMatrixBase64;
import info.rexs.model.value.RexsAttributeValueScalar;

/**
 * This class represents an attribute of a REXS model.
 *
 * @author FVA GmbH
 */
public class RexsAttribute {

	/** The ID of the attribute. */
	private RexsAttributeId attributeId;

	/** The origin ID of the attribute */
	private String originAttributeId;

	/** The unit of the attribute. */
	private RexsUnitId unit;

	/** The orign unti of the attribute */
	private String originUnit;

	/**The value of the attribute */
	private AbstractRexsAttributeValue value = null;

	/**
	 * Constructs a new {@link RexsAttribute} for the given properties.
	 *
	 * @param attributeId
	 * 				The ID of the attribute as a {@link String}.
	 * @param unit
	 * 				The unit of the attribute as a {@link String}.
	 */
	protected RexsAttribute(String attributeId, String unit) {
		Objects.requireNonNull(attributeId, "attribute id cannot be empty");
		this.attributeId = RexsAttributeId.findById(attributeId);
		this.originAttributeId = attributeId;

		Objects.requireNonNull(unit, "unit cannot be empty");
		this.unit = RexsUnitId.findById(unit);
		this.originUnit = unit;

		if (this.unit==RexsStandardUnitIds.UNKNOWN)
			this.unit = RexsUnitId.create(originUnit);
		if (this.attributeId==RexsStandardAttributeIds.UNKNOWN)
			this.attributeId = RexsAttributeId.create(originAttributeId, this.unit);
	}

	/**
	 * Constructs a new {@link RexsAttribute} for the given properties.
	 *
	 * @param attributeId
	 * 				The ID of the attribute as a {@link String}.
	 */
	protected RexsAttribute(String attributeId) {
		this(attributeId, RexsStandardUnitIds.none.toString());
	}

	/**
	 * Constructs a new {@link RexsAttribute} from scratch.
	 *
	 * @param attributeId
	 * 				The ID of the attribute.
	 */
	protected RexsAttribute(RexsAttributeId attributeId) {
		Objects.requireNonNull(attributeId, "attribute id cannot be empty");
		this.attributeId = attributeId;
		this.originAttributeId = attributeId.getId();
		this.unit = attributeId.getUnit();
		this.originUnit = this.unit.getId();
	}

	/** copy constructor */
	public RexsAttribute(RexsAttribute attribute) {
		this(attribute.attributeId);
		if (attribute.value != null)
			this.setRawValue(attribute.value.copy());
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
	 * 				The origin ID of the attribute as a {@link String}.
	 */
	public String getOriginAttributeId() {
		return originAttributeId;
	}

	/**
	 * @return
	 * 				The unit of the attribute as {@link RexsUnitId}.
	 */
	public RexsUnitId getUnit() {
		return unit;
	}

	public void setUnit(RexsUnitId unit) {
		this.unit = unit;
		this.originUnit = unit.getId();
	}

	/**
	 * @return
	 * 				The origing unit of the attribute as a {@link String}.
	 */
	public String getOriginUnit() {
		return originUnit;
	}

	/**
	 * @return
	 * 				The value of the attribute as a {@link AbstractRexsAttributeValue}.
	 */
	public AbstractRexsAttributeValue getRawValue() {
		return value;
	}

	/**
	 * Sets the value of the attribute.
	 *
	 * @param value
	 * 				The new value as a {@link AbstractRexsAttributeValue}.
	 */
	public void setRawValue(AbstractRexsAttributeValue value) {
		this.value = value;
	}

	/**
	 * Checks whether the attribute has a value.
	 *
	 * @return
	 * 				{@code true} if the attribute has a value, otherwise {@code false}.
	 */
	public boolean hasValue() {
		return value != null
				&& value.hasValue();
	}

	private void checkValue() {
		if (!hasValue())
			throw new RexsModelAccessException(
					"value cannot be null for attribute " + this.getAttributeId().getId());
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
		checkValue();
		return value.getValueString();
	}

	public OffsetDateTime getDateTimeValue() {
		checkValue();
		return value.getValueDateTime();
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
		checkValue();
		return value.getValueBoolean();
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
		checkValue();
		return value.getValueInteger();
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
		checkValue();
		checkUnit(unit);
		return value.getValueDouble();
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
		checkValue();
		return value.getValueStringArray();
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
		checkValue();
		return value.getValueStringArray();
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
		checkValue();
		return value.getValueBooleanArray();
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
		checkValue();
		return value.getValueIntegerArray();
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
		checkValue();
		return value.getValueIntegerArrayUnboxed();
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
		checkValue();
		checkUnit(unit);
		return value.getValueDoubleArray();
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
		checkValue();
		checkUnit(unit);
		return value.getValueDoubleArrayUnboxed();
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
		checkValue();
		return value.getValueStringMatrix();
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
		checkValue();
		return value.getValueBooleanMatrix();
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
		checkValue();
		return value.getValueIntegerMatrix();
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
		checkValue();
		return value.getValueIntegerMatrixUnboxed();
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
		checkValue();
		checkUnit(unit);
		return value.getValueDoubleMatrix();
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
		checkValue();
		checkUnit(unit);
		return value.getValueDoubleMatrixUnboxed();
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
		checkValue();
		return value.getValueArrayOfIntegerArrays();
	}

	/**
	 * TODO Document me!
	 *
	 * @param type
	 * 				TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public Object getValue(RexsValueType type) throws RexsModelAccessException{

		switch (type) {
			case DATE_TIME:
				return getDateTimeValue();
			case BOOLEAN:
				return getBooleanValue();
			case BOOLEAN_ARRAY:
				return getBooleanArrayValue();
			case BOOLEAN_MATRIX:
				return getBooleanMatrixValue();

			case STRING:
				return getStringValue();
			case STRING_ARRAY:
				return getStringArrayValue();
			case STRING_MATRIX:
				return getStringMatrixValue();

			case INTEGER:
				return getIntegerValue();
			case INTEGER_ARRAY:
				return getIntegerArrayValue();
			case INTEGER_MATRIX:
				return getIntegerMatrixValue();
			case ARRAY_OF_INTEGER_ARRAYS:
				return getArrayOfIntegerArraysValue();

			case FLOATING_POINT:
				return getDoubleValue(getUnit());
			case FLOATING_POINT_ARRAY:
				return getDoubleArrayValue(getUnit());
			case FLOATING_POINT_MATRIX:
				return getDoubleMatrixValue(getUnit());

			case ENUM:
				return getStringValue();
			case ENUM_ARRAY:
				return getStringArrayValue();

			case REFERENCE_COMPONENT:
			case FILE_REFERENCE:
				return getStringValue();

			default:
				return getStringValue();
		}
	}

	private void checkUnit(RexsUnitId unitToCheck) {
		if (!attributeId.getUnit().equals(unitToCheck)
				&& attributeId.getUnit() != RexsStandardUnitIds.UNKNOWN
				&& !attributeId.getUnit().isEquivalent(unitToCheck))
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
		if (this.value == null || !(this.value instanceof RexsAttributeValueScalar))
			this.value = new RexsAttributeValueScalar();
		((RexsAttributeValueScalar)this.value).setValueString(value);
	}

	public void setTimeValue(OffsetDateTime value) {
		this.value = new RexsAttributeValueScalar();
		((RexsAttributeValueScalar)this.value).setValueTime(value);
	}

	/**
	 * Sets the boolean value of the attribute.
	 *
	 * @param value
	 * 				The value of the attribute as {@link Boolean}.
	 */
	public void setBooleanValue(boolean value) {
		if (this.value == null || !(this.value instanceof RexsAttributeValueScalar))
			this.value = new RexsAttributeValueScalar();
		((RexsAttributeValueScalar)this.value).setValueBoolean(value);
	}

	/**
	 * Sets the integer value of the attribute.
	 *
	 * @param value
	 * 				The value of the attribute as {@link Integer}.
	 */
	public void setIntegerValue(int value) {
		if (this.value == null || !(this.value instanceof RexsAttributeValueScalar))
			this.value = new RexsAttributeValueScalar();
		((RexsAttributeValueScalar)this.value).setValueInteger(value);
	}

	/**
	 * Sets the floating point value of the attribute.
	 *
	 * @param value
	 * 				The value of the attribute as {@link Double}.
	 */
	public void setDoubleValue(double value) {
		if (this.value == null || !(this.value instanceof RexsAttributeValueScalar))
			this.value = new RexsAttributeValueScalar();
		((RexsAttributeValueScalar)this.value).setValueDouble(value);
	}

	/**
	 * Sets the string array value of the attribute.
	 *
	 * @param value
	 * 				The value of the attribute as {@link String[]}.
	 */
	public void setStringArrayValue(String[] value) {
		if (this.value == null || !(this.value instanceof RexsAttributeValueArray))
			this.value = new RexsAttributeValueArray();
		((RexsAttributeValueArray)this.value).setValueStringArray(value);
	}

	/**
	 * Sets the enum array value of the attribute.
	 *
	 * @param value
	 * 				The value of the attribute as {@link String[]}.
	 */
	public void setEnumArrayValue(String[] value) {
		setStringArrayValue(value);
	}

	/**
	 * Sets the bolean array value of the attribute.
	 *
	 * @param value
	 * 				The value of the attribute as {@link Boolean[]}.
	 */
	public void setBooleanArrayValue(Boolean[] value) {
		if (this.value == null || !(this.value instanceof RexsAttributeValueArray))
			this.value = new RexsAttributeValueArray();
		((RexsAttributeValueArray)this.value).setValueBooleanArray(value);
	}

	/**
	 * Sets the integer array value of the attribute.
	 *
	 * @param value
	 * 				The value of the attribute as {@link Integer[]}.
	 */
	public void setIntegerArrayValue(Integer[] value) {
		if (this.value == null || !(this.value instanceof RexsAttributeValueArray))
			this.value = new RexsAttributeValueArray();
		((RexsAttributeValueArray)this.value).setValueIntegerArray(value);
	}

	/**
	 * Sets the integer array value of the attribute.
	 *
	 * @param value
	 * 				The value of the attribute as {@link int[]}.
	 */
	public void setIntegerArrayValue(int[] value) {
		if (this.value == null || !(this.value instanceof RexsAttributeValueArray))
			this.value = new RexsAttributeValueArray();
		((RexsAttributeValueArray)this.value).setValueIntegerArray(value);
	}

	/**
	 * Sets the integer array value of the attribute with Base64 encoding.
	 *
	 * @param value
	 * 				The value of the attribute as {@link int[]}.
	 */
	public void setIntegerArrayValueBase64(int[] value) {
		if (this.value == null || !(this.value instanceof RexsAttributeValueArrayBase64))
			this.value = new RexsAttributeValueArrayBase64();
		((RexsAttributeValueArrayBase64)this.value).setValueIntegerArray(value);
	}

	/**
	 * Sets the floating point array value of the attribute.
	 *
	 * @param value
	 * 				The value of the attribute as {@link Double[]}.
	 */
	public void setDoubleArrayValue(Double[] value) {
		if (this.value == null || !(this.value instanceof RexsAttributeValueArray))
			this.value = new RexsAttributeValueArray();
		((RexsAttributeValueArray)this.value).setValueDoubleArray(value);
	}

	/**
	 * Sets the floating point array value of the attribute.
	 *
	 * @param value
	 * 				The value of the attribute as {@link double[]}.
	 */
	public void setDoubleArrayValue(double[] value) {
		if (this.value == null || !(this.value instanceof RexsAttributeValueArray))
			this.value = new RexsAttributeValueArray();
		((RexsAttributeValueArray)this.value).setValueDoubleArray(value);
	}

	/**
	 * Sets the floating point array value of the attribute.
	 *
	 * @param value
	 * 				The value of the attribute as {@link float[]}.
	 */
	public void setDoubleArrayValue(float[] value) {
		if (this.value == null || !(this.value instanceof RexsAttributeValueArray))
			this.value = new RexsAttributeValueArray();
		((RexsAttributeValueArray)this.value).setValueDoubleArray(value);
	}

	/**
	 * Sets the floating point array value of the attribute with Base64 encoding.
	 *
	 * @param value
	 * 				The value of the attribute as {@link float[]}.
	 */
	public void setDoubleArrayValueBase64(float[] value) {
		if (this.value == null || !(this.value instanceof RexsAttributeValueArrayBase64))
			this.value = new RexsAttributeValueArrayBase64();
		((RexsAttributeValueArrayBase64)this.value).setValueDoubleArray(value);
	}

	/**
	 * Sets the floating point array value of the attribute with Base64 encoding.
	 *
	 * @param value
	 * 				The value of the attribute as {@link double[]}.
	 */
	public void setDoubleArrayValueBase64(double[] value) {
		if (this.value == null || !(this.value instanceof RexsAttributeValueArrayBase64))
			this.value = new RexsAttributeValueArrayBase64();
		((RexsAttributeValueArrayBase64)this.value).setValueDoubleArray(value);
	}

	/**
	 * Sets the string matrix value of the attribute.
	 *
	 * @param value
	 * 				The value of the attribute as {@link String[][]}.
	 */
	public void setStringMatrixValue(String[][] value) {
		if (this.value == null || !(this.value instanceof RexsAttributeValueMatrix))
			this.value = new RexsAttributeValueMatrix();
		((RexsAttributeValueMatrix)this.value).setValueStringMatrix(value);
	}

	/**
	 * Sets the boolean matrix value of the attribute.
	 *
	 * @param value
	 * 				The value of the attribute as {@link Boolean[][]}.
	 */
	public void setBooleanMatrixValue(Boolean[][] value) {
		if (this.value == null || !(this.value instanceof RexsAttributeValueMatrix))
			this.value = new RexsAttributeValueMatrix();
		((RexsAttributeValueMatrix)this.value).setValueBooleanMatrix(value);
	}

	/**
	 * Sets the integer matrix value of the attribute.
	 *
	 * @param value
	 * 				The value of the attribute as {@link Integer[][]}.
	 */
	public void setIntegerMatrixValue(Integer[][] value) {
		if (this.value == null || !(this.value instanceof RexsAttributeValueMatrix))
			this.value = new RexsAttributeValueMatrix();
		((RexsAttributeValueMatrix)this.value).setValueIntegerMatrix(value);
	}

	/**
	 * Sets the integer matrix value of the attribute.
	 *
	 * @param value
	 * 				The value of the attribute as {@link int[][]}.
	 */
	public void setIntegerMatrixValue(int[][] value) {
		if (this.value == null || !(this.value instanceof RexsAttributeValueMatrix))
			this.value = new RexsAttributeValueMatrix();
		((RexsAttributeValueMatrix)this.value).setValueIntegerMatrix(value);
	}

	/**
	 * Sets the integer matrix value of the attribute with Base64 encoding.
	 *
	 * @param value
	 * 				The value of the attribute as {@link int[][]}.
	 */
	public void setIntegerMatrixValueBase64(int[][] value) {
		if (this.value == null || !(this.value instanceof RexsAttributeValueMatrixBase64))
			this.value = new RexsAttributeValueMatrixBase64();
		((RexsAttributeValueMatrixBase64)this.value).setValueIntegerMatrix(value);
	}

	/**
	 * Sets the floating point matrix value of the attribute.
	 *
	 * @param value
	 * 				The value of the attribute as {@link Double[][]}.
	 */
	public void setDoubleMatrixValue(Double[][] value) {
		if (this.value == null || !(this.value instanceof RexsAttributeValueMatrix))
			this.value = new RexsAttributeValueMatrix();
		((RexsAttributeValueMatrix)this.value).setValueDoubleMatrix(value);
	}

	/**
	 * Sets the floating point matrix value of the attribute.
	 *
	 * @param value
	 * 				The value of the attribute as {@link double[][]}.
	 */
	public void setDoubleMatrixValue(double[][] value) {
		if (this.value == null || !(this.value instanceof RexsAttributeValueMatrix))
			this.value = new RexsAttributeValueMatrix();
		((RexsAttributeValueMatrix)this.value).setValueDoubleMatrix(value);
	}

	/**
	 * Sets the floating point matrix value of the attribute.
	 *
	 * @param value
	 * 				The value of the attribute as {@link float[][]}.
	 */
	public void setDoubleMatrixValue(float[][] value) {
		if (this.value == null || !(this.value instanceof RexsAttributeValueMatrix))
			this.value = new RexsAttributeValueMatrix();
		((RexsAttributeValueMatrix)this.value).setValueDoubleMatrix(value);
	}

	/**
	 * Sets the floating point matrix value of the attribute with Base64 encoding.
	 *
	 * @param value
	 * 				The value of the attribute as {@link float[][]}.
	 */
	public void setDoubleMatrixValueBase64(float[][] value) {
		if (this.value == null || !(this.value instanceof RexsAttributeValueMatrixBase64))
			this.value = new RexsAttributeValueMatrixBase64();
		((RexsAttributeValueMatrixBase64)this.value).setValueDoubleMatrix(value);
	}

	/**
	 * Sets the floating point matrix value of the attribute with Base64 encoding.
	 *
	 * @param value
	 * 				The value of the attribute as {@link double[][]}.
	 */
	public void setDoubleMatrixValueBase64(double[][] value) {
		if (this.value == null || !(this.value instanceof RexsAttributeValueMatrixBase64))
			this.value = new RexsAttributeValueMatrixBase64();
		((RexsAttributeValueMatrixBase64)this.value).setValueDoubleMatrix(value);
	}

	/**
	 * Sets the array of integer arrays value of the attribute.
	 *
	 * @param value
	 * 				The value of the attribute as {@link List}.
	 */
	public void setArrayOfIntegerArraysValue(List<Integer[]> value) {
		if (this.value == null || !(this.value instanceof RexsAttributeValueArrayOfArrays))
			this.value = new RexsAttributeValueArrayOfArrays();
		((RexsAttributeValueArrayOfArrays)this.value).setValueArrayOfIntegerArrays(value);
	}

	public void setId(RexsAttributeId id) {
		this.attributeId = id;
	}

}
