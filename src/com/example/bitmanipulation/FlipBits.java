package com.example.bitmanipulation;
/**
 * How may operations are required to convert a number 
 * from A to B
 * @author rajeevkr
 *
 */
public class FlipBits {

	public static void main(String[] args) {
		System.out.println("Num of operations required to convert 73 to 21 "+flipBits(73, 21));
	}
	
	private static int flipBits(int a,int b){
		long xOrdNum=a^b;
		int count=0;

		for(int i=1;i<33;i++){ 
			if((xOrdNum &(1<<(i-1)))!=0){
				count++;
			}	
		}
		return count;


	}




}
