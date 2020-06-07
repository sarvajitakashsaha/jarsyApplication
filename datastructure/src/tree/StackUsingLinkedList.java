package tree;

class StackClass {
//	private class Node{
//		int data;
//		Node Link;
//	}
	Node top;

	StackClass() {
		this.top = null;
	}

	public void push(Node temp) {

		temp.Link = top;
		top = temp;
	}

	public void display() {
		if (top == null) {
			System.out.println("onder flow");
			return;
		} else {
			Node temp = top;
			while (temp != null) {
				System.out.printf("%d->", temp.data);
				temp = temp.Link;
			}
		}
	}

	public boolean isEmpty() {
		if (top == null) {
			return true;
		} else {
			return false;
		}
	}

	public int peek() {
		if (!isEmpty()) {
			return top.data;
		} else {
			return -1;
		}
	}

	public Node pop() {
		if (isEmpty()) {
			System.out.println("underflow");
			return null;
		} else {

			Node temp = top;
			top = top.Link;
			return temp;
		}
	}
}

public class StackUsingLinkedList {
	public static void main(String[] args) {
		System.out.println("strack using linked list");
		StackClass obj = new StackClass();
		Node n1 = new Node(10);
		obj.push(n1);
		Node n2 = new Node(20);
		obj.push(n2);

		obj.display();
		System.out.println("\ntop of the StackClass is" + obj.peek());
		obj.pop();
		obj.display();
	}

}
