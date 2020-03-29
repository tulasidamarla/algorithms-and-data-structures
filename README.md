# algorithms-and-data-structures

Data structures
---------------
A data structure is a way to store and organize data in order to facilitate access and modifications.

Abstract data types(ADT)
------------------------
Primitive data types supports basic operations like addition and subtraction etc. But, for user defined data types (ex: Java classes) , we need to define operations(methods). To simplify the process of solving the problems, we generally combine data structures along with their opeations and are called abstract data types. So, an ADT consists of two parts. 1) Declaration of data 2) Declaration of operations.

Commonly used ADTs include: Linked Lists, Stacks, Queues, Trees, Dictionaries, Hash Tables, Graphs etc.

Algorithm
---------
An algorithm is the step by step instructions to solve a given problem.

Analysis of an algorithm
------------------------
For a given problem there can be one to many algorithms possible. Algorithm analysis helps in determining which of them is efficient in terms of time and space consumed.

Running time analysis
---------------------
It is the process of determining how running time increases as the size of the input increases.

Compare algorithms
------------------
If running time of a given algorithm is expressed as a function of the input size, then running time of different algorithms would be ideal to compare. Execution time and No of statements are not a good measure.

Execution time: Not a good measure as execution times are specific to a particular computer.<br>
Number of statements: Not a good measure, since no of statements vary with the programming language.

Rate of growth
--------------
The rate at which the running time increases as a function of input is called rate of growth.

Note: In general, lower values of n are discarded. That means rate of growth at lower values of n is not important.

Efficiency of an Algorithm:
---------------------------
Insertion sort, takes time roughly equal to c1*n<sup>2</sup> to sort n items, where c1 is a constant that does not depend on n. That is, it takes time roughly proportional to n<sup>2</sup> . 

The second, merge sort, takes time roughly equal to c2nlog(n), where log(n) stands for log(n) with base 2 and c2 is another constant that also does not depend on n. 

Insertion sort typically has a smaller constant factor than merge sort, so that c1 < c2. The constant factors can have far less of an impact on the running time than the dependence on the input size n. 

It is evident that insertion sort has a factor of n in its running time, whereas merge sort has a factor of log n, which is much smaller. (For example, when n is 1000, lg n is approximately 10, and when n equals one million, lg n is approximately only 20.).No matter how much smaller c1 is than c2 , there will always be a crossover point beyond which merge sort is faster.
