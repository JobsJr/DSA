package com.example.algo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AddSum {

	public static void main(String[] args) {
		int [] array={2,7,11,15};
		int target=9;
		System.out.println(Arrays.toString(giveIndices(array, target)));
	}
	
	/**
	 * TC:O(n2)
	 * SC:O(1)
	 * @param array
	 * @param target
	 * @return
	 */
	
	public static int [] giveIndices(int [] array,int target){
		int length=array.length;
		if(length >1){
			for(int i=0;i<length-2;i++){
				for(int j=i+1;j<length-1;j++){
					if(array[i]+array[j]==target){
						int [] returnArray=new int[]{i,j};
						return returnArray;
					}
				}
			}

		}
		return null;
		
	}
	
	
	/**
	* TC:O(n)
	 * SC:O(n)
	 * @param nums
	 * @param target
	 * @return
	 */
	
	public static int[] twoSum(int[] nums, int target) {
	    Map<Integer, Integer> map = new HashMap<>();
	    for (int i = 0; i < nums.length; i++) {
	        map.put(nums[i], i);
	    }
	    for (int i = 0; i < nums.length; i++) {
	        int complement = target - nums[i];
	        if (map.containsKey(complement) && map.get(complement) != i) {
	            return new int[] { i, map.get(complement) };
	        }
	    }
	    throw new IllegalArgumentException("No two sum solution");
	}

}
