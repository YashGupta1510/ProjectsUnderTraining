package com.nagarro.queue;

import java.util.Arrays;
import java.util.Scanner;

public class Functions {

	static Scanner ob = new Scanner(System.in);

	public static int rear = 0;
	public static int front = 0;

	public static void enqueue(int[] queue) {
		System.out.println("Enter value to Enqueue");
		int data = ob.nextInt();
		if (rear == -1) {
			queue[0] = data;
			rear = 0;
			front = 0;
		} else if (rear == queue.length - 1) {
			System.out.println("__OVERFLOW__");
		} else {
			queue[++rear] = data;
		}
	}

	public static void dequeue(int[] queue) {
		if (front == -1) {
			System.out.println("__UNDERFLOW__");
		} else if (rear == front) {
			System.out.println(queue[front]);
			front = -1;
			rear = -1;
		} else {
			System.out.println(queue[front++]);
		}
	}

	public static void peek(int[] queue) {
		if (rear == -1) {
			System.out.println("Empty queue");
		} else {
			System.out.println(queue[front]);
		}
	}

	public static void contains(int[] queue) {
		System.out.println("Enter value to find");
		int data = ob.nextInt();
		int f = 0;
		if (front == -1) {
			System.out.println("Empty queue");
		} else {
			for (int i = front; i <= rear; i++) {
				if (queue[i] == data) {
					f = 1;
					break;
				}
			}
		}
		if (f == 1) {
			System.out.println("Data found");
		} else {
			System.out.println("Data not found");

		}
	}

	public static void size() {
		if (front == -1) {
			System.out.println("queue Empty");
		} else {
			System.out.println(rear - front + 1);
		}
	}

	public static void center(int[] queue) {
		if (front == -1) {
			System.out.println("queue Empty");
		} else {
			int t = rear - front;
			System.out.println(queue[(t / 2) + front]);
		}
	}

	public static void reverse(int[] queue) {
		if (front == -1) {
			System.out.println("Empty queue");
		} else {
			int mid = (rear - front) / 2 ;
			for (int i = front; i <= mid + front; i++) {
				int t = queue[i];
				queue[i] = queue[rear - i];
				queue[rear - i] = t;
			}
		}
	}

	public static void traverse(int[] queue) {
		if (front == -1) {
			System.out.println("queue Empty");
		} else {
			for (int i = front; i < rear; i++) {
				System.out.print(queue[i] + " => ");
			}
			System.out.println(queue[rear]);
		}
	}

	public static void sort(int[] queue) {
		if (rear == -1) {
			System.out.println("queue Empty");
		} else {
			Arrays.sort(queue, front, rear + 1);
		}
	}

	public static IteratorQueue<Integer> iterator(int[] queue) {
		IteratorQueue<Integer> i = new IteratorQueue<Integer>(queue, rear, front);
		return i;
	}

}
