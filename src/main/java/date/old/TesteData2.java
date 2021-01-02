package date.old;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class TesteData2 {

	
	public TesteData2(){
		iniciaEssaBagaca();
	}

	public static void main(String[] args) {
		new TesteData2();
	}
	
	private void iniciaEssaBagaca() {
		String dia = "10";
		String mes = "abril";
		
		int nrDia = new Integer(dia);
		int nrMes = converteMes(mes);
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		
		Calendar dataAtual = Calendar.getInstance();
		
		Calendar novaData = new GregorianCalendar();
		novaData.set(2010, 1, 25);
		novaData.add(Calendar.DAY_OF_MONTH,15);
		
		Calendar data = new GregorianCalendar();
		data.set(dataAtual.get(Calendar.YEAR), nrMes, nrDia);
		
		Calendar data15 = new GregorianCalendar();
		data15.set(2012, 1, 25);
		data15.add(Calendar.DAY_OF_MONTH,15);
		
		
		if(data.before(novaData) || data.after(data15))
			System.out.println("Entrou");
		else
			System.out.println("N�o Entrou");
		
		
		
		
		System.out.println("Data de Hoje: " + formato.format(novaData.getTime()));
		// System.out.println("Data: "+formato.format(dataAtual.getTime()));
		System.out.println("Data Maxima: " + formato.format(data15.getTime()));
		System.out.println("Data Escolhida: " + formato.format(data.getTime()));

		System.out.println("Data: " + nrDia + " de " + converteMes(nrMes));
		
		
		
			
	}
	
	
	
	private int converteMes(String mes) {
		if (mes.equals("janeiro"))
			return 0;
		if (mes.equals("fevereiro"))
			return 1;
		if (mes.equals("mar�o"))
			return 2;
		if (mes.equals("abril"))
			return 3;
		if (mes.equals("maio"))
			return 4;
		if (mes.equals("junho"))
			return 5;
		if (mes.equals("julho"))
			return 6;
		if (mes.equals("agosto"))
			return 7;
		if (mes.equals("setembro"))
			return 8;
		if (mes.equals("outubro"))
			return 9;
		if (mes.equals("novembro"))
			return 10;
		if (mes.equals("dezembro"))
			return 11;
		return -1;
	}
	
	private String converteMes(int mes) {
		if (mes == 0)
			return "janeiro";
		if (mes == 1)
			return "fevereiro";
		if (mes == 2)
			return "mar�o";
		if (mes == 3)
			return "abril";
		if (mes == 4)
			return "maio";
		if (mes == 5)
			return "junho";
		if (mes == 6)
			return "julho";
		if (mes == 7)
			return "agosto";
		if (mes == 8)
			return "setembro";
		if (mes == 9)
			return "outubro";
		if (mes == 10)
			return "novembro";
		if (mes == 11)
			return "dezembro";
		return "";
	}
	
}
