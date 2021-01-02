package linkedlist;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	MyLinkedList inmigrationList;
	String name;
	String surname;
	int passport;
	int priority;

	public static void main(String[] args) {
		
		new Main();

	}
	
	public Main() {
		inmigrationList = new MyLinkedList();
		//TODO alimentando dinamicamente pra fazer os testes mais rapido.
		inmigrationList.add(new Person("Renato", "Renato", 111, 3));
		inmigrationList.add(new Person("Pedro", "Pedro", 222, 3));
		inmigrationList.add(new Person("Jack", "Jack", 333, 3));
		inmigrationList.add(new Person("Rob", "Rob", 444, 3));
		inmigrationList.add(new Person("Elias", "Elias", 555, 3));
		inmigrationList.add(new Person("Maria", "Maria", 666, 3));
		menu();
		
	}
	
	public void menu() {
		
		boolean stillHere = true;
		
		do {
			System.out.println("Welcome to Immigration");
			System.out.println("What do you want to do?");
			System.out.println("1) Add a new person to the list"); // Done
			System.out.println("2) Check position of a person"); // Done
			System.out.println("3) Add a new person to the list in a particular position"); // Done
			System.out.println("4) Remove someone from the list"); //Done
			System.out.println("5) Cut off the list");
			System.out.println("6) Update information on one person");
			System.out.println("7) To print the whole list");
			System.out.println("8) To close the program");
			
			String optionSelected = askingUser();
			
			if (optionSelected.equals("1")) {
				addingPerson();
			}
			else if (optionSelected.equals("2")) {
				checkPosition();
			}
			else if (optionSelected.equals("3")) {
				addingPersonInPosition();
			}
			else if (optionSelected.equals("4")) {
				removingPerson();
			}
			else if (optionSelected.equals("5")) {
				//System.out.println("5 selected"); // include a method in this class that calls another method in inmigrationList
				cuttingOff();
			}
			else if (optionSelected.equals("6")) {
				System.out.println("6 selected"); // include a method that ask for the id of the person that we want to modify
													// and asks the information to modify
				updatingPerson();
			}
			else if (optionSelected.equals("7")) {
				System.out.println(inmigrationList.FullList());
			}
			else if (optionSelected.equals("8")) {
				stillHere = false;
			}
			else {
				System.out.println("Please select a valid option");
			}
			
		} while (stillHere);
		
	}
	
	public String askingUser() {
		
		String answer = "";
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		try {
			answer = br.readLine();
			
		} catch (Exception e) {}
		
		return answer;
	}
	
	public void addingPerson() {
		collectingData();		
		int newId = inmigrationList.add(new Person(name, surname, passport, priority));
		System.out.println("The ID of the new person is " + newId);
		
	}
	
	public void checkPosition() {
		System.out.println("What is the id of the new person?");
		
		//Validation
		int id = Integer.parseInt(askingUser());
		System.out.println("The person with the ID " + id + " is in position " + inmigrationList.find(id));
		
	}
	
	public void addingPersonInPosition() {
		collectingData();
		
		System.out.println("What position do you want to put the person on?");
		
		//Validation
		int position = Integer.parseInt(askingUser());
		
		try {
			int newId = inmigrationList.insert(new Person(name, surname, passport, priority), position);
			System.out.println("The ID of the new person is " + newId);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public void removingPerson() {
		System.out.println("What is the id of the person to remove?");
		
		//Validation
		int id = Integer.parseInt(askingUser());
		try {
			inmigrationList.removeAt(inmigrationList.find(id));
			System.out.println("The person has been removed");
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	//TODO Tranks, esse é o metodo de remover.
	public void cuttingOff() {
		System.out.println("What is many of last people do you want to remove?");

		int quantity = Integer.parseInt(askingUser());
		inmigrationList.removeManyLast(quantity);
	}
	
	//TODO atualizar a pessoa pelo ID.
	public void updatingPerson() {
		//fazer um menu para perguntar qual informacao ele quer alterar, nome, passaporte, sobrenome igual aos menus que faz normalmente.
		//meu exemplo esta simplificado para refazer o usuario inteiro.
		System.out.println("What is the id of the person to update?");
		int id = Integer.parseInt(askingUser());
		Person updatedPerson = inmigrationList.getById(id);
		int position = inmigrationList.getPosition(updatedPerson);
		collectingData();
		updatedPerson.setName(name);
		updatedPerson.setSurname(surname);
		updatedPerson.setPassport(passport);
		updatedPerson.setPriority(priority);
		//removo a pessoa pela posicao e adiciono de volta com o mesmo ID e posicao de antes.
		inmigrationList.removeAt(position);
		inmigrationList.insert(updatedPerson, position);
	}
	
	public void collectingData() {
		System.out.println("What is the name of the person?");
		name = askingUser();
		System.out.println("What is the surname of the person?");
		surname = askingUser();
		System.out.println("What is the passport number of the person?");
		
		// Do some validation here
		passport = Integer.parseInt(askingUser());
		
		System.out.println("What's the priority for the new person?");
		System.out.println("1) Top priority - People with children under 1 year");
		System.out.println("2) Medium priority - Peeple with disability");
		System.out.println("3) Nomal priority - General Public");
		
		priority = Integer.parseInt(askingUser());
	}
	

}
