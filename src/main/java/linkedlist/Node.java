package linkedlist;

public class Node {
	
	private Object element;
	private Node previous;
	private Node next;
	
	public Node(Node nextElement, Object element) {
		this.next = nextElement;
		this.element = element;
	}
	
	public Node(Object element) {
		this.element = element;
	}
	
	public Object getElement() {
		return element;
	} 
	
	public void setPrevious(Node previous) {
		this.previous = previous;
	}
	
	public Node getPrevious() {
		return previous;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
	
	public Node getNext() {
		return next;
	}
	
}