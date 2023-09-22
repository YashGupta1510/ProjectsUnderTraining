package com.nagarro.linkedList;

import java.util.Scanner;

public class Functions {
	static Scanner ob = new Scanner(System.in);

	static Node insert(Node head) {
		/*
		 * This function is used to insert the newly created nodes into the linked list
		 */
		System.out.println("Enter value to insert");
		int data = ob.nextInt();

		Node node = new Node(data);

		if (head == null) {
			head = node;
		} else {
			Node curr = head;
			while (curr.next != null) {
				curr = curr.next;
			}
			curr.next = node;
		}

		return head;
	}

	static Node insertPos(Node head) {
		/**
		 * Inserts the data at the specific wanted position
		 */
		System.out.println("Enter value to insert");
		int data = ob.nextInt();
		System.out.println("Enter wanted poisition");
		int pos = ob.nextInt();
		if (pos < 1) {
			System.out.println("invalid input");
		} else if (pos == 1) {
			Node newNode = new Node(data);
			newNode.next = head;
			head = newNode;
		} else {
			Node curr = head;
			while (pos-- != 0) {
				if (pos == 1) {
					Node newNode = new Node(data);

					newNode.next = curr.next;

					curr.next = newNode;
					break;
				}
				curr = curr.next;
			}
			if (pos != 1)
				System.out.print("pos out of range");
		}
		return head;
	}

	static void traverse(Node head) {
		/**
		 * Prints all the linked nodes
		 * 
		 */
		Node curr = head;
		while (curr.next != null) {
			System.out.print(curr.data + " => ");
			curr = curr.next;
		}
		System.out.println(curr.data);
	}

	static Node delete(Node head) {
		/**
		 * Deletes nodes with the first occurance match
		 */
		System.out.println("Enter value to delete");
		int data = ob.nextInt();
		boolean f = false;
		if (head.data == data) {
			head = head.next;
			System.out.println("Deleted");
			f = true;
		} else {
			Node curr = head.next;
			Node prev = head;
			while (curr != null && !f) {
				if (curr.data == data) {
					prev.next = curr.next;
					System.out.println("Deleted");
					f = true;
				}
				curr = curr.next;
				prev = prev.next;
			}
		}
		if (!f) {
			System.out.println("The item does not exist");
		}
		return head;
	}

	static Node deletePos(Node head) {
		/**
		 * deletes the data at the specific wanted position
		 */

		System.out.println("Enter poisition");
		int pos = ob.nextInt();
		if (pos < 1) {
			System.out.println("invalid input");
		} else if (pos == 1) {
			head = head.next;
			System.out.println("Deleted");
		} else {
			Node curr = head.next;
			Node prev = head;
			while ((pos-- != 0) && (curr.next != null)) {
				curr = curr.next;
				prev = prev.next;
			}
			prev.next = curr.next;
			System.out.println("Deleted");
			if (pos != 1) {
				System.out.print("pos out of range");
			}

		}
		return head;
	}

	static void size(Node head) {
		int count = 0;
		Node curr = head;
		while (curr != null) {
			count++;
			curr = curr.next;
		}
		System.out.println(count);
	}

	static Node center(Node head) {
		Node midPrev = null;
		while (head != null && head.next != null) {
			midPrev = (midPrev == null) ? head : midPrev.next;
			head = head.next.next;
		}
		Node mid = midPrev.next;
		midPrev.next = null;
		return mid;
	}

	static Node reverse(Node head) {
		Node prev = null;
		Node current = head;
		Node next = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
		return head;

	}

	static Node sort(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node mid = center(head);
		Node left = sort(head);
		Node right = sort(mid);
		return merge(left, right);
	}

	static Node merge(Node left, Node right) {
		Node t = new Node();
		Node tail = t;
		while (left != null && right != null) {
			if (left.data < right.data) {
				tail.next = left;
				left = left.next;
				tail = tail.next;
			} else {
				tail.next = right;
				right = right.next;
				tail = tail.next;
			}
		}
		tail.next = (left != null) ? left : right;
		return t.next;
	}

	static IteratorLinkedList<Node> iterator(Node head) {
		IteratorLinkedList<Node> i = new IteratorLinkedList<Node>(head);
		return i;
	}

}
