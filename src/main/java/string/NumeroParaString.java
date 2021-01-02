package string;

import java.util.Optional;

public class NumeroParaString {

	public static void main(String[] args) {
		double num = 682.0;
		
		String retorno = String.valueOf((int) num);
		
		System.out.println("numero: " + retorno);
		
		double importInt = 1; 
		
		boolean important = Optional.ofNullable(importInt).filter(value -> value == 1).map(values -> Boolean.TRUE).orElse(false);
		
		System.out.println("important: " + important);

	}

}
