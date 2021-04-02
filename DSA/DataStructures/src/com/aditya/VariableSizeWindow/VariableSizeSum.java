package com.aditya.VariableSizeWindow;

public class VariableSizeSum {

	public static void main(String[] args) {

		int arr[] = { 4, 1, 1, 1, 2, 3, 5 };
		int sum = 5;
		int max = maxSizeSumArray(arr, sum);
		System.out.println("Maximum length of sub array is " + max);
	}

	public static int maxSizeSumArray(int[] arr, int k) {

		int i = 0, j = 0;
		int sum = 0, max = 0;

		while (j < arr.length) {

			sum = sum + arr[j];

			if (sum > k) {
				while (sum > k) {
					sum = sum - arr[i];
					++i;
				}
				++j;
			}

			if (sum == k) {
				max = Math.max(j - i + 1, max);
				++j;
			}

			if (sum < k) {
				++j;
			}
		}

		return max;
	}
}
