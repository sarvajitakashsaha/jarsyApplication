package queue;

//LIFO
class Queue {
	int maxSize = 10;

	class Node {
		int data;
		Node next;
	}

	Node front;

	public Queue() {
		this.front = null;
	}

	public void enqueue(int x) {
		if (size() == maxSize) {
			System.out.println("overflow");
			return;
		} else {
			Node node = new Node();
			node.data = x;
			if (front == null) {
				front = node;
			} else {
				Node temp = front;
				while (temp.next != null) {
					temp = temp.next;
				}
				temp.next = node;
			}
		}
	}

	public int size() {
		int count = 0;
		Node temp = front;
		while (temp != null) {
			count = count + 1;
			temp = temp.next;
		}
		return count;
	}

	public void dequeue() {
		if (front == null) {
			System.out.println("Empty queue");
			return;
		} else {
   			System.out.println("deleted item is :: " + front.data);
			front = front.next;
		}
	}

	public void display() {
		Node temp = front;
		while (temp != null) {
			System.out.printf("%d->", temp.data);
			temp = temp.next;
		}
	}

}

public class QueueUsingLinkedList {
	public static void main(String[] args) {
		Queue obj = new Queue();
		obj.enqueue(10);
		obj.enqueue(20);
		obj.enqueue(30);
		obj.enqueue(40);
		obj.enqueue(50);
		obj.dequeue();
		obj.display();
		System.out.println("\ncount is :: " + obj.size());
		System.out.println("\nqueue using linked list");
	}

}
