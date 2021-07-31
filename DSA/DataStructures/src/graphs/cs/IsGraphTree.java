package graphs.cs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Graph9 {

	List<List<Integer>> graph;
	boolean visited[];
	int nodes;

	public Graph9(int nodes) {
		graph = new ArrayList<>();
		visited = new boolean[nodes];
		this.nodes = nodes;

		for (int i = 0; i < nodes; i++) {
			graph.add(i, new ArrayList<>());
		}
	}

	public void addEdge(int a, int b) {
		graph.get(a).add(b);
	}

	public boolean isTree(Graph9 graphs) {
		int start = 0;
		int numVisited = 1;
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
					numVisited++;
				} else
					return false;
			}
		}

		if (numVisited == graphs.nodes)
			return true;
		else
			return false;
	}
}

public class IsGraphTree {

	public static void main(String[] args) {

		int nodes = 6;
		Graph9 a = new Graph9(nodes);
		a.addEdge(0, 1);
		a.addEdge(1, 3);
		a.addEdge(0, 2);
		a.addEdge(2, 4);
		a.addEdge(0, 5);
		boolean out = a.isTree(a);
		System.out.println(out);
	}

}
