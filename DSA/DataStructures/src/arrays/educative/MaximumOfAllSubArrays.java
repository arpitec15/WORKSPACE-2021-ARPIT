package arrays.educative;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MaximumOfAllSubArrays {

	public static void main(String[] args) {

//		int arr[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
//		int arr[] = { -7,-8,7,5,7,1,6,0 };
//		int arr[] = { 1 };
//		int arr[] = {9,11};
//		int arr[] = {4,3,11};
		int arr[] = { -6, -10, -7, -1, -9, 9, -8, -4, 10, -5, 2, 9, 0, -7, 7, 4, -2, -10, 8, 7 };

		int k = 7;
		int[] maxSubArrayInt = maxSubArrayInt(arr, k);
		System.out.println(Arrays.toString(maxSubArrayInt));

	}


	private static int[] maxSubArrayInt(int[] arr, int k) {

		List<Integer> list = new ArrayList<>();

		int i = 0, j = 0;

		Deque<Integer> queue = new LinkedList<>();

		while (j < arr.length) {

//			Add till the window completes
			if (j - i + 1 < k) {

//				make sure largest element is at the peek of the queue
				while (!queue.isEmpty() && arr[j] > queue.peekLast()) {
					queue.pollLast();
				}

				queue.add(arr[j]);
				++j;

			}

			else if (j - i + 1 == k) {

//				remaining one of the window. Will run only one time
				if (j == k - 1) {
					while (!queue.isEmpty() && arr[j] > queue.peekLast()) {
						queue.pollLast();
					}
					queue.addLast(arr[j]);
				}

				list.add(queue.peek());

				if (arr[i] == queue.peek()) {
					queue.remove();
				}

				++i;
				++j;

				if (j == arr.length) {
					break;
				}
				while (!queue.isEmpty() && arr[j] > queue.peekLast()) {
					queue.pollLast();
				}

				queue.offerLast(arr[j]);
			}

		}

		int[] output1 = new int[list.size()];

		for (int p = 0; p < list.size(); p++) {
			output1[p] = list.get(p);
		}

		return output1;

	}

}
