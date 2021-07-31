package dp.aditya;

class CountSubsetsWithSumEqualToX {

	static int subsetSum(int a[], int n, int sum) {

		// Initializing the matrix
		int tab[][] = new int[n + 1][sum + 1];

		// Initializing the first value of matrix
		tab[0][0] = 1;

		for (int i = 1; i <= sum; i++)
			tab[0][i] = 0;

		for (int i = 1; i <= n; i++)
			tab[i][0] = 1;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sum; j++) {

				// If the value is greater than the sum
				if (a[i - 1] <= j) {
					tab[i][j] = tab[i - 1][j] + tab[i - 1][j - a[i - 1]];
					System.out.println("tab[" + i + "][" + j + "] = tab[" + (i - 1) + "][" + j + "]+ tab[" + (i - 1)
							+ "][" + (j - a[i - 1]) + "]");
				}
				else {
					tab[i][j] = tab[i - 1][j];
		}}}
		return tab[n][sum];
	}

	public static void main(String[] args) {

		int a[] = { 2, 3, 5, 6, 8, 10 };
		int sum = 5;
		int n = a.length;

		System.out.print(subsetSum(a, n, sum));
	}
}

//Output 
/* 
tab[1][2] = tab[0][2]+ tab[0][0]
tab[1][3] = tab[0][3]+ tab[0][1]
tab[1][4] = tab[0][4]+ tab[0][2]
tab[1][5] = tab[0][5]+ tab[0][3]
tab[2][3] = tab[1][3]+ tab[1][0]
tab[2][4] = tab[1][4]+ tab[1][1]
tab[2][5] = tab[1][5]+ tab[1][2]
tab[3][5] = tab[2][5]+ tab[2][0]
Output -> 2 */