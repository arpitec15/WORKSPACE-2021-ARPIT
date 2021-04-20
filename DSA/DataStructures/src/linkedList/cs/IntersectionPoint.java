package linkedList.cs;

public class IntersectionPoint {

	public static void main(String[] args) {

		Node head1 = null;
		Linked a = new Linked();

		head1 = a.insert(1, head1);
		head1 = a.insert(24, head1);
		head1 = a.insert(34, head1);
		head1 = a.insert(9, head1);
		head1 = a.insert(8, head1);
		head1 = a.insert(37, head1);
		head1 = a.insert(5, head1);

		a.printList(head1);
		System.out.println();

		Node head2 = null;

		head2 = a.insert(12, head2);
		head2 = a.insert(99, head2);
		head2 = a.insert(8, head2);
		head2 = a.insert(37, head2);
		head2 = a.insert(5, head2);

		a.printList(head2);
		System.out.println();

		System.out.println(a.getIntersectionOfLists(head1, head2));

	}

}
