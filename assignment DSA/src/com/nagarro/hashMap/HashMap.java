package com.nagarro.hashMap;

import java.util.Scanner;

public class HashMap {
	public static void function() {
		Scanner ob = new Scanner(System.in);
		System.out.println("Enter Key");
		int key = ob.nextInt();
		System.out.println("Enter Value");
		int value = ob.nextInt();
		Functions.put(key,value);
		while (true) {
			System.out.println("press 1 to Insert");
			System.out.println("press 2 to Delete");
			System.out.println("press 3 to Contains");
			System.out.println("press 4 to Get Value by Key");
			System.out.println("press 5 to Size");
			System.out.println("press 6 to Iterator");
			System.out.println("press 0 to Traverse/Print");
			System.out.println("press 99 to Exit HashMap menu");
			int choice = ob.nextInt();
			if (choice == 99) {
				break;
			} else {
				switch (choice) {
				case 1:
					System.out.println("Enter Key");
					key = ob.nextInt();
					System.out.println("Enter Value");
					value = ob.nextInt();
					Functions.put(key, value);
					break;
				case 2:
					System.out.println("Enter Key");
					key = ob.nextInt();
					Functions.delete(key);
					break;
				case 3:
					System.out.println("Enter Key");
					key = ob.nextInt();
					Functions.contains(key);
					break;
				case 4:
					System.out.println("Enter Key");
					key = ob.nextInt();
					Functions.getValue(key);
					break;
				case 5:
					int s = Functions.size();
					System.out.println(s);
					break;
				case 6:
					Functions.iterator();
					break;
				case 0:
					Functions.traverse();
					break;
				default:
					System.out.println("--INVALID OPTION-- \n --TRY AGAIN--");
					break;
				}
			}
		}

	}

}
