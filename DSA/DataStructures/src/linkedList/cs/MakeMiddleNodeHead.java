package linkedList.cs;

public class MakeMiddleNodeHead {

	public static void main(String[] args) {

		Linked a = new Linked();

		Node head = null;
		head = a.insert(12, head);
		head = a.insert(7, head);
		head = a.insert(13, head);
		head = a.insert(22, head);
		head = a.insert(8, head);

		a.printList(head);
		System.out.println();

		head = a.makeMiddleNodeHead(head);

		a.printList(head);
	}

}
