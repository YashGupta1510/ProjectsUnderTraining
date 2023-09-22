package com.nagarro.hashMap;

public class IteratorHashMap<T> {
	
	static Qnode map[];
	static int size = Functions.size();
	static int set[] = new int[size];
	
	public IteratorHashMap(Qnode[] map){
		IteratorHashMap.map = map;
	}
	
	static int c = 0;
	static int currIndex = 0 ;
	public static void EntrySet() {
		for(int i = 0 ; i < map.length ; i++) {
			if(map[i] != null) {
				Qnode t = map[i];
				while(t != null){
					set[c++] = t.key;
					t = t.next;
				}
			}
		}
	}

	
	public boolean hasNext() {
        return currIndex < size;
    }

    public Qnode next() {
        if(hasNext()){
        	int hash = Functions.hashcode(set[currIndex]);
    		int index = hash & (size - 1);
    		Qnode t = map[index];
   			while(t != null){
    			if(t.hash == hash) {
    				return t;
    			}
    			 t = t.next;
    		}
    	}
        return null;
    }
}