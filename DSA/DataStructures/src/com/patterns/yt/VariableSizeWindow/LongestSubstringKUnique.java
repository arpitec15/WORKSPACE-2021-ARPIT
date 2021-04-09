package com.patterns.yt.VariableSizeWindow;

import java.util.HashMap;

public class LongestSubstringKUnique {

	public static void main(String[] args) {

//		char arr[] = { 'a', 'a', 'b', 'a', 'c', 'b', 'e', 'b', 'e', 'b', 'e' };
		char arr[] = { 'a', 'b', 'a', 'c', 'c', 'a','a', 'b'};
		int unique = 2;
		int longest = longestUniqueSubstring(arr, unique);
		System.out.println("Maximum length of sub array is " + longest);
	}

	public static int longestUniqueSubstring(char[] arr, int k) {

		int i = 0, j = 0;
		int max = 0;

		HashMap<Character, Integer> hm = new HashMap<>();

		while (j < arr.length) {

			insert(hm, arr[j]);
			if (hm.size() > k) {
				while (hm.size() > k && i < j) {
					remove(hm, arr[i]);
					i++;
				}
			}

			if (hm.size() == k) {
				max = Math.max(j - i + 1, max);
				++j;
			}

			if (hm.size() < k) {
				++j;
			}
		}

		return max;
	}

	private static void remove(HashMap<Character, Integer> hm, char c) {
		// TODO Auto-generated method stub
		if (hm.get(c) == 1)
			hm.remove(c);
		else if (hm.get(c) > 1)
			hm.put(c, hm.get(c) - 1);
		else if (hm.get(c) == 0)
			hm.remove(c);
	}

	private static void insert(HashMap<Character, Integer> hm, char c) {
		// TODO Auto-generated method stub
		if (hm.containsKey(c)) {
			hm.put(c, hm.get(c) + 1);
		} else
			hm.put(c, 1);
	}
}
