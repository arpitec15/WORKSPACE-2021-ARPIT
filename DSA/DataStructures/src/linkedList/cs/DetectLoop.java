package linkedList.cs;

public class DetectLoop {

	public static void main(String[] args) {
		Node head = null;
		Linked a = new Linked();
		head = a.insert(12, head);
		head = a.insert(99, head);
		head = a.insert(37, head);
		head = a.insert(5, head);
		head = a.insert(25, head);

		head.next.next.next.next.next = head.next;

		boolean isLoopPresent = a.detectLoop(head);
		
		System.out.println(isLoopPresent);

	}
}
