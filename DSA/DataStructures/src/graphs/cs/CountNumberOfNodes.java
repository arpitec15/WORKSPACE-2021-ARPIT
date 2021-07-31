package graphs.cs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Graph8 {
	List<List<Integer>> graph;
	boolean visited[];
	int nodes;

	Graph8(int nodes) {
		graph = new ArrayList<>();
		visited = new boolean[nodes];
		this.nodes = nodes;

		for (int i = 0; i < nodes; i++) {
			graph.add(i, new ArrayList<>());
		}
	}

	public void addEdge(int a, int b) {
		graph.get(a).add(b);
		graph.get(b).add(a);
	}

	public int countNumberOfNodes(Graph8 a) {
		int sum = 0;
		Stack<Integer> stack = new Stack<>();

		stack.push(0);
		visited[0] = true;

		for (int i = 0; i < graph.size(); i++) {
			sum = sum + graph.get(i).size();
		}

		return sum / 2;
	}

}

public class CountNumberOfNodes {

	public static void main(String[] args) {

		int nodes = 4;
		Graph8 a = new Graph8(nodes);

		a.addEdge(0, 1);
		a.addEdge(1, 2);
		a.addEdge(2, 3);
		a.addEdge(3, 1);
		a.addEdge(3, 0);

		int count = a.countNumberOfNodes(a);
		System.out.println(count);
	}

}
