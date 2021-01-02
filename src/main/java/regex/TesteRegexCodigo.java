package regex;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TesteRegexCodigo {

	public static void main(String[] args) {
		System.out.println(teste1());
	}
	
	private static String teste1() {
		String error = "BPR00123";
		String application = "MIF";
		

		Pattern pat = Pattern.compile("^[A-Z][3].*");

		//Si es 0, null, o "GBP00000" setearemos codError 0
		if (error != null && !error.equals("0") && !error.equals("GBP00000")) {
			
			Matcher mat = pat.matcher(error);
			String string = error;
			string.matches(pat.pattern());
			System.out.println("String: "+string);
		     
			//Si coincide con el patrón formatearemos el código son la aplicación para que tenga 5 dígitos y le añadiremos la aplicación
			if (mat.matches()){
				System.out.println("Matcher: "+mat.replaceFirst(pat.toString()));
				String originalError = error.substring(0,3);
				error = error.substring(3,error.length());
				error=String.format("%05d", Integer.parseInt(error));				
				error=originalError+error;
				
			//SI no coincide con el patrón, miraremos si empieza por números
			}else {				
				
				Pattern patNum = Pattern.compile("^[0-9]+.*");
				Matcher matNum = patNum.matcher(error);
				
				//SI empieza por números, formatearemos el código son la aplicación para que tenga 5 dígitos y le añadiremos la aplicación
				if (matNum.matches()) {					
					
					if (Arrays.asList(new String[]{"00000","00002","00123"}).contains(error)) {
						
						error=String.format("%05d", Integer.parseInt(error));
						
						error="GBP"+error;
						
					}else {
					
						error=String.format("%05d", Integer.parseInt(error));
						
						error=application+error;
					}
				}			
			}
			
		}else {
			
			error = "0";
		}
		
		return error;
	
	}
}
