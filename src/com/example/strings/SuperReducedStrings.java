package com.example.strings;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class SuperReducedStrings {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		reduce(sc.next());
	}
	
	private static void reduce(String input){
		if(input!=null && input.isEmpty()){
			throw new IllegalArgumentException("Wrong input!");
		}
		
		LinkedHashSet<Character>charSet=new LinkedHashSet<Character>();
		
		for(Character ch:input.toCharArray()){
			System.out.println("Adding: "+ch);
			if(!charSet.add(ch)){
				System.out.println("Removing: "+ch);

				charSet.remove(ch);
			}
		}
		
		if(charSet.isEmpty()){
			System.out.println("Empty String");
		}else{
			String finalString="";
			for(Character ch:charSet){
				finalString+=ch;
			}
			
			System.out.println(finalString);
		}
	}

}
