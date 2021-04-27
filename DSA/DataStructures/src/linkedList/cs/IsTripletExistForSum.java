package linkedList.cs;

public class IsTripletExistForSum {

	public static void main(String[] args) {

		Linked a = new Linked();

		Node head1 = null;
		head1 = a.insert(5, head1);
		head1 = a.insert(2, head1);
		head1 = a.insert(9, head1);

		a.printList(head1);
		System.out.println();

//		Ascending
		Node head2 = null;
		head2 = a.insert(2, head2);
		head2 = a.insert(3, head2);
		head2 = a.insert(7, head2);

		a.printList(head2);
		System.out.println();

//		Descending
		Node head3 = null;
		head3 = a.insert(12, head3);
		head3 = a.insert(8, head3);
		head3 = a.insert(4, head3);

		a.printList(head3);
		System.out.println();

		System.out.println(a.isTripletExistForSum(head1, head2, head3, 13));
//		System.out.println(a.isTripletExistForSum(head1, head2, head3, 14));
	}

}
