package binarysearchtree;

import java.util.*;

public class FloorAndCeil {
	Node root;
	Set<Integer> s = new TreeSet<>();

	public FloorAndCeil() {
		this.root = null;
	}

	public void printInOrder(Node top) {
		if (top == null) {
			return;
		} else {
			printInOrder(top.left);
			// System.out.print(top.data + " ");
			s.add(top.data);
			printInOrder(top.right);
		}
	}

	public int getCeil(int data) {
		int ceil = 0;
		List<Integer> l = new ArrayList<Integer>(s);
		for (int i = 0; i < s.size(); i++) {
			if (l.get(i) >= data) {
				ceil = l.get(i);
				break;
			}

		}
		return ceil;
	}

	public int getfloor(int data) {
		int ceil = 0;
		List<Integer> l = new ArrayList<Integer>(s);
		for (int i = s.size() - 1; i > 0; i--) {
			if (l.get(i) <= data) {
				ceil = l.get(i);
				break;
			}

		}
		return ceil;
	}

	

	public static void main(String[] args) {
		FloorAndCeil tree = new FloorAndCeil();
		tree.root = new Node(8);
		tree.root.left = new Node(4);
		tree.root.right = new Node(12);
		tree.root.left.left = new Node(2);
		tree.root.left.right = new Node(6);
		tree.root.right.left = new Node(10);
		tree.root.right.right = new Node(14);

		tree.printInOrder(tree.root);
		System.out.println("ceil is :: " + tree.getCeil(5));
		System.out.println("floor is :: " + tree.getfloor(9));
	}

}
