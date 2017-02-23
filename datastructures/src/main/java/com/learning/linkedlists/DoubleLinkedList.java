package com.learning.linkedlists;


/**
 * Doubly Linked list is also call two way linked list. Given a node we can
 * navigate in both directions. A single linked list node cannot be removed
 * unless we have a pointer to predecessor. In doubly linked list we can remove
 * with out previous node reference because it has a pointer which points to
 * previous node.
 * 
 * The prmary disadvantage of DLL is it requires more space and the second is
 * insertion and deletion takes more time because of more pointer operations.
 */
public class DoubleLinkedList<T> {
	private int length;
	private DLLNode<T> head;

	public DoubleLinkedList() {
		length = 0;
	}

	public boolean add(T data) {
		addLast(data);
		return true;
	}

	public boolean addFirst(T data) {
		DLLNode<T> node = null;
		node = new DLLNode<T>(data, null, head);
		head = node;
		length++;
		return true;
	}

	public boolean addLast(T data) {
		DLLNode<T> node = new DLLNode<T>(data);
		if(length==0){
			addFirst(data);
		}else{
			DLLNode<T> current = head;
			if(current.getNext() != null){
				current=current.getNext();
			}
			current.setNext(node);
			node.setPrevious(current);
		}
		length++;
		return true;
	}

	public boolean add(T data, int index) {
		if(length == 0 || index == 0){
			addFirst(data);
		}else if (length == index){
			addLast(data);
		}else{
			DLLNode<T> node = new DLLNode<T>(data);
			int count = 0;
			DLLNode<T> next = head;
			DLLNode<T> previous = head;
			
			while(count < index){
				previous = next;
				next = next.getNext();
				count++;
			}
			
			previous.setNext(node);
			next.setPrevious(node);
			
			node.setNext(next);
			node.setPrevious(previous);
			length++;
			
		}
		return true;
	}

	// TODO
	public T getFirst() {
		return null;
	}

	// TODO
	public T getLast() {
		return null;
	}

	// TODO
	public boolean removeFirst() {
		return true;
	}

	// TODO
	public boolean removeLast() {
		return true;
	}

	@Override
	public String toString() {
		DLLNode<T> current = head;
		StringBuilder sb = new StringBuilder();

		sb.append("[");

		if (head != null) {
			while (current.getNext() != null) {
				sb.append(current.getData() + ",");
				current = current.getNext();
			}
			sb.append(current.getData());
		}
		sb.append("]");
		return sb.toString();
	}

}

class DLLNode<T> {

	private T data;
	private DLLNode<T> previous;
	private DLLNode<T> next;

	public DLLNode(T data) {
		this.data = data;
	}

	public DLLNode(T data, DLLNode<T> previous, DLLNode<T> next) {
		this.data = data;
		this.previous = previous;
		this.next = next;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public DLLNode<T> getPrevious() {
		return previous;
	}

	public void setPrevious(DLLNode<T> previous) {
		this.previous = previous;
	}

	public DLLNode<T> getNext() {
		return next;
	}

	public void setNext(DLLNode<T> next) {
		this.next = next;
	}

}