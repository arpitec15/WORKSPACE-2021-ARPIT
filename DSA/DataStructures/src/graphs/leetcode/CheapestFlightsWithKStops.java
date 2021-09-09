package graphs.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class CheapestFlightsWithKStops {

	public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

		// Build the adjacency matrix
		int adjMatrix[][] = new int[n][n];
		for (int[] flight : flights) {
			adjMatrix[flight[0]][flight[1]] = flight[2];
		}

		// Shortest distances array
		int[] distances = new int[n];

		// Shortest steps array
		int[] currentStops = new int[n];
		Arrays.fill(distances, Integer.MAX_VALUE);
		Arrays.fill(currentStops, Integer.MAX_VALUE);
		distances[src] = 0;
		currentStops[src] = 0;

		// The priority queue would contain (node, cost, stops)
		PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
		minHeap.offer(new int[] { src, 0, 0 });

		while (!minHeap.isEmpty()) {

			int[] info = minHeap.poll();
			int node = info[0], stops = info[2], cost = info[1];

			// If destination is reached, return the cost to get here
			if (node == dst) {
				return cost;
			}

			// If there are no more steps left, continue
			if (stops == K + 1) {
				continue;
			}

			// Examine and relax all neighboring edges if possible
			for (int neighbour = 0; neighbour < n; neighbour++) {
				if (adjMatrix[node][neighbour] > 0) {
					int costTillSource = cost, minCostTillNode = distances[neighbour],
							sourceToDestDirectFlightCost = adjMatrix[node][neighbour];

					// Better cost?
					if (costTillSource + sourceToDestDirectFlightCost < minCostTillNode) {
						minHeap.offer(
								new int[] { neighbour, costTillSource + sourceToDestDirectFlightCost, stops + 1 });
						distances[neighbour] = costTillSource + sourceToDestDirectFlightCost;
					} else if (stops < currentStops[neighbour]) {
						// Better steps?
						minHeap.offer(
								new int[] { neighbour, costTillSource + sourceToDestDirectFlightCost, stops + 1 });
					}
					currentStops[neighbour] = stops;
				}
			}
		}

		return distances[dst] == Integer.MAX_VALUE ? -1 : distances[dst];
	}

	public static void main(String[] args) {

		int[][] flights = { { 0, 1, 100 }, { 1, 2, 100 }, { 0, 2, 500 } };
		int src = 0;
		int dest = 2;
		int k = 1;
		int n = 3;
		int cheapestPrice = findCheapestPrice(n, flights, src, dest, k);
		System.out.println(cheapestPrice);
	}

}
