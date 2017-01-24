package com.learning.sort;

import java.util.Arrays;

public class HeapSortDemo {

	public static void main(String[] args) {

/*		int[] arr = { 20, 30, 21, 40, 61, 50, 55, 60, 70 };

		System.out.println("original" + Arrays.toString(arr));
		buildMaxHeap(arr);
		System.out.println("max heap" + Arrays.toString(arr));
		int[] remaining = deleteMaximum(arr);
		System.out.println(" after delete max new max heap is " + Arrays.toString(remaining));
		increaseValue(remaining, 5, 70);
		System.out.println(" after increase new max heap is " + Arrays.toString(remaining));
*/		
		int[] original = { 20, 30, 21, 40, 61, 50, 55, 60, 70 };
		System.out.println("unsorted list " + Arrays.toString(original));
		buildMaxHeap(original);
		System.out.println("max heapified list " + Arrays.toString(original));
		heapsort(original);
		System.out.println("sorted list " + Arrays.toString(original));
	}
	
	public static void heapsort(int[] unsorted){
		buildMaxHeap(unsorted);
		int size = unsorted.length-1;
		for(int i= size; i > 0 ; i--){
			exchange(unsorted, 0, i);
			size--;
			maxHeapify(unsorted, 0,size);
		}
	}

	public static void buildMaxHeap(int[] arr) {
		// From last non leaf to the root of the tree call maxHeapify
		for (int i = arr.length / 2; i >= 0; i--) {
			maxHeapify(arr, i, arr.length);
		}
	}

	public static void maxHeapify(int[] a, int i, int n) {

		int leftindex = 2 * i + 1;
		int rightindex = 2 * i + 2;
		int largeindex;

		if (leftindex < n && a[leftindex] > a[i]) {
			largeindex = leftindex;
		} else {
			largeindex = i;
		}

		if (rightindex < n && a[rightindex] > a[largeindex]) {
			largeindex = rightindex;
		}

		if (largeindex != i) {
			exchange(a, i, largeindex);
			maxHeapify(a, largeindex,n);
		}

	}
	

	private static void exchange(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	private static int[] deleteMaximum(int[] a) {
		int[] arr={};
		if (a.length > 0) {
			int max = a[0];
			exchange(a, 0, a.length-1);
			arr = Arrays.copyOfRange(a, 0, a.length-1);
			System.out.println("deleted max element i.e." + max);
		}
		System.out.println("new array after deletion " + Arrays.toString(arr));
		maxHeapify(arr, 0,a.length);
		return arr;
	}
	
	private static void increaseValue(int[] a, int index, int value){
		if(value < a[index]){
			return;
		}
		a[index] = value;
		int parent = index/2;
		while( index > 1 && a[parent] < a[index]){
			exchange(a, index, parent);
			index = parent;
			parent = (index-1)/2;
		}
	}

}
