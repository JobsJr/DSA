package com.example.arrays;

import java.util.Arrays;

public class LowestDifference {

	public static void main(String[] args) {

		int a[]={1,3,15,11,2};
		int b[]={23,127,235,19,8};
		
		int result=findMinimimDiff(a, b);
		System.out.println("Minmum Diff:= "+result);
	}

	
	public static int findMinimimDiff(int a[],int b[]){
		
		Arrays.sort(a);
		Arrays.sort(b);
		
		int l=0;
		int m=0;
		int differance=Integer.MAX_VALUE;
		while(l<a.length && m < b.length){
			int tempDiff=Math.abs(a[l]-b[m]);
			if(tempDiff<differance){
				differance=tempDiff;
			}
			
			//Move smaller one
			if(a[l]<=b[m]){
				l++;
			}else{
				m++;
			}
		}
		return differance;
	}
}
