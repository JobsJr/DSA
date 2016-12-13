package com.example.arrays;

public class MinDistance {

	public static void main(String[] args) {

		int arr[]={2, 5, 3, 5, 4, 4, 2, 3};
		System.out.println(findMinDist(arr, 3, 2));
	}
	
	private static int findMinDist(int array[],int x,int y){
		int minDistance=0;
		boolean isMinDistanceFound=false;
		
		for(int i=0;i<array.length;i++){
			if(array[i]==x){
				for(int j=0;j<array.length;j++){
					if(array[j]==y){
						minDistance=Math.abs(i-j);
						isMinDistanceFound=true;
						break;
					}
				}
				if(isMinDistanceFound){
					break;
				}
			}
			
		}
		
		return minDistance;
		
	}

}
