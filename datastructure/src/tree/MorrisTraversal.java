package tree;
// Tree traversal with out recursion with out stack

/*
1. Initialize current as root 
2. While current is not NULL
   If the current does not have left child
      a) Print current’s data
      b) Go to the right, i.e., current = current->right
   Else
      a) Make current as the right child of the rightmost 
         node in current's left subtree
      b) Go to this left child, i.e., current = current->left*/

public class MorrisTraversal {
	Node root;

	public MorrisTraversal() {
		this.root = null;
	}

	public void inorderMorrisTraversal() {
		if (root == null) {
			return;
		}
		Node current = root;
		while (current != null) {
			if (current.left == null) {
				System.out.print(current.data + " ");
				current = current.right;
			} else {
				/* Find the inorder predecessor of current */
				Node pre = current.left;
				while (pre.right != null && pre.right != current) {
					pre = pre.right;
				}
				if (pre.right == null) {
					pre.right = current;
					current = current.left;
				} else { /* checking (pre.right==current) */
					pre.right = null;
					System.out.print(current.data + " ");
					current = current.right;
				}

			}

		}
	}

	public static void main(String[] args) {
		MorrisTraversal tree = new MorrisTraversal();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.inorderMorrisTraversal();
		System.out.println("\nInOrder traversal without recursion and without stack");

	}

}
