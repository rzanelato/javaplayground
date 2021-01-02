package logica;

import java.util.Calendar;

public class TesteLogicaCiclos {
	
	public static void main(String[] args) throws Exception {
		IncluirTurma turmaIngresso = new IncluirTurma();
		
		turmaIngresso.setNrAno(2010);
		turmaIngresso.setNrSemestre("2");
		turmaIngresso.setCdTurma("1");
		
		
		
		int ano = (turmaIngresso.getNrAno()).intValue();
		int anoIni = (turmaIngresso.getNrAno()).intValue(); 
		int nr_turma = (new Long(turmaIngresso.getCdTurma()).intValue());
		int qtdCiclos = getCiclos();
		int ocorrenciasAno = getOcorrenciasPorAno();
		Calendar dataInicio = Calendar.getInstance();
		//dataInicio.set(2010,11,30);
		int ciclo = getCicloAtual(ocorrenciasAno, dataInicio);

		int countSemestre = Integer.parseInt(turmaIngresso.getNrSemestre());
		int countSemestreIni = Integer.parseInt(turmaIngresso.getNrSemestre());
		int countTurma = 1;

		while(countTurma <= nr_turma) {
			turmaIngresso.setCdTurma(String.valueOf(countTurma));
			for(int periodo = 1; periodo <= qtdCiclos; periodo++) {
				turmaIngresso.setNrPeriodo(String.valueOf(periodo));
				turmaIngresso.setNumeroCiclo(ciclo);
				turmaIngresso.setNrAno(new Integer(ano));
				turmaIngresso.setNrSemestre(getSemestreCiclo(ciclo, ocorrenciasAno));
				
				if(ciclo == ocorrenciasAno){
					ciclo = 1;
					ano++;
				}else{
					ciclo++;
				}

				turmaIngresso.toSting();
				
				++countSemestre;
			}
			++countTurma;
			countSemestre = countSemestreIni;
			ano = anoIni;
		}
	}
	
	private static String getSemestreCiclo(int ciclo, int ocorrenciasAno) {
		Float ocorrenciasFloat = new Float(ocorrenciasAno);
		Integer resultado = Math.round(ocorrenciasFloat/2);
		
		boolean isPrimeiroSemestre = (ciclo <= resultado);
		
		if(isPrimeiroSemestre)
			return "1";
		else
			return "2";
	}

	private static Integer getCiclos() throws Exception{
		return 10;
    }
	
	private static Integer getOcorrenciasPorAno() throws Exception{
		return 52;
    }
	
	private static Integer getCicloAtual(final Integer numeroOcorrenciasAno, final Calendar dataInicio){
		if(numeroOcorrenciasAno <= 12 && numeroOcorrenciasAno != 0)
			return getCicloNormal(numeroOcorrenciasAno, dataInicio);

		if(numeroOcorrenciasAno == 24)
			return getCicloQuinzenal(dataInicio);

		if(numeroOcorrenciasAno == 52)
			return getCicloSemanal(dataInicio);

		return 1;
	}
	
	private static Integer getCicloQuinzenal(final Calendar dataInicio) {
		Float semanaAno = new Float(dataInicio.get(Calendar.WEEK_OF_YEAR));
		Float quinzenaAno = semanaAno/2;
		System.out.println("quinzena: "+quinzenaAno);

		return Math.round(quinzenaAno);

	}

	private static Integer getCicloSemanal(final Calendar dataInicio) {
		System.out.println("Semana: "+dataInicio.get(Calendar.WEEK_OF_YEAR));
		return dataInicio.get(Calendar.WEEK_OF_YEAR);
	}

	private static Integer getCicloNormal(final Integer numeroOcorrenciasAno, final Calendar dataInicio) {
		int numeroMesesAno = 12;
		int mes = dataInicio.get(Calendar.MONTH)+1;
		int qtdeMesesOcorrePorAno = numeroMesesAno/numeroOcorrenciasAno;
		int ciclo = 1;
		int countMeses = 1;
		
		for(int mesAno = 0; mesAno <= numeroMesesAno; mesAno++){
			boolean isMesAnoIgualMesEscolhido = (mesAno == mes); 
			if(isMesAnoIgualMesEscolhido)
				break;
			
			if(countMeses == qtdeMesesOcorrePorAno){
				ciclo++;
				countMeses = 1;
			}else{
				countMeses++;
			}
		}
		return ciclo;
	}
	
	static class IncluirTurma {
		private String  cdTurma;
		private Integer nrAno;
		private String  nrSemestre;
		private String  nrPeriodo;
		private Integer numeroCiclo;
		
		public String getCdTurma() {
			return cdTurma;
		}
		public Integer getNrAno() {
			return nrAno;
		}
		public String getNrSemestre() {
			return nrSemestre;
		}
		public String getNrPeriodo() {
			return nrPeriodo;
		}
		public Integer getNumeroCiclo() {
			return numeroCiclo;
		}
		public void setCdTurma(String cdTurma) {
			this.cdTurma = cdTurma;
		}
		public void setNrAno(Integer nrAno) {
			this.nrAno = nrAno;
		}
		public void setNrSemestre(String nrSemestre) {
			this.nrSemestre = nrSemestre;
		}
		public void setNrPeriodo(String nrPeriodo) {
			this.nrPeriodo = nrPeriodo;
		}
		public void setNumeroCiclo(Integer numeroCiclo) {
			this.numeroCiclo = numeroCiclo;
		}
		
		public void toSting(){
			System.out.println("cdTurma = "+cdTurma+ ", nrAno = "+nrAno+", nrSemestre = "+nrSemestre+", nrPeriodo = "+ nrPeriodo+ ", nrCiclo = "+ numeroCiclo );
		}
	}

}
