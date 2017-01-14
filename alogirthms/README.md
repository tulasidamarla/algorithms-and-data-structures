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

Example
-------

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

Insertion Sort can take different amounts of time for two input sequences of the same size depending on how nearly sorted they already are. In general, the time taken by an algorithm grows with the size of the input. Total time for execution is

	c.1 + c.2 + c.3+ ...c.(n-1) = c(n*n-n)/2 ≅ c(n*n-n) ≅ c(n*n) // generally lower order terms are ignored

The worst case scenario i.e. if elements are in reverse sort order, this algorithm takes O(n^2).

The best time possible .i.e. if elements are in sorted order, this algorithm take Ω(n), because for loop has to traverse through out the length of the array.

	
Merge Sort
----------
Merge sort uses divide and conquer paradigm. It operates as follows.
Divide: Divide the n-element sequence to be sorted into two subsequences of n/2 elements each.
Conquer: Sort the two subsequences recursively using merge sort.
Combine: Merge the two sorted subsequences to produce the sorted answer.

	

