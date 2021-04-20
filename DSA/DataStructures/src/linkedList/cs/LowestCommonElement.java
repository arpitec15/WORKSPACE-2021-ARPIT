package linkedList.cs;

public class LowestCommonElement {

	public static void main(String[] args) {

		Node head1 = null;
		Linked a = new Linked();

		head1 = a.insert(37, head1);
		head1 = a.insert(18, head1);
		head1 = a.insert(13, head1);
		head1 = a.insert(13, head1);

		Node head2 = null;
		head2 = a.insert(3, head2);
		head2 = a.insert(14, head2);
		head2 = a.insert(8, head2);

		a.printList(head1);
		System.out.println();

		a.printList(head2);
		System.out.println();

		int lce = a.getLowestCommonElement(head1, head2);

		System.out.println("Lowest common element is " + lce);
	}

}
