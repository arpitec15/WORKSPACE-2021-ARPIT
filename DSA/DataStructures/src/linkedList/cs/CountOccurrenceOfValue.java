package linkedList.cs;

public class CountOccurrenceOfValue {

	public static void main(String[] args) {

		Node root = null;
		Linked a = new Linked();
		root = a.insert(1, root);
		root = a.insert(2, root);
		root = a.insert(3, root);
		root = a.insert(4, root);
		root = a.insert(4, root);
		root = a.insert(5, root);

		System.out.println("------------Count Occurrence --------------");
		int occ = a.countOccurrence(root, 4);
		System.out.println("Occurence is " + occ);

	}

}
