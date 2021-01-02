package java8.design.patterns;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Consumer;

public class TemplateMethodConsumer {

	public static void main(String[] args) {
		Consumer<Map<String, String>> manyValues = AddManyValues::add;
		Consumer<Map<String, String>> fewValues = AddFewValues::add;
		Consumer<Map<String, String>> oneValue = TemplateMethodConsumer::addTest;
		Consumer<Map<String, String>> paramValue = x -> addParam(x);
		
		
		Consumer<Map<String, String>> sequence1 = TemplateMethodConsumer::addTest;
		Consumer<Map<String, String>> sequence2 = sequence1.andThen(AddFewValues::add);
		Consumer<Map<String, String>> sequence3 = sequence2.andThen(AddManyValues::add);
		
		Map<String, String> result = TemplateMethodConsumer.execute("Teste", oneValue);
		printResult("Resultado 1", result);
		
		Map<String, String> result2 = TemplateMethodConsumer.execute("Teste2", manyValues);
		printResult("Resultado 2", result2);
		
		Map<String, String> result3 = TemplateMethodConsumer.execute("Teste3", fewValues);
		printResult("Resultado 3", result3);
		
		Map<String, String> result4 = TemplateMethodConsumer.execute("Teste4", paramValue);
		printResult("Resultado 4", result4);
		
		Map<String, String> result5 = TemplateMethodConsumer.execute("Teste5", sequence3);
		printResult("Resultado 5", result5);
	}
	
	private static void printResult(String string, Map<String, String> result) {
		System.out.println(string);
		result.entrySet().stream().forEach(TemplateMethodConsumer::doPrint);
	}
	
	private static void doPrint(Entry<String, String> entry) {
		System.out.println(" - K: " + entry.getKey() + " V: "+entry.getValue());
	}

	private static Map<String, String> execute(String name, Consumer<Map<String, String>> consumerString) {
		Map<String, String> result = new HashMap<String, String>();
		consumerString.accept(result);
		return result;
	}
	
	private static void addTest(Map<String, String> listMap) {
		listMap.put("OneValue", "888");
	}
	
	private static void addParam(Map<String, String> listMap) {
		listMap.put("ParamValue", "888");
	}
	
	private static void consumerTest(Map<String, String> listMap, Consumer<Map<String, String>> consumer, String key, String value) {
		listMap.put(key, value);
		consumer.accept(listMap);
	}

}
class AddFewValues {
	
	public static void add(Map<String, String> listMap) {
		listMap.put("RenatoF", "1000");
		listMap.put("ZanelatoFS", "6666");
	}
}
class AddManyValues {
	
	public static void add(Map<String, String> listMap) {
		listMap.put("Renato", "66");
		listMap.put("Zanelato", "33");
		listMap.put("RenatoZ", "2561");
		listMap.put("RZanelato", "281");
	}
}
