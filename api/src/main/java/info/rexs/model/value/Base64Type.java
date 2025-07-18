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
package info.rexs.model.value;

public enum Base64Type {

	INT_32("int32"),
	FLOAT_32("float32"),
	FLOAT_64("float64");

	private final String code;

	private Base64Type(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public static Base64Type fromCode(String code) {
		for (Base64Type type: Base64Type.values()) {
			if (type.code.equals(code)) {
				return type;
			}
		}
		throw new IllegalArgumentException(code);
	}
}
