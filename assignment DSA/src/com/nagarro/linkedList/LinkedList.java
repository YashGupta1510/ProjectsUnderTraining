package com.nagarro.linkedList;

import java.util.Scanner;

public class LinkedList {

	public static void function() {
		Scanner ob = new Scanner(System.in);
		System.out.println("Enter first Element");
		int data = ob.nextInt();
		Node head = new Node(data);
		while (true) {
			System.out.println("press 1 to Insert");
			System.out.println("press 2 to Insert at position");
			System.out.println("press 3 to Delete");
			System.out.println("press 4 to Delete at position");
			System.out.println("press 5 to Center");
			System.out.println("press 6 to Sort");
			System.out.println("press 7 to Reverse");
			System.out.println("press 8 to Size");
			System.out.println("press 9 to Iterator");
			System.out.println("press 0 to Traverse/Print");
			System.out.println("press 99 to Exit Linked List menu");
			int choice = ob.nextInt();
			if (choice == 99) {
				break;
			} else {
				switch (choice) {
				case 1:
					head = Functions.insert(head);
					break;
				case 2:
					head = Functions.insertPos(head);
					break;
				case 3:
					head = Functions.delete(head);
					break;
				case 4:
					head = Functions.deletePos(head);
					break;
				case 5:
					Node t = Functions.center(head);
					System.out.println(t.data);
					break;
				case 6:
					head = Functions.sort(head);
					break;
				case 7:
					head = Functions.reverse(head);
					break;
				case 8:
					Functions.size(head);
					break;
				case 9:
					Functions.iterator(head);
					break;
				case 0:
					Functions.traverse(head);
					break;
				default:
					System.out.println("--INVALID OPTION-- \n --TRY AGAIN--");
					break;
				
				}
			}
		}

	}

}
