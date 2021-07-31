package heap.yt;

import java.util.Comparator;
import java.util.PriorityQueue;

class Pair {
	Integer key;
	Integer value;

	public Pair(Integer key, Integer value) {
		this.key = key;
		this.value = value;
	}

	public Integer getKey() {
		return key;
	}

	public void setKey(Integer key) {
		this.key = key;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
}

public class KClosestElement {

	public static void printKclosest(int[] arr, int n, int x, int k) {
		
		Comparator<Pair> cmp = (p1,p2) -> p2.getValue().compareTo(p1.getValue());

// Make a max heap.
		PriorityQueue<Pair> pq = new PriorityQueue<>(cmp);

// Build heap of difference with first k elements
		
		for (int i = 0; i < k; i++) {
			pq.offer(new Pair(arr[i], Math.abs(arr[i] - x)));
		}

// Now process remaining elements.
		for (int i = k; i < n; i++) {
			int diff = Math.abs(arr[i] - x);

// If difference with current element is more than root, then ignore it.
			if (diff > pq.peek().getValue())
				continue;

// Else remove root and insert
			pq.poll();
			pq.offer(new Pair(arr[i], diff));
		}

// Print contents of heap.
		while (!pq.isEmpty()) {
			System.out.print(pq.poll().getKey() + " ");
		}
	}

	public static void main(String[] args) {
		int arr[] = { -10, -50, 21, 17, 80 };
		int x = 20, k = 1;
		int n = arr.length;

		printKclosest(arr, n, x, k);

	}

}
