package dp.educative.lcs;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		String s1 = "abdca";
		String s2 = "cbda";

//		Recursive
//		int lcs = findLCSLengthRecursive("abdca", "cbda", 0, 0);

//		Memoization
//		Integer[][] dp = new Integer[s1.length()][s2.length()];
//		int lcs = findLCSLengthRecursiveMemo(dp, s1, s2, 0, 0);

//		DP
//		int lcs = findLCSLengthRecursiveDP("abdca", "cbda");

//		More optimal DP
		int lcs = findLCSLengthRecursiveDP_optimal("abdca", "cbda");

		System.out.println(lcs);
	}

	private static int findLCSLengthRecursiveDP_optimal(String s1, String s2) {

		int[][] dp = new int[2][s2.length() + 1];
		int maxLength = 0;
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1))
					dp[i % 2][j] = 1 + dp[(i - 1) % 2][j - 1];
				else
					dp[i % 2][j] = Math.max(dp[(i - 1) % 2][j], dp[i % 2][j - 1]);

				maxLength = Math.max(maxLength, dp[i % 2][j]);
			}
		}
		return maxLength;
	}

	private static int findLCSLengthRecursiveDP(String s1, String s2) {

		int[][] dp = new int[s1.length() + 1][s2.length() + 1];
		int maxLength = 0;
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1))
					dp[i][j] = 1 + dp[i - 1][j - 1];
				else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);

				maxLength = Math.max(maxLength, dp[i][j]);
			}
		}
		return maxLength;
	}

	private static int findLCSLengthRecursiveMemo(Integer[][] dp, String s1, String s2, int i1, int i2) {

		if (i1 == s1.length() || i2 == s2.length())
			return 0;

		if (dp[i1][i2] == null) {
			if (s1.charAt(i1) == s2.charAt(i2))
				dp[i1][i2] = 1 + findLCSLengthRecursiveMemo(dp, s1, s2, i1 + 1, i2 + 1);
			else {
				int c1 = findLCSLengthRecursiveMemo(dp, s1, s2, i1, i2 + 1);
				int c2 = findLCSLengthRecursiveMemo(dp, s1, s2, i1 + 1, i2);
				dp[i1][i2] = Math.max(c1, c2);
			}
		}

		return dp[i1][i2];
	}

	private static int findLCSLengthRecursive(String s1, String s2, int i1, int i2) {
		if (i1 == s1.length() || i2 == s2.length())
			return 0;

		if (s1.charAt(i1) == s2.charAt(i2))
			return 1 + findLCSLengthRecursive(s1, s2, i1 + 1, i2 + 1);

		int c1 = findLCSLengthRecursive(s1, s2, i1, i2 + 1);
		int c2 = findLCSLengthRecursive(s1, s2, i1 + 1, i2);

		return Math.max(c1, c2);
	}

}
