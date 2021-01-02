package string;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;

public class StringListSort {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<>();
		list.add("01");
		list.add("22");
		list.add("12");
		list.add("11");
		list.add("2");
		list.add("1");
		
		//list.sort(Comparator.comparing(Integer::valueOf));
		list.forEach(System.out::println);
		System.out.println();
		System.out.println("(1).compareTo(2) [" + Integer.valueOf(1).compareTo(2) + "]");
		System.out.println("(2).compareTo(2) [ " + Integer.valueOf(2).compareTo(2) + "]");
		System.out.println("(3).compareTo(2) [ " +Integer.valueOf(3).compareTo(2) + "]");
		
		System.out.println();
		list.stream().map(Integer::valueOf).forEach(System.out::println);
	}

}
