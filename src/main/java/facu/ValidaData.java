package facu;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * 
 * @author Grupo TCC
 *
 */
public class ValidaData {
	/**
	 * Variavel String de controle do dia.
	 */
	private String dia;
	
	/**
	 * Variavel String de controle do m�s.
	 */
	private String mes;
	
	/**
	 * Variavel int de controle do dia da semana
	 */
	private int nrDiaSemana;
	
	/**
	 * Construtor da classe ValidaData
	 * @param dia
	 * @param mes
	 */
	public ValidaData(String dia, String mes){
		this.dia = dia;
		this.mes = mes;
	}

	/**
	 * Metodo responsavel por executar o processo de verificao da data.
	 * 
	 * @throws Exception
	 */
	@SuppressWarnings("static-access")
	public void executar() throws Exception{
		
		if(isDataNormal()){
			//Converte dia e mes de palavra (por extenso) para numero
			int nrDia = ConverterUtils.converteNumero(dia);
			int nrMes = ConverterUtils.converteMes(mes);
			
			//Verifica se o dia ou o mes nao foram ditos
			if(!dia.equals("ndefine") || !mes.equals("ndefine")){
				if(isDiaMesValido(nrDia,nrMes)){
					//Dia atual
					Calendar dataAtual = Calendar.getInstance();
					
					//Adiciona 15 dias no dia atual para fazer o calculo.
					Calendar dataLimite = Calendar.getInstance();
					dataLimite.add(Calendar.DAY_OF_MONTH, 15);
					
					//Recebe o dia que foi passado por parametro.
					Calendar dataEscolhida = new GregorianCalendar();
					dataEscolhida.set(dataEscolhida.get(dataEscolhida.YEAR), nrMes, nrDia);
					nrDiaSemana = dataEscolhida.get(GregorianCalendar.DAY_OF_WEEK);
					
					//verifica se o dia é anterior ao dia atual
					if(dataEscolhida.before(dataAtual))
						throw new Exception("anterior");
					else{
						//verifica se o dia é posterior aos 15 dias
						if(dataEscolhida.after(dataLimite))
							throw new Exception("posterior");
					}
				}else
					throw new Exception("invalida");
			}
		}
	}
	
	/**
	 * Metodo responsavel por verificar se as palavras hoje, amanha, depois de amanha e os dias da semana foram ditas e trata-las
	 * 
	 * @return boolean
	 */
	@SuppressWarnings("static-access")
	private boolean isDataNormal(){
		Calendar dataHoje = Calendar.getInstance();
		
		if(dia.equals("hoje")){
			dia = ConverterUtils.converteDia(dataHoje.get(dataHoje.DAY_OF_MONTH));
			mes = ConverterUtils.converteMes(dataHoje.get(dataHoje.MONTH));
			nrDiaSemana = dataHoje.get(dataHoje.DAY_OF_WEEK);
			return false;
		}
		if(dia.equals("amanha")){
			dataHoje.add(dataHoje.DAY_OF_MONTH, 1);
			dia = ConverterUtils.converteDia(dataHoje.get(dataHoje.DAY_OF_MONTH));
			mes = ConverterUtils.converteMes(dataHoje.get(dataHoje.MONTH));
			nrDiaSemana = dataHoje.get(dataHoje.DAY_OF_WEEK);
			return false;
		}
		if(dia.equals("depois de amanha")){
			dataHoje.add(dataHoje.DAY_OF_MONTH, 2);
			dia = ConverterUtils.converteDia(dataHoje.get(dataHoje.DAY_OF_MONTH));
			mes = ConverterUtils.converteMes(dataHoje.get(dataHoje.MONTH));
			nrDiaSemana = dataHoje.get(dataHoje.DAY_OF_WEEK);
			return false;
		}
		if(dia.equals("segunda")){
			System.out.println(dataHoje.get(Calendar.DAY_OF_WEEK));
			dataHoje.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
			dia = ConverterUtils.converteDia(dataHoje.get(dataHoje.DAY_OF_MONTH));
			mes = ConverterUtils.converteMes(dataHoje.get(dataHoje.MONTH));
			nrDiaSemana = dataHoje.get(dataHoje.DAY_OF_WEEK);
			return false;
		}
		//Terca
		if(dia.substring(0,3).equals("ter")){
			dataHoje.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
			dia = ConverterUtils.converteDia(dataHoje.get(dataHoje.DAY_OF_MONTH));
			mes = ConverterUtils.converteMes(dataHoje.get(dataHoje.MONTH));
			nrDiaSemana = dataHoje.get(dataHoje.DAY_OF_WEEK);
			return false;
		}
		if(dia.equals("quarta")){
			dataHoje.set(dataHoje.DAY_OF_WEEK, Calendar.WEDNESDAY);
			dia = ConverterUtils.converteDia(dataHoje.get(dataHoje.DAY_OF_MONTH));
			mes = ConverterUtils.converteMes(dataHoje.get(dataHoje.MONTH));
			nrDiaSemana = dataHoje.get(dataHoje.DAY_OF_WEEK);
			return false;
		}
		if(dia.equals("quinta")){
			dataHoje.set(dataHoje.DAY_OF_WEEK, Calendar.THURSDAY);
			dia = ConverterUtils.converteDia(dataHoje.get(dataHoje.DAY_OF_MONTH));
			mes = ConverterUtils.converteMes(dataHoje.get(dataHoje.MONTH));
			nrDiaSemana = dataHoje.get(dataHoje.DAY_OF_WEEK);
			return false;
		}
		if(dia.equals("sexta")){
			dataHoje.set(dataHoje.DAY_OF_WEEK, Calendar.FRIDAY);
			dia = ConverterUtils.converteDia(dataHoje.get(dataHoje.DAY_OF_MONTH));
			mes = ConverterUtils.converteMes(dataHoje.get(dataHoje.MONTH));
			nrDiaSemana = dataHoje.get(dataHoje.DAY_OF_WEEK);
			return false;
		}
		if(dia.equals("sabado")){
			dataHoje.set(dataHoje.DAY_OF_WEEK, Calendar.SATURDAY);
			dia = ConverterUtils.converteDia(dataHoje.get(dataHoje.DAY_OF_MONTH));
			mes = ConverterUtils.converteMes(dataHoje.get(dataHoje.MONTH));
			nrDiaSemana = dataHoje.get(dataHoje.DAY_OF_WEEK);
			return false;
		}
		if(dia.equals("domingo")){
			dataHoje.set(dataHoje.DAY_OF_WEEK, Calendar.SUNDAY);
			dia = ConverterUtils.converteDia(dataHoje.get(dataHoje.DAY_OF_MONTH));
			mes = ConverterUtils.converteMes(dataHoje.get(dataHoje.MONTH));
			nrDiaSemana = dataHoje.get(dataHoje.DAY_OF_WEEK);
			return false;
		}
		return true;
	}
	
	/**
	 * Metodo responsavel por validar o dia e o mes em especial.
	 * Verifica se o mes de Fevereiro é maior que 28 para anos regulares e 29 para anos bissextos e se
	 * os meses que possuem 30 dias estao recebendo 
	 * 
	 * @param nrDia
	 * @param nrMes
	 * @return boolean
	 */
	private boolean isDiaMesValido(int nrDia, int nrMes) {
		if(nrDia < 0)
			return false;
		if(retornaTipoMes(nrMes) == 1 && nrDia > 28)
			return false;
		if(retornaTipoMes(nrMes) == 2 && nrDia > 29)
			return false;
		if(retornaTipoMes(nrMes) == 3 && nrDia > 30)
			return false;
		
		return true;
	}
	
	/**
	 * Metodo responsavel por verificar o tipo do mes.
	 * Se o mes de Fevereiro tem 28 ou 29 dias e se os demais meses tem 30 ou 31 dias.
	 * 
	 * @param mes
	 * @return int
	 */
	private int retornaTipoMes(int mes){
		if(mes == 1){
			if(!isBissexto())
				return 1;
			else
				return 2;
		}
		if(mes == 3 || mes == 5 || mes == 8 || mes == 10)
			return 3;
		if(mes == 0 || mes == 2 || mes == 4 || mes == 6 || mes == 7 || mes == 9 || mes == 11)
			return 4;
		return 0;
	}
	
	/**
	 * Metodo responsavel por verificar se o ano atual é bissexto.
	 * 
	 * @return boolean
	 */
	private boolean isBissexto() {
		int ano = new Integer(Calendar.getInstance().get(Calendar.YEAR));
		return (ano % 4 == 0) && ((ano < 1582) || (ano % 100 != 0) || (ano % 400 == 0));  
	}

	/**
	 * Metodo responsavel por retornar o dia e o mes
	 * 
	 * @return String
	 */
	public String getDiaMes(){
		return dia+" de "+mes;
	}
	
	/**
	 * Metodo responsavel por retornar o dia da semana, dia e mes
	 * 
	 * @return String
	 */
	public String toString(){
		return ConverterUtils.converteDiaSemana(nrDiaSemana)+", "+dia+" de "+mes;
	}
}