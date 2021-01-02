package linkedlist;

import java.util.Date;

public class PersonOne {

	private String firstName;
	private String lastName;
	private String passport;
	private Date dateArrival;
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String toString() {
		return this.firstName;
	}

}
