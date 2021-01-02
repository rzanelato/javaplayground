package facu;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * 
 * @author Grupo TCC
 *
 */
public class ValidaHorario {
	/**
	 * Variavel String de controle do dia.
	 */
	private String hora;
	
	/**
	 * Variavel String de controle do mes.
	 */
	private String minuto;
	
	/**
	 * Variavel String de controle do dia e mes
	 */
	private String diaMes;
	
	/**
	 * Construtor da classe ValidaHorario
	 * 
	 * @param hora
	 * @param minuto
	 * @param diaMes
	 */
	public ValidaHorario(String hora, String minuto, String diaMes){
		this.hora = hora;
		this.minuto = minuto;
		this.diaMes = diaMes;
	}

	/**
	 * Metodo responsavel por executar o processo de verificacao do horario.
	 * 
	 * @throws Exception
	 */
	public void executar() throws Exception{
		//Verifica se é o dia atual para fazer a validacao do horario
		if(isDataDeHoje()){
			//Verifica se a hora foi dita
			if(!hora.equals("ndefine")){
				//Converte hora e minuto de palavra (por extenso) para numero
				int nrHora = ConverterUtils.converteHora(hora);
				int nrMinuto = 0;
				//Verifica se o minuto foi dita
				if(!minuto.equals("ndefine"))
					nrMinuto = ConverterUtils.converteNumero(minuto);
			
				//Verifica se o horario é valido
				if(isHoraMinutoInValido(nrHora,nrMinuto)){
					throw new Exception("invalido");
				}
			}
		}
	}
	
	/**
	 * Metodo responsavel por verificar se a data escolhida é a de hoje
	 * 
	 * @return boolean
	 */
	private boolean isDataDeHoje() {
		//Separa o dia e mes que esta escrito por extenso
		String strDia = diaMes.substring(0, diaMes.indexOf(" de "));
		String aux = diaMes.substring(diaMes.indexOf(" de "), diaMes.length());
		String strMes = aux.substring(4, aux.length());
		
		//Converte dia e mes de palavra (por extenso) para numero
		int nrDia = ConverterUtils.converteNumero(strDia);
		int nrMes = ConverterUtils.converteMes(strMes);
		
		//Dia atual
		Calendar dataAtual = GregorianCalendar.getInstance();
		//Data escolhida
		Calendar dataEscolhida = new GregorianCalendar();
		dataEscolhida.set(dataAtual.get(Calendar.YEAR), nrMes, nrDia);
		
		//compara se o dia escolhido é o mesmo que o dia atual
		if(dataEscolhida.compareTo(dataAtual) == 0)
			return true;
		
		return false;
	}
	
	/**
	 * M�todo responsavel por verificar se a hora e minuto sao invalidos.
	 * 
	 * @return boolean
	 */
	private boolean isHoraMinutoInValido(int hora, int minuto) {
		Calendar dataAtual = GregorianCalendar.getInstance();
		//Cria dia e hora escolhido para fazer validacao
		Calendar dataEscolhida = new GregorianCalendar();
		dataEscolhida.set(dataAtual.get(Calendar.YEAR), dataAtual.get(Calendar.MONTH), dataAtual.get(Calendar.DAY_OF_MONTH), hora, minuto);
		
		//Verifica se a hora é anterior a hora atual
		if(dataEscolhida.before(dataAtual))
			return true;
		
		return false;
	}
	
	/**
	 * Metodo responsavel por retornar a hora e minuto por extenso
	 * 
	 * @return String
	 */
	public String toString(){
		String retorno = "";
		if(hora.equals("uma")){
			retorno = "a "+hora + " hora ";
		}else{
			retorno = "as "+hora + " horas ";
		}
		if(!minuto.equals("ndefine")){
			if(minuto.equals("um")){
				retorno += "e " + minuto + " minuto.";
			}else{
				retorno += "e " + minuto + " minutos.";
			}
		}
		return retorno;
	}
}