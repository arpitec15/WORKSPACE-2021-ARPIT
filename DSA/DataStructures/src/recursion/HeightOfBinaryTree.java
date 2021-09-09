package recursion;

class Node {
	int data;
	Node left, right;

	Node(int item) {
		data = item;
		left = right = null;
	}
}

public class HeightOfBinaryTree {
	Node root;

	public static void main(String[] args) {

		HeightOfBinaryTree tree = new HeightOfBinaryTree();

		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		System.out.println("Height of tree is : " + tree.height(tree.root));

	}

	private int height(Node root) {

		if (root == null)
			return 0;

		int lh = height(root.left);
		int rh = height(root.right);

		return 1 + Math.max(lh, rh);

	}

}
