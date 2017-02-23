package com.learning.linkedlists;

public class CircularLinkedList<T> {
	private CLLNode<T> tail;
	private int length;
	public CircularLinkedList() {
		
	}
	
	/**
	 * Add to First is to create new Head with given data.
	 * */
	public boolean addFirst(T data){
		CLLNode<T> newNode = new CLLNode<T>(data);
		if(tail == null){
			tail = newNode;
			tail.setNext(tail);
		}else{
			//point newNode next element as tail's next and point tail's next element as newNode 
			newNode.setNext(tail.getNext());
			tail.setNext(newNode);
		}
		length++;
		return true;
	}
	
	
	public boolean addLast(T data){
		addFirst(data);
		tail=tail.getNext();
		return true;
	}
	
	@Override
	public String toString() {
		CLLNode<T> temp = tail;
		StringBuilder sb = new StringBuilder();

		sb.append("[");

		if (tail != null) {
			temp = temp.getNext();
			while (temp != tail) {
				sb.append(temp.getData() + ",");
				temp = temp.getNext();
			}
			sb.append(temp.getData());
		}
		sb.append("]");
		return sb.toString();
	}
}

class CLLNode<T> {
	private T data;
	private CLLNode<T> next;

	public CLLNode(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public CLLNode<T> getNext() {
		return next;
	}

	public void setNext(CLLNode<T> next) {
		this.next = next;
	}



}
