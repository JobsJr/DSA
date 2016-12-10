package com.example.bitmanipulation;

public class BinarySum {
	private static final int NUMBER_SYSTEM_BINARY=2;
	
	public static void main(String[] args) {
		String a="100011";
		String b="100100";
		
		System.out.println("Sum = "+binarySum(a, b));
		
	}
	
	private static String binarySum(String x,String y){
		long xLong=Long.parseLong(x,NUMBER_SYSTEM_BINARY);
		long yLong=Long.parseLong(y, NUMBER_SYSTEM_BINARY);
		
		return Long.toBinaryString(xLong+yLong);
	}

}
