package graphs.cs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Graph7 {
	List<List<Integer>> graph;
	boolean visited[], recursiveStack[];
	int nodes;
	int lastV;

	Graph7(int nodes) {
		graph = new ArrayList<>();
		visited = new boolean[nodes];
		recursiveStack = new boolean[nodes];
		this.nodes = nodes;

		for (int i = 0; i < nodes; i++) {
			graph.add(i, new ArrayList<>());
		}
	}

	public void addEdge(int a, int b) {
		graph.get(a).add(b);
	}

	public void dfs(int start) {
		Stack<Integer> stack = new Stack<>();

		stack.push(start);
		visited[start] = true;

		while (!stack.isEmpty()) {
			Integer node = stack.pop();
			List<Integer> neighboursList = graph.get(node);

			for (Integer neighbour : neighboursList) {
				if (!visited[neighbour]) {
					stack.push(neighbour);
					visited[neighbour] = true;
				}
			}
		}
	}

	public int motherVertex(Graph7 a) {

		for (int i = 0; i < a.nodes; i++) {
			if (visited[i] == false) {
				dfs(i);
				lastV = i;
			}
		}

		Arrays.fill(visited, false);
		dfs(lastV);
		if (lastVisited() == 0)
			return lastV;
		return -1;

	}

	private int lastVisited() {
		int lastV = 0;
		int j = 0;
		for (Boolean visitedA : visited) {
			if (visitedA == false) {
				lastV = j;
			}
			j++;
		}
		return lastV;
	}
}

public class MotherVertex {

	public static void main(String[] args) {
		int nodes = 4;
		Graph7 a = new Graph7(nodes);
		a.addEdge(0, 1);
		a.addEdge(1, 2);
		a.addEdge(3, 1);
		a.addEdge(3, 0);
		

		System.out.println(a.motherVertex(a));
	}

}