package com.example.arrays;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class OddFreq {

	public static void main(String[] args) {
		int ar[] = {2, 3, 5, 4, 5, 2, 4, 3, 5, 2, 4, 4, 2};
		System.out.println(""+findNumUsingHashTable(ar));
	}
	
	/**
	 * Naive
	 * TC:O(n2)
	 * SC:O(1)
	 * @param array
	 * @return
	 */

	private static int findNum(int[] array) {
		int count=1;
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] == array[j] ) {
					count++;
				}	
			}
			
			if(count%2!=0){
				return i;
			}
			count=1;
		}

		return -1;

	}
	/**
	 * 
	 * @param array
	 * @return
	 */
	private static int findNumUsingHashTable(int [] array){
		HashMap<Integer, Integer>freqMap=new LinkedHashMap<Integer, Integer>();
		for(int i=0;i<array.length;i++){
			Integer val=freqMap.get(array[i]);
			if(val!=null){
				freqMap.put(array[i],++val);
			}else{
				freqMap.put(array[i], 1);
			}
		}
		
		//Traverse through map
		for(Integer value:freqMap.keySet()){
			if(freqMap.get(value)%2!=0){
				return value;
			}
			
		}
		
		return -1;
	}

}
