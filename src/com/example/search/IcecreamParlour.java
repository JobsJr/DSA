package com.example.search;

public class IcecreamParlour {

		public static void main(String[] args) {
		    int m=4;//4;
		    int n=4;//5;
		    int [] array={1,4,5,3,2};//{1,4,5,3,2};
		    findSum(m,n,array);
		    
		  }
		  
		  
		  
		  private static void findSum(int m,int n,int []array){
		      for(int i=0;i<n-1;i++){
		        //i=0.j=0.0<0
		        for(int j=i+1;j<n;j++){
		          checkSum(i,j,m,array);  
		        }  
		        
		      }
		  
		  }
		  private static void checkSum(int start,int end,int m,int []array){
		      
		    
		    if(array[start]<m 
		       && array[end]< m 
		       && array[start]+array[end]==m){
		           start=start+1;
		           end=end+1;
		          System.out.print(start+" "+end);
		      }
		  
		  
		  }

}
