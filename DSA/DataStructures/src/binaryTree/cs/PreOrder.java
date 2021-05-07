package binaryTree.cs;

public class PreOrder {

	public static void main(String[] args) {

		BinaryTree a = new BinaryTree();

		Node root = a.createNewNode(2);
		root.left = a.createNewNode(7);
		root.right = a.createNewNode(5);
		root.left.left = a.createNewNode(2);
		root.left.right = a.createNewNode(6);
		root.left.right.left = a.createNewNode(5);
		root.left.right.right = a.createNewNode(11);
		root.right.right = a.createNewNode(9);
		root.right.right.left = a.createNewNode(4);

//	    Algorithm Preorder(tree)
//	    1. Visit the root.
//	    2. Traverse the left subtree, i.e., call Preorder(left-subtree)
//	    3. Traverse the right subtree, i.e., call Preorder(right-subtree) 

		System.out.print("Pre order: ");
		a.preorder(root);
		System.out.println();

	}

}
