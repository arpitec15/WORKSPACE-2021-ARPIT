package arrays.educative;

import java.util.Arrays;
import java.util.List;

public class LowHighIndex {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1, 2, 5, 5, 5, 5, 5, 5, 5, 5, 20);

		int lowIndex = findLowIndex(list, 5);
		int highIndex = findHighIndex(list, 5);
		System.out.println(lowIndex + " " + highIndex);

	}

	private static int findLowIndex(List<Integer> list, int key) {

		int low = 0;
		int high = list.size() - 1;

		int mid = 0;

		while (low <= high) {

			mid = (low + high) / 2;

			if (list.get(mid) == key) {
				high = mid - 1;
			}

			else if (list.get(mid) < key) {
				low = mid + 1;

			}

			else if (list.get(mid) > key) {
				high = mid - 1;

			}

		}
		if (list.get(low) == key)
			return low;
		else
			return -1;
	}

	private static int findHighIndex(List<Integer> list, int key) {

		int low = 0;
		int high = list.size() - 1;

		int mid = 0;

		while (low <= high) {

			mid = (low + high) / 2;

			if (list.get(mid) == key) {
				low = mid + 1;
			}

			else if (list.get(mid) < key) {
				low = mid + 1;

			}

			else if (list.get(mid) > key) {
				high = mid - 1;

			}

		}
		if (list.get(high) == key)
			return high;
		else
			return -1;
	}

}
