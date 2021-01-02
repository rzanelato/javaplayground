package linkedlist.teste;

import linkedlist.LinkedList;
import linkedlist.PersonOne;

public class TestLinkedList {

	public static void main(String[] args) {
		//addFirst();
		//addLast();
		//addByIndex();
		//getByIndex();
		//removeFirst();
		//removeLast();
		//removeByIndex();
		//containsElement();
		//size();
		test();
	}
	
	public static void test() {
		LinkedList list = new LinkedList();
		PersonOne person1 = new PersonOne();
		person1.setFirstName("Rafael");
		PersonOne person2 = new PersonOne();
		person2.setFirstName("Paulo");
		PersonOne person3 = new PersonOne();
		person3.setFirstName("Renato");
		PersonOne person4 = new PersonOne();
		person4.setFirstName("Zanelato");
		list.add(person1);
		list.add(person2);
		list.add(person3);
		list.add(person4);
		
		System.out.println(list);
	}
	
	public static void addFirst() {
		LinkedList lista = new LinkedList();
		lista.addFirst("Rafael");
		lista.addFirst("Paulo");
		lista.addFirst("Renato");
		
		System.out.println(lista);
	}

	public static void addLast() {
		LinkedList lista = new LinkedList();
		lista.add("Rafael");
		lista.add("Paulo");
		lista.add("Renato");
		lista.add("Zanelato");

		System.out.println(lista);
	}

	public static void addByIndex() {
		LinkedList lista = new LinkedList();
		lista.add("Rafael");
		lista.add(0, "Paulo");
		lista.add(1, "Camila");
		lista.add(2, "Renato");
		lista.add(1, "Zanelato");

		System.out.println(lista);
	}

	public static void getByIndex() {
		LinkedList lista = new LinkedList();
		lista.add("Rafael");
		lista.add(0, "Paulo");
		lista.add(1, "Camila");
		lista.add(2, "Renato");
		lista.add(1, "Zanelato");
		lista.add("Coelho");

		System.out.println(lista.get(0));
		System.out.println(lista.get(1));
		System.out.println(lista);
	}
	
	public static void removeFirst() {
		LinkedList lista = new LinkedList();
		lista.add("Rafael");
		lista.add(0, "Paulo");
		lista.add(1, "Camila");
		lista.add(2, "Renato");
		lista.add(1, "Zanelato");
		lista.add("Coelho");
        
        lista.removeFirst();
        
        System.out.println(lista);
	}
	
	public static void removeLast() {
		LinkedList lista = new LinkedList();
		lista.add("Rafael");
		lista.add(0, "Paulo");
		lista.add(1, "Camila");
		lista.add(2, "Renato");
		lista.add(1, "Zanelato");
		lista.add("Coelho");
        
        lista.removeLast();

        System.out.println(lista);
	}
	
	public static void removeByIndex() {
		LinkedList lista = new LinkedList();
		lista.add("Rafael");
		lista.add(0, "Paulo");
		lista.add(1, "Camila");
		lista.add(2, "Renato");
		lista.add(1, "Zanelato");
		lista.add("Coelho");
		
		lista.remove(1);

		System.out.println(lista);
	}
	
	public static void containsElement() {
		LinkedList lista = new LinkedList();
		lista.add("Rafael");
		lista.add(0, "Paulo");
		lista.add(1, "Camila");
		lista.add(2, "Renato");
		lista.add(1, "Zanelato");
		lista.add("Coelho");
		
		/*
		System.out.println(lista.contains("Rafael"));
		System.out.println(lista.contains("Camila"));
		System.out.println(lista.contains("Pedro"));
		*/
	}
	
	public static void size() {
		LinkedList lista = new LinkedList();
		lista.add("Rafael");
		lista.add(0, "Paulo");
		lista.add(1, "Camila");
		lista.add(2, "Renato");
		lista.add(1, "Zanelato");
		lista.add("Coelho");
        
        System.out.println(lista.size());
        lista.add("Camila");
        
        System.out.println(lista.size());
	}

}