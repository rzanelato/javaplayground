package pojo;

public class Activity {
	
	private String name;
	private String points;
	
	public Activity() {
	}
	
	public Activity(String name, String points) {
		this.name = name;
		this.points = points;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPoints() {
		return points;
	}
	
	public void setPoints(String points) {
		this.points = points;
	}
	
	@Override
	public String toString() {
		return "[A]: " + name + " - [P]: " + points;
	}
}
