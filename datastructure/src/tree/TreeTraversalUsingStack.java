package tree;

//Algo
//1.push The current Node and go to left child till left chile = null;
//2.pop node and print
//3. go to right child of that node
class Node {
	int data;
	Node left, right;
	Node Link;

	public Node(int item) {
		data = item;
		left = right = null;
	}

	public Node() {
	}
}

public class TreeTraversalUsingStack {
	Node root;
	StackClass s = new StackClass();

	public TreeTraversalUsingStack() {

	}

	public void inorder() {

		if (root == null)
			return;

		Node curr = root;
		while (curr != null || !s.isEmpty()) {
			while (curr != null) {
				s.push(curr);
				curr = curr.left;
			}

			curr = s.pop();
			System.out.print(curr.data + " ");

			curr = curr.right;
		}

	}

	public static void main(String[] args) {
		TreeTraversalUsingStack tree = new TreeTraversalUsingStack();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.inorder();
		System.out.println("\nBinary Tree travarsal in non recursive way by using Stack");

	}

}
