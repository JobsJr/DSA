package com.example.arrays;

import java.util.Arrays;

public class ArraySum {

	public static void main(String[] args) {
		int A[] = {1, 4, 45, 6, 10, -8};
	    int n = 16;
	    
	   // findPairs(A, n);
	    boolean isFound=findPair(A, n);
	    if(isFound){
	    	System.out.println("Found");
	    }else{
	    	System.out.println("Not found");
	    }
	}

	/**
	 * Complexity=O(n*nlogn)
	 * SC:O(1)
	 * @param array
	 * @param sum
	 */
	private static void findPairs(int[] array, int sum) {
		// 1.Sort the number
		// 2.Traverse & add each number
		// 3.Find key

		Arrays.sort(array);
		for (int i = 0; i < array.length; i++) {
			int num = sum - array[i];
			int index = Arrays.binarySearch(array, num);
			if (index >=0) {
				System.out.println("The pair is "+ i + " " + index);
				return;
			}
		}
		System.out.println("Pair not found: ");

	}
	
	
	/**
	 * Complexity=O(nLogn)(Sorting technique)
	 * SC:O(1)
	 * @param array
	 * @param sum
	 */
	private static boolean findPair(int []array,int sum){
		Arrays.sort(array);
		int start=0;
		int end=array.length-1;
		
		while(start < end){
			if(array[start]+array[end]==sum){
				return true;
			}else if(array[start]+array[end]<sum){
				start++;
			}else{
				end--;
			}
		}
		
		return false;
		
		
	}

}
