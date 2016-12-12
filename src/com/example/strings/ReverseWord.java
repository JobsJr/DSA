package com.example.strings;

import java.util.Arrays;

public class ReverseWord {

	public static void main(String[] args) {
		String input="@ the boy ran";
		System.out.println(Arrays.toString(reverseWords(input)));
		
	}
	
	private static void reverse(char [] input,int start,int end){
		while(start < end){
			input[start]=(char) (input[start]^input[end]);
			input[end]=(char) (input[start]^input[end]);
			input[start]=(char) (input[start]^input[end]);
			start++;
			end--;
		}
	}
	
	private static char [] reverseWords(String input){
		char [] inputArray=input.toCharArray();
		int start=-1;
		
		for(int i=0;i<inputArray.length;){
			if(inputArray[i]!=' '){
				start=i;
				while(i<inputArray.length&& inputArray[i]!=' '){
					i++;
				}
				i--;
				reverse(inputArray, start, i);
			}
			
			i++;
		}
		return inputArray;
		
	}

}
