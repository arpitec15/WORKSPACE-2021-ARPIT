package dp.cs;

public class SubsetSum {

	public static boolean isSubsetExists(int[] arr, int sum) {
		if (arr.length == 0) {
			return false;
		}

		boolean[][] mat = new boolean[arr.length][sum + 1];

		for (int i = 0; i < arr.length; i++) {
			mat[i][0] = true;
		}

		for (int j = 0; j <= sum; j++) {
			if (j == arr[0]) {
				mat[0][j] = true;
			}
		}

		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j <= sum; j++) {

				if (mat[i - 1][j]) {
					mat[i][j] = true;
				} else {
					if (j >= arr[i]) {
						mat[i][j] = mat[i - 1][j - arr[i]];
					}
				}
			}
		}

		return mat[arr.length - 1][sum];
	}

	private static boolean isSubsetExistsRecursive(int[] arr, int sum, int n) {

		if (sum == 0)
			return true;

		if (n < 0)
			return false;

		if (arr[n] > sum)
			return isSubsetExistsRecursive(arr, sum, n - 1);

		return isSubsetExistsRecursive(arr, sum, n - 1) || isSubsetExistsRecursive(arr, sum - arr[n], n - 1);

	}

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 5 };
		int sum = 5;

//		System.out.println(SubsetSum.isSubsetExists(arr, sum));
		System.out.println(SubsetSum.isSubsetExistsRecursive(arr, sum, arr.length - 1));

	}

}
