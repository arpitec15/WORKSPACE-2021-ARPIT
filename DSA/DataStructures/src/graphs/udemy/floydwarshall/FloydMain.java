package graphs.udemy.floydwarshall;

import java.util.ArrayList;

import graphs.udemy.bellmanFord.WeightedGraph;

public class FloydMain {

	public static void main(String[] args) {

		ArrayList<WeightedNode> nodeList = new ArrayList<>();
		nodeList.add(new WeightedNode("A", 0));
		nodeList.add(new WeightedNode("B", 1));
		nodeList.add(new WeightedNode("C", 2));
		nodeList.add(new WeightedNode("D", 3));

		FloydWarshall f = new FloydWarshall(nodeList);
		f.addWeightedEdge(0, 3, 1);
		f.addWeightedEdge(0, 1, 8);
		f.addWeightedEdge(1, 2, 1);
		f.addWeightedEdge(2, 0, 4);
		f.addWeightedEdge(3, 1, 2);
		f.addWeightedEdge(3, 2, 9);

		System.out.println("Floyd Warshall Algo ");
		f.floydWarshall();
	}

}
