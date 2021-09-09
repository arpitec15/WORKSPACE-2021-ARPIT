package dp.aditya;

/* Dynamic Programming Java implementation of LCS problem */
public class LCSubString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LCSubString lcs = new LCSubString();
		String s1 = "abfce";
		String s2 = "abcde";

		char[] X = s1.toCharArray();
		char[] Y = s2.toCharArray();
		int m = X.length;
		int n = Y.length;

//		System.out.println("Length of LCSubstring is" + " " + lcs.lcsRec(s1, s2, m, n, 0));
		System.out.println("Length of LCS is" + " " + lcs.lcsDP(s1, s2, s1.length(), s2.length()));
	}

	private int lcsRec(String x, String y, int m, int n, int count) {

		if (m == 0 || n == 0) {
			return count;
		}

		if (x.charAt(m - 1) == y.charAt(n - 1)) {
			return lcsRec(x, y, n - 1, m - 1, count + 1);
		}

		else {
			int incl = lcsRec(x, y, n - 1, m, 0);
			int excl = lcsRec(x, y, n, m - 1, 0);
			return Math.max(count, Math.max(incl, excl));
		}
	}

	private int lcsDP(String x, String y, int m, int n) {
		int dp[][] = new int[x.length() + 1][y.length() + 1];
		int max = 0;

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (x.charAt(i - 1) == y.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = 0;
				}
				max = max > dp[i][j] ? max : dp[i][j];
			}
		}
		return max;
	}

}
