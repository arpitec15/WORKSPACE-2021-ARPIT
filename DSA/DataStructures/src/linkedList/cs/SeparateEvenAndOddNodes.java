package linkedList.cs;

public class SeparateEvenAndOddNodes {

	public static void main(String[] args) {
		Node root = null;
		Linked a = new Linked();
		root = a.insert(1, root);
		root = a.insert(2, root);
		root = a.insert(3, root);
		root = a.insert(4, root);
		root = a.insert(5, root);

		System.out.println("------------Reverse Alternatively --------------");
		a.printList(root);
		root = a.separateEvenOddNodes(root);
		System.out.println();
		a.printList(root);
	}
}
