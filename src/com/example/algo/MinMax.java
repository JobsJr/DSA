package com.example.algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 * Given 5 integers,find max & min value that can be obtained,by adding
 * any four of them
 * @author rajeevkr
 *
 */
public class MinMax {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        long a = in.nextLong();
        long b = in.nextLong();
        long c = in.nextLong();
        long d = in.nextLong();
        long e = in.nextLong();
        
        ArrayList<Long>list=new ArrayList<Long>(5);
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);
        
        getMinMax(list);


        
	}
	
	public static void getMinMax(ArrayList<Long>list){
		Long min=0L;
		//TODO:Edge cases
		Long max=0L;
		Collections.sort(list);
		min=list.get(0);
		max=list.get(4);
		
		for(int i=1;i<4;i++){
			min+=list.get(i);
		}
		
		for(int i=3;i>0;i--){
			max+=list.get(i);
		}
		
		System.out.println(min+" "+max);
	}

}
