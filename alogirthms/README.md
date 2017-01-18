Insertion Sort
--------------
Insertion sort, solves the sorting problem. It is an efficient algorithm for sorting a small number of elements.Insertion sort works the way many people sort a hand of playing cards. It starts with an empty left hand and the cards face down on the table. We then remove one card at a time from the table and insert it into the correct position in the left hand. To find the correct position for a card, we compare it with each of the cards already in the hand, from right to left. At all times, the cards held in the left hand are sorted, and these cards were originally the top cards of the pile on the table.

Psuedo code
-----------
	insertionsort (int[] a){
		for int i from 1 to a.length
		key = a[i];
		//insert this key into a sorted sequence by comparing all elements to its left
		j = i-1;
		while( j > 0 and a[j] > key){
			a[j+1] = a[j];
			j--;
		} 
		a[j] = key;
	}

Implementation
--------------

	private static int[] insertionSort(int[] a){
		//starting with second element i.e i=1
		for(int i=1;i< a.length;i++){ //n times
			int current=a[i]; // constant time
			int insertPosition=i; // constant time
			//find the index to insert
			while(insertPosition > 0 && a[insertPosition-1] > current){ // 1,2,3 ...n-1 times
				a[insertPosition]=a[insertPosition-1]; //constant time
				insertPosition--; //constant time
			}
			a[insertPosition]=current; // constant time
		}
		return a;
	}

Note: Insert position always validate towards left.

Analysis
--------

Time complexity
---------------
Insertion Sort can take different amounts of time for two input sequences of the same size depending on how nearly sorted they already are. In general, the time taken by an algorithm grows with the size of the input. Total time for execution is

	c.1 + c.2 + c.3+ ...c.(n-1) = c(n*n-n)/2 ≅ c(n*n-n) ≅ c(n*n) // generally lower order terms are ignored

The worst case scenario i.e. if elements are in reverse sort order, this algorithm takes O(n^2).

The best time possible .i.e. if elements are in sorted order, this algorithm take Ω(n), because for loop has to traverse through out the length of the array.

Space complexity
----------------
This algorithm needs three variables to store key, for outer loop and and for insertion position. so, for space complexity this algorithm is not dependent on the input size. 

The space complexity of insertion sort is order of 1 or O(1).

Note: If an algorithm has space complexity of O(1), it is called inplace algorithm.

Merge Sort
----------
Merge sort uses divide and conquer paradigm. It operates as follows. <br>
Divide: Divide the n-element sequence to be sorted into two subsequences of n/2 elements each.<br>
Conquer: Sort the two subsequences recursively using merge sort.<br>
Combine: Merge the two sorted subsequences to produce the sorted answer.<br>

Merge sort works with a procedure called merging. Lets see merging.

Merging is a process of combining two sorted arrays into one sorted array. 

	public void merge(int[] left, int[] right, int[] result){

		int indexLeft=0;
		int indexRight=0;
		int j=0;
		
		while(indexLeft < left.length && indexRight < right.length){ // n times
			if(left[indexLeft] < right[indexRight]){
				result[j] = right[indexRight];
				indexRight++;
			}else{
				result[j] = left[indexLeft];
				indexLeft++;
			}
			j++;
		}
		//copy what is remaining
		while(indexLeft < left.length){
			result[j] = left[indexleft];
			indexLeft++;
			j++;
		}
		
		while(indexRight < right.length){
			result[j] = right[indexRight];
			indexRight++;
			j++;
		}
		
	}
	
Time Complexity
---------------
If total no of elements in the result array are n, then for looping through all the elements complexity is O(n) and for copying elements to the result array is O(n). Total time complexity is O(n)+O(n) = O(n).

Space complexity
----------------
If total no of elements in the left and right array are n, then this mergin needs another array of size n. i.e. Space complexity of this algorithm is O(n). 
		
Note: This is called out of place algorithm, because it uses extra memory to solve the problem.

Merge Sort
----------
As mentioned before, Merge sort uses divide and conquer method to sort a given array. It does this using the merge process discussed above. Merge Sort splits the given array recursively until each array contains one element. i.e. If an array contains n elements then merge sort splits the array into n arrays of size 1. It uses merge process from here. In first step, it creates n/2 sorted arrays of each array size 2. In the 2 step, it creates n/4 sorted arrays of each array size 4. It goes on, until the array size becomes n/n. i.e. 1.

Implementation
--------------
	
	private static void mergeSort(int[] list) {
		if (list.length <= 1) {
			return;
		}

		// Split the array in half
		int[] left = new int[list.length / 2];
		int[] right = new int[list.length - left.length];
		
		// copy left array
		for (int i = 0; i < left.length; i++) {
			left[i] = list[i];
		}
		// copy right array
		for (int i = 0; i < right.length; i++) {
			right[i] = list[i + left.length];
		}

		// Sort each half
		mergeSort(left);
		mergeSort(right);

		// Merge the sorted halves together, using the original array
		merge(left, right, list); // 
		
	}

Space Complexity
----------------
From merge process, we know space complexity required is O(n). In addition to merging, Mergesort occupies additional space for recursive function calling of mergesort. We know already if the array sizes are halfed in each call, no of recursive calls are of the order of logn. Total space complexity is O(n + logn). i.e. O(n)

Time Complexity
---------------
Lets assume that time complexity for solving the problem is T(n). Then T(n) = 2T(n/2) + n.
n is for merging process. now using back substitution method, 
	T(n/2) = 2T(n/4) + n/2;  

	T(n) = 2 (2T(n/4) + (n/2)) + n;
	T(n) = 2^kT(n/2^k) + n/2^k + n/2^k-1  + ....+n
	
recursion stops when n/2^k = 1; i.e. T(n) = n(1+1/2+1/2^2+...1/2^n) = nlogn

so, Time complexity of merge sort is ϴ(nlogn). 

Note:  ϴ is mentioned because it represents average time. For merge sort there is no best case or worst case. i.e. Even if you give a sorted array, it still takes nlogn time.

Quick Sort
-----------
Merge sort is good for sort large data sets. But, for small data sets it is more complex. For smaller inputs Quick sort works faster than Merge sort. Like Merge sort Quick sort also uses divide and conquer approach. 

Quick sort uses a procedure called partition. Partition procedure chooses a random element from the list of elements and partition the list into two lists in such a way that all the elements to its left are lesser than the this and all the elements to its right are larger than this. This random element is generally taken either from the first, middle or last.

This procedure repeats to the two lists that were created in the first step and so on.

Partition
---------
Lets see the partition algorithm with an example. Lets say the list is 9 6 5 0 8 2 4 7
Lets choose the random number as the last element. i.e. 7. This is also called pivot.

To implement partition we need two pointers say i, j. variable j is to iterate the list from 0 to n-1 where n is the size of the list.
The value of i starts from -1. while iterating through the list using index j when any element is find smaller than pivot, increment the value of i by 1 and exchange with value at jth index with ith index. 

To understand this, let us iterate throught the list.
when j=0, value is 9 , which is greater than 7, so leave it as it is. <br>
when j=1, value is 6 , which is less than 7, so increment i. i.e. i=0 and exchange jth index value with ith index. i.e. 9 and 6. so list now becomes 6 9 5 0 8 2 4 7 <br>
when j = 2, value is 5, which is less than 7, so increment i. i.e. i = 1 and exchange . i.e. 9 and 5. so list now becomes 6 5 9 0 8 2 4 7 <br>
when j = 3, value is 0, again it is less than 7, so increment i and exchange. now list is 6 5 0 9 8 2 4 7.
when j = 4, value is 8, it is greater than 7, hence no change.
when j = 5, value is 3, which is less than 7, so increment i and exchange. i.e. 6 5 0 2 9 8 4 7
when j= 6, value is 4, which is less than 7, so increment i and exchange. i.e. 6 5 0 2 4 9 8 7

Now loop stops because j reached n-1 i.e. 6. After the loop is completed i = 4, so exchange 4th element with pivot. now the list is 
6 5 0 2 4 7 9 8.

From the above list it is clear that 7 is at the right position in the list. i.e. all elements to its left are smaller and all elements to its right are larger than 7. so, now repeat the same procedure for the left list and right list.

Psuedo code
-----------
	public int method(int[] list, int start, int pivotindex){
		int i = start - 1;
		int j = start;
		int pivot = list[pivotindex];
		while( j < pivotindex){
			if(list[j] < pivot){
				i++;
				//exchange list[i] with list[j]
			}
		}
		//exchange list[i+1] with pivot(or list[pivotindex]
		return i+1;
	}
Note: once partitioning is done, this method returns the index position of pivot.

Time complexity
---------------
If a list contains n elements, then for partition algorithm , it takes n comparision to put a pivot element in its right partition. so, time complexity is O(n).

Space complexity
----------------
Partition algorithm won't use any new spaces. so space complexity is O(1).

Quick Sort
----------
Lets see how quick sort works using partition. Quick sort takes a list of n elements and partition the list into n lists each of size 1 using recursion. Here is the psuedo code.
	
	private static void quicksort(int[] a,int p, int r) {
		if(p < r){
			int q=partition(a, p, r);
			quicksort(a,p,q-1);
			quicksort(a,q+1,r);
		}
	}

Time complexity
---------------

For partition algorithm we know time complexity is O(n). If, Time complexity for quick sort is T(n), then
	T(n) = 2*T(n/2) + n;
This is same as merge sort, so Time complexity for quick sort is O(nlogn)

Space complexity
----------------
If partition results a pivot element to be positioned at the middle of the list, then each partition splits the list into two. In that case space complexity is O(logn).
In the worst case, if partition results a pivot element to be positioned at the beginning or at the end of the list in each partition, then order of space complexity is O(n).
