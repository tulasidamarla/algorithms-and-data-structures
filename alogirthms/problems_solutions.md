Merge Sort problems
-------------------

Problem 1
---------
Given logn sorted lists of each having size n/logn, what is the total time required to merge them into one sorted array.

Lets take value of n is 16. i.e. Total no of lists are 4, each list contains again 4. It requires total 3 merges to get one sequence.

Lets take value of n as 64. i.e. Total no of lists are 8 and each list contains again 8 elements. It requires total 7 merges to get one sorted array. If you observe the sequence it is working at the rate of loglogn - 1. i.e. loglogn.

So total time complexity including merge process is  ϴ(nloglogn)


Problem 2
---------

