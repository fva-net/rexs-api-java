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
package info.rexs.model.util;

import java.util.Arrays;
import java.util.stream.IntStream;

public class JavaDatatypeUtils {

	private JavaDatatypeUtils() {}

	public static Integer[] boxIntArray(int[] array) {
		return Arrays.stream(array).boxed().toArray(Integer[]::new);
	}

	public static Double[] boxFloatArray(float[] array) {
		return IntStream.range(0, array.length).mapToDouble(i -> array[i]).boxed().toArray(Double[]::new);
	}

	public static Double[] boxDoubleArray(double[] array) {
		return Arrays.stream(array).boxed().toArray(Double[]::new);
	}

	public static Integer[][] boxIntMatrix(int[][] matrix) {
		int colLength = 0;
		for (int i = 0; i < matrix.length; i++)
			colLength += matrix[i].length;

		Integer[][] boxedMatrix = new Integer[matrix.length][colLength];
		for (int i = 0; i < matrix.length; i++)
			boxedMatrix[i] = boxIntArray(matrix[i]);

		return boxedMatrix;
	}

	public static Double[][] boxFloatMatrix(float[][] matrix) {
		int colLength = 0;
		for (int i = 0; i < matrix.length; i++)
			colLength += matrix[i].length;

		Double[][] boxedMatrix = new Double[matrix.length][colLength];
		for (int i = 0; i < matrix.length; i++)
			boxedMatrix[i] = boxFloatArray(matrix[i]);

		return boxedMatrix;
	}

	public static Double[][] boxDoubleMatrix(double[][] matrix) {
		int colLength = 0;
		for (int i = 0; i < matrix.length; i++)
			colLength += matrix[i].length;

		Double[][] boxedMatrix = new Double[matrix.length][colLength];
		for (int i = 0; i < matrix.length; i++)
			boxedMatrix[i] = boxDoubleArray(matrix[i]);

		return boxedMatrix;
	}
}
