package com.example.bitmanipulation;

public class SwapOddEvenBits {

	public static void main(String[] args) {
		long input=23;
		System.out.println("Before Swappping: "+Long.toBinaryString(input));
		
		System.out.println("After Swapping : "+Long.toBinaryString(swapBits(input)));
		
	}
	
	private static long swapBits(long n){
		long evenBits=n & 0xAAAAAAAA;//Get all bits at even pos
		long oddBits=n & 0x55555555;	//Get all bits at odd pos


		evenBits>>=1;
		oddBits<<=1;


		return (evenBits|oddBits);
	}


}
