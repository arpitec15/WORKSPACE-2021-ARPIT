package linkedList.cs;

public class DeleteMiddleNode {

	public static void main(String[] args) {
		Node head = null;
		Linked a = new Linked();
		head = a.insert(12, head);
		head = a.insert(99, head);
		head = a.insert(37, head);
		head = a.insert(5, head);
		head = a.insert(25, head);


		a.deleteMiddleElement(head);

		a.printList(head);

	}
}
