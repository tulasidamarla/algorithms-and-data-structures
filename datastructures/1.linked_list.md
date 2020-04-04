Linked Lists
------------
Linked list is a data structure used for storing collections of data. It has the following properties.

i)successive elements are connected by pointers<br>
ii)Last element points to null<br>
iii)can grow or shrink in size during the execution of a program<br>
iv)It does not waste memory but consumes extra memory for pointers.<br>

Note:linked list takes O(n) for accessing an element in the worst case.

Singly Linked Lists
-------------------
This list contains a number of nodes in which each node has next pointer to the following and the last node points to null, which indicates the end of the list.

Basic operations on a list
--------------------------
1)Traversing the list.<br>
2)Inserting an item in the list.<br>
3)Deleting an item from the list.<br>

Double Linked Lists
-------------------
Doubly Linked list is also call two way linked list. Given a node we can navigate in both directions. A single linked list node cannot be removed unless
 we have a pointer to predecessor. In doubly linked list we can remove with out previous  node reference because it has a pointer which points to previous node. 
 
The primary disadvantage of DLL is it requires more space.
The second disadvantage is insertion and deletion takes more time because of more pointer operations.
 
Circular Linked Lists
---------------------
In single and double linked list end of the list is indicated with null pointer. But circular linked lists do not have ends. While traversing the list we should be careful, otherwise we will end up looping infinitely. 

Circular linked lists are useful in some scenarios. For ex, when serveral processes are using CPU, it has to assure that no process access the resource before all other processes have done. This is also called round robin algorithm.

In general use Circular Linked Lists are single directional and added to the end of the list. 

Memory Efficient or XOR Doubly Linked Lists
-------------------------------------------
In a conventional doubly linked list there are two pointers for each node one for pointing previous node and another for next node.
The node will be like this.
	public class DLLNode<T>{
		private T data;
		private DLLNode<T> ptrDiff;
		.....
	} 
	
ptrDiff of the first node is XOR of NULL and second node. similarly ptrDiff of last node is XOR of previous node and NULL. For ex, If we have 4 nodes say A, B, C and D.

To get the next pointer of A --> XOR(NULL, B)
To get the next pointer of B --> XOR(A, C)
To get the next pointer of C --> XOR(B, D)
To get the next pointer of D --> XOR(C, NULL)

How does this work?
To know , First we need to understand XOR properties. XOR of two same values is always 0. XOR of two different values is 1. For ex,
	XOR(0,1)/XOR(1,0) --> 1
	XOR(1,1)/XOR(0,0) --> 0

XOR has the following properties.
	XOR(X,0) --> X
	XOR(X,X) --> 0
	XOR(X,Y) --> XOR(Y,X) // symmetric
	XOR(XOR(X,Y),Z) --> XOR(X,XOR(Y,Z) //transitive

If we want to move to B, performing ptrDiff(XOR) of C with D will give B. We know XOR(B,D) is C. So, XOR(XOR(B,D),D) gives B.

Note
----
It is not possible to implement this in Java, because In Java objects are not directly accessed, they are accessed through references.
	  
Unrolled Linked Lists
---------------------
The biggest advantage of Linked Lists is that inserting an element at any position it takes O(1) time. But, to search an element it takes O(n). There is a simple variation of singly linked lists called Unrolled Linked Lists which is an improvement over the former.

An Unrolled Linked List stores multiple elements in each node(It is better to call block instead on node). In each block a Circular Linked List is used to connect all nodes.

Skip Lists
----------
  	
