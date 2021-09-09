package binaryTree.cs;

public class LeftViewOfBinaryTree {

	public static void main(String[] args) {

		BinaryTree a = new BinaryTree();

		Node root = a.createNewNode(1);
		root.left = null;
		root.right = a.createNewNode(3);

		a.leftViewOfTree(root, 0);

	}

}
