package binaryTree.cs;

public class InOrder {

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
	    
	    
		/*
		 * Algorithm Inorder(tree) 
		 * 1. Traverse the left subtree, i.e., call Inorder(left-subtree) 
		 * 2. Visit the root. 
		 * 3. Traverse the right subtree, i.e. call Inorder(right-subtree)
		 */
	    
	    
	    System.out.print("Inorder: ");
	    a.inorder(root);
	    System.out.println();
	    
	    
	    
	}

}
