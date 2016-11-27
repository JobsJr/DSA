package com.example.search;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class MissingNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1,2,3,4,5
		// 1,2,2,4,5,5,6,7
		
		Integer [] A={1,2,3,4,5};
		Integer [] B={1,2,2,4,5,5,6,7};
		printMissingNumbers(Arrays.asList(A), Arrays.asList(B));


	}
	
	
	private static void printMissingNumbers(List<Integer>A,List<Integer>B){
		HashSet<Integer>missingSet=new HashSet<Integer>();
		if(B.isEmpty()){
			throw new IllegalArgumentException("B can't be empty!");
		}
		
		//Sort the lists
		Collections.sort(A);
		Collections.sort(B);
		
	
		//Comparision only for length of A
		for(int indexA=0,indexB=0;indexA<A.size();){
			//If B[i]==A[i],increment i
			if(indexB<B.size() && indexA<A.size()&&B.get(indexB)==A.get(indexA)){
				indexA++;
				indexB++;;
				continue;

			}
			else{
				if(indexB<B.size()){
					missingSet.add(B.get(indexB));
					indexB++;
					indexA++;
				}
				
			}
		}
		int sizeOfA=A.size();
		int sizeOfB=B.size();
		
		if(sizeOfB > sizeOfA){
			//Put extra elements of B in missing set
			for(int i=sizeOfA;i<sizeOfB;i++){
				missingSet.add(B.get(i));
			}
		}
		System.out.println(missingSet.toString());
		
		
	}

}
