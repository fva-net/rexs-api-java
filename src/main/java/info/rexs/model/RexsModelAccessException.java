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

/**
 * Thrown to indicate that there is illegal access to the REXS model.
 *
 * @author FVA GmbH
 */
public class RexsModelAccessException extends Exception {

	/** Serial Version UID for interoperability */
	private static final long serialVersionUID = -4659241657963203171L;

	/**
	 * Constructs a new {@link RexsModelAccessException} with the specified detail message.
	 *
	 * @param message
	 * 				The detail message.
	 */
	public RexsModelAccessException(String message) {
		super(message);
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
	}
}
