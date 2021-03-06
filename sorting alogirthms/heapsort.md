
Lets see the time complexity for various operations in commonly used data structures.
<html>
<head>

</head>
<body>

<table>
  <tr>
    <th>List Type</th>
    <th>Insertion</th>
    <th>Search</th>
    <th>Find Minimum</th>
    <th>Delete Minimum</th>
  </tr>
  <tr>
    <td>Unsorted Array</td>
    <td>O(1)</td>
    <td>O(n)</td>
    <td>O(n)</td>
    <td>O(n)</td>
  </tr>
  <tr>
    <td>Sorted List</td>
    <td>O(n)</td>
    <td>O(logn)</td>
    <td>O(1)</td>
    <td>O(n)</td>
  </tr>
  <tr>
    <td>UnSorted Linked List</td>
    <td>O(1)</td>
    <td>O(n)</td>
    <td>O(n)</td>
    <td>O(n)</td>
  </tr>
  
</table>
</body>
</html>

Heap
----
Some requirements need insert, finding minimum and deleting minimum to be optimal. Search may not be the main requirement. 

Heap is a data structure which gives optimal performance for insert, find min and delete min. 
Heaps are of two types
- Min heap and Max heap.
  - Min heap is a complete binary tree in which min element is at the root.
  - Max heap is a complete binary tree in which max element is at the root.  
- The time complexity of heap for insert, find min and delete min are O(logn), 1, O(logn).
- Heap can be implemented using an array,  binary tree, ternary tree, .... or a n-ary tree.
- Most common implementation of heap is binary tree. 
  - Heap needs a complete binary tree. 
  - Disadvantge of using Binary tree is, it consumes more space because it needs pointers

Time complexity of various operations of min heap

  <table>
  <tr>
    <th>Type</th>
    <th>Insertion</th>
    <th>Search</th>
    <th>Find Minimum</th>
    <th>Delete Minimum</th>
  </tr>
  <tr>
    <td>Min Heap</td>
    <td>O(logn)</td>
    <td>O(n)</td>
    <td>O(1)</td>
    <td>O(logn)</td>
  </tr>
  
</table>
</body>
</html>

Binary Tree Types
- Strict binary tree --> Any node in the tree will have either 0 or 2 sub nodes. <br>
- Complete binary tree --> There will be no null nodes from root to last leaf node. <br>
- Full binary tree --> Its a complete binary tree with all leaf nodes at same level. <br>

Binary Tree properties
-
- Height of a tree is the no of edges between root node to longest leaf node.<br>
- Hieght of a node is the no of edges between the node to its deepest leaf.<br>
- Depth of a node is the no of edges between the node and the root node.<br>
- For a tree, Height and deapth are same.
- If height of the tree is h, then total no of nodes (2^0 + 2^1 + ...2^h).<br>
- Max no of nodes in a full binary tree is 2^(h+1)-1.<br>
- If 'n' is the no of nodes of a binary tree, then height of the tree is logn.<br>
- If n is the no of elements then in a complete binary tree leafs exists from  (n/2)+1 to n.<br>
- All non leaf nodes are present from 0 to n/2. 
- All leaf nodes are already either max or min heap.

<b>Findout if below are complete binary trees</b>

<b>problem 1</b>

		10		
	      /    \
	     5     11		
	   /  \     
	  15   6     		

Index of elements starting from root by level order traversal -> 0,1,2,3,4

<b>Answer</b>: Complete binary tree

		10
	      /    \
	     5     11
	   /  \   /  \
	      6 7    9

Index of elements starting from root by level order traversal -> 0,1,2,null,4,5,6

<b>Answer</b>: Not a complete binary tree
  
Representing Heap using Array
-

		10		//2^0 nodes at level 0
	      /    \
	     5     11		// 2^1 nodes at level 1
	   /  \   /  \
	  15   6 7    9		// 2^2 nodes at level 2
	  
- To represent the tree elements in an array let's to level order traversal and give indexes.
- For the above example values at index 0 is 1, index 1 is 5, index 2 is 11, index 3 is 15, index 4 is 6, index 5 is 7 and index 6 is 9.   - array representation is [10,5,11,15,6,7,9]
- To find the left sub node of a node with index 'i' is 2i.In java 2i+1 because index starts from 0; 
- To find the right sub node of a node with index 'i' is 2i+1. In java 2i+2; <br>
- To find the parent of a node with index 'i' is i/2. 

Find if below arrays represents max heap
-

If n is the no of nodes in a tree, leaf nodes start from n/2+1 to n. We need to verify the array from 0 to n/2, because all leaf nodes satisfy max heap condition.

<b>problem 1</b>
25,12,16,13,10,8,14 

		25
	      /    \
	     12     16
	   /  \   /  \
	  13  10 8   14

- size is 7. verify from 0 to 3 indexes.
- left of 25(12 using formula 2i+1 index is 1) satisfies max heap condition, right of 25 (using formual 2i+2 is 2) satisfies max heap
- left of 12 (value is 13 at index 2*1+1 ) does not satisfy max heap condition

<b>Answer:</b> does not represent max heap 

<b>problem 2</b>
25,14,16,13,10,8,14

		25
	      /    \
	     14     16
	   /  \   /  \
	  13  10 8   14


- size is 7. verify from 0 to 3 indexes.
- left of 25(14 using formula 2i+1 index is 1) satisfies max heap condition, right of 25 (using formual 2i+2 is 2) satisfies max heap
- left of 14 (value is 13 at index 2*1+1) satifies max heap condition, right of 14(value is 10 at index 2*1+2) satisfies max heap
- left of 16 (value is 8 at index 2*2+1) satifies max heap condition, right of 16(value is 14 at index 2*2+2) satisfies max heap

<b>Answer:</b> represents max heap 

<b>Program to find if an array represents map heap</b>

	static boolean isMaxHeap(int[] array) {
		boolean flag = true;
		for(int i = 0 ; i < array.length/2; i++) {
			if ( (array[i] < array[2*i+1]) || (array[i] < array[2*i+2])) {
				flag = false;
				break;
			}
		}
		return flag;
	}


Max heapify
-----------

Given a node whose left sub tree and right subtree already satisfy max heap, then to max heapify of the current node using recursive method use the below code.
	
	
	public static void maxHeapify(int[] a, int current, int n) {

		int leftindex = 2 * current + 1;
		int rightindex = 2 * current + 2;
		int largeindex;

		if (leftindex < n && a[leftindex] > a[current]) {
			largeindex = leftindex;
		} else {
			largeindex = current;
		}

		if (rightindex < n && a[rightindex] > a[largeindex]) {
			largeindex = rightindex;
		}

		if (largeindex != current) {
			exchange(a, current, largeindex);
			maxHeapify(a, largeindex,n);
		}

	}

	private static void exchange(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}


<i><Note>:</i> max heapifying logic always gets the max element to the current node from the sub tree. It means this travers from current node to deepest node.
	
Let's consider the strategy for max heapifying at node 12.

		25
	      /    \
	     12     16
	   /  \   /  \
	  13  10 8   14


- apply maxheapify at 12 (index 1). 12 doesn't satisfy max heap condition but 13 and 10 are satisfying max heap.
  - compare 12 with left subnode 13 and store larger value index(13's index 3) in a variable say largeindex(3).
  - compare 12's right subnode 10(index 4) with value at largeindex(3). As 13 is still larger no need to do change anything.
  - exchange 12 with largeindex value. i.e. 12 and 13 are exchanged
  
<b>Note:</b> As per the code after exchanging it tries to maxHeapify from largeindex to sub nodes. That is from index 3, it tries to maxheapfiy the subtree. Because, that is a leaf node, it stops.

Time complexity:
----------------
For max heapifying at any given level of heap, it requires two comparisions.(i.e with left and right). so to bring down an element from top node to deepest node, time complexity is 2*h i.e. 2logn, because logn is the height of the tree given n elements. 

<b> Time complexity is approximately logn. </b>

Space complexity
----------------
For recursive calling of methods, the worst space complexity is upto logn.

Build Max Heap
--------------
We know all leaf nodes satisfy by default satisfy either max heap or min heap conditions. So, to build a max heap using max heapify algorithm, the max heapify algorithm has to run from last non leaf node to the root of the tree i.e from n/2 to 0. 


	public static void buildMaxHeap(int[] arr){
		for(int i=arr.length/2; i >= 0; i--){
			 maxHeapify(arr, i, arr.length);
		}
	}

Time complexity
---------------
To understand time complexity , few properties of a tree are needed.<br>
No of nodes present in a complete binary tree at height h , is seal of |n/2^(h+1)|+1. ( h is from 0 to logn)

Total no of elements in a tree with height 4 is 15. <br>
so, at level 0, no of elements are |15/2|+1 = 8. <br>
no of elements at level 1 are 4.<br>
no of elements at level 2 are 2.<br>
no of elements at level 3 are 1.<br>

Total work done, for running max heapify on all nodes at a height h is  (|n/2^(h+1)|+1)*O(h).<br>
Total work done, for running max heapify on complete tree is  ∑(|n/2^(h+1)|+1)O(h) where h = 1 to logn.

	T(n) = n/2 ∑ h/2^h ( where h = 0 to logn)
		 = n/2 * 2 (The sigma operation results in a harmonic progression. The sum of 						the progression is 2)
		 = n.
		 
So, Time complexity for building heap is O(n).

Space complexity
----------------
Space complexity for this same as max heapify. i.e. O(logn).		 

Delete max
----------
Maximum element in a max heap is the first element. After deleting the first element, exchane the root with the last element and apply max heapify to get max heap. Here is the code.

	private static int[] deleteMaximum(int[] a) {
		int[] arr={};
		if (a.length > 0) {
			int max = a[0];
			exchange(a, 0, a.length-1);
			arr = Arrays.copyOfRange(a, 0, a.length-1); 
		}
		maxHeapify(arr, 0);
		return arr; 
	}

Note:  After deletion remaining elements are copied to new array because in java you can't resize an existing array.

Time complexity for deletion is same as maxHeapify. i.e. O(logn)<br>
Space complexity is also same as maxHeapify i.e. O(logn)

Increasing a value
------------------
Increasing value of an element in the heap, needs to run maxHeapify from that node to the top of the tree. Here is the code.

	private static void increaseValue(int[] a, int index, int value){
		if(value < a[index]){
			return;
		}
		a[index] = value;
		int parent = (index-1)/2;
		while( index > 1 && a[parent] < a[index]){
			exchange(a, index, parent);
			index = parent;
			parent = (index-1)/2;
		}
	}

Note: Given an node with index i, parent node index is (i-1)/2. If parent is smaller than the children, then exchange. repeat this until the root of the tree.

Time complexity is O(logn) and space complexity is O(1) because there are no recursive calls.

Note: Decreasing value is also possible using max heap. If value is decreased, then simply call maxHeapify on the tree from that node.

Inserting an element
--------------------
To insert an element simply add the element at the end of the heap and call increaseValue function which is written above.

so, Time complexity is O(logn) and space complexity is O(1).

Heap sort
---------
To sort a list using heap sort, first it needs to build a max heap. Using this, we can extract the max element and remaining list needs to be max heapified. so each time max element is extracted remove the max element and max heapify the remaining elements. Continue this until we reach the end of the list. Here is the code.
	
	public static void heapsort(int[] unsorted){
		buildMaxHeap(unsorted);
		int size = unsorted.length-1;
		for(int i= size; i > 0 ; i--){
			exchange(unsorted, 0, i);
			size--;
			maxHeapify(unsorted, 0,size);
		}
	}

Time complexity
---------------
For buildMaxHeap time complexity is O(n). For maxHeapify time complexity is O(logn). So , Time complexity for heap sort is O(n) + O(nlogn) = O(nlogn).

Space complexity
----------------
For both buildMaxHeap and maxHeapify space complexity is O(logn). So, Time complexity for heap sort is O(logn).

