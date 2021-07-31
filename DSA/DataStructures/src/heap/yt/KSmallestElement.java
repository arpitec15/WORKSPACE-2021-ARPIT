package heap.yt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class KSmallestElement {
	private static List<Integer> FirstKelements(int[] arr, int size, int k) {
		List<Integer> list = new ArrayList<>();
		PriorityQueue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < arr.length; i++) {

			if (minHeap.size() < k)
				minHeap.add(arr[i]);

			else if (arr[i] > minHeap.peek()) {
				minHeap.poll();
				minHeap.add(arr[i]);
			}
			if (minHeap.size() >= k)
				list.add(minHeap.peek());
			else
				list.add(-1);
		}
		return list;

	}

	public static void main(String[] args) {

		int arr[] = { 0, 2, 1, 13, 6, 7 };
		int size = arr.length;
		int k = 3;
		List<Integer> firstKelements = FirstKelements(arr, size, k);
		System.out.println(firstKelements);
	}

}
