package doublelinkedlist;

public class DoubleLinkedList {

	class Node {
		int data;
		Node next;
		Node prev;
	}

	Node head;

	public DoubleLinkedList() {
		this.head = null;
	}

	public void insertAtBegin(int x) {
		Node node = new Node();
		node.data = x;
		if (head == null) {
			head = node;
		} else {
			node.next = head;
			node.prev = null;
			head.prev = node;
			head = node;
		}
	}

	public void insertAtEnd(int x) {
		Node node = new Node();
		node.data = x;
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = node;
		node.prev = temp;
		node.next = null;
	}

	public void insertAtMiddle(int x, Node previous) {
		Node node = new Node();
		node.data = x;
		Node temp = previous.next;
		node.next = previous.next;
		temp.prev = node;
		node.prev = previous;
		previous.next = node;

	}

	public void delete(Node node) {
		Node pr = node.prev;
		Node ne = node.next;
		pr.next = ne;
		ne.prev = pr;
	}

	public void display() {
		if (head == null) {
			System.out.println("Empty List");
			return;
		} else {
			Node temp = head;
			System.out.println("\n Traversal in forward direction\n");
			while (temp != null) {
				System.out.printf("%d <=>", temp.data);
				temp = temp.next;
			}
			System.out.println("\n Traversal in reverse  direction\n");
			Node end = head;
			while (end.next != null) {
				end = end.next;
			}
			while (end != null) {
				System.out.printf("%d<=>", end.data);
				end = end.prev;
			}
		}
	}

	public static void main(String[] args) {
		DoubleLinkedList obj = new DoubleLinkedList();
		obj.insertAtBegin(10);
		obj.insertAtBegin(20);
		obj.insertAtBegin(30);
		obj.insertAtBegin(40);
		obj.insertAtEnd(5);
		obj.insertAtMiddle(25, obj.head.next);
		obj.delete(obj.head.next.next);
		obj.display();

		System.out.println("\nDouble Linked List ");

	}

}
