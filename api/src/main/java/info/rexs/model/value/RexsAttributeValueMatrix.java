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

public class RexsAttributeValueMatrix extends AbstractRexsAttributeValueMatrix {

	private List<List<String>> value = null;

	public RexsAttributeValueMatrix() {}

	public RexsAttributeValueMatrix(List<List<String>> value) {
		this.value = value;
	}

	@Override
	public boolean hasValue() {
		return value != null
				&& !value.isEmpty();
	}

	@Override
	public AbstractRexsAttributeValue copy() {
		List<List<String>> value = null;
		if (this.value != null) {
			value = new ArrayList<>();
			for (List<String> rowValue : this.value) {
				value.add(new ArrayList<>(rowValue));
			}
		}

		return new RexsAttributeValueMatrix(value);
	}

	@Override
	public Boolean[][] getValueBooleanMatrix() {
		Boolean[][] val = null;
		if (value != null && !value.isEmpty())
			val = convertStringMatrixToBooleanMatrix(value);
		return val;
	}

	@Override
	public String[][] getValueStringMatrix() {
		String[][] val = null;
		if (value != null && !value.isEmpty())
			val = convertStringMatrixToStringMatrix(value);
		return val;
	}

	@Override
	public Integer[][] getValueIntegerMatrix() {
		Integer[][] val = null;
		if (value != null && !value.isEmpty())
			val = convertStringMatrixToIntegerMatrixBoxed(value);
		return val;
	}

	@Override
	public int[][] getValueIntegerMatrixUnboxed() {
		int[][] val = null;
		if (value != null && !value.isEmpty())
			val = convertStringMatrixToIntegerMatrixUnboxed(value);
		return val;
	}

	@Override
	public Double[][] getValueDoubleMatrix() {
		Double[][] val = null;
		if (value != null && !value.isEmpty())
			val = convertStringMatrixToDoubleMatrixBoxed(value);
		return val;
	}

	@Override
	public double[][] getValueDoubleMatrixUnboxed() {
		double[][] val = null;
		if (value != null && !value.isEmpty())
			val = convertStringMatrixToDoubleMatrixUnboxed(value);
		return val;
	}

	public void setValueBooleanMatrix(Boolean[][] value) {
		setValue(value);
	}

	public void setValueStringMatrix(String[][] value) {
		setValue(value);
	}

	public void setValueIntegerMatrix(Integer[][] value) {
		setValue(value);
	}

	public void setValueIntegerMatrix(int[][] value) {
		setValue(JavaDatatypeUtils.boxIntMatrix(value));
	}

	public void setValueDoubleMatrix(Double[][] value) {
		setValue(value);
	}

	public void setValueDoubleMatrix(double[][] value) {
		setValue(JavaDatatypeUtils.boxDoubleMatrix(value));
	}

	public void setValueDoubleMatrix(float[][] value) {
		setValue(JavaDatatypeUtils.boxFloatMatrix(value));
	}

	private void setValue(Object[][] value) {
		if (value == null) {
			this.value = null;
			return;
		}

		this.value = new ArrayList<>();
		for (int i = 0; i < value.length; i++) {
			List<String> row = new ArrayList<>();
			if (value[i] != null) {
				for (int j = 0; j < value[i].length; j++) {
					if (value[i][j] == null)
						row.add("");
					else
						row.add(String.valueOf(value[i][j]));
				}
			}
			this.value.add(row);
		}
	}

	public List<List<String>> getRawValue() {
		return value;
	}
}
