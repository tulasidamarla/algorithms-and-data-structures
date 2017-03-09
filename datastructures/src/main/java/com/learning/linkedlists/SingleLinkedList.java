package com.learning.linkedlists;


public class SingleLinkedList<T> {

	private int length;
	private SLLNode<T> head;

	public SingleLinkedList() {
		length = 0;
	}

	public SLLNode<T> getFirst() {
		return head;
	}
	
	public T getLast() {
		SLLNode<T> tempNode = head;
		while(tempNode.next != null){
			tempNode = tempNode.next;
		}
		return tempNode.data;
	}

	public T get(int index) {
		if(index < 0 || index > length){
			return null; // throw an exception with illegal argument instead
		}else{
			int temp = 0;
			SLLNode<T> tempNode = head;
			while(temp == index){
				tempNode=tempNode.next;
				temp++;
			}
			return tempNode.next.data;
		}
		
	}

	public boolean addFirst(T data) {
		SLLNode<T> node = new SLLNode<T>(data);
		node.next = head;
		head = node;
		length++;
		return true;
	}

	public boolean addLast(T data) {
		SLLNode<T> node = new SLLNode<T>(data);
		if (length < 1) {
			head = node;
		} else {
			SLLNode<T> current = head;
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
		SLLNode<T> current = head;
		SLLNode<T> next = null;
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
			SLLNode<T> newNode = new SLLNode<T>(data);
			current.next=newNode;
			newNode.next=next;
			length++;
		}

		return true;
	}

	public boolean removeFirst() {
		if (head != null) {
			SLLNode<T> current = head;
			head = current.next;
			current = null;
			length--;
		}
		return true;
	}

	public boolean removeLast() {
		if (length > 0) {
			SLLNode<T> temp = head.next;
			SLLNode<T> current = head;
			if (temp == null) {
				head = null;
			} else {
				while (temp.next != null) {
					current = temp;
					temp = temp.next;
				}
				current.next=null;
			}
			length--;
		}
		return true;
	}
	
	//TODO
	public boolean remove(T data) {
		return true;
	}
	//TODO
	public boolean remove(int index) {
		return true;
	}
	//TODO
	public int indexOf(T data) {
		return -1;
	}
	
	public int size(){
		return length;
	}

	@Override
	public String toString() {
		SLLNode<T> current = head;
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
	
	class SLLNode<T> {
		private T data;
		private SLLNode<T> next;

		public SLLNode(T data) {
			this.data = data;
		}

	}
	
	//Problems on Single Linked List
	
	public void swapList(){
		//head=swap(head);
		head=swapIterative(head);
	}
	
	private SLLNode<T> swap(SLLNode<T> head){
		SLLNode<T> temp = null;
		
		if(head == null || head.next == null){
			return null;
		}else{
			temp = head.next;
			head.next = head.next.next;
			temp.next = head;
			head = temp;
			head.next.next = swap(head.next.next);
			return head;
		}
		
	}
	
	private SLLNode<T> swapIterative(SLLNode<T> head){
		SLLNode<T> temp1 = null;
		SLLNode<T> newHead = null;
		while(head != null && head.next != null){
			if(temp1 != null){
				temp1.next.next = head.next;
			}
			
			temp1 = head.next; // set second element to temp
			head.next = head.next.next; // set head next pointer to third element 
			temp1.next = head; // set temp next pointer to head 
			
			head = head.next; // set head to next of current head
			
			//This is to store head and return
			if(newHead == null){
				newHead = temp1;
			}
			
		}
		return newHead;
	}
	
	
}


