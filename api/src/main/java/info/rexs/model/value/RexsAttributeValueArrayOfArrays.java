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

public class RexsAttributeValueArrayOfArrays extends AbstractRexsAttributeValue {

	private List<AbstractRexsAttributeValueArray> value = null;

	public RexsAttributeValueArrayOfArrays() {}

	public RexsAttributeValueArrayOfArrays(List<AbstractRexsAttributeValueArray> value) {
		this.value = value;
	}

	@Override
	public boolean hasValue() {
		return value != null;
	}

	@Override
	public AbstractRexsAttributeValue copy() {
		List<AbstractRexsAttributeValueArray> value = new ArrayList<>();
		if (this.value != null)
			for (AbstractRexsAttributeValueArray arrayValue : this.value) {
				value.add((AbstractRexsAttributeValueArray)arrayValue.copy());
			}

		return new RexsAttributeValueArrayOfArrays(value);
	}

	@Override
	public List<Integer[]> getValueArrayOfIntegerArrays() {
		List<Integer[]> val = new ArrayList<>();

		if (value != null) {
			for (AbstractRexsAttributeValueArray valueArray : value) {
				val.add(valueArray.getValueIntegerArray());
			}
		}

		return val;
	}

	public void setValueArrayOfIntegerArrays(List<Integer[]> value) {
		this.value = new ArrayList<>();

		for (Integer[] valueArray : value) {
			RexsAttributeValueArray array = new RexsAttributeValueArray();
			array.setValueIntegerArray(valueArray);
			this.value.add(array);
		}
	}

	public List<AbstractRexsAttributeValueArray> getRawValue() {
		return value;
	}
}
