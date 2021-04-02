package arrays;

//Check if there exists a pair which matches given Sum

public class CheckPairSum {

	public static void main(String[] args) {
		
		int a[] = {1,2,3,6,94,7,8,9};
		int sum = 10;
		
		System.out.println(CheckPairSum_BruteForce(a,sum));

	}

	private static boolean CheckPairSum_BruteForce(int[] a, int sum) {

		int pair_sum = 0;
		for (int i = 0; i < a.length - 2; i++) {
			pair_sum = a[i + 1] + a[i];

			if (pair_sum == sum) {
				return true;
			}

		}

		return false;
	}
	
	
	
	

}
