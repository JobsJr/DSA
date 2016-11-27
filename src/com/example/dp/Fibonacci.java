package com.example.dp;

import java.util.ArrayList;

/**
 * Fibonacii Series using DP
 * @author rajeevkr
 *
 */
public class Fibonacci {

	public static void main(String[] args) {
		fib(7);
	}
	
	public static void fib(int n){
		ArrayList<Integer>fibList=new ArrayList<Integer>();
		fibList.add(1);//fib(0)=1
		fibList.add(1);//fib(1)=1
		
		for(int i=2;i<n;i++){
			fibList.add(fibList.get(i-1)+fibList.get(i-2));
		}
		
		System.out.println(fibList.toString());
	}

}
