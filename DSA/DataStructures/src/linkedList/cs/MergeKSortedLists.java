package linkedList.cs;

public class MergeKSortedLists {

	public static void main(String[] args) {

		Linked a = new Linked();

		Node arr[] = new Node[5];

		arr[0] = a.getNewNode(1);
		arr[0].next = a.getNewNode(3);
		arr[0].next.next = a.getNewNode(5);
		arr[0].next.next.next = a.getNewNode(7);

		arr[1] = a.getNewNode(2);
		arr[1].next = a.getNewNode(4);
		arr[1].next.next = a.getNewNode(6);
		arr[1].next.next.next = a.getNewNode(8);

		arr[2] = a.getNewNode(0);
		arr[2].next = a.getNewNode(9);
		arr[2].next.next = a.getNewNode(10);
		arr[2].next.next.next = a.getNewNode(11);

		arr[3] = a.getNewNode(12);
		arr[3].next = a.getNewNode(14);
		arr[3].next.next = a.getNewNode(16);
		arr[3].next.next.next = a.getNewNode(18);

		arr[4] = a.getNewNode(0);
		arr[4].next = a.getNewNode(19);
		arr[4].next.next = a.getNewNode(20);
		arr[4].next.next.next = a.getNewNode(31);

//		Node mergedList = a.mergeKSortedLists(arr, arr.length - 1);
		Node mergedList = a.mergeKListsUsingPQ(arr);

		a.printList(mergedList);
	}

}
