package com.example.dp;
/**
 * Given a matrix of integers where every element represents weight of the cell. Find the path having the maximum weight in matrix [N X N]. Path Traversal Rules are:
	It should begin from top left element.The path can end at any element of last row.We can move to following two cells from a cell (i, j).
		Down Move : (i+1, j)
		Diagonal Move : (i+1, j+1)
	
 * @author rajeevkr
 *
 */
public class MaxCost {

	public static void main(String[] args) {
		int mat[][] = {  { 4, 1 ,5 ,6 , 1 },
		        { 2 ,9 ,2 ,11 ,10 },
		        { 15,1 ,3 ,15, 2 },
		        { 16, 92, 41,4,3},
		        { 8, 142, 6, 4, 8 }
		    };
		    int N = 5;
		    System.out.println("Cost:= "+findMaxCost(mat));
	}
	
	public static int findMaxCost(int [][]matrix){
		int result=0;
		int N=(int)Math.sqrt(matrix.length);
		//Let dp[m][n] be the one to keep track of the maximum cost of i,j pair
		int dp[][]=new int[N][N];
		
	    dp[0][0] = matrix[0][0];

		
		
		for(int row=0;row<N;row++){
			for(int col=0;col<N;col++){
				//Top-left element
				if(row==0 && col==0){
					dp[row][col]=matrix[row][col];
				}
				
				//0th row,1st col
				if(col==0 && row!=0){
					dp[row][col]=dp[row-1][col];
				}else if(row!=0 && col!=0){//any random row,col but only down or diagonal
					dp[row][col]=Math.max(dp[row-1][col],dp[row-1][col-1]);
				}
			}
		}
		
		for(int i=0;i<N;i++){
			if(result<dp[N-1][i]){
				result=dp[N-1][i];
			}
		}
		return result;
		
		
		
		
	}
	
	

}
