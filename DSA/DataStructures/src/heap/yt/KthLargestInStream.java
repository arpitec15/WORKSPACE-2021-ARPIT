package heap.yt;

import java.util.PriorityQueue;

class KthLargest {
	final PriorityQueue<Integer> q;
	final int k;

	public KthLargest(int k, int[] nums) {
		this.k = k;
		q = new PriorityQueue<Integer>(k);
//		for (int a : nums) {
//			add(a);
//		}
	}

	public int add(int val) {
		q.offer(val);
		if (q.size() > k) {
			q.poll();
		}
		return q.peek();
	}

	public static void main(String[] args) {
		int arr[] = { 1, 3, 5, 11, 12, 15 };
		int k = 3;
		KthLargest stream = new KthLargest(2, arr);
		for (int i : arr) {
			int add = stream.add(i);
			System.out.println("Adding i " + i + " and Kth largest is " + add);
		}
	}
}
