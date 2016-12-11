package com.example.arrays;

import java.util.Arrays;
/**
 * This moves all the zeroes to the Right & non zeroes to
 * the left
 * 
 * @author rajeevkr
 *
 */
public class MoveZeroes {

	public static void main(String[] args) {
		int arr[] = {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9};
		System.out.println("Original array "+Arrays.toString(arr));
		moveZeroes(arr);
		System.out.println("Modified array "+Arrays.toString(arr));

	}
	
	private static void moveZeroes(int arr[]){
		int nonZeroCount=0;
		
		//Reset all values if value !=0
		//from 0
		for(int i=0;i<arr.length;i++){
			if(arr[i]!=0){
				arr[nonZeroCount++]=arr[i];
			}
		}
		
		//Fill the array only with
		//0's
		while(nonZeroCount<arr.length){
			arr[nonZeroCount++]=0;
		}
		
	}

}
