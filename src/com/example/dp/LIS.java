package com.example.dp;

import java.util.Arrays;

public class LIS {

	public static void main(String[] args) {
		int []array={ 10, 22, 9, 33, 21, 50, 41, 60 };
		System.out.println("Length: "+lcs(array));
		
		
	}
	
	/**
	 * This works on the basic principle that
	 * Lets say ,L(S) is the array of longest inc subsequence
	 * If Li is the longest seq till index i & a[i] is a part of it then
	 * 		li=max(lj)+1 where j<i,arra[j]<array[i]
	 * More explaination:
	 * http://www.geeksforgeeks.org/dynamic-programming-set-3-longest-increasing-subsequence/
	 * https://www.youtube.com/watch?v=CE2b_-XfVDk
	 * @param array
	 * @return
	 */
	public static int lcs(int []array){
		if(array==null){
			throw new IllegalArgumentException("Cant! have a null array");
		}
		
		if(array.length<=1){
			return 1;
		}
		
		//Intialize length array,which has the length,li
		//of increasing sequences at index i
		
		int []lsArray=new int [array.length];
		
		for(int i=0;i<lsArray.length;i++){
			lsArray[i]=1;
		}
		for(int i=1;i<array.length;i++){
			for(int j=0;j<i;j++){
				if(array[i]>array[j] && lsArray[i]<lsArray[j]+1){
					lsArray[i]=lsArray[j]+1;
				}
			}
		}
		
		Arrays.sort(lsArray);
		
		return lsArray[lsArray.length-1];
		
		
		
	}

}
