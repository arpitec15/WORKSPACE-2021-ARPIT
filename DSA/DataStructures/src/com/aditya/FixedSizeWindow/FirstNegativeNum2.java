package com.aditya.FixedSizeWindow;

import java.util.TreeMap;

public class FirstNegativeNum2 {

	public static void main(String[] args) {

		int arr[] = { 12, -1, -7, 8, -15, 30, 16, 28 };
		int k = 3;
		firstNegativeNum(arr, k);
	}

	public static void firstNegativeNum(int[] arr, int k) {

		int i = 0, j = 0;
		TreeMap<Integer, Integer> hm = new TreeMap<>();

		while (j < arr.length) {

			if (arr[j] < 0) {
				hm.put(arr[j], j);
			}

			if (j - i + 1 < k)
				++j;

			else if (j - i + 1 == k) {
				if (!hm.isEmpty()) {
					if (hm.containsValue(i)) {
						System.out.println(hm.lastEntry().getKey());
						if (i >= hm.get(hm.lastEntry().getKey())) {
							hm.remove(hm.lastEntry().getKey());
						}
					} else {				
						System.out.println(0);
					}
						
				}
				else
				{
					System.out.println(0);
				}
				++j;
				++i;
			}

		}

	}

}
