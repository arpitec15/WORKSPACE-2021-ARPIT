package dp.educative.boundedKnapSack;

public class CountSubsetSum {

	public static void main(String[] args) {

		int[] num = { 1, 1, 2, 3 };
		int output = countSubsets(num, 4);
		System.out.println(output);

	}

	private static int countSubsets(int[] num, int sum) {

//		Recursive
//		return countSubsetsRecursive(num, sum, 0);

//		Memoization
//		Integer[][] dp = new Integer[num.length][sum + 1];
//		return countSubsetsRecursiveMemo(dp, num, sum, 0);

//		DP
//		return countSubsetsDP(num, sum); 

//		DP optimized
		return countSubsetsDP_optimized(num, sum);
	}

	static int countSubsetsDP_optimized(int[] num, int sum) {

		int n = num.length;
		int[] dp = new int[sum + 1];
		dp[0] = 1;

		// with only one number, we can form a subset only when the required sum is
		// equal to its value

//		without for-each
//		for (int s = 1; s <= sum; s++) {
//			dp[s] = (num[0] == s ? 1 : 0);
//		}

//		with for-each
		for (int s = 1; s <= sum; s++) {
			dp[s] = 0;
		}

//		process all subsets for all sums 
//		(without for each)
//		for (int i = 1; i < num.length; i++) {
//			for (int s = sum; s >= 0; s--) {
//				if (s >= num[i])
//					dp[s] += dp[s - num[i]];
//			}
//		}

//		using for each
		for (int nums : num) {
			for (int j = sum; j >= 0; j--) {
				if (j >= nums)
					dp[j] += dp[j - nums];

			}
		}

		return dp[sum];

	}

	private static int countSubsetsDP(int[] num, int sum) {

		int n = num.length;
		int dp[][] = new int[n][sum + 1];

		for (int i = 0; i < n; i++) {
			dp[i][0] = 1;
		}

		for (int j = 1; j <= sum; j++) {
			dp[0][j] = (num[0] == j ? 1 : 0);
		}

		for (int i = 1; i < n; i++) {
			for (int j = 1; j <= sum; j++) {

				if (j >= num[i])
					dp[i][j] = dp[i - 1][j] + dp[i - 1][j - num[i]];
				else
					dp[i][j] = dp[i - 1][j];

			}

		}
		return dp[n - 1][sum];

	}

	private static int countSubsetsRecursiveMemo(Integer[][] dp, int[] num, int sum, int currentIndex) {

		// base checks
		if (sum == 0)
			return 1;

		if (num.length == 0 || currentIndex >= num.length)
			return 0;

		// check if we have not already processed a similar problem
		if (dp[currentIndex][sum] == null) {
			// recursive call after choosing the number at the currentIndex
			// if the number at currentIndex exceeds the sum, we shouldn't process this
			int sum1 = 0;
			if (num[currentIndex] <= sum)
				sum1 = countSubsetsRecursiveMemo(dp, num, sum - num[currentIndex], currentIndex + 1);

			// recursive call after excluding the number at the currentIndex
			int sum2 = countSubsetsRecursiveMemo(dp, num, sum, currentIndex + 1);

			dp[currentIndex][sum] = sum1 + sum2;
		}

		return dp[currentIndex][sum];
	}

	private static int countSubsetsRecursive(int[] num, int sum, int currentIndex) {

		// base checks
		if (sum == 0)
			return 1;

		if (num.length == 0 || currentIndex >= num.length)
			return 0;

		// recursive call after selecting the number at the currentIndex
		// if the number at currentIndex exceeds the sum, we shouldn't process this
		int sum1 = 0;
		if (num[currentIndex] <= sum)
			sum1 = countSubsetsRecursive(num, sum - num[currentIndex], currentIndex + 1);

		// recursive call after excluding the number at the currentIndex
		int sum2 = countSubsetsRecursive(num, sum, currentIndex + 1);

		return sum1 + sum2;
	}

}
