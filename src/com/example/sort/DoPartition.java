package com.example.sort;

import java.util.Arrays;

public class DoPartition {

	public static void main(String[] args) {
		int [] inputArray=new int[]{23,24,25,20,19,17};
		partitionArray(inputArray);

	}
	
	private static void partitionArray(int [] array){
		
		int pivot=array[0]; //23
		int partionIndex=0;//0
		
		//0
		for(int i=partionIndex;i<array.length;i++){
			//23<=23
			if(array[i]<=pivot){
				int temp=array[i];//23,20
				array[i]=array[partionIndex];//23=23
				array[partionIndex]=temp;//23
				partionIndex++;
			}
		}
		
		int temp=pivot;
		array[0]=array[partionIndex];
		array[partionIndex]=temp;
		
		System.out.println(Arrays.toString(array));
	}

}
