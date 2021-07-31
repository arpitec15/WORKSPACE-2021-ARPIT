package dp.educative.lcs;

public class LongestCommonSubstring {

	public static void main(String[] args) {

//		Recursive
//		int len = findLCSLengthRecursive("abdca", "cbda", 0, 0, 0);

//		Memoization
		String s1 = "abdca";
		String s2 = "cbda";
		int maxLength = Math.min(s1.length(), s2.length());
		Integer[][][] dp = new Integer[s1.length()][s1.length()][maxLength];
//		int len = findLCSLengthRecursiveMemo(dp, s1, s2, 0, 0, 0);

//		DP
//		int len = findLCSLengthDP("abdca", "cbda");

//		DP More Optimized
		int len = findLCSLengthDP_Optimized("abdca", "cbda");

		System.out.println(len);
	}

	private static int findLCSLengthRecursive(String s1, String s2, int i1, int i2, int count) {

		if (i1 == s1.length() || i2 == s2.length())
			return count;

		if (s1.charAt(i1) == s2.charAt(i2))
			count = findLCSLengthRecursive(s1, s2, i1 + 1, i2 + 1, count + 1);

		int c1 = findLCSLengthRecursive(s1, s2, i1, i2 + 1, 0);
		int c2 = findLCSLengthRecursive(s1, s2, i1 + 1, i2, 0);

		return Math.max(count, Math.max(c1, c2));
	}

	private static int findLCSLengthRecursiveMemo(Integer[][][] dp, String s1, String s2, int i1, int i2, int count) {

		if (i1 == s1.length() || i2 == s2.length())
			return count;

		if (dp[i1][i2][count] == null) {
			int c1 = count;
			if (s1.charAt(i1) == s2.charAt(i2))
				c1 = findLCSLengthRecursiveMemo(dp, s1, s2, i1 + 1, i2 + 1, count + 1);
			int c2 = findLCSLengthRecursiveMemo(dp, s1, s2, i1, i2 + 1, 0);
			int c3 = findLCSLengthRecursiveMemo(dp, s1, s2, i1 + 1, i2, 0);
			dp[i1][i2][count] = Math.max(c1, Math.max(c2, c3));
		}

		return dp[i1][i2][count];

	}

	private static int findLCSLengthDP(String s1, String s2) {

		int[][] dp = new int[s1.length() + 1][s2.length() + 1];
		int maxLength = 0;
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
					maxLength = Math.max(maxLength, dp[i][j]);
				}
			}
		}
		return maxLength;
	}

	private static int findLCSLengthDP_Optimized(String s1, String s2) {

//		We only need one previous row to find the optimal solution!
		int[][] dp = new int[2][s2.length() + 1];
		int maxLength = 0;
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				dp[i % 2][j] = 0;
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i % 2][j] = 1 + dp[(i - 1) % 2][j - 1];
					maxLength = Math.max(maxLength, dp[i % 2][j]);
				}
			}
		}
		return maxLength;
	}
}
