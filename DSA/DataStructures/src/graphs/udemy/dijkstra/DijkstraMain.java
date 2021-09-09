package graphs.udemy.dijkstra;

import java.util.ArrayList;

public class DijkstraMain {

	public static void main(String[] args) {

		ArrayList<WeightedNode> nodeList = new ArrayList<>();
		nodeList.add(new WeightedNode("A", 0));
		nodeList.add(new WeightedNode("B", 1));
		nodeList.add(new WeightedNode("C", 2));
		nodeList.add(new WeightedNode("D", 3));
		nodeList.add(new WeightedNode("E", 4));
		nodeList.add(new WeightedNode("F", 5));
		nodeList.add(new WeightedNode("G", 7));

		WeightedGraph dij = new WeightedGraph(nodeList);

		dij.addWeightedEdge(0, 1, 2);
		dij.addWeightedEdge(1, 2, 6);
		dij.addWeightedEdge(0, 2, 5);
		dij.addWeightedEdge(1, 3, 1);
		dij.addWeightedEdge(1, 4, 3);
		dij.addWeightedEdge(2, 5, 8);
		dij.addWeightedEdge(2, 4, 4);
		dij.addWeightedEdge(4, 6, 9);
		dij.addWeightedEdge(5, 6, 7);

		System.out.println("Printing dijkstra from source A ");
		dij.dijkstra(nodeList.get(0));
	}

}
