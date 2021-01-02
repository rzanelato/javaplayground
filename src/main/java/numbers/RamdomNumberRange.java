package numbers;

import java.util.Optional;
import java.util.Random;

public class RamdomNumberRange {

	public static void main(String[] args) {
		
		
		System.out.println(getRamdonRange());
		

	}
	
	private static Integer getRamdonRange() {
		Integer range = new Random().nextInt(30);
		return Optional.of(range).filter(value -> value >= 20 && value <= 30).orElseGet(() -> getRamdonRange());
	}

}
