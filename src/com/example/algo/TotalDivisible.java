package com.example.algo;

import java.util.Scanner;

public class TotalDivisible {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
      findTotalDivisible(a, k, n);
	}
        
	
	
	private static void findTotalDivisible(int [] array,int divisor,int len){
		int total=0;
		if(len < 2){
			System.out.println(total);
			return;
		}
		if(len==2){
			if((array[0]+array[1])%divisor==0)
				total++;
		}else{
			for(int i=0;i<=len-2;i++){
				for(int j=i+1;j<=len-1;j++){
					if(((array[i]+array[j])%divisor)==0){
						total++;
					}
				}
			}

		}
		
		  System.out.println(total);
		
	   }
    

}
