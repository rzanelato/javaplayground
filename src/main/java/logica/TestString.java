package logica;

import java.util.ArrayList;
import java.util.List;

import pojo.Testando;

public class TestString {
	
	public static void main(String[] args) {
		stringIsEmpty();
		/*
		String cood = "53"; 
		String formato = generaGDD(cood);
		
		System.out.println(formato);
		
		testeStringNull();
		
		//testeLogicaObj();
		
		//List<String> lista = new ArrayList<String>();
		//lista.add(new String());
		List<String> lista = null;
		System.out.println((lista == null || lista.isEmpty()));
		*/
		
		
	}
	
	private static void testeLogicaObj(){
		int escenario = 2;
		int max = 8;
		List<Testando> listMatrizNeutro = rellenaList();
		List<Testando> listMatrizPrimeroEscenario = new ArrayList<Testando>();
		
		escenario = doListaMatrizPrimeroEscenario(listMatrizNeutro, escenario, max, listMatrizPrimeroEscenario);
		
		System.out.println("ListaNova: "+ listMatrizPrimeroEscenario.isEmpty());
		System.out.println("Escenario: "+ escenario);
		for (Testando testando : listMatrizPrimeroEscenario) {
			System.out.println(listMatrizPrimeroEscenario.indexOf(testando)+": "+testando.getNumber());
		}
		
		System.out.println();
		System.out.println("ListaNeutra:");
		for (Testando testando : listMatrizNeutro) {
			System.out.println(listMatrizNeutro.indexOf(testando)+": "+testando.getNumber());
		}
		
	}
	
	private static List<Testando> rellenaList() {
		List<Testando> lista = new ArrayList<Testando>();
		Testando teste1 = new Testando();
		teste1.setNumber(2);
		lista.add(teste1);
		
		Testando teste2 = new Testando();
		teste2.setNumber(2);
		lista.add(teste2);
		
		Testando teste3 = new Testando();
		teste3.setNumber(2);
		lista.add(teste3);
		
		Testando teste4 = new Testando();
		teste4.setNumber(2);
		lista.add(teste4);
		
		Testando teste5 = new Testando();
		teste5.setNumber(2);
		lista.add(teste5);
		Testando teste6 = new Testando();
		teste6.setNumber(2);
		lista.add(teste6);
		
		return lista;
	}

	private static Integer doListaMatrizPrimeroEscenario(
			List<Testando> listMatrizNeutro, int intEscenario,int max,
			List<Testando> listMatrizPrimeroEscenario) {
		
		for (Testando neutro: listMatrizNeutro) {
			if (neutro.getNumber().intValue() == intEscenario) {
				listMatrizPrimeroEscenario.add(neutro);
			}
		}
		if (listMatrizPrimeroEscenario.isEmpty()) {
			if(intEscenario <= max) {
				intEscenario = doListaMatrizPrimeroEscenario(listMatrizNeutro, ++intEscenario, max, listMatrizPrimeroEscenario);
			}
		} else {
			for (Testando neutro: listMatrizPrimeroEscenario) {
				listMatrizNeutro.remove(neutro);
			}
		}
		return intEscenario;
		
	}
	
	
	public static void testeStringNull() {
		Testando teste = new Testando();
		teste.setValue(null);
		if("valor".equals(teste.toString())) {
			System.out.println("OK");
		} else {
			System.out.println("NULL");
		}
	}
	
	public static String generaGDD(String numCoordina){
		
		return "C"+String.format("%014d", Long.parseLong(numCoordina));
	}
	
	public static void testeString(){
		String str = null;
		Testando test = null;
		Number num = null;
		System.out.println("String = "+ str);
		System.out.println("Testando = "+ test);
		System.out.println("Number = "+ num);
		
	}
	
	public static void stringIsEmpty() {
		String branco = " ";
		String nula = null;
		System.out.println("Branco: "+branco.trim().isEmpty());
		//System.out.println("Nulo: "+nula.isEmpty());
		
	}

}
