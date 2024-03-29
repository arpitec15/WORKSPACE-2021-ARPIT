package dp.educative.unboundedKnapSack;

/*
 * Given a staircase with �n� steps and an array of �n� numbers 
 * representing the fee that you have to pay if you take the step. 
 * Implement a method to calculate the minimum fee required to reach 
 * the top of the staircase (beyond the top-most step). 
 * At every step, you have an option to take either 1 step, 2 steps, or 3 steps. 
 * You should assume that you are standing at the first step. 
 */

public class MinimumJumpsWithFee {

	public static int minJumpsWithFee(int[] fee) {
		int dp[] = new int[fee.length + 1]; // +1 to handle the 0th step
		dp[0] = 0; // if there are no steps, we dont have to pay any fee
		dp[1] = fee[0]; // only one step, so we have to pay its fee
		// for 2 or 3 steps staircase, since we start from the first step so we have to
		// pay its fee
		// and from the first step we can reach the top by taking two or three steps, so
		// we don't
		// have to pay any other fee.
		dp[2] = dp[3] = fee[0];

		for (int i = 3; i < fee.length; i++)
			dp[i + 1] = Math.min(fee[i] + dp[i], Math.min(fee[i - 1] + dp[i - 1], fee[i - 2] + dp[i - 2]));

		return dp[fee.length];
	}

	public static void main(String[] args) {

		int[] arr = { 1, 2, 1, 3, 2, 1, 2, 1 };

		System.out.println(minJumpsWithFee(arr));

	}

}
