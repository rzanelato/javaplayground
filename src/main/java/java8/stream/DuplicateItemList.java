package java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class DuplicateItemList {

	public static void main(String[] args) {
		/*
		List<String> list = new ArrayList<>();
		list.add("123");
		list.add("223");
		list.add("323");
		list.add("1123");
		list.add("321");
		list.add(null);
		list.add(null);
		*/
		List<String> list = new ArrayList<>();
		long countTotal = list.stream().filter(Objects::nonNull).count();
		long count = list.stream().filter(Objects::nonNull).distinct().count();
		if (countTotal > count) {
			System.out.println("Duplicados");
		}
		
		System.out.println("isListaValida: " + validaLista(list.stream().filter(Objects::nonNull).collect(Collectors.toList())));
		
		//list.stream().forEach(System.out::println);
		System.out.println("Object.nonNull: " + Objects.nonNull(null));
		System.out.println("Object.nonNull: " + Objects.nonNull(list));
		System.out.println("Optional.ofNullable: " + Optional.ofNullable(null).isPresent());
		System.out.println("Optional.ofNullable: " + Optional.ofNullable(list).isPresent());

	}
	
	public static boolean comparaListas(List<?> listA, List<?> listB){
		return Optional.of(listA.size() ==  listB.size()).filter(size -> size).isPresent();
	}
	
	public static boolean validaLista(List<String> list){
		return comparaListas(list.stream().distinct().collect(Collectors.toList()), list);
	}

}
