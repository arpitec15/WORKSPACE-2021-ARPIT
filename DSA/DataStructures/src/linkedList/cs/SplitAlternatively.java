package linkedList.cs;

public class SplitAlternatively {

	public static void main(String[] args) {

		Node head1 = null;
		Linked a = new Linked();

		head1 = a.insert(1, head1);
		head1 = a.insert(2, head1);
		head1 = a.insert(3, head1);
		head1 = a.insert(4, head1);
		head1 = a.insert(5, head1);
		head1 = a.insert(6, head1);
		head1 = a.insert(7, head1);

		
		a.splitAlternatively(head1);

		a.printList(a.firstHead);
		System.out.println();
		a.printList(a.secondHead);
	}

}
