package com.example.algo;

public class CamelCase {

	public static void main(String[] args) {
		System.out.println(getWords(""));
		
	}
	
	public static int getWords(String s){
		if(s!=null){
			s=s.trim();
			if(s.length()==0){
				return 0;	
			}
		}else if(s==null){
			return 0;
		}
		
		int numOfCaps=0;
		for(char c:s.toCharArray()){
			if(Character.isUpperCase(c)){
				numOfCaps++;
				
			}
		}
		return numOfCaps+1;
	}

}
