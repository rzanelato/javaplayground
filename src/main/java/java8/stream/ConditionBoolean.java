package java8.stream;

import java.util.stream.Stream;

public class ConditionBoolean {

	public static void main(String[] args) {
		String status1 = "NA";
		String status2 = "A";

		
		
		System.out.println(Stream.of(status1).allMatch("NA"::equalsIgnoreCase));
		System.out.println(Stream.of(status2).allMatch("NA"::equalsIgnoreCase));
	}

}
