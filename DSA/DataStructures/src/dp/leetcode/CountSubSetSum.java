package dp.leetcode;

import java.util.Arrays;

public class CountSubSetSum {

	public static void main(String[] args) {
		int arr[] = { 2, 3, 5, 6, 8, 10 };
		int target = 10;
		int n = arr.length;

//		Recursive
//		int s = 0;
//		int out = isSubSetSumRecursive(arr, n, target, s, 0);
//		System.out.println(out);

//		Memoization
//		int[][] memo = new int[n + 1][target + 1];
//		Arrays.stream(memo).forEach(a -> Arrays.fill(a, -1));
//		int outMemo = isSubSetSumMemo(arr, n, target, 0, 0, memo);
//		System.out.println(outMemo);

//		DP

		int[][] dp = new int[n + 1][target + 1];
		int outDP = isSubSetSumDP(arr, n, target, dp);
		System.out.println(outDP);

	}

	private static int isSubSetSumRecursive(int[] arr, int n, int sum, int s, int count) {

		if (n == 0) {
			if (sum == s) {
				++count;
			}

			return count;
		}

		if (arr[n - 1] > sum)
			return isSubSetSumRecursive(arr, n - 1, sum, s, count);

		count = isSubSetSumRecursive(arr, n - 1, sum, s + arr[n - 1], count);
		count = isSubSetSumRecursive(arr, n - 1, sum, s, count);
		return count;
	}

	private static int isSubSetSumMemo(int[] arr, int n, int sum, int s, int count, int[][] memo) {

		if (memo[n - 1][s] != -1)
			return memo[n - 1][s];

		if (n == 0) {
			if (sum == s) {
				++count;
			}

			return count;
		}

		count = isSubSetSumRecursive(arr, n - 1, sum, s + arr[n - 1], count);
		count = isSubSetSumRecursive(arr, n - 1, sum, s, count);
		memo[n - 1][sum] = count;
		return count;

	}

	private static int isSubSetSumDP(int[] arr, int n, int sum, int[][] dp) {

		for (int i = 0; i <= n; i++)
			dp[i][0] = 1;

		for (int i = 1; i <= sum; i++)
			dp[0][i] = 0;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sum; j++) {

				dp[i][j] = dp[i - 1][j];

				if (j >= arr[i - 1]) {
					dp[i][j] = dp[i][j] + dp[i - 1][j - arr[i - 1]];
				}
			}
		}
		return dp[n][sum];
	}

}
