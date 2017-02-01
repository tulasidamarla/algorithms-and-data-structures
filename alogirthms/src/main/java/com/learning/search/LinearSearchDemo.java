package com.learning.search;

public class LinearSearchDemo {

	public static void main(String[] args) {
		int[] a = {7,120,5,0,300,20,6,77};
		linearSearch(a,77);

	}

	private static boolean linearSearch(int[] a,int value) {
		boolean found=false;
		int index=0;
		while(index < a.length){
			if(a[index] == value){
				found = true;
				System.out.println("found " + value + " at " + index + " position");
				return found;
			}
			index++;
		}
		return found;
	}

}
