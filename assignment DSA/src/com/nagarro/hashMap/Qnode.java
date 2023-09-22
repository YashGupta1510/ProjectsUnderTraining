package com.nagarro.hashMap;


public class Qnode {
	public Qnode next;
	public int value;
	public int key;
	public int hash;
	
	public Qnode(int key, int value,int hash) {
		this.key = key;
		this.value = value;
		this.next = null;
		this.hash = hash;
	}
	
	public Qnode() {
		
	}
}
