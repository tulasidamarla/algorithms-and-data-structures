package com.learning.sort;

import java.util.Arrays;

public class InsertionSortDemo {
	
	public static void main(String[] args) {
		int[] a = { 32, 31, 41, 59, 26, 41, 58 };
		System.out.println(Arrays.toString(insertionSort(a)));
	}

	private static int[] insertionSort(int[] a){
		for(int i=1;i<a.length;i++){
			int current = a[i];
			int insertPosition = i;
			while(insertPosition > 0 && a[insertPosition-1] > current){
				a[insertPosition] = a[insertPosition-1];
				insertPosition--;
			}
			a[insertPosition] = current;
		}
		return a;
	}
}
