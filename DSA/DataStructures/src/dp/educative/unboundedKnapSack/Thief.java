package dp.educative.unboundedKnapSack;

/*
 * There are n houses built in a line. 
 * A thief wants to steal the maximum possible money from these houses. 
 * The only restriction the thief has is that he can’t steal from two 
 * consecutive houses, as that would alert the security system. 
 * How should the thief maximize his stealing?
 */

/*
Input: {2, 5, 1, 3, 6, 2, 4}
Output: 15
Explanation: The thief should steal from houses 5 + 6 + 4
 */

public class Thief {

	public static void main(String[] args) {

		int[] wealth = { 2, 5, 1, 3, 6, 2, 4 };
		int output = findMaxSteal(wealth);
	}

	private static int findMaxSteal(int[] wealth) {

//		Recursive code
//		return findMaxStealRecursive(wealth, 0);

//		Memoization
//		int dp[] = new int[wealth.length];
//		return findMaxStealMemo(dp, wealth, 0);

//		DP
		return findMaxStealDP(wealth);

	}

	private static int findMaxStealRecursive(int[] wealth, int currentIndex) {
		if (currentIndex >= wealth.length)
			return 0;

		// steal from current house and skip one to steal from the next house
		int stealCurrent = wealth[currentIndex] + findMaxStealRecursive(wealth, currentIndex + 2);
		// skip current house to steel from the adjacent house
		int skipCurrent = findMaxStealRecursive(wealth, currentIndex + 1);

		return Math.max(stealCurrent, skipCurrent);
	}

	private static int findMaxStealMemo(int[] dp, int[] wealth, int currentIndex) {

		if (currentIndex >= wealth.length)
			return 0;

		if (dp[currentIndex] == 0) {
			// steal from current house and skip one to steal next
			int stealCurrent = wealth[currentIndex] + findMaxStealMemo(dp, wealth, currentIndex + 2);
			// skip current house to steel from the adjacent house
			int skipCurrent = findMaxStealMemo(dp, wealth, currentIndex + 1);

			dp[currentIndex] = Math.max(stealCurrent, skipCurrent);
		}
		return dp[currentIndex];

	}

	public static int findMaxStealDP(int[] wealth) {
		if (wealth.length == 0)
			return 0;
		int dp[] = new int[wealth.length + 1]; // '+1' to handle the zero house
		dp[0] = 0; // if there are no houses, the thief can't steal anything
		dp[1] = wealth[0]; // only one house, so the thief have to steal from it

//		{ 2, 5, 1, 3, 6, 2, 4 }
		// please note that dp[] has one extra element to handle zero house
		for (int i = 1; i < wealth.length; i++)
			dp[i + 1] = Math.max(wealth[i] + dp[i - 1], dp[i]);

		return dp[wealth.length];
	}

}
