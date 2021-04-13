package arrays.educative;

import java.util.*;

class TripletSumToZero {

	public static List<List<Integer>> findTriplets(int[] arr, int targetSum) {
		Arrays.sort(arr);

		List<List<Integer>> allTriplets = new ArrayList<>();

		for (int i = 0; i < arr.length - 2; i++) {
			int sum = targetSum - arr[i];

			int start = i + 1;
			int end = arr.length - 1;

			while (start < end) {
				int t = arr[start] + arr[end];
				if (t == sum) {
					allTriplets.add(Arrays.asList(arr[start], arr[end], arr[i]));
					start++;
					end--;
				} else if (t < sum) {
					start++;
				} else {
					end--;
				}
			}
		}

		return allTriplets;
	}

	public static void main(String[] args) {
//		int arr[] = { -3, 0, 1, 2, -1, 1, -2 };
//		int arr[] = { -5, 2, -1, -2, 3  };
		int arr[] = { -3, -1, 1, 2  };

		System.out.println(TripletSumToZero.findTriplets(arr, 1));
	}

}