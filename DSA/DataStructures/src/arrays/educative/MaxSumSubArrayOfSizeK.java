package arrays.educative;

public class MaxSumSubArrayOfSizeK {

	public static void main(String[] args) {

		int[] arr = { 2, 1, 5, 1, 3, 2 };
		int k = 3;
		int maxSum = findMaxSumSubArray(k, arr);
		System.out.println("Max sum is "+ maxSum);

	}

	public static int findMaxSumSubArray(int k, int[] arr) {
		// TODO: Write your code here
		int i = 0;
		int j = 0;
		int sum = 0;
		int maxSum = 0;
		while (j < arr.length) {
			sum = sum + arr[j];
			if (j - i + 1 == k) {
				maxSum = Math.max(sum, maxSum);
				sum = sum - arr[i];
				i++;
				j++;
			}

			else {
				++j;

			}

		}
		return maxSum;
	}

}
