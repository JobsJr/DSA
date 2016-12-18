package com.example.arrays;

import java.util.Arrays;


public class MergeArrays {

	public static void main(String[] args) {
		
		int a[]=new int [9];
		for(int i=0;i<7;i++){
			a[i]=i;
		}
		int b[]={7,8};
		
		mergeArrays(a, b);
		System.out.println(Arrays.toString(a));

	}
	
	public static void mergeArrays(int a[],int b[]){
		 int i = a.length -1;
		 int n = b.length-1;
		 int m = i-n-1;
		 
		 while(m >=0 && n >=0){
			 if(a[m] > b[n]){
				 a[i--]=a[m--];
			 }else{
				 a[i--]=b[n--];
			 }
		 }
		 
		 while(n>=0){
			 a[i--]=b[n--];
		 }
	}

}
