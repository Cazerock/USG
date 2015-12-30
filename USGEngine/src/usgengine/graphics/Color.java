package usgengine.graphics;

import usgengine.math.Vector4f;

public class Color {

	public float r, g, b, a;
	
	public static final Color WHITE = new Color(0xFFFFFF);
	public static final Color BLACK = new Color(0x000000);
	public static final Color RED = new Color(0xFF0000);
	public static final Color GREEN = new Color(0x00FF00);
	public static final Color BLUE = new Color(0x0000FF);
		
	public Color(float red, float green, float blue) {
		this.r = red;
		this.g = green;
		this.b = blue;
	}

	public Color(float red, float green, float blue, float alpha) {
		this.r = red;
		this.g = green;
		this.b = blue;
		this.a = alpha;
	}

	public Color(Color color, float a) {
		this(color.r, color.g, color.b, a);
	}

	public Color(Vector4f color) {
		this.r = color.x;
		this.g = color.y;
		this.b = color.z;
		this.a = color.w;
	}

	public Color withNewAlpha(float a) {
		this.a = a;

		return this;
	}

	public Color(int rgba) {
		set(rgba);
	}

	public void set(int rgba) {
		this.r = ((rgba & 0x00FF0000) >> 16) / 255.0f;
		this.g = ((rgba & 0x0000FF00) >> 8) / 255.0f;
		this.b = (rgba & 0x000000FF) / 255.0f;
		this.a = 1 - ((rgba & 0xFF000000) >> 24) / 255.0f;
	}

	public static int toInt(Color color) {
		int r = (int) (color.r * 255);
		int g = (int) (color.g * 255);
		int b = (int) (color.b * 255);
		int a = (int) (color.a * 255);

		return ((r << 0) | (g << 8) | (b << 16) | (a << 24));
	}

}