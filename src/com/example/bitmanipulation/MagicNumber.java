package com.example.bitmanipulation;

public class MagicNumber {

	public static void main(String[] args) {
		for(int i=1;i<3;i++){
			System.out.println(i+" th magic number is "+getMagicNumber(i));
		}

	}
	
	
	private static int getMagicNumber(int n){
		int magicNumber=0;
		int pow=1;
		while(n!=0){
			pow=pow*5;
			if((n&1)!=0){
				magicNumber+=pow;
			}
			n>>=1;
		}
		
		return magicNumber;
		
	}


}
