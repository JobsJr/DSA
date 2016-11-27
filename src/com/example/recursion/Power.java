package com.example.recursion;

public class Power {

	public static void main(String[] args) {

		System.out.println(pow(3, 4));
	}
	
	public static int pow(int num,int pow){
		if(pow==1)
			return num;
		else
			return num*pow(num,pow-1);
	}

}
