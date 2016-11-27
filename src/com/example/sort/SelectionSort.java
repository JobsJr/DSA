package com.example.sort;

public class SelectionSort implements ISort{

	@Override
	public int[] sort(int[] inputArray) {
		int length=inputArray.length;
		
		if(length==0){
			throw new IllegalArgumentException("Can't pass null!!");
		}
		int min=0;
		
		for(int i=0;i<length;i++){
			min=i;
			for(int j=i+1;j<length;j++){
				if(inputArray[j]<inputArray[min]){
					min=j;
				}
			}
			
			//Swap
			int temp=inputArray[i];
			inputArray[i]=inputArray[min];
			inputArray[min]=temp;
			
		}
		return null;
	}

}
