package com.learning.linkedlists;

public class SingleLinkedListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class SLLNode<T> {
	private T data;
	private SLLNode<T> next;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public SLLNode<T> getNext() {
		return next;
	}

	public void setNext(SLLNode<T> next) {
		this.next = next;
	}
	
	/** 
	 * Time complexity O(n) and Space complexity is O(1).
	 * */
	public int listLength(SLLNode<T> headNode){
		int length=0;
		SLLNode<T> currentNode = headNode;
		while(currentNode.next != null){
			length++;
			System.out.print(currentNode.data+"\t");
			currentNode=currentNode.next;
		}
		System.out.println();
		return length;
	}
	
	/** 
	 * Time complexity O(n) and Space complexity is O(1).
	 * */
	public SLLNode<T> insert(SLLNode<T> headNode, SLLNode<T> nodeToInsert, int position){
		if(headNode == null){
			return nodeToInsert;
		}
		int size=listLength(headNode);
		if(position >= size || position < 0){
			throw new RuntimeException("Invalid position index " + position);
		}
		if(position == 0){
			nodeToInsert.next = headNode;
			return nodeToInsert;
		}else{
			SLLNode<T> currentNode=headNode;
			int count=0;
			while(count < position){
				currentNode = currentNode.next;
				count++;
			}
			SLLNode<T> nextNode= currentNode.next;
			currentNode.next = nodeToInsert;
			nodeToInsert.next = nextNode;
		}
		return headNode;
	}

	/** 
	 * Time complexity O(n) and Space complexity is O(1).
	 * */
	public SLLNode<T> delete(SLLNode<T> headNode, SLLNode<T> nodeToDelete, int position){

		int size=listLength(headNode);
		if(position >= size || position < 0){
			throw new RuntimeException("Invalid position index " + position);
		}
		if(position == 0){
			nodeToDelete.next = headNode;
			return nodeToDelete;
		}else{
			SLLNode<T> currentNode=headNode;
			int count=0;
			while(count < position){
				currentNode = currentNode.next;
				count++;
			}
			SLLNode<T> nextNode= currentNode.next;
			currentNode.next = nextNode.next;
			nextNode = null;
		}
		return headNode;
	}
}
