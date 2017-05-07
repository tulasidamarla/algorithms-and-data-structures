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
		SingleLinkedList<Integer> intList=getList();
		intList.addLast(9);
		intList.swapList();
		assertEquals("[2,1,4,3,6,5,8,7,9]", intList.toString());
		
	}
	
	/**
	 * This test reverses all nodes of a linked list
	 */
	@Test
	public void testReverseNodes() {
		SingleLinkedList<Integer> intList=getList();
		intList.reverseLinkedList();
		assertEquals("[8,7,6,5,4,3,2,1]", intList.toString());
	}
	
	/**
	 * This test reverses k nodes of a linked list given k
	 */
	@Test
	public void testReverseKNodes() {
		SingleLinkedList<Integer> intList=getList();
		intList.addLast(9);
		intList.addLast(10);
		intList.reverseKnodesRecursive(3);
		assertEquals("[3,2,1,6,5,4,9,8,7,10]", intList.toString());
		intList.reverseKnodesRecursive(3);
		intList.reverseKnodesRecursive(4);
		assertEquals("[4,3,2,1,8,7,6,5,10,9]", intList.toString());
		intList.reverseKnodesRecursive(4);
		intList.reverseKnodesRecursive(2);
		assertEquals("[2,1,4,3,6,5,8,7,10,9]", intList.toString());
		intList.reverseKnodesRecursive(2);
		intList.reverseKNodesIterative(3);
		assertEquals("[3,2,1,6,5,4,9,8,7,10]", intList.toString());
		System.out.println(intList);
	}
	
	
	@Test
	public void testEvenAndOddNodesTogether(){
		SingleLinkedList<Integer> intList=getList();
		intList.addLast(9);
		intList.evenAndOddNodesTogether();
		assertEquals("[1,3,5,7,9,2,4,6,8]", intList.toString());
	}
	
	
	
	/**
	 * This test swaps find the nth node from end given n. 
	 */
	@Test
	public void findNthNodeFromEnd() {
		SingleLinkedList<Integer> intList = getList();
		assertEquals(new Integer(6), intList.findFromEndUsingMap(3));
		assertEquals(new Integer(6), intList.findFromEndUsingGet(3));
		assertEquals(new Integer(6), intList.findFromEnd(3));
		assertEquals(new Integer(6), intList.findFromEndUsingRecursion(3));
	}
	
	@Test
	public void testCycle(){
		SingleLinkedList<Integer> intList=getList();
		assertFalse(intList.hasLoop());
		intList.createLoopAt(2);
		assertTrue(intList.hasLoop());
		assertEquals(3, intList.getLoopStart().intValue());
		assertEquals(6, intList.lengthOfLoop());
	}
	
	public SingleLinkedList<Integer> getList(){
		SingleLinkedList<Integer> intList = new SingleLinkedList<Integer>();
		intList.addLast(1);
		intList.addLast(2);
		intList.addLast(3);
		intList.addLast(4);
		intList.addLast(5);
		intList.addLast(6);
		intList.addLast(7);
		intList.addLast(8);
		return intList;
	}

	
}
