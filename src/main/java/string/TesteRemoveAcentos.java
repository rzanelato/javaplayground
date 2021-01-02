package string;

public class TesteRemoveAcentos {

	public static void main(String[] args) {
		System.out.println(trataApostrofo("D'OESTE"));

	}


	public static  String removerAcentos (final String s) {
		String acentuado = "Ã§Ã‡Ã¡Ã©Ã­Ã³ÃºÃ½Ã�Ã‰Ã�Ã“ÃšÃ�Ã Ã¨Ã¬Ã²Ã¹Ã€ÃˆÃŒÃ’Ã™Ã£ÃµÃ±Ã¤Ã«Ã¯Ã¶Ã¼Ã¿Ã„Ã‹Ã�Ã–ÃœÃƒÃ•Ã‘Ã¢ÃªÃ®Ã´Ã»Ã‚ÃŠÃŽÃ”Ã›";  
		String semAcento = "cCaeiouyAEIOUYaeiouAEIOUaonaeiouyAEIOUAONaeiouAEIOU";  
		char[] tabela;  

		tabela = new char[256];  
		for (int i = 0; i < tabela.length; ++i) {  
			tabela [i] = (char) i;  
		}  
		for (int i = 0; i < acentuado.length(); ++i) {  
			tabela [acentuado.charAt(i)] = semAcento.charAt(i);  
		}  

		StringBuffer sb = new StringBuffer();  
		for (int i = 0; i < s.length(); ++i) {  
			char ch = s.charAt (i);  
			if (ch < 256) {   
				sb.append (tabela [ch]);  
			} else {  
				sb.append (ch);  
			}  
		}  
		return sb.toString();  
	}

	private static String trataApostrofo( String s ){
		int posApost;
		if ( (posApost = s.indexOf("'")) > 0 ){
			s = s.substring(0,posApost) + "'" + s.substring(posApost);
		}

		return s;
	}
}
