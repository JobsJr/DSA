package com.example.dp;

public class LCS {

	public static void main(String[] args) {
		String str1 = "ABCDGHLQR";
        String str2 = "AEDPHR";
        
        //System.out.println(LCSIterative(str1.toCharArray(), str2.toCharArray()));
        System.out.println(LCSRecursive(str1.toCharArray(), str2.toCharArray(), str1.length(), str2.length()));

	}
	
	
	public static int  LCSIterative(char[] s1,char[] s2){
		
		int max=0;
		
		int [][]maxArray=new int [s1.length+1][s2.length+1];
		for(int i=1;i<maxArray.length;i++){
			for(int j=1;j<maxArray[i].length;j++){
				if(s1[i-1]==s2[j-1]){
					maxArray[i][j]=1+maxArray[i-1][j-1];
				}else{
					maxArray[i][j]=Math.max(maxArray[i][j-1], maxArray[i-1][j]);
				}
				if(max <maxArray[i][j]){
					max=maxArray[i][j];
				}
			}
		}
		
		return max;
	}
	
	
	public static int LCSRecursive(char [] s1,char [] s2,int i,int j){
			
		if(i==0||j==0){
			return 0;
		}
		
		if(s1[i-1]==s2[j-1]){
			return 1+LCSRecursive(s1, s2, i-1, j-1);
		}else{
			return Math.max(LCSRecursive(s1, s2, i, j-1), LCSRecursive(s1, s2, i-1, j));
		}
		
	}

}
