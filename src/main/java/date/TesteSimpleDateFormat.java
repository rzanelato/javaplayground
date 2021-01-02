package date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TesteSimpleDateFormat {

	public static void main(String[] args) {
		SimpleDateFormat defaultDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, 9);
		calendar.set(Calendar.MONTH, 8);
		calendar.set(Calendar.YEAR, 2018);
		calendar.set(Calendar.HOUR_OF_DAY, 10);
		calendar.set(Calendar.MINUTE, 10);
		calendar.set(Calendar.MILLISECOND, 10);

		Date hoje = calendar.getTime();
		
		System.out.println("Antes");
		System.out.println(defaultDateFormat.format(hoje));

		System.out.println("Depois");
		defaultDateFormat.applyPattern("dd/MM/yyyy HH:mm");
		System.out.println(defaultDateFormat.format(hoje));
		
	}

}
