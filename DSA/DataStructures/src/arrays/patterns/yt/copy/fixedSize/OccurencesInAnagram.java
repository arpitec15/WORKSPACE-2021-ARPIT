package arrays.patterns.yt.copy.fixedSize;

import java.util.Arrays;

public class OccurencesInAnagram {

	final static int MAX_CHAR = 256;

	// Function to find if two strings are equal
	static boolean isCountZero(int[] count) {
		
//		Using Java 8 
		return Arrays.stream(count).allMatch(p -> p==0);
		
//		Using Java 7
		
//		for (int i = 0; i < MAX_CHAR; i++)
//			if (count[i] != 0)
//				return false;
//		return true;
	}

	static int countAnagrams(String text, String word) {
		int N = text.length();
		int n = word.length();

		// Check for first window. The idea is to
		// use single count array to match counts
		int[] count = new int[MAX_CHAR];
		for (int i = 0; i < n; i++)
			count[word.charAt(i)]++;
		for (int i = 0; i < n; i++)
			count[text.charAt(i)]--;

		// If first window itself is anagram
		int res = 0;
		if (isCountZero(count))
			res++;

		for (int i = n; i < N; i++) {

			// Add last character of current
			// window
			count[text.charAt(i)]++;

			// Remove first character of previous
			// window.
			count[text.charAt(i - n)]--;

			// If count array is 0, we found an
			// anagram.
			if (isCountZero(count))
				res++;
		}
		return res;
	}

	static int countAnagramsPractise(String text, String word) {

		int n = word.length();
		int N = text.length();
		int occ = 0;

		int[] count = new int[MAX_CHAR];

		for (int i = 0; i < n; i++) {
			count[word.charAt(i)]++;
		}

		for (int j = 0; j < n; j++) {
			count[text.charAt(j)]--;
		}

		if (isCountZero(count))
			occ++;

		for (int i = n; i < N; i++) {
			
			count[text.charAt(i)]++;
			count[text.charAt(i-n)]--;

			if (isCountZero(count)) {
				occ++;
			}
		}

		return occ;

	}

	public static void main(String[] args) {
		String text = "forxxorfxdofr";
		String word = "for";
//		System.out.print(countAnagrams(text, word));
		System.out.print(countAnagramsPractise(text, word));

	}

}
