package com.nagarro.stack;

public class IteratorStack<T> {
		
	int stack[]; 
	int top, bottom;
	public IteratorStack(int[] stack, int top , int bottom){
		this.stack = stack;
	}
	
	 public boolean hasNext() {
         return (top != -1) && (bottom <= top);
     }

     public int next() {
         if(hasNext()){
         	return stack[bottom++]; 
         }
         return -1;
     }     
}
