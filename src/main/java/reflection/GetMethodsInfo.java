package reflection;

import java.util.stream.Stream;

import pojo.Activity;

public class GetMethodsInfo {

	public static void main(String[] args) {
		
		Activity teste = new Activity("Nome", "100");
		
		Stream.of(teste.getClass().getMethods()).filter(metodo -> metodo.getName().startsWith("get")).forEach(metodo -> System.out.println(metodo.getName()));

	}

}
