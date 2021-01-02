package string;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class TesteRegex {
		
	public static void main(String[] args) {
		quartoTeste();
		
		
	}

	private static void quartoTeste() {
		try {
			 
			File[] lista = new File("D:\\Meus documentos\\_teste").listFiles();
			StringBuffer arquivos = new StringBuffer();
			for(File file:lista) {
				if(file.isDirectory()){
					arquivos.append("PASTA: "+file.getName()+"\n");
					File[] lista2 = new File(file.getPath()).listFiles();
					for(File filex:lista2) {
						if(filex.getName().endsWith(".txt")){
							arquivos.append(usaRegex(filex)+"\n");
						}
					}
					arquivos.append("FIM: "+file.getName()+"\n");
				}
				if(file.getName().endsWith(".txt")){
					arquivos.append(usaRegex(file));
				}
			}
			File filen = new File("D:\\Meus documentos\\_teste\\teste2.txt");
			FileWriter escreve = new FileWriter(filen, true);
            if (filen.canWrite()) {
            		escreve.write(arquivos.toString());
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possivel gravar no arquivo: ", "Erro!", JOptionPane.ERROR_MESSAGE);
            }
            
            escreve.close();
		
		
		} catch (FileNotFoundException e) {
			System.out.println("Erro: File Not Found");
		} catch (IOException io){
			System.out.println("Erro: IO");
		}
	}
	
	private static String usaRegex(File file){
		String retorno = "";
		try {
			String teste = "";
			BufferedReader reader = new BufferedReader(new FileReader(file));
			
			String aux;
			while ((aux = reader.readLine()) != null) {
				teste += aux+"\n";
				
			}
			reader.close();
			
			Pattern pattern = Pattern.compile("[0-9a-zA-Z\\.\\w]+@[0-9a-zA-Z]+[\\.0-9a-zA-Z]*");
			Matcher m = pattern.matcher(teste);
			
			while (m.find()) {
				retorno += teste.substring(m.start(), m.end())+"\n";
				
			}
		} catch (FileNotFoundException e) {
			System.out.println("Erro: File Not Found");
		} catch (IOException io){
			System.out.println("Erro: IO");
		}
		return retorno;
	}

	private static void terceiroTeste() {
		try {
			 
			File[] lista = new File("D:\\Meus documentos\\_teste").listFiles();
			StringBuffer arquivos = new StringBuffer();
			for(File file:lista) {
				if(file.isDirectory()){
					arquivos.append("PASTA: "+file.getName()+"\n");
					File[] lista2 = new File(file.getPath()).listFiles();
					for(File filex:lista2) {
						if(filex.getName().endsWith(".mp3")){
							arquivos.append(filex.getName()+"\n");
						}
					}
					arquivos.append("FIM: "+file.getName()+"\n");
				}
				if(file.getName().endsWith(".mp3")){
					arquivos.append(file.getName()+"\n");
				}
			}
			File filen = new File("D:\\Meus documentos\\_teste\\teste2.txt");
			FileWriter escreve = new FileWriter(filen, true);
            if (filen.canWrite()) {
            		escreve.write(arquivos.toString());
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possivel gravar no arquivo: ", "Erro!", JOptionPane.ERROR_MESSAGE);
            }
            
            escreve.close();
		
		
		} catch (FileNotFoundException e) {
			System.out.println("Erro: File Not Found");
		} catch (IOException io){
			System.out.println("Erro: IO");
		}
	}

	private static void segundoTeste() throws FileNotFoundException, IOException {
		
		String teste = "";
		File files = new File("D:\\Meus documentos\\_teste");
		
		BufferedReader reader = new BufferedReader(new FileReader(files));
		
		String aux;
		while ((aux = reader.readLine()) != null) {
			teste += aux+"\n";
			
		}
		reader.close();
		
		Pattern pattern = Pattern.compile("[0-9a-zA-Z\\.\\w]+@[0-9a-zA-Z]+[\\.0-9a-zA-Z]*");
		//String teste = "Eu tenho um renato.zanelato@metodista.br email que tiazinha@gmail.com.mae.pai.tia.primo. renato@zanelato.zzn.com.xx.pp é renatozanelato@yahoo.com.mt e gostaria que o java lesse ele rz84@bol.com.br enten linkin_foda@hotmail.com densse";
		Matcher m = pattern.matcher(teste);
		
		while (m.find()) {
			System.out.println(teste.substring(m.start(), m.end()));
			
		}
	}

	private static void primeiroTeste() {
		//Pattern pattern = Pattern.compile("[0-3\\s][0-9] de [a-zA-Z]+");
		Pattern pattern = Pattern.compile("[0-9a-zA-Z\\.\\w]+@[0-9a-zA-Z]+[\\.0-9a-zA-Z]*");
		//Pattern pattern = Pattern.compile(".+@.+\\.[a-z]+");
		//Pattern pattern = Pattern.compile("^\\S+@^\\S+");
		
		
		//String teste = "eu gostaria de ver o filme homem aranha, fahrenheit 11 de setembro em 42 de Janeiro111 de 2010 as 1_ e 30 em 2 de cumbica";
		
		String teste = "Eu tenho um renato.zanelato@metodista.br email que tiazinha@gmail.com.mae.pai.tia.primo. renato@zanelato.zzn.com.xx.pp é renatozanelato@yahoo.com.mt e gostaria que o java lesse ele rz84@bol.com.br enten linkin_foda@hotmail.com densse";
		
		//Matcher m = p.matcher(teste);
		Matcher m = pattern.matcher(teste);
		
		while (m.find()) {
			System.out.println(teste.substring(m.start(), m.end()));
			
		}
	}

}
