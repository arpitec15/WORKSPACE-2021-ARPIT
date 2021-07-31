package heap.yt;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

public class SumBetweenKSmallest {

	private static void SumBWKSmallest(int[] arr, int size, int k1, int k2) {
		// Creating Min Heap for given
		// array with only k elements
		// Create min heap with priority queue
		int[] arrE = new int[2];
		PriorityQueue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder());
		int j = 0;
		while (j < 2) {
			minHeap.clear();
			for (int i = 0; i < k1; i++) {
				minHeap.add(arr[i]);
			}

			// Loop For each element in array
			// after the kth element
			for (int i = k1; i < size; i++) {

				// If current element is smaller
				// than minimum ((top element of
				// the minHeap) element, do nothing
				// and continue to next element
				if (minHeap.peek() < arr[i])
					continue;

				// Otherwise Change minimum element
				// (top element of the minHeap) to
				// current element by polling out
				// the top element of the minHeap
				else {
					minHeap.poll();
					minHeap.add(arr[i]);
				}
			}

			arrE[j] = minHeap.poll();

			++j;
			k1 = k2;
		}

		System.out.println(Arrays.toString(arrE));
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < arrE[1] && arr[i] > arrE[0]) {
				sum = sum + arr[i];
			}
		}
		System.out.println("Sum is " + sum);

	}

	public static void main(String[] args) {

		int arr[] = { 1, 3, 5, 11, 12, 15 };

		int size = arr.length;

		// Size of Min Heap
		int k1 = 3;
		int k2 = 6;

		SumBWKSmallest(arr, size, k1, k2);

	}

}
