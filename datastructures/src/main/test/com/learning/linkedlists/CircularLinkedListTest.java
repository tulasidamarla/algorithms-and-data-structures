package com.learning.linkedlists;

import static org.junit.Assert.*;

import org.junit.Test;

public class CircularLinkedListTest {

	@Test
	public void testAddFirst() {
		CircularLinkedList<String> cll= new CircularLinkedList<>();
		cll.addFirst("Tulasi");
		cll.addFirst("Damarla");
		assertEquals( "[Damarla,Tulasi]", cll.toString());
		cll.addLast("Ram");
		assertEquals( "[Damarla,Tulasi,Ram]", cll.toString());
	}

}
