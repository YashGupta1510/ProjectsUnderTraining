package com.nagarro.stack;

import java.util.Arrays;
import java.util.Scanner;

public class Functions {

	static Scanner ob = new Scanner(System.in);

	public static int top = 0;
	public static int bottom = 0;

	public static void push(int[] stack) {
		System.out.println("Enter value to push");
		int data = ob.nextInt();
		if (top == -1) {
			stack[0] = data;
			top = 0;
			bottom = 0;
		} else if (top == stack.length - 1) {
			System.out.println("__OVERFLOW__");
		} else {
			stack[++top] = data;
		}
	}

	public static void pop(int[] stack) {
		if (bottom == -1) {
			System.out.println("__UNDERFLOW__");
		} else if (top == 0) {
			System.out.println(stack[top--]);
			bottom--;
		} else {
			System.out.println(stack[top--]);
		}
	}

	public static void peek(int[] stack) {
		if (bottom == -1) {
			System.out.println("Empty Stack");
		} else {
			System.out.println(stack[top]);
		}
	}

	public static void contains(int[] stack) {
		System.out.println("Enter value to find");
		int data = ob.nextInt();
		int f = 0;
		if (bottom == -1) {
			System.out.println("Empty Stack");
		} else {
			for (int i = bottom; i <= top; i++) {
				if (stack[i] == data) {
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
		if (top == -1) {
			System.out.println("Stack Empty");
		} else {
			System.out.println(top + 1);
		}
	}

	public static void center(int[] stack) {
		if (top == -1) {
			System.out.println("Stack Empty");
		} else {
			System.out.println(stack[top / 2]);
		}
	}

	public static void reverse(int[] stack) {
		if (top == -1) {
			System.out.println("Empty Stack");
		} else {
			for (int i = bottom; i <= top / 2; i++) {
				int t = stack[i];
				stack[i] = stack[top - i];
				stack[top - i] = t;
			}
		}
	}

	public static void traverse(int[] stack) {
		if (top == -1) {
			System.out.println("Stack Empty");
		} else {
			for (int i = bottom; i < top; i++) {
				System.out.print(stack[i] + " => ");
			}
			System.out.println(stack[top]);
		}
	}

	public static void sort(int[] stack) {
		if (top == -1) {
			System.out.println("Stack Empty");
		} else {
			Arrays.sort(stack, bottom, top + 1);
		}
	}

	public static IteratorStack<Integer> iterator(int[] stack) {
		IteratorStack<Integer> i = new IteratorStack<Integer>(stack, top, bottom);
		return i;
	}

}
