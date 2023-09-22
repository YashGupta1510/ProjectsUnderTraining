package com.nagarro.linkedList;

public class IteratorLinkedList<T> {
	Node current;

	public IteratorLinkedList(Node head) {
		current = head;
	}

	public boolean hasNext() {
		return current != null;
	}

	public Node next() {
		if (hasNext()) {
			Node t = current;
			current = current.next;
			return t;
		}
		return null;
	}
}
