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
import info.rexs.model.util.Base64Utils;

public class RexsAttributeValueMatrixBase64 extends AbstractRexsAttributeValueMatrix {

	private String value = null;

	private Base64Type type = null;

	private int rows = -1;

	private int cols = -1;

	public RexsAttributeValueMatrixBase64() {}

	public RexsAttributeValueMatrixBase64(String value, Base64Type type, int rows, int cols) {
		this.value = value;
		this.type = type;
		this.rows = rows;
		this.cols = cols;
	}

	@Override
	public boolean hasValue() {
		return value != null;
	}

	@Override
	public AbstractRexsAttributeValue copy() {
		return new RexsAttributeValueMatrixBase64(value, type, rows, cols);
	}

	private void checkRowsAndCols() {
		if (rows < 0)
			throw new RexsModelAccessException("matrix with base64 value requires number of rows");

		if (cols < 0)
			throw new RexsModelAccessException("matrix with base64 value requires number of columns");
	}

	@Override
	public Integer[][] getValueIntegerMatrix() {
		checkRowsAndCols();
		if (type == Base64Type.INT_32)
			return Base64Utils.decodeInt32MatrixBoxed(value, rows, cols);
		return super.getValueIntegerMatrix();
	}

	@Override
	public int[][] getValueIntegerMatrixUnboxed() {
		checkRowsAndCols();
		if (type == Base64Type.INT_32)
			return Base64Utils.decodeInt32Matrix(value, rows, cols);
		return super.getValueIntegerMatrixUnboxed();
	}

	@Override
	public Double[][] getValueDoubleMatrix() {
		checkRowsAndCols();
		if (type == Base64Type.FLOAT_32)
			return Base64Utils.decodeFloat32MatrixBoxed(value, rows, cols);
		else if (type == Base64Type.FLOAT_64)
			return Base64Utils.decodeFloat64MatrixBoxed(value, rows, cols);
		return super.getValueDoubleMatrix();
	}

	@Override
	public double[][] getValueDoubleMatrixUnboxed() {
		checkRowsAndCols();
		if (type == Base64Type.FLOAT_32) {
			float[][] floatMatrix = Base64Utils.decodeFloat32Matrix(value, rows, cols);
			return convertFloatMatrixToDoubleMatrix(floatMatrix);

		} else if (type == Base64Type.FLOAT_64)
			return Base64Utils.decodeFloat64Matrix(value, rows, cols);
		return super.getValueDoubleMatrixUnboxed();
	}

	public void setValueIntegerMatrix(int[][] value) {
		this.value = Base64Utils.encodeInt32Matrix(value);
		this.type = Base64Type.INT_32;
	}

	public void setValueDoubleMatrix(double[][] value) {
		this.value = Base64Utils.encodeFloat64Matrix(value);
		this.type = Base64Type.FLOAT_64;
	}

	public void setValueDoubleMatrix(float[][] value) {
		this.value = Base64Utils.encodeFloat32Matrix(value);
		this.type = Base64Type.FLOAT_32;
	}

	public String getRawValue() {
		return value;
	}

	public Base64Type getRawType() {
		return type;
	}

	public int getRawRows() {
		return rows;
	}

	public int getRawCols() {
		return cols;
	}
}
