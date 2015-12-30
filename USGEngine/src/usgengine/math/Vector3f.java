package usgengine.math;

public class Vector3f {

	public float x, y, z;

	public Vector3f() {
		x = y = z = 0;
	}

	public Vector3f(float xyz) {
		x = y = z = xyz;
	}

	public Vector3f(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Vector3f(Vector3f vector) {
		this.x = vector.x;
		this.y = vector.y;
		this.z = vector.z;
	}

	public Vector3f scale(float s) {
		return set(x * s, y * s, z * s);
	}

	public Vector3f scale(float sx, float sy, float sz) {
		return set(x * sx, y * sy, z * sz);
	}

	public Vector3f scale(Vector3f vector) {
		return set(x * vector.x, y * vector.y, z * vector.z);
	}

	public Vector3f add(float a) {
		return set(x + a, y + a, z + a);
	}

	public Vector3f add(float ax, float ay, float az) {
		return set(x + ax, y + ay, z + az);
	}

	public Vector3f add(Vector3f vector) {
		return set(x + vector.x, y + vector.y, z + vector.z);
	}

	public Vector3f subtract(float s) {
		return set(x - s, y - s, z - s);
	}

	public Vector3f subtract(float sx, float sy, float sz) {
		return set(x - sx, y - sy, z - sz);
	}

	public Vector3f subtract(Vector3f vector) {
		return set(x - vector.x, y - vector.y, z - vector.z);
	}

	public Vector3f divide(float d) {
		return set(x / d, y / d, z / d);
	}

	public Vector3f divide(float dx, float dy, float dz) {
		return set(x / dx, y / dy, z / dz);
	}

	public Vector3f divide(Vector3f vector) {
		return set(x / vector.x, y / vector.y, z / vector.z);
	}

	public Vector3f copy() {
		return new Vector3f(x, y, z);
	}

	public Vector3f set(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;

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

	@Override
	public String toString() {
		return ("[" + x + ", " + y + ", " + z + "]");
	}

	@Override
	public boolean equals(Object o) {
		if (o != null && o instanceof Vector3f) {
			return x == ((Vector3f) o).x && y == ((Vector3f) o).y && z == ((Vector3f) o).z;
		}
		return false;
	}

}
