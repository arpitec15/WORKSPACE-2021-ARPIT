package linkedList.cs;

public class AddOneAsNumber {

	public static void main(String[] args) {

		Node root = null;
		Linked a = new Linked();
		root = a.insert(9, root);
		root = a.insert(9, root);
		root = a.insert(9, root);
		root = a.insert(9, root);
		root = a.insert(9, root);
		root = a.insert(9, root);

		
		Node out = a.addOne(root);
		a.printList(out);
	}

}
