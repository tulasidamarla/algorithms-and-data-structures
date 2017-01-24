package com.learning.sort;

import java.util.Arrays;

/**
 * @author damart1
 *
 */
public class BubbleSortDemo {

	public static void main(String[] args) {
		int[] original = { 20, 30, 21, 40, 61, 50, 55, 60, 70 };
		System.out.println("unsorted list " + Arrays.toString(original));
		
		bubblesort(original);
		
		System.out.println("sorted list " + Arrays.toString(original));
		
		bubblesort(original);
		
		

	}
	
	
	/**
	 * Bubble sort is the simplest sorting algorithm. It works by iterating the input array from first element to the last element
	 * comparing each pair of elements and swapping them if needed.
	 * 
	 * In 1st iteration it moves the biggest element and moves it to end, in 2nd iteration it takes 2nd biggest and moves to second last.
	 * It continues until the end of all elements.
	 * 
	 * swapped variable is used to findout if the list is already sorted. Incase if the list is already sorted, then time complexity is O(n).
	 * 
	 * Time complexity is O(n^2) where as space complexity. 
	 * Space complexity is O(1) because it is not using any space.
	 * @param arr
	 */
	public static void bubblesort(int[] arr){
		int len = arr.length;
		boolean swapped = true;
		for(int i=len-1; i >= 0 && swapped ; i--){
			swapped = false;
			for(int j=0; j<= i-1; j++){
				if(arr[j] > arr[j+1]){
					exchange(arr, j, j+1);
					swapped=true;
				}
			}
			if(swapped == false){
				System.out.println("list is already sorted");
			}
		}
	}
	
	private static void exchange(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	

}
