package file;

import java.io.File;

public class TestePathSO {
	
	public static void main(String[] args) {
		
		File files = new File("D:\\Meus documentos\\_teste");
		
		for(File file : files.listFiles()){
			if(!file.isDirectory()){
				if(file.separatorChar == '\\')
					System.out.println("windows");
				System.out.println(file.separatorChar);
				
				if(file.separatorChar == '/')
					System.out.println("unix");
				
				System.out.println("arquivo"+file.separatorChar+"nome novo");
			}
			
		}
	}

}
