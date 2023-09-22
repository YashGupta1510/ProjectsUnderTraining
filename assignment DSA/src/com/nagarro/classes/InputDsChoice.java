package com.nagarro.classes;

import java.util.Scanner;

public class InputDsChoice {

	static int input() {
		Scanner ob = new Scanner(System.in);
		System.out.println("press 1 to Linked List");
		System.out.println("press 2 to Stack");
		System.out.println("press 3 to Queue");
		System.out.println("press 4 to Priority Queue");
		System.out.println("press 5 to HashMap");
		System.out.println("press 99 to EXIT");
		int choice = ob.nextInt();
		return choice;
	}
}
