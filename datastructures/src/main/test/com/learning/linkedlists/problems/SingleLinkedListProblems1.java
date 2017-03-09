package com.learning.linkedlists.problems;

import static org.junit.Assert.*;

import org.junit.Test;

import com.learning.linkedlists.SingleLinkedList;

public class SingleLinkedListProblems1 {

	/**
	 * This test swaps every two nodes from the beginning. If the input size is odd, then leave the last node as it is.
	 */
	@Test
	public void testSwapNodes() {
		SingleLinkedList<Integer> intList = new SingleLinkedList<Integer>();
		intList.addLast(5);
		intList.addLast(13);
		intList.addLast(15);
		intList.addLast(18);
		intList.addLast(20);
		intList.addLast(11);
		intList.addLast(6);
		intList.addLast(7);
		intList.swapList();
		assertEquals("[13,5,18,15,11,20,7,6]", intList.toString());
		
	}

}
