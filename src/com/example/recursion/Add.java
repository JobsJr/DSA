package com.example.recursion;

public class Add {

	public static void main(String[] args) {
		System.out.println(add(4,4));
	}
	
	
	public static int add (int n,int k){
		//Base case
		if(k<1){
			return k;
		}else{
			return n+add(n,k-1);
		}
	}

}
