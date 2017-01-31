package com.learning.sort;

import java.util.Arrays;

/**
 * Shell sort was invented by Donald Shell. It is an improved version of insertion sort.
 * Shell sort is also known as n-gap insertion sort. In insertion sort comparisons are made
 * between adjacent elements. The basic idea in shell sort is to exchange every hth element.
 * For ex, if h is 4, then exchange 1st element with 4th, 2nd with 5th and so on.
 * 
 * Shell sort works by starting with big enough h(but not larger than size of the array) value
 * and allow exchanges that are h distance apart. This array can be called h-sorted. The next step
 * is to reduce h by certain sequence and again perform another complete h-sort. Last sequence for h
 * is always 1. i.e. insertion sort, except by this time array is already well formed and easier to sort.
 * 
 * Time complexity Worst case is O(nloglogn). Best case is O(n). Average case depends on gap sequnce.
 * Space complexity Worst case is O(n)
 * 
 * @author damart1
 *
 */
public class ShellSortDemo {

	public static void main(String[] args) {
		int [] array = {5,3,0,2,4,1,0,5,2,3,1,4}; 
	    System.out.println("Before: " + Arrays.toString(array));
	    shellSort(array);
	    System.out.println("After:  " + Arrays.toString(array));

	}
	
	public static void shellSort(int[] array) {
	    int inner, outer;
	    int temp;
	 
	    int h =0;
	    /**
	     * create sequence of your choice.In this case 1, 4, 13, 30 so on.
	     * * */
	    while (h <= array.length) {
	      h = h * 3 + 1;
	    }
	    
	    /**
	     * h-sort sequences have to be run in reverse order.
	     * 
	     * In the sequence created above, it should be 4 - sorted, then 1-sorted
	     * 
	     * 13-sorted won't work because it more than size of the array
	     * 
	     * */
	    while (h > 0) {
	    	outer = h;
	      while (outer < array.length) {
	    	temp = array[outer];
	        inner = outer;
	        while (inner > h - 1 && array[inner - h] >= temp) {
	          array[inner] = array[inner - h];
	          inner -= h;
	        }
	        array[inner] = temp;
	        outer++;
	      }
	      h = (h - 1) / 3;
	      System.out.println(Arrays.toString(array));
	    }
	  }
}
