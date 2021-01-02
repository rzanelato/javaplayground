package linkedlist;

public class LinkedList {

	private Node first;
	private Node last;
	private int totalElements;

	public void add(Object element) {
		if (this.totalElements == 0) {
			this.addFirst(element);
		} else {
			Node newElement = new Node(element);
			this.last.setNext(newElement);
			newElement.setPrevious(this.last);
			this.last = newElement;
			this.totalElements++;
		}
	}

	public void add(int index, Object element) {
		if(index == 0) { 
			this.addFirst(element);
		} else if(index == this.totalElements) {
			this.add(element);
		} else {
			Node previous = this.getNode(index - 1);
			Node next = previous.getNext();
			Node newElement = new Node(previous.getNext(), element);
			newElement.setPrevious(previous);
			previous.setNext(newElement);
			next.setPrevious(newElement);
			this.totalElements++;
		}
	}

	public void addFirst(Object element) {
		if(this.totalElements == 0){
			Node newElement = new Node(element);
			this.first = newElement;
			this.last = newElement;
		} else {
			Node newElement = new Node(this.first, element);
			this.first.setPrevious(newElement);
			this.first = newElement;
		}
		this.totalElements++;
	}

	public Object get(int index) {
		return this.getNode(index).getElement();
	}

	private Node getNode(int index) {
		if(!this.isIndexOccupied(index)){
			throw new IllegalArgumentException("Invalid index");
		}
		Node current = first;
		for (int i = 0; i < index; i++) {
			current = current.getNext();
		}
		return current;
	}

	private boolean isIndexOccupied(int index){
		return index >= 0 && index < this.totalElements;
	}

	public void remove(int index) {
		if (!this.isIndexOccupied(index)) {
			throw new IllegalArgumentException("Invalid index");
		}
		if (index == 0) {
			this.removeFirst();
		} else if (index == this.totalElements - 1) {
			this.removeLast();
		} else {
			Node previous = this.getNode(index - 1);
			Node current = previous.getNext();
			Node next = current.getNext();
			previous.setNext(next);
			next.setPrevious(previous);
			this.totalElements--;
		}
	}

	public void removeFirst() {
		if (!this.isIndexOccupied(0)) {
			throw new IllegalArgumentException("Invalid Position");
		}
		this.first = this.first.getNext();
		this.totalElements--;
		if (this.totalElements == 0) {
			this.last = null;
		}
	}

	public void removeLast() {
		if (!this.isIndexOccupied(this.totalElements - 1)) {
			throw new IllegalArgumentException("Invalid position");
		}
		if (this.totalElements == 1) {
			this.removeFirst();
		} else {
			Node beforeLast = this.last.getPrevious();
			beforeLast.setNext(null);
			this.last = beforeLast;
			this.totalElements--;
		} }

	public int size() {
		return this.totalElements;
	}

	/*
	public boolean contains(Object element) {
		Node current = this.first;
		while (current != null) {
			if (current.getElement().equals(element)) {
				return true;
			}
			current = current.getNext();
		}
		return false;
	}
	 */
	
	public String toString() {
		if(this.totalElements == 0){
			return "[]";
		}
		StringBuilder builder = new StringBuilder("[");
		Node current = first;
		for (int i = 0; i < this.totalElements - 1; i++) {
			builder.append(current.getElement());
			builder.append(", ");
			current = current.getNext();
		}
		builder.append(current.getElement());
		builder.append("]");
		return builder.toString();
	}
}

