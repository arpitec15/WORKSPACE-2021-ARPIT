package linkedList.cs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

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

	Node getNewNode(int i) {

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

//		node.next.next = head;
//		head = node.next;
//
//		node.next = null;
//		return head;

		Node temp = node.next;
		node.next = null;
		temp.next = head;

		return temp;

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
			int count = 0;
			Node copy = next;
			while (copy != null) {
				copy = copy.next;
				++count;
			}
			if (count < k) {
				head.next = next;
			} else {

				head.next = reverseInGroupK(next, k);
			}
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

	public Node mergeKSortedLists(Node[] arr, int last) {
		while (last != 0) {
			int i = 0;
			int j = last;

			while (i < j) {
				arr[i] = mergeTwoSortedLinkedList(arr[i], arr[j]);

				i++;
				j--;

				if (i >= j) {
					last = j;
					break;
				}
			}
		}

		return arr[0];
	}

	/*
	 * It merges two sorted linked list
	 */
	public Node mergeTwoSortedLinkedList(Node node1, Node node2) {
		if (node1 == null && node2 == null) {
			return null;
		}

		if (node1 == null || node2 == null) {
			return node1 != null ? node1 : node2;
		}

		return mergeTwoList(node1, node2);
	}

	/*
	 * Helper function to merge two sorted linked list
	 */
	public Node mergeTwoList(Node first, Node second) {
		if (first == null && second == null) {
			return null;
		}

		Node tmp = new Node();
		Node finalList = tmp;
		while (first != null && second != null) {
			if (first.i < second.i) {
				tmp.next = first;
				first = first.next;
			} else {
				tmp.next = second;
				second = second.next;
			}

			tmp = tmp.next;
		}

		tmp.next = (first != null) ? first : second;

		return finalList.next;
	}

//	--------------------------------------------
//	Merge K sorted K Linked List Using Priority Queue
//	Leetcode HARD problem

	public Node mergeKListsUsingPQ(Node[] lists) {
		if (lists == null || lists.length == 0)
			return null;
		PriorityQueue<Node> queue = new PriorityQueue<Node>(lists.length, (a, b) -> a.i - b.i);
		Node dummy = new Node();
		Node tail = dummy;

		for (Node node : lists)
			if (node != null)
				queue.add(node);

		while (!queue.isEmpty()) {
			tail.next = queue.poll();
			tail = tail.next;

			if (tail.next != null)
				queue.add(tail.next);
		}
		return dummy.next;
	}

//	--------------------------------------------
	public Node getUnionOfTwoLinkedList(Node node1, Node node2) {
		if (node1 == null && node2 == null) {
			return null;
		}

		if (node1 == null || node2 == null) {
			return node1 != null ? node1 : node2;
		}

		Set<Integer> s = new HashSet<>();

		Node temp = new Node();
		Node result = temp;

		while (node1 != null) {
			if (!s.contains(node1.i)) {
				temp.next = node1;
				temp = temp.next;
				s.add(node1.i);
			}
			node1 = node1.next;
		}

		while (node2 != null) {
			if (!s.contains(node2.i)) {
				temp.next = node2;
				temp = temp.next;
				s.add(node2.i);
			}
			node2 = node2.next;
		}
		temp.next = null;

		return result.next;
	}

	public Node getIntersectionOfTwoLinkedList(Node node1, Node node2) {
		if (node1 == null || node2 == null) {
			return null;
		}

		Set<Integer> s = new HashSet<>();

		Node temp = new Node();
		Node result = temp;

		while (node1 != null) {
			s.add(node1.i);
			node1 = node1.next;
		}

		while (node2 != null) {
			if (s.contains(node2.i)) {
				temp.next = node2;
				temp = temp.next;
			}
			node2 = node2.next;
		}

		temp.next = null;

		return result.next;
	}

	public int getSumOfPairs(Node node1, Node node2, int sum) {
		if (node1 == null || node2 == null) {
			return 0;
		}

		HashSet<Integer> s = new HashSet<>();
		int countPairs = 0;

		while (node1 != null) {
			s.add(node1.i);
			node1 = node1.next;
		}

		while (node2 != null) {
			if (s.contains(sum - node2.i)) {
				countPairs++;
			}

			node2 = node2.next;
		}

		return countPairs;

	}

	public int getSumOfNodes(Node node) {
		if (node == null) {
			return 0;
		}

		int sum = 0;
		while (node != null) {
			sum = sum + node.i;
			node = node.next;
		}

		return sum;
	}

	public int getSumOfLastNNodes(Node node, int n) {
		if (node == null || n <= 0) {
			return 0;
		}

		int sum = 0;
		Node head = node;

		while (node != null && n > 0) {
			sum = sum + node.i;
			node = node.next;
			n--;
		}

		if (node == null) {
			if (n > 0) {
				System.out.println("N is greater than total nodes");
				return 0;
			} else {
				return sum;
			}
		}

		while (node.next != null) {
			node = node.next;
			head = head.next;
		}

		head = head.next;
		sum = 0;

		while (head != null) {
			sum = sum + head.i;
			head = head.next;
		}

		return sum;
	}

	public boolean ifEvenNodes(Node node) {
		if (node == null) {
			return true;
		}

		Node temp = node;

		while (temp.next != null && temp.next.next != null) {
			temp = temp.next.next;
		}

		if (temp.next == null) {
			return false;
		} else {
			return true;
		}
	}

	public Node removeEveryKthNode(Node node, int k) {
		if (node == null || k <= 1) {
			return null;
		}

		if (node.next == null && k > 1) {
			System.out.println("Not a valid case");
			return node;
		}

		Node head = node;
		int i = 1;

		while (node != null && node.next != null) {
			if (i % (k - 1) == 0) {
				node.next = node.next.next;
			}

			node = node.next;
			i++;
		}

		return head;
	}

	public void deleteOnlyGivenNode(Node node) {
		if (node == null || node.next == null) {
			return;
		}

		node.i = node.next.i;
		node.next = node.next.next;
	}

	public Node deleteLastOccurrenceOfItem(Node node, int val) {
		if (node == null) {
			return null;
		}

		Node head, temp;

		head = node;
		temp = null;

		while (node != null) {
			if (node.i == val) {
				temp = node;
			}

			node = node.next;
		}

		if (temp == null) {
			return head;
		}

		if (temp == head) {
			return head.next;
		}

		if (temp.next == null) {
			node = head;
			while (node.next.next != null) {
				node = node.next;
			}
			node.next = null;
			return head;
		}

		temp.i = temp.next.i;
		temp.next = temp.next.next;

		return head;
	}

	public Node sortWhichIsSortedOnAbsoluteValue(Node head) {
		if (head == null || head.next == null) {
			return head;
		}

		Node node, next, prev;

		node = next = head;
		prev = null;

		if (head.i < 0) {
			prev = node;
			node = node.next;
		}

		while (node != null) {
			if (node.i < 0) {
				prev.next = node.next;
				next = node.next;
				node.next = head;
				head = node;
				node = next;
			} else {
				prev = node;
				node = node.next;
			}
		}

		return head;
	}

	public Node clone(Node node) {
		if (node == null) {
			return node;
		}

		Node first = node;
		Node next = null;

		while (node != null) {
			Node newNode = getNewNode(node.i);
			next = node.next;
			node.next = newNode;
			newNode.next = next;

			node = next;
		}

		node = first;

		while (node != null) {
			node.next.random = node.random.next;
			node = node.next != null ? node.next.next : node.next;
		}

		node = first;
		Node copy = node.next;
		Node tempCopy = copy;

		while (node != null && copy != null) {
			node.next = node.next != null ? node.next.next : node.next;
			copy.next = copy.next != null ? copy.next.next : copy.next;

			node = node.next;
			copy = copy.next;
		}

		return tempCopy;
	}

	public Node cloneUsingHashmap(Node firstHead) {
		if (firstHead == null) {
			return null;
		}

		HashMap<Node, Node> m = new HashMap<>();
		Node secondHead = null, secondNode = null;
		Node firstNode = firstHead;

		while (firstNode != null) {
			Node newNode = getNewNode(firstNode.i);
			if (secondHead == null) {
				secondHead = newNode;
				secondNode = secondHead;
			} else {
				secondNode.next = newNode;
				secondNode = newNode;
			}

			m.put(firstNode, secondNode);
			firstNode = firstNode.next;
		}

		firstNode = firstHead;
		secondNode = secondHead;

		while (firstNode != null) {
			if (firstNode.random != null) {
				secondNode.random = m.get(firstNode.random);
			}

			firstNode = firstNode.next;
			secondNode = secondNode.next;
		}

		return secondHead;
	}

//	  -----------------------------------------------------------------

	public Node mergeTwoSortedLinkedListReverseOrder(Node node1, Node node2) {
		if (node1 == null && node2 == null) {
			return null;
		}

		Node mergedList, next;
		mergedList = null;

		while (node1 != null && node2 != null) {
			if (node1.i < node2.i) {
				next = node1.next;
				node1.next = mergedList;
				mergedList = node1;
				node1 = next;
			} else {
				next = node2.next;
				node2.next = mergedList;
				mergedList = node2;
				node2 = next;
			}
		}

		Node temp = node1 != null ? node1 : node2;
		while (temp != null) {
			next = temp.next;
			temp.next = mergedList;
			mergedList = temp;
			temp = next;
		}

		return mergedList;
	}

//	----------------------------------------------------------------

	public Node moveAllOccurrenceOfElementToEnd(Node head, int value) {
		if (head == null || head.next == null) {
			return head;
		}

		Node node, tail, prev, next, temp;
		node = head;
		prev = null;

		while (node.next != null) {
			node = node.next;
		}

		tail = node;
		temp = tail;
		node = head;

		while (node != temp) {
			if (node.i == value && prev == null) {
				next = node.next;
				tail.next = node;
				tail = tail.next;
				node.next = null;
				node = head = next;
			} else if (node.i == value && prev != null) {
				next = node.next;
				prev.next = node.next;
				tail.next = node;
				tail = tail.next;
				node.next = null;
				node = next;
			} else {
				prev = node;
				node = node.next;
			}
		}

		return head;
	}

	public Node rearrangeLinkedListZigzag(Node head) {
		if (head == null || head.next == null) {
			return head;
		}

		Node node = head;
		boolean flag = true;

		while (node.next != null) {
			if (flag) {
				if (node.i > node.next.i) {
					int t = node.i;
					node.i = node.next.i;
					node.next.i = t;
				}
				flag = !flag;
			} else {
				if (node.i < node.next.i) {
					int t = node.i;
					node.i = node.next.i;
					node.next.i = t;
				}
				flag = !flag;
			}

			node = node.next;
		}

		return head;
	}

	public Node createList(int arr[]) {
		Node node = null;

		for (int i = 0; i < arr.length; i++) {
			node = insert(arr[i], node);
		}

		return node;
	}

	public Node flattenEasy(Node node) {
		if (node == null) {
			return node;
		}

		Node start, end;
		start = end = node;

		while (end.next != null) {
			end = end.next;
		}

		while (start != null) {
			if (start.child != null) {
				end.next = start.child;
				end = end.next;

				while (end.next != null) {
					end = end.next;
				}
			}
			start = start.next;
		}

		return node;
	}

//	Q.75 left

	public Node rearrangeLinkedListAlternateMinMaxElements(Node head) {
		if (head == null || head.next == null) {
			return head;
		}

		head = sortLinkedList(head);

		Node middleNode = findMiddleNode(head);
		Node nextList = middleNode.next;
		middleNode.next = null;

		Node reversedList = reverseRecursive(nextList);
		Node firstList = head;

		Node finalList = new Node();
		Node node = finalList;

		while (firstList != null || reversedList != null) {

			if (firstList != null) {
				node.next = firstList;
				node = node.next;
				firstList = firstList.next;
			}

			if (reversedList != null) {
				node.next = reversedList;
				node = node.next;
				reversedList = reversedList.next;
			}
		}

		return finalList.next;
	}

	public Node rearrangeLinkedListInPlace(Node head) {
		if (head == null || head.next == null || head.next.next == null) {
			return head;
		}

		Node middleNode = findMiddleNode(head);
		Node nextList = middleNode.next;
		middleNode.next = null;

		Node reversedList = reverseRecursive(nextList);
		Node firstList = head;

		Node finalList = new Node();
		Node node = finalList;

		while (firstList != null || reversedList != null) {

			if (firstList != null) {
				node.next = firstList;
				node = node.next;
				firstList = firstList.next;
			}

			if (reversedList != null) {
				node.next = reversedList;
				node = node.next;
				reversedList = reversedList.next;
			}
		}

		return finalList.next;
	}

	public Node rearrangeLinkedListAroundGivelValueKeepOrder(Node head, int val) {
		if (head == null || head.next == null) {
			return head;
		}

		Node lessValueStartNode, lessValueEndNode, givenValueStartNode, givenValueEndNode, greaterValuesStartNode,
				greaterValuesEndNode;

		lessValueEndNode = lessValueStartNode = null;
		givenValueStartNode = givenValueEndNode = null;
		greaterValuesStartNode = greaterValuesEndNode = null;

		Node node = head;

		while (node != null) {
			if (node.i < val) {
				if (lessValueStartNode == null) {
					lessValueStartNode = lessValueEndNode = node;
				} else {
					lessValueEndNode.next = node;
					lessValueEndNode = node;
				}
			} else if (node.i == val) {
				if (givenValueStartNode == null) {
					givenValueStartNode = givenValueEndNode = node;
				} else {
					givenValueEndNode.next = node;
					givenValueEndNode = node;
				}
			} else {
				if (greaterValuesStartNode == null) {
					greaterValuesStartNode = greaterValuesEndNode = node;
				} else {
					greaterValuesEndNode.next = node;
					greaterValuesEndNode = node;
				}
			}
			node = node.next;
		}

		lessValueEndNode.next = givenValueStartNode;
		givenValueEndNode.next = greaterValuesStartNode;

		greaterValuesEndNode.next = null;

		return lessValueStartNode;
	}

	public Node arbitraryPointToNextGreaterElement(Node head) {
		if (head == null || head.next == null) {
			return head;
		}

		Node node = head;
		while (node != null) {
			node.random = node.next;
			node = node.next;
		}

		sortLinkedList(head);

		return head;
	}

	public Node alternateOddEvenNode(Node head) {
		if (head == null || head.next == null) {
			return head;
		}

		Node odd = new Node();
		Node oddHead = odd;
		Node even = new Node();
		Node evenHead = even;

		Node node = head;

		while (node != null) {
			if (node.i % 2 == 0) {
				even.next = node;
				even = even.next;
			} else {
				odd.next = node;
				odd = odd.next;
			}

			node = node.next;
		}

		odd.next = null;
		even.next = null;

		odd = oddHead.next;
		even = evenHead.next;

		Node curr = new Node();
		Node finalList = curr;

		while (odd != null || even != null) {
			if (odd != null) {
				curr.next = odd;
				curr = curr.next;
				odd = odd.next;
			}

			if (even != null) {
				curr.next = even;
				curr = curr.next;
				even = even.next;
			}
		}

		curr.next = odd != null ? odd : even;

		return finalList.next;
	}

	public boolean checkIfLinkedListOfStringFormsPalindrome(Node head) {
		if (head == null) {
			return false;
		}

		if (head.next == null) {
			return true;
		}

		Node middle = findMiddleNode(head);
		middle.next = reverseRecursive(middle.next);
		Node secondHalf = middle.next;
		Node second = secondHalf;
		middle.next = null;

		boolean ifPalidrome = true;
		while (head != null && second != null) {
			if (head.i != second.i) {
				return false;
			}

			head = head.next;
			second = second.next;
		}

		if (head != null && second == null) {
			ifPalidrome = true;
		}

		middle.next = reverseRecursive(secondHalf);

		return ifPalidrome;
	}

	public int compareString(Node head1, Node head2) {
		if (head1 == null && head2 == null) {
			return 0;
		}

		while (head1 != null && head2 != null) {
			if (head1.i < head2.i) {
				return -1;
			} else if (head1.i > head2.i) {
				return 1;
			}

			head1 = head1.next;
			head2 = head2.next;
		}

		if (head1 == null && head2 == null) {
			return 0;
		}

		return head1 != null ? 1 : -1;
	}

	public int lengthOfLongestPalindrome(Node node) {
		if (node == null) {
			return 0;
		}

		if (node.next == null) {
			return 1;
		}

		Node next, prev;
		prev = next = null;
		int result = 1;

		while (node != null) {
			next = node.next;
			node.next = prev;

			result = Math.max(result, 2 * getCommonElementCount(prev, next) + 1);
			result = Math.max(result, 2 * getCommonElementCount(node, next));

			prev = node;
			node = next;
		}

		return result;
	}

	public int getCommonElementCount(Node a, Node b) {
		int count = 0;

		while (a != null && b != null) {
			if (a.i == b.i) {
				count++;
			} else {
				break;
			}

			a = a.next;
			b = b.next;
		}

		return count;
	}

//	------------------------------------------

	int max = Integer.MIN_VALUE;
	int min = Integer.MAX_VALUE;

	public void getMaxMin(Node node) {
		if (node == null) {
			System.out.println("List is blank");
			return;
		}

		while (node != null) {
			if (node.i > max) {
				max = node.i;
			}

			if (node.i < min) {
				min = node.i;
			}

			node = node.next;
		}
	}

	public Node deleteLargestElement(Node node) {
		if (node == null || node.next == null) {
			return null;
		}

		Node prevLargest, largest, head, prev;
		head = largest = node;
		prevLargest = null;
		prev = node;
		node = node.next;

		while (node != null) {
			if (node.i > largest.i) {
				prevLargest = prev;
				largest = node;
			}

			prev = node;
			node = node.next;
		}

		if (head == largest) {
			head = head.next;
		} else {
			prevLargest.next = largest.next;
		}

		return head;
	}

	public Node reverseFromGivenPositions(Node node, int p, int q) {
		if (node == null || node.next == null || p >= q || p < 1 || q < 1) {
			return node;
		}

		Node head = node;
		Node prev = null;

		for (int i = 1; node != null && i < p; i++) {
			prev = node;
			node = node.next;
		}

		if (node == null) {
			return head;
		}

		Node firstPartLastNode = prev;
		Node secondPartStartNode = node;
		Node next = null;

		for (int i = 0; node != null && i <= q - p; i++) {
			next = node.next;
			node.next = prev;
			prev = node;
			node = next;
		}

		if (p != 1) {
			firstPartLastNode.next = prev;
		}

		secondPartStartNode.next = node;

		return p == 1 ? prev : head;

	}

}