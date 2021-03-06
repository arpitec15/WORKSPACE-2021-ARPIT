package dp.aditya;

public class PalindromePartition {

	public static void main(String[] args) {

		String s = "abccbc";
		int minCuts = palindromePartition(s);
		System.out.println(minCuts);
	}

	private static int palindromePartition(String s) {

		boolean dp[][] = new boolean[s.length()][s.length()];

		for (int g = 0; g < s.length(); g++) {
			for (int i = 0, j = g; j < dp.length; i++, j++) {
				if (g == 0)
					dp[i][j] = true;
				else if (g == 1)
					dp[i][j] = s.charAt(i) == s.charAt(j);
				else if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == true)
					dp[i][j] = true;
				else
					dp[i][j] = false;
			}
		}

		int[] strg = new int[s.length()];
		strg[0] = 0;

		for (int j = 1; j < strg.length; j++) {

			if (dp[0][j])
				strg[j] = 0;
			else {
				int min = Integer.MAX_VALUE;
				for (int i = j; i >= 1; i--) {
					if (dp[i][j]) {
						if (strg[i - 1] < min) {
							min = strg[i - 1];
						}
					}
				}
				strg[j] = min + 1;
			}
		}
		return strg[strg.length - 1];
	}

}
