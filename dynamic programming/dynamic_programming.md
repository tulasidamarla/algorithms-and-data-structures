what is Dynamic Programming?
Dynamic programming is an algorithmic paradigm that solves a given complex problem by breaking into subproblems and storing the results of subproblems to avoid computing the same results again. Consider the following example.
	f(n) = f(n-1) + f(n-2), where n >=2, f(1) = 1 and f(0)=0

Note: The above equation gives us a series of numbers, which is nothing but the famous fibonacci series. i.e. {0,1,1,2,3,5,8,13,21...}

We can observe that the above series gives us a recursive function. Here is the code for that.

		public int fib(int n){
			if( n > = 0){
				if(n <=1){
					return n;
				}
			}
			return fib(n-1) + fib(n-2);
		}		
		
As we can see from above, if n <=1, we simply return n. But, if n > 1, we recursively call the fib() function to get f(n). 
*****
Note: This property where a problem has a recursive definition is called the optimal substructure property.

Let's see an example for fib(5). Here is the hierarchy of calls.
             
				 fib(5)
			     /             \
		       fib(4)                fib(3)
		     /      \                /     \
		 fib(3)      fib(2)         fib(2)    fib(1)
		/     \        /    \       /    \
	  fib(2)   fib(1)  fib(1) fib(0) fib(1) fib(0)
	  /    \
	fib(1) fib(0)

Note: The important thing to note above is that some fib() functions to calculate the same number multiple times. For ex, fib(3) substructure is calculated twice, similarly, fib(2) substructure was calculated 3 times. This is called as overlapping subproblems property.

we can observe the binary tree with depth of 5, for fib(5). So, the time complexity of the above problem is 2^n.

Note: we can reduce the time complexity, by not solving the same problem again, by remembering them. There are two ways to store the results in memory.
1)Memoization(Top-Down) : Store the results in memory whenever a problem is solved first time.
2)Tabulation(Bottom-up) : precompute the solutions in a linear fashion and store it in a table.

What is the difference between Dynamic programming algorithm and Divide and Conquer algorithm?
Both algorithms work by combining solutions to subproblems. However, In Divide and Conquer algorithm the subproblems don't overlap.

Examplea: 
Divide and conquer --> Binary search.
Dynamic programming --> Fibonacci serires.

Where to use dynamic programming?
Ans:Whenever a problem satisfies the below properties we can use dynamic programming.
1)Overlapping subproblem
2)Optimal substructure

Problem:
-------
Findout the value for fib(40) using the recursive function solution and also with Memoization and Tabulation and compare them?

Recursive function: Using recursive function, fib(40) returns the value 102334155 and it took about 700 milliseconds in my machine.

Memoization: 
1)In memoization we initialize a lookup table with all elements to say -1 or null. 
2)At each step of i, check whether value exists in the table. If it's not null, return the value.
3)If it's null, check if i satisfies the base condition i.e. n <=1.
4)If it's null and does not satisfy the base condition then split the problem into subproblems and recursively call them.

Here is the code:
	
	private int fibM(int n) {
		if (lookup[n] == -1)
	    {
	      if (n <= 1) {
	          lookup[n] = n;
	          System.out.println(lookup[n]);
	      }
	      else {
	          lookup[n] = fibM(n-1) + fibM(n-2);
	      }
	    }
	    return lookup[n];
	}
	
