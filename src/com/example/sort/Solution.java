package com.example.sort;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int key=scanner.nextInt();
		int n=scanner.nextInt();
		
		int []array=new int[n];
		for(int i=0;i<n;i++){
			array[i]=scanner.nextInt();
		}
		int index=-1;
		for(int i=0;i<n;i++){
			if(array[i]==key){
				index=i;
				break;
			}
		}
		
		System.out.println("Item foudn at: "+index);
	}

}
