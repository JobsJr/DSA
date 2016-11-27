package com.example.sort;

import java.util.Arrays;

public class Driver {

	public static void main(String[] args) {
		int [] inputArray=new int[]{1,2,5,6,7,8,1,3,4,51};
		
//		ISort sortType=new BubbleSort();//bubble sort
		
		
		//ISort sortType=new SelectionSort();//Selection sort
		
		//ISort sortType=new InsertionSort();//Insertion sort
		
		//ISort sortType=new QuickSort(); //Quicksort
		ISort sortType=new MergeSort();
		sortType.sort(inputArray);
		
		System.out.println(Arrays.toString(inputArray));
		
	}

}
