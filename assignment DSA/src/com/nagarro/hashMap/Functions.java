package com.nagarro.hashMap;

import java.util.Scanner;

public class Functions {

	static Scanner ob = new Scanner(System.in);
	
	static final int size = 20;
	static Qnode map[] = new Qnode[size];
	
	public static int hashcode(int key) {
		int hash = 5;
		hash += 13 * key;
		return hash;
	}

	public static void put(int key, int value) {
		int hash = hashcode(key);
		int index = hash & (size - 1);
		Qnode t = map[index];
		if(t == null) {
			map[index] = new Qnode(key, value, hash);
		}else{ 
			Qnode prev = t;
			while(t != null) {
				if(t.hash == hash) {
					t.value = value;
					return;
				}
				prev = t;
				t = t.next;
			}
			prev.next = new Qnode(key, value, hash);
		}
	}

	public static void delete(int key) {
		int hash = hashcode(key);
		int index = hash & (size - 1);
		Qnode t = map[index];
		boolean f = false;
		if(t == null) {
			f = false;
		}else if (t.next == null) {
			f = true;
			map[index] = null;
		}else{
			Qnode prev = t;
			while(t != null){
				if(t.hash == hash) {
					f = true;
					prev.next = t.next;
					break;
				}
				 prev = t;
				 t = t.next;
			}
		}
		if(f) {
			System.out.println("DELETED");
		}else {
			System.out.println("NOT EXISTS");
		}
	}
	
	public static void contains(int key) {
		int hash = hashcode(key);
		int index = hash & (size - 1);
		Qnode t = map[index];
		boolean f = false;
		if(t == null) {
			f = false;
		}else{
			while(t != null){
				if(t.hash == hash) {
					f = true;
					break;
				}
				 t = t.next;
			}
		}
		if(f) {
			System.out.println("EXISTS | Value : " + t.value);
		}else {
			System.out.println("NOT EXISTS");
		}
	}

	
	public static void getValue(int key) {
		int hash = hashcode(key);
		int index = hash & (size - 1);
		Qnode t = map[index];
		boolean f = false;
		if(t == null) {
			f = false;
		}else{
			while(t != null){
				if(t.hash == hash) {
					f = true;
					break;
				}
				 t = t.next;
			}
		}
		if(f) {
			System.out.println("Value : " + t.value);
		}else {
			System.out.println("NOT EXISTS");
		}
	}

	
	public static int size() {
		int counter = 0;
		for(int i = 0 ; i < size ; i++) {
			if(map[i] != null) {
				Qnode t = map[i];
				while(t != null){
					counter++;
					t = t.next;
				}
			}
		}
		return counter;
	}


	public static IteratorHashMap<Qnode> iterator() {
		IteratorHashMap<Qnode> i = new IteratorHashMap<Qnode>(map);
		return i;
	}
	
	public static void traverse() {
		for(int i = 0 ; i < size ; i++) {
			if(map[i] != null) {
				Qnode t = map[i];
				while(t != null){
					System.out.println("Key : " + t.key + " | Value : " + t.value);
					t = t.next;
				}
			}
		}
	}

	
	
}
