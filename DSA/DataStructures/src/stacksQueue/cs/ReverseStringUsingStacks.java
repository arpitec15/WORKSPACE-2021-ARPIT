package stacksQueue.cs;

import java.util.Stack;

public class ReverseStringUsingStacks {

	public static void main(String[] args) {

		String s = "ARPIT";
		String reverse = reverseString(s);
		System.out.println("Reversed string is " + reverse);

	}

	private static String reverseString(String s) {

		Stack<Character> stack = new Stack<>();
		String reverseString = "";

		for (int i = 0; i < s.length(); i++) {
			stack.push(s.charAt(i));
		}

		while (!stack.isEmpty()) {

			reverseString = reverseString + stack.pop();

		}

		return reverseString;
	}

}
