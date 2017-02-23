package com.learning.linkedlists;

import static org.junit.Assert.*;

import org.junit.Test;

public class DoubleLinkedListTest {
	
	@Test
	public void testAddFirst() {
		DoubleLinkedList<String> list=new DoubleLinkedList<>();
		list.addFirst("Damarla");
		assertEquals(list.toString(),"[Damarla]");
		list.addFirst("Ram");
		list.addFirst("Tulasi");
		assertEquals(list.toString(),"[Tulasi,Ram,Damarla]");
	}
	
	@Test
	public void testAdd() {
		DoubleLinkedList<String> list=new DoubleLinkedList<>();
		list.add("Damarla");
		assertEquals(list.toString(),"[Damarla]");
		list.add("Ram");
		list.add("Tulasi");
		assertEquals(list.toString(),"[Damarla,Ram,Tulasi]");
	}
	
	@Test
	public void testAddLast() {
		DoubleLinkedList<String> list=new DoubleLinkedList<>();
		list.addLast("Damarla");
		assertEquals(list.toString(),"[Damarla]");
		list.addLast("Ram");
		list.addLast("Tulasi");
		assertEquals(list.toString(),"[Damarla,Ram,Tulasi]");
	}
	
	@Test
	public void testAddAtIndex() {
		DoubleLinkedList<String> list=new DoubleLinkedList<>();
		list.add("Damarla",1);
		assertEquals(list.toString(),"[Damarla]");
		list.add("Ram",0);
		assertEquals(list.toString(),"[Ram,Damarla]");
		list.add("Tulasi",1);
		assertEquals(list.toString(),"[Ram,Tulasi,Damarla]");
	}

}
