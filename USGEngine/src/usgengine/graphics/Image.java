package usgengine.graphics;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import org.lwjgl.BufferUtils;

import usgengine.utils.BufferUtil;
import usgengine.utils.Logger;

import static org.lwjgl.stb.STBImage.*;

public class Image {
	
	private final ByteBuffer image;
	
	private final int width, height;
	private final int components;
	
	public Image(String path) {
		ByteBuffer imageBuffer;
		
		try {
			imageBuffer = BufferUtil.fileToByteBuffer(path);
		} catch (IOException e) {
			Logger.error("Could not find the image at the path '" + path + "'.");
			throw new RuntimeException(e);
		}
		
		IntBuffer w = BufferUtils.createIntBuffer(1);
		IntBuffer h = BufferUtils.createIntBuffer(1);
		IntBuffer c = BufferUtils.createIntBuffer(1);
		
		image = stbi_load_from_memory(imageBuffer, w, h, c, 0);
		
		this.width = w.get(0);
		this.height = h.get(0);
		this.components = c.get(0);
	}
	
	public ByteBuffer getBuffer() {
		return image;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getComponenets() {
		return components;
	}
	
	public void dispose() {
		stbi_image_free(image);
	}

}
