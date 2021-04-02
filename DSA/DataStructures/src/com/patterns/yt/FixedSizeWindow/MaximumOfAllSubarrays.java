package com.patterns.yt.FixedSizeWindow;

import java.util.Deque;
import java.util.LinkedList;

public class MaximumOfAllSubarrays {

	public static void main(String[] args) {

		int arr[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int k = 3;
		maxSubArray(arr, k);
//		maxSubArrays(arr, k);
	}

	public static void maxSubArray(int[] arr, int k) {

		Deque<Integer> queue = new LinkedList<Integer>();

		int i = 0, j = 0;

		while (j < arr.length) {

			if (j - i + 1 < k) {

				if (!queue.isEmpty() && queue.peek() < arr[j]) {
					queue.remove();
				}

				queue.add(arr[j]);
				++j;

			}

			if (j - i + 1 == k) {
				System.out.print(queue.peek() + "  ");

				if (arr[i] == queue.peek()) {
					queue.remove();
				}

				++i;
				++j;

				if (j == arr.length) {
					return;
				}
				while (!queue.isEmpty() && arr[j] > queue.peekLast()) {
					queue.pollLast();
				}

//				queue.addLast(arr[j]);
				queue.offerLast(arr[j]);
			}

		}

	}

	public static void maxSubArrays(int[] arr, int k) {

//		Corner test cases
		if (arr.length == 0 || k <= 0 || k > arr.length) {
			return;
		}

		Deque<Integer> queue = new LinkedList<>();
		int i;
		for (i = 0; i < k; i++) {
			while (!queue.isEmpty() && arr[i] >= arr[queue.peekLast()]) {
				queue.removeLast();
			}

			queue.addLast(i);
		}

		for (; i < arr.length; i++) {
			System.out.print(arr[queue.peek()] + " ");

//			Checking window size
			while (!queue.isEmpty() && i - k >= queue.peek()) {
				queue.removeFirst();
			}

//			If element to be added is greater than existing elements
			while (!queue.isEmpty() && arr[i] >= arr[queue.peekLast()]) {
				queue.removeLast();
			}

			queue.addLast(i);
		}

		System.out.print(arr[queue.peek()]);
	}
}
