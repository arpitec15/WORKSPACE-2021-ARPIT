package arrays.educative;

public class MaxSumSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 1, 7, -2, -5, 10, -1 };

		int maxSum = findMaxSumSubArray(arr);
		System.out.println(maxSum);

	}

	public static int findMaxSumSubArray(int[] arr) {

		int max_so_far = arr[0];
		int current_max = arr[0];

		for (int i = 1; i < arr.length; i++) {

			current_max = Math.max(current_max + arr[i], arr[i]);
			max_so_far = Math.max(current_max, max_so_far);
		}

		return max_so_far;

	}
}
