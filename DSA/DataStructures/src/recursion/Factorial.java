package recursion;

public class Factorial {

	public static void main(String[] args) {

		System.out.println(factorial(4));
	}

	private static int factorial(int n) {

		if (n == 1)
			return 1;

		int out = n * factorial(n - 1);
		return out;

	}

}
