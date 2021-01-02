package file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class EscreverArquivoAddLinha {

	public static void main(String[] args) {
		File file = new File("/temp/image.txt");
		File csv = new File("/temp/image.csv");
		String[] strs = new String[] {"Linha1 ;\n","Linha2 ;\n","Nome ;\n","Tempo ;\n"};
		
		for (String texto : strs) {
			System.out.println(texto + " - " +file.getAbsolutePath());
			EscreverArquivoAddLinha.writeFile(file, texto);
			try {
				FileUtils.writeStringToFile(csv, texto, "UTF-8", true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	public static void writeFile(File file, String texto){
		try {
			FileWriter escreve = new FileWriter(file, true);
			
			if (file.canWrite()) {
				escreve.write(texto+"\r\n");
			}
			escreve.close();
		} catch (IOException e) {
			e.getStackTrace();
		}
	}

}
