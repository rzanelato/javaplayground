package java8.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import pojo.User;

public class MaxValStreams {
	
	public static void main(String[] args) {
		List<User> listUser = new ArrayList<User>();
		listUser.add(new User(10));
		listUser.add(new User(30));
		listUser.add(new User(100));
		listUser.add(new User(7));
		
		Optional<User> max = listUser.stream().max(Comparator.comparing(User::getAge));
		
		System.out.println(max.get().getAge());
		
	}

}
