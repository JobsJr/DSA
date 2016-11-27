package com.example.search;

public class SherlocksArray {

	public static void main(String[] args) {
		int [] array={1,2,3};
	    if(checkSum(array)){
	      System.out.print("YES");
	    }else{
	            System.out.print("NO");
	    }
	   
	  }
	  
	  
	  
	  
	  private static boolean  checkSum(int [] array){
	      int n=array.length;
	    
	      for(int i=1;i<=n-2;i++){
	        
	        int leftStart=0;//0
	        int leftEnd=i-1;//1-1=0
	        
	        int rightStart=i+1;//1+1=2
	        int rightEnd=n-1;//4-1=3
	        
	        if(findSum(leftStart,leftEnd,array)==findSum(rightStart,rightEnd,array)){
	            return true;
	        }
	      
	      }
	      return false;
	  }
	  
	  
	  
	  private static int findSum(int start,int end,int [] array){
	      int sum=0;
	      for(int i=start;i<=end;i++){
	        sum+=array[i];
	      }
	    
	      return sum;
	  }

}
