package silly;

import java.util.Optional;

public class Talk {
	
	private String name;
	private int duration;
	
	public Talk(String text) {
		distributeValues(text);
	}

	public Talk(String name, int duration) {
		this.name = name;
		this.duration = duration;
	}

	private void distributeValues(String text) {
		this.name =  text;
		setDurationBy(text);
	}
	
	private void setDurationBy(String text) {
		Optional.of(text)
			.filter(textDuration -> !textDuration.endsWith("lightning"))
			.ifPresentOrElse(this::standardDuration
					, this::lightningDuration);
				
	}
	
	private void standardDuration(String text) {
		duration = Integer.valueOf(text.substring(text.lastIndexOf("min")-2, text.lastIndexOf("min")));
	}
	
	private void lightningDuration() {
		duration = 5;
	}

	public String getName() {
		return name;
	}

	public int getDuration() {
		return duration;
	}

	@Override
	public String toString() {
		return "Talk [name= " + name + ", duration= " + duration + "]";
	}
}
