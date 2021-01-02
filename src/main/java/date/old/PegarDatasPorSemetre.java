package date.old;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class PegarDatasPorSemetre {

	public static void main(String[] args) {
		Calendar dataHoje = Calendar.getInstance();
		dataHoje.set(Calendar.YEAR, 2018);
		dataHoje.set(Calendar.MONTH, 6);
		dataHoje.set(Calendar.DAY_OF_MONTH, 2);
		
		Calendar data = Calendar.getInstance();
		
		data.set(Calendar.YEAR, 2017);
		data.set(Calendar.MONTH, 0);
		data.set(Calendar.DAY_OF_MONTH, 1);
		
		SimpleDateFormat dateFormatter = new SimpleDateFormat("E, d-M-y 'at' h:m:s a z");
		dateFormatter = new SimpleDateFormat("EEEE, d MMMM, yyyy");

		dateFormatter = new SimpleDateFormat("yyyyMMdd");
		System.out.println("Sem 24h:   " + dateFormatter.format(dataHoje.getTime()));
		System.out.println();
		
		//inicio
		while(data.before(dataHoje)) {
			String dateBegin = dateFormatter.format(data.getTime());
			data.add(Calendar.MONTH, 3);
			data.add(Calendar.DAY_OF_MONTH, -1);
			String dateEnd = dateFormatter.format(data.getTime());
			data.add(Calendar.DAY_OF_MONTH, 1);
			System.out.println("Inicio:   " + dateBegin + "\tFim: "+dateEnd );
			
		}
		
		String testeData = dateFormatter.format(dataHoje.getTime());
		System.out.println("Ano: " + testeData.substring(0,4));
		System.out.println("Mes: " + testeData.substring(4,6));
		System.out.println("Dia: " + testeData.substring(6));

	}

}
