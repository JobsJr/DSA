package com.example.dp;

public class LCSAdjacent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	private static int LCSAdjacent(int array[]){
		
		int N=array.length;
		int []dp=new int[N];
		
		for(int i=0;i<N;i++){
			dp[i]=1;
		}
		
		for(int i=1;i<N;i++){
			for(int j=0;j<i;j++){
				if(array[i]-array[j]==1 || array[i]+array[j]==1){
					dp[i]=Math.max(dp[i],dp[j]+1);
				}
			}
		}
		return 1;
		
		
	}

}
