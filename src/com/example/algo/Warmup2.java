package com.example.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Warmup2 {

	public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int k = in.nextInt();
	        int q = in.nextInt();
	        int[] a = new int[n];
	        for(int a_i=0; a_i < n; a_i++){
	            a[a_i] = in.nextInt();
	        }
	        ArrayList<Integer> inputList=(ArrayList) Arrays.asList(a);
			Collections.rotate(inputList, k);


	        for(int a0 = 0; a0 < q; a0++){
	            int m = in.nextInt();
		        printNth(inputList, k, m);
	        }
	       
	}

	public static void printNth(List<Integer>input,int times,int query ){
		if(query<0 || query >=input.size()){
			System.out.println("Fuck you!!!");
			return;
		}
		
		System.out.println(input.get(query));
	}
}