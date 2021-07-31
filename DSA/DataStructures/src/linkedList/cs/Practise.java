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
//		root = a.insert(6,  root);
//		root = a.insert(7, root);

//		Node inserted = a.insertAtGiven(25 , 3, root);
//		a.printList(inserted);

//		Node rotateByK = a.rotateByK(1, root);
//		a.printList(rotateByK);

//		System.out.println();

//		Node rotateAntiByK = a.rotateAntiClockByK(1, root);
//		a.printList(rotateAntiByK);

		
//		Node reverseRecursive = a.reverseRecursive(root);
//		a.printList(reverseRecursive);
		
//		Node moveLastNodeToFront = a.moveLastNodeToFront(root);
//		a.printList(moveLastNodeToFront);
		
		Node reverseInGroupK = a.reverseInGroupK(root, 2);
		a.printList(reverseInGroupK);
		
//		Node reverseInGroupKA = a.reverseInGroupKAlternatively(root, 2);
//		a.printList(reverseInGroupKA);
	}
}
