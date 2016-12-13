package com.example.arrays;

import java.util.Arrays;

public class IncreasingDecreasingSeq {

	public static void main(String[] args) {

		int arr[] = {120, 100, 80, 20, 0};
		System.out.println(find(arr));
	}
	
	private static int find(int []array){
		Arrays.sort(array);
		
		return array[array.length-1];
		
		
	}

}
