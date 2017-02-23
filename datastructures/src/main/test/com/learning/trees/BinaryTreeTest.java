package com.learning.trees;

import org.junit.Test;

public class BinaryTreeTest {

	@Test
	public void test() {
		BinaryTree<String> namesTree= new BinaryTree<>();
		
		namesTree.addToLeft("Tulasi");
		namesTree.addToLeft("Ram");
		namesTree.addToRight("Damarla");
		namesTree.addToLeft("Swaroopa");
		namesTree.addToRight("Damarla");
		namesTree.printPreorderTraversal();
		namesTree.printIterativePreorderTraversal();
	}
	
	@Test
	public void levelOrderTraversalTest() {
		BinaryTree<String> namesTree= new BinaryTree<>();
		
		namesTree.addToLeft("Tulasi");
		namesTree.addToLeft("Ram");
		namesTree.addToRight("Damarla");
		namesTree.addToLeft("Swaroopa");
		namesTree.addToRight("Damarla");
		
		namesTree.printLevelOrderTraversal();
	}

}
