Merge Sort problems
-------------------

Problem 1
---------
Given logn sorted lists of each having size n/logn, what is the total time required to merge them into one sorted array.

Solution:

Lets take value of n is 16. i.e. Total no of lists are 4, each list contains again 4. It requires total 3 merges to get one sequence.

Lets take value of n as 64. i.e. Total no of lists are 8 and each list contains again 8 elements. It requires total 7 merges to get one sorted array. If you observe the sequence it is working at the rate of loglogn - 1. i.e. loglogn.

So total time complexity including merge process is  ϴ(nloglogn)

Problem 2
---------
n strings each of length n are given, then what is the time taken to sort them?

Solution:

strings are compared using lexicographical order. If we have two numbers say 3 and 5, time taken two compare them is O(1), whereas time taken two compare two strings each of length 'n' is O(n). So, using merge sort, time taken to compare is O(n)*O(nlogn).i.e. O(n^2 logn)

Problem 3
---------
If the following sequence is being sorted using two way merging, what will be the order of elements after the 2nd round?
20 47 15 8 9 4 40 30 12 17

Solution:
After 1st round ---> 20 47    8  15    4 9     30 40   12  17
After 2nd round ---> 8 15 20 47        4 9 30 40       12  17

Problem 4
---------
The median of n elements can be found in O(n) time. If median is selected as pivot then what is the time complexity of quick sort?
Solution:
If median can be found in O(n), then copy the median to the end of the list and run the quick sort using pivot as last element. This will divivde the list into half in each iteration, thus get the best performance of quick sort. i.e. O(nlogn). Total time complexity is O(nlogn) + O(n) ≈ O(nlogn)
