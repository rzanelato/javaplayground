package java8.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import pojo.Activity;
import pojo.Group;
import pojo.User;

public class OrderListStream {

	private static String order = "Order";
	
	public static void main(String[] args) {
		testeOrderListWithoutChildren();
	}
	
	private static void testeOrderListWithoutChildren() {
		Group gp = getGroup();
		
		
		Optional.of(existExtension(gp.getListUsers())).filter(value -> value).ifPresent(consumer -> gp.getListUsers().sort(getComparator()));
		//gp.getListUsers().sort(getComparator());
		gp.getListUsers().forEach(user -> System.out.println(user.getName()));
		
		
	}
	
	private static boolean existExtension(List<User> list) {
		List<Boolean> hasExtension = new ArrayList<>();
		//Optional.ofNullable(list).ifPresent(users -> users.forEach(user -> hasExtension.add(Optional.ofNullable(user.getListActivities()).isPresent())));
		//Optional.ofNullable(list).ifPresent(users -> hasExtension.add(users.stream().allMatch(user -> user.getListActivities() != null && user.getListActivities().stream().allMatch(acts -> order.contains(acts.getName())))));
		boolean result = Stream.of(list).filter(Objects::nonNull).allMatch(listx -> listx.stream().allMatch(user -> Objects.nonNull(user.getListActivities()) && user.getListActivities().stream().anyMatch(acts -> order.contains(acts.getName()))));
		//System.out.println(Stream.of(list).filter(Objects::nonNull).allMatch(listx -> listx.stream().allMatch(usr -> Objects.nonNull(usr.getListActivities()))));
		System.out.println(result);
		return !hasExtension.isEmpty() && hasExtension.stream().filter(booleanValue -> !booleanValue).findAny().orElse(true);
	}
	
	
	private static Comparator<User> getComparator() {
		return (User user, User other) -> 
			user.getListActivities().stream().filter(acts -> order.contains(acts.getName())).map(Activity::getPoints).map(Integer::valueOf).findAny().orElse(1)
					.compareTo(other.getListActivities().stream().filter(acts -> order.contains(acts.getName())).map(Activity::getPoints).map(Integer::valueOf).findAny().orElse(1));
		
	}

	private static Group getGroup() {
		
		Activity org = new Activity("Org", "302");
		Activity act1 = new Activity(order, "2");
		Activity act2 = new Activity(order, "3");
		Activity act3 = new Activity(order, "1");
		
		List<Activity> listAct1 = new ArrayList<>();
		listAct1.add(org);
		listAct1.add(act1);
		
		List<Activity> listAct2 = new ArrayList<>();
		listAct2.add(org);
		listAct2.add(act2);
		
		List<Activity> listAct3 = new ArrayList<>();
		listAct3.add(org);
		listAct3.add(act3);
		
		User user1 = new User("Ev3", listAct1);
		User user2 = new User("Ev2", listAct2);
		User user3 = new User("Ev1", listAct3);
		User user4 = new User("Ev0", new ArrayList<>());
		User user5 = new User("Ev4", null);
		
		List<User> listUser1 = new ArrayList<>();
		
		listUser1.add(user1);
		listUser1.add(user2);
		listUser1.add(user3);
		//listUser1.add(user4);
		//listUser1.add(user5);
		
		return new Group(1, "Consultation", listUser1);		
		
	}
}
