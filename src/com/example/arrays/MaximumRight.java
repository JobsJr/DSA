package com.example.arrays;

public class MaximumRight {

	public static void main(String[] args) {
		int arr[]={6, 5, 4, 3, 2, 1};
		int maxDiff=findMaxDiff(arr);
		System.out.println("Max Diff: "+maxDiff);
	}
	
	/**
	 * Naive approach
	 * TC:=O(n*n)
	 * SC=O(1)
	 * @param arr
	 * @return
	 */
	public static int findMaxDiff(int [] arr){
		int maxDiff=-1;
		
		for(int i=0;i<arr.length;i++){
			for(int j=i+1;j<arr.length;j++){
				if(arr[j]>arr[i] && (j-i)>maxDiff){
					maxDiff=j-i;
				}
			}
			
		}
		
		return maxDiff;
	}

}
