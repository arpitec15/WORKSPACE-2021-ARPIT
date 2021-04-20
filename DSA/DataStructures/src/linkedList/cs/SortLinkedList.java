package linkedList.cs;

public class SortLinkedList {

	public static void main(String[] args) {

		Node root = null;
		Linked a = new Linked();
		root = a.insert(5, root);
		root = a.insert(4, root);
		root = a.insert(3, root);
		root = a.insert(2, root);
		root = a.insert(1, root);

		System.out.println("------------Sort Linked List --------------");
		a.printList(root);
		System.out.println();
		System.out.println("********************");
		Node sort = a.sortLinkedList(root);
		a.printList(sort);
		
	}

}
