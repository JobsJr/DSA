package com.example.bitmanipulation;

/**
 * Check equality of two numbers
 * without using any comparison statement
 * 
 * @author rajeevkr
 *
 */
public class CheckEquality {

	public static void main(String[] args) {
		int a=5,b=-5;
		
		if(checkEquality(a, b)){
			System.out.println("Numbers are equal");
		}else{
			System.out.println("Numbers are not equal");
		}
	}

	private static boolean checkEquality(int a,int b){
		return (a^b)==0? true:false;
	}
}
