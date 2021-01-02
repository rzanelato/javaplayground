package file;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JOptionPane;


public class TesteFileProperties {
	
	public static void main(String[] args) {
		
		try {

			File file = new File(
					"I:\\Atendimento\\SPP\\CHAMADOS_USUARIOS\\RENATO\\Testes\\DB.properties");

			String caminhoBase = "";
			Properties properties = new Properties();

			FileInputStream fis = new FileInputStream(file);

			properties.load(fis);
			//properties.setProperty("fase"+fase+".jogo"+jogo+".time","franca,mexico");
			properties.setProperty("fase1.jogo1.resultado","0,2");
			
			String string = "";
			
			
			
			
			fis.close();

			System.out.println(caminhoBase);

		} catch (IOException ioe) {
			JOptionPane.showMessageDialog(null,
					"Erro ao abrir o arquivo properties.");
		} catch (Exception e) {
			e.printStackTrace();
		}
			
						
			
			
		
		
	}
	
	
	private static void testePropertie(){
		try {

			File file = new File(
					"I:\\Atendimento\\SPP\\CHAMADOS_USUARIOS\\RENATO\\Testes\\DB.properties");

			String caminhoBase = "";
			Properties properties = new Properties();

			FileInputStream fis = new FileInputStream(file);

			properties.load(fis);
			caminhoBase = properties.getProperty("caminho.base");
			fis.close();

			System.out.println(caminhoBase);

		} catch (IOException ioe) {
			JOptionPane.showMessageDialog(null,
					"Erro ao abrir o arquivo properties.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
