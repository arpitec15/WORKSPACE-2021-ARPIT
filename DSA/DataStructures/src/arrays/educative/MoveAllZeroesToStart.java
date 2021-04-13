package arrays.educative;

import java.util.Arrays;

public class MoveAllZeroesToStart {

	public static void main(String[] args) {

		int[] arr = { 1, 10, 0, 0, 59, 63, 0, 88, 0 };
		moveZeroes(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void moveZeroes(int[] arr) {
		// TODO Auto-generated method stub

		int temp = 0, j = arr.length - 1;
		int zeroIndex = 0;

		while (j >= 0) {

			if (arr[j] == 0 && j != 0 && arr[j - 1] != 0) {
				temp = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = temp;
			}

			if (arr[j] == 0) {
				int k = j;
				while (k > 0 && arr[k] == 0) {
					--k;
				}

				temp = arr[k];
				arr[j] = temp;
				arr[k] = 0;

			}

			j--;

		}

	}

}
