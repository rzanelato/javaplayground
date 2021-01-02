package logica;

import java.util.ArrayList;
import java.util.List;

public class TesteLogicaExtratoMatricula {

	public static void main(String[] args) {

		List<Long> referencias = getList();

		int referencia = 0;
		int referenciaAnt = 0;
		int idcontrato = 0;
		int idcontratoAnt = 0;
		int ordem = -1;
		int ordemAnt = -1;
		int mes = 1;
		int mesMax = 6; 
		int qtdReferencias = referencias.size();
		String aux = "";
		int parcelasRestantes = 0;


		int vlBruto = 0;
		int vlLiquido = 0;
		int vlRecebido = 0;

		for(int i = 0; i < qtdReferencias; i++){

			referencia = Integer.parseInt(referencias.get(i).toString());				    	 

			if (referencia > 6 && i == 0){
				mes += 6;
				mesMax += 6;
			}

			while(mes < referencia){
				if (referencia > 6){
					if (referencia < 10){
						aux = "0";
					}else{
						aux = "";
					}

				}else{
					aux = "0";
				}
				System.out.println("mes: "+aux+mes);
				parcelasRestantes++;
				mes++;
			}

			if (i == 0 || (idcontrato == idcontratoAnt && ordem == ordemAnt)){

				if (referencia > 6){
					if (referencia < 10){
						aux = "0";
					}else{
						aux = "";
					}
				}else{
					aux = "0";
				}

				vlBruto++;
				vlLiquido++;
				vlRecebido++;

				if(referencia == referenciaAnt)
					mes--;

				System.out.println("mes: "+aux+mes+" referencia:"+ referencia);
				
				referenciaAnt = referencia;
			}else{					 	
				parcelasRestantes++;
				mes++;
			}
			
			if(mes < mesMax && i == qtdReferencias-1){
				mes++;
				while(mes <= mesMax){
					if (referencia > 6){
						if (referencia < 10){
							aux = "0";
						}else{
							aux = "";
						}

					}else{
						aux = "0";
					}
					System.out.println("mes: "+aux+mes);

					parcelasRestantes++;
					mes++;
				}
			}
			
			if (i >= 0 && referenciaAnt != referencia && idcontratoAnt != idcontrato && ordemAnt != ordem){
				referenciaAnt = referencia;
				idcontratoAnt = idcontrato;
				ordemAnt = ordem;
			}
			mes++;
		}
		System.out.println("Restante: "+parcelasRestantes);
		System.out.println("VlBruto: "+vlBruto);
		System.out.println("vlLiquido: "+vlLiquido);
		System.out.println("vlRecebido: "+vlRecebido);

	}

	private static List<Long> getList() {
		List<Long> lista = new ArrayList<Long>();

		lista.add(new Long(7));
		lista.add(new Long(8));
		lista.add(new Long(11));
		lista.add(new Long(11));
		lista.add(new Long(11));
		lista.add(new Long(11));


		return lista;
	}

}
