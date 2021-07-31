package binaryTree.educative;

import java.util.List;
import java.util.Stack;

public class DeleteZeroSumSubTrees {

	public static void main(String[] args) {

		BinaryTreeEducative a = new BinaryTreeEducative();

		Node root = a.createNewNode(7);
		root.left = a.createNewNode(5);
		root.right = a.createNewNode(6);
		root.left.left = a.createNewNode(-3);
		root.left.right = a.createNewNode(-2);

		System.out.print("Delete Sub Tree If Sum Is Zero ");
		System.out.println(a.deleteZeroSumSubTree(root));
		a.levelOrderTraversalLineByLine2(root);

	}

}
