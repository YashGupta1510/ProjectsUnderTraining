package com.nagarro.classes;

import com.nagarro.hashMap.HashMap;
import com.nagarro.linkedList.LinkedList;
import com.nagarro.priorityQueue.PriorityQueue;
import com.nagarro.queue.Queue;
import com.nagarro.stack.Stack;

public class Main {

	public static void main(String[] args) {
		
		int choice = InputDsChoice.input();
		while (choice != 99) {
			switch (choice) {
			case 1:
				LinkedList.function();
				choice = InputDsChoice.input();
				break;
			case 2:
				Stack.function();
				choice = InputDsChoice.input();
				break;
			case 3:
				Queue.function();
				choice = InputDsChoice.input();
				break;
			case 4:
				PriorityQueue.function();
				choice = InputDsChoice.input();
				break;
			case 5:
				HashMap.function();
				choice = InputDsChoice.input();
				break;	
			default:
				System.out.println("--INVALID OPTION-- \n --TRY AGAIN--");
				choice = InputDsChoice.input();
				break;
			}
		}
	}

}
