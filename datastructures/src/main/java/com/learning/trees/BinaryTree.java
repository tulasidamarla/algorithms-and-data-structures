package com.learning.trees;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class BinaryTree<T> {
	private BinaryTreeNode<T> root;

	public String getPreorder() {
		return preorderTraversal(root);
	}

	private String preorderTraversal(BinaryTreeNode<T> root) {
		if (root != null) {
			return root.getData() + preorderTraversal(root.getLeft()) + preorderTraversal(root.getRight());
		}
		return "";

	}

	public void printPreorderIterativeMethodTraversal() {
		System.out.println("----------iterative pre order traversal start---------");
		preorderIterativeMethodTraversal(root);
		System.out.println("--------iterative pre order traversal end---------");
	}

	private void preorderIterativeMethodTraversal(BinaryTreeNode<T> root) {
		Deque<BinaryTreeNode<T>> stack = new ArrayDeque<>();
		if (root != null) {
			stack.push(root);
		}
		while (!stack.isEmpty()) {
			BinaryTreeNode<T> temp = stack.pop();
			System.out.print(temp.getData() + " ");
			if (temp.getRight() != null) {
				stack.push(temp.getRight());
			}
			if (temp.getLeft() != null) {
				stack.push(temp.getLeft());
			}
		}
		System.out.println("");
	}

	public void printInorderTraversal() {
		System.out.println("----------inorder traversal start---------");
		inorderTraversal(root);
		System.out.println();
		System.out.println("----------inorder traversal end---------");
	}

	private void inorderTraversal(BinaryTreeNode<T> root) {
		if (root != null) {
			inorderTraversal(root.getLeft());
			System.out.print(root.getData() + " ");
			inorderTraversal(root.getRight());
		}
	}

	public void printInorderIterativeTraversal() {
		System.out.println("----------inorder iterative traversal start---------");
		inorderIterativeMethodTraversal(root);
		System.out.println();
		System.out.println("----------inorder iterative traversal end---------");
	}

	private void inorderIterativeMethodTraversal(BinaryTreeNode<T> root) {
		Deque<BinaryTreeNode<T>> stack = new ArrayDeque<>();
		BinaryTreeNode<T> currentNode = root;
		boolean done = false;
		while (!done) {
			if (currentNode != null) {
				stack.push(currentNode);
				currentNode = currentNode.getLeft();
			} else {
				if (stack.isEmpty()) {
					done = true;
				} else {
					currentNode = stack.pop();
					System.out.print(currentNode.getData() + " ");
					currentNode = currentNode.getRight();
				}
			}
		}
	}

	public void printPostOrderTraversal() {
		System.out.println("----------post order traversal start---------");
		postOrderTraversal(root);
		System.out.println();
		System.out.println("----------post order traversal end---------");
	}

	private void postOrderTraversal(BinaryTreeNode<T> root) {
		if (root != null) {
			postOrderTraversal(root.getLeft());
			postOrderTraversal(root.getRight());
			System.out.print(root.getData() + " ");
		}
	}

	public void printPostOrderIteativeMethodTraversal() {
		System.out.println("----------post order iterative method traversal start---------");
		postOrderIterativeTraversal(root);
		System.out.println();
		System.out.println("----------post order iterative method traversal end---------");
	}

	private void postOrderIterativeTraversal(BinaryTreeNode<T> root) {
		if (root != null) {
			Deque<BinaryTreeNode<T>> stack = new ArrayDeque<>();
			stack.push(root);
			BinaryTreeNode<T> currentNode = null;
			BinaryTreeNode<T> previousNode = null;
			while (!stack.isEmpty()) {
				currentNode = stack.peek();
				if (previousNode == null || previousNode.getLeft() == currentNode
						|| previousNode.getRight() == currentNode) {
					if (currentNode.getLeft() != null) {
						stack.push(currentNode.getLeft());
					} else if (currentNode.getRight() != null) {
						stack.push(currentNode.getRight());
					}
				} else if (currentNode.getLeft() == previousNode) {
					if (currentNode.getRight() != null) {
						stack.push(currentNode.getRight());
					}
				} else {
					System.out.print(currentNode.getData() + " ");
					stack.pop();
				}
				previousNode = currentNode;
			}
		}
	}

	public void printLevelOrderTraversal() {
		System.out.println("----------level order traversal start---------");
		levelOrderTraversal(root);
		System.out.println("");
		System.out.println("----------level order traversal end---------");
	}

	public void printReverseLevelOrderTraversal() {
		System.out.println("----------reverse level order traversal start---------");
		reverseLevelOrderTraversal(root);
		System.out.println("");
		System.out.println("----------reverse level order traversal end---------");
	}

	private void reverseLevelOrderTraversal(BinaryTreeNode<T> root) {
		if (root == null) {
			return;
		} else {
			Deque<BinaryTreeNode<T>> stack = new ArrayDeque<>();
			Deque<BinaryTreeNode<T>> queue = new ArrayDeque<>();
			BinaryTreeNode<T> temp = null;
			queue.offer(root);
			while (!queue.isEmpty()) {
				temp = queue.poll();
				if (temp.getLeft() != null) {
					queue.offer(temp.getLeft());
				}
				if (temp.getRight() != null) {
					queue.offer(temp.getRight());
				}
				stack.push(temp);
			}
			while (!stack.isEmpty()) {
				System.out.print(stack.pop().getData() + " ");
			}
		}
	}

	private void levelOrderTraversal(BinaryTreeNode<T> root) {
		Deque<BinaryTreeNode<T>> queue = new ArrayDeque<>();

		if (root != null) {
			queue.offer(root);
			BinaryTreeNode<T> temp = null;
			while (!queue.isEmpty()) {
				/* remove the head element and assign it to temp */
				temp = queue.poll();
				// process current node data and add its two children to the
				// queue.
				System.out.print(temp.getData() + " ");
				if (temp.getLeft() != null) {
					queue.offer(temp.getLeft());
				}
				if (temp.getRight() != null) {
					queue.offer(temp.getRight());
				}
			}
		}

	}

	public void insertRecursive(T data) {
		root = insertRecursive(root, data);
	}

	private BinaryTreeNode<T> insertRecursive(BinaryTreeNode<T> node, T data) {

		if (node == null) {
			node = new BinaryTreeNode<>(data);
		} else {
			if (node.getRight() == null) {
				node.setRight(insertRecursive(node.getRight(), data));
			} else {
				node.setLeft(insertRecursive(node.getLeft(), data));
			}
		}
		return node;
	}

	public void insert(T data) {
		insert(root, data);
	}

	private void insert(BinaryTreeNode<T> root, T data) {
		Deque<BinaryTreeNode<T>> queue = new ArrayDeque<>();
		BinaryTreeNode<T> nodeToInsert = new BinaryTreeNode<>(data);
		if (root == null) {
			this.root = nodeToInsert;
		} else {
			queue.offer(root);
			BinaryTreeNode<T> temp = null;
			while (!queue.isEmpty()) {
				temp = queue.poll();
				if (temp.getLeft() == null) {
					temp.setLeft(nodeToInsert);
					queue.clear();
					break;
				} else {
					queue.offer(temp.getLeft());
				}

				if (temp.getRight() == null) {
					temp.setRight(nodeToInsert);
					queue.clear();
					break;
				} else {
					queue.offer(temp.getRight());
				}
			}
		}
	}

	public int size() {
		return size(root);
	}

	private int size(BinaryTreeNode<T> root) {
		if (root == null) {
			return 0;
		} else {
			return size(root.getLeft()) + 1 + size(root.getRight());
		}
	}

	public void removeTree() {
		this.root = null;
	}

	public int height() {
		return findHeight(root);
	}

	private int findHeight(BinaryTreeNode<T> root) {
		int leftTreeHeight = 0;
		int rightTreeHeight = 0;
		int height = 0;

		if (root != null) {
			leftTreeHeight = findHeight(root.getLeft());
			rightTreeHeight = findHeight(root.getRight());
			if (leftTreeHeight < rightTreeHeight) {
				height = rightTreeHeight + 1;
			} else {
				height = leftTreeHeight + 1;
			}
		}
		return height;
	}

	public int heightNonRecursive() {
		return findHeightNonRecursive(root);
	}

	private int findHeightNonRecursive(BinaryTreeNode<T> root) {
		int level = 0;
		if (root != null) {
			LinkedList<BinaryTreeNode<T>> queue = new LinkedList<>();
			queue.add(root);
			queue.add(null);
			BinaryTreeNode<T> temp = null;
			while (!queue.isEmpty()) {
				temp = queue.poll();
				if (temp == null) {
					queue.offer(null);
					level++;
				} else {
					queue.offer(temp.getLeft());
					queue.offer(temp.getRight());
				}
			}
		}
		return level;
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