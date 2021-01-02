package map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import pojo.Activity;

public class TestMapsObj {
	
	public static void main(String[] args) {
		System.out.println("hashmap");
		hashMap();
		
		System.out.println("justmap");
		justMap();
		
	}
	
	private static void hashMap() {
		Map<String, Object> map = new HashMap<>();
		for (Activity activity : getList()) {
			map.put(activity.getName(), activity);
		}
		
		for (Entry<String, Object> entry : map.entrySet()) {
			System.out.println("K: " + entry.getKey() + " V: " + entry.getValue());
		}
	}
	
	private static void justMap() {
		Map<String, Object> map = getList().stream().collect(Collectors.toMap(Activity::getName, act -> act, (x1,x2) -> x2));
	
		for (Entry<String, Object> entry : map.entrySet()) {
			System.out.println("K: " + entry.getKey() + " V: " + entry.getValue());
		}
		System.out.println(map.get("atv3"));
	}

	private static List<Activity> getList() {
		List<Activity> listActivities = new ArrayList<>();
		Activity act1 = new Activity("atv1", "33");
		Activity act2 = new Activity("atv2", "33333");
		Activity act3 = new Activity("atv3", "343");
		Activity act4 = new Activity("atv1", "353");
		Activity act5 = new Activity("atv3", "633");
		
		listActivities.add(act1);
		listActivities.add(act2);
		listActivities.add(act3);
		listActivities.add(act4);
		listActivities.add(act5);
		
		return listActivities;
	}
	
}
