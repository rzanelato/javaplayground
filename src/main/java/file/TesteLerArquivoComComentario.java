package file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class TesteLerArquivoComComentario {

	private static List<String> linhas;

	public static void main(String[] args) {
		try {
			lerArquivo();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	private static void lerArquivo() throws Exception{
		File file = new File("resources/prop.prop");
		
		FileReader freader = new FileReader(file);
		
		BufferedReader buffer = new BufferedReader(freader);
		
		String configBase = "jndi.caminho da base...!!!";
		String user = "Teste.Usuario";
		String senha = "Senha Teste";
		
		//StringBuffer stringBuffer = new StringBuffer();
		
		linhas = new ArrayList<String>();
		
		while (buffer.ready()){
			linhas.add(buffer.readLine());
		}
		
		buffer.close();
		freader.close();
		
		boolean flag = false;
		boolean flagComentario = false;
		List<Integer> linhaConnectionInicio = new ArrayList<Integer>();
		List<Integer> linhaUserInicio = new ArrayList<Integer>();
		List<Integer> linhaPasswordInicio = new ArrayList<Integer>();
		List<Integer> linhaConnectionFim = new ArrayList<Integer>();
		List<Integer> linhaUserFim = new ArrayList<Integer>();
		List<Integer> linhaPasswordFim = new ArrayList<Integer>();
		
		int count = 0;
		for (String string : linhas) {
			if (string.contains("<!--") && string.contains("-->")){
				count++;
				continue;
			}

			if (string.contains("<!--")) {
				flagComentario = true;
				count++;
				continue;
			}
			
			if (string.contains("-->") && flagComentario){
				flagComentario = false;
				count++;
				continue;
			}

			if (flagComentario) {
				count++;
				continue;
			}

			if (string.contains("<connection-url>") && string.contains("</connection-url>")){
				linhas.set(count, "	<connection-url>" + configBase + "</connection-url>");
			} else {
				if (string.contains("<connection-url>")) {
					flag = true;
					System.out.println("Linha "+count+": "+string);
					linhaConnectionInicio.add(count);
					count++;
					continue;
				}
				if (string.contains("</connection-url>") && flag) {
					System.out.println("Linha "+count+": "+string);
					linhaConnectionFim.add(count);
					flag = false;
					count++;
					continue;
				}
			}
			if (string.contains("<user-name>") && string.contains("</user-name>")){
				linhas.set(count, "	<user-name>" + user + "</user-name>");
			} else {
				if (string.contains("<user-name>")) {
					flag = true;
					linhaUserInicio.add(count);
					count++;
					continue;
				}
				if (string.contains("</user-name>") && flag) {
					linhaUserFim.add(count);
					flag = false;
					count++;
					continue;
				}
			}
			
			if (string.contains("<password>") && string.contains("</password>")){
				linhas.set(count, "	<password>" + user + "</password>");
			} else {
				if (string.contains("<password>")) {
					flag = true;
					linhaPasswordInicio.add(count);
					count++;
					continue;
				}
				if (string.contains("</password>") && flag) {
					linhaPasswordFim.add(count);
					flag = false;
					count++;
					continue;
				}
			}
			
			count++;
		}

		alteraLinhas("	<password>" + senha + "</password>", linhaPasswordInicio, linhaPasswordFim);
		alteraLinhas("	<user-name>" + user + "</user-name>", linhaUserInicio, linhaUserFim);
		alteraLinhas("	<connection-url>" + configBase + "</connection-url>", linhaConnectionInicio, linhaConnectionFim);
		
		int teste = 0;
		for (String string : linhas) {
			System.out.println("Linha "+teste+": "+string);
			teste++;
		}
				
		//System.out.println(stringBuffer.toString());
	
	}

	private static void alteraLinhas(String config, List<Integer> inicio, List<Integer> fim) {
		for (int index = inicio.size()-1; index >= 0 ; index--) {
			for(int i = fim.get(index); i >= inicio.get(index); i--){
				if(i != fim.get(index))
					linhas.remove(i);
				else
					linhas.set(i,config);
				
			}
		}
	}
	
}

