package file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

public class TesteBuscaArquivoDentroDoJar {

	public static void main(String[] args) {
		String path = TesteBuscaArquivoDentroDoJar.class.getResource("teste.txt").toString();
		path = path.replace("teste.txt", "");
		JOptionPane.showMessageDialog(null, path);
		String caminho = "";
		String aux;
		StringTokenizer st = null;
		Boolean flag = true;
		st = new StringTokenizer(path, "/");
		while (st.hasMoreTokens()){
			aux = st.nextToken();
			if(!aux.equals("jar:file:")){
				if(!"!".equals(aux.substring(aux.length()-1)) && flag){
					caminho += aux.toString()+"\\";
				}else{
					flag = false;
				}
			}
		}
		caminho = caminho.replaceAll("%20", " ");
		
		System.out.println(caminho);
		JOptionPane.showMessageDialog(null, caminho);
		
		File file = new File(caminho+"\\teste.txt");
		
		JOptionPane.showMessageDialog(null, file.getAbsolutePath());
		
		file.renameTo(new File("C:\\Documents and Settings\\renato.zanelato\\Desktop\\teste.txt"));
		
		try {
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			
			String x = buffer.readLine();
			
			JOptionPane.showMessageDialog(null,x);	
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null,"FileNotFound");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,"IOException");
		}
		
	}
	
}
