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
package info.rexs.upgrade;

/**
 * Thrown to indicate an error during the upgrade process of a REXS model.
 *
 * @author FVA GmbH
 */
public class RexsUpgradeException extends Exception {

	/** Serial Version UID for interoperability */
	private static final long serialVersionUID = -3716334373193476988L;

	/**
	 * Constructs a new {@link RexsUpgradeException} with the specified detail message.
	 *
	 * @param message
	 * 				The detail message.
	 */
	public RexsUpgradeException(String message) {
		super(message);
	}

	/**
	 * Constructs a new {@link RexsUpgradeException} with the specified detail message and cause.
	 *
	 * @param message
	 * 				The detail message.
	 * @param cause
	 * 				The cause.
	 */
	public RexsUpgradeException(String message, Throwable cause) {
		super(message, cause);
	}
}
