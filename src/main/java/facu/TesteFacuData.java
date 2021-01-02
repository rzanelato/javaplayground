package facu;

public class TesteFacuData {

	public static void main(String[] args) {
		try {
			ValidaData valida = new ValidaData("segunda","abril");
			valida.executar();
			System.out.println(valida.toString());
			
			valida = new ValidaData("terça","abril");
			valida.executar();
			System.out.println(valida.toString());
			
			valida = new ValidaData("quarta","abril");
			valida.executar();
			System.out.println(valida.toString());
			
			valida = new ValidaData("quinta","abril");
			valida.executar();
			System.out.println(valida.toString());
			
			valida = new ValidaData("sexta","abril");
			valida.executar();
			System.out.println(valida.toString());
			
			valida = new ValidaData("sabado","abril");
			valida.executar();
			System.out.println(valida.toString());
			
			valida = new ValidaData("domingo","abril");
			valida.executar();
			System.out.println(valida.toString());
		} catch (Exception e) {
			System.out.println("Erro: "+e.getMessage());
		}

	}

}
