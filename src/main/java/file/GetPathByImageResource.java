package file;

import java.io.File;
import java.io.IOException;

public class GetPathByImageResource {

	public static void main(String[] args) throws IOException {
		String[] fileArray = { 
				"resources/imageTest.jpg",
				"../resources/imageTest.jpg", 
				"../imageTest.jpg", 
				"/Programacion/oxygen/eclipse_teste/worksapace/Testes/resources/imageTest.jpg" 
		};

		for (String f : fileArray) {
			displayInfo(f);
		}

	}

	public static void displayInfo(String f) throws IOException {
		File file = new File(f);
		System.out.println("========================================");
		System.out.println("          name:" + file.getName());
		System.out.println("  is directory:" + file.isDirectory());
		System.out.println("	   is file:" + file.isFile());
		System.out.println("        exists:" + file.exists());
		System.out.println("          path:" + file.getPath());
		System.out.println(" absolute file:" + file.getAbsoluteFile());
		System.out.println(" absolute path:" + file.getAbsolutePath());
		System.out.println("canonical file:" + file.getCanonicalFile());
		System.out.println("canonical path:" + file.getCanonicalPath());
	}

}
