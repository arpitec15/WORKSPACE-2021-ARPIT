package binaryTree.cs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

class Node {
	int data;
	Node left;
	Node right;
	Node next;
	int height;
}

public class BinaryTree {

	public Node createNewNode(int val) {

		Node a = new Node();
		a.data = val;
		a.left = null;
		a.right = null;

		return a;
	}

	public void inorder(Node node) {

		if (node == null) {
			return;
		}

		inorder(node.left);
		System.out.print(node.data + " ");
		inorder(node.right);

	}

	public void preorder(Node node) {

		if (node == null) {
			return;
		}

		System.out.print(node.data + " ");
		preorder(node.left);
		preorder(node.right);

	}

	public void postorder(Node node) {
		if (node == null) {
			return;
		}

		postorder(node.left);
		postorder(node.right);
		System.out.print(node.data + " ");

	}

	public int getSumOfNodes(Node node) {

		if (node == null) {
			return 0;
		}

		int leftSum = getSumOfNodes(node.left);
		int rightSum = getSumOfNodes(node.right);

		return node.data + leftSum + rightSum;

	}

	public int getDifferenceEvenOddvalues(Node node) {
		if (node == null) {
			return 0;
		}

		return node.data - getDifferenceEvenOddvalues(node.left) - getDifferenceEvenOddvalues(node.right);
	}

	public int getNumberOfNodes(Node node) {
		if (node == null) {
			return 0;
		}

		int leftNodes = getNumberOfNodes(node.left);
		int rightNodes = getNumberOfNodes(node.right);
		return 1 + leftNodes + rightNodes;
	}

	public int getNumberOfLeafNodes(Node node) {
		if (node == null) {
			return 0;
		}

		if (node.left == null && node.right == null) {
			return 1;
		}

		int numberOfLeafNodesLeft = getNumberOfLeafNodes(node.left);
		int numberOfLeafNodesRight = getNumberOfLeafNodes(node.right);

		return numberOfLeafNodesLeft + numberOfLeafNodesRight;
	}

	public int getHeightOfTree(Node node) {
		if (node == null) {
			return -1;
		}

		return Math.max(getHeightOfTree(node.left), getHeightOfTree(node.right)) + 1;
	}

	public void printAtGivenLevel(Node node, int level) {
		if (node == null) {
			return;
		}

		if (level == 1) {
			System.out.print(node.data + " ");
			return;
		}

		printAtGivenLevel(node.left, level - 1);
		printAtGivenLevel(node.right, level - 1);
	}

	public void levelOrderTraversalUsingRecursion(Node node) {
		if (node == null) {
			return;
		}

		int height = getHeightOfTree(node);

		for (int i = 0; i <= height; i++) {
			printAtGivenLevel(node, i + 1);
			System.out.println();
		}
	}

	public void levelOrderTraversalUsingQueue(Node node) {
		if (node == null) {
			return;
		}

		Queue<Node> q = new LinkedList<Node>();
		q.add(node);

		while (!q.isEmpty()) {

			Node top = q.remove();
			System.out.print(top.data + " ");

			if (top.left != null) {
				q.add(top.left);
			}

			if (top.right != null) {
				q.add(top.right);
			}
		}
	}

	public void reverseLevelOrderTraversalUsingRecursion(Node node) {
		if (node == null) {
			return;
		}

		int height = getHeightOfTree(node);

		for (int i = height; i >= 0; i--) {
			printAtGivenLevel(node, i + 1);
			System.out.println();
		}
	}

	public void reverseTraversalWithoutRecursion(Node node) {
		if (node == null) {
			return;
		}

		Queue<Node> q = new LinkedList<Node>();
		q.add(node);

		Stack<Node> s = new Stack<Node>();

		while (q.size() > 0) {
			Node t = q.remove();
			s.push(t);

			if (t.right != null) {
				q.add(t.right);
			}

			if (t.left != null) {
				q.add(t.left);
			}
		}

		while (!s.isEmpty()) {
			System.out.print(s.pop().data + " ");
		}
	}

	public void levelOrderTraversalUsingQueueLineByLine(Node node) {
		if (node == null) {
			return;
		}

		Queue<Node> a = new LinkedList<Node>();
		a.add(node);

		while (true) {

			int queueSize = a.size();
			if (queueSize == 0) {
				break;
			}

			while (queueSize > 0) {

				Node temp = a.peek();
				System.out.print(temp.data + " ");

				a.remove();

				if (temp.left != null) {
					a.add(temp.left);
				}

				if (temp.right != null) {
					a.add(temp.right);
				}

				queueSize--;
			}

			System.out.println();
		}
	}

	int maxLevel;

	public void leftViewOfTree(Node node, int level) {
		if (node == null) {
			return;
		}

		if (level >= maxLevel) {
			System.out.print(node.data + " ");
			maxLevel++;
		}

		leftViewOfTree(node.left, level + 1);
		leftViewOfTree(node.right, level + 1);
	}

	public void rightViewOfTree(Node node, int level) {
		if (node == null) {
			return;
		}

		if (level >= maxLevel) {
			System.out.print(node.data + " ");
			maxLevel++;
		}

		rightViewOfTree(node.right, level + 1);
		rightViewOfTree(node.left, level + 1);
	}

	public void inorderUsingStack(Node node) {
		if (node == null) {
			return;
		}

		Stack<Node> s = new Stack<Node>();
		while (node != null) {
			s.push(node);
			node = node.left;
		}

		while (s.size() > 0) {
			Node t = s.pop();
			System.out.print(t.data + " ");
			if (t.right != null) {
				Node tmp = t.right;
				while (tmp != null) {
					s.push(tmp);
					tmp = tmp.left;
				}
			}
		}
	}

	public void preorderWithoutRecursion(Node node) {
		if (node == null) {
			return;
		}

		Stack<Node> s = new Stack<Node>();

		s.push(node);

		while (s.size() > 0) {
			Node t = s.pop();
			System.out.print(t.data + " ");

			if (t.right != null) {
				s.push(t.right);
			}

			if (t.left != null) {
				s.push(t.left);
			}
		}
	}

	public void postorderUsingTwoStack(Node node) {
		if (node == null) {
			return;
		}

		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();

		s1.push(node);

		while (s1.size() > 0) {
			Node t = s1.pop();

			if (t.left != null) {
				s1.push(t.left);
			}

			if (t.right != null) {
				s1.push(t.right);
			}

			s2.push(t);
		}

		while (s2.size() > 0) {
			System.out.print(s2.pop().data + " ");
		}
	}

	public Node mirrorTree(Node node) {
		if (node == null) {
			return null;
		}

		Node t = node.left;
		node.left = node.right;
		node.right = t;

		mirrorTree(node.left);
		mirrorTree(node.right);

		return node;
	}

	public Node deleteTree(Node node) {
		if (node == null) {
			return null;
		}

		node.left = deleteTree(node.left);
		node.right = deleteTree(node.right);

		System.out.println("Deleting node " + node.data);
		node = null;
		return node;
	}

	public boolean checkIfIdentical(Node t1, Node t2) {
		if (t1 == null && t2 == null) {
			return true;
		}

		if (t1 == null || t2 == null) {
			return false;
		}

		return t1.data == t2.data && checkIfIdentical(t1.left, t2.left) && checkIfIdentical(t1.right, t2.right);
	}

	public int getLevelOfNode(Node node, int val, int level) {
		if (node == null) {
			return 0;
		}

		int l;

		if (node.data == val) {
			return level;
		}

		l = getLevelOfNode(node.left, val, level + 1);

		if (l != 0) {
			return l;
		}

		l = getLevelOfNode(node.right, val, level + 1);

		return l;
	}

	public void topView(Node node) {
		if (node == null) {
			return;
		}

		TreeMap<Integer, Integer> m = new TreeMap<Integer, Integer>();

		Queue<Node> q = new LinkedList<Node>();
		q.add(node);

		while (!q.isEmpty()) {
			Node temp = q.remove();
			int hd = temp.height;

			if (m.get(hd) == null) {
				m.put(hd, temp.data);
			}

			if (temp.left != null) {
				temp.left.height = hd - 1;
				q.add(temp.left);
			}

			if (temp.right != null) {
				temp.right.height = hd + 1;
				q.add(temp.right);
			}
		}
		System.out.println(m.values());
	}

	public void bottomView(Node node) {
		if (node == null) {
			return;
		}

		TreeMap<Integer, Integer> m = new TreeMap<Integer, Integer>();

		Queue<Node> q = new LinkedList<Node>();
		q.add(node);

		while (!q.isEmpty()) {
			Node temp = q.remove();
			int hd = temp.height;

			m.put(hd, temp.data);

			if (temp.left != null) {
				temp.left.height = hd - 1;
				q.add(temp.left);
			}

			if (temp.right != null) {
				temp.right.height = hd + 1;
				q.add(temp.right);
			}
		}
		System.out.println(m.values());
	}

//	Start - Print Boundary Nodes in Binary Tree

	public void printBoundary(Node node) {
		if (node != null) {
			System.out.print(node.data + " ");

			printBoundaryLeft(node.left);

			printLeaves(node.left);
			printLeaves(node.right);

			printBoundaryRight(node.right);
		}
	}

	public void printBoundaryLeft(Node node) {
		if (node == null) {
			return;
		}

		if (node.left != null) {
			System.out.print(node.data + " ");
			printBoundaryLeft(node.left);
		} else if (node.right != null) {
			System.out.print(node.data + " ");
			printBoundaryLeft(node.right);
		}
	}

	public void printLeaves(Node node) {
		if (node == null) {
			return;
		}

		printLeaves(node.left);

		if (node.left == null && node.right == null) {
			System.out.print(node.data + " ");
		}
		printLeaves(node.right);
	}

	public void printBoundaryRight(Node node) {
		if (node == null) {
			return;
		}

		if (node.right != null) {
			printBoundaryRight(node.right);
			System.out.print(node.data + " ");
		} else if (node.left != null) {
			printBoundaryRight(node.left);
			System.out.print(node.data + " ");
		}
	}

//	End - Print Boundary Nodes of Binary Tree

//	Start - Print Vertical Order Of Binary Tree

	public void printVerticalOrder(Node node) {
		if (node == null) {
			return;
		}
		int hd = 0;

		TreeMap<Integer, ArrayList<Integer>> m = new TreeMap<Integer, ArrayList<Integer>>();

		getVerticalOrder(node, hd, m);

		for (Map.Entry<Integer, ArrayList<Integer>> cm : m.entrySet()) {
			System.out.println(cm.getValue());
		}
	}

	public void getVerticalOrder(Node node, int hd, TreeMap<Integer, ArrayList<Integer>> m) {
		if (node == null) {
			return;
		}

		if (m.get(hd) == null) {
			ArrayList<Integer> l = new ArrayList<Integer>();
			l.add(node.data);
			m.put(hd, l);
		} else {
			ArrayList<Integer> l = m.get(hd);
			l.add(node.data);
			m.put(hd, l);
		}

		getVerticalOrder(node.left, hd - 1, m);
		getVerticalOrder(node.right, hd + 1, m);
	}

//	End - Print vertical order

//	Start - Print Vertical Sum

	public void getVerticalSum(Node node) {
		if (node == null) {
			return;
		}

		Map<Integer, Integer> m = new TreeMap<Integer, Integer>();

		verticalSum(node, 0, m);

		if (m != null) {
			System.out.println(m.values());
		}
	}

	public void verticalSum(Node node, int d, Map<Integer, Integer> m) {
		if (node == null) {
			return;
		}

		verticalSum(node.left, d - 1, m);

		int s = (m.get(d) == null) ? 0 : m.get(d);
		m.put(d, s + node.data);

		verticalSum(node.right, d + 1, m);
	}

//	End - Print Vertical Sum

//	Start - Get Sum of elements Level wise of Binary Tree

	public void printSumLevelWise(Node node) {
		if (node == null) {
			return;
		}

		Queue<Node> q = new LinkedList<Node>();
		q.add(node);

		while (true) {
			int size = q.size();
			if (size == 0) {
				break;
			}
			int sum = 0;
			while (size > 0) {
				Node t = q.remove();
				sum = sum + t.data;

				if (t.left != null) {
					q.add(t.left);
				}

				if (t.right != null) {
					q.add(t.right);
				}

				size--;
			}
			System.out.println(sum);
		}

		return;
	}

//	End - Get Sum of elements Level wise of Binary Tree

//	 Start - Search an element

	public boolean recursiveSearch(Node node, int key) {
		if (node == null) {
			return false;
		}

		if (node.data == key) {
			return true;
		}

		return recursiveSearch(node.left, key) || recursiveSearch(node.right, key);
	}

	public boolean iterativeSearch(Node node, int key) {
		if (node == null) {
			return false;
		}

		Queue<Node> q = new LinkedList<Node>();
		q.add(node);

		while (!q.isEmpty()) {
			Node t = q.remove();
			if (t.data == key) {
				return true;
			}

			if (t.left != null) {
				q.add(t.left);
			}

			if (t.right != null) {
				q.add(t.right);
			}
		}

		return false;
	}

//	 End - Search an element

//	Start - Print Level order Traversal in Spiral Form

	public void printInSpiralForm(Node node) {
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();

		s1.push(node);
		while (!s1.isEmpty() || !s2.isEmpty()) {

			while (!s1.isEmpty()) {
				Node tmp = s1.pop();
				System.out.print(tmp.data + " ");

				if (tmp.left != null) {
					s2.push(tmp.left);
				}

				if (tmp.right != null) {
					s2.push(tmp.right);
				}
			}
			System.out.println();

			while (!s2.isEmpty()) {
				Node tmp = s2.pop();
				System.out.print(tmp.data + " ");

				if (tmp.right != null) {
					s1.push(tmp.right);
				}

				if (tmp.left != null) {
					s1.push(tmp.left);
				}
			}
			System.out.println();
		}
	}

//	End - Print Level order Traversal in Spiral Form

	public void printBetweenTwoLevels(Node node, int min, int max) {
		if (node == null) {
			return;
		}

		Queue<Node> q = new LinkedList<Node>();
		q.add(node);
		int l = 1;

		while (true) {
			int size = q.size();
			if (size == 0 || l > max) {
				break;
			}
			while (size > 0) {
				Node t = q.remove();
				if (l >= min && l <= max) {
					System.out.print(t.data + " ");
				}
				if (t.left != null) {
					q.add(t.left);
				}

				if (t.right != null) {
					q.add(t.right);
				}

				size--;
			}
			l++;
		}
	}

	public int getMaximumWidth(Node node) {
		if (node == null) {
			return 0;
		}

		Queue<Node> q = new LinkedList<Node>();
		q.add(node);

		int maxWidth = 1;

		while (true) {
			int size = q.size();
			if (size == 0) {
				break;
			}

			if (size > maxWidth) {
				maxWidth = size;
			}

			while (size > 0) {
				Node t = q.remove();

				if (t.left != null) {
					q.add(t.left);
				}

				if (t.right != null) {
					q.add(t.right);
				}
				size--;

			}
		}

		return maxWidth;
	}

	public boolean ifMirrorTree(Node node1, Node node2) {
		if (node1 == null && node2 == null) {
			return true;
		}

		if (node1 == null || node2 == null) {
			return false;
		}

		return node1.data == node2.data && ifMirrorTree(node1.left, node2.right)
				&& ifMirrorTree(node1.right, node2.left);
	}

	public boolean ifMirrorStructureTree(Node node1, Node node2) {
		if (node1 == null && node2 == null) {
			return true;
		}

		if (node1 == null || node2 == null) {
			return false;
		}

		return ifMirrorStructureTree(node1.left, node2.right) && ifMirrorStructureTree(node1.right, node2.left);
	}

	public boolean ifSameStructure(Node node1, Node node2) {
		if (node1 == null && node2 == null) {
			return true;
		}

		if (node1 == null || node2 == null) {
			return false;
		}

		return ifSameStructure(node1.left, node2.left) && ifSameStructure(node1.right, node2.right);
	}

	public boolean ifFoldableTree(Node node) {
		if (node == null) {
			return true;
		}

		return ifMirrorStructure(node.left, node.right);
	}

	public boolean ifMirrorStructure(Node node1, Node node2) {
		if (node1 == null && node2 == null) {
			return true;
		}

		if (node1 == null || node2 == null) {
			return false;
		}

		return ifMirrorStructure(node1.left, node2.right) && ifMirrorStructure(node1.right, node2.left);
	}

	public boolean ifIsomorphic(Node node1, Node node2) {
		if (node1 == null && node2 == null) {
			return true;
		}

		if (node1 == null || node2 == null) {
			return false;
		}

		if (node1.data != node2.data) {
			return false;
		}

		return (ifIsomorphic(node1.left, node2.left) && ifIsomorphic(node1.right, node2.right))
				|| (ifIsomorphic(node1.left, node2.right) && ifIsomorphic(node1.right, node2.left));
	}

	public int getWidthOfLevel(Node node, int level) {
		if (node == null) {
			return 0;
		}

		if (level == 1) {
			return 1;
		}

		return getWidthOfLevel(node.left, level - 1) + getWidthOfLevel(node.right, level - 1);
	}

	public void doubleTree(Node node) {
		if (node == null) {
			return;
		}

		doubleTree(node.left);
		doubleTree(node.right);

		Node newNode = createNewNode(node.data);
		newNode.left = node.left;
		node.left = newNode;
	}

	int preIndex = 0;

	public Node buildTreeFromInOrderPreOrder(int preorderArray[], int inorderArray[], int start, int end) {
		if (start > end) {
			return null;
		}

		Node node = createNewNode(preorderArray[preIndex++]);

		if (start == end) {
			return node;
		}

		int inoderIndex = getInorderIndex(node.data, inorderArray, start, end);

		node.left = buildTreeFromInOrderPreOrder(preorderArray, inorderArray, start, inoderIndex - 1);
		node.right = buildTreeFromInOrderPreOrder(preorderArray, inorderArray, inoderIndex + 1, end);

		return node;
	}

	private int getInorderIndex(int val, int in[], int start, int end) {
		for (int i = start; i <= end; i++) {
			if (in[i] == val) {
				return i;
			}
		}

		return -1;
	}

	public int heightIteratively(Node node) {
		if (node == null) {
			return -1;
		}

		Queue<Node> q = new LinkedList<Node>();
		q.add(node);
		int height = 0;

		while (true) {
			int size = q.size();
			if (size == 0) {
				break;
			}

			while (size > 0) {
				Node t = q.remove();
				if (t.left != null) {
					q.add(t.left);
				}

				if (t.right != null) {
					q.add(t.right);
				}

				size--;
			}

			height = height + 1;
		}
		return height;
	}

	public int height(Node node) {
		if (node == null) {
			return -1;
		}

		return Math.max(height(node.left), height(node.right)) + 1;
	}

	int diameter;

	public int getDiameter(Node node) {
		if (node == null) {
			return 0;
		}

		if (node.left == null && node.right == null) {
			return 1;
		}

		int lH = getDiameter(node.left);
		int rH = getDiameter(node.right);

		diameter = Math.max(diameter, lH + rH + 1);

		return Math.max(lH, rH) + 1;
	}

	public int ifHeightBalancedTree(Node node) {
		if (node == null) {
			return 0;
		}

		if (node.left == null && node.right == null) {
			return 1;
		}

		int lH = ifHeightBalancedTree(node.left);
		int rH = ifHeightBalancedTree(node.right);

		if (lH == -1 || rH == -1 || Math.abs(lH - rH) > 1) {
			return -1;
		}

		return Math.max(lH, rH) + 1;
	}

	public boolean ifRootToLeafPathSumMatches(Node node, int total) {
		if (node == null) {
			return false;
		}

		if (node.left == null && node.right == null && total == node.data)
			return true;

		return ifRootToLeafPathSumMatches(node.left, total - node.data)
				|| ifRootToLeafPathSumMatches(node.right, total - node.data);
	}

	public void printRootToLeaf(Node node) {
		if (node == null) {
			return;
		}

		int arr[] = new int[10];
		printRootToLeafImpl(node, arr, 0);
	}

	private void printRootToLeafImpl(Node node, int[] arr, int index) {
		if (node == null) {
			return;
		}

		arr[index] = node.data;

		if (node.left == null && node.right == null) {
			printArray(arr, index);
		}

		printRootToLeafImpl(node.left, arr, index + 1);
		printRootToLeafImpl(node.right, arr, index + 1);
	}

	private void printArray(int[] arr, int index) {
		for (int i = 0; i <= index; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	int maxSum;

	public void maxSumFromRootToLeaf(Node node, int sum) {
		if (node == null) {
			return;
		}

		if (node.left == null && node.right == null && sum + node.data > maxSum) {
			maxSum = sum + node.data;
			return;
		}

		maxSumFromRootToLeaf(node.left, sum + node.data);
		maxSumFromRootToLeaf(node.right, sum + node.data);
	}

	int sumRootToLeaf;

	public void sumRootToLeaf(Node node, int i) {
		if (node == null) {
			return;
		}

		if (node.left == null && node.right == null) {
			sumRootToLeaf = sumRootToLeaf + (i * 10 + node.data);
			return;
		}

		sumRootToLeaf(node.left, i * 10 + node.data);
		sumRootToLeaf(node.right, i * 10 + node.data);
	}

	int maximum = Integer.MIN_VALUE;
	int minimum = Integer.MAX_VALUE;

	public void findMinMaxValue(Node node) {
		if (node == null) {
			return;
		}

		if (node.data > maximum) {
			maximum = node.data;
		}

		if (node.data < minimum) {
			minimum = node.data;
		}

		findMinMaxValue(node.left);
		findMinMaxValue(node.right);
	}

	public int findMinHeightLevelwise(Node node) {
		if (node == null) {
			return 0;
		}

		int height = 1;

		Queue<Node> queue = new LinkedList<>();
		queue.add(node);

		while (true) {
			int size = queue.size();

			if (queue.isEmpty() || size == 0) {
				break;
			}

			while (size > 0) {
				Node temp = queue.remove();

				if (temp.left == null && temp.right == null) {
					return height;
				}

				if (temp.left != null) {
					queue.add(temp.left);
				}

				if (temp.right != null) {
					queue.add(temp.right);
				}

				size--;
			}

			height++;
		}

		return height;
	}

	public int minHeight(Node node) {
		if (node == null) {
			return 0;
		}

		if (node.left == null && node.right == null) {
			return 1;
		}

		if (node.left == null) {
			return minHeight(node.right) + 1;
		}

		if (node.right == null) {
			return minHeight(node.left) + 1;
		}

		return Math.min(minHeight(node.left), minHeight(node.right)) + 1;
	}

	int minHeight = Integer.MAX_VALUE;

	public void findMinHeightRecursive(Node node, int height) {
		if (node == null) {
			return;
		}

		if (node.left == null && node.right == null && height < minHeight) {
			minHeight = height;
		}

		findMinHeightRecursive(node.left, height + 1);
		findMinHeightRecursive(node.right, height + 1);
	}

	public int sumOfLeafNodes(Node node) {
		if (node == null) {
			return 0;
		}

		if (node.left == null && node.right == null) {
			return node.data;
		}

		return sumOfLeafNodes(node.left) + sumOfLeafNodes(node.right);
	}

	int sumOfLeafNode;

	public void sumOfLeafNodesAnother(Node node) {
		if (node == null) {
			return;
		}

		if (node.left == null && node.right == null) {
			sumOfLeafNode = sumOfLeafNode + node.data;
		}

		sumOfLeafNodes(node.left);
		sumOfLeafNodes(node.right);
	}

	public int sumOfLeftLeafNodes(Node node, boolean ifLeftLeaf) {
		if (node == null) {
			return 0;
		}

		if (node.left == null && node.right == null && ifLeftLeaf) {
			return node.data;
		}

		return sumOfLeftLeafNodes(node.left, true) + sumOfLeftLeafNodes(node.right, false);
	}

	int sumOfLeftLeafNode;

	public void sumOfLeftLeafNodesAnother(Node node, boolean ifLeftLeaf) {
		if (node == null) {
			return;
		}

		if (node.left == null && node.right == null && ifLeftLeaf) {
			sumOfLeftLeafNode = sumOfLeftLeafNode + node.data;
		}

		sumOfLeftLeafNodesAnother(node.left, true);
		sumOfLeftLeafNodesAnother(node.right, false);
	}

	public int getMinDistanceToLeaf(Node node) {
		if (node == null) {
			return Integer.MAX_VALUE;
		}

		if (node.left == null && node.right == null) {
			return 0;
		}

		return 1 + Math.min(getMinDistanceToLeaf(node.left), getMinDistanceToLeaf(node.right));
	}

	int levelOfLeaf;

	public boolean ifLeavesAtSameLevel(Node node, int level) {
		if (node == null) {
			return true;
		}

		if (node.left == null && node.right == null) {
			if (levelOfLeaf == 0) {
				levelOfLeaf = level;
				return true;
			}

			return levelOfLeaf == level;
		}

		return ifLeavesAtSameLevel(node.left, level + 1) && ifLeavesAtSameLevel(node.right, level + 1);
	}

	Node deepestLeftLeafNode;
	int currentLevel;

	public void deepestLeftLeafNode(Node node, int level, boolean ifLeft) {
		if (node == null) {
			return;
		}

		if (ifLeft && node.left == null && node.right == null && level > currentLevel) {
			deepestLeftLeafNode = node;
			currentLevel = level;
		}

		deepestLeftLeafNode(node.left, level + 1, true);
		deepestLeftLeafNode(node.right, level + 1, false);
	}

	int depthDeepestOldLevelNode;

	public void depthDeepestOddLevelNodeSecond(Node node, int level) {
		if (node == null) {
			return;
		}

		if (node.left == null && node.right == null && (level % 2 != 0) && (level > depthDeepestOldLevelNode)) {
			depthDeepestOldLevelNode = level;
		}

		depthDeepestOddLevelNodeSecond(node.left, level + 1);
		depthDeepestOddLevelNodeSecond(node.right, level + 1);
	}

	public Node removeNodesLessThanKLength(Node node, int k, int level) {
		if (node == null) {
			return null;
		}

		node.left = removeNodesLessThanKLength(node.left, k, level + 1);
		node.right = removeNodesLessThanKLength(node.right, k, level + 1);

		if (node.left == null && node.right == null && level < k) {
			return null;
		}

		return node;
	}

	public Node removeAllNodesIfSumGreaterThanK(Node node, int k, int s) {
		if (node == null) {
			return null;
		}

		node.left = removeAllNodesIfSumGreaterThanK(node.left, k, s + node.data);
		node.right = removeAllNodesIfSumGreaterThanK(node.right, k, s + node.data);

		if (node.left == null && node.right == null && (s + node.data) < k) {
			return null;
		}

		return node;
	}

	public boolean checkIfSequenceMatchedFromRootToLeaf(Node node, int[] sequence, int index) {
		if (node == null) {
			return false;
		}

		if (index >= sequence.length || node.data != sequence[index]) {
			return false;
		}

		if (node.left == null && node.right == null && index == sequence.length - 1) {
			return true;
		}

		return checkIfSequenceMatchedFromRootToLeaf(node.left, sequence, index + 1)
				|| checkIfSequenceMatchedFromRootToLeaf(node.right, sequence, index + 1);
	}

	public boolean printAncestors(Node node, int val) {
		if (node == null) {
			return false;
		}

		if (node.data == val) {
			System.out.println(node.data);
			return true;
		}

		if (printAncestors(node.left, val) || printAncestors(node.right, val)) {
			System.out.println(node.data);
			return true;
		}

		return false;
	}

	public Node getParent(Node node, int key) {
		if (node == null || node.data == key) {
			return null;
		}

		if ((node.left != null && node.left.data == key) || (node.right != null && node.right.data == key)) {
			return node;
		}

		Node l = getParent(node.left, key);

		if (l != null) {
			return l;
		}

		l = getParent(node.right, key);
		return l;
	}

	public Node getSibling(Node node, int key) {
		if (node == null || node.data == key) {
			return null;
		}

		if (node.left != null && node.left.data == key) {
			return node.right;
		}

		if (node.right != null && node.right.data == key) {
			return node.left;
		}

		Node l = getSibling(node.left, key);

		if (l != null) {
			return l;
		}

		l = getSibling(node.right, key);
		return l;
	}

	public boolean isSiblings(Node node, Node a, Node b) {
		if (node == null) {
			return false;
		}

		return (node.left == a && node.right == b) || (node.left == b && node.right == a) || isSiblings(node.left, a, b)
				|| isSiblings(node.right, a, b);
	}

	public boolean ifCousins(Node node, Node a, Node b) {
		if (node == null || a == null || b == null) {
			return false;
		}

		if (getLevelOfNode(node, a.data, 1) != getLevelOfNode(node, b.data, 1)) {
			return false;
		}

		return !isSiblings(node, a, b);
	}

//	start - LCA

	boolean ifN1Present = false;
	boolean ifN2Present = false;

	public Node findLowestCommonAncestor(Node node, int n1, int n2) {

		Node lca = this.findLowestCommonAncestorUtil(node, n1, n2);

		if (ifN1Present && ifN2Present) {
			return lca;
		} else if (!ifN1Present && !ifN2Present) {
			return null;
		} else {
			int val = lca.data == n1 ? n2 : n1;
			if (ifElementPresent(lca, val)) {
				return lca;
			}
		}

		return null;
	}

	public Node findLowestCommonAncestorUtil(Node node, int n1, int n2) {
		if (node == null) {
			return null;
		}

		if (node.data == n1) {
			ifN1Present = true;
			return node;
		}

		if (node.data == n2) {
			ifN2Present = true;
			return node;
		}

		Node leftLCA = findLowestCommonAncestorUtil(node.left, n1, n2);
		Node rightLCA = findLowestCommonAncestorUtil(node.right, n1, n2);

		if (leftLCA != null && rightLCA != null) {
			return node;
		}

		return leftLCA != null ? leftLCA : rightLCA;
	}

	private boolean ifElementPresent(Node node, int val) {
		if (node == null) {
			return false;
		}

		if (node.data == val) {
			return true;
		}

		return ifElementPresent(node.left, val) || ifElementPresent(node.right, val);
	}
//	end- LCA

//	start - distance from parent node
	public int distanceBetweenTwoNodes(Node node, int n1, int n2) {
		if (node == null) {
			return -1;
		}

		Node lca = this.findLowestCommonAncestor(node, n1, n2);

		if (lca == null) {
			return -1;
		}

		int d1 = distanceFromParentToNode(lca, n1, 0);
		int d2 = distanceFromParentToNode(lca, n2, 0);

		return d1 + d2;
	}

	public int distanceFromParentToNode(Node node, int val, int distance) {
		if (node == null) {
			return -1;
		}

		if (node.data == val) {
			return distance;
		}

		int d = distanceFromParentToNode(node.left, val, distance + 1);

		if (d != -1) {
			return d;
		}

		d = distanceFromParentToNode(node.right, val, distance + 1);

		return d;
	}

//	end - distance from parent node

	public int printElementsAtKDistance(Node node, Node targetNode, int k) {
		if (node == null || targetNode == null || k < 0) {
			return -1;
		}

		return printElementsAtKDistanceUtil(node, targetNode, k);
	}

	public int printElementsAtKDistanceUtil(Node node, Node targetNode, int k) {
		if (node == null) {
			return -1;
		}

		if (node == targetNode) {
			printNodesAtKDistanceFromParent(node, k);
			return 0;
		}

		int leftDist = printElementsAtKDistanceUtil(node.left, targetNode, k);

		if (leftDist != -1) {
			if (leftDist + 1 == k) {
				System.out.print(node.data + " ");
			} else {
				printNodesAtKDistanceFromParent(node.right, k - 2 - leftDist);
			}

			return leftDist + 1;
		}

		int rightDist = printElementsAtKDistanceUtil(node.right, targetNode, k);

		if (rightDist != -1) {
			if (rightDist + 1 == k) {
				System.out.print(node.data + " ");
			} else {
				printNodesAtKDistanceFromParent(node.left, k - 2 - rightDist);
			}

			return rightDist + 1;
		}

		return -1;
	}

	public void printNodesAtKDistanceFromParent(Node node, int k) {
		if (node == null) {
			return;
		}

		if (k == 0) {
			System.out.print(node.data + " ");
		}

		printNodesAtKDistanceFromParent(node.left, k - 1);
		printNodesAtKDistanceFromParent(node.right, k - 1);
	}

	public void printAllElementsAtKDistanceFromLeafNode(Node node, int k) {
		if (node == null || k < 0) {
			return;
		}

		int arr[] = new int[20];
		boolean visited[] = new boolean[20];

		printAllElementsAtKDistanceFromLeafNodeUtil(node, k, arr, visited, 0);
	}

	public void printAllElementsAtKDistanceFromLeafNodeUtil(Node node, int k, int[] arr, boolean[] visited, int count) {
		if (node == null) {
			return;
		}

		arr[count] = node.data;
		visited[count] = false;

		if (node.left == null && node.right == null && count - k >= 0 && visited[count - k] == false) {
			System.out.print(arr[count - k] + " ");
			visited[count - k] = true;
			return;
		}

		printAllElementsAtKDistanceFromLeafNodeUtil(node.left, k, arr, visited, count + 1);
		printAllElementsAtKDistanceFromLeafNodeUtil(node.right, k, arr, visited, count + 1);
	}

	int sum;
	int count;

	public void getAverage(Node node) {
		if (node == null) {
			return;
		}

		sum = sum + node.data;
		count = count + 1;

		getAverage(node.left);
		getAverage(node.right);
	}

	public int closestLeafNode(Node node, int val) {
		if (node == null) {
			return Integer.MAX_VALUE;
		}

		Node arr[] = new Node[10];
		return closestLeafNodeUtil(node, arr, val, 0);
	}

	public int closestLeafNodeUtil(Node node, Node arr[], int val, int level) {
		if (node == null) {
			return Integer.MAX_VALUE;
		}

		int minDistFromLeaf = Integer.MAX_VALUE;

		if (node.data == val) {
			minDistFromLeaf = getMinDistanceToLeaf(node);

			for (int i = level - 1; i >= 0; i--) {
				minDistFromLeaf = Math.min(minDistFromLeaf, level - i + getMinDistanceToLeaf(arr[i]));
			}

			return minDistFromLeaf;
		}

		arr[level] = node;

		minDistFromLeaf = Math.min(minDistFromLeaf, closestLeafNodeUtil(node.left, arr, val, level + 1));

		if (minDistFromLeaf != Integer.MAX_VALUE) {
			return minDistFromLeaf;
		}

		return Math.min(minDistFromLeaf, closestLeafNodeUtil(node.right, arr, val, level + 1));
	}

	public void serialize(Node node, List<Integer> list) {
		if (node == null) {
			list.add(-1);
			return;
		}

		list.add(node.data);

		serialize(node.left, list);
		serialize(node.right, list);
	}

	int deSerializeIndex = 0;

	public Node deSerialize(List<Integer> list) {
		if (list.get(deSerializeIndex) == -1) {
			deSerializeIndex++;
			return null;
		}

		Node newNode = createNewNode(list.get(deSerializeIndex++));

		newNode.left = deSerialize(list);
		newNode.right = deSerialize(list);

		return newNode;
	}

	Node prev = null;

	public boolean isTreeBST(Node node) {
		if (node == null) {
			return true;
		}

		if (!isTreeBST(node.left)) {
			return false;
		}

		if (prev != null && node.data < prev.data) {
			return false;
		}

		prev = node;

		return isTreeBST(node.right);
	}

	Node headLinkedList;
//	Node prev;

	public void bstToDoublyLinkedList(Node node) {
		if (node == null) {
			return;
		}

		bstToDoublyLinkedList(node.left);

		if (prev == null) {
			headLinkedList = node;
			prev = node;
		} else {
			node.left = prev;
			prev.right = node;
			prev = node;
		}

		bstToDoublyLinkedList(node.right);
	}

//	Node prev;

	public void connectNextPointerToInorderSuccessor(Node node) {
		if (node == null) {
			return;
		}

		connectNextPointerToInorderSuccessor(node.left);

		if (prev != null) {
			prev.next = node;
		}

		prev = node;

		connectNextPointerToInorderSuccessor(node.right);
	}

	public void getRightNodeRecursive(Node node, int key) {
		if (node == null || node.data == key) {
			return;
		}

		int levelOfKey = getLevelOfNode(node, key, 1);
		storeRightNode(node, key, levelOfKey);
	}

	Node rightNode;
	boolean flag;

	public void storeRightNode(Node node, int key, int level) {
		if (node == null) {
			return;
		}

		if (level == 1 & node.data == key) {
			if (flag) {
				rightNode = node;
				return;
			} else {
				flag = true;
			}
		}

		storeRightNode(node.left, key, level - 1);
		storeRightNode(node.right, key, level - 1);
	}

	public Node getRightNodeIterative(Node node, int key) {
		if (node == null || node.data == key) {
			return null;
		}

		Queue<Node> q = new LinkedList<Node>();
		q.add(node);

		boolean flag = false;

		while (true) {
			int size = q.size();

			if (size == 0 || flag) {
				break;
			}

			while (size > 0) {
				Node t = q.remove();
				if (flag) {
					return t;
				}

				if (t.data == key) {
					flag = true;
				}

				if (t.left != null) {
					q.add(t.left);
				}

				if (t.right != null) {
					q.add(t.right);
				}

				size--;
			}
		}

		return null;
	}

//	start - connect nodes at same level with next pointer

	public void connectNode(Node node) {
		Node previousNode;

		Queue<Node> q = new LinkedList<>();
		q.add(node);

		while (!q.isEmpty()) {
			int size = q.size();

			previousNode = null;

			while (size > 0) {
				node = q.remove();

				if (previousNode != null) {
					previousNode.next = node;
				}

				previousNode = node;

				if (node.left != null) {
					q.add(node.left);
				}

				if (node.right != null) {
					q.add(node.right);
				}

				size--;
			}
		}
	}

	public void connectNodeAtSameLevel(Node node) {
		if (node == null) {
			return;
		}

		while (node != null) {
			Node t = node;

			while (t != null) {
				if (t.left != null) {
					if (t.right != null) {
						t.left.next = t.right;
					} else {
						t.left.next = getNextRight(t);
					}
				}

				if (t.right != null) {
					t.right.next = getNextRight(t);
				}

				t = t.next;
			}

			if (node.left != null) {
				node = node.left;
			} else if (node.right != null) {
				node = node.right;
			} else {
				node = getNextRight(node);
			}
		}
	}

	public Node getNextRight(Node node) {
		Node tmp = node.next;

		while (tmp != null) {
			if (tmp.left != null) {
				return tmp.left;
			} else if (tmp.right != null) {
				return tmp.right;
			}
			tmp = tmp.next;
		}
		return null;
	}

//	end - connect nodes at same level with next pointer

//	start - Connect ‘next' pointer to Level Order Successor Node

	public void connectNodeLevelSuccessor(Node node) {
		Node previousNode = null;

		Queue<Node> q = new LinkedList<>();
		q.add(node);

		while (!q.isEmpty()) {
			int size = q.size();

			while (size > 0) {
				node = q.remove();

				if (previousNode != null) {
					previousNode.next = node;
				}

				previousNode = node;

				if (node.left != null) {
					q.add(node.left);
				}

				if (node.right != null) {
					q.add(node.right);
				}
				size--;
			}
		}
	}
//	end - Connect ‘next' pointer to Level Order Successor Node

//	start - Check if each parent contain sum of children

	public boolean ifParentContainSumofChildren(Node node) {
		if (node == null || (node.left == null && node.right == null)) {
			return true;
		}

		int a = node.left != null ? node.left.data : 0;
		int b = node.right != null ? node.right.data : 0;

		return (a + b == node.data) && ifParentContainSumofChildren(node.left)
				&& ifParentContainSumofChildren(node.right);
	}

//	end - Check if each parent contain sum of children

//	start - Check if each node contains the sum of left & right subtree (Sum Tree)

	public boolean ifSumTree(Node node) {
		int leftSum;
		int rightSum;

		if (node == null || ifLeafNode(node))
			return true;

		if (ifSumTree(node.left) && ifSumTree(node.right)) {
			if (node.left == null)
				leftSum = 0;
			else if (ifLeafNode(node.left))
				leftSum = node.left.data;
			else
				leftSum = 2 * (node.left.data);

			if (node.right == null)
				rightSum = 0;
			else if (ifLeafNode(node.right))
				rightSum = node.right.data;
			else
				rightSum = 2 * (node.right.data);

			if ((node.data == rightSum + leftSum))
				return true;
			else
				return false;
		}

		return false;
	}

	public boolean ifLeafNode(Node node) {
		if (node == null) {
			return false;
		}

		if (node.left == null && node.right == null) {
			return true;
		}

		return false;
	}

//	end - Check if each node contains the sum of left & right subtree (Sum Tree)

//	start - Get Diagonal Sum in Binary Tree

	public void diagonalSum(Node node) {
		if (node == null) {
			return;
		}

		Queue<Node> q = new LinkedList<Node>();
		q.add(node);

		while (true) {
			int size = q.size();

			if (size == 0) {
				break;
			}

			int s = 0;

			while (size > 0) {
				Node temp = q.remove();

				while (temp != null) {
					s = s + temp.data;

					if (temp.left != null) {
						q.add(temp.left);
					}

					temp = temp.right;
				}

				size--;
			}

			System.out.println(s);
		}
	}

//	end - Get Diagonal Sum in Binary Tree

//	start - Check if given Tree is Sub-Tree of Main Tree in Binary Tree

	public boolean isSubTree(Node main, Node sub) {
		if (sub == null) {
			return true;
		}

		if (main == null) {
			return false;
		}

		if (ifIdenticalTrees(main, sub)) {
			return true;
		}

		return isSubTree(main.left, sub) || isSubTree(main.right, sub);
	}

	public boolean ifIdenticalTrees(Node a, Node b) {
		if (a == null && b == null) {
			return true;
		}

		if (a == null || b == null) {
			return false;
		}

		return a.data == b.data && ifIdenticalTrees(a.left, b.left) && ifIdenticalTrees(a.right, b.right);
	}

	public boolean isSubTreeOptimized(Node main, int mainTreeNodes, Node sub, int subTreeNodes) {
		if (sub == null) {
			return true;
		}

		if (main == null) {
			return false;
		}

		int mainInorder[] = new int[mainTreeNodes];
		inorderFillArray(main, mainInorder);
		i = 0;

		int subInorder[] = new int[subTreeNodes];
		inorderFillArray(sub, subInorder);
		i = 0;

		String mainInorderString = arrayToString(mainInorder);
		String subInorderString = arrayToString(subInorder);

		if (!mainInorderString.contains(subInorderString)) {
			return false;
		}

		int mainPreorder[] = new int[mainTreeNodes];
		preorderFillArray(main, mainPreorder);
		i = 0;

		int subPreorder[] = new int[subTreeNodes];
		preorderFillArray(sub, subPreorder);

		String mainPreorderString = arrayToString(mainPreorder);
		String subPreorderString = arrayToString(subPreorder);

		return mainPreorderString.contains(subPreorderString);
	}

	int i;

	public void inorderFillArray(Node node, int a[]) {
		if (node == null) {
			return;
		}

		inorderFillArray(node.left, a);

		a[i++] = node.data;

		inorderFillArray(node.right, a);
	}

	public void preorderFillArray(Node node, int a[]) {
		if (node == null) {
			return;
		}

		a[i++] = node.data;

		preorderFillArray(node.left, a);
		preorderFillArray(node.right, a);
	}

	public String arrayToString(int a[]) {
		String s = "";
		for (int i = 0; i < a.length; i++) {
			s = s + a[i];
		}

		return s;
	}

//	end - Check if given Tree is Sub-Tree of Main Tree in Binary Tree

//	start - Get Max Sum between two Leaves in Binary Tree

	int maxSumBetweenTwoLeaves = 0;

	public int getMaxSumPathBetweenTwoLeaves(Node node) {
		if (node == null) {
			return 0;
		}

		if (node.left == null && node.right == null) {
			return node.data;
		}

		int l = getMaxSumPathBetweenTwoLeaves(node.left);
		int r = getMaxSumPathBetweenTwoLeaves(node.right);

		if (node.left != null && node.right != null) {
			if (l + r + node.data > maxSumBetweenTwoLeaves) {
				maxSumBetweenTwoLeaves = l + r + node.data;
			}

			return Math.max(l, r) + node.data;
		}

		return node.left != null ? l + node.data : r + node.data;
	}

//	end - Get Max Sum between two Leaves in Binary Tree

//	start - Get Max Sum path in binary tree

//	int maxSum = 0;

	public int maxSumPath(Node node) {
		if (node == null) {
			return 0;
		}

		if (node.left == null && node.right == null) {
			return node.data;
		}

		int l = maxSumPath(node.left);
		int r = maxSumPath(node.right);

		int max_one = Math.max(node.data, node.data + Math.max(l, r));

		int max_two = Math.max(max_one, l + r + node.data);

		maxSum = Math.max(maxSum, max_two);

		return max_one;
	}

//	end - Get Max Sum path in binary tree

//	start - Print all paths where sum of all the node values of each path equals given value

	List<Integer> elements = new ArrayList<Integer>();

	public void printKPathEqualToSum(Node node, int val) {
		if (node == null) {
			return;
		}

		elements.add(node.data);

		printKPathEqualToSum(node.left, val);
		printKPathEqualToSum(node.right, val);

		int sum = 0;

		for (int i = elements.size() - 1; i >= 0; i--) {

			sum = sum + elements.get(i);

			if (sum == val) {

				for (int j = i; j < elements.size(); j++) {
					System.out.print(elements.get(j) + " ");
				}

				System.out.println();
			}
		}

		elements.remove(elements.size() - 1);
	}

//	end - Print all paths where sum of all the node values of each path equals given value

//  start - level order average

	public List<Integer> levelOrderAverage(Node node) {
		if (node == null) {
			return new ArrayList<Integer>();
		}

		List<Integer> avgList = new ArrayList<Integer>();

		Queue<Node> q = new LinkedList<Node>();
		q.add(node);

		while (true) {
			int queueSize = q.size();
			if (queueSize == 0) {
				break;
			}

			int sum = 0;
			int count = 0;

			while (queueSize > 0) {
				Node headNode = q.remove();

				sum = sum + headNode.data;
				count++;

				if (headNode.left != null) {
					q.add(headNode.left);
				}

				if (headNode.right != null) {
					q.add(headNode.right);
				}

				queueSize--;
			}

			avgList.add(sum / count);
		}

		return avgList;
	}

//	end - level order average

//	start - Find all paths from root to leaf where sum of 
//	nodes is equal to given sum
	public List<List<Integer>> showAllSumPath(Node node, int sum) {
		List<List<Integer>> allSumPathList = new ArrayList<>();

		List<Integer> singlePath = new ArrayList<>();

		sumPathUtil(node, sum, allSumPathList, singlePath);

		return allSumPathList;
	}

	public void sumPathUtil(Node node, int sum, List<List<Integer>> allSumPathList, List<Integer> singlePath) {
		if (node == null) {
			return;
		}

		singlePath.add(node.data);

		if (node.left == null && node.right == null && node.data == sum) {
			allSumPathList.add(new ArrayList<>(singlePath));
		} else {
			sumPathUtil(node.left, sum - node.data, allSumPathList, singlePath);
			sumPathUtil(node.right, sum - node.data, allSumPathList, singlePath);
		}

		singlePath.remove(singlePath.size() - 1);
	}
//	end - Find all paths from root to leaf where sum of	nodes is equal to given sum

//	start- check if there exists a pair for given Sum in Binary Tree

	public boolean ifPairExists(Node node, int sum) {
		HashSet<Integer> set = new HashSet<>();

		return ifPairExistsUtil(node, sum, set);
	}

	public boolean ifPairExistsUtil(Node node, int sum, HashSet<Integer> set) {
		if (node == null) {
			return false;
		}

		if (set.contains(sum - node.data)) {
			return true;
		}

		set.add(node.data);

		if (ifPairExistsUtil(node.left, sum, set)) {
			return true;
		}

		return ifPairExistsUtil(node.right, sum, set);
	}

//	end- check if there exists a pair for given Sum in Binary Tree
	
	
	public boolean printAncestorsDummy(Node node, int val) {
		if (node == null) {
			return false;
		}

		if (node.data == val) {
			return true;
		}

		if (printAncestorsDummy(node.left, val) || printAncestorsDummy(node.right, val)) {
			System.out.println(node.data);
			return false;
		}

		return false;
	}

}
