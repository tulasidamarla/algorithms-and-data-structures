package com.learning.trees;

import org.junit.Assert;
import org.junit.Test;

public class BinaryTreeTest {

	@Test
	public void traversalTest() {
		BinaryTree<Integer> namesTree= new BinaryTree<>();
		/*namesTree.insert(1);
		namesTree.insert(2);
		namesTree.insert(3);
		namesTree.insert(4);
		namesTree.insert(5);
		namesTree.insert(6);
		namesTree.insert(7);*/
		//namesTree.printLevelOrderTraversal();
		//namesTree.printReverseLevelOrderTraversal();
		
		//namesTree.printPreorderTraversal();
		//System.out.println(namesTree.getPreorder());
		
		namesTree.insertRecursive(1);
		namesTree.insertRecursive(2);
		namesTree.insertRecursive(3);
		namesTree.insertRecursive(4);
		namesTree.insertRecursive(5);
		namesTree.insertRecursive(6);
		namesTree.insertRecursive(7);
		Assert.assertEquals(namesTree.getPreorder(),"1245367");
		//namesTree.printPreorderIterativeMethodTraversal();
		//namesTree.printInorderTraversal();
		//namesTree.printInorderIterativeTraversal();
		//namesTree.printPostOrderTraversal();
		//namesTree.printPostOrderIteativeMethodTraversal();
	}
	
	@Test
	public void sizeTest() {
		BinaryTree<String> namesTree= new BinaryTree<>();
		namesTree.insert("Tulasi");
		namesTree.insert("Ram");
		namesTree.insert("Damarla");
		namesTree.insert("Sadhu");
		namesTree.insert("Arghya");
		namesTree.insert("Vishwas");
		namesTree.insert("Muninarayana");
		Assert.assertEquals(namesTree.size(), 7);
	}
	
	@Test
	public void removeTest() {
		BinaryTree<String> namesTree= new BinaryTree<>();
		namesTree.insert("Tulasi");
		namesTree.insert("Ram");
		namesTree.insert("Damarla");
		namesTree.insert("Sadhu");
		namesTree.insert("Arghya");
		namesTree.insert("Vishwas");
		namesTree.insert("Muninarayana");
		namesTree.removeTree();
		Assert.assertEquals(namesTree.size(), 0);
	}

	
	@Test
	public void heightTest() {
		BinaryTree<String> namesTree= new BinaryTree<>();
		
		namesTree.insert("Tulasi");
		namesTree.insert("Ram");
		namesTree.insert("Damarla");
		namesTree.insert("Sadhu");
		namesTree.insert("Arghya");
		namesTree.insert("Vishwas");
		namesTree.insert("Muninarayana");
		
		Assert.assertEquals(namesTree.height(), 3);
		Assert.assertEquals(namesTree.heightNonRecursive(), 3);
	}
}
