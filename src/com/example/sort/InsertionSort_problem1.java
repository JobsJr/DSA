package com.example.sort;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort_problem1 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int length=sc.nextInt();
		int [] input=new int [length];
		for(int i=0;i<length;i++){
			input[i]=sc.nextInt();
		}
		
//		insertionSort(input);
		insertionSort_variation(input);
	}
	
	
	private static void insertionSort(int []array){
		int length=array.length;
		int hole=length-1;
		int value=array[hole];
		
		while(hole > 0 && array[hole-1]>value){
			array[hole]=array[hole-1];
			hole--;
			System.out.println(Arrays.toString(array));
		}
		array[hole]=value;
		
		System.out.println(Arrays.toString(array));
		
		
		
	}
	
	private static void insertionSort_variation(int []array){
		
		int length=array.length;
		int numOfShifts=0;
		
		for(int i=1;i<length;i++){
			int hole=i;
			int value=array[hole];
			
			while(hole > 0 && array[hole-1]>value){
				array[hole]=array[hole-1];
				hole--;
				numOfShifts++;
			}
			array[hole]=value;
			System.out.println(Arrays.toString(array));

		}
		System.out.println(numOfShifts);


	}


}
