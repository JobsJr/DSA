package com.example.dp;

import java.util.Arrays;

public class LCSDifference {

	public static void main(String[] args) {

		int arr[] = {10, 9, 4, 5, 4, 8, 6};
		System.out.println(lcdDiffernce(arr,arr.length));
		
	}
	
	
	private static int lcdDiffernce(int [] arr,int n){
		// Initialize the dp[] array with 1 as a
	    // single element will be of 1 length
	    int dp[]=new int[n];
	    for (int i = 0; i< n; i++)
	        dp[i] = 1;
	 
	    // Start traversing the given array
	    for (int i=1; i<n; i++)
	    {
	        // Compare with all the previous elements
	        for (int j=0; j<i; j++)
	        {
	            // If the element is consecutive then
	            // consider this subsequence and update
	            // dp[i] if required.
	            if ((arr[i] == arr[j]+1) ||
	                (arr[i] == arr[j]-1))
	 
	                dp[i] = Math.max(dp[i], dp[j]+1);
	        }
	    }
	 
	    // Longest length will be the maximum value
	    // of dp array.
	    int result = 1;
	    for (int i = 0 ; i < n ; i++)
	        if (result < dp[i])
	            result = dp[i];
	    return result;
	}

}
