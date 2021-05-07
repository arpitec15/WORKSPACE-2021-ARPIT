package binaryTree.cs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

class Node {
	int data;
	Node left;
	Node right;
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

}
