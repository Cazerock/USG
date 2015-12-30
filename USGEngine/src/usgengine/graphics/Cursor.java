package usgengine.graphics;

import org.lwjgl.glfw.GLFWImage;

import usgengine.utils.Logger;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.system.MemoryUtil.*;

public class Cursor {
	
	private long cursor;
	private Texture texture;
	private int xHot, yHot;
	
	public Cursor(Texture texture) {
		this(texture, 0, 0);
	}
	
	public Cursor(Texture texture, int xHot, int yHot) {
		this.texture = texture;
		this.xHot = xHot;
		this.yHot = yHot;
		
		GLFWImage image = GLFWImage.malloc();
		image.width(texture.getWidth());
		image.height(texture.getHeight());
		image.pixels(texture.getBuffer());
		
		cursor = glfwCreateCursor(image, xHot, yHot);
		if(cursor == NULL) {
			Logger.error("Failed to create the GLFW cursor.");
			new RuntimeException();
		}
		
		image.free();
	}
		
	public Cursor(Standard cursor) {
		this.cursor = glfwCreateStandardCursor(cursor.get());
		
		if(this.cursor == NULL) {
			Logger.error("Failed to create the GLFW cursor.");
			new RuntimeException();
		}
	}
	
	public int getXHot() {
		return xHot;
	}
	
	public int getYHot() {
		return yHot;
	}
	
	public Texture getTexture() {
		return texture;
	}
	
	public long getCursor() {
		return cursor;
	}
	
	public enum Standard {
        ARROW(GLFW_ARROW_CURSOR),
        IBEAM(GLFW_IBEAM_CURSOR),
        CROSSHAIR(GLFW_CROSSHAIR_CURSOR),
        HAND(GLFW_HAND_CURSOR),
        HRESIZE(GLFW_HRESIZE_CURSOR),
        VRESIZE(GLFW_VRESIZE_CURSOR);

        private int standard;

        Standard(int standard) {
            this.standard = standard;
        }
        
        public int get() {
            return standard;
        }
    }

}
