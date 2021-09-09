package recursion;

public class KSymbolInGrammar {

	public static void main(String[] args) {

		int out = ks(2, 2);
		System.out.println(out);

	}

	private static int ks(int n, int k) {

		if (k == 1 && n == 1)
			return 0;

		int mid = (int) (Math.pow(2, n - 1) / 2);

		if (k <= mid)
			return ks(n - 1, k);

		else
			return ks(n - 1, k - mid) == 0 ? 1 : 0;

	}

}
