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

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

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
	public boolean getValueBoolean() throws RexsModelAccessException{
		Boolean val = null;
		if(!value.equals("false")&&!value.equals("true")) {
			throw new RexsModelAccessException("boolean value cannot be "+value);
		}

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
	public int getValueInteger() throws RexsModelAccessException {
		Integer val = null;
		if (value != null && !value.isEmpty()) {
			try {
				val = Integer.parseInt(value);
			} catch (NumberFormatException ex) {
				throw new RexsModelAccessException("cannot read integer value " + value, ex);
			}
		}
		if (val == null)
			throw new RexsModelAccessException("int value cannot be null");

		return val;
	}

	@Override
	public double getValueDouble() throws RexsModelAccessException {
		Double val = null;
		if (value != null && !value.isEmpty()) {
			try {
				val = Double.parseDouble(value);
			} catch (NumberFormatException ex) {
				throw new RexsModelAccessException("cannot read double value " + value, ex);
			}
		}
		if (val == null)
			throw new RexsModelAccessException("double value cannot be null");

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

	public void setValueTime(OffsetDateTime time) {
		this.value = DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(time);
	}

	public OffsetDateTime getValueDateTime() {
		return OffsetDateTime.parse(value, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
	}
}
