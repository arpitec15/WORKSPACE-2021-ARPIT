package arrays.educative;

public class SearchRotatedArray {

	public static void main(String[] args) {

		int arr[] = { 11, 12, 15, 18, 2, 5, 6, 8 };
		int index = searchInRotatedSortedIterative(arr, 0, arr.length - 1, 8);
		System.out.println("Key is at " + index);
	}

	private static int searchInRotatedSortedIterative(int[] arr, int start, int end, int key) {

		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (arr[mid] == key) {
				return mid;
			}

			else if (arr[mid] <= arr[end]) { // Right side of array is sorted
				if (key <= arr[end] && key > arr[mid]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}

			else { //left side of array is sorted
				if (arr[start] <= key && key < arr[mid]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			}

		}
		return -1;
	}

	public static int searchInRotatedSortedRecursive(int[] arr, int low, int high, int target) {

		if (low <= high) {
			int mid = low + (high - low) / 2;

			if (arr[mid] == target) {
				return mid;
			} else if (arr[low] <= arr[mid]) { // Left Side of the Array is Sorted.
				if (arr[low] <= target && target < arr[mid]) {
					return searchInRotatedSortedRecursive(arr, low, mid - 1, target);
				} else {
					return searchInRotatedSortedRecursive(arr, mid + 1, high, target);
				}
			} else { // Right Side is sorted.
				if (arr[mid] < target && target <= arr[high]) {
					return searchInRotatedSortedRecursive(arr, mid + 1, high, target);
				} else {
					return searchInRotatedSortedRecursive(arr, low, mid - 1, target);
				}
			}
		}
		return -1;
	}
}
