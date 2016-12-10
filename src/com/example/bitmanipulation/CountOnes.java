package com.example.bitmanipulation;

/**
 * Count the number of bits set in an integer(Hamming weight)
 * @author rajeevkr
 *
 */
public class CountOnes {
	private static final int NUM_OF_BITS=64;
	
	public static void main(String[] args) {
		int i=15;
		System.out.println("Num of bits set in "+i+"=> "+countOne(i));
	}
	
	private static int countOne(int num){
		int count=0;
		for(int i=1;i<=NUM_OF_BITS;i++){
			if(hasOne(num, i)){
				count++;
			}
		}
		return count;
	}

	/**
	 * To see if a bit is set @ ith position
	 * 1.Left shift 1 to i position
	 * 2.AND it with the number
	 * 	 2.1 if bit i in number is set,it is set
	 * 	 2.2 else 0 	
	 * @param num
	 * @param position
	 * @return
	 */
	private static boolean hasOne(int num,int position){
		return (num &(1<<position))!=0;
	}
}
