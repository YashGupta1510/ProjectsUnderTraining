package com.nagarro.queue;

import java.util.Scanner;

public class Queue {
	public static void function() {
		Scanner ob = new Scanner(System.in);
		int queue[] = new int[20];
		System.out.println("Enter first Element");
		int data = ob.nextInt();
		queue[0] = data;
		while (true) {
			System.out.println("press 1 to Enqueue");
			System.out.println("press 2 to Dequeue");
			System.out.println("press 3 to Peek");
			System.out.println("press 4 to Contains");
			System.out.println("press 5 to Size");
			System.out.println("press 6 to Center");
			System.out.println("press 7 to Sort");
			System.out.println("press 8 to Reverse");
			System.out.println("press 9 to Iterator");
			System.out.println("press 0 to Traverse/Print");
			System.out.println("press 99 to Exit queue menu");
			int choice = ob.nextInt();
			if (choice == 99) {
				break;
			} else {
				switch (choice) {
				case 1:
					Functions.enqueue(queue);
					break;
				case 2:
					Functions.dequeue(queue);
					break;
				case 3:
					Functions.peek(queue);
					break;
				case 4:
					Functions.contains(queue);
					break;
				case 5:
					Functions.size();
					break;
				case 6:
					Functions.center(queue);
					break;
				case 7:
					Functions.sort(queue);
					break;
				case 8:
					Functions.reverse(queue);
					break;
				case 9:
					Functions.iterator(queue);
					break;
				case 0:
					Functions.traverse(queue);
					break;
				default:
					System.out.println("--INVALID OPTION-- \n --TRY AGAIN--");
					break;
				
				}
			}
		}

	}

}
