package com.example.sort;

public class QuickSort implements ISort{

	@Override
	public int[] sort(int[] inputArray) {
		 quickSort(inputArray, 0, inputArray.length-1);
		 return inputArray;
	}
	
	
	private static void quickSort(int[] a,int start,int end){
		if(start >= end ) return;
		int partitionIndex=partition(a, start, end);
		quickSort(a, start, partitionIndex-1);
		quickSort(a, partitionIndex+1, end);
	}
	
	/**
	 * This logic is simple,
	 * 1.Consider an element as Pivot,in our case,it is the rightmost element
	 * 2.So,have an index in array such that,all the elements less then pivot are on
	 * left side of it & rest,right side(iterate,compare with pivot,swap & change pivot)
	 * 3.Swap items at pivot index & partition index
	 * 
	 * @param a
	 * @param start
	 * @param end
	 * @return partitionIndex
	 */
	
	private static int partition(int [] a,int start,int end){
		//Take a pivot,say,rightmost of the array
		int pivot=a[end];
		
		//Take partionIndex,in the beginning,start
		int partitionIndex=start;
		
		for(int i=start;i<end;i++){
			//element @ i is <pivot,then swap it with the 
			//the element @ partition index & increment partition index
			
			if(a[i]<=pivot){
				int temp=a[i];
				a[i]=a[partitionIndex];
				a[partitionIndex]=temp;
				partitionIndex++;
			}
		}
		
		//Swap Pivot & Partition index
		int temp=end;
		a[end]=a[partitionIndex];
		a[partitionIndex]=a[temp];
		return partitionIndex;
		
	}

}
