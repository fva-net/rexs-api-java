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

import java.util.ArrayList;
import java.util.List;

import info.rexs.model.util.JavaDatatypeUtils;

public class RexsAttributeValueArray extends AbstractRexsAttributeValueArray {

	private List<String> value = null;

	public RexsAttributeValueArray() {}

	public RexsAttributeValueArray(List<String> value) {
		this.value = value;
	}

	@Override
	public boolean hasValue() {
		return value != null
				&& !value.isEmpty();
	}

	@Override
	public AbstractRexsAttributeValue copy() {
		return new RexsAttributeValueArray(new ArrayList<>(value));
	}

	@Override
	public Boolean[] getValueBooleanArray() {
		Boolean[] val = null;
		if (value != null && !value.isEmpty())
			val = convertStringListToBooleanArray(value);
		return val;
	}

	@Override
	public String[] getValueStringArray() {
		String [] val = null;
		if (value != null && !value.isEmpty())
			val = convertStringListToStringArray(value);
		return val;
	}

	@Override
	public Integer[] getValueIntegerArray() {
		Integer[] val = null;
		if (value != null && !value.isEmpty())
			val = convertStringListToIntegerArrayBoxed(value);
		return val;
	}

	@Override
	public int[] getValueIntegerArrayUnboxed() {
		int[] val = null;
		if (value != null && !value.isEmpty())
			val = convertStringListToIntegerArrayUnboxed(value);
		return val;
	}

	@Override
	public Double[] getValueDoubleArray() {
		Double[] val = null;
		if (value != null && !value.isEmpty())
			val = convertStringListToDoubleArrayBoxed(value);
		return val;
	}

	@Override
	public double[] getValueDoubleArrayUnboxed() {
		double[] val = null;
		if (value != null && !value.isEmpty())
			val = convertStringListToDoubleArrayUnboxed(value);
		return val;
	}

	public void setValueBooleanArray(Boolean[] value) {
		setValue(value);
	}

	public void setValueStringArray(String[] value) {
		setValue(value);
	}

	public void setValueIntegerArray(Integer[] value) {
		setValue(value);
	}

	public void setValueIntegerArray(int[] value) {
		setValue(JavaDatatypeUtils.boxIntArray(value));
	}

	public void setValueDoubleArray(Double[] value) {
		setValue(value);
	}

	public void setValueDoubleArray(double[] value) {
		setValue(JavaDatatypeUtils.boxDoubleArray(value));
	}

	public void setValueDoubleArray(float[] value) {
		setValue(JavaDatatypeUtils.boxFloatArray(value));
	}

	private void setValue(Object[] value) {
		if (value == null) {
			this.value = null;
			return;
		}

		this.value = new ArrayList<>();
		for (int i = 0; i < value.length; i++) {
			if (value[i] == null)
				this.value.add("");
			else
				this.value.add(String.valueOf(value[i]));
		}
	}

	public List<String> getRawValue() {
		return value;
	}
}
