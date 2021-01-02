package java8.optional;

import java.util.Objects;
import java.util.Optional;

import pojo.User;

public class OptionalTest {

	public static void main(String[] args) {
		User user = new User();
		user.setFirstname("Renato");
		user.setLastname("Zanelato");
		//user.setAddress("Rua de merda");
		//user.setAge(35);
		user.setActive(true);
		/*
		System.out.println(Optional.ofNullable(user.getFirstname()).orElse(null));
		System.out.println(Optional.ofNullable(user.getLastname()).orElse(null));
		//System.out.println(Optional.ofNullable(user.getLastname()).orElseThrow(() -> new NullPointerException("Deu Merda")));
		System.out.println(Optional.ofNullable(user.getAge()).orElseThrow(() -> new NullPointerException("Deu Merda")));
		System.out.println(Optional.ofNullable(user.isActive()).orElse(false));
		System.out.println(Optional.ofNullable(user.isActive()).get());
		
		System.out.println();
		System.out.println(Optional.ofNullable(true).get());
		System.out.println(Optional.ofNullable(false).get());
		System.out.println();
		System.out.println(Optional.ofNullable(user.getFirstname()).filter(OptionalTest::isValid).orElse(""));
		System.out.println(Optional.ofNullable(user.getLastname()).map(OptionalTest::isValid).isPresent());
		*/
		
		Optional.ofNullable(user.getFirstname()).map(OptionalTest::isValid).ifPresent(teste -> {
			if (!Boolean.TRUE.equals(teste)) {
				new Exception("Deu Ruim Mesmo");
			}
		});
		
		Optional.ofNullable(user.getFirstname()).map(OptionalTest::isValid).ifPresent(t -> {
			try {
				//funcionaPuta(t);
			} catch (Exception e1) {
				new Exception();
			}
		});
		Optional.ofNullable(user.getFirstname()).map(OptionalTest::isValid)
			.ifPresent(result -> {
				try {
					funcionaPuta(result);
				} catch (Exception e1) {
					//new NullPointerException("sssss");
					e1.printStackTrace();
				}
			});
		
		try {
			 Optional.ofNullable(true).filter(Objects::nonNull).map(valor -> Boolean.TRUE).orElseThrow(() -> new Exception("ERRO TRUE"));
			Optional.ofNullable(false).filter(Objects::nonNull).map(valor -> Boolean.TRUE).orElseThrow(() -> new Exception("ERRO False"));
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Fim");
	}
	
	public static void funcionaPuta(boolean teste) throws Exception {
		if (!teste) {
			throw new Exception("Deu Ruim");
		}
	}
	
	public static boolean isValid(String nome) {
		return nome.equals("Renatao");
	}

}
