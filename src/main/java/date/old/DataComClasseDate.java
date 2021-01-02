package date.old;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataComClasseDate {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		Date fecha = new Date();
		fecha.setYear(118);
		fecha.setMonth(3);
		fecha.setDate(8);
		fecha.setHours(11);
		fecha.setMinutes(39);
		
		Calendar data = Calendar.getInstance();
//		data.set(Calendar.YEAR, 2018);
//		data.set(Calendar.MONTH, 3);
//		data.set(Calendar.DAY_OF_MONTH, 9);
//		data.set(2018, 3, 8, 11, 26, 10);
		
		data.setTime(fecha);
		
		SimpleDateFormat dateFormatter = new SimpleDateFormat("E, y-M-d 'at' h:m:s a z");
		dateFormatter = new SimpleDateFormat("EEEE, MMMM d, yyyy");
		System.out.println("Sem 24h:   " + dateFormatter.format(data.getTime()));
		data.add(Calendar.HOUR,24);
		System.out.println("Com 24h:   " + dateFormatter.format(data.getTime()));

/*
		dateFormatter = new SimpleDateFormat("E, y-M-d 'at' h:m:s a z");
		System.out.println("Format 1:   " + dateFormatter.format(data.getTime()));

		dateFormatter = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
		System.out.println("Format 2:   " + dateFormatter.format(data.getTime()));

		dateFormatter = new SimpleDateFormat("EEEE, MMMM d, yyyy");
		System.out.println("Format 3:   " + dateFormatter.format(data.getTime()));
	*/	
		Date hoje = new Date();
		
		System.out.println("Format 3:   " + dateFormatter.format(hoje));
		
		if (data.getTime().before(hoje)) {
			System.out.println("before");
		}
		
		if (data.getTime().after(hoje)) {
			System.out.println("after");
		}
		
		if (hoje.before(data.getTime())) {
			System.out.println("Esta valido");
		}
		

		
	}

}
