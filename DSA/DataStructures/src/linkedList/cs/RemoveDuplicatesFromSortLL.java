package linkedList.cs;

public class RemoveDuplicatesFromSortLL {

	public static void main(String[] args) {

		Node head = null;
		Linked a = new Linked();

		head = a.insert(1, head);
		head = a.insert(1, head);
		head = a.insert(2, head);
		head = a.insert(3, head);
		head = a.insert(3, head);
		head = a.insert(3, head);
		head = a.insert(4, head);
		head = a.insert(5, head);
		head = a.insert(5, head);
		head = a.insert(6, head);

		a.printList(head);
		System.out.println();
		Node distinct = a.removeDuplicates(head);
		System.out.println();
		a.printList(distinct);

	}

}
