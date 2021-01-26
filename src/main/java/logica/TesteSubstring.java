package logica;

public class TesteSubstring {

	public static void main(String[] args) {
		//testeSubstring();
		pegarUltimoDigito();
	}
	
	private static void testeSubstring() {
		String sub = "2,16";
		String strNova = sub.substring(sub.indexOf(",")+1);
		System.out.println(strNova);
		
	}
	
	private static void pegarUltimoDigito() {
		String[] list = new String[] {"156095","156099","156183","156534"};
		
		
		for (String str : list) {
			String digito = str.substring(str.length()-2);
			System.out.println("Info: "+ str + " - ["+digito+"]" );
			
		}
		
	}
	
}
