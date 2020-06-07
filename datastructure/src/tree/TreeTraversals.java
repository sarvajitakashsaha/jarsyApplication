package tree;

//Depth First Traversals:
//(a) Inorder (Left, Root, Right) : 
//(b) Preorder (Root, Left, Right) : 
//(c) Postorder (Left, Right, Root) : 

//Level order traversal of a tree is breadth first traversal for the tree. 
public class TreeTraversals {
	class Node {
		int data;
		Node right, left;

		Node(int data) {
			this.data = data;
			right = left = null;
		}
	}

	Node root;

	public TreeTraversals() {
		this.root = null;
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

	public void printPreOrder(Node top) {
		if (top == null) {
			return;
		} else {
			System.out.print(top.data + " ");
			printPreOrder(top.left);
			printPreOrder(top.right);

		}
	}

	public void printPostOrder(Node top) {
		if (top == null) {
			return;
		} else {
			printPostOrder(top.left);
			printPostOrder(top.right);
			System.out.print(top.data + " ");

		}
	}

//	public int height(Node top) {
//		if (top == null) {
//			return 0;
//		} else {
//			int lheight = height(top.left);
//			int rheight = height(top.right);
//			if (lheight <= rheight) {
//				return (rheight + 1);
//			} else {
//				return (lheight + 1);
//			}
//		}
//	}
//
//	public void printLevelOrder(Node top) {
//		int h = height(top);
//		for (int i = 1; i <= h; i++) {
//			printGivenLevel(top, i);
//		}
//	}
//
//	public void printGivenLevel(Node top, int h) {
//		if (h == 0) {
//			return;
//		}
//		if (h == 1) {
//			System.out.print(top.data + " ");
//		} else if (h > 1) {
//			printGivenLevel(top.left, h - 1);
//			printGivenLevel(top.right, h - 1);
//		}
//	}
	public int height(Node top) {
		if (top == null) {
			return 0;
		} else {
			int lheight = height(top.left);
			int rheight = height(top.right);
			if (lheight <= rheight) {
				return (rheight + 1);
			} else {
				return (lheight + 1);
			}
		}
	}

	public void printLevelOrder(Node top) {
		if (top == null) {
			return;
		}
		int h = height(top);
		for (int i = 1; i <= h; i++) {
			printGivenLevel(top, i);
		}
	}

	public void printGivenLevel(Node top, int h) {
		if (h == 0) {
			return;
		}
		if (h == 1) {
			System.out.print(top.data + " ");
		} else {
			printGivenLevel(top.left, h - 1);
			printGivenLevel(top.right, h - 1);
		}
	}

	public static void main(String[] args) {
		TreeTraversals tree = new TreeTraversals();
		tree.root = tree.new Node(1);
		tree.root.left = tree.new Node(2);
		tree.root.right = tree.new Node(3);
		tree.root.left.left = tree.new Node(4);
		tree.root.left.right = tree.new Node(5);
		System.out.println("Inorder traversal of binary tree is ");
		tree.printInOrder(tree.root);
		System.out.println("\nPreorder traversal of binary tree is ");
		tree.printPreOrder(tree.root);
		System.out.println("\nPostorder traversal of binary tree is ");
		tree.printPostOrder(tree.root);
		System.out.println("\nHeoght of the given tree is " + tree.height(tree.root));
		System.out.println("\nLevelorder traversal of binary tree is ");
		tree.printLevelOrder(tree.root);
		System.out.println("\nBinary Tree Traveersals");

	}

}
