package binaryTree.leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

// Definition for a binary tree node. 
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

class VerticalOrderTraversal {
	private Map<Integer, Queue<int[]>> nodeEntries = new HashMap<>();

	public List<List<Integer>> verticalTraversal(TreeNode root) {
		dfs(root, 0, 0);
		int minCol = Collections.min(nodeEntries.keySet());
		int maxCol = Collections.max(nodeEntries.keySet());

		List<List<Integer>> output = new ArrayList<>();
		for (int col = minCol; col <= maxCol; ++col) {
			output.add(new ArrayList<>());
			while (!nodeEntries.get(col).isEmpty()) {
				int[] entry = nodeEntries.get(col).remove();
				output.get(output.size() - 1).add(entry[1]);
			}
		}
		return output;

	}

	private void dfs(TreeNode root, int col, int row) {
		if (root == null)
			return;

		nodeEntries.putIfAbsent(col, new PriorityQueue<>((e1, e2) -> {
			if (e1[0] != e2[0])
				return e1[0] - e2[0];
			return e1[1] - e2[1];
		}));

		nodeEntries.get(col).add(new int[] { row, root.val });
		dfs(root.left, col - 1, row + 1);
		dfs(root.right, col + 1, row + 1);

	}
}
