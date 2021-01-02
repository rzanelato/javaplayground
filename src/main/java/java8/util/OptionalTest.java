package java8.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;

import pojo.Activity;
import pojo.Group;
import pojo.User;

public class OptionalTest {

	public static void main(String[] args) {
		
		
		
		String a = "nombre";
		Group grupo0 = new Group(0, null, false);
		Group grupo1 = new Group(0, "re", false);
		Stream.of(grupo0.getName()).filter(StringUtils::isEmpty).map(name->a).findAny().ifPresent(x->grupo0.setName(x));
		
		System.out.println("xxx -> " + grupo0.getName());
		
		Stream.of(grupo1.getName()).filter(StringUtils::isEmpty).map(name->a).findAny().ifPresent(x->grupo1.setName(x));
		System.out.println("ssssss -> " + grupo1.getName());
		
		Optional<String> opt = getString(null);
		Optional<String> opt1 = getString("");
		Optional<String> opt2 = getString("xxx");
		Optional<String> opt3 = getString("Renato");
		
		opt.ifPresent(string -> System.out.println("Teste: " + string));
		opt1.ifPresent(string -> System.out.println("Teste1: " + string));
		opt2.ifPresent(string -> System.out.println("Teste2: " + string));
		opt3.ifPresent(string -> System.out.println("Teste3: " + string));
		
		
		Group g0 = new Group(0, null, false);
		Group g1 = new Group(0, "nome", false);
		String teste = Optional.ofNullable(g0.getName()).filter(StringUtils::isNotBlank).orElse("nadica");
		String teste2 = Optional.ofNullable(g1.getName()).filter(StringUtils::isNotBlank).orElse("nadica");
		
		System.out.println("TEste do vazio: [" + teste + "] - {" + teste2 + "}");
		
		testeOptionalComLista();
		
		try {
			testeFilterMapCondition();
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		
	}
	
	private static void testeFilterMapCondition() throws Exception {
		Group grupo0 = new Group(0, null, false);
		Group grupo1 = new Group(1, "Renato 1", true);
		Group grupo2 = new Group(1, "Renato 2", false);
		Group grupo3 = new Group(0, "Renato 3", true);
		Group grupo4 = new Group(0, "Renato 4", false);
		
		System.out.println("xxx - " + Optional.ofNullable(grupo0).map(Group::getName).orElse(null));
		System.out.println("sss - " + Optional.ofNullable(grupo1).map(Group::getName).orElse(null));
		

		
		
		getValid(grupo1);
		System.out.println("Nome: " + grupo1.getName());
		getValid(grupo2);
		System.out.println("Nome: " + grupo2.getName());
		getValid(grupo3);
		System.out.println("Nome: " + grupo3.getName());
		getValid(grupo4);
		
		/*
		Optional.ofNullable(grupo1).filter(gp -> gp.getNumber() != 0 && gp.isActive()).orElseThrow(() -> new Exception("Erro"));
		System.out.println("Nome: " + grupo1.getName());
		
		Optional.ofNullable(grupo2).filter(gp -> gp.getNumber() != 0 && gp.isActive()).orElseThrow(() -> new Exception("Erro"));
		System.out.println("Nome: " + grupo2.getName());
		
		Optional.ofNullable(grupo3).filter(gp -> gp.getNumber() != 0 && gp.isActive()).orElseThrow(() -> new Exception("Erro"));
		System.out.println("Nome: " + grupo3.getName());
		
		Optional.ofNullable(grupo4).filter(gp -> gp.getNumber() != 0 && gp.isActive()).orElseThrow(() -> new Exception("Erro"));
		System.out.println("Nome: " + grupo4.getName());
		*/
		
	}
	
	private static Group getValid(Group group) throws Exception {
		return Optional.ofNullable(group).filter(gp -> gp.getNumber() != 0 && gp.isActive()).orElseThrow(() -> new Exception("Erro"));
	}
	
	
	private static void testeOptionalComLista() {
		// Deve sair Renato Zanelato
		User user = new User("Renato", new ArrayList<>());
		Activity activity = new Activity("Zanelato", "100");
		//Activity activity = new Activity();
		
		Optional.ofNullable(activity.getName()).ifPresent(name -> user.setListActivities(createActivity(name)));
		
		String nome = user.getName();
		String sobrenome = user.getListActivities().stream().filter(Objects::nonNull).findFirst().map(Activity::getName).orElse("nada");
		
		System.out.println("\nTeste Optional com lista");
		System.out.println(nome + " " + sobrenome);
		
	}
	
	private static List<Activity> createActivity(String name) {
		List<Activity> list = new ArrayList<>();
		list.add(new Activity(name, "5"));
		return list;
	}

	private static Optional<String> getString(String string) {
		if (string == null) {
			return Optional.empty(); 
		}
		if (string.isEmpty()) {
			return Optional.empty();
		}
		if ("xxx".equals(string)) {
			return Optional.of("Pornografia");
		}
		return Optional.of("Valor: " + string);
	}

}
