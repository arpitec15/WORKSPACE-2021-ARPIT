package dp.leetcode;

import java.util.Arrays;

public class SubSetSum {

	public static void main(String[] args) {
		int arr[] = { 2, 3, 7, 8, 10 };
		int sum = 12;
		int n = arr.length - 1;

//		Recursive
//		boolean out = isSubSetSum(arr, n, sum);
//		System.out.println(out);

//		Memoization
//		int[][] memo = new int[n + 1][sum + 1];
//		Arrays.stream(memo).forEach(a -> Arrays.fill(a, -1));
//		int outMemo = isSubSetSumMemo(arr, n, sum, memo);
//		boolean output;
//		output = outMemo == 1 ? true : false;
//		System.out.println(output);

//		DP

		boolean[][] dp = new boolean[n + 1][sum + 1];
		boolean outDP = isSubSetSumDP(arr, n, sum, dp);
		System.out.println(outDP);

	}

	private static boolean isSubSetSumDP(int[] arr, int n, int sum, boolean[][] dp) {

		for (int i = 0; i <= n; i++)
			dp[i][0] = true;

		for (int i = 1; i <= sum; i++)
			dp[0][i] = false;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sum; j++) {

				dp[i][j] = dp[i - 1][j];

				if (j >= arr[i - 1]) {
					dp[i][j] = dp[i][j] || dp[i - 1][j - arr[i - 1]];
				}
			}
		}
		return dp[n][sum];
	}

	private static boolean isSubSetSum(int[] arr, int n, int sum) {

		if (sum == 0)
			return true;

		if (n == 0 && sum > 0)
			return false;

		if (arr[n - 1] > sum)
			return isSubSetSum(arr, n - 1, sum);

		return isSubSetSum(arr, n - 1, sum - arr[n - 1]) || isSubSetSum(arr, n - 1, sum);
	}

	private static int isSubSetSumMemo(int[] arr, int n, int sum, int[][] memo) {

		if (sum == 0)
			return 1;

		if (n == 0 && sum > 0)
			return 0;

		if (memo[n - 1][sum] != -1) {
			return memo[n - 1][sum];

		}

		if (arr[n - 1] > sum) {
			memo[n - 1][sum] = isSubSetSumMemo(arr, n - 1, sum, memo);
			return memo[n - 1][sum];
		}

		else if (isSubSetSumMemo(arr, n - 1, sum - arr[n - 1], memo) != 0
				|| isSubSetSumMemo(arr, n - 1, sum, memo) != 0) {
			return memo[n - 1][sum] = 1;
		} else
			return memo[n - 1][sum] = 0;

	}

}
