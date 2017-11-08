package com.learning.dynamicprogramming;

public class OverlappingSubProblemApp {
	
	int lookup[] = null;

	public static void main(String[] args) {
		long startTime=System.currentTimeMillis();
		System.out.println(fib(40));
		long endTime = System.currentTimeMillis();
		System.out.println((endTime-startTime));
		OverlappingSubProblemApp fibMemoization = new OverlappingSubProblemApp();
		
		fibMemoization.lookup = new int[41];
		for(int i=0; i < fibMemoization.lookup.length; i++) {
			fibMemoization.lookup[i]=-1;
		}
		
		startTime=System.currentTimeMillis();
		System.out.println(fibMemoization.fibM(40));
		endTime=System.currentTimeMillis();
		System.out.println(endTime-startTime);
		
	}

	private static int fib(int n){
		if( n >= 0){
			if(n <= 1){
				return n;
			}
		}
		return fib(n-1) + fib(n-2);
	}
	
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
}
