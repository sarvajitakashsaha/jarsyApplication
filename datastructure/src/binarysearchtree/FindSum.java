package binarysearchtree;

import java.util.ArrayList;
import java.util.List;

//Find a pair with given sum in a Balanced BST

public class FindSum {
	Node root;

	List<Integer> lst = new ArrayList<Integer>();

	public FindSum() {
		this.root = null;
	}

	public Node insert(Node top, int val) {

		if (top == null) {
			Node node = new Node(val);
			return node;
		} else {
			if (val < top.data) {
				top.left = insert(top.left, val);
			} else {
				top.right = insert(top.right, val);
			}
		}
		return top;
	}

	public void printInOrder(Node top) {
		if (top == null) {
			return;
		} else {
			printInOrder(top.left);
			System.out.print(top.data + " ");
			lst.add(top.data);
			printInOrder(top.right);
		}
	}

	public void getPairofSum(int s) {
		int l = 0;
		int r = lst.size() - 1;
		while (l < r) {
			if (lst.get(l) + lst.get(r) < s) {
				l = l + 1;
			} else if (lst.get(l) + lst.get(r) > s) {
				r = r - 1;
			} else {
				System.out.println("\npair is ::  " + lst.get(l) + " and " + lst.get(r));
				l++;

			}
		}
	}

	public static void main(String[] args) {
		FindSum tree = new FindSum(); /*
										 * 15 / \ 10 20 / \ / \ 8 12 16 25
										 */
		tree.root = tree.insert(tree.root, 15);
		tree.root = tree.insert(tree.root, 10);
		tree.root = tree.insert(tree.root, 20);
		tree.root = tree.insert(tree.root, 8);
		tree.root = tree.insert(tree.root, 12);
		tree.root = tree.insert(tree.root, 16);
		tree.root = tree.insert(tree.root, 22);
		tree.printInOrder(tree.root);

		tree.getPairofSum(30);
		System.out.println("\nFind t pair with given sum in a Balanced BST");

	}

}
