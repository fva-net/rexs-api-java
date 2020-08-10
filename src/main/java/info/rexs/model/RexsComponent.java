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

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collectors;

import info.rexs.db.constants.AttributeId;
import info.rexs.db.constants.ComponentType;
import info.rexs.model.jaxb.Attribute;
import info.rexs.model.jaxb.Component;
import lombok.EqualsAndHashCode;

/**
 * This class represents an component of a REXS model.
 *
 * @author FVA GmbH
 */
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class RexsComponent implements Comparable<RexsComponent> {

	/** The representation of this component in the JAXB model. */
	private Component rawComponent;

	/** The numeric ID of the component within the REXS model. */
	@EqualsAndHashCode.Include
	private Integer id;

	/** The type of the component. */
	private ComponentType type;

	/** An internal index with all attributes of the component for quick access. */
	private Map<String, RexsAttribute> attributes;

	/**
	 * Constructs a new {@link RexsComponent} for the given {@link Component}.
	 *
	 * @param rawComponent
	 * 				The representation of this component in the JAXB model.
	 */
	public RexsComponent(Component rawComponent) {
		this.rawComponent = rawComponent;
		this.id = rawComponent.getId();
		this.type = ComponentType.findById(rawComponent.getType());
		this.attributes = rawComponent.getAttribute().stream().collect(Collectors.toMap(Attribute::getId, RexsAttribute::new));
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
	 * 				The name of the component within the REXS model.
	 */
	public String getName() {
		String name = rawComponent.getName();
		if (name == null)
			name = "";
		return name;
	}

	/**
	 * @return
	 * 				The type of the component as {@link ComponentType}.
	 */
	public ComponentType getType() {
		return type;
	}

	/**
	 * @return
	 * 				The representation of this component in the JAXB model.
	 */
	public Component getRawComponent() {
		return rawComponent;
	}

	/**
	 * @return
	 * 				All attributes assigned to the component as a {@link Collection} of {@link RexsAttribute}.
	 */
	public Collection<RexsAttribute> getAttributes() {
		return Collections.unmodifiableCollection(attributes.values());
	}

	/**
	 * Checks on the ID of an attribute whether the component contains a corresponding attribute.
	 *
	 * @param attributeId
	 * 				The ID of the attribute as {@link AttributeId}.
	 *
	 * @return
	 * 				{@code true} if the component contains the attribute, otherwise {@code false}.
	 */
	public boolean hasAttribute(AttributeId attributeId) {
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
	 * 				The ID of the attribute as {@link AttributeId}.
	 *
	 * @return
	 * 				The attribute as {@link RexsAttribute} or {@code null} if the component does not contain a corresponding attribute.
	 */
	public RexsAttribute getAttribute(AttributeId attributeId) {
		return getAttribute(attributeId.getId());
	}

	/**
	 * Returns the attribute of the component for an attribute ID.
	 *
	 * @param attributeId
	 * 				The ID of the attribute as {@link String}.
	 *
	 * @return
	 * 				The attribute as {@link RexsAttribute} or {@code null} if the component does not contain a corresponding attribute.
	 */
	public RexsAttribute getAttribute(String attributeId) {
		return attributes.get(attributeId);
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
		if (attributes.containsKey(newAttribute.getAttributeId().getId())) {
			Iterator<Attribute> iterator = rawComponent.getAttribute().iterator();
			while(iterator.hasNext()) {
				Attribute attribute = iterator.next();
				if (attribute.getId().equals(newAttribute.getAttributeId().getId())) {
					iterator.remove();
					break;
				}
			}
		}
		attributes.put(newAttribute.getAttributeId().getId(), newAttribute);
		rawComponent.getAttribute().add(newAttribute.getRawAttribute());
	}

	private RexsAttribute createAndAddAttribute(AttributeId attributeId) {
		RexsAttribute attribute = new RexsAttribute(attributeId);
		addAttribute(attribute);
		return attribute;
	}

	/**
	 * Creates a new attribute with a string value and adds it to the component.
	 * <p>
	 * If the component already has an attribute with the attribute ID, then the existing attribute is replaced by the new attribute.
	 *
	 * @param attributeId
	 * 				The ID of the new attribute as {@link AttributeId}.
	 * @param value
	 * 				The value of the new attribute as {@link String}.
	 */
	public void addAttribute(AttributeId attributeId, String value) {
		RexsAttribute attribute = createAndAddAttribute(attributeId);
		attribute.setStringValue(value);
	}

	/**
	 * Creates a new attribute with a boolean value and adds it to the component.
	 * <p>
	 * If the component already has an attribute with the attribute ID, then the existing attribute is replaced by the new attribute.
	 *
	 * @param attributeId
	 * 				The ID of the new attribute as {@link AttributeId}.
	 * @param value
	 * 				The value of the new attribute as {@link Boolean}.
	 */
	public void addAttribute(AttributeId attributeId, Boolean value) {
		RexsAttribute attribute = createAndAddAttribute(attributeId);
		attribute.setBooleanValue(value);
	}

	/**
	 * Creates a new attribute with a integer value and adds it to the component.
	 * <p>
	 * If the component already has an attribute with the attribute ID, then the existing attribute is replaced by the new attribute.
	 *
	 * @param attributeId
	 * 				The ID of the new attribute as {@link AttributeId}.
	 * @param value
	 * 				The value of the new attribute as {@link Integer}.
	 */
	public void addAttribute(AttributeId attributeId, Integer value) {
		RexsAttribute attribute = createAndAddAttribute(attributeId);
		attribute.setIntegerValue(value);
	}

	/**
	 * Creates a new attribute with a floating point value and adds it to the component.
	 * <p>
	 * If the component already has an attribute with the attribute ID, then the existing attribute is replaced by the new attribute.
	 *
	 * @param attributeId
	 * 				The ID of the new attribute as {@link AttributeId}.
	 * @param value
	 * 				The value of the new attribute as {@link Double}.
	 */
	public void addAttribute(AttributeId attributeId, Double value) {
		RexsAttribute attribute = createAndAddAttribute(attributeId);
		attribute.setDoubleValue(value);
	}

	/**
	 * Creates a new attribute with a string array value and adds it to the component.
	 * <p>
	 * If the component already has an attribute with the attribute ID, then the existing attribute is replaced by the new attribute.
	 *
	 * @param attributeId
	 * 				The ID of the new attribute as {@link AttributeId}.
	 * @param arrayValues
	 * 				The value of the new attribute as {@link String[]}.
	 */
	public void addAttribute(AttributeId attributeId, String[] arrayValues) {
		RexsAttribute attribute = createAndAddAttribute(attributeId);
		attribute.setStringArrayValue(arrayValues);
	}

	/**
	 * Creates a new attribute with a boolean array value and adds it to the component.
	 * <p>
	 * If the component already has an attribute with the attribute ID, then the existing attribute is replaced by the new attribute.
	 *
	 * @param attributeId
	 * 				The ID of the new attribute as {@link AttributeId}.
	 * @param arrayValues
	 * 				The value of the new attribute as {@link Boolean[]}.
	 */
	public void addAttribute(AttributeId attributeId, Boolean[] arrayValues) {
		RexsAttribute attribute = createAndAddAttribute(attributeId);
		attribute.setBooleanArrayValue(arrayValues);
	}

	/**
	 * Creates a new attribute with a integer array value and adds it to the component.
	 * <p>
	 * If the component already has an attribute with the attribute ID, then the existing attribute is replaced by the new attribute.
	 *
	 * @param attributeId
	 * 				The ID of the new attribute as {@link AttributeId}.
	 * @param arrayValues
	 * 				The value of the new attribute as {@link Integer[]}.
	 */
	public void addAttribute(AttributeId attributeId, Integer[] arrayValues) {
		RexsAttribute attribute = createAndAddAttribute(attributeId);
		attribute.setIntegerArrayValue(arrayValues);
	}

	/**
	 * Creates a new attribute with a floating point array value and adds it to the component.
	 * <p>
	 * If the component already has an attribute with the attribute ID, then the existing attribute is replaced by the new attribute.
	 *
	 * @param attributeId
	 * 				The ID of the new attribute as {@link AttributeId}.
	 * @param arrayValues
	 * 				The value of the new attribute as {@link Double[]}.
	 */
	public void addAttribute(AttributeId attributeId, Double[] arrayValues) {
		RexsAttribute attribute = createAndAddAttribute(attributeId);
		attribute.setDoubleArrayValue(arrayValues);
	}

	/**
	 * Creates a new attribute with a string matrix value and adds it to the component.
	 * <p>
	 * If the component already has an attribute with the attribute ID, then the existing attribute is replaced by the new attribute.
	 *
	 * @param attributeId
	 * 				The ID of the new attribute as {@link AttributeId}.
	 * @param matrixValues
	 * 				The value of the new attribute as {@link String[][]}.
	 */
	public void addAttribute(AttributeId attributeId, String[][] matrixValues) {
		RexsAttribute attribute = createAndAddAttribute(attributeId);
		attribute.setStringMatrixValue(matrixValues);
	}

	/**
	 * Creates a new attribute with a boolean matrix value and adds it to the component.
	 * <p>
	 * If the component already has an attribute with the attribute ID, then the existing attribute is replaced by the new attribute.
	 *
	 * @param attributeId
	 * 				The ID of the new attribute as {@link AttributeId}.
	 * @param matrixValues
	 * 				The value of the new attribute as {@link Boolean[][]}.
	 */
	public void addAttribute(AttributeId attributeId, Boolean[][] matrixValues) {
		RexsAttribute attribute = createAndAddAttribute(attributeId);
		attribute.setBooleanMatrixValue(matrixValues);
	}

	/**
	 * Creates a new attribute with a integer matrix value and adds it to the component.
	 * <p>
	 * If the component already has an attribute with the attribute ID, then the existing attribute is replaced by the new attribute.
	 *
	 * @param attributeId
	 * 				The ID of the new attribute as {@link AttributeId}.
	 * @param matrixValues
	 * 				The value of the new attribute as {@link Integer[][]}.
	 */
	public void addAttribute(AttributeId attributeId, Integer[][] matrixValues) {
		RexsAttribute attribute = createAndAddAttribute(attributeId);
		attribute.setIntegerMatrixValue(matrixValues);
	}

	/**
	 * Creates a new attribute with a floating point matrix value and adds it to the component.
	 * <p>
	 * If the component already has an attribute with the attribute ID, then the existing attribute is replaced by the new attribute.
	 *
	 * @param attributeId
	 * 				The ID of the new attribute as {@link AttributeId}.
	 * @param matrixValues
	 * 				The value of the new attribute as {@link Double[][]}.
	 */
	public void addAttribute(AttributeId attributeId, Double[][] matrixValues) {
		RexsAttribute attribute = createAndAddAttribute(attributeId);
		attribute.setDoubleMatrixValue(matrixValues);
	}

	/**
	 * Changes the numeric ID of the component.
	 * <p>
	 * ATTENTION: Make sure that the new ID has not already been assigned to another component.
	 *
	 * @param newId
	 * 				The new numeric ID of the component within the REXS model.
	 */
	protected void changeComponentId(Integer newId) {
		id = newId;
		rawComponent.setId(newId);
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
	 * 				The ID of the attribute as {@link AttributeId}.
	 */
	public void deleteAttribute(AttributeId attributeId) {
		if (hasAttribute(attributeId)) {
			RexsAttribute attribute = getAttribute(attributeId);
			attributes.remove(attributeId.getId());
			rawComponent.getAttribute().remove(attribute.getRawAttribute());
		}
	}
}
