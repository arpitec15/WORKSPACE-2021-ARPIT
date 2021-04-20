package linkedList.cs;

public class MoveLastNodeToFront {

	public static void main(String[] args) {

		Node root = null;
		Linked a = new Linked();
		root = a.insert(1, root);
		root = a.insert(2, root);
		root = a.insert(3, root);
		root = a.insert(4, root);
		root = a.insert(5, root);

		System.out.println("------------Move Last Node To Front --------------");
		a.printList(root);
		root = a.moveLastNodeToFront(root);
		System.out.println();
		a.printList(root);

	}

}
