package string;

public class TesteFormatarCep {

	public static void main(String[] args) {
		System.out.println(formatarCep("9540840"));
		
		
	}
	
	private static String formatarCep(final String cep){
		String cepAux = cep.substring(0, cep.length()-3);
		String digito = cep.substring(cep.length()-3, cep.length());
		
		while(cepAux.length() < 5)
			cepAux = "0"+cepAux;
	
		return cepAux+"-"+digito;
	}
	
}
