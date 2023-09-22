package com.nagarro.priorityQueue;

import java.util.Scanner;

public class PriorityQueue {
	
	public static void function() {
		Scanner ob = new Scanner(System.in);
		int heap[] = new int[20];
		System.out.println("Enter first Element");
		int data = ob.nextInt();
		heap[0] = data;
		while (true) {
			System.out.println("press 1 to Enqueue");
			System.out.println("press 2 to Dequeue");
			System.out.println("press 3 to Peek");
			System.out.println("press 4 to Contains");
			System.out.println("press 5 to Size");
			System.out.println("press 6 to Center");
			System.out.println("press 7 to Reverse");
			System.out.println("press 8 to Iterator");
			System.out.println("press 0 to Traverse/Print");
			System.out.println("press 99 to Exit queue menu");
			int choice = ob.nextInt();
			if (choice == 99) {
				break;
			} else {
				switch (choice) {
				case 1:
					Functions.enqueue(heap);
					break;
				case 2:
					int t = Functions.dequeue(heap);
					System.out.println(t);
					break;
				case 3:
					Functions.peek(heap);
					break;
				case 4:
					Functions.contains(heap);
					break;
				case 5:
					Functions.size();
					break;
				case 6:
					Functions.center(heap);
					break;
				case 7:
					Functions.reverse(heap);
					break;
				case 8:
					Functions.iterator(heap);
					break;
				case 0:
					Functions.traverse(heap);
					break;
				default:
					System.out.println("--INVALID OPTION-- \n --TRY AGAIN--");
					break;
				
				}
			}
		}

	}
}
