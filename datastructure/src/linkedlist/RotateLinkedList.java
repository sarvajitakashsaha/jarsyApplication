package linkedlist;

import linkedlist.SingleLinkedList.Node;

public class RotateLinkedList {
	int pos = 4;
	SingleLinkedList lst = new SingleLinkedList();

//	public void insert(int x) {
//		lst.insertAtBegining(x);
//		Node n = lst.head;
//		System.out.println(n.data);
//	}

	public Node rotate(Node h) {
		Node temp = h;
		Node head = h;
		Node b = h;
		for (int i = 0 ; i < pos; i++) {
			temp = temp.next;
			
		}
		head = temp;
		while(temp.next != null) {
			temp = temp.next;
		}
		temp.next = b;
		
		
		return head;
	}

	public void show(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.printf("%d->", temp.data);
		}
		
	}

	public static void main(String[] args) {
		SingleLinkedList lst1 = new SingleLinkedList();
		RotateLinkedList obj = new RotateLinkedList();
		lst1.insertAtEnd(10);
		lst1.insertAtEnd(20);
		lst1.insertAtEnd(30);
		lst1.insertAtEnd(40);
		lst1.insertAtEnd(50);
		lst1.insertAtEnd(60);
		lst1.insertAtEnd(70);
		lst1.insertAtEnd(80);
		lst1.head = obj.rotate(lst1.head);
	   	obj.show(lst1.head);
		//obj.show();

	}

}
