package com.learning.trees;

import java.util.ArrayDeque;
import java.util.Deque;

public class BinaryTree<T> {
	private int length=0;
	private BinaryTreeNode<T> root;
	
	public BinaryTree() {
		length = 0;
	}
	
	public boolean addToLeft(T data){
		if(root == null){
			root = new BinaryTreeNode<T>(data);
		}else{
			BinaryTreeNode<T> temp = root;
			while(temp.getLeft() != null){
				temp = temp.getLeft();
			}
			BinaryTreeNode<T> newNode=new BinaryTreeNode<T>(data);
			temp.setLeft(newNode);
		}
		length++;
		return true;
	}
	
	public boolean addToRight(T data){
		if(root == null){
			root = new BinaryTreeNode<T>(data);
		}else{
			BinaryTreeNode<T> temp = root;
			while(temp.getRight() != null){
				temp = temp.getRight();
			}
			BinaryTreeNode<T> newNode=new BinaryTreeNode<T>(data);
			temp.setRight(newNode);
		}
		length++;
		return true;
	}
	
	public void printPreorderTraversal(){
		System.out.println("---------pre order traversal start---------");
		preorderTraversal(root);
		System.out.println("---------pre order traversal end---------");
	}
	
	private void preorderTraversal(BinaryTreeNode<T> root){
		
		if(root != null){
			System.out.print(root.getData() + " ");
			preorderTraversal(root.getLeft());
			preorderTraversal(root.getRight());
		}
		
	}
	
	public void printIterativePreorderTraversal(){
		System.out.println("----------iterative pre order traversal start---------");
		iterativePreorderTraversal(root);
		System.out.println("--------iterative pre order traversal end---------");
	}
	
	private void iterativePreorderTraversal(BinaryTreeNode<T> root){
		Deque<BinaryTreeNode<T>> stack=new ArrayDeque<>();
		if(root != null){
			stack.push(root);
		}
		while(!stack.isEmpty()){
			BinaryTreeNode<T> temp=stack.pop();
			System.out.print(temp.getData() + " ");
			if(temp.getRight()!=null){
				stack.push(temp.getRight());
			}
			if(temp.getLeft()!=null){
				stack.push(temp.getLeft());
			}
		}
	}
	
	public void printLevelOrderTraversal(){
		System.out.println("----------level order traversal start---------");
		levelOrderTraversal(root);
		System.out.println("----------level order traversal end---------");
	}
	
	private void levelOrderTraversal(BinaryTreeNode<T> root){
		Deque<BinaryTreeNode<T>> queue=new ArrayDeque<>();
		
		if(root!=null){
			queue.offer(root);
			BinaryTreeNode<T> temp=null;
			while (!queue.isEmpty()) {
				/*remove the head element and assign it to temp*/
				temp = queue.poll();
				// process current node data and add its two children to the queue.
				System.out.print(temp.getData() + "\t");
				if (temp.getLeft() != null) {
					queue.offer(temp.getLeft());
				}
				if (temp.getRight() != null) {
					queue.offer(temp.getRight());
				}
			}
		}
		
	}
}

class BinaryTreeNode<T> {

	private T data;
	private BinaryTreeNode<T> left;
	private BinaryTreeNode<T> right;

	BinaryTreeNode(T data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public BinaryTreeNode<T> getLeft() {
		return left;
	}

	public void setLeft(BinaryTreeNode<T> left) {
		this.left = left;
	}

	public BinaryTreeNode<T> getRight() {
		return right;
	}

	public void setRight(BinaryTreeNode<T> right) {
		this.right = right;
	}
	
	

}