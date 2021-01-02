package java8.stream;

import java.util.ArrayList;
import java.util.List;

public class BooleanList {

	public static void main(String[] args) {
		List<Boolean> hasValue = new ArrayList<>();
		hasValue.add(true);
		hasValue.add(true);
		hasValue.add(true);
		hasValue.add(false);
		hasValue.add(true);
		hasValue.add(true);
		

		
		boolean result = hasValue.stream().filter(value -> !value).findAny().orElse(true);
		System.out.println("Result: " + (!hasValue.isEmpty() && result));
	}

}
