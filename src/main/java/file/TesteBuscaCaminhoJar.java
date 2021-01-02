package file;

import java.io.File;
import java.io.IOException;
import java.util.StringTokenizer;


public class TesteBuscaCaminhoJar {

	public static void main(String[] args) {
		buscaCaminhoArquivo();
		//System.out.println(buscaCaminhoArquivo());
		File file = new File("Users/rzanelato/Desktop/TesteFile.txt");
		System.out.println(file.getName());
		System.out.println(file.exists());
		try {
			file.createNewFile();
			System.out.println("foi");
		} catch (IOException e) {
			System.out.println("fedeu");
		}
	}
	
	private static String buscaCaminhoArquivo(){
		String path = TesteBuscaCaminhoJar.class.getResource("TesteBuscaCaminhoJar.class").toString();
		path = path.replace("TesteBuscaCaminhoJar.class", "");
		
		
		//String caminho = path;
		//caminho = novoBuscaCaminho(caminho); 
		
		String caminho = "";
		String aux;
		StringTokenizer st = null;
		Boolean flag = true;
		st = new StringTokenizer(path, "/");
		while (st.hasMoreTokens()){
			aux = st.nextToken();
			if(!aux.equals("jar:file:")){
				if(!"!".equals(aux.substring(aux.length()-1)) && flag){
					caminho += aux.toString()+File.separatorChar;
				}else{
					flag = false;
				}
			}
		}
		caminho = caminho.replaceAll("%20", " ");
		System.out.println("caminho: "+caminho);
		
		
		return caminho;
	}

	private static String novoBuscaCaminho(String caminho) {
		String novoCaminho = "";
		
		String aux[] = caminho.split("/");
		
		
		
		return novoCaminho;
	}
}
