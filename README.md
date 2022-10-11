DATA STRUCTURES
-
- Particular way of storing and organizing data in a computer so that it can be used efficiently
- Facilitates access and modifications
- Types
    - Linear (accessed in sequential order, may or may not be stored in sequential memory locations)
      Eg: Linked Lists, Stacks, Queues, Arrays**
    - Non-Linear (Stored/accessed in non-linear order)
      Eg: Trees, Graphs

**Arrays cannot be created manually. They are created automatically by the programming language.

Abstract data types (ADT's)
- 
User-defined data types that are defined along with their operations
- Primitive data types support basic operations such as addition and subtraction. System provides implementations for these.
- For ADT the operations have to be defined explicitly.
- ADT describes certain operations that can be done on the data itself
- It is called "Abstract" because it gives an implementation-independent view
- Examples :: Data type and few operations
    - Stack
      -   isFull()
      -   isEmpty() 
    - Queue 
      - insert() 
      - delete()
    - List 
      - size() 
      - get(i)
- The user or client of the ADT needs to know about the method interfaces such as names of the methods, types of parameters and what are the values returned, not the actual implementation.

ALGORITHMS
- 
- An algorithm is the step-by-step unambiguous instructions to solve a given problem.
- Main Criteria to judge the merits of algorithm
    - Correctness (solution in finite number of steps)
    - Efficiency (limited resources to execute)
- <ins><b>Analysis of Algorithms</b></ins>
    - Amongst the various solutions possible, algorithm analysis helps determine the most efficient algorithm in terms of time and space consumed
    - Goal is to compare algorithms in terms of various factors (such as running time, memory, developer effort etc)
- <ins><b>Running Time Analysis</b></ins>
    - Process of determining how the running time increases as input size increases

<i>Note: Common types of input :: Size of array, Polynominal degree, Number of elements in a matrix, Vertices and indicies of the graph, Number of bits in input</i>

- <ins><b>Comparison of algorithms</b></ins>
    - Express running time of any algorithm as function of input size and compare them
    - Other comparison methods (not to be used)
        - Execution time : as these are specific to computer
        - Number of statements executed : as this is specific to the programming language

<img src="algorithms/growth_rate.png" alt="Growth Rate" align="middle" width="70%">

- <ins><b>Analysis of an algorithm</b></ins>
    - For which inputs algorithm takes least amount of time to run (Best case)
    - For which inputs algorithm takes longest amount of time to run (worst case)
    - For random inputs random running time of algorithm (Average case)
      <b>Lower Bound <= Average Time <= Upper Bound </b>

- <ins><b>Asymptotic Notation</b></ins>
    - Syntax for representing upper and lower bounds
    - Upper and lower bounds need to be identified for best, worst and average cases
    - "Asymptotic" means approaching a value or curve arbitrarily closely

    - <ins><b>Big O Notation (upper bound function)</ins></b>
        - If f(n) denotes the running time(time complexity) of an algorithm , then O(g(n)) = f(n), there exists positive constants c and n0 such that 0 <= f(n) <= cg(n), for all n >= n0.

    - <i> Example </i>  
      
      f(n) = 3n + 2  
      3n + 2 <= cn (This condition will be satisfied if c >= 4, we choose 4 because that is closest)  
      3n + 2 <= 4n  
      n >= 2  

    - Constant c is 4 and n0 is 2, which implies function 4n is always greater than 3n+2 when n >= 2.
    - <i>Conclusion</i> f(n) is always lessthan some constant multiplied by g(n), which describes upper bound of f(n).
   
   - <ins><b>Big Omega  Notation Ω(lower bound function)</ins></b>
        - If f(n) denotes the time complexity of an algorithm, then Ω(g(n)) = f(n), there exists positive constants c and n0 such that 0 <= cg(n) <= f(n), for all n >= n0.
        - At larger values of n, the tighter lower bound of f(n) is g(n). For example, if f(n) = 100n<sup>2</sup> + 10n + 50, 	g(n) is Ω(n<sup>2</sup>).

      <i>Example</i>

      f(n) = 3n+2  
      3n + 2 >= cn (This condition will be satisfied if c = 3)  
      3n + 2 >= 3n (This condition will be satisfied for all n values >= 1)

       - If c=3 and n0 = 1, all the conditions are satisfied for Big omega. i.e. f(n) = Ω(g(n))

    - <i>Conclusion</i> f(n) is always greater than some constant multiplied by g(n), which describes lower bound of f(n).
    
  - <ins><b> Big Theta Notation (Order Function) </ins></b>
    - If f(n) denotes the time complexity of an algorithm, then θ(g(n)) = f(n), there exists positive constants c1,c2,n0 such that 0 <= c1g(n) <= f(n) <= c2g(n), for all n >= n0.
    - Big theta is combination of Big oh and omega, but the function should satisfy the condition n >= n0.
    - From the above examples for f(n) = 3n+2, n0=2 for Big oh where as n0=1 for Big omega.

      c1*n <= 3n + 2 <= c2*n, for all n > n0    
      Solution 1 :: keep n0 as 1,but make c2 = 5, c1=3  
      solution 2 :: n0 = 2, c1=3 and c2=4

<img src="algorithms/big_oh.PNG" alt="Big Oh" align="middle" width="30%"><img src="algorithms/big_omega.PNG" alt="Big Omega" align="middle" width="30%">
<img src="algorithms/big_theta.PNG" alt="Big Theta" align="middle" width="30%">
<br>
<span style="display:inline-block;margin-right: 150px;" width="200px">Big Oh</span>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
<span style="display:inline-block;margin-right: 150px;" width="200px">Big Omega</span>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<span style="display:inline-block;" width="200px">Big Theta</span>

- <b><i>Note</b></i>  
  - Big oh is used to find the worst case. In any scenario performance can't be worst than this for any value of n.  
  - Big omega is used to find the best case. In any scenario performance can't be better than this for any value of n.  
  - Big theta gives average case.  
  - In practice Big omega is not very much useful. Big oh is used to find the worst case scenarios.

- <b><i>Example</i></b><br>
  - int[] array= {5,7,3,2,1,8,9};<br>
  - Finding an element from the array has best, worst and average cases possible.   
  - For ex searching element 5, is found in the first attempt, which is the best case. It is represented as Ω(1)  
  - For ex searching for element 9, requires scan of the entire array, which is the worst case. It is represented as O(n).  
  - For average case it is θ(n/2), which is θ(n) 

<a href="algorithms/1.asymptotic_notations.md">Next: asymptotic notations</a>

