package linkedlist;

public class ReversingLinkedList {
	
	class Node{
		int data;
		Node next;
	}
	Node head;
	
	public ReversingLinkedList() {
		this.head = null;
	}

	public void insert(int x) {
		Node node = new Node();
		node.data = x;
		node.next = head;
		head = node;
	}
	
	public Node reverse(Node head) {
		Node current = head;
		Node prev = null;
		Node next = null;
		while(current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}
	public void display(Node head) {
		Node temp = head;
		while(temp != null) {
			System.out.printf("%d->", temp.data);
			temp = temp.next;
		}
	}
	public static void main(String[] args) {
		ReversingLinkedList obj = new ReversingLinkedList();
		obj.insert(10);
		obj.insert(20);
		obj.insert(30);
		obj.insert(40);
		obj.display(obj.head);
		obj.head = obj.reverse(obj.head); 
		System.out.println("\nAfter reversing\n");
		obj.display(obj.head);

	}

}
