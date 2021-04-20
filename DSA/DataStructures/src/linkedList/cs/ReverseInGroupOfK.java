package linkedList.cs;

public class ReverseInGroupOfK {

	public static void main(String[] args) {
		Node root = null;
		Linked a = new Linked();
		root = a.insert(1, root);
		root = a.insert(2, root);
		root = a.insert(3, root);
		root = a.insert(4, root);
		root = a.insert(5, root);

		System.out.println("------------Reverse In Group --------------");
		a.printList(root);
		root = a.reverseInGroupK(root, 3);
		System.out.println();
		a.printList(root);
	}
}
