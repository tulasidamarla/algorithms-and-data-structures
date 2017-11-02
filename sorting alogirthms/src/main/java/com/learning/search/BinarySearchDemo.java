package com.learning.search;

public class BinarySearchDemo {

	public static void main(String[] args) {
		int[] a = { 2, 5, 50, 60, 120,300};
		binarySearch(a,60);
	}
	
	private static boolean binarySearch(int[] a,int value){
		boolean found = false;
		int low=0;
		int high = a.length-1;
		
		while(low <= high){

			int mid=low + (high-low)/2;
			
			if(a[mid] == value){
				found = true;
				System.out.println("found " + value + " at " + mid + " position");
				return true;
			}
			
			if(a[mid] > value){
				high = mid-1;
			}
			
			if(a[mid] < value){
				low = mid+1;
			}
			
		}
		System.out.println("element not found");
		return found;
	}

}
