package logica;

public class TesteMathJava {
	
	public static void main(String[] args) {
		double paginas = 20;
		double totalResultados = 5;
		
		double totalPaginas = (totalResultados / paginas);
		double teste = totalResultados % 2;
		System.out.println(teste);
		System.out.println(totalPaginas);
		System.out.println(Math.ceil(totalPaginas));
		System.out.println(new Double(Math.ceil(totalPaginas)).intValue());
		
	}
}
