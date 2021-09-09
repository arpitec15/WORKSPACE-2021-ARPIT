package recursion;

//Java program to sort a Stack using recursion
//Note that here predefined Stack class is used
//for stack operation

import java.util.ListIterator;
import java.util.Stack;

class SortStack {

	static void sortedInsert(Stack<Integer> s, int x) {

		if (s.isEmpty() || s.peek() > x) {
			s.push(x);
			return;
		}

		else {
			int temp = s.pop();
			sortedInsert(s, x);
			s.push(temp);
		}

	}

	static void reverse(Stack<Integer> s) {

		if (s.size() == 0)
			return;

		int temp = s.pop();
		reverse(s);
		sortedInsert(s, temp);

	}

	// Utility Method to print contents of stack
	static void printStack(Stack<Integer> s) {
		ListIterator<Integer> lt = s.listIterator();

		// forwarding
		while (lt.hasNext())
			lt.next();

		// printing from top to bottom
		while (lt.hasPrevious())
			System.out.print(lt.previous() + " ");
	}

	// Driver code
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>();
		s.push(30);
		s.push(5);
		s.push(18);
		s.push(4);
		s.push(0);

		System.out.println("Stack elements before sorting: ");
		printStack(s);

		reverse(s);

		System.out.println(" \n\nStack elements after sorting:");
		printStack(s);
	}
}
