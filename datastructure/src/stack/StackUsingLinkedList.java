package stack;

class StackClass{
	private class Node{
		int data;
		Node Link;
	}
	Node top;
	StackClass(){
		this.top = null;
	}
	
	public void push(int x) {
		Node temp = new Node();
		
		temp.data = x;
		temp.Link=top;
		top = temp;
	}
	public void display() {
		if(top == null) {
			System.out.println("onder flow");
			return;
		}
		else {
			Node temp = top;
			while(temp != null) {
				System.out.printf("%d->",temp.data);
				temp = temp.Link;
			}
		}
	}
	public boolean isEmpty() {
		if(top == null) {
			return true;
		} else {
			return false;
		} 			
	}
	public int peek() {
		if(!isEmpty()) {
			return top.data;
		} else {return -1;}
	}
	public void pop() {
		if(isEmpty()) {
			System.out.println("underflow");
			return;
		} else {
			System.out.println("poped item is" + top.data);
			top = top.Link;
			
		}
	}
}


public class StackUsingLinkedList {
	 public static void main(String[] args) {
		 System.out.println("strack using linked list");
		 StackClass obj = new StackClass();
		 obj.push(10);
		 obj.push(20);
		 obj.push(30);
		 obj.display();
		 System.out.println("\ntop of the StackClass is" + obj.peek());
		 obj.pop();
		 obj.display();
	 }

}
