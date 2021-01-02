package logica;

import java.util.ArrayList;
import java.util.List;

public class TestNumber {
	
	public static void main(String[] args) {
		//testeNumber();
		
		int i = 20<<2;
		
		System.out.println("i: "+i);
		//testeLogicaMaxNum();
	}
	
	private static void testeLogicaMaxNum() {
		List<Integer> listInt = new ArrayList<Integer>();
		listInt.add(new Integer(4));
		listInt.add(new Integer(9));
		listInt.add(new Integer(1));
		listInt.add(new Integer(8));
		listInt.add(new Integer(5));
		listInt.add(new Integer(3));
		
		int max = 0;
		
		for (Integer integer : listInt) {
			if(integer.intValue() > max) {
				max = integer.intValue();
			}
		}
		System.out.println("Max: "+max);
		
		
	}
	

	private static void testeNumber() {
		Number num1 = 100;
		Number num2 = 100;
		
		System.out.println("== "+ (num1 == num2));
		System.out.println("equals "+ (num1.equals(num2)));
		System.out.println();
		
		Long num3 = 100L;

		System.out.println("== "+ (num1 == num3));
		System.out.println("equals "+ (num1.equals(num3)));
	}
	
	

}
