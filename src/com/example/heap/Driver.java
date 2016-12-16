package com.example.heap;

import java.util.Arrays;

public class Driver {

	public static void main(String[] args) {
		int [] array={6,5,3,1,8,7,2,4};
		Heap heap=new Heap(array.length, 0);
		System.out.println("Before Sorting: "+Arrays.toString(array));
		
		heap.heapSort(array);
		System.out.println("After sorting: "+Arrays.toString(array));
	}

}
