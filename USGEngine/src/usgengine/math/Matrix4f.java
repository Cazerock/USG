package usgengine.math;

import java.nio.FloatBuffer;

import usgengine.utils.BufferUtil;

public class Matrix4f implements Cloneable {

	private float[] elements = new float[16];

	public Matrix4f() {
		for (int i = 0; i < elements.length; i++) {
			elements[i] = 0.0f;
		}
	}

	public Matrix4f(float diagonal) {
		for (int i = 0; i < elements.length; i++) {
			elements[i] = 0.0f;
		}

		elements[0 + 0 * 4] = diagonal;
		elements[1 + 1 * 4] = diagonal;
		elements[2 + 2 * 4] = diagonal;
		elements[3 + 3 * 4] = diagonal;
	}

	public static Matrix4f identity() {
		return new Matrix4f(1.0f);
	}

	public Matrix4f multiply(Matrix4f other) {
		float[] temp = new float[16];

		for (int y = 0; y < 4; y++) {
			for (int x = 0; x < 4; x++) {
				float sum = 0.0f;
				for (int e = 0; e < 4; e++) {
					sum += elements[x + e * 4] * other.elements[e + y * 4];
				}
				temp[x + y * 4] = sum;
			}
		}

		for (int i = 0; i < temp.length; i++) {
			elements[i] = temp[i];
		}

		return this;
	}

	public static Matrix4f orthographic(float left, float right, float bottom, float top, float near, float far) {
		Matrix4f result = Matrix4f.identity();

		result.elements[0 + 0 * 4] = 2.0f / (right - left);
		result.elements[1 + 1 * 4] = 2.0f / (top - bottom);
		result.elements[2 + 2 * 4] = 2.0f / (near - far);

		result.elements[0 + 3 * 4] = (left + right) / (left - right);
		result.elements[1 + 3 * 4] = (bottom + top) / (bottom - top);
		result.elements[2 + 3 * 4] = (far + near) / (far - near);

		return result;
	}

	public static Matrix4f perspective(float fov, float aspect, float near, float far) {
		Matrix4f result = Matrix4f.identity();

		result.elements[0 + 0 * 4] = ((float) (1.0f / Math.tan(Math.toRadians(0.5 * fov)))) / aspect;
		result.elements[1 + 1 * 4] = (float) (1.0f / Math.tan(Math.toRadians(0.5 * fov)));
		result.elements[2 + 2 * 4] = (near + far) / (near - far);
		result.elements[3 + 2 * 4] = 1.0f;
		result.elements[2 + 3 * 4] = (2.0f * near * far) / (near - far);

		return result;
	}

	public static Matrix4f translate(float x, float y, float z) {
		Matrix4f result = Matrix4f.identity();

		result.elements[0 + 3 * 4] = x;
		result.elements[1 + 3 * 4] = y;
		result.elements[2 + 3 * 4] = z;

		return result;
	}

	public static Matrix4f rotate(float angle, Vector3f axis) {
		Matrix4f result = Matrix4f.identity();

		float r = (float) Math.toRadians(angle);
		float c = (float) Math.cos(r);
		float s = (float) Math.sin(r);
		float omc = 1.0f - c;

		result.elements[0 + 0 * 4] = axis.x * omc + c;
		result.elements[1 + 0 * 4] = axis.y * axis.x * omc + axis.z * s;
		result.elements[2 + 0 * 4] = axis.x * axis.z * omc - axis.y * s;

		result.elements[0 + 1 * 4] = axis.x * axis.y * omc - axis.z * s;
		result.elements[1 + 1 * 4] = axis.y * omc + c;
		result.elements[2 + 1 * 4] = axis.y * axis.z * omc + axis.x * s;

		result.elements[0 + 2 * 4] = axis.x * axis.z * omc + axis.y * s;
		result.elements[1 + 2 * 4] = axis.x * axis.z * omc + axis.x * s;
		result.elements[2 + 2 * 4] = axis.z * omc + c;

		return result;
	}

	public static Matrix4f scale(Vector3f scale) {
		Matrix4f result = Matrix4f.identity();

		result.elements[0 + 0 * 4] = scale.x;
		result.elements[1 + 1 * 4] = scale.y;
		result.elements[2 + 2 * 4] = scale.z;

		return result;
	}

	public Matrix4f invert() {
		float[] temp = new float[16];

		temp[0] = elements[5] * elements[10] * elements[15] - elements[5] * elements[11] * elements[14] - elements[9] * elements[6] * elements[15] + elements[9] * elements[7] * elements[14] + elements[13] * elements[6] * elements[11] - elements[13] * elements[7] * elements[10];
		temp[1] = -elements[1] * elements[10] * elements[15] + elements[1] * elements[11] * elements[14] + elements[9] * elements[2] * elements[15] - elements[9] * elements[3] * elements[14] - elements[13] * elements[2] * elements[11] + elements[13] * elements[3] * elements[10];
		temp[2] = elements[1] * elements[6] * elements[15] - elements[1] * elements[7] * elements[14] - elements[5] * elements[2] * elements[15] + elements[5] * elements[3] * elements[14] + elements[13] * elements[2] * elements[7] - elements[13] * elements[3] * elements[6];
		temp[3] = -elements[1] * elements[6] * elements[11] + elements[1] * elements[7] * elements[10] + elements[5] * elements[2] * elements[11] - elements[5] * elements[3] * elements[10] - elements[9] * elements[2] * elements[7] + elements[9] * elements[3] * elements[6];
		temp[4] = -elements[4] * elements[10] * elements[15] + elements[4] * elements[11] * elements[14] + elements[8] * elements[6] * elements[15] - elements[8] * elements[7] * elements[14] - elements[12] * elements[6] * elements[11] + elements[12] * elements[7] * elements[10];
		temp[5] = elements[0] * elements[10] * elements[15] - elements[0] * elements[11] * elements[14] - elements[8] * elements[2] * elements[15] + elements[8] * elements[3] * elements[14] + elements[12] * elements[2] * elements[11] - elements[12] * elements[3] * elements[10];
		temp[6] = -elements[0] * elements[6] * elements[15] + elements[0] * elements[7] * elements[14] + elements[4] * elements[2] * elements[15] - elements[4] * elements[3] * elements[14] - elements[12] * elements[2] * elements[7] + elements[12] * elements[3] * elements[6];
		temp[7] = elements[0] * elements[6] * elements[11] - elements[0] * elements[7] * elements[10] - elements[4] * elements[2] * elements[11] + elements[4] * elements[3] * elements[10] + elements[8] * elements[2] * elements[7] - elements[8] * elements[3] * elements[6];
		temp[8] = elements[4] * elements[9] * elements[15] - elements[4] * elements[11] * elements[13] - elements[8] * elements[5] * elements[15] + elements[8] * elements[7] * elements[13] + elements[12] * elements[5] * elements[11] - elements[12] * elements[7] * elements[9];
		temp[9] = -elements[0] * elements[9] * elements[15] + elements[0] * elements[11] * elements[13] + elements[8] * elements[1] * elements[15] - elements[8] * elements[3] * elements[13] - elements[12] * elements[1] * elements[11] + elements[12] * elements[3] * elements[9];
		temp[10] = elements[0] * elements[5] * elements[15] - elements[0] * elements[7] * elements[13] - elements[4] * elements[1] * elements[15] + elements[4] * elements[3] * elements[13] + elements[12] * elements[1] * elements[7] - elements[12] * elements[3] * elements[5];
		temp[11] = -elements[0] * elements[5] * elements[11] + elements[0] * elements[7] * elements[9] + elements[4] * elements[1] * elements[11] - elements[4] * elements[3] * elements[9] - elements[8] * elements[1] * elements[7] + elements[8] * elements[3] * elements[5];
		temp[12] = -elements[4] * elements[9] * elements[14] + elements[4] * elements[10] * elements[13] + elements[8] * elements[5] * elements[14] - elements[8] * elements[6] * elements[13] - elements[12] * elements[5] * elements[10] + elements[12] * elements[6] * elements[9];
		temp[13] = elements[0] * elements[9] * elements[14] - elements[0] * elements[10] * elements[13] - elements[8] * elements[1] * elements[14] + elements[8] * elements[2] * elements[13] + elements[12] * elements[1] * elements[10] - elements[12] * elements[2] * elements[9];
		temp[14] = -elements[0] * elements[5] * elements[14] + elements[0] * elements[6] * elements[13] + elements[4] * elements[1] * elements[14] - elements[4] * elements[2] * elements[13] - elements[12] * elements[1] * elements[6] + elements[12] * elements[2] * elements[5];
		temp[15] = elements[0] * elements[5] * elements[10] - elements[0] * elements[6] * elements[9] - elements[4] * elements[1] * elements[10] + elements[4] * elements[2] * elements[9] + elements[8] * elements[1] * elements[6] - elements[8] * elements[2] * elements[5];

		double determinant = elements[0] * temp[0] + elements[1] * temp[4] + elements[2] * temp[8] + elements[3] * temp[12];
		determinant = 1.0 / determinant;

		for (int i = 0; i < 16; i++)
			elements[i] = (float) (temp[i] * determinant);

		return this;
	}

	public void setElement(int index, float value) {
		elements[index] = value;
	}

	public void setElement(int row, int column, float value) {
		setElement(row + column * 4, value);
	}

	public float getElement(int index) {
		return elements[index];
	}

	public float getElement(int row, int column) {
		return elements[row + column * 4];
	}
	
	public FloatBuffer getBuffer() {
		return BufferUtil.toFloatBuffer(elements);
	}

	@Override
	public Matrix4f clone() {
		Matrix4f result = Matrix4f.identity();

		for (int i = 0; i < elements.length; i++) {
			result.elements[i] = elements[i];
		}

		return result;
	}

}
