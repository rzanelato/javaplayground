package linkedlist.teste;

import linkedlist.ListaLigada;

public class TestarListaLigada {

	public static void main(String[] args) {
		//adicionaNoComeco();
		//adicionarFim();
		adicionaPorPosicao();
		//pegaPorPosicao();
		//removeDoComeco();
		//removeDoFim();
		//removePorPosicao();
		//contemElemento();
		tamanho();
	}
	
	public static void adicionaNoComeco() {
		ListaLigada lista = new ListaLigada();
		lista.adicionaNoComeco("Rafael");
		lista.adicionaNoComeco("Paulo");
		lista.adicionaNoComeco("Renato");
		
		System.out.println(lista);
	}

	public static void adicionarFim() {
		ListaLigada lista = new ListaLigada();
		lista.adiciona("Rafael");
		lista.adiciona("Paulo");
		lista.adiciona("Renato");
		lista.adiciona("Zanelato");

		System.out.println(lista);
	}

	public static void adicionaPorPosicao() {
		ListaLigada lista = new ListaLigada();
		lista.adiciona("Rafael");
		lista.adiciona(0, "Paulo");
		lista.adiciona(1, "Camila");
		lista.adiciona(2, "Renato");
		lista.adiciona(1, "Zanelato");

		System.out.println(lista);
	}

	public static void pegaPorPosicao() {
		ListaLigada lista = new ListaLigada();
		lista.adiciona("Rafael");
		lista.adiciona(0, "Paulo");
		lista.adiciona(1, "Camila");
		lista.adiciona(2, "Renato");
		lista.adiciona(1, "Zanelato");
		lista.adiciona("Coelho");

		System.out.println(lista.pega(0));
		System.out.println(lista.pega(1));
		System.out.println(lista);
	}
	
	public static void removeDoComeco() {
		ListaLigada lista = new ListaLigada();
		lista.adiciona("Rafael");
		lista.adiciona(0, "Paulo");
		lista.adiciona(1, "Camila");
		lista.adiciona(2, "Renato");
		lista.adiciona(1, "Zanelato");
		lista.adiciona("Coelho");
        
        lista.removeDoComeco();
        
        System.out.println(lista);
	}
	
	public static void removeDoFim() {
		ListaLigada lista = new ListaLigada();
		lista.adiciona("Rafael");
		lista.adiciona(0, "Paulo");
		lista.adiciona(1, "Camila");
		lista.adiciona(2, "Renato");
		lista.adiciona(1, "Zanelato");
		lista.adiciona("Coelho");
        
        lista.removeDoFim();

        System.out.println(lista);
	}
	
	public static void removePorPosicao() {
		ListaLigada lista = new ListaLigada();
		lista.adiciona("Rafael");
		lista.adiciona(0, "Paulo");
		lista.adiciona(1, "Camila");
		lista.adiciona(2, "Renato");
		lista.adiciona(1, "Zanelato");
		lista.adiciona("Coelho");
		
		lista.remove(1);

		System.out.println(lista);
	}
	
	public static void contemElemento() {
		ListaLigada lista = new ListaLigada();
		lista.adiciona("Rafael");
		lista.adiciona(0, "Paulo");
		lista.adiciona(1, "Camila");
		lista.adiciona(2, "Renato");
		lista.adiciona(1, "Zanelato");
		lista.adiciona("Coelho");
		
		System.out.println(lista.contem("Rafael"));
		System.out.println(lista.contem("Camila"));
		System.out.println(lista.contem("Pedro"));
	}
	
	public static void tamanho() {
		ListaLigada lista = new ListaLigada();
		lista.adiciona("Rafael");
		lista.adiciona(0, "Paulo");
		lista.adiciona(1, "Camila");
		lista.adiciona(2, "Renato");
		lista.adiciona(1, "Zanelato");
		lista.adiciona("Coelho");
        
        System.out.println(lista.tamanho());
        lista.adiciona("Camila");
        
        System.out.println(lista.tamanho());
	}

}