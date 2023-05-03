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

import lombok.Getter;

/**
 * Thrown to indicate that there is illegal access to the REXS model.
 *
 * @author FVA GmbH
 */
@Getter
public class RexsModelAccessException extends RuntimeException {

	/** Serial Version UID for interoperability */
	private static final long serialVersionUID = -4659241657963203171L;

	/** TODO Dcoument me! */
	public static final int DEFAULT_COMPONENT_ID_EMPTY = 0;

	/** TODO Dcoument me! */
	public static final String DEFAULT_COMPONENT_NAME_EMPTY = "";

	/** TODO Document me! */
	private final int componentId;

	/** TODO Document me! */
	private final String componentName;

	/**
	 * Constructs a new {@link RexsModelAccessException} with the specified detail message.
	 *
	 * @param message
	 * 				The detail message.
	 */
	public RexsModelAccessException(String message) {
		super(message);
		this.componentId = DEFAULT_COMPONENT_ID_EMPTY;
		this.componentName = DEFAULT_COMPONENT_NAME_EMPTY;
	}

	/**
	 * Constructs a new {@link RexsModelAccessException} with the specified detail message and cause.
	 *
	 * @param message
	 * 				The detail message.
	 * @param cause
	 * 				The cause.
	 */
	public RexsModelAccessException(String message, Throwable cause) {
		super(message, cause);
		this.componentId = DEFAULT_COMPONENT_ID_EMPTY;
		this.componentName = DEFAULT_COMPONENT_NAME_EMPTY;
	}

	/**
	 * Constructs a new {@link RexsModelAccessException} for a given component with the specified detail message.
	 *
	 * @param rexsComponent
	 * 				The {@link RexsComponent} which caused the exception.
	 * @param message
	 * 				The detail message.
	 */
	public RexsModelAccessException(RexsComponent rexsComponent, String message) {
		super(message);
		this.componentId = rexsComponent.getId();
		this.componentName = rexsComponent.getName();
	}

	/**
	 * Constructs a new {@link RexsModelAccessException} for a given component with the specified detail message and
	 * cause.
	 *
	 * @param rexsComponent
	 *            the {@link RexsComponent} which caused the exception
	 * @param message
	 *            The detail message.
	 * @param cause
	 *            The cause.
	 */
	public RexsModelAccessException(RexsComponent rexsComponent, String message, Throwable cause) {
		super(message, cause);
		this.componentId = rexsComponent.getId();
		this.componentName = rexsComponent.getName();
	}
}
