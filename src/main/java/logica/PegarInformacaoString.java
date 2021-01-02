package logica;

import javax.swing.JOptionPane;

import utils.EasyCopier;

public class PegarInformacaoString {
	
	public static void main(String[] args) {
		String texto = "";
		
		while(texto != null) {
			texto = JOptionPane.showInputDialog("Texto");
			
			if (texto != null) {
				if ("".equals(texto)) {
					texto = EasyCopier.getCopy();
					System.out.println(texto);
				}
				if ("".equals(texto)) {
					System.out.println("Nao pegou texto bem!");
					
				} else {
					String novo = texto.trim().replace("\r", "").replaceAll("\n", "");
					String principal = novo.substring(novo.indexOf("SVH-"), novo.indexOf("SVH-")+10);
					novo = novo.substring(novo.indexOf("SVH-")+10);
					String secundario = novo.substring(novo.indexOf("SVH-"), novo.indexOf("SVH-")+10);
					novo = novo.substring(novo.indexOf("SVH-")+10);
					
					String linhaPasta = secundario + " - " + novo + " - " + principal;
					String linhaExcel = secundario + "\t" + novo + " - " + principal;
					
					System.out.println();
					System.out.println(linhaExcel);
					System.out.println(linhaPasta);
					
					EasyCopier.copy(linhaExcel+"\n\n"+linhaPasta);
				}
			}
		}
	}
}