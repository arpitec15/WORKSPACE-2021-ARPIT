package linkedList.cs;

public class CountRotationInSortedRotatedList {

	public static void main(String[] args) {

		Linked a = new Linked();

		Node head = null;
		head = a.insert(22, head);
		head = a.insert(38, head);
		head = a.insert(1, head);
		head = a.insert(7, head);
		head = a.insert(13, head);

		a.printList(head);
		System.out.println();

		System.out.println(a.countRotationInSortedRotatedList(head));
	}

}
