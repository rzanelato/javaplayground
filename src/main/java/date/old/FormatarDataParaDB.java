package date.old;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatarDataParaDB {

	final static String OLD_FORMAT  = "dd/MM/yyyy HH:mm";
	final static String NEW_FORMAT = "yyyy-MM-dd hh:mm:ss.SSS";
	
	public static void main(String[] args) throws ParseException {
		String data1 = "13/12/2011 00:32";
		String data2 = "10/05/2017 13:29";
		
		String formatOracle = "TO_DATE('10/05/2017 13:29', 'dd/MM/yyyy HH24:MI')";
		
		DateFormat formatter = new SimpleDateFormat(OLD_FORMAT);
		Date d = formatter.parse(data1);
		((SimpleDateFormat) formatter).applyPattern(NEW_FORMAT);
		String newDateString = formatter.format(d);
		System.out.println(newDateString);

		Timestamp dataFormatada = Timestamp.valueOf(newDateString);
		
		
		//Calendar calendar = Calendar.
		//Timestamp dataFormatada = Timestamp.valueOf(data1);
		
		System.out.println(dataFormatada.getHours());
		System.out.println(dataFormatada.getMinutes());
		System.out.println(dataFormatada.getDate());
		System.out.println(dataFormatada.getMonth());
		System.out.println(dataFormatada.getYear());
		System.out.println(dataFormatada.getTime());

	}

}
