package string;

public class TesteSplitString {
	
	public static void main(String[] args) {
		String string = "Fechamento Final - (01/10/2010 a 31/12/2010)";
		String[] split = string.split(" - ");
		
		for(String str: split){
			System.out.println(str);
		}
		
		String string1 = "Fora de Prazo - (01/10/2010 a 31/12/2010)";
		String[] split1 = string1.split(" - ");
		
		for(String str: split1){
			System.out.println(str);
		}
		
		String string2 = "Fechada";
		String[] split2 = string2.split(" - ");
		
		for(String str: split2){
			System.out.println(str);
		}
		
		if(split2.length >1){
			
		}
	}
	
	private void teste1(){
		String string = "Essa frase é pra ser lida assim!!__";
		
		String[] teste = string.split("");
		
		int index = 0;
		for(String str: teste){
			
			if(index != 0)
				if(str.equals("!"))
					System.out.println("interrogacao");
				else
					
				System.out.println(str);
			index++;
		}
	}

}
