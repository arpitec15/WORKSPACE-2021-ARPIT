package arrays.educative;

class MinSizeSubArraySum {
	public static int findMinSubArray(int S, int[] arr) {
		int windowSum = 0, minLength = Integer.MAX_VALUE;
		int j = 0;
		for (int i = 0; i < arr.length; i++) {
			windowSum += arr[i]; // add the next element
			// shrink the window as small as possible until the 'windowSum' is smaller than
			// 'S'
			while (windowSum >= S) {
				minLength = Math.min(minLength, i - j + 1);
				windowSum -= arr[j]; // subtract the element going out
				j++; // slide the window ahead
			}
		}

		return minLength == Integer.MAX_VALUE ? 0 : minLength;
	}

	public static void main(String[] args) {
		int result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 });
		System.out.println("Smallest subarray length: " + result);
		result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 8 });
		System.out.println("Smallest subarray length: " + result);
		result = MinSizeSubArraySum.findMinSubArray(8, new int[] { 3, 4, 1, 1, 6 });
		System.out.println("Smallest subarray length: " + result);
	}
}