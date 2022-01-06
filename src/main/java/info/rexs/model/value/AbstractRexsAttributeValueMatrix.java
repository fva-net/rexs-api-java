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

import java.util.Arrays;
import java.util.List;

import info.rexs.model.RexsModelAccessException;

public abstract class AbstractRexsAttributeValueMatrix extends AbstractRexsAttributeValue {

	protected String[][] convertStringMatrixToStringMatrix(List<List<String>> stringMatrix) {
		String[][] newStringMatrix = new String[stringMatrix.size()][stringMatrix.get(0).size()];

		for (int i = 0; i < stringMatrix.size(); i++) {
			List<String> stringArray = stringMatrix.get(i);
			for (int j = 0; j < stringArray.size(); j++) {
				newStringMatrix[i][j] = stringArray.get(j);
			}
		}
		return newStringMatrix;
	}

	protected Boolean[][] convertStringMatrixToBooleanMatrix(List<List<String>> stringMatrix) {
		Boolean[][] booleanMatrix = new Boolean[stringMatrix.size()][stringMatrix.get(0).size()];

		for (int i = 0; i < stringMatrix.size(); i++) {
			List<String> stringArray = stringMatrix.get(i);
			for (int j = 0; j < stringArray.size(); j++) {
				String stringValue = stringArray.get(j);
				if (!stringValue.isEmpty()) {
					booleanMatrix[i][j] = Boolean.valueOf(stringValue);
				}
			}
		}
		return booleanMatrix;
	}

	protected Integer[][] convertStringMatrixToIntegerMatrixBoxed(List<List<String>> stringMatrix) {
		Integer[][] integerMatrix = new Integer[stringMatrix.size()][stringMatrix.get(0).size()];

		for (int i = 0; i < stringMatrix.size(); i++) {
			List<String> stringArray = stringMatrix.get(i);
			for (int j = 0; j < stringArray.size(); j++) {
				String stringValue = stringArray.get(j);
				if (!stringValue.isEmpty()) {
					try {
						integerMatrix[i][j] = Integer.parseInt(stringValue);
					} catch (NumberFormatException ex) {
						throw new RexsModelAccessException("cannot read integer value " + stringValue, ex);
					}
				}
			}
		}
		return integerMatrix;
	}

	protected int[][] convertStringMatrixToIntegerMatrixUnboxed(List<List<String>> stringMatrix) {
		int[][] integerMatrix = new int[stringMatrix.size()][stringMatrix.get(0).size()];

		for (int i = 0; i < stringMatrix.size(); i++) {
			List<String> stringArray = stringMatrix.get(i);
			for (int j = 0; j < stringArray.size(); j++) {
				String stringValue = stringArray.get(j);
				if (!stringValue.isEmpty()) {
					try {
						integerMatrix[i][j] = Integer.parseInt(stringValue);
					} catch (NumberFormatException ex) {
						throw new RexsModelAccessException("cannot read integer value " + stringValue, ex);
					}
				}
			}
		}
		return integerMatrix;
	}

	protected Double[][] convertStringMatrixToDoubleMatrixBoxed(List<List<String>> stringMatrix) {
		Double[][] doubleMatrix = new Double[stringMatrix.size()][stringMatrix.get(0).size()];

		for (int i = 0; i < stringMatrix.size(); i++) {
			List<String> stringArray = stringMatrix.get(i);
			for (int j = 0; j < stringArray.size(); j++) {
				String stringValue = stringArray.get(j);
				if (!stringValue.isEmpty()) {
					try {
						doubleMatrix[i][j] = Double.parseDouble(stringValue);
						if (Double.isNaN(doubleMatrix[i][j]))
							doubleMatrix[i][j] = null;
					} catch (NumberFormatException ex) {
						throw new RexsModelAccessException("cannot read double value " + stringValue, ex);
					}
				}
			}
		}
		return doubleMatrix;
	}

	protected double[][] convertStringMatrixToDoubleMatrixUnboxed(List<List<String>> stringMatrix) {
		double[][] doubleMatrix = new double[stringMatrix.size()][stringMatrix.get(0).size()];

		for (int i = 0; i < stringMatrix.size(); i++) {
			List<String> stringArray = stringMatrix.get(i);
			for (int j = 0; j < stringArray.size(); j++) {
				String stringValue = stringArray.get(j);
				if (!stringValue.isEmpty()) {
					try {
						double parsedDouble = Double.parseDouble(stringValue);
						if (!Double.isNaN(parsedDouble))
							doubleMatrix[i][j] = parsedDouble;
					} catch (NumberFormatException ex) {
						throw new RexsModelAccessException("cannot read double value " + stringValue, ex);
					}
				}
			}
		}
		return doubleMatrix;
	}

	protected double[][] convertFloatMatrixToDoubleMatrix(float[][] input) {
		if (input == null)
			return null;

		int colLength = Arrays.stream(input)
				.mapToInt(col -> col.length)
				.max()
				.orElse(0);

		double[][] output = new double[input.length][colLength];
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[i].length; j++) {
				output[i][j] = input[i][j];
			}
		}
		return output;
	}
}
