package com.nagarro.priorityQueue;

import java.util.Scanner;

public class Functions {

	static Scanner ob = new Scanner(System.in);

	static int size = 0;

	static int parent(int i) {
		return (i - 1) / 2;
	}

	static void shiftUp(int[] heap, int i) {
		while ((i > 0) && (heap[parent(i)] < heap[i])) {
			swap(heap, parent(i), i);
			i = parent(i);
		}
	}

	static void shiftDown(int[] heap, int i) {

		int maxIndex = i;
		int left = (2 * i) + 1;
		if ((left <= size) && (heap[left] > heap[maxIndex])) {
			maxIndex = left;
		}
		int right = ((2 * i) + 2);

		if (right <= size && heap[right] > heap[maxIndex]) {
			maxIndex = right;
		}
		if (i != maxIndex) {
			swap(heap, i, maxIndex);
			shiftDown(heap, maxIndex);
		}
	}

	static void swap(int[] heap, int i, int j) {
		
		int temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
		
	}

	public static void enqueue(int[] heap) {

		System.out.println("Enter value to Enqueue");
		int data = ob.nextInt();

		heap[++size] = data;

		shiftUp(heap, size);
	}

	public static int dequeue(int[] heap) {

		if( size < 0 ) {
			System.out.println("Empty PQ");
			return -1;
		}else {
		int t = heap[0];

		heap[0] = heap[size--];

		shiftDown(heap, 0);
		return t;
		}
		 
	}

	public static void peek(int[] heap) {
		
		if (size < 0) {
			System.out.println("Empty PQ");
		} else {
			System.out.println(heap[0]);
		}
		
	}

	public static void size() {
		System.out.println(size+1);
	}

	public static void center(int[] heap) {
		if (size == -1) {
			System.out.println("Empty PQ");
		} else {
			System.out.println(heap[size / 2]);
		}
	}

	public static void reverse(int[] heap) {
		if (size == -1) {
			System.out.println("Empty PQ");
		} else {
			int mid = (size + 1) / 2;
			for (int i = 0; i < mid; i++) {
				int t = heap[i];
				heap[i] = heap[size - i];
				heap[size - i] = t;
			}
		}
	}

	public static void traverse(int[] heap) {
		if (size == -1) {
			System.out.println("queue Empty");
		} else {
			for (int i = 0; i < size; i++) {
				System.out.print(heap[i] + " => ");
			}
			System.out.println(heap[size]);
		}
	}

	public static IteratorPriorityQueue<Integer> iterator(int[] heap) {
		IteratorPriorityQueue<Integer> i = new IteratorPriorityQueue<Integer>(heap, size);
		return i;
	}
	
	
	public static void contains(int[] heap) {
		System.out.println("Enter value to find");
		int data = ob.nextInt();
		int f = 0;
		if (size == -1) {
			System.out.println("Empty queue");
		} else {
			for (int i = 0; i <= size; i++) {
				if (heap[i] == data) {
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
	
}
