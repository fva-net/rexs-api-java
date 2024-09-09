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

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import info.rexs.db.constants.RexsAttributeId;
import info.rexs.db.constants.RexsComponentType;
import info.rexs.db.constants.RexsUnitId;
import info.rexs.db.constants.RexsValueType;

/**
 * This class represents an component of a REXS model.
 *
 * @author FVA GmbH
 */
public class RexsComponent implements Comparable<RexsComponent> {

	/** The numeric ID of the component within the REXS model. */
	private Integer id;

	/** The type of the component. */
	private RexsComponentType type;

	/** The origin type of the component */
	private String originType;

	/** The name of the component */
	private String name;

	/** An internal index with all attributes of the component for quick access. */
	private Map<String, RexsAttribute> attributes = new HashMap<>();

	/**
	 * Constructs a new {@link RexsComponent} for the given properties.
	 *
	 * @param id
	 * 				The numeric ID of the component as an {@link Integer}.
	 * @param type
	 * 				The type of the component as a {@link String}.
	 * @param name
	 * 				The name of the component as a {@link String}.
	 */
	protected RexsComponent(Integer id, String type, String name) {
		this.id = id;
		this.type = RexsComponentType.findById(type);
		this.originType = type;
		this.name = name;
	}

	/**
	 * Constructs a new {@link RexsComponent} for the given properties.
	 *
	 * @param id
	 * 				The numeric ID of the component as an {@link Integer}.
	 * @param type
	 * 				The type of the component as a {@link RexsComponentType}.
	 * @param name
	 * 				The name of the component as a {@link String}.
	 */
	protected RexsComponent(Integer id, RexsComponentType type, String name) {
		this.id = id;
		this.type = type;
		this.originType = type.getId();
		this.name = name;
	}

	/** Copy constructor */
	public RexsComponent(RexsComponent component) {
		this.id = component.id;
		this.type = component.type;
		this.originType = component.originType;
		this.name = component.name;
		for (RexsAttribute attribute: component.getAttributes()) {
			RexsAttribute newAttribute = new RexsAttribute(attribute);
			this.addAttribute(newAttribute);
		}
	}

	/**
	 * @return
	 * 				The numeric ID of the component within the REXS model.
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return
	 * 				The type of the component as {@link RexsComponentType}.
	 */
	public RexsComponentType getType() {
		return type;
	}

	/**
	 * @return
	 * 				The orign type of the component as a {@link String}.
	 */
	public String getOriginType() {
		return originType;
	}

	/**
	 * @return
	 * 				The name of the component within the REXS model.
	 */
	public String getName() {
		if (name == null)
			name = "";
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return
	 * 				All attributes assigned to the component as a {@link Collection} of {@link RexsAttribute}.
	 */
	public Collection<RexsAttribute> getAttributes() {
		return Collections.unmodifiableCollection(attributes.values());
	}

	public void removeAttribute(RexsAttributeId attributeId) {
		attributes.remove(attributeId.getId());
	}

	/**
	 * Checks on the ID of an attribute whether the component contains a corresponding attribute.
	 *
	 * @param attributeId
	 * 				The ID of the attribute as {@link RexsAttributeId}.
	 *
	 * @return
	 * 				{@code true} if the component contains the attribute, otherwise {@code false}.
	 */
	public boolean hasAttribute(RexsAttributeId attributeId) {
		return hasAttribute(attributeId.getId());
	}

	/**
	 * Checks on the ID of an attribute whether the component contains a corresponding attribute.
	 *
	 * @param attributeId
	 * 				The ID of the attribute as {@link String}.
	 *
	 * @return
	 * 				{@code true} if the component contains the attribute, otherwise {@code false}.
	 */
	public boolean hasAttribute(String attributeId) {
		return attributes.containsKey(attributeId);
	}

	/**
	 * Returns the attribute of the component for an attribute ID.
	 *
	 * @param attributeId
	 * 				The ID of the attribute as {@link RexsAttributeId}.
	 *
	 * @return
	 * 				The attribute as {@link RexsAttribute} or {@code null} if the component
	 * 				does not contain a corresponding attribute.
	 *
	 * @throws RexsModelAccessException
	 * 				If the attribute is not defined on the component.
	 */
	public RexsAttribute getAttribute(RexsAttributeId attributeId) {
		return getAttribute(attributeId.getId());
	}

	/**
	 * Returns the attribute of the component for an attribute ID.
	 *
	 * @param attributeId
	 * 				The ID of the attribute as {@link String}.
	 *
	 * @return
	 * 				The attribute as {@link RexsAttribute} or {@code null} if the component
	 * 				does not contain a corresponding attribute.
	 *
	 * @throws RexsModelAccessException
	 * 				If the attribute is not defined on the component.
	 */
	public RexsAttribute getAttribute(String attributeId) {
		RexsAttribute rexsAttribute = attributes.get(attributeId);
		if (rexsAttribute == null)
			throw new RexsModelAccessException(this, "attribute '" + attributeId + "' not found!");
		return rexsAttribute;
	}

	/**
	 * TODO Document me!
	 *
	 * @param attributeId
	 * 				The ID of the attribute as {@link RexsAttributeId}.
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public RexsUnitId getUnit(RexsAttributeId attributeId) {
		RexsAttribute attribute = getAttribute(attributeId);
		return attribute.getUnit();
	}

	/**
	 * TODO Document me!
	 *
	 * @param attributeId
	 * 				The ID of the attribute as {@link RexsAttributeId}.
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public boolean hasValue(RexsAttributeId attributeId) {
		return hasValue(attributeId.getId());
	}

	/**
	 * TODO Document me!
	 *
	 * @param attributeId
	 * 				The ID of the attribute as {@link String}.
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public boolean hasValue(String attributeId) {
		if (!hasAttribute(attributeId))
			return false;
		RexsAttribute attribute = getAttribute(attributeId);
		return attribute.hasValue();
	}

	/**
	 * TODO Document me!
	 *
	 * @param attributeId
	 * 				TODO Document me!
	 * @param type
	 * 				TODO Document me!
	 *
	 * @return
	 * 				TODO Document me!
	 */
	public Object getValue(RexsAttributeId attributeId, RexsValueType type) {
		RexsAttribute attribute = getAttribute(attributeId);
		return attribute.getValue(type);
	}

	/**
	 * Returns the string value of the attribute.
	 *
	 * @param attributeId
	 * 				The ID of the attribute as {@link RexsAttributeId}.
	 *
	 * @return
	 * 				The value of the attribute as {@link String}.
	 *
	 * @throws RexsModelAccessException
	 * 				If the attribute has no string value.
	 */
	public String getStringValue(RexsAttributeId attributeId) {
		RexsAttribute attribute = getAttribute(attributeId);
		return attribute.getStringValue();
	}

	/**
	 * Returns the boolean value of the attribute.
	 *
	 * @param attributeId
	 * 				The ID of the attribute as {@link RexsAttributeId}.
	 *
	 * @return
	 * 				The value of the attribute as {@link boolean}.
	 *
	 * @throws RexsModelAccessException
	 * 				If the attribute has no boolean value.
	 */
	public boolean getBooleanValue(RexsAttributeId attributeId) {
		RexsAttribute attribute = getAttribute(attributeId);
		return attribute.getBooleanValue();
	}

	/**
	 * Returns the integer value of the attribute.
	 *
	 * @param attributeId
	 * 				The ID of the attribute as {@link RexsAttributeId}.
	 *
	 * @return
	 * 				The value of the attribute as {@link Integer}.
	 *
	 * @throws RexsModelAccessException
	 * 				If the attribute has no integer value.
	 */
	public int getIntegerValue(RexsAttributeId attributeId) {
		RexsAttribute attribute = getAttribute(attributeId);
		return attribute.getIntegerValue();
	}

	/**
	 * Returns the floating point value of the attribute.
	 *
	 * @param attributeId
	 * 				The ID of the attribute as {@link RexsAttributeId}.
	 * @param unit
	 * 				The unit of the attribute as {@link RexsUnitId}.
	 *
	 * @return
	 * 				The value of the attribute as {@link Double}.
	 *
	 * @throws RexsModelAccessException
	 * 				If the attribute has no double value or the unit does not match the unit of the attribute.
	 */
	public double getDoubleValue(RexsAttributeId attributeId, RexsUnitId unit) {
		RexsAttribute attribute = getAttribute(attributeId);
		return attribute.getDoubleValue(unit);
	}

	/**
	 * Returns the string array value of the attribute.
	 *
	 * @param attributeId
	 * 				The ID of the attribute as {@link RexsAttributeId}.
	 *
	 * @return
	 * 				The value of the attribute as {@link String[]}.
	 *
	 * @throws RexsModelAccessException
	 * 				If the attribute has no string array value.
	 */
	public String[] getStringArrayValue(RexsAttributeId attributeId) {
		RexsAttribute attribute = getAttribute(attributeId);
		return attribute.getStringArrayValue();
	}

	/**
	 * Returns the enum array value of the attribute.
	 *
	 * @param attributeId
	 * 				The ID of the attribute as {@link RexsAttributeId}.
	 *
	 * @return
	 * 				The value of the attribute as {@link String[]}.
	 *
	 * @throws RexsModelAccessException
	 * 				If the attribute has no enum array value.
	 */
	public String[] getEnumArrayValue(RexsAttributeId attributeId) {
		RexsAttribute attribute = getAttribute(attributeId);
		return attribute.getEnumArrayValue();
	}

	/**
	 * Returns the boolean array value of the attribute.
	 *
	 * @param attributeId
	 * 				The ID of the attribute as {@link RexsAttributeId}.
	 *
	 * @return
	 * 				The value of the attribute as {@link Boolean[]}.
	 *
	 * @throws RexsModelAccessException
	 * 				If the attribute has no boolean array value.
	 */
	public Boolean[] getBooleanArrayValue(RexsAttributeId attributeId) {
		RexsAttribute attribute = getAttribute(attributeId);
		return attribute.getBooleanArrayValue();
	}

	/**
	 * Returns the integer array value of the attribute.
	 *
	 * @param attributeId
	 * 				The ID of the attribute as {@link RexsAttributeId}.
	 *
	 * @return
	 * 				The value of the attribute as {@link Integer[]}.
	 *
	 * @throws RexsModelAccessException
	 * 				If the attribute has no integer array value.
	 */
	public Integer[] getIntegerArrayValue(RexsAttributeId attributeId) {
		RexsAttribute attribute = getAttribute(attributeId);
		return attribute.getIntegerArrayValue();
	}

	/**
	 * Returns the integer array value of the attribute.
	 *
	 * @param attributeId
	 * 				The ID of the attribute as {@link RexsAttributeId}.
	 *
	 * @return
	 * 				The value of the attribute as {@link int[]}.
	 *
	 * @throws RexsModelAccessException
	 * 				If the attribute has no integer array value.
	 */
	public int[] getIntegerArrayValueUnboxed(RexsAttributeId attributeId) {
		RexsAttribute attribute = getAttribute(attributeId);
		return attribute.getIntegerArrayValueUnboxed();
	}

	/**
	 * Returns the floating point array value of the attribute.
	 *
	 * @param attributeId
	 * 				The ID of the attribute as {@link RexsAttributeId}.
	 * @param unit
	 * 				The unit of the attribute as {@link RexsUnitId}.
	 *
	 * @return
	 * 				The value of the attribute as {@link Double[]}.
	 *
	 * @throws RexsModelAccessException
	 * 				If the attribute has no double array value or the unit does not match the unit of the attribute.
	 */
	public Double[] getDoubleArrayValue(RexsAttributeId attributeId, RexsUnitId unit) {
		RexsAttribute attribute = getAttribute(attributeId);
		return attribute.getDoubleArrayValue(unit);
	}

	/**
	 * Returns the floating point array value of the attribute.
	 *
	 * @param attributeId
	 * 				The ID of the attribute as {@link RexsAttributeId}.
	 * @param unit
	 * 				The unit of the attribute as {@link RexsUnitId}.
	 *
	 * @return
	 * 				The value of the attribute as {@link double[]}.
	 *
	 * @throws RexsModelAccessException
	 * 				If the attribute has no double array value or the unit does not match the unit of the attribute.
	 */
	public double[] getDoubleArrayValueUnboxed(RexsAttributeId attributeId, RexsUnitId unit) {
		RexsAttribute attribute = getAttribute(attributeId);
		return attribute.getDoubleArrayValueUnboxed(unit);
	}

	/**
	 * Returns the string matrix value of the attribute.
	 *
	 * @param attributeId
	 * 				The ID of the attribute as {@link RexsAttributeId}.
	 *
	 * @return
	 * 				The value of the attribute as {@link String[][]}.
	 *
	 * @throws RexsModelAccessException
	 * 				If the attribute has no string matrix value.
	 */
	public String[][] getStringMatrixValue(RexsAttributeId attributeId) {
		RexsAttribute attribute = getAttribute(attributeId);
		return attribute.getStringMatrixValue();
	}

	/**
	 * Returns the boolean matrix value of the attribute.
	 *
	 * @param attributeId
	 * 				The ID of the attribute as {@link RexsAttributeId}.
	 *
	 * @return
	 * 				The value of the attribute as {@link Boolean[][]}.
	 *
	 * @throws RexsModelAccessException
	 * 				If the attribute has no boolean matrix value.
	 */
	public Boolean[][] getBooleanMatrixValue(RexsAttributeId attributeId) {
		RexsAttribute attribute = getAttribute(attributeId);
		return attribute.getBooleanMatrixValue();
	}

	/**
	 * Returns the integer matrix value of the attribute.
	 *
	 * @param attributeId
	 * 				The ID of the attribute as {@link RexsAttributeId}.
	 *
	 * @return
	 * 				The value of the attribute as {@link Integer[][]}.
	 *
	 * @throws RexsModelAccessException
	 * 				If the attribute has no integer matrix value.
	 */
	public Integer[][] getIntegerMatrixValue(RexsAttributeId attributeId) {
		RexsAttribute attribute = getAttribute(attributeId);
		return attribute.getIntegerMatrixValue();
	}

	/**
	 * Returns the integer matrix value of the attribute.
	 *
	 * @param attributeId
	 * 				The ID of the attribute as {@link RexsAttributeId}.
	 *
	 * @return
	 * 				The value of the attribute as {@link int[][]}.
	 *
	 * @throws RexsModelAccessException
	 * 				If the attribute has no integer matrix value.
	 */
	public int[][] getIntegerMatrixValueUnboxed(RexsAttributeId attributeId) {
		RexsAttribute attribute = getAttribute(attributeId);
		return attribute.getIntegerMatrixValueUnboxed();
	}

	/**
	 * Returns the floating point matrix value of the attribute.
	 *
	 * @param attributeId
	 * 				The ID of the attribute as {@link RexsAttributeId}.
	 * @param unit
	 * 				The unit of the attribute as {@link RexsUnitId}.
	 *
	 * @return
	 * 				The value of the attribute as {@link Double[][]}.
	 *
	 * @throws RexsModelAccessException
	 * 				If the attribute has no double matrix value or the unit does not match the unit of the attribute.
	 */
	public Double[][] getDoubleMatrixValue(RexsAttributeId attributeId, RexsUnitId unit) {
		RexsAttribute attribute = getAttribute(attributeId);
		return attribute.getDoubleMatrixValue(unit);
	}

	/**
	 * Returns the floating point matrix value of the attribute.
	 *
	 * @param attributeId
	 * 				The ID of the attribute as {@link RexsAttributeId}.
	 * @param unit
	 * 				The unit of the attribute as {@link RexsUnitId}.
	 *
	 * @return
	 * 				The value of the attribute as {@link double[][]}.
	 *
	 * @throws RexsModelAccessException
	 * 				If the attribute has no double matrix value or the unit does not match the unit of the attribute.
	 */
	public double[][] getDoubleMatrixValueUnboxed(RexsAttributeId attributeId, RexsUnitId unit) {
		RexsAttribute attribute = getAttribute(attributeId);
		return attribute.getDoubleMatrixValueUnboxed(unit);
	}

	/**
	 * Returns the array of integer arrays value of the attribute.
	 *
	 * @param attributeId
	 * 				The ID of the attribute as {@link RexsAttributeId}.
	 *
	 * @return
	 * 				The value of the attribute as {@link List}.
	 *
	 * @throws RexsModelAccessException
	 * 				If the attribute has no array of integer array value.
	 */
	public List<Integer[]> getArrayOfIntegerArraysValue(RexsAttributeId attributeId) {
		RexsAttribute attribute = getAttribute(attributeId);
		return attribute.getArrayOfIntegerArraysValue();
	}

	/**
	 * Adds an attribute to the component.
	 * <p>
	 * If the component already has an attribute with the attribute ID, then the existing attribute is replaced by the new attribute.
	 *
	 * @param newAttribute
	 * 				The new attribute as {@link RexsAttribute}.
	 */
	public void addAttribute(RexsAttribute newAttribute) {
		attributes.put(newAttribute.getAttributeId().getId(), newAttribute);
	}

	private RexsAttribute createAndAddAttribute(RexsAttributeId attributeId) {
		RexsAttribute attribute = RexsModelObjectFactory.getInstance().createRexsAttribute(attributeId);
		addAttribute(attribute);
		return attribute;
	}

	/**
	 * Creates a new attribute with a string value and adds it to the component.
	 * <p>
	 * If the component already has an attribute with the attribute ID, then the existing attribute is replaced by the new attribute.
	 * If the value is null no attribute is added.
	 *
	 * @param attributeId
	 * 				The ID of the new attribute as {@link RexsAttributeId}.
	 * @param value
	 * 				The value of the new attribute as {@link String}.
	 */
	public void addAttribute(RexsAttributeId attributeId, String value) {
		if (value==null)
			return;
		RexsAttribute attribute = createAndAddAttribute(attributeId);
		attribute.setStringValue(value);
	}

	/**
	 * Creates a new attribute with a boolean value and adds it to the component.
	 * <p>
	 * If the component already has an attribute with the attribute ID, then the existing attribute is replaced by the new attribute.
	 * If the value is null no attribute is added.
	 *
	 * @param attributeId
	 * 				The ID of the new attribute as {@link RexsAttributeId}.
	 * @param value
	 * 				The value of the new attribute as {@link Boolean}.
	 */
	public void addAttribute(RexsAttributeId attributeId, Boolean value) {
		if (value==null)
			return;
		RexsAttribute attribute = createAndAddAttribute(attributeId);
		attribute.setBooleanValue(value);
	}

	/**
	 * Creates a new attribute with a integer value and adds it to the component.
	 * <p>
	 * If the component already has an attribute with the attribute ID, then the existing attribute is replaced by the new attribute.
	 * If the value is null no attribute is added.
	 *
	 * @param attributeId
	 * 				The ID of the new attribute as {@link RexsAttributeId}.
	 * @param value
	 * 				The value of the new attribute as {@link Integer}.
	 */
	public void addAttribute(RexsAttributeId attributeId, Integer value) {
		if (value==null)
			return;
		RexsAttribute attribute = createAndAddAttribute(attributeId);
		attribute.setIntegerValue(value);
	}

	/**
	 * Creates a new attribute with a floating point value and adds it to the component.
	 * <p>
	 * If the component already has an attribute with the attribute ID, then the existing attribute is replaced by the new attribute.
	 * If the value is null no attribute is added.
	 *
	 * @param attributeId
	 * 				The ID of the new attribute as {@link RexsAttributeId}.
	 * @param value
	 * 				The value of the new attribute as {@link Double}.
	 */
	public void addAttribute(RexsAttributeId attributeId, Double value) {
		if (value==null)
			return;
		RexsAttribute attribute = createAndAddAttribute(attributeId);
		attribute.setDoubleValue(value);
	}

	/**
	 * Creates a new attribute with a string array value and adds it to the component.
	 * <p>
	 * If the component already has an attribute with the attribute ID, then the existing attribute is replaced by the new attribute.
	 *
	 * @param attributeId
	 * 				The ID of the new attribute as {@link RexsAttributeId}.
	 * @param arrayValues
	 * 				The value of the new attribute as {@link String[]}.
	 */
	public void addAttribute(RexsAttributeId attributeId, String[] arrayValues) {
		RexsAttribute attribute = createAndAddAttribute(attributeId);
		attribute.setStringArrayValue(arrayValues);
	}

	/**
	 * Creates a new attribute with a boolean array value and adds it to the component.
	 * <p>
	 * If the component already has an attribute with the attribute ID, then the existing attribute is replaced by the new attribute.
	 *
	 * @param attributeId
	 * 				The ID of the new attribute as {@link RexsAttributeId}.
	 * @param arrayValues
	 * 				The value of the new attribute as {@link Boolean[]}.
	 */
	public void addAttribute(RexsAttributeId attributeId, Boolean[] arrayValues) {
		RexsAttribute attribute = createAndAddAttribute(attributeId);
		attribute.setBooleanArrayValue(arrayValues);
	}

	/**
	 * Creates a new attribute with a integer array value and adds it to the component.
	 * <p>
	 * If the component already has an attribute with the attribute ID, then the existing attribute is replaced by the new attribute.
	 *
	 * @param attributeId
	 * 				The ID of the new attribute as {@link RexsAttributeId}.
	 * @param arrayValues
	 * 				The value of the new attribute as {@link Integer[]}.
	 */
	public void addAttribute(RexsAttributeId attributeId, Integer[] arrayValues) {
		RexsAttribute attribute = createAndAddAttribute(attributeId);
		attribute.setIntegerArrayValue(arrayValues);
	}

	/**
	 * Creates a new attribute with a integer array value and adds it to the component.
	 * <p>
	 * If the component already has an attribute with the attribute ID, then the existing attribute is replaced by the new attribute.
	 *
	 * @param attributeId
	 * 				The ID of the new attribute as {@link RexsAttributeId}.
	 * @param arrayValues
	 * 				The value of the new attribute as {@link int[]}.
	 */
	public void addAttribute(RexsAttributeId attributeId, int[] arrayValues) {
		RexsAttribute attribute = createAndAddAttribute(attributeId);
		attribute.setIntegerArrayValue(arrayValues);
	}

	/**
	 * Creates a new attribute with a Base64 encoded integer array value and adds it to the component.
	 * <p>
	 * If the component already has an attribute with the attribute ID, then the existing attribute is replaced by the new attribute.
	 *
	 * @param attributeId
	 * 				The ID of the new attribute as {@link RexsAttributeId}.
	 * @param arrayValues
	 * 				The value of the new attribute as {@link int[]}.
	 */
	public void addAttributeBase64(RexsAttributeId attributeId, int[] arrayValues) {
		RexsAttribute attribute = createAndAddAttribute(attributeId);
		attribute.setIntegerArrayValueBase64(arrayValues);
	}

	/**
	 * Creates a new attribute with a floating point array value and adds it to the component.
	 * <p>
	 * If the component already has an attribute with the attribute ID, then the existing attribute is replaced by the new attribute.
	 *
	 * @param attributeId
	 * 				The ID of the new attribute as {@link RexsAttributeId}.
	 * @param arrayValues
	 * 				The value of the new attribute as {@link Double[]}.
	 */
	public void addAttribute(RexsAttributeId attributeId, Double[] arrayValues) {
		RexsAttribute attribute = createAndAddAttribute(attributeId);
		attribute.setDoubleArrayValue(arrayValues);
	}

	/**
	 * Creates a new attribute with a floating point array value and adds it to the component.
	 * <p>
	 * If the component already has an attribute with the attribute ID, then the existing attribute is replaced by the new attribute.
	 *
	 * @param attributeId
	 * 				The ID of the new attribute as {@link RexsAttributeId}.
	 * @param arrayValues
	 * 				The value of the new attribute as {@link float[]}.
	 */
	public void addAttribute(RexsAttributeId attributeId, float[] arrayValues) {
		RexsAttribute attribute = createAndAddAttribute(attributeId);
		attribute.setDoubleArrayValue(arrayValues);
	}

	/**
	 * Creates a new attribute with a floating point array value and adds it to the component.
	 * <p>
	 * If the component already has an attribute with the attribute ID, then the existing attribute is replaced by the new attribute.
	 *
	 * @param attributeId
	 * 				The ID of the new attribute as {@link RexsAttributeId}.
	 * @param arrayValues
	 * 				The value of the new attribute as {@link double[]}.
	 */
	public void addAttribute(RexsAttributeId attributeId, double[] arrayValues) {
		RexsAttribute attribute = createAndAddAttribute(attributeId);
		attribute.setDoubleArrayValue(arrayValues);
	}

	/**
	 * Creates a new attribute with a Base64 encoded floating point array value and adds it to the component.
	 * <p>
	 * If the component already has an attribute with the attribute ID, then the existing attribute is replaced by the new attribute.
	 *
	 * @param attributeId
	 * 				The ID of the new attribute as {@link RexsAttributeId}.
	 * @param arrayValues
	 * 				The value of the new attribute as {@link float[]}.
	 */
	public void addAttributeBase64(RexsAttributeId attributeId, float[] arrayValues) {
		RexsAttribute attribute = createAndAddAttribute(attributeId);
		attribute.setDoubleArrayValueBase64(arrayValues);
	}

	/**
	 * Creates a new attribute with a Base64 encoded floating point array value and adds it to the component.
	 * <p>
	 * If the component already has an attribute with the attribute ID, then the existing attribute is replaced by the new attribute.
	 *
	 * @param attributeId
	 * 				The ID of the new attribute as {@link RexsAttributeId}.
	 * @param arrayValues
	 * 				The value of the new attribute as {@link double[]}.
	 */
	public void addAttributeBase64(RexsAttributeId attributeId, double[] arrayValues) {
		RexsAttribute attribute = createAndAddAttribute(attributeId);
		attribute.setDoubleArrayValueBase64(arrayValues);
	}

	/**
	 * Creates a new attribute with a string matrix value and adds it to the component.
	 * <p>
	 * If the component already has an attribute with the attribute ID, then the existing attribute is replaced by the new attribute.
	 *
	 * @param attributeId
	 * 				The ID of the new attribute as {@link RexsAttributeId}.
	 * @param matrixValues
	 * 				The value of the new attribute as {@link String[][]}.
	 */
	public void addAttribute(RexsAttributeId attributeId, String[][] matrixValues) {
		RexsAttribute attribute = createAndAddAttribute(attributeId);
		attribute.setStringMatrixValue(matrixValues);
	}

	/**
	 * Creates a new attribute with a boolean matrix value and adds it to the component.
	 * <p>
	 * If the component already has an attribute with the attribute ID, then the existing attribute is replaced by the new attribute.
	 *
	 * @param attributeId
	 * 				The ID of the new attribute as {@link RexsAttributeId}.
	 * @param matrixValues
	 * 				The value of the new attribute as {@link Boolean[][]}.
	 */
	public void addAttribute(RexsAttributeId attributeId, Boolean[][] matrixValues) {
		RexsAttribute attribute = createAndAddAttribute(attributeId);
		attribute.setBooleanMatrixValue(matrixValues);
	}

	/**
	 * Creates a new attribute with a integer matrix value and adds it to the component.
	 * <p>
	 * If the component already has an attribute with the attribute ID, then the existing attribute is replaced by the new attribute.
	 *
	 * @param attributeId
	 * 				The ID of the new attribute as {@link RexsAttributeId}.
	 * @param matrixValues
	 * 				The value of the new attribute as {@link Integer[][]}.
	 */
	public void addAttribute(RexsAttributeId attributeId, Integer[][] matrixValues) {
		RexsAttribute attribute = createAndAddAttribute(attributeId);
		attribute.setIntegerMatrixValue(matrixValues);
	}

	/**
	 * Creates a new attribute with a integer matrix value and adds it to the component.
	 * <p>
	 * If the component already has an attribute with the attribute ID, then the existing attribute is replaced by the new attribute.
	 *
	 * @param attributeId
	 * 				The ID of the new attribute as {@link RexsAttributeId}.
	 * @param matrixValues
	 * 				The value of the new attribute as {@link int[][]}.
	 */
	public void addAttribute(RexsAttributeId attributeId, int[][] matrixValues) {
		RexsAttribute attribute = createAndAddAttribute(attributeId);
		attribute.setIntegerMatrixValue(matrixValues);
	}

	/**
	 * Creates a new attribute with a Base64 encoded integer matrix value and adds it to the component.
	 * <p>
	 * If the component already has an attribute with the attribute ID, then the existing attribute is replaced by the new attribute.
	 *
	 * @param attributeId
	 * 				The ID of the new attribute as {@link RexsAttributeId}.
	 * @param matrixValues
	 * 				The value of the new attribute as {@link int[][]}.
	 */
	public void addAttributeBase64(RexsAttributeId attributeId, int[][] matrixValues) {
		RexsAttribute attribute = createAndAddAttribute(attributeId);
		attribute.setIntegerMatrixValueBase64(matrixValues);
	}

	/**
	 * Creates a new attribute with a floating point matrix value and adds it to the component.
	 * <p>
	 * If the component already has an attribute with the attribute ID, then the existing attribute is replaced by the new attribute.
	 *
	 * @param attributeId
	 * 				The ID of the new attribute as {@link RexsAttributeId}.
	 * @param matrixValues
	 * 				The value of the new attribute as {@link Double[][]}.
	 */
	public void addAttribute(RexsAttributeId attributeId, Double[][] matrixValues) {
		RexsAttribute attribute = createAndAddAttribute(attributeId);
		attribute.setDoubleMatrixValue(matrixValues);
	}

	/**
	 * Creates a new attribute with a floating point matrix value and adds it to the component.
	 * <p>
	 * If the component already has an attribute with the attribute ID, then the existing attribute is replaced by the new attribute.
	 *
	 * @param attributeId
	 * 				The ID of the new attribute as {@link RexsAttributeId}.
	 * @param matrixValues
	 * 				The value of the new attribute as {@link float[][]}.
	 */
	public void addAttribute(RexsAttributeId attributeId, float[][] matrixValues) {
		RexsAttribute attribute = createAndAddAttribute(attributeId);
		attribute.setDoubleMatrixValue(matrixValues);
	}

	/**
	 * Creates a new attribute with a floating point matrix value and adds it to the component.
	 * <p>
	 * If the component already has an attribute with the attribute ID, then the existing attribute is replaced by the new attribute.
	 *
	 * @param attributeId
	 * 				The ID of the new attribute as {@link RexsAttributeId}.
	 * @param matrixValues
	 * 				The value of the new attribute as {@link double[][]}.
	 */
	public void addAttribute(RexsAttributeId attributeId, double[][] matrixValues) {
		RexsAttribute attribute = createAndAddAttribute(attributeId);
		attribute.setDoubleMatrixValue(matrixValues);
	}

	/**
	 * Creates a new attribute with a Base64 encoded floating point matrix value and adds it to the component.
	 * <p>
	 * If the component already has an attribute with the attribute ID, then the existing attribute is replaced by the new attribute.
	 *
	 * @param attributeId
	 * 				The ID of the new attribute as {@link RexsAttributeId}.
	 * @param matrixValues
	 * 				The value of the new attribute as {@link float[][]}.
	 */
	public void addAttributeBase64(RexsAttributeId attributeId, float[][] matrixValues) {
		RexsAttribute attribute = createAndAddAttribute(attributeId);
		attribute.setDoubleMatrixValueBase64(matrixValues);
	}

	/**
	 * Creates a new attribute with a Base64 encoded floating point matrix value and adds it to the component.
	 * <p>
	 * If the component already has an attribute with the attribute ID, then the existing attribute is replaced by the new attribute.
	 *
	 * @param attributeId
	 * 				The ID of the new attribute as {@link RexsAttributeId}.
	 * @param matrixValues
	 * 				The value of the new attribute as {@link double[][]}.
	 */
	public void addAttributeBase64(RexsAttributeId attributeId, double[][] matrixValues) {
		RexsAttribute attribute = createAndAddAttribute(attributeId);
		attribute.setDoubleMatrixValueBase64(matrixValues);
	}

	/**
	 * Creates a new attribute with a array of integer arrays value and adds it to the component.
	 * <p>
	 * If the component already has an attribute with the attribute ID, then the existing attribute is replaced by the new attribute.
	 *
	 * @param attributeId
	 * 				The ID of the new attribute as {@link RexsAttributeId}.
	 * @param arrayOfIntegerArrayValues
	 * 				The value of the new attribute as {@link List}.
	 */
	public void addAttribute(RexsAttributeId attributeId, List<Integer[]> arrayOfIntegerArrayValues) {
		RexsAttribute attribute = createAndAddAttribute(attributeId);
		attribute.setArrayOfIntegerArraysValue(arrayOfIntegerArrayValues);
	}

	/**
	 * Changes the numeric ID of the component.
	 * <p>
	 * ATTENTION: Make sure that the new ID has not already been assigned to another component.
	 *
	 * @param newId
	 * 				The new numeric ID of the component within the REXS model.
	 */
	public void changeComponentId(Integer newId) {
		this.id = newId;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int compareTo(RexsComponent other) {
		return getId() - other.getId();
	}

	/**
	 * Deletes the attribute of the component for an attribute ID.
	 *
	 * @param attributeId
	 * 				The ID of the attribute as {@link RexsAttributeId}.
	 */
	public void deleteAttribute(RexsAttributeId attributeId) {
		if (hasAttribute(attributeId)) {
			attributes.remove(attributeId.getId());
		}
	}

	/**
	 * Returns whether the component is of a given list of types
	 *
	 * @param rexsComponentTypes
	 * 				an array containing the allowed types
	 *
	 * @return
	 * 				whether the component type is in the list of types
	 */
	public boolean isOfType(RexsComponentType... rexsComponentTypes) {
		return this.type.isOneOf(rexsComponentTypes);
	}

	@Override
    public String toString() {
    	if (name!=null)
    		return name+" - "+id;
    	return String.valueOf(id);
    }

	public void setId(Integer newCompId) {
		if(newCompId != null)
			this.id = newCompId;
	}

	public void setType(RexsComponentType newType) {
		this.type = newType;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof RexsComponent)) {
			return false;
		}
		RexsComponent other = (RexsComponent)o;
		if (!other.canEqual(this)) {
			return false;
		}
		Object this_id = getId();
		Object other_id = other.getId();
		return this_id == null ? other_id == null : this_id.equals(other_id);
	}

	protected boolean canEqual(Object other) {
		return other instanceof RexsComponent;
	}

	@Override
	public int hashCode() {
		int result = 1;
		Object _id = getId();
		result = result * 59 + (_id == null ? 43 : _id.hashCode());
		return result;
	}
}
