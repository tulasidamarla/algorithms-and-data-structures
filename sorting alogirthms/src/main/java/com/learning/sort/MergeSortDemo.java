package com.learning.sort;

import java.util.Arrays;

public class MergeSortDemo {

	public static void main(String[] args) {
		int[] array = { 30, 70, 7, 10, 45, 90, 50,33,20, 110, 35, 120, 65, 15 };
		mergeSort(array);
		System.out.println(Arrays.toString(array));
	}
	
	private static void mergeSort(int[] list) {
		if (list.length <= 1) {
			return;
		}

		// Split the array in half
		int[] left = new int[list.length / 2];
		int[] right = new int[list.length - left.length];
		
		// copy left array
		for (int i = 0; i < left.length; i++) {
			left[i] = list[i];
		}
		// copy right array
		for (int i = 0; i < right.length; i++) {
			right[i] = list[i + left.length];
		}

		// Sort each half
		mergeSort(left);
		mergeSort(right);

		// Merge the halves together, overwriting the original array
		merge(left, right, list); // 
		
	}

	private static void merge(int[] left, int[] right, int[] result) {

		// Merge both halves into the result array
		// Next element to consider in the first array
		int indexLeft = 0;
		// Next element to consider in the second array
		int indexRight = 0;

		// Next open position in the result
		int j = 0;

		// As long as neither indexFirst nor indexSecond is past the end, move
		// the smaller element into the result.
		while (indexLeft < left.length && indexRight < right.length) { 
			if (left[indexLeft] < right[indexRight]) {
				result[j] = left[indexLeft];
				indexLeft++;
			} else {
				result[j] = right[indexRight];
				indexRight++;
			}
			j++;
		}

		// copy what's remaining
		while(indexLeft < left.length){
			result[j] = left[indexLeft];
			indexLeft++;
			j++;
		}
		while(indexRight < right.length){
			result[j] = right[indexRight];
			indexRight++;
			j++;
		}
	}
	
	
}
