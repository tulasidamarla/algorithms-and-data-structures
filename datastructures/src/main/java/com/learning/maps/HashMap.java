package com.learning.maps;

public class HashMap<K,V> {
	Entry<K,V>[] table = null;
	private static final int INITIAL_CAPACITY = 16;
	
	
	@SuppressWarnings("unchecked")
	public HashMap() {
		table = new Entry[INITIAL_CAPACITY];
	}
	
	//Basic operations
	public void put(K key, V value){
		if(key == null || value == null){
			return;
		}
		
		if(table[getIndex(key)] == null){
			Entry<K, V> entry = new Entry<>(key, value);
			table[getIndex(key)] = entry;
		}else{
			Entry<K,V> head = table[getIndex(key)];
			
			if(head.key.equals(key)){
				head.value = value;
			}
		}
		
		
	}
	
	private int getIndex(K key){
		return key.hashCode()%16;
	}
	
	private static class Entry<K,V>{
		K key;
		V value;
		Entry<K,V> next;
		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}
		
		
	}

}
