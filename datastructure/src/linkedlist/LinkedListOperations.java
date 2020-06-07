package linkedlist;

class SingleLinkedList {
	public class Node {
		int data;
		Node next;
	}

	public Node head;

	public SingleLinkedList() {
		this.head = null;
	}

	public void insertAtBegining(int x) {
		Node node = new Node();
		node.data = x;
		node.next = head;
		head = node;
	}

	public void insertAtEnd(int x) {
		Node node = new Node();
		node.data = x;
		Node temp = head;
		if (isEmpty()) {
			head = node;
		} else {
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = node;
		}
	}

	public void insertAfter(Node prev, int x) {
		Node node = new Node();
		node.data = x;
		node.next = prev.next;
		prev.next = node;
	}

	public void deleteByValue(int x) {
		if (isEmpty()) {
			System.out.println("list is empty");
			return;
		} else {
			if (head.data == x) {
				head = head.next;
			} else {
				Node temp = head.next;
				Node prev = head;
				while (temp != null) {
					if (temp.data == x) {
						prev.next = temp.next;
					}
					prev = temp;
					temp = temp.next;

				}
			}
		}
	}

	public void deleteByPosition(Node prev) {
		Node temp = prev.next.next;
		prev.next = temp;
	}
	public boolean isEmpty() {
		if (head == null) {
			return true;
		} else {
			return false;
		}
	}

	public int getLength() {
		int count = 0;
		if (isEmpty()) {
			return -1;
		} else {
			Node temp = head;
			while (temp != null) {
				count = count + 1;
				temp = temp.next;
			}
			return count;
		}
	}

	public void display() {
		if (isEmpty()) {
			System.out.println("under flow");
			return;
		} else {
			Node temp = head;
			while (temp != null) {
				System.out.printf("%d->", temp.data);
				temp = temp.next;
			}
		}
	}
}

public class LinkedListOperations {

	public static void main(String[] args) {
		SingleLinkedList obj = new SingleLinkedList();
		obj.insertAtBegining(10);
		obj.insertAtBegining(20);
		obj.insertAtBegining(30);
		obj.insertAfter(obj.head.next, 15);
		obj.insertAtEnd(5);

		obj.display();
	//	obj.deleteByValue(5);
		obj.deleteByPosition(obj.head.next);
		System.out.println("\n After DEletion :: \n");
		obj.display();
		System.out.println("\nThe Length of the linked list is : " + obj.getLength());
		System.out.println("\nBasic Linked List Operations");

	}

}
