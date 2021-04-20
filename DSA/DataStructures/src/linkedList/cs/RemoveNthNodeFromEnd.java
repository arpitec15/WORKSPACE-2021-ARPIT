package linkedList.cs;

public class RemoveNthNodeFromEnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node root = null;
		Linked a = new Linked();
		root = a.insert(1, root);
		root = a.insert(2, root);
		root = a.insert(3, root);
		root = a.insert(4, root);
		root = a.insert(5, root);

		root = a.removeNthNodeFromLast(root, 2);

		a.printList(root);

	}

}
