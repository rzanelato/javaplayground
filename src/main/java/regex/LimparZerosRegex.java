package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LimparZerosRegex {
	
	public static void main(String[] args) {
		String str = "00000";
		
		String novo = str.replaceFirst("0*", "");
		
		
		System.out.println(novo);
		//System.out.println("2220002020");
		
		System.out.println("É valido? => "+esTextoValido(str));
		
	}
	
	private static boolean esTextoValido(String texto) {
		Pattern pat = Pattern.compile("(\\d+)");
		Matcher mat = pat.matcher(texto);

		String result = "";
		while(mat.find()) {
			result += mat.group();
		}
		result = result.replaceFirst("0*", "");
		System.out.println("size: "+result.length());
		
		if (result.length() <= 0 || result.length() > 8) {
			return false;
		}
		
		return true;
	}

}
