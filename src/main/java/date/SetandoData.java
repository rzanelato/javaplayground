package date;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SetandoData {

	public static void main(String[] args) {
		Calendar data = Calendar.getInstance();
		
		int ano = 18;
		
		ano = updateYear(ano);
		
		data.set(Calendar.YEAR, ano);
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println(format.format(data.getTime()));
		
		
	}

	private static int updateYear(int ano) {
		Calendar data = Calendar.getInstance();
		if (ano < 100) {
			boolean isAbove2000 = (data.get(Calendar.YEAR) - ano) < 2000;
			if (isAbove2000) {
				ano += 1900;
			} else {
				ano += 2000;
			}
		}
		return ano;
	}
}
