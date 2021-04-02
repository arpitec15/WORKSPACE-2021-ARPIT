package com.aditya.FixedSizeWindow;

public class MaxSumContiguousArray {

	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 4, 2, 2, 2 };
		int k = 3;
		int out = maxArray(arr, k);
		System.out.println(out);
	}

	public static int maxArray(int[] arr, int k) {

		int max_sum_so_far = Integer.MIN_VALUE;
		int sum = 0;
		int i = 0, j = 0;

		while (j < arr.length) {
			
			sum = sum + arr[j];
			if (j - i + 1 == k) {
				max_sum_so_far = Math.max(max_sum_so_far, sum);
				sum = sum - arr[i];
				++j;
				++i;
			}
			
			else if (j - i + 1 < k) {
				++j;
			}
		}
		return max_sum_so_far;
	}

}
