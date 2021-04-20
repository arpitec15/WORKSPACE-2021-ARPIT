package linkedList.cs;

public class SearchNode {

	public static void main(String[] args) {
		Node root = null;
		Linked a = new Linked();
		root = a.insert(12, root);
		root = a.insert(24, root);
		root = a.insert(36, root);
		root = a.insert(48, root);
		root = a.insert(72, root);

		boolean isPresent = a.searchNode(12, root);
		
		System.out.println("Is present - " + isPresent);
	}
}
