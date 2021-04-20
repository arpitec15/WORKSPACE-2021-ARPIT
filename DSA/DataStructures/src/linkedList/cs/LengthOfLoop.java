package linkedList.cs;

public class LengthOfLoop {

	public static void main(String[] args) {
		Node head = null;
		Linked a = new Linked();
		head = a.insert(12, head);
		head = a.insert(99, head);
		head = a.insert(37, head);
		head = a.insert(5, head);
		head = a.insert(25, head);
		
//		head.next.next.next.next.next = head.next;

		head = a.insert(8, head);
		head = a.insert(9, head);
		head = a.insert(5, head);

		head.next.next.next.next.next.next.next.next = head.next.next.next.next;
		

		int lengthOfLoop = a.lengthOfLoop(head);
		
		System.out.println(lengthOfLoop);

	}
}
