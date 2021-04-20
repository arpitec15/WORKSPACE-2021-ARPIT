package linkedList.cs;

public class InsertAtHead {

	public static void main(String[] args) {

		Node root = null;
		Linked a = new Linked();
		root = a.insert(12, root);
		root = a.insert(24, root);
		root = a.insert(36, root);

		root = a.insertFront(48, root);
		a.printList(root);
	}

}
