package date.old;

import java.sql.Timestamp;
import java.util.Calendar;

public class TestarTimestamp {

	public static void main(String[] args) {
		
		
		Timestamp hoje = new Timestamp(Calendar.getInstance().getTimeInMillis());
		System.out.println(hoje.toString());
		
		Calendar dataAnterior = Calendar.getInstance();
		dataAnterior.set(Calendar.DAY_OF_MONTH, 3);
		
		Calendar dataPosterior = Calendar.getInstance();
		dataPosterior.set(Calendar.DAY_OF_MONTH, 13);
		
		Timestamp anterior = new Timestamp(dataAnterior.getTimeInMillis());
		
		Timestamp posterior = new Timestamp(dataPosterior.getTimeInMillis());
		
		System.out.println("Antes: "+ hoje.compareTo(anterior));
		System.out.println("Depois: "+ hoje.compareTo(posterior));
		System.out.println("hoje: "+ hoje.compareTo(hoje));
		

	}

}
