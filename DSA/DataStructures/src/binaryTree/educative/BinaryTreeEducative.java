package binaryTree.educative;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Stack;

class Node {
	int data;
	Node left;
	Node right;
	Node next;
	int height;
}

public class BinaryTreeEducative {

	public Node createNewNode(int val) {

		Node a = new Node();
		a.data = val;
		a.left = null;
		a.right = null;

		return a;
	}

	public static String iterativeInorder(Node root) {
		String result = "";
		Stack<Node> stack = new Stack<>();

		while (!stack.isEmpty() || root != null) {

			if (root != null) {
				stack.push(root);
				root = root.left;
				continue;
			}
			System.out.println(stack.peek().data + " ");
			root = stack.pop().right;
		}

		return result;

	}

	public void levelOrderTraversalLineByLine(Node root) {

		if (root == null) {
			return;
		}

		Queue<Node> queue = new LinkedList<>();

		queue.add(root);

		while (queue.size() != 0) {

			int size = queue.size();

			while (size > 0) {

				Node temp = queue.peek();
				System.out.print(temp.data + " ");
				queue.remove();

				if (temp.left != null) {
					queue.add(temp.left);
				}

				if (temp.right != null) {
					queue.add(temp.right);
				}
				size--;
			}
			System.out.println();

		}

	}

	public String levelOrderTraversalLineByLine2(Node root) {

		if (root == null) {
			return "";
		}

		String result = "";

		ArrayList<Queue<Node>> queues = new ArrayList<Queue<Node>>();

		queues.add(new ArrayDeque<Node>());
		queues.add(new ArrayDeque<Node>());

		Queue<Node> current_queue = queues.get(0);
		Queue<Node> next_queue = queues.get(1);

		current_queue.add(root);
		int level_number = 0;

		while (!current_queue.isEmpty()) {
			Node temp = current_queue.poll();
			System.out.print(temp.data + " ");
			result += String.valueOf(temp.data) + " ";

			if (temp.left != null) {
				next_queue.add(temp.left);
			}

			if (temp.right != null) {
				next_queue.add(temp.right);
			}

			if (current_queue.isEmpty()) {
				System.out.println();
				++level_number;
				current_queue = queues.get(level_number % 2);
				next_queue = queues.get((level_number + 1) % 2);
			}
		}
		System.out.println();
		return result;

	}

	public static String levelOrderTraversalLineByLine3(Node root) {

		if (root == null) {
			return "";
		}

		String result = "";

		Queue<Node> current_queue = new ArrayDeque<Node>();

		Node dummyNode = new Node();

		current_queue.add(root);
		current_queue.add(dummyNode);

		while (!current_queue.isEmpty()) {
			Node temp = current_queue.poll();
			System.out.print(temp.data + " ");
			result += String.valueOf(temp.data) + " ";

			if (temp.left != null) {
				current_queue.add(temp.left);
			}

			if (temp.right != null) {
				current_queue.add(temp.right);
			}

			if (current_queue.peek() == dummyNode) {
				System.out.println();

				current_queue.remove();

				if (!current_queue.isEmpty()) {
					current_queue.add(dummyNode);
				}
			}
		}
		System.out.println();
		return result;
	}

	public static List<List<Integer>> reverseTraverse(Node root) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		if (root == null)
			return result;

		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int levelSize = queue.size();
			List<Integer> currentLevel = new ArrayList<>(levelSize);
			for (int i = 0; i < levelSize; i++) {
				Node currentNode = queue.poll();
				// add the node to the current level
				currentLevel.add(currentNode.data);
				// insert the children of current node to the queue
				if (currentNode.left != null)
					queue.offer(currentNode.left);
				if (currentNode.right != null)
					queue.offer(currentNode.right);
			}
			// append the current level at the beginning
			result.add(0, currentLevel);
		}

		return result;
	}

	public static List<Double> findLevelAverages(Node root) {
		List<Double> result = new ArrayList<>();
		if (root == null)
			return result;

		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int levelSize = queue.size();
			double levelSum = 0;
			for (int i = 0; i < levelSize; i++) {
				Node currentNode = queue.poll();
				// add the node's value to the running sum
				levelSum += currentNode.data;
				// insert the children of current node to the queue
				if (currentNode.left != null)
					queue.offer(currentNode.left);
				if (currentNode.right != null)
					queue.offer(currentNode.right);
			}
			// append the current level's average to the result array
			result.add(levelSum / levelSize);
		}

		return result;
	}

	public static Node findLevelOrderSuccessor(Node root, int key) {
		if (root == null)
			return null;

		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			Node currentNode = queue.poll();
			// insert the children of current node in the queue
			if (currentNode.left != null)
				queue.offer(currentNode.left);
			if (currentNode.right != null)
				queue.offer(currentNode.right);

			// break if we have found the key
			if (currentNode.data == key)
				break;
		}

		return queue.peek();
	}

	public static List<List<Integer>> zigZagTraverse(Node root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null)
			return result;

		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		boolean leftToRight = true;
		while (!queue.isEmpty()) {
			int levelSize = queue.size();
			List<Integer> currentLevel = new LinkedList<>();
			for (int i = 0; i < levelSize; i++) {
				Node currentNode = queue.poll();

				// add the node to the current level based on the traverse direction
				if (leftToRight)
					currentLevel.add(currentNode.data);
				else
					currentLevel.add(0, currentNode.data);

				// insert the children of current node in the queue
				if (currentNode.left != null)
					queue.offer(currentNode.left);
				if (currentNode.right != null)
					queue.offer(currentNode.right);
			}
			result.add(currentLevel);
			// reverse the traversal direction
			leftToRight = !leftToRight;
		}

		return result;
	}

	public static void mirrorBinaryTree(Node root) {

		if (root == null) {
			return;
		}

		// We will do a post-order traversal of the binary tree.

		if (root.left != null) {
			mirrorBinaryTree(root.left);
		}

		if (root.right != null) {
			mirrorBinaryTree(root.right);
		}

		// Let's swap the left and right nodes at current level.

		Node temp = root.left;
		root.left = root.right;
		root.right = temp;
	}

	public int deleteZeroSumSubTree(Node root) {

		if (root == null) {
			return 0;
		}

		int sum_left = deleteZeroSumSubTree(root.left);
		int sum_right = deleteZeroSumSubTree(root.right);

		if (sum_left == 0) {
			root.left = null;
		}

		if (sum_right == 0) {
			root.right = null;
		}

		return root.data + sum_left + sum_right;

	}

	public List<List<Integer>> findPaths(Node root, int sum) {
		List<List<Integer>> allPaths = new ArrayList<>();
		List<Integer> currentPath = new ArrayList<Integer>();
		findPathsRecursive(root, sum, currentPath, allPaths);
		return allPaths;
	}

	private static void findPathsRecursive(Node currentNode, int sum, List<Integer> currentPath,
			List<List<Integer>> allPaths) {
		if (currentNode == null)
			return;

		// add the current node to the path
		currentPath.add(currentNode.data);

		// if the current node is a leaf and its value is equal to sum, save the current
		// path
		if (currentNode.data == sum && currentNode.left == null && currentNode.right == null) {
			allPaths.add(new ArrayList<Integer>(currentPath));
		} else {
			// traverse the left sub-tree
			findPathsRecursive(currentNode.left, sum - currentNode.data, currentPath, allPaths);
			// traverse the right sub-tree
			findPathsRecursive(currentNode.right, sum - currentNode.data, currentPath, allPaths);
		}

		// remove the current node from the path to backtrack,
		// we need to remove the current node while we are going up the recursive call
		// stack.
		currentPath.remove(currentPath.size() - 1);
	}

	public int findSumOfPathNumbers(Node root) {
		return findRootToLeafPathNumbers(root, 0);
	}

	private static int findRootToLeafPathNumbers(Node currentNode, int pathSum) {
		if (currentNode == null)
			return 0;

		// calculate the path number of the current node
		pathSum = 10 * pathSum + currentNode.data;

		// if the current node is a leaf, return the current path sum.
		if (currentNode.left == null && currentNode.right == null) {
			return pathSum;
		}

		// traverse the left and the right sub-tree
		return findRootToLeafPathNumbers(currentNode.left, pathSum)
				+ findRootToLeafPathNumbers(currentNode.right, pathSum);
	}

	public int countPaths(Node root, int S) {
		List<Integer> currentPath = new LinkedList<>();
		return countPathsRecursive(root, S, currentPath);
	}

	private static int countPathsRecursive(Node currentNode, int S, List<Integer> currentPath) {
		if (currentNode == null)
			return 0;

		// add the current node to the path
		currentPath.add(currentNode.data);
		int pathCount = 0, pathSum = 0;
		// find the sums of all sub-paths in the current path list
		ListIterator<Integer> pathIterator = currentPath.listIterator(currentPath.size());
		while (pathIterator.hasPrevious()) {
			pathSum += pathIterator.previous();
			// if the sum of any sub-path is equal to 'S' we increment our path count.
			if (pathSum == S) {
				pathCount++;
			}
		}

		// traverse the left sub-tree
		pathCount += countPathsRecursive(currentNode.left, S, currentPath);
		// traverse the right sub-tree
		pathCount += countPathsRecursive(currentNode.right, S, currentPath);

		// remove the current node from the path to backtrack,
		// we need to remove the current node while we are going up the recursive call
		// stack.
		currentPath.remove(currentPath.size() - 1);

		return pathCount;
	}

}