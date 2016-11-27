package com.example.sort;

public class MergeSort implements ISort{
	
	@Override
	public int[] sort(int[] inputArray) {
		mergeSort(inputArray);
		return inputArray;
	}
	
	
	private void mergeSort(int [] inputArray){		
		int sizeOfArray=inputArray.length;
		if(sizeOfArray < 2)
			return;
		int mid=sizeOfArray/2;
		int [] leftArray=new int[mid];
		int [] rightArray=new int[sizeOfArray-mid];
		
		for(int i=0;i<mid;i++){
			leftArray[i]=inputArray[i];
		}
	
		for(int j=mid;j<sizeOfArray;j++){
			rightArray[j-mid]=inputArray[j];
		}
		mergeSort(leftArray);
		mergeSort(rightArray);
		merge(inputArray, leftArray, rightArray);
		
	}
	
	private void merge(int [] a,int []left,int [] right){
		int nl=left.length;
		int nR=right.length;
		
		int i=0;
		int j=0;
		int k=0;
		
		//Keep replacing the array until one of the 
		//array(L or I),is completed
		while(i<nl && j<nR ){
			if(left[i]<=right[j]){
				a[k]=left[i];
				k++;
				i++;
			}else{
				a[k]=right[j];
				k++;
				j++;
			}
		}
		
		//If Right is completed first,fill all
		//the elements in left in to main array
		while(i<nl){
			a[k]=left[i];
			i++;
			k++;
		}
		
		while(j<nR){
			a[k]=right[j];
			j++;
			k++;
		}
	}

}
