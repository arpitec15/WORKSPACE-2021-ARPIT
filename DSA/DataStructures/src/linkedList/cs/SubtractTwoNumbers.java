package linkedList.cs;

public class SubtractTwoNumbers {

	public static void main(String[] args) {

		Linked a = new Linked();

		Node head1 = null;
		head1 = a.insert(2, head1);
		head1 = a.insert(2, head1);
		head1 = a.insert(2, head1);
		head1 = a.insert(9, head1);
		head1 = a.insert(2, head1);

		a.printList(head1);
		System.out.println();

		Node head2 = null;
		head2 = a.insert(8, head2);
		head2 = a.insert(8, head2);
		head2 = a.insert(8, head2);

		a.printList(head2);
		System.out.println();

		Node diffLists = a.subTwoNumbers(head1, head2);
		a.printList(diffLists);
	}

}
