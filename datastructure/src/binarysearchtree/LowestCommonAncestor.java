package binarysearchtree;

public class LowestCommonAncestor {
	Node root;

	public LowestCommonAncestor() {
		this.root = null;
	}

	public void getLCA(Node root, int t1, int t2) {
		if (root == null) {
			return;
		}
		if (t1 < root.data && t2 < root.data) {
			getLCA(root.left, t1, t2);
		}
		if (t1 > root.data && t2 > root.data) {
			getLCA(root.right, t1, t2);
		}
		if ((t1 < root.data && t2 > root.data) || (t1 > root.data && t2 < root.data)
				|| (t1 == root.data || t2 == root.data)) {
			System.out.println("LCA is :: " + root.data);
		}

	}

	public static void main(String args[]) {
		LowestCommonAncestor tree = new LowestCommonAncestor();
		tree.root = new Node(20);
		tree.root.left = new Node(8);
		tree.root.right = new Node(22);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(12);
		tree.root.left.right.left = new Node(10);
		tree.root.left.right.right = new Node(14);
		tree.getLCA(tree.root, 10, 22);
	}

}
