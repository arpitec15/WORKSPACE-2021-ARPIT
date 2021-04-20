package linkedList.cs;

public class Delete_N_NodesAfter_M_Nodes {

	public static void main(String[] args) {

		Node head = null;
		Linked a = new Linked();

		head = a.insert(1, head);
		head = a.insert(2, head);
		head = a.insert(3, head);
		head = a.insert(4, head);
		head = a.insert(5, head);
		head = a.insert(6, head);

		a.printList(head);
		System.out.println();
		Node out = a.delete_N_nodes_after_M_nodes(head,2,2);
		System.out.println();
		a.printList(out);

	}

}
