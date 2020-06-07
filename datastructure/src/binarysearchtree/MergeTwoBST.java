package binarysearchtree;

public class MergeTwoBST {
	Node root;

	public MergeTwoBST() {
		this.root = null;
	}

	public Node insert(Node root, int data) {
		if (root == null) {
			Node temp = new Node(data);
			return temp;
		} else {
			if (data < root.data) {
				root.left = insert(root.left, data);
			} else {
				root.right = insert(root.right, data);
			}
		}

		return root;
	}

	public void inorder(Node root1, Node root2) {
		if (root2 == null) {
			return;
		} else {
			inorder(root1, root2.left);
			insert(root1, root2.data);
			inorder(root1, root2.right);
		}
	}

	public void printInOrder(Node top) {
		if (top == null) {
			return;
		} else {
			printInOrder(top.left);
			System.out.print(top.data + " ");
			printInOrder(top.right);
		}
	}

	public static void main(String[] args) {
		MergeTwoBST root1 = new MergeTwoBST();
		root1.root = new Node(3);
		root1.root.left = new Node(1);
		root1.root.right = new Node(5);

		MergeTwoBST root2 = new MergeTwoBST();
		root2.root = new Node(4);
		root2.root.left = new Node(2);
		root2.root.right = new Node(6);
		root2.inorder(root1.root, root2.root);
		root1.printInOrder(root1.root);
	}

}
