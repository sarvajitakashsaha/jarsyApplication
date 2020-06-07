package linkedlist.circularlinkedlist;

public class CircularLinkedList {
	class Node {
		int data;
		Node next;
	}

	Node last;

	public CircularLinkedList() {
		this.last = null;
	}

	public Node addToEmpty(Node l, int val) {
		if (l != null) {
			return l;
		}
		Node node = new Node();
		node.data = val;
		node.next = node;
		last = node;
		return last;
	}

	public Node addBegin(Node end, int val) {
		if (end == null) {
			return addToEmpty(end, val);
		} else {
			Node node = new Node();
			node.data = val;
			node.next = end.next;
			end.next = node;

		}
		return end;
	}

	public Node addBetween(Node end, int val, Node prev) {
		if (end == null) {
			return addToEmpty(end, val);
		} else {
			Node node = new Node();
			node.data = val;
			node.next = prev.next;
			prev.next = node;
		}
		return end;
	}

	public Node addEnd(Node end, int val) {
		if (end == null) {
			return addToEmpty(end, val);
		} else {
			Node node = new Node();
			node.data = val;
			node.next = end.next;
			end.next = node;
			last = node;
		}
		return last;
	}

	public Node delete(Node end, Node del) {
		if (end == null) {
			System.out.println("empty lst");
			return end;
		} else {
			if (end.next == del) {
				end.next = del.next;
			} else {
				Node head = end.next;
				while (head.next != del) {
					head = head.next;
				}
				head.next = del.next;
			}
			Node head = end.next;
		}
		return end;

	}

	public void display(Node last) {
		Node head;
		Node p;
		if (last == null) {
			System.out.println("list is empty");
			return;
		} else {
			head = last.next;
			System.out.printf("%d->", head.data);
			p = head.next;
			while (p != last.next) {
				System.out.printf("%d->", p.data);
				p = p.next;
			}
		}
	}

	public static void main(String[] args) {

		CircularLinkedList obj = new CircularLinkedList();
		obj.last = obj.addToEmpty(obj.last, 10);
		obj.last = obj.addBegin(obj.last, 20);
		obj.last = obj.addBegin(obj.last, 30);
		obj.last = obj.addEnd(obj.last, 5);
		obj.last = obj.addBetween(obj.last, 25, obj.last.next);
		obj.last = obj.delete(obj.last, obj.last);
		obj.display(obj.last);
		System.out.println("\ncircular linked list");
	}
}
