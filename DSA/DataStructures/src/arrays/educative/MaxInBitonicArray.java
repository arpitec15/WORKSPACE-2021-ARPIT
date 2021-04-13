package arrays.educative;

class MaxInBitonicArray {

	public static int findMax(int[] arr) {
		// TODO: Write your code here

		int max = 0;
		int i = 0;
		boolean ascending = false;
		boolean descending = false;

		if (arr[i] > arr[i + 1])
			descending = true;
		else
			ascending = true;

		while (i < arr.length - 1 && ((ascending && arr[i] < arr[i + 1]) || (descending && arr[i] > arr[i + 1]))) {
			max = Math.max(max, arr[i]);
			i++;
			max = Math.max(max, arr[i]);
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println(MaxInBitonicArray.findMax(new int[] { 1, 3, 8, 12, 4, 2 }));
		System.out.println(MaxInBitonicArray.findMax(new int[] { 3, 8, 3, 1 }));
		System.out.println(MaxInBitonicArray.findMax(new int[] { 1, 3, 8, 12 }));
		System.out.println(MaxInBitonicArray.findMax(new int[] { 10, 9, 8 }));
	}
}