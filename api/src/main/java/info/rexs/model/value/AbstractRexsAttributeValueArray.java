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

import java.util.List;

import info.rexs.model.RexsModelAccessException;

public abstract class AbstractRexsAttributeValueArray extends AbstractRexsAttributeValue {

	protected String[] convertStringListToStringArray(List<String> stringList) {
		String[] stringArray = new String[stringList.size()];

		for (int i = 0; i < stringList.size(); i++) {
			stringArray[i] = stringList.get(i);
		}
		return stringArray;
	}

	protected Boolean[] convertStringListToBooleanArray(List<String> stringList) {
		Boolean[] booleanArray = new Boolean[stringList.size()];

		for (int i = 0; i < stringList.size(); i++) {
			String stringValue = stringList.get(i);
			if (!stringValue.isEmpty()) {
				if(!stringValue.equals("false")&&!stringValue.equals("true")) {
					throw new RexsModelAccessException("cannot read boolean value " + stringValue);
				}
				booleanArray[i] = Boolean.valueOf(stringValue);
			}
		}
		return booleanArray;
	}

	protected Integer[] convertStringListToIntegerArrayBoxed(List<String> stringList) {
		Integer[] integerArray = new Integer[stringList.size()];

		for (int i = 0; i < stringList.size(); i++) {
			String stringValue = stringList.get(i);
			if (!stringValue.isEmpty()) {
				try {
					integerArray[i] = Integer.parseInt(stringValue);
				} catch (NumberFormatException ex) {
					throw new RexsModelAccessException("cannot read integer value " + stringValue, ex);
				}
			}
		}
		return integerArray;
	}

	protected int[] convertStringListToIntegerArrayUnboxed(List<String> stringList) {
		int[] integerArray = new int[stringList.size()];

		for (int i = 0; i < stringList.size(); i++) {
			String stringValue = stringList.get(i);
			if (!stringValue.isEmpty()) {
				try {
					integerArray[i] = Integer.parseInt(stringValue);
				} catch (NumberFormatException ex) {
					throw new RexsModelAccessException("cannot read integer value " + stringValue, ex);
				}
			}
		}
		return integerArray;
	}

	protected Double[] convertStringListToDoubleArrayBoxed(List<String> stringList) {
		Double[] doubleArray = new Double[stringList.size()];

		for (int i = 0; i < stringList.size(); i++) {
			String stringValue = stringList.get(i);
			if (!stringValue.isEmpty()) {
				try {
					doubleArray[i] = Double.parseDouble(stringValue);
					if (Double.isNaN(doubleArray[i]))
						doubleArray[i] = null;
				} catch (NumberFormatException ex) {
					throw new RexsModelAccessException("cannot read double value " + stringValue, ex);
				}
			}
		}
		return doubleArray;
	}

	protected double[] convertStringListToDoubleArrayUnboxed(List<String> stringList) {
		double[] doubleArray = new double[stringList.size()];

		for (int i = 0; i < stringList.size(); i++) {
			String stringValue = stringList.get(i);
			if (!stringValue.isEmpty()) {
				try {
					double parsedDouble = Double.parseDouble(stringValue);
					if (!Double.isNaN(parsedDouble))
						doubleArray[i] = parsedDouble;
				} catch (NumberFormatException ex) {
					throw new RexsModelAccessException("cannot read double value " + stringValue, ex);
				}
			}
		}
		return doubleArray;
	}

	protected double[] convertFloatArrayToDoubleArray(float[] input) {
		if (input == null)
			return null;

		double[] output = new double[input.length];
		for (int i = 0; i < input.length; i++) {
			output[i] = input[i];
		}
		return output;
	}
}
