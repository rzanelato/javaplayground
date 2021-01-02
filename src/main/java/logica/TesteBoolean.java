package logica;

public class TesteBoolean {

	private Boolean verdadero;
	
	public static void main(String[] args) {
		System.out.println(new TesteBoolean().getBooleano());
		boolean teste = new Boolean(null);
		System.out.println(teste);
		
		
		
		//error
		//teste.booleanValue();
		
	}
	
	public Boolean getBooleano(){
		boolean x = new Boolean(verdadero); 
		return x;
	}
}
