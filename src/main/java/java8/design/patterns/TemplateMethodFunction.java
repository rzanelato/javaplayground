package java8.design.patterns;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class TemplateMethodFunction {

	public static void main(String[] args) {
		Function<String, Map<String, String>> manyValues = TemplateMethodFunction::add;
		
		Map<String, String> result2 = TemplateMethodFunction.execute("Teste1", manyValues);
		printResult("Resultado 1", result2);
		
	}

	private static Map<String, String> execute(String name, Function<String, Map<String, String>> consumerString) {
		Map<String, String> result = consumerString.apply(name);
		return result;
	}
	
	private static void printResult(String string, Map<String, String> result) {
		System.out.println(string);
		result.entrySet().stream().forEach(entry -> System.out.println(" - K: " + entry.getKey() + " V: "+entry.getValue()));
	}
	
	private static Map<String, String> add(String str) {
		Map<String, String> listMap = new HashMap<String, String>();

		listMap.put(str, "123465");
		listMap.put("Renato", "66");
		listMap.put("Zanelato", "33");
		listMap.put("RenatoZ", "2561");
		listMap.put("RZanelato", "281");
		
		return listMap; 
	}
	
}