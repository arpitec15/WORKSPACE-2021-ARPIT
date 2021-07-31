package dp.educative.boundedKnapSack;

public class CountSubsetWithDiff {

	public static void main(String[] args) {

//		int[] num = { 1, 2, 7, 1 };
//		int[] num = { 1 };
//		int[] num = { 7, 9, 3, 8, 0, 2, 4, 8, 3, 9 };
		int[] num = { 5, 2, 2, 7, 3, 7, 9, 0, 2, 3 };
		int output = countSubsetsWithDiff(num, 9);
		System.out.println(output);

	}

	private static int countSubsetsWithDiff(int[] num, int diff) {

		int range = 0;
		for (int i : num) {
			range += i;
		}

		if (range < diff)
			return 0;

		if (diff == 0 && range % 2 != 0)
			return 0;

		double d_sum = (range + diff) / 2.0;

		int sum = 0;
		if (d_sum % 1 != 0)
			return 0;
		else
			sum = (int) d_sum;

		return CountSubsetSum.countSubsetsDP_optimized(num, sum);
	}

}
