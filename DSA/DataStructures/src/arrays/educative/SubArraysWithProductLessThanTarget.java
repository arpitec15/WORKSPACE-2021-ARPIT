package arrays.educative;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubArraysWithProductLessThanTarget {

	public static void main(String[] args) {

		int arr[] = { 2, 5, 3, 10 };
//		int arr[] = { 8, 2, 6, 5 };
		int target = 30;

		List<List<Integer>> list = findSubArrays(arr, target);
		System.out.println(list);

	}

	private static List<List<Integer>> findSubArrays(int[] arr, int target) {
		// TODO Auto-generated method stub

		int j = 1, i = 0, prod = 1;
		List<List<Integer>> result = new ArrayList<>();

		prod = arr[0] * arr[1];

		while (i < arr.length) {

			if (prod < target && j != 0 && i != j && i < arr.length && j < arr.length) {
				result.add(Arrays.asList(arr[i], arr[j]));
				if(j == arr.length-1) {
					j++;
				}
				else {
					j++;
					prod = prod * arr[j];
					
				}
			} else if (j != 0 && i < arr.length && j <= arr.length) {

				if (arr[i] < target)
					result.add(Arrays.asList(arr[i]));

				prod = prod / arr[i];
				i++;
			}
		}
		return result;
	}

}
