package arrays.educative;

import java.util.HashMap;
import java.util.OptionalInt;

public class FirstNonRepeating {

	public static void main(String[] args) {
		int[] arr = { 9, 2, 3, 2, 6, 6 };
		int findFirstUnique = findFirstUnique(arr);
		System.out.println(findFirstUnique);
	}

	public static int findFirstUnique(int[] arr) {

		HashMap<Integer, Integer> hm = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {

			if (hm.containsKey(arr[i])) {
				hm.put(arr[i], hm.get(arr[i]) + 1);
			} else
				hm.put(arr[i], 1);
		}

		int max = hm.entrySet().stream().filter(e -> e.getValue() == 1).mapToInt(e -> e.getKey()).max().getAsInt();
		return max;
	}

}
