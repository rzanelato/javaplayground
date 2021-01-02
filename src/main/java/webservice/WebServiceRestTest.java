package webservice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.client.RestTemplate;

import pojo.CurrencyDTO;


public class WebServiceRestTest {

	public static void main(String[] args) {
		//fillServer();
		testServiceCurrency();
	}
	
	private static void fillServer() {
		String url = "http://localhost:8080/account/create";
		RestTemplate restTemplate = new RestTemplate();

		Map<String, Object> obj1 = new HashMap<>();
		obj1.put("accountId", "1");
		obj1.put("iban", "IE2335533390054322043300");
		obj1.put("balance", "1020.05");
		obj1.put("currency", "BRL");
		obj1.put("active", true);
		
		restTemplate.httpEntityCallback(obj1);
		restTemplate.postForObject(url, obj1, Map.class);
		
		Map<String, Object> obj2 = new HashMap<>();
		obj2.put("accountId", "2");
		obj2.put("iban", "IE2335533390054322043300");
		obj2.put("balance", "1020.05");
		obj2.put("currency", "BRL");
		obj2.put("active", true);
		
		restTemplate.httpEntityCallback(obj2);
		restTemplate.postForObject(url, obj2, Map.class);
		
		Map<String, Object> obj3 = new HashMap<>();
		obj3.put("accountId", "3");
		obj3.put("iban", "IE2335533390054322043300");
		obj3.put("balance", "1020.05");
		obj3.put("currency", "BRL");
		obj3.put("active", true);
		
		restTemplate.httpEntityCallback(obj3);
		restTemplate.postForObject(url, obj3, Map.class);
		
		Map<String, Object> obj4 = new HashMap<>();
		obj4.put("accountId", "4");
		obj4.put("iban", "IE2335533390054322043300");
		obj4.put("balance", "1020.05");
		obj4.put("currency", "BRL");
		obj4.put("active", false);
		
		restTemplate.httpEntityCallback(obj4);
		restTemplate.postForObject(url, obj4, Map.class);
		
		Map<String, Object> obj5 = new HashMap<>();
		obj5.put("accountId", "5");
		obj5.put("balance", "1020.05");
		obj5.put("currency", "BRL");
		
		restTemplate.httpEntityCallback(obj5);
		restTemplate.postForObject(url, obj5, Map.class);
		
	}
	
	private static void testServiceCurrency() {
		RestTemplate restTemplate = new RestTemplate();
		String base = "EUR";
		String other = "BRL";
		String url = String.format("https://api.exchangeratesapi.io/latest?base=%s&symbols=%s",base, other);
		CurrencyDTO obj = restTemplate.getForObject(url, CurrencyDTO.class);
		
		System.out.println(obj);
		
		System.out.println("Base: " + obj.getBase());
		obj.getRates().entrySet().stream().forEach(key -> System.out.println(key.getKey() + " - " + key.getValue()));
		
		System.out.println(obj.calcNewAmount("100"));
		
	}
	



}
