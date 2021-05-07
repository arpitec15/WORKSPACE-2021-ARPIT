package leetcode.october;

public class PowerOfThree {

	public static void main(String[] args) {

		boolean isPowerOfThree = isPowerOfThree(1);
		System.out.println(isPowerOfThree);
	}

	private static boolean isPowerOfThree(int n) {
		// TODO Auto-generated method stub
		if (n < 3) {
			return false;
		}

		while (n > 5) {
			n = n / 3;
		}

		if (n == 1 || n==3)
			return true;
		else
			return false;
	}

}
