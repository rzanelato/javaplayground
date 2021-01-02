package date.old;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class TesteDataHora {

	public static void main(String[] args) {
		Calendar data = GregorianCalendar.getInstance();
		
		System.out.println(TimeZone.getTimeZone("GMT-3").getDisplayName());
		System.out.println(data.getTimeZone().getDisplayName());
		
		SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy-HH:mm a - kk:mm Z"); 
		System.out.println(formatoData.format(data.getTime()));
	}
	
}
