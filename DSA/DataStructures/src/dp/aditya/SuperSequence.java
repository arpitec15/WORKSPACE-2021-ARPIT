package dp.aditya;

class SuperSequence {

	// Function to find length of the
	// shortest supersequence of X and Y.
	static int shortestSuperSequence(String X, String Y) {
		int m = X.length();
		int n = Y.length();

		// find lcs
		int l = lcs(X, Y, m, n);

		// Result is sum of input string
		// lengths - length of lcs
		return (m + n - l);
	}

	// Returns length of LCS
	// for X[0..m - 1], Y[0..n - 1]
	static int lcs(String X, String Y, int m, int n) {
		int[][] L = new int[m + 1][n + 1];
		int i, j;

		// Following steps build L[m + 1][n + 1]
		// in bottom up fashion. Note that
		// L[i][j] contains length of LCS
		// of X[0..i - 1]and Y[0..j - 1]
		for (i = 0; i <= m; i++) {
			for (j = 0; j <= n; j++) {
				if (i == 0 || j == 0)
					L[i][j] = 0;

				else if (X.charAt(i - 1) == Y.charAt(j - 1))
					L[i][j] = L[i - 1][j - 1] + 1;

				else
					L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
			}
		}

		// L[m][n] contains length of LCS
		// for X[0..n - 1] and Y[0..m - 1]
		return L[m][n];
	}

	private static int shortestSuperSequenceRecursive(String X, String Y, int m, int n) {
		if (m == 0)
			return n;
		if (n == 0)
			return m;

		if (X.charAt(m - 1) == Y.charAt(n - 1))
			return 1 + shortestSuperSequenceRecursive(X, Y, m - 1, n - 1);

		return 1 + Math.min(shortestSuperSequenceRecursive(X, Y, m - 1, n),
				shortestSuperSequenceRecursive(X, Y, m, n - 1));
	}

	private static int superSeqDP(String X, String Y, int m, int n) {

		int[][] dp = new int[m + 1][n + 1];

		// Fill table in bottom up manner
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				// Below steps follow above recurrence
				if (i == 0)
					dp[i][j] = j;
				else if (j == 0)
					dp[i][j] = i;
				else if (X.charAt(i - 1) == Y.charAt(j - 1))
					dp[i][j] = 1 + dp[i - 1][j - 1];
				else
					dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
			}
		}

		return dp[m][n];
	}

// Driver code
	public static void main(String args[]) {
		String X = "AGGTAB";
		String Y = "GXTXAYB";

		System.out.println("Length of the shortest " + "supersequence is " + shortestSuperSequence(X, Y));
		System.out.println("Length of the shortest " + "supersequence is "
				+ shortestSuperSequenceRecursive(X, Y, X.length(), Y.length()));
		System.out.println("Length of the shortest supersequence is " + superSeqDP(X, Y, X.length(), Y.length()));

	}

}