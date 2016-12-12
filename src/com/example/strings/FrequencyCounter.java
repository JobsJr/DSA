package com.example.strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

public class FrequencyCounter {

	public static void main(String[] args) {
		getFrequency("occurrence");
	}

	
	
	/**
	 * Naive approach
	 * @param input
	 */
	private static void getFrequency(String input) {
		
		List<Character>characterList=new ArrayList<Character>();
		LinkedHashMap<Character, Integer>frequencyMap=new LinkedHashMap<Character, Integer>();
		
		for(Character ch:input.toCharArray()){
			characterList.add(ch);
		}
		
		for(Character ch:characterList){
			frequencyMap.put(ch, Collections.frequency(characterList, ch));
		}
		
		 print(frequencyMap);
		 
	}
	
	private static void print(LinkedHashMap<Character, Integer>map){
		for(Character ch:map.keySet()){
			int count=map.get(ch);
			for(int i=1;i<=count;i++){
				System.out.print(ch);
			}
		}
	}

}
