package arrays.educative;

import java.util.Arrays;

public class RearrangePosAndNeg {

	public static void main(String[] args) {

		int[] arr = { 10, -1, 20, 4, 5, -9, -6 };

//		output = {-1, -9, -6, 10, 20, 4, 5};
//		order doesn't matters

		reArrange(arr);

	}

	public static void reArrange(int[] arr) {

		// Write - Your - Code
		int i = 0;
		int j = arr.length - 1;
		int temp = 0;
		while (i < j && j<arr.length) {

			while(arr[i] < 0) {
				++i;
			}			
			
			if (arr[i] > 0 && arr[j] < 0) {
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;				
			} 
			--j;
					
		}
		System.out.println(Arrays.toString(arr));
	}

}
