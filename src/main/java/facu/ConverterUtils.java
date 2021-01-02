package facu;

/**
 * 
 * @author Grupo TCC
 * 
 * Classe util para converter numero, data, hora e dia da semana
 *
 */
public class ConverterUtils {

	/**
	 * Metodo responsavel por converter o numero de String para int 
	 * 
	 * @param numero
	 * @return int
	 */
	public static int converteNumero(String numero) {
		if (numero.equals("primeiro") || numero.equals("um"))
			return 1;
		if (numero.equals("dois"))
			return 2;
		if (numero.equals("tres"))
			return 3;
		if (numero.equals("quatro"))
			return 4;
		if (numero.equals("cinco"))
			return 5;
		if (numero.equals("seis"))
			return 6;
		if (numero.equals("sete"))
			return 7;
		if (numero.equals("oito"))
			return 8;
		if (numero.equals("nove"))
			return 9;
		if (numero.equals("dez"))
			return 10;
		if (numero.equals("onze"))
			return 11;
		if (numero.equals("doze"))
			return 12;
		if (numero.equals("treze"))
			return 13;
		if (numero.equals("quatorze"))
			return 14;
		if (numero.equals("quinze"))
			return 15;
		if (numero.equals("dezesseis"))
			return 16;
		if (numero.equals("dezessete"))
			return 17;
		if (numero.equals("dezoito"))
			return 18;
		if (numero.equals("dezenove"))
			return 19;
		if (numero.equals("vinte"))
			return 20;
		if (numero.equals("vinte e um"))
			return 21;
		if (numero.equals("vinte e dois"))
			return 22;
		if (numero.equals("vinte e tres"))
			return 23;
		if (numero.equals("vinte e quatro"))
			return 24;
		if (numero.equals("vinte e cinco"))
			return 25;
		if (numero.equals("vinte e seis"))
			return 26;
		if (numero.equals("vinte e sete"))
			return 27;
		if (numero.equals("vinte e oito"))
			return 28;
		if (numero.equals("vinte e nove"))
			return 29;
		if (numero.equals("trinta"))
			return 30;
		if (numero.equals("trinta e um"))
			return 31;
		if (numero.equals("trinta e dois"))
			return 32;
		if (numero.equals("trinta e tres"))
			return 33;
		if (numero.equals("trinta e quatro"))
			return 34;
		if (numero.equals("trinta e cinco"))
			return 35;
		if (numero.equals("trinta e seis"))
			return 36;
		if (numero.equals("trinta e sete"))
			return 37;
		if (numero.equals("trinta e oito"))
			return 38;
		if (numero.equals("trinta e nove"))
			return 39;
		if (numero.equals("quarenta"))
			return 40;
		if (numero.equals("quarenta e um"))
			return 41;
		if (numero.equals("quarenta e dois"))
			return 42;
		if (numero.equals("quarenta e tres"))
			return 43;
		if (numero.equals("quarenta e quatro"))
			return 44;
		if (numero.equals("quarenta e cinco"))
			return 45;
		if (numero.equals("quarenta e seis"))
			return 46;
		if (numero.equals("quarenta e sete"))
			return 47;
		if (numero.equals("quarenta e oito"))
			return 48;
		if (numero.equals("quarenta e nove"))
			return 49;
		if (numero.equals("cinquenta"))
			return 50;
		if (numero.equals("cinquenta e um"))
			return 51;
		if (numero.equals("cinquenta e dois"))
			return 52;
		if (numero.equals("cinquenta e tres"))
			return 53;
		if (numero.equals("cinquenta e quatro"))
			return 54;
		if (numero.equals("cinquenta e cinco"))
			return 55;
		if (numero.equals("cinquenta e seis"))
			return 56;
		if (numero.equals("cinquenta e sete"))
			return 57;
		if (numero.equals("cinquenta e oito"))
			return 58;
		if (numero.equals("cinquenta e nove"))
			return 59;
		
		return -1;
	}
	
	/**
	 * Metodo responsavel por converter o dia de int para String (Extenso) 
	 * 
	 * @param dia
	 * @return String
	 */
	public static String converteDia(int dia) {
		if (dia == 1)
			return "primeiro";
		if (dia == 2)
			return "dois";
		if (dia == 3)
			return "tres";
		if (dia == 4)
			return "quatro";
		if (dia == 5)
			return "cinco";
		if (dia == 6)
			return "seis";
		if (dia == 7)
			return "sete";
		if (dia == 8)
			return "oito";
		if (dia == 9)
			return "nove";
		if (dia == 10)
			return "dez";
		if (dia == 11)
			return "onze";
		if (dia == 12)
			return "doze";
		if (dia == 13)
			return "treze";
		if (dia == 14)
			return "quatorze";
		if (dia == 15)
			return "quinze";
		if (dia == 16)
			return "dezesseis";
		if (dia == 17)
			return "dezessete";
		if (dia == 18)
			return "dezoito";
		if (dia == 19)
			return "dezenove";
		if (dia == 20)
			return "vinte";
		if (dia == 21)
			return "vinte e um";
		if (dia == 22)
			return "vinte e dois";
		if (dia == 23)
			return "vinte e tres";
		if (dia == 24)
			return "vinte e quatro";
		if (dia == 25)
			return "vinte e cinco";
		if (dia == 26)
			return "vinte e seis";
		if (dia == 27)
			return "vinte e sete";
		if (dia == 28)
			return "vinte e oito";
		if (dia == 29)
			return "vinte e nove";
		if (dia == 30)
			return "trinta";
		if (dia == 31)
			return "trinta e um";
		
		return null;
	}
	
	/**
	 * Metodo responsavel por converter o mes de String para int 
	 * 
	 * @param mes
	 * @return int
	 */
	public static int converteMes(String mes) {
		if (mes.equals("janeiro"))
			return 0;
		if (mes.equals("fevereiro"))
			return 1;
		if (mes.substring(0,3).equals("mar"))
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
	
	/**
	 * Metodo responsavel por converter o mes de int para String 
	 * 
	 * @param mes
	 * @return String
	 */
	public static String converteMes(int mes) {
		if (mes == 0)
			return "janeiro";
		if (mes == 1)
			return "fevereiro";
		if (mes == 2)
			return "março";
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
		
		return null;
	}
	
	/**
	 * Metodo responsavel por converter o dia da semana de int para String
	 * 
	 * @param mes
	 * @return String
	 */
	public static String converteDiaSemana(int mes) {
		if (mes == 1)
			return "domingo";
		if (mes == 2)
			return "segunda feira";
		if (mes == 3)
			return "terça feira";
		if (mes == 4)
			return "quarta feira";
		if (mes == 5)
			return "quinta feira";
		if (mes == 6)
			return "sexta feira";
		if (mes == 7)
			return "sabado";
		
		return null;
	}

	/**
	 * Metodo responsavel por converter o hora de int para String (Extenso) 
	 * 
	 * @param hora
	 * @return int
	 */
	public static int converteHora(String hora) {
		if (hora.equals("zero"))
			return 0;
		if (hora.equals("uma"))
			return 1;
		if (hora.equals("dois"))
			return 2;
		if (hora.equals("tres"))
			return 3;
		if (hora.equals("quatro"))
			return 4;
		if (hora.equals("cinco"))
			return 5;
		if (hora.equals("seis"))
			return 6;
		if (hora.equals("sete"))
			return 7;
		if (hora.equals("oito"))
			return 8;
		if (hora.equals("nove"))
			return 9;
		if (hora.equals("dez"))
			return 10;
		if (hora.equals("onze"))
			return 11;
		if (hora.equals("doze"))
			return 12;
		if (hora.equals("treze"))
			return 13;
		if (hora.equals("quatorze"))
			return 14;
		if (hora.equals("quinze"))
			return 15;
		if (hora.equals("dezeseis"))
			return 16;
		if (hora.equals("dezessete"))
			return 17;
		if (hora.equals("dezoito"))
			return 18;
		if (hora.equals("dezenove"))
			return 19;
		if (hora.equals("vinte"))
			return 20;
		if (hora.equals("vinte e uma"))
			return 21;
		if (hora.equals("vinte e duas"))
			return 22;
		if (hora.equals("vinte e tres"))
			return 23;
		if (hora.equals("vinte e quatro"))
			return 24;
		
		return -1;
	}
}
