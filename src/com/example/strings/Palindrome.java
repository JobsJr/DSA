package com.example.strings;

public class Palindrome {

	public static void main(String[] args) {
		boolean isPalinfrome=isPalindrome("A man, a plan, a canal, Panama!");
		System.out.println("Is it a palindrome "+isPalinfrome);
	}

	public static boolean isPalindrome(String input){
		//TODO: Validate
		int i=0;
		int j=input.length()-1;
		char a,b;
		
		while(i < j){
		a=Character.toLowerCase(input.charAt(i));
		b=Character.toLowerCase(input.charAt(j));

		if(!(Character.isAlphabetic(a))){
		i++;
		}


		if(!(Character.isAlphabetic(b))){
		j--;
		}

		if(Character.isAlphabetic(a) && Character.isAlphabetic(b) && a==b){
		i++;
		j--;
		}else if(Character.isAlphabetic(a) && Character.isAlphabetic(b)&&a !=b){
			return false;
		}

		}
		return true;
	}
}
