package pojo;

import java.util.ArrayList;
import java.util.List;

public class Group {

	private int number;
	private String name;
	private boolean active;
	private List<User> listUsers;
	
	public Group(int number, String name, List<User> listUsers) {
		this.number = number;
		this.name = name;
		this.listUsers = listUsers;
	}
	
	public Group(int number, String name, boolean active) {
		this.number = number;
		this.name = name;
		this.active = active;
		this.listUsers = new ArrayList<>();
	}

	public int getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<User> getListUsers() {
		return listUsers;
	}
	
	public void setListUsers(List<User> listUsers) {
		this.listUsers = listUsers;
	}
	
	public boolean isActive() {
		return this.active;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}
}
