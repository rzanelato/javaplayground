package logica;

public class TesteLinhasDinamicas {

	public static void main(String[] args) {
		String[] linhas = new String[10];
		
		int count = 0;
		
		linhas[count++] = "Renato";
		linhas[++count] = "Zanelato";
		linhas[++count] = "Zanela";
		linhas[++count] = "Palmito";
		linhas[++count] = "Zana";
		
		int i = 0;
		for (String str: linhas) {
			System.out.println("Obj["+i+"]: "+str);
			i++;
		}

	}

}
