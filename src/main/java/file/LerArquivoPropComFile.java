package file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class LerArquivoPropComFile {

	private static List<String> linhas;

	public static void main(String[] args) {
		LerArquivoPropComFile teste = new LerArquivoPropComFile();
		try {
			teste.lerPropertie("carteleriar3.svc");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	public void lerPropertie(String propName) throws Exception{
		File file = new File("src/main/resources/configDaemon.properties");
		FileReader freader = new FileReader(file);
		BufferedReader buffer = new BufferedReader(freader);
		
		linhas = new ArrayList<String>();
		while (buffer.ready()){
			linhas.add(buffer.readLine());
		}
		
		freader.close();
		buffer.close();
		
		for (String string : linhas) {
			if (string.contains(propName)) {
				System.out.println("Linha: "+string);
				String valor = string.substring(string.indexOf("=")+1).trim();
				System.out.println("Valor: |"+ valor+"|");
				System.out.println();
			}
		}
	}
}

