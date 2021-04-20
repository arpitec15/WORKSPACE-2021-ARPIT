package linkedList.cs;

public class Practise {

	public static void main(String[] args) {
		
		Node root = null;
		Linked a = new Linked();
		root = a.insert(1, root);
		root = a.insert(2, root);
		root = a.insert(3, root);
		root = a.insert(4, root);
		root = a.insert(5, root);
		
		Node one = root;
		Node two = one;
		Node three = null;

		while(one.next!= null) {
			if(one.i <3) {
				three = a.insert(one.i, three);				
			}
			one = one.next;
		}
		
//		Node temp = null;
//		temp = a.insert(11, temp);
//		temp = a.insert(12, temp);
//		temp = a.insert(13, temp);
//		temp = a.insert(14, temp);
//		temp = a.insert(15, temp);
//		
//		three.next.next.next = temp;
//		
		a.printList(root);
		System.out.println();
		System.out.println();
		a.printList(one);
		System.out.println();
		System.out.println();
		a.printList(three);
//		System.out.println();
//		System.out.println();
	}
}

