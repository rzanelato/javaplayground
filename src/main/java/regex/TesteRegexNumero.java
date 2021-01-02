package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TesteRegexNumero {
	
	public static void main(String[] args) {
		String texto = "12s3scc4s567";
		
		
		Pattern pat = Pattern.compile("(\\d+)");
		Matcher mat = pat.matcher(texto);

		String result = "";
		while(mat.find()) {
			result += mat.group();
		}
		
		System.out.println(result);
		
	}

}
