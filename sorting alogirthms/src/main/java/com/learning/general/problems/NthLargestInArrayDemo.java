package com.learning.general.problems;

import java.util.Arrays;

public class NthLargestInArrayDemo {

	public static void main(String[] args) {
		int[] a= {9,6,0,5,4,8};
		System.out.println(findNthLargest(a,2));
		System.out.println(Arrays.toString(a));
	}
	
	public static int findNthLargest(int[] a, int n){
		int p=0;
		int r=a.length-1;
		quicksort(a,p,r,n);
		return a[a.length-n];
	}
	
	private static void quicksort(int[] a,int p, int r, int n) {
		if(p < r){
			int q=partition(a, p, r);
			if(q==a.length-n){
				return;
			}
			if(q > a.length-n){
				quicksort(a,p,q-1,n);
			}else{
				quicksort(a,q+1,r,n);
			}
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
