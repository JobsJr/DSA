package com.example.bitmanipulation;

public class ConvertToBinary {

	public static void main(String[] args) {
		toBin(4);
	}
	
	private static void toBin(int n){
		if(n>=1)
			toBin(n/2);


		System.out.println(n%2+" ");	
	}


}
