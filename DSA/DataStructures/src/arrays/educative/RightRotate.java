package arrays.educative;

import java.util.Arrays;

public class RightRotate {

	public static void main(String[] args) {

		int[] arr = { 9, 2, 3, 2, 6, 6 };
		
//		output = [6, 9, 2, 3, 2, 6]
		
				rotateArray(arr);

	}

	private static void rotateArray(int[] arr) {

		int lastElement = arr[arr.length - 1];

		for (int i = arr.length - 1; i > 0; i--) {

			arr[i] = arr[i - 1];

		}
		
		arr[0] = lastElement;
		System.out.println(Arrays.toString(arr));
	}

}
