package linkedlist;

import java.util.HashSet;

import linkedlist.SingleLinkedList.Node;

public class LoopInLinkedList {

//	public boolean findingLoop(Node head) {
//		HashSet set = new HashSet();
//		Node temp = head;
//		while (temp != null) {
//			if (set.contains(temp)) {
//				return true;
//			} else {
//				set.add(temp);
//				temp = temp.next;
//			}
//		}
//		return false;
//	}
	
	//Floyd Cycle Detection
	public boolean findingLoop(Node head) {
		Node fast = head;
		Node slow = head;
		while (fast != null && slow.next != null && fast.next !=null) {
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow) {
				fast= head;
				// detectin the node where loop starts
				while(fast != slow) {
					fast = fast.next;
					slow = slow.next;
				}
				// removing loop
				fast = head;
				while(fast.next.next!=slow) {
					fast=fast.next;
				}
				fast.next.next=null;
				// returning true if there is loop
				return true;
			} 
		} return false;
	}

	public static void main(String[] args) {
		LoopInLinkedList loop = new LoopInLinkedList();
		SingleLinkedList obj = new SingleLinkedList();
		obj.insertAtBegining(10);
		obj.insertAtBegining(20);
		obj.insertAtBegining(30);
		obj.insertAtBegining(40);
		obj.insertAtBegining(50);
		obj.head.next.next.next.next.next = obj.head.next;

		if (loop.findingLoop(obj.head)) {
			System.out.println("There is a loop");
		} else {
			System.out.println("There is no loop");
		}
		obj.display();
		System.out.println("\nfinding loop in linked list");
	}
}
