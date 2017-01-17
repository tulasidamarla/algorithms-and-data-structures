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


