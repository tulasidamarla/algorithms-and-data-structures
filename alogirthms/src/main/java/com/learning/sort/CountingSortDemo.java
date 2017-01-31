package com.learning.sort;

import java.util.Arrays;

public class CountingSortDemo {
	
	private static final int MAX_RANGE = 1000000;
	
	public static void main(String[] args) {
		int[] array = { 20, 30, 21, 40, 61, 20,50, 55, 60, 70 };
		//int [] array = {5,3,0,2,4,1,0,5,2,3,1,4}; 
	    System.out.println("Before: " + Arrays.toString(array));
	    countingSort(array);
	    System.out.println("After:  " + Arrays.toString(array));

	}
	
	public static void countingSort( int[] arr )
    {
        int n = arr.length;
        if (n == 0)
            return;
        /** find max and min values **/
        int max = arr[0], min = arr[0];
        for (int i = 1; i < n; i++)
        {
            if (arr[i] > max)
                max = arr[i];
            if (arr[i] < min)
                min = arr[i];
        }
        int range = max - min + 1;
 
        /** check if range is small enough for count array **/
        /** else it might give out of memory exception while allocating memory for array **/
        if (range > MAX_RANGE)
        {
            System.out.println("\nError : Range too large for sort");
            return;
        }
 
        int[] count = new int[range];
        
        /** make count/frequency array for each element **/
        for (int i = 0; i < n; i++)
            count[arr[i] - min]++;
        System.out.println(Arrays.toString(count));
        
        /** modify count so that positions in final array is obtained **/
        for (int i = 1; i < range; i++)
            count[i] += count[i - 1];
        System.out.println(Arrays.toString(count));
        
        /** modify original array **/
        int j = 0;
        for (int i = 0; i < range; i++)
            while (j < count[i])
                arr[j++] = i + min;
    }

}
