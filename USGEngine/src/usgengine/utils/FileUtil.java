package usgengine.utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileUtil {
	
	public static String read(String name) {
		String content = null;
		File file = new File(name);
		
		try {
			FileReader reader = new FileReader(file);
			char[] chars = new char[(int)file.length()];
			reader.read(chars);
			content = new String(chars);
			reader.close();
		} catch (IOException e) {
			Logger.error("Failed to load file '" + name + "'.", e);
		}
		
			return content;
		}

}
