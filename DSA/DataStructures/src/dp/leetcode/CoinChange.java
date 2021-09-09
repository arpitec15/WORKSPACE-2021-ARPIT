package dp.leetcode;

import java.util.Arrays;

//A Naive recursive JAVA program to find minimum of coins
//to make a given change V
class CoinChange {

	static int coin(int coins[], int total, int i, int[][] memo) {

		if (i >= coins.length)
			return Integer.MAX_VALUE - 5;

		if (total == 0 && i < coins.length)
			return 0;

		if (total < 0)
			return Integer.MAX_VALUE - 5;

		if (memo[i][total] != 0)
			return memo[i][total];

		int op1 = 1 + coin(coins, total - coins[i], i, memo);
		int op2 = coin(coins, total, i + 1, memo);
		memo[i][total] = Math.min(op1, op2);
		return Math.min(op1, op2);

	}

	public static void main(String args[]) {
		int coins[] = {2 };
		int total = 3;
		int[][] memo = new int[coins.length][total + 1];
		System.out.println("Minimum coins required is " + coin(coins, total, 0, memo));
		System.out.println(Arrays.deepToString(memo));
	}
}
