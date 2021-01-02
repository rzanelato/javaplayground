package java8.stream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import java8.util.OptionalTest;
import pojo.Activity;
import pojo.Group;
import pojo.User;

public class StreamListTest {

	public static void main(String[] args) {

		//testeListActivityWithoutName();
		testeOrderListWithoutChildren();
		/*
		Group gp = getGroup();
		Stream<User> filter = gp.getListUsers().stream().filter(u -> u.getListActivities() != null);
		//filter.forEach(u -> u.getListActivities().forEach(System.out::println));
		print(filter);
		//Stream<String> mapUser = filter.map(User::getName);
		//mapUser.forEach(System.out::println);
		 */
	}
	
	private static void testeOrderListWithoutChildren() {
		Group gp = getGroup();
		
		Optional.ofNullable(gp.getListUsers()).ifPresent(users -> users.forEach(user -> Optional.ofNullable(user.getListActivities()).ifPresent(acts -> acts.sort(Comparator.comparing(Activity::getName)))));
		Optional.ofNullable(gp.getListUsers()).ifPresent(users -> users.sort(Comparator.comparing(User::getName)));
		
		System.out.println(gp.getName());
		Optional.ofNullable(gp.getListUsers()).ifPresent(users -> users.forEach(user -> System.out.println(user.getName())));
		Optional.ofNullable(gp.getListUsers()).ifPresent(users -> users.forEach(user -> Optional.ofNullable(user.getListActivities()).ifPresent(actvs -> actvs.forEach(actv -> System.out.println(actv.getName())))));
		
		
	}

	private static void testeListVazia() {
		List<Activity> actList = new ArrayList<>();
		//actList.add(new Activity("Renato", "100"));
		System.out.println(actList.stream().filter(Objects::nonNull).findFirst().map(Activity::getName).orElse("nada"));
	}
	
	private static void testeListActivityWithoutName() {
		List<Activity> actList = new ArrayList<>();
		//actList.add(new Activity("Renato", "100"));
		actList.add(new Activity(null , "101"));
		actList.add(new Activity(null , "120"));
		actList.add(new Activity(null, "140"));
		
		List<String> names = actList.stream().filter(Objects::nonNull).map(Activity::getName).filter(Objects::nonNull).collect(Collectors.toList());
		System.out.println("size: " + names.size());
		names.forEach(System.out::println);
		//Optional.ofNullable(names).filter(List::isEmpty).orElseThrow(() -> new NullPointerException("TEM ITEM"));
		
		Stream.of(names).filter(Objects::isNull).map(x->Boolean.TRUE).findAny().orElseThrow(()->new NullPointerException("Tem Item"));
	}

	private static void print(Stream<User> filter) {
		filter.forEach(u -> System.out.println(u.getName()));
	}

	private static Group getGroup() {
		Activity act1 = new Activity("atv1", "1");
		Activity act2 = new Activity("atv2", "2");
		Activity act3 = new Activity("atv1", "3");
		Activity act4 = new Activity("atv4", "353");
		Activity act5 = new Activity("atv5", "633");
		
		List<Activity> listAct1 = new ArrayList<Activity>();
		listAct1.add(act4);
		listAct1.add(act2);
		listAct1.add(act1);
		listAct1.add(act3);
		List<Activity> listAct2 = new ArrayList<Activity>();
		listAct2.add(act5);
		listAct2.add(act3);
		listAct2.add(act4);
		
		User user1 = new User("Renato", listAct1);
		User user2 = new User("Zanelato", listAct2);
		User user3 = new User("Walt", null);
		User user4 = new User("Zurita", null);
		
		List<User> listUser1 = new ArrayList<>();
		List<User> listUser2 = new ArrayList<>();
		
		listUser1.add(user1);
		listUser1.add(user2);
		listUser1.add(user3);
		
		listUser2.add(user4);
		listUser2.add(user1);
		
		return new Group(1, "G1", listUser1);		
	}

}
