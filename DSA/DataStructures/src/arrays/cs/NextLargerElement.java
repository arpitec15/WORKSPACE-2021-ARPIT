package arrays.cs;

import java.util.Stack;

public class NextLargerElement {

	public static void main(String[] args) {

		int[] arr = { 1, 4, 2, 6, 1, 8, 3 };

		nextLargerElement(arr);

	}

	private static void nextLargerElement(int[] arr) {

		Stack<Integer> stack = new Stack<>();

		int nge[] = new int[arr.length-1];
		int j = 0;

		stack.push(arr[0]);
		for (int i = 1; i < arr.length; i++) {

			while (!stack.isEmpty() && arr[i] > stack.peek()) {
				stack.pop();
				nge[j++] = arr[i];
			}
			stack.push(arr[i]);
		}

		nge[j] = stack.pop();

		for (int i : nge) {
			System.out.print(i + " ");
		}

	}

}
