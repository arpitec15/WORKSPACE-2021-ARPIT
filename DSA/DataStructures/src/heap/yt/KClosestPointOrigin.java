package heap.yt;

import java.util.Comparator;
import java.util.PriorityQueue;

class PairC {
	int first, second;

	PairC(int a, int b) {
		first = a;
		second = b;
	}

}

class KClosestPointOrigin {

// Function to find the K closest points
	static void kClosestPoints(int x[], int y[], int n, int k) {

		Comparator<PairC> cmp = (p1, p2) -> {
			return (int) ((Math.pow(p1.first, 2) + (int) Math.pow(p1.second, 2))
					- (Math.pow(p2.first, 2) + (int) Math.pow(p2.second, 2)));
//			return p1.first - p2.second;
		};
		// Create a priority queue
		PriorityQueue<PairC> pq = new PriorityQueue<>(cmp);

		// Pushing all the points
		// in the queue
		for (int i = 0; i < n; i++) {
			pq.add(new PairC(x[i], y[i]));
		}

		// Print the first K elements
		// of the queue
		for (int i = 0; i < k; i++) {
			// Remove the top of the queue
			// and store in a temporary pair
			PairC p = pq.poll();

			// Print the first (x)
			// and second (y) of pair
			System.out.println(p.first + " " + p.second);
		}
	}

// Driver code
	public static void main(String[] args) {

		// x coordinate of points
		int x[] = { 5, -2, 0, 10 };

		// y coordinate of points
		int y[] = { 5, 2, 1, 10 };
		int K = 1;

		int n = x.length;

		kClosestPoints(x, y, n, K);
	}
}