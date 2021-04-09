package arrays.educative;

public class BinarySearchOnSortedArray {

	public static void main(String[] args) {

		int[] arr = { 1, 10, 20, 47, 59, 63, 75, 88, 99, 107, 120, 133, 155, 162, 176, 188, 199, 200, 210, 222 };
		int key = 222;

		int index = binarySearch(arr, key);
		System.out.println("length is " + (arr.length - 1));
		System.out.println(index);

	}

	private static int binarySearch(int[] arr, int key) {
		// TODO Auto-generated method stub

		int low = 0;
		int high = arr.length - 1;
		int mid = 0;

		while (low <= high) {
			mid = (low + high) / 2;

			if (key == arr[mid]) {
				return mid;
			}

			else if (key < arr[mid]) {
				high = mid - 1;

			}

			else {
				low = mid + 1;
			}

		}
		return -1;
	}

}
