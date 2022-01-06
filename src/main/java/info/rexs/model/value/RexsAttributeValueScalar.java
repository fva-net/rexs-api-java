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
package info.rexs.model.value;

import info.rexs.model.RexsModelAccessException;

public class RexsAttributeValueScalar extends AbstractRexsAttributeValue {

	private String value = null;

	public RexsAttributeValueScalar() {}

	public RexsAttributeValueScalar(String value) {
		this.value = value;
	}

	@Override
	public boolean hasValue() {
		return value != null
				&& !value.isEmpty();
	}

	@Override
	public AbstractRexsAttributeValue copy() {
		return new RexsAttributeValueScalar(value);
	}

	@Override
	public boolean getValueBoolean() {
		Boolean val = null;
		if (value != null && !value.isEmpty())
			val = Boolean.valueOf(value);

		if (val == null)
			throw new RexsModelAccessException("boolean value cannot be null");

		return val;
	}

	@Override
	public String getValueString() {
		return value;
	}

	@Override
	public int getValueInteger() {
		Integer val = null;
		if (value != null && !value.isEmpty()) {
			try {
				val = Integer.parseInt(value);
			} catch (NumberFormatException ex) {
				throw new RexsModelAccessException("cannot read integer value " + value, ex);
			}
		}

		return val;
	}

	@Override
	public double getValueDouble() {
		Double val = null;
		if (value != null && !value.isEmpty()) {
			try {
				val = Double.parseDouble(value);
				if (Double.isNaN(val))
					val = null;
			} catch (NumberFormatException ex) {
				throw new RexsModelAccessException("cannot read double value " + value, ex);
			}
		}

		return val;
	}

	public void setValueBoolean(boolean value) {
		this.value = Boolean.toString(value);
	}

	public void setValueString(String value) {
		this.value = value;
	}

	public void setValueInteger(int value) {
		this.value = Integer.toString(value);
	}

	public void setValueDouble(double value) {
		this.value = Double.toString(value);
	}

	public String getRawValue() {
		return value;
	}
}
