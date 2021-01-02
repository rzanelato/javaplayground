package linkedlist;

public class MyLinkedList {

	private Person first;
	private Person last;
	private int peopleCount;

	public MyLinkedList() {
		first = null;
		last = null;
		peopleCount = 0;
	}

	public int add(Person person) {
		if(first == null) {
			first = person;
			last = first;
			peopleCount++;
		} else {
			if (person.getPriority() == 1) {
				int position = 1;
				Person currentPerson = first;
				boolean positionFound = false;
				do {
					if (currentPerson.getPriority() == 1) {
						currentPerson = currentPerson.getNextPerson();
						position += 1;
					} else {
						insert(person, position);
						positionFound = true;
					}

				} while (!positionFound);

			} else if (person.getPriority() == 2) {
				int position = 1;
				Person currentPerson = first;
				boolean positionFound = false;

				do {
					if (currentPerson.getPriority() == 1 || currentPerson.getPriority() == 2) {
						currentPerson = currentPerson.getNextPerson();
						position += 1;
					} else {
						insert(person, position);
						positionFound = true;
					}
				} while (!positionFound);

			} else if (person.getPriority() == 3) {
				last.setNextPerson(person);
				last = person;
				peopleCount++;
			}
		}
		
		return person.getId();
	}

	// First person has index 0. If we want to add someone in the 3rd position, we want to put it in index 2
	// For that we stand on person with index 1
	public int insert(Person person, int position) {
		if(size() < position) {
			throw new IllegalStateException("The queue is smaller than the position you are trying to insert at: " + position);
		}
		if (position <= 0) {
			throw new IllegalStateException("You can't insert in anyone in a position lower than 1");
		}
		if (position == 1) {
			person.setNextPerson(first);
			first = person;
			peopleCount++;
		} else {
			Person currentPerson = first;

			for(int i = 1; i < position - 1 && currentPerson != null; i++) {
				currentPerson = currentPerson.getNextPerson();
			}

			Person nextPerson = currentPerson.getNextPerson();
			currentPerson.setNextPerson(person);
			person.setNextPerson(nextPerson);
			peopleCount++;
		}
		
		return person.getId();
	}

	//TODO Troquei por void pq nao faz muito sentido ter um retorno.
	public void removeAt(int position) {
		if(first == null) {
			throw new IllegalStateException("The LinkedList is empty and there are no items to remove");
		}
		if (position <= 0) {
			throw new IllegalStateException("You can't delete a position lower than 1");
		}
		if (position == 1) {
			first = first.getNextPerson();
			peopleCount--;
		
		} else {
			Person currentPerson = first;
			Person prevPerson = first;

			for(int i = 1; i < position && currentPerson != null; i++) {
				prevPerson = currentPerson;
				currentPerson = currentPerson.getNextPerson();
			}

			prevPerson.setNextPerson(currentPerson.getNextPerson());
			peopleCount--;
		}
	}

	//TODO Metodo alterado para void pq pra remover vc nao precisa ou nao deveria devolver item.
	public void remove() {
		if(first == null) {
			throw new IllegalStateException("The LinkedList is empty and there are no items to remove");
		}
		first = first.getNextPerson();
		peopleCount--;
		
		//TODO Tranks, adicionado isso pra ele quando remover o item, ele limpar o lest caso seja o ultimo item.
		if (peopleCount == 0) {
			last = null;
		}
	}
	
	//TODO metodo para remover as ultimas pessoas
	public void removeManyLast(int quantity) {
		if(quantity > peopleCount) {
			throw new IllegalStateException("The LinkedList there is less than "+quantity+" elements.");
		}
		for (int i = 0; i < quantity; i++) {
			removeLast();
		}
	}
	
	//TODO Metodo de remover o ultimo.
	private void removeLast() {
		int beforLastPersonPosition = peopleCount - 1;
		boolean isPositionLast = beforLastPersonPosition >= 0 && beforLastPersonPosition < peopleCount;
		if(!isPositionLast) {
			throw new IllegalStateException("The LinkedList is empty and there are no items to remove");
		}
		if (peopleCount == 1) {
			remove();
		} else {
			Person beforeLast = get(beforLastPersonPosition);
			beforeLast.setNextPerson(null);
			last = beforeLast;
			peopleCount--;
		} 
	}

	public Person get(int position) {
		if(first == null) {
			throw new IllegalStateException("The LinkedList is empty and there are no items to get");
		}

		Person currentPerson = first;
		for(int i = 1; i < size() && currentPerson != null; i++) {
			if(i == position) {
				return currentPerson;
			}
			currentPerson = currentPerson.getNextPerson();
		}

		//if we didn't find it then return null
		return null;
	}

	//TODO adicionado para buscar a pessoa pelo ID.
	public Person getById(int id) {
		Person current = first;
		while (current != null) {
			if (current.getId() == id) {
				return current;
			}
			current = current.getNextPerson();
		}
		return current;
	}
	
	//TODO pegar a posicao da pessoa buscando pela pessoa.
	public int getPosition(Person person) {
		int position = 1;
		Person current = first;
		while (current != null) {
			if (current.equals(person)) {
				return position;
			}
			current = current.getNextPerson();
			position++;
		}
		return position;
	}
	
	public int find(int id) {
		if(first == null) {
			throw new IllegalStateException("The LinkedList is empty and there are no items to find");
		}

		Person currentPerson = first;
		for(int i = 0; i < size() && currentPerson != null; i++) {
			if(currentPerson.getId() == id) {
				return i + 1;
			}

			currentPerson = currentPerson.getNextPerson();
		}

		//if we didn't find it, then return -1
		return -1;
	}

	//useful for pretty print
	public String FullList() {
		if(first == null) {
			return "The list is empty";
		}
		else {
			int i = 1;
			String fullList = "";
			Person currentPerson = first;
			do {
				fullList += "Position: " + i + "\n";
				fullList += "ID: " + currentPerson.getId() + "\n";
				fullList += "Full Name: " + currentPerson.getName() +" "+ currentPerson.getSurname() + "\n";
				fullList += "Passport: " + currentPerson.getPassport() + "\n";
				fullList += "Priority: " + currentPerson.getPriority() + "\n \n";

				currentPerson = currentPerson.getNextPerson();
				i++;
			} while (i <= size());
			return fullList;
		}

	}

	//create a method to cut off the list

	//create a method to modify the info of the person

	public Person getLast() {
		return last;
	}

	public int size(){
		return peopleCount;
	}


}
