package com.learning.linkedlists;

public class SingleLinkedListDemo {

	public static void main(String[] args) {
		SingleLinkedList<String> strings = new SingleLinkedList<String>();
		strings.addLast("Ram");
		strings.addFirst("Tulasi");
		strings.add("Damarla", 2);
		strings.add("Puppy", 0);

		System.out.println(strings);
		strings.removeFirst();
		strings.removeLast();
		strings.removeFirst();
		strings.removeLast();
		System.out.println(strings);
	}

}

class SingleLinkedList<T> {

	private int length;
	private SLLNode<T> head;

	public SingleLinkedList() {
		length = 0;
	}

	public SLLNode<T> getFirst() {
		return head;
	}
	//TODO
	public SLLNode<T> getLast() {
		return null;
	}
	//TODO
	public SLLNode<T> get(int index) {
		return null;
	}

	public boolean addFirst(T data) {
		SLLNode<T> node = new SLLNode<T>(data);
		node.setNext(head);
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
			while (current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(node);
			length++;
		}
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
				current = current.getNext();
				curPosition++;
			}
			next = current.getNext();
			SLLNode<T> newNode = new SLLNode<T>(data);
			current.setNext(newNode);
			newNode.setNext(next);
			length++;
		}

		return true;
	}

	public boolean removeFirst() {
		if (head != null) {
			SLLNode<T> current = head;
			head = current.getNext();
			current = null;
			length--;
		}
		return true;
	}

	public boolean removeLast() {
		if (length > 0) {
			SLLNode<T> next = head.getNext();
			SLLNode<T> current = head;
			if (next == null) {
				head = null;
			} else {
				while (next.getNext() != null) {
					current = next;
					next = next.getNext();
				}
				current.setNext(null);
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

	@Override
	public String toString() {
		SLLNode<T> current = head;
		StringBuilder sb = new StringBuilder();

		sb.append("[");
		if (length > 0) {
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

class SLLNode<T> {
	private T data;
	private SLLNode<T> next;

	public SLLNode(T data) {
		this.data = data;
	}

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

}
