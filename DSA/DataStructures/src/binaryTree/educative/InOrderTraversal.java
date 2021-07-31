package binaryTree.educative;

import java.util.Stack;

public class InOrderTraversal {

	static String iterativeInorder(Node root) {
		String result = "";
		Stack<Node> stack = new Stack<>();

		while (!stack.isEmpty() || root != null) {

			if(root != null) {
				stack.push(root);
				root = root.left;
				continue;
			}
			System.out.println(stack.peek().data + " ");
			root = stack.pop().right;
		}
		return result;

	}

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

		System.out.print("Inorder Traversal = ");
		iterativeInorder(root);

	}

}
