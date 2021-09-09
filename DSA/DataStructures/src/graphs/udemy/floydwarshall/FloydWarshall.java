package graphs.udemy.floydwarshall;

import java.util.ArrayList;
import java.util.Map;

import graphs.udemy.bellmanFord.WeightedNode;

public class FloydWarshall {

	ArrayList<graphs.udemy.floydwarshall.WeightedNode> nodeList = new ArrayList<>();

	// Constructor
	public FloydWarshall(ArrayList<graphs.udemy.floydwarshall.WeightedNode> nodeList) {
		this.nodeList = nodeList;
	}

	void floydWarshall() {
		int size = nodeList.size();
		int[][] V = new int[size][size];

		// Initializing Distance table from adjacency list
		for (int i = 0; i < size; i++) {
			graphs.udemy.floydwarshall.WeightedNode first = nodeList.get(i);
			for (int j = 0; j < size; j++) {
				graphs.udemy.floydwarshall.WeightedNode second = nodeList.get(j);
				if (i == j)
					V[i][j] = 0;
				else if (first.weightMap.containsKey(second)) { // we have direct edge between i & j
					V[i][j] = first.weightMap.get(second);
				} else { // no direct edge between i & j, so mark it as infinity [divided by 10 to avoid
							// arithmetic overflow]
					V[i][j] = Integer.MAX_VALUE / 10;
				}
			}
		} // end of loop

		// Floyd Warshall's Algorithm
		for (int k = 0; k < nodeList.size(); k++) {
			for (int i = 0; i < nodeList.size(); i++) {
				for (int j = 0; j < nodeList.size(); j++) {
					if (V[i][j] > V[i][k] + V[k][j]) { // if update possible, then update path
						V[i][j] = V[i][k] + V[k][j]; // this will keep a track on path
					}
				}
			}
		} // end of loop

		// Print table of node with minimum distance and shortest path from each source
		for (int i = 0; i < size; i++) {
			System.out.print("Printing distance list for node " + nodeList.get(i) + ": ");
			for (int j = 0; j < size; j++) {
				System.out.print(V[i][j] + " ");
			}
			System.out.println();
		}

	}// end of method

	public void addWeightedEdge(int i, int j, int d) {
		graphs.udemy.floydwarshall.WeightedNode first = nodeList.get(i);
		graphs.udemy.floydwarshall.WeightedNode second = nodeList.get(j);
		first.neighbors.add(second);
		first.weightMap.put(second, d);
	}

}// end of class
