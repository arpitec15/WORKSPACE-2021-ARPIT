package graphs.udemy.graphAdjacencyList;

import java.util.ArrayList;

public class GraphMain {

	public static void main(String[] args) {

		ArrayList<GraphNode> nodeList = new ArrayList<>();
		nodeList.add(new GraphNode("A", 0));
		nodeList.add(new GraphNode("B", 1));
		nodeList.add(new GraphNode("C", 2));
		nodeList.add(new GraphNode("D", 3));
		nodeList.add(new GraphNode("E", 4));
		nodeList.add(new GraphNode("F", 5));
		nodeList.add(new GraphNode("G", 6));
		nodeList.add(new GraphNode("H", 7));

		Graph topoGraph = new Graph(nodeList);
		topoGraph.addDirectedEdge(0, 2);
		topoGraph.addDirectedEdge(2, 4);
		topoGraph.addDirectedEdge(4, 7);
		topoGraph.addDirectedEdge(4, 5);
		topoGraph.addDirectedEdge(5, 6);
		topoGraph.addDirectedEdge(1, 2);
		topoGraph.addDirectedEdge(1, 3);
		topoGraph.addDirectedEdge(3, 5);

		System.out.println(topoGraph.toString());
		topoGraph.topologicalSort();
	}

}
