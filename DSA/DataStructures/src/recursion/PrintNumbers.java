package recursion;

public class PrintNumbers {

	public static void main(String[] args) {
		printNumbers(8);
	}

	private static void printNumbers(int n) {
		if (n == 1) {
			System.out.print(n + " ");
			return;
		}
		System.out.print(n + " ");
		printNumbers(n - 1);
	}
}
