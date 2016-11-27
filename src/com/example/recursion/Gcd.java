package com.example.recursion;

public class Gcd {

	public static void main(String[] args) {
		System.out.println(getGCD(5, 2, true)); // 1
		System.out.println(getGCD(100, 10, true)); // 10

	}
	
	public static int getGCD(int n,int k,boolean isRecursive){
			if(!isRecursive)
			return getIterativeGcd(n, k);
			else
				return getRecursiveGcd(n, k);
		
	}

	private static int getIterativeGcd(int n, int k) {
		int gcd=1;
		int r=0;
		if(n<k){
			int temp=n;
			n=k;
			k=temp;
		}
		 while(k!=0){
			 r=n%k;
			 n=k;
			 k=r;
		 }
		 
		 return n;

	}
	
	
	public static int getRecursiveGcd(int n,int k){
		//Recursive case
		if(k!=0){
			return getRecursiveGcd(k,n%k);
		}else{
			return n;
		}
	}
	
	

}
