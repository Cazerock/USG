package usgengine.math;

public class Vector4f {

	public float x, y, z, w;

	public Vector4f() {
		x = y = z = w = 0;
	}

	public Vector4f(float xyzw) {
		x = y = z = w = xyzw;
	}
	
	public Vector4f(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public Vector4f(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Vector4f(float x, float y, float z, float w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}

	public Vector4f(Vector4f vector) {
		this.x = vector.x;
		this.y = vector.y;
		this.z = vector.z;
		this.w = vector.w;
	}

	public Vector4f scale(float s) {
		return set(x * s, y * s, z * s, w * s);
	}

	public Vector4f scale(float sx, float sy, float sz, float sw) {
		return set(x * sx, y * sy, z * sz, w * sw);
	}

	public Vector4f scale(Vector4f vector) {
		return set(x * vector.x, y * vector.y, z * vector.z, w * vector.w);
	}

	public Vector4f add(float a) {
		return set(x + a, y + a, z + a, w + a);
	}

	public Vector4f add(float ax, float ay, float az, float aw) {
		return set(x + ax, y + ay, z + az, w + aw);
	}

	public Vector4f add(Vector4f vector) {
		return set(x + vector.x, y + vector.y, z + vector.z, w + vector.w);
	}

	public Vector4f subtract(float s) {
		return set(x - s, y - s, z - s, w - s);
	}

	public Vector4f subtract(float sx, float sy, float sz, float sw) {
		return set(x - sx, y - sy, z - sz, w - sw);
	}

	public Vector4f subtract(Vector4f vector) {
		return set(x - vector.x, y - vector.y, z - vector.z, w - vector.w);
	}

	public Vector4f divide(float d) {
		return set(x / d, y / d, z / d, w / d);
	}

	public Vector4f divide(float dx, float dy, float dz, float dw) {
		return set(x / dx, y / dy, z / dz, w / dw);
	}

	public Vector4f divide(Vector4f vector) {
		return set(x / vector.x, y / vector.y, z / vector.z, w / vector.w);
	}

	public Vector4f copy() {
		return new Vector4f(x, y, z);
	}

	public Vector4f set(float x, float y, float z, float w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;

		return this;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getX() {
		return x;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getY() {
		return y;
	}

	public void setZ(float z) {
		this.z = z;
	}

	public float getZ() {
		return z;
	}

	public void setW(float w) {
		this.w = w;
	}

	public float getW() {
		return w;
	}

	@Override
	public String toString() {
		return ("[" + x + ", " + y + ", " + z + ", " + w + "]");
	}

	@Override
	public boolean equals(Object o) {
		if (o != null && o instanceof Vector4f) {
			return x == ((Vector4f) o).x && y == ((Vector4f) o).y && z == ((Vector4f) o).z && w == ((Vector4f) o).w;
		}
		return false;
	}

}
