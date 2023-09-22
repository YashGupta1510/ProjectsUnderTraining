package com.nagarro.queue;

public class IteratorQueue<T> {
	int queue[]; 
	int front, rear;
	public IteratorQueue(int[] queue, int rear , int front){
		this.queue = queue;
	}
	
	 public boolean hasNext() {
         return (rear != -1) && (front <= rear);
     }

     public int next() {
         if(hasNext()){
         	return queue[front++]; 
         }
         return -1;
     }  
}
