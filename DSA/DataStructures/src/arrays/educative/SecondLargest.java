package arrays.educative;

public class SecondLargest {

	public static void main(String[] args) {

		int[] arr = { 9, 2, 3, 2, 6, 6 };
		int secondLargest = secondlargest(arr);
		System.out.println(secondLargest);

	}

	private static int secondlargest(int[] arr) {

		int largest = Integer.MIN_VALUE;
		int secondLargest = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {

			if(arr[i] > largest) {
				secondLargest = largest;
				largest = arr[i];
			}
			else if(arr[i] < largest && arr[i] > secondLargest)
				secondLargest = arr[i];
		}

		return secondLargest;
	}

}
