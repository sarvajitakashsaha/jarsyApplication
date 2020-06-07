package binarysearchtree;

class Node {
	int data;
	Node right, left;

	Node(int data) {
		this.data = data;
		right = left = null;
	}
}

public class BinarySearchTree {

	Node root;

	public BinarySearchTree() {
		this.root = null;
	}

//inserting without recursion
//	public void insert(Node top, int data) {
//		Node node = new Node(data);
//		if (top == null) {
//			root = node;
//			return;
//		} else {
//			Node prev = null;
//			Node current = top;
//			while (current != null) {
//				if (data < current.data) {
//					prev = current;
//					current = current.left;
//				} else if (data > current.data) {
//					prev = current;
//					current = current.right;
//
//				}
//			}
//			if (data > prev.data) {
//				prev.right = node;
//			} else {
//				prev.left = node;
//			}
//		}
//	}

	// with recursion
	public Node insert(Node top, int data) {
		if (top == null) {
			Node node = new Node(data);
			return node;
		} else {

			if (data < top.data) {
				top.left = insert(top.left, data);
			} else {
				top.right = insert(top.right, data);
			}
		}
		return top;
	}

	public boolean isPresent(Node top, int val) {
		if (top == null) {
			return false;
		} else {
			while (top != null) {
				if (top.data == val) {
					return true;
				} else if (top.data > val) {
					top = top.left;
					isPresent(top, val);
				} else {
					isPresent(top.right, val);
				}
			}
		}
		return false;
	}

	public void deleteNode(Node root, int val) {
		if (root == null) {
			return;
		} else {
			Node pre = null;
			Node current = root;
			while (current.data != val) {
				if (val < current.data) {
					pre = current;
					current = current.left;
				} else {
					pre = current;
					current = current.right;
				}
			}
			// leaf node
			if (current.left == null && current.right == null) {
				if (current.data < pre.data) {
					pre.left = null;
				} else {
					pre.right = null;
				}
			}
			// Node having only one child
			if (current.left == null && current.right != null) {
				if (current.data < pre.data) {
					pre.left = current.right;
				} else {
					pre.right = current.right;
				}
			} else if (current.left != null && current.right == null) {
				if (current.data < pre.data) {
					pre.left = current.left;
				} else {
					pre.right = current.left;
				}
			}
			// Node having both left and right child
			if (current.left != null && current.right != null) {
				Node successor = getInOrderSuccessor(current);
				current.data = successor.data;
			}
		}
	}

	public Node getInOrderSuccessor(Node del) {
		Node temp = del.right;
		Node pre = null;
		while (temp.left != null) {
			pre = temp;
			temp = temp.left;
		}
		if (temp.right == null) {
			pre.left = null;
		} else {
			pre.left = temp.right;
		}
		return temp;
	}

	public void inorder(Node root) {
		if (root == null) {
			return;
		} else {
			inorder(root.left);
			System.out.print(root.data + " ");
			inorder(root.right);
		}
	}

	public static void main(String[] args) {
		BinarySearchTree obj = new BinarySearchTree();
		obj.root = new Node(20);
		// obj.insert(obj.root, 20);
		obj.insert(obj.root, 30);
		obj.insert(obj.root, 25);
		obj.insert(obj.root, 24);
		obj.insert(obj.root, 40);
		obj.insert(obj.root, 10);
		obj.insert(obj.root, 15);
		obj.insert(obj.root, 5);
		obj.insert(obj.root, 17);
		obj.insert(obj.root, 6);
		obj.deleteNode(obj.root, 20);
		obj.inorder(obj.root);
		if (obj.isPresent(obj.root, 2)) {
			System.out.println("\nit is present");
		} else {
			System.out.println("\nIt is not present");
		}
		System.out
				.println("\nIn BST left child should be smaller than root and right child should be greater than root");
	}
}
