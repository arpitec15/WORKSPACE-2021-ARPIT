package dp.educative.boundedKnapSack;

import java.util.Arrays;

public class MinSubsetSumDiff {

	public static void main(String[] args) {

//		int num[] = { 1, 6, 11, 5 };
		int num[] = { 1, 3, 100, 4 };

		int output = minSubsetDiffRecursive(num);
//		int output = minSubsetDiffDP_optimized(num);

		System.out.println(output);

	}

	private static int minSubsetDiffRecursive(int[] num) {

//		return minDiffRecursive(num, 0, 0, 0);

//		Memoization

		int sum = 0;
		for (int i = 0; i < num.length; i++)
			sum += num[i];

		Integer[][] dp = new Integer[num.length][sum + 1];
		return minDiffRecursiveMemoization(dp, num, 0, 0, 0);
	}

	private static int minDiffRecursiveMemoization(Integer[][] dp, int[] num, int currentIndex, int sum1, int sum2) {

		// base check
		if (currentIndex == num.length)
			return Math.abs(sum1 - sum2);

		// check if we have not already processed similar problem
		if (dp[currentIndex][sum1] == null) {
			// recursive call after including the number at the currentIndex in the first
			// set
			int diff1 = minDiffRecursiveMemoization(dp, num, currentIndex + 1, sum1 + num[currentIndex], sum2);

			// recursive call after including the number at the currentIndex in the second
			// set
			int diff2 = minDiffRecursiveMemoization(dp, num, currentIndex + 1, sum1, sum2 + num[currentIndex]);

			dp[currentIndex][sum1] = Math.min(diff1, diff2);
		}

		return dp[currentIndex][sum1];
	}

	private static int minDiffRecursive(int[] num, int currentIndex, int sum1, int sum2) {

		// base check
		if (currentIndex == num.length)
			return Math.abs(sum1 - sum2);

		// recursive call after including the number at the currentIndex in the first
		// set
		int diff1 = minDiffRecursive(num, currentIndex + 1, sum1 + num[currentIndex], sum2);

		// recursive call after including the number at the currentIndex in the second
		// set
		int diff2 = minDiffRecursive(num, currentIndex + 1, sum1, sum2 + num[currentIndex]);

		return Math.min(diff1, diff2);

	}

	private static int minSubsetDiffDP_optimized(int[] num) {

		int sum = 0;
		for (int i : num) {
			sum += i;
		}

		boolean[] dp = new boolean[sum + 1];

		dp[0] = true;

		for (int n : num) {
			for (int i = sum; i > 0; i--) {
				if (i >= n) {
					dp[i] = dp[i] || dp[i - n];
				}
			}
		}

		int output = 0;
		for (int i = dp.length / 2; i >= 0; i--) {
			if (dp[i]) {
				output = Math.abs(sum - (i * 2));
				break;
			}
		}

		return output;
	}

}
