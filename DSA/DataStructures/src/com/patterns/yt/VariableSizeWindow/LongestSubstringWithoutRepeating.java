package com.patterns.yt.VariableSizeWindow;

import java.util.HashMap;

public class LongestSubstringWithoutRepeating {

	public static void main(String[] args) {

//		char arr[] = { 'p', 'p', 'c', 'k', 'e', 'b', 'b' };
		char arr[] = { 'a', 'b', 'c', 'a', 'b', 'c', 'b', 'b' };
//		char arr[] = { 'b', 'b', 'c' , 'd'};
		int longest = longestNRSubstring(arr);
		System.out.println("Maximum length of non repeating chars sub array is " + longest);
	}

	public static int longestNRSubstring(char[] arr) {

		int i = 0, j = 0;
		int max = 0;

		HashMap<Character, Integer> hm = new HashMap<>();

		while (j < arr.length) {

			if (hm.containsKey(arr[j])) {
				while (hm.containsKey(arr[j])) {
					hm.remove(arr[i]);
					++i;
				}
			}

			else {
				hm.put(arr[j], 1);
				max = Math.max(j - i + 1, max);
				System.out.println(max);
				++j;
			}
		}
		return max;
	}
}
