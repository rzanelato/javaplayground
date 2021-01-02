package string;

public class TestStringRegex {

	public static void main(String[] args) {
		
		
		String t1 = "Test1";
		String t2 = "Test1";
		
		System.out.println("RAPIDOS " + (t1 == new String("Test1")));
		
		String iban = "ES12345678901234567890";
		String ibanRuim = "E12345678901234567890";
		String ibanRuim2 = "1234567890123456789012";
		String ibanRuim3 = "ESS1234567890123456789";
		
		System.out.println(check(iban));
		System.out.println(check(ibanRuim));
		System.out.println(check(ibanRuim2));
		System.out.println(check(ibanRuim3));
		System.out.println();
		System.out.println(check2(iban));
		System.out.println(check2(ibanRuim));
		System.out.println(check2(ibanRuim2));
		System.out.println(check2(ibanRuim3));
		System.out.println();
		System.out.println(check3(iban));
		System.out.println(check3(ibanRuim));
		System.out.println(check3(ibanRuim2));
		System.out.println(check3(ibanRuim3));
	}

	private static String check(String iban) {
		if (iban.length() != 22) {
			return "Nao possui 22 digitos";
		}
		StringBuilder builder = new StringBuilder();
		String test = iban.substring(0,2);
		
		if (test.replaceAll("^*[0-9]", "").replaceAll("^*[a-zA-Z]{2}", "XX").length() != 2) {
			return "Codigo invalido";
			
		}
		if (iban.substring(2).replaceAll("^*[a-zA-Z]", "").length() != 20) {
			return "Numero de Iban invalido";
		}
		builder.append(" ");
		builder.append(test.replaceAll("^*[a-zA-Z]{2}", "XX"));
		builder.append("\t");
		builder.append(iban.substring(2).replaceAll("^*[a-zA-Z]", ""));
		
		return builder.toString();
	}
	
	private static String check2(String iban) {
		if (iban.length() != 22
			|| (iban.substring(0,2).replaceAll("^*[0-9]", "").replaceAll("^*[a-zA-Z]{2}", "XX").length() != 2)
			|| (iban.substring(2).replaceAll("^*[a-zA-Z]", "").length() != 20)) {
			return "Iban Invalido";
		}
		StringBuilder builder = new StringBuilder();
		String test = iban.substring(0,2);
		builder.append(" ");
		builder.append(test.replaceAll("^*[a-zA-Z]{2}", "XX"));
		builder.append("\t");
		builder.append(iban.substring(2).replaceAll("^*[a-zA-Z]", ""));
		
		return builder.toString();
	}
	
	private static boolean check3(String iban) {
		return !(iban.length() != 22 || (iban.substring(0,2).replaceAll("^*[0-9]", "").replaceAll("^*[a-zA-Z]{2}", "XX").length() != 2)
				|| (iban.substring(2).replaceAll("^*[a-zA-Z]", "").length() != 20));
	}
	
	

}
