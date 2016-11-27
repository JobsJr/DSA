package com.example.recursion;

public class PascalsTriangle {

	public static void main(String[] args) {
		print(4);
	}

	
	public static void print(int numOfRows){
		for(int i=0;i<numOfRows;i++){
			for(int j=0;j<=i;j++){
				System.out.print(""+factorial(i)/(factorial(j)*factorial(i-j)));
				System.out.print(" ");
			}
			System.out.println("");
		}
		
	}
	
	public static int factorial(int n){
		if(n==0) return 1;
		else return factorial(n-1)*n;
	}
	
}
