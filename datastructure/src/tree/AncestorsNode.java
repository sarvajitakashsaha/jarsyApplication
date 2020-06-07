package tree;

public class AncestorsNode {
	Node root;

	public AncestorsNode() {
		this.root = null;
	}

	public boolean printAncestors(Node top, int target) {
		if (top == null) {
			return false;
		}
		if (top.data == target) {
			return true;
		}
		if (printAncestors(top.left, target) || printAncestors(top.right, target)) {
			System.out.print(top.data + " ");
			return true;
		}
		return false;
	}

	public static void main(String args[]) {
		AncestorsNode tree = new AncestorsNode();

		/*
		 * Construct the following binary tree 1 / \ 2 3 / \ 4 5 / 7
		 */
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.left.left.left = new Node(7);

		tree.printAncestors(tree.root, 7);

	}

}
