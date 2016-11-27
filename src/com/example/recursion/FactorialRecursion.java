package com.example.recursion;

public class FactorialRecursion {

	public static void main(String[] args) {
		System.out.println(factorial(4));//4x3x2x1=24
	}
	
	public static int factorial(int n){
		if(n!=1 || n!=0){
			return n*factorial(n-1);
		}else{
			return 1;
		}
	}

}
