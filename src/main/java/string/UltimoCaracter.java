package string;

public class UltimoCaracter {

	public static void main(String[] args) {
		String string = "Metodo.metodo()";
		System.out.println(string);
		string = string.concat(";");
		System.out.println(string);
		
		StringBuilder builder = new StringBuilder();
		builder.append("Classe.metodo()");
		builder.insert(builder.length(), ";");
		
		System.out.println(builder.toString());

	}

}
