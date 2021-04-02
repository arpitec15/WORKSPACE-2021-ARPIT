package com.aditya.FixedSizeWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class FirstNegativeNum {

	public static void main(String[] args) {

		int arr[] = { 12, -1, -7, 8, -15, 30, 16, 28 };
		int k = 3;
		firstNegativeNum(arr, k);
	}

	public static void firstNegativeNum(int[] arr, int k) {

		int i = 0, j = 0;
		List<Integer> neg = new ArrayList<>();
		TreeMap<Integer, Integer> hm = new TreeMap<>();

		while (j < arr.length) {

			if (arr[j] < 0) {
				neg.add(arr[j]);
				hm.put(arr[j], j);
			}

			if (j - i + 1 < k)
				++j;

			else if (j - i + 1 == k) {
				if (!hm.isEmpty()) {
					if (hm.containsValue(i)) {
						System.out.println("*******start********");
						System.out.println(neg.get(0));
						System.out.println(hm.lastEntry().getKey());
						System.out.println("******end*********");
						if (i >= hm.get(neg.get(0))) {
							hm.remove(neg.get(0));
							neg.remove(0);
						}
					} else
						System.out.println(0);
				}
				++j;
				++i;
			}

		}

	}

}
