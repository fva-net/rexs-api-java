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

import java.util.List;

import info.rexs.model.RexsModelAccessException;

public abstract class AbstractRexsAttributeValue {

	public abstract boolean hasValue();

	public abstract AbstractRexsAttributeValue copy();

	public boolean getValueBoolean() {
		throw new RexsModelAccessException("attribute value is not available as a boolean");
	}

	public Boolean[] getValueBooleanArray() {
		throw new RexsModelAccessException("attribute value is not available as a boolean array");
	}

	public Boolean[][] getValueBooleanMatrix() {
		throw new RexsModelAccessException("attribute value is not available as a boolean matrix");
	}

	public String getValueString() {
		throw new RexsModelAccessException("attribute value is not available as a string");
	}

	public String[] getValueStringArray() {
		throw new RexsModelAccessException("attribute value is not available as a string array");
	}

	public String[][] getValueStringMatrix() {
		throw new RexsModelAccessException("attribute value is not available as a string matrix");
	}

	public int getValueInteger() {
		throw new RexsModelAccessException("attribute value is not available as a integer");
	}

	public Integer[] getValueIntegerArray() {
		throw new RexsModelAccessException("attribute value is not available as a integer array");
	}

	public int[] getValueIntegerArrayUnboxed() {
		throw new RexsModelAccessException("attribute value is not available as a integer array");
	}

	public Integer[][] getValueIntegerMatrix() {
		throw new RexsModelAccessException("attribute value is not available as a integer matrix");
	}

	public int[][] getValueIntegerMatrixUnboxed() {
		throw new RexsModelAccessException("attribute value is not available as a integer matrix");
	}

	public List<Integer[]> getValueArrayOfIntegerArrays() {
		throw new RexsModelAccessException("attribute value is not available as a array of integer arrays");
	}

	public double getValueDouble() {
		throw new RexsModelAccessException("attribute value is not available as a double");
	}

	public Double[] getValueDoubleArray() {
		throw new RexsModelAccessException("attribute value is not available as a double array");
	}

	public double[] getValueDoubleArrayUnboxed() {
		throw new RexsModelAccessException("attribute value is not available as a double array");
	}

	public Double[][] getValueDoubleMatrix() {
		throw new RexsModelAccessException("attribute value is not available as a double matrix");
	}

	public double[][] getValueDoubleMatrixUnboxed() {
		throw new RexsModelAccessException("attribute value is not available as a double matrix");
	}
}
