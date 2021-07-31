package binaryTree.educative;

import java.util.List;
import java.util.Stack;

public class ReverseLevelOrderTraversal {

	public static void main(String[] args) {

		BinaryTreeEducative a = new BinaryTreeEducative();

		Node root = a.createNewNode(2);
		root.left = a.createNewNode(7);
		root.right = a.createNewNode(5);
		root.left.left = a.createNewNode(12);
		root.left.left.left = a.createNewNode(1);
		root.left.left.left.right = a.createNewNode(10);
		root.left.right = a.createNewNode(6);
		root.left.right.left = a.createNewNode(5);
		root.left.right.right = a.createNewNode(11);
		root.left.right.right.right = a.createNewNode(13);

		System.out.print("Reverse Traversal = ");
		List<List<Integer>> reverseTraverse = BinaryTreeEducative.reverseTraverse(root);

		System.out.println(reverseTraverse);
	}

}
