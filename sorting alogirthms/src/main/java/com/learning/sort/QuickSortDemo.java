package com.learning.sort;

import java.util.Arrays;

public class QuickSortDemo {

	public static void main(String[] args) {

		int[] array = { 30, 70, 7, 10, 45, 90, 50,33,20, 110, 35, 120, 65, 15 };
		int p=0;
		int r=array.length-1;

		quicksort(array,p,r);
		System.out.println(Arrays.toString(array));
	}

	private static void quicksort(int[] a,int p, int r) {
		if(p < r){
			int q=partition(a, p, r);
			quicksort(a,p,q-1);
			quicksort(a,q+1,r);
		}
	}
	
	private static int partition(int[] a, int p, int r){
		int x=a[r];
		int i=p-1;
		int j = p;
		while(j < r){
			if(a[j] < x ){
				i++;
				exchangeNumbers(a, i, j);
			}
			j++;
		}
		//exchange a[i+1] with a[r]
		exchangeNumbers(a, i+1, r);
		return i+1;
	}
	
	private static void exchangeNumbers(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
