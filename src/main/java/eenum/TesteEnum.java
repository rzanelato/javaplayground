package eenum;

public class TesteEnum {
	public static void main(String[] args) {
		for (VideosEnum en : VideosEnum.values()) {
			
			System.out.println("Teste: "+en.value());
		}
		
		System.out.println();
		for (LegendasEnum en : LegendasEnum.values()) {
			
			System.out.println("Teste: "+en.value());
		}
		
		
	}
		
	
}
