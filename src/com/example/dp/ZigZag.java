package com.example.dp;

public class ZigZag {

	public static void main(String[] args) {
		int A[]={1,7,4,9,2,5};
		System.out.println(longestZigzagSubsequence(A, A.length));
	}
	
	private static int longestZigzagSubsequence(int A[], int n)
	{
		 int Table[][]=new int[n][2];
		 
		    for (int i=0; i<n; i++){
		    	Table[i][0] = 1; 
		    	Table[i][1] = 1;
		    }
		 
		    int result = 1;
		 
		    for (int i=1; i<n; i++) {
		        for (int j=0; j<i; j++){
		        	// If A[i] is greater than last element in subsequence, 
		        	//then check with Table[j][1]
		        	if (A[j] < A[i] && Table[i][0] < Table[j][1] + 1)
		        		Table[i][0] = Table[j][1] + 1;
		 
		            // If A[i] is smaller than last element in subsequence, 
		            //then check with Table[j][0]
		            if( A[j] > A[i] && Table[i][1] < Table[j][0] + 1)
		                Table[i][1] = Table[j][0] + 1;
		        }
		 
		        /* Pick maximum of both values at index i  */
		        if (result < Math.max(Table[i][0], Table[i][1]))
		            result = Math.max(Table[i][0], Table[i][1]);
		    }
		 
		    return result;
	   
	}

}
