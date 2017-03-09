package com.learning.linkedlists;

import static org.junit.Assert.*;

import org.junit.Test;

public class SingleLinkedListTest {

	@Test
	public void testSingleLinkedList() {
		SingleLinkedList<String> strings = new SingleLinkedList<String>();
		strings.addLast("Ram");
		strings.addFirst("Tulasi");
		strings.add("Damarla", 2);
		strings.add("Puppy", 0);
		assertSame(strings.get(1), "Tulasi");

		strings.removeFirst();
		strings.removeLast();
		strings.removeFirst();
		strings.removeLast();
		assertEquals(strings.size(), 0);
	}

}
