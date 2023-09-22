package com.nagarro.priorityQueue;

public class IteratorPriorityQueue<T> {
	int heap[]; 
	int size;
	int curr = 0;
	public IteratorPriorityQueue(int[] heap, int  size){
		this.heap = heap;
		this.size = size;
	}

	 public boolean hasNext() {
         return (size != -1) && (curr < size);
     }

     public int next() {
         if(hasNext()){
         	return Functions.dequeue(heap); 
         }
         return -1;
     }  
     
}