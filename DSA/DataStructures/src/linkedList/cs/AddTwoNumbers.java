package linkedList.cs;

public class AddTwoNumbers {

	public static void main(String[] args) {

		Linked a = new Linked();

		Node head1 = null;
		head1 = a.insert(1, head1);
		head1 = a.insert(1, head1);
		head1 = a.insert(1, head1);
		head1 = a.insert(1, head1);
		head1 = a.insert(2, head1);

		a.printList(head1);
		System.out.println();

		Node head2 = null;
		head2 = a.insert(1, head2);
		head2 = a.insert(1, head2);
		head2 = a.insert(1, head2);

		a.printList(head2);
		System.out.println();

		Node addLists = a.addTwoNumbers(head1, head2);
		a.printList(addLists);
	}

}
