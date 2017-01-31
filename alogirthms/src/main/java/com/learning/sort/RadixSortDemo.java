package com.learning.sort;

import java.util.Arrays;

public class RadixSortDemo {

 
    /*Driver function to check for above function*/
    public static void main (String[] args)
    {
        int arr[] = {170, 45, 75, 90, 802, 24, 2, 66};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    
    /** Radix Sort function **/
    public static void radixSort(int[] a){
        int i, max = a[0], exp = 1, n = a.length;
        int[] b = new int[10];
        
        //find max
        for (i = 1; i < n; i++){
            if (a[i] > max)
                max = a[i];
        }

        while (max / exp > 0){
            int[] bucket = new int[10];
 
            for (i = 0; i < n; i++){
                bucket[(a[i] / exp) % 10]++;
            }
            
            for (i = 1; i < 10; i++){
                bucket[i] += bucket[i - 1];
            }

            for (i = n - 1; i >= 0; i--){
            	int index = --bucket[(a[i] / exp) % 10];
                b[index] = a[i];
            }
            
            for (i = 0; i < n; i++){
                a[i] = b[i];
            }
            
            exp *= 10;
        }
    }
}


