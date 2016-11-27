package com.example.algo;

import java.util.Scanner;

public class Warmup1 {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int a0=scanner.nextInt();
		int a1=scanner.nextInt();
		int a2=scanner.nextInt();
		int b0=scanner.nextInt();
		int b1=scanner.nextInt();
		int b2=scanner.nextInt();
		
		int a[]= new int []{a0,a1,a2};
		int b[]=new int []{b0,b1,b2};
		
		printScores(a, b, 3);
	}
	
	public static void printScores(int a[],int b[],int len){
		int scoreA=0;
		int scoreB=0;
		
		for(int i=0;i<len;i++){
			if(a[i]>b[i]) scoreA++;
			else if(a[i]<b[i]) scoreB++;
		}
		
		System.out.println(scoreA+" "+scoreB);
	}

}
