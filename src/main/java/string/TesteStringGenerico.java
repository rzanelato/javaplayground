package string;

public class TesteStringGenerico {

	public static void main(String[] args) {
		//metodoTeste1();
		//metodoTeste2();
		metodoTeste3();
	}
	
	private static void metodoTeste1(){
		String idFatura = "33";
		System.out.println("openPopup(\"aprServicoCobrancaFatura.jsp?_Fatura="+idFatura+"&random="+Math.random()+"\",\"ServicoCobrancaFatura\",800,400);");
	}
	private static void metodoTeste2(){
		String nula = null;
		String preenchida = new String();
		
		if(nula == null)
			System.out.println("Nula = null");
		else
			System.out.println("Nula not null ");
		
		if(preenchida == null)
			System.out.println("preenchida = null");
		else
			System.out.println("preenchida not null");
	}
	
	private static void metodoTeste3(){
		Object obj = new Object();
		obj = "S";
		
		if (((Boolean)obj).booleanValue()) {
			 System.out.println("true");
		} else { 
			System.out.println("false");
		}
		
	}
}
