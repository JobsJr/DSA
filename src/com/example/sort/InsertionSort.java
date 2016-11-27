package com.example.sort;

public class InsertionSort implements ISort{

	@Override
	public int[] sort(int[] inputArray) {
		if(inputArray==null && inputArray.length==0){
			throw new IllegalArgumentException("Wrong argument passed!!");
		}
		int holeIndex=0;
		int value=-1;
		for(int i=1;i<inputArray.length;i++ ){
			holeIndex=i;
			value=inputArray[i];
			while(holeIndex>0 && inputArray[holeIndex-1]>value){
				inputArray[holeIndex]=inputArray[holeIndex-1];
				holeIndex--;
			}
			
			inputArray[holeIndex]=value;
		}
		return inputArray;
	}
}
