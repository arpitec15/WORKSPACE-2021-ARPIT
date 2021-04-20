package linkedList.cs;

public class FindMiddleNode {

	public static void main(String[] args) {

		Node root = null;
		Linked a = new Linked();
		root = a.insert(1, root);
		root = a.insert(2, root);
		root = a.insert(3, root);
		root = a.insert(4, root);
		root = a.insert(5, root);

//		root = a.insert(5, root);
//		root = a.insert(3, root);
		
		System.out.println("------------Middle element --------------");
		Node mid = a.findMiddleNode(root);
		System.out.println(mid.i);
		
	}

}
