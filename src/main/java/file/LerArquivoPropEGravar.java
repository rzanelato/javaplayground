package file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class LerArquivoPropEGravar {

	private static List<String> linhas;

	public static void main(String[] args) {
		LerArquivoPropEGravar teste = new LerArquivoPropEGravar();
		try {
			teste.lerArquivo();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	public void lerArquivo() throws Exception{
		File file = new File("prop.prop");
		FileReader freader = new FileReader(file);
		BufferedReader buffer = new BufferedReader(freader);
		
		Properties propertie= new Properties();
		String propFileName = "prop-prod.prop";
		InputStream fileProp = getClass().getClassLoader().getResourceAsStream(propFileName);

		if (fileProp != null) {
			propertie.load(fileProp);
		} 
		
		linhas = new ArrayList<String>();
		while (buffer.ready()){
			linhas.add(buffer.readLine());
		}
		
		buffer.close();
		freader.close();
		
		for(Object obj : propertie.keySet()) {
			for (String string : linhas) {
				if (string.contains(obj.toString())) {
					System.out.println("Linha antiga: "+string);
					String comeco = string.substring(0, string.indexOf("="));
					System.out.println("Nova Linha: "+ comeco + "="+propertie.getProperty(obj.toString()));
					//linhas.set(linhas.indexOf(string), comeco + "="+propertie.getProperty(obj.toString()));
					System.out.println();
				}
			}
		}
		System.out.println("Linhas:");
		for (String string : linhas) {
			System.out.println(string);
		}				
	}
	
}

