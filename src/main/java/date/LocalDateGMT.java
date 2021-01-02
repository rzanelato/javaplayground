package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalField;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class LocalDateGMT {

	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeZone(TimeZone.getTimeZone("GMT-1"));
		System.out.println("Calendar: " + getDateWithoutTimeUsingFormat(calendar.getTime()));


		//printZoneId();
		
		testInternet();
		
		
		LocalDateTime local = LocalDateTime.now();
		ZonedDateTime zone = ZonedDateTime.now();
		Instant instant = Instant.now();
		System.out.println(new Date().getTime());
		//Period duration = Period.
		//System.out.println(zone.getLong(ChronoField.INSTANT_SECONDS));
		//System.out.println(zone.getLong(ChronoField.MILLI_OF_SECOND));
		//System.out.println(zone.getLong(ChronoField.NANO_OF_SECOND));
		
		for ( ChronoField chrono : ChronoField.values()) {
			try {
				System.out.println(instant.getLong(chrono) + " - " + chrono.getDisplayName(Locale.ENGLISH));
			} catch (Exception e) {
				System.out.println("Erro: " + e.getMessage());
			}
		}
	}


	private static void testInternet() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

		//Here you say to java the initial timezone. This is the secret
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		//Will print in UTC
		System.out.println(sdf.format(calendar.getTime()));    

		//Here you set to your timezone
		sdf.setTimeZone(TimeZone.getDefault());
		//Will print on your default Timezone
		System.out.println(sdf.format(calendar.getTime()));		
	}


	private static void printZoneId() {
		for (String zona: ZoneId.getAvailableZoneIds()) {
			System.out.println(zona);
		}
	}

	
	public static Date getDateWithoutTimeUsingFormat(Date date) {
		
		SimpleDateFormat formatter = new SimpleDateFormat( "dd/MM/yyyy HH:mm z");
		try {
			return formatter.parse(formatter.format(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
