package com.learning.general.problems;

public class NumberReverseDemo {
	
	public static void main(String[] args) {
		System.out.println(reverse(34751));
	}
	
	public static int reverse(int a){
		int exp=1;
		int reverse=0;
		while(a/exp > 0){
			reverse*=10;
			reverse += ((a/exp)%10);
			exp*=10;
			
		}
		return reverse;
	}

}
