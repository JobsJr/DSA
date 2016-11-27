package com.example.algo;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CutSticks {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Integer arr[] = new Integer[n];
        for(int arr_i=0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        
        checkSticks(arr, arr.length);
        
	}
	
	private static void checkSticks(Integer [] array,int length){
		if(length==0){
			throw new IllegalArgumentException("Can't pass an empty array!");
		}
		
		Arrays.sort(array);
		int min=array[0];
		ArrayList<Integer>arrayList=new ArrayList<>(Arrays.asList(array));
		int index=0;
		while(arrayList.size()!=0 && index<arrayList.size()){
			int value=arrayList.get(index);
			if(value==0 || value < 0){
				arrayList.remove(index);
				index=0;
			}else{
				System.out.println(arrayList.size());
				arrayList.set(index, value-min);
				if(arrayList.get(index)<min && arrayList.get(index)>=0){
					min=arrayList.get(index);							
				}
				index++;
			}
			
		}
	}
	
	

}
