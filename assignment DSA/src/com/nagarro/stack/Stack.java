package com.nagarro.stack;

import java.util.Scanner;

public class Stack {
	public static void function() {
		Scanner ob = new Scanner(System.in);
		int stack[] = new int[20];
		System.out.println("Enter first Element");
		int data = ob.nextInt();
		stack[0] = data;
		while (true) {
			System.out.println("press 1 to Push");
			System.out.println("press 2 to Pop");
			System.out.println("press 3 to Peek");
			System.out.println("press 4 to Contains");
			System.out.println("press 5 to Size");
			System.out.println("press 6 to Center");
			System.out.println("press 7 to Sort");
			System.out.println("press 8 to Reverse");
			System.out.println("press 9 to Iterator");
			System.out.println("press 0 to Traverse/Print");
			System.out.println("press 99 to Exit Stack menu");
			int choice = ob.nextInt();
			if (choice == 99) {
				break;
			} else {
				switch (choice) {
				case 1:
					Functions.push(stack);
					break;
				case 2:
					Functions.pop(stack);
					break;
				case 3:
					Functions.peek(stack);
					break;
				case 4:
					Functions.contains(stack);
					break;
				case 5:
					Functions.size();
					break;
				case 6:
					Functions.center(stack);
					break;
				case 7:
					Functions.sort(stack);
					break;
				case 8:
					Functions.reverse(stack);
					break;
				case 9:
					Functions.iterator(stack);
					break;
				case 0:
					Functions.traverse(stack);
					break;
				default:
					System.out.println("--INVALID OPTION-- \n --TRY AGAIN--");
					break;
				
				}
			}
		}

	}
}
