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

import info.rexs.model.util.Base64Utils;

public class RexsAttributeValueArrayBase64 extends AbstractRexsAttributeValueArray {

	private String value = null;

	private Base64Type type = null;

	public RexsAttributeValueArrayBase64() {}

	public RexsAttributeValueArrayBase64(String value, Base64Type type) {
		this.value = value;
		this.type = type;
	}

	@Override
	public boolean hasValue() {
		return value != null
				&& !value.isEmpty();
	}

	@Override
	public AbstractRexsAttributeValue copy() {
		return new RexsAttributeValueArrayBase64(value, type);
	}

	@Override
	public Integer[] getValueIntegerArray() {
		if (type == Base64Type.INT_32)
			return Base64Utils.decodeInt32ArrayBoxed(value);
		return super.getValueIntegerArray();
	}

	@Override
	public int[] getValueIntegerArrayUnboxed() {
		if (type == Base64Type.INT_32)
			return Base64Utils.decodeInt32Array(value);
		return super.getValueIntegerArrayUnboxed();
	}

	@Override
	public Double[] getValueDoubleArray() {
		if (type == Base64Type.FLOAT_32)
			return Base64Utils.decodeFloat32ArrayBoxed(value);
		else if (type == Base64Type.FLOAT_64)
			return Base64Utils.decodeFloat64ArrayBoxed(value);
		return super.getValueDoubleArray();
	}

	@Override
	public double[] getValueDoubleArrayUnboxed() {
		if (type == Base64Type.FLOAT_32) {
			float[] floatArray = Base64Utils.decodeFloat32Array(value);
			return convertFloatArrayToDoubleArray(floatArray);

		} else if (type == Base64Type.FLOAT_64)
			return Base64Utils.decodeFloat64Array(value);
		return super.getValueDoubleArrayUnboxed();
	}

	public void setValueIntegerArray(int[] value) {
		this.value = Base64Utils.encodeInt32Array(value);
		this.type = Base64Type.INT_32;
	}

	public void setValueDoubleArray(double[] value) {
		this.value = Base64Utils.encodeFloat64Array(value);
		this.type = Base64Type.FLOAT_64;
	}

	public void setValueDoubleArray(float[] value) {
		this.value = Base64Utils.encodeFloat32Array(value);
		this.type = Base64Type.FLOAT_32;
	}

	public String getRawValue() {
		return value;
	}

	public Base64Type getRawType() {
		return type;
	}
}
