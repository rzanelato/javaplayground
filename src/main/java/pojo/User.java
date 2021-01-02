package pojo;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

	private String firstname;
	private String lastname;
	private String name;
	private String address;
	private int age;
	private boolean active;
	private List<Activity> listActivities;
	
	public User() {
	}
	
	public User(int age) {
		this.age = age;
	}
	
	public User(String name, List<Activity> list) {
	    this.name = name;
	    this.listActivities = list;
	}
	
}
