package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class TesteTrocaCodificacaoArquivo {
	
	
	public static void main(String[] args) throws IOException {
		OutputStreamWriter testeEscreve = new OutputStreamWriter(new FileOutputStream("D:\\Meus documentos\\_teste\\testeLog.log"),"unicode");
		
		
		StringBuffer string = new StringBuffer();
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\Meus documentos\\_teste\\testeLog.log"),"unicode"));
		
		bw.append("teste1");
		bw.newLine();
		bw.append("Eu estou fazendo um teste\r\n");
		bw.newLine();
		bw.append("Eu estou fazendo um teste\r\n");
		bw.append("Eu estou fazendo um teste\r\n");
		bw.append("Eu estou fazendo um teste\r\n");
		
		bw.close();
		
//		System.out.println(bw.getEncoding());
		
		
		
		
		
	}

	private static void teste() throws UnsupportedEncodingException,
			FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader (new FileInputStream("entrada.xml"), "ISO-8859-1"));  
		BufferedWriter bw = new BufferedWriter (new OutputStreamWriter (new FileOutputStream("saida.xml"), "UTF-8"));  
		for (String linha = br.readLine(); linha != null; linha = br.readLine()) {  
			bw.write (linha); bw.newLine();  
		}  
		bw.close();  
		br.close();
	}

}
