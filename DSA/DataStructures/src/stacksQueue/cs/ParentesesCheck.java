package stacksQueue.cs;

import java.util.Stack;

public class ParentesesCheck {

	public static void main(String[] args) {

		String st1 = "a+((b*c)+(e*d))";
		String st2 = "a+((b*c)+(e*d)";

		boolean isBalanced = checkParentheses(st1);
		System.out.println(isBalanced);

	}

	public static boolean checkParentheses(String s) {

		Stack<Character> st = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			switch (c) {
			case '{':
			case '[':
			case '(':
				st.push(c);
				break;
			case '}':
			case ']':
			case ')':
				if (!st.isEmpty()) {
					char ch = st.pop();
					if (ch == '{' && c != '}' || ch == '[' && c != ']' || ch == '(' && c != ')') {
						System.out.println("Not valid bracket: " + c);
						return false;
					}
				} else {
					System.out.println("Not valid brackets");
					return false;
				}
				break;
			}
		}
		if (!st.isEmpty()) {
			System.out.println("Not valid Bracket");
			return false;
		}

		return true;
	}

}
