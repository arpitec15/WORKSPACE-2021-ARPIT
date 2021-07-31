package dp.educative.boundedKnapSack;

public class EqualSubsetSumPartition {

	public static void main(String[] args) {

		EqualSubsetSumPartition e = new EqualSubsetSumPartition();
//		int num[] = { 1, 5, 11, 5 };
//		int num[] = { 1, 1, 3, 4, 7 };
//		int num[] = { 3, 3, 3, 4, 5 };
		int num[] = { 1, 2, 5 };
		boolean output = canPartition(num);
		System.out.println(output);
	}

	private static boolean canPartition(int[] num) {

		int sum = 0;
		for (int i = 0; i < num.length; i++) {
			sum += num[i];
		}

		if (sum % 2 != 0)
			return false;

//		Recursive
//		return canPartitionRecursive(num, sum / 2, 0);

//		Memoization
//		Boolean[][] dp = new Boolean[num.length][sum / 2 + 1];
//		return canPartitionRecursiveMemo(dp, num, sum / 2, 0);

//		return canPartitionDP(num);

		return canPartitionDP_optimized(num);
	}

	private static boolean canPartitionDP_optimized(int[] nums) {

		int sum = 0;

		for (int num : nums) {
			sum += num;
		}

		if ((sum & 1) == 1) {
			return false;
		}
		sum /= 2;

		boolean[] dp = new boolean[sum + 1];

		dp[0] = true;

		for (int num : nums) {
			for (int i = sum; i > 0; i--) {
				if (i >= num) {
					dp[i] = dp[i] || dp[i - num];
				}
			}
		}

		return dp[sum];

	}

	private static boolean canPartitionDP(int[] num) {

		int n = num.length;
		// find the total sum
		int sum = 0;
		for (int i = 0; i < n; i++)
			sum += num[i];

		// if 'sum' is a an odd number, we can't have two subsets with same total
		if (sum % 2 != 0)
			return false;

		// we are trying to find a subset of given numbers that has a total sum of
		// ‘sum/2’.
		sum /= 2;

		boolean[][] dp = new boolean[n + 1][sum + 1];

		// populate the sum=0 column, as we can always have '0' sum without including
		// any element
		for (int i = 0; i <= n; i++)
			dp[i][0] = true;

		// with only one number, we can form a subset only when the required sum is
		// equal to its value
		for (int s = 1; s <= sum; s++) {
			dp[0][s] = false;
		}

		// process all subsets for all sums
		for (int i = 1; i <= n; i++) {
			for (int s = 1; s <= sum; s++) {
				if (num[i - 1] <= s)
					dp[i][s] = (dp[i - 1][s] || dp[i - 1][s - num[i - 1]]);
				else
					dp[i][s] = dp[i - 1][s];

			}
		}

		// the bottom-right corner will have our answer.
		return dp[n][sum];
	}

	private static boolean canPartitionRecursiveMemo(Boolean[][] dp, int[] num, int sum, int currentIndex) {

		// base check
		if (sum == 0)
			return true;

		if (num.length == 0 || currentIndex >= num.length)
			return false;

		// if we have not already processed a similar problem
		if (dp[currentIndex][sum] == null) {
			// recursive call after choosing the number at the currentIndex
			// if the number at currentIndex exceeds the sum, we shouldn't process this
			if (num[currentIndex] <= sum) {
				if (canPartitionRecursiveMemo(dp, num, sum - num[currentIndex], currentIndex + 1)) {
					dp[currentIndex][sum] = true;
					return true;
				}
			}

			// recursive call after excluding the number at the currentIndex
			dp[currentIndex][sum] = canPartitionRecursiveMemo(dp, num, sum, currentIndex + 1);
		}

		return dp[currentIndex][sum];
	}

	private static boolean canPartitionRecursive(int[] num, int sum, int currentIndex) {

		// base check
		if (sum == 0)
			return true;

		if (num.length == 0 || currentIndex >= num.length)
			return false;

		// recursive call after choosing the number at the currentIndex
		// if the number at currentIndex exceeds the sum, we shouldn't process this
		if (num[currentIndex] <= sum) {
			if (canPartitionRecursive(num, sum - num[currentIndex], currentIndex + 1))
				return true;
		}

		// recursive call after excluding the number at the currentIndex
		return canPartitionRecursive(num, sum, currentIndex + 1);
	}

}
