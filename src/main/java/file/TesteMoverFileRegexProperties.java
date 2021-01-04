package file;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class TesteMoverFileRegexProperties {
		
	public static void main(String[] args) throws Exception {
		
		nome = "123456789012345";
		runGrava();
		
		//runLe();
		//removerProperties(nome);
		
		
	}

	static String retornoRegex = "";
	static String nome = "";

	public static void runLe() throws Exception {
		
		buscaCaminhoProperties(nome);
		
		
		
	}
	
	public static void runGrava() throws Exception {
		
		String caminho = "D:\\Meus documentos\\_teste";
		String novoCaminho = "D:\\Meus documentos\\_teste\\pasta";
		String extensoes = "avi";
		
		gravaPropertiesNovo(nome,caminho,novoCaminho,extensoes);
		
		//gravaPropertiesNovo(nome,"teste video 8","Teste de caminho novo video 8",extensoes);
		
	}
	
	private static void buscaCaminhoProperties(String nomeConfig) throws Exception{
		try {
			File file = new File("D:\\Meus documentos\\_teste\\teste3.lkn");
			
			//retornoRegex = usaRegex(file);
			
			String origem = "";
			String destino = "";
			String extensao = "";
			Properties properties = new Properties();
			
			FileInputStream fis = new FileInputStream(file);
			
			properties.load(fis);
			
			Enumeration<?> testeEnum = properties.propertyNames();
			List<String> listNome = new ArrayList<String>();
			while(testeEnum.hasMoreElements()){
				String aux = testeEnum.nextElement().toString();
				aux = aux.substring(0, aux.indexOf("."));
				if(!listNome.contains(aux)){
					listNome.add(aux);
				}
				
			}
			for(String sss:listNome)
				System.out.println(sss);
				
			nomeConfig = nomeConfig.toLowerCase();
			origem = properties.getProperty(nomeConfig+".origem");
			destino = properties.getProperty(nomeConfig+".destino");
			extensao = properties.getProperty(nomeConfig+".extensao");
			
			
			
			fis.close();
			retornoRegex = String.valueOf(properties.size());
			
//			String[] teste = extensao.split(",");
			//String[] teste2 = retornoRegex.split(",");
			
			System.out.println("Total: "+retornoRegex);
			System.out.println("Total/3: "+Integer.parseInt(retornoRegex)/3);
			System.out.println("TotalList: "+listNome.size());
			//for(String y:teste2)
				//System.out.println("Config: "+y);
			System.out.println("Origem: "+origem);
			System.out.println("Destino: "+destino);
			System.out.println("Extensao: "+extensao.trim());
			
		
		} catch (FileNotFoundException e) {
			System.out.println("Erro FileNotFound");
		} catch (IOException e) {
			System.out.println("Erro IO");
		}
		
	}
	
	private static void removerProperties(String nomeConfig) throws Exception{
		try {
			
			File filer = new File("D:\\Meus documentos\\_teste\\teste3.lkn");
			Properties prop = new Properties();
			FileInputStream fis = new FileInputStream(filer);
			
			prop.load(fis);
			
			
			prop.remove(nomeConfig+".origem");
			prop.remove(nomeConfig+".destino");
			prop.remove(nomeConfig+".extensao");
			
			prop.store(new FileOutputStream(filer),"Properties");
			
			
		} catch (FileNotFoundException e) {
			System.out.println("Erro FileNotFound");
		} catch (IOException e) {
			System.out.println("Erro IO");
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
			
			Pattern pattern = Pattern.compile("#[0-9a-zA-Z]+#");
			Matcher m = pattern.matcher(teste);
			
			while (m.find()) {
				retorno += teste.substring(m.start(), m.end())+",";
				
			}
		} catch (FileNotFoundException e) {
			System.out.println("Erro: File Not Found");
		} catch (IOException io){
			System.out.println("Erro: IO");
		}
		return retorno;
	}
	
	private static boolean isNaoExisteVirgulaRegex(String extensoes){
		String retorno = "";
		
		extensoes = extensoes.toLowerCase();
			
		Pattern pattern = Pattern.compile("[0-9a-z]+");
		//Pattern pattern = Pattern.compile(",");
		
		Matcher m = pattern.matcher(extensoes);
				
		while (m.find()) {
			String xx;
			if(!(xx = extensoes.substring(m.start(), m.end())).equals(""))
				retorno += extensoes.substring(m.start(), m.end())+",";
		}
		
		System.out.println(retorno);
		if(retorno.length() == 0){
			return true;
		}
		return false;
	}
	
	private static String ajustaExtensoes(String extensoes){
		String retorno = "";
		
		extensoes = extensoes.toLowerCase();
			
		Pattern pattern = Pattern.compile("[0-9a-z]+");
		
		Matcher m = pattern.matcher(extensoes);
				
		while (m.find()) {
			String xx;
			if(!(xx = extensoes.substring(m.start(), m.end())).equals(""))
				retorno += xx+",";
		}
		retorno = retorno.substring(0,retorno.length()-1);
		System.out.println(retorno);
		
		return retorno;
	}
	
	private static void gravaPropertiesNovo(String nomeConfig, String origem, String destino, String extensao) throws Exception{
		String caminhoProperties = "D:\\Meus documentos\\_teste\\teste3.lkn";
		
		File filen = new File(caminhoProperties);
		
		try {
			Properties prop = new Properties();
			FileInputStream fis = new FileInputStream(filen);
			
			prop.load(fis);
			nomeConfig = nomeConfig.toLowerCase();
			
			prop.setProperty(nomeConfig+".origem", origem);
			prop.setProperty(nomeConfig+".destino", destino);
			prop.setProperty(nomeConfig+".extensao", ajustaExtensoes(extensao));
			
			prop.store(new FileOutputStream(filen), "Properties");
			
			
		} catch (FileNotFoundException e) {
			System.out.println("Erro FileNotFound");
		} catch (IOException e) {
			System.out.println("Erro IO");
		}
		
		
		
	}
	
	private static void gravaProperties(String nomeConfig, String origem, String destino, String extensao){
		String caminhoProperties = "D:\\Meus documentos\\_teste\\teste3.lkn";
		
		File filen = new File(caminhoProperties);
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("#"+nomeConfig+"#\n");
		buffer.append(nomeConfig+".origem= "+origem.replaceAll("\\\\","/")+"\n");
		buffer.append(nomeConfig+".destino= "+destino.replaceAll("\\\\","/")+"\n");
		buffer.append(nomeConfig+".extensao= "+extensao.toLowerCase()+"\n");
		
		FileWriter escreve;
		
		try {
			escreve = new FileWriter(filen, true);
			if (filen.canWrite()) {
				escreve.write(buffer.toString());
			} else {
				JOptionPane.showMessageDialog(null, "Nao foi possivel gravar no arquivo: ", "Erro!", JOptionPane.ERROR_MESSAGE);
			}
			
			escreve.close();
		} catch (IOException e) {
			System.out.println("Errrooo IO");
		}
	}
	

}
