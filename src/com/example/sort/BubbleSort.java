package com.example.sort;

public class BubbleSort implements ISort {
	

	@Override
	public int[] sort(int[] inputArray) {
		int length=inputArray.length;
		if(length==0){
			throw new IllegalArgumentException("Array Can't be null");
		}
		
		for(int steps=1;steps<=length-1;steps++){
			for(int index=0;index<=length-steps-1;index++){
				if(inputArray[index]>inputArray[index+1]){
					int temp=inputArray[index];
					inputArray[index]=inputArray[index+1];
					inputArray[index+1]=temp;
				}
					
			}
		}
		return inputArray;
	}
	


}
