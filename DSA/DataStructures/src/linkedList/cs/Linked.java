package linkedList.cs;

class Linked {

	Node root;

	public Linked() {
		root = null;
	}

	public void printList(Node node) {
		if (node == null) {
			return;
		}

		System.out.print(node.i + " ");
		printList(node.next);
	}

	private Node getNewNode(int i) {

		Node a = new Node();
		a.i = i;
		a.next = null;
		return a;
	}

	public Node insert(int i, Node node) {

		if (node == null) {
			return getNewNode(i);
		}

		else {
			node.next = insert(i, node.next);
		}
		return node;
	}

	public Node insertFront(int i, Node root) {
		Node node = getNewNode(i);
		node.next = root;

		return node;
	}

	public Node insertAtGiven(int i, int position, Node node) {

		if (position < 1) {
		}

		if (node == null && position > 1) {
			System.out.println("Position is greater than element");
			return node;
		}

		if (node == null && position == 1) {
			return getNewNode(i);
		}

		if (position == 1) {
			Node newNode = getNewNode(i);
			newNode.next = node;
			return newNode;
		}

		node.next = insertAtGiven(i, position - 1, node.next);
		return node;

	}

	public Node deleteLast(Node root) {

		if (root == null || root.next == null) {
			return null;
		}

		Node temp = root;
		while (temp.next.next != null) {
			temp = temp.next;
		}

		temp.next = null;
		return root;
	}

	public Node deleteFront(Node root) {
		if (root == null) {
			return root;
		}

		return root.next;
	}

	public Node deleteAtPosition(int position, Node node) {

		if (position < 0) {
			System.out.println("Not a valid position");
		}

		if (node == null && position > 1) {
			System.out.println("Not valid position");
			return node;
		}
		if (position == 1) {
			return node.next;
		}

		node.next = deleteAtPosition(position - 1, node.next);
		return node;
	}

	public int sizeOfList(Node node) {
		// TODO Auto-generated method stub
		if (node == null)
			return 0;
		int count = 0;
		while (node != null) {
			count++;
			node = node.next;
		}
		return count;
	}

	public boolean searchNode(int i, Node node) {

		if (node == null)
			return false;

		while (node != null) {
			if (node.i == i)
				return true;
			node = node.next;
		}
		return false;
	}

	public Node rotateByK(int k, Node node) {
		if (node == null || k < 0) {
			return node;
		}

//	      calculate size of LL
		int sizeOfLinkedList = sizeOfList(node);
		k = k % sizeOfLinkedList;

//	      if no rotation needed
		if (k == 0) {
			return node;
		}

		Node tmp = node;
		int i = 1;

		while (i < sizeOfLinkedList - k) {
			tmp = tmp.next;
			i++;
		}

//		for k = 1 ; tmp is 4 -> 5 -> null

//	     for k = 3 tmp is {2, 3, 4, 5}

//		Copying value in another Node so as to make 
//		next of tmp as null;
		Node temp = tmp.next;

//		Copy node
		Node head = temp;

//		for k =3  ; 1 -> 2 -> null
//		for k = 1 ; 1 -> 2 -> 3 -> 4 -> null
		tmp.next = null;

//		3 -> 4 -> 5 -> null
		while (temp.next != null) {
			temp = temp.next;
		}

//		3 -> 4 -> 5 ->     1 -> 2 -> null

		temp.next = node;

		return head;

	}

	public Node rotateAntiClockByK(int k, Node node) {

		if (node == null || k < 0) {
			return node;
		}

		int sizeOfLinkedList = sizeOfList(node);
		k = k % sizeOfLinkedList;
		if (k == 0) {
			return node;
		}

		Node tmp = node;
		int i = 1;

		while (i < k) {
			tmp = tmp.next;
			i++;
		}

		Node temp = tmp.next;
		Node head = temp;
		tmp.next = null;

		i = 1;
		while (temp.next != null) {
			temp = temp.next;
		}

		temp.next = node;
		return head;

	}

	public Node reverseRecursive(Node node) {
		// TODO Auto-generated method stub

		if (node == null || node.next == null) {
			return node;
		}

		Node temp = reverseRecursive(node.next);
		node.next.next = node;
		node.next = null;

		return temp;
	}

	public Node findMiddleNode(Node node) {
		// TODO Auto-generated method stub
		Node slow = node;
		Node fast = node.next.next;
		while (fast != null && fast.next != null) {

			slow = slow.next;
			fast = fast.next.next;
		}

		Node temp = slow.next;
		slow.next = null;
		return temp;

//		---------------------------------------
//		Node slow = null;
//		
//        while (node != null && node.next != null) {
//            slow = (slow == null) ? node : slow.next;
//            node = node.next.next;
//        }
//        
//        Node mid = slow.next;
//        slow.next = null;
//        return mid;

//		---------------------------------------

//		if(node == null) {
//		      return null;
//		    }
//		    
//		    Node a = node;
//		    Node b = node.next;
//		    
//		    while(b != null && b.next != null) {
//		      a = a.next;
//		      b = b.next.next;
//		    }
//		    
//		    return a;
//        

	}

	public Node sortLinkedList(Node node) {

//		if (node == null || node.next == null) {
//			return node;
//		}
//
//		Node middle = findMiddleNode(node);
//		Node secondHalf = middle.next;
//		middle.next = null;
//
//		Node left = sortLinkedList(node);
//		Node right = sortLinkedList(secondHalf);
//
//		Node merge = merge(left, right);
//
//		return merge;

		if (node == null || node.next == null)
			return node;

		Node mid = findMiddleNode(node);
		Node left = sortLinkedList(node);
		Node right = sortLinkedList(mid);
		return merge(left, right);

	}

	public Node merge(Node a, Node b) {
		// TODO Auto-generated method stub

		Node temp = new Node();
		Node finalList = temp;

		while (a != null && b != null) {
			if (a.i < b.i) {
				temp.next = a;
				a = a.next;
			} else {
				temp.next = b;
				b = b.next;
			}
			temp = temp.next;
		}
		temp.next = (a == null) ? b : a;
		return finalList.next;
	}

	public Node getUnion(Node a, Node b) {

		a = sortLinkedList(a);
		b = sortLinkedList(b);
		return mergeWithUnion(a, b);

	}

	private Node mergeWithUnion(Node a, Node b) {

		Node temp = new Node();
		Node finalList = temp;
		while (a != null && b != null) {
			if (a.i < b.i) {
				temp.next = a;
				a = a.next;
			} else if (a.i > b.i) {
				temp.next = b;
				b = b.next;
			} else {
				temp.next = a;
				a = a.next;
				b = b.next;
			}
			temp = temp.next;
		}
		temp.next = (a == null) ? b : a;
		return finalList.next;
	}

	public Node getIntersection(Node a, Node b) {

		a = sortLinkedList(a);
		b = sortLinkedList(b);
		return mergeWithIntersection(a, b);
	}

	private Node mergeWithIntersection(Node a, Node b) {

		if (a == null && b == null) {
			return null;
		}

		if (a != null && b == null) {
			return a;
		}

		if (a == null && b != null) {
			return b;
		}

		Node temp = new Node();
		Node finalList = temp;
		while (a != null && b != null) {
			if (a.i < b.i) {
				a = a.next;
			} else if (a.i > b.i) {
				b = b.next;
			} else {
				temp.next = a;
				temp = temp.next;
				a = a.next;
				b = b.next;
			}
		}
		temp.next = null;
		return finalList.next;
	}

	public int getLowestCommonElement(Node a, Node b) {

		a = sortLinkedList(a);
		b = sortLinkedList(b);

		if (a == null && b == null) {
			return -1;
		}

		if (a != null && b == null) {
			return a.i;
		}

		if (a == null && b != null) {
			return b.i;
		}

		while (a != null && b != null) {
			if (a.i < b.i) {
				a = a.next;
			} else if (a.i > b.i) {
				b = b.next;
			} else {
				return a.i;
			}
		}
		return -1;
	}

	public Node removeDuplicates(Node head) {
		Node temp = null;

		while (head != null) {

			if (head.next == null) {
				temp = insert(head.i, temp);
				return temp;
			}

			else if (head.i == head.next.i) {
				head = head.next;

			} else {
				temp = insert(head.i, temp);
				head = head.next;
			}
		}

		return temp;
	}

	public Node delete_N_nodes_after_M_nodes(Node head, int N, int M) {

		Node temp = head;
		int i = 1;
		while (M > i) {
			temp = temp.next;
			++i;
		}

		Node temp2 = temp.next;
		temp.next = null;
		i = 0;
		while (N > i) {
			temp2 = temp2.next;
			i++;
		}

		while (temp2.next != null) {
			head = insert(temp2.i, head);
			temp2 = temp2.next;
		}
		head = insert(temp2.i, head);

		return head;
	}

	public Node removeNthNodeFromLast(Node head, int n) {

		Node dummy = new Node();
		dummy.next = head;
		Node first = dummy;
		Node second = dummy;
		// Advances first pointer so that the gap between first and second is n nodes
		// apart
		for (int i = 1; i <= n + 1; i++) {
			first = first.next;
		}
		// Move first to the end, maintaining the gap
		while (first != null) {
			first = first.next;
			second = second.next;
		}
		second.next = second.next.next;
		return dummy.next;

	}

	public boolean detectLoop(Node node) {

		Node fast = node;
		Node slow = node;

		while (fast.next != null && fast.next.next != null) {

			slow = slow.next;
			fast = fast.next.next;

			if (fast.i == slow.i)
				return true;
		}

		return false;
	}

	public int lengthOfLoop(Node head) {

		Node slow = head;
		Node fast = head;
		int length = 0;
		if (head == null)
			return -1;

		while (fast.next != null && fast.next.next != null) {

			slow = slow.next;
			fast = fast.next.next;

			if (fast.i == slow.i)
				break;
		}

		if (slow == fast) {
			while (fast.next != slow) {
				fast = fast.next;
				++length;
			}
			++length;
		}
		return length;
	}

	public void removeLoop(Node head) {

		if (head == null) {
			return;
		}

		Node slow, fast;

		slow = fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow.i == fast.i) {
				break;
			}
		}

		if (slow == fast) {
			if (fast == head) {
				while (slow.next != fast) {
					slow = slow.next;
				}

				slow.next = null;
			} else {
				slow = head;
				while (slow.next != fast.next) {
					slow = slow.next;
					fast = fast.next;
				}

				fast.next = null;
			}
		}

		return;

	}

	public void deleteMiddleElement(Node node) {

		if (node == null || node.next == null) {
			return;
		}

		Node slow, fast, prev;

		slow = fast = prev = node;

		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		prev.next = slow.next;
		return;

	}

	public Node moveLastNodeToFront(Node node) {

		if (node == null || node.next == null) {
			return node;
		}

		Node head = node;

		while (node.next.next != null) {
			node = node.next;
		}

		node.next.next = head;
		head = node.next;

		node.next = null;
		return head;

	}

	public int countOccurrence(Node node, int key) {

		int occ = 0;
		while (node.next != null) {
			if (node.i == key)
				++occ;

			node = node.next;
		}

		return occ;
	}

	public void swapNodes(int n1, int n2, Node head) {

		Node prevNode1 = null, prevNode2 = null, node1 = head, node2 = head;

		// Checks if list is empty
		if (head == null) {
			return;
		}

		// If n1 and n2 are equal, then
		// list will remain the same
		if (n1 == n2)
			return;

		// Search for node1
		while (node1 != null && node1.i != n1) {
			prevNode1 = node1;
			node1 = node1.next;
		}

		// Search for node2
		while (node2 != null && node2.i != n2) {
			prevNode2 = node2;
			node2 = node2.next;
		}

		if (node1 != null && node2 != null) {

			// If previous node to node1 is not null then,
			// it will point to node2
			if (prevNode1 != null)
				prevNode1.next = node2;
			else
				head = node2;

			// If previous node to node2 is not null then,
			// it will point to node1
			if (prevNode2 != null)
				prevNode2.next = node1;
			else
				head = node1;

			// Swaps the next nodes of node1 and node2
			Node temp = node1.next;
			node1.next = node2.next;
			node2.next = temp;
		} else {
			System.out.println("Swapping is not possible");
		}
	}

	public int getIntersectionOfLists(Node node1, Node node2) {

		if (node1 == null || node2 == null) {
			return -1;
		}

		Node head1 = node1, head2 = node2;

		int count1 = 0, count2 = 0;
		while (node1 != null) {
			count1++;
			node1 = node1.next;
		}

		while (node2 != null) {
			count2++;
			node2 = node2.next;
		}

		int v = count1 - count2;
		while (v > 0) {
			head1 = head1.next;
			v--;
		}

		while (v < 0) {
			head2 = head2.next;
			v++;
		}

		while (head1 != null && head2 != null) {
			if (head1.i == head2.i) {
				return head1.i;
			}

			head1 = head1.next;
			head2 = head2.next;
		}

		return -1;

	}

	public Node reverseIteratively(Node node) {

		if (node == null || node.next == null) {
			return node;
		}

		Node prev, next;
		prev = next = null;

		while (node != null) {
			next = node.next;
			node.next = prev;
			prev = node;
			node = next;
		}

		return prev;

	}

	public Node reverseInGroupK(Node head, int k) {

		Node prev, next;
		prev = next = null;

		Node node = head;

		int i = 0;

		while (node != null && i < k) {
			next = node.next;
			node.next = prev;
			prev = node;
			node = next;
			i++;
		}

		if (next != null) {
			head.next = reverseInGroupK(next, k);
		}

		return prev;

	}

	public Node reverseInGroupKAlternatively(Node head, int k) {

		if (k <= 1 || head == null || head.next == null) {
			return head;
		}
		Node prev, next;
		prev = next = null;

		Node node = head;

		int i = 0;

		while (node != null && i < k) {
			next = node.next;
			node.next = prev;
			prev = node;
			node = next;
			i++;
		}

		i = 0;
		if (next != null) {
			head.next = next;
			node = next;
			while (node != null && i < k - 1) {
				node = node.next;
				i++;
			}
			if (node != null) {
				node.next = reverseInGroupKAlternatively(node.next, k);
			}
		}

		return prev;
	}

	public Node separateEvenOddNodes(Node node) {

		if (node == null || node.next == null) {
			return node;
		}

		Node evenStartingNode, evenEndNode, oddStartingNode, oddEndNode;

		evenStartingNode = evenEndNode = oddStartingNode = oddEndNode = null;

		while (node != null) {
			if (node.i % 2 == 0) {
				if (evenStartingNode == null) {
					evenStartingNode = node;
					evenEndNode = evenStartingNode;
				} else {
					evenEndNode.next = node;
					evenEndNode = evenEndNode.next;
				}
			} else {
				if (oddStartingNode == null) {
					oddStartingNode = node;
					oddEndNode = oddStartingNode;
				} else {
					oddEndNode.next = node;
					oddEndNode = oddEndNode.next;
				}
			}

			node = node.next;
		}

		evenEndNode.next = oddStartingNode;
		oddEndNode.next = null;
		return evenStartingNode;

	}

	Node firstHead;
	Node secondHead;

	public void splitAlternatively(Node node) {

		if (node == null || node.next == null) {
			return;
		}

		Node firstTemp;
		Node secondTemp;

		firstHead = firstTemp = node;
		secondHead = secondTemp = node.next;
		node = node.next.next;

		while (node != null && node.next != null) {
			firstTemp.next = node;
			secondTemp.next = node.next;

			firstTemp = firstTemp.next;
			secondTemp = secondTemp.next;

			node = node.next.next;
		}

		if (node != null) {
			firstTemp.next = node;
			firstTemp = firstTemp.next;
		}

		firstTemp.next = null;
		secondTemp.next = null;

		return;
	}

//	Node first, second;

	public void mergeTwoListAlternatively(Node node1, Node node2) {

		Node node1next, node2next;

		Node first = node1;
		Node second = node2;
		Node temp = null;

		while (node1 != null && node2 != null) {

//			Variable just to preserve value
			node1next = node1.next;

//			Operation just to change value of "first" node
			node1.next = node2;

//			Copy back original value 
			node1 = node1next;

//			----------------------------------------

//			Variable just to preserve value
			node2next = node2.next;

//			Operation just to change value of "second" node
			node2.next = node1next;

//			Copy back original value 
			node2 = node2next;

		}

		second = node2;
		printList(first);
	}

	public Node addOne(Node node) {

		// Add 1 to linked list from end to beginning
		int carry = addWithCarry(node);

		// If there is carry after processing all nodes,
		// then we need to add a new node to linked list
		if (carry > 0) {
			Node newNode = getNewNode(carry);
			newNode.next = node;
			return newNode; // New node becomes head now
		}

		return node;
	}

	private int addWithCarry(Node head) {

		// If linked list is empty, then
		// return carry
		if (head == null)
			return 1;

		// Add carry returned be next node call
		int res = head.i + addWithCarry(head.next);

		// Update data and return new carry
		head.i = (res) % 10;
		return (res) / 10;
	}

	public Node addTwoNumbers(Node node1, Node node2) {

		node1 = this.reverseRecursive(node1);
		node2 = this.reverseRecursive(node2);

		Node newListHead = null;
		Node prev = null;
		int sum, c = 0;

		while (node1 != null || node2 != null) {
			sum = c + (node1 != null ? node1.i : 0) + (node2 != null ? node2.i : 0);

			c = sum / 10;

			Node node = getNewNode(sum % 10);
			if (newListHead == null) {
				newListHead = node;
			} else {
				prev.next = node;
			}

			prev = node;

			if (node1 != null) {
				node1 = node1.next;
			}

			if (node2 != null) {
				node2 = node2.next;
			}
		}

		if (c != 0) {
			prev.next = getNewNode(c);
		}

		newListHead = this.reverseRecursive(newListHead);

		return newListHead;
	}

	public Node subTwoNumbers(Node node1, Node node2) {

		Node head1 = node1;
		Node head2 = node2;

		int count1 = 0, count2 = 0;

		while (node1 != null) {
			node1 = node1.next;
			count1++;
		}

		while (node2 != null) {
			node2 = node2.next;
			count2++;
		}

		node1 = head1;
		node2 = head2;

		if ((count1 < count2) || (count1 == count2 && node2 == getBiggerList(node1, node2))) {
			Node t = node1;
			node1 = node2;
			node2 = t;
		}

		node1 = this.reverseRecursive(node1);
		node2 = this.reverseRecursive(node2);

		Node newListHead = null;
		int diff;
		int borrow = 0;

		while (node1 != null || node2 != null) {

			int firstNum = node1 == null ? 0 : node1.i;
			int secondNum = node2 == null ? 0 : node2.i;

			if (firstNum < secondNum) {
				diff = (10 + firstNum) - secondNum - borrow;
				borrow = 1;
				newListHead = insert(diff, newListHead);

			} else {

				diff = firstNum - secondNum - borrow;
				borrow = 0;
				newListHead = insert(diff, newListHead);

			}

			if (node1 != null && node1.next != null) {
				node1 = node1.next;
			} else {
				node1 = null;

			}

			if (node2 != null && node2.next != null) {
				node2 = node2.next;
			} else {
				node2 = null;
			}
		}

		newListHead = this.reverseRecursive(newListHead);

		return newListHead;

	}

	private Node getBiggerList(Node node1, Node node2) {

		Node head1 = node1;
		Node head2 = node2;
		while (node1 != null) {
			if (node1.i > node2.i) {
				return head1;
			} else if (node1.i < node2.i) {
				return head2;
			}

			node1 = node1.next;
			node2 = node2.next;
		}

		return head1;

	}

	public boolean isTripletExistForSum(Node node1, Node node2, Node node3, int val) {

		Node head2, head3;
		head2 = node2;
		head3 = node3;

		while (node1 != null) {
			while (node2 != null && node3 != null) {

				int s = node1.i + node2.i + node3.i;

				if (s == val) {
					return true;
				} else if (s > val) {
					node3 = node3.next;
				} else {
					node2 = node2.next;
				}
			}

			node1 = node1.next;
			node2 = head2;
			node3 = head3;
		}

		return false;

	}

	public Node makeMiddleNodeHead(Node node) {

		if (node == null || node.next == null) {
			return node;
		}

		Node slow, fast, head, prev;
		slow = fast = head = prev = node;

		while (fast.next != null && fast.next.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		prev.next = slow.next;
		slow.next = head;
		head = slow;

		return head;

	}

	public Node insertNodeInMiddle(Node node, int val) {

		Node slow = node, fast = node;

		while (fast.next != null && fast.next.next != null) {

			slow = slow.next;
			fast = fast.next.next;
		}

		Node newNode = getNewNode(val);

		Node temp = slow.next;
		newNode.next = temp;
		slow.next = newNode;

		return node;
	}

	public int countRotationInSortedRotatedList(Node node) {

		int count = 0;
		while (node != null) {

			if (node.i < node.next.i) {
				++count;
				node = node.next;
			} else {
				++count;
				break;
			}

		}

		if (node.next == null) {
			return 0;
		} else {
			return count + 1;
		}

	}
}