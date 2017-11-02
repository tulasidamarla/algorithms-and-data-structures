package com.learning.linkedlists;

import java.util.HashMap;
import java.util.Map;

/**
 * @author damart1
 *
 * @param <T>
 */
public class SingleLinkedList<T> {

	private int length;
	private Node<T> head;

	public SingleLinkedList() {
		length = 0;
	}

	public T getFirst() {
		return head.data;
	}

	public T getLast() {
		return getLastNode().data;
	}

	private Node<T> getLastNode() {
		Node<T> tempNode = head;
		while (tempNode.next != null) {
			tempNode = tempNode.next;
		}
		return tempNode;
	}

	public T get(int index) {
		return getNodeAt(index).data;
	}

	private Node<T> getNodeAt(int index) {
		if (index < 0 || index > length) {
			return null; // throw an exception with illegal argument instead
		} else {
			int temp = 0;
			Node<T> tempNode = head;
			while (temp < index) {
				tempNode = tempNode.next;
				temp++;
			}
			return tempNode;
		}
	}

	public boolean addFirst(T data) {
		Node<T> node = new Node<T>(data);
		node.next = head;
		head = node;
		length++;
		return true;
	}

	public boolean addLast(T data) {
		Node<T> node = new Node<T>(data);
		if (length < 1) {
			head = node;
		} else {
			Node<T> current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = node;
		}
		length++;
		return true;
	}

	public boolean add(T data, int position) {
		int curPosition = 0;
		Node<T> current = head;
		Node<T> next = null;
		if (position == 0) {
			addFirst(data);
		} else if (position == length) {
			addLast(data);
		} else if (position < length && position > 0) {
			while (curPosition < position) {
				current = current.next;
				curPosition++;
			}
			next = current.next;
			Node<T> newNode = new Node<T>(data);
			current.next = newNode;
			newNode.next = next;
			length++;
		}

		return true;
	}

	public boolean removeFirst() {
		if (head != null) {
			Node<T> current = head;
			head = current.next;
			current = null;
			length--;
		}
		return true;
	}

	public boolean removeLast() {
		if (length > 0) {
			Node<T> temp = head.next;
			Node<T> current = head;
			if (temp == null) {
				head = null;
			} else {
				while (temp.next != null) {
					current = temp;
					temp = temp.next;
				}
				current.next = null;
			}
			length--;
		}
		return true;
	}

	// TODO
	public boolean remove(T data) {
		return true;
	}

	// TODO
	public boolean remove(int index) {
		return true;
	}

	// TODO
	public int indexOf(T data) {
		return -1;
	}

	public int size() {
		return length;
	}

	@Override
	public String toString() {
		Node<T> current = head;
		StringBuilder sb = new StringBuilder();

		sb.append("[");
		if (length > 0) {
			while (current.next != null) {
				sb.append(current.data + ",");
				current = current.next;
			}
			sb.append(current.data);
		}
		sb.append("]");
		return sb.toString();
	}

	private static class Node<T> {
		private T data;
		private Node<T> next;

		public Node(T data) {
			this.data = data;
		}

	}

	// Problems on Single Linked List

	// 1. Reverse a single linked list
	public void reverseLinkedList() {
		reverse(head);
		// reverseIterative();
	}

	/* Recursive approach */
	public void reverse(Node<T> current) {

		if (current.next == null) {
			head = current;
			return;
		}
		reverse(current.next);
		current.next.next = current;
		current.next = null;
	}

	private void reverseIterative() {
		Node<T> current = head;
		Node<T> prev = null;
		Node<T> next = null;

		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
	}

	// 2 swap pair of elements on a linked list
	public void swapList() {
		head = swap(head);
		// head = swapIterative(head);
	}

	/**
	 * Recursive approach
	 */
	private Node<T> swap(Node<T> head) {
		Node<T> temp = null;

		if (head == null) {
			return null;
		} else if (head.next == null) {
			// If no elements are odd, simply return last element
			return head;
		} else {

			temp = head.next;
			head.next = head.next.next;
			temp.next = head;
			head = temp;

			head.next.next = swap(head.next.next);

			return head;
		}

	}

	/**
	 * Iterative approach
	 */
	private Node<T> swapIterative(Node<T> node) {
		Node<T> temp = null;
		Node<T> head = null;

		while (node != null && node.next != null) {

			if (temp != null) {
				temp.next.next = node.next;
			}

			temp = node.next; // set second element to temp
			node.next = node.next.next; // set head next pointer to third
										// element
			temp.next = node; // set temp next pointer to head

			node = node.next; // set head to next of current head

			// This is to store head and return
			if (head == null) {
				head = temp;
			}

		}
		return head;
	}

	// 3. Reverse k elements in groups in a linked list given a k value

	public void reverseKnodesRecursive(int k) {
		head = reverseKnodesRecursive(head, k);
	}

	private Node<T> reverseKnodesRecursive(Node<T> head, int k) {
		int count = k;
		Node<T> previous = null;
		Node<T> current = head;
		Node<T> next = null;
		// reversing k elements
		while (current != null && count > 0) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
			count--;
		}

		// next points to k+1 th node
		if (next != null) {
			head.next = reverseKnodesRecursive(next, k);
		}
		
		// return the head node
		return previous;
	}

	public void reverseKNodesIterative(int k) {
		head = reverseKNodesIterative(head, k);
	}

	// 4. Find nth node from end of the linked list

	private Node<T> reverseKNodesIterative(Node<T> head, int k) {
		Node<T> current = head;
		Node<T> prevCurrent = head;
		Node<T> prevTail = null;
		while (current != null) {
			Node<T> previous = null;
			Node<T> next = null;
			int count = k;
			while (current != null && count > 0) {
				next = current.next;
				current.next = previous;
				previous = current;
				current = next;
				count--;
			}
			if (prevTail != null) {
				prevTail.next = previous;
			} else {
				head = previous;
			}
			prevTail = prevCurrent;
			prevCurrent = current;
		}
		return head;
	}

	// Using map
	/**
	 * Time complexity O(n) and Space complexity O(n)
	 * 
	 * @param n
	 * @return
	 */
	public T findFromEndUsingMap(int n) {
		Node<T> temp = head;
		Map<Integer, Node<T>> map = new HashMap<>();
		int index = 0;

		while (temp != null) {
			map.put(index++, temp);
			temp = temp.next;
		}
		return map.get(length - n).data;
	}

	// Using get and length methods
	/**
	 * Time complexity O(n) and Space complexity O(1)
	 * 
	 * @param n
	 * @return
	 */
	public T findFromEndUsingGet(int n) {
		return get(length - n);
	}

	// Using two pointers

	/**
	 * 
	 * Using get method Time complexity is O(n) but it takes two scans of the
	 * entire list. One scan for getting the length and other for get() method.
	 * 
	 * Time complexity O(n) and Space complexity O(1)
	 * 
	 * @param n
	 * @return
	 */
	public T findFromEnd(int n) {
		Node<T> temp1 = head;
		Node<T> temp2 = head;
		int counter = 0;

		while (temp1 != null) {
			temp1 = temp1.next;
			counter++;
			if (counter > n) {
				temp2 = temp2.next;
			}
		}
		return temp2.data;
	}

	// Using Recursion of the above solution
	public T findFromEndUsingRecursion(int n) {
		return findFromEndRecursion(head, n);
	}

	private int counter = 0;
	private T data;

	private T findFromEndRecursion(Node<T> head, int n) {

		if (head != null) {
			findFromEndRecursion(head.next, n);
			counter++;
			if (counter == n) {
				data = head.data;
			}
		}
		return data;
	}

	/**
	 * Problem 5: Find out if a linked list has a cycle.
	 * 
	 * Using Floyd cycle technique.
	 * 
	 * It uses two pointers(slow and fast) moving at different speeds to walk
	 * the linked list. The only way fast pointer meets slow pointer at some
	 * location is if list circular.
	 * 
	 * Time complexity is O(n).
	 */
	public boolean hasLoop() {
		Node<T> fastPointer = head;
		Node<T> slowPointer = head;
		boolean hasCycle = false;
		while (fastPointer != null && fastPointer.next != null) {
			fastPointer = fastPointer.next.next;
			slowPointer = slowPointer.next;
			if (fastPointer == slowPointer) {
				hasCycle = true;
				break;
			}
		}
		return hasCycle;
	}

	public void createLoopAt(int position) {
		Node<T> lastNode = getLastNode();
		Node<T> nodeAtPosition = getNodeAt(position);
		lastNode.next = nodeAtPosition;
	}

	public int lengthOfLoop() {
		Node<T> fastPointer = head;
		Node<T> slowPointer = head;
		boolean hasCycle = false;
		while (fastPointer != null && fastPointer.next != null) {
			fastPointer = fastPointer.next.next;
			slowPointer = slowPointer.next;
			if (fastPointer == slowPointer) {
				hasCycle = true;
				break;
			}
		}
		int length = 0;
		if (hasCycle) {
			do {
				slowPointer = slowPointer.next;
				length++;
			} while (slowPointer != fastPointer);
		}
		return length;
	}

	/**
	 * Lets say m is length from head to loop start, l is length of loop k is
	 * the length from start of loop to where the pointers meet Total distance
	 * travelled by slowpointer ds= m + p*l + k (where p is an integer) Total
	 * distance travelled by fastpointer df = m + q*l + k (where q is an integer
	 * greater than p)
	 * 
	 * As fast pointer travelled double the speed of slow pointer, m + q*l + k =
	 * 2(m+p*l+k) m + k = (q-2p)*l (It means that m + k is multiple of length of
	 * the loop)
	 *
	 * Now if we start slow pointer from head, to reach the start of the loop it
	 * needs m steps. Meanwhile, fast pointer is at a distance of k from start
	 * of the loop, will also move m steps. i.e. k+m(multiple length of the loop
	 * as defined above) steps from the start of the loop.
	 * 
	 * so, by the time slow pointer reaches the start of the loop, fast pointer
	 * also reaches the start of the loop no matter how many times it loops.
	 * 
	 */
	public T getLoopStart() {
		Node<T> fastPointer = head;
		Node<T> slowPointer = head;
		boolean hasCycle = false;
		while (fastPointer != null && fastPointer.next != null) {
			fastPointer = fastPointer.next.next;
			slowPointer = slowPointer.next;
			if (fastPointer == slowPointer) {
				hasCycle = true;
				break;
			}
		}
		if (hasCycle) {
			slowPointer = head;
			while (slowPointer != fastPointer) {
				slowPointer = slowPointer.next;
				fastPointer = fastPointer.next;
			}
		}
		return fastPointer.data;
	}

	/*public int lengthOfTheLoop() {
		Node<T> fastPointer = head;
		Node<T> slowPointer = head;
		boolean hasCycle = false;
		while (fastPointer != null && fastPointer.next != null) {
			fastPointer = fastPointer.next.next;
			slowPointer = slowPointer.next;
			if (fastPointer == slowPointer) {
				hasCycle = true;
				break;
			}
		}
		if (hasCycle) {
			slowPointer = head;
			while (slowPointer != fastPointer) {
				slowPointer = slowPointer.next;
				fastPointer = fastPointer.next;
			}
		}
		int counter = 0;
		do {
			counter++;
			slowPointer = slowPointer.next;
		} while (slowPointer != fastPointer);

		return counter;
	}*/

	public void evenAndOddNodesTogether() {
		head = evenAndOddNodesTogether(head);
	}

	private Node<T> evenAndOddNodesTogether(Node<T> head) {

		if (head != null) {
			Node<T> odd = head;
			Node<T> even = head.next;
			Node<T> evenFirst = even;

			while (true) {
				if(even == null || even.next == null){
					odd.next = evenFirst;
					break;
				}
				odd.next = even.next;
				odd = even.next;
				if(odd.next == null){
					even.next = null;
					odd.next = evenFirst;
					break;
				}
				even.next = odd.next;
				even = odd.next;
			}
		}
		return head;
	}

}
