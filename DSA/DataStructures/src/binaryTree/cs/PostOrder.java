package binaryTree.cs;

public class PostOrder {

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

//		Algorithm Postorder(tree)
//		   1. Traverse the left subtree, i.e., call Postorder(left-subtree)
//		   2. Traverse the right subtree, i.e., call Postorder(right-subtree)
//		   3. Visit the root.
		   
		
//		System.out.print("Inorder: ");
//		a.postorder(root);
//		System.out.println();
		
		a.postOrderUsingStack(root);

	}

}
