package dp.educative.boundedKnapSack;

/**
 * @author arpitshrivastava
 *
 */
public class KnapSack01 {

//	Recursive Code
	private int knapsackRecursive(int[] profits, int[] weights, int capacity, int currentIndex) {
		// base checks
		if (capacity <= 0 || currentIndex >= profits.length)
			return 0;

		int profit1 = 0;
		if (weights[currentIndex] <= capacity)
			profit1 = profits[currentIndex]
					+ knapsackRecursive(profits, weights, capacity - weights[currentIndex], currentIndex + 1);

		// recursive call after excluding the element at the currentIndex
		int profit2 = knapsackRecursive(profits, weights, capacity, currentIndex + 1);

		return Math.max(profit1, profit2);
	}

	private int KnapsackMemoization(Integer[][] dp, int[] profits, int[] weights, int capacity, int currentIndex) {

		// base checks
		if (capacity <= 0 || currentIndex >= profits.length)
			return 0;

		// if we have already solved a similar problem, return the result from memory
		if (dp[currentIndex][capacity] != null)
			return dp[currentIndex][capacity];

		// recursive call after choosing the element at the currentIndex
		// if the weight of the element at currentIndex exceeds the capacity, we
		// shouldn't process this
		int profit1 = 0;
		if (weights[currentIndex] <= capacity)
			profit1 = profits[currentIndex]
					+ KnapsackMemoization(dp, profits, weights, capacity - weights[currentIndex], currentIndex + 1);

		// recursive call after excluding the element at the currentIndex
		int profit2 = KnapsackMemoization(dp, profits, weights, capacity, currentIndex + 1);

		dp[currentIndex][capacity] = Math.max(profit1, profit2);
		return dp[currentIndex][capacity];
	}

	public int solveKnapsackDP(int[] profits, int[] weights, int capacity) {
		// basic checks
		if (capacity <= 0 || profits.length == 0 || weights.length != profits.length)
			return 0;

		int n = profits.length;
		int[][] dp = new int[n][capacity + 1];

		// populate the capacity=0 columns, with '0' capacity we have '0' profit
		for (int i = 0; i < n; i++)
			dp[i][0] = 0;

		// if we have only one weight, we will take it if it is not more than the
		// capacity
		for (int c = 0; c <= capacity; c++) {
			if (weights[0] <= c)
				dp[0][c] = profits[0];
		}

		// process all sub-arrays for all the capacities
		for (int i = 1; i < n; i++) {
			for (int c = 1; c <= capacity; c++) {
				int profit1 = 0, profit2 = 0;
				// include the item, if it is not more than the capacity
				if (weights[i] <= c)
					profit1 = profits[i] + dp[i - 1][c - weights[i]];
				// exclude the item
				profit2 = dp[i - 1][c];
				// take maximum
				dp[i][c] = Math.max(profit1, profit2);
			}
		}

		// maximum profit will be at the bottom-right corner.
		return dp[n - 1][capacity];
	}

	public int solveKnapsackDP_myStyle(int[] profits, int[] weights, int capacity) {
		// basic checks
		if (capacity <= 0 || profits.length == 0 || weights.length != profits.length)
			return 0;

		int n = profits.length;
		int[][] dp = new int[n + 1][capacity + 1];

		// populate the capacity=0 columns, with '0' capacity we have '0' profit
		for (int i = 0; i <= n; i++)
			dp[i][0] = 0;

		// if we have only one weight, we will take it if it is not more than the
		// capacity
		for (int c = 0; c <= capacity; c++) {
			if (weights[0] <= c)
				dp[0][c] = profits[0];
		}

		// process all sub-arrays for all the capacities
		for (int i = 1; i <= n; i++) {
			for (int c = 1; c <= capacity; c++) {
				int profit1 = 0, profit2 = 0;
				// include the item, if it is not more than the capacity
				if (weights[i - 1] <= c) {
					// System.out.println("i is " + i);
					profit1 = profits[i - 1] + dp[i - 1][c - weights[i - 1]];

				}
				// exclude the item
				profit2 = dp[i - 1][c];
				// take maximum
				dp[i][c] = Math.max(profit1, profit2);
			}
		}

//		Printing elements
		printSelectedElements(dp, weights, profits, capacity);
		// maximum profit will be at the bottom-right corner.
		return dp[n][capacity];

	}

	private void printSelectedElements(int[][] dp, int[] weights, int[] profits, int capacity) {

		System.out.print("Selected weights:");
		int totalProfit = dp[weights.length][capacity];
		for (int i = weights.length; i > 0; i--) {
			if (totalProfit != dp[i - 1][capacity]) {
				System.out.print(" " + weights[i - 1]);
				capacity -= weights[i - 1];
				totalProfit -= profits[i - 1];
			}
		}

		if (totalProfit != 0)
			System.out.print(" " + weights[0]);
		System.out.println("");
	}

	private int solveKnapsackDP_optimized(int[] profits, int[] weights, int capacity) {

		// basic checks
		if (capacity <= 0 || profits.length == 0 || weights.length != profits.length)
			return 0;

		int n = profits.length;
		int[] dp = new int[capacity + 1];

		// if we have only one weight, we will take it if it is not more than the
		// capacity
		for (int c = 0; c <= capacity; c++) {
			if (weights[0] <= c)
				dp[c] = profits[0];
		}

		// process all sub-arrays for all the capacities
		for (int i = 1; i < n; i++) {
			for (int c = capacity; c >= 0; c--) {
				int profit1 = 0, profit2 = 0;
				// include the item, if it is not more than the capacity
				if (weights[i] <= c)
					profit1 = profits[i] + dp[c - weights[i]];
				// exclude the item
				profit2 = dp[c];
				// take maximum
				dp[c] = Math.max(profit1, profit2);
			}
		}

		return dp[capacity];
	}

	

	public static void main(String[] args) {

		KnapSack01 ks = new KnapSack01();
		int[] profits = { 1, 6, 10, 16 };
		int[] weights = { 1, 2, 3, 5 };
		/*
		 * // Recursive int maxProfit = ks.knapsackRecursive(profits, weights, 7, 0);
		 * System.out.println("Total knapsack profit ---> " + maxProfit);
		 * 
		 * // Memoization int capacity = 7; Integer[][] dp = new
		 * Integer[profits.length][capacity + 1]; int maxProfitMemo =
		 * ks.KnapsackMemoization(dp, profits, weights, 7, 0);
		 * System.out.println("Total knapsack profit ---> " + maxProfitMemo);
		 * 
		 * // DP int maxProfitDP = ks.solveKnapsackDP(profits, weights, 7);
		 * System.out.println("Total knapsack profit ---> " + maxProfitDP);
//		DP
		int maxProfitDP_MyStyle = ks.solveKnapsackDP_myStyle(profits, weights, 7);
		System.out.println("Total knapsack profit ---> " + maxProfitDP_MyStyle);
		 */

//		DP
		int maxProfitDP_Optimized = ks.solveKnapsackDP_optimized(profits, weights, 7);
		System.out.println("Total knapsack profit ---> " + maxProfitDP_Optimized);

	}

}
