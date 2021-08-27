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
package info.rexs.model.util;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.Base64;

public class Base64Utils {

	private Base64Utils() {}

	public static String encodeInt32Array(int[] array) {
		return Base64.getEncoder().encodeToString(intToByteArray(array));
	}

	public static int[] decodeInt32Array(String base64Encoded) {
		if (isEmpty(base64Encoded))
			return null;
		byte[] byteArray = Base64.getDecoder().decode(base64Encoded);
		return byteToIntArray(byteArray);
	}

	public static Integer[] decodeInt32ArrayBoxed(String base64Encoded) {
		if (isEmpty(base64Encoded))
			return null;
		int[] intArray = decodeInt32Array(base64Encoded);
		return JavaDatatypeUtils.boxIntArray(intArray);
	}

	public static String encodeFloat32Array(float[] array) {
		return Base64.getEncoder().encodeToString(floatToByteArray(array));
	}

	public static float[] decodeFloat32Array(String base64Encoded) {
		if (isEmpty(base64Encoded))
			return null;
		byte[] byteArray = Base64.getDecoder().decode(base64Encoded);
		return byteToFloatArray(byteArray);
	}

	public static Double[] decodeFloat32ArrayBoxed(String base64Encoded) {
		if (isEmpty(base64Encoded))
			return null;
		float[] floatArray = decodeFloat32Array(base64Encoded);
		return JavaDatatypeUtils.boxFloatArray(floatArray);
	}

	public static String encodeFloat64Array(double[] array) {
		return Base64.getEncoder().encodeToString(doubleToByteArray(array));
	}

	public static double[] decodeFloat64Array(String base64Encoded) {
		if (isEmpty(base64Encoded))
			return null;
		byte[] byteArray = Base64.getDecoder().decode(base64Encoded);
		return byteToDoubleArray(byteArray);
	}

	public static Double[] decodeFloat64ArrayBoxed(String base64Encoded) {
		if (isEmpty(base64Encoded))
			return null;
		double[] doubleArray = decodeFloat64Array(base64Encoded);
		return JavaDatatypeUtils.boxDoubleArray(doubleArray);
	}

	private static byte[] intToByteArray(int[] array) {
		ByteBuffer buf = ByteBuffer.allocate(Integer.SIZE / Byte.SIZE * array.length);
		buf.order(ByteOrder.LITTLE_ENDIAN).asIntBuffer().put(array);
		return buf.array();
	}

	private static byte[] floatToByteArray(float[] array) {
		ByteBuffer buf = ByteBuffer.allocate(Float.SIZE / Byte.SIZE * array.length);
		buf.order(ByteOrder.LITTLE_ENDIAN).asFloatBuffer().put(array);
		return buf.array();
	}

	private static byte[] doubleToByteArray(double[] array) {
		ByteBuffer buf = ByteBuffer.allocate(Double.SIZE / Byte.SIZE * array.length);
		buf.order(ByteOrder.LITTLE_ENDIAN).asDoubleBuffer().put(array);
		return buf.array();
	}

	private static int[] byteToIntArray(byte[] bytes) {
		IntBuffer buf = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
		int[] array = new int[buf.limit()];
		buf.get(array);
		return array;
	}

	private static float[] byteToFloatArray(byte[] bytes) {
		FloatBuffer buf = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN).asFloatBuffer();
		float[] array = new float[buf.limit()];
		buf.get(array);
		return array;
	}

	private static double[] byteToDoubleArray(byte[] bytes) {
		DoubleBuffer buf = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN).asDoubleBuffer();
		double[] array = new double[buf.limit()];
		buf.get(array);
		return array;
	}

	public static String encodeInt32Matrix(int[][] matrix) {
		int[] array = flatIntMatrix(matrix);
		return encodeInt32Array(array);
	}

	public static int[][] decodeInt32Matrix(String base64Encoded, int rows, int cols) {
		if (isEmpty(base64Encoded))
			return null;
		int[] intArray = decodeInt32Array(base64Encoded);
		return unflatIntMatrix(intArray, rows, cols);
	}

	public static Integer[][] decodeInt32MatrixBoxed(String base64Encoded, int rows, int cols) {
		if (isEmpty(base64Encoded))
			return null;
		int[][] intMatrix = decodeInt32Matrix(base64Encoded, rows, cols);
		return JavaDatatypeUtils.boxIntMatrix(intMatrix);
	}

	public static String encodeFloat32Matrix(float[][] matrix) {
		float[] array = flatFloatMatrix(matrix);
		return encodeFloat32Array(array);
	}

	public static float[][] decodeFloat32Matrix(String base64Encoded, int rows, int cols) {
		if (isEmpty(base64Encoded))
			return null;
		float[] floatArray = decodeFloat32Array(base64Encoded);
		return unflatFloatMatrix(floatArray, rows, cols);
	}

	public static Double[][] decodeFloat32MatrixBoxed(String base64Encoded, int rows, int cols) {
		if (isEmpty(base64Encoded))
			return null;
		float[][] floatMatrix = decodeFloat32Matrix(base64Encoded, rows, cols);
		return JavaDatatypeUtils.boxFloatMatrix(floatMatrix);
	}

	public static String encodeFloat64Matrix(double[][] matrix) {
		double[] array = flatDoubleMatrix(matrix);
		return encodeFloat64Array(array);
	}

	public static double[][] decodeFloat64Matrix(String base64Encoded, int rows, int cols) {
		if (isEmpty(base64Encoded))
			return null;
		double[] doubleArray = decodeFloat64Array(base64Encoded);
		return unflatDoubleMatrix(doubleArray, rows, cols);
	}

	public static Double[][] decodeFloat64MatrixBoxed(String base64Encoded, int rows, int cols) {
		if (isEmpty(base64Encoded))
			return null;
		double[][] doubleMatrix = decodeFloat64Matrix(base64Encoded, rows, cols);
		return JavaDatatypeUtils.boxDoubleMatrix(doubleMatrix);
	}

	private static int[] flatIntMatrix(int[][] matrix) {
		int arrayLength = 0;
		for (int i = 0; i < matrix.length; i++)
			arrayLength += matrix[i].length;

		int[] array = new int[arrayLength];
		int arrayIndex = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				array[arrayIndex++] = matrix[i][j];
			}
		}

		return array;
	}

	private static float[] flatFloatMatrix(float[][] matrix) {
		int arrayLength = 0;
		for (int i = 0; i < matrix.length; i++)
			arrayLength += matrix[i].length;

		float[] array = new float[arrayLength];
		int arrayIndex = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				array[arrayIndex++] = matrix[i][j];
			}
		}

		return array;
	}

	private static double[] flatDoubleMatrix(double[][] matrix) {
		int arrayLength = 0;
		for (int i = 0; i < matrix.length; i++)
			arrayLength += matrix[i].length;

		double[] array = new double[arrayLength];
		int arrayIndex = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				array[arrayIndex++] = matrix[i][j];
			}
		}

		return array;
	}

	private static int[][] unflatIntMatrix(int[] array, int rows, int cols) {
		int[][] matrix = new int[rows][cols];
		for (int i = 0; i < array.length; i++) {
			int rowIndex = i / cols;
			int colIndex = i % cols;
			matrix[rowIndex][colIndex] = array[i];
		}
		return matrix;
	}

	private static float[][] unflatFloatMatrix(float[] array, int rows, int cols) {
		float[][] matrix = new float[rows][cols];
		for (int i = 0; i < array.length; i++) {
			int rowIndex = i / cols;
			int colIndex = i % cols;
			matrix[rowIndex][colIndex] = array[i];
		}
		return matrix;
	}

	private static double[][] unflatDoubleMatrix(double[] array, int rows, int cols) {
		double[][] matrix = new double[rows][cols];
		for (int i = 0; i < array.length; i++) {
			int rowIndex = i / cols;
			int colIndex = i % cols;
			matrix[rowIndex][colIndex] = array[i];
		}
		return matrix;
	}

	private static boolean isEmpty(String value) {
		return value == null || value.length() < 1;
	}
}
