package date.old;

import java.util.Calendar;

import facu.ConverterUtils;


public class TesteDiaDaSemana {
	
	private static String dia;
	private static String mes;
	private static int nrDiaSemana;
	
	public static void main(String[] args) {
		
		diaSemana("segunda");
		diaSemana("terça");
		diaSemana("quarta");
		diaSemana("quinta");
		diaSemana("sexta");
		diaSemana("sabado");
		diaSemana("domingo");
		
	}
	
	
	private static void diaSemana(String dia){
		Calendar dataHoje = Calendar.getInstance();
		
		if(dia.equals("segunda")){
			//dataHoje.add(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
			//dataHoje.roll(Calendar.DAY_OF_WEEK, true);
			dataHoje.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);
			dia = ConverterUtils.converteDia(dataHoje.get(dataHoje.DAY_OF_MONTH));
			mes = ConverterUtils.converteMes(dataHoje.get(dataHoje.MONTH));
			nrDiaSemana = dataHoje.get(dataHoje.DAY_OF_WEEK);
		}
		if(dia.substring(0,3).equals("ter")){
			dataHoje.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
			dia = ConverterUtils.converteDia(dataHoje.get(dataHoje.DAY_OF_MONTH));
			mes = ConverterUtils.converteMes(dataHoje.get(dataHoje.MONTH));
			nrDiaSemana = dataHoje.get(dataHoje.DAY_OF_WEEK);
		}
		if(dia.equals("quarta")){
			dataHoje.set(dataHoje.DAY_OF_WEEK, Calendar.WEDNESDAY);
			dia = ConverterUtils.converteDia(dataHoje.get(dataHoje.DAY_OF_MONTH));
			mes = ConverterUtils.converteMes(dataHoje.get(dataHoje.MONTH));
			nrDiaSemana = dataHoje.get(dataHoje.DAY_OF_WEEK);
		}
		if(dia.equals("quinta")){
			dataHoje.set(dataHoje.DAY_OF_WEEK, Calendar.THURSDAY);
			dia = ConverterUtils.converteDia(dataHoje.get(dataHoje.DAY_OF_MONTH));
			mes = ConverterUtils.converteMes(dataHoje.get(dataHoje.MONTH));
			nrDiaSemana = dataHoje.get(dataHoje.DAY_OF_WEEK);
		}
		if(dia.equals("sexta")){
			dataHoje.set(dataHoje.DAY_OF_WEEK, Calendar.FRIDAY);
			dia = ConverterUtils.converteDia(dataHoje.get(dataHoje.DAY_OF_MONTH));
			mes = ConverterUtils.converteMes(dataHoje.get(dataHoje.MONTH));
			nrDiaSemana = dataHoje.get(dataHoje.DAY_OF_WEEK);
		}
		if(dia.equals("sabado")){
			dataHoje.set(dataHoje.DAY_OF_WEEK, Calendar.SATURDAY);
			dia = ConverterUtils.converteDia(dataHoje.get(dataHoje.DAY_OF_MONTH));
			mes = ConverterUtils.converteMes(dataHoje.get(dataHoje.MONTH));
			nrDiaSemana = dataHoje.get(dataHoje.DAY_OF_WEEK);
		}
		if(dia.equals("domingo")){
			dataHoje.set(dataHoje.DAY_OF_WEEK, Calendar.SUNDAY);
			dia = ConverterUtils.converteDia(dataHoje.get(dataHoje.DAY_OF_MONTH));
			mes = ConverterUtils.converteMes(dataHoje.get(dataHoje.MONTH));
			nrDiaSemana = dataHoje.get(dataHoje.DAY_OF_WEEK);
		}
		System.out.println(ConverterUtils.converteDiaSemana(nrDiaSemana)+" "+ dia+ " "+ mes);
	}

}

