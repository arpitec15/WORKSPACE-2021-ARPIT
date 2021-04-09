package arrays.educative;

import java.util.Arrays;

public class RearrangeSortedArrayInMaxMin {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 5 };
//		output = {5, 1, 4, 2, 3};

		maxMin(arr);
		maxMinOptimised(arr);

	}

	private static void maxMinOptimised(int[] arr) {
		// TODO Auto-generated method stub
		
	}

	public static void maxMin(int[] arr) {

		int[] newArray = new int[arr.length];

		int i = 0;
		int j = arr.length - 1;

		boolean switcher = false;

		for (int k = 0; k < arr.length; k++) {

			if (switcher)
				newArray[k] = arr[i++];
			else
				newArray[k] = arr[j--];
			
			switcher = !switcher;
		}
		
		System.out.println(Arrays.toString(newArray));

	}

	
	
}
