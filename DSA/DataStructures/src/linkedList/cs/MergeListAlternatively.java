package linkedList.cs;

public class MergeListAlternatively {

	public static void main(String[] args) {

		Node head1 = null;
		Linked a = new Linked();

		head1 = a.insert(1, head1);
		head1 = a.insert(3, head1);
		head1 = a.insert(5, head1);
		head1 = a.insert(7, head1);

		Node head2 = null;
		head2 = a.insert(2, head2);
		head2 = a.insert(4, head2);
		head2 = a.insert(6, head2);

		a.printList(head1);
		System.out.println();

		a.printList(head2);
		System.out.println();

		a.mergeTwoListAlternatively(head1, head2);

//		a.printList(a.first);
	}

}
