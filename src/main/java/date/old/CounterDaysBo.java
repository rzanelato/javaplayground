package date.old;

import java.util.Calendar;

import javax.swing.JOptionPane;

public class CounterDaysBo {
	
	public static void main(String[] args) {
		String titulo = "Counter Days Bo";
		int diasFaltantes = getDiasFaltantes(getDiaHoje(), getDataVoltaBo());
		if(diasFaltantes != 0){
			String mensagem = "";
			if(diasFaltantes == 1)
				mensagem = "Amanh� a Bobozinha voltar para o Bobozinho! Eba!";
			else
				mensagem = "Faltam "+diasFaltantes+" dias para a Bobozinha voltar para o Bobozinho!";
			JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.INFORMATION_MESSAGE);
		}else{
			String mensagem = "Bobozinha j� voltou para o Bobozinho";
			JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	private static Calendar getDataVoltaBo(){
		Calendar calendar = Calendar.getInstance();
		calendar.set(2014, 3, 28, 9, 0, 0);
		return calendar;
	}
	
	private static Calendar getDiaHoje(){
		Calendar calendar = Calendar.getInstance();
		return calendar;
	}
	
	private static int getDiasFaltantes(Calendar dataInicio, Calendar dataFim){
		int count = 0;
		while(dataInicio.before(dataFim)){
			dataInicio.add(Calendar.DAY_OF_MONTH, 1);
			count++;
		}
		return count;
	}
}

