package binaryTree.educative;

import java.util.Stack;

public class InOrderIterator {

	Stack<Node> stk = new Stack<Node>();

	public InOrderIterator(Node root) {
		populateIterator(root);
	}

	public void populateIterator(Node root) {
		while (root != null) {
			stk.push(root);
			root = root.left;
		}
	}

	public boolean hasNext() {
		return !stk.isEmpty();
	}

	public Node getNext() {
		if (stk.isEmpty())
			return null;

		Node rVal = stk.pop();
		Node temp = rVal.right;
		populateIterator(temp);

		return rVal;
	}

	public static String inorderUsingIterator(Node root) {
		InOrderIterator iter = new InOrderIterator(root);
		String result = "";
		while (iter.hasNext()) {
			result += iter.getNext().data + " ";
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

		System.out.print("Inorder Iterator = ");
		System.out.println(inorderUsingIterator(root));

	}

}
