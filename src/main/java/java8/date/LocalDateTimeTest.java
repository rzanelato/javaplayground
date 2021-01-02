package java8.date;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class LocalDateTimeTest {
	
	public static void main(String[] args) {
		LocalDateTime baseDados = LocalDateTime.now();
		
		LocalDateTime calc30 = baseDados.plusSeconds(30);
		
		long seconds = calc30.plusSeconds(20).until(baseDados.plusSeconds(5), ChronoUnit.SECONDS);
		
		System.out.println("Seconds: " + seconds);
	}

}
